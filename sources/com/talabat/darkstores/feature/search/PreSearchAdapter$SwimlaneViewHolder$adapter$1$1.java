package com.talabat.darkstores.feature.search;

import com.talabat.darkstores.feature.search.listener.PreSearchSwimlaneListener;
import com.talabat.feature.darkstorescart.data.model.Product;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class PreSearchAdapter$SwimlaneViewHolder$adapter$1$1 extends FunctionReferenceImpl implements Function2<Product, Integer, Unit> {
    public PreSearchAdapter$SwimlaneViewHolder$adapter$1$1(Object obj) {
        super(2, obj, PreSearchSwimlaneListener.class, "onPreSearchProductClicked", "onPreSearchProductClicked(Lcom/talabat/feature/darkstorescart/data/model/Product;I)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Product) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Product product, int i11) {
        Intrinsics.checkNotNullParameter(product, "p0");
        ((PreSearchSwimlaneListener) this.receiver).onPreSearchProductClicked(product, i11);
    }
}
