package com.sdau.gksystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@SpringBootApplication
@MapperScan("com.sdau.gksystem.mapper")
public class GksystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(GksystemApplication.class, args);
    }


    @Component
    public class ErrorPageConfig implements ErrorPageRegistrar {
        @Override
        public void registerErrorPages(ErrorPageRegistry registry) {
            ErrorPage error400Page=new ErrorPage(HttpStatus.BAD_REQUEST,"/index.html" );
            ErrorPage error401Page=new ErrorPage(HttpStatus.UNAUTHORIZED,"/index.html");
            ErrorPage error404Page=new ErrorPage(HttpStatus.NOT_FOUND, "/index.html");
            ErrorPage error500Page=new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/index.html");
            registry.addErrorPages(error400Page,error401Page,error404Page, error500Page);
        }

    }


}
