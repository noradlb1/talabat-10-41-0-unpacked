package com.talabat.wallet.checkoutpaymentmanager.domain.business.usecase;

import buisnessmodels.Cart;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.talabatcommon.views.wallet.benefitmanager.domain.business.usecase.GetBenefitBinDetailUseCase;
import com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.business.GetQPayDeflectionSavedCardUseCase;
import com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.business.IsQPayServiceDownUseCase;
import com.talabat.wallet.checkoutpaymentmanager.domain.application.usecase.GetCheckoutTimeOutVariationUseCase;
import com.talabat.wallet.checkoutpaymentmanager.domain.entity.CheckoutPaymentUpdateResult;
import com.talabat.wallet.knetStatusManager.domain.business.usecase.GetKNetStatusUseCase;
import com.talabat.wallet.qPayManager.domain.business.usecase.GetQPayEnabledUseCase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J*\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J;\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cHBø\u0001\u0000¢\u0006\u0002\u0010 R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"Lcom/talabat/wallet/checkoutpaymentmanager/domain/business/usecase/GetPaymentMethodUpdate;", "", "getQPayDeflectionSavedCardUseCase", "Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/domain/business/GetQPayDeflectionSavedCardUseCase;", "getKNetStatusUseCase", "Lcom/talabat/wallet/knetStatusManager/domain/business/usecase/GetKNetStatusUseCase;", "getCheckoutTimeOutVariationUseCase", "Lcom/talabat/wallet/checkoutpaymentmanager/domain/application/usecase/GetCheckoutTimeOutVariationUseCase;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "checkoutTracker", "Lcom/talabat/wallet/checkoutpaymentmanager/domain/business/usecase/CheckoutTracker;", "getBenefitBinDetailUseCase", "Lcom/talabat/talabatcommon/views/wallet/benefitmanager/domain/business/usecase/GetBenefitBinDetailUseCase;", "getQPayEnabledUseCase", "Lcom/talabat/wallet/qPayManager/domain/business/usecase/GetQPayEnabledUseCase;", "isQPayServiceDownUseCase", "Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/domain/business/IsQPayServiceDownUseCase;", "(Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/domain/business/GetQPayDeflectionSavedCardUseCase;Lcom/talabat/wallet/knetStatusManager/domain/business/usecase/GetKNetStatusUseCase;Lcom/talabat/wallet/checkoutpaymentmanager/domain/application/usecase/GetCheckoutTimeOutVariationUseCase;Lcom/talabat/configuration/ConfigurationLocalRepository;Lcom/talabat/wallet/checkoutpaymentmanager/domain/business/usecase/CheckoutTracker;Lcom/talabat/talabatcommon/views/wallet/benefitmanager/domain/business/usecase/GetBenefitBinDetailUseCase;Lcom/talabat/wallet/qPayManager/domain/business/usecase/GetQPayEnabledUseCase;Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/domain/business/IsQPayServiceDownUseCase;)V", "addCheckoutLoadedTracking", "", "cart", "Lbuisnessmodels/Cart;", "defaultPaymentMethod", "", "checkoutPaymentUpdateResult", "Lcom/talabat/wallet/checkoutpaymentmanager/domain/entity/CheckoutPaymentUpdateResult;", "isHideBNPLPaymentMethod", "", "invoke", "isDebitCardAccepted", "bins", "(ZLbuisnessmodels/Cart;Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetPaymentMethodUpdate {
    @NotNull
    private final CheckoutTracker checkoutTracker;
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final GetBenefitBinDetailUseCase getBenefitBinDetailUseCase;
    @NotNull
    private final GetCheckoutTimeOutVariationUseCase getCheckoutTimeOutVariationUseCase;
    @NotNull
    private final GetKNetStatusUseCase getKNetStatusUseCase;
    @NotNull
    private final GetQPayDeflectionSavedCardUseCase getQPayDeflectionSavedCardUseCase;
    @NotNull
    private final GetQPayEnabledUseCase getQPayEnabledUseCase;
    @NotNull
    private final IsQPayServiceDownUseCase isQPayServiceDownUseCase;

    public GetPaymentMethodUpdate(@NotNull GetQPayDeflectionSavedCardUseCase getQPayDeflectionSavedCardUseCase2, @NotNull GetKNetStatusUseCase getKNetStatusUseCase2, @NotNull GetCheckoutTimeOutVariationUseCase getCheckoutTimeOutVariationUseCase2, @NotNull ConfigurationLocalRepository configurationLocalRepository2, @NotNull CheckoutTracker checkoutTracker2, @NotNull GetBenefitBinDetailUseCase getBenefitBinDetailUseCase2, @NotNull GetQPayEnabledUseCase getQPayEnabledUseCase2, @NotNull IsQPayServiceDownUseCase isQPayServiceDownUseCase2) {
        Intrinsics.checkNotNullParameter(getQPayDeflectionSavedCardUseCase2, "getQPayDeflectionSavedCardUseCase");
        Intrinsics.checkNotNullParameter(getKNetStatusUseCase2, "getKNetStatusUseCase");
        Intrinsics.checkNotNullParameter(getCheckoutTimeOutVariationUseCase2, "getCheckoutTimeOutVariationUseCase");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(checkoutTracker2, "checkoutTracker");
        Intrinsics.checkNotNullParameter(getBenefitBinDetailUseCase2, "getBenefitBinDetailUseCase");
        Intrinsics.checkNotNullParameter(getQPayEnabledUseCase2, "getQPayEnabledUseCase");
        Intrinsics.checkNotNullParameter(isQPayServiceDownUseCase2, "isQPayServiceDownUseCase");
        this.getQPayDeflectionSavedCardUseCase = getQPayDeflectionSavedCardUseCase2;
        this.getKNetStatusUseCase = getKNetStatusUseCase2;
        this.getCheckoutTimeOutVariationUseCase = getCheckoutTimeOutVariationUseCase2;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.checkoutTracker = checkoutTracker2;
        this.getBenefitBinDetailUseCase = getBenefitBinDetailUseCase2;
        this.getQPayEnabledUseCase = getQPayEnabledUseCase2;
        this.isQPayServiceDownUseCase = isQPayServiceDownUseCase2;
    }

    private final void addCheckoutLoadedTracking(Cart cart, String str, CheckoutPaymentUpdateResult checkoutPaymentUpdateResult, boolean z11) {
        if (checkoutPaymentUpdateResult instanceof CheckoutPaymentUpdateResult.KNetIsUnAvailable) {
            this.checkoutTracker.onCheckoutLoaded(cart, str, true, z11, checkoutPaymentUpdateResult);
        } else if (checkoutPaymentUpdateResult instanceof CheckoutPaymentUpdateResult.KNetIsAvailable) {
            this.checkoutTracker.onCheckoutLoaded(cart, GetPaymentMethodUpdateKt.KNET, false, z11, checkoutPaymentUpdateResult);
        } else {
            this.checkoutTracker.onCheckoutLoaded(cart, str, false, z11, checkoutPaymentUpdateResult);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v14, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v15, resolved type: java.lang.String} */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0087, code lost:
        r8 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00da, code lost:
        r2 = r11.configurationLocalRepository.selectedCountry().getCountryId();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00ea, code lost:
        if (r2 != com.talabat.talabatcore.model.TalabatCountry.KUWAIT.getCountryId()) goto L_0x0115;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00ec, code lost:
        r10 = com.talabat.wallet.checkoutpaymentmanager.domain.entity.mapper.CheckoutPaymentUpdateResultMapper.INSTANCE;
        r2 = r11.getKNetStatusUseCase;
        r0.f12541h = r11;
        r0.f12542i = r8;
        r0.f12543j = r9;
        r0.f12544k = r10;
        r0.f12545l = r12;
        r0.f12550q = 2;
        r7 = r2.invoke(r7, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0101, code lost:
        if (r7 != r1) goto L_0x0104;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0103, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0104, code lost:
        r4 = r12;
        r12 = r7;
        r7 = r4;
        r5 = r10;
        r10 = r8;
        r8 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x010a, code lost:
        r8 = r8.mapKNetStatusToCheckoutPaymentUpdateResult((com.talabat.wallet.knetStatusManager.domain.entity.KNetStatusResult) r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0110, code lost:
        r12 = r7;
        r2 = r11;
        r11 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x011b, code lost:
        if (r2 != com.talabat.talabatcore.model.TalabatCountry.QATAR.getCountryId()) goto L_0x01af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x011d, code lost:
        r10 = r11.isQPayServiceDownUseCase;
        r0.f12541h = r11;
        r0.f12542i = r8;
        r0.f12543j = r9;
        r0.f12544k = null;
        r0.f12545l = r7;
        r0.f12546m = r12;
        r0.f12550q = 3;
        r10 = r10.invoke(r7, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0133, code lost:
        if (r10 != r1) goto L_0x0136;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0135, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0136, code lost:
        r4 = r9;
        r9 = r7;
        r7 = r12;
        r12 = r10;
        r10 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x013d, code lost:
        r12 = ((java.lang.Boolean) r12).booleanValue();
        r2 = r11.getQPayEnabledUseCase;
        r0.f12541h = r11;
        r0.f12542i = r10;
        r0.f12543j = r8;
        r0.f12545l = r9;
        r0.f12546m = r7;
        r0.f12547n = r12;
        r0.f12550q = 4;
        r2 = r2.invoke(r9, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0158, code lost:
        if (r2 != r1) goto L_0x015b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x015a, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x015b, code lost:
        r4 = r8;
        r8 = r7;
        r7 = r12;
        r12 = r2;
        r2 = r11;
        r11 = r10;
        r10 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0162, code lost:
        r12 = (com.talabat.wallet.qPayManager.domain.entity.QPayStatus) r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x016a, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) com.talabat.wallet.qPayManager.domain.entity.QPayStatus.QPayIsAvailable.INSTANCE) == false) goto L_0x0199;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x016c, code lost:
        if (r9 == false) goto L_0x0193;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x016e, code lost:
        r9 = com.talabat.wallet.checkoutpaymentmanager.domain.entity.mapper.CheckoutPaymentUpdateResultMapper.INSTANCE;
        r12 = r2.getQPayDeflectionSavedCardUseCase;
        r0.f12541h = r2;
        r0.f12542i = r11;
        r0.f12543j = r10;
        r0.f12544k = r9;
        r0.f12545l = r8;
        r0.f12546m = r7;
        r0.f12550q = 5;
        r12 = r12.invoke(r7, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0185, code lost:
        if (r12 != r1) goto L_0x0188;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0187, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0188, code lost:
        r0 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0189, code lost:
        r7 = r9.mapQPayBinsToCheckoutPaymentUpdateResult((com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.entity.QPayDeflectionBinDetail) r12, r7);
        r12 = r8;
        r9 = r10;
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0193, code lost:
        r7 = com.talabat.wallet.checkoutpaymentmanager.domain.entity.CheckoutPaymentUpdateResult.QPayIsNotAvailable.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0195, code lost:
        r12 = r8;
        r9 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0197, code lost:
        r8 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x019f, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) com.talabat.wallet.qPayManager.domain.entity.QPayStatus.QPayIsUnAvailable.INSTANCE) == false) goto L_0x01a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x01a1, code lost:
        if (r7 == false) goto L_0x01a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x01a3, code lost:
        r7 = com.talabat.wallet.checkoutpaymentmanager.domain.entity.CheckoutPaymentUpdateResult.QPayIsDown.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x01a6, code lost:
        r7 = com.talabat.wallet.checkoutpaymentmanager.domain.entity.CheckoutPaymentUpdateResult.QPayIsNotAvailable.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01ae, code lost:
        throw new kotlin.NoWhenBranchMatchedException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x01b5, code lost:
        if (r2 != com.talabat.talabatcore.model.TalabatCountry.BAHRAIN.getCountryId()) goto L_0x01dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x01b7, code lost:
        r7 = com.talabat.wallet.checkoutpaymentmanager.domain.entity.mapper.CheckoutPaymentUpdateResultMapper.INSTANCE;
        r2 = r11.getBenefitBinDetailUseCase;
        r0.f12541h = r11;
        r0.f12542i = r8;
        r0.f12543j = r9;
        r0.f12544k = r7;
        r0.f12545l = r12;
        r0.f12550q = 6;
        r10 = r2.invoke(r10, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01cc, code lost:
        if (r10 != r1) goto L_0x01cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x01ce, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x01cf, code lost:
        r4 = r8;
        r8 = r7;
        r7 = r12;
        r12 = r10;
        r10 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x01d4, code lost:
        r8 = r8.mapBenefitBinsToCheckoutPaymentUpdateResult((com.talabat.talabatcommon.views.wallet.benefitmanager.domain.entity.BenefitBinsDetail) r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01dc, code lost:
        r7 = com.talabat.wallet.checkoutpaymentmanager.domain.entity.CheckoutPaymentUpdateResult.DefaultPaymentMethod.INSTANCE;
        r2 = r11;
        r11 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x01e1, code lost:
        r2.addCheckoutLoadedTracking(r11, r9, r8, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x01e4, code lost:
        return r8;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke(boolean r7, @org.jetbrains.annotations.Nullable buisnessmodels.Cart r8, @org.jetbrains.annotations.NotNull java.lang.String r9, @org.jetbrains.annotations.NotNull java.lang.String r10, boolean r11, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.wallet.checkoutpaymentmanager.domain.entity.CheckoutPaymentUpdateResult> r12) {
        /*
            r6 = this;
            boolean r0 = r12 instanceof com.talabat.wallet.checkoutpaymentmanager.domain.business.usecase.GetPaymentMethodUpdate$invoke$1
            if (r0 == 0) goto L_0x0013
            r0 = r12
            com.talabat.wallet.checkoutpaymentmanager.domain.business.usecase.GetPaymentMethodUpdate$invoke$1 r0 = (com.talabat.wallet.checkoutpaymentmanager.domain.business.usecase.GetPaymentMethodUpdate$invoke$1) r0
            int r1 = r0.f12550q
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f12550q = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.wallet.checkoutpaymentmanager.domain.business.usecase.GetPaymentMethodUpdate$invoke$1 r0 = new com.talabat.wallet.checkoutpaymentmanager.domain.business.usecase.GetPaymentMethodUpdate$invoke$1
            r0.<init>(r6, r12)
        L_0x0018:
            java.lang.Object r12 = r0.f12548o
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f12550q
            switch(r2) {
                case 0: goto L_0x00bd;
                case 1: goto L_0x00a1;
                case 2: goto L_0x008a;
                case 3: goto L_0x0072;
                case 4: goto L_0x005b;
                case 5: goto L_0x0042;
                case 6: goto L_0x002b;
                default: goto L_0x0023;
            }
        L_0x0023:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x002b:
            boolean r7 = r0.f12545l
            java.lang.Object r8 = r0.f12544k
            com.talabat.wallet.checkoutpaymentmanager.domain.entity.mapper.CheckoutPaymentUpdateResultMapper r8 = (com.talabat.wallet.checkoutpaymentmanager.domain.entity.mapper.CheckoutPaymentUpdateResultMapper) r8
            java.lang.Object r9 = r0.f12543j
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r10 = r0.f12542i
            buisnessmodels.Cart r10 = (buisnessmodels.Cart) r10
            java.lang.Object r11 = r0.f12541h
            com.talabat.wallet.checkoutpaymentmanager.domain.business.usecase.GetPaymentMethodUpdate r11 = (com.talabat.wallet.checkoutpaymentmanager.domain.business.usecase.GetPaymentMethodUpdate) r11
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x01d4
        L_0x0042:
            boolean r7 = r0.f12546m
            boolean r8 = r0.f12545l
            java.lang.Object r9 = r0.f12544k
            com.talabat.wallet.checkoutpaymentmanager.domain.entity.mapper.CheckoutPaymentUpdateResultMapper r9 = (com.talabat.wallet.checkoutpaymentmanager.domain.entity.mapper.CheckoutPaymentUpdateResultMapper) r9
            java.lang.Object r10 = r0.f12543j
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r11 = r0.f12542i
            buisnessmodels.Cart r11 = (buisnessmodels.Cart) r11
            java.lang.Object r0 = r0.f12541h
            com.talabat.wallet.checkoutpaymentmanager.domain.business.usecase.GetPaymentMethodUpdate r0 = (com.talabat.wallet.checkoutpaymentmanager.domain.business.usecase.GetPaymentMethodUpdate) r0
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0189
        L_0x005b:
            boolean r7 = r0.f12547n
            boolean r8 = r0.f12546m
            boolean r9 = r0.f12545l
            java.lang.Object r10 = r0.f12543j
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r11 = r0.f12542i
            buisnessmodels.Cart r11 = (buisnessmodels.Cart) r11
            java.lang.Object r2 = r0.f12541h
            com.talabat.wallet.checkoutpaymentmanager.domain.business.usecase.GetPaymentMethodUpdate r2 = (com.talabat.wallet.checkoutpaymentmanager.domain.business.usecase.GetPaymentMethodUpdate) r2
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0162
        L_0x0072:
            boolean r7 = r0.f12546m
            boolean r8 = r0.f12545l
            java.lang.Object r9 = r0.f12543j
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r10 = r0.f12542i
            buisnessmodels.Cart r10 = (buisnessmodels.Cart) r10
            java.lang.Object r11 = r0.f12541h
            com.talabat.wallet.checkoutpaymentmanager.domain.business.usecase.GetPaymentMethodUpdate r11 = (com.talabat.wallet.checkoutpaymentmanager.domain.business.usecase.GetPaymentMethodUpdate) r11
            kotlin.ResultKt.throwOnFailure(r12)
            r4 = r9
            r9 = r8
        L_0x0087:
            r8 = r4
            goto L_0x013d
        L_0x008a:
            boolean r7 = r0.f12545l
            java.lang.Object r8 = r0.f12544k
            com.talabat.wallet.checkoutpaymentmanager.domain.entity.mapper.CheckoutPaymentUpdateResultMapper r8 = (com.talabat.wallet.checkoutpaymentmanager.domain.entity.mapper.CheckoutPaymentUpdateResultMapper) r8
            java.lang.Object r9 = r0.f12543j
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r10 = r0.f12542i
            buisnessmodels.Cart r10 = (buisnessmodels.Cart) r10
            java.lang.Object r11 = r0.f12541h
            com.talabat.wallet.checkoutpaymentmanager.domain.business.usecase.GetPaymentMethodUpdate r11 = (com.talabat.wallet.checkoutpaymentmanager.domain.business.usecase.GetPaymentMethodUpdate) r11
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x010a
        L_0x00a1:
            boolean r11 = r0.f12546m
            boolean r7 = r0.f12545l
            java.lang.Object r8 = r0.f12544k
            r10 = r8
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r8 = r0.f12543j
            r9 = r8
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r8 = r0.f12542i
            buisnessmodels.Cart r8 = (buisnessmodels.Cart) r8
            java.lang.Object r2 = r0.f12541h
            com.talabat.wallet.checkoutpaymentmanager.domain.business.usecase.GetPaymentMethodUpdate r2 = (com.talabat.wallet.checkoutpaymentmanager.domain.business.usecase.GetPaymentMethodUpdate) r2
            kotlin.ResultKt.throwOnFailure(r12)
            r12 = r11
            r11 = r2
            goto L_0x00da
        L_0x00bd:
            kotlin.ResultKt.throwOnFailure(r12)
            com.talabat.wallet.checkoutpaymentmanager.domain.application.usecase.GetCheckoutTimeOutVariationUseCase r12 = r6.getCheckoutTimeOutVariationUseCase
            r0.f12541h = r6
            r0.f12542i = r8
            r0.f12543j = r9
            r0.f12544k = r10
            r0.f12545l = r7
            r0.f12546m = r11
            r2 = 1
            r0.f12550q = r2
            java.lang.Object r12 = r12.invoke(r0)
            if (r12 != r1) goto L_0x00d8
            return r1
        L_0x00d8:
            r12 = r11
            r11 = r6
        L_0x00da:
            com.talabat.configuration.ConfigurationLocalRepository r2 = r11.configurationLocalRepository
            com.talabat.configuration.country.Country r2 = r2.selectedCountry()
            int r2 = r2.getCountryId()
            com.talabat.talabatcore.model.TalabatCountry r3 = com.talabat.talabatcore.model.TalabatCountry.KUWAIT
            int r3 = r3.getCountryId()
            if (r2 != r3) goto L_0x0115
            com.talabat.wallet.checkoutpaymentmanager.domain.entity.mapper.CheckoutPaymentUpdateResultMapper r10 = com.talabat.wallet.checkoutpaymentmanager.domain.entity.mapper.CheckoutPaymentUpdateResultMapper.INSTANCE
            com.talabat.wallet.knetStatusManager.domain.business.usecase.GetKNetStatusUseCase r2 = r11.getKNetStatusUseCase
            r0.f12541h = r11
            r0.f12542i = r8
            r0.f12543j = r9
            r0.f12544k = r10
            r0.f12545l = r12
            r3 = 2
            r0.f12550q = r3
            java.lang.Object r7 = r2.invoke(r7, r0)
            if (r7 != r1) goto L_0x0104
            return r1
        L_0x0104:
            r4 = r12
            r12 = r7
            r7 = r4
            r5 = r10
            r10 = r8
            r8 = r5
        L_0x010a:
            com.talabat.wallet.knetStatusManager.domain.entity.KNetStatusResult r12 = (com.talabat.wallet.knetStatusManager.domain.entity.KNetStatusResult) r12
            com.talabat.wallet.checkoutpaymentmanager.domain.entity.CheckoutPaymentUpdateResult r8 = r8.mapKNetStatusToCheckoutPaymentUpdateResult(r12)
        L_0x0110:
            r12 = r7
            r2 = r11
            r11 = r10
            goto L_0x01e1
        L_0x0115:
            com.talabat.talabatcore.model.TalabatCountry r3 = com.talabat.talabatcore.model.TalabatCountry.QATAR
            int r3 = r3.getCountryId()
            if (r2 != r3) goto L_0x01af
            com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.business.IsQPayServiceDownUseCase r10 = r11.isQPayServiceDownUseCase
            r0.f12541h = r11
            r0.f12542i = r8
            r0.f12543j = r9
            r2 = 0
            r0.f12544k = r2
            r0.f12545l = r7
            r0.f12546m = r12
            r2 = 3
            r0.f12550q = r2
            java.lang.Object r10 = r10.invoke(r7, r0)
            if (r10 != r1) goto L_0x0136
            return r1
        L_0x0136:
            r4 = r9
            r9 = r7
            r7 = r12
            r12 = r10
            r10 = r8
            goto L_0x0087
        L_0x013d:
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            com.talabat.wallet.qPayManager.domain.business.usecase.GetQPayEnabledUseCase r2 = r11.getQPayEnabledUseCase
            r0.f12541h = r11
            r0.f12542i = r10
            r0.f12543j = r8
            r0.f12545l = r9
            r0.f12546m = r7
            r0.f12547n = r12
            r3 = 4
            r0.f12550q = r3
            java.lang.Object r2 = r2.invoke(r9, r0)
            if (r2 != r1) goto L_0x015b
            return r1
        L_0x015b:
            r4 = r8
            r8 = r7
            r7 = r12
            r12 = r2
            r2 = r11
            r11 = r10
            r10 = r4
        L_0x0162:
            com.talabat.wallet.qPayManager.domain.entity.QPayStatus r12 = (com.talabat.wallet.qPayManager.domain.entity.QPayStatus) r12
            com.talabat.wallet.qPayManager.domain.entity.QPayStatus$QPayIsAvailable r3 = com.talabat.wallet.qPayManager.domain.entity.QPayStatus.QPayIsAvailable.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0199
            if (r9 == 0) goto L_0x0193
            com.talabat.wallet.checkoutpaymentmanager.domain.entity.mapper.CheckoutPaymentUpdateResultMapper r9 = com.talabat.wallet.checkoutpaymentmanager.domain.entity.mapper.CheckoutPaymentUpdateResultMapper.INSTANCE
            com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.business.GetQPayDeflectionSavedCardUseCase r12 = r2.getQPayDeflectionSavedCardUseCase
            r0.f12541h = r2
            r0.f12542i = r11
            r0.f12543j = r10
            r0.f12544k = r9
            r0.f12545l = r8
            r0.f12546m = r7
            r3 = 5
            r0.f12550q = r3
            java.lang.Object r12 = r12.invoke(r7, r0)
            if (r12 != r1) goto L_0x0188
            return r1
        L_0x0188:
            r0 = r2
        L_0x0189:
            com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.entity.QPayDeflectionBinDetail r12 = (com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.entity.QPayDeflectionBinDetail) r12
            com.talabat.wallet.checkoutpaymentmanager.domain.entity.CheckoutPaymentUpdateResult r7 = r9.mapQPayBinsToCheckoutPaymentUpdateResult(r12, r7)
            r12 = r8
            r9 = r10
            r2 = r0
            goto L_0x0197
        L_0x0193:
            com.talabat.wallet.checkoutpaymentmanager.domain.entity.CheckoutPaymentUpdateResult$QPayIsNotAvailable r7 = com.talabat.wallet.checkoutpaymentmanager.domain.entity.CheckoutPaymentUpdateResult.QPayIsNotAvailable.INSTANCE
        L_0x0195:
            r12 = r8
            r9 = r10
        L_0x0197:
            r8 = r7
            goto L_0x01e1
        L_0x0199:
            com.talabat.wallet.qPayManager.domain.entity.QPayStatus$QPayIsUnAvailable r9 = com.talabat.wallet.qPayManager.domain.entity.QPayStatus.QPayIsUnAvailable.INSTANCE
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r9)
            if (r9 == 0) goto L_0x01a9
            if (r7 == 0) goto L_0x01a6
            com.talabat.wallet.checkoutpaymentmanager.domain.entity.CheckoutPaymentUpdateResult$QPayIsDown r7 = com.talabat.wallet.checkoutpaymentmanager.domain.entity.CheckoutPaymentUpdateResult.QPayIsDown.INSTANCE
            goto L_0x0195
        L_0x01a6:
            com.talabat.wallet.checkoutpaymentmanager.domain.entity.CheckoutPaymentUpdateResult$QPayIsNotAvailable r7 = com.talabat.wallet.checkoutpaymentmanager.domain.entity.CheckoutPaymentUpdateResult.QPayIsNotAvailable.INSTANCE
            goto L_0x0195
        L_0x01a9:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        L_0x01af:
            com.talabat.talabatcore.model.TalabatCountry r7 = com.talabat.talabatcore.model.TalabatCountry.BAHRAIN
            int r7 = r7.getCountryId()
            if (r2 != r7) goto L_0x01dc
            com.talabat.wallet.checkoutpaymentmanager.domain.entity.mapper.CheckoutPaymentUpdateResultMapper r7 = com.talabat.wallet.checkoutpaymentmanager.domain.entity.mapper.CheckoutPaymentUpdateResultMapper.INSTANCE
            com.talabat.talabatcommon.views.wallet.benefitmanager.domain.business.usecase.GetBenefitBinDetailUseCase r2 = r11.getBenefitBinDetailUseCase
            r0.f12541h = r11
            r0.f12542i = r8
            r0.f12543j = r9
            r0.f12544k = r7
            r0.f12545l = r12
            r3 = 6
            r0.f12550q = r3
            java.lang.Object r10 = r2.invoke(r10, r0)
            if (r10 != r1) goto L_0x01cf
            return r1
        L_0x01cf:
            r4 = r8
            r8 = r7
            r7 = r12
            r12 = r10
            r10 = r4
        L_0x01d4:
            com.talabat.talabatcommon.views.wallet.benefitmanager.domain.entity.BenefitBinsDetail r12 = (com.talabat.talabatcommon.views.wallet.benefitmanager.domain.entity.BenefitBinsDetail) r12
            com.talabat.wallet.checkoutpaymentmanager.domain.entity.CheckoutPaymentUpdateResult r8 = r8.mapBenefitBinsToCheckoutPaymentUpdateResult(r12)
            goto L_0x0110
        L_0x01dc:
            com.talabat.wallet.checkoutpaymentmanager.domain.entity.CheckoutPaymentUpdateResult$DefaultPaymentMethod r7 = com.talabat.wallet.checkoutpaymentmanager.domain.entity.CheckoutPaymentUpdateResult.DefaultPaymentMethod.INSTANCE
            r2 = r11
            r11 = r8
            goto L_0x0197
        L_0x01e1:
            r2.addCheckoutLoadedTracking(r11, r9, r8, r12)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.wallet.checkoutpaymentmanager.domain.business.usecase.GetPaymentMethodUpdate.invoke(boolean, buisnessmodels.Cart, java.lang.String, java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
