package com.talabat.feature.darkstores.swimlanes.data.remote.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B;\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0003\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\tHÆ\u0003J?\u0010\u0016\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/talabat/feature/darkstores/swimlanes/data/remote/model/SwimlanesResponseData;", "", "id", "", "name", "products", "", "Lcom/talabat/feature/darkstores/swimlanes/data/remote/model/SwimlanesProductResponse;", "tracking", "Lcom/talabat/feature/darkstores/swimlanes/data/remote/model/SwimlanesTrackingResponse;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/talabat/feature/darkstores/swimlanes/data/remote/model/SwimlanesTrackingResponse;)V", "getId", "()Ljava/lang/String;", "getName", "getProducts", "()Ljava/util/List;", "getTracking", "()Lcom/talabat/feature/darkstores/swimlanes/data/remote/model/SwimlanesTrackingResponse;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_darkstores-swimlanes_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SwimlanesResponseData {
    @Nullable

    /* renamed from: id  reason: collision with root package name */
    private final String f58406id;
    @Nullable

    /* renamed from: name  reason: collision with root package name */
    private final String f58407name;
    @Nullable
    private final List<SwimlanesProductResponse> products;
    @Nullable

    /* renamed from: tracking  reason: collision with root package name */
    private final SwimlanesTrackingResponse f58408tracking;

    public SwimlanesResponseData() {
        this((String) null, (String) null, (List) null, (SwimlanesTrackingResponse) null, 15, (DefaultConstructorMarker) null);
    }

    public SwimlanesResponseData(@Nullable @Json(name = "id") String str, @Nullable @Json(name = "name") String str2, @Nullable @Json(name = "products") List<SwimlanesProductResponse> list, @Nullable @Json(name = "tracking") SwimlanesTrackingResponse swimlanesTrackingResponse) {
        this.f58406id = str;
        this.f58407name = str2;
        this.products = list;
        this.f58408tracking = swimlanesTrackingResponse;
    }

    public static /* synthetic */ SwimlanesResponseData copy$default(SwimlanesResponseData swimlanesResponseData, String str, String str2, List<SwimlanesProductResponse> list, SwimlanesTrackingResponse swimlanesTrackingResponse, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = swimlanesResponseData.f58406id;
        }
        if ((i11 & 2) != 0) {
            str2 = swimlanesResponseData.f58407name;
        }
        if ((i11 & 4) != 0) {
            list = swimlanesResponseData.products;
        }
        if ((i11 & 8) != 0) {
            swimlanesTrackingResponse = swimlanesResponseData.f58408tracking;
        }
        return swimlanesResponseData.copy(str, str2, list, swimlanesTrackingResponse);
    }

    @Nullable
    public final String component1() {
        return this.f58406id;
    }

    @Nullable
    public final String component2() {
        return this.f58407name;
    }

    @Nullable
    public final List<SwimlanesProductResponse> component3() {
        return this.products;
    }

    @Nullable
    public final SwimlanesTrackingResponse component4() {
        return this.f58408tracking;
    }

    @NotNull
    public final SwimlanesResponseData copy(@Nullable @Json(name = "id") String str, @Nullable @Json(name = "name") String str2, @Nullable @Json(name = "products") List<SwimlanesProductResponse> list, @Nullable @Json(name = "tracking") SwimlanesTrackingResponse swimlanesTrackingResponse) {
        return new SwimlanesResponseData(str, str2, list, swimlanesTrackingResponse);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SwimlanesResponseData)) {
            return false;
        }
        SwimlanesResponseData swimlanesResponseData = (SwimlanesResponseData) obj;
        return Intrinsics.areEqual((Object) this.f58406id, (Object) swimlanesResponseData.f58406id) && Intrinsics.areEqual((Object) this.f58407name, (Object) swimlanesResponseData.f58407name) && Intrinsics.areEqual((Object) this.products, (Object) swimlanesResponseData.products) && Intrinsics.areEqual((Object) this.f58408tracking, (Object) swimlanesResponseData.f58408tracking);
    }

    @Nullable
    public final String getId() {
        return this.f58406id;
    }

    @Nullable
    public final String getName() {
        return this.f58407name;
    }

    @Nullable
    public final List<SwimlanesProductResponse> getProducts() {
        return this.products;
    }

    @Nullable
    public final SwimlanesTrackingResponse getTracking() {
        return this.f58408tracking;
    }

    public int hashCode() {
        String str = this.f58406id;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f58407name;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<SwimlanesProductResponse> list = this.products;
        int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        SwimlanesTrackingResponse swimlanesTrackingResponse = this.f58408tracking;
        if (swimlanesTrackingResponse != null) {
            i11 = swimlanesTrackingResponse.hashCode();
        }
        return hashCode3 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.f58406id;
        String str2 = this.f58407name;
        List<SwimlanesProductResponse> list = this.products;
        SwimlanesTrackingResponse swimlanesTrackingResponse = this.f58408tracking;
        return "SwimlanesResponseData(id=" + str + ", name=" + str2 + ", products=" + list + ", tracking=" + swimlanesTrackingResponse + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SwimlanesResponseData(String str, String str2, List list, SwimlanesTrackingResponse swimlanesTrackingResponse, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : list, (i11 & 8) != 0 ? null : swimlanesTrackingResponse);
    }
}
