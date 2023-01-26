# Grpc Sample

> Rest를 대체하는 Grpc 통신 모듈 사용 JAVA 예제 (Gradle, SpringBoot)
>> Client App 에서 요청 -> Server App 에서 응답

-----

* **grpcProto 모듈 (SpringBoot)**
    * Grpc 요청/응답 라이브러리 생성
* **grpcClient 모듈 (SpringBoot)**
    * Grpc 요청쪽 SpringBoot App
* **grpcServer 모듈 (SpringBoot)**
    * Grpc 응답쪽 SpringBoot App

-----

## GrpcProto

1. build.gradle 작성 <br/><br/>
    * plugins에 protobuf 추가

   ```groovy
    plugins {
        id 'com.google.protobuf' version '0.9.1'
    }
   ```

    * dependencies 라이브러리 추가
   ```groovy
    dependencies {
        runtimeOnly 'io.grpc:grpc-netty-shaded:1.52.0' // protocol buffer를 java 파일로 컴파일하는데 사용되는 의존성
        implementation 'io.grpc:grpc-protobuf:1.52.0' // protobuf-java로 만들어지는 서버 입장의 파일에서 필요한 메서드 등을 포함하고 있으는 의존성
        implementation 'io.grpc:grpc-stub:1.52.0' // protobuf-java로 만들어지는 클라이언트 입장의 파일에서 필요한 메서드 등을 포함하고 있는 의존성
        compileOnly 'org.apache.tomcat:annotations-api:6.0.53' // necessary for Java 9+ , grpc를 사용할 때 java 9 이상에서 사용하기 위해서 필요한 의존성
    }
   ```

    * protobuf 작성
   ```groovy
    protobuf {
        protoc {
            artifact = "com.google.protobuf:protoc:3.21.7"
        }
        plugins {
            grpc {
                artifact = 'io.grpc:protoc-gen-grpc-java:1.52.0'
            }
        }
        generateProtoTasks {
            all()*.plugins {
                grpc {}
            }
        }
    }
   ```
    * sourceSetes 작성

   ```groovy
    sourceSets {
        main {
            java {
                srcDirs 'build/generated/source/proto/main/grpc'
                srcDirs 'build/generated/source/proto/main/java'
            }
        }
    }
   ```

2. grpcProto/src/main/proto/serverInfo.proto 파일 작성

   > ```protobuf
   >  syntax = "proto3";
   >  
   >  package com.example;
   >  
   >  service ServerInfo {
   >    rpc ServerInfoTask(ServerInfoMsg.Request) returns (ServerInfoMsg.Response);
   >  }
   >  
   >  message ServerInfoMsg {
   >    message Request {
   >      string requester = 1;
   >    }
   >  
   >    message Response {
   >      string requester = 1;
   >      string info = 2;
   >      string time = 3;
   >    }
   >  }
   > ```
   > * 함수 serverInfo.serverInfoTask 작성 (service)
   > * Request, Response 객체 생성 (message)

3. 빌드
    ```shell
    gradle build
    ```

## GrpcServer

1. build.gradle 작성<br/><br/>

    * dependencies 라이브러리 추가
   > * 프로젝트에 /libs 폴더를 생성 후, grpcProto에서 빌드되어 나온 라이브러리를 복사
   > * Server+Client 용 grpc 라이브러리를 추가 <br/><br/>
   > * 참고 :
   >> * Server 용 : net.devh:grpc-server-spring-boot-starter:2.14.0.RELEASE
   >> * Client 용 : net.devh:grpc-client-spring-boot-starter:2.14.0.RELEASE
   >> * Server + Client 용 : net.devh:grpc-spring-boot-starter:2.14.0.RELEASE
   > ```groovy
   > dependencies {
   >     implementation fileTree(dir: 'libs', include: ['*.jar'])
   >     implementation 'net.devh:grpc-spring-boot-starter:2.14.0.RELEASE'
   > }
   > ```
2. application.yml 추가
   > * 9090 포트로 Grpc 모듈부분 실행
   > ```yaml
   > grpc:
   >  server:
   >    port: 9090
   > ```
3. com/example/grpcServer/grpc/ServerInfoServiceImpl.java GRPC 서비스파일 작성
    * ServerInfoOuterClass를 이용하여 response 객체 반환

## GrpcClient

1. build.gradle 작성<br/><br/>

    * dependencies 라이브러리 추가
   > * 프로젝트에 /libs 폴더를 생성 후, grpcProto에서 빌드되어 나온 라이브러리를 복사
   > * Client 용 grpc 라이브러리를 추가
   > ```groovy
   > dependencies {
   >     implementation fileTree(dir: 'libs', include: ['*.jar'])
   >     implementation 'net.devh:grpc-client-spring-boot-starter:2.14.0.RELEASE'
   > }
   > ```

2. application.yml 수정
   > * 통신할 Grpc Server 정보 입력
   > ```yaml
   > grpc:
   >  client:
   >    server1:
   >      address: 'static://localhost:9090'
   >      negotiation-type: plaintext
   > ```

3. com/example/grpcClient/service/grpc/ServerInfoServiceImpl.java GRPC 서비스파일 작성

   > ```java
   > @Service
   > public class ServerInfoServiceImpl {
   > 
   >      @GrpcClient("server1")
   >      private ServerInfoGrpc.ServerInfoBlockingStub serverInfoStub;
   > 
   >      public ResponseDTO sendServerInfo(final String requester) {
   > 
   >          // Grpc Server Call
   >          ServerInfoOuterClass.ServerInfoMsg.Response response = 
   >          this.serverInfoStub.serverInfoTask(ServerInfoOuterClass.ServerInfoMsg.Request.newBuilder().setRequester(requester).build());
   > 
   >          ResponseDTO responseDTO = ResponseDTO.builder()
   >                  .requester(response.getRequester())
   >                  .info(response.getInfo())
   >                  .time(response.getTime())
   >                  .build();
   > 
   >          return responseDTO;
   >      }
   > }
   > ```
   > * @grpcClient : Springboot의 application.yml 에 설정한 'server1' 에 해당되는 grpc 서버 App으로 매핑
   > * proto에서 만든 (service 객체명 또는 Message + 정의되어있는 명칭)된 자동생성 클래스들을 선언
   > * 자동생성된 객체들을 이용하여 grpc 통신하고 response 받을 객체 생성