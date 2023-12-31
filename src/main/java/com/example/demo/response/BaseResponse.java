package com.example.demo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
    public class BaseResponse implements Serializable {

        private static final long serialVersionUID = 1L;

        private int responseCode;
        private String message;
        private Object data;

}

