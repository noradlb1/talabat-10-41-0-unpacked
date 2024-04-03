package com.talabat.darkstores.feature.searchResults;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.CombinedLoadStates;
import androidx.paging.LoadState;
import androidx.paging.PagingDataAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.OnProductQuantityChangeTrackingListener;
import com.talabat.darkstores.common.lists.adapters.CartCountMapHelper;
import com.talabat.darkstores.data.tracking.NewProductQuantityListener;
import com.talabat.darkstores.feature.categories.subcategories.list.ProductTileViewHolder;
import com.talabat.darkstores.feature.searchResults.paging.SearchPagingItem;
import com.talabat.feature.darkstorescart.data.model.Product;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u00010\b\u0000\u0018\u0000 B2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002BCB9\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\u0010\u00103\u001a\u00020\t2\b\u00104\u001a\u0004\u0018\u00010\bJ\u0010\u00105\u001a\u00020\u00122\u0006\u00106\u001a\u00020\u0012H\u0016J\u0010\u00107\u001a\u00020\t2\u0006\u00108\u001a\u000209H\u0016J\u0018\u0010:\u001a\u00020\t2\u0006\u0010;\u001a\u00020\u00032\u0006\u00106\u001a\u00020\u0012H\u0016J\u0018\u0010<\u001a\u00020\u00032\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0012H\u0016J\u0010\u0010@\u001a\u00020\t2\u0006\u0010;\u001a\u00020\u0003H\u0016J\u0014\u0010A\u001a\u00020)*\u00020)2\u0006\u00106\u001a\u00020\u0012H\u0002R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0004¢\u0006\u0002\n\u0000RC\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00120\u00142\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00120\u00148F@FX\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R \u0010\u0006\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010 \"\u0004\b!\u0010\"R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00120$¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0004¢\u0006\u0002\n\u0000R4\u0010'\u001a\u001c\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\t\u0018\u00010(j\u0004\u0018\u0001`*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0010\u0010/\u001a\u000200X\u0004¢\u0006\u0004\n\u0002\u00101R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/talabat/darkstores/feature/searchResults/SearchResultsProductsListAdapter;", "Landroidx/paging/PagingDataAdapter;", "Lcom/talabat/darkstores/feature/searchResults/paging/SearchPagingItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "listener", "Lcom/talabat/darkstores/common/OnProductQuantityChangeTrackingListener;", "categoryClickListener", "Lkotlin/Function1;", "", "", "Lcom/talabat/darkstores/feature/searchResults/CategoryClickListener;", "resultsType", "Lcom/talabat/darkstores/feature/searchResults/SearchResultsType;", "newQuantityListener", "Lcom/talabat/darkstores/data/tracking/NewProductQuantityListener;", "(Lcom/talabat/darkstores/common/OnProductQuantityChangeTrackingListener;Lkotlin/jvm/functions/Function1;Lcom/talabat/darkstores/feature/searchResults/SearchResultsType;Lcom/talabat/darkstores/data/tracking/NewProductQuantityListener;)V", "_labelUpdateWithItemsCount", "Landroidx/lifecycle/MutableLiveData;", "", "<set-?>", "", "cartCountMap", "getCartCountMap", "()Ljava/util/Map;", "setCartCountMap", "(Ljava/util/Map;)V", "cartCountMap$delegate", "Lcom/talabat/darkstores/common/lists/adapters/CartCountMapHelper;", "helper", "Lcom/talabat/darkstores/common/lists/adapters/CartCountMapHelper;", "isLoading", "", "()Z", "setLoading", "(Z)V", "labelUpdateWithItemsCount", "Landroidx/lifecycle/LiveData;", "getLabelUpdateWithItemsCount", "()Landroidx/lifecycle/LiveData;", "onItemClickListener", "Lkotlin/Function2;", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "Lcom/talabat/darkstores/feature/searchResults/ProductClickListener;", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "quantityChangedListener", "com/talabat/darkstores/feature/searchResults/SearchResultsProductsListAdapter$quantityChangedListener$1", "Lcom/talabat/darkstores/feature/searchResults/SearchResultsProductsListAdapter$quantityChangedListener$1;", "selectedCategoryId", "changeCategorySelection", "selectedId", "getItemViewType", "position", "onAttachedToRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewRecycled", "prepareForDisplay", "Companion", "SearchPagingItemDiffCallback", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SearchResultsProductsListAdapter extends PagingDataAdapter<SearchPagingItem, RecyclerView.ViewHolder> {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    public static final int HEADER_SPAN = 2;
    @Deprecated
    public static final int PRODUCT_SPAN = 1;

    /* renamed from: i  reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f56617i = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(SearchResultsProductsListAdapter.class, "cartCountMap", "getCartCountMap()Ljava/util/Map;", 0))};
    @NotNull
    private final MutableLiveData<Integer> _labelUpdateWithItemsCount;
    @NotNull
    private final CartCountMapHelper cartCountMap$delegate;
    @NotNull
    private final Function1<String, Unit> categoryClickListener;
    @NotNull
    private final CartCountMapHelper helper;
    private boolean isLoading;
    @NotNull
    private final LiveData<Integer> labelUpdateWithItemsCount;
    /* access modifiers changed from: private */
    @Nullable
    public final NewProductQuantityListener newQuantityListener;
    @Nullable
    private Function2<? super Product, ? super Integer, Unit> onItemClickListener;
    @NotNull
    private final SearchResultsProductsListAdapter$quantityChangedListener$1 quantityChangedListener;
    /* access modifiers changed from: private */
    @NotNull
    public final SearchResultsType resultsType;
    @Nullable
    private String selectedCategoryId;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/darkstores/feature/searchResults/SearchResultsProductsListAdapter$Companion;", "", "()V", "HEADER_SPAN", "", "PRODUCT_SPAN", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/talabat/darkstores/feature/searchResults/SearchResultsProductsListAdapter$SearchPagingItemDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/talabat/darkstores/feature/searchResults/paging/SearchPagingItem;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SearchPagingItemDiffCallback extends DiffUtil.ItemCallback<SearchPagingItem> {
        @NotNull
        public static final SearchPagingItemDiffCallback INSTANCE = new SearchPagingItemDiffCallback();

        private SearchPagingItemDiffCallback() {
        }

        public boolean areContentsTheSame(@NotNull SearchPagingItem searchPagingItem, @NotNull SearchPagingItem searchPagingItem2) {
            Intrinsics.checkNotNullParameter(searchPagingItem, "oldItem");
            Intrinsics.checkNotNullParameter(searchPagingItem2, "newItem");
            return Intrinsics.areEqual((Object) searchPagingItem, (Object) searchPagingItem2);
        }

        public boolean areItemsTheSame(@NotNull SearchPagingItem searchPagingItem, @NotNull SearchPagingItem searchPagingItem2) {
            Intrinsics.checkNotNullParameter(searchPagingItem, "oldItem");
            Intrinsics.checkNotNullParameter(searchPagingItem2, "newItem");
            return (searchPagingItem2 instanceof SearchPagingItem.Categories) && (searchPagingItem instanceof SearchPagingItem.Categories) && Intrinsics.areEqual((Object) ((SearchPagingItem.Categories) searchPagingItem2).getCategories(), (Object) ((SearchPagingItem.Categories) searchPagingItem).getCategories());
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchResultsProductsListAdapter(@NotNull OnProductQuantityChangeTrackingListener onProductQuantityChangeTrackingListener, @NotNull Function1<? super String, Unit> function1, @NotNull SearchResultsType searchResultsType, @Nullable NewProductQuantityListener newProductQuantityListener) {
        super(SearchPagingItemDiffCallback.INSTANCE, (CoroutineDispatcher) null, (CoroutineDispatcher) null, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(onProductQuantityChangeTrackingListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(function1, "categoryClickListener");
        Intrinsics.checkNotNullParameter(searchResultsType, "resultsType");
        this.categoryClickListener = function1;
        this.resultsType = searchResultsType;
        this.newQuantityListener = newProductQuantityListener;
        MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>();
        this._labelUpdateWithItemsCount = mutableLiveData;
        this.labelUpdateWithItemsCount = mutableLiveData;
        addLoadStateListener(new Function1<CombinedLoadStates, Unit>(this) {

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ SearchResultsProductsListAdapter f56618g;

            {
                this.f56618g = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((CombinedLoadStates) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull CombinedLoadStates combinedLoadStates) {
                Intrinsics.checkNotNullParameter(combinedLoadStates, "it");
                this.f56618g.setLoading(combinedLoadStates.getRefresh() instanceof LoadState.Loading);
                if (this.f56618g.isLoading()) {
                    SearchResultsProductsListAdapter searchResultsProductsListAdapter = this.f56618g;
                    searchResultsProductsListAdapter.notifyItemRangeChanged(1, searchResultsProductsListAdapter.getItemCount());
                }
            }
        });
        CartCountMapHelper cartCountMapHelper = new CartCountMapHelper(this);
        this.helper = cartCountMapHelper;
        this.quantityChangedListener = new SearchResultsProductsListAdapter$quantityChangedListener$1(this, onProductQuantityChangeTrackingListener);
        this.cartCountMap$delegate = cartCountMapHelper;
    }

    public static final /* synthetic */ SearchPagingItem access$getItem(SearchResultsProductsListAdapter searchResultsProductsListAdapter, int i11) {
        return (SearchPagingItem) searchResultsProductsListAdapter.getItem(i11);
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-0  reason: not valid java name */
    public static final void m10084onBindViewHolder$lambda0(SearchResultsProductsListAdapter searchResultsProductsListAdapter, SearchPagingItem searchPagingItem, int i11, View view) {
        Intrinsics.checkNotNullParameter(searchResultsProductsListAdapter, "this$0");
        Function2<? super Product, ? super Integer, Unit> function2 = searchResultsProductsListAdapter.onItemClickListener;
        if (function2 != null) {
            function2.invoke(((SearchPagingItem.Product) searchPagingItem).getProduct(), Integer.valueOf(i11));
        }
    }

    private final Product prepareForDisplay(Product product, int i11) {
        int i12;
        Integer num = getCartCountMap().get(product.getId());
        if (num != null) {
            i12 = num.intValue();
        } else {
            i12 = 0;
        }
        product.setCartCount(i12);
        this.helper.getPositionMap().put(product.getId(), Integer.valueOf(i11));
        return product;
    }

    public final void changeCategorySelection(@Nullable String str) {
        this.selectedCategoryId = str;
        notifyItemChanged(0, str);
    }

    @NotNull
    public final Map<String, Integer> getCartCountMap() {
        return this.cartCountMap$delegate.getValue(this, f56617i[0]);
    }

    public int getItemViewType(int i11) {
        SearchPagingItem searchPagingItem = (SearchPagingItem) getItem(i11);
        if (searchPagingItem instanceof SearchPagingItem.Categories) {
            return R.layout.darkstores_item_search_categories;
        }
        if (searchPagingItem instanceof SearchPagingItem.Product) {
            return R.layout.darkstores_product_tile_new;
        }
        if (searchPagingItem instanceof SearchPagingItem.TotalCount) {
            return R.layout.darkstores_item_seach_label;
        }
        if (searchPagingItem == null) {
            return R.layout.darkstores_product_tile_new_placeholder;
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public final LiveData<Integer> getLabelUpdateWithItemsCount() {
        return this.labelUpdateWithItemsCount;
    }

    @Nullable
    public final Function2<Product, Integer, Unit> getOnItemClickListener() {
        return this.onItemClickListener;
    }

    public final boolean isLoading() {
        return this.isLoading;
    }

    public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView) {
        GridLayoutManager gridLayoutManager;
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            gridLayoutManager = (GridLayoutManager) layoutManager;
        } else {
            gridLayoutManager = null;
        }
        if (gridLayoutManager != null) {
            gridLayoutManager.setSpanSizeLookup(new SearchResultsProductsListAdapter$onAttachedToRecyclerView$1(this));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: com.talabat.darkstores.feature.searchResults.SearchCategoriesViewHolder} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1, types: [kotlinx.android.extensions.LayoutContainer] */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull androidx.recyclerview.widget.RecyclerView.ViewHolder r6, int r7) {
        /*
            r5 = this;
            java.lang.String r0 = "holder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.Object r0 = r5.getItem(r7)
            com.talabat.darkstores.feature.searchResults.paging.SearchPagingItem r0 = (com.talabat.darkstores.feature.searchResults.paging.SearchPagingItem) r0
            boolean r1 = r0 instanceof com.talabat.darkstores.feature.searchResults.paging.SearchPagingItem.Categories
            r2 = 0
            if (r1 == 0) goto L_0x0025
            boolean r7 = r6 instanceof com.talabat.darkstores.feature.searchResults.SearchCategoriesViewHolder
            if (r7 == 0) goto L_0x0017
            r2 = r6
            com.talabat.darkstores.feature.searchResults.SearchCategoriesViewHolder r2 = (com.talabat.darkstores.feature.searchResults.SearchCategoriesViewHolder) r2
        L_0x0017:
            if (r2 == 0) goto L_0x006f
            com.talabat.darkstores.feature.searchResults.paging.SearchPagingItem$Categories r0 = (com.talabat.darkstores.feature.searchResults.paging.SearchPagingItem.Categories) r0
            java.util.List r6 = r0.getCategories()
            java.lang.String r7 = r5.selectedCategoryId
            r2.bind(r6, r7)
            goto L_0x006f
        L_0x0025:
            boolean r1 = r0 instanceof com.talabat.darkstores.feature.searchResults.paging.SearchPagingItem.Product
            if (r1 == 0) goto L_0x005c
            r1 = r0
            com.talabat.darkstores.feature.searchResults.paging.SearchPagingItem$Product r1 = (com.talabat.darkstores.feature.searchResults.paging.SearchPagingItem.Product) r1
            com.talabat.feature.darkstorescart.data.model.Product r1 = r1.getProduct()
            com.talabat.feature.darkstorescart.data.model.Product r1 = r5.prepareForDisplay(r1, r7)
            boolean r3 = r6 instanceof com.talabat.darkstores.feature.categories.subcategories.list.ProductTileViewHolder
            if (r3 == 0) goto L_0x003c
            r3 = r6
            com.talabat.darkstores.feature.categories.subcategories.list.ProductTileViewHolder r3 = (com.talabat.darkstores.feature.categories.subcategories.list.ProductTileViewHolder) r3
            goto L_0x003d
        L_0x003c:
            r3 = r2
        L_0x003d:
            if (r3 == 0) goto L_0x0044
            boolean r4 = r5.isLoading
            r3.bind(r1, r4)
        L_0x0044:
            boolean r1 = r6 instanceof kotlinx.android.extensions.LayoutContainer
            if (r1 == 0) goto L_0x004b
            r2 = r6
            kotlinx.android.extensions.LayoutContainer r2 = (kotlinx.android.extensions.LayoutContainer) r2
        L_0x004b:
            if (r2 == 0) goto L_0x006f
            android.view.View r6 = r2.getContainerView()
            if (r6 == 0) goto L_0x006f
            oj.f r1 = new oj.f
            r1.<init>(r5, r0, r7)
            r6.setOnClickListener(r1)
            goto L_0x006f
        L_0x005c:
            boolean r6 = r0 instanceof com.talabat.darkstores.feature.searchResults.paging.SearchPagingItem.TotalCount
            if (r6 == 0) goto L_0x006f
            androidx.lifecycle.MutableLiveData<java.lang.Integer> r6 = r5._labelUpdateWithItemsCount
            com.talabat.darkstores.feature.searchResults.paging.SearchPagingItem$TotalCount r0 = (com.talabat.darkstores.feature.searchResults.paging.SearchPagingItem.TotalCount) r0
            int r7 = r0.getTotalCount()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r6.setValue(r7)
        L_0x006f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.feature.searchResults.SearchResultsProductsListAdapter.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        boolean z11;
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i11, viewGroup, false);
        if (i11 == R.layout.darkstores_product_tile_new) {
            Intrinsics.checkNotNullExpressionValue(inflate, "view");
            SearchResultsProductsListAdapter$quantityChangedListener$1 searchResultsProductsListAdapter$quantityChangedListener$1 = this.quantityChangedListener;
            if (viewGroup.getLayoutDirection() == 1) {
                z11 = true;
            } else {
                z11 = false;
            }
            return new ProductTileViewHolder(inflate, searchResultsProductsListAdapter$quantityChangedListener$1, z11, this.newQuantityListener, false, 16, (DefaultConstructorMarker) null);
        } else if (i11 != R.layout.darkstores_item_search_categories) {
            return new SearchResultsProductsListAdapter$onCreateViewHolder$1(inflate);
        } else {
            Intrinsics.checkNotNullExpressionValue(inflate, "view");
            return new SearchCategoriesViewHolder(inflate, this.categoryClickListener);
        }
    }

    public void onViewRecycled(@NotNull RecyclerView.ViewHolder viewHolder) {
        ProductTileViewHolder productTileViewHolder;
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof ProductTileViewHolder) {
            productTileViewHolder = (ProductTileViewHolder) viewHolder;
        } else {
            productTileViewHolder = null;
        }
        if (productTileViewHolder != null) {
            productTileViewHolder.clear();
        }
    }

    public final void setCartCountMap(@NotNull Map<String, Integer> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.cartCountMap$delegate.setValue(this, f56617i[0], map);
    }

    public final void setLoading(boolean z11) {
        this.isLoading = z11;
    }

    public final void setOnItemClickListener(@Nullable Function2<? super Product, ? super Integer, Unit> function2) {
        this.onItemClickListener = function2;
    }
}
