package com.talabat.feature.darkstorescarrierbag.presentation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import com.talabat.feature.darkstorescarrierbag.domain.usecase.SendDarkstoresCarrierBagEvent;
import com.talabat.feature.darkstorescarrierbag.domain.usecase.SetDarkstoresCarrierBagFakeDoorTestShown;
import com.talabat.feature.darkstorescarrierbag.domain.usecase.ShouldShowDarkstoresCarrierBagFakeDoorTest;
import com.talabat.feature.darkstorescarrierbag.presentation.model.CarrierBagOption;
import com.talabat.feature.darkstorescarrierbag.presentation.model.DarkstoresCarrierBagEvent;
import com.talabat.observabilityNew.squads.nfv.ObservableAttributesNames;
import com.talabat.wrapper.EventWrapper;
import dm.g;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.DisposableKt;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u0017\u001a\u00020\u0018H\u0014J\u0006\u0010\u0019\u001a\u00020\u0018J\u000e\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u0018J\u000e\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cJ\u001a\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u000b2\b\b\u0002\u0010!\u001a\u00020\u000bH\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010X\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/talabat/feature/darkstorescarrierbag/presentation/DarkstoresCarrierBagViewModel;", "Landroidx/lifecycle/ViewModel;", "shouldShowDarkstoresCarrierBagFakeDoorTest", "Lcom/talabat/feature/darkstorescarrierbag/domain/usecase/ShouldShowDarkstoresCarrierBagFakeDoorTest;", "setDarkstoresCarrierBagFakeDoorTestShown", "Lcom/talabat/feature/darkstorescarrierbag/domain/usecase/SetDarkstoresCarrierBagFakeDoorTestShown;", "sendDarkstoresCarrierBagEvent", "Lcom/talabat/feature/darkstorescarrierbag/domain/usecase/SendDarkstoresCarrierBagEvent;", "rxSchedulersFactory", "Lcom/talabat/core/dispatcher/domain/RxSchedulersFactory;", "vendorCode", "", "(Lcom/talabat/feature/darkstorescarrierbag/domain/usecase/ShouldShowDarkstoresCarrierBagFakeDoorTest;Lcom/talabat/feature/darkstorescarrierbag/domain/usecase/SetDarkstoresCarrierBagFakeDoorTestShown;Lcom/talabat/feature/darkstorescarrierbag/domain/usecase/SendDarkstoresCarrierBagEvent;Lcom/talabat/core/dispatcher/domain/RxSchedulersFactory;Ljava/lang/String;)V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "eventLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/wrapper/EventWrapper;", "Lcom/talabat/feature/darkstorescarrierbag/presentation/model/DarkstoresCarrierBagEvent;", "events", "Landroidx/lifecycle/LiveData;", "getEvents", "()Landroidx/lifecycle/LiveData;", "onCleared", "", "onCloseClicked", "onContinueToCheckoutClicked", "selectedOption", "Lcom/talabat/feature/darkstorescarrierbag/presentation/model/CarrierBagOption;", "onInitialized", "onOptionSelected", "trackPopupEvent", "eventName", "popupButton", "com_talabat_feature_darkstores-carrier-bag_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DarkstoresCarrierBagViewModel extends ViewModel {
    @NotNull
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    @NotNull
    private MutableLiveData<EventWrapper<DarkstoresCarrierBagEvent>> eventLiveData = new MutableLiveData<>();
    @NotNull
    private final RxSchedulersFactory rxSchedulersFactory;
    @NotNull
    private final SendDarkstoresCarrierBagEvent sendDarkstoresCarrierBagEvent;
    @NotNull
    private final SetDarkstoresCarrierBagFakeDoorTestShown setDarkstoresCarrierBagFakeDoorTestShown;
    @NotNull
    private final ShouldShowDarkstoresCarrierBagFakeDoorTest shouldShowDarkstoresCarrierBagFakeDoorTest;
    @NotNull
    private final String vendorCode;

    @Inject
    public DarkstoresCarrierBagViewModel(@NotNull ShouldShowDarkstoresCarrierBagFakeDoorTest shouldShowDarkstoresCarrierBagFakeDoorTest2, @NotNull SetDarkstoresCarrierBagFakeDoorTestShown setDarkstoresCarrierBagFakeDoorTestShown2, @NotNull SendDarkstoresCarrierBagEvent sendDarkstoresCarrierBagEvent2, @NotNull RxSchedulersFactory rxSchedulersFactory2, @NotNull @Named("vendor_code") String str) {
        Intrinsics.checkNotNullParameter(shouldShowDarkstoresCarrierBagFakeDoorTest2, "shouldShowDarkstoresCarrierBagFakeDoorTest");
        Intrinsics.checkNotNullParameter(setDarkstoresCarrierBagFakeDoorTestShown2, "setDarkstoresCarrierBagFakeDoorTestShown");
        Intrinsics.checkNotNullParameter(sendDarkstoresCarrierBagEvent2, "sendDarkstoresCarrierBagEvent");
        Intrinsics.checkNotNullParameter(rxSchedulersFactory2, "rxSchedulersFactory");
        Intrinsics.checkNotNullParameter(str, ObservableAttributesNames.VENDOR_CODE);
        this.shouldShowDarkstoresCarrierBagFakeDoorTest = shouldShowDarkstoresCarrierBagFakeDoorTest2;
        this.setDarkstoresCarrierBagFakeDoorTestShown = setDarkstoresCarrierBagFakeDoorTestShown2;
        this.sendDarkstoresCarrierBagEvent = sendDarkstoresCarrierBagEvent2;
        this.rxSchedulersFactory = rxSchedulersFactory2;
        this.vendorCode = str;
    }

    public static /* synthetic */ void b(DarkstoresCarrierBagViewModel darkstoresCarrierBagViewModel, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = "NULL";
        }
        darkstoresCarrierBagViewModel.trackPopupEvent(str, str2);
    }

    /* access modifiers changed from: private */
    /* renamed from: onInitialized$lambda-0  reason: not valid java name */
    public static final void m10165onInitialized$lambda0(DarkstoresCarrierBagViewModel darkstoresCarrierBagViewModel, Boolean bool) {
        Intrinsics.checkNotNullParameter(darkstoresCarrierBagViewModel, "this$0");
        Intrinsics.checkNotNullExpressionValue(bool, "shouldShow");
        if (bool.booleanValue()) {
            darkstoresCarrierBagViewModel.eventLiveData.postValue(new EventWrapper(DarkstoresCarrierBagEvent.ShowBottomSheet.INSTANCE));
            b(darkstoresCarrierBagViewModel, "bottom_sheet_loaded", (String) null, 2, (Object) null);
            return;
        }
        darkstoresCarrierBagViewModel.eventLiveData.postValue(new EventWrapper(DarkstoresCarrierBagEvent.ContinueToCheckout.INSTANCE));
    }

    private final void trackPopupEvent(String str, String str2) {
        Disposable subscribe = this.sendDarkstoresCarrierBagEvent.invoke(str, this.vendorCode, str2).subscribeOn(this.rxSchedulersFactory.io()).subscribe();
        Intrinsics.checkNotNullExpressionValue(subscribe, "sendDarkstoresCarrierBag…\n            .subscribe()");
        DisposableKt.addTo(subscribe, this.compositeDisposable);
    }

    @NotNull
    public final LiveData<EventWrapper<DarkstoresCarrierBagEvent>> getEvents() {
        return this.eventLiveData;
    }

    public void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }

    public final void onCloseClicked() {
        this.eventLiveData.postValue(new EventWrapper(DarkstoresCarrierBagEvent.HideBottomSheet.INSTANCE));
        trackPopupEvent("bottom_sheet_closed", "clicked closed");
    }

    public final void onContinueToCheckoutClicked(@NotNull CarrierBagOption carrierBagOption) {
        Intrinsics.checkNotNullParameter(carrierBagOption, "selectedOption");
        this.eventLiveData.postValue(new EventWrapper(DarkstoresCarrierBagEvent.ContinueToCheckout.INSTANCE));
        Disposable subscribe = this.setDarkstoresCarrierBagFakeDoorTestShown.invoke(true).subscribeOn(this.rxSchedulersFactory.io()).subscribe();
        Intrinsics.checkNotNullExpressionValue(subscribe, "setDarkstoresCarrierBagF…\n            .subscribe()");
        DisposableKt.addTo(subscribe, this.compositeDisposable);
        trackPopupEvent("bottom_sheet_clicked", carrierBagOption.getValue());
    }

    public final void onInitialized() {
        Disposable subscribe = this.shouldShowDarkstoresCarrierBagFakeDoorTest.invoke().subscribeOn(this.rxSchedulersFactory.io()).subscribe(new g(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "shouldShowDarkstoresCarr…          }\n            }");
        DisposableKt.addTo(subscribe, this.compositeDisposable);
    }

    public final void onOptionSelected(@NotNull CarrierBagOption carrierBagOption) {
        Intrinsics.checkNotNullParameter(carrierBagOption, "selectedOption");
        this.eventLiveData.postValue(new EventWrapper(new DarkstoresCarrierBagEvent.OnOptionSelected(carrierBagOption)));
    }
}
