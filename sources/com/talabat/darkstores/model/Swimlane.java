package com.talabat.darkstores.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import com.talabat.feature.darkstorescart.data.model.Product;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u000eHÆ\u0003Jk\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u000e\b\u0003\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006+"}, d2 = {"Lcom/talabat/darkstores/model/Swimlane;", "", "headline", "", "tag", "compactSwimlaneLayoutType", "Lcom/talabat/darkstores/model/CompactSwimlaneLayoutType;", "categoryId", "products", "", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "swimlaneId", "requestId", "tracking", "Lcom/talabat/darkstores/model/SwimlaneTracking;", "(Ljava/lang/String;Ljava/lang/String;Lcom/talabat/darkstores/model/CompactSwimlaneLayoutType;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/talabat/darkstores/model/SwimlaneTracking;)V", "getCategoryId", "()Ljava/lang/String;", "getCompactSwimlaneLayoutType", "()Lcom/talabat/darkstores/model/CompactSwimlaneLayoutType;", "getHeadline", "getProducts", "()Ljava/util/List;", "getRequestId", "getSwimlaneId", "getTag", "getTracking", "()Lcom/talabat/darkstores/model/SwimlaneTracking;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Swimlane {
    @Nullable
    private final String categoryId;
    @Nullable
    private final CompactSwimlaneLayoutType compactSwimlaneLayoutType;
    @NotNull
    private final String headline;
    @NotNull
    private final List<Product> products;
    @Nullable
    private final String requestId;
    @Nullable
    private final String swimlaneId;
    @Nullable
    private final String tag;
    @Nullable

    /* renamed from: tracking  reason: collision with root package name */
    private final SwimlaneTracking f56640tracking;

    public Swimlane(@NotNull String str, @Nullable String str2, @Nullable CompactSwimlaneLayoutType compactSwimlaneLayoutType2, @Nullable @Json(name = "id") String str3, @NotNull @Json(name = "items") List<Product> list, @Nullable @Json(name = "swimlaneId") String str4, @Nullable @Json(name = "requestId") String str5, @Nullable @Json(name = "tracking") SwimlaneTracking swimlaneTracking) {
        Intrinsics.checkNotNullParameter(str, "headline");
        Intrinsics.checkNotNullParameter(list, "products");
        this.headline = str;
        this.tag = str2;
        this.compactSwimlaneLayoutType = compactSwimlaneLayoutType2;
        this.categoryId = str3;
        this.products = list;
        this.swimlaneId = str4;
        this.requestId = str5;
        this.f56640tracking = swimlaneTracking;
    }

    public static /* synthetic */ Swimlane copy$default(Swimlane swimlane, String str, String str2, CompactSwimlaneLayoutType compactSwimlaneLayoutType2, String str3, List list, String str4, String str5, SwimlaneTracking swimlaneTracking, int i11, Object obj) {
        Swimlane swimlane2 = swimlane;
        int i12 = i11;
        return swimlane.copy((i12 & 1) != 0 ? swimlane2.headline : str, (i12 & 2) != 0 ? swimlane2.tag : str2, (i12 & 4) != 0 ? swimlane2.compactSwimlaneLayoutType : compactSwimlaneLayoutType2, (i12 & 8) != 0 ? swimlane2.categoryId : str3, (i12 & 16) != 0 ? swimlane2.products : list, (i12 & 32) != 0 ? swimlane2.swimlaneId : str4, (i12 & 64) != 0 ? swimlane2.requestId : str5, (i12 & 128) != 0 ? swimlane2.f56640tracking : swimlaneTracking);
    }

    @NotNull
    public final String component1() {
        return this.headline;
    }

    @Nullable
    public final String component2() {
        return this.tag;
    }

    @Nullable
    public final CompactSwimlaneLayoutType component3() {
        return this.compactSwimlaneLayoutType;
    }

    @Nullable
    public final String component4() {
        return this.categoryId;
    }

    @NotNull
    public final List<Product> component5() {
        return this.products;
    }

    @Nullable
    public final String component6() {
        return this.swimlaneId;
    }

    @Nullable
    public final String component7() {
        return this.requestId;
    }

    @Nullable
    public final SwimlaneTracking component8() {
        return this.f56640tracking;
    }

    @NotNull
    public final Swimlane copy(@NotNull String str, @Nullable String str2, @Nullable CompactSwimlaneLayoutType compactSwimlaneLayoutType2, @Nullable @Json(name = "id") String str3, @NotNull @Json(name = "items") List<Product> list, @Nullable @Json(name = "swimlaneId") String str4, @Nullable @Json(name = "requestId") String str5, @Nullable @Json(name = "tracking") SwimlaneTracking swimlaneTracking) {
        Intrinsics.checkNotNullParameter(str, "headline");
        Intrinsics.checkNotNullParameter(list, "products");
        return new Swimlane(str, str2, compactSwimlaneLayoutType2, str3, list, str4, str5, swimlaneTracking);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Swimlane)) {
            return false;
        }
        Swimlane swimlane = (Swimlane) obj;
        return Intrinsics.areEqual((Object) this.headline, (Object) swimlane.headline) && Intrinsics.areEqual((Object) this.tag, (Object) swimlane.tag) && this.compactSwimlaneLayoutType == swimlane.compactSwimlaneLayoutType && Intrinsics.areEqual((Object) this.categoryId, (Object) swimlane.categoryId) && Intrinsics.areEqual((Object) this.products, (Object) swimlane.products) && Intrinsics.areEqual((Object) this.swimlaneId, (Object) swimlane.swimlaneId) && Intrinsics.areEqual((Object) this.requestId, (Object) swimlane.requestId) && Intrinsics.areEqual((Object) this.f56640tracking, (Object) swimlane.f56640tracking);
    }

    @Nullable
    public final String getCategoryId() {
        return this.categoryId;
    }

    @Nullable
    public final CompactSwimlaneLayoutType getCompactSwimlaneLayoutType() {
        return this.compactSwimlaneLayoutType;
    }

    @NotNull
    public final String getHeadline() {
        return this.headline;
    }

    @NotNull
    public final List<Product> getProducts() {
        return this.products;
    }

    @Nullable
    public final String getRequestId() {
        return this.requestId;
    }

    @Nullable
    public final String getSwimlaneId() {
        return this.swimlaneId;
    }

    @Nullable
    public final String getTag() {
        return this.tag;
    }

    @Nullable
    public final SwimlaneTracking getTracking() {
        return this.f56640tracking;
    }

    public int hashCode() {
        int hashCode = this.headline.hashCode() * 31;
        String str = this.tag;
        int i11 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        CompactSwimlaneLayoutType compactSwimlaneLayoutType2 = this.compactSwimlaneLayoutType;
        int hashCode3 = (hashCode2 + (compactSwimlaneLayoutType2 == null ? 0 : compactSwimlaneLayoutType2.hashCode())) * 31;
        String str2 = this.categoryId;
        int hashCode4 = (((hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.products.hashCode()) * 31;
        String str3 = this.swimlaneId;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.requestId;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        SwimlaneTracking swimlaneTracking = this.f56640tracking;
        if (swimlaneTracking != null) {
            i11 = swimlaneTracking.hashCode();
        }
        return hashCode6 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.headline;
        String str2 = this.tag;
        CompactSwimlaneLayoutType compactSwimlaneLayoutType2 = this.compactSwimlaneLayoutType;
        String str3 = this.categoryId;
        List<Product> list = this.products;
        String str4 = this.swimlaneId;
        String str5 = this.requestId;
        SwimlaneTracking swimlaneTracking = this.f56640tracking;
        return "Swimlane(headline=" + str + ", tag=" + str2 + ", compactSwimlaneLayoutType=" + compactSwimlaneLayoutType2 + ", categoryId=" + str3 + ", products=" + list + ", swimlaneId=" + str4 + ", requestId=" + str5 + ", tracking=" + swimlaneTracking + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Swimlane(String str, String str2, CompactSwimlaneLayoutType compactSwimlaneLayoutType2, String str3, List list, String str4, String str5, SwimlaneTracking swimlaneTracking, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i11 & 4) != 0 ? null : compactSwimlaneLayoutType2, str3, list, (i11 & 32) != 0 ? null : str4, str5, swimlaneTracking);
    }
}
