package com.talabat.darkstores.feature.categoriesOverview;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.navigation.NavArgsLazy;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.FragmentKt;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cj.a;
import cj.b;
import cj.c;
import cj.d;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.Result;
import com.talabat.darkstores.common.base.BaseBottomSheet;
import com.talabat.darkstores.common.extensions.SearchViewExtensionsKt;
import com.talabat.darkstores.common.extensions.ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$4;
import com.talabat.darkstores.common.extensions.ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$5;
import com.talabat.darkstores.common.extensions.ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$6;
import com.talabat.darkstores.common.extensions.ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$7;
import com.talabat.darkstores.feature.home.CategoriesListAdapter;
import com.talabat.darkstores.model.Category;
import com.talabat.talabatcommon.views.ShimmerLayout;
import com.talabat.wrapper.EventWrapper;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\b\u0000\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0016\u0010\n\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\u001a\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0014R\u001b\u0010\u0017\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001d\u001a\u00020\u00188BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\"\u001a\u00020\u001e8BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0014\u001a\u0004\b \u0010!R\u001a\u0010$\u001a\u00020#8\u0014X\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'¨\u0006+"}, d2 = {"Lcom/talabat/darkstores/feature/categoriesOverview/CategoriesOverviewBottomSheet;", "Lcom/talabat/darkstores/common/base/BaseBottomSheet;", "", "observeNavigationActions", "setupSearchView", "setupCategoriesRecyclerView", "observeSearchCategory", "", "Lcom/talabat/darkstores/model/Category;", "categories", "onCategoriesReceived", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "", "i0", "Lcom/talabat/darkstores/feature/categoriesOverview/CategoriesOverviewFragmentViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/talabat/darkstores/feature/categoriesOverview/CategoriesOverviewFragmentViewModel;", "viewModel", "Lcom/talabat/darkstores/feature/categoriesOverview/CategoriesOverviewBottomSheetArgs;", "args$delegate", "Landroidx/navigation/NavArgsLazy;", "getArgs", "()Lcom/talabat/darkstores/feature/categoriesOverview/CategoriesOverviewBottomSheetArgs;", "args", "Lcom/talabat/darkstores/feature/home/CategoriesListAdapter;", "categoriesListAdapter$delegate", "getCategoriesListAdapter", "()Lcom/talabat/darkstores/feature/home/CategoriesListAdapter;", "categoriesListAdapter", "", "contentViewId", "I", "getContentViewId", "()I", "<init>", "()V", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0})
public final class CategoriesOverviewBottomSheet extends BaseBottomSheet {
    private static final int COLUMN_SPAN = 4;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String SCREEN_NAME = "DS All Categories";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    private final NavArgsLazy args$delegate;
    @NotNull
    private final Lazy categoriesListAdapter$delegate;
    private final int contentViewId;
    @NotNull
    private final Lazy viewModel$delegate;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/darkstores/feature/categoriesOverview/CategoriesOverviewBottomSheet$Companion;", "", "()V", "COLUMN_SPAN", "", "SCREEN_NAME", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CategoriesOverviewBottomSheet() {
        CategoriesOverviewBottomSheet$special$$inlined$viewModel$1 categoriesOverviewBottomSheet$special$$inlined$viewModel$1 = new CategoriesOverviewBottomSheet$special$$inlined$viewModel$1();
        ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$4 viewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$4 = new ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$4(this);
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        Lazy lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$5(viewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$4));
        this.viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(CategoriesOverviewFragmentViewModel.class), new ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$6(lazy), new ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$7((Function0) null, lazy), categoriesOverviewBottomSheet$special$$inlined$viewModel$1);
        this.args$delegate = new NavArgsLazy(Reflection.getOrCreateKotlinClass(CategoriesOverviewBottomSheetArgs.class), new CategoriesOverviewBottomSheet$special$$inlined$navArgs$1(this));
        this.categoriesListAdapter$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new CategoriesOverviewBottomSheet$categoriesListAdapter$2(this));
        this.contentViewId = R.layout.darkstores_fragment_bottom_sheet_categories_overview;
    }

    /* access modifiers changed from: private */
    public final CategoriesOverviewBottomSheetArgs getArgs() {
        return (CategoriesOverviewBottomSheetArgs) this.args$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final CategoriesListAdapter getCategoriesListAdapter() {
        return (CategoriesListAdapter) this.categoriesListAdapter$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final CategoriesOverviewFragmentViewModel getViewModel() {
        return (CategoriesOverviewFragmentViewModel) this.viewModel$delegate.getValue();
    }

    private final void observeNavigationActions() {
        getViewModel().getNavigationActions().observe(getViewLifecycleOwner(), new d(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: observeNavigationActions$lambda-3  reason: not valid java name */
    public static final void m9935observeNavigationActions$lambda3(CategoriesOverviewBottomSheet categoriesOverviewBottomSheet, EventWrapper eventWrapper) {
        Intrinsics.checkNotNullParameter(categoriesOverviewBottomSheet, "this$0");
        NavDirections navDirections = (NavDirections) eventWrapper.getContentIfNotHandled();
        if (navDirections != null) {
            FragmentKt.findNavController(categoriesOverviewBottomSheet).navigate(navDirections);
        }
    }

    private final void observeSearchCategory() {
        getViewModel().getSearchCategoryLiveData().observe(getViewLifecycleOwner(), new a(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: observeSearchCategory$lambda-7  reason: not valid java name */
    public static final void m9936observeSearchCategory$lambda7(CategoriesOverviewBottomSheet categoriesOverviewBottomSheet, Result result) {
        int i11;
        int i12;
        Intrinsics.checkNotNullParameter(categoriesOverviewBottomSheet, "this$0");
        if (result.isLoading()) {
            categoriesOverviewBottomSheet.getCategoriesListAdapter().submitSearchCategories(CollectionsKt__CollectionsKt.emptyList());
            categoriesOverviewBottomSheet.getCategoriesListAdapter().notifyDataSetChanged();
            ((ShimmerLayout) categoriesOverviewBottomSheet._$_findCachedViewById(R.id.loading_layout)).startShimmerAnimation();
        } else {
            ((ShimmerLayout) categoriesOverviewBottomSheet._$_findCachedViewById(R.id.loading_layout)).stopShimmerAnimation();
        }
        ShimmerLayout shimmerLayout = (ShimmerLayout) categoriesOverviewBottomSheet._$_findCachedViewById(R.id.loading_layout);
        Intrinsics.checkNotNullExpressionValue(shimmerLayout, "loading_layout");
        int i13 = 0;
        if (result.isLoading()) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        shimmerLayout.setVisibility(i11);
        LinearLayout linearLayout = (LinearLayout) categoriesOverviewBottomSheet._$_findCachedViewById(R.id.no_results_layout);
        Intrinsics.checkNotNullExpressionValue(linearLayout, "no_results_layout");
        if (result.isError()) {
            i12 = 0;
        } else {
            i12 = 8;
        }
        linearLayout.setVisibility(i12);
        RecyclerView recyclerView = (RecyclerView) categoriesOverviewBottomSheet._$_findCachedViewById(R.id.recyclerView);
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        if (!result.isSuccess()) {
            i13 = 8;
        }
        recyclerView.setVisibility(i13);
        if (result instanceof Result.Success) {
            categoriesOverviewBottomSheet.onCategoriesReceived((List) ((Result.Success) result).getData());
        }
    }

    private final void onCategoriesReceived(List<Category> list) {
        if (list.isEmpty()) {
            getCategoriesListAdapter().submitCategories(ArraysKt___ArraysKt.toList((T[]) getArgs().getCategories()));
        } else {
            getCategoriesListAdapter().submitSearchCategories(list);
        }
        ((RecyclerView) _$_findCachedViewById(R.id.recyclerView)).smoothScrollToPosition(0);
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-1  reason: not valid java name */
    public static final void m9937onViewCreated$lambda1(CategoriesOverviewBottomSheet categoriesOverviewBottomSheet, View view) {
        Intrinsics.checkNotNullParameter(categoriesOverviewBottomSheet, "this$0");
        categoriesOverviewBottomSheet.dismiss();
    }

    private final void setupCategoriesRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 4));
        recyclerView.setAdapter(getCategoriesListAdapter());
    }

    private final void setupSearchView() {
        int i11;
        SearchView searchView = (SearchView) _$_findCachedViewById(R.id.searchView);
        Intrinsics.checkNotNullExpressionValue(searchView, "");
        SearchViewExtensionsKt.styleMarshmallowSearchBar(searchView);
        if (getViewModel().isSearchCategoryEnabled()) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        searchView.setVisibility(i11);
        searchView.setOnQueryTextListener(new CategoriesOverviewBottomSheet$setupSearchView$1$1(this));
        searchView.setOnQueryTextFocusChangeListener(new b(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setupSearchView$lambda-5$lambda-4  reason: not valid java name */
    public static final void m9938setupSearchView$lambda5$lambda4(CategoriesOverviewBottomSheet categoriesOverviewBottomSheet, View view, boolean z11) {
        Intrinsics.checkNotNullParameter(categoriesOverviewBottomSheet, "this$0");
        if (z11) {
            categoriesOverviewBottomSheet.getViewModel().onCategorySearchBarClicked();
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

    public int getContentViewId() {
        return this.contentViewId;
    }

    @NotNull
    public String i0() {
        return SCREEN_NAME;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        setupSearchView();
        setupCategoriesRecyclerView();
        ((ImageView) _$_findCachedViewById(R.id.category_overview_close)).setOnClickListener(new c(this));
        observeSearchCategory();
        observeNavigationActions();
    }
}
