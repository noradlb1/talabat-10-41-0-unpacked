package tracking.models;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.ScreenNames;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003JO\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006\""}, d2 = {"Ltracking/models/SwimlaneVendorTracking;", "", "itemList", "", "id", "", "name", "brand", "index", "category", "variant", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getBrand", "()Ljava/lang/String;", "getCategory", "getId", "()I", "getIndex", "getItemList", "getName", "getVariant", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SwimlaneVendorTracking {
    @NotNull
    private final String brand;
    @NotNull
    private final String category;

    /* renamed from: id  reason: collision with root package name */
    private final int f63560id;
    private final int index;
    @NotNull
    private final String itemList;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f63561name;
    @NotNull
    private final String variant;

    public SwimlaneVendorTracking(@NotNull String str, int i11, @NotNull String str2, @NotNull String str3, int i12, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, "itemList");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, ScreenNames.SCREEN_TYPE_BRAND);
        Intrinsics.checkNotNullParameter(str4, "category");
        Intrinsics.checkNotNullParameter(str5, "variant");
        this.itemList = str;
        this.f63560id = i11;
        this.f63561name = str2;
        this.brand = str3;
        this.index = i12;
        this.category = str4;
        this.variant = str5;
    }

    public static /* synthetic */ SwimlaneVendorTracking copy$default(SwimlaneVendorTracking swimlaneVendorTracking, String str, int i11, String str2, String str3, int i12, String str4, String str5, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            str = swimlaneVendorTracking.itemList;
        }
        if ((i13 & 2) != 0) {
            i11 = swimlaneVendorTracking.f63560id;
        }
        int i14 = i11;
        if ((i13 & 4) != 0) {
            str2 = swimlaneVendorTracking.f63561name;
        }
        String str6 = str2;
        if ((i13 & 8) != 0) {
            str3 = swimlaneVendorTracking.brand;
        }
        String str7 = str3;
        if ((i13 & 16) != 0) {
            i12 = swimlaneVendorTracking.index;
        }
        int i15 = i12;
        if ((i13 & 32) != 0) {
            str4 = swimlaneVendorTracking.category;
        }
        String str8 = str4;
        if ((i13 & 64) != 0) {
            str5 = swimlaneVendorTracking.variant;
        }
        return swimlaneVendorTracking.copy(str, i14, str6, str7, i15, str8, str5);
    }

    @NotNull
    public final String component1() {
        return this.itemList;
    }

    public final int component2() {
        return this.f63560id;
    }

    @NotNull
    public final String component3() {
        return this.f63561name;
    }

    @NotNull
    public final String component4() {
        return this.brand;
    }

    public final int component5() {
        return this.index;
    }

    @NotNull
    public final String component6() {
        return this.category;
    }

    @NotNull
    public final String component7() {
        return this.variant;
    }

    @NotNull
    public final SwimlaneVendorTracking copy(@NotNull String str, int i11, @NotNull String str2, @NotNull String str3, int i12, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, "itemList");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, ScreenNames.SCREEN_TYPE_BRAND);
        Intrinsics.checkNotNullParameter(str4, "category");
        String str6 = str5;
        Intrinsics.checkNotNullParameter(str6, "variant");
        return new SwimlaneVendorTracking(str, i11, str2, str3, i12, str4, str6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SwimlaneVendorTracking)) {
            return false;
        }
        SwimlaneVendorTracking swimlaneVendorTracking = (SwimlaneVendorTracking) obj;
        return Intrinsics.areEqual((Object) this.itemList, (Object) swimlaneVendorTracking.itemList) && this.f63560id == swimlaneVendorTracking.f63560id && Intrinsics.areEqual((Object) this.f63561name, (Object) swimlaneVendorTracking.f63561name) && Intrinsics.areEqual((Object) this.brand, (Object) swimlaneVendorTracking.brand) && this.index == swimlaneVendorTracking.index && Intrinsics.areEqual((Object) this.category, (Object) swimlaneVendorTracking.category) && Intrinsics.areEqual((Object) this.variant, (Object) swimlaneVendorTracking.variant);
    }

    @NotNull
    public final String getBrand() {
        return this.brand;
    }

    @NotNull
    public final String getCategory() {
        return this.category;
    }

    public final int getId() {
        return this.f63560id;
    }

    public final int getIndex() {
        return this.index;
    }

    @NotNull
    public final String getItemList() {
        return this.itemList;
    }

    @NotNull
    public final String getName() {
        return this.f63561name;
    }

    @NotNull
    public final String getVariant() {
        return this.variant;
    }

    public int hashCode() {
        return (((((((((((this.itemList.hashCode() * 31) + this.f63560id) * 31) + this.f63561name.hashCode()) * 31) + this.brand.hashCode()) * 31) + this.index) * 31) + this.category.hashCode()) * 31) + this.variant.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.itemList;
        int i11 = this.f63560id;
        String str2 = this.f63561name;
        String str3 = this.brand;
        int i12 = this.index;
        String str4 = this.category;
        String str5 = this.variant;
        return "SwimlaneVendorTracking(itemList=" + str + ", id=" + i11 + ", name=" + str2 + ", brand=" + str3 + ", index=" + i12 + ", category=" + str4 + ", variant=" + str5 + ")";
    }
}
