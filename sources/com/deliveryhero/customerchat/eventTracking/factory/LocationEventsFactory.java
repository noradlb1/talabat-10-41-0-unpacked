package com.deliveryhero.customerchat.eventTracking.factory;

import com.deliveryhero.customerchat.analytics.model.Contact;
import com.deliveryhero.customerchat.analytics.model.EventCreationRequest;
import com.deliveryhero.customerchat.analytics.model.Product;
import com.deliveryhero.customerchat.analytics.model.User;
import com.deliveryhero.customerchat.eventTracking.data.EventMetadata;
import com.deliveryhero.customerchat.eventTracking.data.UserProperties;
import com.deliveryhero.customerchat.eventTracking.factory.EventsFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/deliveryhero/customerchat/eventTracking/factory/LocationEventsFactory;", "Lcom/deliveryhero/customerchat/eventTracking/factory/EventsFactory;", "createLocationClickedEvent", "Lcom/deliveryhero/customerchat/analytics/model/EventCreationRequest;", "eventMetadata", "Lcom/deliveryhero/customerchat/eventTracking/data/EventMetadata;", "createLocationPickerLaunchedEvent", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface LocationEventsFactory extends EventsFactory {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @NotNull
        public static Contact createContactObject(@NotNull LocationEventsFactory locationEventsFactory, @NotNull EventMetadata eventMetadata) {
            Intrinsics.checkNotNullParameter(eventMetadata, "eventMetadata");
            return EventsFactory.DefaultImpls.createContactObject(locationEventsFactory, eventMetadata);
        }

        @NotNull
        public static Product createProductObject(@NotNull LocationEventsFactory locationEventsFactory, @Nullable UserProperties userProperties) {
            return EventsFactory.DefaultImpls.createProductObject(locationEventsFactory, userProperties);
        }

        @NotNull
        public static User createUserObject(@NotNull LocationEventsFactory locationEventsFactory, @NotNull EventMetadata eventMetadata, @Nullable UserProperties userProperties) {
            Intrinsics.checkNotNullParameter(eventMetadata, "eventMetadata");
            return EventsFactory.DefaultImpls.createUserObject(locationEventsFactory, eventMetadata, userProperties);
        }
    }

    @NotNull
    EventCreationRequest createLocationClickedEvent(@NotNull EventMetadata eventMetadata);

    @NotNull
    EventCreationRequest createLocationPickerLaunchedEvent(@NotNull EventMetadata eventMetadata);
}
