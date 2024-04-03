package com.talabat.darkstores.common.lists.adapters;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.talabat.darkstores.common.OnProductQuantityChangeTrackingListener;
import com.talabat.feature.darkstorescart.data.model.Product;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0014R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nRC\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00050\u000b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00050\u000b8F@FX\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001a"}, d2 = {"Lcom/talabat/darkstores/common/lists/adapters/CartMapProductListAdapter;", "Lcom/talabat/darkstores/common/lists/adapters/ProductsListAdapter;", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "product", "applyCartCountToItem", "", "position", "f", "Lcom/talabat/darkstores/common/lists/adapters/CartCountMapHelper;", "helper", "Lcom/talabat/darkstores/common/lists/adapters/CartCountMapHelper;", "", "", "<set-?>", "cartCountMap$delegate", "getCartCountMap", "()Ljava/util/Map;", "setCartCountMap", "(Ljava/util/Map;)V", "cartCountMap", "Lcom/talabat/darkstores/common/OnProductQuantityChangeTrackingListener;", "listener", "", "useDesignSystemStepper", "<init>", "(Lcom/talabat/darkstores/common/OnProductQuantityChangeTrackingListener;Z)V", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0})
public final class CartMapProductListAdapter extends ProductsListAdapter {

    /* renamed from: i  reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f56157i = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(CartMapProductListAdapter.class, "cartCountMap", "getCartCountMap()Ljava/util/Map;", 0))};
    @NotNull
    private final CartCountMapHelper cartCountMap$delegate;
    @NotNull
    private final CartCountMapHelper helper;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CartMapProductListAdapter(OnProductQuantityChangeTrackingListener onProductQuantityChangeTrackingListener, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(onProductQuantityChangeTrackingListener, (i11 & 2) != 0 ? false : z11);
    }

    private final Product applyCartCountToItem(Product product) {
        Integer num = getCartCountMap().get(product.getId());
        product.setCartCount(num != null ? num.intValue() : 0);
        return product;
    }

    @NotNull
    /* renamed from: f */
    public Product getItem(int i11) {
        Product product = (Product) super.getItem(i11);
        this.helper.getPositionMap().put(product.getId(), Integer.valueOf(i11));
        Intrinsics.checkNotNullExpressionValue(product, "item");
        return applyCartCountToItem(product);
    }

    @NotNull
    public final Map<String, Integer> getCartCountMap() {
        return this.cartCountMap$delegate.getValue(this, f56157i[0]);
    }

    public final void setCartCountMap(@NotNull Map<String, Integer> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.cartCountMap$delegate.setValue(this, f56157i[0], map);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CartMapProductListAdapter(@NotNull OnProductQuantityChangeTrackingListener onProductQuantityChangeTrackingListener, boolean z11) {
        super(onProductQuantityChangeTrackingListener, z11);
        Intrinsics.checkNotNullParameter(onProductQuantityChangeTrackingListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        CartCountMapHelper cartCountMapHelper = new CartCountMapHelper(this);
        this.helper = cartCountMapHelper;
        this.cartCountMap$delegate = cartCountMapHelper;
    }
}
