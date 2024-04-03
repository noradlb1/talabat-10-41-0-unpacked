package com.huawei.agconnect.credential.obs;

import com.huawei.agconnect.https.annotation.Result;

public class z {
    @Result("code")
    private int code;
    @Result("msg")
    private String msg;

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(int i11) {
        this.code = i11;
    }

    public void setMsg(String str) {
        this.msg = str;
    }
}
