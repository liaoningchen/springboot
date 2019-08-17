package com.springboot.log.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.PrintWriter;
import java.io.StringWriter;


@RestController
public class Test extends BaseController {

    @GetMapping("/test")
    public String test(){
        try {
            int q = 0/0;
        }catch (Exception e){
            logger.error("错误",e);
        }
        logger.info("测试");
        return "hello logback";
    }

    public static String getTrace(Throwable t) {
        StringWriter stringWriter= new StringWriter();
        PrintWriter writer= new PrintWriter(stringWriter);
        t.printStackTrace(writer);
        StringBuffer buffer= stringWriter.getBuffer();
        return buffer.toString();
    }

}
