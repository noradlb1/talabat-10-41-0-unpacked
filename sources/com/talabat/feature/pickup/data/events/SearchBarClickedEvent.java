package com.talabat.feature.pickup.data.events;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u001e\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\rHÖ\u0003J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u001d"}, d2 = {"Lcom/talabat/feature/pickup/data/events/SearchBarClickedEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "screenName", "", "screenType", "eventOrigin", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEventOrigin", "()Ljava/lang/String;", "getScreenName", "getScreenType", "attributes", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "component1", "component2", "component3", "copy", "equals", "", "other", "featureName", "hashCode", "", "name", "toString", "Companion", "com_talabat_feature_pickup_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SearchBarClickedEvent extends TalabatEvent {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String EVENT_NAME = "search_bar_clicked";
    @NotNull
    private final String eventOrigin;
    @NotNull
    private final String screenName;
    @NotNull
    private final String screenType;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/feature/pickup/data/events/SearchBarClickedEvent$Companion;", "", "()V", "EVENT_NAME", "", "com_talabat_feature_pickup_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SearchBarClickedEvent(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        Intrinsics.checkNotNullParameter(str2, "screenType");
        Intrinsics.checkNotNullParameter(str3, "eventOrigin");
        this.screenName = str;
        this.screenType = str2;
        this.eventOrigin = str3;
    }

    public static /* synthetic */ SearchBarClickedEvent copy$default(SearchBarClickedEvent searchBarClickedEvent, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = searchBarClickedEvent.screenName;
        }
        if ((i11 & 2) != 0) {
            str2 = searchBarClickedEvent.screenType;
        }
        if ((i11 & 4) != 0) {
            str3 = searchBarClickedEvent.eventOrigin;
        }
        return searchBarClickedEvent.copy(str, str2, str3);
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return MapsKt__MapsKt.mutableMapOf(TuplesKt.to("screenType", this.screenType), TuplesKt.to("screenName", this.screenName), TuplesKt.to("eventOrigin", this.eventOrigin));
    }

    @NotNull
    public final String component1() {
        return this.screenName;
    }

    @NotNull
    public final String component2() {
        return this.screenType;
    }

    @NotNull
    public final String component3() {
        return this.eventOrigin;
    }

    @NotNull
    public final SearchBarClickedEvent copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        Intrinsics.checkNotNullParameter(str2, "screenType");
        Intrinsics.checkNotNullParameter(str3, "eventOrigin");
        return new SearchBarClickedEvent(str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SearchBarClickedEvent)) {
            return false;
        }
        SearchBarClickedEvent searchBarClickedEvent = (SearchBarClickedEvent) obj;
        return Intrinsics.areEqual((Object) this.screenName, (Object) searchBarClickedEvent.screenName) && Intrinsics.areEqual((Object) this.screenType, (Object) searchBarClickedEvent.screenType) && Intrinsics.areEqual((Object) this.eventOrigin, (Object) searchBarClickedEvent.eventOrigin);
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "pickup";
    }

    @NotNull
    public final String getEventOrigin() {
        return this.eventOrigin;
    }

    @NotNull
    public final String getScreenName() {
        return this.screenName;
    }

    @NotNull
    public final String getScreenType() {
        return this.screenType;
    }

    public int hashCode() {
        return (((this.screenName.hashCode() * 31) + this.screenType.hashCode()) * 31) + this.eventOrigin.hashCode();
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "search_bar_clicked";
    }

    @NotNull
    public String toString() {
        String str = this.screenName;
        String str2 = this.screenType;
        String str3 = this.eventOrigin;
        return "SearchBarClickedEvent(screenName=" + str + ", screenType=" + str2 + ", eventOrigin=" + str3 + ")";
    }
}
