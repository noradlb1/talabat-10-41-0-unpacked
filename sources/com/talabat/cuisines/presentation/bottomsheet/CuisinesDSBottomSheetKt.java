package com.talabat.cuisines.presentation.bottomsheet;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ViewParent;
import android.widget.Filterable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import com.designsystem.ds_bottom_sheet_v2.DSBottomSheet;
import com.designsystem.ds_button_v2.DSBaseButton;
import com.designsystem.ds_button_v2.DSPrimaryButton;
import com.designsystem.ds_fixed_footer.DSBaseFixedFooter;
import com.designsystem.ds_fixed_footer.DSFixedFooterWithVerticalButtons;
import com.designsystem.ds_icon_button.DSIconButtonModel;
import com.designsystem.ds_navigation_bar.DSNavigationBar;
import com.designsystem.ds_navigation_bar.DSNavigationBarWithActionButton;
import com.designsystem.ds_navigation_bar.models.DSNavigationBarActionButtonModel;
import com.designsystem.ds_search_field.DSSearchField;
import com.designsystem.marshmallow.R;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.data.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.cuisines.domain.SelectableCuisine;
import com.talabat.cuisines.navigation.StartCuisineViewForResult;
import com.talabat.cuisines.presentation.CuisinesAdapterKt;
import com.talabat.cuisines.presentation.CuisinesScreenKt;
import com.talabat.cuisines.presentation.CuisinesViewModel;
import com.talabat.talabatcommon.extentions.BroadcastsKt;
import com.talabat.talabatcommon.extentions.BundleKt;
import datamodels.Cuisine;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import vh.a;
import vh.b;
import vh.c;

