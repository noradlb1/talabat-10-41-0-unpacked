package com.talabat.darkstores.feature.search;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.OnProductQuantityChangeTrackingListener;
import com.talabat.darkstores.common.lists.adapters.CartCountMapHelper;
import com.talabat.darkstores.common.view.ProductItemView;
import com.talabat.darkstores.common.view.ProductView;
import com.talabat.darkstores.data.tracking.NewProductQuantityListener;
import com.talabat.darkstores.model.CategorySuggestion;
import com.talabat.darkstores.model.ProductSuggestion;
import com.talabat.darkstores.model.SearchSuggestion;
import com.talabat.feature.darkstorescart.data.model.Product;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.android.extensions.LayoutContainer;
import mj.w;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001(\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002/0B\u0017\u0012\u0006\u0010,\u001a\u00020+\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b-\u0010.J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0016J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014RC\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00040\u00152\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00040\u00158F@FX\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cRT\u0010\"\u001a4\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\r\u0018\u00010\u001e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0014\u0010)\u001a\u00020(8\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*¨\u00061"}, d2 = {"Lcom/talabat/darkstores/feature/search/SearchSuggestionsAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/talabat/darkstores/model/SearchSuggestion;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "position", "getItemViewType", "e", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "holder", "", "onBindViewHolder", "Lcom/talabat/darkstores/data/tracking/NewProductQuantityListener;", "newQuantityListener", "Lcom/talabat/darkstores/data/tracking/NewProductQuantityListener;", "Lcom/talabat/darkstores/common/lists/adapters/CartCountMapHelper;", "helper", "Lcom/talabat/darkstores/common/lists/adapters/CartCountMapHelper;", "", "", "<set-?>", "cartCountMap$delegate", "getCartCountMap", "()Ljava/util/Map;", "setCartCountMap", "(Ljava/util/Map;)V", "cartCountMap", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "item", "onItemClickListener", "Lkotlin/jvm/functions/Function2;", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "com/talabat/darkstores/feature/search/SearchSuggestionsAdapter$quantityChangedListener$1", "quantityChangedListener", "Lcom/talabat/darkstores/feature/search/SearchSuggestionsAdapter$quantityChangedListener$1;", "Lcom/talabat/darkstores/common/OnProductQuantityChangeTrackingListener;", "listener", "<init>", "(Lcom/talabat/darkstores/common/OnProductQuantityChangeTrackingListener;Lcom/talabat/darkstores/data/tracking/NewProductQuantityListener;)V", "CategorySuggestionViewHolder", "ProductSuggestionViewHolder", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0})
public final class SearchSuggestionsAdapter extends ListAdapter<SearchSuggestion, RecyclerView.ViewHolder> {

    /* renamed from: i  reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f56582i = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(SearchSuggestionsAdapter.class, "cartCountMap", "getCartCountMap()Ljava/util/Map;", 0))};
    @NotNull
    private final CartCountMapHelper cartCountMap$delegate;
    @NotNull
    private final CartCountMapHelper helper;
    /* access modifiers changed from: private */
    @NotNull
    public final NewProductQuantityListener newQuantityListener;
    @Nullable
    private Function2<? super SearchSuggestion, ? super Integer, Unit> onItemClickListener;
    /* access modifiers changed from: private */
    @NotNull
    public final SearchSuggestionsAdapter$quantityChangedListener$1 quantityChangedListener;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/talabat/darkstores/feature/search/SearchSuggestionsAdapter$CategorySuggestionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lkotlinx/android/extensions/LayoutContainer;", "containerView", "Landroid/view/View;", "(Landroid/view/View;)V", "getContainerView", "()Landroid/view/View;", "bind", "", "suggestion", "Lcom/talabat/darkstores/model/CategorySuggestion;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CategorySuggestionViewHolder extends RecyclerView.ViewHolder implements LayoutContainer {
        @NotNull
        private final View containerView;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CategorySuggestionViewHolder(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "containerView");
            this.containerView = view;
        }

        public final void bind(@NotNull CategorySuggestion categorySuggestion) {
            Intrinsics.checkNotNullParameter(categorySuggestion, "suggestion");
            View containerView2 = getContainerView();
            ((TextView) containerView2.findViewById(R.id.tvQuery)).setText(categorySuggestion.getOriginalSearchQuery());
            ((TextView) containerView2.findViewById(R.id.tvCategory)).setText(getContainerView().getContext().getString(com.talabat.localization.R.string.category_suggestion, new Object[]{categorySuggestion.getCategory().getName()}));
        }

        @NotNull
        public View getContainerView() {
            return this.containerView;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/talabat/darkstores/feature/search/SearchSuggestionsAdapter$ProductSuggestionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lkotlinx/android/extensions/LayoutContainer;", "containerView", "Landroid/view/View;", "(Lcom/talabat/darkstores/feature/search/SearchSuggestionsAdapter;Landroid/view/View;)V", "getContainerView", "()Landroid/view/View;", "bind", "", "suggestion", "Lcom/talabat/darkstores/model/ProductSuggestion;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class ProductSuggestionViewHolder extends RecyclerView.ViewHolder implements LayoutContainer {
        @NotNull
        private final View containerView;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ SearchSuggestionsAdapter f56583h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ProductSuggestionViewHolder(@NotNull SearchSuggestionsAdapter searchSuggestionsAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "containerView");
            this.f56583h = searchSuggestionsAdapter;
            this.containerView = view;
        }

        public final void bind(@NotNull ProductSuggestion productSuggestion) {
            Intrinsics.checkNotNullParameter(productSuggestion, "suggestion");
            View containerView2 = getContainerView();
            SearchSuggestionsAdapter searchSuggestionsAdapter = this.f56583h;
            int i11 = R.id.productItemView;
            ProductItemView productItemView = (ProductItemView) containerView2.findViewById(i11);
            Intrinsics.checkNotNullExpressionValue(productItemView, "productItemView");
            ProductView.DefaultImpls.setProduct$default(productItemView, productSuggestion.getProduct(), false, Integer.valueOf(getBindingAdapterPosition()), 2, (Object) null);
            ((ProductItemView) containerView2.findViewById(i11)).setProductQuantityChangeListener(searchSuggestionsAdapter.quantityChangedListener);
            ((ProductItemView) containerView2.findViewById(i11)).setNewQuantityListener(searchSuggestionsAdapter.newQuantityListener);
        }

        @NotNull
        public View getContainerView() {
            return this.containerView;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchSuggestionsAdapter(@NotNull OnProductQuantityChangeTrackingListener onProductQuantityChangeTrackingListener, @NotNull NewProductQuantityListener newProductQuantityListener) {
        super(new SearchSuggestionDiffCallback());
        Intrinsics.checkNotNullParameter(onProductQuantityChangeTrackingListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(newProductQuantityListener, "newQuantityListener");
        this.newQuantityListener = newProductQuantityListener;
        CartCountMapHelper cartCountMapHelper = new CartCountMapHelper(this);
        this.helper = cartCountMapHelper;
        this.cartCountMap$delegate = cartCountMapHelper;
        this.quantityChangedListener = new SearchSuggestionsAdapter$quantityChangedListener$1(onProductQuantityChangeTrackingListener);
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-2$lambda-1  reason: not valid java name */
    public static final void m10077onBindViewHolder$lambda2$lambda1(SearchSuggestionsAdapter searchSuggestionsAdapter, SearchSuggestion searchSuggestion, int i11, View view) {
        Intrinsics.checkNotNullParameter(searchSuggestionsAdapter, "this$0");
        Intrinsics.checkNotNullParameter(searchSuggestion, "$item");
        Function2<? super SearchSuggestion, ? super Integer, Unit> function2 = searchSuggestionsAdapter.onItemClickListener;
        if (function2 != null) {
            function2.invoke(searchSuggestion, Integer.valueOf(i11));
        }
    }

    @Nullable
    /* renamed from: e */
    public SearchSuggestion getItem(int i11) {
        int i12;
        try {
            SearchSuggestion searchSuggestion = (SearchSuggestion) super.getItem(i11);
            if (searchSuggestion instanceof ProductSuggestion) {
                this.helper.getPositionMap().put(((ProductSuggestion) searchSuggestion).getProduct().getId(), Integer.valueOf(i11));
                Product product = ((ProductSuggestion) searchSuggestion).getProduct();
                Integer num = getCartCountMap().get(product.getId());
                if (num != null) {
                    i12 = num.intValue();
                } else {
                    i12 = 0;
                }
                product.setCartCount(i12);
            }
            return searchSuggestion;
        } catch (NoSuchElementException unused) {
            return null;
        }
    }

    @NotNull
    public final Map<String, Integer> getCartCountMap() {
        return this.cartCountMap$delegate.getValue(this, f56582i[0]);
    }

    public int getItemViewType(int i11) {
        SearchSuggestion e11 = getItem(i11);
        if (e11 instanceof ProductSuggestion) {
            return R.layout.darkstores_item_search_suggestion_product;
        }
        if (e11 instanceof CategorySuggestion) {
            return R.layout.darkstores_item_search_suggestion_category;
        }
        return R.layout.darkstores_item_search_suggestion_empty;
    }

    @Nullable
    public final Function2<SearchSuggestion, Integer, Unit> getOnItemClickListener() {
        return this.onItemClickListener;
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i11) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        SearchSuggestion e11 = getItem(i11);
        if (e11 != null) {
            if (e11 instanceof ProductSuggestion) {
                ((ProductSuggestionViewHolder) viewHolder).bind((ProductSuggestion) e11);
            } else if (e11 instanceof CategorySuggestion) {
                ((CategorySuggestionViewHolder) viewHolder).bind((CategorySuggestion) e11);
            }
            viewHolder.itemView.setOnClickListener(new w(this, e11, i11));
        }
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i11, viewGroup, false);
        if (i11 == R.layout.darkstores_item_search_suggestion_product) {
            Intrinsics.checkNotNullExpressionValue(inflate, "view");
            return new ProductSuggestionViewHolder(this, inflate);
        } else if (i11 == R.layout.darkstores_item_search_suggestion_category) {
            Intrinsics.checkNotNullExpressionValue(inflate, "view");
            return new CategorySuggestionViewHolder(inflate);
        } else {
            throw new IllegalStateException(("Unsupported ViewType: " + i11).toString());
        }
    }

    public final void setCartCountMap(@NotNull Map<String, Integer> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.cartCountMap$delegate.setValue(this, f56582i[0], map);
    }

    public final void setOnItemClickListener(@Nullable Function2<? super SearchSuggestion, ? super Integer, Unit> function2) {
        this.onItemClickListener = function2;
    }
}
