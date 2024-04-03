package com.talabat.fluttercore.tracking.event;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0002\u0010\nJ\u001e\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016J\t\u0010\r\u001a\u00020\u0003HÂ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÂ\u0003J\u0017\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006HÂ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\tHÂ\u0003JE\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tHÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\f0\tH\u0016J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/talabat/fluttercore/tracking/event/FlutterEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "name", "", "featureName", "attributes", "", "", "platforms", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;)V", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_TalabatFlutterCore_TalabatFlutterCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FlutterEvent extends TalabatEvent {
    @NotNull
    private final Map<String, Object> attributes;
    @NotNull
    private final String featureName;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f59794name;
    @NotNull
    private final List<String> platforms;

    public FlutterEvent(@NotNull String str, @NotNull String str2, @NotNull Map<String, ? extends Object> map, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "featureName");
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        Intrinsics.checkNotNullParameter(list, AnalyticsMethodChannel.EVENT_PLATFORMS_KEY);
        this.f59794name = str;
        this.featureName = str2;
        this.attributes = map;
        this.platforms = list;
    }

    private final String component1() {
        return this.f59794name;
    }

    private final String component2() {
        return this.featureName;
    }

    private final Map<String, Object> component3() {
        return this.attributes;
    }

    private final List<String> component4() {
        return this.platforms;
    }

    public static /* synthetic */ FlutterEvent copy$default(FlutterEvent flutterEvent, String str, String str2, Map<String, Object> map, List<String> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = flutterEvent.f59794name;
        }
        if ((i11 & 2) != 0) {
            str2 = flutterEvent.featureName;
        }
        if ((i11 & 4) != 0) {
            map = flutterEvent.attributes;
        }
        if ((i11 & 8) != 0) {
            list = flutterEvent.platforms;
        }
        return flutterEvent.copy(str, str2, map, list);
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return this.attributes;
    }

    @NotNull
    public final FlutterEvent copy(@NotNull String str, @NotNull String str2, @NotNull Map<String, ? extends Object> map, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "featureName");
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        Intrinsics.checkNotNullParameter(list, AnalyticsMethodChannel.EVENT_PLATFORMS_KEY);
        return new FlutterEvent(str, str2, map, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FlutterEvent)) {
            return false;
        }
        FlutterEvent flutterEvent = (FlutterEvent) obj;
        return Intrinsics.areEqual((Object) this.f59794name, (Object) flutterEvent.f59794name) && Intrinsics.areEqual((Object) this.featureName, (Object) flutterEvent.featureName) && Intrinsics.areEqual((Object) this.attributes, (Object) flutterEvent.attributes) && Intrinsics.areEqual((Object) this.platforms, (Object) flutterEvent.platforms);
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return this.featureName;
    }

    public int hashCode() {
        return (((((this.f59794name.hashCode() * 31) + this.featureName.hashCode()) * 31) + this.attributes.hashCode()) * 31) + this.platforms.hashCode();
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return this.f59794name;
    }

    @NotNull
    public List<PlatformName> platforms() {
        Iterable<String> iterable = this.platforms;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (String from : iterable) {
            arrayList.add(PlatformName.Companion.from(from));
        }
        return arrayList;
    }

    @NotNull
    public String toString() {
        String str = this.f59794name;
        String str2 = this.featureName;
        Map<String, Object> map = this.attributes;
        List<String> list = this.platforms;
        return "FlutterEvent(name=" + str + ", featureName=" + str2 + ", attributes=" + map + ", platforms=" + list + ")";
    }
}
