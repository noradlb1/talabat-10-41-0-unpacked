package com.talabat.configuration.location;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/talabat/configuration/location/City;", "", "id", "", "countryId", "name", "", "(IILjava/lang/String;)V", "getCountryId", "()I", "getId", "getName", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "com_talabat_core_configuration_remote_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class City {
    public static final int BAD_ID = -1;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final int countryId;

    /* renamed from: id  reason: collision with root package name */
    private final int f55767id;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f55768name;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/configuration/location/City$Companion;", "", "()V", "BAD_ID", "", "com_talabat_core_configuration_remote_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public City(int i11, int i12, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.f55767id = i11;
        this.countryId = i12;
        this.f55768name = str;
    }

    public static /* synthetic */ City copy$default(City city, int i11, int i12, String str, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = city.f55767id;
        }
        if ((i13 & 2) != 0) {
            i12 = city.countryId;
        }
        if ((i13 & 4) != 0) {
            str = city.f55768name;
        }
        return city.copy(i11, i12, str);
    }

    public final int component1() {
        return this.f55767id;
    }

    public final int component2() {
        return this.countryId;
    }

    @NotNull
    public final String component3() {
        return this.f55768name;
    }

    @NotNull
    public final City copy(int i11, int i12, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return new City(i11, i12, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof City)) {
            return false;
        }
        City city = (City) obj;
        return this.f55767id == city.f55767id && this.countryId == city.countryId && Intrinsics.areEqual((Object) this.f55768name, (Object) city.f55768name);
    }

    public final int getCountryId() {
        return this.countryId;
    }

    public final int getId() {
        return this.f55767id;
    }

    @NotNull
    public final String getName() {
        return this.f55768name;
    }

    public int hashCode() {
        return (((this.f55767id * 31) + this.countryId) * 31) + this.f55768name.hashCode();
    }

    @NotNull
    public String toString() {
        int i11 = this.f55767id;
        int i12 = this.countryId;
        String str = this.f55768name;
        return "City(id=" + i11 + ", countryId=" + i12 + ", name=" + str + ")";
    }
}
