package com.talabat.darkstores.feature.cart;

import com.talabat.feature.darkstorescart.data.model.Product;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CartController$setProductCount$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CartController f56246g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Product f56247h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f56248i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CartController$setProductCount$1(CartController cartController, Product product, int i11) {
        super(0);
        this.f56246g = cartController;
        this.f56247h = product;
        this.f56248i = i11;
    }

    public final void invoke() {
        this.f56246g.cartRepository.setProductCount(this.f56247h, this.f56248i);
    }
}
