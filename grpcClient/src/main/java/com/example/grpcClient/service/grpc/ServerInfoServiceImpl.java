package com.example.grpcClient.service.grpc;

import com.example.ServerInfoGrpc;
import com.example.ServerInfoOuterClass;
import com.example.grpcClient.dto.ResponseDTO;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class ServerInfoServiceImpl {

    @GrpcClient("server1")
    private ServerInfoGrpc.ServerInfoBlockingStub serverInfoStub;

    public ResponseDTO sendServerInfo(final String requester) {

        // Grpc Server Call
        ServerInfoOuterClass.ServerInfoMsg.Response response = this.serverInfoStub.serverInfoTask(ServerInfoOuterClass.ServerInfoMsg.Request.newBuilder().setRequester(requester).build());

        ResponseDTO responseDTO = ResponseDTO.builder()
                .requester(response.getRequester())
                .info(response.getInfo())
                .time(response.getTime())
                .build();

        return responseDTO;
    }
}
