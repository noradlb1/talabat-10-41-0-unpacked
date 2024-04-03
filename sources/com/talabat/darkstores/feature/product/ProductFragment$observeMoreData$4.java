package com.talabat.darkstores.feature.product;

import com.talabat.darkstores.R;
import com.talabat.darkstores.feature.product.imageSlider.ImageSliderView;
import com.talabat.feature.darkstorescart.data.model.Product;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012&\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005 \u0006*\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "it", "Lkotlin/Pair;", "", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ProductFragment$observeMoreData$4 extends Lambda implements Function1<Pair<? extends Boolean, ? extends Product>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ProductFragment f56483g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProductFragment$observeMoreData$4(ProductFragment productFragment) {
        super(1);
        this.f56483g = productFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Pair<Boolean, Product>) (Pair) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Pair<Boolean, Product> pair) {
        ((ImageSliderView) this.f56483g._$_findCachedViewById(R.id.header_image_container)).setItemsList(this.f56483g.getViewModel().getProductImages(pair.getSecond()), pair.getFirst().booleanValue(), this.f56483g.getViewModel().isExtendedInfoEnabled());
    }
}
