package com.talabat.darkstores.feature.cart.views;

import androidx.lifecycle.ViewModel;
import com.talabat.darkstores.feature.cart.model.CartCampaignProgressModel;
import com.talabat.darkstores.feature.cart.model.CartProgressCampaign;
import com.talabat.darkstores.feature.cart.model.ProgressCampaignType;
import com.talabat.darkstores.feature.cart.views.CartCampaignProgressState;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.rxkotlin.Observables;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00052\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020#0\"j\b\u0012\u0004\u0012\u00020#`$H\u0002J \u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\u00152\u0006\u0010(\u001a\u00020\u0005H\u0002J\u0010\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020#H\u0002J\u001a\u0010+\u001a\u0004\u0018\u00010#2\u0006\u0010 \u001a\u00020,2\u0006\u0010&\u001a\u00020\u0015H\u0002J \u0010-\u001a\u00020\u00192\u0006\u0010 \u001a\u00020#2\u0006\u0010&\u001a\u00020\u00152\u0006\u0010.\u001a\u00020\u0015H\u0002R>\u0010\u0003\u001a&\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005 \u0006*\u0012\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0010X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u001c\u0010\u0013\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0010X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u001c\u0010\u0017\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00150\u00150\u0010X\u0004¢\u0006\u0002\n\u0000R8\u0010\u0018\u001a&\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00190\u0019 \u0006*\u0012\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00190\u0019\u0018\u00010\u00040\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\bR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00150\f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000eR\u001c\u0010\u001d\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00150\u00150\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/talabat/darkstores/feature/cart/views/CartProgressViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "allCampaignInfoSubject", "Lio/reactivex/Observable;", "Lcom/talabat/darkstores/feature/cart/model/CartCampaignProgressModel;", "kotlin.jvm.PlatformType", "getAllCampaignInfoSubject", "()Lio/reactivex/Observable;", "setAllCampaignInfoSubject", "(Lio/reactivex/Observable;)V", "basketCampaignInfoObserver", "Lio/reactivex/Observer;", "getBasketCampaignInfoObserver", "()Lio/reactivex/Observer;", "basketCampaignInfoSubject", "Lio/reactivex/subjects/PublishSubject;", "campaignInfoObserver", "getCampaignInfoObserver", "campaignInfoSubject", "movInfoObserver", "", "getMovInfoObserver", "movInfoSubject", "stateObservable", "Lcom/talabat/darkstores/feature/cart/views/CartCampaignProgressState;", "getStateObservable$com_talabat_NewArchi_darkstores_darkstores", "totalChangedObserver", "getTotalChangedObserver", "totalChangedSubject", "addCampaigns", "", "model", "allCampaigns", "Ljava/util/ArrayList;", "Lcom/talabat/darkstores/feature/cart/model/CartProgressCampaign;", "Lkotlin/collections/ArrayList;", "createState", "total", "mov", "campaignModel", "getCelebrationCampaignState", "lastCampaign", "getFirstTargetCampaign", "Lcom/talabat/darkstores/feature/cart/model/CartCampaignProgressModel$Populated;", "getTargetedCampaignState", "threshold", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CartProgressViewModel extends ViewModel {
    private Observable<CartCampaignProgressModel> allCampaignInfoSubject;
    @NotNull
    private final Observer<CartCampaignProgressModel> basketCampaignInfoObserver;
    @NotNull
    private final PublishSubject<CartCampaignProgressModel> basketCampaignInfoSubject;
    @NotNull
    private final Observer<CartCampaignProgressModel> campaignInfoObserver;
    @NotNull
    private final PublishSubject<CartCampaignProgressModel> campaignInfoSubject;
    @NotNull
    private final Observer<Float> movInfoObserver;
    @NotNull
    private final PublishSubject<Float> movInfoSubject;
    private final Observable<CartCampaignProgressState> stateObservable;
    @NotNull
    private final Observer<Float> totalChangedObserver;
    @NotNull
    private final PublishSubject<Float> totalChangedSubject;

    public CartProgressViewModel() {
        PublishSubject<CartCampaignProgressModel> create = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "create<CartCampaignProgressModel>()");
        this.campaignInfoSubject = create;
        PublishSubject<CartCampaignProgressModel> create2 = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create2, "create<CartCampaignProgressModel>()");
        this.basketCampaignInfoSubject = create2;
        PublishSubject<Float> create3 = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create3, "create<Float>()");
        this.movInfoSubject = create3;
        PublishSubject<Float> create4 = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create4, "create<Float>()");
        this.totalChangedSubject = create4;
        Observables observables = Observables.INSTANCE;
        Observable<CartCampaignProgressModel> distinctUntilChanged = create.distinctUntilChanged();
        CartCampaignProgressModel.Initial initial = CartCampaignProgressModel.Initial.INSTANCE;
        Observable<CartCampaignProgressModel> startWith = distinctUntilChanged.startWith(initial);
        Intrinsics.checkNotNullExpressionValue(startWith, "campaignInfoSubject.dist…ignProgressModel.Initial)");
        Observable<CartCampaignProgressModel> startWith2 = create2.distinctUntilChanged().startWith(initial);
        Intrinsics.checkNotNullExpressionValue(startWith2, "basketCampaignInfoSubjec…ignProgressModel.Initial)");
        Observable<R> combineLatest = Observable.combineLatest(startWith, startWith2, new CartProgressViewModel$special$$inlined$combineLatest$1(this));
        Intrinsics.checkExpressionValueIsNotNull(combineLatest, "Observable.combineLatest…ombineFunction(t1, t2) })");
        Observable<R> distinctUntilChanged2 = combineLatest.distinctUntilChanged();
        this.allCampaignInfoSubject = distinctUntilChanged2;
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged2, "allCampaignInfoSubject");
        Observable<R> combineLatest2 = Observable.combineLatest(create4, create3, distinctUntilChanged2, new CartProgressViewModel$special$$inlined$combineLatest$2(this));
        Intrinsics.checkExpressionValueIsNotNull(combineLatest2, "Observable.combineLatest…neFunction(t1, t2, t3) })");
        this.stateObservable = combineLatest2.distinctUntilChanged();
        this.campaignInfoObserver = create;
        this.basketCampaignInfoObserver = create2;
        this.totalChangedObserver = create4;
        this.movInfoObserver = create3;
    }

    /* access modifiers changed from: private */
    public final void addCampaigns(CartCampaignProgressModel cartCampaignProgressModel, ArrayList<CartProgressCampaign> arrayList) {
        if (cartCampaignProgressModel instanceof CartCampaignProgressModel.Populated) {
            arrayList.addAll(((CartCampaignProgressModel.Populated) cartCampaignProgressModel).getCampaigns());
        }
    }

    /* access modifiers changed from: private */
    public final CartCampaignProgressState createState(float f11, float f12, CartCampaignProgressModel cartCampaignProgressModel) {
        Float totalTriggerThreshold;
        CartCampaignProgressState cartCampaignProgressState = CartCampaignProgressState.Hidden.INSTANCE;
        if (f11 < f12) {
            return new CartCampaignProgressState.Mov(f11, f12);
        }
        if (!(cartCampaignProgressModel instanceof CartCampaignProgressModel.Populated)) {
            return cartCampaignProgressState;
        }
        CartCampaignProgressModel.Populated populated = (CartCampaignProgressModel.Populated) cartCampaignProgressModel;
        CartProgressCampaign firstTargetCampaign = getFirstTargetCampaign(populated, f11);
        if (!(firstTargetCampaign == null || (totalTriggerThreshold = firstTargetCampaign.getCampaign().getTotalTriggerThreshold()) == null)) {
            cartCampaignProgressState = getTargetedCampaignState(firstTargetCampaign, f11, totalTriggerThreshold.floatValue());
        }
        if (firstTargetCampaign != null || !(!populated.getCampaigns().isEmpty())) {
            return cartCampaignProgressState;
        }
        CartProgressCampaign cartProgressCampaign = (CartProgressCampaign) CollectionsKt___CollectionsKt.last(populated.getCampaigns());
        Float totalTriggerThreshold2 = cartProgressCampaign.getCampaign().getTotalTriggerThreshold();
        if (totalTriggerThreshold2 == null) {
            return cartCampaignProgressState;
        }
        totalTriggerThreshold2.floatValue();
        return getCelebrationCampaignState(cartProgressCampaign);
    }

    private final CartCampaignProgressState getCelebrationCampaignState(CartProgressCampaign cartProgressCampaign) {
        if (cartProgressCampaign.getProgressCampaignType() == ProgressCampaignType.DeliveryFee) {
            return new CartCampaignProgressState.DeliveryFeeFulfilled(cartProgressCampaign.getCampaign());
        }
        return new CartCampaignProgressState.BasketFulfilled(cartProgressCampaign.getCampaign());
    }

    private final CartProgressCampaign getFirstTargetCampaign(CartCampaignProgressModel.Populated populated, float f11) {
        Object obj;
        Iterator it = populated.getCampaigns().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            Float totalTriggerThreshold = ((CartProgressCampaign) obj).getCampaign().getTotalTriggerThreshold();
            boolean z11 = false;
            if (totalTriggerThreshold != null && f11 < totalTriggerThreshold.floatValue()) {
                z11 = true;
                continue;
            }
            if (z11) {
                break;
            }
        }
        return (CartProgressCampaign) obj;
    }

    private final CartCampaignProgressState getTargetedCampaignState(CartProgressCampaign cartProgressCampaign, float f11, float f12) {
        if (cartProgressCampaign.getProgressCampaignType() == ProgressCampaignType.DeliveryFee) {
            return new CartCampaignProgressState.DeliveryFee(f11, f12, cartProgressCampaign.getCampaign());
        }
        return new CartCampaignProgressState.Basket(f11, f12, cartProgressCampaign.getCampaign());
    }

    public final Observable<CartCampaignProgressModel> getAllCampaignInfoSubject() {
        return this.allCampaignInfoSubject;
    }

    @NotNull
    public final Observer<CartCampaignProgressModel> getBasketCampaignInfoObserver() {
        return this.basketCampaignInfoObserver;
    }

    @NotNull
    public final Observer<CartCampaignProgressModel> getCampaignInfoObserver() {
        return this.campaignInfoObserver;
    }

    @NotNull
    public final Observer<Float> getMovInfoObserver() {
        return this.movInfoObserver;
    }

    public final Observable<CartCampaignProgressState> getStateObservable$com_talabat_NewArchi_darkstores_darkstores() {
        return this.stateObservable;
    }

    @NotNull
    public final Observer<Float> getTotalChangedObserver() {
        return this.totalChangedObserver;
    }

    public final void setAllCampaignInfoSubject(Observable<CartCampaignProgressModel> observable) {
        this.allCampaignInfoSubject = observable;
    }
}
