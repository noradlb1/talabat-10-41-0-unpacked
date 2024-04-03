package com.talabat.darkstores.feature.cart.cartabadonment;

import com.talabat.darkstores.data.tracking.product.ProductTracker;
import com.talabat.feature.darkstorescart.data.repository.DarkstoresCartRepository;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ti.a;
import ti.b;
import ti.c;
import ti.d;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/talabat/darkstores/feature/cart/cartabadonment/StartCartClearedEventTrackerUseCase;", "", "cartRepository", "Lcom/talabat/feature/darkstorescart/data/repository/DarkstoresCartRepository;", "productTracker", "Lcom/talabat/darkstores/data/tracking/product/ProductTracker;", "(Lcom/talabat/feature/darkstorescart/data/repository/DarkstoresCartRepository;Lcom/talabat/darkstores/data/tracking/product/ProductTracker;)V", "invoke", "Lio/reactivex/Observable;", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class StartCartClearedEventTrackerUseCase {
    @NotNull
    private final DarkstoresCartRepository cartRepository;
    @NotNull
    private final ProductTracker productTracker;

    @Inject
    public StartCartClearedEventTrackerUseCase(@NotNull DarkstoresCartRepository darkstoresCartRepository, @NotNull ProductTracker productTracker2) {
        Intrinsics.checkNotNullParameter(darkstoresCartRepository, "cartRepository");
        Intrinsics.checkNotNullParameter(productTracker2, "productTracker");
        this.cartRepository = darkstoresCartRepository;
        this.productTracker = productTracker2;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final Boolean m9838invoke$lambda0(List list) {
        Intrinsics.checkNotNullParameter(list, "cartProducts");
        return Boolean.valueOf(list.isEmpty());
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-1  reason: not valid java name */
    public static final Boolean m9839invoke$lambda1(Boolean bool, Boolean bool2) {
        boolean z11;
        Intrinsics.checkNotNullParameter(bool, "wasCartEmpty");
        Intrinsics.checkNotNullParameter(bool2, "isCartEmpty");
        if (bool.booleanValue() || !bool2.booleanValue()) {
            z11 = false;
        } else {
            z11 = true;
        }
        return Boolean.valueOf(z11);
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-2  reason: not valid java name */
    public static final void m9840invoke$lambda2(StartCartClearedEventTrackerUseCase startCartClearedEventTrackerUseCase, Boolean bool) {
        Intrinsics.checkNotNullParameter(startCartClearedEventTrackerUseCase, "this$0");
        Intrinsics.checkNotNullExpressionValue(bool, "isCartCleared");
        if (bool.booleanValue()) {
            startCartClearedEventTrackerUseCase.productTracker.cartCleared();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-3  reason: not valid java name */
    public static final Unit m9841invoke$lambda3(Boolean bool) {
        Intrinsics.checkNotNullParameter(bool, "it");
        return Unit.INSTANCE;
    }

    @NotNull
    public final Observable<Unit> invoke() {
        Observable<R> share = this.cartRepository.getAllInStockProducts().map(new a()).share();
        Observable<R> map = Observable.zip(share, share.skip(1), new b()).doOnNext(new c(this)).map(new d());
        Intrinsics.checkNotNullExpressionValue(map, "zip(\n            emptyCa…      }\n        }.map { }");
        return map;
    }
}
