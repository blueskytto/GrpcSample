package com.example;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.52.0)",
    comments = "Source: serverInfo.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ServerInfoGrpc {

  private ServerInfoGrpc() {}

  public static final String SERVICE_NAME = "com.example.ServerInfo";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.ServerInfoOuterClass.ServerInfoMsg.Request,
      com.example.ServerInfoOuterClass.ServerInfoMsg.Response> getServerInfoTaskMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ServerInfoTask",
      requestType = com.example.ServerInfoOuterClass.ServerInfoMsg.Request.class,
      responseType = com.example.ServerInfoOuterClass.ServerInfoMsg.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.ServerInfoOuterClass.ServerInfoMsg.Request,
      com.example.ServerInfoOuterClass.ServerInfoMsg.Response> getServerInfoTaskMethod() {
    io.grpc.MethodDescriptor<com.example.ServerInfoOuterClass.ServerInfoMsg.Request, com.example.ServerInfoOuterClass.ServerInfoMsg.Response> getServerInfoTaskMethod;
    if ((getServerInfoTaskMethod = ServerInfoGrpc.getServerInfoTaskMethod) == null) {
      synchronized (ServerInfoGrpc.class) {
        if ((getServerInfoTaskMethod = ServerInfoGrpc.getServerInfoTaskMethod) == null) {
          ServerInfoGrpc.getServerInfoTaskMethod = getServerInfoTaskMethod =
              io.grpc.MethodDescriptor.<com.example.ServerInfoOuterClass.ServerInfoMsg.Request, com.example.ServerInfoOuterClass.ServerInfoMsg.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ServerInfoTask"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.ServerInfoOuterClass.ServerInfoMsg.Request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.ServerInfoOuterClass.ServerInfoMsg.Response.getDefaultInstance()))
              .setSchemaDescriptor(new ServerInfoMethodDescriptorSupplier("ServerInfoTask"))
              .build();
        }
      }
    }
    return getServerInfoTaskMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ServerInfoStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServerInfoStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServerInfoStub>() {
        @java.lang.Override
        public ServerInfoStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServerInfoStub(channel, callOptions);
        }
      };
    return ServerInfoStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ServerInfoBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServerInfoBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServerInfoBlockingStub>() {
        @java.lang.Override
        public ServerInfoBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServerInfoBlockingStub(channel, callOptions);
        }
      };
    return ServerInfoBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ServerInfoFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServerInfoFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServerInfoFutureStub>() {
        @java.lang.Override
        public ServerInfoFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServerInfoFutureStub(channel, callOptions);
        }
      };
    return ServerInfoFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ServerInfoImplBase implements io.grpc.BindableService {

    /**
     */
    public void serverInfoTask(com.example.ServerInfoOuterClass.ServerInfoMsg.Request request,
        io.grpc.stub.StreamObserver<com.example.ServerInfoOuterClass.ServerInfoMsg.Response> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getServerInfoTaskMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getServerInfoTaskMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.ServerInfoOuterClass.ServerInfoMsg.Request,
                com.example.ServerInfoOuterClass.ServerInfoMsg.Response>(
                  this, METHODID_SERVER_INFO_TASK)))
          .build();
    }
  }

  /**
   */
  public static final class ServerInfoStub extends io.grpc.stub.AbstractAsyncStub<ServerInfoStub> {
    private ServerInfoStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServerInfoStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServerInfoStub(channel, callOptions);
    }

    /**
     */
    public void serverInfoTask(com.example.ServerInfoOuterClass.ServerInfoMsg.Request request,
        io.grpc.stub.StreamObserver<com.example.ServerInfoOuterClass.ServerInfoMsg.Response> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getServerInfoTaskMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ServerInfoBlockingStub extends io.grpc.stub.AbstractBlockingStub<ServerInfoBlockingStub> {
    private ServerInfoBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServerInfoBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServerInfoBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.ServerInfoOuterClass.ServerInfoMsg.Response serverInfoTask(com.example.ServerInfoOuterClass.ServerInfoMsg.Request request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getServerInfoTaskMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ServerInfoFutureStub extends io.grpc.stub.AbstractFutureStub<ServerInfoFutureStub> {
    private ServerInfoFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServerInfoFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServerInfoFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.ServerInfoOuterClass.ServerInfoMsg.Response> serverInfoTask(
        com.example.ServerInfoOuterClass.ServerInfoMsg.Request request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getServerInfoTaskMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SERVER_INFO_TASK = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ServerInfoImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ServerInfoImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SERVER_INFO_TASK:
          serviceImpl.serverInfoTask((com.example.ServerInfoOuterClass.ServerInfoMsg.Request) request,
              (io.grpc.stub.StreamObserver<com.example.ServerInfoOuterClass.ServerInfoMsg.Response>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ServerInfoBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ServerInfoBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.ServerInfoOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ServerInfo");
    }
  }

  private static final class ServerInfoFileDescriptorSupplier
      extends ServerInfoBaseDescriptorSupplier {
    ServerInfoFileDescriptorSupplier() {}
  }

  private static final class ServerInfoMethodDescriptorSupplier
      extends ServerInfoBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ServerInfoMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ServerInfoGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ServerInfoFileDescriptorSupplier())
              .addMethod(getServerInfoTaskMethod())
              .build();
        }
      }
    }
    return result;
  }
}
