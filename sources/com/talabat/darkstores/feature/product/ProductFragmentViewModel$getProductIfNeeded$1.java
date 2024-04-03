package com.talabat.darkstores.feature.product;

import com.talabat.feature.darkstorescart.data.model.Product;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ProductFragmentViewModel$getProductIfNeeded$1 extends Lambda implements Function1<Product, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ProductFragmentViewModel f56499g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProductFragmentViewModel$getProductIfNeeded$1(ProductFragmentViewModel productFragmentViewModel) {
        super(1);
        this.f56499g = productFragmentViewModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Product) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Product product) {
        ProductFragmentViewModel productFragmentViewModel = this.f56499g;
        Intrinsics.checkNotNullExpressionValue(product, "it");
        productFragmentViewModel.product = product;
        this.f56499g.notifyProductExtendedInfo(product.getExtendedInfo(), product.getDescription());
    }
}
