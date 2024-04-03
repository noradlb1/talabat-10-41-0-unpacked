package com.deliveryhero.customerchat.eventTracking.factory;

import com.deliveryhero.customerchat.analytics.model.Contact;
import com.deliveryhero.customerchat.analytics.model.Event;
import com.deliveryhero.customerchat.analytics.model.EventCreationRequest;
import com.deliveryhero.customerchat.analytics.model.Financial;
import com.deliveryhero.customerchat.analytics.model.Order;
import com.deliveryhero.customerchat.analytics.model.Product;
import com.deliveryhero.customerchat.analytics.model.Screen;
import com.deliveryhero.customerchat.analytics.model.User;
import com.deliveryhero.customerchat.datastore.UserPropertiesDataStoreHelper;
import com.deliveryhero.customerchat.eventTracking.constants.EventDetailsKeys;
import com.deliveryhero.customerchat.eventTracking.constants.EventName;
import com.deliveryhero.customerchat.eventTracking.data.CallMetadata;
import com.deliveryhero.customerchat.eventTracking.data.EventMetadata;
import com.deliveryhero.customerchat.eventTracking.data.UserProperties;
import com.deliveryhero.customerchat.eventTracking.factory.CallEventsFactory;
import com.deliveryhero.customerchat.eventTracking.utils.EventUtils;
import com.deliveryhero.customerchat.telephony.domain.voipAnalytics.CallRegistrationStatus;
import com.google.android.exoplayer2.RendererCapabilities;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010%\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010 \u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010!\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\"\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010#\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010$\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010%\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010&\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001e\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00100(2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/deliveryhero/customerchat/eventTracking/factory/CallEventsFactoryImpl;", "Lcom/deliveryhero/customerchat/eventTracking/factory/CallEventsFactory;", "eventUtils", "Lcom/deliveryhero/customerchat/eventTracking/utils/EventUtils;", "userPropertiesDataStoreHelper", "Lcom/deliveryhero/customerchat/datastore/UserPropertiesDataStoreHelper;", "(Lcom/deliveryhero/customerchat/eventTracking/utils/EventUtils;Lcom/deliveryhero/customerchat/datastore/UserPropertiesDataStoreHelper;)V", "userProperties", "Lcom/deliveryhero/customerchat/eventTracking/data/UserProperties;", "getUserProperties", "()Lcom/deliveryhero/customerchat/eventTracking/data/UserProperties;", "userProperties$delegate", "Lkotlin/Lazy;", "createEvent", "Lcom/deliveryhero/customerchat/analytics/model/Event;", "etsEventType", "", "callMetadata", "Lcom/deliveryhero/customerchat/eventTracking/data/CallMetadata;", "createEventObject", "Lcom/deliveryhero/customerchat/analytics/model/EventCreationRequest;", "eventName", "eventMetadata", "Lcom/deliveryhero/customerchat/eventTracking/data/EventMetadata;", "createInAppCallButtonClicked", "createInAppCallButtonShown", "createInAppCallCancelled", "createInAppCallEnded", "createInAppCallErrorCaused", "createInAppCallMuteButtonClicked", "createInAppCallPickedUp", "createInAppCallRejected", "createInAppCallRingStarted", "createInAppCallSpeakerButtonClicked", "createInAppCallSurveyDisplayed", "createInAppCallSurveySubmitted", "createInAppCallTimedOut", "createInAppCallUserRegistered", "createTraditionalCallButtonClicked", "getEventDetails", "", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CallEventsFactoryImpl implements CallEventsFactory {
    @NotNull
    private final EventUtils eventUtils;
    @NotNull
    private final Lazy userProperties$delegate = LazyKt__LazyJVMKt.lazy(new CallEventsFactoryImpl$userProperties$2(this));
    /* access modifiers changed from: private */
    @NotNull
    public final UserPropertiesDataStoreHelper userPropertiesDataStoreHelper;

    public CallEventsFactoryImpl(@NotNull EventUtils eventUtils2, @NotNull UserPropertiesDataStoreHelper userPropertiesDataStoreHelper2) {
        Intrinsics.checkNotNullParameter(eventUtils2, "eventUtils");
        Intrinsics.checkNotNullParameter(userPropertiesDataStoreHelper2, "userPropertiesDataStoreHelper");
        this.eventUtils = eventUtils2;
        this.userPropertiesDataStoreHelper = userPropertiesDataStoreHelper2;
    }

    private final Event createEvent(String str, CallMetadata callMetadata) {
        return new Event(this.eventUtils.generateUUID(), str, getEventDetails(callMetadata));
    }

    private final EventCreationRequest createEventObject(String str, EventMetadata eventMetadata, CallMetadata callMetadata) {
        String globalEntityID = eventMetadata.getGlobalEntityID();
        String generateTimeStamp = this.eventUtils.generateTimeStamp();
        Order order = new Order(eventMetadata.getOrderID(), (Map) null, 2, (DefaultConstructorMarker) null);
        Contact createContactObject = createContactObject(eventMetadata);
        User createUserObject = createUserObject(eventMetadata, getUserProperties());
        return new EventCreationRequest(globalEntityID, generateTimeStamp, createEvent(str, callMetadata), createProductObject(getUserProperties()), createUserObject, order, createContactObject, (Screen) null, (Financial) null, RendererCapabilities.MODE_SUPPORT_MASK, (DefaultConstructorMarker) null);
    }

    private final Map<String, String> getEventDetails(CallMetadata callMetadata) {
        String str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(EventDetailsKeys.EVENT_VERSION, "1");
        linkedHashMap.put("call_id", callMetadata.getCallID());
        linkedHashMap.put("duration", callMetadata.getDuration());
        linkedHashMap.put(EventDetailsKeys.CALL_END_REASON, callMetadata.getEndCallReason());
        linkedHashMap.put("source", callMetadata.getSource());
        linkedHashMap.put("error", callMetadata.getErrorMessage());
        linkedHashMap.put(EventDetailsKeys.CALL_BUTTONS_TOGGLE, callMetadata.getButtonToggleState());
        Boolean buttonState = callMetadata.getButtonState();
        String str2 = null;
        if (buttonState != null) {
            str = buttonState.toString();
        } else {
            str = null;
        }
        linkedHashMap.put("enabled", str);
        CallRegistrationStatus registrationStatus = callMetadata.getRegistrationStatus();
        if (registrationStatus != null) {
            str2 = registrationStatus.toString();
        }
        linkedHashMap.put("result", str2);
        linkedHashMap.put("provider", callMetadata.getProvider());
        linkedHashMap.put(EventDetailsKeys.RECEIVER_TYPES, callMetadata.getReceiverType());
        linkedHashMap.put(EventDetailsKeys.RECEIVER_USER_ID, callMetadata.getReceiverUserID());
        return linkedHashMap;
    }

    private final UserProperties getUserProperties() {
        return (UserProperties) this.userProperties$delegate.getValue();
    }

    @NotNull
    public Contact createContactObject(@NotNull EventMetadata eventMetadata) {
        return CallEventsFactory.DefaultImpls.createContactObject(this, eventMetadata);
    }

    @NotNull
    public EventCreationRequest createInAppCallButtonClicked(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata) {
        Intrinsics.checkNotNullParameter(eventMetadata, "eventMetadata");
        Intrinsics.checkNotNullParameter(callMetadata, "callMetadata");
        return createEventObject(EventName.IN_APP_CALL_BUTTON_CLICKED, eventMetadata, callMetadata);
    }

    @NotNull
    public EventCreationRequest createInAppCallButtonShown(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata) {
        Intrinsics.checkNotNullParameter(eventMetadata, "eventMetadata");
        Intrinsics.checkNotNullParameter(callMetadata, "callMetadata");
        return createEventObject(EventName.IN_APP_CALL_BUTTON_SHOWN, eventMetadata, callMetadata);
    }

    @NotNull
    public EventCreationRequest createInAppCallCancelled(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata) {
        Intrinsics.checkNotNullParameter(eventMetadata, "eventMetadata");
        Intrinsics.checkNotNullParameter(callMetadata, "callMetadata");
        return createEventObject(EventName.IN_APP_CALL_CANCELLED, eventMetadata, callMetadata);
    }

    @NotNull
    public EventCreationRequest createInAppCallEnded(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata) {
        Intrinsics.checkNotNullParameter(eventMetadata, "eventMetadata");
        Intrinsics.checkNotNullParameter(callMetadata, "callMetadata");
        return createEventObject(EventName.IN_APP_CALL_ENDED, eventMetadata, callMetadata);
    }

    @NotNull
    public EventCreationRequest createInAppCallErrorCaused(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata) {
        Intrinsics.checkNotNullParameter(eventMetadata, "eventMetadata");
        Intrinsics.checkNotNullParameter(callMetadata, "callMetadata");
        return createEventObject(EventName.IN_APP_CALL_ERROR_CAUSED, eventMetadata, callMetadata);
    }

    @NotNull
    public EventCreationRequest createInAppCallMuteButtonClicked(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata) {
        Intrinsics.checkNotNullParameter(eventMetadata, "eventMetadata");
        Intrinsics.checkNotNullParameter(callMetadata, "callMetadata");
        return createEventObject(EventName.IN_APP_CALL_MUTE_BUTTON_CLICKED, eventMetadata, callMetadata);
    }

    @NotNull
    public EventCreationRequest createInAppCallPickedUp(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata) {
        Intrinsics.checkNotNullParameter(eventMetadata, "eventMetadata");
        Intrinsics.checkNotNullParameter(callMetadata, "callMetadata");
        return createEventObject(EventName.IN_APP_CALL_PICKED_UP, eventMetadata, callMetadata);
    }

    @NotNull
    public EventCreationRequest createInAppCallRejected(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata) {
        Intrinsics.checkNotNullParameter(eventMetadata, "eventMetadata");
        Intrinsics.checkNotNullParameter(callMetadata, "callMetadata");
        return createEventObject(EventName.IN_APP_CALL_REJECTED, eventMetadata, callMetadata);
    }

    @NotNull
    public EventCreationRequest createInAppCallRingStarted(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata) {
        Intrinsics.checkNotNullParameter(eventMetadata, "eventMetadata");
        Intrinsics.checkNotNullParameter(callMetadata, "callMetadata");
        return createEventObject(EventName.IN_APP_CALL_RING_STARTED, eventMetadata, callMetadata);
    }

    @NotNull
    public EventCreationRequest createInAppCallSpeakerButtonClicked(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata) {
        Intrinsics.checkNotNullParameter(eventMetadata, "eventMetadata");
        Intrinsics.checkNotNullParameter(callMetadata, "callMetadata");
        return createEventObject(EventName.IN_APP_CALL_SPEAKER_BUTTON_CLICKED, eventMetadata, callMetadata);
    }

    @NotNull
    public EventCreationRequest createInAppCallSurveyDisplayed(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata) {
        Intrinsics.checkNotNullParameter(eventMetadata, "eventMetadata");
        Intrinsics.checkNotNullParameter(callMetadata, "callMetadata");
        return createEventObject(EventName.IN_APP_CALL_SURVEY_DISPLAYED, eventMetadata, callMetadata);
    }

    @NotNull
    public EventCreationRequest createInAppCallSurveySubmitted(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata) {
        Intrinsics.checkNotNullParameter(eventMetadata, "eventMetadata");
        Intrinsics.checkNotNullParameter(callMetadata, "callMetadata");
        return createEventObject(EventName.IN_APP_CALL_SURVEY_SUBMITTED, eventMetadata, callMetadata);
    }

    @NotNull
    public EventCreationRequest createInAppCallTimedOut(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata) {
        Intrinsics.checkNotNullParameter(eventMetadata, "eventMetadata");
        Intrinsics.checkNotNullParameter(callMetadata, "callMetadata");
        return createEventObject(EventName.IN_APP_CALL_TIMED_OUT, eventMetadata, callMetadata);
    }

    @NotNull
    public EventCreationRequest createInAppCallUserRegistered(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata) {
        Intrinsics.checkNotNullParameter(eventMetadata, "eventMetadata");
        Intrinsics.checkNotNullParameter(callMetadata, "callMetadata");
        return createEventObject(EventName.IN_APP_CALL_USER_REGISTERED, eventMetadata, callMetadata);
    }

    @NotNull
    public Product createProductObject(@Nullable UserProperties userProperties) {
        return CallEventsFactory.DefaultImpls.createProductObject(this, userProperties);
    }

    @NotNull
    public EventCreationRequest createTraditionalCallButtonClicked(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata) {
        Intrinsics.checkNotNullParameter(eventMetadata, "eventMetadata");
        Intrinsics.checkNotNullParameter(callMetadata, "callMetadata");
        return createEventObject(EventName.TRADITIONAL_CALL_BUTTON_CLICKED, eventMetadata, callMetadata);
    }

    @NotNull
    public User createUserObject(@NotNull EventMetadata eventMetadata, @Nullable UserProperties userProperties) {
        return CallEventsFactory.DefaultImpls.createUserObject(this, eventMetadata, userProperties);
    }
}
