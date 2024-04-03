package com.talabat.darkstores.feature.categories.subcategories;

import com.talabat.darkstores.common.OnProductQuantityChangeListener;
import com.talabat.darkstores.common.OnProductQuantityChangeTrackingListener;
import com.talabat.darkstores.common.SwimlaneTrackingData;
import com.talabat.darkstores.feature.tracking.TrackingCategoryId;
import com.talabat.feature.darkstorescart.data.model.Product;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010\tJ5\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\fH\u0016¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"com/talabat/darkstores/feature/categories/subcategories/ProductsItemsListAdapter$quantityChangedListener$1", "Lcom/talabat/darkstores/common/OnProductQuantityChangeListener;", "decreaseProductCount", "", "product", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "count", "", "listPosition", "(Lcom/talabat/feature/darkstorescart/data/model/Product;ILjava/lang/Integer;)V", "increaseProductCount", "onFailure", "Lkotlin/Function0;", "(Lcom/talabat/feature/darkstorescart/data/model/Product;ILjava/lang/Integer;Lkotlin/jvm/functions/Function0;)V", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProductsItemsListAdapter$quantityChangedListener$1 implements OnProductQuantityChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ OnProductQuantityChangeTrackingListener f56315a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ProductsItemsListAdapter f56316b;

    public ProductsItemsListAdapter$quantityChangedListener$1(OnProductQuantityChangeTrackingListener onProductQuantityChangeTrackingListener, ProductsItemsListAdapter productsItemsListAdapter) {
        this.f56315a = onProductQuantityChangeTrackingListener;
        this.f56316b = productsItemsListAdapter;
    }

    public void decreaseProductCount(@NotNull Product product, int i11, @Nullable Integer num) {
        boolean z11;
        Intrinsics.checkNotNullParameter(product, "product");
        OnProductQuantityChangeTrackingListener onProductQuantityChangeTrackingListener = this.f56315a;
        TrackingCategoryId access$getTrackingCategoryId$p = this.f56316b.trackingCategoryId;
        if (this.f56316b.newProductQuantityListener == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        OnProductQuantityChangeTrackingListener.DefaultImpls.decreaseProductCount$default(onProductQuantityChangeTrackingListener, product, i11, num, access$getTrackingCategoryId$p, (SwimlaneTrackingData) null, (String) null, (String) null, z11, 112, (Object) null);
        this.f56316b.onQuantityChange.invoke(product, Integer.valueOf(i11));
    }

    public void increaseProductCount(@NotNull Product product, int i11, @Nullable Integer num, @NotNull Function0<Unit> function0) {
        boolean z11;
        Product product2 = product;
        Intrinsics.checkNotNullParameter(product, "product");
        Intrinsics.checkNotNullParameter(function0, "onFailure");
        OnProductQuantityChangeTrackingListener onProductQuantityChangeTrackingListener = this.f56315a;
        TrackingCategoryId access$getTrackingCategoryId$p = this.f56316b.trackingCategoryId;
        if (this.f56316b.newProductQuantityListener == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        OnProductQuantityChangeTrackingListener.DefaultImpls.increaseProductCount$default(onProductQuantityChangeTrackingListener, product, i11, num, access$getTrackingCategoryId$p, (SwimlaneTrackingData) null, (String) null, (String) null, z11, function0, 112, (Object) null);
        this.f56316b.onQuantityChange.invoke(product, Integer.valueOf(i11));
    }
}
