package com.talabat.homescreen.adapter.model.vetrical;

import com.google.gson.annotations.SerializedName;
import com.talabat.observability.squads.nfv.ObservableAttributesNames;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b#\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001:\u0001:Bw\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0002\u0010\u0014J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010HÆ\u0003J\u000f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012HÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0007HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u000bHÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\u0001\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00102\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012HÆ\u0001J\u0013\u00105\u001a\u00020\u000b2\b\u00106\u001a\u0004\u0018\u000107HÖ\u0003J\t\u00108\u001a\u00020\u0003HÖ\u0001J\t\u00109\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\f\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u001cR \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(¨\u0006;"}, d2 = {"Lcom/talabat/homescreen/adapter/model/vetrical/VerticalItem;", "Ljava/io/Serializable;", "id", "", "title", "", "widthType", "Lcom/talabat/homescreen/adapter/model/vetrical/VerticalItem$WidthType;", "backgroundColorHex", "imageUrl", "isNew", "", "deepLink", "imageId", "titleId", "verticalIds", "", "onSmallVerticalClicked", "Lkotlin/Function0;", "", "(ILjava/lang/String;Lcom/talabat/homescreen/adapter/model/vetrical/VerticalItem$WidthType;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;IILjava/util/List;Lkotlin/jvm/functions/Function0;)V", "getBackgroundColorHex", "()Ljava/lang/String;", "getDeepLink", "getId", "()I", "getImageId", "getImageUrl", "()Z", "getOnSmallVerticalClicked", "()Lkotlin/jvm/functions/Function0;", "setOnSmallVerticalClicked", "(Lkotlin/jvm/functions/Function0;)V", "getTitle", "getTitleId", "getVerticalIds", "()Ljava/util/List;", "setVerticalIds", "(Ljava/util/List;)V", "getWidthType", "()Lcom/talabat/homescreen/adapter/model/vetrical/VerticalItem$WidthType;", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "WidthType", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VerticalItem implements Serializable {
    @NotNull
    private final String backgroundColorHex;
    @SerializedName("deeplink")
    @NotNull
    private final String deepLink;

    /* renamed from: id  reason: collision with root package name */
    private final int f60966id;
    private final int imageId;
    @NotNull
    private final String imageUrl;
    private final boolean isNew;
    @NotNull
    private Function0<Unit> onSmallVerticalClicked;
    @NotNull
    private final String title;
    private final int titleId;
    @NotNull
    private List<Integer> verticalIds;
    @NotNull
    private final WidthType widthType;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/talabat/homescreen/adapter/model/vetrical/VerticalItem$WidthType;", "", "percent", "", "(Ljava/lang/String;IF)V", "getPercent", "()F", "QUOTER", "HALF", "THREEFOURTHS", "FULL", "THIRD", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum WidthType {
        QUOTER(25.0f),
        HALF(50.0f),
        THREEFOURTHS(75.0f),
        FULL(100.0f),
        THIRD(34.0f);
        
        private final float percent;

        private WidthType(float f11) {
            this.percent = f11;
        }

        public final float getPercent() {
            return this.percent;
        }
    }

    public VerticalItem(int i11, @NotNull String str, @NotNull WidthType widthType2, @NotNull String str2, @NotNull String str3, boolean z11, @NotNull String str4, int i12, int i13, @NotNull List<Integer> list, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(widthType2, "widthType");
        Intrinsics.checkNotNullParameter(str2, "backgroundColorHex");
        Intrinsics.checkNotNullParameter(str3, ObservableAttributesNames.IMAGE_URL_V2);
        Intrinsics.checkNotNullParameter(str4, "deepLink");
        Intrinsics.checkNotNullParameter(list, "verticalIds");
        Intrinsics.checkNotNullParameter(function0, "onSmallVerticalClicked");
        this.f60966id = i11;
        this.title = str;
        this.widthType = widthType2;
        this.backgroundColorHex = str2;
        this.imageUrl = str3;
        this.isNew = z11;
        this.deepLink = str4;
        this.imageId = i12;
        this.titleId = i13;
        this.verticalIds = list;
        this.onSmallVerticalClicked = function0;
    }

    public static /* synthetic */ VerticalItem copy$default(VerticalItem verticalItem, int i11, String str, WidthType widthType2, String str2, String str3, boolean z11, String str4, int i12, int i13, List list, Function0 function0, int i14, Object obj) {
        VerticalItem verticalItem2 = verticalItem;
        int i15 = i14;
        return verticalItem.copy((i15 & 1) != 0 ? verticalItem2.f60966id : i11, (i15 & 2) != 0 ? verticalItem2.title : str, (i15 & 4) != 0 ? verticalItem2.widthType : widthType2, (i15 & 8) != 0 ? verticalItem2.backgroundColorHex : str2, (i15 & 16) != 0 ? verticalItem2.imageUrl : str3, (i15 & 32) != 0 ? verticalItem2.isNew : z11, (i15 & 64) != 0 ? verticalItem2.deepLink : str4, (i15 & 128) != 0 ? verticalItem2.imageId : i12, (i15 & 256) != 0 ? verticalItem2.titleId : i13, (i15 & 512) != 0 ? verticalItem2.verticalIds : list, (i15 & 1024) != 0 ? verticalItem2.onSmallVerticalClicked : function0);
    }

    public final int component1() {
        return this.f60966id;
    }

    @NotNull
    public final List<Integer> component10() {
        return this.verticalIds;
    }

    @NotNull
    public final Function0<Unit> component11() {
        return this.onSmallVerticalClicked;
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    @NotNull
    public final WidthType component3() {
        return this.widthType;
    }

    @NotNull
    public final String component4() {
        return this.backgroundColorHex;
    }

    @NotNull
    public final String component5() {
        return this.imageUrl;
    }

    public final boolean component6() {
        return this.isNew;
    }

    @NotNull
    public final String component7() {
        return this.deepLink;
    }

    public final int component8() {
        return this.imageId;
    }

    public final int component9() {
        return this.titleId;
    }

    @NotNull
    public final VerticalItem copy(int i11, @NotNull String str, @NotNull WidthType widthType2, @NotNull String str2, @NotNull String str3, boolean z11, @NotNull String str4, int i12, int i13, @NotNull List<Integer> list, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "title");
        WidthType widthType3 = widthType2;
        Intrinsics.checkNotNullParameter(widthType3, "widthType");
        String str5 = str2;
        Intrinsics.checkNotNullParameter(str5, "backgroundColorHex");
        String str6 = str3;
        Intrinsics.checkNotNullParameter(str6, ObservableAttributesNames.IMAGE_URL_V2);
        String str7 = str4;
        Intrinsics.checkNotNullParameter(str7, "deepLink");
        List<Integer> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "verticalIds");
        Function0<Unit> function02 = function0;
        Intrinsics.checkNotNullParameter(function02, "onSmallVerticalClicked");
        return new VerticalItem(i11, str, widthType3, str5, str6, z11, str7, i12, i13, list2, function02);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VerticalItem)) {
            return false;
        }
        VerticalItem verticalItem = (VerticalItem) obj;
        return this.f60966id == verticalItem.f60966id && Intrinsics.areEqual((Object) this.title, (Object) verticalItem.title) && this.widthType == verticalItem.widthType && Intrinsics.areEqual((Object) this.backgroundColorHex, (Object) verticalItem.backgroundColorHex) && Intrinsics.areEqual((Object) this.imageUrl, (Object) verticalItem.imageUrl) && this.isNew == verticalItem.isNew && Intrinsics.areEqual((Object) this.deepLink, (Object) verticalItem.deepLink) && this.imageId == verticalItem.imageId && this.titleId == verticalItem.titleId && Intrinsics.areEqual((Object) this.verticalIds, (Object) verticalItem.verticalIds) && Intrinsics.areEqual((Object) this.onSmallVerticalClicked, (Object) verticalItem.onSmallVerticalClicked);
    }

    @NotNull
    public final String getBackgroundColorHex() {
        return this.backgroundColorHex;
    }

    @NotNull
    public final String getDeepLink() {
        return this.deepLink;
    }

    public final int getId() {
        return this.f60966id;
    }

    public final int getImageId() {
        return this.imageId;
    }

    @NotNull
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @NotNull
    public final Function0<Unit> getOnSmallVerticalClicked() {
        return this.onSmallVerticalClicked;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public final int getTitleId() {
        return this.titleId;
    }

    @NotNull
    public final List<Integer> getVerticalIds() {
        return this.verticalIds;
    }

    @NotNull
    public final WidthType getWidthType() {
        return this.widthType;
    }

    public int hashCode() {
        int hashCode = ((((((((this.f60966id * 31) + this.title.hashCode()) * 31) + this.widthType.hashCode()) * 31) + this.backgroundColorHex.hashCode()) * 31) + this.imageUrl.hashCode()) * 31;
        boolean z11 = this.isNew;
        if (z11) {
            z11 = true;
        }
        return ((((((((((hashCode + (z11 ? 1 : 0)) * 31) + this.deepLink.hashCode()) * 31) + this.imageId) * 31) + this.titleId) * 31) + this.verticalIds.hashCode()) * 31) + this.onSmallVerticalClicked.hashCode();
    }

    public final boolean isNew() {
        return this.isNew;
    }

    public final void setOnSmallVerticalClicked(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onSmallVerticalClicked = function0;
    }

    public final void setVerticalIds(@NotNull List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.verticalIds = list;
    }

    @NotNull
    public String toString() {
        int i11 = this.f60966id;
        String str = this.title;
        WidthType widthType2 = this.widthType;
        String str2 = this.backgroundColorHex;
        String str3 = this.imageUrl;
        boolean z11 = this.isNew;
        String str4 = this.deepLink;
        int i12 = this.imageId;
        int i13 = this.titleId;
        List<Integer> list = this.verticalIds;
        Function0<Unit> function0 = this.onSmallVerticalClicked;
        return "VerticalItem(id=" + i11 + ", title=" + str + ", widthType=" + widthType2 + ", backgroundColorHex=" + str2 + ", imageUrl=" + str3 + ", isNew=" + z11 + ", deepLink=" + str4 + ", imageId=" + i12 + ", titleId=" + i13 + ", verticalIds=" + list + ", onSmallVerticalClicked=" + function0 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ VerticalItem(int r16, java.lang.String r17, com.talabat.homescreen.adapter.model.vetrical.VerticalItem.WidthType r18, java.lang.String r19, java.lang.String r20, boolean r21, java.lang.String r22, int r23, int r24, java.util.List r25, kotlin.jvm.functions.Function0 r26, int r27, kotlin.jvm.internal.DefaultConstructorMarker r28) {
        /*
            r15 = this;
            r0 = r27
            r1 = r0 & 2
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000a
            r5 = r2
            goto L_0x000c
        L_0x000a:
            r5 = r17
        L_0x000c:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0012
            r8 = r2
            goto L_0x0014
        L_0x0012:
            r8 = r20
        L_0x0014:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x001a
            r10 = r2
            goto L_0x001c
        L_0x001a:
            r10 = r22
        L_0x001c:
            r1 = r0 & 128(0x80, float:1.794E-43)
            r2 = -1
            if (r1 == 0) goto L_0x0023
            r11 = r2
            goto L_0x0025
        L_0x0023:
            r11 = r23
        L_0x0025:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x002b
            r12 = r2
            goto L_0x002d
        L_0x002b:
            r12 = r24
        L_0x002d:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0037
            java.util.List r1 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            r13 = r1
            goto L_0x0039
        L_0x0037:
            r13 = r25
        L_0x0039:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0041
            com.talabat.homescreen.adapter.model.vetrical.VerticalItem$1 r0 = com.talabat.homescreen.adapter.model.vetrical.VerticalItem.AnonymousClass1.INSTANCE
            r14 = r0
            goto L_0x0043
        L_0x0041:
            r14 = r26
        L_0x0043:
            r3 = r15
            r4 = r16
            r6 = r18
            r7 = r19
            r9 = r21
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.homescreen.adapter.model.vetrical.VerticalItem.<init>(int, java.lang.String, com.talabat.homescreen.adapter.model.vetrical.VerticalItem$WidthType, java.lang.String, java.lang.String, boolean, java.lang.String, int, int, java.util.List, kotlin.jvm.functions.Function0, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
