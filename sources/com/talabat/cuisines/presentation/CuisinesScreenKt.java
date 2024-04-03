package com.talabat.cuisines.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.data.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.cuisines.CuisinesIntegrator;
import com.talabat.cuisines.CuisinesIntegratorKt;
import com.talabat.cuisines.R;
import com.talabat.cuisines.di.factory.CuisinesViewModelFactory;
import com.talabat.cuisines.domain.SelectableCuisine;
import com.talabat.cuisines.navigation.RouterKt;
import com.talabat.talabatcommon.extentions.BroadcastsKt;
import com.talabat.talabatcommon.extentions.BundleKt;
import com.talabat.talabatcommon.extentions.GsonKt;
import com.talabat.talabatcommon.views.twolinesbutton.TwoLinesButton;
import datamodels.Cuisine;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tracking.AppTracker;
import uh.b;
import uh.c;
import uh.d;
import uh.e;
import uh.f;
import uh.g;
import uh.h;
import uh.i;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002\u001a\u001c\u0010\b\u001a\u00020\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002\u001a\u0014\u0010\r\u001a\u00020\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\u0014\u0010\u000e\u001a\u00020\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\f\u0010\u000f\u001a\u00020\t*\u00020\u0004H\u0002\u001a\u0014\u0010\u0010\u001a\u00020\t*\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\u0014\u0010\u0011\u001a\u00020\t*\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a\u0014\u0010\u0012\u001a\u00020\t*\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a\u0014\u0010\u0013\u001a\u00020\t*\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a\u0014\u0010\u0014\u001a\u00020\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\u0014\u0010\u0015\u001a\u00020\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\u001c\u0010\u0016\u001a\u00020\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002\u001a\u001c\u0010\u0017\u001a\u00020\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002\u001a\f\u0010\u0018\u001a\u00020\t*\u00020\u0019H\u0002\u001a\u001a\u0010\u001a\u001a\u00020\t*\u00020\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002\u001a\f\u0010\u000b\u001a\u00020\f*\u00020\u0004H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"EXTRA_IS_COLLECTION", "", "EXTRA_IS_PICKUP", "CuisinesFragment", "Landroidx/fragment/app/Fragment;", "isCollection", "", "isPickup", "bindApplyClick", "", "Lcom/talabat/cuisines/presentation/CuisinesFragmentMultipleSelection;", "viewModel", "Lcom/talabat/cuisines/presentation/CuisinesViewModel;", "bindBackPress", "bindCancelClick", "bindClearClick", "bindCuisines", "bindCuisinesAdapter", "bindCuisinesAdapterWithPopular", "bindErrors", "bindResetClick", "handleCancel", "registerToCuisineClick", "registerToCuisineClickWithPopular", "replaceCuisinesFragment", "Lcom/talabat/cuisines/presentation/CuisinesActivity;", "updateDoneBtn", "cuisines", "", "Lcom/talabat/cuisines/domain/SelectableCuisine;", "com_talabat_Components_cuisines_cuisines"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class CuisinesScreenKt {
    @NotNull
    public static final String EXTRA_IS_COLLECTION = "isCollection";
    @NotNull
    public static final String EXTRA_IS_PICKUP = "isPickup";

    private static final Fragment CuisinesFragment(boolean z11, boolean z12) {
        CuisinesFragmentMultipleSelection cuisinesFragmentMultipleSelection = new CuisinesFragmentMultipleSelection();
        Bundle bundle = new Bundle();
        BundleKt.set(bundle, EXTRA_IS_COLLECTION, z11);
        BundleKt.set(bundle, EXTRA_IS_PICKUP, z12);
        cuisinesFragmentMultipleSelection.setArguments(bundle);
        return cuisinesFragmentMultipleSelection;
    }

    /* access modifiers changed from: private */
    public static final void bindApplyClick(CuisinesFragmentMultipleSelection cuisinesFragmentMultipleSelection, CuisinesViewModel cuisinesViewModel, boolean z11) {
        ((TwoLinesButton) cuisinesFragmentMultipleSelection._$_findCachedViewById(R.id.doneBtn)).setOnClickListener(new b(cuisinesFragmentMultipleSelection, cuisinesViewModel, z11));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindApplyClick$lambda-13  reason: not valid java name */
    public static final void m9617bindApplyClick$lambda13(CuisinesFragmentMultipleSelection cuisinesFragmentMultipleSelection, CuisinesViewModel cuisinesViewModel, boolean z11, View view) {
        Object obj;
        Cuisine cuisine;
        Intrinsics.checkNotNullParameter(cuisinesFragmentMultipleSelection, "$this_bindApplyClick");
        Intrinsics.checkNotNullParameter(cuisinesViewModel, "$viewModel");
        AppTracker.onRestaurantsCuisineApply(cuisinesFragmentMultipleSelection.getContext(), cuisinesViewModel.getShopCategorySelected().invoke(), z11);
        FragmentActivity activity = cuisinesFragmentMultipleSelection.getActivity();
        if (activity != null) {
            Intent intent = new Intent();
            List value = cuisinesViewModel.getCuisines().getValue();
            String str = null;
            if (value != null) {
                Intrinsics.checkNotNullExpressionValue(value, "value");
                Iterator it = value.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (((SelectableCuisine) obj).isOn()) {
                        break;
                    }
                }
                SelectableCuisine selectableCuisine = (SelectableCuisine) obj;
                if (!(selectableCuisine == null || (cuisine = selectableCuisine.getCuisine()) == null)) {
                    str = GsonKt.toJson$default(cuisine, (Gson) null, 1, (Object) null);
                }
            }
            intent.putExtra(CuisinesAdapterKt.EXTRA_CUISINE, str);
            intent.putExtra(RouterKt.ANALYTICS_SHOP_CATEGORY, cuisinesViewModel.getShopCategorySelected().invoke());
            Unit unit = Unit.INSTANCE;
            activity.setResult(-1, intent);
        }
        FragmentActivity activity2 = cuisinesFragmentMultipleSelection.getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }

    /* access modifiers changed from: private */
    public static final void bindBackPress(CuisinesFragmentMultipleSelection cuisinesFragmentMultipleSelection, CuisinesViewModel cuisinesViewModel) {
        cuisinesFragmentMultipleSelection.requireActivity().getOnBackPressedDispatcher().addCallback(new CuisinesScreenKt$bindBackPress$1(cuisinesFragmentMultipleSelection, cuisinesViewModel));
    }

    /* access modifiers changed from: private */
    public static final void bindCancelClick(CuisinesFragmentMultipleSelection cuisinesFragmentMultipleSelection, CuisinesViewModel cuisinesViewModel) {
        ((ImageButton) cuisinesFragmentMultipleSelection._$_findCachedViewById(R.id.cancelImageBtn)).setOnClickListener(new f(cuisinesFragmentMultipleSelection, cuisinesViewModel));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindCancelClick$lambda-9  reason: not valid java name */
    public static final void m9618bindCancelClick$lambda9(CuisinesFragmentMultipleSelection cuisinesFragmentMultipleSelection, CuisinesViewModel cuisinesViewModel, View view) {
        Intrinsics.checkNotNullParameter(cuisinesFragmentMultipleSelection, "$this_bindCancelClick");
        Intrinsics.checkNotNullParameter(cuisinesViewModel, "$viewModel");
        handleCancel(cuisinesFragmentMultipleSelection, cuisinesViewModel);
    }

    /* access modifiers changed from: private */
    public static final void bindClearClick(Fragment fragment) {
        View view = fragment.getView();
        ((ImageView) (view != null ? view.findViewById(R.id.clearCuisineBtn) : null)).setOnClickListener(new c(fragment));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindClearClick$lambda-6  reason: not valid java name */
    public static final void m9619bindClearClick$lambda6(Fragment fragment, View view) {
        View view2;
        Intrinsics.checkNotNullParameter(fragment, "$this_bindClearClick");
        View view3 = fragment.getView();
        if (view3 != null) {
            view2 = view3.findViewById(R.id.searchEdt);
        } else {
            view2 = null;
        }
        ((EditText) view2).getText().clear();
    }

    /* access modifiers changed from: private */
    public static final void bindCuisines(Fragment fragment, CuisinesViewModel cuisinesViewModel) {
        if (ITalabatExperiment.DefaultImpls.getBooleanVariant$default(TalabatExperiment.INSTANCE, TalabatExperimentConstants.CAN_SHOW_POPULAR_CUISNES, false, (TalabatExperimentDataSourceStrategy) null, 4, (Object) null)) {
            bindCuisinesAdapterWithPopular(fragment, cuisinesViewModel);
        } else {
            bindCuisinesAdapter(fragment, cuisinesViewModel);
        }
    }

    public static final void bindCuisinesAdapter(@NotNull Fragment fragment, @NotNull CuisinesViewModel cuisinesViewModel) {
        View view;
        View view2;
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(cuisinesViewModel, "viewModel");
        View view3 = fragment.getView();
        View view4 = null;
        if (view3 != null) {
            view = view3.findViewById(R.id.cuisineRecyclerView);
        } else {
            view = null;
        }
        ((RecyclerView) view).setLayoutManager(new LinearLayoutManager(fragment.getContext(), 1, false));
        CuisinesAdapter cuisinesAdapter = new CuisinesAdapter();
        View view5 = fragment.getView();
        if (view5 != null) {
            view2 = view5.findViewById(R.id.cuisineRecyclerView);
        } else {
            view2 = null;
        }
        ((RecyclerView) view2).setAdapter(cuisinesAdapter);
        cuisinesViewModel.getCuisines().observe(fragment, new e(cuisinesAdapter, fragment));
        View view6 = fragment.getView();
        if (view6 != null) {
            view4 = view6.findViewById(R.id.searchEdt);
        }
        EditText editText = (EditText) view4;
        Intrinsics.checkNotNullExpressionValue(editText, "searchEdt");
        editText.addTextChangedListener(new CuisinesScreenKt$bindCuisinesAdapter$$inlined$addTextChangedListener$default$1(cuisinesAdapter));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindCuisinesAdapter$lambda-0  reason: not valid java name */
    public static final void m9620bindCuisinesAdapter$lambda0(CuisinesAdapter cuisinesAdapter, Fragment fragment, List list) {
        Intrinsics.checkNotNullParameter(cuisinesAdapter, "$adapter");
        Intrinsics.checkNotNullParameter(fragment, "$this_bindCuisinesAdapter");
        Intrinsics.checkNotNullExpressionValue(list, "it");
        cuisinesAdapter.setCuisineList(list);
        updateDoneBtn(fragment, list);
    }

    public static final void bindCuisinesAdapterWithPopular(@NotNull Fragment fragment, @NotNull CuisinesViewModel cuisinesViewModel) {
        View view;
        View view2;
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(cuisinesViewModel, "viewModel");
        View view3 = fragment.getView();
        View view4 = null;
        if (view3 != null) {
            view = view3.findViewById(R.id.cuisineRecyclerView);
        } else {
            view = null;
        }
        ((RecyclerView) view).setLayoutManager(new LinearLayoutManager(fragment.getContext(), 1, false));
        PopularCuisinesAdapter popularCuisinesAdapter = new PopularCuisinesAdapter();
        View view5 = fragment.getView();
        if (view5 != null) {
            view2 = view5.findViewById(R.id.cuisineRecyclerView);
        } else {
            view2 = null;
        }
        ((RecyclerView) view2).setAdapter(popularCuisinesAdapter);
        cuisinesViewModel.getShowCuisinesWithPopular().observe(fragment, new g(popularCuisinesAdapter));
        cuisinesViewModel.getCuisines().observe(fragment, new h(popularCuisinesAdapter, fragment));
        View view6 = fragment.getView();
        if (view6 != null) {
            view4 = view6.findViewById(R.id.searchEdt);
        }
        EditText editText = (EditText) view4;
        Intrinsics.checkNotNullExpressionValue(editText, "searchEdt");
        editText.addTextChangedListener(new CuisinesScreenKt$bindCuisinesAdapterWithPopular$$inlined$addTextChangedListener$default$1(popularCuisinesAdapter));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindCuisinesAdapterWithPopular$lambda-2  reason: not valid java name */
    public static final void m9621bindCuisinesAdapterWithPopular$lambda2(PopularCuisinesAdapter popularCuisinesAdapter, List list) {
        Intrinsics.checkNotNullParameter(popularCuisinesAdapter, "$adapter");
        Intrinsics.checkNotNullExpressionValue(list, "it");
        popularCuisinesAdapter.setAllCuisinesWithPopular$com_talabat_Components_cuisines_cuisines(list);
    }

    /* access modifiers changed from: private */
    /* renamed from: bindCuisinesAdapterWithPopular$lambda-3  reason: not valid java name */
    public static final void m9622bindCuisinesAdapterWithPopular$lambda3(PopularCuisinesAdapter popularCuisinesAdapter, Fragment fragment, List list) {
        Intrinsics.checkNotNullParameter(popularCuisinesAdapter, "$adapter");
        Intrinsics.checkNotNullParameter(fragment, "$this_bindCuisinesAdapterWithPopular");
        Intrinsics.checkNotNullExpressionValue(list, "it");
        popularCuisinesAdapter.setAllCuisines$com_talabat_Components_cuisines_cuisines(list);
        updateDoneBtn(fragment, list);
    }

    public static final void bindErrors(@NotNull Fragment fragment, @NotNull CuisinesViewModel cuisinesViewModel) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(cuisinesViewModel, "viewModel");
        cuisinesViewModel.getErrors().observe(fragment.getViewLifecycleOwner(), new d(cuisinesViewModel));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindErrors$lambda-8  reason: not valid java name */
    public static final void m9623bindErrors$lambda8(CuisinesViewModel cuisinesViewModel, Throwable th2) {
        Intrinsics.checkNotNullParameter(cuisinesViewModel, "$viewModel");
        if (th2 != null) {
            if (CuisinesIntegrator.INSTANCE.isLoggerInitialized()) {
                CuisinesIntegratorKt.getLogger().displayErrorMessage(th2);
            }
            cuisinesViewModel.getErrors().setValue(null);
        }
    }

    /* access modifiers changed from: private */
    public static final void bindResetClick(CuisinesFragmentMultipleSelection cuisinesFragmentMultipleSelection, CuisinesViewModel cuisinesViewModel) {
        ((TextView) cuisinesFragmentMultipleSelection._$_findCachedViewById(R.id.resetBtn)).setOnClickListener(new i(cuisinesFragmentMultipleSelection, cuisinesViewModel));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindResetClick$lambda-10  reason: not valid java name */
    public static final void m9624bindResetClick$lambda10(CuisinesFragmentMultipleSelection cuisinesFragmentMultipleSelection, CuisinesViewModel cuisinesViewModel, View view) {
        Intrinsics.checkNotNullParameter(cuisinesFragmentMultipleSelection, "$this_bindResetClick");
        Intrinsics.checkNotNullParameter(cuisinesViewModel, "$viewModel");
        AppTracker.onRestaurantsCuisineClear(cuisinesFragmentMultipleSelection.getContext(), cuisinesViewModel.getShopCategorySelected().invoke());
        if (ITalabatExperiment.DefaultImpls.getBooleanVariant$default(TalabatExperiment.INSTANCE, TalabatExperimentConstants.CAN_SHOW_POPULAR_CUISNES, false, (TalabatExperimentDataSourceStrategy) null, 4, (Object) null)) {
            CuisinesViewModelKt.clearCuisineSelectionWithPopular(cuisinesViewModel);
        } else {
            CuisinesViewModelKt.clearCuisineSelection(cuisinesViewModel);
        }
    }

    /* access modifiers changed from: private */
    public static final void handleCancel(CuisinesFragmentMultipleSelection cuisinesFragmentMultipleSelection, CuisinesViewModel cuisinesViewModel) {
        cuisinesViewModel.getApplyLastSelection().invoke();
        FragmentActivity activity = cuisinesFragmentMultipleSelection.getActivity();
        if (activity != null) {
            activity.setResult(0);
        }
        FragmentActivity activity2 = cuisinesFragmentMultipleSelection.getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }

    /* access modifiers changed from: private */
    public static final void registerToCuisineClick(CuisinesFragmentMultipleSelection cuisinesFragmentMultipleSelection, CuisinesViewModel cuisinesViewModel, boolean z11) {
        BroadcastsKt.registerToBroadcast$default((Fragment) cuisinesFragmentMultipleSelection, CuisinesAdapterKt.ACTION_CUISINE_CLICKED, (Lifecycle.State) null, (Function1) new CuisinesScreenKt$registerToCuisineClick$1(cuisinesFragmentMultipleSelection, cuisinesViewModel, z11), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void registerToCuisineClickWithPopular(CuisinesFragmentMultipleSelection cuisinesFragmentMultipleSelection, CuisinesViewModel cuisinesViewModel, boolean z11) {
        BroadcastsKt.registerToBroadcast$default((Fragment) cuisinesFragmentMultipleSelection, CuisinesAdapterKt.ACTION_CUISINE_CLICKED, (Lifecycle.State) null, (Function1) new CuisinesScreenKt$registerToCuisineClickWithPopular$1(cuisinesFragmentMultipleSelection, cuisinesViewModel, z11), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void replaceCuisinesFragment(CuisinesActivity cuisinesActivity) {
        cuisinesActivity.getSupportFragmentManager().beginTransaction().replace(R.id.container, CuisinesFragment(cuisinesActivity.getIntent().getBooleanExtra(EXTRA_IS_COLLECTION, false), cuisinesActivity.getIntent().getBooleanExtra(EXTRA_IS_PICKUP, false))).commitNow();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: com.talabat.talabatcommon.views.twolinesbutton.TwoLinesButton} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: com.talabat.talabatcommon.views.twolinesbutton.TwoLinesButton} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: com.talabat.talabatcommon.views.twolinesbutton.TwoLinesButton} */
    /* JADX WARNING: type inference failed for: r1v5, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final void updateDoneBtn(androidx.fragment.app.Fragment r6, java.util.List<com.talabat.cuisines.domain.SelectableCuisine> r7) {
        /*
            com.talabat.core.experiment.data.TalabatExperiment r0 = com.talabat.core.experiment.data.TalabatExperiment.INSTANCE
            com.talabat.core.experiment.data.TalabatExperimentConstants r1 = com.talabat.core.experiment.data.TalabatExperimentConstants.COUNTERS_AND_NEW_DESIGN_FILTERS_CUISINES
            r2 = 0
            r3 = 0
            r4 = 4
            r5 = 0
            boolean r0 = com.talabat.core.experiment.domain.ITalabatExperiment.DefaultImpls.getBooleanVariant$default(r0, r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x007e
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r7 = r7.iterator()
        L_0x0019:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x0030
            java.lang.Object r1 = r7.next()
            r2 = r1
            com.talabat.cuisines.domain.SelectableCuisine r2 = (com.talabat.cuisines.domain.SelectableCuisine) r2
            boolean r2 = r2.isOn()
            if (r2 == 0) goto L_0x0019
            r0.add(r1)
            goto L_0x0019
        L_0x0030:
            int r7 = r0.size()
            java.lang.String r0 = ""
            r1 = 0
            if (r7 <= 0) goto L_0x006d
            android.view.View r2 = r6.getView()
            if (r2 == 0) goto L_0x0046
            int r3 = com.talabat.cuisines.R.id.doneBtn
            android.view.View r2 = r2.findViewById(r3)
            goto L_0x0047
        L_0x0046:
            r2 = r1
        L_0x0047:
            com.talabat.talabatcommon.views.twolinesbutton.TwoLinesButton r2 = (com.talabat.talabatcommon.views.twolinesbutton.TwoLinesButton) r2
            android.content.Context r6 = r6.getContext()
            if (r6 == 0) goto L_0x0065
            android.content.res.Resources r6 = r6.getResources()
            if (r6 == 0) goto L_0x0065
            int r1 = com.talabat.localization.R.plurals.numberOfCuisinesSelected
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r4 = 0
            java.lang.Integer r5 = java.lang.Integer.valueOf(r7)
            r3[r4] = r5
            java.lang.String r1 = r6.getQuantityString(r1, r7, r3)
        L_0x0065:
            if (r1 != 0) goto L_0x0068
            goto L_0x0069
        L_0x0068:
            r0 = r1
        L_0x0069:
            r2.setSecondLineText(r0)
            goto L_0x007e
        L_0x006d:
            android.view.View r6 = r6.getView()
            if (r6 == 0) goto L_0x0079
            int r7 = com.talabat.cuisines.R.id.doneBtn
            android.view.View r1 = r6.findViewById(r7)
        L_0x0079:
            com.talabat.talabatcommon.views.twolinesbutton.TwoLinesButton r1 = (com.talabat.talabatcommon.views.twolinesbutton.TwoLinesButton) r1
            r1.setSecondLineText(r0)
        L_0x007e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.cuisines.presentation.CuisinesScreenKt.updateDoneBtn(androidx.fragment.app.Fragment, java.util.List):void");
    }

    @NotNull
    public static final CuisinesViewModel viewModel(@NotNull Fragment fragment) {
        boolean z11;
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        CuisinesViewModelFactory.Companion companion = CuisinesViewModelFactory.Companion;
        Bundle arguments = fragment.getArguments();
        boolean z12 = false;
        if (arguments != null) {
            z11 = Intrinsics.areEqual(arguments.get(EXTRA_IS_COLLECTION), (Object) Boolean.TRUE);
        } else {
            z11 = false;
        }
        Bundle arguments2 = fragment.getArguments();
        if (arguments2 != null) {
            z12 = Intrinsics.areEqual(arguments2.get(EXTRA_IS_PICKUP), (Object) Boolean.TRUE);
        }
        return (CuisinesViewModel) new ViewModelProvider((ViewModelStoreOwner) fragment, (ViewModelProvider.Factory) companion.newInstance(z11, z12)).get(CuisinesViewModel.class);
    }
}
