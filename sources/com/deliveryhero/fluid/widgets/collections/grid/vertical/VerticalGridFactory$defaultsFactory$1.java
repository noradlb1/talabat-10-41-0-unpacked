package com.deliveryhero.fluid.widgets.collections.grid.vertical;

import com.deliveryhero.fluid.expression.literal.Literal;
import com.deliveryhero.fluid.values.LogicalPixel;
import com.deliveryhero.fluid.widgets.collections.grid.GridWidget;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/deliveryhero/fluid/widgets/collections/grid/vertical/VerticalGridModel;", "widget", "Lcom/deliveryhero/fluid/widgets/collections/grid/GridWidget;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class VerticalGridFactory$defaultsFactory$1 extends Lambda implements Function1<GridWidget, VerticalGridModel> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ VerticalGridFactory f30245g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VerticalGridFactory$defaultsFactory$1(VerticalGridFactory verticalGridFactory) {
        super(1);
        this.f30245g = verticalGridFactory;
    }

    @NotNull
    public final VerticalGridModel invoke(@NotNull GridWidget gridWidget) {
        Intrinsics.checkNotNullParameter(gridWidget, "widget");
        return new VerticalGridModel(new Literal(CollectionsKt__CollectionsKt.emptyList()), new Literal(LogicalPixel.Companion.getZERO()), this.f30245g.a(gridWidget));
    }
}
