package com.facebook.internal;

import android.content.Intent;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import com.huawei.hms.api.FailedBinderCallBack;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0013\u001a\u00020\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/facebook/internal/AppCall;", "", "requestCode", "", "callId", "Ljava/util/UUID;", "(ILjava/util/UUID;)V", "getCallId", "()Ljava/util/UUID;", "getRequestCode", "()I", "setRequestCode", "(I)V", "requestIntent", "Landroid/content/Intent;", "getRequestIntent", "()Landroid/content/Intent;", "setRequestIntent", "(Landroid/content/Intent;)V", "setPending", "", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@AutoHandleExceptions
public final class AppCall {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @Nullable
    public static AppCall currentPendingCall;
    @NotNull
    private final UUID callId;
    private int requestCode;
    @Nullable
    private Intent requestIntent;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0002R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/facebook/internal/AppCall$Companion;", "", "()V", "<set-?>", "Lcom/facebook/internal/AppCall;", "currentPendingCall", "getCurrentPendingCall", "()Lcom/facebook/internal/AppCall;", "finishPendingCall", "callId", "Ljava/util/UUID;", "requestCode", "", "setCurrentPendingCall", "", "appCall", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final synchronized boolean setCurrentPendingCall(AppCall appCall) {
            boolean z11;
            AppCall currentPendingCall = getCurrentPendingCall();
            AppCall.currentPendingCall = appCall;
            if (currentPendingCall != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            return z11;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0024, code lost:
            return null;
         */
        @kotlin.jvm.JvmStatic
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final synchronized com.facebook.internal.AppCall finishPendingCall(@org.jetbrains.annotations.NotNull java.util.UUID r4, int r5) {
            /*
                r3 = this;
                monitor-enter(r3)
                java.lang.String r0 = "callId"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)     // Catch:{ all -> 0x0025 }
                com.facebook.internal.AppCall r0 = r3.getCurrentPendingCall()     // Catch:{ all -> 0x0025 }
                r1 = 0
                if (r0 == 0) goto L_0x0023
                java.util.UUID r2 = r0.getCallId()     // Catch:{ all -> 0x0025 }
                boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r4)     // Catch:{ all -> 0x0025 }
                if (r4 == 0) goto L_0x0023
                int r4 = r0.getRequestCode()     // Catch:{ all -> 0x0025 }
                if (r4 == r5) goto L_0x001e
                goto L_0x0023
            L_0x001e:
                r3.setCurrentPendingCall(r1)     // Catch:{ all -> 0x0025 }
                monitor-exit(r3)
                return r0
            L_0x0023:
                monitor-exit(r3)
                return r1
            L_0x0025:
                r4 = move-exception
                monitor-exit(r3)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.AppCall.Companion.finishPendingCall(java.util.UUID, int):com.facebook.internal.AppCall");
        }

        @Nullable
        public final AppCall getCurrentPendingCall() {
            return AppCall.currentPendingCall;
        }
    }

    @JvmOverloads
    public AppCall(int i11) {
        this(i11, (UUID) null, 2, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public AppCall(int i11, @NotNull UUID uuid) {
        Intrinsics.checkNotNullParameter(uuid, FailedBinderCallBack.CALLER_ID);
        this.requestCode = i11;
        this.callId = uuid;
    }

    @JvmStatic
    @Nullable
    public static final synchronized AppCall finishPendingCall(@NotNull UUID uuid, int i11) {
        AppCall finishPendingCall;
        synchronized (AppCall.class) {
            finishPendingCall = Companion.finishPendingCall(uuid, i11);
        }
        return finishPendingCall;
    }

    @NotNull
    public final UUID getCallId() {
        return this.callId;
    }

    public final int getRequestCode() {
        return this.requestCode;
    }

    @Nullable
    public final Intent getRequestIntent() {
        return this.requestIntent;
    }

    public final boolean setPending() {
        return Companion.setCurrentPendingCall(this);
    }

    public final void setRequestCode(int i11) {
        this.requestCode = i11;
    }

    public final void setRequestIntent(@Nullable Intent intent) {
        this.requestIntent = intent;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AppCall(int r1, java.util.UUID r2, int r3, kotlin.jvm.internal.DefaultConstructorMarker r4) {
        /*
            r0 = this;
            r3 = r3 & 2
            if (r3 == 0) goto L_0x000d
            java.util.UUID r2 = java.util.UUID.randomUUID()
            java.lang.String r3 = "randomUUID()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
        L_0x000d:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.AppCall.<init>(int, java.util.UUID, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
