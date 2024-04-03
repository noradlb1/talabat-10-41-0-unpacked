package com.talabat.darkstores.feature.product.views;

import androidx.lifecycle.ViewModel;
import com.talabat.darkstores.feature.product.views.CartButtonEvent;
import com.talabat.darkstores.feature.product.views.CartButtonState;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lj.d;
import lj.e;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000  2\u00020\u0001:\u0001 B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0013H\u0002J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0013H\u0002J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0018\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0013H\u0002R#\u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\f0\f0\u0010X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\t¨\u0006!"}, d2 = {"Lcom/talabat/darkstores/feature/product/views/AddToCartButtonViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "currentCount", "Lio/reactivex/Observable;", "Lkotlin/Pair;", "", "", "getCurrentCount", "()Lio/reactivex/Observable;", "eventObserver", "Lio/reactivex/Observer;", "Lcom/talabat/darkstores/feature/product/views/CartButtonEvent;", "getEventObserver", "()Lio/reactivex/Observer;", "eventSubject", "Lio/reactivex/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "stateObservable", "Lcom/talabat/darkstores/feature/product/views/CartButtonState;", "stock", "viewState", "getViewState", "handleAddAction", "Lcom/talabat/darkstores/feature/product/views/CartButtonState$NotEmpty;", "state", "handleRemoveAction", "handleSetupAction", "setup", "Lcom/talabat/darkstores/feature/product/views/CartButtonEvent$Setup;", "handleState", "event", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AddToCartButtonViewModel extends ViewModel {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long EMIT_CART_DELAY = 300;
    private static final int INITIAL_STOCK = 10;
    @NotNull
    private final Observable<Pair<Integer, Boolean>> currentCount;
    @NotNull
    private final Observer<CartButtonEvent> eventObserver;
    @NotNull
    private final PublishSubject<CartButtonEvent> eventSubject;
    @NotNull
    private final Observable<CartButtonState> stateObservable;
    private int stock = 10;
    @NotNull
    private final Observable<CartButtonState> viewState;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/darkstores/feature/product/views/AddToCartButtonViewModel$Companion;", "", "()V", "EMIT_CART_DELAY", "", "INITIAL_STOCK", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AddToCartButtonViewModel() {
        PublishSubject<CartButtonEvent> create = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "create<CartButtonEvent>()");
        this.eventSubject = create;
        Observable<R> share = create.scan(CartButtonState.Empty.INSTANCE, new d(this)).share();
        Intrinsics.checkNotNullExpressionValue(share, "eventSubject\n        .sc…state) }\n        .share()");
        this.stateObservable = share;
        Observable<R> distinctUntilChanged = share.distinctUntilChanged();
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "stateObservable\n        .distinctUntilChanged()");
        this.viewState = distinctUntilChanged;
        Observable<R> map = share.skip(1).debounce(EMIT_CART_DELAY, TimeUnit.MILLISECONDS).distinctUntilChanged().map(new e());
        Intrinsics.checkNotNullExpressionValue(map, "stateObservable\n        …)\n            }\n        }");
        this.currentCount = map;
        this.eventObserver = create;
    }

    /* access modifiers changed from: private */
    /* renamed from: currentCount$lambda-1  reason: not valid java name */
    public static final Pair m10050currentCount$lambda1(CartButtonState cartButtonState) {
        Intrinsics.checkNotNullParameter(cartButtonState, "it");
        if (Intrinsics.areEqual((Object) cartButtonState, (Object) CartButtonState.Empty.INSTANCE)) {
            return new Pair(0, Boolean.TRUE);
        }
        if (cartButtonState instanceof CartButtonState.NotEmpty) {
            CartButtonState.NotEmpty notEmpty = (CartButtonState.NotEmpty) cartButtonState;
            return new Pair(Integer.valueOf(notEmpty.getQuantity()), Boolean.valueOf(notEmpty.isRemove()));
        }
        throw new NoWhenBranchMatchedException();
    }

    private final CartButtonState.NotEmpty handleAddAction(CartButtonState cartButtonState) {
        CartButtonState.NotEmpty full;
        if (Intrinsics.areEqual((Object) cartButtonState, (Object) CartButtonState.Empty.INSTANCE)) {
            return new CartButtonState.NotEmpty.One(false);
        }
        if (cartButtonState instanceof CartButtonState.NotEmpty.One) {
            full = new CartButtonState.NotEmpty.More(((CartButtonState.NotEmpty.One) cartButtonState).getQuantity() + 1, false);
        } else if (cartButtonState instanceof CartButtonState.NotEmpty.More) {
            CartButtonState.NotEmpty.More more = (CartButtonState.NotEmpty.More) cartButtonState;
            if (more.getQuantity() + 1 == this.stock) {
                full = new CartButtonState.NotEmpty.Full(more.getQuantity() + 1, false);
            } else {
                full = new CartButtonState.NotEmpty.More(more.getQuantity() + 1, false);
            }
        } else if (cartButtonState instanceof CartButtonState.NotEmpty.Full) {
            full = new CartButtonState.NotEmpty.Full(((CartButtonState.NotEmpty.Full) cartButtonState).getQuantity(), false);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return full;
    }

    private final CartButtonState handleRemoveAction(CartButtonState cartButtonState) {
        CartButtonState.Empty empty = CartButtonState.Empty.INSTANCE;
        if (Intrinsics.areEqual((Object) cartButtonState, (Object) empty) || (cartButtonState instanceof CartButtonState.NotEmpty.One)) {
            return empty;
        }
        if (cartButtonState instanceof CartButtonState.NotEmpty.More) {
            CartButtonState.NotEmpty.More more = (CartButtonState.NotEmpty.More) cartButtonState;
            if (more.getQuantity() == 2) {
                return new CartButtonState.NotEmpty.One(true);
            }
            return new CartButtonState.NotEmpty.More(more.getQuantity() - 1, true);
        } else if (cartButtonState instanceof CartButtonState.NotEmpty.Full) {
            return new CartButtonState.NotEmpty.More(((CartButtonState.NotEmpty.Full) cartButtonState).getQuantity() - 1, true);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final CartButtonState handleSetupAction(CartButtonEvent.Setup setup) {
        CartButtonState more;
        this.stock = setup.getStock();
        int quantity = setup.getQuantity();
        if (quantity == 0) {
            return CartButtonState.Empty.INSTANCE;
        }
        if (quantity == this.stock) {
            more = new CartButtonState.NotEmpty.Full(setup.getQuantity(), false);
        } else if (quantity == 1) {
            return new CartButtonState.NotEmpty.One(false);
        } else {
            more = new CartButtonState.NotEmpty.More(setup.getQuantity(), false);
        }
        return more;
    }

    private final CartButtonState handleState(CartButtonEvent cartButtonEvent, CartButtonState cartButtonState) {
        if (Intrinsics.areEqual((Object) cartButtonEvent, (Object) CartButtonEvent.Add.INSTANCE)) {
            return handleAddAction(cartButtonState);
        }
        if (Intrinsics.areEqual((Object) cartButtonEvent, (Object) CartButtonEvent.Remove.INSTANCE)) {
            return handleRemoveAction(cartButtonState);
        }
        if (cartButtonEvent instanceof CartButtonEvent.Setup) {
            return handleSetupAction((CartButtonEvent.Setup) cartButtonEvent);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* access modifiers changed from: private */
    /* renamed from: stateObservable$lambda-0  reason: not valid java name */
    public static final CartButtonState m10051stateObservable$lambda0(AddToCartButtonViewModel addToCartButtonViewModel, CartButtonState cartButtonState, CartButtonEvent cartButtonEvent) {
        Intrinsics.checkNotNullParameter(addToCartButtonViewModel, "this$0");
        Intrinsics.checkNotNullParameter(cartButtonState, "state");
        Intrinsics.checkNotNullParameter(cartButtonEvent, "event");
        return addToCartButtonViewModel.handleState(cartButtonEvent, cartButtonState);
    }

    @NotNull
    public final Observable<Pair<Integer, Boolean>> getCurrentCount() {
        return this.currentCount;
    }

    @NotNull
    public final Observer<CartButtonEvent> getEventObserver() {
        return this.eventObserver;
    }

    @NotNull
    public final Observable<CartButtonState> getViewState() {
        return this.viewState;
    }
}
