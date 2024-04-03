package com.talabat.darkstores.feature.categories.subcategories;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.designsystem.marshmallow.R;
import com.talabat.darkstores.common.OnProductQuantityChangeTrackingListener;
import com.talabat.darkstores.common.lists.adapters.CartCountMapHelper;
import com.talabat.darkstores.data.discovery.model.SortOption;
import com.talabat.darkstores.data.tracking.NewProductQuantityListener;
import com.talabat.darkstores.feature.categories.subcategories.list.ProductTileViewHolder;
import com.talabat.darkstores.feature.tracking.TrackingCategoryId;
import com.talabat.feature.darkstorescart.data.model.Product;
import com.talabat.talabatcommon.extension.ViewKt;
import java.util.List;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yi.b;
import yi.c;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007*\u00012\b\u0000\u0018\u0000 92\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00039:;B\u0001\u0012\u0006\u00106\u001a\u000205\u0012!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00060\u0013\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\u001a\b\u0002\u0010!\u001a\u0014\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060 \u0012\u001c\b\u0002\u0010%\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0004\b7\u00108J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0014J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0003H\u0016R/\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00060\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR&\u0010!\u001a\u0014\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060 8\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R(\u0010%\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010\u0019R\u0014\u0010'\u001a\u00020&8\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(RC\u00101\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\b0)2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\b0)8F@FX\u0002¢\u0006\u0012\n\u0004\b,\u0010(\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0014\u00103\u001a\u0002028\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104¨\u0006<"}, d2 = {"Lcom/talabat/darkstores/feature/categories/subcategories/ProductsItemsListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/talabat/darkstores/feature/categories/subcategories/SubcategoryItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "onAttachedToRecyclerView", "", "position", "e", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "holder", "onBindViewHolder", "getItemViewType", "onViewRecycled", "Lkotlin/Function1;", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "Lkotlin/ParameterName;", "name", "item", "onItemClickListener", "Lkotlin/jvm/functions/Function1;", "Lcom/talabat/darkstores/data/tracking/NewProductQuantityListener;", "newProductQuantityListener", "Lcom/talabat/darkstores/data/tracking/NewProductQuantityListener;", "Lcom/talabat/darkstores/feature/tracking/TrackingCategoryId;", "trackingCategoryId", "Lcom/talabat/darkstores/feature/tracking/TrackingCategoryId;", "Lkotlin/Function2;", "onQuantityChange", "Lkotlin/jvm/functions/Function2;", "", "Lcom/talabat/darkstores/data/discovery/model/SortOption;", "onSortOptionClicked", "Lcom/talabat/darkstores/common/lists/adapters/CartCountMapHelper;", "helper", "Lcom/talabat/darkstores/common/lists/adapters/CartCountMapHelper;", "", "", "<set-?>", "cartCountMap$delegate", "getCartCountMap", "()Ljava/util/Map;", "setCartCountMap", "(Ljava/util/Map;)V", "cartCountMap", "com/talabat/darkstores/feature/categories/subcategories/ProductsItemsListAdapter$quantityChangedListener$1", "quantityChangedListener", "Lcom/talabat/darkstores/feature/categories/subcategories/ProductsItemsListAdapter$quantityChangedListener$1;", "Lcom/talabat/darkstores/common/OnProductQuantityChangeTrackingListener;", "quantityTrackingListener", "<init>", "(Lcom/talabat/darkstores/common/OnProductQuantityChangeTrackingListener;Lkotlin/jvm/functions/Function1;Lcom/talabat/darkstores/data/tracking/NewProductQuantityListener;Lcom/talabat/darkstores/feature/tracking/TrackingCategoryId;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "Companion", "DiffCallback", "HeadlineViewHolder", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0})
public final class ProductsItemsListAdapter extends ListAdapter<SubcategoryItem, RecyclerView.ViewHolder> {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int HEADLINE_SPAN = 2;
    private static final int PRODUCT_SPAN = 1;

    /* renamed from: i  reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f56312i = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(ProductsItemsListAdapter.class, "cartCountMap", "getCartCountMap()Ljava/util/Map;", 0))};
    @NotNull
    private final CartCountMapHelper cartCountMap$delegate;
    @NotNull
    private final CartCountMapHelper helper;
    /* access modifiers changed from: private */
    @Nullable
    public final NewProductQuantityListener newProductQuantityListener;
    @NotNull
    private final Function1<Product, Unit> onItemClickListener;
    /* access modifiers changed from: private */
    @NotNull
    public final Function2<Product, Integer, Unit> onQuantityChange;
    /* access modifiers changed from: private */
    @Nullable
    public final Function1<List<SortOption>, Unit> onSortOptionClicked;
    @NotNull
    private final ProductsItemsListAdapter$quantityChangedListener$1 quantityChangedListener;
    /* access modifiers changed from: private */
    @Nullable
    public final TrackingCategoryId trackingCategoryId;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/darkstores/feature/categories/subcategories/ProductsItemsListAdapter$Companion;", "", "()V", "HEADLINE_SPAN", "", "PRODUCT_SPAN", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/talabat/darkstores/feature/categories/subcategories/ProductsItemsListAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/talabat/darkstores/feature/categories/subcategories/SubcategoryItem;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class DiffCallback extends DiffUtil.ItemCallback<SubcategoryItem> {
        @NotNull
        public static final DiffCallback INSTANCE = new DiffCallback();

        private DiffCallback() {
        }

        public boolean areContentsTheSame(@NotNull SubcategoryItem subcategoryItem, @NotNull SubcategoryItem subcategoryItem2) {
            Intrinsics.checkNotNullParameter(subcategoryItem, "oldItem");
            Intrinsics.checkNotNullParameter(subcategoryItem2, "newItem");
            return Intrinsics.areEqual((Object) subcategoryItem, (Object) subcategoryItem2);
        }

        public boolean areItemsTheSame(@NotNull SubcategoryItem subcategoryItem, @NotNull SubcategoryItem subcategoryItem2) {
            Intrinsics.checkNotNullParameter(subcategoryItem, "oldItem");
            Intrinsics.checkNotNullParameter(subcategoryItem2, "newItem");
            return Intrinsics.areEqual((Object) subcategoryItem.getId(), (Object) subcategoryItem2.getId());
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/talabat/darkstores/feature/categories/subcategories/ProductsItemsListAdapter$HeadlineViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/talabat/darkstores/feature/categories/subcategories/ProductsItemsListAdapter;Landroid/view/View;)V", "bind", "", "item", "Lcom/talabat/darkstores/feature/categories/subcategories/SubcategoryHeadline;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class HeadlineViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ ProductsItemsListAdapter f56313h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public HeadlineViewHolder(@NotNull ProductsItemsListAdapter productsItemsListAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.f56313h = productsItemsListAdapter;
        }

        /* access modifiers changed from: private */
        /* renamed from: bind$lambda-2$lambda-1  reason: not valid java name */
        public static final void m9865bind$lambda2$lambda1(ProductsItemsListAdapter productsItemsListAdapter, SubcategoryHeadline subcategoryHeadline, View view) {
            Intrinsics.checkNotNullParameter(productsItemsListAdapter, "this$0");
            Intrinsics.checkNotNullParameter(subcategoryHeadline, "$item");
            Function1 access$getOnSortOptionClicked$p = productsItemsListAdapter.onSortOptionClicked;
            if (access$getOnSortOptionClicked$p != null) {
                access$getOnSortOptionClicked$p.invoke(subcategoryHeadline.getSortOptions());
            }
        }

        public final void bind(@NotNull SubcategoryHeadline subcategoryHeadline) {
            float f11;
            Intrinsics.checkNotNullParameter(subcategoryHeadline, "item");
            View view = this.itemView;
            ProductsItemsListAdapter productsItemsListAdapter = this.f56313h;
            Intrinsics.checkNotNullExpressionValue(view, "");
            float dimensionPixelSize = (float) view.getResources().getDimensionPixelSize(R.dimen.ds_s);
            Integer marginTop = subcategoryHeadline.getMarginTop();
            if (marginTop != null) {
                f11 = (float) marginTop.intValue();
            } else {
                f11 = 0.0f;
            }
            ViewKt.setMargin$default(view, (Float) null, Float.valueOf(dimensionPixelSize + f11), (Float) null, (Float) null, 13, (Object) null);
            ((TextView) view.findViewById(com.talabat.darkstores.R.id.tvTitle)).setText(subcategoryHeadline.getHeadline());
            if (subcategoryHeadline.getSortOptions().isEmpty()) {
                TextView textView = (TextView) view.findViewById(com.talabat.darkstores.R.id.sort_by);
                Intrinsics.checkNotNullExpressionValue(textView, "sort_by");
                textView.setVisibility(8);
                return;
            }
            int i11 = com.talabat.darkstores.R.id.sort_by;
            TextView textView2 = (TextView) view.findViewById(i11);
            Intrinsics.checkNotNullExpressionValue(textView2, "sort_by");
            textView2.setVisibility(0);
            ((TextView) view.findViewById(i11)).setOnClickListener(new c(productsItemsListAdapter, subcategoryHeadline));
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ProductsItemsListAdapter(OnProductQuantityChangeTrackingListener onProductQuantityChangeTrackingListener, Function1 function1, NewProductQuantityListener newProductQuantityListener2, TrackingCategoryId trackingCategoryId2, Function2 function2, Function1 function12, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(onProductQuantityChangeTrackingListener, function1, newProductQuantityListener2, trackingCategoryId2, (i11 & 16) != 0 ? AnonymousClass1.INSTANCE : function2, (i11 & 32) != 0 ? null : function12);
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-0  reason: not valid java name */
    public static final void m9864onBindViewHolder$lambda0(ProductsItemsListAdapter productsItemsListAdapter, SubcategoryItem subcategoryItem, View view) {
        Intrinsics.checkNotNullParameter(productsItemsListAdapter, "this$0");
        Intrinsics.checkNotNullParameter(subcategoryItem, "$item");
        productsItemsListAdapter.onItemClickListener.invoke(((SubcategoryProduct) subcategoryItem).getProduct());
    }

    @NotNull
    /* renamed from: e */
    public SubcategoryItem getItem(int i11) {
        int i12;
        SubcategoryItem subcategoryItem = (SubcategoryItem) super.getItem(i11);
        if (subcategoryItem instanceof SubcategoryProduct) {
            SubcategoryProduct subcategoryProduct = (SubcategoryProduct) subcategoryItem;
            this.helper.getPositionMap().put(subcategoryProduct.getProduct().getId(), Integer.valueOf(i11));
            Product product = subcategoryProduct.getProduct();
            Integer num = getCartCountMap().get(subcategoryProduct.getProduct().getId());
            if (num != null) {
                i12 = num.intValue();
            } else {
                i12 = 0;
            }
            product.setCartCount(i12);
        }
        Intrinsics.checkNotNullExpressionValue(subcategoryItem, "item");
        return subcategoryItem;
    }

    @NotNull
    public final Map<String, Integer> getCartCountMap() {
        return this.cartCountMap$delegate.getValue(this, f56312i[0]);
    }

    public int getItemViewType(int i11) {
        SubcategoryItem e11 = getItem(i11);
        if (e11 instanceof SubcategoryHeadline) {
            return com.talabat.darkstores.R.layout.darkstores_subcategory_header;
        }
        if (e11 instanceof SubcategoryProduct) {
            return com.talabat.darkstores.R.layout.darkstores_product_tile_new;
        }
        throw new NoWhenBranchMatchedException();
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
            gridLayoutManager.setSpanSizeLookup(new ProductsItemsListAdapter$onAttachedToRecyclerView$1(this));
        }
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i11) {
        ProductTileViewHolder productTileViewHolder;
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        SubcategoryItem e11 = getItem(i11);
        HeadlineViewHolder headlineViewHolder = null;
        if (e11 instanceof SubcategoryHeadline) {
            if (viewHolder instanceof HeadlineViewHolder) {
                headlineViewHolder = (HeadlineViewHolder) viewHolder;
            }
            if (headlineViewHolder != null) {
                headlineViewHolder.bind((SubcategoryHeadline) e11);
            }
        } else if (e11 instanceof SubcategoryProduct) {
            if (viewHolder instanceof ProductTileViewHolder) {
                productTileViewHolder = (ProductTileViewHolder) viewHolder;
            } else {
                productTileViewHolder = null;
            }
            if (productTileViewHolder != null) {
                ProductTileViewHolder.bind$default(productTileViewHolder, ((SubcategoryProduct) e11).getProduct(), false, 2, (Object) null);
            }
            viewHolder.itemView.setOnClickListener(new b(this, e11));
        }
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        boolean z11;
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = ViewKt.inflate(viewGroup, i11);
        if (i11 == com.talabat.darkstores.R.layout.darkstores_subcategory_header) {
            return new HeadlineViewHolder(this, inflate);
        }
        if (i11 == com.talabat.darkstores.R.layout.darkstores_product_tile_new) {
            ProductsItemsListAdapter$quantityChangedListener$1 productsItemsListAdapter$quantityChangedListener$1 = this.quantityChangedListener;
            if (viewGroup.getLayoutDirection() == 1) {
                z11 = true;
            } else {
                z11 = false;
            }
            return new ProductTileViewHolder(inflate, productsItemsListAdapter$quantityChangedListener$1, z11, this.newProductQuantityListener, false, 16, (DefaultConstructorMarker) null);
        }
        throw new IllegalArgumentException("This view type is not supported.");
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
        this.cartCountMap$delegate.setValue(this, f56312i[0], map);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProductsItemsListAdapter(@NotNull OnProductQuantityChangeTrackingListener onProductQuantityChangeTrackingListener, @NotNull Function1<? super Product, Unit> function1, @Nullable NewProductQuantityListener newProductQuantityListener2, @Nullable TrackingCategoryId trackingCategoryId2, @NotNull Function2<? super Product, ? super Integer, Unit> function2, @Nullable Function1<? super List<SortOption>, Unit> function12) {
        super(DiffCallback.INSTANCE);
        Intrinsics.checkNotNullParameter(onProductQuantityChangeTrackingListener, "quantityTrackingListener");
        Intrinsics.checkNotNullParameter(function1, "onItemClickListener");
        Intrinsics.checkNotNullParameter(function2, "onQuantityChange");
        this.onItemClickListener = function1;
        this.newProductQuantityListener = newProductQuantityListener2;
        this.trackingCategoryId = trackingCategoryId2;
        this.onQuantityChange = function2;
        this.onSortOptionClicked = function12;
        CartCountMapHelper cartCountMapHelper = new CartCountMapHelper(this);
        this.helper = cartCountMapHelper;
        this.cartCountMap$delegate = cartCountMapHelper;
        this.quantityChangedListener = new ProductsItemsListAdapter$quantityChangedListener$1(onProductQuantityChangeTrackingListener, this);
    }
}
