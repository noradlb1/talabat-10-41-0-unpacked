package com.talabat.talabatlife.ui.vendorList.views;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.talabatcommon.extentions.BooleanKt;
import com.talabat.talabatcommon.utils.AnimationHelper;
import com.talabat.talabatcommon.utils.AnimationSpeed;
import com.talabat.talabatcommon.utils.Conversion;
import com.talabat.talabatlife.R;
import com.talabat.talabatlife.ui.vendorList.model.FilterType;
import com.talabat.talabatlife.ui.vendorList.model.VendorLocationFilterDisplayModel;
import com.talabat.talabatlife.ui.vendorList.views.VendorLocationFilterAdapter;
import com.talabat.talabatnavigation.tLife.TLifeNavigationActions;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nw.d;
import nw.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001%B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J$\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001e\u001a\u00020\nH\u0002J\b\u0010\u001f\u001a\u00020\nH\u0002J\u0010\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\nH\u0002J\b\u0010$\u001a\u00020\nH\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/talabat/talabatlife/ui/vendorList/views/VendorLocationFilterFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/talabat/talabatlife/ui/vendorList/views/VendorLocationFilterAdapter$VendorLocationFilterInterface;", "Lcom/talabat/talabatcommon/utils/AnimationHelper;", "vendorLocationFilterFragmentInterface", "Lcom/talabat/talabatlife/ui/vendorList/views/VendorLocationFilterFragment$VendorLocationFilterFragmentInterface;", "(Lcom/talabat/talabatlife/ui/vendorList/views/VendorLocationFilterFragment$VendorLocationFilterFragmentInterface;)V", "listAdapter", "Lcom/talabat/talabatlife/ui/vendorList/views/VendorLocationFilterAdapter;", "addClearButtonListener", "", "addCloseFragmentListener", "addEditTextListener", "dismissBottomSheet", "getCurrentLocationDisplayModel", "Lcom/talabat/talabatlife/ui/vendorList/model/VendorLocationFilterDisplayModel;", "onChangeSelectedLocation", "vendorLocationFilterDisplayModel", "position", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "populateAdapter", "removeClearButton", "setBottomSheetHeight", "marginTop", "", "setUpUI", "showClearButton", "VendorLocationFilterFragmentInterface", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorLocationFilterFragment extends Fragment implements VendorLocationFilterAdapter.VendorLocationFilterInterface, AnimationHelper, TraceFieldInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    /* access modifiers changed from: private */
    @Nullable
    public VendorLocationFilterAdapter listAdapter;
    @NotNull
    private final VendorLocationFilterFragmentInterface vendorLocationFilterFragmentInterface;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0018\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/talabat/talabatlife/ui/vendorList/views/VendorLocationFilterFragment$VendorLocationFilterFragmentInterface;", "", "closeBottomSheet", "", "dismissButtonSheet", "onChangeSelectedPosition", "vendorLocationFilterDisplayModel", "Lcom/talabat/talabatlife/ui/vendorList/model/VendorLocationFilterDisplayModel;", "position", "", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface VendorLocationFilterFragmentInterface {
        void closeBottomSheet();

        void dismissButtonSheet();

        void onChangeSelectedPosition(@NotNull VendorLocationFilterDisplayModel vendorLocationFilterDisplayModel, int i11);
    }

    public VendorLocationFilterFragment(@NotNull VendorLocationFilterFragmentInterface vendorLocationFilterFragmentInterface2) {
        Intrinsics.checkNotNullParameter(vendorLocationFilterFragmentInterface2, "vendorLocationFilterFragmentInterface");
        this.vendorLocationFilterFragmentInterface = vendorLocationFilterFragmentInterface2;
    }

    private final void addClearButtonListener() {
        int i11 = R.id.clear_button;
        ((ImageView) _$_findCachedViewById(i11)).setVisibility(8);
        ((ImageView) _$_findCachedViewById(i11)).setOnClickListener(new e(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: addClearButtonListener$lambda-6  reason: not valid java name */
    public static final void m5858addClearButtonListener$lambda6(VendorLocationFilterFragment vendorLocationFilterFragment, View view) {
        Intrinsics.checkNotNullParameter(vendorLocationFilterFragment, "this$0");
        ((EditText) vendorLocationFilterFragment._$_findCachedViewById(R.id.search_edit)).getText().clear();
    }

    private final void addCloseFragmentListener() {
        ((ImageView) _$_findCachedViewById(R.id.close_fragment)).setOnClickListener(new d(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: addCloseFragmentListener$lambda-0  reason: not valid java name */
    public static final void m5859addCloseFragmentListener$lambda0(VendorLocationFilterFragment vendorLocationFilterFragment, View view) {
        Intrinsics.checkNotNullParameter(vendorLocationFilterFragment, "this$0");
        vendorLocationFilterFragment.vendorLocationFilterFragmentInterface.closeBottomSheet();
    }

    private final void addEditTextListener() {
        ((EditText) _$_findCachedViewById(R.id.search_edit)).addTextChangedListener(new VendorLocationFilterFragment$addEditTextListener$1(this));
    }

    private final VendorLocationFilterDisplayModel getCurrentLocationDisplayModel() {
        Boolean bool;
        Boolean bool2;
        Double d11;
        Double d12;
        String str = null;
        VendorLocationFilterDisplayModel vendorLocationFilterDisplayModel = new VendorLocationFilterDisplayModel(0, (String) null, (String) null, (Double) null, (Double) null, (FilterType) null, 63, (DefaultConstructorMarker) null);
        Bundle arguments = getArguments();
        if (arguments != null) {
            bool = Boolean.valueOf(arguments.containsKey(TLifeNavigationActions.EXTRA_VENDOR_FILTER_CURRENT_LATITUDE));
        } else {
            bool = null;
        }
        if (BooleanKt.orFalse(bool)) {
            Bundle arguments2 = getArguments();
            if (arguments2 != null) {
                d12 = Double.valueOf(arguments2.getDouble(TLifeNavigationActions.EXTRA_VENDOR_FILTER_CURRENT_LATITUDE));
            } else {
                d12 = null;
            }
            vendorLocationFilterDisplayModel.setLatitude(d12);
        }
        Bundle arguments3 = getArguments();
        if (arguments3 != null) {
            bool2 = Boolean.valueOf(arguments3.containsKey(TLifeNavigationActions.EXTRA_VENDOR_FILTER_CURRENT_LONGITUDE));
        } else {
            bool2 = null;
        }
        if (BooleanKt.orFalse(bool2)) {
            Bundle arguments4 = getArguments();
            if (arguments4 != null) {
                d11 = Double.valueOf(arguments4.getDouble(TLifeNavigationActions.EXTRA_VENDOR_FILTER_CURRENT_LONGITUDE));
            } else {
                d11 = null;
            }
            vendorLocationFilterDisplayModel.setLongitude(d11);
        }
        vendorLocationFilterDisplayModel.setFilterType(FilterType.CURRENT_LOCATION_FILTER);
        Bundle arguments5 = getArguments();
        if (arguments5 != null) {
            str = arguments5.getString(TLifeNavigationActions.EXTRA_VENDOR_FILTER_CURRENT_CITY);
        }
        if (str == null) {
            str = "";
        }
        vendorLocationFilterDisplayModel.setCityName(str);
        String string = getString(com.talabat.localization.R.string.current_location);
        Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo….string.current_location)");
        vendorLocationFilterDisplayModel.setAreaName(string);
        return vendorLocationFilterDisplayModel;
    }

    private final void populateAdapter() {
        ArrayList parcelableArrayList;
        Integer num;
        Bundle arguments = getArguments();
        if (arguments != null && (parcelableArrayList = arguments.getParcelableArrayList(TLifeNavigationActions.EXTRA_VENDOR_FILTER_LOCATION_LIST)) != null) {
            VendorLocationFilterAdapter vendorLocationFilterAdapter = this.listAdapter;
            if (vendorLocationFilterAdapter != null) {
                vendorLocationFilterAdapter.addItem(getCurrentLocationDisplayModel());
            }
            VendorLocationFilterAdapter vendorLocationFilterAdapter2 = this.listAdapter;
            if (vendorLocationFilterAdapter2 != null) {
                vendorLocationFilterAdapter2.addAllItems(parcelableArrayList);
            }
            Bundle arguments2 = getArguments();
            if (arguments2 != null) {
                num = Integer.valueOf(arguments2.getInt("area_id"));
            } else {
                num = null;
            }
            if (num != null) {
                int intValue = num.intValue();
                if (intValue == 0) {
                    VendorLocationFilterAdapter vendorLocationFilterAdapter3 = this.listAdapter;
                    if (vendorLocationFilterAdapter3 != null) {
                        vendorLocationFilterAdapter3.addDefaultSelection();
                        return;
                    }
                    return;
                }
                VendorLocationFilterAdapter vendorLocationFilterAdapter4 = this.listAdapter;
                if (vendorLocationFilterAdapter4 != null) {
                    vendorLocationFilterAdapter4.addChosenArea(intValue);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void removeClearButton() {
        ((ImageView) _$_findCachedViewById(R.id.clear_button)).setVisibility(8);
    }

    private final void setBottomSheetHeight(float f11) {
        WindowManager windowManager;
        Display defaultDisplay;
        Conversion.Companion companion = Conversion.Companion;
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        float dpToPx = companion.dpToPx(f11, resources);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        FragmentActivity activity = getActivity();
        if (!(activity == null || (windowManager = activity.getWindowManager()) == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null)) {
            defaultDisplay.getMetrics(displayMetrics);
        }
        int i11 = displayMetrics.heightPixels;
        int i12 = R.id.location_list_container;
        ViewGroup.LayoutParams layoutParams = ((ConstraintLayout) _$_findCachedViewById(i12)).getLayoutParams();
        layoutParams.height = i11 - ((int) dpToPx);
        layoutParams.width = -1;
        ((ConstraintLayout) _$_findCachedViewById(i12)).setLayoutParams(layoutParams);
    }

    private final void setUpUI() {
        Context context = getContext();
        if (context != null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            this.listAdapter = new VendorLocationFilterAdapter(this, context);
            RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.vendor_location_list);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(this.listAdapter);
            recyclerView.setNestedScrollingEnabled(false);
        }
    }

    /* access modifiers changed from: private */
    public final void showClearButton() {
        ((ImageView) _$_findCachedViewById(R.id.clear_button)).setVisibility(0);
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

    public void dismissBottomSheet() {
        this.vendorLocationFilterFragmentInterface.dismissButtonSheet();
    }

    public void onChangeSelectedLocation(@NotNull VendorLocationFilterDisplayModel vendorLocationFilterDisplayModel, int i11) {
        Intrinsics.checkNotNullParameter(vendorLocationFilterDisplayModel, "vendorLocationFilterDisplayModel");
        this.vendorLocationFilterFragmentInterface.onChangeSelectedPosition(vendorLocationFilterDisplayModel, i11);
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "VendorLocationFilterFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "VendorLocationFilterFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.frag_vendor_list_location_filter, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(\n      …          false\n        )");
        TraceMachine.exitMethod();
        return inflate;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        setBottomSheetHeight(116.0f);
        setUpUI();
        populateAdapter();
        addCloseFragmentListener();
        addEditTextListener();
        addClearButtonListener();
    }
}
