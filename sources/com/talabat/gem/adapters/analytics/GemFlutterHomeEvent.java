package com.talabat.gem.adapters.analytics;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import com.talabat.userandlocation.customerinfo.data.local.impl.CustomerInfoLocalDataSourceImpl;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\b\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B;\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u001e\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003JG\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00120 H\u0016J\t\u0010!\u001a\u00020\u0003HÖ\u0001R!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006#"}, d2 = {"Lcom/talabat/gem/adapters/analytics/GemFlutterHomeEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "source", "", "gemHomeData", "", "", "noDataReason", "info", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V", "getGemHomeData", "()Ljava/util/Map;", "getInfo", "()Ljava/lang/String;", "getNoDataReason", "getSource", "attributes", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "featureName", "hashCode", "", "name", "platforms", "", "toString", "Companion", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemFlutterHomeEvent extends TalabatEvent {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String EVENT_NAME = "gem_flutter_home";
    @NotNull
    public static final String FEATURE_NAME = "Gem_Events";
    @Nullable
    private final Map<String, Object> gemHomeData;
    @Nullable
    private final String info;
    @Nullable
    private final String noDataReason;
    @Nullable
    private final String source;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/gem/adapters/analytics/GemFlutterHomeEvent$Companion;", "", "()V", "EVENT_NAME", "", "FEATURE_NAME", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public GemFlutterHomeEvent(@Nullable String str, @Nullable Map<String, ? extends Object> map, @Nullable String str2, @Nullable String str3) {
        this.source = str;
        this.gemHomeData = map;
        this.noDataReason = str2;
        this.info = str3;
    }

    public static /* synthetic */ GemFlutterHomeEvent copy$default(GemFlutterHomeEvent gemFlutterHomeEvent, String str, Map<String, Object> map, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = gemFlutterHomeEvent.source;
        }
        if ((i11 & 2) != 0) {
            map = gemFlutterHomeEvent.gemHomeData;
        }
        if ((i11 & 4) != 0) {
            str2 = gemFlutterHomeEvent.noDataReason;
        }
        if ((i11 & 8) != 0) {
            str3 = gemFlutterHomeEvent.info;
        }
        return gemFlutterHomeEvent.copy(str, map, str2, str3);
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String str = this.info;
        if (str != null) {
            linkedHashMap.put(CustomerInfoLocalDataSourceImpl.KEY, str);
        }
        if (this.noDataReason != null) {
            linkedHashMap.put("status", "no_data");
            linkedHashMap.put("no_data_reason", this.noDataReason);
        } else {
            linkedHashMap.put("status", "success");
            String str2 = this.source;
            if (str2 != null) {
                linkedHashMap.put("source", str2);
            }
            Map<String, Object> map = this.gemHomeData;
            if (map != null) {
                linkedHashMap.put("gem_home_data", map);
            }
        }
        return linkedHashMap;
    }

    @Nullable
    public final String component1() {
        return this.source;
    }

    @Nullable
    public final Map<String, Object> component2() {
        return this.gemHomeData;
    }

    @Nullable
    public final String component3() {
        return this.noDataReason;
    }

    @Nullable
    public final String component4() {
        return this.info;
    }

    @NotNull
    public final GemFlutterHomeEvent copy(@Nullable String str, @Nullable Map<String, ? extends Object> map, @Nullable String str2, @Nullable String str3) {
        return new GemFlutterHomeEvent(str, map, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GemFlutterHomeEvent)) {
            return false;
        }
        GemFlutterHomeEvent gemFlutterHomeEvent = (GemFlutterHomeEvent) obj;
        return Intrinsics.areEqual((Object) this.source, (Object) gemFlutterHomeEvent.source) && Intrinsics.areEqual((Object) this.gemHomeData, (Object) gemFlutterHomeEvent.gemHomeData) && Intrinsics.areEqual((Object) this.noDataReason, (Object) gemFlutterHomeEvent.noDataReason) && Intrinsics.areEqual((Object) this.info, (Object) gemFlutterHomeEvent.info);
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "Gem_Events";
    }

    @Nullable
    public final Map<String, Object> getGemHomeData() {
        return this.gemHomeData;
    }

    @Nullable
    public final String getInfo() {
        return this.info;
    }

    @Nullable
    public final String getNoDataReason() {
        return this.noDataReason;
    }

    @Nullable
    public final String getSource() {
        return this.source;
    }

    public int hashCode() {
        String str = this.source;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Map<String, Object> map = this.gemHomeData;
        int hashCode2 = (hashCode + (map == null ? 0 : map.hashCode())) * 31;
        String str2 = this.noDataReason;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.info;
        if (str3 != null) {
            i11 = str3.hashCode();
        }
        return hashCode3 + i11;
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return EVENT_NAME;
    }

    @NotNull
    public List<PlatformName> platforms() {
        return CollectionsKt__CollectionsJVMKt.listOf(PlatformName.NEW_RELIC);
    }

    @NotNull
    public String toString() {
        String str = this.source;
        Map<String, Object> map = this.gemHomeData;
        String str2 = this.noDataReason;
        String str3 = this.info;
        return "GemFlutterHomeEvent(source=" + str + ", gemHomeData=" + map + ", noDataReason=" + str2 + ", info=" + str3 + ")";
    }
}
