package com.talabat.talabatlife.ui.redeemConfirmation;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.fragment.app.FragmentActivity;
import com.talabat.talabatcore.BaseFragment;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatlife.R;
import com.talabat.talabatlife.ui.redeemConfirmation.viewModel.RedeemConformationViewModel;
import com.talabat.talabatlife.ui.redeemConfirmation.viewModel.RedeemConformationViewModelImpl;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.base.NavigatorModel;
import com.talabat.talabatnavigation.tLife.TLifeNavigationActions;
import java.util.LinkedHashMap;
import java.util.Map;
import jw.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\u001a\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0002J\b\u0010\u0016\u001a\u00020\u0005H\u0002J\b\u0010\u0017\u001a\u00020\u0002H\u0016¨\u0006\u0018"}, d2 = {"Lcom/talabat/talabatlife/ui/redeemConfirmation/OfferRedeemConformationFragment;", "Lcom/talabat/talabatcore/BaseFragment;", "Lcom/talabat/talabatlife/ui/redeemConfirmation/viewModel/RedeemConformationViewModel;", "()V", "failureHere", "", "failure", "Lcom/talabat/talabatcore/exception/Failure;", "getViewModelClass", "Ljava/lang/Class;", "layoutId", "", "navigateToVendorOffers", "activity", "Landroidx/fragment/app/FragmentActivity;", "observatory", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "populateUi", "setupUi", "viewModelBuilder", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OfferRedeemConformationFragment extends BaseFragment {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    private final void navigateToVendorOffers(FragmentActivity fragmentActivity) {
        Navigator.Companion companion = Navigator.Companion;
        NavigatorModel navigatorModel = new NavigatorModel((String) null, (Bundle) null, (Function1) null, 7, (DefaultConstructorMarker) null);
        navigatorModel.setAction(TLifeNavigationActions.OPEN_TALABAT_LIFE_VENDORS_ACTIVITY);
        navigatorModel.setInit(OfferRedeemConformationFragment$navigateToVendorOffers$1$1.INSTANCE);
        Unit unit = Unit.INSTANCE;
        companion.navigate((Context) fragmentActivity, navigatorModel);
    }

    private final void populateUi() {
    }

    private final void setupUi() {
        ((Button) _$_findCachedViewById(R.id.redeemConformationDiscoverMoreButton)).setOnClickListener(new a(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setupUi$lambda-1  reason: not valid java name */
    public static final void m5841setupUi$lambda1(OfferRedeemConformationFragment offerRedeemConformationFragment, View view) {
        Intrinsics.checkNotNullParameter(offerRedeemConformationFragment, "this$0");
        FragmentActivity activity = offerRedeemConformationFragment.getActivity();
        if (activity != null) {
            offerRedeemConformationFragment.navigateToVendorOffers(activity);
            activity.finish();
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

    public void failureHere(@Nullable Failure failure) {
    }

    @NotNull
    public Class<RedeemConformationViewModel> getViewModelClass() {
        return RedeemConformationViewModel.class;
    }

    public int layoutId() {
        return R.layout.frag_offer_redeem_confirmation;
    }

    public void observatory() {
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        setupUi();
        populateUi();
    }

    @NotNull
    public RedeemConformationViewModel viewModelBuilder() {
        return new RedeemConformationViewModelImpl();
    }
}
