package com.deliveryhero.chatsdk.network.http.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0016\b\u0003\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J+\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\u0016\b\u0003\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0006HÖ\u0001R\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/deliveryhero/chatsdk/network/http/model/TotalUnreadCountResponse;", "", "total", "", "channels", "", "", "(ILjava/util/Map;)V", "getChannels", "()Ljava/util/Map;", "getTotal", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TotalUnreadCountResponse {
    @Nullable
    private final Map<String, Integer> channels;
    private final int total;

    public TotalUnreadCountResponse(@Json(name = "total") int i11, @Nullable @Json(name = "channels") Map<String, Integer> map) {
        this.total = i11;
        this.channels = map;
    }

    public static /* synthetic */ TotalUnreadCountResponse copy$default(TotalUnreadCountResponse totalUnreadCountResponse, int i11, Map<String, Integer> map, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = totalUnreadCountResponse.total;
        }
        if ((i12 & 2) != 0) {
            map = totalUnreadCountResponse.channels;
        }
        return totalUnreadCountResponse.copy(i11, map);
    }

    public final int component1() {
        return this.total;
    }

    @Nullable
    public final Map<String, Integer> component2() {
        return this.channels;
    }

    @NotNull
    public final TotalUnreadCountResponse copy(@Json(name = "total") int i11, @Nullable @Json(name = "channels") Map<String, Integer> map) {
        return new TotalUnreadCountResponse(i11, map);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TotalUnreadCountResponse)) {
            return false;
        }
        TotalUnreadCountResponse totalUnreadCountResponse = (TotalUnreadCountResponse) obj;
        return this.total == totalUnreadCountResponse.total && Intrinsics.areEqual((Object) this.channels, (Object) totalUnreadCountResponse.channels);
    }

    @Nullable
    public final Map<String, Integer> getChannels() {
        return this.channels;
    }

    public final int getTotal() {
        return this.total;
    }

    public int hashCode() {
        int i11 = this.total * 31;
        Map<String, Integer> map = this.channels;
        return i11 + (map == null ? 0 : map.hashCode());
    }

    @NotNull
    public String toString() {
        return "TotalUnreadCountResponse(total=" + this.total + ", channels=" + this.channels + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TotalUnreadCountResponse(int i11, Map map, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, (i12 & 2) != 0 ? MapsKt__MapsKt.emptyMap() : map);
    }
}
