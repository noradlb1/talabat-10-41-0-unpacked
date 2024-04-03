package com.talabat.darkstores.feature.home.viewholder;

import com.talabat.darkstores.feature.home.swimlane.ProductClickTrackingAttribute;
import com.talabat.darkstores.model.Swimlane;
import com.talabat.feature.darkstorescart.data.model.Product;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "product", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "<anonymous parameter 1>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SwimlanesProductViewHolder$bind$1$1 extends Lambda implements Function2<Product, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function3<Product, String, ProductClickTrackingAttribute, Unit> f56443g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Swimlane f56444h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ProductClickTrackingAttribute f56445i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SwimlanesProductViewHolder$bind$1$1(Function3<? super Product, ? super String, ? super ProductClickTrackingAttribute, Unit> function3, Swimlane swimlane, ProductClickTrackingAttribute productClickTrackingAttribute) {
        super(2);
        this.f56443g = function3;
        this.f56444h = swimlane;
        this.f56445i = productClickTrackingAttribute;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Product) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Product product, int i11) {
        Intrinsics.checkNotNullParameter(product, "product");
        this.f56443g.invoke(product, this.f56444h.getRequestId(), this.f56445i);
    }
}
