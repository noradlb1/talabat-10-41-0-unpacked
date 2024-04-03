package com.talabat.darkstores.feature.product;

import com.talabat.darkstores.common.lists.adapters.CartMapProductListAdapter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/darkstores/common/lists/adapters/CartMapProductListAdapter;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ProductFragment$productListAdapter$2 extends Lambda implements Function0<CartMapProductListAdapter> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ProductFragment f56492g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProductFragment$productListAdapter$2(ProductFragment productFragment) {
        super(0);
        this.f56492g = productFragment;
    }

    @NotNull
    public final CartMapProductListAdapter invoke() {
        return new CartMapProductListAdapter(this.f56492g.getCartFragmentViewModel(), this.f56492g.getViewModel().isDesignSystemStepperEnabled());
    }
}
