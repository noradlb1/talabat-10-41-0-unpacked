package com.talabat.wallet.debitcarddeflection.domain.business;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.talabatcommon.views.wallet.benefitmanager.domain.business.usecase.GetBenefitBinDetailUseCase;
import com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.business.GetQPayDeflectionSavedCardUseCase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fHBø\u0001\u0000¢\u0006\u0002\u0010\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lcom/talabat/wallet/debitcarddeflection/domain/business/GetBinsDetailDisplayModelUseCase;", "", "getBenefitBinDetailUseCase", "Lcom/talabat/talabatcommon/views/wallet/benefitmanager/domain/business/usecase/GetBenefitBinDetailUseCase;", "getQPayDeflectionBinsUseCase", "Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/domain/business/GetQPayDeflectionSavedCardUseCase;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "(Lcom/talabat/talabatcommon/views/wallet/benefitmanager/domain/business/usecase/GetBenefitBinDetailUseCase;Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/domain/business/GetQPayDeflectionSavedCardUseCase;Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "invoke", "Lcom/talabat/talabatcommon/views/wallet/debitcarddeflection/presentation/displaymodel/DebitCardBinsDetailDisplayModel;", "binNumber", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetBinsDetailDisplayModelUseCase {
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final GetBenefitBinDetailUseCase getBenefitBinDetailUseCase;
    @NotNull
    private final GetQPayDeflectionSavedCardUseCase getQPayDeflectionBinsUseCase;

    public GetBinsDetailDisplayModelUseCase(@NotNull GetBenefitBinDetailUseCase getBenefitBinDetailUseCase2, @NotNull GetQPayDeflectionSavedCardUseCase getQPayDeflectionSavedCardUseCase, @NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(getBenefitBinDetailUseCase2, "getBenefitBinDetailUseCase");
        Intrinsics.checkNotNullParameter(getQPayDeflectionSavedCardUseCase, "getQPayDeflectionBinsUseCase");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        this.getBenefitBinDetailUseCase = getBenefitBinDetailUseCase2;
        this.getQPayDeflectionBinsUseCase = getQPayDeflectionSavedCardUseCase;
        this.configurationLocalRepository = configurationLocalRepository2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull java.lang.String r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.talabatcommon.views.wallet.debitcarddeflection.presentation.displaymodel.DebitCardBinsDetailDisplayModel> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.talabat.wallet.debitcarddeflection.domain.business.GetBinsDetailDisplayModelUseCase$invoke$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.talabat.wallet.debitcarddeflection.domain.business.GetBinsDetailDisplayModelUseCase$invoke$1 r0 = (com.talabat.wallet.debitcarddeflection.domain.business.GetBinsDetailDisplayModelUseCase$invoke$1) r0
            int r1 = r0.f12569k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f12569k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.wallet.debitcarddeflection.domain.business.GetBinsDetailDisplayModelUseCase$invoke$1 r0 = new com.talabat.wallet.debitcarddeflection.domain.business.GetBinsDetailDisplayModelUseCase$invoke$1
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f12567i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f12569k
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0040
            if (r2 == r4) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            java.lang.Object r7 = r0.f12566h
            com.talabat.talabatcommon.views.wallet.debitcarddeflection.presentation.viewmodel.mapper.DebitCardBinsDetailDisplayModelMapper r7 = (com.talabat.talabatcommon.views.wallet.debitcarddeflection.presentation.viewmodel.mapper.DebitCardBinsDetailDisplayModelMapper) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x007e
        L_0x0030:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0038:
            java.lang.Object r7 = r0.f12566h
            com.talabat.talabatcommon.views.wallet.debitcarddeflection.presentation.viewmodel.mapper.DebitCardBinsDetailDisplayModelMapper r7 = (com.talabat.talabatcommon.views.wallet.debitcarddeflection.presentation.viewmodel.mapper.DebitCardBinsDetailDisplayModelMapper) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0065
        L_0x0040:
            kotlin.ResultKt.throwOnFailure(r8)
            com.talabat.configuration.ConfigurationLocalRepository r8 = r6.configurationLocalRepository
            com.talabat.configuration.country.Country r8 = r8.selectedCountry()
            int r8 = r8.getCountryId()
            com.talabat.configuration.country.Country r2 = com.talabat.configuration.country.Country.QATAR
            int r2 = r2.getCountryId()
            if (r8 != r2) goto L_0x006c
            com.talabat.talabatcommon.views.wallet.debitcarddeflection.presentation.viewmodel.mapper.DebitCardBinsDetailDisplayModelMapper r7 = com.talabat.talabatcommon.views.wallet.debitcarddeflection.presentation.viewmodel.mapper.DebitCardBinsDetailDisplayModelMapper.INSTANCE
            com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.business.GetQPayDeflectionSavedCardUseCase r8 = r6.getQPayDeflectionBinsUseCase
            r0.f12566h = r7
            r0.f12569k = r4
            r2 = 0
            java.lang.Object r8 = r8.invoke(r2, r0)
            if (r8 != r1) goto L_0x0065
            return r1
        L_0x0065:
            com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.entity.QPayDeflectionBinDetail r8 = (com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.entity.QPayDeflectionBinDetail) r8
            com.talabat.talabatcommon.views.wallet.debitcarddeflection.presentation.displaymodel.DebitCardBinsDetailDisplayModel r7 = r7.mapToQPayBinsDetailDisplayModel(r8)
            goto L_0x0084
        L_0x006c:
            com.talabat.talabatcommon.views.wallet.debitcarddeflection.presentation.viewmodel.mapper.DebitCardBinsDetailDisplayModelMapper r8 = com.talabat.talabatcommon.views.wallet.debitcarddeflection.presentation.viewmodel.mapper.DebitCardBinsDetailDisplayModelMapper.INSTANCE
            com.talabat.talabatcommon.views.wallet.benefitmanager.domain.business.usecase.GetBenefitBinDetailUseCase r2 = r6.getBenefitBinDetailUseCase
            r0.f12566h = r8
            r0.f12569k = r3
            java.lang.Object r7 = r2.invoke(r7, r0)
            if (r7 != r1) goto L_0x007b
            return r1
        L_0x007b:
            r5 = r8
            r8 = r7
            r7 = r5
        L_0x007e:
            com.talabat.talabatcommon.views.wallet.benefitmanager.domain.entity.BenefitBinsDetail r8 = (com.talabat.talabatcommon.views.wallet.benefitmanager.domain.entity.BenefitBinsDetail) r8
            com.talabat.talabatcommon.views.wallet.debitcarddeflection.presentation.displaymodel.DebitCardBinsDetailDisplayModel r7 = r7.mapToBenefitBinsDetailDisplayModel(r8)
        L_0x0084:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.wallet.debitcarddeflection.domain.business.GetBinsDetailDisplayModelUseCase.invoke(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
