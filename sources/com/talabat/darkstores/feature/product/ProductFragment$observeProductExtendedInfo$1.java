package com.talabat.darkstores.feature.product;

import com.talabat.feature.darkstorescart.data.model.ProductExtendedInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "productExtendedInfo", "Lcom/talabat/feature/darkstorescart/data/model/ProductExtendedInfo;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ProductFragment$observeProductExtendedInfo$1 extends Lambda implements Function1<ProductExtendedInfo, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ProductFragment f56487g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProductFragment$observeProductExtendedInfo$1(ProductFragment productFragment) {
        super(1);
        this.f56487g = productFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ProductExtendedInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ProductExtendedInfo productExtendedInfo) {
        Intrinsics.checkNotNullParameter(productExtendedInfo, "productExtendedInfo");
        this.f56487g.setTopProductExtendedInfo(productExtendedInfo);
    }
}
