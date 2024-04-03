package com.talabat.darkstores.feature.product;

import com.talabat.darkstores.R;
import com.talabat.darkstores.feature.product.views.AddToCartButton;
import com.talabat.feature.darkstorescart.data.model.Product;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "product", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ProductFragment$observeMoreData$3 extends Lambda implements Function1<Product, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ProductFragment f56482g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProductFragment$observeMoreData$3(ProductFragment productFragment) {
        super(1);
        this.f56482g = productFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Product) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Product product) {
        Unit unit;
        Pair<Integer, Integer> cartProductQuantityAndStock = this.f56482g.getCartFragmentViewModel().cartProductQuantityAndStock(this.f56482g.getArgs().getProduct().getId());
        if (cartProductQuantityAndStock != null) {
            ProductFragment productFragment = this.f56482g;
            ((AddToCartButton) productFragment._$_findCachedViewById(R.id.addToCartButton)).setupQuantityAndStock(cartProductQuantityAndStock.component1().intValue(), cartProductQuantityAndStock.component2().intValue());
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            ((AddToCartButton) this.f56482g._$_findCachedViewById(R.id.addToCartButton)).setupQuantityAndStock(0, product.getStock());
        }
        this.f56482g.getViewModel().trackProductOpened(this.f56482g.getArgs().getShouldTrackProductOpenedEvent(), this.f56482g.getArgs().getDeeplinkUri(), this.f56482g.getArgs().getEventOrigin(), this.f56482g.getArgs().getSwimlaneRequestId(), this.f56482g.getArgs().getSearchRequestId(), this.f56482g.getArgs().getSearchTerm(), this.f56482g.getArgs().getProductClickTrackingAttribute(), product.getExtendedInfo());
        ProductFragment productFragment2 = this.f56482g;
        Intrinsics.checkNotNullExpressionValue(product, "product");
        productFragment2.setProductDetails(product);
    }
}
