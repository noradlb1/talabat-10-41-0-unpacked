package com.talabat.filters.presentation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.data.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.filters.R;
import com.talabat.talabatcommon.views.fragments.FragmentInflater;
import com.talabat.talabatcommon.views.fragments.InflatableFragment;
import com.talabat.talabatcore.adapters.FunctionalAdaptersKt;
import com.talabat.talabatcore.extensions.LifecycleKt;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.AppTracker;
import wp.a;
import wp.b;
import wp.c;

@Instrumented
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0007\u0012\u0010\b\u0003\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J\u0012\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J%\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0001R\u0019\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/talabat/filters/presentation/FiltersFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/talabat/talabatcommon/views/fragments/InflatableFragment;", "viewModelType", "Ljava/lang/Class;", "Lcom/talabat/filters/presentation/FiltersViewModel;", "(Ljava/lang/Class;)V", "getViewModelType", "()Ljava/lang/Class;", "bindButtons", "", "filtersViewModel", "observeFilters", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "com_talabat_Components_filters_filters"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FiltersFragment extends Fragment implements InflatableFragment, TraceFieldInterface {
    private final /* synthetic */ FragmentInflater $$delegate_0;
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    public Trace _nr_trace;
    @NotNull
    private final Class<? extends FiltersViewModel> viewModelType;

    @JvmOverloads
    public FiltersFragment() {
        this((Class) null, 1, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public FiltersFragment(@NotNull @VisibleForTesting Class<? extends FiltersViewModel> cls) {
        int i11;
        Intrinsics.checkNotNullParameter(cls, "viewModelType");
        this._$_findViewCache = new LinkedHashMap();
        this.viewModelType = cls;
        TalabatExperiment talabatExperiment = TalabatExperiment.INSTANCE;
        if (ITalabatExperiment.DefaultImpls.getBooleanVariant$default(talabatExperiment, TalabatExperimentConstants.SHOW_POPULAR_FILTERS, false, (TalabatExperimentDataSourceStrategy) null, 4, (Object) null)) {
            i11 = R.layout.fragment_filters_popular_filters;
        } else {
            if (ITalabatExperiment.DefaultImpls.getBooleanVariant$default(talabatExperiment, TalabatExperimentConstants.COUNTERS_AND_NEW_DESIGN_FILTERS_CUISINES, false, (TalabatExperimentDataSourceStrategy) null, 4, (Object) null)) {
                i11 = R.layout.fragment_filters_experiment;
            } else {
                i11 = R.layout.fragment_filters;
            }
        }
        this.$$delegate_0 = new FragmentInflater(i11);
    }

    private final void bindButtons(FiltersViewModel filtersViewModel) {
        ((TextView) _$_findCachedViewById(R.id.resetBtn)).setOnClickListener(new a(this, filtersViewModel));
        ((ImageButton) _$_findCachedViewById(R.id.closeBtn)).setOnClickListener(new b(this));
        ((Button) _$_findCachedViewById(R.id.doneBtn)).setOnClickListener(new c(this, filtersViewModel));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindButtons$lambda-1  reason: not valid java name */
    public static final void m10435bindButtons$lambda1(FiltersFragment filtersFragment, FiltersViewModel filtersViewModel, View view) {
        Intrinsics.checkNotNullParameter(filtersFragment, "this$0");
        Intrinsics.checkNotNullParameter(filtersViewModel, "$filtersViewModel");
        AppTracker.onFilterClearClicked(filtersFragment.getContext(), FiltersViewModelKt.getSortingSlug(filtersViewModel), FiltersViewModelKt.getFiltersSlug(filtersViewModel));
        FiltersViewModelKt.reset(filtersViewModel);
    }

    /* access modifiers changed from: private */
    /* renamed from: bindButtons$lambda-2  reason: not valid java name */
    public static final void m10436bindButtons$lambda2(FiltersFragment filtersFragment, View view) {
        Intrinsics.checkNotNullParameter(filtersFragment, "this$0");
        FragmentActivity activity = filtersFragment.getActivity();
        if (activity != null) {
            activity.setResult(0);
        }
        FragmentActivity activity2 = filtersFragment.getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: bindButtons$lambda-3  reason: not valid java name */
    public static final void m10437bindButtons$lambda3(FiltersFragment filtersFragment, FiltersViewModel filtersViewModel, View view) {
        Intrinsics.checkNotNullParameter(filtersFragment, "this$0");
        Intrinsics.checkNotNullParameter(filtersViewModel, "$filtersViewModel");
        AppTracker.onFilterApplyClicked(filtersFragment.getContext(), FiltersViewModelKt.getSortingSlug(filtersViewModel), FiltersViewModelKt.getFiltersSlug(filtersViewModel));
        FiltersViewModelKt.applySelection(filtersViewModel);
        FragmentActivity activity = filtersFragment.getActivity();
        if (activity != null) {
            activity.setResult(-1, FiltersScreenKt.resultExtras(filtersViewModel));
        }
        FragmentActivity activity2 = filtersFragment.getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }

    private final void observeFilters(FiltersViewModel filtersViewModel) {
        LifecycleKt.observe(this, filtersViewModel.getFilters(), new FiltersFragment$observeFilters$1$1(this, filtersViewModel));
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

    @NotNull
    public final Class<? extends FiltersViewModel> getViewModelType() {
        return this.viewModelType;
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        FiltersViewModel filtersViewModel = (FiltersViewModel) ViewModelProviders.of((Fragment) this).get(this.viewModelType);
        LifecycleKt.observe(this, filtersViewModel.getButtonsContainerVisibility(), new FiltersFragment$onActivityCreated$1$1(this));
        LifecycleKt.observe(this, filtersViewModel.getAnalyticsClick(), new FiltersFragment$onActivityCreated$1$2(this, filtersViewModel));
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.sortRecycleView);
        Intrinsics.checkNotNullExpressionValue(recyclerView, "sortRecycleView");
        FunctionalAdaptersKt.invoke$default(recyclerView, R.layout.item_vendor_sort, filtersViewModel.getSorts(), getViewLifecycleOwner(), (RecyclerView.LayoutManager) null, (Function2) null, new FiltersFragment$onActivityCreated$1$3(this, filtersViewModel), 24, (Object) null);
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(R.id.filtersRecyclerView);
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "filtersRecyclerView");
        int i11 = R.layout.item_vendor_filter;
        FunctionalAdaptersKt.invoke$default(recyclerView2, i11, filtersViewModel.getFilters(), getViewLifecycleOwner(), (RecyclerView.LayoutManager) null, (Function2) null, new FiltersFragment$onActivityCreated$1$4(filtersViewModel, this), 24, (Object) null);
        int i12 = R.id.popularFilterRecyclerView;
        if (((RecyclerView) _$_findCachedViewById(i12)) != null) {
            RecyclerView recyclerView3 = (RecyclerView) _$_findCachedViewById(i12);
            Intrinsics.checkNotNullExpressionValue(recyclerView3, "popularFilterRecyclerView");
            FunctionalAdaptersKt.invoke$default(recyclerView3, i11, filtersViewModel.getPopularFilters(), getViewLifecycleOwner(), (RecyclerView.LayoutManager) null, (Function2) null, new FiltersFragment$onActivityCreated$1$5(filtersViewModel, this), 24, (Object) null);
        }
        observeFilters(filtersViewModel);
        bindButtons(filtersViewModel);
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "FiltersFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "FiltersFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View onCreateView = this.$$delegate_0.onCreateView(layoutInflater, viewGroup, bundle);
        TraceMachine.exitMethod();
        return onCreateView;
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

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FiltersFragment(Class cls, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? FiltersViewModel.class : cls);
    }
}
