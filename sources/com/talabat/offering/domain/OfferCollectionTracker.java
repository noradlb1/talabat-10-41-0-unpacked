package com.talabat.offering.domain;

import com.talabat.offering.data.RestaurantListUpdatedEvent;
import com.talabat.offering.data.RestaurantShopClickedEvent;
import com.talabat.offering.data.SubscriptionVerificationEvent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&¨\u0006\u0013"}, d2 = {"Lcom/talabat/offering/domain/OfferCollectionTracker;", "", "trackMobileVerificationCancelled", "", "subscriptionVerificationEvent", "Lcom/talabat/offering/data/SubscriptionVerificationEvent;", "trackMobileVerificationClicked", "trackMobileVerificationCodeExpired", "trackMobileVerificationCodeResend", "trackMobileVerificationContinued", "trackMobileVerificationErrorShown", "trackMobileVerificationStarted", "trackMobileVerificationValidated", "trackShopClicked", "restaurantShopClickedEvent", "Lcom/talabat/offering/data/RestaurantShopClickedEvent;", "trackShopListUpdated", "restaurantListUpdatedEvent", "Lcom/talabat/offering/data/RestaurantListUpdatedEvent;", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface OfferCollectionTracker {
    void trackMobileVerificationCancelled(@NotNull SubscriptionVerificationEvent subscriptionVerificationEvent);

    void trackMobileVerificationClicked(@NotNull SubscriptionVerificationEvent subscriptionVerificationEvent);

    void trackMobileVerificationCodeExpired(@NotNull SubscriptionVerificationEvent subscriptionVerificationEvent);

    void trackMobileVerificationCodeResend(@NotNull SubscriptionVerificationEvent subscriptionVerificationEvent);

    void trackMobileVerificationContinued(@NotNull SubscriptionVerificationEvent subscriptionVerificationEvent);

    void trackMobileVerificationErrorShown(@NotNull SubscriptionVerificationEvent subscriptionVerificationEvent);

    void trackMobileVerificationStarted(@NotNull SubscriptionVerificationEvent subscriptionVerificationEvent);

    void trackMobileVerificationValidated(@NotNull SubscriptionVerificationEvent subscriptionVerificationEvent);

    void trackShopClicked(@NotNull RestaurantShopClickedEvent restaurantShopClickedEvent);

    void trackShopListUpdated(@NotNull RestaurantListUpdatedEvent restaurantListUpdatedEvent);
}
