package com.talabat.talabatcommon.feature.walletCardList;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.country.Country;
import com.talabat.talabatcommon.views.wallet.benefitmanager.domain.business.usecase.GetBenefitBinDetailUseCase;
import com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.business.GetQPayDeflectionBinsUseCase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012HBø\u0001\u0000¢\u0006\u0002\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletCardList/DebitCardDeflectionUseCase;", "", "getBenefitBinDetailUseCase", "Lcom/talabat/talabatcommon/views/wallet/benefitmanager/domain/business/usecase/GetBenefitBinDetailUseCase;", "getQPayDeflectionBinsUseCase", "Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/domain/business/GetQPayDeflectionBinsUseCase;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "(Lcom/talabat/talabatcommon/views/wallet/benefitmanager/domain/business/usecase/GetBenefitBinDetailUseCase;Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/domain/business/GetQPayDeflectionBinsUseCase;Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "getConfigurationLocalRepository", "()Lcom/talabat/configuration/ConfigurationLocalRepository;", "getGetBenefitBinDetailUseCase", "()Lcom/talabat/talabatcommon/views/wallet/benefitmanager/domain/business/usecase/GetBenefitBinDetailUseCase;", "getGetQPayDeflectionBinsUseCase", "()Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/domain/business/GetQPayDeflectionBinsUseCase;", "invoke", "Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/viewModel/DeflectionInfoDisplayModel;", "binNumbers", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DebitCardDeflectionUseCase {
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final GetBenefitBinDetailUseCase getBenefitBinDetailUseCase;
    @NotNull
    private final GetQPayDeflectionBinsUseCase getQPayDeflectionBinsUseCase;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Country.values().length];
            iArr[Country.QATAR.ordinal()] = 1;
            iArr[Country.BAHRAIN.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public DebitCardDeflectionUseCase(@NotNull GetBenefitBinDetailUseCase getBenefitBinDetailUseCase2, @NotNull GetQPayDeflectionBinsUseCase getQPayDeflectionBinsUseCase2, @NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(getBenefitBinDetailUseCase2, "getBenefitBinDetailUseCase");
        Intrinsics.checkNotNullParameter(getQPayDeflectionBinsUseCase2, "getQPayDeflectionBinsUseCase");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        this.getBenefitBinDetailUseCase = getBenefitBinDetailUseCase2;
        this.getQPayDeflectionBinsUseCase = getQPayDeflectionBinsUseCase2;
        this.configurationLocalRepository = configurationLocalRepository2;
    }

    @NotNull
    public final ConfigurationLocalRepository getConfigurationLocalRepository() {
        return this.configurationLocalRepository;
    }

    @NotNull
    public final GetBenefitBinDetailUseCase getGetBenefitBinDetailUseCase() {
        return this.getBenefitBinDetailUseCase;
    }

    @NotNull
    public final GetQPayDeflectionBinsUseCase getGetQPayDeflectionBinsUseCase() {
        return this.getQPayDeflectionBinsUseCase;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull java.lang.String r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.talabatcommon.views.wallet.cardViewWidgets.viewModel.DeflectionInfoDisplayModel> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.talabat.talabatcommon.feature.walletCardList.DebitCardDeflectionUseCase$invoke$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.talabat.talabatcommon.feature.walletCardList.DebitCardDeflectionUseCase$invoke$1 r0 = (com.talabat.talabatcommon.feature.walletCardList.DebitCardDeflectionUseCase$invoke$1) r0
            int r1 = r0.f61705k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f61705k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.talabatcommon.feature.walletCardList.DebitCardDeflectionUseCase$invoke$1 r0 = new com.talabat.talabatcommon.feature.walletCardList.DebitCardDeflectionUseCase$invoke$1
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f61703i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f61705k
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0040
            if (r2 == r4) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            java.lang.Object r7 = r0.f61702h
            com.talabat.talabatcommon.feature.walletCardList.mapper.DebitCardDeflectionMapper r7 = (com.talabat.talabatcommon.feature.walletCardList.mapper.DebitCardDeflectionMapper) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x006a
        L_0x0030:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0038:
            java.lang.Object r7 = r0.f61702h
            com.talabat.talabatcommon.feature.walletCardList.mapper.DebitCardDeflectionMapper r7 = (com.talabat.talabatcommon.feature.walletCardList.mapper.DebitCardDeflectionMapper) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0083
        L_0x0040:
            kotlin.ResultKt.throwOnFailure(r8)
            com.talabat.configuration.ConfigurationLocalRepository r8 = r6.configurationLocalRepository
            com.talabat.configuration.country.Country r8 = r8.selectedCountry()
            int[] r2 = com.talabat.talabatcommon.feature.walletCardList.DebitCardDeflectionUseCase.WhenMappings.$EnumSwitchMapping$0
            int r8 = r8.ordinal()
            r8 = r2[r8]
            if (r8 == r4) goto L_0x0071
            if (r8 == r3) goto L_0x0058
            com.talabat.talabatcommon.views.wallet.cardViewWidgets.viewModel.DeflectionInfoDisplayModel$Hidden r7 = com.talabat.talabatcommon.views.wallet.cardViewWidgets.viewModel.DeflectionInfoDisplayModel.Hidden.INSTANCE
            goto L_0x0089
        L_0x0058:
            com.talabat.talabatcommon.feature.walletCardList.mapper.DebitCardDeflectionMapper r8 = com.talabat.talabatcommon.feature.walletCardList.mapper.DebitCardDeflectionMapper.INSTANCE
            com.talabat.talabatcommon.views.wallet.benefitmanager.domain.business.usecase.GetBenefitBinDetailUseCase r2 = r6.getBenefitBinDetailUseCase
            r0.f61702h = r8
            r0.f61705k = r3
            java.lang.Object r7 = r2.invoke(r7, r0)
            if (r7 != r1) goto L_0x0067
            return r1
        L_0x0067:
            r5 = r8
            r8 = r7
            r7 = r5
        L_0x006a:
            com.talabat.talabatcommon.views.wallet.benefitmanager.domain.entity.BenefitBinsDetail r8 = (com.talabat.talabatcommon.views.wallet.benefitmanager.domain.entity.BenefitBinsDetail) r8
            com.talabat.talabatcommon.views.wallet.cardViewWidgets.viewModel.DeflectionInfoDisplayModel r7 = r7.mapBenefitBinsDetailToDeflectionInfoDisplayModel(r8)
            goto L_0x0089
        L_0x0071:
            com.talabat.talabatcommon.feature.walletCardList.mapper.DebitCardDeflectionMapper r8 = com.talabat.talabatcommon.feature.walletCardList.mapper.DebitCardDeflectionMapper.INSTANCE
            com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.business.GetQPayDeflectionBinsUseCase r2 = r6.getQPayDeflectionBinsUseCase
            r0.f61702h = r8
            r0.f61705k = r4
            java.lang.Object r7 = r2.invoke(r7, r0)
            if (r7 != r1) goto L_0x0080
            return r1
        L_0x0080:
            r5 = r8
            r8 = r7
            r7 = r5
        L_0x0083:
            com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.entity.QPayDeflectionBinDetail r8 = (com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.entity.QPayDeflectionBinDetail) r8
            com.talabat.talabatcommon.views.wallet.cardViewWidgets.viewModel.DeflectionInfoDisplayModel r7 = r7.mapQPayDeflectionBinDetailToDeflectionInfoDisplayModel(r8)
        L_0x0089:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.feature.walletCardList.DebitCardDeflectionUseCase.invoke(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
