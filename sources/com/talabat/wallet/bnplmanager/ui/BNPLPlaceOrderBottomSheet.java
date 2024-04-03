package com.talabat.wallet.bnplmanager.ui;

import JsonModels.PlaceOrderResponse;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.designsystem.ds_bottom_sheet_v2.DSBottomSheet;
import com.google.android.gms.common.util.VisibleForTesting;
import com.talabat.talabatcommon.model.wallet.WalletCardListDisplayModel;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.CardListFragment;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView;
import com.talabat.talabatnavigation.common.TalabatCommonNavigationActions;
import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import com.talabat.wallet.bnplmanager.domain.entity.BNPLPlan;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001-B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u001a\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0017\u001a\u00020\u0011H\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0015H\u0016J\b\u0010\u001a\u001a\u00020\u0011H\u0007J\b\u0010\u001b\u001a\u00020\u0013H\u0007J\u0012\u0010\u001c\u001a\u00020\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0015H\u0016J\u0010\u0010 \u001a\u00020\u00152\b\u0010!\u001a\u0004\u0018\u00010\u001eJ\u0006\u0010\"\u001a\u00020\u0015J\u0012\u0010#\u001a\u00020\u00152\b\u0010$\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010%\u001a\u00020\u0015H\u0016J\u0006\u0010&\u001a\u00020\u0015J\b\u0010'\u001a\u00020\u0015H\u0016J\u0006\u0010(\u001a\u00020\u0015J\u0010\u0010)\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\u0011H\u0016J\u0010\u0010+\u001a\u00020\u00152\u0006\u0010,\u001a\u00020\u0013H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/talabat/wallet/bnplmanager/ui/BNPLPlaceOrderBottomSheet;", "Lcom/talabat/wallet/bnplmanager/ui/BNPLPlaceOrderFragmentInterface;", "Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/view/CardListFragment$CardListFragmentInterface;", "appCompatActivity", "Landroidx/appcompat/app/AppCompatActivity;", "bnplPlan", "Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLPlan;", "bnplPlaceOrderBottomSheetInterface", "Lcom/talabat/wallet/bnplmanager/ui/BNPLPlaceOrderBottomSheetInterface;", "defaultPaymentMethod", "", "(Landroidx/appcompat/app/AppCompatActivity;Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLPlan;Lcom/talabat/wallet/bnplmanager/ui/BNPLPlaceOrderBottomSheetInterface;Ljava/lang/String;)V", "bNPLInitiatePlaceOrderFragment", "Lcom/talabat/wallet/bnplmanager/ui/BNPLInitiatePlaceOrderFragment;", "bottomSheetFragment", "Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;", "selectedPosition", "", "walletCardList", "Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;", "attachCardList", "", "cardListData", "viewHeight", "cancelLoader", "closeBottomSheet", "getSelectedPosition", "getWalletCardList", "navigateToOrderSuccessScreen", "orderResponse", "LJsonModels/PlaceOrderResponse;", "onBackButtonClicked", "onGetBNPLOrderSuccess", "response", "onGetBNPNOrderFailure", "onGetBinVoucher", "binNumber", "placeOrderWithBNPL", "show", "showLoader", "updateBNPLPaymentDetail", "updatePositionClicked", "position", "updateWalletCardList", "walletCardListDisplayModel", "Companion", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BNPLPlaceOrderBottomSheet implements BNPLPlaceOrderFragmentInterface, CardListFragment.CardListFragmentInterface {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    public static final String TAG = "BNPLPlaceOrderBottomSheet";
    @NotNull
    private final AppCompatActivity appCompatActivity;
    @Nullable
    private BNPLInitiatePlaceOrderFragment bNPLInitiatePlaceOrderFragment;
    @Nullable
    private final BNPLPlaceOrderBottomSheetInterface bnplPlaceOrderBottomSheetInterface;
    @Nullable
    private final BNPLPlan bnplPlan;
    @NotNull
    private final DSBottomSheet bottomSheetFragment;
    @Nullable
    private final String defaultPaymentMethod;
    private int selectedPosition;
    @NotNull
    private WalletCardListDisplayModel walletCardList;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/wallet/bnplmanager/ui/BNPLPlaceOrderBottomSheet$Companion;", "", "()V", "TAG", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public BNPLPlaceOrderBottomSheet(@NotNull AppCompatActivity appCompatActivity2, @Nullable BNPLPlan bNPLPlan, @Nullable BNPLPlaceOrderBottomSheetInterface bNPLPlaceOrderBottomSheetInterface, @Nullable String str) {
        Intrinsics.checkNotNullParameter(appCompatActivity2, "appCompatActivity");
        this.appCompatActivity = appCompatActivity2;
        this.bnplPlan = bNPLPlan;
        this.bnplPlaceOrderBottomSheetInterface = bNPLPlaceOrderBottomSheetInterface;
        this.defaultPaymentMethod = str;
        this.walletCardList = new WalletCardListDisplayModel((List) null, false, 0, 7, (DefaultConstructorMarker) null);
        DSBottomSheet dSBottomSheet = new DSBottomSheet();
        this.bottomSheetFragment = dSBottomSheet;
        if (bNPLPlan != null) {
            BNPLInitiatePlaceOrderFragment bNPLInitiatePlaceOrderFragment2 = new BNPLInitiatePlaceOrderFragment(this, bNPLPlan, str);
            this.bNPLInitiatePlaceOrderFragment = bNPLInitiatePlaceOrderFragment2;
            dSBottomSheet.setBody(bNPLInitiatePlaceOrderFragment2);
        }
    }

    public void attachCardList(@Nullable WalletCardListDisplayModel walletCardListDisplayModel, int i11) {
        CardListFragment cardListFragment$default = DefaultCardView.Companion.getCardListFragment$default(DefaultCardView.Companion, walletCardListDisplayModel, this, (CardListFragment.CardListDefaultCardInterface) null, 4, (Object) null);
        Bundle bundle = new Bundle();
        bundle.putInt(TalabatCommonNavigationActions.EXTRA_WALLET_PAYMENT_WIDGET_CARD_LIST_HEIGHT, i11);
        Bundle arguments = cardListFragment$default.getArguments();
        if (arguments != null) {
            arguments.putBundle(TalabatCommonNavigationActions.EXTRA_WALLET_PAYMENT_WIDGET_CARD_LIST_BUNDLE_KEY, bundle);
        }
        this.bottomSheetFragment.setBody(cardListFragment$default);
    }

    public void cancelLoader() {
        BNPLPlaceOrderBottomSheetInterface bNPLPlaceOrderBottomSheetInterface = this.bnplPlaceOrderBottomSheetInterface;
        if (bNPLPlaceOrderBottomSheetInterface != null) {
            bNPLPlaceOrderBottomSheetInterface.cancelLoader();
        }
    }

    public void closeBottomSheet() {
        this.bottomSheetFragment.dismiss();
    }

    @VisibleForTesting
    public final int getSelectedPosition() {
        return this.selectedPosition;
    }

    @NotNull
    @VisibleForTesting
    public final WalletCardListDisplayModel getWalletCardList() {
        return this.walletCardList;
    }

    public void navigateToOrderSuccessScreen(@Nullable PlaceOrderResponse placeOrderResponse) {
        BNPLPlaceOrderBottomSheetInterface bNPLPlaceOrderBottomSheetInterface = this.bnplPlaceOrderBottomSheetInterface;
        if (bNPLPlaceOrderBottomSheetInterface != null) {
            bNPLPlaceOrderBottomSheetInterface.navigateToOrderSuccessScreen(placeOrderResponse);
        }
    }

    public void onBackButtonClicked() {
        boolean z11;
        Bundle bundle = new Bundle();
        bundle.putInt(CardListFragment.SELECTED_POSITION, this.selectedPosition);
        Collection cardList = this.walletCardList.getCardList();
        if (cardList == null || cardList.isEmpty()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            bundle.putParcelable(WalletNavigatorActions.EXTRA_UPDATE_WALLET_CARD_LIST, this.walletCardList);
        }
        if (this.bnplPlan != null) {
            BNPLInitiatePlaceOrderFragment bNPLInitiatePlaceOrderFragment2 = this.bNPLInitiatePlaceOrderFragment;
            if (bNPLInitiatePlaceOrderFragment2 != null) {
                bNPLInitiatePlaceOrderFragment2.setArguments(bundle);
            }
            this.bottomSheetFragment.setBody(this.bNPLInitiatePlaceOrderFragment);
        }
    }

    public final void onGetBNPLOrderSuccess(@Nullable PlaceOrderResponse placeOrderResponse) {
        BNPLInitiatePlaceOrderFragment bNPLInitiatePlaceOrderFragment2 = this.bNPLInitiatePlaceOrderFragment;
        if (bNPLInitiatePlaceOrderFragment2 != null) {
            bNPLInitiatePlaceOrderFragment2.onGetBNPLOrderSuccess(placeOrderResponse);
        }
    }

    public final void onGetBNPNOrderFailure() {
        BNPLInitiatePlaceOrderFragment bNPLInitiatePlaceOrderFragment2 = this.bNPLInitiatePlaceOrderFragment;
        if (bNPLInitiatePlaceOrderFragment2 != null) {
            bNPLInitiatePlaceOrderFragment2.enablePaymentButton();
        }
    }

    public void onGetBinVoucher(@Nullable String str) {
        BNPLPlaceOrderBottomSheetInterface bNPLPlaceOrderBottomSheetInterface = this.bnplPlaceOrderBottomSheetInterface;
        if (bNPLPlaceOrderBottomSheetInterface != null) {
            bNPLPlaceOrderBottomSheetInterface.onGetBinVoucher(str);
        }
    }

    public void placeOrderWithBNPL() {
        BNPLPlaceOrderBottomSheetInterface bNPLPlaceOrderBottomSheetInterface = this.bnplPlaceOrderBottomSheetInterface;
        if (bNPLPlaceOrderBottomSheetInterface != null) {
            bNPLPlaceOrderBottomSheetInterface.placeOrderWithBNPL();
        }
    }

    public final void show() {
        this.bottomSheetFragment.show(this.appCompatActivity.getSupportFragmentManager(), TAG);
    }

    public void showLoader() {
        BNPLPlaceOrderBottomSheetInterface bNPLPlaceOrderBottomSheetInterface = this.bnplPlaceOrderBottomSheetInterface;
        if (bNPLPlaceOrderBottomSheetInterface != null) {
            bNPLPlaceOrderBottomSheetInterface.showLoader();
        }
    }

    public final void updateBNPLPaymentDetail() {
        BNPLInitiatePlaceOrderFragment bNPLInitiatePlaceOrderFragment2 = this.bNPLInitiatePlaceOrderFragment;
        if (bNPLInitiatePlaceOrderFragment2 != null) {
            bNPLInitiatePlaceOrderFragment2.updateBNPLPaymentDetail();
        }
    }

    public void updatePositionClicked(int i11) {
        this.selectedPosition = i11;
    }

    public void updateWalletCardList(@NotNull WalletCardListDisplayModel walletCardListDisplayModel) {
        Intrinsics.checkNotNullParameter(walletCardListDisplayModel, "walletCardListDisplayModel");
        this.walletCardList = walletCardListDisplayModel;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BNPLPlaceOrderBottomSheet(AppCompatActivity appCompatActivity2, BNPLPlan bNPLPlan, BNPLPlaceOrderBottomSheetInterface bNPLPlaceOrderBottomSheetInterface, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(appCompatActivity2, bNPLPlan, bNPLPlaceOrderBottomSheetInterface, (i11 & 8) != 0 ? null : str);
    }
}
