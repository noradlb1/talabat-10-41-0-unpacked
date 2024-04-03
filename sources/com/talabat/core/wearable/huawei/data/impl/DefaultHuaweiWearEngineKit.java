package com.talabat.core.wearable.huawei.data.impl;

import com.huawei.hmf.tasks.Task;
import com.huawei.wearengine.auth.AuthClient;
import com.huawei.wearengine.auth.Permission;
import com.huawei.wearengine.device.Device;
import com.huawei.wearengine.device.DeviceClient;
import com.huawei.wearengine.p2p.Message;
import com.huawei.wearengine.p2p.P2pClient;
import com.huawei.wearengine.p2p.SendCallback;
import com.talabat.core.wearable.huawei.data.HuaweiWearEngineKit;
import com.talabat.talabatcore.cache.Cache;
import com.talabat.talabatcore.logger.LogManager;
import java.nio.charset.Charset;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sh.a;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 %2\u00020\u0001:\u0001%B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0011\u0010\u000b\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0011\u0010\u0010\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0011\u0010\u0011\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0019\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\fH\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0019\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\u0018\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u000fH\u0016J!\u0010 \u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010!J\u001b\u0010\"\u001a\u00020\f*\b\u0012\u0004\u0012\u00020\f0#H@ø\u0001\u0000¢\u0006\u0002\u0010$R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, d2 = {"Lcom/talabat/core/wearable/huawei/data/impl/DefaultHuaweiWearEngineKit;", "Lcom/talabat/core/wearable/huawei/data/HuaweiWearEngineKit;", "cache", "Lcom/talabat/talabatcore/cache/Cache;", "deviceClient", "Lcom/huawei/wearengine/device/DeviceClient;", "authClient", "Lcom/huawei/wearengine/auth/AuthClient;", "p2pClient", "Lcom/huawei/wearengine/p2p/P2pClient;", "(Lcom/talabat/talabatcore/cache/Cache;Lcom/huawei/wearengine/device/DeviceClient;Lcom/huawei/wearengine/auth/AuthClient;Lcom/huawei/wearengine/p2p/P2pClient;)V", "authenticateUser", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBondedDevice", "Lcom/huawei/wearengine/device/Device;", "hasAvailableDevices", "isAuthenticated", "isPingSuccessfull", "pingResult", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isSyncEnabled", "logInfo", "", "msg", "", "ping", "bondedDevice", "(Lcom/huawei/wearengine/device/Device;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "send", "message", "sendPingMessage", "(Lcom/huawei/wearengine/p2p/P2pClient;Lcom/huawei/wearengine/device/Device;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "await", "Lcom/huawei/hmf/tasks/Task;", "(Lcom/huawei/hmf/tasks/Task;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "com_talabat_core_wearable_huawei_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DefaultHuaweiWearEngineKit implements HuaweiWearEngineKit {
    private static final int APP_NOT_INSTALLED = 200;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long FAILED_DELAY = 1000;
    private static final int MESSAGE_SEND_SUCCESSFUL = 207;
    private static final int PING_FAILED = 201;
    private static final int PING_SUCCESSFUL = 202;
    @NotNull
    private static final IntRange RETRY_RANGE = new IntRange(1, 10);
    private static final long SUCCESSFULL_DELAY = 5000;
    @NotNull
    private static final String WATCH_SYNC_SWITCH_STATUS_ENABLED_KEY = "watch_sync_switch_status_enabled_key";
    @NotNull
    private final AuthClient authClient;
    @NotNull
    private final Cache cache;
    @NotNull
    private final DeviceClient deviceClient;
    @NotNull
    private final P2pClient p2pClient;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/talabat/core/wearable/huawei/data/impl/DefaultHuaweiWearEngineKit$Companion;", "", "()V", "APP_NOT_INSTALLED", "", "FAILED_DELAY", "", "MESSAGE_SEND_SUCCESSFUL", "PING_FAILED", "PING_SUCCESSFUL", "RETRY_RANGE", "Lkotlin/ranges/IntRange;", "SUCCESSFULL_DELAY", "WATCH_SYNC_SWITCH_STATUS_ENABLED_KEY", "", "com_talabat_core_wearable_huawei_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public DefaultHuaweiWearEngineKit(@NotNull Cache cache2, @NotNull DeviceClient deviceClient2, @NotNull AuthClient authClient2, @NotNull P2pClient p2pClient2) {
        Intrinsics.checkNotNullParameter(cache2, "cache");
        Intrinsics.checkNotNullParameter(deviceClient2, "deviceClient");
        Intrinsics.checkNotNullParameter(authClient2, "authClient");
        Intrinsics.checkNotNullParameter(p2pClient2, "p2pClient");
        this.cache = cache2;
        this.deviceClient = deviceClient2;
        this.authClient = authClient2;
        this.p2pClient = p2pClient2;
    }

    /* access modifiers changed from: private */
    public final Object await(Task<Boolean> task, Continuation<? super Boolean> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        task.addOnCompleteListener(new DefaultHuaweiWearEngineKit$await$2$1(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object isPingSuccessfull(int r7, kotlin.coroutines.Continuation<? super java.lang.Boolean> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.talabat.core.wearable.huawei.data.impl.DefaultHuaweiWearEngineKit$isPingSuccessfull$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.talabat.core.wearable.huawei.data.impl.DefaultHuaweiWearEngineKit$isPingSuccessfull$1 r0 = (com.talabat.core.wearable.huawei.data.impl.DefaultHuaweiWearEngineKit$isPingSuccessfull$1) r0
            int r1 = r0.f56017j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f56017j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.core.wearable.huawei.data.impl.DefaultHuaweiWearEngineKit$isPingSuccessfull$1 r0 = new com.talabat.core.wearable.huawei.data.impl.DefaultHuaweiWearEngineKit$isPingSuccessfull$1
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f56015h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f56017j
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 == r5) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0055
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x006c
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r8)
            switch(r7) {
                case 200: goto L_0x0067;
                case 201: goto L_0x0057;
                case 202: goto L_0x0045;
                default: goto L_0x003f;
            }
        L_0x003f:
            java.lang.String r7 = "Ping undefined"
            r6.logInfo(r7)
            goto L_0x006c
        L_0x0045:
            java.lang.String r7 = "Ping successful."
            r6.logInfo(r7)
            r0.f56017j = r3
            r7 = 5000(0x1388, double:2.4703E-320)
            java.lang.Object r7 = kotlinx.coroutines.DelayKt.delay(r7, r0)
            if (r7 != r1) goto L_0x0055
            return r1
        L_0x0055:
            r4 = r5
            goto L_0x006c
        L_0x0057:
            java.lang.String r7 = "Ping failed."
            r6.logInfo(r7)
            r0.f56017j = r5
            r7 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r7 = kotlinx.coroutines.DelayKt.delay(r7, r0)
            if (r7 != r1) goto L_0x006c
            return r1
        L_0x0067:
            java.lang.String r7 = "Please install watch app firstly."
            r6.logInfo(r7)
        L_0x006c:
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.core.wearable.huawei.data.impl.DefaultHuaweiWearEngineKit.isPingSuccessfull(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void logInfo(String str) {
        LogManager.info("HuaweiWearEngineKit: " + str);
    }

    /* access modifiers changed from: private */
    /* renamed from: send$lambda-3  reason: not valid java name */
    public static final void m9614send$lambda3(DefaultHuaweiWearEngineKit defaultHuaweiWearEngineKit, Task task) {
        String str;
        Intrinsics.checkNotNullParameter(defaultHuaweiWearEngineKit, "this$0");
        if (task.isSuccessful()) {
            str = "Message SuccessListener";
        } else {
            str = "Message FailureListener";
        }
        defaultHuaweiWearEngineKit.logInfo(str);
    }

    /* access modifiers changed from: private */
    public final Object sendPingMessage(P2pClient p2pClient2, Device device, Continuation<? super Integer> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        p2pClient2.ping(device, new DefaultHuaweiWearEngineKit$sendPingMessage$2$1(this, safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    @Nullable
    public Object authenticateUser(@NotNull Continuation<? super Boolean> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        DefaultHuaweiWearEngineKit$authenticateUser$2$authCallback$1 defaultHuaweiWearEngineKit$authenticateUser$2$authCallback$1 = new DefaultHuaweiWearEngineKit$authenticateUser$2$authCallback$1(this, safeContinuation);
        this.authClient.requestPermission(defaultHuaweiWearEngineKit$authenticateUser$2$authCallback$1, Permission.DEVICE_MANAGER).addOnSuccessListener(new DefaultHuaweiWearEngineKit$authenticateUser$2$1(this)).addOnFailureListener(new DefaultHuaweiWearEngineKit$authenticateUser$2$2(this));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    @Nullable
    public Object getBondedDevice(@NotNull Continuation<? super Device> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.deviceClient.getBondedDevices().addOnCompleteListener(new DefaultHuaweiWearEngineKit$getBondedDevice$2$1(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    @Nullable
    public Object hasAvailableDevices(@NotNull Continuation<? super Boolean> continuation) {
        Task<Boolean> hasAvailableDevices = this.deviceClient.hasAvailableDevices();
        Intrinsics.checkNotNullExpressionValue(hasAvailableDevices, "deviceClient.hasAvailableDevices()");
        return await(hasAvailableDevices, continuation);
    }

    @Nullable
    public Object isAuthenticated(@NotNull Continuation<? super Boolean> continuation) {
        Task<Boolean> checkPermission = this.authClient.checkPermission(Permission.DEVICE_MANAGER);
        Intrinsics.checkNotNullExpressionValue(checkPermission, "authClient.checkPermissi…ermission.DEVICE_MANAGER)");
        return await(checkPermission, continuation);
    }

    public boolean isSyncEnabled() {
        return this.cache.getBoolean(WATCH_SYNC_SWITCH_STATUS_ENABLED_KEY, true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0066 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0067 A[PHI: r7 
      PHI: (r7v2 java.lang.Object) = (r7v6 java.lang.Object), (r7v1 java.lang.Object) binds: [B:21:0x0064, B:10:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object ping(@org.jetbrains.annotations.NotNull com.huawei.wearengine.device.Device r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.talabat.core.wearable.huawei.data.impl.DefaultHuaweiWearEngineKit$ping$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.talabat.core.wearable.huawei.data.impl.DefaultHuaweiWearEngineKit$ping$1 r0 = (com.talabat.core.wearable.huawei.data.impl.DefaultHuaweiWearEngineKit$ping$1) r0
            int r1 = r0.f56021k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f56021k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.core.wearable.huawei.data.impl.DefaultHuaweiWearEngineKit$ping$1 r0 = new com.talabat.core.wearable.huawei.data.impl.DefaultHuaweiWearEngineKit$ping$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f56019i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f56021k
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0067
        L_0x002c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0034:
            java.lang.Object r6 = r0.f56018h
            com.talabat.core.wearable.huawei.data.impl.DefaultHuaweiWearEngineKit r6 = (com.talabat.core.wearable.huawei.data.impl.DefaultHuaweiWearEngineKit) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0055
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.ranges.IntRange r7 = RETRY_RANGE
            boolean r7 = kotlin.collections.CollectionsKt___CollectionsKt.any(r7)
            if (r7 == 0) goto L_0x0068
            com.huawei.wearengine.p2p.P2pClient r7 = r5.p2pClient
            r0.f56018h = r5
            r0.f56021k = r4
            java.lang.Object r7 = r5.sendPingMessage(r7, r6, r0)
            if (r7 != r1) goto L_0x0054
            return r1
        L_0x0054:
            r6 = r5
        L_0x0055:
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = r7.intValue()
            r2 = 0
            r0.f56018h = r2
            r0.f56021k = r3
            java.lang.Object r7 = r6.isPingSuccessfull(r7, r0)
            if (r7 != r1) goto L_0x0067
            return r1
        L_0x0067:
            return r7
        L_0x0068:
            r6 = 0
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.core.wearable.huawei.data.impl.DefaultHuaweiWearEngineKit.ping(com.huawei.wearengine.device.Device, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void send(@NotNull String str, @NotNull Device device) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(device, "bondedDevice");
        if (isSyncEnabled()) {
            logInfo(str);
            Message.Builder builder = new Message.Builder();
            Charset forName = Charset.forName("UTF-8");
            Intrinsics.checkNotNullExpressionValue(forName, "forName(charsetName)");
            byte[] bytes = str.getBytes(forName);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            builder.setPayload(bytes);
            this.p2pClient.send(device, builder.build(), (SendCallback) new DefaultHuaweiWearEngineKit$send$sendCallback$1(this)).addOnCompleteListener(new a(this));
        }
    }
}
