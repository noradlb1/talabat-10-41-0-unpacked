package com.talabat.darkstores.feature.categories.subcategories.list;

import android.view.View;
import com.talabat.feature.darkstorescart.data.model.Product;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ProductTileViewHolder$collectEvents$1$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ProductTileViewHolder f56363g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Product f56364h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProductTileViewHolder$collectEvents$1$1(ProductTileViewHolder productTileViewHolder, Product product) {
        super(0);
        this.f56363g = productTileViewHolder;
        this.f56364h = product;
    }

    public final void invoke() {
        ProductTileViewHolder productTileViewHolder = this.f56363g;
        View view = productTileViewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "itemView");
        productTileViewHolder.setupStepper(view, this.f56364h);
    }
}
