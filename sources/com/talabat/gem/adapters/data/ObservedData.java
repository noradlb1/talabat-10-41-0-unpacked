package com.talabat.gem.adapters.data;

import com.talabat.gem.domain.entities.Location;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/talabat/gem/adapters/data/ObservedData;", "", "userName", "", "userLocation", "Lcom/talabat/gem/domain/entities/Location;", "localization", "selectedRestaurantId", "", "(Ljava/lang/String;Lcom/talabat/gem/domain/entities/Location;Ljava/lang/String;Ljava/lang/Integer;)V", "getLocalization", "()Ljava/lang/String;", "getSelectedRestaurantId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUserLocation", "()Lcom/talabat/gem/domain/entities/Location;", "getUserName", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ObservedData {
    @Nullable
    private final String localization;
    @Nullable
    private final Integer selectedRestaurantId;
    @NotNull
    private final Location userLocation;
    @NotNull
    private final String userName;

    public ObservedData() {
        this((String) null, (Location) null, (String) null, (Integer) null, 15, (DefaultConstructorMarker) null);
    }

    public ObservedData(@NotNull String str, @NotNull Location location, @Nullable String str2, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(str, "userName");
        Intrinsics.checkNotNullParameter(location, "userLocation");
        this.userName = str;
        this.userLocation = location;
        this.localization = str2;
        this.selectedRestaurantId = num;
    }

    @Nullable
    public final String getLocalization() {
        return this.localization;
    }

    @Nullable
    public final Integer getSelectedRestaurantId() {
        return this.selectedRestaurantId;
    }

    @NotNull
    public final Location getUserLocation() {
        return this.userLocation;
    }

    @NotNull
    public final String getUserName() {
        return this.userName;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ObservedData(String str, Location location, String str2, Integer num, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? CacheKt.name() : str, (i11 & 2) != 0 ? CacheKt.location() : location, (i11 & 4) != 0 ? CacheKt.localization() : str2, (i11 & 8) != 0 ? CacheKt.cachedSelectedRestaurantId() : num);
    }
}
