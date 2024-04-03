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
import com.deliveryhero.customerchat.eventTracking.data.ErrorMessageMetadata;
import com.deliveryhero.customerchat.eventTracking.data.EventMetadata;
import com.deliveryhero.customerchat.eventTracking.data.MessageMetadata;
import com.deliveryhero.customerchat.eventTracking.data.MessageType;
import com.deliveryhero.customerchat.eventTracking.data.TranslationMetadata;
import com.deliveryhero.customerchat.eventTracking.data.UserProperties;
import com.deliveryhero.customerchat.eventTracking.factory.MessageEventsFactory;
import com.deliveryhero.customerchat.eventTracking.utils.EventUtils;
import com.google.android.exoplayer2.RendererCapabilities;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010%\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J.\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0012H\u0002J<\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0012H\u0002J\u0018\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010 \u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010!\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\"\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J4\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00160$2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0012H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/deliveryhero/customerchat/eventTracking/factory/MessageEventsFactoryImpl;", "Lcom/deliveryhero/customerchat/eventTracking/factory/MessageEventsFactory;", "eventUtils", "Lcom/deliveryhero/customerchat/eventTracking/utils/EventUtils;", "userPropertiesDataStoreHelper", "Lcom/deliveryhero/customerchat/datastore/UserPropertiesDataStoreHelper;", "(Lcom/deliveryhero/customerchat/eventTracking/utils/EventUtils;Lcom/deliveryhero/customerchat/datastore/UserPropertiesDataStoreHelper;)V", "userProperties", "Lcom/deliveryhero/customerchat/eventTracking/data/UserProperties;", "getUserProperties", "()Lcom/deliveryhero/customerchat/eventTracking/data/UserProperties;", "userProperties$delegate", "Lkotlin/Lazy;", "createErrorSendingMessageEvent", "Lcom/deliveryhero/customerchat/analytics/model/EventCreationRequest;", "eventMetadata", "Lcom/deliveryhero/customerchat/eventTracking/data/EventMetadata;", "errorMetadata", "Lcom/deliveryhero/customerchat/eventTracking/data/ErrorMessageMetadata;", "createEvent", "Lcom/deliveryhero/customerchat/analytics/model/Event;", "etsEventType", "", "messageMetadata", "Lcom/deliveryhero/customerchat/eventTracking/data/MessageMetadata;", "translationMetadata", "Lcom/deliveryhero/customerchat/eventTracking/data/TranslationMetadata;", "errorMessageMetadata", "createEventObject", "eventName", "createMessageDeliveredEvent", "createMessageQuickResponseSelectedEvent", "createMessageSentEvent", "createTranslationActivatedEvent", "createTranslationDeactivatedEvent", "getEventDetails", "", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MessageEventsFactoryImpl implements MessageEventsFactory {
    @NotNull
    private final EventUtils eventUtils;
    @NotNull
    private final Lazy userProperties$delegate = LazyKt__LazyJVMKt.lazy(new MessageEventsFactoryImpl$userProperties$2(this));
    /* access modifiers changed from: private */
    @NotNull
    public final UserPropertiesDataStoreHelper userPropertiesDataStoreHelper;

    public MessageEventsFactoryImpl(@NotNull EventUtils eventUtils2, @NotNull UserPropertiesDataStoreHelper userPropertiesDataStoreHelper2) {
        Intrinsics.checkNotNullParameter(eventUtils2, "eventUtils");
        Intrinsics.checkNotNullParameter(userPropertiesDataStoreHelper2, "userPropertiesDataStoreHelper");
        this.eventUtils = eventUtils2;
        this.userPropertiesDataStoreHelper = userPropertiesDataStoreHelper2;
    }

    public static /* synthetic */ EventCreationRequest a(MessageEventsFactoryImpl messageEventsFactoryImpl, String str, EventMetadata eventMetadata, MessageMetadata messageMetadata, TranslationMetadata translationMetadata, ErrorMessageMetadata errorMessageMetadata, int i11, Object obj) {
        return messageEventsFactoryImpl.createEventObject(str, eventMetadata, (i11 & 4) != 0 ? null : messageMetadata, (i11 & 8) != 0 ? null : translationMetadata, (i11 & 16) != 0 ? null : errorMessageMetadata);
    }

    private final Event createEvent(String str, MessageMetadata messageMetadata, TranslationMetadata translationMetadata, ErrorMessageMetadata errorMessageMetadata) {
        return new Event(this.eventUtils.generateUUID(), str, getEventDetails(messageMetadata, translationMetadata, errorMessageMetadata));
    }

    private final EventCreationRequest createEventObject(String str, EventMetadata eventMetadata, MessageMetadata messageMetadata, TranslationMetadata translationMetadata, ErrorMessageMetadata errorMessageMetadata) {
        EventMetadata eventMetadata2 = eventMetadata;
        String globalEntityID = eventMetadata.getGlobalEntityID();
        String generateTimeStamp = this.eventUtils.generateTimeStamp();
        Order order = new Order(eventMetadata.getOrderID(), (Map) null, 2, (DefaultConstructorMarker) null);
        Contact createContactObject = createContactObject(eventMetadata2);
        User createUserObject = createUserObject(eventMetadata2, getUserProperties());
        String str2 = str;
        return new EventCreationRequest(globalEntityID, generateTimeStamp, createEvent(str, messageMetadata, translationMetadata, errorMessageMetadata), createProductObject(getUserProperties()), createUserObject, order, createContactObject, (Screen) null, (Financial) null, RendererCapabilities.MODE_SUPPORT_MASK, (DefaultConstructorMarker) null);
    }

    private final Map<String, String> getEventDetails(MessageMetadata messageMetadata, TranslationMetadata translationMetadata, ErrorMessageMetadata errorMessageMetadata) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(EventDetailsKeys.EVENT_VERSION, "1");
        if (messageMetadata != null) {
            MessageType messageType = messageMetadata.getMessageType();
            if (messageType != null) {
                linkedHashMap.put("type", messageType.toString());
            }
            linkedHashMap.put(EventDetailsKeys.WORDS, String.valueOf(messageMetadata.getWordCount()));
            linkedHashMap.put(EventDetailsKeys.CHARACTERS, String.valueOf(messageMetadata.getCharacterCount()));
            linkedHashMap.put(EventDetailsKeys.DEFAULT_LANGUAGE, String.valueOf(messageMetadata.getDefaultLanguage()));
            linkedHashMap.put(EventDetailsKeys.ARE_QUICK_RESPONSES_USED, String.valueOf(messageMetadata.isQuickResponseUsed()));
            linkedHashMap.put(EventDetailsKeys.CORRELATION_ID, messageMetadata.getCorrelationId());
            linkedHashMap.put(EventDetailsKeys.QUICK_RESPONSE, messageMetadata.getQuickResponse());
        }
        if (translationMetadata != null) {
            linkedHashMap.put(EventDetailsKeys.TRANSLATION_LANGUAGE, translationMetadata.getDefaultLanguage());
            linkedHashMap.put(EventDetailsKeys.SUPPORTED_LANGUAGES, String.valueOf(translationMetadata.getSupportedTranslations()));
        }
        if (errorMessageMetadata != null) {
            linkedHashMap.put("error_code", errorMessageMetadata.getErrorCode());
            linkedHashMap.put("error_message", errorMessageMetadata.getErrorMessage());
            linkedHashMap.put(EventDetailsKeys.CORRELATION_ID, errorMessageMetadata.getCorrelationID());
        }
        return linkedHashMap;
    }

    private final UserProperties getUserProperties() {
        return (UserProperties) this.userProperties$delegate.getValue();
    }

    @NotNull
    public Contact createContactObject(@NotNull EventMetadata eventMetadata) {
        return MessageEventsFactory.DefaultImpls.createContactObject(this, eventMetadata);
    }

    @NotNull
    public EventCreationRequest createErrorSendingMessageEvent(@NotNull EventMetadata eventMetadata, @NotNull ErrorMessageMetadata errorMessageMetadata) {
        Intrinsics.checkNotNullParameter(eventMetadata, "eventMetadata");
        Intrinsics.checkNotNullParameter(errorMessageMetadata, "errorMetadata");
        return a(this, EventName.ERROR_SENDING_MESSAGE, eventMetadata, (MessageMetadata) null, (TranslationMetadata) null, errorMessageMetadata, 12, (Object) null);
    }

    @NotNull
    public EventCreationRequest createMessageDeliveredEvent(@NotNull EventMetadata eventMetadata, @NotNull MessageMetadata messageMetadata) {
        Intrinsics.checkNotNullParameter(eventMetadata, "eventMetadata");
        Intrinsics.checkNotNullParameter(messageMetadata, "messageMetadata");
        return a(this, EventName.MESSAGE_DELIVERED, eventMetadata, messageMetadata, (TranslationMetadata) null, (ErrorMessageMetadata) null, 24, (Object) null);
    }

    @NotNull
    public EventCreationRequest createMessageQuickResponseSelectedEvent(@NotNull EventMetadata eventMetadata, @NotNull MessageMetadata messageMetadata) {
        Intrinsics.checkNotNullParameter(eventMetadata, "eventMetadata");
        Intrinsics.checkNotNullParameter(messageMetadata, "messageMetadata");
        return a(this, EventName.MESSAGE_QUICK_RESPONSE_SELECTED, eventMetadata, messageMetadata, (TranslationMetadata) null, (ErrorMessageMetadata) null, 24, (Object) null);
    }

    @NotNull
    public EventCreationRequest createMessageSentEvent(@NotNull EventMetadata eventMetadata, @NotNull MessageMetadata messageMetadata) {
        Intrinsics.checkNotNullParameter(eventMetadata, "eventMetadata");
        Intrinsics.checkNotNullParameter(messageMetadata, "messageMetadata");
        return a(this, EventName.MESSAGE_SENT, eventMetadata, messageMetadata, (TranslationMetadata) null, (ErrorMessageMetadata) null, 24, (Object) null);
    }

    @NotNull
    public Product createProductObject(@Nullable UserProperties userProperties) {
        return MessageEventsFactory.DefaultImpls.createProductObject(this, userProperties);
    }

    @NotNull
    public EventCreationRequest createTranslationActivatedEvent(@NotNull EventMetadata eventMetadata, @NotNull TranslationMetadata translationMetadata) {
        Intrinsics.checkNotNullParameter(eventMetadata, "eventMetadata");
        Intrinsics.checkNotNullParameter(translationMetadata, "translationMetadata");
        return a(this, EventName.TRANSLATION_ACTIVATED, eventMetadata, (MessageMetadata) null, translationMetadata, (ErrorMessageMetadata) null, 20, (Object) null);
    }

    @NotNull
    public EventCreationRequest createTranslationDeactivatedEvent(@NotNull EventMetadata eventMetadata, @NotNull TranslationMetadata translationMetadata) {
        Intrinsics.checkNotNullParameter(eventMetadata, "eventMetadata");
        Intrinsics.checkNotNullParameter(translationMetadata, "translationMetadata");
        return a(this, EventName.TRANSLATION_DEACTIVATED, eventMetadata, (MessageMetadata) null, translationMetadata, (ErrorMessageMetadata) null, 20, (Object) null);
    }

    @NotNull
    public User createUserObject(@NotNull EventMetadata eventMetadata, @Nullable UserProperties userProperties) {
        return MessageEventsFactory.DefaultImpls.createUserObject(this, eventMetadata, userProperties);
    }
}
