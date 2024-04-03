package com.talabat.feature.tpro.presentation.management.details.adapter.viewholder;

import com.talabat.talabatcommon.model.wallet.WalletCardListDisplayModel;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.CardListBottomSheet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/talabat/feature/tpro/presentation/management/details/adapter/viewholder/TproDetailsCardInfoViewHolder$cardListInterface$1", "Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/view/CardListBottomSheet$CardListBottomSheetInterface;", "updatePositionClicked", "", "position", "", "updateWalletCardList", "walletCardListDisplayModel", "Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TproDetailsCardInfoViewHolder$cardListInterface$1 implements CardListBottomSheet.CardListBottomSheetInterface {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TproDetailsCardInfoViewHolder f59320b;

    public TproDetailsCardInfoViewHolder$cardListInterface$1(TproDetailsCardInfoViewHolder tproDetailsCardInfoViewHolder) {
        this.f59320b = tproDetailsCardInfoViewHolder;
    }

    public void updatePositionClicked(int i11) {
        this.f59320b.binding.walletPaymentWidget.updateClickedPositionData(i11);
    }

    public void updateWalletCardList(@NotNull WalletCardListDisplayModel walletCardListDisplayModel) {
        Intrinsics.checkNotNullParameter(walletCardListDisplayModel, "walletCardListDisplayModel");
        this.f59320b.binding.walletPaymentWidget.updateWalletCardList(walletCardListDisplayModel);
    }
}
