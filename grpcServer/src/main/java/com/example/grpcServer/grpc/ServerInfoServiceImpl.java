package com.example.grpcServer.grpc;

import com.example.ServerInfoGrpc;
import com.example.ServerInfoOuterClass;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@GrpcService
@Slf4j
public class ServerInfoServiceImpl extends ServerInfoGrpc.ServerInfoImplBase {

    /**
     *  GRPC로 요청오면 서버 Host명과 현재 서버시간을 돌려줌
     * @param request 1) requester : 요청자
     * @param responseObserver 1) hostName : 호스트명, 2) timeToString : 서버시간
     */
    @Override
    public void serverInfoTask(ServerInfoOuterClass.ServerInfoMsg.Request request, StreamObserver<ServerInfoOuterClass.ServerInfoMsg.Response> responseObserver) {

        Timestamp time = new Timestamp(System.currentTimeMillis());

        String timeToString = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(time);
        String hostName = null;

        try {
            hostName = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }


        log.info("서비스 요청 : ", request.getRequester());

        ServerInfoOuterClass.ServerInfoMsg.Response response = ServerInfoOuterClass.ServerInfoMsg.Response.newBuilder()
                .setRequester(request.getRequester())
                .setInfo(hostName)
                .setTime(timeToString)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
