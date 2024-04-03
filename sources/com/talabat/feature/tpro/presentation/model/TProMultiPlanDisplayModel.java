package com.talabat.feature.tpro.presentation.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007¢\u0006\u0002\u0010\u000fJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\r0\nHÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J[\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\n2\b\b\u0002\u0010\u000e\u001a\u00020\u0007HÆ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001J\u0013\u0010$\u001a\u00020\u00032\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\u0005HÖ\u0001J\t\u0010(\u001a\u00020\u0007HÖ\u0001J\u0019\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016¨\u0006."}, d2 = {"Lcom/talabat/feature/tpro/presentation/model/TProMultiPlanDisplayModel;", "Landroid/os/Parcelable;", "activeSubscription", "", "freeTrialDays", "", "freeTrialTitle", "", "freeTrialEligible", "plans", "", "Lcom/talabat/feature/tpro/presentation/model/TProPlanDisplayModel;", "products", "Lcom/talabat/feature/tpro/presentation/model/TProProductDisplayModel;", "termsUrl", "(ZILjava/lang/String;ZLjava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getActiveSubscription", "()Z", "getFreeTrialDays", "()I", "getFreeTrialEligible", "getFreeTrialTitle", "()Ljava/lang/String;", "getPlans", "()Ljava/util/List;", "getProducts", "getTermsUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Parcelize
public final class TProMultiPlanDisplayModel implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<TProMultiPlanDisplayModel> CREATOR = new Creator();
    private final boolean activeSubscription;
    private final int freeTrialDays;
    private final boolean freeTrialEligible;
    @NotNull
    private final String freeTrialTitle;
    @NotNull
    private final List<TProPlanDisplayModel> plans;
    @NotNull
    private final List<TProProductDisplayModel> products;
    @NotNull
    private final String termsUrl;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<TProMultiPlanDisplayModel> {
        @NotNull
        public final TProMultiPlanDisplayModel createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            boolean z11 = parcel.readInt() != 0;
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            boolean z12 = parcel.readInt() != 0;
            int readInt2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt2);
            for (int i11 = 0; i11 != readInt2; i11++) {
                arrayList.add(TProPlanDisplayModel.CREATOR.createFromParcel(parcel));
            }
            int readInt3 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(readInt3);
            for (int i12 = 0; i12 != readInt3; i12++) {
                arrayList2.add(TProProductDisplayModel.CREATOR.createFromParcel(parcel));
            }
            return new TProMultiPlanDisplayModel(z11, readInt, readString, z12, arrayList, arrayList2, parcel.readString());
        }

        @NotNull
        public final TProMultiPlanDisplayModel[] newArray(int i11) {
            return new TProMultiPlanDisplayModel[i11];
        }
    }

    public TProMultiPlanDisplayModel() {
        this(false, 0, (String) null, false, (List) null, (List) null, (String) null, 127, (DefaultConstructorMarker) null);
    }

    public TProMultiPlanDisplayModel(boolean z11, int i11, @NotNull String str, boolean z12, @NotNull List<TProPlanDisplayModel> list, @NotNull List<TProProductDisplayModel> list2, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "freeTrialTitle");
        Intrinsics.checkNotNullParameter(list, "plans");
        Intrinsics.checkNotNullParameter(list2, "products");
        Intrinsics.checkNotNullParameter(str2, "termsUrl");
        this.activeSubscription = z11;
        this.freeTrialDays = i11;
        this.freeTrialTitle = str;
        this.freeTrialEligible = z12;
        this.plans = list;
        this.products = list2;
        this.termsUrl = str2;
    }

    public static /* synthetic */ TProMultiPlanDisplayModel copy$default(TProMultiPlanDisplayModel tProMultiPlanDisplayModel, boolean z11, int i11, String str, boolean z12, List<TProPlanDisplayModel> list, List<TProProductDisplayModel> list2, String str2, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            z11 = tProMultiPlanDisplayModel.activeSubscription;
        }
        if ((i12 & 2) != 0) {
            i11 = tProMultiPlanDisplayModel.freeTrialDays;
        }
        int i13 = i11;
        if ((i12 & 4) != 0) {
            str = tProMultiPlanDisplayModel.freeTrialTitle;
        }
        String str3 = str;
        if ((i12 & 8) != 0) {
            z12 = tProMultiPlanDisplayModel.freeTrialEligible;
        }
        boolean z13 = z12;
        if ((i12 & 16) != 0) {
            list = tProMultiPlanDisplayModel.plans;
        }
        List<TProPlanDisplayModel> list3 = list;
        if ((i12 & 32) != 0) {
            list2 = tProMultiPlanDisplayModel.products;
        }
        List<TProProductDisplayModel> list4 = list2;
        if ((i12 & 64) != 0) {
            str2 = tProMultiPlanDisplayModel.termsUrl;
        }
        return tProMultiPlanDisplayModel.copy(z11, i13, str3, z13, list3, list4, str2);
    }

    public final boolean component1() {
        return this.activeSubscription;
    }

    public final int component2() {
        return this.freeTrialDays;
    }

    @NotNull
    public final String component3() {
        return this.freeTrialTitle;
    }

    public final boolean component4() {
        return this.freeTrialEligible;
    }

    @NotNull
    public final List<TProPlanDisplayModel> component5() {
        return this.plans;
    }

    @NotNull
    public final List<TProProductDisplayModel> component6() {
        return this.products;
    }

    @NotNull
    public final String component7() {
        return this.termsUrl;
    }

    @NotNull
    public final TProMultiPlanDisplayModel copy(boolean z11, int i11, @NotNull String str, boolean z12, @NotNull List<TProPlanDisplayModel> list, @NotNull List<TProProductDisplayModel> list2, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "freeTrialTitle");
        Intrinsics.checkNotNullParameter(list, "plans");
        Intrinsics.checkNotNullParameter(list2, "products");
        String str3 = str2;
        Intrinsics.checkNotNullParameter(str3, "termsUrl");
        return new TProMultiPlanDisplayModel(z11, i11, str, z12, list, list2, str3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TProMultiPlanDisplayModel)) {
            return false;
        }
        TProMultiPlanDisplayModel tProMultiPlanDisplayModel = (TProMultiPlanDisplayModel) obj;
        return this.activeSubscription == tProMultiPlanDisplayModel.activeSubscription && this.freeTrialDays == tProMultiPlanDisplayModel.freeTrialDays && Intrinsics.areEqual((Object) this.freeTrialTitle, (Object) tProMultiPlanDisplayModel.freeTrialTitle) && this.freeTrialEligible == tProMultiPlanDisplayModel.freeTrialEligible && Intrinsics.areEqual((Object) this.plans, (Object) tProMultiPlanDisplayModel.plans) && Intrinsics.areEqual((Object) this.products, (Object) tProMultiPlanDisplayModel.products) && Intrinsics.areEqual((Object) this.termsUrl, (Object) tProMultiPlanDisplayModel.termsUrl);
    }

    public final boolean getActiveSubscription() {
        return this.activeSubscription;
    }

    public final int getFreeTrialDays() {
        return this.freeTrialDays;
    }

    public final boolean getFreeTrialEligible() {
        return this.freeTrialEligible;
    }

    @NotNull
    public final String getFreeTrialTitle() {
        return this.freeTrialTitle;
    }

    @NotNull
    public final List<TProPlanDisplayModel> getPlans() {
        return this.plans;
    }

    @NotNull
    public final List<TProProductDisplayModel> getProducts() {
        return this.products;
    }

    @NotNull
    public final String getTermsUrl() {
        return this.termsUrl;
    }

    public int hashCode() {
        boolean z11 = this.activeSubscription;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int hashCode = (((((z11 ? 1 : 0) * true) + this.freeTrialDays) * 31) + this.freeTrialTitle.hashCode()) * 31;
        boolean z13 = this.freeTrialEligible;
        if (!z13) {
            z12 = z13;
        }
        return ((((((hashCode + (z12 ? 1 : 0)) * 31) + this.plans.hashCode()) * 31) + this.products.hashCode()) * 31) + this.termsUrl.hashCode();
    }

    @NotNull
    public String toString() {
        boolean z11 = this.activeSubscription;
        int i11 = this.freeTrialDays;
        String str = this.freeTrialTitle;
        boolean z12 = this.freeTrialEligible;
        List<TProPlanDisplayModel> list = this.plans;
        List<TProProductDisplayModel> list2 = this.products;
        String str2 = this.termsUrl;
        return "TProMultiPlanDisplayModel(activeSubscription=" + z11 + ", freeTrialDays=" + i11 + ", freeTrialTitle=" + str + ", freeTrialEligible=" + z12 + ", plans=" + list + ", products=" + list2 + ", termsUrl=" + str2 + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.activeSubscription ? 1 : 0);
        parcel.writeInt(this.freeTrialDays);
        parcel.writeString(this.freeTrialTitle);
        parcel.writeInt(this.freeTrialEligible ? 1 : 0);
        List<TProPlanDisplayModel> list = this.plans;
        parcel.writeInt(list.size());
        for (TProPlanDisplayModel writeToParcel : list) {
            writeToParcel.writeToParcel(parcel, i11);
        }
        List<TProProductDisplayModel> list2 = this.products;
        parcel.writeInt(list2.size());
        for (TProProductDisplayModel writeToParcel2 : list2) {
            writeToParcel2.writeToParcel(parcel, i11);
        }
        parcel.writeString(this.termsUrl);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TProMultiPlanDisplayModel(boolean r6, int r7, java.lang.String r8, boolean r9, java.util.List r10, java.util.List r11, java.lang.String r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r5 = this;
            r14 = r13 & 1
            if (r14 == 0) goto L_0x000a
            kotlin.jvm.internal.BooleanCompanionObject r6 = kotlin.jvm.internal.BooleanCompanionObject.INSTANCE
            boolean r6 = com.talabat.talabatcommon.extentions.BooleanKt.orFalse((kotlin.jvm.internal.BooleanCompanionObject) r6)
        L_0x000a:
            r14 = r13 & 2
            if (r14 == 0) goto L_0x0014
            kotlin.jvm.internal.IntCompanionObject r7 = kotlin.jvm.internal.IntCompanionObject.INSTANCE
            int r7 = com.talabat.talabatcommon.extentions.IntKt.orZero((kotlin.jvm.internal.IntCompanionObject) r7)
        L_0x0014:
            r14 = r7
            r7 = r13 & 4
            if (r7 == 0) goto L_0x001f
            kotlin.jvm.internal.StringCompanionObject r7 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r8 = com.talabat.talabatcommon.extentions.StringUtils.empty(r7)
        L_0x001f:
            r0 = r8
            r7 = r13 & 8
            if (r7 == 0) goto L_0x002a
            kotlin.jvm.internal.BooleanCompanionObject r7 = kotlin.jvm.internal.BooleanCompanionObject.INSTANCE
            boolean r9 = com.talabat.talabatcommon.extentions.BooleanKt.orFalse((kotlin.jvm.internal.BooleanCompanionObject) r7)
        L_0x002a:
            r1 = r9
            r7 = r13 & 16
            if (r7 == 0) goto L_0x0033
            java.util.List r10 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x0033:
            r2 = r10
            r7 = r13 & 32
            if (r7 == 0) goto L_0x003c
            java.util.List r11 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x003c:
            r3 = r11
            r7 = r13 & 64
            if (r7 == 0) goto L_0x0047
            kotlin.jvm.internal.StringCompanionObject r7 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r12 = com.talabat.talabatcommon.extentions.StringUtils.empty(r7)
        L_0x0047:
            r4 = r12
            r7 = r5
            r8 = r6
            r9 = r14
            r10 = r0
            r11 = r1
            r12 = r2
            r13 = r3
            r14 = r4
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tpro.presentation.model.TProMultiPlanDisplayModel.<init>(boolean, int, java.lang.String, boolean, java.util.List, java.util.List, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
