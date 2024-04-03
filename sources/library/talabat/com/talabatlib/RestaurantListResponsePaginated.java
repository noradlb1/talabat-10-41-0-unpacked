package library.talabat.com.talabatlib;

import com.google.gson.annotations.SerializedName;
import com.talabat.feature.rewards.domain.model.Mission;
import datamodels.FeaturedProducts;
import datamodels.Restaurant;
import datamodels.Swimlane;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001Bw\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0006¢\u0006\u0002\u0010\u0011J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003J\u0011\u0010!\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\"\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u0011\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0006HÆ\u0003J{\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00062\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00032\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0006HÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\t\u0010*\u001a\u00020\tHÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015¨\u0006+"}, d2 = {"Llibrary/talabat/com/talabatlib/RestaurantListResponsePaginated;", "", "page", "", "size", "vendors", "", "Ldatamodels/Restaurant;", "baseUrl", "", "swimlanes", "Ldatamodels/Swimlane;", "featuredProducts", "Ldatamodels/FeaturedProducts;", "totalVendors", "missions", "Lcom/talabat/feature/rewards/domain/model/Mission;", "(IILjava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;ILjava/util/List;)V", "getBaseUrl", "()Ljava/lang/String;", "getFeaturedProducts", "()Ljava/util/List;", "getMissions", "getPage", "()I", "getSize", "getSwimlanes", "getTotalVendors", "getVendors", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RestaurantListResponsePaginated {
    @Nullable
    private final String baseUrl;
    @SerializedName("featured_products")
    @Nullable
    private final List<FeaturedProducts> featuredProducts;
    @SerializedName("missions")
    @Nullable
    private final List<Mission> missions;
    private final int page;
    private final int size;
    @Nullable
    private final List<Swimlane> swimlanes;
    @SerializedName("total_vendors")
    private final int totalVendors;
    @Nullable
    private final List<Restaurant> vendors;

    public RestaurantListResponsePaginated() {
        this(0, 0, (List) null, (String) null, (List) null, (List) null, 0, (List) null, 255, (DefaultConstructorMarker) null);
    }

    public RestaurantListResponsePaginated(int i11, int i12, @Nullable List<? extends Restaurant> list, @Nullable String str, @Nullable List<Swimlane> list2, @Nullable List<FeaturedProducts> list3, int i13, @Nullable List<Mission> list4) {
        this.page = i11;
        this.size = i12;
        this.vendors = list;
        this.baseUrl = str;
        this.swimlanes = list2;
        this.featuredProducts = list3;
        this.totalVendors = i13;
        this.missions = list4;
    }

    public static /* synthetic */ RestaurantListResponsePaginated copy$default(RestaurantListResponsePaginated restaurantListResponsePaginated, int i11, int i12, List list, String str, List list2, List list3, int i13, List list4, int i14, Object obj) {
        RestaurantListResponsePaginated restaurantListResponsePaginated2 = restaurantListResponsePaginated;
        int i15 = i14;
        return restaurantListResponsePaginated.copy((i15 & 1) != 0 ? restaurantListResponsePaginated2.page : i11, (i15 & 2) != 0 ? restaurantListResponsePaginated2.size : i12, (i15 & 4) != 0 ? restaurantListResponsePaginated2.vendors : list, (i15 & 8) != 0 ? restaurantListResponsePaginated2.baseUrl : str, (i15 & 16) != 0 ? restaurantListResponsePaginated2.swimlanes : list2, (i15 & 32) != 0 ? restaurantListResponsePaginated2.featuredProducts : list3, (i15 & 64) != 0 ? restaurantListResponsePaginated2.totalVendors : i13, (i15 & 128) != 0 ? restaurantListResponsePaginated2.missions : list4);
    }

    public final int component1() {
        return this.page;
    }

    public final int component2() {
        return this.size;
    }

    @Nullable
    public final List<Restaurant> component3() {
        return this.vendors;
    }

    @Nullable
    public final String component4() {
        return this.baseUrl;
    }

    @Nullable
    public final List<Swimlane> component5() {
        return this.swimlanes;
    }

    @Nullable
    public final List<FeaturedProducts> component6() {
        return this.featuredProducts;
    }

    public final int component7() {
        return this.totalVendors;
    }

    @Nullable
    public final List<Mission> component8() {
        return this.missions;
    }

    @NotNull
    public final RestaurantListResponsePaginated copy(int i11, int i12, @Nullable List<? extends Restaurant> list, @Nullable String str, @Nullable List<Swimlane> list2, @Nullable List<FeaturedProducts> list3, int i13, @Nullable List<Mission> list4) {
        return new RestaurantListResponsePaginated(i11, i12, list, str, list2, list3, i13, list4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RestaurantListResponsePaginated)) {
            return false;
        }
        RestaurantListResponsePaginated restaurantListResponsePaginated = (RestaurantListResponsePaginated) obj;
        return this.page == restaurantListResponsePaginated.page && this.size == restaurantListResponsePaginated.size && Intrinsics.areEqual((Object) this.vendors, (Object) restaurantListResponsePaginated.vendors) && Intrinsics.areEqual((Object) this.baseUrl, (Object) restaurantListResponsePaginated.baseUrl) && Intrinsics.areEqual((Object) this.swimlanes, (Object) restaurantListResponsePaginated.swimlanes) && Intrinsics.areEqual((Object) this.featuredProducts, (Object) restaurantListResponsePaginated.featuredProducts) && this.totalVendors == restaurantListResponsePaginated.totalVendors && Intrinsics.areEqual((Object) this.missions, (Object) restaurantListResponsePaginated.missions);
    }

    @Nullable
    public final String getBaseUrl() {
        return this.baseUrl;
    }

    @Nullable
    public final List<FeaturedProducts> getFeaturedProducts() {
        return this.featuredProducts;
    }

    @Nullable
    public final List<Mission> getMissions() {
        return this.missions;
    }

    public final int getPage() {
        return this.page;
    }

    public final int getSize() {
        return this.size;
    }

    @Nullable
    public final List<Swimlane> getSwimlanes() {
        return this.swimlanes;
    }

    public final int getTotalVendors() {
        return this.totalVendors;
    }

    @Nullable
    public final List<Restaurant> getVendors() {
        return this.vendors;
    }

    public int hashCode() {
        int i11 = ((this.page * 31) + this.size) * 31;
        List<Restaurant> list = this.vendors;
        int i12 = 0;
        int hashCode = (i11 + (list == null ? 0 : list.hashCode())) * 31;
        String str = this.baseUrl;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<Swimlane> list2 = this.swimlanes;
        int hashCode3 = (hashCode2 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<FeaturedProducts> list3 = this.featuredProducts;
        int hashCode4 = (((hashCode3 + (list3 == null ? 0 : list3.hashCode())) * 31) + this.totalVendors) * 31;
        List<Mission> list4 = this.missions;
        if (list4 != null) {
            i12 = list4.hashCode();
        }
        return hashCode4 + i12;
    }

    @NotNull
    public String toString() {
        int i11 = this.page;
        int i12 = this.size;
        List<Restaurant> list = this.vendors;
        String str = this.baseUrl;
        List<Swimlane> list2 = this.swimlanes;
        List<FeaturedProducts> list3 = this.featuredProducts;
        int i13 = this.totalVendors;
        List<Mission> list4 = this.missions;
        return "RestaurantListResponsePaginated(page=" + i11 + ", size=" + i12 + ", vendors=" + list + ", baseUrl=" + str + ", swimlanes=" + list2 + ", featuredProducts=" + list3 + ", totalVendors=" + i13 + ", missions=" + list4 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RestaurantListResponsePaginated(int r11, int r12, java.util.List r13, java.lang.String r14, java.util.List r15, java.util.List r16, int r17, java.util.List r18, int r19, kotlin.jvm.internal.DefaultConstructorMarker r20) {
        /*
            r10 = this;
            r0 = r19
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r11
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r12
        L_0x0011:
            r4 = r0 & 4
            r5 = 0
            if (r4 == 0) goto L_0x0018
            r4 = r5
            goto L_0x0019
        L_0x0018:
            r4 = r13
        L_0x0019:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x001f
            r6 = r5
            goto L_0x0020
        L_0x001f:
            r6 = r14
        L_0x0020:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x0026
            r7 = r5
            goto L_0x0027
        L_0x0026:
            r7 = r15
        L_0x0027:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x002d
            r8 = r5
            goto L_0x002f
        L_0x002d:
            r8 = r16
        L_0x002f:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x0034
            goto L_0x0036
        L_0x0034:
            r2 = r17
        L_0x0036:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x003b
            goto L_0x003d
        L_0x003b:
            r5 = r18
        L_0x003d:
            r11 = r10
            r12 = r1
            r13 = r3
            r14 = r4
            r15 = r6
            r16 = r7
            r17 = r8
            r18 = r2
            r19 = r5
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: library.talabat.com.talabatlib.RestaurantListResponsePaginated.<init>(int, int, java.util.List, java.lang.String, java.util.List, java.util.List, int, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
