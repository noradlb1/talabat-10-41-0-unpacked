package com.talabat.darkstores.feature.categories.subcategories;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.navigation.fragment.FragmentKt;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.Result;
import com.talabat.darkstores.common.base.BaseFragment;
import com.talabat.darkstores.common.extensions.ContextExtensionsKt;
import com.talabat.darkstores.common.extensions.ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$4;
import com.talabat.darkstores.common.extensions.ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$5;
import com.talabat.darkstores.common.extensions.ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$6;
import com.talabat.darkstores.common.extensions.ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$7;
import com.talabat.darkstores.common.view.LoadingFailedView;
import com.talabat.darkstores.data.tracking.EventOrigin;
import com.talabat.darkstores.feature.categories.CategoriesFragmentDirections;
import com.talabat.darkstores.feature.home.swimlane.ProductClickTrackingAttribute;
import com.talabat.darkstores.feature.tracking.EventOriginType;
import com.talabat.feature.darkstorescart.data.model.Product;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yi.f;
import yi.g;
import yi.h;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 92\u00020\u0001:\u00019B\u0007¢\u0006\u0004\b7\u00108J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J$\u0010\u000b\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\u001a\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0014J\b\u0010\u0017\u001a\u00020\u0002H\u0016R\u001a\u0010\u0019\u001a\u00020\u00188\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001e\u001a\u00020\u001d8\u0016XD¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001a\u0010#\u001a\u00020\"8\u0016X\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001b\u0010,\u001a\u00020'8BX\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001b\u00101\u001a\u00020-8BX\u0002¢\u0006\f\n\u0004\b.\u0010)\u001a\u0004\b/\u00100R\u001b\u00106\u001a\u0002028BX\u0002¢\u0006\f\n\u0004\b3\u0010)\u001a\u0004\b4\u00105¨\u0006:"}, d2 = {"Lcom/talabat/darkstores/feature/categories/subcategories/SubcategoriesFragment;", "Lcom/talabat/darkstores/common/base/BaseFragment;", "", "observeData", "setupSubcategoriesTitlesRecyclerView", "setupSwimlanesRecyclerView", "", "Lcom/talabat/darkstores/feature/categories/subcategories/SubcategoryHeadline;", "headlines", "Lcom/talabat/darkstores/feature/categories/subcategories/SubcategoryItem;", "subcategoryItems", "onDataReceived", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "product", "onProductClicked", "onResume", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "onDestroy", "i0", "onRetryClicked", "", "contentViewId", "I", "getContentViewId", "()I", "", "screenName", "Ljava/lang/String;", "getScreenName", "()Ljava/lang/String;", "Lcom/talabat/darkstores/feature/tracking/EventOriginType;", "eventOriginType", "Lcom/talabat/darkstores/feature/tracking/EventOriginType;", "getEventOriginType", "()Lcom/talabat/darkstores/feature/tracking/EventOriginType;", "Lcom/talabat/darkstores/feature/categories/subcategories/SubcategoriesFragmentViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/talabat/darkstores/feature/categories/subcategories/SubcategoriesFragmentViewModel;", "viewModel", "Lcom/talabat/darkstores/feature/categories/subcategories/HeadlinesChipsListAdapter;", "headlinesChipsListAdapter$delegate", "getHeadlinesChipsListAdapter", "()Lcom/talabat/darkstores/feature/categories/subcategories/HeadlinesChipsListAdapter;", "headlinesChipsListAdapter", "Lcom/talabat/darkstores/feature/categories/subcategories/ProductsItemsListAdapter;", "subcategoryItemsAdapter$delegate", "getSubcategoryItemsAdapter", "()Lcom/talabat/darkstores/feature/categories/subcategories/ProductsItemsListAdapter;", "subcategoryItemsAdapter", "<init>", "()V", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0})
public final class SubcategoriesFragment extends BaseFragment {
    @NotNull
    private static final String CATEGORY_ID = "category_id";
    @NotNull
    private static final String CATEGORY_NAME = "category_name";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String EVENT_ORIGIN = "event_origin";
    @NotNull
    private static final String SCREEN_NAME = "DS Subcategory Screen";
    @NotNull
    private static final String SUBCATEGORY_ID = "subcategory_id";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final int contentViewId = R.layout.darkstores_fragment_subcategories;
    @NotNull
    private final EventOriginType eventOriginType = EventOriginType.Category;
    @NotNull
    private final Lazy headlinesChipsListAdapter$delegate;
    @NotNull
    private final String screenName = SCREEN_NAME;
    @NotNull
    private final Lazy subcategoryItemsAdapter$delegate;
    @NotNull
    private final Lazy viewModel$delegate;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/darkstores/feature/categories/subcategories/SubcategoriesFragment$Companion;", "", "()V", "CATEGORY_ID", "", "CATEGORY_NAME", "EVENT_ORIGIN", "SCREEN_NAME", "SUBCATEGORY_ID", "newInstance", "Lcom/talabat/darkstores/feature/categories/subcategories/SubcategoriesFragment;", "categoryId", "categoryName", "subcategoryId", "eventOrigin", "Lcom/talabat/darkstores/data/tracking/EventOrigin;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ SubcategoriesFragment newInstance$default(Companion companion, String str, String str2, String str3, EventOrigin eventOrigin, int i11, Object obj) {
            if ((i11 & 4) != 0) {
                str3 = null;
            }
            return companion.newInstance(str, str2, str3, eventOrigin);
        }

