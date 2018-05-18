package com.fine.distribution.config;


import com.fine.distribution.common.JsonBackEntity;
import com.fine.distribution.utlis.HospitalException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
@ResponseBody
public class ErrorExceptionControl {

        @ExceptionHandler(HospitalException.class)
        public JsonBackEntity handleException(Exception e) {
            e.printStackTrace();
            JsonBackEntity jsonBackEntity=new JsonBackEntity();
            jsonBackEntity.setCode(Integer.parseInt(e.getMessage()));
            jsonBackEntity.setResult("自定义code"+e.getMessage());
            return jsonBackEntity;
        }



}
