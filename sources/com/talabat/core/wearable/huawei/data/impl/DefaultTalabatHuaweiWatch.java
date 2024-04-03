package com.talabat.core.wearable.huawei.data.impl;

import com.talabat.core.wearable.huawei.data.HuaweiWearEngineKit;
import com.talabat.core.wearable.huawei.domain.TalabatHuaweiWatch;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0019\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lcom/talabat/core/wearable/huawei/data/impl/DefaultTalabatHuaweiWatch;", "Lcom/talabat/core/wearable/huawei/domain/TalabatHuaweiWatch;", "wearEngine", "Lcom/talabat/core/wearable/huawei/data/HuaweiWearEngineKit;", "(Lcom/talabat/core/wearable/huawei/data/HuaweiWearEngineKit;)V", "checkUserAuthentication", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "send", "", "message", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_core_wearable_huawei_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DefaultTalabatHuaweiWatch implements TalabatHuaweiWatch {
    @NotNull
    private final HuaweiWearEngineKit wearEngine;

    @Inject
    public DefaultTalabatHuaweiWatch(@NotNull HuaweiWearEngineKit huaweiWearEngineKit) {
        Intrinsics.checkNotNullParameter(huaweiWearEngineKit, "wearEngine");
        this.wearEngine = huaweiWearEngineKit;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object checkUserAuthentication(kotlin.coroutines.Continuation<? super java.lang.Boolean> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.talabat.core.wearable.huawei.data.impl.DefaultTalabatHuaweiWatch$checkUserAuthentication$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.talabat.core.wearable.huawei.data.impl.DefaultTalabatHuaweiWatch$checkUserAuthentication$1 r0 = (com.talabat.core.wearable.huawei.data.impl.DefaultTalabatHuaweiWatch$checkUserAuthentication$1) r0
            int r1 = r0.f56028k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f56028k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.core.wearable.huawei.data.impl.DefaultTalabatHuaweiWatch$checkUserAuthentication$1 r0 = new com.talabat.core.wearable.huawei.data.impl.DefaultTalabatHuaweiWatch$checkUserAuthentication$1
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f56026i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f56028k
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0064
        L_0x002c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0034:
            java.lang.Object r2 = r0.f56025h
            com.talabat.core.wearable.huawei.data.impl.DefaultTalabatHuaweiWatch r2 = (com.talabat.core.wearable.huawei.data.impl.DefaultTalabatHuaweiWatch) r2
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004d
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r6)
            com.talabat.core.wearable.huawei.data.HuaweiWearEngineKit r6 = r5.wearEngine
            r0.f56025h = r5
            r0.f56028k = r4
            java.lang.Object r6 = r6.isAuthenticated(r0)
            if (r6 != r1) goto L_0x004c
            return r1
        L_0x004c:
            r2 = r5
        L_0x004d:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x0056
            goto L_0x006e
        L_0x0056:
            com.talabat.core.wearable.huawei.data.HuaweiWearEngineKit r6 = r2.wearEngine
            r2 = 0
            r0.f56025h = r2
            r0.f56028k = r3
            java.lang.Object r6 = r6.authenticateUser(r0)
            if (r6 != r1) goto L_0x0064
            return r1
        L_0x0064:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x006d
            goto L_0x006e
        L_0x006d:
            r4 = 0
        L_0x006e:
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.core.wearable.huawei.data.impl.DefaultTalabatHuaweiWatch.checkUserAuthentication(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object send(@org.jetbrains.annotations.NotNull java.lang.String r8, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.talabat.core.wearable.huawei.data.impl.DefaultTalabatHuaweiWatch$send$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.talabat.core.wearable.huawei.data.impl.DefaultTalabatHuaweiWatch$send$1 r0 = (com.talabat.core.wearable.huawei.data.impl.DefaultTalabatHuaweiWatch$send$1) r0
            int r1 = r0.f56034m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f56034m = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.core.wearable.huawei.data.impl.DefaultTalabatHuaweiWatch$send$1 r0 = new com.talabat.core.wearable.huawei.data.impl.DefaultTalabatHuaweiWatch$send$1
            r0.<init>(r7, r9)
        L_0x0018:
            java.lang.Object r9 = r0.f56032k
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f56034m
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L_0x006b
            if (r2 == r6) goto L_0x005f
            if (r2 == r5) goto L_0x0053
            if (r2 == r4) goto L_0x0047
            if (r2 != r3) goto L_0x003f
            java.lang.Object r8 = r0.f56031j
            com.huawei.wearengine.device.Device r8 = (com.huawei.wearengine.device.Device) r8
            java.lang.Object r1 = r0.f56030i
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.f56029h
            com.talabat.core.wearable.huawei.data.impl.DefaultTalabatHuaweiWatch r0 = (com.talabat.core.wearable.huawei.data.impl.DefaultTalabatHuaweiWatch) r0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x00c6
        L_0x003f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0047:
            java.lang.Object r8 = r0.f56030i
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r2 = r0.f56029h
            com.talabat.core.wearable.huawei.data.impl.DefaultTalabatHuaweiWatch r2 = (com.talabat.core.wearable.huawei.data.impl.DefaultTalabatHuaweiWatch) r2
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x00aa
        L_0x0053:
            java.lang.Object r8 = r0.f56030i
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r2 = r0.f56029h
            com.talabat.core.wearable.huawei.data.impl.DefaultTalabatHuaweiWatch r2 = (com.talabat.core.wearable.huawei.data.impl.DefaultTalabatHuaweiWatch) r2
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0093
        L_0x005f:
            java.lang.Object r8 = r0.f56030i
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r2 = r0.f56029h
            com.talabat.core.wearable.huawei.data.impl.DefaultTalabatHuaweiWatch r2 = (com.talabat.core.wearable.huawei.data.impl.DefaultTalabatHuaweiWatch) r2
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x007e
        L_0x006b:
            kotlin.ResultKt.throwOnFailure(r9)
            com.talabat.core.wearable.huawei.data.HuaweiWearEngineKit r9 = r7.wearEngine
            r0.f56029h = r7
            r0.f56030i = r8
            r0.f56034m = r6
            java.lang.Object r9 = r9.hasAvailableDevices(r0)
            if (r9 != r1) goto L_0x007d
            return r1
        L_0x007d:
            r2 = r7
        L_0x007e:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x00d3
            r0.f56029h = r2
            r0.f56030i = r8
            r0.f56034m = r5
            java.lang.Object r9 = r2.checkUserAuthentication(r0)
            if (r9 != r1) goto L_0x0093
            return r1
        L_0x0093:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x00d3
            com.talabat.core.wearable.huawei.data.HuaweiWearEngineKit r9 = r2.wearEngine
            r0.f56029h = r2
            r0.f56030i = r8
            r0.f56034m = r4
            java.lang.Object r9 = r9.getBondedDevice(r0)
            if (r9 != r1) goto L_0x00aa
            return r1
        L_0x00aa:
            com.huawei.wearengine.device.Device r9 = (com.huawei.wearengine.device.Device) r9
            if (r9 != 0) goto L_0x00b1
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L_0x00b1:
            com.talabat.core.wearable.huawei.data.HuaweiWearEngineKit r4 = r2.wearEngine
            r0.f56029h = r2
            r0.f56030i = r8
            r0.f56031j = r9
            r0.f56034m = r3
            java.lang.Object r0 = r4.ping(r9, r0)
            if (r0 != r1) goto L_0x00c2
            return r1
        L_0x00c2:
            r1 = r8
            r8 = r9
            r9 = r0
            r0 = r2
        L_0x00c6:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x00d3
            com.talabat.core.wearable.huawei.data.HuaweiWearEngineKit r9 = r0.wearEngine
            r9.send(r1, r8)
        L_0x00d3:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.core.wearable.huawei.data.impl.DefaultTalabatHuaweiWatch.send(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
