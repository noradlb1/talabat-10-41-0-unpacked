package com.huawei.hms.common.internal;

public class ResolveClientBean {

    /* renamed from: a  reason: collision with root package name */
    private final int f48186a;

    /* renamed from: b  reason: collision with root package name */
    private final AnyClient f48187b;

    /* renamed from: c  reason: collision with root package name */
    private int f48188c;

    public ResolveClientBean(AnyClient anyClient, int i11) {
        this.f48187b = anyClient;
        this.f48186a = Objects.hashCode(anyClient);
        this.f48188c = i11;
    }

    public void clientReconnect() {
        this.f48187b.connect(this.f48188c, true);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ResolveClientBean)) {
            return false;
        }
        return this.f48187b.equals(((ResolveClientBean) obj).f48187b);
    }

    public AnyClient getClient() {
        return this.f48187b;
    }

    public int hashCode() {
        return this.f48186a;
    }
}
