package com.talabat.splash.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/talabat/splash/domain/model/SplashRedirectionWrapper;", "", "initiateAppInfo", "", "flowType", "", "(ZI)V", "getFlowType", "()I", "setFlowType", "(I)V", "getInitiateAppInfo", "()Z", "setInitiateAppInfo", "(Z)V", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SplashRedirectionWrapper {
    private int flowType;
    private boolean initiateAppInfo;

    public SplashRedirectionWrapper() {
        this(false, 0, 3, (DefaultConstructorMarker) null);
    }

    public SplashRedirectionWrapper(boolean z11, int i11) {
        this.initiateAppInfo = z11;
        this.flowType = i11;
    }

    public static /* synthetic */ SplashRedirectionWrapper copy$default(SplashRedirectionWrapper splashRedirectionWrapper, boolean z11, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            z11 = splashRedirectionWrapper.initiateAppInfo;
        }
        if ((i12 & 2) != 0) {
            i11 = splashRedirectionWrapper.flowType;
        }
        return splashRedirectionWrapper.copy(z11, i11);
    }

    public final boolean component1() {
        return this.initiateAppInfo;
    }

    public final int component2() {
        return this.flowType;
    }

    @NotNull
    public final SplashRedirectionWrapper copy(boolean z11, int i11) {
        return new SplashRedirectionWrapper(z11, i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SplashRedirectionWrapper)) {
            return false;
        }
        SplashRedirectionWrapper splashRedirectionWrapper = (SplashRedirectionWrapper) obj;
        return this.initiateAppInfo == splashRedirectionWrapper.initiateAppInfo && this.flowType == splashRedirectionWrapper.flowType;
    }

    public final int getFlowType() {
        return this.flowType;
    }

    public final boolean getInitiateAppInfo() {
        return this.initiateAppInfo;
    }

    public int hashCode() {
        boolean z11 = this.initiateAppInfo;
        if (z11) {
            z11 = true;
        }
        return ((z11 ? 1 : 0) * true) + this.flowType;
    }

    public final void setFlowType(int i11) {
        this.flowType = i11;
    }

    public final void setInitiateAppInfo(boolean z11) {
        this.initiateAppInfo = z11;
    }

    @NotNull
    public String toString() {
        boolean z11 = this.initiateAppInfo;
        int i11 = this.flowType;
        return "SplashRedirectionWrapper(initiateAppInfo=" + z11 + ", flowType=" + i11 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SplashRedirectionWrapper(boolean z11, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? false : z11, (i12 & 2) != 0 ? SplashDataUtils.INSTANCE.getNORMAL_FLOW() : i11);
    }
}