@Metadata(d1 = {"\u0000r\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002\u001a\u0014\u0010\n\u001a\u00020\u000b*\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0002\u001a\f\u0010\u000e\u001a\u00020\u000b*\u00020\u0007H\u0002\u001a\u0014\u0010\u000f\u001a\u00020\u000b*\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0002\u001a\u0014\u0010\u0010\u001a\u00020\u000b*\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0002\u001a\u0014\u0010\u0011\u001a\u00020\u000b*\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0002\u001a\u0014\u0010\u0012\u001a\u00020\u000b*\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0002\u001aH\u0010\u0013\u001a\u00020\u000b*\u00020\u00142\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t2\u001c\u0010\u0016\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00180\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001bH\u0000\u001a\f\u0010\u001c\u001a\u00020\u000b*\u00020\u0007H\u0002\u001a\f\u0010\u001d\u001a\u00020\u001e*\u00020\u0014H\u0002\u001a\f\u0010\u001f\u001a\u00020 *\u00020\u0014H\u0002\u001a\u000e\u0010!\u001a\u0004\u0018\u00010\"*\u00020\u0007H\u0002\u001a\u000e\u0010#\u001a\u0004\u0018\u00010$*\u00020\u0007H\u0002\u001a\u000e\u0010%\u001a\u0004\u0018\u00010&*\u00020\u0007H\u0002\u001a\u0014\u0010'\u001a\u00020\u000b*\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0002\u001a\u0014\u0010(\u001a\u00020\u000b*\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0002\u001a@\u0010)\u001a\u00020\u000b*\u00020\u00142\u0006\u0010*\u001a\u00020\"2\u001c\u0010\u0016\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00180\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001bH\u0000\u001a\u001a\u0010+\u001a\u00020\u000b*\u00020\u00072\f\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"BOTTOM_SHEET_MAX_HEIGHT", "", "EXTRA_DS_BOTTOM_SHEET_CUISINE", "", "EXTRA_DS_BOTTOM_SHEET_SHOP_CATEGORY", "EXTRA_DS_BOTTOM_SHEET_SUCCESS", "getBody", "Lcom/talabat/cuisines/presentation/bottomsheet/CuisinesDSBottomSheetBodyFragment;", "isCollection", "", "bindApplyClick", "", "viewModel", "Lcom/talabat/cuisines/presentation/CuisinesViewModel;", "bindCancelClick", "bindCuisines", "bindCuisinesAdapter", "bindCuisinesAdapterWithPopular", "bindResetClick", "createAndShowCuisinesDSBottomSheet", "Landroidx/appcompat/app/AppCompatActivity;", "isPickup", "callbacks", "Lcom/talabat/cuisines/navigation/StartCuisineViewForResult;", "Lkotlin/Pair;", "Ldatamodels/Cuisine;", "onDismiss", "Lkotlin/Function0;", "filterCuisines", "getFooter", "Lcom/designsystem/ds_fixed_footer/DSBaseFixedFooter;", "getNavigationBar", "Lcom/designsystem/ds_navigation_bar/DSNavigationBar;", "parent", "Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;", "parentFooter", "Lcom/designsystem/ds_fixed_footer/DSFixedFooterWithVerticalButtons;", "parentNavigationBar", "Lcom/designsystem/ds_navigation_bar/DSNavigationBarWithActionButton;", "registerToCuisineClick", "registerToCuisineClickWithPopular", "updateCuisinesDSBottomSheet", "bottomSheet", "updateDoneBtn", "cuisines", "", "Lcom/talabat/cuisines/domain/SelectableCuisine;", "com_talabat_Components_cuisines_cuisines"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class CuisinesDSBottomSheetKt {
    private static final double BOTTOM_SHEET_MAX_HEIGHT = 0.95d;
    @NotNull
    private static final String EXTRA_DS_BOTTOM_SHEET_CUISINE = "EXTRA_DS_BOTTOM_SHEET_CUISINE";
    @NotNull
    private static final String EXTRA_DS_BOTTOM_SHEET_SHOP_CATEGORY = "EXTRA_DS_BOTTOM_SHEET_SHOP_CATEGORY";
    @NotNull
    private static final String EXTRA_DS_BOTTOM_SHEET_SUCCESS = "EXTRA_DS_BOTTOM_SHEET_SUCCESS";

    /* access modifiers changed from: private */
    public static final void bindApplyClick(CuisinesDSBottomSheetBodyFragment cuisinesDSBottomSheetBodyFragment, CuisinesViewModel cuisinesViewModel) {
        List<DSBaseButton> buttons;
        DSBaseButton dSBaseButton;
        DSFixedFooterWithVerticalButtons parentFooter = parentFooter(cuisinesDSBottomSheetBodyFragment);
        if (parentFooter != null && (buttons = parentFooter.getButtons()) != null && (dSBaseButton = (DSBaseButton) CollectionsKt___CollectionsKt.firstOrNull(buttons)) != null) {
            dSBaseButton.setOnTap(new CuisinesDSBottomSheetKt$bindApplyClick$1$1(dSBaseButton, cuisinesViewModel, cuisinesDSBottomSheetBodyFragment));
        }
    }

    /* access modifiers changed from: private */
    public static final void bindCancelClick(CuisinesDSBottomSheetBodyFragment cuisinesDSBottomSheetBodyFragment) {
        DSNavigationBarWithActionButton parentNavigationBar = parentNavigationBar(cuisinesDSBottomSheetBodyFragment);
        if (parentNavigationBar != null) {
            parentNavigationBar.setLeadingIconButton(new DSIconButtonModel(R.drawable.ds_close, new CuisinesDSBottomSheetKt$bindCancelClick$1(cuisinesDSBottomSheetBodyFragment)));
        }
    }

    /* access modifiers changed from: private */
    public static final void bindCuisines(CuisinesDSBottomSheetBodyFragment cuisinesDSBottomSheetBodyFragment, CuisinesViewModel cuisinesViewModel) {
        if (ITalabatExperiment.DefaultImpls.getBooleanVariant$default(TalabatExperiment.INSTANCE, TalabatExperimentConstants.CAN_SHOW_POPULAR_CUISNES, false, (TalabatExperimentDataSourceStrategy) null, 4, (Object) null)) {
            bindCuisinesAdapterWithPopular(cuisinesDSBottomSheetBodyFragment, cuisinesViewModel);
        } else {
            bindCuisinesAdapter(cuisinesDSBottomSheetBodyFragment, cuisinesViewModel);
        }
    }

    private static final void bindCuisinesAdapter(CuisinesDSBottomSheetBodyFragment cuisinesDSBottomSheetBodyFragment, CuisinesViewModel cuisinesViewModel) {
        CuisinesDSBottomSheetAdapter cuisinesDSBottomSheetAdapter = new CuisinesDSBottomSheetAdapter();
        ((RecyclerView) cuisinesDSBottomSheetBodyFragment._$_findCachedViewById(com.talabat.cuisines.R.id.cuisineRecyclerView)).setAdapter(cuisinesDSBottomSheetAdapter);
        cuisinesViewModel.getCuisines().observe(cuisinesDSBottomSheetBodyFragment, new c(cuisinesDSBottomSheetAdapter, cuisinesDSBottomSheetBodyFragment));
        ((DSSearchField) cuisinesDSBottomSheetBodyFragment._$_findCachedViewById(com.talabat.cuisines.R.id.searchField)).setOnTextChange(new CuisinesDSBottomSheetKt$bindCuisinesAdapter$2(cuisinesDSBottomSheetAdapter));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindCuisinesAdapter$lambda-6  reason: not valid java name */
    public static final void m9625bindCuisinesAdapter$lambda6(CuisinesDSBottomSheetAdapter cuisinesDSBottomSheetAdapter, CuisinesDSBottomSheetBodyFragment cuisinesDSBottomSheetBodyFragment, List list) {
        Intrinsics.checkNotNullParameter(cuisinesDSBottomSheetAdapter, "$adapter");
        Intrinsics.checkNotNullParameter(cuisinesDSBottomSheetBodyFragment, "$this_bindCuisinesAdapter");
        Intrinsics.checkNotNullExpressionValue(list, "it");
        cuisinesDSBottomSheetAdapter.setAllCuisines$com_talabat_Components_cuisines_cuisines(list);
        updateDoneBtn(cuisinesDSBottomSheetBodyFragment, list);
    }

    private static final void bindCuisinesAdapterWithPopular(CuisinesDSBottomSheetBodyFragment cuisinesDSBottomSheetBodyFragment, CuisinesViewModel cuisinesViewModel) {
        PopularCuisinesDSBottomSheetAdapter popularCuisinesDSBottomSheetAdapter = new PopularCuisinesDSBottomSheetAdapter();
        ((RecyclerView) cuisinesDSBottomSheetBodyFragment._$_findCachedViewById(com.talabat.cuisines.R.id.cuisineRecyclerView)).setAdapter(popularCuisinesDSBottomSheetAdapter);
        cuisinesViewModel.getShowCuisinesWithPopular().observe(cuisinesDSBottomSheetBodyFragment, new a(popularCuisinesDSBottomSheetAdapter));
        cuisinesViewModel.getCuisines().observe(cuisinesDSBottomSheetBodyFragment, new b(popularCuisinesDSBottomSheetAdapter, cuisinesDSBottomSheetBodyFragment));
        ((DSSearchField) cuisinesDSBottomSheetBodyFragment._$_findCachedViewById(com.talabat.cuisines.R.id.searchField)).setOnTextChange(new CuisinesDSBottomSheetKt$bindCuisinesAdapterWithPopular$3(popularCuisinesDSBottomSheetAdapter));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindCuisinesAdapterWithPopular$lambda-4  reason: not valid java name */
    public static final void m9626bindCuisinesAdapterWithPopular$lambda4(PopularCuisinesDSBottomSheetAdapter popularCuisinesDSBottomSheetAdapter, List list) {
        Intrinsics.checkNotNullParameter(popularCuisinesDSBottomSheetAdapter, "$adapter");
        Intrinsics.checkNotNullExpressionValue(list, "it");
        popularCuisinesDSBottomSheetAdapter.setAllCuisinesWithPopular$com_talabat_Components_cuisines_cuisines(list);
    }

    /* access modifiers changed from: private */
    /* renamed from: bindCuisinesAdapterWithPopular$lambda-5  reason: not valid java name */
    public static final void m9627bindCuisinesAdapterWithPopular$lambda5(PopularCuisinesDSBottomSheetAdapter popularCuisinesDSBottomSheetAdapter, CuisinesDSBottomSheetBodyFragment cuisinesDSBottomSheetBodyFragment, List list) {
        Intrinsics.checkNotNullParameter(popularCuisinesDSBottomSheetAdapter, "$adapter");
        Intrinsics.checkNotNullParameter(cuisinesDSBottomSheetBodyFragment, "$this_bindCuisinesAdapterWithPopular");
        Intrinsics.checkNotNullExpressionValue(list, "it");
        popularCuisinesDSBottomSheetAdapter.setAllCuisines$com_talabat_Components_cuisines_cuisines(list);
        updateDoneBtn(cuisinesDSBottomSheetBodyFragment, list);
    }

    /* access modifiers changed from: private */
    public static final void bindResetClick(CuisinesDSBottomSheetBodyFragment cuisinesDSBottomSheetBodyFragment, CuisinesViewModel cuisinesViewModel) {
        DSNavigationBarWithActionButton parentNavigationBar = parentNavigationBar(cuisinesDSBottomSheetBodyFragment);
        if (parentNavigationBar != null) {
            String string = cuisinesDSBottomSheetBodyFragment.getString(com.talabat.localization.R.string.clear_all);
            Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo…ation.R.string.clear_all)");
            parentNavigationBar.setActionButton(new DSNavigationBarActionButtonModel(string, new CuisinesDSBottomSheetKt$bindResetClick$1(cuisinesDSBottomSheetBodyFragment, cuisinesViewModel)));
        }
    }

    public static final void createAndShowCuisinesDSBottomSheet(@NotNull AppCompatActivity appCompatActivity, boolean z11, boolean z12, @NotNull StartCuisineViewForResult<Pair<Cuisine, String>> startCuisineViewForResult, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "<this>");
        Intrinsics.checkNotNullParameter(startCuisineViewForResult, "callbacks");
        Intrinsics.checkNotNullParameter(function0, "onDismiss");
        DSBottomSheet dSBottomSheet = new DSBottomSheet();
        updateCuisinesDSBottomSheet(appCompatActivity, dSBottomSheet, startCuisineViewForResult, function0);
        dSBottomSheet.setBody(getBody(z11));
        FragmentManager supportFragmentManager = appCompatActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        dSBottomSheet.show(supportFragmentManager);
    }

    /* access modifiers changed from: private */
    public static final void filterCuisines(CuisinesDSBottomSheetBodyFragment cuisinesDSBottomSheetBodyFragment) {
        RecyclerView.Adapter adapter = ((RecyclerView) cuisinesDSBottomSheetBodyFragment._$_findCachedViewById(com.talabat.cuisines.R.id.cuisineRecyclerView)).getAdapter();
        if (adapter != null) {
            ((Filterable) adapter).getFilter().filter(((DSSearchField) cuisinesDSBottomSheetBodyFragment._$_findCachedViewById(com.talabat.cuisines.R.id.searchField)).getText());
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.Filterable");
    }

    private static final CuisinesDSBottomSheetBodyFragment getBody(boolean z11) {
        CuisinesDSBottomSheetBodyFragment cuisinesDSBottomSheetBodyFragment = new CuisinesDSBottomSheetBodyFragment();
        Bundle bundle = new Bundle();
        BundleKt.set(bundle, CuisinesScreenKt.EXTRA_IS_COLLECTION, z11);
        cuisinesDSBottomSheetBodyFragment.setArguments(bundle);
        return cuisinesDSBottomSheetBodyFragment;
    }

    private static final DSBaseFixedFooter getFooter(AppCompatActivity appCompatActivity) {
        DSFixedFooterWithVerticalButtons dSFixedFooterWithVerticalButtons = new DSFixedFooterWithVerticalButtons(appCompatActivity, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Context context = dSFixedFooterWithVerticalButtons.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        DSPrimaryButton dSPrimaryButton = new DSPrimaryButton(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        String string = appCompatActivity.getString(com.talabat.localization.R.string.cuisine_apply);
        Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo…n.R.string.cuisine_apply)");
        dSPrimaryButton.setTitle(string);
        dSFixedFooterWithVerticalButtons.setButtons(CollectionsKt__CollectionsJVMKt.listOf(dSPrimaryButton));
        return dSFixedFooterWithVerticalButtons;
    }

    private static final DSNavigationBar getNavigationBar(AppCompatActivity appCompatActivity) {
        DSNavigationBarWithActionButton dSNavigationBarWithActionButton = new DSNavigationBarWithActionButton(appCompatActivity, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        dSNavigationBarWithActionButton.setTitle(appCompatActivity.getString(com.talabat.localization.R.string.cuisines));
        return dSNavigationBarWithActionButton;
    }

    /* access modifiers changed from: private */
    public static final DSBottomSheet parent(CuisinesDSBottomSheetBodyFragment cuisinesDSBottomSheetBodyFragment) {
        Fragment parentFragment = cuisinesDSBottomSheetBodyFragment.getParentFragment();
        if (parentFragment instanceof DSBottomSheet) {
            return (DSBottomSheet) parentFragment;
        }
        return null;
    }

    private static final DSFixedFooterWithVerticalButtons parentFooter(CuisinesDSBottomSheetBodyFragment cuisinesDSBottomSheetBodyFragment) {
        DSBottomSheet parent = parent(cuisinesDSBottomSheetBodyFragment);
        ViewParent footer = parent != null ? parent.getFooter() : null;
        if (footer instanceof DSFixedFooterWithVerticalButtons) {
            return (DSFixedFooterWithVerticalButtons) footer;
        }
        return null;
    }

    private static final DSNavigationBarWithActionButton parentNavigationBar(CuisinesDSBottomSheetBodyFragment cuisinesDSBottomSheetBodyFragment) {
        DSBottomSheet parent = parent(cuisinesDSBottomSheetBodyFragment);
        ViewParent navigationBar = parent != null ? parent.getNavigationBar() : null;
        if (navigationBar instanceof DSNavigationBarWithActionButton) {
            return (DSNavigationBarWithActionButton) navigationBar;
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static final void registerToCuisineClick(CuisinesDSBottomSheetBodyFragment cuisinesDSBottomSheetBodyFragment, CuisinesViewModel cuisinesViewModel) {
        BroadcastsKt.registerToBroadcast$default((Fragment) cuisinesDSBottomSheetBodyFragment, CuisinesAdapterKt.ACTION_CUISINE_CLICKED, (Lifecycle.State) null, (Function1) new CuisinesDSBottomSheetKt$registerToCuisineClick$1(cuisinesDSBottomSheetBodyFragment, cuisinesViewModel), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void registerToCuisineClickWithPopular(CuisinesDSBottomSheetBodyFragment cuisinesDSBottomSheetBodyFragment, CuisinesViewModel cuisinesViewModel) {
        BroadcastsKt.registerToBroadcast$default((Fragment) cuisinesDSBottomSheetBodyFragment, CuisinesAdapterKt.ACTION_CUISINE_CLICKED, (Lifecycle.State) null, (Function1) new CuisinesDSBottomSheetKt$registerToCuisineClickWithPopular$1(cuisinesDSBottomSheetBodyFragment, cuisinesViewModel), 2, (Object) null);
    }

    public static final void updateCuisinesDSBottomSheet(@NotNull AppCompatActivity appCompatActivity, @NotNull DSBottomSheet dSBottomSheet, @NotNull StartCuisineViewForResult<Pair<Cuisine, String>> startCuisineViewForResult, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "<this>");
        Intrinsics.checkNotNullParameter(dSBottomSheet, "bottomSheet");
        Intrinsics.checkNotNullParameter(startCuisineViewForResult, "callbacks");
        Intrinsics.checkNotNullParameter(function0, "onDismiss");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        dSBottomSheet.setMaxHeightRation(BOTTOM_SHEET_MAX_HEIGHT);
        dSBottomSheet.setNavigationBar(getNavigationBar(appCompatActivity));
        dSBottomSheet.setFooter(getFooter(appCompatActivity));
        dSBottomSheet.setOnShow(new CuisinesDSBottomSheetKt$updateCuisinesDSBottomSheet$1$1(startCuisineViewForResult, dSBottomSheet, objectRef));
        dSBottomSheet.setOnDismiss(new CuisinesDSBottomSheetKt$updateCuisinesDSBottomSheet$1$2(objectRef, dSBottomSheet, startCuisineViewForResult, function0));
    }

    private static final void updateDoneBtn(CuisinesDSBottomSheetBodyFragment cuisinesDSBottomSheetBodyFragment, List<SelectableCuisine> list) {
        DSBaseButton dSBaseButton;
        List<DSBaseButton> buttons;
        DSBaseButton dSBaseButton2;
        Resources resources;
        List<DSBaseButton> buttons2;
        if (ITalabatExperiment.DefaultImpls.getBooleanVariant$default(TalabatExperiment.INSTANCE, TalabatExperimentConstants.COUNTERS_AND_NEW_DESIGN_FILTERS_CUISINES, false, (TalabatExperimentDataSourceStrategy) null, 4, (Object) null)) {
            ArrayList arrayList = new ArrayList();
            for (Object next : list) {
                if (((SelectableCuisine) next).isOn()) {
                    arrayList.add(next);
                }
            }
            int size = arrayList.size();
            String str = null;
            if (size > 0) {
                DSFixedFooterWithVerticalButtons parentFooter = parentFooter(cuisinesDSBottomSheetBodyFragment);
                if (parentFooter == null || (buttons2 = parentFooter.getButtons()) == null) {
                    dSBaseButton2 = null;
                } else {
                    dSBaseButton2 = (DSBaseButton) CollectionsKt___CollectionsKt.firstOrNull(buttons2);
                }
                if (dSBaseButton2 != null) {
                    Context context = cuisinesDSBottomSheetBodyFragment.getContext();
                    if (!(context == null || (resources = context.getResources()) == null)) {
                        str = resources.getQuantityString(com.talabat.localization.R.plurals.numberOfCuisinesSelected, size, new Object[]{Integer.valueOf(size)});
                    }
                    dSBaseButton2.setCaption(str);
                    return;
                }
                return;
            }
            DSFixedFooterWithVerticalButtons parentFooter2 = parentFooter(cuisinesDSBottomSheetBodyFragment);
            if (parentFooter2 == null || (buttons = parentFooter2.getButtons()) == null) {
                dSBaseButton = null;
            } else {
                dSBaseButton = (DSBaseButton) CollectionsKt___CollectionsKt.firstOrNull(buttons);
            }
            if (dSBaseButton != null) {
                dSBaseButton.setCaption((String) null);
            }
        }
    }
}
