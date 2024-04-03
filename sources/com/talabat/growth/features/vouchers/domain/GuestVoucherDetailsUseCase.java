package com.talabat.growth.features.vouchers.domain;

import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.talabatcommon.feature.vouchers.loyalty.repository.VoucherRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J!\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fHBø\u0001\u0000¢\u0006\u0002\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lcom/talabat/growth/features/vouchers/domain/GuestVoucherDetailsUseCase;", "", "voucherRepository", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/repository/VoucherRepository;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "(Lcom/talabat/talabatcommon/feature/vouchers/loyalty/repository/VoucherRepository;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "invoke", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/mapper/GuestVoucherDomainModel;", "voucherCode", "", "countryCode", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GuestVoucherDetailsUseCase {
    @NotNull
    private final IObservabilityManager observabilityManager;
    @NotNull
    private final VoucherRepository voucherRepository;

    public GuestVoucherDetailsUseCase(@NotNull VoucherRepository voucherRepository2, @NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(voucherRepository2, "voucherRepository");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        this.voucherRepository = voucherRepository2;
        this.observabilityManager = iObservabilityManager;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull java.lang.String r5, int r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.GuestVoucherDomainModel> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.talabat.growth.features.vouchers.domain.GuestVoucherDetailsUseCase$invoke$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.talabat.growth.features.vouchers.domain.GuestVoucherDetailsUseCase$invoke$1 r0 = (com.talabat.growth.features.vouchers.domain.GuestVoucherDetailsUseCase$invoke$1) r0
            int r1 = r0.f60581m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f60581m = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.growth.features.vouchers.domain.GuestVoucherDetailsUseCase$invoke$1 r0 = new com.talabat.growth.features.vouchers.domain.GuestVoucherDetailsUseCase$invoke$1
            r0.<init>(r4, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f60579k
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f60581m
            r3 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 != r3) goto L_0x0035
            int r6 = r0.f60578j
            java.lang.Object r5 = r0.f60577i
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r0 = r0.f60576h
            com.talabat.growth.features.vouchers.domain.GuestVoucherDetailsUseCase r0 = (com.talabat.growth.features.vouchers.domain.GuestVoucherDetailsUseCase) r0
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ all -> 0x0033 }
            goto L_0x0054
        L_0x0033:
            r7 = move-exception
            goto L_0x005d
        L_0x0035:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.Result$Companion r7 = kotlin.Result.Companion     // Catch:{ all -> 0x005b }
            com.talabat.talabatcommon.feature.vouchers.loyalty.repository.VoucherRepository r7 = r4.voucherRepository     // Catch:{ all -> 0x005b }
            r0.f60576h = r4     // Catch:{ all -> 0x005b }
            r0.f60577i = r5     // Catch:{ all -> 0x005b }
            r0.f60578j = r6     // Catch:{ all -> 0x005b }
            r0.f60581m = r3     // Catch:{ all -> 0x005b }
            java.lang.Object r7 = r7.getGuestVoucher(r5, r6, r0)     // Catch:{ all -> 0x005b }
            if (r7 != r1) goto L_0x0053
            return r1
        L_0x0053:
            r0 = r4
        L_0x0054:
            com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.GuestVoucherDomainModel r7 = (com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.GuestVoucherDomainModel) r7     // Catch:{ all -> 0x0033 }
            java.lang.Object r7 = kotlin.Result.m6329constructorimpl(r7)     // Catch:{ all -> 0x0033 }
            goto L_0x0067
        L_0x005b:
            r7 = move-exception
            r0 = r4
        L_0x005d:
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r7 = kotlin.ResultKt.createFailure(r7)
            java.lang.Object r7 = kotlin.Result.m6329constructorimpl(r7)
        L_0x0067:
            java.lang.Throwable r1 = kotlin.Result.m6332exceptionOrNullimpl(r7)
            if (r1 == 0) goto L_0x0090
            com.talabat.core.observabilityNew.domain.IObservabilityManager r7 = r0.observabilityManager
            java.lang.String r0 = r1.getMessage()
            if (r0 != 0) goto L_0x007b
            kotlin.jvm.internal.StringCompanionObject r0 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r0 = com.talabat.talabatcommon.extentions.StringUtils.empty(r0)
        L_0x007b:
            java.lang.String r6 = java.lang.String.valueOf(r6)
            com.talabat.talabatcommon.feature.vouchers.loyalty.tracking.ObservabilityManagerUtilKt.observeFailToGetGuestVoucherDetails(r7, r0, r5, r6)
            com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.VoucherFailures$FailToLoadGuestVoucher r5 = new com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.VoucherFailures$FailToLoadGuestVoucher
            boolean r6 = r1 instanceof com.talabat.talabatcore.exception.Failure
            if (r6 == 0) goto L_0x008b
            com.talabat.talabatcore.exception.Failure r1 = (com.talabat.talabatcore.exception.Failure) r1
            goto L_0x008c
        L_0x008b:
            r1 = 0
        L_0x008c:
            r5.<init>(r1)
            throw r5
        L_0x0090:
            kotlin.ResultKt.throwOnFailure(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.growth.features.vouchers.domain.GuestVoucherDetailsUseCase.invoke(java.lang.String, int, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
