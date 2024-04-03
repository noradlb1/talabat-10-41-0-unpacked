package com.talabat.sdsquad.ui.filters;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.sdsquad.R;
import com.talabat.sdsquad.data.vendorslist.response.Sort;
import com.talabat.sdsquad.extentions.ViewExtentionsKt;
import com.talabat.sdsquad.ui.filters.adapters.FiltersAdapter;
import com.talabat.sdsquad.ui.filters.adapters.SortAdapter;
import com.talabat.sdsquad.ui.filters.adapters.viewholders.FilterViewHolder;
import com.talabat.sdsquad.ui.filters.adapters.viewholders.SortViewHolder;
import com.talabat.sdsquad.ui.filters.displaymodels.FilterDisplayModel;
import hu.a;
import hu.b;
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
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 %2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001%B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u0013H\u0002J\u0012\u0010\u0018\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J$\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010!\u001a\u00020\u0013H\u0002J\u0010\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020$H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/talabat/sdsquad/ui/filters/FiltersFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/talabat/sdsquad/ui/filters/adapters/viewholders/SortViewHolder$OnSortClickListener;", "Lcom/talabat/sdsquad/ui/filters/adapters/viewholders/FilterViewHolder$OnFilterClicked;", "()V", "mFiltersAdapter", "Lcom/talabat/sdsquad/ui/filters/adapters/FiltersAdapter;", "getMFiltersAdapter", "()Lcom/talabat/sdsquad/ui/filters/adapters/FiltersAdapter;", "mFiltersAdapter$delegate", "Lkotlin/Lazy;", "mSortAdapter", "Lcom/talabat/sdsquad/ui/filters/adapters/SortAdapter;", "getMSortAdapter", "()Lcom/talabat/sdsquad/ui/filters/adapters/SortAdapter;", "mSortAdapter$delegate", "viewModel", "Lcom/talabat/sdsquad/ui/filters/FiltersViewModel;", "filterClicked", "", "filter", "Lcom/talabat/sdsquad/ui/filters/displaymodels/FilterDisplayModel;", "observeFiltersList", "observeSortsList", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "showBottomButtons", "sortClicked", "sortModel", "Lcom/talabat/sdsquad/data/vendorslist/response/Sort;", "Companion", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FiltersFragment extends Fragment implements SortViewHolder.OnSortClickListener, FilterViewHolder.OnFilterClicked, TraceFieldInterface {
    @NotNull
    private static final String ARG_SELECTED_FILTERS = "ARG_SELECTED_FILTERS";
    @NotNull
    private static final String ARG_SELECTED_SORT = "ARG_SELECTED_SORT";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    @NotNull
    private final Lazy mFiltersAdapter$delegate;
    @NotNull
    private final Lazy mSortAdapter$delegate;
    private FiltersViewModel viewModel;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\u0010\fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/talabat/sdsquad/ui/filters/FiltersFragment$Companion;", "", "()V", "ARG_SELECTED_FILTERS", "", "ARG_SELECTED_SORT", "getInstance", "Lcom/talabat/sdsquad/ui/filters/FiltersFragment;", "selectedSort", "", "selectedFilters", "Ljava/util/ArrayList;", "(Ljava/lang/Integer;Ljava/util/ArrayList;)Lcom/talabat/sdsquad/ui/filters/FiltersFragment;", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FiltersFragment getInstance(@Nullable Integer num, @Nullable ArrayList<Integer> arrayList) {
            int i11;
            FiltersFragment filtersFragment = new FiltersFragment();
            Bundle bundle = new Bundle();
            if (num != null) {
                i11 = num.intValue();
            } else {
                i11 = 0;
            }
            bundle.putInt(FiltersFragment.ARG_SELECTED_SORT, i11);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            bundle.putIntegerArrayList(FiltersFragment.ARG_SELECTED_FILTERS, arrayList);
            filtersFragment.setArguments(bundle);
            return filtersFragment;
        }
    }

    public FiltersFragment() {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.mSortAdapter$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, FiltersFragment$mSortAdapter$2.INSTANCE);
        this.mFiltersAdapter$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, FiltersFragment$mFiltersAdapter$2.INSTANCE);
    }

    private final FiltersAdapter getMFiltersAdapter() {
        return (FiltersAdapter) this.mFiltersAdapter$delegate.getValue();
    }

    private final SortAdapter getMSortAdapter() {
        return (SortAdapter) this.mSortAdapter$delegate.getValue();
    }

    private final void observeFiltersList() {
        FiltersViewModel filtersViewModel = this.viewModel;
        if (filtersViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            filtersViewModel = null;
        }
        filtersViewModel.getFiltersResponse().observe(this, new b(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: observeFiltersList$lambda-4  reason: not valid java name */
    public static final void m10818observeFiltersList$lambda4(FiltersFragment filtersFragment, List list) {
        Intrinsics.checkNotNullParameter(filtersFragment, "this$0");
        FiltersAdapter mFiltersAdapter = filtersFragment.getMFiltersAdapter();
        Intrinsics.checkNotNullExpressionValue(list, "t");
        mFiltersAdapter.setFiltersList(list);
    }

    private final void observeSortsList() {
        FiltersViewModel filtersViewModel = this.viewModel;
        if (filtersViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            filtersViewModel = null;
        }
        filtersViewModel.getSortsResponse().observe(this, new a(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: observeSortsList$lambda-3  reason: not valid java name */
    public static final void m10819observeSortsList$lambda3(FiltersFragment filtersFragment, List list) {
        Intrinsics.checkNotNullParameter(filtersFragment, "this$0");
        SortAdapter mSortAdapter = filtersFragment.getMSortAdapter();
        Intrinsics.checkNotNullExpressionValue(list, "t");
        mSortAdapter.setSortList(list);
    }

    /* access modifiers changed from: private */
    /* renamed from: onActivityCreated$lambda-0  reason: not valid java name */
    public static final void m10820onActivityCreated$lambda0(FiltersFragment filtersFragment, View view) {
        Intrinsics.checkNotNullParameter(filtersFragment, "this$0");
        FiltersViewModel filtersViewModel = filtersFragment.viewModel;
        if (filtersViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            filtersViewModel = null;
        }
        filtersViewModel.reset();
    }

    /* access modifiers changed from: private */
    /* renamed from: onActivityCreated$lambda-1  reason: not valid java name */
    public static final void m10821onActivityCreated$lambda1(FiltersFragment filtersFragment, View view) {
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
    /* renamed from: onActivityCreated$lambda-2  reason: not valid java name */
    public static final void m10822onActivityCreated$lambda2(FiltersFragment filtersFragment, View view) {
        Intrinsics.checkNotNullParameter(filtersFragment, "this$0");
        Intent intent = new Intent();
        FiltersViewModel filtersViewModel = filtersFragment.viewModel;
        FiltersViewModel filtersViewModel2 = null;
        if (filtersViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            filtersViewModel = null;
        }
        intent.putIntegerArrayListExtra("selectedFilters", filtersViewModel.getSelectedFilters());
        FiltersViewModel filtersViewModel3 = filtersFragment.viewModel;
        if (filtersViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            filtersViewModel2 = filtersViewModel3;
        }
        intent.putExtra("selectedSorts", filtersViewModel2.getSelectedSort());
        FragmentActivity activity = filtersFragment.getActivity();
        if (activity != null) {
            activity.setResult(-1, intent);
        }
        FragmentActivity activity2 = filtersFragment.getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }

    private final void showBottomButtons() {
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.buttonsContainer);
        Intrinsics.checkNotNullExpressionValue(linearLayout, "buttonsContainer");
        ViewExtentionsKt.show$default(linearLayout, true, 0, 2, (Object) null);
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

    public void filterClicked(@NotNull FilterDisplayModel filterDisplayModel) {
        Intrinsics.checkNotNullParameter(filterDisplayModel, "filter");
        FiltersViewModel filtersViewModel = this.viewModel;
        if (filtersViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            filtersViewModel = null;
        }
        filtersViewModel.setClickedFilter(filterDisplayModel);
        showBottomButtons();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003b, code lost:
        if (r2 != false) goto L_0x003d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityCreated(@org.jetbrains.annotations.Nullable android.os.Bundle r7) {
        /*
            r6 = this;
            super.onActivityCreated(r7)
            android.os.Bundle r7 = r6.getArguments()
            if (r7 == 0) goto L_0x0010
            java.lang.String r0 = "ARG_SELECTED_SORT"
            int r7 = r7.getInt(r0)
            goto L_0x0016
        L_0x0010:
            com.talabat.sdsquad.data.vendorslist.response.SortTypes r7 = com.talabat.sdsquad.data.vendorslist.response.SortTypes.RECOMMENDATION
            int r7 = r7.ordinal()
        L_0x0016:
            android.os.Bundle r0 = r6.getArguments()
            r1 = 0
            if (r0 == 0) goto L_0x0024
            java.lang.String r2 = "ARG_SELECTED_FILTERS"
            java.util.ArrayList r0 = r0.getIntegerArrayList(r2)
            goto L_0x0025
        L_0x0024:
            r0 = r1
        L_0x0025:
            com.talabat.sdsquad.data.vendorslist.response.SortTypes r2 = com.talabat.sdsquad.data.vendorslist.response.SortTypes.RECOMMENDATION
            int r2 = r2.ordinal()
            r3 = 0
            r4 = 1
            if (r7 != r2) goto L_0x003d
            if (r0 == 0) goto L_0x003a
            boolean r2 = r0.isEmpty()
            r2 = r2 ^ r4
            if (r2 != r4) goto L_0x003a
            r2 = r4
            goto L_0x003b
        L_0x003a:
            r2 = r3
        L_0x003b:
            if (r2 == 0) goto L_0x0040
        L_0x003d:
            r6.showBottomButtons()
        L_0x0040:
            com.talabat.sdsquad.core.TalabatViewModelFactory r2 = new com.talabat.sdsquad.core.TalabatViewModelFactory
            r2.<init>()
            androidx.lifecycle.ViewModelProvider r2 = androidx.lifecycle.ViewModelProviders.of((androidx.fragment.app.Fragment) r6, (androidx.lifecycle.ViewModelProvider.Factory) r2)
            java.lang.Class<com.talabat.sdsquad.ui.filters.FiltersViewModel> r5 = com.talabat.sdsquad.ui.filters.FiltersViewModel.class
            androidx.lifecycle.ViewModel r2 = r2.get(r5)
            com.talabat.sdsquad.ui.filters.FiltersViewModel r2 = (com.talabat.sdsquad.ui.filters.FiltersViewModel) r2
            r6.viewModel = r2
            if (r2 != 0) goto L_0x005c
            java.lang.String r2 = "viewModel"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            goto L_0x005d
        L_0x005c:
            r1 = r2
        L_0x005d:
            if (r0 != 0) goto L_0x0064
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L_0x0064:
            r1.getSortAndFilters(r7, r0)
            int r7 = com.talabat.sdsquad.R.id.sortList
            android.view.View r7 = r6._$_findCachedViewById(r7)
            androidx.recyclerview.widget.RecyclerView r7 = (androidx.recyclerview.widget.RecyclerView) r7
            androidx.recyclerview.widget.LinearLayoutManager r0 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r1 = r6.getContext()
            r0.<init>(r1, r4, r3)
            r7.setLayoutManager(r0)
            com.talabat.sdsquad.ui.filters.adapters.SortAdapter r7 = r6.getMSortAdapter()
            r7.setClickListener(r6)
            int r7 = com.talabat.sdsquad.R.id.sortList
            android.view.View r7 = r6._$_findCachedViewById(r7)
            androidx.recyclerview.widget.RecyclerView r7 = (androidx.recyclerview.widget.RecyclerView) r7
            com.talabat.sdsquad.ui.filters.adapters.SortAdapter r0 = r6.getMSortAdapter()
            r7.setAdapter(r0)
            int r7 = com.talabat.sdsquad.R.id.filterList
            android.view.View r7 = r6._$_findCachedViewById(r7)
            androidx.recyclerview.widget.RecyclerView r7 = (androidx.recyclerview.widget.RecyclerView) r7
            androidx.recyclerview.widget.LinearLayoutManager r0 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r1 = r6.getContext()
            r0.<init>(r1, r4, r3)
            r7.setLayoutManager(r0)
            com.talabat.sdsquad.ui.filters.adapters.FiltersAdapter r7 = r6.getMFiltersAdapter()
            r7.setListener(r6)
            int r7 = com.talabat.sdsquad.R.id.filterList
            android.view.View r7 = r6._$_findCachedViewById(r7)
            androidx.recyclerview.widget.RecyclerView r7 = (androidx.recyclerview.widget.RecyclerView) r7
            com.talabat.sdsquad.ui.filters.adapters.FiltersAdapter r0 = r6.getMFiltersAdapter()
            r7.setAdapter(r0)
            r6.observeSortsList()
            r6.observeFiltersList()
            int r7 = com.talabat.sdsquad.R.id.resetBtn
            android.view.View r7 = r6._$_findCachedViewById(r7)
            android.widget.Button r7 = (android.widget.Button) r7
            hu.c r0 = new hu.c
            r0.<init>(r6)
            r7.setOnClickListener(r0)
            int r7 = com.talabat.sdsquad.R.id.closeBtn
            android.view.View r7 = r6._$_findCachedViewById(r7)
            android.widget.ImageButton r7 = (android.widget.ImageButton) r7
            hu.d r0 = new hu.d
            r0.<init>(r6)
            r7.setOnClickListener(r0)
            int r7 = com.talabat.sdsquad.R.id.doneBtn
            android.view.View r7 = r6._$_findCachedViewById(r7)
            android.widget.Button r7 = (android.widget.Button) r7
            hu.e r0 = new hu.e
            r0.<init>(r6)
            r7.setOnClickListener(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.sdsquad.ui.filters.FiltersFragment.onActivityCreated(android.os.Bundle):void");
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "FiltersFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "FiltersFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_filters, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…ilters, container, false)");
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

    public void sortClicked(@NotNull Sort sort) {
        Intrinsics.checkNotNullParameter(sort, "sortModel");
        FiltersViewModel filtersViewModel = this.viewModel;
        if (filtersViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            filtersViewModel = null;
        }
        filtersViewModel.setSelectedSort(sort);
        showBottomButtons();
    }
}
