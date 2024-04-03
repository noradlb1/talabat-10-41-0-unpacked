package com.talabat.fluttercore.channels.dto;

import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\bHÆ\u0003JE\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u001f\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/talabat/fluttercore/channels/dto/TrackEventMethodCallArguments;", "", "eventName", "", "featureName", "attributes", "", "platforms", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;)V", "getAttributes", "()Ljava/util/Map;", "getEventName", "()Ljava/lang/String;", "getFeatureName", "getPlatforms", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_TalabatFlutterCore_TalabatFlutterCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TrackEventMethodCallArguments {
    @NotNull
    private final Map<String, Object> attributes;
    @NotNull
    private final String eventName;
    @NotNull
    private final String featureName;
    @NotNull
    private final List<String> platforms;

    public TrackEventMethodCallArguments(@NotNull String str, @NotNull String str2, @NotNull Map<String, ? extends Object> map, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(str2, "featureName");
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        Intrinsics.checkNotNullParameter(list, AnalyticsMethodChannel.EVENT_PLATFORMS_KEY);
        this.eventName = str;
        this.featureName = str2;
        this.attributes = map;
        this.platforms = list;
    }

    public static /* synthetic */ TrackEventMethodCallArguments copy$default(TrackEventMethodCallArguments trackEventMethodCallArguments, String str, String str2, Map<String, Object> map, List<String> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = trackEventMethodCallArguments.eventName;
        }
        if ((i11 & 2) != 0) {
            str2 = trackEventMethodCallArguments.featureName;
        }
        if ((i11 & 4) != 0) {
            map = trackEventMethodCallArguments.attributes;
        }
        if ((i11 & 8) != 0) {
            list = trackEventMethodCallArguments.platforms;
        }
        return trackEventMethodCallArguments.copy(str, str2, map, list);
    }

    @NotNull
    public final String component1() {
        return this.eventName;
    }

    @NotNull
    public final String component2() {
        return this.featureName;
    }

    @NotNull
    public final Map<String, Object> component3() {
        return this.attributes;
    }

    @NotNull
    public final List<String> component4() {
        return this.platforms;
    }

    @NotNull
    public final TrackEventMethodCallArguments copy(@NotNull String str, @NotNull String str2, @NotNull Map<String, ? extends Object> map, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(str2, "featureName");
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        Intrinsics.checkNotNullParameter(list, AnalyticsMethodChannel.EVENT_PLATFORMS_KEY);
        return new TrackEventMethodCallArguments(str, str2, map, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TrackEventMethodCallArguments)) {
            return false;
        }
        TrackEventMethodCallArguments trackEventMethodCallArguments = (TrackEventMethodCallArguments) obj;
        return Intrinsics.areEqual((Object) this.eventName, (Object) trackEventMethodCallArguments.eventName) && Intrinsics.areEqual((Object) this.featureName, (Object) trackEventMethodCallArguments.featureName) && Intrinsics.areEqual((Object) this.attributes, (Object) trackEventMethodCallArguments.attributes) && Intrinsics.areEqual((Object) this.platforms, (Object) trackEventMethodCallArguments.platforms);
    }

    @NotNull
    public final Map<String, Object> getAttributes() {
        return this.attributes;
    }

    @NotNull
    public final String getEventName() {
        return this.eventName;
    }

    @NotNull
    public final String getFeatureName() {
        return this.featureName;
    }

    @NotNull
    public final List<String> getPlatforms() {
        return this.platforms;
    }

    public int hashCode() {
        return (((((this.eventName.hashCode() * 31) + this.featureName.hashCode()) * 31) + this.attributes.hashCode()) * 31) + this.platforms.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.eventName;
        String str2 = this.featureName;
        Map<String, Object> map = this.attributes;
        List<String> list = this.platforms;
        return "TrackEventMethodCallArguments(eventName=" + str + ", featureName=" + str2 + ", attributes=" + map + ", platforms=" + list + ")";
    }
}
