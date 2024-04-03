package com.deliveryhero.customerchat.eventTracking.factory;

import com.deliveryhero.customerchat.analytics.model.Contact;
import com.deliveryhero.customerchat.analytics.model.Product;
import com.deliveryhero.customerchat.analytics.model.User;
import com.deliveryhero.customerchat.eventTracking.constants.ContactDetailsKeys;
import com.deliveryhero.customerchat.eventTracking.data.EventMetadata;
import com.deliveryhero.customerchat.eventTracking.data.UserProperties;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0016\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rH\u0002¨\u0006\u000f"}, d2 = {"Lcom/deliveryhero/customerchat/eventTracking/factory/EventsFactory;", "", "createContactObject", "Lcom/deliveryhero/customerchat/analytics/model/Contact;", "eventMetadata", "Lcom/deliveryhero/customerchat/eventTracking/data/EventMetadata;", "createProductObject", "Lcom/deliveryhero/customerchat/analytics/model/Product;", "userProperties", "Lcom/deliveryhero/customerchat/eventTracking/data/UserProperties;", "createUserObject", "Lcom/deliveryhero/customerchat/analytics/model/User;", "getContactDetails", "", "", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface EventsFactory {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @NotNull
        public static Contact createContactObject(@NotNull EventsFactory eventsFactory, @NotNull EventMetadata eventMetadata) {
            Intrinsics.checkNotNullParameter(eventMetadata, "eventMetadata");
            return new Contact(eventMetadata.getChannelID(), getContactDetails(eventsFactory));
        }

        @NotNull
        public static Product createProductObject(@NotNull EventsFactory eventsFactory, @Nullable UserProperties userProperties) {
            String str;
            if (userProperties != null) {
                str = userProperties.getSdkVersion();
            } else {
                str = null;
            }
            return new Product((String) null, str, 1, (DefaultConstructorMarker) null);
        }

        @NotNull
        public static User createUserObject(@NotNull EventsFactory eventsFactory, @NotNull EventMetadata eventMetadata, @Nullable UserProperties userProperties) {
            Map<String, String> map;
            Intrinsics.checkNotNullParameter(eventMetadata, "eventMetadata");
            String userID = eventMetadata.getUserID();
            if (userProperties != null) {
                map = UserProperties.Companion.toMap(userProperties);
            } else {
                map = null;
            }
            return new User(userID, map);
        }

        private static Map<String, String> getContactDetails(EventsFactory eventsFactory) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(ContactDetailsKeys.SENT_FROM, ContactDetailsKeys.SENT_FROM_VALUE);
            linkedHashMap.put(ContactDetailsKeys.USER_TYPES, ContactDetailsKeys.USER_TYPES_VALUE);
            return linkedHashMap;
        }
    }

    @NotNull
    Contact createContactObject(@NotNull EventMetadata eventMetadata);

    @NotNull
    Product createProductObject(@Nullable UserProperties userProperties);

    @NotNull
    User createUserObject(@NotNull EventMetadata eventMetadata, @Nullable UserProperties userProperties);
}
