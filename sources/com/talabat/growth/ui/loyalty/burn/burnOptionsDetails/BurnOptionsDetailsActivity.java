package com.talabat.growth.ui.loyalty.burn.burnOptionsDetails;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.designsystem.ds_alert.DSAlert;
import com.designsystem.ds_icon_button.DSIconButtonModel;
import com.talabat.feature.rewards.presentation.DSBottomSheetFragmentWithoutPadding;
import com.talabat.growth.ui.loyalty.burn.burnOptionsDetails.BurnOptionsDetailsFragment;
import com.talabat.growth.ui.loyalty.burn.details.BurnOptionsDetailsDialogFragment;
import com.talabat.growth.ui.loyalty.burn.models.BurnItemDisplayModel;
import com.talabat.growth.ui.util.ExtentionsKt;
import com.talabat.localization.R;
import com.talabat.talabatcore.BaseActivity;
import com.talabat.talabatcore.BaseFragment;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.base.NavigatorModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0002J\f\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/talabat/growth/ui/loyalty/burn/burnOptionsDetails/BurnOptionsDetailsActivity;", "Lcom/talabat/talabatcore/BaseActivity;", "()V", "fragment", "Lcom/talabat/talabatcore/BaseFragment;", "Companion", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BurnOptionsDetailsActivity extends BaseActivity {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String EXTRA_LOYALTY_BURN_DETAILS_ITEM = "BurnDetailsItem";
    @NotNull
    public static final String EXTRA_LOYALTY_BURN_DETAILS_TOTAL_POINTS = "BurnDetailsTotalPoints";
    @NotNull
    public static final String EXTRA_LOYALTY_VOUCHER_POSITION = "EXTRA_LOYALTY_VOUCHER_POSITION";
    @NotNull
    private static final String OPEN_LOYALTY_BURN_OPTIONS_DETAILS_ACTIVITY = "talabat.action.Growth.loyalty.burnOptionsDetails";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J.\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u001e\u0010\u0017\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/talabat/growth/ui/loyalty/burn/burnOptionsDetails/BurnOptionsDetailsActivity$Companion;", "", "()V", "EXTRA_LOYALTY_BURN_DETAILS_ITEM", "", "EXTRA_LOYALTY_BURN_DETAILS_TOTAL_POINTS", "EXTRA_LOYALTY_VOUCHER_POSITION", "OPEN_LOYALTY_BURN_OPTIONS_DETAILS_ACTIVITY", "navigateToActivity", "", "context", "Landroid/content/Context;", "burnItemDisplayModel", "Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemDisplayModel;", "totalPoints", "", "position", "Lcom/talabat/growth/ui/loyalty/burn/burnOptionsDetails/BurnOptionsDetailsFragment$VoucherPosition;", "showBottomSheet", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "dsBottomSheet", "Lcom/talabat/feature/rewards/presentation/DSBottomSheetFragmentWithoutPadding;", "showNotEnoughPointsWarning", "dsAlert", "Lcom/designsystem/ds_alert/DSAlert;", "points", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void navigateToActivity(@NotNull Context context, @NotNull BurnItemDisplayModel burnItemDisplayModel, int i11, @NotNull BurnOptionsDetailsFragment.VoucherPosition voucherPosition) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(burnItemDisplayModel, "burnItemDisplayModel");
            Intrinsics.checkNotNullParameter(voucherPosition, "position");
            Bundle bundle = new Bundle();
            bundle.putParcelable(BurnOptionsDetailsActivity.EXTRA_LOYALTY_BURN_DETAILS_ITEM, burnItemDisplayModel);
            bundle.putInt("BurnDetailsTotalPoints", i11);
            bundle.putParcelable(BurnOptionsDetailsActivity.EXTRA_LOYALTY_VOUCHER_POSITION, voucherPosition);
            Navigator.Companion.navigate(context, new NavigatorModel(BurnOptionsDetailsActivity.OPEN_LOYALTY_BURN_OPTIONS_DETAILS_ACTIVITY, bundle, (Function1) null, 4, (DefaultConstructorMarker) null));
        }

        public final void showBottomSheet(@NotNull FragmentManager fragmentManager, @NotNull DSBottomSheetFragmentWithoutPadding dSBottomSheetFragmentWithoutPadding, @NotNull BurnItemDisplayModel burnItemDisplayModel, int i11, @NotNull BurnOptionsDetailsFragment.VoucherPosition voucherPosition) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics.checkNotNullParameter(dSBottomSheetFragmentWithoutPadding, "dsBottomSheet");
            Intrinsics.checkNotNullParameter(burnItemDisplayModel, "burnItemDisplayModel");
            Intrinsics.checkNotNullParameter(voucherPosition, "position");
            if (!dSBottomSheetFragmentWithoutPadding.isAdded()) {
                Bundle bundle = new Bundle();
                bundle.putParcelable(BurnOptionsDetailsActivity.EXTRA_LOYALTY_BURN_DETAILS_ITEM, burnItemDisplayModel);
                bundle.putInt("BurnDetailsTotalPoints", i11);
                bundle.putParcelable(BurnOptionsDetailsActivity.EXTRA_LOYALTY_VOUCHER_POSITION, voucherPosition);
                BurnOptionsDetailsDialogFragment burnOptionsDetailsDialogFragment = new BurnOptionsDetailsDialogFragment();
                burnOptionsDetailsDialogFragment.setArguments(bundle);
                dSBottomSheetFragmentWithoutPadding.setBody(burnOptionsDetailsDialogFragment);
                dSBottomSheetFragmentWithoutPadding.setWithNavigationBar(false);
                dSBottomSheetFragmentWithoutPadding.show(fragmentManager);
            }
        }

        public final void showNotEnoughPointsWarning(@NotNull Context context, @NotNull DSAlert dSAlert, int i11) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(dSAlert, "dsAlert");
            dSAlert.setDescriptor(context.getString(R.string.loyalty_you_need_more_points_to_redeem, new Object[]{ExtentionsKt.decimalFormat(i11)}));
            dSAlert.setIconButton(new DSIconButtonModel(com.designsystem.marshmallow.R.drawable.ds_close, new BurnOptionsDetailsActivity$Companion$showNotEnoughPointsWarning$1$1(dSAlert)));
            dSAlert.setVisibility(0);
        }
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i11);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    @NotNull
    public BaseFragment fragment() {
        return new BurnOptionsDetailsFragment();
    }
}
