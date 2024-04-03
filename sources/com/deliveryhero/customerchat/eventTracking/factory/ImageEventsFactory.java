package com.deliveryhero.customerchat.eventTracking.factory;

import com.deliveryhero.customerchat.analytics.model.Contact;
import com.deliveryhero.customerchat.analytics.model.EventCreationRequest;
import com.deliveryhero.customerchat.analytics.model.Product;
import com.deliveryhero.customerchat.analytics.model.User;
import com.deliveryhero.customerchat.eventTracking.data.EventMetadata;
import com.deliveryhero.customerchat.eventTracking.data.ImageMetadata;
import com.deliveryhero.customerchat.eventTracking.data.UserProperties;
import com.deliveryhero.customerchat.eventTracking.factory.EventsFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&J\u001a\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\u001a\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH&¨\u0006\r"}, d2 = {"Lcom/deliveryhero/customerchat/eventTracking/factory/ImageEventsFactory;", "Lcom/deliveryhero/customerchat/eventTracking/factory/EventsFactory;", "createCameraLaunchedEvent", "Lcom/deliveryhero/customerchat/analytics/model/EventCreationRequest;", "eventMetadata", "Lcom/deliveryhero/customerchat/eventTracking/data/EventMetadata;", "createGalleryLaunchedEvent", "createGridLaunchedEvent", "createImageSelectedEvent", "imageMetadata", "Lcom/deliveryhero/customerchat/eventTracking/data/ImageMetadata;", "createImageUploadCanceledEvent", "createImageUploadedEvent", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ImageEventsFactory extends EventsFactory {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @NotNull
        public static Contact createContactObject(@NotNull ImageEventsFactory imageEventsFactory, @NotNull EventMetadata eventMetadata) {
            Intrinsics.checkNotNullParameter(eventMetadata, "eventMetadata");
            return EventsFactory.DefaultImpls.createContactObject(imageEventsFactory, eventMetadata);
        }

        @NotNull
        public static Product createProductObject(@NotNull ImageEventsFactory imageEventsFactory, @Nullable UserProperties userProperties) {
            return EventsFactory.DefaultImpls.createProductObject(imageEventsFactory, userProperties);
        }

        @NotNull
        public static User createUserObject(@NotNull ImageEventsFactory imageEventsFactory, @NotNull EventMetadata eventMetadata, @Nullable UserProperties userProperties) {
            Intrinsics.checkNotNullParameter(eventMetadata, "eventMetadata");
            return EventsFactory.DefaultImpls.createUserObject(imageEventsFactory, eventMetadata, userProperties);
        }
    }

    @NotNull
    EventCreationRequest createCameraLaunchedEvent(@NotNull EventMetadata eventMetadata);

    @NotNull
    EventCreationRequest createGalleryLaunchedEvent(@NotNull EventMetadata eventMetadata);

    @NotNull
    EventCreationRequest createGridLaunchedEvent(@NotNull EventMetadata eventMetadata);

    @NotNull
    EventCreationRequest createImageSelectedEvent(@NotNull EventMetadata eventMetadata, @NotNull ImageMetadata imageMetadata);

    @NotNull
    EventCreationRequest createImageUploadCanceledEvent(@NotNull EventMetadata eventMetadata, @Nullable ImageMetadata imageMetadata);

    @NotNull
    EventCreationRequest createImageUploadedEvent(@NotNull EventMetadata eventMetadata, @Nullable ImageMetadata imageMetadata);
}
