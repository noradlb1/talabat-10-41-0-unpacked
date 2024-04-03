package com.talabat.offering.presentation.viewmodel;

import JsonModels.PolygonEvents;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.offering.domain.usecases.business.GetOfferCollectionUseCase;
import com.talabat.offering.domain.usecases.business.GetUserIsOfferCollectionSubscribedUseCase;
import com.talabat.offering.domain.usecases.business.SendMobileOTPUseCase;
import com.talabat.offering.domain.usecases.business.TrackShopClickedUseCase;
import com.talabat.offering.domain.usecases.business.TrackShopListUpdatedUseCase;
import com.talabat.offering.domain.usecases.business.TrackSubscriptionVerificationUseCase;
import com.talabat.offering.domain.usecases.business.VerifyOTPSubscriptionUseCase;
import com.talabat.offering.presentation.displaymodel.HeaderDisplayModel;
import com.talabat.offering.presentation.displaymodel.OTPDisplayModel;
import com.talabat.offering.presentation.displaymodel.PopupDisplayModel;
import com.talabat.offering.presentation.displaymodel.UserSubscriptionDisplayModel;
import com.talabat.offering.presentation.displaymodel.VendorsDisplayModel;
import datamodels.QuickFilter;
import datamodels.Restaurant;
import datamodels.RestaurantListModel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.ShopClickedEvent;

