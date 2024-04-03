package com.talabat.darkstores.data.discovery;

import com.talabat.feature.darkstorescart.data.model.Product;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u000122\u0010\u0003\u001a.\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0001\u0012\u0004\u0012\u00020\u0005 \u0006*\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0001\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "it", "Lkotlin/Pair;", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DiscoveryRepo$getProducts$3 extends Lambda implements Function1<Pair<? extends List<? extends Product>, ? extends Integer>, List<? extends Product>> {
    public static final DiscoveryRepo$getProducts$3 INSTANCE = new DiscoveryRepo$getProducts$3();

    public DiscoveryRepo$getProducts$3() {
        super(1);
    }

    @NotNull
    public final List<Product> invoke(Pair<? extends List<Product>, Integer> pair) {
        return (List) pair.getFirst();
    }
}
