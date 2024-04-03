package com.talabat.homescreen.orderstatus.presentation.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.homescreen.adapter.model.order_tracking.OrderTrackingItem;
import com.talabat.homescreen.orderstatus.domain.entity.OrderEntity;
import com.talabat.homescreen.orderstatus.domain.entity.OrderStatusEntity;
import com.talabat.homescreen.orderstatus.domain.usecase.business.ObserveOrderStatusesUseCase;
import com.talabat.homescreen.orderstatus.domain.usecase.business.TrackOrderStatusClickUseCase;
import com.talabat.homescreen.orderstatus.presentation.displaymodel.OrderStatus;
import com.talabat.homescreen.orderstatus.presentation.observability.OrderStatusUpdateTracker;
import com.talabat.homescreen.orderstatus.presentation.provider.StringProvider;
import com.talabat.homescreen.orderstatus.ui.OrderStatusView;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.SingleLiveEvent;
import com.talabat.talabatcore.logger.LogManager;
import hs.a;
import hs.b;
import hs.c;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0002J \u0010)\u001a\u0004\u0018\u00010\u00182\f\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u00172\u0006\u0010,\u001a\u00020\u0018H\u0002J\u0010\u0010-\u001a\u00020\u00142\u0006\u0010.\u001a\u00020\u001aH\u0002J\u0016\u0010/\u001a\u0002002\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0017H\u0002J \u00101\u001a\u00020\u00142\u0006\u0010'\u001a\u00020(2\u0006\u00102\u001a\u00020\u00142\u0006\u00103\u001a\u00020(H\u0002J\u0010\u00104\u001a\u0002002\u0006\u00105\u001a\u00020\u001aH\u0002J\u0010\u00106\u001a\u0002002\u0006\u00105\u001a\u00020\u001aH\u0002J\u0016\u00107\u001a\u0002002\f\u0010#\u001a\b\u0012\u0004\u0012\u00020+0\u0017H\u0002J\u0016\u00108\u001a\u0002002\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0017H\u0002J\u0014\u00109\u001a\u0002002\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0017J\u000e\u0010:\u001a\u0002002\u0006\u0010;\u001a\u00020\u0014J\u0006\u0010<\u001a\u000200J\u0006\u0010=\u001a\u000200J\u0010\u0010>\u001a\u00020?2\u0006\u0010.\u001a\u00020\u001aH\u0002J\u0010\u0010@\u001a\u00020A2\u0006\u0010.\u001a\u00020\u001aH\u0002J$\u0010B\u001a\u0002002\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\f\u0010#\u001a\b\u0012\u0004\u0012\u00020+0\u0017H\u0002J\u0010\u0010D\u001a\u0002002\u0006\u0010;\u001a\u00020\u0014H\u0002J\u0010\u0010E\u001a\u0002002\u0006\u0010.\u001a\u00020FH\u0002J\u0016\u0010G\u001a\u0002002\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0017H\u0002J\u0016\u0010H\u001a\u0002002\f\u0010#\u001a\b\u0012\u0004\u0012\u00020+0\u0017H\u0002J\u0014\u0010I\u001a\u00020\u0018*\u00020\u00182\u0006\u0010'\u001a\u00020+H\u0002J\f\u0010J\u001a\u00020\u0012*\u00020\u001aH\u0002R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0011X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u0016X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00120\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00140\u001e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R\u000e\u0010\b\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u001d\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u001e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010 R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lcom/talabat/homescreen/orderstatus/presentation/viewmodel/OrderStatusViewModel;", "", "observeOrderStatusesUseCase", "Lcom/talabat/homescreen/orderstatus/domain/usecase/business/ObserveOrderStatusesUseCase;", "trackOrderStatusClickUseCase", "Lcom/talabat/homescreen/orderstatus/domain/usecase/business/TrackOrderStatusClickUseCase;", "mainScheduler", "Lio/reactivex/Scheduler;", "ioScheduler", "stringProvider", "Lcom/talabat/homescreen/orderstatus/presentation/provider/StringProvider;", "orderStatusUpdateTracker", "Lcom/talabat/homescreen/orderstatus/presentation/observability/OrderStatusUpdateTracker;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "(Lcom/talabat/homescreen/orderstatus/domain/usecase/business/ObserveOrderStatusesUseCase;Lcom/talabat/homescreen/orderstatus/domain/usecase/business/TrackOrderStatusClickUseCase;Lio/reactivex/Scheduler;Lio/reactivex/Scheduler;Lcom/talabat/homescreen/orderstatus/presentation/provider/StringProvider;Lcom/talabat/homescreen/orderstatus/presentation/observability/OrderStatusUpdateTracker;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "_goToOrderConfirmation", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/SingleLiveEvent;", "Lcom/talabat/homescreen/adapter/model/order_tracking/OrderTrackingItem;", "_goToOrderReplacement", "", "_orderStatuses", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/talabat/homescreen/orderstatus/presentation/displaymodel/OrderStatus;", "cachedOrderStatus", "Lcom/talabat/homescreen/orderstatus/ui/OrderStatusView$OrderStatusData;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "goToOrderConfirmation", "Landroidx/lifecycle/LiveData;", "getGoToOrderConfirmation", "()Landroidx/lifecycle/LiveData;", "goToOrderReplacement", "getGoToOrderReplacement", "orderStatuses", "getOrderStatuses", "canShowAlert", "", "orderStatus", "", "createCopyWithNewStatusOrNull", "ordersStatuses", "Lcom/talabat/homescreen/orderstatus/domain/entity/OrderStatusEntity;", "shownOrder", "createStatus", "it", "display", "", "getChainNameWithOrderStatus", "chainName", "orderType", "goToOrderConfirmationScreen", "orderStatusData", "handleOrderConfirmation", "handleOrderStatusRefresh", "observeStatuses", "onBind", "onOrderStatusClick", "orderId", "onViewAttached", "onViewDetached", "toMultipleOrderStatus", "Lcom/talabat/homescreen/orderstatus/presentation/displaymodel/OrderStatus$Multiple;", "toSingleOrderStatus", "Lcom/talabat/homescreen/orderstatus/presentation/displaymodel/OrderStatus$Single;", "trackIfEmpty", "shownOrders", "trackOrderStatusDataNullFor", "trackOrderStatusObserveError", "", "trackStatusUpdateFromComponent", "trackStatusUpdateFromRefresh", "createCopyWithNewStatus", "toOrderTrackingItem", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderStatusViewModel {
    @NotNull
    private final SingleLiveEvent<OrderTrackingItem> _goToOrderConfirmation;
    @NotNull
    private final SingleLiveEvent<String> _goToOrderReplacement;
    @NotNull
    private final MutableLiveData<List<OrderStatus>> _orderStatuses;
    @NotNull
    private List<OrderStatusView.OrderStatusData> cachedOrderStatus;
    @NotNull
    private final CompositeDisposable compositeDisposable;
    @NotNull
    private final LiveData<OrderTrackingItem> goToOrderConfirmation;
    @NotNull
    private final LiveData<String> goToOrderReplacement;
    @NotNull
    private final Scheduler ioScheduler;
    @NotNull
    private final Scheduler mainScheduler;
    @NotNull
    private final IObservabilityManager observabilityManager;
    @NotNull
    private final ObserveOrderStatusesUseCase observeOrderStatusesUseCase;
    @NotNull
    private final OrderStatusUpdateTracker orderStatusUpdateTracker;
    @NotNull
    private final LiveData<List<OrderStatus>> orderStatuses;
    @NotNull
    private final StringProvider stringProvider;
    @NotNull
    private final TrackOrderStatusClickUseCase trackOrderStatusClickUseCase;

    public OrderStatusViewModel(@NotNull ObserveOrderStatusesUseCase observeOrderStatusesUseCase2, @NotNull TrackOrderStatusClickUseCase trackOrderStatusClickUseCase2, @NotNull Scheduler scheduler, @NotNull Scheduler scheduler2, @NotNull StringProvider stringProvider2, @NotNull OrderStatusUpdateTracker orderStatusUpdateTracker2, @NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(observeOrderStatusesUseCase2, "observeOrderStatusesUseCase");
        Intrinsics.checkNotNullParameter(trackOrderStatusClickUseCase2, "trackOrderStatusClickUseCase");
        Intrinsics.checkNotNullParameter(scheduler, "mainScheduler");
        Intrinsics.checkNotNullParameter(scheduler2, "ioScheduler");
        Intrinsics.checkNotNullParameter(stringProvider2, "stringProvider");
        Intrinsics.checkNotNullParameter(orderStatusUpdateTracker2, "orderStatusUpdateTracker");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        this.observeOrderStatusesUseCase = observeOrderStatusesUseCase2;
        this.trackOrderStatusClickUseCase = trackOrderStatusClickUseCase2;
        this.mainScheduler = scheduler;
        this.ioScheduler = scheduler2;
        this.stringProvider = stringProvider2;
        this.orderStatusUpdateTracker = orderStatusUpdateTracker2;
        this.observabilityManager = iObservabilityManager;
        MutableLiveData<List<OrderStatus>> mutableLiveData = new MutableLiveData<>();
        this._orderStatuses = mutableLiveData;
        SingleLiveEvent<OrderTrackingItem> singleLiveEvent = new SingleLiveEvent<>();
        this._goToOrderConfirmation = singleLiveEvent;
        SingleLiveEvent<String> singleLiveEvent2 = new SingleLiveEvent<>();
        this._goToOrderReplacement = singleLiveEvent2;
        this.orderStatuses = mutableLiveData;
        this.goToOrderConfirmation = singleLiveEvent;
        this.goToOrderReplacement = singleLiveEvent2;
        this.cachedOrderStatus = CollectionsKt__CollectionsKt.emptyList();
        this.compositeDisposable = new CompositeDisposable();
    }

    private final boolean canShowAlert(int i11) {
        return i11 == 6;
    }

    private final OrderStatus createCopyWithNewStatus(OrderStatus orderStatus, OrderStatusEntity orderStatusEntity) {
        String orderStatusDescription = this.stringProvider.getOrderStatusDescription(orderStatusEntity.getOrderStatus(), orderStatusEntity.isOrderSuccessful(), orderStatus.getOrderType());
        if (orderStatus instanceof OrderStatus.Multiple) {
            return new OrderStatus.Multiple(orderStatus.getOrderId(), orderStatus.getRestaurantName(), orderStatusDescription, orderStatus.getOrderType(), canShowAlert(orderStatusEntity.getOrderStatus()));
        }
        if (orderStatus instanceof OrderStatus.Single) {
            return new OrderStatus.Single(orderStatus.getOrderId(), orderStatus.getRestaurantName(), orderStatusDescription, orderStatus.getOrderType(), canShowAlert(orderStatusEntity.getOrderStatus()));
        }
        throw new NoWhenBranchMatchedException();
    }

    private final OrderStatus createCopyWithNewStatusOrNull(List<OrderStatusEntity> list, OrderStatus orderStatus) {
        Object obj;
        if (orderStatus.getOrderType() == 1) {
            return orderStatus;
        }
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) orderStatus.getOrderId(), (Object) String.valueOf(((OrderStatusEntity) obj).getOrderId()))) {
                break;
            }
        }
        OrderStatusEntity orderStatusEntity = (OrderStatusEntity) obj;
        if (orderStatusEntity != null) {
            return createCopyWithNewStatus(orderStatus, orderStatusEntity);
        }
        return null;
    }

    private final String createStatus(OrderStatusView.OrderStatusData orderStatusData) {
        return this.stringProvider.getOrderStatusDescription(orderStatusData.getOrderStatus(), orderStatusData.isOrderStatus(), orderStatusData.getOrderType());
    }

    private final void display(List<OrderStatusView.OrderStatusData> list) {
        ArrayList arrayList;
        if (list.size() == 1) {
            Iterable<OrderStatusView.OrderStatusData> iterable = list;
            arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
            for (OrderStatusView.OrderStatusData singleOrderStatus : iterable) {
                arrayList.add(toSingleOrderStatus(singleOrderStatus));
            }
        } else {
            Iterable<OrderStatusView.OrderStatusData> iterable2 = list;
            arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable2, 10));
            for (OrderStatusView.OrderStatusData multipleOrderStatus : iterable2) {
                arrayList.add(toMultipleOrderStatus(multipleOrderStatus));
            }
        }
        this._orderStatuses.postValue(arrayList);
    }

    private final String getChainNameWithOrderStatus(int i11, String str, int i12) {
        if (i11 == 6) {
            return this.stringProvider.getReplacement(str);
        }
        return this.stringProvider.getChainName(str, i12);
    }

    private final void goToOrderConfirmationScreen(OrderStatusView.OrderStatusData orderStatusData) {
        this._goToOrderConfirmation.postValue(toOrderTrackingItem(orderStatusData));
    }

    private final void handleOrderConfirmation(OrderStatusView.OrderStatusData orderStatusData) {
        goToOrderConfirmationScreen(orderStatusData);
        boolean z11 = true;
        if (orderStatusData.getOrderType() != 1) {
            z11 = false;
        }
        this.trackOrderStatusClickUseCase.trackOrderStatusClick(String.valueOf(orderStatusData.getOriginalOrderID()), orderStatusData.getChainId(), orderStatusData.getChainName(), z11);
    }

    /* access modifiers changed from: private */
    public final void handleOrderStatusRefresh(List<OrderStatusEntity> list) {
        List<OrderStatus> value = this._orderStatuses.getValue();
        if (value == null) {
            value = CollectionsKt__CollectionsKt.emptyList();
        }
        trackIfEmpty(value, list);
        trackStatusUpdateFromRefresh(list);
        ArrayList arrayList = new ArrayList();
        for (OrderStatus createCopyWithNewStatusOrNull : value) {
            OrderStatus createCopyWithNewStatusOrNull2 = createCopyWithNewStatusOrNull(list, createCopyWithNewStatusOrNull);
            if (createCopyWithNewStatusOrNull2 != null) {
                arrayList.add(createCopyWithNewStatusOrNull2);
            }
        }
        this._orderStatuses.postValue(arrayList);
    }

    private final void observeStatuses(List<OrderStatusView.OrderStatusData> list) {
        Iterable<OrderStatusView.OrderStatusData> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (OrderStatusView.OrderStatusData orderStatusData : iterable) {
            arrayList.add(new OrderEntity(orderStatusData.getEncryptedOrderId(), orderStatusData.getOrderType()));
        }
        CompositeDisposable compositeDisposable2 = this.compositeDisposable;
        Disposable subscribe = this.observeOrderStatusesUseCase.observeOrderStatuses(arrayList).subscribeOn(this.ioScheduler).observeOn(this.mainScheduler).doOnError(new a(this)).subscribe(new b(this), new c());
        Intrinsics.checkNotNullExpressionValue(subscribe, "observeOrderStatusesUseC…ception(it)\n            }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe);
    }

    /* access modifiers changed from: private */
    /* renamed from: observeStatuses$lambda-4  reason: not valid java name */
    public static final void m10651observeStatuses$lambda4(Throwable th2) {
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        LogManager.logException(th2);
    }

    private final OrderStatus.Multiple toMultipleOrderStatus(OrderStatusView.OrderStatusData orderStatusData) {
        return new OrderStatus.Multiple(String.valueOf(orderStatusData.getOriginalOrderID()), getChainNameWithOrderStatus(orderStatusData.getOrderStatus(), orderStatusData.getChainName(), orderStatusData.getOrderType()), this.stringProvider.getOrderStatusDescription(orderStatusData.getOrderStatus(), orderStatusData.isOrderStatus(), orderStatusData.getOrderType()), orderStatusData.getOrderType(), canShowAlert(orderStatusData.getOrderStatus()));
    }

    private final OrderTrackingItem toOrderTrackingItem(OrderStatusView.OrderStatusData orderStatusData) {
        return new OrderTrackingItem(String.valueOf(orderStatusData.getOriginalOrderID()), orderStatusData.getChainName(), "", String.valueOf(orderStatusData.getOrderStatus()), (String) null, 0.0d, 0.0d, 0.0d, 0.0d, (String) null, 0.0d, 0.0d, 0.0d, 0.0d, (String) null, (String) null, (String) null, orderStatusData.getOrderReceivedTime(), 0, false, 0.0d, orderStatusData.getEncryptedOrderId(), false, orderStatusData.isTracking(), orderStatusData.isPreOrder(), orderStatusData.isOrderStatus(), orderStatusData.getPreOrderDeliveryTime(), Boolean.valueOf(orderStatusData.isTalabatGo()));
    }

    private final OrderStatus.Single toSingleOrderStatus(OrderStatusView.OrderStatusData orderStatusData) {
        return new OrderStatus.Single(String.valueOf(orderStatusData.getOriginalOrderID()), getChainNameWithOrderStatus(orderStatusData.getOrderStatus(), orderStatusData.getChainName(), orderStatusData.getOrderType()), createStatus(orderStatusData), orderStatusData.getOrderType(), canShowAlert(orderStatusData.getOrderStatus()));
    }

    private final void trackIfEmpty(List<? extends OrderStatus> list, List<OrderStatusEntity> list2) {
        if (list.isEmpty()) {
            this.observabilityManager.trackUnExpectedScenario("HandleOrderStatusRefresh-EmptyShownOrders", MapsKt__MapsJVMKt.mapOf(TuplesKt.to("orderIds", CollectionsKt___CollectionsKt.joinToString$default(list2, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, OrderStatusViewModel$trackIfEmpty$1.INSTANCE, 31, (Object) null))));
        }
    }

    private final void trackOrderStatusDataNullFor(String str) {
        this.observabilityManager.trackUnExpectedScenario("OnOrderStatusClick-NullOrderStatus", MapsKt__MapsJVMKt.mapOf(TuplesKt.to("orderId", str)));
    }

    /* access modifiers changed from: private */
    public final void trackOrderStatusObserveError(Throwable th2) {
        IObservabilityManager iObservabilityManager = this.observabilityManager;
        String message = th2.getMessage();
        if (message == null) {
            message = "";
        }
        iObservabilityManager.trackUnExpectedScenario("OrderStatusViewModelObserveStatuses-Error", MapsKt__MapsJVMKt.mapOf(TuplesKt.to("errorMessage", message)));
    }

    private final void trackStatusUpdateFromComponent(List<OrderStatusView.OrderStatusData> list) {
        for (OrderStatusView.OrderStatusData orderStatusData : list) {
            this.orderStatusUpdateTracker.trackStatus(OrderStatusUpdateTracker.From.Component, orderStatusData.getOrderStatus(), String.valueOf(orderStatusData.getOriginalOrderID()), this.observabilityManager);
        }
    }

    private final void trackStatusUpdateFromRefresh(List<OrderStatusEntity> list) {
        for (OrderStatusEntity orderStatusEntity : list) {
            OrderStatusUpdateTracker.INSTANCE.trackStatus(OrderStatusUpdateTracker.From.Refresh, orderStatusEntity.getOrderStatus(), String.valueOf(orderStatusEntity.getOrderId()), this.observabilityManager);
        }
    }

    @NotNull
    public final LiveData<OrderTrackingItem> getGoToOrderConfirmation() {
        return this.goToOrderConfirmation;
    }

    @NotNull
    public final LiveData<String> getGoToOrderReplacement() {
        return this.goToOrderReplacement;
    }

    @NotNull
    public final LiveData<List<OrderStatus>> getOrderStatuses() {
        return this.orderStatuses;
    }

    public final void onBind(@NotNull List<OrderStatusView.OrderStatusData> list) {
        Intrinsics.checkNotNullParameter(list, "orderStatuses");
        if (!list.isEmpty()) {
            this.cachedOrderStatus = list;
            display(list);
            trackStatusUpdateFromComponent(list);
            observeStatuses(list);
        }
    }

    public final void onOrderStatusClick(@NotNull String str) {
        Object obj;
        Integer num;
        boolean z11;
        Intrinsics.checkNotNullParameter(str, "orderId");
        Iterator it = this.cachedOrderStatus.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            int originalOrderID = ((OrderStatusView.OrderStatusData) obj).getOriginalOrderID();
            try {
                Result.Companion companion = Result.Companion;
                num = Result.m6329constructorimpl(Integer.valueOf(Integer.parseInt(str)));
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                num = Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
            if (Result.m6335isFailureimpl(num)) {
                num = -1;
            }
            if (originalOrderID == ((Number) num).intValue()) {
                z11 = true;
                continue;
            } else {
                z11 = false;
                continue;
            }
            if (z11) {
                break;
            }
        }
        OrderStatusView.OrderStatusData orderStatusData = (OrderStatusView.OrderStatusData) obj;
        if (orderStatusData == null) {
            trackOrderStatusDataNullFor(str);
        } else if (orderStatusData.getOrderStatus() == 6) {
            this._goToOrderReplacement.postValue(str);
        } else {
            handleOrderConfirmation(orderStatusData);
        }
    }

    public final void onViewAttached() {
        if (!this.cachedOrderStatus.isEmpty()) {
            observeStatuses(this.cachedOrderStatus);
        }
    }

    public final void onViewDetached() {
        this.compositeDisposable.clear();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OrderStatusViewModel(ObserveOrderStatusesUseCase observeOrderStatusesUseCase2, TrackOrderStatusClickUseCase trackOrderStatusClickUseCase2, Scheduler scheduler, Scheduler scheduler2, StringProvider stringProvider2, OrderStatusUpdateTracker orderStatusUpdateTracker2, IObservabilityManager iObservabilityManager, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(observeOrderStatusesUseCase2, trackOrderStatusClickUseCase2, scheduler, scheduler2, stringProvider2, (i11 & 32) != 0 ? OrderStatusUpdateTracker.INSTANCE : orderStatusUpdateTracker2, iObservabilityManager);
    }
}
