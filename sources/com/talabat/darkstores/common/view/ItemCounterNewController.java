package com.talabat.darkstores.common.view;

import androidx.annotation.VisibleForTesting;
import ci.j;
import ci.k;
import ci.l;
import com.facebook.internal.NativeProtocol;
import com.talabat.darkstores.common.view.ItemCounterAction;
import com.talabat.darkstores.common.view.ItemCounterState;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 +2\u00020\u0001:\u0001+B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0018\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0007H\u0002J\u0010\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010 \u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010!\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020#H\u0002J\u0006\u0010$\u001a\u00020\u001aJ\u0006\u0010%\u001a\u00020\u001aJ(\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u000b2\b\b\u0002\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u000bR\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\nX\u0004¢\u0006\u0002\n\u0000R#\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00120\u00110\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u000e\u0010\u0014\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R2\u0010\u0015\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00160\u0016 \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00160\u0016\u0018\u00010\n0\nX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\r¨\u0006,"}, d2 = {"Lcom/talabat/darkstores/common/view/ItemCounterNewController;", "", "uiScheduler", "Lio/reactivex/Scheduler;", "(Lio/reactivex/Scheduler;)V", "actionSubject", "Lio/reactivex/subjects/PublishSubject;", "Lcom/talabat/darkstores/common/view/ItemCounterAction;", "kotlin.jvm.PlatformType", "productQuantityState", "Lio/reactivex/Observable;", "", "getProductQuantityState", "()Lio/reactivex/Observable;", "productState", "Lcom/talabat/darkstores/common/view/ProductState;", "productStateForTrackingEvents", "Lkotlin/Pair;", "", "getProductStateForTrackingEvents", "shouldCollapse", "state", "Lcom/talabat/darkstores/common/view/ItemCounterState;", "viewState", "getViewState", "add", "", "handleAction", "action", "handleAddAction", "handleCloseAction", "handleOpenAction", "handleRemoveAction", "handleSetupAction", "setupAction", "Lcom/talabat/darkstores/common/view/ItemCounterAction$Setup;", "open", "remove", "setup", "quantity", "stock", "collapse", "freeCount", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ItemCounterNewController {
    private static final long CART_UPDATE_DELAY = 300;
    public static final long COLLAPSE_DELAY = 4000;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final PublishSubject<ItemCounterAction> actionSubject;
    @NotNull
    private final Observable<Integer> productQuantityState;
    @NotNull
    private final Observable<ProductState> productState;
    @NotNull
    private final Observable<Pair<Integer, Boolean>> productStateForTrackingEvents;
    private boolean shouldCollapse = true;
    private final Observable<ItemCounterState> state;
    @NotNull
    private final Observable<ItemCounterState> viewState;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u00020\u00048\u0006XT¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0002¨\u0006\u0007"}, d2 = {"Lcom/talabat/darkstores/common/view/ItemCounterNewController$Companion;", "", "()V", "CART_UPDATE_DELAY", "", "COLLAPSE_DELAY", "getCOLLAPSE_DELAY$annotations", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @VisibleForTesting
        public static /* synthetic */ void getCOLLAPSE_DELAY$annotations() {
        }
    }

    public ItemCounterNewController(@NotNull Scheduler scheduler) {
        Intrinsics.checkNotNullParameter(scheduler, "uiScheduler");
        PublishSubject<ItemCounterAction> create = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "create<ItemCounterAction>()");
        this.actionSubject = create;
        Observable<R> switchMap = create.switchMap(new j(this, scheduler));
        ItemCounterState.Invisible invisible = ItemCounterState.Invisible.INSTANCE;
        Observable<R> share = switchMap.scan(invisible, new k(this)).onErrorReturnItem(invisible).share();
        this.state = share;
        Observable<R> distinctUntilChanged = share.distinctUntilChanged();
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "state\n        .distinctUntilChanged()");
        this.viewState = distinctUntilChanged;
        Observable<R> share2 = share.map(new l()).filter(new a()).distinctUntilChanged().skip(1).debounce(CART_UPDATE_DELAY, TimeUnit.MILLISECONDS, scheduler).share();
        Intrinsics.checkNotNullExpressionValue(share2, "state\n        .map { Pro…heduler)\n        .share()");
        this.productState = share2;
        Observable<R> map = share2.filter(new b()).map(new c());
        Intrinsics.checkNotNullExpressionValue(map, "productState\n        .fi….quantity, it.isRemove) }");
        this.productStateForTrackingEvents = map;
        Observable<R> map2 = share2.map(new d());
        Intrinsics.checkNotNullExpressionValue(map2, "productState\n        .map { it.quantity }");
        this.productQuantityState = map2;
    }

    /* access modifiers changed from: private */
    public final ItemCounterState handleAction(ItemCounterState itemCounterState, ItemCounterAction itemCounterAction) {
        if (itemCounterAction instanceof ItemCounterAction.Setup) {
            return handleSetupAction(itemCounterState, (ItemCounterAction.Setup) itemCounterAction);
        }
        if (Intrinsics.areEqual((Object) itemCounterAction, (Object) ItemCounterAction.Add.INSTANCE)) {
            return handleAddAction(itemCounterState);
        }
        if (Intrinsics.areEqual((Object) itemCounterAction, (Object) ItemCounterAction.Remove.INSTANCE)) {
            return handleRemoveAction(itemCounterState);
        }
        if (Intrinsics.areEqual((Object) itemCounterAction, (Object) ItemCounterAction.Close.INSTANCE)) {
            return handleCloseAction(itemCounterState);
        }
        if (Intrinsics.areEqual((Object) itemCounterAction, (Object) ItemCounterAction.Open.INSTANCE)) {
            return handleOpenAction(itemCounterState);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final ItemCounterState handleAddAction(ItemCounterState itemCounterState) {
        if (itemCounterState instanceof ItemCounterState.Empty) {
            return new ItemCounterState.Expanded.One(itemCounterState.getStock(), itemCounterState.getFreeCount(), false, false, 12, (DefaultConstructorMarker) null);
        }
        if (itemCounterState instanceof ItemCounterState.Expanded.One) {
            return new ItemCounterState.Expanded.More(2, itemCounterState.getStock(), itemCounterState.getFreeCount(), false, false, 24, (DefaultConstructorMarker) null);
        }
        if (itemCounterState instanceof ItemCounterState.Expanded.More) {
            return new ItemCounterState.Expanded.More(itemCounterState.getQuantity() + 1, itemCounterState.getStock(), itemCounterState.getFreeCount(), false, false, 24, (DefaultConstructorMarker) null);
        }
        throw new UnsupportedOperationException("This action does not exist");
    }

    private final ItemCounterState handleCloseAction(ItemCounterState itemCounterState) {
        boolean z11;
        if (itemCounterState instanceof ItemCounterState.Expanded.One) {
            z11 = true;
        } else {
            z11 = itemCounterState instanceof ItemCounterState.Expanded.More;
        }
        if (z11) {
            return new ItemCounterState.Collapsed(itemCounterState.getQuantity(), itemCounterState.getStock(), itemCounterState.getFreeCount(), false, false, 24, (DefaultConstructorMarker) null);
        }
        return itemCounterState;
    }

    /* JADX WARNING: type inference failed for: r0v2 */
    /* JADX WARNING: type inference failed for: r1v1, types: [com.talabat.darkstores.common.view.ItemCounterState$Expanded$More] */
    /* JADX WARNING: type inference failed for: r3v2, types: [com.talabat.darkstores.common.view.ItemCounterState$Expanded$One] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.talabat.darkstores.common.view.ItemCounterState handleOpenAction(com.talabat.darkstores.common.view.ItemCounterState r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.talabat.darkstores.common.view.ItemCounterState.Collapsed
            if (r0 == 0) goto L_0x0033
            int r2 = r11.getQuantity()
            r0 = 1
            if (r2 != r0) goto L_0x001f
            com.talabat.darkstores.common.view.ItemCounterState$Expanded$One r0 = new com.talabat.darkstores.common.view.ItemCounterState$Expanded$One
            int r4 = r11.getStock()
            int r5 = r11.getFreeCount()
            r6 = 0
            r7 = 0
            r8 = 12
            r9 = 0
            r3 = r0
            r3.<init>(r4, r5, r6, r7, r8, r9)
            goto L_0x0032
        L_0x001f:
            com.talabat.darkstores.common.view.ItemCounterState$Expanded$More r0 = new com.talabat.darkstores.common.view.ItemCounterState$Expanded$More
            int r3 = r11.getStock()
            int r4 = r11.getFreeCount()
            r5 = 0
            r6 = 0
            r7 = 24
            r8 = 0
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
        L_0x0032:
            r11 = r0
        L_0x0033:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.common.view.ItemCounterNewController.handleOpenAction(com.talabat.darkstores.common.view.ItemCounterState):com.talabat.darkstores.common.view.ItemCounterState");
    }

    private final ItemCounterState handleRemoveAction(ItemCounterState itemCounterState) {
        ItemCounterState itemCounterState2 = itemCounterState;
        if (itemCounterState2 instanceof ItemCounterState.Empty) {
            throw new UnsupportedOperationException("This action does not exist");
        } else if (itemCounterState2 instanceof ItemCounterState.Expanded.One) {
            return new ItemCounterState.Empty(itemCounterState.getStock(), itemCounterState.getFreeCount(), true, false, 8, (DefaultConstructorMarker) null);
        } else {
            if (!(itemCounterState2 instanceof ItemCounterState.Expanded.More)) {
                throw new UnsupportedOperationException("This action does not exist");
            } else if (itemCounterState.getQuantity() == 2) {
                return new ItemCounterState.Expanded.One(itemCounterState.getStock(), itemCounterState.getFreeCount(), true, false, 8, (DefaultConstructorMarker) null);
            } else {
                return new ItemCounterState.Expanded.More(itemCounterState.getQuantity() - 1, itemCounterState.getStock(), itemCounterState.getFreeCount(), true, false, 16, (DefaultConstructorMarker) null);
            }
        }
    }

    /* JADX WARNING: type inference failed for: r0v7, types: [com.talabat.darkstores.common.view.ItemCounterState$Invisible] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.talabat.darkstores.common.view.ItemCounterState handleSetupAction(com.talabat.darkstores.common.view.ItemCounterState r21, com.talabat.darkstores.common.view.ItemCounterAction.Setup r22) {
        /*
            r20 = this;
            int r0 = r22.getStock()
            r1 = 1
            if (r0 >= r1) goto L_0x000d
            com.talabat.darkstores.common.view.ItemCounterState$Invisible r0 = com.talabat.darkstores.common.view.ItemCounterState.Invisible.INSTANCE
        L_0x0009:
            r3 = r20
            goto L_0x007b
        L_0x000d:
            int r0 = r22.getQuantity()
            r2 = r21
            boolean r2 = r2 instanceof com.talabat.darkstores.common.view.ItemCounterState.Expanded
            r2 = r2 ^ r1
            if (r0 != 0) goto L_0x002b
            com.talabat.darkstores.common.view.ItemCounterState$Empty r0 = new com.talabat.darkstores.common.view.ItemCounterState$Empty
            int r4 = r22.getStock()
            int r5 = r22.getFreeCount()
            r6 = 0
            r7 = 1
            r8 = 4
            r9 = 0
            r3 = r0
            r3.<init>(r4, r5, r6, r7, r8, r9)
            goto L_0x0009
        L_0x002b:
            r3 = r20
            boolean r4 = r3.shouldCollapse
            if (r4 == 0) goto L_0x004b
            if (r2 == 0) goto L_0x004b
            com.talabat.darkstores.common.view.ItemCounterState$Collapsed r0 = new com.talabat.darkstores.common.view.ItemCounterState$Collapsed
            int r6 = r22.getQuantity()
            int r7 = r22.getStock()
            int r8 = r22.getFreeCount()
            r9 = 0
            r10 = 1
            r11 = 8
            r12 = 0
            r5 = r0
            r5.<init>(r6, r7, r8, r9, r10, r11, r12)
            goto L_0x007b
        L_0x004b:
            if (r0 != r1) goto L_0x0064
            com.talabat.darkstores.common.view.ItemCounterState$Expanded$One r0 = new com.talabat.darkstores.common.view.ItemCounterState$Expanded$One
            int r14 = r22.getStock()
            int r15 = r22.getFreeCount()
            r16 = 0
            r17 = 1
            r18 = 4
            r19 = 0
            r13 = r0
            r13.<init>(r14, r15, r16, r17, r18, r19)
            goto L_0x007b
        L_0x0064:
            com.talabat.darkstores.common.view.ItemCounterState$Expanded$More r0 = new com.talabat.darkstores.common.view.ItemCounterState$Expanded$More
            int r5 = r22.getQuantity()
            int r6 = r22.getStock()
            int r7 = r22.getFreeCount()
            r8 = 0
            r9 = 1
            r10 = 8
            r11 = 0
            r4 = r0
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)
        L_0x007b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.common.view.ItemCounterNewController.handleSetupAction(com.talabat.darkstores.common.view.ItemCounterState, com.talabat.darkstores.common.view.ItemCounterAction$Setup):com.talabat.darkstores.common.view.ItemCounterState");
    }

    /* access modifiers changed from: private */
    /* renamed from: productQuantityState$lambda-5  reason: not valid java name */
    public static final Integer m9647productQuantityState$lambda5(ProductState productState2) {
        Intrinsics.checkNotNullParameter(productState2, "it");
        return Integer.valueOf(productState2.getQuantity());
    }

    /* access modifiers changed from: private */
    /* renamed from: productState$lambda-1  reason: not valid java name */
    public static final ProductState m9648productState$lambda1(ItemCounterState itemCounterState) {
        Intrinsics.checkNotNullParameter(itemCounterState, "it");
        return new ProductState(itemCounterState.getQuantity(), itemCounterState.isRemove(), itemCounterState.isSetUp());
    }

    /* access modifiers changed from: private */
    /* renamed from: productState$lambda-2  reason: not valid java name */
    public static final boolean m9649productState$lambda2(ProductState productState2) {
        Intrinsics.checkNotNullParameter(productState2, "<name for destructuring parameter 0>");
        if (productState2.component1() >= 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: productStateForTrackingEvents$lambda-3  reason: not valid java name */
    public static final boolean m9650productStateForTrackingEvents$lambda3(ProductState productState2) {
        Intrinsics.checkNotNullParameter(productState2, "it");
        return !productState2.isSetUp();
    }

    /* access modifiers changed from: private */
    /* renamed from: productStateForTrackingEvents$lambda-4  reason: not valid java name */
    public static final Pair m9651productStateForTrackingEvents$lambda4(ProductState productState2) {
        Intrinsics.checkNotNullParameter(productState2, "it");
        return new Pair(Integer.valueOf(productState2.getQuantity()), Boolean.valueOf(productState2.isRemove()));
    }

    public static /* synthetic */ void setup$default(ItemCounterNewController itemCounterNewController, int i11, int i12, boolean z11, int i13, int i14, Object obj) {
        if ((i14 & 4) != 0) {
            z11 = true;
        }
        itemCounterNewController.setup(i11, i12, z11, i13);
    }

    /* access modifiers changed from: private */
    /* renamed from: state$lambda-0  reason: not valid java name */
    public static final ObservableSource m9652state$lambda0(ItemCounterNewController itemCounterNewController, Scheduler scheduler, ItemCounterAction itemCounterAction) {
        Intrinsics.checkNotNullParameter(itemCounterNewController, "this$0");
        Intrinsics.checkNotNullParameter(scheduler, "$uiScheduler");
        Intrinsics.checkNotNullParameter(itemCounterAction, NativeProtocol.WEB_DIALOG_ACTION);
        if (itemCounterNewController.shouldCollapse) {
            return Observable.just(ItemCounterAction.Close.INSTANCE).delay(4000, TimeUnit.MILLISECONDS, scheduler).startWith(itemCounterAction);
        }
        return Observable.just(itemCounterAction);
    }

    public final void add() {
        this.actionSubject.onNext(ItemCounterAction.Add.INSTANCE);
    }

    @NotNull
    public final Observable<Integer> getProductQuantityState() {
        return this.productQuantityState;
    }

    @NotNull
    public final Observable<Pair<Integer, Boolean>> getProductStateForTrackingEvents() {
        return this.productStateForTrackingEvents;
    }

    @NotNull
    public final Observable<ItemCounterState> getViewState() {
        return this.viewState;
    }

    public final void open() {
        this.actionSubject.onNext(ItemCounterAction.Open.INSTANCE);
    }

    public final void remove() {
        this.actionSubject.onNext(ItemCounterAction.Remove.INSTANCE);
    }

    public final void setup(int i11, int i12, boolean z11, int i13) {
        this.shouldCollapse = z11;
        this.actionSubject.onNext(new ItemCounterAction.Setup(i11, i12, i13));
    }
}
