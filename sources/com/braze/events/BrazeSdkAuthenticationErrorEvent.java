package com.braze.events;

import bo.app.x4;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002HÂ\u0003J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u0002HÆ\u0001J\t\u0010\t\u001a\u00020\bHÖ\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0012\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000eR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/braze/events/BrazeSdkAuthenticationErrorEvent;", "", "Lbo/app/x4;", "component1", "", "toString", "sdkAuthError", "copy", "", "hashCode", "other", "", "equals", "getErrorReason", "()Ljava/lang/String;", "errorReason", "getErrorCode", "()I", "errorCode", "", "getRequestInitiationTime", "()Ljava/lang/Long;", "requestInitiationTime", "getSignature", "signature", "getUserId", "userId", "<init>", "(Lbo/app/x4;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class BrazeSdkAuthenticationErrorEvent {
    private final x4 sdkAuthError;

    public BrazeSdkAuthenticationErrorEvent(x4 x4Var) {
        Intrinsics.checkNotNullParameter(x4Var, "sdkAuthError");
        this.sdkAuthError = x4Var;
    }

    private final x4 component1() {
        return this.sdkAuthError;
    }

    public static /* synthetic */ BrazeSdkAuthenticationErrorEvent copy$default(BrazeSdkAuthenticationErrorEvent brazeSdkAuthenticationErrorEvent, x4 x4Var, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            x4Var = brazeSdkAuthenticationErrorEvent.sdkAuthError;
        }
        return brazeSdkAuthenticationErrorEvent.copy(x4Var);
    }

    public final BrazeSdkAuthenticationErrorEvent copy(x4 x4Var) {
        Intrinsics.checkNotNullParameter(x4Var, "sdkAuthError");
        return new BrazeSdkAuthenticationErrorEvent(x4Var);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BrazeSdkAuthenticationErrorEvent) && Intrinsics.areEqual((Object) this.sdkAuthError, (Object) ((BrazeSdkAuthenticationErrorEvent) obj).sdkAuthError);
    }

    public final int getErrorCode() {
        return this.sdkAuthError.c();
    }

    public final String getErrorReason() {
        return this.sdkAuthError.d();
    }

    public final Long getRequestInitiationTime() {
        return this.sdkAuthError.b().j();
    }

    public final String getSignature() {
        return this.sdkAuthError.b().k();
    }

    public final String getUserId() {
        return this.sdkAuthError.b().a();
    }

    public int hashCode() {
        return this.sdkAuthError.hashCode();
    }

    public String toString() {
        return this.sdkAuthError.toString();
    }
}