@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u000e\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u000200J\u001e\u0010@\u001a\u00020>2\u0006\u0010A\u001a\u00020\u001d2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020CJ \u0010E\u001a\u00020>2\u0006\u0010F\u001a\u0002002\b\u0010G\u001a\u0004\u0018\u0001002\u0006\u0010H\u001a\u00020IJ\u0016\u0010J\u001a\u00020>2\u0006\u0010F\u001a\u0002002\u0006\u0010H\u001a\u00020IJ\u000e\u0010K\u001a\u00020>2\u0006\u0010L\u001a\u00020MJ\u0006\u0010N\u001a\u00020>J\u000e\u0010O\u001a\u00020>2\u0006\u0010P\u001a\u000200J\u0006\u0010Q\u001a\u00020>J\u0006\u0010R\u001a\u00020>J\u000e\u0010S\u001a\u00020>2\u0006\u0010T\u001a\u000200J\u0006\u0010U\u001a\u00020>J\u0006\u0010V\u001a\u00020>J\u0006\u0010W\u001a\u00020>J\u0006\u0010X\u001a\u00020>J\u000e\u0010Y\u001a\u00020>2\u0006\u0010Z\u001a\u000206J\u000e\u0010[\u001a\u00020>2\u0006\u0010\\\u001a\u000200R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u0012¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0015R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u0012¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0015R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020#0\u0012¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0015R'\u0010'\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010)\u0012\u0006\u0012\u0004\u0018\u00010*0(0\u0012¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0015R\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u0012¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0015R\u0017\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u0012¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0015R\u0017\u00102\u001a\b\u0012\u0004\u0012\u0002030\u0012¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0015R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0017\u00105\u001a\b\u0012\u0004\u0012\u0002060\u0012¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u0015R\u0017\u00108\u001a\b\u0012\u0004\u0012\u0002060\u0012¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u0015R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010:\u001a\b\u0012\u0004\u0012\u00020;0\u0012¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u0015R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006]"}, d2 = {"Lcom/talabat/offering/presentation/viewmodel/OfferCollectionViewModel;", "Landroidx/lifecycle/ViewModel;", "offerCollectionUseCase", "Lcom/talabat/offering/domain/usecases/business/GetOfferCollectionUseCase;", "userIsOfferCollectionSubscribedUseCase", "Lcom/talabat/offering/domain/usecases/business/GetUserIsOfferCollectionSubscribedUseCase;", "sendMobileOTPUseCase", "Lcom/talabat/offering/domain/usecases/business/SendMobileOTPUseCase;", "verifyOTPSubscriptionUseCase", "Lcom/talabat/offering/domain/usecases/business/VerifyOTPSubscriptionUseCase;", "trackShopClickedUseCase", "Lcom/talabat/offering/domain/usecases/business/TrackShopClickedUseCase;", "trackShopListUpdatedUseCase", "Lcom/talabat/offering/domain/usecases/business/TrackShopListUpdatedUseCase;", "trackSubscriptionVerificationUseCase", "Lcom/talabat/offering/domain/usecases/business/TrackSubscriptionVerificationUseCase;", "(Lcom/talabat/offering/domain/usecases/business/GetOfferCollectionUseCase;Lcom/talabat/offering/domain/usecases/business/GetUserIsOfferCollectionSubscribedUseCase;Lcom/talabat/offering/domain/usecases/business/SendMobileOTPUseCase;Lcom/talabat/offering/domain/usecases/business/VerifyOTPSubscriptionUseCase;Lcom/talabat/offering/domain/usecases/business/TrackShopClickedUseCase;Lcom/talabat/offering/domain/usecases/business/TrackShopListUpdatedUseCase;Lcom/talabat/offering/domain/usecases/business/TrackSubscriptionVerificationUseCase;)V", "backgroundData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/offering/presentation/displaymodel/HeaderDisplayModel;", "getBackgroundData", "()Landroidx/lifecycle/MutableLiveData;", "eventOriginSource", "Ltracking/ShopClickedEvent$EventOriginSourceDelegate;", "getEventOriginSource", "()Ltracking/ShopClickedEvent$EventOriginSourceDelegate;", "headerViewData", "getHeaderViewData", "headerViewState", "", "getHeaderViewState", "offerSubscribed", "Lcom/talabat/offering/presentation/displaymodel/UserSubscriptionDisplayModel;", "getOfferSubscribed", "otpData", "Lcom/talabat/offering/presentation/displaymodel/OTPDisplayModel;", "getOtpData", "otpVerification", "getOtpVerification", "polygonQuickFilterData", "Lkotlin/Pair;", "LJsonModels/PolygonEvents;", "Ldatamodels/QuickFilter;", "getPolygonQuickFilterData", "popupData", "Lcom/talabat/offering/presentation/displaymodel/PopupDisplayModel;", "getPopupData", "productIdData", "", "getProductIdData", "restaurantsListModel", "Ldatamodels/RestaurantListModel;", "getRestaurantsListModel", "telcoExpired", "", "getTelcoExpired", "telcoVerified", "getTelcoVerified", "vendors", "Lcom/talabat/offering/presentation/displaymodel/VendorsDisplayModel;", "getVendors", "getCTAStatus", "", "productId", "getOfferCollectionData", "collectionId", "latitude", "", "longitude", "resendMobileNumberOTP", "mobileNumber", "requestId", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "sendMobileNumberOTP", "sendShopClickedGA", "selectedRestaurant", "Ldatamodels/Restaurant;", "sendShopListUpdatedGA", "trackSubscriptionVerificationCancelled", "screenName", "trackSubscriptionVerificationClicked", "trackSubscriptionVerificationContinued", "trackSubscriptionVerificationErrorShown", "errorMessage", "trackSubscriptionVerificationExpired", "trackSubscriptionVerificationResend", "trackSubscriptionVerificationStarted", "trackSubscriptionVerificationValidated", "updateTelcoStatus", "isTelcoVerified", "verifyOTP", "otpCode", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OfferCollectionViewModel extends ViewModel {
    @NotNull
    private final MutableLiveData<HeaderDisplayModel> backgroundData = new MutableLiveData<>();
    @NotNull
    private final ShopClickedEvent.EventOriginSourceDelegate eventOriginSource = new ShopClickedEvent.EventOriginSourceDelegate();
    @NotNull
    private final MutableLiveData<HeaderDisplayModel> headerViewData = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<Integer> headerViewState = new MutableLiveData<>(1);
    /* access modifiers changed from: private */
    @NotNull
    public final GetOfferCollectionUseCase offerCollectionUseCase;
    @NotNull
    private final MutableLiveData<UserSubscriptionDisplayModel> offerSubscribed = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<OTPDisplayModel> otpData = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<OTPDisplayModel> otpVerification = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<Pair<PolygonEvents, QuickFilter>> polygonQuickFilterData = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<PopupDisplayModel> popupData = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<String> productIdData = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<RestaurantListModel> restaurantsListModel = new MutableLiveData<>();
    /* access modifiers changed from: private */
    @NotNull
    public final SendMobileOTPUseCase sendMobileOTPUseCase;
    @NotNull
    private final MutableLiveData<Boolean> telcoExpired = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<Boolean> telcoVerified = new MutableLiveData<>();
    @NotNull
    private final TrackShopClickedUseCase trackShopClickedUseCase;
    @NotNull
    private final TrackShopListUpdatedUseCase trackShopListUpdatedUseCase;
    @NotNull
    private final TrackSubscriptionVerificationUseCase trackSubscriptionVerificationUseCase;
    /* access modifiers changed from: private */
    @NotNull
    public final GetUserIsOfferCollectionSubscribedUseCase userIsOfferCollectionSubscribedUseCase;
    @NotNull
    private final MutableLiveData<VendorsDisplayModel> vendors = new MutableLiveData<>();
    /* access modifiers changed from: private */
    @NotNull
    public final VerifyOTPSubscriptionUseCase verifyOTPSubscriptionUseCase;

    public OfferCollectionViewModel(@NotNull GetOfferCollectionUseCase getOfferCollectionUseCase, @NotNull GetUserIsOfferCollectionSubscribedUseCase getUserIsOfferCollectionSubscribedUseCase, @NotNull SendMobileOTPUseCase sendMobileOTPUseCase2, @NotNull VerifyOTPSubscriptionUseCase verifyOTPSubscriptionUseCase2, @NotNull TrackShopClickedUseCase trackShopClickedUseCase2, @NotNull TrackShopListUpdatedUseCase trackShopListUpdatedUseCase2, @NotNull TrackSubscriptionVerificationUseCase trackSubscriptionVerificationUseCase2) {
        Intrinsics.checkNotNullParameter(getOfferCollectionUseCase, "offerCollectionUseCase");
        Intrinsics.checkNotNullParameter(getUserIsOfferCollectionSubscribedUseCase, "userIsOfferCollectionSubscribedUseCase");
        Intrinsics.checkNotNullParameter(sendMobileOTPUseCase2, "sendMobileOTPUseCase");
        Intrinsics.checkNotNullParameter(verifyOTPSubscriptionUseCase2, "verifyOTPSubscriptionUseCase");
        Intrinsics.checkNotNullParameter(trackShopClickedUseCase2, "trackShopClickedUseCase");
        Intrinsics.checkNotNullParameter(trackShopListUpdatedUseCase2, "trackShopListUpdatedUseCase");
        Intrinsics.checkNotNullParameter(trackSubscriptionVerificationUseCase2, "trackSubscriptionVerificationUseCase");
        this.offerCollectionUseCase = getOfferCollectionUseCase;
        this.userIsOfferCollectionSubscribedUseCase = getUserIsOfferCollectionSubscribedUseCase;
        this.sendMobileOTPUseCase = sendMobileOTPUseCase2;
        this.verifyOTPSubscriptionUseCase = verifyOTPSubscriptionUseCase2;
        this.trackShopClickedUseCase = trackShopClickedUseCase2;
        this.trackShopListUpdatedUseCase = trackShopListUpdatedUseCase2;
        this.trackSubscriptionVerificationUseCase = trackSubscriptionVerificationUseCase2;
    }

    @NotNull
    public final MutableLiveData<HeaderDisplayModel> getBackgroundData() {
        return this.backgroundData;
    }

    public final void getCTAStatus(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "productId");
        this.productIdData.postValue(str);
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new OfferCollectionViewModel$getCTAStatus$1(this, str, (Continuation<? super OfferCollectionViewModel$getCTAStatus$1>) null), 3, (Object) null);
    }

    @NotNull
    public final ShopClickedEvent.EventOriginSourceDelegate getEventOriginSource() {
        return this.eventOriginSource;
    }

    @NotNull
    public final MutableLiveData<HeaderDisplayModel> getHeaderViewData() {
        return this.headerViewData;
    }

    @NotNull
    public final MutableLiveData<Integer> getHeaderViewState() {
        return this.headerViewState;
    }

    public final void getOfferCollectionData(int i11, double d11, double d12) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new OfferCollectionViewModel$getOfferCollectionData$1(this, i11, d11, d12, (Continuation<? super OfferCollectionViewModel$getOfferCollectionData$1>) null), 3, (Object) null);
    }

    @NotNull
    public final MutableLiveData<UserSubscriptionDisplayModel> getOfferSubscribed() {
        return this.offerSubscribed;
    }

    @NotNull
    public final MutableLiveData<OTPDisplayModel> getOtpData() {
        return this.otpData;
    }

    @NotNull
    public final MutableLiveData<OTPDisplayModel> getOtpVerification() {
        return this.otpVerification;
    }

    @NotNull
    public final MutableLiveData<Pair<PolygonEvents, QuickFilter>> getPolygonQuickFilterData() {
        return this.polygonQuickFilterData;
    }

    @NotNull
    public final MutableLiveData<PopupDisplayModel> getPopupData() {
        return this.popupData;
    }

    @NotNull
    public final MutableLiveData<String> getProductIdData() {
        return this.productIdData;
    }

    @NotNull
    public final MutableLiveData<RestaurantListModel> getRestaurantsListModel() {
        return this.restaurantsListModel;
    }

    @NotNull
    public final MutableLiveData<Boolean> getTelcoExpired() {
        return this.telcoExpired;
    }

    @NotNull
    public final MutableLiveData<Boolean> getTelcoVerified() {
        return this.telcoVerified;
    }

    @NotNull
    public final MutableLiveData<VendorsDisplayModel> getVendors() {
        return this.vendors;
    }

    public final void resendMobileNumberOTP(@NotNull String str, @Nullable String str2, @NotNull ConfigurationLocalRepository configurationLocalRepository) {
        Intrinsics.checkNotNullParameter(str, "mobileNumber");
        Intrinsics.checkNotNullParameter(configurationLocalRepository, "configurationLocalRepository");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new OfferCollectionViewModel$resendMobileNumberOTP$1(this, str, str2, configurationLocalRepository, (Continuation<? super OfferCollectionViewModel$resendMobileNumberOTP$1>) null), 3, (Object) null);
    }

    public final void sendMobileNumberOTP(@NotNull String str, @NotNull ConfigurationLocalRepository configurationLocalRepository) {
        Intrinsics.checkNotNullParameter(str, "mobileNumber");
        Intrinsics.checkNotNullParameter(configurationLocalRepository, "configurationLocalRepository");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new OfferCollectionViewModel$sendMobileNumberOTP$1(this, str, configurationLocalRepository, (Continuation<? super OfferCollectionViewModel$sendMobileNumberOTP$1>) null), 3, (Object) null);
    }

    public final void sendShopClickedGA(@NotNull Restaurant restaurant) {
        PolygonEvents polygonEvents;
        Intrinsics.checkNotNullParameter(restaurant, "selectedRestaurant");
        TrackShopClickedUseCase trackShopClickedUseCase2 = this.trackShopClickedUseCase;
        Pair value = this.polygonQuickFilterData.getValue();
        QuickFilter quickFilter = null;
        if (value != null) {
            polygonEvents = (PolygonEvents) value.getFirst();
        } else {
            polygonEvents = null;
        }
        Pair value2 = this.polygonQuickFilterData.getValue();
        if (value2 != null) {
            quickFilter = (QuickFilter) value2.getSecond();
        }
        trackShopClickedUseCase2.trackShopClicked(restaurant, polygonEvents, quickFilter, this.eventOriginSource);
    }

    public final void sendShopListUpdatedGA() {
        PolygonEvents polygonEvents;
        TrackShopListUpdatedUseCase trackShopListUpdatedUseCase2 = this.trackShopListUpdatedUseCase;
        VendorsDisplayModel value = this.vendors.getValue();
        if (value != null) {
            RestaurantListModel restaurantListModel = ((VendorsDisplayModel.ShowVendors) value).getRestaurantListModel();
            Pair value2 = this.polygonQuickFilterData.getValue();
            QuickFilter quickFilter = null;
            if (value2 != null) {
                polygonEvents = (PolygonEvents) value2.getFirst();
            } else {
                polygonEvents = null;
            }
            Pair value3 = this.polygonQuickFilterData.getValue();
            if (value3 != null) {
                quickFilter = (QuickFilter) value3.getSecond();
            }
            trackShopListUpdatedUseCase2.trackShopListUpdated(restaurantListModel, polygonEvents, quickFilter, this.eventOriginSource, this.telcoVerified.getValue(), this.telcoExpired.getValue());
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.offering.presentation.displaymodel.VendorsDisplayModel.ShowVendors");
    }

    public final void trackSubscriptionVerificationCancelled(@NotNull String str) {
        String str2;
        QuickFilter quickFilter;
        Intrinsics.checkNotNullParameter(str, "screenName");
        TrackSubscriptionVerificationUseCase trackSubscriptionVerificationUseCase2 = this.trackSubscriptionVerificationUseCase;
        Pair value = this.polygonQuickFilterData.getValue();
        if (value == null || (quickFilter = (QuickFilter) value.getSecond()) == null) {
            str2 = null;
        } else {
            str2 = quickFilter.getSlug();
        }
        trackSubscriptionVerificationUseCase2.trackMobileVerificationCancelled(String.valueOf(str2), "channel", str, OfferCollectionViewModelKt.SCREEN_TYPE);
    }

    public final void trackSubscriptionVerificationClicked() {
        String str;
        QuickFilter quickFilter;
        TrackSubscriptionVerificationUseCase trackSubscriptionVerificationUseCase2 = this.trackSubscriptionVerificationUseCase;
        Pair value = this.polygonQuickFilterData.getValue();
        if (value == null || (quickFilter = (QuickFilter) value.getSecond()) == null) {
            str = null;
        } else {
            str = quickFilter.getSlug();
        }
        trackSubscriptionVerificationUseCase2.trackMobileVerificationClicked(String.valueOf(str), "channel", "Restaurant List Screen", "shop_list");
    }

    public final void trackSubscriptionVerificationContinued() {
        String str;
        QuickFilter quickFilter;
        QuickFilter quickFilter2;
        TrackSubscriptionVerificationUseCase trackSubscriptionVerificationUseCase2 = this.trackSubscriptionVerificationUseCase;
        Pair value = this.polygonQuickFilterData.getValue();
        String str2 = null;
        if (value == null || (quickFilter2 = (QuickFilter) value.getSecond()) == null) {
            str = null;
        } else {
            str = quickFilter2.getSlug();
        }
        String valueOf = String.valueOf(str);
        Pair value2 = this.polygonQuickFilterData.getValue();
        if (!(value2 == null || (quickFilter = (QuickFilter) value2.getSecond()) == null)) {
            str2 = quickFilter.getSlug();
        }
        trackSubscriptionVerificationUseCase2.trackMobileVerificationContinued(valueOf, "channel", OfferCollectionViewModelKt.SCREEN_NAME, OfferCollectionViewModelKt.SCREEN_TYPE, "Telco: " + str2, "mobile number added");
    }

    public final void trackSubscriptionVerificationErrorShown(@NotNull String str) {
        String str2;
        QuickFilter quickFilter;
        QuickFilter quickFilter2;
        Intrinsics.checkNotNullParameter(str, "errorMessage");
        TrackSubscriptionVerificationUseCase trackSubscriptionVerificationUseCase2 = this.trackSubscriptionVerificationUseCase;
        Pair value = this.polygonQuickFilterData.getValue();
        String str3 = null;
        if (value == null || (quickFilter2 = (QuickFilter) value.getSecond()) == null) {
            str2 = null;
        } else {
            str2 = quickFilter2.getSlug();
        }
        String valueOf = String.valueOf(str2);
        Pair value2 = this.polygonQuickFilterData.getValue();
        if (!(value2 == null || (quickFilter = (QuickFilter) value2.getSecond()) == null)) {
            str3 = quickFilter.getSlug();
        }
        trackSubscriptionVerificationUseCase2.trackMobileVerificationErrorShown(valueOf, "channel", OfferCollectionViewModelKt.SCREEN_NAME, OfferCollectionViewModelKt.SCREEN_TYPE, "Telco: " + str3, str);
    }

    public final void trackSubscriptionVerificationExpired() {
        String str;
        QuickFilter quickFilter;
        QuickFilter quickFilter2;
        TrackSubscriptionVerificationUseCase trackSubscriptionVerificationUseCase2 = this.trackSubscriptionVerificationUseCase;
        Pair value = this.polygonQuickFilterData.getValue();
        String str2 = null;
        if (value == null || (quickFilter2 = (QuickFilter) value.getSecond()) == null) {
            str = null;
        } else {
            str = quickFilter2.getSlug();
        }
        String valueOf = String.valueOf(str);
        Pair value2 = this.polygonQuickFilterData.getValue();
        if (!(value2 == null || (quickFilter = (QuickFilter) value2.getSecond()) == null)) {
            str2 = quickFilter.getSlug();
        }
        trackSubscriptionVerificationUseCase2.trackMobileVerificationCodeExpired(valueOf, "channel", OfferCollectionViewModelKt.SCREEN_NAME, OfferCollectionViewModelKt.SCREEN_TYPE, "Telco: " + str2);
    }

    public final void trackSubscriptionVerificationResend() {
        String str;
        QuickFilter quickFilter;
        QuickFilter quickFilter2;
        TrackSubscriptionVerificationUseCase trackSubscriptionVerificationUseCase2 = this.trackSubscriptionVerificationUseCase;
        Pair value = this.polygonQuickFilterData.getValue();
        String str2 = null;
        if (value == null || (quickFilter2 = (QuickFilter) value.getSecond()) == null) {
            str = null;
        } else {
            str = quickFilter2.getSlug();
        }
        String valueOf = String.valueOf(str);
        Pair value2 = this.polygonQuickFilterData.getValue();
        if (!(value2 == null || (quickFilter = (QuickFilter) value2.getSecond()) == null)) {
            str2 = quickFilter.getSlug();
        }
        trackSubscriptionVerificationUseCase2.trackMobileVerificationCodeResend(valueOf, "channel", OfferCollectionViewModelKt.SCREEN_NAME, OfferCollectionViewModelKt.SCREEN_TYPE, "Telco: " + str2);
    }

    public final void trackSubscriptionVerificationStarted() {
        String str;
        QuickFilter quickFilter;
        QuickFilter quickFilter2;
        TrackSubscriptionVerificationUseCase trackSubscriptionVerificationUseCase2 = this.trackSubscriptionVerificationUseCase;
        Pair value = this.polygonQuickFilterData.getValue();
        String str2 = null;
        if (value == null || (quickFilter2 = (QuickFilter) value.getSecond()) == null) {
            str = null;
        } else {
            str = quickFilter2.getSlug();
        }
        String valueOf = String.valueOf(str);
        Pair value2 = this.polygonQuickFilterData.getValue();
        if (!(value2 == null || (quickFilter = (QuickFilter) value2.getSecond()) == null)) {
            str2 = quickFilter.getSlug();
        }
        trackSubscriptionVerificationUseCase2.trackMobileVerificationStarted(valueOf, "channel", OfferCollectionViewModelKt.SCREEN_NAME, OfferCollectionViewModelKt.SCREEN_TYPE, "Telco: " + str2);
    }

    public final void trackSubscriptionVerificationValidated() {
        String str;
        QuickFilter quickFilter;
        QuickFilter quickFilter2;
        TrackSubscriptionVerificationUseCase trackSubscriptionVerificationUseCase2 = this.trackSubscriptionVerificationUseCase;
        Pair value = this.polygonQuickFilterData.getValue();
        String str2 = null;
        if (value == null || (quickFilter2 = (QuickFilter) value.getSecond()) == null) {
            str = null;
        } else {
            str = quickFilter2.getSlug();
        }
        String valueOf = String.valueOf(str);
        Pair value2 = this.polygonQuickFilterData.getValue();
        if (!(value2 == null || (quickFilter = (QuickFilter) value2.getSecond()) == null)) {
            str2 = quickFilter.getSlug();
        }
        trackSubscriptionVerificationUseCase2.trackMobileVerificationValidated(valueOf, "channel", OfferCollectionViewModelKt.SCREEN_NAME, OfferCollectionViewModelKt.SCREEN_TYPE, "Telco: " + str2);
    }

    public final void updateTelcoStatus(boolean z11) {
        this.telcoVerified.setValue(Boolean.valueOf(z11));
        sendShopListUpdatedGA();
    }

    public final void verifyOTP(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "otpCode");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new OfferCollectionViewModel$verifyOTP$1(this, str, (Continuation<? super OfferCollectionViewModel$verifyOTP$1>) null), 3, (Object) null);
    }
}
