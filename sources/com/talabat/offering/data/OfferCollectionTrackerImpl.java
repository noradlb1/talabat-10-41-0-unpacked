package com.talabat.offering.data;

import android.content.Context;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.offering.domain.OfferCollectionTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tracking.IAppTracker;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/talabat/offering/data/OfferCollectionTrackerImpl;", "Lcom/talabat/offering/domain/OfferCollectionTracker;", "context", "Landroid/content/Context;", "appTracker", "Ltracking/IAppTracker;", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "(Landroid/content/Context;Ltracking/IAppTracker;Lcom/talabat/core/tracking/domain/TalabatTracker;)V", "getContext", "()Landroid/content/Context;", "trackMobileVerificationCancelled", "", "subscriptionVerificationEvent", "Lcom/talabat/offering/data/SubscriptionVerificationEvent;", "trackMobileVerificationClicked", "trackMobileVerificationCodeExpired", "trackMobileVerificationCodeResend", "trackMobileVerificationContinued", "trackMobileVerificationErrorShown", "trackMobileVerificationStarted", "trackMobileVerificationValidated", "trackShopClicked", "restaurantShopClickedEvent", "Lcom/talabat/offering/data/RestaurantShopClickedEvent;", "trackShopListUpdated", "restaurantListUpdatedEvent", "Lcom/talabat/offering/data/RestaurantListUpdatedEvent;", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OfferCollectionTrackerImpl implements OfferCollectionTracker {
    @NotNull
    private final IAppTracker appTracker;
    @NotNull
    private final Context context;
    @NotNull
    private final TalabatTracker talabatTracker;

    public OfferCollectionTrackerImpl(@NotNull Context context2, @NotNull IAppTracker iAppTracker, @NotNull TalabatTracker talabatTracker2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(iAppTracker, "appTracker");
        Intrinsics.checkNotNullParameter(talabatTracker2, "talabatTracker");
        this.context = context2;
        this.appTracker = iAppTracker;
        this.talabatTracker = talabatTracker2;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    public void trackMobileVerificationCancelled(@NotNull SubscriptionVerificationEvent subscriptionVerificationEvent) {
        Intrinsics.checkNotNullParameter(subscriptionVerificationEvent, "subscriptionVerificationEvent");
        this.appTracker.onSubscriptionVerificationCancelled(this.context, subscriptionVerificationEvent.getChannel(), subscriptionVerificationEvent.getEventOrigin(), subscriptionVerificationEvent.getScreenName(), subscriptionVerificationEvent.getScreenType());
    }

    public void trackMobileVerificationClicked(@NotNull SubscriptionVerificationEvent subscriptionVerificationEvent) {
        Intrinsics.checkNotNullParameter(subscriptionVerificationEvent, "subscriptionVerificationEvent");
        this.appTracker.onSubscriptionVerificationClicked(this.context, subscriptionVerificationEvent.getChannel(), subscriptionVerificationEvent.getEventOrigin(), subscriptionVerificationEvent.getScreenName(), subscriptionVerificationEvent.getScreenType());
    }

    public void trackMobileVerificationCodeExpired(@NotNull SubscriptionVerificationEvent subscriptionVerificationEvent) {
        Intrinsics.checkNotNullParameter(subscriptionVerificationEvent, "subscriptionVerificationEvent");
        this.appTracker.onSubscriptionVerificationCodeExpired(this.context, subscriptionVerificationEvent.getChannel(), subscriptionVerificationEvent.getEventOrigin(), subscriptionVerificationEvent.getScreenName(), subscriptionVerificationEvent.getScreenType(), subscriptionVerificationEvent.getSubscriptionType());
    }

    public void trackMobileVerificationCodeResend(@NotNull SubscriptionVerificationEvent subscriptionVerificationEvent) {
        Intrinsics.checkNotNullParameter(subscriptionVerificationEvent, "subscriptionVerificationEvent");
        this.appTracker.onSubscriptionVerificationCodeResend(this.context, subscriptionVerificationEvent.getChannel(), subscriptionVerificationEvent.getEventOrigin(), subscriptionVerificationEvent.getScreenName(), subscriptionVerificationEvent.getScreenType(), subscriptionVerificationEvent.getSubscriptionType());
    }

    public void trackMobileVerificationContinued(@NotNull SubscriptionVerificationEvent subscriptionVerificationEvent) {
        Intrinsics.checkNotNullParameter(subscriptionVerificationEvent, "subscriptionVerificationEvent");
        this.appTracker.onSubscriptionVerificationContinued(this.context, subscriptionVerificationEvent.getChannel(), subscriptionVerificationEvent.getEventOrigin(), subscriptionVerificationEvent.getScreenName(), subscriptionVerificationEvent.getScreenType(), subscriptionVerificationEvent.getSubscriptionType(), subscriptionVerificationEvent.getMobileVerificationStatus());
    }

    public void trackMobileVerificationErrorShown(@NotNull SubscriptionVerificationEvent subscriptionVerificationEvent) {
        Intrinsics.checkNotNullParameter(subscriptionVerificationEvent, "subscriptionVerificationEvent");
        this.appTracker.onSubscriptionVerificationErrorShown(this.context, subscriptionVerificationEvent.getChannel(), subscriptionVerificationEvent.getEventOrigin(), subscriptionVerificationEvent.getScreenName(), subscriptionVerificationEvent.getScreenType(), subscriptionVerificationEvent.getSubscriptionType(), subscriptionVerificationEvent.getFailReason());
    }

    public void trackMobileVerificationStarted(@NotNull SubscriptionVerificationEvent subscriptionVerificationEvent) {
        Intrinsics.checkNotNullParameter(subscriptionVerificationEvent, "subscriptionVerificationEvent");
        this.appTracker.onSubscriptionVerificationStarted(this.context, subscriptionVerificationEvent.getChannel(), subscriptionVerificationEvent.getEventOrigin(), subscriptionVerificationEvent.getScreenName(), subscriptionVerificationEvent.getScreenType(), subscriptionVerificationEvent.getSubscriptionType());
    }

    public void trackMobileVerificationValidated(@NotNull SubscriptionVerificationEvent subscriptionVerificationEvent) {
        Intrinsics.checkNotNullParameter(subscriptionVerificationEvent, "subscriptionVerificationEvent");
        this.appTracker.onSubscriptionVerificationValidated(this.context, subscriptionVerificationEvent.getChannel(), subscriptionVerificationEvent.getEventOrigin(), subscriptionVerificationEvent.getScreenName(), subscriptionVerificationEvent.getScreenType(), subscriptionVerificationEvent.getSubscriptionType());
    }

    public void trackShopClicked(@NotNull RestaurantShopClickedEvent restaurantShopClickedEvent) {
        Intrinsics.checkNotNullParameter(restaurantShopClickedEvent, "restaurantShopClickedEvent");
        this.appTracker.onOfferingRestaurantsClicked(this.context, restaurantShopClickedEvent.getSelectedRestaurant(), restaurantShopClickedEvent.getClickOrigin(), restaurantShopClickedEvent.getSearchString(), restaurantShopClickedEvent.getChannelIndex(), restaurantShopClickedEvent.getChannel(), restaurantShopClickedEvent.getScreenType(), restaurantShopClickedEvent.getSearchTerm(), restaurantShopClickedEvent.getPolygonEvent(), restaurantShopClickedEvent.getListViewType(), restaurantShopClickedEvent.getSwimlanesGa(), restaurantShopClickedEvent.getEventOriginSource(), Intrinsics.areEqual((Object) restaurantShopClickedEvent.isGemRestaurant(), (Object) Boolean.TRUE));
    }

    public void trackShopListUpdated(@NotNull RestaurantListUpdatedEvent restaurantListUpdatedEvent) {
        Intrinsics.checkNotNullParameter(restaurantListUpdatedEvent, "restaurantListUpdatedEvent");
        this.appTracker.onOfferingRestaurantListUpdated(this.context, restaurantListUpdatedEvent.getRestaurants(), restaurantListUpdatedEvent.getShopListType(), restaurantListUpdatedEvent.getChannelIndex(), restaurantListUpdatedEvent.getChannel(), restaurantListUpdatedEvent.getShopListTrigger(), restaurantListUpdatedEvent.isRecomendRestaurantsExist(), restaurantListUpdatedEvent.getShopRecommendedQuantity(), restaurantListUpdatedEvent.getShopOpenNumber(), restaurantListUpdatedEvent.isCollection(), restaurantListUpdatedEvent.getShopIds(), restaurantListUpdatedEvent.getPolygonEvent(), restaurantListUpdatedEvent.getListViewType(), restaurantListUpdatedEvent.getSwimlanesGa(), restaurantListUpdatedEvent.getEventOriginSource(), restaurantListUpdatedEvent.getEventOrigin(), restaurantListUpdatedEvent.getTelcoVerified(), restaurantListUpdatedEvent.getTelcoExpired());
    }
}
