package com.huawei.hms.dtm.core;

public class Ac extends Dc<Object> {
    public Ac(Object obj) {
        super(obj);
    }

    public boolean b() {
        return value() != null;
    }

    public Double c() {
        throw new V("object to double");
    }
}
