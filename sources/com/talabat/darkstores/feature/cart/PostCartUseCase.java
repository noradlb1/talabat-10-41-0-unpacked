package com.talabat.darkstores.feature.cart;

import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import com.talabat.darkstores.feature.cart.model.PostCartData;
import com.talabat.feature.darkstorescart.data.model.CartResponse;
import com.talabat.feature.darkstorescart.data.model.Product;
import com.talabat.feature.darkstorescart.data.repository.DarkstoresCartRepository;
import com.talabat.feature.darkstorescartlist.domain.usecase.IsMultiBasketEnabledUseCase;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ri.p1;
import ri.q1;
import ri.r1;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ5\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/talabat/darkstores/feature/cart/PostCartUseCase;", "", "darkstoresRepo", "Lcom/talabat/darkstores/data/darkstores/DarkstoresRepo;", "isMultiBasketEnabled", "Lcom/talabat/feature/darkstorescartlist/domain/usecase/IsMultiBasketEnabledUseCase;", "darkstoresCartRepository", "Lcom/talabat/feature/darkstorescart/data/repository/DarkstoresCartRepository;", "(Lcom/talabat/darkstores/data/darkstores/DarkstoresRepo;Lcom/talabat/feature/darkstorescartlist/domain/usecase/IsMultiBasketEnabledUseCase;Lcom/talabat/feature/darkstorescart/data/repository/DarkstoresCartRepository;)V", "invoke", "Lio/reactivex/Single;", "Lcom/talabat/feature/darkstorescart/data/model/CartResponse;", "cartItems", "", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "deliveryFee", "", "minOrder", "enableBasketBasedDeliveryFee", "", "saveCartId", "", "cartResponse", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PostCartUseCase {
    @NotNull
    private final DarkstoresCartRepository darkstoresCartRepository;
    @NotNull
    private final DarkstoresRepo darkstoresRepo;
    @NotNull
    private final IsMultiBasketEnabledUseCase isMultiBasketEnabled;

    @Inject
    public PostCartUseCase(@NotNull DarkstoresRepo darkstoresRepo2, @NotNull IsMultiBasketEnabledUseCase isMultiBasketEnabledUseCase, @NotNull DarkstoresCartRepository darkstoresCartRepository2) {
        Intrinsics.checkNotNullParameter(darkstoresRepo2, "darkstoresRepo");
        Intrinsics.checkNotNullParameter(isMultiBasketEnabledUseCase, "isMultiBasketEnabled");
        Intrinsics.checkNotNullParameter(darkstoresCartRepository2, "darkstoresCartRepository");
        this.darkstoresRepo = darkstoresRepo2;
        this.isMultiBasketEnabled = isMultiBasketEnabledUseCase;
        this.darkstoresCartRepository = darkstoresCartRepository2;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final Boolean m9833invoke$lambda0(PostCartUseCase postCartUseCase) {
        Intrinsics.checkNotNullParameter(postCartUseCase, "this$0");
        return Boolean.valueOf(postCartUseCase.isMultiBasketEnabled.invoke());
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-1  reason: not valid java name */
    public static final SingleSource m9834invoke$lambda1(List list, float f11, float f12, boolean z11, PostCartUseCase postCartUseCase, Boolean bool) {
        Intrinsics.checkNotNullParameter(list, "$cartItems");
        Intrinsics.checkNotNullParameter(postCartUseCase, "this$0");
        Intrinsics.checkNotNullParameter(bool, "isMultiBasketEnabled");
        PostCartData postCartData = new PostCartData(list, f11, f12, z11);
        if (!bool.booleanValue()) {
            return postCartUseCase.darkstoresRepo.postCartByCartId(postCartData);
        }
        Single<CartResponse> doOnSuccess = postCartUseCase.darkstoresRepo.postCartByVendorId(postCartData).doOnSuccess(new r1(postCartUseCase));
        Intrinsics.checkNotNullExpressionValue(doOnSuccess, "{\n                    da…CartId)\n                }");
        return doOnSuccess;
    }

    /* access modifiers changed from: private */
    public final void saveCartId(CartResponse cartResponse) {
        String cartId = cartResponse.getCartId();
        if (cartId != null) {
            this.darkstoresCartRepository.saveCartId(cartId);
        }
    }

    @NotNull
    public final Single<CartResponse> invoke(@NotNull List<Product> list, float f11, float f12, boolean z11) {
        Intrinsics.checkNotNullParameter(list, "cartItems");
        Single<CartResponse> flatMap = Single.fromCallable(new p1(this)).flatMap(new q1(list, f11, f12, z11, this));
        Intrinsics.checkNotNullExpressionValue(flatMap, "fromCallable { isMultiBa…          }\n            }");
        return flatMap;
    }
}
