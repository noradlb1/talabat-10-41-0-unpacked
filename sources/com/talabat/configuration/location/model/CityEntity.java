package com.talabat.configuration.location.model;

import com.google.gson.annotations.SerializedName;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J2\u0010\u0011\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/talabat/configuration/location/model/CityEntity;", "", "id", "", "countryId", "name", "", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getCountryId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getId", "getName", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/talabat/configuration/location/model/CityEntity;", "equals", "", "other", "hashCode", "toString", "com_talabat_core_configuration_remote_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CityEntity {
    @SerializedName("cid")
    @Nullable
    private final Integer countryId;
    @SerializedName("id")
    @Nullable

    /* renamed from: id  reason: collision with root package name */
    private final Integer f55774id;
    @SerializedName("na")
    @Nullable

    /* renamed from: name  reason: collision with root package name */
    private final String f55775name;

    public CityEntity() {
        this((Integer) null, (Integer) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public CityEntity(@Nullable @Json(name = "id") Integer num, @Nullable @Json(name = "cid") Integer num2, @Nullable @Json(name = "na") String str) {
        this.f55774id = num;
        this.countryId = num2;
        this.f55775name = str;
    }

    public static /* synthetic */ CityEntity copy$default(CityEntity cityEntity, Integer num, Integer num2, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = cityEntity.f55774id;
        }
        if ((i11 & 2) != 0) {
            num2 = cityEntity.countryId;
        }
        if ((i11 & 4) != 0) {
            str = cityEntity.f55775name;
        }
        return cityEntity.copy(num, num2, str);
    }

    @Nullable
    public final Integer component1() {
        return this.f55774id;
    }

    @Nullable
    public final Integer component2() {
        return this.countryId;
    }

    @Nullable
    public final String component3() {
        return this.f55775name;
    }

    @NotNull
    public final CityEntity copy(@Nullable @Json(name = "id") Integer num, @Nullable @Json(name = "cid") Integer num2, @Nullable @Json(name = "na") String str) {
        return new CityEntity(num, num2, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CityEntity)) {
            return false;
        }
        CityEntity cityEntity = (CityEntity) obj;
        return Intrinsics.areEqual((Object) this.f55774id, (Object) cityEntity.f55774id) && Intrinsics.areEqual((Object) this.countryId, (Object) cityEntity.countryId) && Intrinsics.areEqual((Object) this.f55775name, (Object) cityEntity.f55775name);
    }

    @Nullable
    public final Integer getCountryId() {
        return this.countryId;
    }

    @Nullable
    public final Integer getId() {
        return this.f55774id;
    }

    @Nullable
    public final String getName() {
        return this.f55775name;
    }

    public int hashCode() {
        Integer num = this.f55774id;
        int i11 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.countryId;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.f55775name;
        if (str != null) {
            i11 = str.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        Integer num = this.f55774id;
        Integer num2 = this.countryId;
        String str = this.f55775name;
        return "CityEntity(id=" + num + ", countryId=" + num2 + ", name=" + str + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CityEntity(Integer num, Integer num2, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : num, (i11 & 2) != 0 ? null : num2, (i11 & 4) != 0 ? null : str);
    }
}
