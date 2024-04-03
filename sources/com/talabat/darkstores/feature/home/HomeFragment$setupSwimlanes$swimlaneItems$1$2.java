package com.talabat.darkstores.feature.home;

import com.talabat.darkstores.feature.home.swimlane.ProductClickTrackingAttribute;
import com.talabat.feature.darkstorescart.data.model.Product;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "product", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "swimlaneRequestId", "", "productClickTrackingAttribute", "Lcom/talabat/darkstores/feature/home/swimlane/ProductClickTrackingAttribute;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class HomeFragment$setupSwimlanes$swimlaneItems$1$2 extends Lambda implements Function3<Product, String, ProductClickTrackingAttribute, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ HomeFragment f56410g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeFragment$setupSwimlanes$swimlaneItems$1$2(HomeFragment homeFragment) {
        super(3);
        this.f56410g = homeFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((Product) obj, (String) obj2, (ProductClickTrackingAttribute) obj3);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Product product, @Nullable String str, @NotNull ProductClickTrackingAttribute productClickTrackingAttribute) {
        Intrinsics.checkNotNullParameter(product, "product");
        Intrinsics.checkNotNullParameter(productClickTrackingAttribute, "productClickTrackingAttribute");
        this.f56410g.onProductClicked(product, str, productClickTrackingAttribute);
    }
}
