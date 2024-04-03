package com.talabat.feature.tpro.presentation.management.details.adapter.viewholder;

import androidx.fragment.app.FragmentManager;
import com.talabat.talabatcommon.model.wallet.WalletCardListDisplayModel;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/talabat/feature/tpro/presentation/management/details/adapter/viewholder/TproDetailsCardInfoViewHolder$defaultCardInterface$1", "Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/view/DefaultCardView$DefaultCardViewFullScreenInterface;", "onChangeClicked", "", "cardListData", "Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TproDetailsCardInfoViewHolder$defaultCardInterface$1 implements DefaultCardView.DefaultCardViewFullScreenInterface {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TproDetailsCardInfoViewHolder f59321b;

    public TproDetailsCardInfoViewHolder$defaultCardInterface$1(TproDetailsCardInfoViewHolder tproDetailsCardInfoViewHolder) {
        this.f59321b = tproDetailsCardInfoViewHolder;
    }

    public void onChangeClicked(@Nullable WalletCardListDisplayModel walletCardListDisplayModel) {
        FragmentManager access$getChildFragmentManager$p = this.f59321b.childFragmentManager;
        TproDetailsCardInfoViewHolder tproDetailsCardInfoViewHolder = this.f59321b;
        if (!tproDetailsCardInfoViewHolder.isFlutterPaymentWidgetExperimentEnabled() || !tproDetailsCardInfoViewHolder.canOpenDeeplink) {
            DefaultCardView.Companion.showCardListBottomSheet(access$getChildFragmentManager$p, walletCardListDisplayModel, tproDetailsCardInfoViewHolder.cardListInterface, "tpro");
        } else {
            tproDetailsCardInfoViewHolder.onChangePaymentClick.invoke();
        }
    }
}
