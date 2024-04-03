package com.talabat.talabatcommon.feature.walletBanner.repository;

import com.talabat.talabatcommon.feature.walletBanner.service.WalletBannerService;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletBanner/repository/WalletBannerRepositoryImpl;", "Lcom/talabat/talabatcommon/feature/walletBanner/repository/WalletBannerRepository;", "walletBannerService", "Lcom/talabat/talabatcommon/feature/walletBanner/service/WalletBannerService;", "(Lcom/talabat/talabatcommon/feature/walletBanner/service/WalletBannerService;)V", "getWalletBanner", "Lcom/talabat/talabatcommon/model/wallet/WalletBannerDisplayModel;", "countryId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletBannerRepositoryImpl implements WalletBannerRepository {
    @NotNull
    private final WalletBannerService walletBannerService;

    @Inject
    public WalletBannerRepositoryImpl(@NotNull WalletBannerService walletBannerService2) {
        Intrinsics.checkNotNullParameter(walletBannerService2, "walletBannerService");
        this.walletBannerService = walletBannerService2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getWalletBanner(@org.jetbrains.annotations.NotNull java.lang.String r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.talabatcommon.model.wallet.WalletBannerDisplayModel> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.talabat.talabatcommon.feature.walletBanner.repository.WalletBannerRepositoryImpl$getWalletBanner$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.talabat.talabatcommon.feature.walletBanner.repository.WalletBannerRepositoryImpl$getWalletBanner$1 r0 = (com.talabat.talabatcommon.feature.walletBanner.repository.WalletBannerRepositoryImpl$getWalletBanner$1) r0
            int r1 = r0.f61698j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f61698j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.talabatcommon.feature.walletBanner.repository.WalletBannerRepositoryImpl$getWalletBanner$1 r0 = new com.talabat.talabatcommon.feature.walletBanner.repository.WalletBannerRepositoryImpl$getWalletBanner$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f61696h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f61698j
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x003f
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r6)
            com.talabat.talabatcommon.feature.walletBanner.service.WalletBannerService r6 = r4.walletBannerService
            r0.f61698j = r3
            java.lang.Object r6 = r6.getWalletBanner(r5, r0)
            if (r6 != r1) goto L_0x003f
            return r1
        L_0x003f:
            com.talabat.talabatcommon.feature.walletBanner.model.WalletBannerResponse r6 = (com.talabat.talabatcommon.feature.walletBanner.model.WalletBannerResponse) r6
            com.talabat.talabatcommon.model.wallet.WalletBannerDisplayModel r5 = com.talabat.talabatcommon.feature.walletBanner.model.WalletBannerResponseKt.toDisplayModel(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.feature.walletBanner.repository.WalletBannerRepositoryImpl.getWalletBanner(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
