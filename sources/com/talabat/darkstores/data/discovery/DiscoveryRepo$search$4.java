package com.talabat.darkstores.data.discovery;

import com.talabat.darkstores.model.SearchSuggestion;
import com.talabat.feature.darkstorescart.data.model.Product;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "it", "Lcom/talabat/darkstores/model/SearchSuggestion;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DiscoveryRepo$search$4 extends Lambda implements Function1<List<? extends SearchSuggestion>, List<? extends Product>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DiscoveryRepo f56189g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DiscoveryRepo$search$4(DiscoveryRepo discoveryRepo) {
        super(1);
        this.f56189g = discoveryRepo;
    }

    @NotNull
    public final List<Product> invoke(List<? extends SearchSuggestion> list) {
        DiscoveryRepo discoveryRepo = this.f56189g;
        Intrinsics.checkNotNullExpressionValue(list, "it");
        return discoveryRepo.searchSuggestionGetAllProducts(list);
    }
}
