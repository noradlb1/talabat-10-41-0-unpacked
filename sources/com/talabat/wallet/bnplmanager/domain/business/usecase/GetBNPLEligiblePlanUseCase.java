package com.talabat.wallet.bnplmanager.domain.business.usecase;

import com.talabat.wallet.bnplmanager.domain.application.usecase.GetBnplFeatureFlagUseCase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.login.domain.repository.CustomerRepository;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eHBø\u0001\u0000¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lcom/talabat/wallet/bnplmanager/domain/business/usecase/GetBNPLEligiblePlanUseCase;", "", "getBnplFeatureFlagUseCase", "Lcom/talabat/wallet/bnplmanager/domain/application/usecase/GetBnplFeatureFlagUseCase;", "customerRepository", "Llibrary/talabat/mvp/login/domain/repository/CustomerRepository;", "getBNPLEligibilityUseCase", "Lcom/talabat/wallet/bnplmanager/domain/business/usecase/GetBNPLEligibilityUseCase;", "getBNPLPlansUseCase", "Lcom/talabat/wallet/bnplmanager/domain/business/usecase/GetBNPLPlansUseCase;", "(Lcom/talabat/wallet/bnplmanager/domain/application/usecase/GetBnplFeatureFlagUseCase;Llibrary/talabat/mvp/login/domain/repository/CustomerRepository;Lcom/talabat/wallet/bnplmanager/domain/business/usecase/GetBNPLEligibilityUseCase;Lcom/talabat/wallet/bnplmanager/domain/business/usecase/GetBNPLPlansUseCase;)V", "invoke", "Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLEligiblePlanDetail;", "bNPLEligibilityRequestDto", "Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLEligibilityRequestDto;", "(Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLEligibilityRequestDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetBNPLEligiblePlanUseCase {
    @NotNull
    private final CustomerRepository customerRepository;
    @NotNull
    private final GetBNPLEligibilityUseCase getBNPLEligibilityUseCase;
    @NotNull
    private final GetBNPLPlansUseCase getBNPLPlansUseCase;
    @NotNull
    private final GetBnplFeatureFlagUseCase getBnplFeatureFlagUseCase;

    public GetBNPLEligiblePlanUseCase(@NotNull GetBnplFeatureFlagUseCase getBnplFeatureFlagUseCase2, @NotNull CustomerRepository customerRepository2, @NotNull GetBNPLEligibilityUseCase getBNPLEligibilityUseCase2, @NotNull GetBNPLPlansUseCase getBNPLPlansUseCase2) {
        Intrinsics.checkNotNullParameter(getBnplFeatureFlagUseCase2, "getBnplFeatureFlagUseCase");
        Intrinsics.checkNotNullParameter(customerRepository2, "customerRepository");
        Intrinsics.checkNotNullParameter(getBNPLEligibilityUseCase2, "getBNPLEligibilityUseCase");
        Intrinsics.checkNotNullParameter(getBNPLPlansUseCase2, "getBNPLPlansUseCase");
        this.getBnplFeatureFlagUseCase = getBnplFeatureFlagUseCase2;
        this.customerRepository = customerRepository2;
        this.getBNPLEligibilityUseCase = getBNPLEligibilityUseCase2;
        this.getBNPLPlansUseCase = getBNPLPlansUseCase2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0086 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull com.talabat.wallet.bnplmanager.data.remote.dto.BNPLEligibilityRequestDto r10, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.wallet.bnplmanager.domain.entity.BNPLEligiblePlanDetail> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof com.talabat.wallet.bnplmanager.domain.business.usecase.GetBNPLEligiblePlanUseCase$invoke$1
            if (r0 == 0) goto L_0x0013
            r0 = r11
            com.talabat.wallet.bnplmanager.domain.business.usecase.GetBNPLEligiblePlanUseCase$invoke$1 r0 = (com.talabat.wallet.bnplmanager.domain.business.usecase.GetBNPLEligiblePlanUseCase$invoke$1) r0
            int r1 = r0.f12475l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f12475l = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.wallet.bnplmanager.domain.business.usecase.GetBNPLEligiblePlanUseCase$invoke$1 r0 = new com.talabat.wallet.bnplmanager.domain.business.usecase.GetBNPLEligiblePlanUseCase$invoke$1
            r0.<init>(r9, r11)
        L_0x0018:
            java.lang.Object r11 = r0.f12473j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f12475l
            r3 = 0
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L_0x0059
            if (r2 == r6) goto L_0x004d
            if (r2 == r5) goto L_0x0041
            if (r2 != r4) goto L_0x0039
            java.lang.Object r10 = r0.f12472i
            com.talabat.wallet.bnplmanager.domain.entity.BNPLEligibilityDetail r10 = (com.talabat.wallet.bnplmanager.domain.entity.BNPLEligibilityDetail) r10
            java.lang.Object r0 = r0.f12471h
            com.talabat.wallet.bnplmanager.domain.entity.BNPLEligiblePlanDetail r0 = (com.talabat.wallet.bnplmanager.domain.entity.BNPLEligiblePlanDetail) r0
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00b2
        L_0x0039:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0041:
            java.lang.Object r10 = r0.f12472i
            com.talabat.wallet.bnplmanager.domain.entity.BNPLEligiblePlanDetail r10 = (com.talabat.wallet.bnplmanager.domain.entity.BNPLEligiblePlanDetail) r10
            java.lang.Object r2 = r0.f12471h
            com.talabat.wallet.bnplmanager.domain.business.usecase.GetBNPLEligiblePlanUseCase r2 = (com.talabat.wallet.bnplmanager.domain.business.usecase.GetBNPLEligiblePlanUseCase) r2
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0097
        L_0x004d:
            java.lang.Object r10 = r0.f12472i
            com.talabat.wallet.bnplmanager.data.remote.dto.BNPLEligibilityRequestDto r10 = (com.talabat.wallet.bnplmanager.data.remote.dto.BNPLEligibilityRequestDto) r10
            java.lang.Object r2 = r0.f12471h
            com.talabat.wallet.bnplmanager.domain.business.usecase.GetBNPLEligiblePlanUseCase r2 = (com.talabat.wallet.bnplmanager.domain.business.usecase.GetBNPLEligiblePlanUseCase) r2
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x006c
        L_0x0059:
            kotlin.ResultKt.throwOnFailure(r11)
            com.talabat.wallet.bnplmanager.domain.application.usecase.GetBnplFeatureFlagUseCase r11 = r9.getBnplFeatureFlagUseCase
            r0.f12471h = r9
            r0.f12472i = r10
            r0.f12475l = r6
            java.lang.Object r11 = r11.invoke(r0)
            if (r11 != r1) goto L_0x006b
            return r1
        L_0x006b:
            r2 = r9
        L_0x006c:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            com.talabat.wallet.bnplmanager.domain.entity.BNPLEligiblePlanDetail r7 = new com.talabat.wallet.bnplmanager.domain.entity.BNPLEligiblePlanDetail
            r7.<init>()
            if (r11 == 0) goto L_0x0083
            library.talabat.mvp.login.domain.repository.CustomerRepository r11 = r2.customerRepository
            boolean r11 = r11.isLoggedIn()
            if (r11 == 0) goto L_0x0083
            r11 = r6
            goto L_0x0084
        L_0x0083:
            r11 = r3
        L_0x0084:
            if (r11 != 0) goto L_0x0087
            return r7
        L_0x0087:
            com.talabat.wallet.bnplmanager.domain.business.usecase.GetBNPLEligibilityUseCase r11 = r2.getBNPLEligibilityUseCase
            r0.f12471h = r2
            r0.f12472i = r7
            r0.f12475l = r5
            java.lang.Object r11 = r11.invoke(r10, r0)
            if (r11 != r1) goto L_0x0096
            return r1
        L_0x0096:
            r10 = r7
        L_0x0097:
            com.talabat.wallet.bnplmanager.domain.entity.BNPLEligibilityDetail r11 = (com.talabat.wallet.bnplmanager.domain.entity.BNPLEligibilityDetail) r11
            boolean r5 = r11.isHideBNPLPaymentMethod()
            if (r5 != 0) goto L_0x00e5
            com.talabat.wallet.bnplmanager.domain.business.usecase.GetBNPLPlansUseCase r2 = r2.getBNPLPlansUseCase
            r0.f12471h = r10
            r0.f12472i = r11
            r0.f12475l = r4
            java.lang.Object r0 = r2.invoke(r0)
            if (r0 != r1) goto L_0x00ae
            return r1
        L_0x00ae:
            r8 = r0
            r0 = r10
            r10 = r11
            r11 = r8
        L_0x00b2:
            java.util.List r11 = (java.util.List) r11
            r1 = r11
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            r1 = r1 ^ r6
            if (r1 == 0) goto L_0x00e4
            com.talabat.wallet.bnplmanager.domain.entity.BNPLEligibilityDetail r1 = r0.getBNPLEligibilityDetail()
            boolean r2 = r10.isBNPLEligible()
            r1.setBNPLEligible(r2)
            com.talabat.wallet.bnplmanager.domain.entity.BNPLEligibilityDetail r1 = r0.getBNPLEligibilityDetail()
            r1.setHideBNPLPaymentMethod(r3)
            com.talabat.wallet.bnplmanager.domain.entity.BNPLEligibilityDetail r1 = r0.getBNPLEligibilityDetail()
            com.talabat.wallet.bnplmanager.domain.entity.BNPLValidationError r10 = r10.getBNPLValidationError()
            r1.setBNPLValidationError(r10)
            java.lang.Object r10 = kotlin.collections.CollectionsKt___CollectionsKt.first(r11)
            com.talabat.wallet.bnplmanager.domain.entity.BNPLPlan r10 = (com.talabat.wallet.bnplmanager.domain.entity.BNPLPlan) r10
            r0.setBNPLPlan(r10)
        L_0x00e4:
            r10 = r0
        L_0x00e5:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.wallet.bnplmanager.domain.business.usecase.GetBNPLEligiblePlanUseCase.invoke(com.talabat.wallet.bnplmanager.data.remote.dto.BNPLEligibilityRequestDto, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
