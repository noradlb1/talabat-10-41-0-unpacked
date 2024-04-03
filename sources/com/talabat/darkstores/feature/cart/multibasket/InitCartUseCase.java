package com.talabat.darkstores.feature.cart.multibasket;

import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import com.talabat.darkstores.domain.common.ApplyDiscountsAndCampaignsUseCase;
import com.talabat.feature.darkstorescart.data.model.Product;
import com.talabat.feature.darkstorescart.data.repository.DarkstoresCartRepository;
import com.talabat.feature.darkstorescartlist.domain.usecase.IsMultiBasketEnabledUseCase;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import retrofit2.HttpException;
import ui.a;
import ui.b;
import ui.c;
import ui.d;
import ui.e;
import ui.f;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0003\n\u0000\b\u0000\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0002J\u0014\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\t\u0010\u0013\u001a\u00020\u000eH\u0002J\f\u0010\u0014\u001a\u00020\u0015*\u00020\u0016H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/talabat/darkstores/feature/cart/multibasket/InitCartUseCase;", "", "darkstoresRepo", "Lcom/talabat/darkstores/data/darkstores/DarkstoresRepo;", "darkstoresCartRepository", "Lcom/talabat/feature/darkstorescart/data/repository/DarkstoresCartRepository;", "isMultiBasketEnabledUseCase", "Lcom/talabat/feature/darkstorescartlist/domain/usecase/IsMultiBasketEnabledUseCase;", "applyDiscountsAndCampaigns", "Lcom/talabat/darkstores/domain/common/ApplyDiscountsAndCampaignsUseCase;", "rxSchedulersFactory", "Lcom/talabat/core/dispatcher/domain/RxSchedulersFactory;", "(Lcom/talabat/darkstores/data/darkstores/DarkstoresRepo;Lcom/talabat/feature/darkstorescart/data/repository/DarkstoresCartRepository;Lcom/talabat/feature/darkstorescartlist/domain/usecase/IsMultiBasketEnabledUseCase;Lcom/talabat/darkstores/domain/common/ApplyDiscountsAndCampaignsUseCase;Lcom/talabat/core/dispatcher/domain/RxSchedulersFactory;)V", "getCart", "Lio/reactivex/Completable;", "handleCartResponse", "", "cart", "Lcom/talabat/darkstores/feature/cart/multibasket/Cart;", "invoke", "isCartNotFoundException", "", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class InitCartUseCase {
    @NotNull
    private final ApplyDiscountsAndCampaignsUseCase applyDiscountsAndCampaigns;
    @NotNull
    private final DarkstoresCartRepository darkstoresCartRepository;
    @NotNull
    private final DarkstoresRepo darkstoresRepo;
    @NotNull
    private final IsMultiBasketEnabledUseCase isMultiBasketEnabledUseCase;
    @NotNull
    private final RxSchedulersFactory rxSchedulersFactory;

    @Inject
    public InitCartUseCase(@NotNull DarkstoresRepo darkstoresRepo2, @NotNull DarkstoresCartRepository darkstoresCartRepository2, @NotNull IsMultiBasketEnabledUseCase isMultiBasketEnabledUseCase2, @NotNull ApplyDiscountsAndCampaignsUseCase applyDiscountsAndCampaignsUseCase, @NotNull RxSchedulersFactory rxSchedulersFactory2) {
        Intrinsics.checkNotNullParameter(darkstoresRepo2, "darkstoresRepo");
        Intrinsics.checkNotNullParameter(darkstoresCartRepository2, "darkstoresCartRepository");
        Intrinsics.checkNotNullParameter(isMultiBasketEnabledUseCase2, "isMultiBasketEnabledUseCase");
        Intrinsics.checkNotNullParameter(applyDiscountsAndCampaignsUseCase, "applyDiscountsAndCampaigns");
        Intrinsics.checkNotNullParameter(rxSchedulersFactory2, "rxSchedulersFactory");
        this.darkstoresRepo = darkstoresRepo2;
        this.darkstoresCartRepository = darkstoresCartRepository2;
        this.isMultiBasketEnabledUseCase = isMultiBasketEnabledUseCase2;
        this.applyDiscountsAndCampaigns = applyDiscountsAndCampaignsUseCase;
        this.rxSchedulersFactory = rxSchedulersFactory2;
    }

    public static /* synthetic */ void f(InitCartUseCase initCartUseCase, Cart cart, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            cart = null;
        }
        initCartUseCase.handleCartResponse(cart);
    }

    private final Completable getCart() {
        Completable ignoreElement = this.darkstoresRepo.getCart().flatMap(new b(this.applyDiscountsAndCampaigns)).map(new c(this)).onErrorResumeNext(new d(this)).ignoreElement();
        Intrinsics.checkNotNullExpressionValue(ignoreElement, "darkstoresRepo.getCart()…        }.ignoreElement()");
        return ignoreElement;
    }

    /* access modifiers changed from: private */
    /* renamed from: getCart$lambda-3  reason: not valid java name */
    public static final SingleSource m9842getCart$lambda3(InitCartUseCase initCartUseCase, Throwable th2) {
        Intrinsics.checkNotNullParameter(initCartUseCase, "this$0");
        Intrinsics.checkNotNullParameter(th2, "exception");
        if (initCartUseCase.isCartNotFoundException(th2)) {
            return Single.fromCallable(new a(initCartUseCase));
        }
        return Single.error(th2);
    }

    /* access modifiers changed from: private */
    /* renamed from: getCart$lambda-3$lambda-2  reason: not valid java name */
    public static final Unit m9843getCart$lambda3$lambda2(InitCartUseCase initCartUseCase) {
        Intrinsics.checkNotNullParameter(initCartUseCase, "this$0");
        f(initCartUseCase, (Cart) null, 1, (Object) null);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final void handleCartResponse(Cart cart) {
        String cartId;
        List<Product> products;
        this.darkstoresCartRepository.clearCart();
        this.darkstoresCartRepository.clearCartInfo();
        if (!(cart == null || (products = cart.getProducts()) == null)) {
            this.darkstoresCartRepository.insertCartProducts(products);
        }
        if (cart != null && (cartId = cart.getCartId()) != null) {
            this.darkstoresCartRepository.saveCartId(cartId);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final Boolean m9844invoke$lambda0(InitCartUseCase initCartUseCase) {
        Intrinsics.checkNotNullParameter(initCartUseCase, "this$0");
        return Boolean.valueOf(initCartUseCase.isMultiBasketEnabledUseCase.invoke());
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-1  reason: not valid java name */
    public static final CompletableSource m9845invoke$lambda1(InitCartUseCase initCartUseCase, Boolean bool) {
        Intrinsics.checkNotNullParameter(initCartUseCase, "this$0");
        Intrinsics.checkNotNullParameter(bool, "isMultiBasketEnabled");
        if (bool.booleanValue()) {
            return initCartUseCase.getCart();
        }
        return Completable.complete();
    }

    private final boolean isCartNotFoundException(Throwable th2) {
        return (th2 instanceof HttpException) && ((HttpException) th2).code() == 404;
    }

    @NotNull
    public final Completable invoke() {
        Completable flatMapCompletable = Single.fromCallable(new e(this)).subscribeOn(this.rxSchedulersFactory.io()).flatMapCompletable(new f(this));
        Intrinsics.checkNotNullExpressionValue(flatMapCompletable, "fromCallable { isMultiBa…          }\n            }");
        return flatMapCompletable;
    }
}
