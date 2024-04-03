package com.talabat.wallet.knetStatusManager.data.impl;

import com.talabat.wallet.knetStatusManager.data.remote.KNetStatusManagerRemoteDataSource;
import com.talabat.wallet.knetStatusManager.domain.repository.KNetStatusManagerRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"Lcom/talabat/wallet/knetStatusManager/data/impl/KNetStatusManagerRepositoryImpl;", "Lcom/talabat/wallet/knetStatusManager/domain/repository/KNetStatusManagerRepository;", "kNetStatusManagerRemoteDataSource", "Lcom/talabat/wallet/knetStatusManager/data/remote/KNetStatusManagerRemoteDataSource;", "(Lcom/talabat/wallet/knetStatusManager/data/remote/KNetStatusManagerRemoteDataSource;)V", "getKNetStatus", "Lcom/talabat/wallet/knetStatusManager/domain/entity/KNetStatus;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class KNetStatusManagerRepositoryImpl implements KNetStatusManagerRepository {
    @NotNull
    private final KNetStatusManagerRemoteDataSource kNetStatusManagerRemoteDataSource;

    public KNetStatusManagerRepositoryImpl(@NotNull KNetStatusManagerRemoteDataSource kNetStatusManagerRemoteDataSource2) {
        Intrinsics.checkNotNullParameter(kNetStatusManagerRemoteDataSource2, "kNetStatusManagerRemoteDataSource");
        this.kNetStatusManagerRemoteDataSource = kNetStatusManagerRemoteDataSource2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getKNetStatus(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.wallet.knetStatusManager.domain.entity.KNetStatus> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.talabat.wallet.knetStatusManager.data.impl.KNetStatusManagerRepositoryImpl$getKNetStatus$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.talabat.wallet.knetStatusManager.data.impl.KNetStatusManagerRepositoryImpl$getKNetStatus$1 r0 = (com.talabat.wallet.knetStatusManager.data.impl.KNetStatusManagerRepositoryImpl$getKNetStatus$1) r0
            int r1 = r0.f12619k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f12619k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.wallet.knetStatusManager.data.impl.KNetStatusManagerRepositoryImpl$getKNetStatus$1 r0 = new com.talabat.wallet.knetStatusManager.data.impl.KNetStatusManagerRepositoryImpl$getKNetStatus$1
            r0.<init>(r6, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f12617i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f12619k
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r0 = r0.f12616h
            com.talabat.wallet.knetStatusManager.domain.entity.KNetStatus r0 = (com.talabat.wallet.knetStatusManager.domain.entity.KNetStatus) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x004f
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r7)
            com.talabat.wallet.knetStatusManager.domain.entity.KNetStatus r7 = new com.talabat.wallet.knetStatusManager.domain.entity.KNetStatus
            r2 = 0
            r4 = 0
            r7.<init>(r2, r3, r4)
            com.talabat.wallet.knetStatusManager.data.remote.KNetStatusManagerRemoteDataSource r2 = r6.kNetStatusManagerRemoteDataSource
            r0.f12616h = r7
            r0.f12619k = r3
            java.lang.Object r0 = r2.getKNetStatus(r0)
            if (r0 != r1) goto L_0x004c
            return r1
        L_0x004c:
            r5 = r0
            r0 = r7
            r7 = r5
        L_0x004f:
            java.lang.Object r7 = com.talabat.mapper.ModelMappingIntegrationKt.parseFromNullable(r0, r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.wallet.knetStatusManager.data.impl.KNetStatusManagerRepositoryImpl.getKNetStatus(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
