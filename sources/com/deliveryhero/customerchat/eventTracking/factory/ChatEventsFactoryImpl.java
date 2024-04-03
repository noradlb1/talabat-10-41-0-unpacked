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
import com.deliveryhero.customerchat.eventTracking.data.FeatureFlagProperties;
import com.deliveryhero.customerchat.eventTracking.data.UserProperties;
import com.deliveryhero.customerchat.eventTracking.factory.ChatEventsFactory;
import com.deliveryhero.customerchat.eventTracking.utils.EventUtils;
import com.google.android.exoplayer2.RendererCapabilities;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J&\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0018H\u0002J0\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u00102\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0018H\u0002J\u0018\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J(\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u001f*\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0018H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/deliveryhero/customerchat/eventTracking/factory/ChatEventsFactoryImpl;", "Lcom/deliveryhero/customerchat/eventTracking/factory/ChatEventsFactory;", "eventUtils", "Lcom/deliveryhero/customerchat/eventTracking/utils/EventUtils;", "userPropertiesDataStoreHelper", "Lcom/deliveryhero/customerchat/datastore/UserPropertiesDataStoreHelper;", "(Lcom/deliveryhero/customerchat/eventTracking/utils/EventUtils;Lcom/deliveryhero/customerchat/datastore/UserPropertiesDataStoreHelper;)V", "userProperties", "Lcom/deliveryhero/customerchat/eventTracking/data/UserProperties;", "getUserProperties", "()Lcom/deliveryhero/customerchat/eventTracking/data/UserProperties;", "userProperties$delegate", "Lkotlin/Lazy;", "createChatClientDisconnectedEvent", "Lcom/deliveryhero/customerchat/analytics/model/EventCreationRequest;", "eventMetadata", "Lcom/deliveryhero/customerchat/eventTracking/data/EventMetadata;", "createChatUIClosedEvent", "createChatUIOpenedEvent", "createEvent", "Lcom/deliveryhero/customerchat/analytics/model/Event;", "etsEventType", "", "eventDetails", "", "createEventObject", "eventName", "createFeatureFlagSetEvent", "featureFlagEventProperties", "Lcom/deliveryhero/customerchat/eventTracking/data/FeatureFlagProperties;", "addEventsVersion", "", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ChatEventsFactoryImpl implements ChatEventsFactory {
    @NotNull
    private final EventUtils eventUtils;
    @NotNull
    private final Lazy userProperties$delegate = LazyKt__LazyJVMKt.lazy(new ChatEventsFactoryImpl$userProperties$2(this));
    /* access modifiers changed from: private */
    @NotNull
    public final UserPropertiesDataStoreHelper userPropertiesDataStoreHelper;

    public ChatEventsFactoryImpl(@NotNull EventUtils eventUtils2, @NotNull UserPropertiesDataStoreHelper userPropertiesDataStoreHelper2) {
        Intrinsics.checkNotNullParameter(eventUtils2, "eventUtils");
        Intrinsics.checkNotNullParameter(userPropertiesDataStoreHelper2, "userPropertiesDataStoreHelper");
        this.eventUtils = eventUtils2;
        this.userPropertiesDataStoreHelper = userPropertiesDataStoreHelper2;
    }

    public static /* synthetic */ EventCreationRequest a(ChatEventsFactoryImpl chatEventsFactoryImpl, String str, EventMetadata eventMetadata, Map map, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            map = MapsKt__MapsKt.emptyMap();
        }
        return chatEventsFactoryImpl.createEventObject(str, eventMetadata, map);
    }

    private final Map<String, String> addEventsVersion(Map<String, String> map) {
        Map<String, String> mutableMap = MapsKt__MapsKt.toMutableMap(map);
        mutableMap.put(EventDetailsKeys.EVENT_VERSION, "1");
        return mutableMap;
    }

    private final Event createEvent(String str, Map<String, String> map) {
        return new Event(this.eventUtils.generateUUID(), str, addEventsVersion(map));
    }

    private final EventCreationRequest createEventObject(String str, EventMetadata eventMetadata, Map<String, String> map) {
        String globalEntityID = eventMetadata.getGlobalEntityID();
        String generateTimeStamp = this.eventUtils.generateTimeStamp();
        Order order = new Order(eventMetadata.getOrderID(), (Map) null, 2, (DefaultConstructorMarker) null);
        Contact createContactObject = createContactObject(eventMetadata);
        User createUserObject = createUserObject(eventMetadata, getUserProperties());
        return new EventCreationRequest(globalEntityID, generateTimeStamp, createEvent(str, map), createProductObject(getUserProperties()), createUserObject, order, createContactObject, (Screen) null, (Financial) null, RendererCapabilities.MODE_SUPPORT_MASK, (DefaultConstructorMarker) null);
    }

    private final UserProperties getUserProperties() {
        return (UserProperties) this.userProperties$delegate.getValue();
    }

    @NotNull
    public EventCreationRequest createChatClientDisconnectedEvent(@NotNull EventMetadata eventMetadata) {
        Intrinsics.checkNotNullParameter(eventMetadata, "eventMetadata");
        return a(this, EventName.CHAT_CLIENT_DISCONNECTED, eventMetadata, (Map) null, 4, (Object) null);
    }

    @NotNull
    public EventCreationRequest createChatUIClosedEvent(@NotNull EventMetadata eventMetadata) {
        Intrinsics.checkNotNullParameter(eventMetadata, "eventMetadata");
        return a(this, EventName.CHAT_UI_CLOSED, eventMetadata, (Map) null, 4, (Object) null);
    }

    @NotNull
    public EventCreationRequest createChatUIOpenedEvent(@NotNull EventMetadata eventMetadata) {
        Intrinsics.checkNotNullParameter(eventMetadata, "eventMetadata");
        return a(this, EventName.CHAT_UI_OPENED, eventMetadata, (Map) null, 4, (Object) null);
    }

    @NotNull
    public Contact createContactObject(@NotNull EventMetadata eventMetadata) {
        return ChatEventsFactory.DefaultImpls.createContactObject(this, eventMetadata);
    }

    @NotNull
    public EventCreationRequest createFeatureFlagSetEvent(@NotNull EventMetadata eventMetadata, @NotNull FeatureFlagProperties featureFlagProperties) {
        Intrinsics.checkNotNullParameter(eventMetadata, "eventMetadata");
        Intrinsics.checkNotNullParameter(featureFlagProperties, "featureFlagEventProperties");
        return createEventObject(EventName.FEATURE_FLAG_SET, eventMetadata, FeatureFlagProperties.Companion.toMap(featureFlagProperties));
    }

    @NotNull
    public Product createProductObject(@Nullable UserProperties userProperties) {
        return ChatEventsFactory.DefaultImpls.createProductObject(this, userProperties);
    }

    @NotNull
    public User createUserObject(@NotNull EventMetadata eventMetadata, @Nullable UserProperties userProperties) {
        return ChatEventsFactory.DefaultImpls.createUserObject(this, eventMetadata, userProperties);
    }
}
