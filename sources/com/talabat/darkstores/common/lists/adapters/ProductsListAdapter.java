package com.talabat.darkstores.common.lists.adapters;

import ai.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.OnProductQuantityChangeTrackingListener;
import com.talabat.darkstores.common.SwimlaneTrackingData;
import com.talabat.darkstores.common.lists.ProductDiffCallback;
import com.talabat.darkstores.data.tracking.NewProductQuantityListener;
import com.talabat.darkstores.feature.categories.subcategories.list.ProductTileViewHolder;
import com.talabat.darkstores.feature.tracking.TrackingCategoryId;
import com.talabat.feature.darkstorescart.data.model.Product;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001/\b\u0010\u0018\u0000 62\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00016B\u0019\u0012\u0006\u00103\u001a\u000202\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b4\u00105J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\u000e\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010J!\u0010\u0016\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0004J\u001a\u0010\u001c\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u0013R\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fRT\u0010$\u001a4\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010 8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010*R\u0018\u0010,\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010.R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010.R\u0014\u00100\u001a\u00020/8\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101¨\u00067"}, d2 = {"Lcom/talabat/darkstores/common/lists/adapters/ProductsListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "position", "getItemViewType", "holder", "", "onBindViewHolder", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "onViewRecycled", "e", "Lcom/talabat/darkstores/feature/tracking/TrackingCategoryId;", "trackingCategoryId", "setTrackingCategoryId", "", "swimlaneTitle", "swimlaneLength", "setSwimlaneTrackingData", "(Ljava/lang/String;Ljava/lang/Integer;)V", "setSwimlaneTitle", "setSwimlaneLength", "swimlaneRequestId", "swimlaneStrategy", "setSwimlaneTrackingInfo", "", "useDesignSystemStepper", "Z", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "item", "onItemClickListener", "Lkotlin/jvm/functions/Function2;", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "Lcom/talabat/darkstores/feature/tracking/TrackingCategoryId;", "Lcom/talabat/darkstores/common/SwimlaneTrackingData;", "swimlaneTrackingData", "Lcom/talabat/darkstores/common/SwimlaneTrackingData;", "Ljava/lang/String;", "com/talabat/darkstores/common/lists/adapters/ProductsListAdapter$quantityChangedListener$1", "quantityChangedListener", "Lcom/talabat/darkstores/common/lists/adapters/ProductsListAdapter$quantityChangedListener$1;", "Lcom/talabat/darkstores/common/OnProductQuantityChangeTrackingListener;", "listener", "<init>", "(Lcom/talabat/darkstores/common/OnProductQuantityChangeTrackingListener;Z)V", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0})
public class ProductsListAdapter extends ListAdapter<Product, RecyclerView.ViewHolder> {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final double WIDTH_RATIO = 0.44d;
    @Nullable
    private Function2<? super Product, ? super Integer, Unit> onItemClickListener;
    @NotNull
    private final ProductsListAdapter$quantityChangedListener$1 quantityChangedListener;
    /* access modifiers changed from: private */
    @Nullable
    public String swimlaneRequestId;
    /* access modifiers changed from: private */
    @Nullable
    public String swimlaneStrategy;
    /* access modifiers changed from: private */
    @Nullable
    public SwimlaneTrackingData swimlaneTrackingData;
    /* access modifiers changed from: private */
    @Nullable
    public TrackingCategoryId trackingCategoryId;
    private final boolean useDesignSystemStepper;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/darkstores/common/lists/adapters/ProductsListAdapter$Companion;", "", "()V", "WIDTH_RATIO", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ProductsListAdapter(OnProductQuantityChangeTrackingListener onProductQuantityChangeTrackingListener, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(onProductQuantityChangeTrackingListener, (i11 & 2) != 0 ? false : z11);
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-0  reason: not valid java name */
    public static final void m9635onBindViewHolder$lambda0(ProductsListAdapter productsListAdapter, int i11, View view) {
        Intrinsics.checkNotNullParameter(productsListAdapter, "this$0");
        productsListAdapter.e(i11);
    }

