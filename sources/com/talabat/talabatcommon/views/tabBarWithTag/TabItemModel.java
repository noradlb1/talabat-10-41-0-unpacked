package com.talabat.talabatcommon.views.tabBarWithTag;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/talabat/talabatcommon/views/tabBarWithTag/TabItemModel;", "", "id", "", "title", "", "shouldShowTag", "", "tagPercentage", "isRevamp", "isShowIcon", "(ILjava/lang/String;ZIZZ)V", "getId", "()I", "()Z", "getShouldShowTag", "getTagPercentage", "getTitle", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TabItemModel {

    /* renamed from: id  reason: collision with root package name */
    private final int f11755id;
    private final boolean isRevamp;
    private final boolean isShowIcon;
    private final boolean shouldShowTag;
    private final int tagPercentage;
    @NotNull
    private final String title;

    public TabItemModel(int i11, @NotNull String str, boolean z11, int i12, boolean z12, boolean z13) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.f11755id = i11;
        this.title = str;
        this.shouldShowTag = z11;
        this.tagPercentage = i12;
        this.isRevamp = z12;
        this.isShowIcon = z13;
    }

    public static /* synthetic */ TabItemModel copy$default(TabItemModel tabItemModel, int i11, String str, boolean z11, int i12, boolean z12, boolean z13, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = tabItemModel.f11755id;
        }
        if ((i13 & 2) != 0) {
            str = tabItemModel.title;
        }
        String str2 = str;
        if ((i13 & 4) != 0) {
            z11 = tabItemModel.shouldShowTag;
        }
        boolean z14 = z11;
        if ((i13 & 8) != 0) {
            i12 = tabItemModel.tagPercentage;
        }
        int i14 = i12;
        if ((i13 & 16) != 0) {
            z12 = tabItemModel.isRevamp;
        }
        boolean z15 = z12;
        if ((i13 & 32) != 0) {
            z13 = tabItemModel.isShowIcon;
        }
        return tabItemModel.copy(i11, str2, z14, i14, z15, z13);
    }

    public final int component1() {
        return this.f11755id;
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    public final boolean component3() {
        return this.shouldShowTag;
    }

    public final int component4() {
        return this.tagPercentage;
    }

    public final boolean component5() {
        return this.isRevamp;
    }

    public final boolean component6() {
        return this.isShowIcon;
    }

    @NotNull
    public final TabItemModel copy(int i11, @NotNull String str, boolean z11, int i12, boolean z12, boolean z13) {
        Intrinsics.checkNotNullParameter(str, "title");
        return new TabItemModel(i11, str, z11, i12, z12, z13);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TabItemModel)) {
            return false;
        }
        TabItemModel tabItemModel = (TabItemModel) obj;
        return this.f11755id == tabItemModel.f11755id && Intrinsics.areEqual((Object) this.title, (Object) tabItemModel.title) && this.shouldShowTag == tabItemModel.shouldShowTag && this.tagPercentage == tabItemModel.tagPercentage && this.isRevamp == tabItemModel.isRevamp && this.isShowIcon == tabItemModel.isShowIcon;
    }

    public final int getId() {
        return this.f11755id;
    }

    public final boolean getShouldShowTag() {
        return this.shouldShowTag;
    }

    public final int getTagPercentage() {
        return this.tagPercentage;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int hashCode = ((this.f11755id * 31) + this.title.hashCode()) * 31;
        boolean z11 = this.shouldShowTag;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int i11 = (((hashCode + (z11 ? 1 : 0)) * 31) + this.tagPercentage) * 31;
        boolean z13 = this.isRevamp;
        if (z13) {
            z13 = true;
        }
        int i12 = (i11 + (z13 ? 1 : 0)) * 31;
        boolean z14 = this.isShowIcon;
        if (!z14) {
            z12 = z14;
        }
        return i12 + (z12 ? 1 : 0);
    }

    public final boolean isRevamp() {
        return this.isRevamp;
    }

    public final boolean isShowIcon() {
        return this.isShowIcon;
    }

    @NotNull
    public String toString() {
        int i11 = this.f11755id;
        String str = this.title;
        boolean z11 = this.shouldShowTag;
        int i12 = this.tagPercentage;
        boolean z12 = this.isRevamp;
        boolean z13 = this.isShowIcon;
        return "TabItemModel(id=" + i11 + ", title=" + str + ", shouldShowTag=" + z11 + ", tagPercentage=" + i12 + ", isRevamp=" + z12 + ", isShowIcon=" + z13 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TabItemModel(int i11, String str, boolean z11, int i12, boolean z12, boolean z13, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, str, (i13 & 4) != 0 ? false : z11, (i13 & 8) != 0 ? 0 : i12, (i13 & 16) != 0 ? false : z12, (i13 & 32) != 0 ? false : z13);
    }
}
