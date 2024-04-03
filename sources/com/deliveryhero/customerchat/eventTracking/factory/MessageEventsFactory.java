package com.deliveryhero.customerchat.eventTracking.factory;

import com.deliveryhero.customerchat.analytics.model.Contact;
import com.deliveryhero.customerchat.analytics.model.EventCreationRequest;
import com.deliveryhero.customerchat.analytics.model.Product;
import com.deliveryhero.customerchat.analytics.model.User;
import com.deliveryhero.customerchat.eventTracking.data.ErrorMessageMetadata;
import com.deliveryhero.customerchat.eventTracking.data.EventMetadata;
import com.deliveryhero.customerchat.eventTracking.data.MessageMetadata;
import com.deliveryhero.customerchat.eventTracking.data.TranslationMetadata;
import com.deliveryhero.customerchat.eventTracking.data.UserProperties;
import com.deliveryhero.customerchat.eventTracking.factory.EventsFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH&¨\u0006\u0011"}, d2 = {"Lcom/deliveryhero/customerchat/eventTracking/factory/MessageEventsFactory;", "Lcom/deliveryhero/customerchat/eventTracking/factory/EventsFactory;", "createErrorSendingMessageEvent", "Lcom/deliveryhero/customerchat/analytics/model/EventCreationRequest;", "eventMetadata", "Lcom/deliveryhero/customerchat/eventTracking/data/EventMetadata;", "errorMetadata", "Lcom/deliveryhero/customerchat/eventTracking/data/ErrorMessageMetadata;", "createMessageDeliveredEvent", "messageMetadata", "Lcom/deliveryhero/customerchat/eventTracking/data/MessageMetadata;", "createMessageQuickResponseSelectedEvent", "createMessageSentEvent", "createTranslationActivatedEvent", "translationMetadata", "Lcom/deliveryhero/customerchat/eventTracking/data/TranslationMetadata;", "createTranslationDeactivatedEvent", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface MessageEventsFactory extends EventsFactory {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @NotNull
        public static Contact createContactObject(@NotNull MessageEventsFactory messageEventsFactory, @NotNull EventMetadata eventMetadata) {
            Intrinsics.checkNotNullParameter(eventMetadata, "eventMetadata");
            return EventsFactory.DefaultImpls.createContactObject(messageEventsFactory, eventMetadata);
        }

        @NotNull
        public static Product createProductObject(@NotNull MessageEventsFactory messageEventsFactory, @Nullable UserProperties userProperties) {
            return EventsFactory.DefaultImpls.createProductObject(messageEventsFactory, userProperties);
        }

        @NotNull
        public static User createUserObject(@NotNull MessageEventsFactory messageEventsFactory, @NotNull EventMetadata eventMetadata, @Nullable UserProperties userProperties) {
            Intrinsics.checkNotNullParameter(eventMetadata, "eventMetadata");
            return EventsFactory.DefaultImpls.createUserObject(messageEventsFactory, eventMetadata, userProperties);
        }
    }

    @NotNull
    EventCreationRequest createErrorSendingMessageEvent(@NotNull EventMetadata eventMetadata, @NotNull ErrorMessageMetadata errorMessageMetadata);

    @NotNull
    EventCreationRequest createMessageDeliveredEvent(@NotNull EventMetadata eventMetadata, @NotNull MessageMetadata messageMetadata);

    @NotNull
    EventCreationRequest createMessageQuickResponseSelectedEvent(@NotNull EventMetadata eventMetadata, @NotNull MessageMetadata messageMetadata);

    @NotNull
    EventCreationRequest createMessageSentEvent(@NotNull EventMetadata eventMetadata, @NotNull MessageMetadata messageMetadata);

    @NotNull
    EventCreationRequest createTranslationActivatedEvent(@NotNull EventMetadata eventMetadata, @NotNull TranslationMetadata translationMetadata);

    @NotNull
    EventCreationRequest createTranslationDeactivatedEvent(@NotNull EventMetadata eventMetadata, @NotNull TranslationMetadata translationMetadata);
}
