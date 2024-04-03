package com.talabat.darkstores.feature.home;

import com.talabat.feature.darkstorescart.data.model.Product;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class HomeFragmentViewModel$loadProductBySkuFromVoucher$1$1 extends Lambda implements Function1<Product, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ HomeFragmentViewModel f56417g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeFragmentViewModel$loadProductBySkuFromVoucher$1$1(HomeFragmentViewModel homeFragmentViewModel) {
        super(1);
        this.f56417g = homeFragmentViewModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Product) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Product product) {
        this.f56417g.mutableVoucherProduct.postValue(product);
    }
}
