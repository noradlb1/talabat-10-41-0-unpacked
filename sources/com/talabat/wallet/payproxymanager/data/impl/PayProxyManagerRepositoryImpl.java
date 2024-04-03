package com.talabat.wallet.payproxymanager.data.impl;

import com.talabat.wallet.payproxymanager.data.remote.PayProxyManagerRemoteDataSource;
import com.talabat.wallet.payproxymanager.domain.PayProxyManagerRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/talabat/wallet/payproxymanager/data/impl/PayProxyManagerRepositoryImpl;", "Lcom/talabat/wallet/payproxymanager/domain/PayProxyManagerRepository;", "payProxyManagerRemoteDataSource", "Lcom/talabat/wallet/payproxymanager/data/remote/PayProxyManagerRemoteDataSource;", "(Lcom/talabat/wallet/payproxymanager/data/remote/PayProxyManagerRemoteDataSource;)V", "sendCVVToPayProxy", "Lcom/talabat/wallet/payproxymanager/domain/entity/PayProxyCVVResult;", "payProxyCVVRequestModel", "Lcom/talabat/wallet/payproxymanager/data/remote/dto/request/PayProxyCVVRequestModel;", "(Lcom/talabat/wallet/payproxymanager/data/remote/dto/request/PayProxyCVVRequestModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PayProxyManagerRepositoryImpl implements PayProxyManagerRepository {
    @NotNull
    private final PayProxyManagerRemoteDataSource payProxyManagerRemoteDataSource;

    public PayProxyManagerRepositoryImpl(@NotNull PayProxyManagerRemoteDataSource payProxyManagerRemoteDataSource2) {
        Intrinsics.checkNotNullParameter(payProxyManagerRemoteDataSource2, "payProxyManagerRemoteDataSource");
        this.payProxyManagerRemoteDataSource = payProxyManagerRemoteDataSource2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object sendCVVToPayProxy(@org.jetbrains.annotations.NotNull com.talabat.wallet.payproxymanager.data.remote.dto.request.PayProxyCVVRequestModel r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.wallet.payproxymanager.domain.entity.PayProxyCVVResult> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.talabat.wallet.payproxymanager.data.impl.PayProxyManagerRepositoryImpl$sendCVVToPayProxy$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.talabat.wallet.payproxymanager.data.impl.PayProxyManagerRepositoryImpl$sendCVVToPayProxy$1 r0 = (com.talabat.wallet.payproxymanager.data.impl.PayProxyManagerRepositoryImpl$sendCVVToPayProxy$1) r0
            int r1 = r0.f12637k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f12637k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.wallet.payproxymanager.data.impl.PayProxyManagerRepositoryImpl$sendCVVToPayProxy$1 r0 = new com.talabat.wallet.payproxymanager.data.impl.PayProxyManagerRepositoryImpl$sendCVVToPayProxy$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f12635i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f12637k
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r6 = r0.f12634h
            com.talabat.wallet.payproxymanager.domain.entity.mapper.PayProxyMapper r6 = (com.talabat.wallet.payproxymanager.domain.entity.mapper.PayProxyMapper) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x004a
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r7)
            com.talabat.wallet.payproxymanager.domain.entity.mapper.PayProxyMapper r7 = com.talabat.wallet.payproxymanager.domain.entity.mapper.PayProxyMapper.INSTANCE
            com.talabat.wallet.payproxymanager.data.remote.PayProxyManagerRemoteDataSource r2 = r5.payProxyManagerRemoteDataSource
            r0.f12634h = r7
            r0.f12637k = r3
            java.lang.Object r6 = r2.sendCVVToPayProxy(r6, r0)
            if (r6 != r1) goto L_0x0047
            return r1
        L_0x0047:
            r4 = r7
            r7 = r6
            r6 = r4
        L_0x004a:
            com.talabat.wallet.payproxymanager.data.remote.dto.response.PayProxyCVVRemoteDto r7 = (com.talabat.wallet.payproxymanager.data.remote.dto.response.PayProxyCVVRemoteDto) r7
            com.talabat.wallet.payproxymanager.domain.entity.PayProxyCVVResult r6 = r6.mapToPayProxyCVV(r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.wallet.payproxymanager.data.impl.PayProxyManagerRepositoryImpl.sendCVVToPayProxy(com.talabat.wallet.payproxymanager.data.remote.dto.request.PayProxyCVVRequestModel, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
