package com.example.grpcClient.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class ResponseDTO {
    String requester;
    String info;
    String time;
}
