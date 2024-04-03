package com.talabat.newrelic;

import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J5\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/talabat/newrelic/NewRelicPendingEvent;", "", "eventType", "", "eventName", "attributes", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getAttributes", "()Ljava/util/Map;", "getEventName", "()Ljava/lang/String;", "getEventType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_ThirdPartyLibs_NewRelic_NewRelic"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NewRelicPendingEvent {
    @NotNull
    private final Map<String, String> attributes;
    @Nullable
    private final String eventName;
    @NotNull
    private final String eventType;

    public NewRelicPendingEvent(@NotNull String str, @Nullable String str2, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        this.eventType = str;
        this.eventName = str2;
        this.attributes = map;
    }

    public static /* synthetic */ NewRelicPendingEvent copy$default(NewRelicPendingEvent newRelicPendingEvent, String str, String str2, Map<String, String> map, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = newRelicPendingEvent.eventType;
        }
        if ((i11 & 2) != 0) {
            str2 = newRelicPendingEvent.eventName;
        }
        if ((i11 & 4) != 0) {
            map = newRelicPendingEvent.attributes;
        }
        return newRelicPendingEvent.copy(str, str2, map);
    }

    @NotNull
    public final String component1() {
        return this.eventType;
    }

    @Nullable
    public final String component2() {
        return this.eventName;
    }

    @NotNull
    public final Map<String, String> component3() {
        return this.attributes;
    }

    @NotNull
    public final NewRelicPendingEvent copy(@NotNull String str, @Nullable String str2, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        return new NewRelicPendingEvent(str, str2, map);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NewRelicPendingEvent)) {
            return false;
        }
        NewRelicPendingEvent newRelicPendingEvent = (NewRelicPendingEvent) obj;
        return Intrinsics.areEqual((Object) this.eventType, (Object) newRelicPendingEvent.eventType) && Intrinsics.areEqual((Object) this.eventName, (Object) newRelicPendingEvent.eventName) && Intrinsics.areEqual((Object) this.attributes, (Object) newRelicPendingEvent.attributes);
    }

    @NotNull
    public final Map<String, String> getAttributes() {
        return this.attributes;
    }

    @Nullable
    public final String getEventName() {
        return this.eventName;
    }

    @NotNull
    public final String getEventType() {
        return this.eventType;
    }

    public int hashCode() {
        int hashCode = this.eventType.hashCode() * 31;
        String str = this.eventName;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.attributes.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.eventType;
        String str2 = this.eventName;
        Map<String, String> map = this.attributes;
        return "NewRelicPendingEvent(eventType=" + str + ", eventName=" + str2 + ", attributes=" + map + ")";
    }
}
