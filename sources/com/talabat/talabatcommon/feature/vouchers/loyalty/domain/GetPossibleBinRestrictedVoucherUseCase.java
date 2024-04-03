package com.talabat.talabatcommon.feature.vouchers.loyalty.domain;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.talabatcommon.feature.vouchers.loyalty.repository.VoucherRepository;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J9\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\rHBø\u0001\u0000¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/GetPossibleBinRestrictedVoucherUseCase;", "", "voucherRepository", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/repository/VoucherRepository;", "featureFlagRepo", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "(Lcom/talabat/talabatcommon/feature/vouchers/loyalty/repository/VoucherRepository;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "invoke", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/mapper/BinRestrictedVoucherModel;", "customerVoucherId", "", "brandId", "areaId", "", "verticalId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetPossibleBinRestrictedVoucherUseCase {
    @NotNull
    private final ITalabatFeatureFlag featureFlagRepo;
    @NotNull
    private final VoucherRepository voucherRepository;

    public GetPossibleBinRestrictedVoucherUseCase(@NotNull VoucherRepository voucherRepository2, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(voucherRepository2, "voucherRepository");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlagRepo");
        this.voucherRepository = voucherRepository2;
        this.featureFlagRepo = iTalabatFeatureFlag;
    }

    public static /* synthetic */ Object invoke$default(GetPossibleBinRestrictedVoucherUseCase getPossibleBinRestrictedVoucherUseCase, String str, String str2, Integer num, int i11, Continuation continuation, int i12, Object obj) {
        return getPossibleBinRestrictedVoucherUseCase.invoke(str, (i12 & 2) != 0 ? null : str2, (i12 & 4) != 0 ? null : num, i11, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x008a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull java.lang.String r8, @org.jetbrains.annotations.Nullable java.lang.String r9, @org.jetbrains.annotations.Nullable java.lang.Integer r10, int r11, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.BinRestrictedVoucherModel> r12) {
        /*
            r7 = this;
            boolean r0 = r12 instanceof com.talabat.talabatcommon.feature.vouchers.loyalty.domain.GetPossibleBinRestrictedVoucherUseCase$invoke$1
            if (r0 == 0) goto L_0x0013
            r0 = r12
            com.talabat.talabatcommon.feature.vouchers.loyalty.domain.GetPossibleBinRestrictedVoucherUseCase$invoke$1 r0 = (com.talabat.talabatcommon.feature.vouchers.loyalty.domain.GetPossibleBinRestrictedVoucherUseCase$invoke$1) r0
            int r1 = r0.f61615k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f61615k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.talabatcommon.feature.vouchers.loyalty.domain.GetPossibleBinRestrictedVoucherUseCase$invoke$1 r0 = new com.talabat.talabatcommon.feature.vouchers.loyalty.domain.GetPossibleBinRestrictedVoucherUseCase$invoke$1
            r0.<init>(r7, r12)
        L_0x0018:
            r6 = r0
            java.lang.Object r12 = r6.f61613i
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.f61615k
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0041
            if (r1 == r3) goto L_0x0039
            if (r1 != r2) goto L_0x0031
            java.lang.Object r8 = r6.f61612h
            java.lang.String r8 = (java.lang.String) r8
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x0079 }
            goto L_0x0072
        L_0x0031:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0039:
            java.lang.Object r8 = r6.f61612h
            java.lang.String r8 = (java.lang.String) r8
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x0079 }
            goto L_0x0062
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r12)
            kotlin.Result$Companion r12 = kotlin.Result.Companion     // Catch:{ all -> 0x0079 }
            com.talabat.core.featureflag.domain.ITalabatFeatureFlag r12 = r7.featureFlagRepo     // Catch:{ all -> 0x0079 }
            com.talabat.core.fwfprojectskeys.domain.projects.home.HomePageFeatureFlagsKeys r1 = com.talabat.core.fwfprojectskeys.domain.projects.home.HomePageFeatureFlagsKeys.INCENTIVES_REFER_A_FRIEND     // Catch:{ all -> 0x0079 }
            r4 = 0
            boolean r12 = r12.getFeatureFlag(r1, r4)     // Catch:{ all -> 0x0079 }
            if (r12 == 0) goto L_0x0065
            com.talabat.talabatcommon.feature.vouchers.loyalty.repository.VoucherRepository r1 = r7.voucherRepository     // Catch:{ all -> 0x0079 }
            r6.f61612h = r8     // Catch:{ all -> 0x0079 }
            r6.f61615k = r3     // Catch:{ all -> 0x0079 }
            r2 = r8
            r3 = r9
            r4 = r10
            r5 = r11
            java.lang.Object r12 = r1.applyPromoCode(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0079 }
            if (r12 != r0) goto L_0x0062
            return r0
        L_0x0062:
            com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.BinRestrictedVoucherModel r12 = (com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.BinRestrictedVoucherModel) r12     // Catch:{ all -> 0x0079 }
            goto L_0x0074
        L_0x0065:
            com.talabat.talabatcommon.feature.vouchers.loyalty.repository.VoucherRepository r9 = r7.voucherRepository     // Catch:{ all -> 0x0079 }
            r6.f61612h = r8     // Catch:{ all -> 0x0079 }
            r6.f61615k = r2     // Catch:{ all -> 0x0079 }
            java.lang.Object r12 = r9.getBinRestrictedVoucher(r8, r6)     // Catch:{ all -> 0x0079 }
            if (r12 != r0) goto L_0x0072
            return r0
        L_0x0072:
            com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.BinRestrictedVoucherModel r12 = (com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.BinRestrictedVoucherModel) r12     // Catch:{ all -> 0x0079 }
        L_0x0074:
            java.lang.Object r9 = kotlin.Result.m6329constructorimpl(r12)     // Catch:{ all -> 0x0079 }
            goto L_0x0084
        L_0x0079:
            r9 = move-exception
            kotlin.Result$Companion r10 = kotlin.Result.Companion
            java.lang.Object r9 = kotlin.ResultKt.createFailure(r9)
            java.lang.Object r9 = kotlin.Result.m6329constructorimpl(r9)
        L_0x0084:
            java.lang.Throwable r10 = kotlin.Result.m6332exceptionOrNullimpl(r9)
            if (r10 != 0) goto L_0x008b
            return r9
        L_0x008b:
            java.lang.String r9 = r10.getMessage()
            if (r9 != 0) goto L_0x0097
            kotlin.jvm.internal.StringCompanionObject r9 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r9 = com.talabat.talabatcommon.extentions.StringUtils.empty(r9)
        L_0x0097:
            com.talabat.talabatcommon.feature.vouchers.loyalty.tracking.ObservabilityManagerUtilKt.observeFailToGetPossibleBinRestrictedVoucher(r9, r8)
            com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.VoucherFailures$FailToLoadPotentialBinRestrictedVoucher r8 = new com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.VoucherFailures$FailToLoadPotentialBinRestrictedVoucher
            boolean r9 = r10 instanceof com.talabat.talabatcore.exception.Failure
            if (r9 == 0) goto L_0x00a3
            com.talabat.talabatcore.exception.Failure r10 = (com.talabat.talabatcore.exception.Failure) r10
            goto L_0x00a4
        L_0x00a3:
            r10 = 0
        L_0x00a4:
            r8.<init>(r10)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.feature.vouchers.loyalty.domain.GetPossibleBinRestrictedVoucherUseCase.invoke(java.lang.String, java.lang.String, java.lang.Integer, int, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
