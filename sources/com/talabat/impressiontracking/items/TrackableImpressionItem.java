package com.talabat.impressiontracking.items;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J)\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/talabat/impressiontracking/items/TrackableImpressionItem;", "", "id", "", "impressionPayload", "", "(Ljava/lang/String;Ljava/util/Map;)V", "getId", "()Ljava/lang/String;", "getImpressionPayload", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_ThirdPartyLibs_ImpressionTracking_ImpressionTracking"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TrackableImpressionItem {
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f60989id;
    @NotNull
    private final Map<String, String> impressionPayload;

    public TrackableImpressionItem(@NotNull String str, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(map, "impressionPayload");
        this.f60989id = str;
        this.impressionPayload = map;
    }

    public static /* synthetic */ TrackableImpressionItem copy$default(TrackableImpressionItem trackableImpressionItem, String str, Map<String, String> map, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = trackableImpressionItem.f60989id;
        }
        if ((i11 & 2) != 0) {
            map = trackableImpressionItem.impressionPayload;
        }
        return trackableImpressionItem.copy(str, map);
    }

    @NotNull
    public final String component1() {
        return this.f60989id;
    }

    @NotNull
    public final Map<String, String> component2() {
        return this.impressionPayload;
    }

    @NotNull
    public final TrackableImpressionItem copy(@NotNull String str, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(map, "impressionPayload");
        return new TrackableImpressionItem(str, map);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TrackableImpressionItem)) {
            return false;
        }
        TrackableImpressionItem trackableImpressionItem = (TrackableImpressionItem) obj;
        return Intrinsics.areEqual((Object) this.f60989id, (Object) trackableImpressionItem.f60989id) && Intrinsics.areEqual((Object) this.impressionPayload, (Object) trackableImpressionItem.impressionPayload);
    }

    @NotNull
    public final String getId() {
        return this.f60989id;
    }

    @NotNull
    public final Map<String, String> getImpressionPayload() {
        return this.impressionPayload;
    }

    public int hashCode() {
        return (this.f60989id.hashCode() * 31) + this.impressionPayload.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.f60989id;
        Map<String, String> map = this.impressionPayload;
        return "TrackableImpressionItem(id=" + str + ", impressionPayload=" + map + ")";
    }
}
