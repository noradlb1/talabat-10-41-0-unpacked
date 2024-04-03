package com.deliveryhero.fluid.widgets.collections.pager;

import com.deliveryhero.fluid.expression.literal.Literal;
import com.deliveryhero.fluid.values.Color;
import com.deliveryhero.fluid.values.LogicalPixel;
import com.deliveryhero.fluid.values.Size;
import com.deliveryhero.fluid.widgets.collections.pager.indicators.PagerDotsIndicatorModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/deliveryhero/fluid/widgets/collections/pager/CarouselModel;", "widget", "Lcom/deliveryhero/fluid/widgets/collections/pager/CarouselWidget;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CarouselFactory$defaultsFactory$1 extends Lambda implements Function1<CarouselWidget, CarouselModel> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CarouselFactory f30252g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CarouselFactory$defaultsFactory$1(CarouselFactory carouselFactory) {
        super(1);
        this.f30252g = carouselFactory;
    }

    @NotNull
    public final CarouselModel invoke(@NotNull CarouselWidget carouselWidget) {
        Intrinsics.checkNotNullParameter(carouselWidget, "widget");
        Literal literal = new Literal(Boolean.FALSE);
        Literal literal2 = new Literal(1000);
        Literal literal3 = new Literal(Size.MatchParent.INSTANCE);
        Literal literal4 = new Literal(CollectionsKt__CollectionsKt.emptyList());
        LogicalPixel.Companion companion = LogicalPixel.Companion;
        Literal literal5 = new Literal(companion.getZERO());
        Literal literal6 = new Literal(companion.getZERO());
        Literal literal7 = new Literal(companion.getZERO());
        Literal literal8 = new Literal(companion.getZERO());
        Color.Companion companion2 = Color.Companion;
        return new CarouselModel(literal, literal2, literal3, literal4, literal5, new PagerDotsIndicatorModel(literal6, literal7, literal8, new Literal(companion2.getOPAQUE_BLACK()), new Literal(companion2.getOPAQUE_WHITE())), this.f30252g.a(carouselWidget));
    }
}
