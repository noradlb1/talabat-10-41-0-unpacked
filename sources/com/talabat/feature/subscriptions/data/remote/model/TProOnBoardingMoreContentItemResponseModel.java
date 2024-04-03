package com.talabat.feature.subscriptions.data.remote.model;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J]\u0010\u001a\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006!"}, d2 = {"Lcom/talabat/feature/subscriptions/data/remote/model/TProOnBoardingMoreContentItemResponseModel;", "", "backgroundColor", "", "leadingImage", "leadingText", "leadingTextColor", "trailingText", "trailingTextColor", "type", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBackgroundColor", "()Ljava/lang/String;", "getLeadingImage", "getLeadingText", "getLeadingTextColor", "getTrailingText", "getTrailingTextColor", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProOnBoardingMoreContentItemResponseModel {
    @Nullable
    private final String backgroundColor;
    @Nullable
    private final String leadingImage;
    @Nullable
    private final String leadingText;
    @Nullable
    private final String leadingTextColor;
    @Nullable
    private final String trailingText;
    @Nullable
    private final String trailingTextColor;
    @Nullable
    private final String type;

    public TProOnBoardingMoreContentItemResponseModel() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 127, (DefaultConstructorMarker) null);
    }

    public TProOnBoardingMoreContentItemResponseModel(@Nullable @Json(name = "backgroundColor") String str, @Nullable @Json(name = "leadingImage") String str2, @Nullable @Json(name = "leadingText") String str3, @Nullable @Json(name = "leadingTextColor") String str4, @Nullable @Json(name = "trailingText") String str5, @Nullable @Json(name = "trailingTextColor") String str6, @Nullable @Json(name = "type") String str7) {
        this.backgroundColor = str;
        this.leadingImage = str2;
        this.leadingText = str3;
        this.leadingTextColor = str4;
        this.trailingText = str5;
        this.trailingTextColor = str6;
        this.type = str7;
    }

    public static /* synthetic */ TProOnBoardingMoreContentItemResponseModel copy$default(TProOnBoardingMoreContentItemResponseModel tProOnBoardingMoreContentItemResponseModel, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = tProOnBoardingMoreContentItemResponseModel.backgroundColor;
        }
        if ((i11 & 2) != 0) {
            str2 = tProOnBoardingMoreContentItemResponseModel.leadingImage;
        }
        String str8 = str2;
        if ((i11 & 4) != 0) {
            str3 = tProOnBoardingMoreContentItemResponseModel.leadingText;
        }
        String str9 = str3;
        if ((i11 & 8) != 0) {
            str4 = tProOnBoardingMoreContentItemResponseModel.leadingTextColor;
        }
        String str10 = str4;
        if ((i11 & 16) != 0) {
            str5 = tProOnBoardingMoreContentItemResponseModel.trailingText;
        }
        String str11 = str5;
        if ((i11 & 32) != 0) {
            str6 = tProOnBoardingMoreContentItemResponseModel.trailingTextColor;
        }
        String str12 = str6;
        if ((i11 & 64) != 0) {
            str7 = tProOnBoardingMoreContentItemResponseModel.type;
        }
        return tProOnBoardingMoreContentItemResponseModel.copy(str, str8, str9, str10, str11, str12, str7);
    }

    @Nullable
    public final String component1() {
        return this.backgroundColor;
    }

    @Nullable
    public final String component2() {
        return this.leadingImage;
    }

    @Nullable
    public final String component3() {
        return this.leadingText;
    }

    @Nullable
    public final String component4() {
        return this.leadingTextColor;
    }

    @Nullable
    public final String component5() {
        return this.trailingText;
    }

    @Nullable
    public final String component6() {
        return this.trailingTextColor;
    }

    @Nullable
    public final String component7() {
        return this.type;
    }

    @NotNull
    public final TProOnBoardingMoreContentItemResponseModel copy(@Nullable @Json(name = "backgroundColor") String str, @Nullable @Json(name = "leadingImage") String str2, @Nullable @Json(name = "leadingText") String str3, @Nullable @Json(name = "leadingTextColor") String str4, @Nullable @Json(name = "trailingText") String str5, @Nullable @Json(name = "trailingTextColor") String str6, @Nullable @Json(name = "type") String str7) {
        return new TProOnBoardingMoreContentItemResponseModel(str, str2, str3, str4, str5, str6, str7);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TProOnBoardingMoreContentItemResponseModel)) {
            return false;
        }
        TProOnBoardingMoreContentItemResponseModel tProOnBoardingMoreContentItemResponseModel = (TProOnBoardingMoreContentItemResponseModel) obj;
        return Intrinsics.areEqual((Object) this.backgroundColor, (Object) tProOnBoardingMoreContentItemResponseModel.backgroundColor) && Intrinsics.areEqual((Object) this.leadingImage, (Object) tProOnBoardingMoreContentItemResponseModel.leadingImage) && Intrinsics.areEqual((Object) this.leadingText, (Object) tProOnBoardingMoreContentItemResponseModel.leadingText) && Intrinsics.areEqual((Object) this.leadingTextColor, (Object) tProOnBoardingMoreContentItemResponseModel.leadingTextColor) && Intrinsics.areEqual((Object) this.trailingText, (Object) tProOnBoardingMoreContentItemResponseModel.trailingText) && Intrinsics.areEqual((Object) this.trailingTextColor, (Object) tProOnBoardingMoreContentItemResponseModel.trailingTextColor) && Intrinsics.areEqual((Object) this.type, (Object) tProOnBoardingMoreContentItemResponseModel.type);
    }

    @Nullable
    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    @Nullable
    public final String getLeadingImage() {
        return this.leadingImage;
    }

    @Nullable
    public final String getLeadingText() {
        return this.leadingText;
    }

    @Nullable
    public final String getLeadingTextColor() {
        return this.leadingTextColor;
    }

    @Nullable
    public final String getTrailingText() {
        return this.trailingText;
    }

    @Nullable
    public final String getTrailingTextColor() {
        return this.trailingTextColor;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.backgroundColor;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.leadingImage;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.leadingText;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.leadingTextColor;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.trailingText;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.trailingTextColor;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.type;
        if (str7 != null) {
            i11 = str7.hashCode();
        }
        return hashCode6 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.backgroundColor;
        String str2 = this.leadingImage;
        String str3 = this.leadingText;
        String str4 = this.leadingTextColor;
        String str5 = this.trailingText;
        String str6 = this.trailingTextColor;
        String str7 = this.type;
        return "TProOnBoardingMoreContentItemResponseModel(backgroundColor=" + str + ", leadingImage=" + str2 + ", leadingText=" + str3 + ", leadingTextColor=" + str4 + ", trailingText=" + str5 + ", trailingTextColor=" + str6 + ", type=" + str7 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TProOnBoardingMoreContentItemResponseModel(java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r6 = this;
            r15 = r14 & 1
            r0 = 0
            if (r15 == 0) goto L_0x0007
            r15 = r0
            goto L_0x0008
        L_0x0007:
            r15 = r7
        L_0x0008:
            r7 = r14 & 2
            if (r7 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r8
        L_0x000f:
            r7 = r14 & 4
            if (r7 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r9
        L_0x0016:
            r7 = r14 & 8
            if (r7 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r10
        L_0x001d:
            r7 = r14 & 16
            if (r7 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r11
        L_0x0024:
            r7 = r14 & 32
            if (r7 == 0) goto L_0x002a
            r5 = r0
            goto L_0x002b
        L_0x002a:
            r5 = r12
        L_0x002b:
            r7 = r14 & 64
            if (r7 == 0) goto L_0x0031
            r14 = r0
            goto L_0x0032
        L_0x0031:
            r14 = r13
        L_0x0032:
            r7 = r6
            r8 = r15
            r9 = r1
            r10 = r2
            r11 = r3
            r12 = r4
            r13 = r5
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingMoreContentItemResponseModel.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
