package com.deliveryhero.customerchat.eventTracking.factory;

import com.deliveryhero.customerchat.analytics.model.Contact;
import com.deliveryhero.customerchat.analytics.model.EventCreationRequest;
import com.deliveryhero.customerchat.analytics.model.Product;
import com.deliveryhero.customerchat.analytics.model.User;
import com.deliveryhero.customerchat.eventTracking.data.EventMetadata;
import com.deliveryhero.customerchat.eventTracking.data.FeatureFlagProperties;
import com.deliveryhero.customerchat.eventTracking.data.UserProperties;
import com.deliveryhero.customerchat.eventTracking.factory.EventsFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/deliveryhero/customerchat/eventTracking/factory/ChatEventsFactory;", "Lcom/deliveryhero/customerchat/eventTracking/factory/EventsFactory;", "createChatClientDisconnectedEvent", "Lcom/deliveryhero/customerchat/analytics/model/EventCreationRequest;", "eventMetadata", "Lcom/deliveryhero/customerchat/eventTracking/data/EventMetadata;", "createChatUIClosedEvent", "createChatUIOpenedEvent", "createFeatureFlagSetEvent", "featureFlagEventProperties", "Lcom/deliveryhero/customerchat/eventTracking/data/FeatureFlagProperties;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ChatEventsFactory extends EventsFactory {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @NotNull
        public static Contact createContactObject(@NotNull ChatEventsFactory chatEventsFactory, @NotNull EventMetadata eventMetadata) {
            Intrinsics.checkNotNullParameter(eventMetadata, "eventMetadata");
            return EventsFactory.DefaultImpls.createContactObject(chatEventsFactory, eventMetadata);
        }

        @NotNull
        public static Product createProductObject(@NotNull ChatEventsFactory chatEventsFactory, @Nullable UserProperties userProperties) {
            return EventsFactory.DefaultImpls.createProductObject(chatEventsFactory, userProperties);
        }

        @NotNull
        public static User createUserObject(@NotNull ChatEventsFactory chatEventsFactory, @NotNull EventMetadata eventMetadata, @Nullable UserProperties userProperties) {
            Intrinsics.checkNotNullParameter(eventMetadata, "eventMetadata");
            return EventsFactory.DefaultImpls.createUserObject(chatEventsFactory, eventMetadata, userProperties);
        }
    }

    @NotNull
    EventCreationRequest createChatClientDisconnectedEvent(@NotNull EventMetadata eventMetadata);

    @NotNull
    EventCreationRequest createChatUIClosedEvent(@NotNull EventMetadata eventMetadata);

    @NotNull
    EventCreationRequest createChatUIOpenedEvent(@NotNull EventMetadata eventMetadata);

    @NotNull
    EventCreationRequest createFeatureFlagSetEvent(@NotNull EventMetadata eventMetadata, @NotNull FeatureFlagProperties featureFlagProperties);
}