        @NotNull
        public final SubcategoriesFragment newInstance(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable EventOrigin eventOrigin) {
            String str4;
            Intrinsics.checkNotNullParameter(str, "categoryId");
            Intrinsics.checkNotNullParameter(str2, "categoryName");
            SubcategoriesFragment subcategoriesFragment = new SubcategoriesFragment();
            Pair[] pairArr = new Pair[4];
            pairArr[0] = TuplesKt.to("category_id", str);
            pairArr[1] = TuplesKt.to("category_name", str2);
            pairArr[2] = TuplesKt.to(SubcategoriesFragment.SUBCATEGORY_ID, str3);
            if (eventOrigin != null) {
                str4 = eventOrigin.getTrackingName();
            } else {
                str4 = null;
            }
            pairArr[3] = TuplesKt.to(SubcategoriesFragment.EVENT_ORIGIN, str4);
            subcategoriesFragment.setArguments(BundleKt.bundleOf(pairArr));
            return subcategoriesFragment;
        }
    }

    public SubcategoriesFragment() {
        SubcategoriesFragment$special$$inlined$viewModel$1 subcategoriesFragment$special$$inlined$viewModel$1 = new SubcategoriesFragment$special$$inlined$viewModel$1(this);
        ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$4 viewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$4 = new ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$4(this);
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        Lazy lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$5(viewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$4));
        this.viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SubcategoriesFragmentViewModel.class), new ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$6(lazy), new ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$7((Function0) null, lazy), subcategoriesFragment$special$$inlined$viewModel$1);
        this.headlinesChipsListAdapter$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, SubcategoriesFragment$headlinesChipsListAdapter$2.INSTANCE);
        this.subcategoryItemsAdapter$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new SubcategoriesFragment$subcategoryItemsAdapter$2(this));
    }

    private final HeadlinesChipsListAdapter getHeadlinesChipsListAdapter() {
        return (HeadlinesChipsListAdapter) this.headlinesChipsListAdapter$delegate.getValue();
    }

    private final ProductsItemsListAdapter getSubcategoryItemsAdapter() {
        return (ProductsItemsListAdapter) this.subcategoryItemsAdapter$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final SubcategoriesFragmentViewModel getViewModel() {
        return (SubcategoriesFragmentViewModel) this.viewModel$delegate.getValue();
    }

    private final void observeData() {
        getViewModel().headlineSelection().observe(getViewLifecycleOwner(), new f(this));
        getViewModel().subcategoryFragmentData().observe(getViewLifecycleOwner(), new g(this));
        getCartFragmentViewModel().getCartMapLiveData().observe(getViewLifecycleOwner(), new h(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: observeData$lambda-1  reason: not valid java name */
    public static final void m9868observeData$lambda1(SubcategoriesFragment subcategoriesFragment, Integer num) {
        LinearLayoutManager linearLayoutManager;
        Intrinsics.checkNotNullParameter(subcategoriesFragment, "this$0");
        HeadlinesChipsListAdapter headlinesChipsListAdapter = subcategoriesFragment.getHeadlinesChipsListAdapter();
        Intrinsics.checkNotNullExpressionValue(num, "position");
        headlinesChipsListAdapter.setCurrentSelection(num.intValue());
        RecyclerView.LayoutManager layoutManager = ((RecyclerView) subcategoriesFragment._$_findCachedViewById(R.id.headlines_recycler_view)).getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            linearLayoutManager = (LinearLayoutManager) layoutManager;
        } else {
            linearLayoutManager = null;
        }
        if (linearLayoutManager != null) {
            linearLayoutManager.scrollToPosition(num.intValue());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: observeData$lambda-3  reason: not valid java name */
    public static final void m9869observeData$lambda3(SubcategoriesFragment subcategoriesFragment, Result result) {
        int i11;
        Intrinsics.checkNotNullParameter(subcategoriesFragment, "this$0");
        ProgressBar progressBar = (ProgressBar) subcategoriesFragment._$_findCachedViewById(R.id.subcategories_progress);
        Intrinsics.checkNotNullExpressionValue(progressBar, "subcategories_progress");
        if (result instanceof Result.Loading) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        progressBar.setVisibility(i11);
        if (result instanceof Result.Error) {
            ((LoadingFailedView) subcategoriesFragment._$_findCachedViewById(R.id.subcategories_error_view)).show(((Result.Error) result).getError());
        } else {
            ((LoadingFailedView) subcategoriesFragment._$_findCachedViewById(R.id.subcategories_error_view)).hide();
        }
        if (result instanceof Result.Success) {
            SubcategoriesData subcategoriesData = (SubcategoriesData) ((Result.Success) result).getData();
            subcategoriesFragment.onDataReceived(subcategoriesData.getHeadlines(), subcategoriesData.getSubcategoryItems());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: observeData$lambda-4  reason: not valid java name */
    public static final void m9870observeData$lambda4(SubcategoriesFragment subcategoriesFragment, Map map) {
        Intrinsics.checkNotNullParameter(subcategoriesFragment, "this$0");
        ProductsItemsListAdapter subcategoryItemsAdapter = subcategoriesFragment.getSubcategoryItemsAdapter();
        Intrinsics.checkNotNullExpressionValue(map, "it");
        subcategoryItemsAdapter.setCartCountMap(map);
    }

    private final void onDataReceived(List<SubcategoryHeadline> list, List<? extends SubcategoryItem> list2) {
        getHeadlinesChipsListAdapter().submitList(list);
        getSubcategoryItemsAdapter().submitList(list2);
        getViewModel().updateImpressionData(list2);
    }

    /* access modifiers changed from: private */
    public final void onProductClicked(Product product) {
        FragmentKt.findNavController(this).navigate(CategoriesFragmentDirections.Companion.actionToProductFragment$default(CategoriesFragmentDirections.Companion, product, false, (String) null, (String) null, (ProductClickTrackingAttribute) null, (String) null, (String) null, (String) null, 254, (Object) null));
    }

    private final void setupSubcategoriesTitlesRecyclerView() {
        Drawable drawableCompat;
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), 0);
        Context context = getContext();
        if (!(context == null || (drawableCompat = ContextExtensionsKt.getDrawableCompat(context, R.drawable.divider_swimlanes_items)) == null)) {
            dividerItemDecoration.setDrawable(drawableCompat);
        }
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.headlines_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAdapter(getHeadlinesChipsListAdapter());
    }

    private final void setupSwimlanesRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.subcategories_recycler_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(recyclerView.getContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(getSubcategoryItemsAdapter());
        recyclerView.addOnScrollListener(new SubcategoriesFragment$setupSwimlanesRecyclerView$1$1(this, gridLayoutManager));
        getHeadlinesChipsListAdapter().setClickListener(new SubcategoriesFragment$setupSwimlanesRecyclerView$1$2(gridLayoutManager));
        SubcategoriesFragmentViewModel viewModel = getViewModel();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "this");
        viewModel.startImpressionTracking(recyclerView, this);
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
    }

    public void onDestroy() {
        getViewModel().stopImpressionTracking();
        super.onDestroy();
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onResume() {
        super.onResume();
        getViewModel().enableAnalytics();
    }

    public void onRetryClicked() {
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        setupSubcategoriesTitlesRecyclerView();
        setupSwimlanesRecyclerView();
        ((LoadingFailedView) _$_findCachedViewById(R.id.subcategories_error_view)).setOnReloadClicked(new SubcategoriesFragment$onViewCreated$1(this));
        observeData();
    }
}
