package com.talabat.feature.darkstores.swimlanes.data.remote.model;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/talabat/feature/darkstores/swimlanes/data/remote/model/ProductAttributesResponse;", "", "type", "", "id", "name", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_darkstores-swimlanes_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProductAttributesResponse {
    @Nullable

    /* renamed from: id  reason: collision with root package name */
    private final String f58402id;
    @Nullable

    /* renamed from: name  reason: collision with root package name */
    private final String f58403name;
    @Nullable
    private final String type;

    public ProductAttributesResponse() {
        this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public ProductAttributesResponse(@Nullable @Json(name = "type") String str, @Nullable @Json(name = "id") String str2, @Nullable @Json(name = "name") String str3) {
        this.type = str;
        this.f58402id = str2;
        this.f58403name = str3;
    }

    public static /* synthetic */ ProductAttributesResponse copy$default(ProductAttributesResponse productAttributesResponse, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = productAttributesResponse.type;
        }
        if ((i11 & 2) != 0) {
            str2 = productAttributesResponse.f58402id;
        }
        if ((i11 & 4) != 0) {
            str3 = productAttributesResponse.f58403name;
        }
        return productAttributesResponse.copy(str, str2, str3);
    }

    @Nullable
    public final String component1() {
        return this.type;
    }

    @Nullable
    public final String component2() {
        return this.f58402id;
    }

    @Nullable
    public final String component3() {
        return this.f58403name;
    }

    @NotNull
    public final ProductAttributesResponse copy(@Nullable @Json(name = "type") String str, @Nullable @Json(name = "id") String str2, @Nullable @Json(name = "name") String str3) {
        return new ProductAttributesResponse(str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductAttributesResponse)) {
            return false;
        }
        ProductAttributesResponse productAttributesResponse = (ProductAttributesResponse) obj;
        return Intrinsics.areEqual((Object) this.type, (Object) productAttributesResponse.type) && Intrinsics.areEqual((Object) this.f58402id, (Object) productAttributesResponse.f58402id) && Intrinsics.areEqual((Object) this.f58403name, (Object) productAttributesResponse.f58403name);
    }

    @Nullable
    public final String getId() {
        return this.f58402id;
    }

    @Nullable
    public final String getName() {
        return this.f58403name;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.type;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f58402id;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f58403name;
        if (str3 != null) {
            i11 = str3.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.type;
        String str2 = this.f58402id;
        String str3 = this.f58403name;
        return "ProductAttributesResponse(type=" + str + ", id=" + str2 + ", name=" + str3 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ProductAttributesResponse(String str, String str2, String str3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3);
    }
}
