package com.talabat.darkstores.feature.home;

import com.talabat.darkstores.feature.home.swimlane.ProductClickTrackingAttribute;
import com.talabat.darkstores.model.Swimlane;
import com.talabat.feature.darkstorescart.data.model.Product;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "product", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "<anonymous parameter 1>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class HomeFragment$addSwimlaneView$1 extends Lambda implements Function2<Product, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ HomeFragment f56381g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Swimlane f56382h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ProductClickTrackingAttribute f56383i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeFragment$addSwimlaneView$1(HomeFragment homeFragment, Swimlane swimlane, ProductClickTrackingAttribute productClickTrackingAttribute) {
        super(2);
        this.f56381g = homeFragment;
        this.f56382h = swimlane;
        this.f56383i = productClickTrackingAttribute;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Product) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Product product, int i11) {
        Intrinsics.checkNotNullParameter(product, "product");
        this.f56381g.onProductClicked(product, this.f56382h.getRequestId(), this.f56383i);
    }
}
