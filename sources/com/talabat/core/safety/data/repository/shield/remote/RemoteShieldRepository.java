package com.talabat.core.safety.data.repository.shield.remote;

import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.safety.data.datasource.info.ShieldInfoDtoFactory;
import com.talabat.core.safety.data.repository.shield.ShieldRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ1\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/talabat/core/safety/data/repository/shield/remote/RemoteShieldRepository;", "Lcom/talabat/core/safety/data/repository/shield/ShieldRepository;", "retrofit", "Lretrofit2/Retrofit;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "shieldInfoDtoFactory", "Lcom/talabat/core/safety/data/datasource/info/ShieldInfoDtoFactory;", "(Lretrofit2/Retrofit;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;Lcom/talabat/core/safety/data/datasource/info/ShieldInfoDtoFactory;)V", "sendSafetyResult", "", "customerId", "", "safetyEventType", "Lcom/talabat/core/safety/domain/SafetyEventType;", "playIntegrityResponse", "safetyAppData", "Lcom/talabat/core/safety/domain/entities/SafetyAppData;", "(Ljava/lang/String;Lcom/talabat/core/safety/domain/SafetyEventType;Ljava/lang/String;Lcom/talabat/core/safety/domain/entities/SafetyAppData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_core_safety_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RemoteShieldRepository implements ShieldRepository {
    @NotNull
    private final IObservabilityManager observabilityManager;
    @NotNull
    private final Retrofit retrofit;
    @NotNull
    private final ShieldInfoDtoFactory shieldInfoDtoFactory;

    @Inject
    public RemoteShieldRepository(@NotNull Retrofit retrofit3, @NotNull IObservabilityManager iObservabilityManager, @NotNull ShieldInfoDtoFactory shieldInfoDtoFactory2) {
        Intrinsics.checkNotNullParameter(retrofit3, "retrofit");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        Intrinsics.checkNotNullParameter(shieldInfoDtoFactory2, "shieldInfoDtoFactory");
        this.retrofit = retrofit3;
        this.observabilityManager = iObservabilityManager;
        this.shieldInfoDtoFactory = shieldInfoDtoFactory2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object sendSafetyResult(@org.jetbrains.annotations.NotNull java.lang.String r7, @org.jetbrains.annotations.NotNull com.talabat.core.safety.domain.SafetyEventType r8, @org.jetbrains.annotations.NotNull java.lang.String r9, @org.jetbrains.annotations.NotNull com.talabat.core.safety.domain.entities.SafetyAppData r10, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r6 = this;
            boolean r0 = r11 instanceof com.talabat.core.safety.data.repository.shield.remote.RemoteShieldRepository$sendSafetyResult$1
            if (r0 == 0) goto L_0x0013
            r0 = r11
            com.talabat.core.safety.data.repository.shield.remote.RemoteShieldRepository$sendSafetyResult$1 r0 = (com.talabat.core.safety.data.repository.shield.remote.RemoteShieldRepository$sendSafetyResult$1) r0
            int r1 = r0.f55970k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f55970k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.core.safety.data.repository.shield.remote.RemoteShieldRepository$sendSafetyResult$1 r0 = new com.talabat.core.safety.data.repository.shield.remote.RemoteShieldRepository$sendSafetyResult$1
            r0.<init>(r6, r11)
        L_0x0018:
            java.lang.Object r11 = r0.f55968i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f55970k
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r7 = r0.f55967h
            com.talabat.core.safety.data.repository.shield.remote.RemoteShieldRepository r7 = (com.talabat.core.safety.data.repository.shield.remote.RemoteShieldRepository) r7
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0054
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r11)
            com.talabat.core.safety.data.datasource.info.ShieldInfoDtoFactory r11 = r6.shieldInfoDtoFactory
            com.talabat.core.safety.data.model.ShieldInfoDto r7 = r11.create(r7, r8, r9, r10)
            retrofit2.Retrofit r8 = r6.retrofit
            java.lang.Class<com.talabat.core.safety.data.datasource.api.ShieldRequestApi> r9 = com.talabat.core.safety.data.datasource.api.ShieldRequestApi.class
            java.lang.Object r8 = r8.create(r9)
            com.talabat.core.safety.data.datasource.api.ShieldRequestApi r8 = (com.talabat.core.safety.data.datasource.api.ShieldRequestApi) r8
            r0.f55967h = r6
            r0.f55970k = r3
            java.lang.Object r11 = r8.postProcedure(r7, r0)
            if (r11 != r1) goto L_0x0053
            return r1
        L_0x0053:
            r7 = r6
        L_0x0054:
            retrofit2.Response r11 = (retrofit2.Response) r11
            com.talabat.core.observabilityNew.domain.IObservabilityManager r0 = r7.observabilityManager
            boolean r7 = r11.isSuccessful()
            if (r7 == 0) goto L_0x0061
            java.lang.String r7 = ""
            goto L_0x0064
        L_0x0061:
            java.lang.String r7 = "un"
        L_0x0064:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "shield_request_"
            r8.append(r9)
            r8.append(r7)
            java.lang.String r7 = "successful"
            r8.append(r7)
            java.lang.String r1 = r8.toString()
            java.lang.String r2 = "shield_request"
            r3 = 0
            r4 = 4
            r5 = 0
            com.talabat.core.observabilityNew.domain.IObservabilityManager.DefaultImpls.trackEvent$default((com.talabat.core.observabilityNew.domain.IObservabilityManager) r0, (java.lang.String) r1, (java.lang.String) r2, (java.util.Map) r3, (int) r4, (java.lang.Object) r5)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.core.safety.data.repository.shield.remote.RemoteShieldRepository.sendSafetyResult(java.lang.String, com.talabat.core.safety.domain.SafetyEventType, java.lang.String, com.talabat.core.safety.domain.entities.SafetyAppData, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
