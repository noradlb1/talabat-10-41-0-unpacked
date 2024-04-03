package com.talabat.cuisines.presentation.bottomsheet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.data.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.cuisines.R;
import com.talabat.cuisines.presentation.CuisinesScreenKt;
import com.talabat.cuisines.presentation.CuisinesViewModel;
import com.talabat.talabatcommon.views.fragments.FragmentInflater;
import com.talabat.talabatcommon.views.fragments.InflatableFragment;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007J%\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0001J\u001a\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/talabat/cuisines/presentation/bottomsheet/CuisinesDSBottomSheetBodyFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/talabat/talabatcommon/views/fragments/InflatableFragment;", "()V", "viewModel", "Lcom/talabat/cuisines/presentation/CuisinesViewModel;", "applyLastSelection", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "com_talabat_Components_cuisines_cuisines"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CuisinesDSBottomSheetBodyFragment extends Fragment implements InflatableFragment, TraceFieldInterface {
    private final /* synthetic */ FragmentInflater $$delegate_0 = new FragmentInflater(R.layout.fragment_cuisines_ds_bottom_sheet);
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    private CuisinesViewModel viewModel;

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

    public final void applyLastSelection() {
        CuisinesViewModel cuisinesViewModel = this.viewModel;
        if (cuisinesViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cuisinesViewModel = null;
        }
        cuisinesViewModel.getApplyLastSelection().invoke();
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "CuisinesDSBottomSheetBodyFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "CuisinesDSBottomSheetBodyFragment#onCreateView", (ArrayList<String>) null);
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

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        CuisinesViewModel viewModel2 = CuisinesScreenKt.viewModel(this);
        this.viewModel = viewModel2;
        CuisinesViewModel cuisinesViewModel = null;
        if (viewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            viewModel2 = null;
        }
        CuisinesDSBottomSheetKt.bindCuisines(this, viewModel2);
        CuisinesViewModel cuisinesViewModel2 = this.viewModel;
        if (cuisinesViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cuisinesViewModel2 = null;
        }
        CuisinesScreenKt.bindErrors(this, cuisinesViewModel2);
        CuisinesViewModel cuisinesViewModel3 = this.viewModel;
        if (cuisinesViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cuisinesViewModel3 = null;
        }
        CuisinesDSBottomSheetKt.bindResetClick(this, cuisinesViewModel3);
        CuisinesDSBottomSheetKt.bindCancelClick(this);
        CuisinesViewModel cuisinesViewModel4 = this.viewModel;
        if (cuisinesViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cuisinesViewModel4 = null;
        }
        CuisinesDSBottomSheetKt.bindApplyClick(this, cuisinesViewModel4);
        if (ITalabatExperiment.DefaultImpls.getBooleanVariant$default(TalabatExperiment.INSTANCE, TalabatExperimentConstants.CAN_SHOW_POPULAR_CUISNES, false, (TalabatExperimentDataSourceStrategy) null, 4, (Object) null)) {
            CuisinesViewModel cuisinesViewModel5 = this.viewModel;
            if (cuisinesViewModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                cuisinesViewModel = cuisinesViewModel5;
            }
            CuisinesDSBottomSheetKt.registerToCuisineClickWithPopular(this, cuisinesViewModel);
            return;
        }
        CuisinesViewModel cuisinesViewModel6 = this.viewModel;
        if (cuisinesViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            cuisinesViewModel = cuisinesViewModel6;
        }
        CuisinesDSBottomSheetKt.registerToCuisineClick(this, cuisinesViewModel);
    }
}
