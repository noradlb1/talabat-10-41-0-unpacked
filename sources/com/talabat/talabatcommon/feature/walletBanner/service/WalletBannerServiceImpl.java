package com.talabat.talabatcommon.feature.walletBanner.service;

import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletBanner/service/WalletBannerServiceImpl;", "Lcom/talabat/talabatcommon/feature/walletBanner/service/WalletBannerService;", "walletBannerApi", "Lcom/talabat/talabatcommon/feature/walletBanner/service/WalletBannerApi;", "(Lcom/talabat/talabatcommon/feature/walletBanner/service/WalletBannerApi;)V", "getWalletBanner", "Lcom/talabat/talabatcommon/feature/walletBanner/model/WalletBannerResponse;", "countryId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletBannerServiceImpl implements WalletBannerService {
    @NotNull
    private final WalletBannerApi walletBannerApi;

    @Inject
    public WalletBannerServiceImpl(@NotNull WalletBannerApi walletBannerApi2) {
        Intrinsics.checkNotNullParameter(walletBannerApi2, "walletBannerApi");
        this.walletBannerApi = walletBannerApi2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0059 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getWalletBanner(@org.jetbrains.annotations.NotNull java.lang.String r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.talabatcommon.feature.walletBanner.model.WalletBannerResponse> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.talabat.talabatcommon.feature.walletBanner.service.WalletBannerServiceImpl$getWalletBanner$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.talabat.talabatcommon.feature.walletBanner.service.WalletBannerServiceImpl$getWalletBanner$1 r0 = (com.talabat.talabatcommon.feature.walletBanner.service.WalletBannerServiceImpl$getWalletBanner$1) r0
            int r1 = r0.f61701j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f61701j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.talabatcommon.feature.walletBanner.service.WalletBannerServiceImpl$getWalletBanner$1 r0 = new com.talabat.talabatcommon.feature.walletBanner.service.WalletBannerServiceImpl$getWalletBanner$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f61699h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f61701j
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ all -> 0x0048 }
            goto L_0x0041
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result$Companion r6 = kotlin.Result.Companion     // Catch:{ all -> 0x0048 }
            com.talabat.talabatcommon.feature.walletBanner.service.WalletBannerApi r6 = r4.walletBannerApi     // Catch:{ all -> 0x0048 }
            r0.f61701j = r3     // Catch:{ all -> 0x0048 }
            java.lang.Object r6 = r6.getWalletBanner(r5, r0)     // Catch:{ all -> 0x0048 }
            if (r6 != r1) goto L_0x0041
            return r1
        L_0x0041:
            com.talabat.talabatcommon.feature.walletBanner.model.WalletBannerResponse r6 = (com.talabat.talabatcommon.feature.walletBanner.model.WalletBannerResponse) r6     // Catch:{ all -> 0x0048 }
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r6)     // Catch:{ all -> 0x0048 }
            goto L_0x0053
        L_0x0048:
            r5 = move-exception
            kotlin.Result$Companion r6 = kotlin.Result.Companion
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)
        L_0x0053:
            boolean r6 = kotlin.Result.m6335isFailureimpl(r5)
            if (r6 == 0) goto L_0x005a
            r5 = 0
        L_0x005a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.feature.walletBanner.service.WalletBannerServiceImpl.getWalletBanner(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
