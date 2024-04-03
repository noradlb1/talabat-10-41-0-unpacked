package com.deliveryhero.fluid.widgets.collections.pager;

import com.deliveryhero.fluid.expression.literal.Literal;
import com.deliveryhero.fluid.values.Color;
import com.deliveryhero.fluid.values.LogicalPixel;
import com.deliveryhero.fluid.widgets.collections.pager.indicators.PagerDotsIndicatorModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/deliveryhero/fluid/widgets/collections/pager/PagerModel;", "widget", "Lcom/deliveryhero/fluid/widgets/collections/pager/PagerWidget;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class PagerFactory$defaultsFactory$1 extends Lambda implements Function1<PagerWidget, PagerModel> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PagerFactory f30262g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PagerFactory$defaultsFactory$1(PagerFactory pagerFactory) {
        super(1);
        this.f30262g = pagerFactory;
    }

    @NotNull
    public final PagerModel invoke(@NotNull PagerWidget pagerWidget) {
        Intrinsics.checkNotNullParameter(pagerWidget, "widget");
        Literal literal = new Literal(Boolean.FALSE);
        Literal literal2 = new Literal(1000);
        Literal literal3 = new Literal(CollectionsKt__CollectionsKt.emptyList());
        LogicalPixel.Companion companion = LogicalPixel.Companion;
        Literal literal4 = new Literal(companion.getZERO());
        Literal literal5 = new Literal(companion.getZERO());
        Literal literal6 = new Literal(companion.getZERO());
        Literal literal7 = new Literal(companion.getZERO());
        Color.Companion companion2 = Color.Companion;
        return new PagerModel(literal, literal2, literal3, literal4, new PagerDotsIndicatorModel(literal5, literal6, literal7, new Literal(companion2.getOPAQUE_BLACK()), new Literal(companion2.getOPAQUE_WHITE())), this.f30262g.a(pagerWidget));
    }
}
