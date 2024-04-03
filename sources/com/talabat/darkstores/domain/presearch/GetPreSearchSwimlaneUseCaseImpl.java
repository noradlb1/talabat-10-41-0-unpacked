package com.talabat.darkstores.domain.presearch;

import com.talabat.darkstores.data.discovery.DiscoveryRepo;
import com.talabat.feature.darkstorescart.data.model.Product;
import io.reactivex.Maybe;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0015\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/darkstores/domain/presearch/GetPreSearchSwimlaneUseCaseImpl;", "Lcom/talabat/darkstores/domain/presearch/GetPreSearchSwimlaneUseCase;", "discoveryRepo", "Lcom/talabat/darkstores/data/discovery/DiscoveryRepo;", "(Lcom/talabat/darkstores/data/discovery/DiscoveryRepo;)V", "invoke", "Lio/reactivex/Maybe;", "", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetPreSearchSwimlaneUseCaseImpl implements GetPreSearchSwimlaneUseCase {
    @NotNull
    private final DiscoveryRepo discoveryRepo;

    @Inject
    public GetPreSearchSwimlaneUseCaseImpl(@NotNull DiscoveryRepo discoveryRepo2) {
        Intrinsics.checkNotNullParameter(discoveryRepo2, "discoveryRepo");
        this.discoveryRepo = discoveryRepo2;
    }

    @NotNull
    public Maybe<List<Product>> invoke() {
        return this.discoveryRepo.getPastOrders("past_orders_frequency");
    }
}
