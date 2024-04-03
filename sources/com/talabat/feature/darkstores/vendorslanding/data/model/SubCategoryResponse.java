package com.talabat.feature.darkstores.vendorslanding.data.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J2\u0010\u0011\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/talabat/feature/darkstores/vendorslanding/data/model/SubCategoryResponse;", "", "count", "", "id", "", "name", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/talabat/feature/darkstores/vendorslanding/data/model/SubCategoryResponse;", "equals", "", "other", "hashCode", "toString", "com_talabat_feature_darkstores-vendor-landing_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubCategoryResponse {
    @Nullable
    private final Integer count;
    @Nullable

    /* renamed from: id  reason: collision with root package name */
    private final String f58444id;
    @Nullable

    /* renamed from: name  reason: collision with root package name */
    private final String f58445name;

    public SubCategoryResponse() {
        this((Integer) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public SubCategoryResponse(@Nullable @Json(name = "count") Integer num, @Nullable @Json(name = "id") String str, @Nullable @Json(name = "name") String str2) {
        this.count = num;
        this.f58444id = str;
        this.f58445name = str2;
    }

    public static /* synthetic */ SubCategoryResponse copy$default(SubCategoryResponse subCategoryResponse, Integer num, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = subCategoryResponse.count;
        }
        if ((i11 & 2) != 0) {
            str = subCategoryResponse.f58444id;
        }
        if ((i11 & 4) != 0) {
            str2 = subCategoryResponse.f58445name;
        }
        return subCategoryResponse.copy(num, str, str2);
    }

    @Nullable
    public final Integer component1() {
        return this.count;
    }

    @Nullable
    public final String component2() {
        return this.f58444id;
    }

    @Nullable
    public final String component3() {
        return this.f58445name;
    }

    @NotNull
    public final SubCategoryResponse copy(@Nullable @Json(name = "count") Integer num, @Nullable @Json(name = "id") String str, @Nullable @Json(name = "name") String str2) {
        return new SubCategoryResponse(num, str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubCategoryResponse)) {
            return false;
        }
        SubCategoryResponse subCategoryResponse = (SubCategoryResponse) obj;
        return Intrinsics.areEqual((Object) this.count, (Object) subCategoryResponse.count) && Intrinsics.areEqual((Object) this.f58444id, (Object) subCategoryResponse.f58444id) && Intrinsics.areEqual((Object) this.f58445name, (Object) subCategoryResponse.f58445name);
    }

    @Nullable
    public final Integer getCount() {
        return this.count;
    }

    @Nullable
    public final String getId() {
        return this.f58444id;
    }

    @Nullable
    public final String getName() {
        return this.f58445name;
    }

    public int hashCode() {
        Integer num = this.count;
        int i11 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.f58444id;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f58445name;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        Integer num = this.count;
        String str = this.f58444id;
        String str2 = this.f58445name;
        return "SubCategoryResponse(count=" + num + ", id=" + str + ", name=" + str2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SubCategoryResponse(Integer num, String str, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : num, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? null : str2);
    }
}
