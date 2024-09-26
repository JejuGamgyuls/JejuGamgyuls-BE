package com.gamgyuls.gamgyuls.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import javax.xml.stream.events.StartDocument;

@Data
@AllArgsConstructor(staticName="set")
public class ResponseDto<D> {
    private boolean result; // true/false
    private String message; // 성공 및 실패 여부
    private D data; // token, exprTime

    public static <D> ResponseDto<D> setSuccess(String message, D data) {

        return ResponseDto.set(true, message, data);
    }

    public static <D> ResponseDto<D> setFailed(String message) {
        return ResponseDto.set(false, message, null);
    }

}
// 응답 위한 Dto
