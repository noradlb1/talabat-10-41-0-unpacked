package com.talabat.talabatcommon.views.wallet.cardViewWidgets.viewModel;

import com.talabat.talabatcommon.model.wallet.WalletCardListDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod;
import com.talabat.talabatcommon.views.wallet.walletPaymentWidgetConfig.model.WalletPaymentWidgetConfigDisplayModel;
import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "walletCardList", "Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;", "walletPaymentWidgetConfigDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentWidgetConfig/model/WalletPaymentWidgetConfigDisplayModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CardViewWidgetsViewModelImpl$getAllPaymentMethods$1 extends Lambda implements Function2<WalletCardListDisplayModel, WalletPaymentWidgetConfigDisplayModel, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CardViewWidgetsViewModelImpl f11897g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Boolean f11898h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Boolean f11899i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CardViewWidgetsViewModelImpl$getAllPaymentMethods$1(CardViewWidgetsViewModelImpl cardViewWidgetsViewModelImpl, Boolean bool, Boolean bool2) {
        super(2);
        this.f11897g = cardViewWidgetsViewModelImpl;
        this.f11898h = bool;
        this.f11899i = bool2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((WalletCardListDisplayModel) obj, (WalletPaymentWidgetConfigDisplayModel) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull WalletCardListDisplayModel walletCardListDisplayModel, @NotNull WalletPaymentWidgetConfigDisplayModel walletPaymentWidgetConfigDisplayModel) {
        boolean z11;
        boolean z12;
        Intrinsics.checkNotNullParameter(walletCardListDisplayModel, WalletNavigatorActions.EXTRA_WALLET_CARD_LIST);
        Intrinsics.checkNotNullParameter(walletPaymentWidgetConfigDisplayModel, "walletPaymentWidgetConfigDisplayModel");
        CardViewWidgetsViewModelImpl cardViewWidgetsViewModelImpl = this.f11897g;
        Boolean bool = this.f11898h;
        if (bool != null) {
            z11 = bool.booleanValue();
        } else {
            z11 = walletPaymentWidgetConfigDisplayModel.isElectronicPaymentEnabled();
        }
        cardViewWidgetsViewModelImpl.setCardEnabled(z11);
        CardViewWidgetsViewModelImpl cardViewWidgetsViewModelImpl2 = this.f11897g;
        Boolean bool2 = this.f11899i;
        if (bool2 != null) {
            z12 = bool2.booleanValue();
        } else {
            z12 = walletPaymentWidgetConfigDisplayModel.isCashEnabled();
        }
        cardViewWidgetsViewModelImpl2.setCashEnabled(z12);
        this.f11897g.setWalletEnabled(walletPaymentWidgetConfigDisplayModel.isWalletEnabled());
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(walletPaymentWidgetConfigDisplayModel.getPaymentMethods());
        if (this.f11897g.isCardEnabled()) {
            arrayList.add(arrayList.size(), PaymentMethod.CARD);
        } else {
            arrayList.remove(PaymentMethod.CARD);
        }
        if (this.f11897g.isCashEnabled()) {
            arrayList.add(arrayList.size(), PaymentMethod.CASH);
        } else {
            arrayList.remove(PaymentMethod.CASH);
        }
        WalletCardListDisplayModel walletCardListDisplayModel2 = new WalletCardListDisplayModel(this.f11897g.populateAllPaymentMethods(walletCardListDisplayModel.getCardList(), this.f11897g.removeDuplicatePaymentGroup(arrayList)), true, -1);
        this.f11897g.getWalletCardListData().setValue(walletCardListDisplayModel2);
        this.f11897g.setDefaultCard(walletCardListDisplayModel2);
    }
}
