package com.andreandrade.sample.springbootredis.controller.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class RegisterUserRequest {

    private String username;
}
