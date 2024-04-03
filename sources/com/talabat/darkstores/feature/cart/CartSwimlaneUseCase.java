package com.talabat.darkstores.feature.cart;

import com.talabat.darkstores.data.basket.model.SwimlaneResponse;
import com.talabat.darkstores.data.discovery.DiscoveryRepo;
import io.reactivex.Maybe;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ri.o1;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/talabat/darkstores/feature/cart/CartSwimlaneUseCase;", "", "discoveryRepo", "Lcom/talabat/darkstores/data/discovery/DiscoveryRepo;", "(Lcom/talabat/darkstores/data/discovery/DiscoveryRepo;)V", "getCartSwimlane", "Lio/reactivex/Maybe;", "Lcom/talabat/darkstores/feature/cart/CartSwimlane;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CartSwimlaneUseCase {
    @NotNull
    private final DiscoveryRepo discoveryRepo;

    @Inject
    public CartSwimlaneUseCase(@NotNull DiscoveryRepo discoveryRepo2) {
        Intrinsics.checkNotNullParameter(discoveryRepo2, "discoveryRepo");
        this.discoveryRepo = discoveryRepo2;
    }

    /* access modifiers changed from: private */
    /* renamed from: getCartSwimlane$lambda-0  reason: not valid java name */
    public static final CartSwimlane m9832getCartSwimlane$lambda0(SwimlaneResponse swimlaneResponse) {
        Intrinsics.checkNotNullParameter(swimlaneResponse, "swimlane");
        return new CartSwimlane(swimlaneResponse, CartSwimlaneViewType.COMPACT_WITH_INFO);
    }

    @NotNull
    public final Maybe<CartSwimlane> getCartSwimlane() {
        Maybe<R> onErrorComplete = this.discoveryRepo.getSwimlane().map(new o1()).onErrorComplete();
        Intrinsics.checkNotNullExpressionValue(onErrorComplete, "discoveryRepo.getSwimlan…      }.onErrorComplete()");
        return onErrorComplete;
    }
}
