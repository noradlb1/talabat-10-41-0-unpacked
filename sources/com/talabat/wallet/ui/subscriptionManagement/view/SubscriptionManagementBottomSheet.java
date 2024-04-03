package com.talabat.wallet.ui.subscriptionManagement.view;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentTransaction;
import com.talabat.talabatcommon.model.wallet.WalletCardDisplayModel;
import com.talabat.talabatcommon.model.wallet.WalletCardListDisplayModel;
import com.talabat.talabatcommon.utils.AnimationHelper;
import com.talabat.talabatcommon.utils.AnimationSpeed;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.CardListBottomSheet;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.CardListFragment;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView;
import com.talabat.talabatcommon.views.wallet.subscription.model.SubscriptionDefaultCardDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod;
import com.talabat.talabatcore.TalabatBaseBottomSheetDialogFragment;
import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import com.talabat.wallet.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.archivers.zip.UnixStat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001(B+\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0012\u0010\u0013\u001a\u00020\u00102\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u0014\u001a\u00020\u0010H\u0002J\b\u0010\u0015\u001a\u00020\u0010H\u0016J&\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010 \u001a\u00020\u00102\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u0007H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/talabat/wallet/ui/subscriptionManagement/view/SubscriptionManagementBottomSheet;", "Lcom/talabat/talabatcore/TalabatBaseBottomSheetDialogFragment;", "Lcom/talabat/talabatcommon/utils/AnimationHelper;", "Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/view/CardListBottomSheet$CardListBottomSheetInterface;", "Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/view/CardListFragment$CardListFragmentInterface;", "Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/view/CardListFragment$CardListDefaultCardInterface;", "cardListData", "Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;", "subscriptionDefaultCard", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionDefaultCardDisplayModel;", "subscriptionBottomSheetInterface", "Lcom/talabat/wallet/ui/subscriptionManagement/view/SubscriptionManagementBottomSheet$SubscriptionManagementBottomSheetInterface;", "shouldSetDefaultCard", "", "(Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionDefaultCardDisplayModel;Lcom/talabat/wallet/ui/subscriptionManagement/view/SubscriptionManagementBottomSheet$SubscriptionManagementBottomSheetInterface;Z)V", "addBundleToFragment", "", "fragment", "Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/view/CardListFragment;", "attachCardList", "closeBottomSheetFromDialog", "onBackButtonClicked", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "updateChosenCard", "card", "Lcom/talabat/talabatcommon/model/wallet/WalletCardDisplayModel;", "updatePositionClicked", "position", "", "updateWalletCardList", "walletCardListDisplayModel", "SubscriptionManagementBottomSheetInterface", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionManagementBottomSheet extends TalabatBaseBottomSheetDialogFragment implements AnimationHelper, CardListBottomSheet.CardListBottomSheetInterface, CardListFragment.CardListFragmentInterface, CardListFragment.CardListDefaultCardInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    @Nullable
    private final WalletCardListDisplayModel cardListData;
    private final boolean shouldSetDefaultCard;
    @NotNull
    private final SubscriptionManagementBottomSheetInterface subscriptionBottomSheetInterface;
    @Nullable
    private final SubscriptionDefaultCardDisplayModel subscriptionDefaultCard;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/talabat/wallet/ui/subscriptionManagement/view/SubscriptionManagementBottomSheet$SubscriptionManagementBottomSheetInterface;", "", "updateCardList", "", "walletCardListDisplayModel", "Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;", "updateSubscriptionDefaultCard", "card", "Lcom/talabat/talabatcommon/model/wallet/WalletCardDisplayModel;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface SubscriptionManagementBottomSheetInterface {
        void updateCardList(@NotNull WalletCardListDisplayModel walletCardListDisplayModel);

        void updateSubscriptionDefaultCard(@NotNull WalletCardDisplayModel walletCardDisplayModel);
    }

    public SubscriptionManagementBottomSheet(@Nullable WalletCardListDisplayModel walletCardListDisplayModel, @Nullable SubscriptionDefaultCardDisplayModel subscriptionDefaultCardDisplayModel, @NotNull SubscriptionManagementBottomSheetInterface subscriptionManagementBottomSheetInterface, boolean z11) {
        Intrinsics.checkNotNullParameter(subscriptionManagementBottomSheetInterface, "subscriptionBottomSheetInterface");
        this._$_findViewCache = new LinkedHashMap();
        this.cardListData = walletCardListDisplayModel;
        this.subscriptionDefaultCard = subscriptionDefaultCardDisplayModel;
        this.subscriptionBottomSheetInterface = subscriptionManagementBottomSheetInterface;
        this.shouldSetDefaultCard = z11;
    }

    private final void addBundleToFragment(CardListFragment cardListFragment) {
        String str;
        String str2;
        String str3;
        Bundle bundle = new Bundle();
        String str4 = null;
        WalletCardDisplayModel walletCardDisplayModel = r2;
        WalletCardDisplayModel walletCardDisplayModel2 = new WalletCardDisplayModel((String) null, (String) null, (String) null, (String) null, (String) null, false, (String) null, (String) null, (String) null, (String) null, (PaymentMethod) null, false, UnixStat.PERM_MASK, (DefaultConstructorMarker) null);
        SubscriptionDefaultCardDisplayModel subscriptionDefaultCardDisplayModel = this.subscriptionDefaultCard;
        if (subscriptionDefaultCardDisplayModel != null) {
            str = subscriptionDefaultCardDisplayModel.getCardType();
        } else {
            str = null;
        }
        String str5 = "";
        if (str == null) {
            str = str5;
        }
        WalletCardDisplayModel walletCardDisplayModel3 = walletCardDisplayModel;
        walletCardDisplayModel3.setCardType(str);
        SubscriptionDefaultCardDisplayModel subscriptionDefaultCardDisplayModel2 = this.subscriptionDefaultCard;
        if (subscriptionDefaultCardDisplayModel2 != null) {
            str2 = subscriptionDefaultCardDisplayModel2.getCardTokenId();
        } else {
            str2 = null;
        }
        if (str2 == null) {
            str2 = str5;
        }
        walletCardDisplayModel3.setTokenId(str2);
        SubscriptionDefaultCardDisplayModel subscriptionDefaultCardDisplayModel3 = this.subscriptionDefaultCard;
        if (subscriptionDefaultCardDisplayModel3 != null) {
            str3 = subscriptionDefaultCardDisplayModel3.getCardExpiryDate();
        } else {
            str3 = null;
        }
        if (str3 == null) {
            str3 = str5;
        }
        walletCardDisplayModel3.setExpiryDate(str3);
        SubscriptionDefaultCardDisplayModel subscriptionDefaultCardDisplayModel4 = this.subscriptionDefaultCard;
        if (subscriptionDefaultCardDisplayModel4 != null) {
            str4 = subscriptionDefaultCardDisplayModel4.getCard4Digits();
        }
        if (str4 != null) {
            str5 = str4;
        }
        walletCardDisplayModel3.setCard4Digits(str5);
        Unit unit = Unit.INSTANCE;
        bundle.putParcelable(WalletNavigatorActions.EXTRA_DEFAULT_CARD_TO_CARD_LIST_BOTTOM_SHEET, walletCardDisplayModel3);
        bundle.putParcelable(DefaultCardView.CARD_LIST, this.cardListData);
        bundle.putBoolean(WalletNavigatorActions.EXTRA_SHOULD_HIDE_BACK_ICON, true);
        bundle.putBoolean(WalletNavigatorActions.EXTRA_SHOULD_IGNORE_BOTTOM_SHEET_CARD_LIST_DEFAULT_CARD, this.shouldSetDefaultCard);
        cardListFragment.setArguments(bundle);
    }

    private final void attachCardList(WalletCardListDisplayModel walletCardListDisplayModel) {
        CardListFragment cardListFragment = DefaultCardView.Companion.getCardListFragment(walletCardListDisplayModel, this, this);
        addBundleToFragment(cardListFragment);
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "childFragmentManager.beginTransaction()");
        beginTransaction.replace(R.id.card_fragment_container, cardListFragment).commit();
    }

    private final void closeBottomSheetFromDialog() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i11)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public void adjustViewHeight(@NotNull View view, int i11, int i12, @NotNull AnimationSpeed animationSpeed) {
        AnimationHelper.DefaultImpls.adjustViewHeight(this, view, i11, i12, animationSpeed);
    }

    public void delay(long j11, @NotNull Function0<Unit> function0) {
        AnimationHelper.DefaultImpls.delay(this, j11, function0);
    }

    public void onBackButtonClicked() {
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.view_subscription_bottom_sheet, viewGroup, false);
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        attachCardList(this.cardListData);
    }

    public void updateChosenCard(@Nullable WalletCardDisplayModel walletCardDisplayModel) {
        closeBottomSheetFromDialog();
        if (walletCardDisplayModel != null) {
            this.subscriptionBottomSheetInterface.updateSubscriptionDefaultCard(walletCardDisplayModel);
        }
    }

    public void updatePositionClicked(int i11) {
    }

    public void updateWalletCardList(@NotNull WalletCardListDisplayModel walletCardListDisplayModel) {
        Intrinsics.checkNotNullParameter(walletCardListDisplayModel, "walletCardListDisplayModel");
        this.subscriptionBottomSheetInterface.updateCardList(walletCardListDisplayModel);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SubscriptionManagementBottomSheet(WalletCardListDisplayModel walletCardListDisplayModel, SubscriptionDefaultCardDisplayModel subscriptionDefaultCardDisplayModel, SubscriptionManagementBottomSheetInterface subscriptionManagementBottomSheetInterface, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(walletCardListDisplayModel, subscriptionDefaultCardDisplayModel, subscriptionManagementBottomSheetInterface, (i11 & 8) != 0 ? true : z11);
    }
}
