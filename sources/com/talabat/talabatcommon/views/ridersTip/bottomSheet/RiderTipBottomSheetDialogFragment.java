package com.talabat.talabatcommon.views.ridersTip.bottomSheet;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentTransaction;
import com.talabat.talabatcommon.R;
import com.talabat.talabatcommon.enums.OrderStatus;
import com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.entity.TipRiderBottomSheetState;
import com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.entity.TipRiderSource;
import com.talabat.talabatcommon.model.wallet.WalletCardListDisplayModel;
import com.talabat.talabatcommon.utils.AnimationHelper;
import com.talabat.talabatcommon.utils.AnimationSpeed;
import com.talabat.talabatcommon.views.ridersTip.bottomSheet.RiderTipFragment;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.CardListBottomSheet;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.CardListFragment;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView;
import com.talabat.talabatcore.TalabatBaseBottomSheetDialogFragment;
import com.talabat.talabatnavigation.common.TalabatCommonNavigationActions;
import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005BO\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J\u001a\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001f\u001a\u00020\u0018H\u0016J\b\u0010 \u001a\u00020\u001dH\u0002J\b\u0010!\u001a\u00020\u001dH\u0016J\b\u0010\"\u001a\u00020\u001dH\u0002J\b\u0010#\u001a\u00020\u001dH\u0016J&\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u001a\u0010,\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020%2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u0010.\u001a\u00020\u001dH\u0016J\u0010\u0010/\u001a\u00020\u001d2\u0006\u00100\u001a\u00020\u0018H\u0016J\u0010\u00101\u001a\u00020\u001d2\u0006\u00102\u001a\u00020\u001bH\u0016R\u000e\u0010\u0010\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0004¢\u0006\u0004\n\u0002\u0010\u0019R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/talabat/talabatcommon/views/ridersTip/bottomSheet/RiderTipBottomSheetDialogFragment;", "Lcom/talabat/talabatcore/TalabatBaseBottomSheetDialogFragment;", "Lcom/talabat/talabatcommon/utils/AnimationHelper;", "Lcom/talabat/talabatcommon/views/ridersTip/bottomSheet/RiderTipFragment$RiderTipFragmentInterface;", "Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/view/CardListBottomSheet$CardListBottomSheetInterface;", "Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/view/CardListFragment$CardListFragmentInterface;", "statusListenerRider", "Lcom/talabat/talabatcommon/views/ridersTip/bottomSheet/RiderTipStatusListener;", "tipRiderBottomSheetStatus", "Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/entity/TipRiderBottomSheetState;", "tipRiderSource", "Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/entity/TipRiderSource;", "orderStatus", "Lcom/talabat/talabatcommon/enums/OrderStatus;", "orderId", "", "encryptedOrderId", "screenName", "selectedTipValue", "", "(Lcom/talabat/talabatcommon/views/ridersTip/bottomSheet/RiderTipStatusListener;Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/entity/TipRiderBottomSheetState;Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/entity/TipRiderSource;Lcom/talabat/talabatcommon/enums/OrderStatus;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;)V", "riderTipFragment", "Lcom/talabat/talabatcommon/views/ridersTip/bottomSheet/RiderTipFragment;", "selectedPosition", "", "Ljava/lang/Float;", "walletCardList", "Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;", "attachCardList", "", "cardListData", "viewHeight", "attachFragment", "closeBottomSheet", "closeBottomSheetFromDialog", "onBackButtonClicked", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "riderTippedSuccessfully", "updatePositionClicked", "position", "updateWalletCardList", "walletCardListDisplayModel", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RiderTipBottomSheetDialogFragment extends TalabatBaseBottomSheetDialogFragment implements AnimationHelper, RiderTipFragment.RiderTipFragmentInterface, CardListBottomSheet.CardListBottomSheetInterface, CardListFragment.CardListFragmentInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    @NotNull
    private final String encryptedOrderId;
    @NotNull
    private final String orderId;
    @Nullable
    private final OrderStatus orderStatus;
    @Nullable
    private RiderTipFragment riderTipFragment;
    @NotNull
    private final String screenName;
    private int selectedPosition;
    @Nullable
    private final Float selectedTipValue;
    @Nullable
    private final RiderTipStatusListener statusListenerRider;
    @NotNull
    private final TipRiderBottomSheetState tipRiderBottomSheetStatus;
    @NotNull
    private final TipRiderSource tipRiderSource;
    @NotNull
    private WalletCardListDisplayModel walletCardList;

    public RiderTipBottomSheetDialogFragment(@Nullable RiderTipStatusListener riderTipStatusListener, @NotNull TipRiderBottomSheetState tipRiderBottomSheetState, @NotNull TipRiderSource tipRiderSource2, @Nullable OrderStatus orderStatus2, @NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable Float f11) {
        Intrinsics.checkNotNullParameter(tipRiderBottomSheetState, "tipRiderBottomSheetStatus");
        Intrinsics.checkNotNullParameter(tipRiderSource2, "tipRiderSource");
        Intrinsics.checkNotNullParameter(str, "orderId");
        Intrinsics.checkNotNullParameter(str2, "encryptedOrderId");
        Intrinsics.checkNotNullParameter(str3, "screenName");
        this._$_findViewCache = new LinkedHashMap();
        this.statusListenerRider = riderTipStatusListener;
        this.tipRiderBottomSheetStatus = tipRiderBottomSheetState;
        this.tipRiderSource = tipRiderSource2;
        this.orderStatus = orderStatus2;
        this.orderId = str;
        this.encryptedOrderId = str2;
        this.screenName = str3;
        this.selectedTipValue = f11;
        this.walletCardList = new WalletCardListDisplayModel((List) null, false, 0, 7, (DefaultConstructorMarker) null);
    }

    private final void attachFragment() {
        RiderTipFragment riderTipFragment2 = new RiderTipFragment(this, this.tipRiderBottomSheetStatus, this.tipRiderSource, this.orderStatus, this.orderId, this.encryptedOrderId, this.screenName, this.selectedTipValue);
        this.riderTipFragment = riderTipFragment2;
        riderTipFragment2.setArguments(getArguments());
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "childFragmentManager.beginTransaction()");
        RiderTipFragment riderTipFragment3 = this.riderTipFragment;
        if (riderTipFragment3 != null) {
            beginTransaction.replace(R.id.child_fragment_container, riderTipFragment3).commit();
        }
    }

    private final void closeBottomSheetFromDialog() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            int i11 = R.id.root_view;
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) dialog.findViewById(i11);
            Intrinsics.checkNotNullExpressionValue(coordinatorLayout, "it.root_view");
            adjustViewHeight(coordinatorLayout, ((CoordinatorLayout) dialog.findViewById(i11)).getHeight(), 0, AnimationSpeed.NORMAL);
            delay(500, new RiderTipBottomSheetDialogFragment$closeBottomSheetFromDialog$1$1(dialog));
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

    public void attachCardList(@Nullable WalletCardListDisplayModel walletCardListDisplayModel, int i11) {
        CardListFragment cardListFragment$default = DefaultCardView.Companion.getCardListFragment$default(DefaultCardView.Companion, walletCardListDisplayModel, this, (CardListFragment.CardListDefaultCardInterface) null, 4, (Object) null);
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "childFragmentManager.beginTransaction()");
        Bundle bundle = new Bundle();
        bundle.putInt(TalabatCommonNavigationActions.EXTRA_WALLET_PAYMENT_WIDGET_CARD_LIST_HEIGHT, i11);
        Bundle arguments = cardListFragment$default.getArguments();
        if (arguments != null) {
            arguments.putBundle(TalabatCommonNavigationActions.EXTRA_WALLET_PAYMENT_WIDGET_CARD_LIST_BUNDLE_KEY, bundle);
        }
        beginTransaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, 17432578, 17432579);
        beginTransaction.replace(R.id.child_fragment_container, cardListFragment$default).addToBackStack("riderTipFragment").commit();
    }

    public void closeBottomSheet() {
        closeBottomSheetFromDialog();
    }

    public void delay(long j11, @NotNull Function0<Unit> function0) {
        AnimationHelper.DefaultImpls.delay(this, j11, function0);
    }

    public void onBackButtonClicked() {
        boolean z11;
        Bundle bundle = new Bundle();
        bundle.putInt(CardListFragment.SELECTED_POSITION, this.selectedPosition);
        bundle.putString("encryptedOrderId", this.encryptedOrderId);
        bundle.putString("orderId", this.orderId);
        bundle.putString("screen_type", this.screenName);
        Collection cardList = this.walletCardList.getCardList();
        if (cardList == null || cardList.isEmpty()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            bundle.putParcelable(WalletNavigatorActions.EXTRA_UPDATE_WALLET_CARD_LIST, this.walletCardList);
        }
        RiderTipFragment riderTipFragment2 = this.riderTipFragment;
        if (riderTipFragment2 != null) {
            riderTipFragment2.setArguments(bundle);
        }
        getChildFragmentManager().popBackStack();
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

    public void riderTippedSuccessfully() {
        RiderTipStatusListener riderTipStatusListener = this.statusListenerRider;
        if (riderTipStatusListener != null) {
            riderTipStatusListener.riderTippedSuccessfully();
        }
    }

    public void updatePositionClicked(int i11) {
        this.selectedPosition = i11;
    }

    public void updateWalletCardList(@NotNull WalletCardListDisplayModel walletCardListDisplayModel) {
        Intrinsics.checkNotNullParameter(walletCardListDisplayModel, "walletCardListDisplayModel");
        this.walletCardList = walletCardListDisplayModel;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RiderTipBottomSheetDialogFragment(com.talabat.talabatcommon.views.ridersTip.bottomSheet.RiderTipStatusListener r13, com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.entity.TipRiderBottomSheetState r14, com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.entity.TipRiderSource r15, com.talabat.talabatcommon.enums.OrderStatus r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.Float r20, int r21, kotlin.jvm.internal.DefaultConstructorMarker r22) {
        /*
            r12 = this;
            r0 = r21
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r4 = r2
            goto L_0x000a
        L_0x0009:
            r4 = r13
        L_0x000a:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0010
            r11 = r2
            goto L_0x0012
        L_0x0010:
            r11 = r20
        L_0x0012:
            r3 = r12
            r5 = r14
            r6 = r15
            r7 = r16
            r8 = r17
            r9 = r18
            r10 = r19
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.views.ridersTip.bottomSheet.RiderTipBottomSheetDialogFragment.<init>(com.talabat.talabatcommon.views.ridersTip.bottomSheet.RiderTipStatusListener, com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.entity.TipRiderBottomSheetState, com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.entity.TipRiderSource, com.talabat.talabatcommon.enums.OrderStatus, java.lang.String, java.lang.String, java.lang.String, java.lang.Float, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
