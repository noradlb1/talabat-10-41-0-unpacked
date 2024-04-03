package com.google.android.play.core.integrity;

final class f extends IntegrityTokenResponse {

    /* renamed from: a  reason: collision with root package name */
    private final String f44543a;

    public /* synthetic */ f(String str, e eVar) {
        this.f44543a = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof IntegrityTokenResponse) {
            return this.f44543a.equals(((IntegrityTokenResponse) obj).token());
        }
        return false;
    }

    public final int hashCode() {
        return this.f44543a.hashCode() ^ 1000003;
    }

    public final String toString() {
        String str = this.f44543a;
        return "IntegrityTokenResponse{token=" + str + "}";
    }

    public final String token() {
        return this.f44543a;
    }
}
