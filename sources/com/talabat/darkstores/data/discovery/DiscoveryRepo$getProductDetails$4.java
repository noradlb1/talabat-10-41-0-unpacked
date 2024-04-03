package com.talabat.darkstores.data.discovery;

import com.talabat.feature.darkstorescart.data.model.Product;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u00010\u00020\u0002H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "it", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DiscoveryRepo$getProductDetails$4 extends Lambda implements Function1<Product, List<? extends Product>> {
    public static final DiscoveryRepo$getProductDetails$4 INSTANCE = new DiscoveryRepo$getProductDetails$4();

    public DiscoveryRepo$getProductDetails$4() {
        super(1);
    }

    @NotNull
    public final List<Product> invoke(Product product) {
        return CollectionsKt__CollectionsJVMKt.listOf(product);
    }
}
