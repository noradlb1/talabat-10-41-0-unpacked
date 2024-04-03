package com.braze.events;

import bo.app.c2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001:\u0001\"B\u001b\u0012\n\u0010\u0007\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b \u0010!J\r\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÂ\u0003J\t\u0010\u0006\u001a\u00020\u0005HÂ\u0003J!\u0010\t\u001a\u00020\u00002\f\b\u0002\u0010\u0007\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000b\u001a\u00020\nHÖ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0018\u0010\u0007\u001a\u00060\u0002j\u0002`\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0011R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001c\u001a\u00020\u001b8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/braze/events/BrazeNetworkFailureEvent;", "", "Ljava/lang/Exception;", "Lkotlin/Exception;", "component1", "Lbo/app/c2;", "component2", "originalException", "brazeRequest", "copy", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/Exception;", "networkExceptionMessage", "Ljava/lang/String;", "getNetworkExceptionMessage", "()Ljava/lang/String;", "", "requestInitiationTime", "Ljava/lang/Long;", "getRequestInitiationTime", "()Ljava/lang/Long;", "Lcom/braze/events/BrazeNetworkFailureEvent$RequestType;", "requestType", "Lcom/braze/events/BrazeNetworkFailureEvent$RequestType;", "getRequestType", "()Lcom/braze/events/BrazeNetworkFailureEvent$RequestType;", "<init>", "(Ljava/lang/Exception;Lbo/app/c2;)V", "RequestType", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class BrazeNetworkFailureEvent {
    private final c2 brazeRequest;
    private final String networkExceptionMessage;
    private final Exception originalException;
    private final Long requestInitiationTime;
    private final RequestType requestType;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/braze/events/BrazeNetworkFailureEvent$RequestType;", "", "(Ljava/lang/String;I)V", "CONTENT_CARDS_SYNC", "NEWS_FEED_SYNC", "OTHER", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum RequestType {
        CONTENT_CARDS_SYNC,
        NEWS_FEED_SYNC,
        OTHER
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0034, code lost:
        if (r2.x() == true) goto L_0x0038;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public BrazeNetworkFailureEvent(java.lang.Exception r2, bo.app.c2 r3) {
        /*
            r1 = this;
            java.lang.String r0 = "originalException"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "brazeRequest"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r1.<init>()
            r1.originalException = r2
            r1.brazeRequest = r3
            java.lang.String r2 = r2.getMessage()
            r1.networkExceptionMessage = r2
            java.lang.Long r2 = r3.j()
            r1.requestInitiationTime = r2
            boolean r2 = r3 instanceof bo.app.b0
            if (r2 == 0) goto L_0x0024
            com.braze.events.BrazeNetworkFailureEvent$RequestType r2 = com.braze.events.BrazeNetworkFailureEvent.RequestType.CONTENT_CARDS_SYNC
            goto L_0x0042
        L_0x0024:
            boolean r2 = r3 instanceof bo.app.i0
            if (r2 == 0) goto L_0x0040
            bo.app.a4 r2 = r3.c()
            if (r2 != 0) goto L_0x002f
            goto L_0x0037
        L_0x002f:
            boolean r2 = r2.x()
            r3 = 1
            if (r2 != r3) goto L_0x0037
            goto L_0x0038
        L_0x0037:
            r3 = 0
        L_0x0038:
            if (r3 == 0) goto L_0x003d
            com.braze.events.BrazeNetworkFailureEvent$RequestType r2 = com.braze.events.BrazeNetworkFailureEvent.RequestType.NEWS_FEED_SYNC
            goto L_0x0042
        L_0x003d:
            com.braze.events.BrazeNetworkFailureEvent$RequestType r2 = com.braze.events.BrazeNetworkFailureEvent.RequestType.OTHER
            goto L_0x0042
        L_0x0040:
            com.braze.events.BrazeNetworkFailureEvent$RequestType r2 = com.braze.events.BrazeNetworkFailureEvent.RequestType.OTHER
        L_0x0042:
            r1.requestType = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braze.events.BrazeNetworkFailureEvent.<init>(java.lang.Exception, bo.app.c2):void");
    }

    private final Exception component1() {
        return this.originalException;
    }

    private final c2 component2() {
        return this.brazeRequest;
    }

    public static /* synthetic */ BrazeNetworkFailureEvent copy$default(BrazeNetworkFailureEvent brazeNetworkFailureEvent, Exception exc, c2 c2Var, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            exc = brazeNetworkFailureEvent.originalException;
        }
        if ((i11 & 2) != 0) {
            c2Var = brazeNetworkFailureEvent.brazeRequest;
        }
        return brazeNetworkFailureEvent.copy(exc, c2Var);
    }

    public final BrazeNetworkFailureEvent copy(Exception exc, c2 c2Var) {
        Intrinsics.checkNotNullParameter(exc, "originalException");
        Intrinsics.checkNotNullParameter(c2Var, "brazeRequest");
        return new BrazeNetworkFailureEvent(exc, c2Var);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BrazeNetworkFailureEvent)) {
            return false;
        }
        BrazeNetworkFailureEvent brazeNetworkFailureEvent = (BrazeNetworkFailureEvent) obj;
        return Intrinsics.areEqual((Object) this.originalException, (Object) brazeNetworkFailureEvent.originalException) && Intrinsics.areEqual((Object) this.brazeRequest, (Object) brazeNetworkFailureEvent.brazeRequest);
    }

    public final String getNetworkExceptionMessage() {
        return this.networkExceptionMessage;
    }

    public final Long getRequestInitiationTime() {
        return this.requestInitiationTime;
    }

    public final RequestType getRequestType() {
        return this.requestType;
    }

    public int hashCode() {
        return (this.originalException.hashCode() * 31) + this.brazeRequest.hashCode();
    }

    public String toString() {
        return "BrazeNetworkFailureEvent(originalException=" + this.originalException + ", brazeRequest=" + this.brazeRequest + ')';
    }
}
