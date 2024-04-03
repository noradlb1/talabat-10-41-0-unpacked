package com.talabat.talabatcommon.views.wallet.cardViewWidgets.viewModel;

import androidx.lifecycle.ViewModelKt;
import com.talabat.talabatcommon.extentions.SafeLetKt;
import com.talabat.talabatcommon.feature.walletCardList.DebitCardDeflectionUseCase;
import com.talabat.talabatcommon.feature.walletCardList.GetCardListUseCase;
import com.talabat.talabatcommon.feature.walletPaymentWidgetConfig.GetWalletPaymentWidgetConfigUseCase;
import com.talabat.talabatcommon.feature.walletPaymentWidgetConfig.WalletPaymentWidgetParam;
import com.talabat.talabatcommon.model.wallet.WalletCardDisplayModel;
import com.talabat.talabatcommon.model.wallet.WalletCardListDisplayModel;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.viewModel.DeflectionInfoDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod;
import com.talabat.talabatcommon.views.wallet.walletPaymentWidgetConfig.model.WalletPaymentWidgetConfigDisplayModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.apache.commons.compress.archivers.zip.UnixStat;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ5\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0002\u0010\u0018J\u0018\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0016\u0010\u001d\u001a\u00020\u00132\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0016J \u0010!\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\u001bH\u0016J\u0010\u0010$\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010%\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010&\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J*\u0010'\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u001fH\u0002J\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020*0\u001f2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020*0,H\u0002J\u0010\u0010-\u001a\u00020\u00132\u0006\u0010.\u001a\u00020\u0015H\u0016J\b\u0010/\u001a\u00020\u0013H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/viewModel/CardViewWidgetsViewModelImpl;", "Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/viewModel/CardViewWidgetsViewModel;", "walletCardListUseCase", "Lcom/talabat/talabatcommon/feature/walletCardList/GetCardListUseCase;", "walletPaymentWidgetConfigUseCase", "Lcom/talabat/talabatcommon/feature/walletPaymentWidgetConfig/GetWalletPaymentWidgetConfigUseCase;", "debitCardDeflectionUseCase", "Lcom/talabat/talabatcommon/feature/walletCardList/DebitCardDeflectionUseCase;", "source", "", "(Lcom/talabat/talabatcommon/feature/walletCardList/GetCardListUseCase;Lcom/talabat/talabatcommon/feature/walletPaymentWidgetConfig/GetWalletPaymentWidgetConfigUseCase;Lcom/talabat/talabatcommon/feature/walletCardList/DebitCardDeflectionUseCase;Ljava/lang/String;)V", "isCardEnabledFromParent", "", "()Z", "setCardEnabledFromParent", "(Z)V", "isCashEnabledFromParent", "setCashEnabledFromParent", "getAllPaymentMethods", "", "walletCardList", "Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;", "walletPaymentWidgetConfigDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentWidgetConfig/model/WalletPaymentWidgetConfigDisplayModel;", "(Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;Lcom/talabat/talabatcommon/views/wallet/walletPaymentWidgetConfig/model/WalletPaymentWidgetConfigDisplayModel;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getCardList", "paymentProvider", "", "country", "getDebitCardsDeflectionInfo", "cardsList", "", "Lcom/talabat/talabatcommon/model/wallet/WalletCardDisplayModel;", "getWalletPaymentWidgetConfig", "componentId", "featureId", "handleConfigServiceSuccess", "handleWalletCardListServiceSuccess", "handleWalletPaymentWidgetConfigSuccess", "populateAllPaymentMethods", "creditCardList", "paymentGroupedList", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/PaymentMethod;", "removeDuplicatePaymentGroup", "", "setDefaultCard", "walletCardListDisplayModel", "updateChangeCard", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CardViewWidgetsViewModelImpl extends CardViewWidgetsViewModel {
    /* access modifiers changed from: private */
    @NotNull
    public final DebitCardDeflectionUseCase debitCardDeflectionUseCase;
    private boolean isCardEnabledFromParent;
    private boolean isCashEnabledFromParent;
    /* access modifiers changed from: private */
    @NotNull
    public final String source;
    @NotNull
    private final GetCardListUseCase walletCardListUseCase;
    @NotNull
    private final GetWalletPaymentWidgetConfigUseCase walletPaymentWidgetConfigUseCase;

    public CardViewWidgetsViewModelImpl(@NotNull GetCardListUseCase getCardListUseCase, @NotNull GetWalletPaymentWidgetConfigUseCase getWalletPaymentWidgetConfigUseCase, @NotNull DebitCardDeflectionUseCase debitCardDeflectionUseCase2, @NotNull String str) {
        Intrinsics.checkNotNullParameter(getCardListUseCase, "walletCardListUseCase");
        Intrinsics.checkNotNullParameter(getWalletPaymentWidgetConfigUseCase, "walletPaymentWidgetConfigUseCase");
        Intrinsics.checkNotNullParameter(debitCardDeflectionUseCase2, "debitCardDeflectionUseCase");
        Intrinsics.checkNotNullParameter(str, "source");
        this.walletCardListUseCase = getCardListUseCase;
        this.walletPaymentWidgetConfigUseCase = getWalletPaymentWidgetConfigUseCase;
        this.debitCardDeflectionUseCase = debitCardDeflectionUseCase2;
        this.source = str;
    }

    private final void getAllPaymentMethods(WalletCardListDisplayModel walletCardListDisplayModel, WalletPaymentWidgetConfigDisplayModel walletPaymentWidgetConfigDisplayModel, Boolean bool, Boolean bool2) {
        SafeLetKt.safeLet(walletCardListDisplayModel, walletPaymentWidgetConfigDisplayModel, new CardViewWidgetsViewModelImpl$getAllPaymentMethods$1(this, bool, bool2));
    }

    private final void handleConfigServiceSuccess(WalletCardListDisplayModel walletCardListDisplayModel) {
        getWalletCardListData().setValue(walletCardListDisplayModel);
        getAllPaymentMethods(getWalletCardListData().getValue(), getWalletPaymentWidgetConfigData().getValue(), Boolean.valueOf(isCardEnabledFromParent()), Boolean.valueOf(isCashEnabledFromParent()));
    }

    /* access modifiers changed from: private */
    public final void handleWalletCardListServiceSuccess(WalletCardListDisplayModel walletCardListDisplayModel) {
        getWalletCardListData().setValue(walletCardListDisplayModel);
        setDefaultCard(walletCardListDisplayModel);
    }

    /* access modifiers changed from: private */
    public final void handleWalletPaymentWidgetConfigSuccess(WalletPaymentWidgetConfigDisplayModel walletPaymentWidgetConfigDisplayModel) {
        getWalletPaymentWidgetConfigData().setValue(walletPaymentWidgetConfigDisplayModel);
        getAllPaymentMethods(getWalletCardListData().getValue(), getWalletPaymentWidgetConfigData().getValue(), Boolean.valueOf(isCardEnabledFromParent()), Boolean.valueOf(isCashEnabledFromParent()));
    }

    /* access modifiers changed from: private */
    public final List<WalletCardDisplayModel> populateAllPaymentMethods(List<WalletCardDisplayModel> list, List<? extends PaymentMethod> list2) {
        ArrayList arrayList = new ArrayList();
        for (PaymentMethod paymentMethod : list2) {
            if (paymentMethod != PaymentMethod.CARD || !isCashEnabled()) {
                WalletCardDisplayModel walletCardDisplayModel = r3;
                WalletCardDisplayModel walletCardDisplayModel2 = new WalletCardDisplayModel((String) null, (String) null, (String) null, (String) null, (String) null, false, (String) null, (String) null, (String) null, (String) null, (PaymentMethod) null, false, UnixStat.PERM_MASK, (DefaultConstructorMarker) null);
                WalletCardDisplayModel walletCardDisplayModel3 = walletCardDisplayModel;
                walletCardDisplayModel3.setPaymentMethod(paymentMethod);
                walletCardDisplayModel3.setCardType(paymentMethod.name());
                arrayList.add(walletCardDisplayModel3);
            } else {
                arrayList.addAll(list);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public final List<PaymentMethod> removeDuplicatePaymentGroup(List<PaymentMethod> list) {
        Set unused = SetsKt__SetsKt.emptySet();
        ArrayList arrayList = new ArrayList();
        for (PaymentMethod next : list) {
            if (!arrayList.contains(next)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public void getCardList(int i11, int i12) {
        this.walletCardListUseCase.invoke(Integer.valueOf(i12), new CardViewWidgetsViewModelImpl$getCardList$1(this));
    }

    public void getDebitCardsDeflectionInfo(@NotNull List<WalletCardDisplayModel> list) {
        Intrinsics.checkNotNullParameter(list, "cardsList");
        if (Intrinsics.areEqual((Object) this.source, (Object) "tpro")) {
            getDeflectionInfoDisplayModelData().setValue(DeflectionInfoDisplayModel.Hidden.INSTANCE);
        } else {
            Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new CardViewWidgetsViewModelImpl$getDebitCardsDeflectionInfo$1(this, list, (Continuation<? super CardViewWidgetsViewModelImpl$getDebitCardsDeflectionInfo$1>) null), 3, (Object) null);
        }
    }

    public void getWalletPaymentWidgetConfig(int i11, int i12, int i13) {
        this.walletPaymentWidgetConfigUseCase.invoke(new WalletPaymentWidgetParam(i11, i12, i13), new CardViewWidgetsViewModelImpl$getWalletPaymentWidgetConfig$1(this));
    }

    public boolean isCardEnabledFromParent() {
        return this.isCardEnabledFromParent;
    }

    public boolean isCashEnabledFromParent() {
        return this.isCashEnabledFromParent;
    }

    public void setCardEnabledFromParent(boolean z11) {
        this.isCardEnabledFromParent = z11;
    }

    public void setCashEnabledFromParent(boolean z11) {
        this.isCashEnabledFromParent = z11;
    }

    public void setDefaultCard(@NotNull WalletCardListDisplayModel walletCardListDisplayModel) {
        Intrinsics.checkNotNullParameter(walletCardListDisplayModel, "walletCardListDisplayModel");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new CardViewWidgetsViewModelImpl$setDefaultCard$1(walletCardListDisplayModel, this, (Continuation<? super CardViewWidgetsViewModelImpl$setDefaultCard$1>) null), 3, (Object) null);
    }

    public void updateChangeCard() {
        getCardChangedData().setValue(Boolean.TRUE);
    }
}
