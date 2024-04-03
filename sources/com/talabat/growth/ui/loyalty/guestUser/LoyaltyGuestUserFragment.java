package com.talabat.growth.ui.loyalty.guestUser;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.fragment.app.FragmentActivity;
import com.designsystem.ds_button_v2.DSPrimaryButton;
import com.talabat.growth.R;
import com.talabat.talabatcore.BaseFragment;
import com.talabat.talabatcore.exception.Failure;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nr.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\u001a\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0002J\b\u0010\u0013\u001a\u00020\u0002H\u0016¨\u0006\u0014"}, d2 = {"Lcom/talabat/growth/ui/loyalty/guestUser/LoyaltyGuestUserFragment;", "Lcom/talabat/talabatcore/BaseFragment;", "Lcom/talabat/growth/ui/loyalty/guestUser/LoyaltyGuestUserViewModel;", "()V", "failureHere", "", "failure", "Lcom/talabat/talabatcore/exception/Failure;", "getViewModelClass", "Ljava/lang/Class;", "layoutId", "", "observatory", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setupUi", "viewModelBuilder", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoyaltyGuestUserFragment extends BaseFragment {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    private final void setupUi() {
        ((ImageButton) _$_findCachedViewById(R.id.loyaltyGuestBackButton)).setOnClickListener(new a(this));
        ((DSPrimaryButton) _$_findCachedViewById(R.id.loyaltyGuestLoginButton)).setOnTap(new LoyaltyGuestUserFragment$setupUi$2(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setupUi$lambda-1  reason: not valid java name */
    public static final void m10609setupUi$lambda1(LoyaltyGuestUserFragment loyaltyGuestUserFragment, View view) {
        Intrinsics.checkNotNullParameter(loyaltyGuestUserFragment, "this$0");
        FragmentActivity activity = loyaltyGuestUserFragment.getActivity();
        if (activity != null) {
            activity.onBackPressed();
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
    public Class<LoyaltyGuestUserViewModel> getViewModelClass() {
        return LoyaltyGuestUserViewModel.class;
    }

    public int layoutId() {
        return R.layout.frag_loyalty_guest_user;
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
    }

    @NotNull
    public LoyaltyGuestUserViewModel viewModelBuilder() {
        return new LoyaltyGuestUserViewModel();
    }
}
