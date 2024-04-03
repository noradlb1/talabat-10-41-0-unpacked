package com.google.android.play.core.integrity;

final class d extends w {

    /* renamed from: a  reason: collision with root package name */
    private String f44542a;

    public final w a(String str) {
        this.f44542a = str;
        return this;
    }

    public final IntegrityTokenResponse b() {
        String str = this.f44542a;
        if (str != null) {
            return new f(str, (e) null);
        }
        throw new IllegalStateException("Missing required properties: token");
    }
}
