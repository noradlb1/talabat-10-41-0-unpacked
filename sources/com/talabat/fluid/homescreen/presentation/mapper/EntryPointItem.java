package com.talabat.fluid.homescreen.presentation.mapper;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003JK\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020\bHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/talabat/fluid/homescreen/presentation/mapper/EntryPointItem;", "", "itemPosition", "", "id", "verticalIds", "", "deepLink", "", "shopName", "title", "(IILjava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDeepLink", "()Ljava/lang/String;", "getId", "()I", "getItemPosition", "getShopName", "getTitle", "getVerticalIds", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class EntryPointItem {
    @NotNull
    private final String deepLink;

    /* renamed from: id  reason: collision with root package name */
    private final int f59724id;
    private final int itemPosition;
    @NotNull
    private final String shopName;
    @NotNull
    private final String title;
    @NotNull
    private final List<Integer> verticalIds;

    public EntryPointItem(int i11, int i12, @NotNull List<Integer> list, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(list, "verticalIds");
        Intrinsics.checkNotNullParameter(str, "deepLink");
        Intrinsics.checkNotNullParameter(str2, "shopName");
        Intrinsics.checkNotNullParameter(str3, "title");
        this.itemPosition = i11;
        this.f59724id = i12;
        this.verticalIds = list;
        this.deepLink = str;
        this.shopName = str2;
        this.title = str3;
    }

    public static /* synthetic */ EntryPointItem copy$default(EntryPointItem entryPointItem, int i11, int i12, List<Integer> list, String str, String str2, String str3, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = entryPointItem.itemPosition;
        }
        if ((i13 & 2) != 0) {
            i12 = entryPointItem.f59724id;
        }
        int i14 = i12;
        if ((i13 & 4) != 0) {
            list = entryPointItem.verticalIds;
        }
        List<Integer> list2 = list;
        if ((i13 & 8) != 0) {
            str = entryPointItem.deepLink;
        }
        String str4 = str;
        if ((i13 & 16) != 0) {
            str2 = entryPointItem.shopName;
        }
        String str5 = str2;
        if ((i13 & 32) != 0) {
            str3 = entryPointItem.title;
        }
        return entryPointItem.copy(i11, i14, list2, str4, str5, str3);
    }

    public final int component1() {
        return this.itemPosition;
    }

    public final int component2() {
        return this.f59724id;
    }

    @NotNull
    public final List<Integer> component3() {
        return this.verticalIds;
    }

    @NotNull
    public final String component4() {
        return this.deepLink;
    }

    @NotNull
    public final String component5() {
        return this.shopName;
    }

    @NotNull
    public final String component6() {
        return this.title;
    }

    @NotNull
    public final EntryPointItem copy(int i11, int i12, @NotNull List<Integer> list, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(list, "verticalIds");
        Intrinsics.checkNotNullParameter(str, "deepLink");
        Intrinsics.checkNotNullParameter(str2, "shopName");
        Intrinsics.checkNotNullParameter(str3, "title");
        return new EntryPointItem(i11, i12, list, str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EntryPointItem)) {
            return false;
        }
        EntryPointItem entryPointItem = (EntryPointItem) obj;
        return this.itemPosition == entryPointItem.itemPosition && this.f59724id == entryPointItem.f59724id && Intrinsics.areEqual((Object) this.verticalIds, (Object) entryPointItem.verticalIds) && Intrinsics.areEqual((Object) this.deepLink, (Object) entryPointItem.deepLink) && Intrinsics.areEqual((Object) this.shopName, (Object) entryPointItem.shopName) && Intrinsics.areEqual((Object) this.title, (Object) entryPointItem.title);
    }

    @NotNull
    public final String getDeepLink() {
        return this.deepLink;
    }

    public final int getId() {
        return this.f59724id;
    }

    public final int getItemPosition() {
        return this.itemPosition;
    }

    @NotNull
    public final String getShopName() {
        return this.shopName;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final List<Integer> getVerticalIds() {
        return this.verticalIds;
    }

    public int hashCode() {
        return (((((((((this.itemPosition * 31) + this.f59724id) * 31) + this.verticalIds.hashCode()) * 31) + this.deepLink.hashCode()) * 31) + this.shopName.hashCode()) * 31) + this.title.hashCode();
    }

    @NotNull
    public String toString() {
        int i11 = this.itemPosition;
        int i12 = this.f59724id;
        List<Integer> list = this.verticalIds;
        String str = this.deepLink;
        String str2 = this.shopName;
        String str3 = this.title;
        return "EntryPointItem(itemPosition=" + i11 + ", id=" + i12 + ", verticalIds=" + list + ", deepLink=" + str + ", shopName=" + str2 + ", title=" + str3 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EntryPointItem(int i11, int i12, List list, String str, String str2, String str3, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, i12, (i13 & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i13 & 8) != 0 ? "" : str, str2, str3);
    }
}
