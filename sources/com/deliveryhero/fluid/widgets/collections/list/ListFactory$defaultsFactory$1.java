package com.deliveryhero.fluid.widgets.collections.list;

import com.deliveryhero.fluid.expression.literal.Literal;
import com.deliveryhero.fluid.values.LogicalPixel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/deliveryhero/fluid/widgets/collections/list/ListModel;", "widget", "Lcom/deliveryhero/fluid/widgets/collections/list/ListWidget;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ListFactory$defaultsFactory$1 extends Lambda implements Function1<ListWidget, ListModel> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ListFactory f30246g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ListFactory$defaultsFactory$1(ListFactory listFactory) {
        super(1);
        this.f30246g = listFactory;
    }

    @NotNull
    public final ListModel invoke(@NotNull ListWidget listWidget) {
        Intrinsics.checkNotNullParameter(listWidget, "widget");
        return new ListModel(new Literal(CollectionsKt__CollectionsKt.emptyList()), new Literal(LogicalPixel.Companion.getZERO()), this.f30246g.a(listWidget));
    }
}
