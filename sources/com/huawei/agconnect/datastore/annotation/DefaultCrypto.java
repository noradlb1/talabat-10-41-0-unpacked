package com.huawei.agconnect.datastore.annotation;

public class DefaultCrypto implements ICrypto {
    public String decrypt(String str) {
        return str;
    }

    public String encrypt(String str) {
        return str;
    }
}
