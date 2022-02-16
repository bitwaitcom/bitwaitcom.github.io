package com.bitwait.bitrade.annotation;


import java.lang.annotation.*;

import com.bitwait.bitrade.constant.AdminModule;

@Target({ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface AccessLog {
    String operation();
    AdminModule module();
}

