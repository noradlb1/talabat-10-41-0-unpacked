package com.deliveryhero.customerchat.analytics.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\u0018\b\u0001\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0006HÆ\u0003J7\u0010\u0010\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\u0018\b\u0003\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R!\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/deliveryhero/customerchat/analytics/model/Event;", "", "id", "", "name", "details", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getDetails", "()Ljava/util/Map;", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Event {
    @Nullable
    private final Map<String, String> details;
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f29800id;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f29801name;

    public Event(@NotNull @Json(name = "id") String str, @NotNull @Json(name = "name") String str2, @Nullable @Json(name = "details") Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "name");
        this.f29800id = str;
        this.f29801name = str2;
        this.details = map;
    }

    public static /* synthetic */ Event copy$default(Event event, String str, String str2, Map<String, String> map, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = event.f29800id;
        }
        if ((i11 & 2) != 0) {
            str2 = event.f29801name;
        }
        if ((i11 & 4) != 0) {
            map = event.details;
        }
        return event.copy(str, str2, map);
    }

    @NotNull
    public final String component1() {
        return this.f29800id;
    }

    @NotNull
    public final String component2() {
        return this.f29801name;
    }

    @Nullable
    public final Map<String, String> component3() {
        return this.details;
    }

    @NotNull
    public final Event copy(@NotNull @Json(name = "id") String str, @NotNull @Json(name = "name") String str2, @Nullable @Json(name = "details") Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "name");
        return new Event(str, str2, map);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Event)) {
            return false;
        }
        Event event = (Event) obj;
        return Intrinsics.areEqual((Object) this.f29800id, (Object) event.f29800id) && Intrinsics.areEqual((Object) this.f29801name, (Object) event.f29801name) && Intrinsics.areEqual((Object) this.details, (Object) event.details);
    }

    @Nullable
    public final Map<String, String> getDetails() {
        return this.details;
    }

    @NotNull
    public final String getId() {
        return this.f29800id;
    }

    @NotNull
    public final String getName() {
        return this.f29801name;
    }

    public int hashCode() {
        int hashCode = ((this.f29800id.hashCode() * 31) + this.f29801name.hashCode()) * 31;
        Map<String, String> map = this.details;
        return hashCode + (map == null ? 0 : map.hashCode());
    }

    @NotNull
    public String toString() {
        return "Event(id=" + this.f29800id + ", name=" + this.f29801name + ", details=" + this.details + ')';
    }
}
