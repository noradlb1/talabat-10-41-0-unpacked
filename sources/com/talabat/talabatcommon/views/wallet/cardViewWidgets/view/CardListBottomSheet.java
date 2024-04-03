package com.talabat.talabatcommon.views.wallet.cardViewWidgets.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentTransaction;
import com.talabat.talabatcommon.R;
import com.talabat.talabatcommon.model.wallet.WalletCardListDisplayModel;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.CardListFragment;
import com.talabat.talabatcore.TalabatBaseBottomSheetDialogFragment;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0019B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J&\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/view/CardListBottomSheet;", "Lcom/talabat/talabatcore/TalabatBaseBottomSheetDialogFragment;", "Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/view/CardListFragment$CardListFragmentInterface;", "cardListBottomSheet", "Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/view/CardListBottomSheet$CardListBottomSheetInterface;", "(Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/view/CardListBottomSheet$CardListBottomSheetInterface;)V", "attachFragment", "", "onBackButtonClicked", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "updatePositionClicked", "position", "", "updateWalletCardList", "walletCardListDisplayModel", "Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;", "CardListBottomSheetInterface", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CardListBottomSheet extends TalabatBaseBottomSheetDialogFragment implements CardListFragment.CardListFragmentInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Nullable
    private final CardListBottomSheetInterface cardListBottomSheet;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/view/CardListBottomSheet$CardListBottomSheetInterface;", "", "updatePositionClicked", "", "position", "", "updateWalletCardList", "walletCardListDisplayModel", "Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface CardListBottomSheetInterface {
        void updatePositionClicked(int i11);

        void updateWalletCardList(@NotNull WalletCardListDisplayModel walletCardListDisplayModel);
    }

    public CardListBottomSheet(@Nullable CardListBottomSheetInterface cardListBottomSheetInterface) {
        this.cardListBottomSheet = cardListBottomSheetInterface;
    }

    private final void attachFragment() {
        CardListFragment cardListFragment = new CardListFragment(this, (CardListFragment.CardListDefaultCardInterface) null, 2, (DefaultConstructorMarker) null);
        cardListFragment.setArguments(getArguments());
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "childFragmentManager.beginTransaction()");
        beginTransaction.replace(R.id.child_fragment_container, cardListFragment).commit();
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

    public void onBackButtonClicked() {
        dismiss();
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.bottom_sheet_container, viewGroup, false);
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        attachFragment();
    }

    public void updatePositionClicked(int i11) {
        CardListBottomSheetInterface cardListBottomSheetInterface = this.cardListBottomSheet;
        if (cardListBottomSheetInterface != null) {
            cardListBottomSheetInterface.updatePositionClicked(i11);
        }
    }

    public void updateWalletCardList(@NotNull WalletCardListDisplayModel walletCardListDisplayModel) {
        Intrinsics.checkNotNullParameter(walletCardListDisplayModel, "walletCardListDisplayModel");
        CardListBottomSheetInterface cardListBottomSheetInterface = this.cardListBottomSheet;
        if (cardListBottomSheetInterface != null) {
            cardListBottomSheetInterface.updateWalletCardList(walletCardListDisplayModel);
        }
    }
}
