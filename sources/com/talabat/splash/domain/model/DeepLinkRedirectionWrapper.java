package com.talabat.splash.domain.model;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/talabat/splash/domain/model/DeepLinkRedirectionWrapper;", "", "()V", "flowType", "", "(I)V", "getFlowType", "()I", "setFlowType", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DeepLinkRedirectionWrapper {
    private int flowType;

    public DeepLinkRedirectionWrapper(int i11) {
        this.flowType = i11;
    }

    public final int getFlowType() {
        return this.flowType;
    }

    public final void setFlowType(int i11) {
        this.flowType = i11;
    }

    public DeepLinkRedirectionWrapper() {
        this(SplashDataUtils.INSTANCE.getDEEP_LINK_FLOW());
    }
}
