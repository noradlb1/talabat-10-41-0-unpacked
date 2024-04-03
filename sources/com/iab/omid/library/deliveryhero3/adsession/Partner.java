package com.iab.omid.library.deliveryhero3.adsession;

import com.iab.omid.library.deliveryhero3.utils.g;

public class Partner {

    /* renamed from: name  reason: collision with root package name */
    private final String f44916name;
    private final String version;

    private Partner(String str, String str2) {
        this.f44916name = str;
        this.version = str2;
    }

    public static Partner createPartner(String str, String str2) {
        g.a(str, "Name is null or empty");
        g.a(str2, "Version is null or empty");
        return new Partner(str, str2);
    }

    public String getName() {
        return this.f44916name;
    }

    public String getVersion() {
        return this.version;
    }
}
