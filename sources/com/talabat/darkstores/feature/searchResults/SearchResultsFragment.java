package com.talabat.darkstores.feature.searchResults;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.navigation.NavArgsLazy;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.FragmentKt;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.base.BaseFragment;
import com.talabat.darkstores.common.extensions.SearchViewExtensionsKt;
import com.talabat.darkstores.common.extensions.ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$4;
import com.talabat.darkstores.common.extensions.ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$5;
import com.talabat.darkstores.common.extensions.ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$6;
import com.talabat.darkstores.common.extensions.ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$7;
import com.talabat.darkstores.feature.cart.CartFragmentViewModel;
import com.talabat.darkstores.feature.home.swimlane.ProductClickTrackingAttribute;
import com.talabat.darkstores.feature.searchResults.NavigationCommand;
import com.talabat.darkstores.feature.searchResults.SearchResultsFragmentDirections;
import com.talabat.darkstores.feature.searchResults.SearchResultsFragmentViewModel;
import com.talabat.darkstores.feature.searchResults.SearchResultsType;
import com.talabat.darkstores.feature.tracking.EventOriginType;
import com.talabat.feature.darkstorescart.data.model.Product;
import com.talabat.wrapper.EventWrapper;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import oj.b;
import oj.c;
import oj.d;
import oj.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u0000 >2\u00020\u0001:\u0001>B\u0007¢\u0006\u0004\b<\u0010=J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0002H\u0002J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\u001a\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0014J\b\u0010\u001c\u001a\u00020\u0004H\u0016R\u001b\u0010\"\u001a\u00020\u001d8BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001a\u0010#\u001a\u00020\u00028\u0016X\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020\t8\u0016XD¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001b\u00100\u001a\u00020+8VX\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001b\u00105\u001a\u0002018BX\u0002¢\u0006\f\n\u0004\b2\u0010-\u001a\u0004\b3\u00104R\u0016\u00107\u001a\u0002068\u0002@\u0002X.¢\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010:\u001a\u0002098BX\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;¨\u0006?"}, d2 = {"Lcom/talabat/darkstores/feature/searchResults/SearchResultsFragment;", "Lcom/talabat/darkstores/common/base/BaseFragment;", "", "itemCount", "", "setupLabel", "count", "Lcom/talabat/darkstores/feature/searchResults/SearchResultsType$Query;", "resultsType", "", "queryLabel", "emptyLabel", "setupRecyclerView", "observeData", "observeNavigationCommands", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "product", "position", "onProductClicked", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "onResume", "Landroid/view/View;", "view", "onViewCreated", "onRetryClicked", "i0", "onDestroyView", "Lcom/talabat/darkstores/feature/searchResults/SearchResultsFragmentArgs;", "args$delegate", "Landroidx/navigation/NavArgsLazy;", "getArgs", "()Lcom/talabat/darkstores/feature/searchResults/SearchResultsFragmentArgs;", "args", "contentViewId", "I", "getContentViewId", "()I", "screenName", "Ljava/lang/String;", "getScreenName", "()Ljava/lang/String;", "Lcom/talabat/darkstores/feature/tracking/EventOriginType;", "eventOriginType$delegate", "Lkotlin/Lazy;", "getEventOriginType", "()Lcom/talabat/darkstores/feature/tracking/EventOriginType;", "eventOriginType", "Lcom/talabat/darkstores/feature/searchResults/SearchResultsFragmentViewModel;", "viewModel$delegate", "getViewModel", "()Lcom/talabat/darkstores/feature/searchResults/SearchResultsFragmentViewModel;", "viewModel", "Lcom/talabat/darkstores/feature/searchResults/SearchResultsProductsListAdapter;", "productsListAdapter", "Lcom/talabat/darkstores/feature/searchResults/SearchResultsProductsListAdapter;", "", "isFromSearch", "()Z", "<init>", "()V", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0})
public final class SearchResultsFragment extends BaseFragment {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String SCREEN_NAME = "DS Search Results";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    private final NavArgsLazy args$delegate = new NavArgsLazy(Reflection.getOrCreateKotlinClass(SearchResultsFragmentArgs.class), new SearchResultsFragment$special$$inlined$navArgs$1(this));
    private final int contentViewId = R.layout.darkstores_fragment_search_results;
    @NotNull
    private final Lazy eventOriginType$delegate;
    /* access modifiers changed from: private */
    public SearchResultsProductsListAdapter productsListAdapter;
    @NotNull
    private final String screenName = SCREEN_NAME;
    @NotNull
    private final Lazy viewModel$delegate;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/darkstores/feature/searchResults/SearchResultsFragment$Companion;", "", "()V", "SCREEN_NAME", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SearchResultsFragment() {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.eventOriginType$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new SearchResultsFragment$eventOriginType$2(this));
        SearchResultsFragment$special$$inlined$viewModel$1 searchResultsFragment$special$$inlined$viewModel$1 = new SearchResultsFragment$special$$inlined$viewModel$1(this);
        Lazy lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$5(new ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$4(this)));
        this.viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SearchResultsFragmentViewModel.class), new ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$6(lazy), new ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$7((Function0) null, lazy), searchResultsFragment$special$$inlined$viewModel$1);
    }

    private final String emptyLabel(int i11) {
        String quantityString = getResources().getQuantityString(com.talabat.localization.R.plurals.empty_query_title, i11, new Object[]{Integer.valueOf(i11)});
        Intrinsics.checkNotNullExpressionValue(quantityString, "resources.getQuantityStr…          count\n        )");
        return quantityString;
    }

    /* access modifiers changed from: private */
    public final SearchResultsFragmentArgs getArgs() {
        return (SearchResultsFragmentArgs) this.args$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final SearchResultsFragmentViewModel getViewModel() {
        return (SearchResultsFragmentViewModel) this.viewModel$delegate.getValue();
    }

    private final boolean isFromSearch() {
        NavDestination destination;
        NavBackStackEntry previousBackStackEntry = FragmentKt.findNavController(this).getPreviousBackStackEntry();
        if (previousBackStackEntry == null || (destination = previousBackStackEntry.getDestination()) == null) {
            return false;
        }
        int id2 = destination.getId();
        if (id2 == R.id.searchFragment || id2 == R.id.flutterSearchFragment) {
            return true;
        }
        return false;
    }

    private final void observeData() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner).launchWhenStarted(new SearchResultsFragment$observeData$1(this, (Continuation<? super SearchResultsFragment$observeData$1>) null));
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner2).launchWhenStarted(new SearchResultsFragment$observeData$2(this, (Continuation<? super SearchResultsFragment$observeData$2>) null));
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "viewLifecycleOwner");
        LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner3).launchWhenStarted(new SearchResultsFragment$observeData$3(this, (Continuation<? super SearchResultsFragment$observeData$3>) null));
        getCartFragmentViewModel().getCartMapLiveData().observe(getViewLifecycleOwner(), new d(this));
        observeNavigationCommands();
    }

    /* access modifiers changed from: private */
    /* renamed from: observeData$lambda-7  reason: not valid java name */
    public static final void m10080observeData$lambda7(SearchResultsFragment searchResultsFragment, Map map) {
        Intrinsics.checkNotNullParameter(searchResultsFragment, "this$0");
        SearchResultsProductsListAdapter searchResultsProductsListAdapter = searchResultsFragment.productsListAdapter;
        if (searchResultsProductsListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("productsListAdapter");
            searchResultsProductsListAdapter = null;
        }
        Intrinsics.checkNotNullExpressionValue(map, "it");
        searchResultsProductsListAdapter.setCartCountMap(map);
    }

    private final void observeNavigationCommands() {
        getViewModel().getNavigationCommands().observe(getViewLifecycleOwner(), new e(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: observeNavigationCommands$lambda-9  reason: not valid java name */
    public static final void m10081observeNavigationCommands$lambda9(SearchResultsFragment searchResultsFragment, EventWrapper eventWrapper) {
        Intrinsics.checkNotNullParameter(searchResultsFragment, "this$0");
        NavigationCommand navigationCommand = (NavigationCommand) eventWrapper.getContentIfNotHandled();
        if (navigationCommand == null) {
            return;
        }
        if (Intrinsics.areEqual((Object) navigationCommand, (Object) NavigationCommand.Back.INSTANCE)) {
            FragmentKt.findNavController(searchResultsFragment).popBackStack();
        } else if (navigationCommand instanceof NavigationCommand.OpenScreen) {
            FragmentKt.findNavController(searchResultsFragment).navigate(((NavigationCommand.OpenScreen) navigationCommand).getAction());
        }
    }

    /* access modifiers changed from: private */
    public final void onProductClicked(Product product, int i11) {
        getViewModel().onProductOpened(product, i11);
        FragmentKt.findNavController(this).navigate(SearchResultsFragmentDirections.Companion.actionToProductFragment$default(SearchResultsFragmentDirections.Companion, product, false, (String) null, (String) null, (ProductClickTrackingAttribute) null, (String) null, (String) null, (String) null, 252, (Object) null));
    }

    private final String queryLabel(int i11, SearchResultsType.Query query) {
        String quantityString = getResources().getQuantityString(com.talabat.localization.R.plurals.query_title, i11, new Object[]{query.getQuery(), Integer.valueOf(i11)});
        Intrinsics.checkNotNullExpressionValue(quantityString, "resources.getQuantityStr…          count\n        )");
        return quantityString;
    }

    private final void setupLabel(int i11) {
        String str;
        SearchResultsType resultsType = getArgs().getResultsType();
        int i12 = R.id.label;
        TextView textView = (TextView) _$_findCachedViewById(i12);
        Intrinsics.checkNotNullExpressionValue(textView, "label");
        textView.setVisibility(0);
        TextView textView2 = (TextView) _$_findCachedViewById(i12);
        SearchResultsFragmentViewModel.ListLabel label = getViewModel().getLabel(resultsType, i11);
        if (label instanceof SearchResultsFragmentViewModel.ListLabel.Text) {
            str = ((SearchResultsFragmentViewModel.ListLabel.Text) label).getLabel();
        } else if (label instanceof SearchResultsFragmentViewModel.ListLabel.EmptyLabel) {
            str = emptyLabel(i11);
        } else if (label instanceof SearchResultsFragmentViewModel.ListLabel.QueryLabel) {
            str = queryLabel(i11, (SearchResultsType.Query) resultsType);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        textView2.setText(str);
    }

    private final void setupRecyclerView() {
        CartFragmentViewModel cartFragmentViewModel = getCartFragmentViewModel();
        SearchResultsFragment$setupRecyclerView$1 searchResultsFragment$setupRecyclerView$1 = new SearchResultsFragment$setupRecyclerView$1(getViewModel());
        SearchResultsType resultsType = getArgs().getResultsType();
        SearchResultsFragmentViewModel viewModel = getViewModel();
        SearchResultsProductsListAdapter searchResultsProductsListAdapter = null;
        if (!(getArgs().getResultsType() instanceof SearchResultsType.Query)) {
            viewModel = null;
        }
        SearchResultsProductsListAdapter searchResultsProductsListAdapter2 = new SearchResultsProductsListAdapter(cartFragmentViewModel, searchResultsFragment$setupRecyclerView$1, resultsType, viewModel);
        searchResultsProductsListAdapter2.setOnItemClickListener(new SearchResultsFragment$setupRecyclerView$3$1(this));
        this.productsListAdapter = searchResultsProductsListAdapter2;
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 2));
        SearchResultsProductsListAdapter searchResultsProductsListAdapter3 = this.productsListAdapter;
        if (searchResultsProductsListAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("productsListAdapter");
            searchResultsProductsListAdapter3 = null;
        }
        recyclerView.setAdapter(searchResultsProductsListAdapter3);
        SearchResultsFragmentViewModel viewModel2 = getViewModel();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "this");
        viewModel2.startImpressionTracking(recyclerView, this);
        SearchResultsProductsListAdapter searchResultsProductsListAdapter4 = this.productsListAdapter;
        if (searchResultsProductsListAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("productsListAdapter");
        } else {
            searchResultsProductsListAdapter = searchResultsProductsListAdapter4;
        }
        searchResultsProductsListAdapter.getLabelUpdateWithItemsCount().observe(getViewLifecycleOwner(), new b(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setupRecyclerView$lambda-6  reason: not valid java name */
    public static final void m10082setupRecyclerView$lambda6(SearchResultsFragment searchResultsFragment, Integer num) {
        Intrinsics.checkNotNullParameter(searchResultsFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(num, "it");
        searchResultsFragment.setupLabel(num.intValue());
    }

    /* access modifiers changed from: private */
    /* renamed from: setupToolbar$lambda-2  reason: not valid java name */
    public static final void m10083setupToolbar$lambda2(SearchResultsFragment searchResultsFragment, View view) {
        Intrinsics.checkNotNullParameter(searchResultsFragment, "this$0");
        searchResultsFragment.getViewModel().onSearchBarClicked(searchResultsFragment.isFromSearch());
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
        return (EventOriginType) this.eventOriginType$delegate.getValue();
    }

    @NotNull
    public String getScreenName() {
        return this.screenName;
    }

    public void i0() {
        super.i0();
        int i11 = R.id.toolbar;
        ((Toolbar) _$_findCachedViewById(i11)).findViewById(R.id.btnSearch).setOnClickListener(new c(this));
        ((Toolbar) _$_findCachedViewById(i11)).setNavigationIcon(getResources().getDrawable(com.designsystem.marshmallow.R.drawable.ds_arrow_back, (Resources.Theme) null));
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        getViewModel().startTraceDefinition();
    }

    public void onDestroyView() {
        getViewModel().stopImpressionTracking();
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onResume() {
        super.onResume();
        getViewModel().onReadyForInteractionDhDefinition();
    }

    public void onRetryClicked() {
        SearchResultsProductsListAdapter searchResultsProductsListAdapter = this.productsListAdapter;
        if (searchResultsProductsListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("productsListAdapter");
            searchResultsProductsListAdapter = null;
        }
        searchResultsProductsListAdapter.retry();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        SearchResultsType.Query query;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        SearchResultsType resultsType = getArgs().getResultsType();
        String str = null;
        if (resultsType instanceof SearchResultsType.Query) {
            query = (SearchResultsType.Query) resultsType;
        } else {
            query = null;
        }
        if (query != null) {
            str = query.getQuery();
        }
        if (str == null) {
            str = "";
        }
        int i11 = R.id.searchView;
        ((SearchView) _$_findCachedViewById(i11)).setQuery(str, false);
        SearchView searchView = (SearchView) _$_findCachedViewById(i11);
        Intrinsics.checkNotNullExpressionValue(searchView, "searchView");
        SearchViewExtensionsKt.styleMarshmallowSearchBar(searchView);
        ((TextView) _$_findCachedViewById(R.id.errorTitle)).setText(getString(com.talabat.localization.R.string.no_results_title, str));
        setupRecyclerView();
        observeData();
    }
}