    public void e(int i11) {
        Function2<? super Product, ? super Integer, Unit> function2 = this.onItemClickListener;
        if (function2 != null) {
            Object item = getItem(i11);
            Intrinsics.checkNotNullExpressionValue(item, "getItem(position)");
            function2.invoke(item, Integer.valueOf(i11));
        }
    }

    public int getItemViewType(int i11) {
        return R.layout.darkstores_product_tile_new;
    }

    @Nullable
    public final Function2<Product, Integer, Unit> getOnItemClickListener() {
        return this.onItemClickListener;
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i11) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Product product = (Product) getItem(i11);
        if (viewHolder instanceof ProductTileViewHolder) {
            ProductTileViewHolder.bind$default((ProductTileViewHolder) viewHolder, product, false, 2, (Object) null);
        }
        viewHolder.itemView.setOnClickListener(new a(this, i11));
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        boolean z11;
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i11, viewGroup, false);
        if (i11 == R.layout.darkstores_product_tile_new) {
            inflate.setLayoutParams(new ConstraintLayout.LayoutParams((int) (((double) viewGroup.getMeasuredWidth()) * WIDTH_RATIO), -2));
            if (viewGroup.getLayoutDirection() == 1) {
                z11 = true;
            } else {
                z11 = false;
            }
            Intrinsics.checkNotNullExpressionValue(inflate, "view");
            return new ProductTileViewHolder(inflate, this.quantityChangedListener, z11, (NewProductQuantityListener) null, this.useDesignSystemStepper);
        }
        throw new IllegalArgumentException();
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

    public final void setOnItemClickListener(@Nullable Function2<? super Product, ? super Integer, Unit> function2) {
        this.onItemClickListener = function2;
    }

    public final void setSwimlaneLength(int i11) {
        SwimlaneTrackingData swimlaneTrackingData2;
        SwimlaneTrackingData swimlaneTrackingData3 = this.swimlaneTrackingData;
        if (swimlaneTrackingData3 == null || (swimlaneTrackingData2 = SwimlaneTrackingData.copy$default(swimlaneTrackingData3, (String) null, Integer.valueOf(i11), 1, (Object) null)) == null) {
            swimlaneTrackingData2 = new SwimlaneTrackingData((String) null, Integer.valueOf(i11), 1, (DefaultConstructorMarker) null);
        }
        this.swimlaneTrackingData = swimlaneTrackingData2;
    }

    public final void setSwimlaneTitle(@NotNull String str) {
        SwimlaneTrackingData swimlaneTrackingData2;
        Intrinsics.checkNotNullParameter(str, "swimlaneTitle");
        SwimlaneTrackingData swimlaneTrackingData3 = this.swimlaneTrackingData;
        if (swimlaneTrackingData3 == null || (swimlaneTrackingData2 = SwimlaneTrackingData.copy$default(swimlaneTrackingData3, str, (Integer) null, 2, (Object) null)) == null) {
            swimlaneTrackingData2 = new SwimlaneTrackingData(str, (Integer) null, 2, (DefaultConstructorMarker) null);
        }
        this.swimlaneTrackingData = swimlaneTrackingData2;
    }

    public final void setSwimlaneTrackingData(@Nullable String str, @Nullable Integer num) {
        this.swimlaneTrackingData = new SwimlaneTrackingData(str, num);
    }

    public final void setSwimlaneTrackingInfo(@Nullable String str, @Nullable String str2) {
        this.swimlaneRequestId = str;
        this.swimlaneStrategy = str2;
    }

    public final void setTrackingCategoryId(@NotNull TrackingCategoryId trackingCategoryId2) {
        Intrinsics.checkNotNullParameter(trackingCategoryId2, "trackingCategoryId");
        this.trackingCategoryId = trackingCategoryId2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProductsListAdapter(@NotNull OnProductQuantityChangeTrackingListener onProductQuantityChangeTrackingListener, boolean z11) {
        super(new ProductDiffCallback());
        Intrinsics.checkNotNullParameter(onProductQuantityChangeTrackingListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.useDesignSystemStepper = z11;
        this.quantityChangedListener = new ProductsListAdapter$quantityChangedListener$1(onProductQuantityChangeTrackingListener, this);
    }
}
