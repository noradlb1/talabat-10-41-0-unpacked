package com.huawei.hms.dtm.core;

/* renamed from: com.huawei.hms.dtm.core.ad  reason: case insensitive filesystem */
public final class C0346ad extends Sc<String> {
    public C0346ad(String str) {
        super(str);
    }

    public C0435sc<?> a(X x11) {
        return new Cc((String) this.f48409a);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0346ad)) {
            return false;
        }
        return ((String) ((C0346ad) obj).f48409a).equals(this.f48409a);
    }

    public /* synthetic */ Object getValue() {
        return super.getValue();
    }

    public int hashCode() {
        return ((String) this.f48409a).hashCode();
    }
}
