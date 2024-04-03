package com.talabat.talabatlife.ui.vendorList.views;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.compose.DialogNavigator;
import com.talabat.talabatcommon.extentions.IntKt;
import com.talabat.talabatcommon.utils.AnimationHelper;
import com.talabat.talabatcommon.utils.AnimationSpeed;
import com.talabat.talabatcore.TalabatBaseBottomSheetDialogFragment;
import com.talabat.talabatlife.R;
import com.talabat.talabatlife.ui.vendorList.model.VendorLocationFilterDisplayModel;
import com.talabat.talabatlife.ui.vendorList.views.VendorLocationFilterFragment;
import com.talabat.talabatnavigation.tLife.TLifeNavigationActions;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001,BO\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001b\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u0019H\u0016J\u0018\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u000eH\u0016J&\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020)H\u0016J\u001a\u0010*\u001a\u00020\u00192\u0006\u0010+\u001a\u00020!2\b\u0010&\u001a\u0004\u0018\u00010\u0017H\u0016R\u0012\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u0012\u0010\n\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/talabat/talabatlife/ui/vendorList/views/VendorsLocationFilterBottomSheet;", "Lcom/talabat/talabatcore/TalabatBaseBottomSheetDialogFragment;", "Lcom/talabat/talabatlife/ui/vendorList/views/VendorLocationFilterFragment$VendorLocationFilterFragmentInterface;", "Lcom/talabat/talabatcommon/utils/AnimationHelper;", "vendorLocationFilterList", "Ljava/util/ArrayList;", "Lcom/talabat/talabatlife/ui/vendorList/model/VendorLocationFilterDisplayModel;", "Lkotlin/collections/ArrayList;", "currentLocationLatitude", "", "currentLocationLongitude", "currentCityName", "", "chosenAreaId", "", "listener", "Lcom/talabat/talabatlife/ui/vendorList/views/VendorsLocationFilterBottomSheet$VendorsLocationFilterBottomSheetInterface;", "(Ljava/util/ArrayList;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Integer;Lcom/talabat/talabatlife/ui/vendorList/views/VendorsLocationFilterBottomSheet$VendorsLocationFilterBottomSheetInterface;)V", "Ljava/lang/Integer;", "Ljava/lang/Double;", "currentLocationModel", "currentPosition", "addValueToBundle", "Landroid/os/Bundle;", "attachFragment", "", "closeBottomSheet", "closeBottomSheetFromDialog", "dismissButtonSheet", "onChangeSelectedPosition", "vendorLocationFilterDisplayModel", "position", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onViewCreated", "view", "VendorsLocationFilterBottomSheetInterface", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorsLocationFilterBottomSheet extends TalabatBaseBottomSheetDialogFragment implements VendorLocationFilterFragment.VendorLocationFilterFragmentInterface, AnimationHelper {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Nullable
    private final Integer chosenAreaId;
    @Nullable
    private final String currentCityName;
    @Nullable
    private final Double currentLocationLatitude;
    @Nullable
    private final Double currentLocationLongitude;
    @Nullable
    private VendorLocationFilterDisplayModel currentLocationModel;
    @Nullable
    private Integer currentPosition;
    @Nullable
    private final VendorsLocationFilterBottomSheetInterface listener;
    @NotNull
    private final ArrayList<VendorLocationFilterDisplayModel> vendorLocationFilterList;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/talabatlife/ui/vendorList/views/VendorsLocationFilterBottomSheet$VendorsLocationFilterBottomSheetInterface;", "", "onLocationChange", "", "vendorLocationFilterDisplayModel", "Lcom/talabat/talabatlife/ui/vendorList/model/VendorLocationFilterDisplayModel;", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface VendorsLocationFilterBottomSheetInterface {
        void onLocationChange(@Nullable VendorLocationFilterDisplayModel vendorLocationFilterDisplayModel);
    }

    public VendorsLocationFilterBottomSheet(@NotNull ArrayList<VendorLocationFilterDisplayModel> arrayList, @Nullable Double d11, @Nullable Double d12, @Nullable String str, @Nullable Integer num, @Nullable VendorsLocationFilterBottomSheetInterface vendorsLocationFilterBottomSheetInterface) {
        Intrinsics.checkNotNullParameter(arrayList, "vendorLocationFilterList");
        this.vendorLocationFilterList = arrayList;
        this.currentLocationLatitude = d11;
        this.currentLocationLongitude = d12;
        this.currentCityName = str;
        this.chosenAreaId = num;
        this.listener = vendorsLocationFilterBottomSheetInterface;
    }

    private final Bundle addValueToBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(TLifeNavigationActions.EXTRA_VENDOR_FILTER_LOCATION_LIST, this.vendorLocationFilterList);
        Double d11 = this.currentLocationLatitude;
        if (d11 != null) {
            bundle.putDouble(TLifeNavigationActions.EXTRA_VENDOR_FILTER_CURRENT_LATITUDE, d11.doubleValue());
        }
        Double d12 = this.currentLocationLongitude;
        if (d12 != null) {
            bundle.putDouble(TLifeNavigationActions.EXTRA_VENDOR_FILTER_CURRENT_LONGITUDE, d12.doubleValue());
        }
        String str = this.currentCityName;
        if (str == null) {
            str = "";
        }
        bundle.putString(TLifeNavigationActions.EXTRA_VENDOR_FILTER_CURRENT_CITY, str);
        bundle.putInt("area_id", IntKt.orZero(this.chosenAreaId));
        return bundle;
    }

    private final void attachFragment() {
        VendorLocationFilterFragment vendorLocationFilterFragment = new VendorLocationFilterFragment(this);
        vendorLocationFilterFragment.setArguments(addValueToBundle());
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "childFragmentManager.beginTransaction()");
        beginTransaction.replace(R.id.child_fragment_container, vendorLocationFilterFragment).commit();
    }

    private final void closeBottomSheetFromDialog() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            int i11 = R.id.root_view;
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) dialog.findViewById(i11);
            Intrinsics.checkNotNullExpressionValue(coordinatorLayout, "it.root_view");
            adjustViewHeight(coordinatorLayout, ((CoordinatorLayout) dialog.findViewById(i11)).getHeight(), 0, AnimationSpeed.NORMAL);
            delay(500, new VendorsLocationFilterBottomSheet$closeBottomSheetFromDialog$1$1(dialog));
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

    public void closeBottomSheet() {
        closeBottomSheetFromDialog();
    }

    public void delay(long j11, @NotNull Function0<Unit> function0) {
        AnimationHelper.DefaultImpls.delay(this, j11, function0);
    }

    public void dismissButtonSheet() {
        dismiss();
    }

    public void onChangeSelectedPosition(@NotNull VendorLocationFilterDisplayModel vendorLocationFilterDisplayModel, int i11) {
        Intrinsics.checkNotNullParameter(vendorLocationFilterDisplayModel, "vendorLocationFilterDisplayModel");
        this.currentLocationModel = vendorLocationFilterDisplayModel;
        this.currentPosition = Integer.valueOf(i11);
        closeBottomSheetFromDialog();
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.bottom_sheet_vendor_location_filter, viewGroup, false);
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onDismiss(@NotNull DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dialogInterface, DialogNavigator.NAME);
        super.onDismiss(dialogInterface);
        VendorsLocationFilterBottomSheetInterface vendorsLocationFilterBottomSheetInterface = this.listener;
        if (vendorsLocationFilterBottomSheetInterface != null) {
            vendorsLocationFilterBottomSheetInterface.onLocationChange(this.currentLocationModel);
        }
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        attachFragment();
    }
}
