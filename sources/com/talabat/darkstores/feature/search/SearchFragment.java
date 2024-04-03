package com.talabat.darkstores.feature.search;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.FragmentKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.base.BaseFragment;
import com.talabat.darkstores.common.extensions.SearchViewExtensionsKt;
import com.talabat.darkstores.common.extensions.ViewExtensionsKt;
import com.talabat.darkstores.common.extensions.ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$4;
import com.talabat.darkstores.common.extensions.ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$5;
import com.talabat.darkstores.common.extensions.ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$6;
import com.talabat.darkstores.common.extensions.ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$7;
import com.talabat.darkstores.feature.tracking.EventOriginType;
import com.talabat.darkstores.model.SearchSuggestion;
import com.talabat.feature.darkstores.domain.tracking.ScreenTrackingProvider;
import com.talabat.wrapper.EventWrapper;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mj.c;
import mj.d;
import mj.e;
import mj.f;
import mj.g;
import mj.h;
import mj.i;
import mj.j;
import mj.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 C2\u00020\u0001:\u0001CB\u0007¢\u0006\u0004\bA\u0010BJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0014\u0010\t\u001a\u00020\u0004*\u00020\u00062\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\u0016\u0010\u0014\u001a\u00020\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\u001a\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016J\b\u0010\u001d\u001a\u00020\u0004H\u0014R\u001a\u0010\u001f\u001a\u00020\u001e8\u0016X\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001a\u0010$\u001a\u00020#8\u0016XD¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001a\u0010)\u001a\u00020(8\u0016X\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001b\u00102\u001a\u00020-8BX\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001b\u00106\u001a\u00020\u00028BX\u0002¢\u0006\f\n\u0004\b3\u0010/\u001a\u0004\b4\u00105R\u001b\u0010;\u001a\u0002078BX\u0002¢\u0006\f\n\u0004\b8\u0010/\u001a\u0004\b9\u0010:R\u001b\u0010@\u001a\u00020<8BX\u0002¢\u0006\f\n\u0004\b=\u0010/\u001a\u0004\b>\u0010?¨\u0006D"}, d2 = {"Lcom/talabat/darkstores/feature/search/SearchFragment;", "Lcom/talabat/darkstores/common/base/BaseFragment;", "Landroidx/navigation/NavController$OnDestinationChangedListener;", "createDestinationListener", "", "observeSearchSuggestions", "Landroidx/recyclerview/widget/RecyclerView;", "", "isEmptyResult", "selectAdapter", "observeCartMap", "observeNavigation", "observePreSearchItems", "observeViewAllVisibility", "observeSearchQuery", "setupSearchView", "setupRecyclerView", "", "Lcom/talabat/darkstores/model/SearchSuggestion;", "suggestions", "onDataReceived", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "onStart", "onStop", "onRetryClicked", "i0", "", "contentViewId", "I", "getContentViewId", "()I", "", "screenName", "Ljava/lang/String;", "getScreenName", "()Ljava/lang/String;", "Lcom/talabat/darkstores/feature/tracking/EventOriginType;", "eventOriginType", "Lcom/talabat/darkstores/feature/tracking/EventOriginType;", "getEventOriginType", "()Lcom/talabat/darkstores/feature/tracking/EventOriginType;", "Lcom/talabat/darkstores/feature/search/SearchFragmentViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/talabat/darkstores/feature/search/SearchFragmentViewModel;", "viewModel", "destinationListener$delegate", "getDestinationListener", "()Landroidx/navigation/NavController$OnDestinationChangedListener;", "destinationListener", "Lcom/talabat/darkstores/feature/search/SearchSuggestionsAdapter;", "searchSuggestionsAdapter$delegate", "getSearchSuggestionsAdapter", "()Lcom/talabat/darkstores/feature/search/SearchSuggestionsAdapter;", "searchSuggestionsAdapter", "Lcom/talabat/darkstores/feature/search/PreSearchAdapter;", "preSearchAdapter$delegate", "getPreSearchAdapter", "()Lcom/talabat/darkstores/feature/search/PreSearchAdapter;", "preSearchAdapter", "<init>", "()V", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0})
public final class SearchFragment extends BaseFragment {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String SCREEN_NAME = "DS Search";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final int contentViewId = R.layout.darkstores_fragment_search;
    @NotNull
    private final Lazy destinationListener$delegate;
    @NotNull
    private final EventOriginType eventOriginType = EventOriginType.Search;
    @NotNull
    private final Lazy preSearchAdapter$delegate;
    @NotNull
    private final String screenName = SCREEN_NAME;
    @NotNull
    private final Lazy searchSuggestionsAdapter$delegate;
    @NotNull
    private final Lazy viewModel$delegate;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/darkstores/feature/search/SearchFragment$Companion;", "", "()V", "SCREEN_NAME", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SearchFragment() {
        SearchFragment$special$$inlined$viewModel$1 searchFragment$special$$inlined$viewModel$1 = new SearchFragment$special$$inlined$viewModel$1();
        ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$4 viewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$4 = new ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$4(this);
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        Lazy lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$5(viewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$4));
        this.viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SearchFragmentViewModel.class), new ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$6(lazy), new ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$7((Function0) null, lazy), searchFragment$special$$inlined$viewModel$1);
        this.destinationListener$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new SearchFragment$destinationListener$2(this));
        this.searchSuggestionsAdapter$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new SearchFragment$searchSuggestionsAdapter$2(this));
        this.preSearchAdapter$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new SearchFragment$preSearchAdapter$2(this));
    }

    /* access modifiers changed from: private */
    public final NavController.OnDestinationChangedListener createDestinationListener() {
        return new g(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: createDestinationListener$lambda-2  reason: not valid java name */
    public static final void m10060createDestinationListener$lambda2(SearchFragment searchFragment, NavController navController, NavDestination navDestination, Bundle bundle) {
        Intrinsics.checkNotNullParameter(searchFragment, "this$0");
        Intrinsics.checkNotNullParameter(navController, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(navDestination, "destination");
        if (navDestination.getId() == R.id.homeFragment) {
            searchFragment.getViewModel().onBackClicked();
        }
    }

    private final NavController.OnDestinationChangedListener getDestinationListener() {
        return (NavController.OnDestinationChangedListener) this.destinationListener$delegate.getValue();
    }

    private final PreSearchAdapter getPreSearchAdapter() {
        return (PreSearchAdapter) this.preSearchAdapter$delegate.getValue();
    }

    private final SearchSuggestionsAdapter getSearchSuggestionsAdapter() {
        return (SearchSuggestionsAdapter) this.searchSuggestionsAdapter$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final SearchFragmentViewModel getViewModel() {
        return (SearchFragmentViewModel) this.viewModel$delegate.getValue();
    }

    private final void observeCartMap() {
        getCartFragmentViewModel().getCartMapLiveData().observe(getViewLifecycleOwner(), new k(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: observeCartMap$lambda-3  reason: not valid java name */
    public static final void m10061observeCartMap$lambda3(SearchFragment searchFragment, Map map) {
        Intrinsics.checkNotNullParameter(searchFragment, "this$0");
        SearchSuggestionsAdapter searchSuggestionsAdapter = searchFragment.getSearchSuggestionsAdapter();
        Intrinsics.checkNotNullExpressionValue(map, "cartCountMap");
        searchSuggestionsAdapter.setCartCountMap(map);
        searchFragment.getPreSearchAdapter().setCartCountMap(map);
    }

    private final void observeNavigation() {
        getViewModel().getNavigationActions().observe(getViewLifecycleOwner(), new e(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: observeNavigation$lambda-5  reason: not valid java name */
    public static final void m10062observeNavigation$lambda5(SearchFragment searchFragment, EventWrapper eventWrapper) {
        Intrinsics.checkNotNullParameter(searchFragment, "this$0");
        NavDirections navDirections = (NavDirections) eventWrapper.getContentIfNotHandled();
        if (navDirections != null) {
            FragmentKt.findNavController(searchFragment).navigate(navDirections);
        }
    }

    private final void observePreSearchItems() {
        getViewModel().getPreSearchItems().observe(getViewLifecycleOwner(), new i(getPreSearchAdapter()));
    }

    private final void observeSearchQuery() {
        getViewModel().getSearchQueryLiveData().observe(getViewLifecycleOwner(), new h(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: observeSearchQuery$lambda-7  reason: not valid java name */
    public static final void m10063observeSearchQuery$lambda7(SearchFragment searchFragment, String str) {
        Intrinsics.checkNotNullParameter(searchFragment, "this$0");
        ((TextView) searchFragment._$_findCachedViewById(R.id.text_view_all_results)).setText(searchFragment.getString(com.talabat.localization.R.string.search_view_all_results, str));
    }

    private final void observeSearchSuggestions() {
        BaseFragment.observeHandleErrors$default(this, getViewModel().getSuggestionsLiveData(), (LifecycleOwner) null, new SearchFragment$observeSearchSuggestions$1(this), 1, (Object) null);
    }

    private final void observeViewAllVisibility() {
        getViewModel().getViewAllButtonVisibilityLiveData().observe(getViewLifecycleOwner(), new j(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: observeViewAllVisibility$lambda-6  reason: not valid java name */
    public static final void m10064observeViewAllVisibility$lambda6(SearchFragment searchFragment, Boolean bool) {
        int i11;
        Intrinsics.checkNotNullParameter(searchFragment, "this$0");
        LinearLayout linearLayout = (LinearLayout) searchFragment._$_findCachedViewById(R.id.view_all_results);
        Intrinsics.checkNotNullExpressionValue(linearLayout, "view_all_results");
        Intrinsics.checkNotNullExpressionValue(bool, "isVisible");
        if (bool.booleanValue()) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        linearLayout.setVisibility(i11);
    }

    /* access modifiers changed from: private */
    public final void onDataReceived(List<? extends SearchSuggestion> list) {
        getSearchSuggestionsAdapter().submitList(list);
        ((RecyclerView) _$_findCachedViewById(R.id.recyclerView)).smoothScrollToPosition(0);
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-1  reason: not valid java name */
    public static final void m10065onViewCreated$lambda1(SearchFragment searchFragment, View view) {
        Intrinsics.checkNotNullParameter(searchFragment, "this$0");
        SearchFragmentViewModel.onSearchQuerySubmitted$default(searchFragment.getViewModel(), ((SearchView) searchFragment._$_findCachedViewById(R.id.searchView)).getQuery().toString(), (ScreenTrackingProvider.EventOrigin) null, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:9:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void selectAdapter(androidx.recyclerview.widget.RecyclerView r2, boolean r3) {
        /*
            r1 = this;
            if (r3 == 0) goto L_0x001e
            int r3 = com.talabat.darkstores.R.id.searchView
            android.view.View r3 = r1._$_findCachedViewById(r3)
            androidx.appcompat.widget.SearchView r3 = (androidx.appcompat.widget.SearchView) r3
            java.lang.CharSequence r3 = r3.getQuery()
            java.lang.String r0 = "searchView.query"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            boolean r3 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r3)
            if (r3 == 0) goto L_0x001e
            com.talabat.darkstores.feature.search.PreSearchAdapter r3 = r1.getPreSearchAdapter()
            goto L_0x0022
        L_0x001e:
            com.talabat.darkstores.feature.search.SearchSuggestionsAdapter r3 = r1.getSearchSuggestionsAdapter()
        L_0x0022:
            androidx.recyclerview.widget.RecyclerView$Adapter r0 = r2.getAdapter()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r3)
            if (r0 != 0) goto L_0x002f
            r2.setAdapter(r3)
        L_0x002f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.feature.search.SearchFragment.selectAdapter(androidx.recyclerview.widget.RecyclerView, boolean):void");
    }

    private final void setupRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(getPreSearchAdapter());
        recyclerView.setOnTouchListener(new f(recyclerView));
    }

    /* access modifiers changed from: private */
    /* renamed from: setupRecyclerView$lambda-12$lambda-11  reason: not valid java name */
    public static final boolean m10066setupRecyclerView$lambda12$lambda11(RecyclerView recyclerView, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullExpressionValue(recyclerView, "");
        return ViewExtensionsKt.hideKeyboard(recyclerView);
    }

    private final void setupSearchView() {
        int i11 = R.id.searchView;
        SearchView searchView = (SearchView) _$_findCachedViewById(i11);
        searchView.setOnQueryTextListener(new SearchFragment$setupSearchView$1$1(this));
        searchView.setOnQueryTextFocusChangeListener(new d(searchView));
        SearchView searchView2 = (SearchView) _$_findCachedViewById(i11);
        Intrinsics.checkNotNullExpressionValue(searchView2, "searchView");
        SearchViewExtensionsKt.styleMarshmallowSearchBar(searchView2);
        searchView.requestFocus();
    }

    /* access modifiers changed from: private */
    /* renamed from: setupSearchView$lambda-10$lambda-9  reason: not valid java name */
    public static final void m10067setupSearchView$lambda10$lambda9(SearchView searchView, View view, boolean z11) {
        if (z11) {
            try {
                Result.Companion companion = Result.Companion;
                View findFocus = searchView.findFocus();
                Intrinsics.checkNotNullExpressionValue(findFocus, "findFocus()");
                ViewExtensionsKt.showKeyboard(findFocus);
                Result.m6329constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
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
    public EventOriginType getEventOriginType() {
        return this.eventOriginType;
    }

    @NotNull
    public String getScreenName() {
        return this.screenName;
    }

    public void i0() {
        super.i0();
        ((Toolbar) _$_findCachedViewById(R.id.toolbar)).setNavigationIcon(ResourcesCompat.getDrawable(getResources(), com.designsystem.marshmallow.R.drawable.ds_arrow_back, (Resources.Theme) null));
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onRetryClicked() {
        getViewModel().onRetry();
    }

    public void onStart() {
        super.onStart();
        FragmentKt.findNavController(this).addOnDestinationChangedListener(getDestinationListener());
    }

    public void onStop() {
        super.onStop();
        FragmentKt.findNavController(this).removeOnDestinationChangedListener(getDestinationListener());
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        setupRecyclerView();
        setupSearchView();
        observePreSearchItems();
        observeSearchSuggestions();
        observeCartMap();
        observeNavigation();
        observeViewAllVisibility();
        observeSearchQuery();
        ((LinearLayout) _$_findCachedViewById(R.id.view_all_results)).setOnClickListener(new c(this));
    }
}
