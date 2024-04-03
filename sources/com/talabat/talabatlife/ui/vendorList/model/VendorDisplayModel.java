package com.talabat.talabatlife.ui.vendorList.model;

import android.os.Parcel;
import android.os.Parcelable;
import buisnessmodels.FilterEngine;
import com.talabat.observability.squads.nfv.ObservableAttributesNames;
import com.visa.checkout.Profile;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b,\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005¢\u0006\u0002\u0010\u0016J\t\u0010>\u001a\u00020\u0003HÖ\u0001J\u0019\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\r\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR\u001a\u0010\u0014\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010!\"\u0004\b\"\u0010#R\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001c\"\u0004\b%\u0010\u001eR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001c\"\u0004\b+\u0010\u001eR\u001a\u0010\u0015\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001c\"\u0004\b-\u0010\u001eR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u0010\f\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001c\"\u0004\b3\u0010\u001eR\u001a\u0010\b\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001c\"\u0004\b5\u0010\u001eR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00107\"\u0004\b;\u00109R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010!\"\u0004\b=\u0010#¨\u0006D"}, d2 = {"Lcom/talabat/talabatlife/ui/vendorList/model/VendorDisplayModel;", "Landroid/os/Parcelable;", "restaurantId", "", "imageUrl", "", "logoUrl", "name", "rating", "reviewsCount", "minimumDistanceFromCustomer", "", "outletsCount", "cuisines", "amount", "", "offers", "", "viewTypeIsVendor", "", "isNew", "newTagText", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IDLjava/lang/String;Ljava/lang/String;FLjava/util/List;ZZLjava/lang/String;)V", "getAmount", "()F", "setAmount", "(F)V", "getCuisines", "()Ljava/lang/String;", "setCuisines", "(Ljava/lang/String;)V", "getImageUrl", "setImageUrl", "()Z", "setNew", "(Z)V", "getLogoUrl", "setLogoUrl", "getMinimumDistanceFromCustomer", "()D", "setMinimumDistanceFromCustomer", "(D)V", "getName", "setName", "getNewTagText", "setNewTagText", "getOffers", "()Ljava/util/List;", "setOffers", "(Ljava/util/List;)V", "getOutletsCount", "setOutletsCount", "getRating", "setRating", "getRestaurantId", "()I", "setRestaurantId", "(I)V", "getReviewsCount", "setReviewsCount", "getViewTypeIsVendor", "setViewTypeIsVendor", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Parcelize
public final class VendorDisplayModel implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<VendorDisplayModel> CREATOR = new Creator();
    private float amount;
    @NotNull
    private String cuisines;
    @NotNull
    private String imageUrl;
    private boolean isNew;
    @NotNull
    private String logoUrl;
    private double minimumDistanceFromCustomer;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private String f12095name;
    @NotNull
    private String newTagText;
    @NotNull
    private List<String> offers;
    @NotNull
    private String outletsCount;
    @NotNull
    private String rating;
    private int restaurantId;
    private int reviewsCount;
    private boolean viewTypeIsVendor;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<VendorDisplayModel> {
        @NotNull
        public final VendorDisplayModel createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            int readInt2 = parcel.readInt();
            double readDouble = parcel.readDouble();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            float readFloat = parcel.readFloat();
            ArrayList<String> createStringArrayList = parcel.createStringArrayList();
            boolean z11 = true;
            boolean z12 = parcel.readInt() != 0;
            if (parcel.readInt() == 0) {
                z11 = false;
            }
            return new VendorDisplayModel(readInt, readString, readString2, readString3, readString4, readInt2, readDouble, readString5, readString6, readFloat, createStringArrayList, z12, z11, parcel.readString());
        }

        @NotNull
        public final VendorDisplayModel[] newArray(int i11) {
            return new VendorDisplayModel[i11];
        }
    }

    public VendorDisplayModel() {
        this(0, (String) null, (String) null, (String) null, (String) null, 0, 0.0d, (String) null, (String) null, 0.0f, (List) null, false, false, (String) null, 16383, (DefaultConstructorMarker) null);
    }

    public VendorDisplayModel(int i11, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, int i12, double d11, @NotNull String str5, @NotNull String str6, float f11, @NotNull List<String> list, boolean z11, boolean z12, @NotNull String str7) {
        String str8 = str5;
        String str9 = str6;
        List<String> list2 = list;
        String str10 = str7;
        Intrinsics.checkNotNullParameter(str, ObservableAttributesNames.IMAGE_URL_V2);
        Intrinsics.checkNotNullParameter(str2, Profile.LOGO_URL);
        Intrinsics.checkNotNullParameter(str3, "name");
        Intrinsics.checkNotNullParameter(str4, FilterEngine.DEEPLINKSORT.RATING);
        Intrinsics.checkNotNullParameter(str8, "outletsCount");
        Intrinsics.checkNotNullParameter(str9, "cuisines");
        Intrinsics.checkNotNullParameter(list2, FilterEngine.DEEPLINKFILER.OFFERS);
        Intrinsics.checkNotNullParameter(str10, "newTagText");
        this.restaurantId = i11;
        this.imageUrl = str;
        this.logoUrl = str2;
        this.f12095name = str3;
        this.rating = str4;
        this.reviewsCount = i12;
        this.minimumDistanceFromCustomer = d11;
        this.outletsCount = str8;
        this.cuisines = str9;
        this.amount = f11;
        this.offers = list2;
        this.viewTypeIsVendor = z11;
        this.isNew = z12;
        this.newTagText = str10;
    }

    public int describeContents() {
        return 0;
    }

    public final float getAmount() {
        return this.amount;
    }

    @NotNull
    public final String getCuisines() {
        return this.cuisines;
    }

    @NotNull
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @NotNull
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    public final double getMinimumDistanceFromCustomer() {
        return this.minimumDistanceFromCustomer;
    }

    @NotNull
    public final String getName() {
        return this.f12095name;
    }

    @NotNull
    public final String getNewTagText() {
        return this.newTagText;
    }

    @NotNull
    public final List<String> getOffers() {
        return this.offers;
    }

    @NotNull
    public final String getOutletsCount() {
        return this.outletsCount;
    }

    @NotNull
    public final String getRating() {
        return this.rating;
    }

    public final int getRestaurantId() {
        return this.restaurantId;
    }

    public final int getReviewsCount() {
        return this.reviewsCount;
    }

    public final boolean getViewTypeIsVendor() {
        return this.viewTypeIsVendor;
    }

    public final boolean isNew() {
        return this.isNew;
    }

    public final void setAmount(float f11) {
        this.amount = f11;
    }

    public final void setCuisines(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cuisines = str;
    }

    public final void setImageUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.imageUrl = str;
    }

    public final void setLogoUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.logoUrl = str;
    }

    public final void setMinimumDistanceFromCustomer(double d11) {
        this.minimumDistanceFromCustomer = d11;
    }

    public final void setName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f12095name = str;
    }

    public final void setNew(boolean z11) {
        this.isNew = z11;
    }

    public final void setNewTagText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.newTagText = str;
    }

    public final void setOffers(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.offers = list;
    }

    public final void setOutletsCount(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.outletsCount = str;
    }

    public final void setRating(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.rating = str;
    }

    public final void setRestaurantId(int i11) {
        this.restaurantId = i11;
    }

    public final void setReviewsCount(int i11) {
        this.reviewsCount = i11;
    }

    public final void setViewTypeIsVendor(boolean z11) {
        this.viewTypeIsVendor = z11;
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.restaurantId);
        parcel.writeString(this.imageUrl);
        parcel.writeString(this.logoUrl);
        parcel.writeString(this.f12095name);
        parcel.writeString(this.rating);
        parcel.writeInt(this.reviewsCount);
        parcel.writeDouble(this.minimumDistanceFromCustomer);
        parcel.writeString(this.outletsCount);
        parcel.writeString(this.cuisines);
        parcel.writeFloat(this.amount);
        parcel.writeStringList(this.offers);
        parcel.writeInt(this.viewTypeIsVendor ? 1 : 0);
        parcel.writeInt(this.isNew ? 1 : 0);
        parcel.writeString(this.newTagText);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ VendorDisplayModel(int r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, int r21, double r22, java.lang.String r24, java.lang.String r25, float r26, java.util.List r27, boolean r28, boolean r29, java.lang.String r30, int r31, kotlin.jvm.internal.DefaultConstructorMarker r32) {
        /*
            r15 = this;
            r0 = r31
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = -1
            goto L_0x000a
        L_0x0008:
            r1 = r16
        L_0x000a:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x0015
            kotlin.jvm.internal.StringCompanionObject r2 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r2 = com.talabat.talabatcommon.extentions.StringUtils.empty(r2)
            goto L_0x0017
        L_0x0015:
            r2 = r17
        L_0x0017:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x0022
            kotlin.jvm.internal.StringCompanionObject r3 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r3 = com.talabat.talabatcommon.extentions.StringUtils.empty(r3)
            goto L_0x0024
        L_0x0022:
            r3 = r18
        L_0x0024:
            r4 = r0 & 8
            if (r4 == 0) goto L_0x002f
            kotlin.jvm.internal.StringCompanionObject r4 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r4 = com.talabat.talabatcommon.extentions.StringUtils.empty(r4)
            goto L_0x0031
        L_0x002f:
            r4 = r19
        L_0x0031:
            r5 = r0 & 16
            if (r5 == 0) goto L_0x003c
            kotlin.jvm.internal.StringCompanionObject r5 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r5 = com.talabat.talabatcommon.extentions.StringUtils.empty(r5)
            goto L_0x003e
        L_0x003c:
            r5 = r20
        L_0x003e:
            r6 = r0 & 32
            if (r6 == 0) goto L_0x0049
            kotlin.jvm.internal.IntCompanionObject r6 = kotlin.jvm.internal.IntCompanionObject.INSTANCE
            int r6 = com.talabat.talabatcommon.extentions.IntKt.orZero((kotlin.jvm.internal.IntCompanionObject) r6)
            goto L_0x004b
        L_0x0049:
            r6 = r21
        L_0x004b:
            r7 = r0 & 64
            if (r7 == 0) goto L_0x0056
            kotlin.jvm.internal.DoubleCompanionObject r7 = kotlin.jvm.internal.DoubleCompanionObject.INSTANCE
            double r7 = com.talabat.talabatcommon.extentions.DoubleKt.orZero((kotlin.jvm.internal.DoubleCompanionObject) r7)
            goto L_0x0058
        L_0x0056:
            r7 = r22
        L_0x0058:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0063
            kotlin.jvm.internal.StringCompanionObject r9 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r9 = com.talabat.talabatcommon.extentions.StringUtils.empty(r9)
            goto L_0x0065
        L_0x0063:
            r9 = r24
        L_0x0065:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0070
            kotlin.jvm.internal.StringCompanionObject r10 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r10 = com.talabat.talabatcommon.extentions.StringUtils.empty(r10)
            goto L_0x0072
        L_0x0070:
            r10 = r25
        L_0x0072:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0078
            r11 = 0
            goto L_0x007a
        L_0x0078:
            r11 = r26
        L_0x007a:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0083
            java.util.List r12 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            goto L_0x0085
        L_0x0083:
            r12 = r27
        L_0x0085:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x008b
            r13 = 1
            goto L_0x008d
        L_0x008b:
            r13 = r28
        L_0x008d:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0093
            r14 = 0
            goto L_0x0095
        L_0x0093:
            r14 = r29
        L_0x0095:
            r0 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x009c
            java.lang.String r0 = ""
            goto L_0x009e
        L_0x009c:
            r0 = r30
        L_0x009e:
            r16 = r15
            r17 = r1
            r18 = r2
            r19 = r3
            r20 = r4
            r21 = r5
            r22 = r6
            r23 = r7
            r25 = r9
            r26 = r10
            r27 = r11
            r28 = r12
            r29 = r13
            r30 = r14
            r31 = r0
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r25, r26, r27, r28, r29, r30, r31)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatlife.ui.vendorList.model.VendorDisplayModel.<init>(int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, double, java.lang.String, java.lang.String, float, java.util.List, boolean, boolean, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
