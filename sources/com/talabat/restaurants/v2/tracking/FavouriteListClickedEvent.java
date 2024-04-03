package com.talabat.restaurants.v2.tracking;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u0015\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÂ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/talabat/restaurants/v2/tracking/FavouriteListClickedEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "user", "", "", "(Ljava/util/Map;)V", "attributes", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "component1", "copy", "equals", "", "other", "featureName", "hashCode", "", "name", "toString", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FavouriteListClickedEvent extends TalabatEvent {
    @NotNull
    private final Map<String, String> user;

    public FavouriteListClickedEvent(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "user");
        this.user = map;
    }

    private final Map<String, String> component1() {
        return this.user;
    }

    public static /* synthetic */ FavouriteListClickedEvent copy$default(FavouriteListClickedEvent favouriteListClickedEvent, Map<String, String> map, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            map = favouriteListClickedEvent.user;
        }
        return favouriteListClickedEvent.copy(map);
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        HashMap hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("screenType", "shop_list"), TuplesKt.to("screenName", "Restaurant List Screen"));
        hashMapOf.putAll(this.user);
        return hashMapOf;
    }

    @NotNull
    public final FavouriteListClickedEvent copy(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "user");
        return new FavouriteListClickedEvent(map);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FavouriteListClickedEvent) && Intrinsics.areEqual((Object) this.user, (Object) ((FavouriteListClickedEvent) obj).user);
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "shop_list";
    }

    public int hashCode() {
        return this.user.hashCode();
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "favourite_list_clicked";
    }

    @NotNull
    public String toString() {
        Map<String, String> map = this.user;
        return "FavouriteListClickedEvent(user=" + map + ")";
    }
}
