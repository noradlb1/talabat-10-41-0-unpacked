package com.braze;

import android.app.Activity;
import android.content.Intent;
import com.appboy.events.FeedUpdatedEvent;
import com.appboy.models.cards.Card;
import com.braze.events.BrazeNetworkFailureEvent;
import com.braze.events.BrazePushEvent;
import com.braze.events.BrazeSdkAuthenticationErrorEvent;
import com.braze.events.ContentCardsUpdatedEvent;
import com.braze.events.FeatureFlagsUpdatedEvent;
import com.braze.events.IEventSubscriber;
import com.braze.events.IValueCallback;
import com.braze.events.InAppMessageEvent;
import com.braze.events.NoMatchingTriggerEvent;
import com.braze.events.SessionStateChangedEvent;
import com.braze.images.IBrazeImageLoader;
import com.braze.models.FeatureFlag;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.outgoing.BrazeProperties;
import java.math.BigDecimal;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J*\u0010\u0014\u001a\u00020\u0015\"\u0004\b\u0000\u0010\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00160\u001aH&J\u0012\u0010\u001b\u001a\u00020\u00152\b\u0010\u001c\u001a\u0004\u0018\u00010\u0007H&J\u001c\u0010\u001b\u001a\u00020\u00152\b\u0010\u001c\u001a\u0004\u0018\u00010\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\u001e\u001a\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010 H&J\u0014\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010\u0007H&J\u0014\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010$\u001a\u0004\u0018\u00010%H&J\u0014\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010\u0007H&J\u000e\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*H&J\u0010\u0010,\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010*H&J\b\u0010-\u001a\u00020.H&J\b\u0010/\u001a\u00020.H&J\b\u00100\u001a\u000201H&J\u0016\u0010\u0004\u001a\u00020\u00152\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u000303H&J\u0010\u00104\u001a\u00020+2\u0006\u00105\u001a\u00020\u0007H&J\n\u00106\u001a\u0004\u0018\u00010\u0007H\u0017J\u0012\u00107\u001a\u00020\u00152\b\u00108\u001a\u0004\u0018\u00010\u0007H&J\u001c\u00107\u001a\u00020\u00152\b\u00108\u001a\u0004\u0018\u00010\u00072\b\u00109\u001a\u0004\u0018\u00010:H&J\u0012\u0010;\u001a\u00020\u00152\b\u0010<\u001a\u0004\u0018\u00010\u0007H'J\u0012\u0010=\u001a\u00020\u00152\b\u0010<\u001a\u0004\u0018\u00010\u0007H'J\b\u0010>\u001a\u00020\u0015H&J&\u0010?\u001a\u00020\u00152\b\u0010@\u001a\u0004\u0018\u00010\u00072\b\u0010A\u001a\u0004\u0018\u00010\u00072\b\u0010B\u001a\u0004\u0018\u00010CH&J0\u0010?\u001a\u00020\u00152\b\u0010@\u001a\u0004\u0018\u00010\u00072\b\u0010A\u001a\u0004\u0018\u00010\u00072\b\u0010B\u001a\u0004\u0018\u00010C2\b\u00109\u001a\u0004\u0018\u00010:H&J.\u0010?\u001a\u00020\u00152\b\u0010@\u001a\u0004\u0018\u00010\u00072\b\u0010A\u001a\u0004\u0018\u00010\u00072\b\u0010B\u001a\u0004\u0018\u00010C2\u0006\u0010D\u001a\u00020.H&J<\u0010?\u001a\u00020\u00152\b\u0010@\u001a\u0004\u0018\u00010\u00072\b\u0010A\u001a\u0004\u0018\u00010\u00072\b\u0010B\u001a\u0004\u0018\u00010C2\b\b\u0002\u0010D\u001a\u00020.2\n\b\u0002\u00109\u001a\u0004\u0018\u00010:H&J&\u0010E\u001a\u00020\u00152\b\u0010F\u001a\u0004\u0018\u00010\u00072\b\u0010G\u001a\u0004\u0018\u00010\u00072\b\u0010H\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010I\u001a\u00020\u00152\b\u0010J\u001a\u0004\u0018\u00010KH&J\u0012\u0010I\u001a\u00020\u00152\b\u0010F\u001a\u0004\u0018\u00010\u0007H&J\u001c\u0010L\u001a\u00020\u00152\b\u0010F\u001a\u0004\u0018\u00010\u00072\b\u0010M\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010N\u001a\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010 H&J\b\u0010O\u001a\u00020\u0015H&J,\u0010P\u001a\u00020\u0015\"\u0004\b\u0000\u0010\u00162\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u0002H\u0016\u0018\u00010\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00160\u001aH&J\u0010\u0010Q\u001a\u00020\u00152\u0006\u0010R\u001a\u00020SH&J\b\u0010T\u001a\u00020\u0015H&J\b\u0010U\u001a\u00020\u0015H&J\u0018\u0010V\u001a\u00020\u00152\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020XH&J\b\u0010Z\u001a\u00020\u0015H&J\b\u0010[\u001a\u00020\u0015H&J\u0018\u0010\\\u001a\u00020\u00152\u0006\u0010]\u001a\u00020\u00072\u0006\u0010^\u001a\u00020SH&J\u0010\u0010_\u001a\u00020\u00152\u0006\u0010`\u001a\u00020\u0007H&J\u0016\u0010a\u001a\u00020\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020b0\u0018H&J\u0016\u0010c\u001a\u00020\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020d0\u0018H&J\u0016\u0010e\u001a\u00020\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020f0\u0018H&J\u0016\u0010g\u001a\u00020\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020h0\u0018H&J\u0016\u0010i\u001a\u00020\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020j0\u0018H&J\u0016\u0010k\u001a\u00020\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020l0\u0018H&J\u0016\u0010m\u001a\u00020\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020n0\u0018H&J\u0016\u0010o\u001a\u00020\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020p0\u0018H&J\u0016\u0010q\u001a\u00020\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020r0\u0018H&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0018\u0010\n\u001a\u00020\u000bX¦\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u0007X¦\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\t\"\u0004\b\u0012\u0010\u0013ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006sÀ\u0006\u0001"}, d2 = {"Lcom/braze/IBraze;", "", "currentUser", "Lcom/braze/BrazeUser;", "getCurrentUser", "()Lcom/braze/BrazeUser;", "deviceId", "", "getDeviceId", "()Ljava/lang/String;", "imageLoader", "Lcom/braze/images/IBrazeImageLoader;", "getImageLoader", "()Lcom/braze/images/IBrazeImageLoader;", "setImageLoader", "(Lcom/braze/images/IBrazeImageLoader;)V", "registeredPushToken", "getRegisteredPushToken", "setRegisteredPushToken", "(Ljava/lang/String;)V", "addSingleSynchronousSubscription", "", "T", "subscriber", "Lcom/braze/events/IEventSubscriber;", "eventClass", "Ljava/lang/Class;", "changeUser", "userId", "sdkAuthSignature", "closeSession", "activity", "Landroid/app/Activity;", "deserializeContentCard", "Lcom/appboy/models/cards/Card;", "contentCardString", "contentCardJson", "Lorg/json/JSONObject;", "deserializeInAppMessageString", "Lcom/braze/models/inappmessage/IInAppMessage;", "inAppMessageString", "getAllFeatureFlags", "", "Lcom/braze/models/FeatureFlag;", "getCachedContentCards", "getContentCardCount", "", "getContentCardUnviewedCount", "getContentCardsLastUpdatedInSecondsFromEpoch", "", "completionCallback", "Lcom/braze/events/IValueCallback;", "getFeatureFlag", "id", "getInstallTrackingId", "logCustomEvent", "eventName", "properties", "Lcom/braze/models/outgoing/BrazeProperties;", "logFeedCardClick", "cardId", "logFeedCardImpression", "logFeedDisplayed", "logPurchase", "productId", "currencyCode", "price", "Ljava/math/BigDecimal;", "quantity", "logPushNotificationActionClicked", "campaignId", "actionId", "actionType", "logPushNotificationOpened", "intent", "Landroid/content/Intent;", "logPushStoryPageClicked", "pageId", "openSession", "refreshFeatureFlags", "removeSingleSubscription", "requestContentCardsRefresh", "fromCache", "", "requestFeedRefresh", "requestFeedRefreshFromCache", "requestGeofences", "latitude", "", "longitude", "requestImmediateDataFlush", "requestLocationInitialization", "setGoogleAdvertisingId", "googleAdvertisingId", "isLimitAdTrackingEnabled", "setSdkAuthenticationSignature", "signature", "subscribeToContentCardsUpdates", "Lcom/braze/events/ContentCardsUpdatedEvent;", "subscribeToFeatureFlagsUpdates", "Lcom/braze/events/FeatureFlagsUpdatedEvent;", "subscribeToFeedUpdates", "Lcom/appboy/events/FeedUpdatedEvent;", "subscribeToNetworkFailures", "Lcom/braze/events/BrazeNetworkFailureEvent;", "subscribeToNewInAppMessages", "Lcom/braze/events/InAppMessageEvent;", "subscribeToNoMatchingTriggerForEvent", "Lcom/braze/events/NoMatchingTriggerEvent;", "subscribeToPushNotificationEvents", "Lcom/braze/events/BrazePushEvent;", "subscribeToSdkAuthenticationFailures", "Lcom/braze/events/BrazeSdkAuthenticationErrorEvent;", "subscribeToSessionUpdates", "Lcom/braze/events/SessionStateChangedEvent;", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IBraze {
    <T> void addSingleSynchronousSubscription(IEventSubscriber<T> iEventSubscriber, Class<T> cls);

    void changeUser(String str);

    void changeUser(String str, String str2);

    void closeSession(Activity activity);

    Card deserializeContentCard(String str);

    Card deserializeContentCard(JSONObject jSONObject);

    IInAppMessage deserializeInAppMessageString(String str);

    List<FeatureFlag> getAllFeatureFlags();

    List<Card> getCachedContentCards();

    int getContentCardCount();

    int getContentCardUnviewedCount();

    long getContentCardsLastUpdatedInSecondsFromEpoch();

    BrazeUser getCurrentUser();

    void getCurrentUser(IValueCallback<BrazeUser> iValueCallback);

    String getDeviceId();

    FeatureFlag getFeatureFlag(String str);

    IBrazeImageLoader getImageLoader();

    @Deprecated(message = "Use {@link #getDeviceId()} for equivalent functionality. Deprecated since May 2021", replaceWith = @ReplaceWith(expression = "deviceId", imports = {}))
    String getInstallTrackingId();

    String getRegisteredPushToken();

    void logCustomEvent(String str);

    void logCustomEvent(String str, BrazeProperties brazeProperties);

    @Deprecated(message = "Please call {@link Card#logClick()} instead to log a click.", replaceWith = @ReplaceWith(expression = "Card.logClick()", imports = {}))
    void logFeedCardClick(String str);

    @Deprecated(message = "Please call {@link Card#logImpression()} instead to log an impression.", replaceWith = @ReplaceWith(expression = "Card.logImpression", imports = {}))
    void logFeedCardImpression(String str);

    void logFeedDisplayed();

    void logPurchase(String str, String str2, BigDecimal bigDecimal);

    void logPurchase(String str, String str2, BigDecimal bigDecimal, int i11);

    void logPurchase(String str, String str2, BigDecimal bigDecimal, int i11, BrazeProperties brazeProperties);

    void logPurchase(String str, String str2, BigDecimal bigDecimal, BrazeProperties brazeProperties);

    void logPushNotificationActionClicked(String str, String str2, String str3);

    void logPushNotificationOpened(Intent intent);

    void logPushNotificationOpened(String str);

    void logPushStoryPageClicked(String str, String str2);

    void openSession(Activity activity);

    void refreshFeatureFlags();

    <T> void removeSingleSubscription(IEventSubscriber<T> iEventSubscriber, Class<T> cls);

    void requestContentCardsRefresh(boolean z11);

    void requestFeedRefresh();

    void requestFeedRefreshFromCache();

    void requestGeofences(double d11, double d12);

    void requestImmediateDataFlush();

    void requestLocationInitialization();

    void setGoogleAdvertisingId(String str, boolean z11);

    void setImageLoader(IBrazeImageLoader iBrazeImageLoader);

    void setRegisteredPushToken(String str);

    void setSdkAuthenticationSignature(String str);

    void subscribeToContentCardsUpdates(IEventSubscriber<ContentCardsUpdatedEvent> iEventSubscriber);

    void subscribeToFeatureFlagsUpdates(IEventSubscriber<FeatureFlagsUpdatedEvent> iEventSubscriber);

    void subscribeToFeedUpdates(IEventSubscriber<FeedUpdatedEvent> iEventSubscriber);

    void subscribeToNetworkFailures(IEventSubscriber<BrazeNetworkFailureEvent> iEventSubscriber);

    void subscribeToNewInAppMessages(IEventSubscriber<InAppMessageEvent> iEventSubscriber);

    void subscribeToNoMatchingTriggerForEvent(IEventSubscriber<NoMatchingTriggerEvent> iEventSubscriber);

    void subscribeToPushNotificationEvents(IEventSubscriber<BrazePushEvent> iEventSubscriber);

    void subscribeToSdkAuthenticationFailures(IEventSubscriber<BrazeSdkAuthenticationErrorEvent> iEventSubscriber);

    void subscribeToSessionUpdates(IEventSubscriber<SessionStateChangedEvent> iEventSubscriber);
}
