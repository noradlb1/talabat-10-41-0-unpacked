package com.talabat.wallet.qPayManager.data.impl;

import com.talabat.talabatcore.platform.NetworkHandler;
import com.talabat.wallet.qPayManager.data.remote.QPayManagerRemoteDataSource;
import com.talabat.wallet.qPayManager.domain.repository.QPayManagerRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J!\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lcom/talabat/wallet/qPayManager/data/impl/QPayManagerRepositoryImpl;", "Lcom/talabat/wallet/qPayManager/domain/repository/QPayManagerRepository;", "qPayManagerRemoteDataSource", "Lcom/talabat/wallet/qPayManager/data/remote/QPayManagerRemoteDataSource;", "networkHandler", "Lcom/talabat/talabatcore/platform/NetworkHandler;", "(Lcom/talabat/wallet/qPayManager/data/remote/QPayManagerRemoteDataSource;Lcom/talabat/talabatcore/platform/NetworkHandler;)V", "getQPayRedirectUrl", "Lcom/talabat/wallet/qPayManager/domain/entity/QPayRedirectUrl;", "url", "", "request", "Lcom/talabat/wallet/qPayManager/data/remote/dto/QPayRedirectUrlRequest;", "(Ljava/lang/String;Lcom/talabat/wallet/qPayManager/data/remote/dto/QPayRedirectUrlRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class QPayManagerRepositoryImpl implements QPayManagerRepository {
    @NotNull
    private final NetworkHandler networkHandler;
    @NotNull
    private final QPayManagerRemoteDataSource qPayManagerRemoteDataSource;

    public QPayManagerRepositoryImpl(@NotNull QPayManagerRemoteDataSource qPayManagerRemoteDataSource2, @NotNull NetworkHandler networkHandler2) {
        Intrinsics.checkNotNullParameter(qPayManagerRemoteDataSource2, "qPayManagerRemoteDataSource");
        Intrinsics.checkNotNullParameter(networkHandler2, "networkHandler");
        this.qPayManagerRemoteDataSource = qPayManagerRemoteDataSource2;
        this.networkHandler = networkHandler2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getQPayRedirectUrl(@org.jetbrains.annotations.NotNull java.lang.String r16, @org.jetbrains.annotations.NotNull com.talabat.wallet.qPayManager.data.remote.dto.QPayRedirectUrlRequest r17, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.wallet.qPayManager.domain.entity.QPayRedirectUrl> r18) {
        /*
            r15 = this;
            r0 = r15
            r1 = r18
            boolean r2 = r1 instanceof com.talabat.wallet.qPayManager.data.impl.QPayManagerRepositoryImpl$getQPayRedirectUrl$1
            if (r2 == 0) goto L_0x0016
            r2 = r1
            com.talabat.wallet.qPayManager.data.impl.QPayManagerRepositoryImpl$getQPayRedirectUrl$1 r2 = (com.talabat.wallet.qPayManager.data.impl.QPayManagerRepositoryImpl$getQPayRedirectUrl$1) r2
            int r3 = r2.f12655k
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0016
            int r3 = r3 - r4
            r2.f12655k = r3
            goto L_0x001b
        L_0x0016:
            com.talabat.wallet.qPayManager.data.impl.QPayManagerRepositoryImpl$getQPayRedirectUrl$1 r2 = new com.talabat.wallet.qPayManager.data.impl.QPayManagerRepositoryImpl$getQPayRedirectUrl$1
            r2.<init>(r15, r1)
        L_0x001b:
            java.lang.Object r1 = r2.f12653i
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.f12655k
            r5 = 1
            if (r4 == 0) goto L_0x0038
            if (r4 != r5) goto L_0x0030
            java.lang.Object r2 = r2.f12652h
            com.talabat.wallet.qPayManager.domain.entity.QPayRedirectUrl r2 = (com.talabat.wallet.qPayManager.domain.entity.QPayRedirectUrl) r2
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0065
        L_0x0030:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r1)
            com.talabat.talabatcore.platform.NetworkHandler r1 = r0.networkHandler
            boolean r1 = r1.isConnected()
            if (r1 == 0) goto L_0x006a
            com.talabat.wallet.qPayManager.domain.entity.QPayRedirectUrl r1 = new com.talabat.wallet.qPayManager.domain.entity.QPayRedirectUrl
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 31
            r13 = 0
            r6 = r1
            r6.<init>(r7, r8, r9, r10, r11, r12, r13)
            com.talabat.wallet.qPayManager.data.remote.QPayManagerRemoteDataSource r4 = r0.qPayManagerRemoteDataSource
            r2.f12652h = r1
            r2.f12655k = r5
            r5 = r16
            r6 = r17
            java.lang.Object r2 = r4.getQPayRedirectUrl(r5, r6, r2)
            if (r2 != r3) goto L_0x0062
            return r3
        L_0x0062:
            r14 = r2
            r2 = r1
            r1 = r14
        L_0x0065:
            java.lang.Object r1 = com.talabat.mapper.ModelMappingIntegrationKt.parseFromNullable(r2, r1)
            return r1
        L_0x006a:
            com.talabat.wallet.qPayManager.data.remote.dto.NoInternetException r1 = new com.talabat.wallet.qPayManager.data.remote.dto.NoInternetException
            r2 = 0
            r1.<init>(r2, r5, r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.wallet.qPayManager.data.impl.QPayManagerRepositoryImpl.getQPayRedirectUrl(java.lang.String, com.talabat.wallet.qPayManager.data.remote.dto.QPayRedirectUrlRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ QPayManagerRepositoryImpl(com.talabat.wallet.qPayManager.data.remote.QPayManagerRemoteDataSource r1, com.talabat.talabatcore.platform.NetworkHandler r2, int r3, kotlin.jvm.internal.DefaultConstructorMarker r4) {
        /*
            r0 = this;
            r3 = r3 & 2
            if (r3 == 0) goto L_0x0018
            com.talabat.talabatcore.platform.NetworkHandler r2 = new com.talabat.talabatcore.platform.NetworkHandler
            com.talabat.talabatcore.application.BaseApplication$Companion r3 = com.talabat.talabatcore.application.BaseApplication.Companion
            com.talabat.talabatcore.application.BaseApplication r3 = r3.getInstance()
            android.content.Context r3 = r3.getApplicationContext()
            java.lang.String r4 = "BaseApplication.instance.applicationContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r2.<init>(r3)
        L_0x0018:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.wallet.qPayManager.data.impl.QPayManagerRepositoryImpl.<init>(com.talabat.wallet.qPayManager.data.remote.QPayManagerRemoteDataSource, com.talabat.talabatcore.platform.NetworkHandler, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
