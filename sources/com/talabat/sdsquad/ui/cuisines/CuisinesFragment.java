package com.talabat.sdsquad.ui.cuisines;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.sdsquad.R;
import com.talabat.sdsquad.core.TalabatViewModelFactory;
import com.talabat.sdsquad.ui.cuisines.adapters.CuisinesAdapter;
import com.talabat.sdsquad.ui.cuisines.adapters.viewholders.CuisineViewHolder;
import com.talabat.sdsquad.ui.cuisines.displaymodels.CuisineDisplayModel;
import fu.a;
import fu.b;
import fu.c;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/talabat/sdsquad/ui/cuisines/CuisinesFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/talabat/sdsquad/ui/cuisines/adapters/viewholders/CuisineViewHolder$OnCuisineClickListener;", "()V", "mCuisineAdapter", "Lcom/talabat/sdsquad/ui/cuisines/adapters/CuisinesAdapter;", "getMCuisineAdapter", "()Lcom/talabat/sdsquad/ui/cuisines/adapters/CuisinesAdapter;", "mCuisineAdapter$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/talabat/sdsquad/ui/cuisines/CuisinesViewModel;", "cuisineClicked", "", "cuisineModel", "Lcom/talabat/sdsquad/ui/cuisines/displaymodels/CuisineDisplayModel;", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "Companion", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CuisinesFragment extends Fragment implements CuisineViewHolder.OnCuisineClickListener, TraceFieldInterface {
    @NotNull
    private static final String ARG_SELECTED_CUISINE_ID = "selectedCuisineId";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    @NotNull
    private final Lazy mCuisineAdapter$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, CuisinesFragment$mCuisineAdapter$2.INSTANCE);
    private CuisinesViewModel viewModel;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/sdsquad/ui/cuisines/CuisinesFragment$Companion;", "", "()V", "ARG_SELECTED_CUISINE_ID", "", "newInstance", "Lcom/talabat/sdsquad/ui/cuisines/CuisinesFragment;", "selectedCuisineId", "", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final CuisinesFragment newInstance(int i11) {
            CuisinesFragment cuisinesFragment = new CuisinesFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(CuisinesFragment.ARG_SELECTED_CUISINE_ID, i11);
            cuisinesFragment.setArguments(bundle);
            return cuisinesFragment;
        }
    }

    /* access modifiers changed from: private */
    public final CuisinesAdapter getMCuisineAdapter() {
        return (CuisinesAdapter) this.mCuisineAdapter$delegate.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: onActivityCreated$lambda-0  reason: not valid java name */
    public static final void m10812onActivityCreated$lambda0(CuisinesFragment cuisinesFragment, List list) {
        Intrinsics.checkNotNullParameter(cuisinesFragment, "this$0");
        CuisinesAdapter mCuisineAdapter = cuisinesFragment.getMCuisineAdapter();
        Intrinsics.checkNotNullExpressionValue(list, "it");
        mCuisineAdapter.setCuisineList(list);
    }

    /* access modifiers changed from: private */
    /* renamed from: onActivityCreated$lambda-1  reason: not valid java name */
    public static final void m10813onActivityCreated$lambda1(CuisinesFragment cuisinesFragment, View view) {
        Intrinsics.checkNotNullParameter(cuisinesFragment, "this$0");
        FragmentActivity activity = cuisinesFragment.getActivity();
        if (activity != null) {
            activity.setResult(0);
        }
        FragmentActivity activity2 = cuisinesFragment.getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onActivityCreated$lambda-2  reason: not valid java name */
    public static final void m10814onActivityCreated$lambda2(CuisinesFragment cuisinesFragment, View view) {
        Intrinsics.checkNotNullParameter(cuisinesFragment, "this$0");
        ((EditText) cuisinesFragment._$_findCachedViewById(R.id.searchEdt)).getText().clear();
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

    public void cuisineClicked(@NotNull CuisineDisplayModel cuisineDisplayModel) {
        Intrinsics.checkNotNullParameter(cuisineDisplayModel, "cuisineModel");
        CuisinesViewModel cuisinesViewModel = this.viewModel;
        CuisinesViewModel cuisinesViewModel2 = null;
        if (cuisinesViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cuisinesViewModel = null;
        }
        cuisinesViewModel.setSelectedCuisine(cuisineDisplayModel);
        Intent intent = new Intent();
        CuisinesViewModel cuisinesViewModel3 = this.viewModel;
        if (cuisinesViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            cuisinesViewModel2 = cuisinesViewModel3;
        }
        intent.putExtra(ARG_SELECTED_CUISINE_ID, cuisinesViewModel2.getSelectedCuisineId());
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setResult(-1, intent);
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        int i11;
        super.onActivityCreated(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            i11 = arguments.getInt(ARG_SELECTED_CUISINE_ID);
        } else {
            i11 = 0;
        }
        this.viewModel = (CuisinesViewModel) ViewModelProviders.of((Fragment) this, (ViewModelProvider.Factory) new TalabatViewModelFactory()).get(CuisinesViewModel.class);
        int i12 = R.id.cuisineRecyclerView;
        ((RecyclerView) _$_findCachedViewById(i12)).setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        getMCuisineAdapter().setCuisineClickListener(this);
        ((RecyclerView) _$_findCachedViewById(i12)).setAdapter(getMCuisineAdapter());
        CuisinesViewModel cuisinesViewModel = this.viewModel;
        CuisinesViewModel cuisinesViewModel2 = null;
        if (cuisinesViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cuisinesViewModel = null;
        }
        cuisinesViewModel.getCuisineList(i11);
        CuisinesViewModel cuisinesViewModel3 = this.viewModel;
        if (cuisinesViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            cuisinesViewModel2 = cuisinesViewModel3;
        }
        cuisinesViewModel2.getCuisinesResponse().observe(getViewLifecycleOwner(), new a(this));
        ((EditText) _$_findCachedViewById(R.id.searchEdt)).addTextChangedListener(new CuisinesFragment$onActivityCreated$2(this));
        ((TextView) _$_findCachedViewById(R.id.cancelBtn)).setOnClickListener(new b(this));
        ((ImageView) _$_findCachedViewById(R.id.clearCuisineBtn)).setOnClickListener(new c(this));
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "CuisinesFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "CuisinesFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_cuisines, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…isines, container, false)");
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
}
