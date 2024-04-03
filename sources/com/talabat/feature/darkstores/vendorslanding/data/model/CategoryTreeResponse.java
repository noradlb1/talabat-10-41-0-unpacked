package com.talabat.feature.darkstores.vendorslanding.data.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0003\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0003\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007¢\u0006\u0002\u0010\fJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007HÆ\u0003JV\u0010\u001b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0003\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00052\u0010\b\u0003\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013¨\u0006\""}, d2 = {"Lcom/talabat/feature/darkstores/vendorslanding/data/model/CategoryTreeResponse;", "", "count", "", "id", "", "imageUrls", "", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/ImageUrlResponse;", "name", "subCategories", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/SubCategoryResponse;", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;)V", "getCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getId", "()Ljava/lang/String;", "getImageUrls", "()Ljava/util/List;", "getName", "getSubCategories", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;)Lcom/talabat/feature/darkstores/vendorslanding/data/model/CategoryTreeResponse;", "equals", "", "other", "hashCode", "toString", "com_talabat_feature_darkstores-vendor-landing_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CategoryTreeResponse {
    @Nullable
    private final Integer count;
    @Nullable

    /* renamed from: id  reason: collision with root package name */
    private final String f58434id;
    @Nullable
    private final List<ImageUrlResponse> imageUrls;
    @Nullable

    /* renamed from: name  reason: collision with root package name */
    private final String f58435name;
    @Nullable
    private final List<SubCategoryResponse> subCategories;

    public CategoryTreeResponse() {
        this((Integer) null, (String) null, (List) null, (String) null, (List) null, 31, (DefaultConstructorMarker) null);
    }

    public CategoryTreeResponse(@Nullable @Json(name = "count") Integer num, @Nullable @Json(name = "id") String str, @Nullable @Json(name = "image_urls") List<ImageUrlResponse> list, @Nullable @Json(name = "name") String str2, @Nullable @Json(name = "sub_categories") List<SubCategoryResponse> list2) {
        this.count = num;
        this.f58434id = str;
        this.imageUrls = list;
        this.f58435name = str2;
        this.subCategories = list2;
    }

    public static /* synthetic */ CategoryTreeResponse copy$default(CategoryTreeResponse categoryTreeResponse, Integer num, String str, List<ImageUrlResponse> list, String str2, List<SubCategoryResponse> list2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = categoryTreeResponse.count;
        }
        if ((i11 & 2) != 0) {
            str = categoryTreeResponse.f58434id;
        }
        String str3 = str;
        if ((i11 & 4) != 0) {
            list = categoryTreeResponse.imageUrls;
        }
        List<ImageUrlResponse> list3 = list;
        if ((i11 & 8) != 0) {
            str2 = categoryTreeResponse.f58435name;
        }
        String str4 = str2;
        if ((i11 & 16) != 0) {
            list2 = categoryTreeResponse.subCategories;
        }
        return categoryTreeResponse.copy(num, str3, list3, str4, list2);
    }

    @Nullable
    public final Integer component1() {
        return this.count;
    }

    @Nullable
    public final String component2() {
        return this.f58434id;
    }

    @Nullable
    public final List<ImageUrlResponse> component3() {
        return this.imageUrls;
    }

    @Nullable
    public final String component4() {
        return this.f58435name;
    }

    @Nullable
    public final List<SubCategoryResponse> component5() {
        return this.subCategories;
    }

    @NotNull
    public final CategoryTreeResponse copy(@Nullable @Json(name = "count") Integer num, @Nullable @Json(name = "id") String str, @Nullable @Json(name = "image_urls") List<ImageUrlResponse> list, @Nullable @Json(name = "name") String str2, @Nullable @Json(name = "sub_categories") List<SubCategoryResponse> list2) {
        return new CategoryTreeResponse(num, str, list, str2, list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CategoryTreeResponse)) {
            return false;
        }
        CategoryTreeResponse categoryTreeResponse = (CategoryTreeResponse) obj;
        return Intrinsics.areEqual((Object) this.count, (Object) categoryTreeResponse.count) && Intrinsics.areEqual((Object) this.f58434id, (Object) categoryTreeResponse.f58434id) && Intrinsics.areEqual((Object) this.imageUrls, (Object) categoryTreeResponse.imageUrls) && Intrinsics.areEqual((Object) this.f58435name, (Object) categoryTreeResponse.f58435name) && Intrinsics.areEqual((Object) this.subCategories, (Object) categoryTreeResponse.subCategories);
    }

    @Nullable
    public final Integer getCount() {
        return this.count;
    }

    @Nullable
    public final String getId() {
        return this.f58434id;
    }

    @Nullable
    public final List<ImageUrlResponse> getImageUrls() {
        return this.imageUrls;
    }

    @Nullable
    public final String getName() {
        return this.f58435name;
    }

    @Nullable
    public final List<SubCategoryResponse> getSubCategories() {
        return this.subCategories;
    }

    public int hashCode() {
        Integer num = this.count;
        int i11 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.f58434id;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<ImageUrlResponse> list = this.imageUrls;
        int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        String str2 = this.f58435name;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<SubCategoryResponse> list2 = this.subCategories;
        if (list2 != null) {
            i11 = list2.hashCode();
        }
        return hashCode4 + i11;
    }

    @NotNull
    public String toString() {
        Integer num = this.count;
        String str = this.f58434id;
        List<ImageUrlResponse> list = this.imageUrls;
        String str2 = this.f58435name;
        List<SubCategoryResponse> list2 = this.subCategories;
        return "CategoryTreeResponse(count=" + num + ", id=" + str + ", imageUrls=" + list + ", name=" + str2 + ", subCategories=" + list2 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CategoryTreeResponse(java.lang.Integer r5, java.lang.String r6, java.util.List r7, java.lang.String r8, java.util.List r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L_0x0007
            r11 = r0
            goto L_0x0008
        L_0x0007:
            r11 = r5
        L_0x0008:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r6
        L_0x000f:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r7
        L_0x0016:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r8
        L_0x001d:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0023
            r10 = r0
            goto L_0x0024
        L_0x0023:
            r10 = r9
        L_0x0024:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.darkstores.vendorslanding.data.model.CategoryTreeResponse.<init>(java.lang.Integer, java.lang.String, java.util.List, java.lang.String, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
