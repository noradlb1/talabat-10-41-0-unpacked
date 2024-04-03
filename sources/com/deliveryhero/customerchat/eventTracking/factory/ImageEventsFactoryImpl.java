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
import com.deliveryhero.customerchat.eventTracking.data.EventMetadata;
import com.deliveryhero.customerchat.eventTracking.data.ImageMetadata;
import com.deliveryhero.customerchat.eventTracking.data.UserProperties;
import com.deliveryhero.customerchat.eventTracking.factory.ImageEventsFactory;
import com.deliveryhero.customerchat.eventTracking.utils.EventUtils;
import com.google.android.exoplayer2.RendererCapabilities;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J$\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u0015\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0016\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0017\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J \u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u00192\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/deliveryhero/customerchat/eventTracking/factory/ImageEventsFactoryImpl;", "Lcom/deliveryhero/customerchat/eventTracking/factory/ImageEventsFactory;", "eventUtils", "Lcom/deliveryhero/customerchat/eventTracking/utils/EventUtils;", "userPropertiesDataStoreHelper", "Lcom/deliveryhero/customerchat/datastore/UserPropertiesDataStoreHelper;", "(Lcom/deliveryhero/customerchat/eventTracking/utils/EventUtils;Lcom/deliveryhero/customerchat/datastore/UserPropertiesDataStoreHelper;)V", "createCameraLaunchedEvent", "Lcom/deliveryhero/customerchat/analytics/model/EventCreationRequest;", "eventMetadata", "Lcom/deliveryhero/customerchat/eventTracking/data/EventMetadata;", "createEvent", "Lcom/deliveryhero/customerchat/analytics/model/Event;", "etsEventType", "", "imageMetadata", "Lcom/deliveryhero/customerchat/eventTracking/data/ImageMetadata;", "createEventObject", "eventName", "createGalleryLaunchedEvent", "createGridLaunchedEvent", "createImageSelectedEvent", "createImageUploadCanceledEvent", "createImageUploadedEvent", "getEventDetails", "", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ImageEventsFactoryImpl implements ImageEventsFactory {
    @NotNull
    private final EventUtils eventUtils;
    @NotNull
    private final UserPropertiesDataStoreHelper userPropertiesDataStoreHelper;

    public ImageEventsFactoryImpl(@NotNull EventUtils eventUtils2, @NotNull UserPropertiesDataStoreHelper userPropertiesDataStoreHelper2) {
        Intrinsics.checkNotNullParameter(eventUtils2, "eventUtils");
        Intrinsics.checkNotNullParameter(userPropertiesDataStoreHelper2, "userPropertiesDataStoreHelper");
        this.eventUtils = eventUtils2;
        this.userPropertiesDataStoreHelper = userPropertiesDataStoreHelper2;
    }

    public static /* synthetic */ EventCreationRequest a(ImageEventsFactoryImpl imageEventsFactoryImpl, String str, EventMetadata eventMetadata, ImageMetadata imageMetadata, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            imageMetadata = null;
        }
        return imageEventsFactoryImpl.createEventObject(str, eventMetadata, imageMetadata);
    }

    private final Event createEvent(String str, ImageMetadata imageMetadata) {
        return new Event(this.eventUtils.generateUUID(), str, getEventDetails(imageMetadata));
    }

    private final EventCreationRequest createEventObject(String str, EventMetadata eventMetadata, ImageMetadata imageMetadata) {
        String globalEntityID = eventMetadata.getGlobalEntityID();
        String generateTimeStamp = this.eventUtils.generateTimeStamp();
        Order order = new Order(eventMetadata.getOrderID(), (Map) null, 2, (DefaultConstructorMarker) null);
        Contact createContactObject = createContactObject(eventMetadata);
        User createUserObject = createUserObject(eventMetadata, this.userPropertiesDataStoreHelper.getLatestUserProperties());
        return new EventCreationRequest(globalEntityID, generateTimeStamp, createEvent(str, imageMetadata), createProductObject(this.userPropertiesDataStoreHelper.getLatestUserProperties()), createUserObject, order, createContactObject, (Screen) null, (Financial) null, RendererCapabilities.MODE_SUPPORT_MASK, (DefaultConstructorMarker) null);
    }

    private final Map<String, String> getEventDetails(ImageMetadata imageMetadata) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(EventDetailsKeys.EVENT_VERSION, "1");
        if (imageMetadata != null) {
            String lowerCase = imageMetadata.getSource().name().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            linkedHashMap.put("source", lowerCase);
            linkedHashMap.put(EventDetailsKeys.IMAGE_WIDTH, imageMetadata.getImageWidth());
            linkedHashMap.put(EventDetailsKeys.IMAGE_HEIGHT, imageMetadata.getImageHeight());
            linkedHashMap.put(EventDetailsKeys.IMAGE_SIZE, imageMetadata.getImageSizeInKB());
            linkedHashMap.put(EventDetailsKeys.IMAGE_UPLOAD_DURATION, imageMetadata.getImageUploadDuration());
            linkedHashMap.put(EventDetailsKeys.COMPRESSION_ALGORITHM, (Object) null);
            linkedHashMap.put(EventDetailsKeys.COMPRESSION_DURATION, (Object) null);
        }
        return linkedHashMap;
    }

    @NotNull
    public EventCreationRequest createCameraLaunchedEvent(@NotNull EventMetadata eventMetadata) {
        Intrinsics.checkNotNullParameter(eventMetadata, "eventMetadata");
        return a(this, EventName.CAMERA_LAUNCHED, eventMetadata, (ImageMetadata) null, 4, (Object) null);
    }

    @NotNull
    public Contact createContactObject(@NotNull EventMetadata eventMetadata) {
        return ImageEventsFactory.DefaultImpls.createContactObject(this, eventMetadata);
    }

    @NotNull
    public EventCreationRequest createGalleryLaunchedEvent(@NotNull EventMetadata eventMetadata) {
        Intrinsics.checkNotNullParameter(eventMetadata, "eventMetadata");
        return a(this, EventName.GALLERY_LAUNCHED, eventMetadata, (ImageMetadata) null, 4, (Object) null);
    }

    @NotNull
    public EventCreationRequest createGridLaunchedEvent(@NotNull EventMetadata eventMetadata) {
        Intrinsics.checkNotNullParameter(eventMetadata, "eventMetadata");
        return a(this, EventName.GRID_LAUNCHED, eventMetadata, (ImageMetadata) null, 4, (Object) null);
    }

    @NotNull
    public EventCreationRequest createImageSelectedEvent(@NotNull EventMetadata eventMetadata, @NotNull ImageMetadata imageMetadata) {
        Intrinsics.checkNotNullParameter(eventMetadata, "eventMetadata");
        Intrinsics.checkNotNullParameter(imageMetadata, "imageMetadata");
        return createEventObject(EventName.IMAGE_SELECTED, eventMetadata, imageMetadata);
    }

    @NotNull
    public EventCreationRequest createImageUploadCanceledEvent(@NotNull EventMetadata eventMetadata, @Nullable ImageMetadata imageMetadata) {
        Intrinsics.checkNotNullParameter(eventMetadata, "eventMetadata");
        return createEventObject(EventName.IMAGE_UPLOAD_CANCELED, eventMetadata, imageMetadata);
    }

    @NotNull
    public EventCreationRequest createImageUploadedEvent(@NotNull EventMetadata eventMetadata, @Nullable ImageMetadata imageMetadata) {
        Intrinsics.checkNotNullParameter(eventMetadata, "eventMetadata");
        return createEventObject(EventName.IMAGE_UPLOADED, eventMetadata, imageMetadata);
    }

    @NotNull
    public Product createProductObject(@Nullable UserProperties userProperties) {
        return ImageEventsFactory.DefaultImpls.createProductObject(this, userProperties);
    }

    @NotNull
    public User createUserObject(@NotNull EventMetadata eventMetadata, @Nullable UserProperties userProperties) {
        return ImageEventsFactory.DefaultImpls.createUserObject(this, eventMetadata, userProperties);
    }
}
