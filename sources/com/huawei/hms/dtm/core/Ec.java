package com.huawei.hms.dtm.core;

public class Ec implements C0435sc<String> {

    /* renamed from: a  reason: collision with root package name */
    public static final Ec f48288a = new Ec();

    private Ec() {
    }

    public String a() {
        throw new V("void to json");
    }

    public boolean b() {
        throw new V("void not empty");
    }

    public Double c() {
        throw new V("void to double");
    }

    public Object d() {
        throw new V("void to object");
    }

    public boolean equals(Object obj) {
        return obj == this || (obj instanceof Ec);
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "";
    }

    public String value() {
        return "";
    }
}
