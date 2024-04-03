package com.talabat.talabatcommon.feature.vouchers.loyalty.domain;

import com.talabat.talabatcommon.feature.vouchers.loyalty.repository.VoucherRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bHBø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/GuestWelcomeVoucherUseCase;", "", "voucherRepository", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/repository/VoucherRepository;", "(Lcom/talabat/talabatcommon/feature/vouchers/loyalty/repository/VoucherRepository;)V", "invoke", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/mapper/GuestWelcomeVoucherDomainModel;", "countryCode", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GuestWelcomeVoucherUseCase {
    @NotNull
    private final VoucherRepository voucherRepository;

    public GuestWelcomeVoucherUseCase(@NotNull VoucherRepository voucherRepository2) {
        Intrinsics.checkNotNullParameter(voucherRepository2, "voucherRepository");
        this.voucherRepository = voucherRepository2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke(int r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.GuestWelcomeVoucherDomainModel> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.talabat.talabatcommon.feature.vouchers.loyalty.domain.GuestWelcomeVoucherUseCase$invoke$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.talabat.talabatcommon.feature.vouchers.loyalty.domain.GuestWelcomeVoucherUseCase$invoke$1 r0 = (com.talabat.talabatcommon.feature.vouchers.loyalty.domain.GuestWelcomeVoucherUseCase$invoke$1) r0
            int r1 = r0.f61619k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f61619k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.talabatcommon.feature.vouchers.loyalty.domain.GuestWelcomeVoucherUseCase$invoke$1 r0 = new com.talabat.talabatcommon.feature.vouchers.loyalty.domain.GuestWelcomeVoucherUseCase$invoke$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f61617i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f61619k
            r3 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            int r5 = r0.f61616h
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ all -> 0x004c }
            goto L_0x0045
        L_0x002b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result$Companion r6 = kotlin.Result.Companion     // Catch:{ all -> 0x004c }
            com.talabat.talabatcommon.feature.vouchers.loyalty.repository.VoucherRepository r6 = r4.voucherRepository     // Catch:{ all -> 0x004c }
            r0.f61616h = r5     // Catch:{ all -> 0x004c }
            r0.f61619k = r3     // Catch:{ all -> 0x004c }
            java.lang.Object r6 = r6.getGuestWelcomeVoucher(r5, r0)     // Catch:{ all -> 0x004c }
            if (r6 != r1) goto L_0x0045
            return r1
        L_0x0045:
            com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.GuestWelcomeVoucherDomainModel r6 = (com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.GuestWelcomeVoucherDomainModel) r6     // Catch:{ all -> 0x004c }
            java.lang.Object r6 = kotlin.Result.m6329constructorimpl(r6)     // Catch:{ all -> 0x004c }
            goto L_0x0057
        L_0x004c:
            r6 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r6 = kotlin.ResultKt.createFailure(r6)
            java.lang.Object r6 = kotlin.Result.m6329constructorimpl(r6)
        L_0x0057:
            java.lang.Throwable r0 = kotlin.Result.m6332exceptionOrNullimpl(r6)
            if (r0 != 0) goto L_0x005e
            return r6
        L_0x005e:
            java.lang.String r6 = r0.getMessage()
            if (r6 != 0) goto L_0x006a
            kotlin.jvm.internal.StringCompanionObject r6 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r6 = com.talabat.talabatcommon.extentions.StringUtils.empty(r6)
        L_0x006a:
            java.lang.String r5 = java.lang.String.valueOf(r5)
            com.talabat.talabatcommon.feature.vouchers.loyalty.tracking.ObservabilityManagerUtilKt.observeFailToGetGuestWelcomeVoucherDetails(r6, r5)
            com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.VoucherFailures$FailToLoadGuestVoucher r5 = new com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.VoucherFailures$FailToLoadGuestVoucher
            boolean r6 = r0 instanceof com.talabat.talabatcore.exception.Failure
            if (r6 == 0) goto L_0x007a
            com.talabat.talabatcore.exception.Failure r0 = (com.talabat.talabatcore.exception.Failure) r0
            goto L_0x007b
        L_0x007a:
            r0 = 0
        L_0x007b:
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.feature.vouchers.loyalty.domain.GuestWelcomeVoucherUseCase.invoke(int, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
