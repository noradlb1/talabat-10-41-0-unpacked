package com.talabat.cuisines.presentation;

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
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J%\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0001¨\u0006\u000e"}, d2 = {"Lcom/talabat/cuisines/presentation/CuisinesFragmentMultipleSelection;", "Landroidx/fragment/app/Fragment;", "Lcom/talabat/talabatcommon/views/fragments/InflatableFragment;", "()V", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "com_talabat_Components_cuisines_cuisines"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CuisinesFragmentMultipleSelection extends Fragment implements InflatableFragment, TraceFieldInterface {
    private final /* synthetic */ FragmentInflater $$delegate_0 = new FragmentInflater(R.layout.fragment_cuisines_multiple_selection);
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;

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

    public void onActivityCreated(@Nullable Bundle bundle) {
        boolean z11;
        super.onActivityCreated(bundle);
        CuisinesViewModel viewModel = CuisinesScreenKt.viewModel(this);
        CuisinesScreenKt.bindCuisines(this, viewModel);
        CuisinesScreenKt.bindErrors(this, viewModel);
        CuisinesScreenKt.bindResetClick(this, viewModel);
        CuisinesScreenKt.bindCancelClick(this, viewModel);
        CuisinesScreenKt.bindClearClick(this);
        Bundle arguments = getArguments();
        boolean z12 = true;
        if (arguments == null || !arguments.getBoolean(CuisinesScreenKt.EXTRA_IS_PICKUP)) {
            z11 = false;
        } else {
            z11 = true;
        }
        CuisinesScreenKt.bindApplyClick(this, viewModel, z11);
        CuisinesScreenKt.bindBackPress(this, viewModel);
        if (ITalabatExperiment.DefaultImpls.getBooleanVariant$default(TalabatExperiment.INSTANCE, TalabatExperimentConstants.CAN_SHOW_POPULAR_CUISNES, false, (TalabatExperimentDataSourceStrategy) null, 4, (Object) null)) {
            Bundle arguments2 = getArguments();
            if (arguments2 == null || !arguments2.getBoolean(CuisinesScreenKt.EXTRA_IS_PICKUP)) {
                z12 = false;
            }
            CuisinesScreenKt.registerToCuisineClickWithPopular(this, viewModel, z12);
            return;
        }
        Bundle arguments3 = getArguments();
        if (arguments3 == null || !arguments3.getBoolean(CuisinesScreenKt.EXTRA_IS_PICKUP)) {
            z12 = false;
        }
        CuisinesScreenKt.registerToCuisineClick(this, viewModel, z12);
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "CuisinesFragmentMultipleSelection#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "CuisinesFragmentMultipleSelection#onCreateView", (ArrayList<String>) null);
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
}
