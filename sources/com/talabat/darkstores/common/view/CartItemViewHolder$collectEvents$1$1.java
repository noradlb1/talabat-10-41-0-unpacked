package com.talabat.darkstores.common.view;

import com.talabat.darkstores.R;
import com.talabat.feature.darkstorescart.data.model.Product;
import com.talabat.talabatcommon.extentions.IntKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CartItemViewHolder$collectEvents$1$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CartItemViewHolder f56170g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Product f56171h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CartItemViewHolder$collectEvents$1$1(CartItemViewHolder cartItemViewHolder, Product product) {
        super(0);
        this.f56170g = cartItemViewHolder;
        this.f56171h = product;
    }

    public final void invoke() {
        ItemCounterNew itemCounterNew = (ItemCounterNew) this.f56170g.itemView.findViewById(R.id.product_tile_counter);
        Intrinsics.checkNotNullExpressionValue(itemCounterNew, "itemView.product_tile_counter");
        ItemCounterNew.setup$default(itemCounterNew, this.f56171h.getCartCount(), this.f56171h.getStock(), false, IntKt.orZero(this.f56171h.getFreeCount()), 4, (Object) null);
    }
}
