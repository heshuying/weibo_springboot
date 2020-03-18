package com.eyesfree.weibo.beans;

import lombok.Data;

@Data
public class RegistReqBean {
    String userName;
    String phoneNum;
    String password;
    String captcha;
}
