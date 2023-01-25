package com.example.grpcClient.controller;

import com.example.grpcClient.dto.ResponseDTO;
import com.example.grpcClient.service.grpc.ServerInfoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ServerInfoController {

    private final ServerInfoServiceImpl serverInfoService;

    @GetMapping("/")
    public ResponseEntity<?> serverInfo() {
        ResponseDTO responseDTO = serverInfoService.sendServerInfo("Client1");

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
