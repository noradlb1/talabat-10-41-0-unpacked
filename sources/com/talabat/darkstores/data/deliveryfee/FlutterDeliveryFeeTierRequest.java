package com.talabat.darkstores.data.deliveryfee;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J9\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0016HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\""}, d2 = {"Lcom/talabat/darkstores/data/deliveryfee/FlutterDeliveryFeeTierRequest;", "Landroid/os/Parcelable;", "title", "", "tiers", "", "Lcom/talabat/darkstores/data/deliveryfee/FlutterGroceryDeliveryFeeTier;", "info", "ctaTag", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getCtaTag", "()Ljava/lang/String;", "getInfo", "getTiers", "()Ljava/util/List;", "getTitle", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Parcelize
public final class FlutterDeliveryFeeTierRequest implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<FlutterDeliveryFeeTierRequest> CREATOR = new Creator();
    @NotNull
    private final String ctaTag;
    @Nullable
    private final String info;
    @NotNull
    private final List<FlutterGroceryDeliveryFeeTier> tiers;
    @NotNull
    private final String title;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<FlutterDeliveryFeeTierRequest> {
        @NotNull
        public final FlutterDeliveryFeeTierRequest createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i11 = 0; i11 != readInt; i11++) {
                arrayList.add(FlutterGroceryDeliveryFeeTier.CREATOR.createFromParcel(parcel));
            }
            return new FlutterDeliveryFeeTierRequest(readString, arrayList, parcel.readString(), parcel.readString());
        }

        @NotNull
        public final FlutterDeliveryFeeTierRequest[] newArray(int i11) {
            return new FlutterDeliveryFeeTierRequest[i11];
        }
    }

    public FlutterDeliveryFeeTierRequest(@NotNull String str, @NotNull List<FlutterGroceryDeliveryFeeTier> list, @Nullable String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(list, BasketDeliveryFeeTiersInfoKeys.KEY_BASKET_DELIVERY_FREE_TIERS);
        Intrinsics.checkNotNullParameter(str3, "ctaTag");
        this.title = str;
        this.tiers = list;
        this.info = str2;
        this.ctaTag = str3;
    }

    public static /* synthetic */ FlutterDeliveryFeeTierRequest copy$default(FlutterDeliveryFeeTierRequest flutterDeliveryFeeTierRequest, String str, List<FlutterGroceryDeliveryFeeTier> list, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = flutterDeliveryFeeTierRequest.title;
        }
        if ((i11 & 2) != 0) {
            list = flutterDeliveryFeeTierRequest.tiers;
        }
        if ((i11 & 4) != 0) {
            str2 = flutterDeliveryFeeTierRequest.info;
        }
        if ((i11 & 8) != 0) {
            str3 = flutterDeliveryFeeTierRequest.ctaTag;
        }
        return flutterDeliveryFeeTierRequest.copy(str, list, str2, str3);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final List<FlutterGroceryDeliveryFeeTier> component2() {
        return this.tiers;
    }

    @Nullable
    public final String component3() {
        return this.info;
    }

    @NotNull
    public final String component4() {
        return this.ctaTag;
    }

    @NotNull
    public final FlutterDeliveryFeeTierRequest copy(@NotNull String str, @NotNull List<FlutterGroceryDeliveryFeeTier> list, @Nullable String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(list, BasketDeliveryFeeTiersInfoKeys.KEY_BASKET_DELIVERY_FREE_TIERS);
        Intrinsics.checkNotNullParameter(str3, "ctaTag");
        return new FlutterDeliveryFeeTierRequest(str, list, str2, str3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FlutterDeliveryFeeTierRequest)) {
            return false;
        }
        FlutterDeliveryFeeTierRequest flutterDeliveryFeeTierRequest = (FlutterDeliveryFeeTierRequest) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) flutterDeliveryFeeTierRequest.title) && Intrinsics.areEqual((Object) this.tiers, (Object) flutterDeliveryFeeTierRequest.tiers) && Intrinsics.areEqual((Object) this.info, (Object) flutterDeliveryFeeTierRequest.info) && Intrinsics.areEqual((Object) this.ctaTag, (Object) flutterDeliveryFeeTierRequest.ctaTag);
    }

    @NotNull
    public final String getCtaTag() {
        return this.ctaTag;
    }

    @Nullable
    public final String getInfo() {
        return this.info;
    }

    @NotNull
    public final List<FlutterGroceryDeliveryFeeTier> getTiers() {
        return this.tiers;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int hashCode = ((this.title.hashCode() * 31) + this.tiers.hashCode()) * 31;
        String str = this.info;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.ctaTag.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.title;
        List<FlutterGroceryDeliveryFeeTier> list = this.tiers;
        String str2 = this.info;
        String str3 = this.ctaTag;
        return "FlutterDeliveryFeeTierRequest(title=" + str + ", tiers=" + list + ", info=" + str2 + ", ctaTag=" + str3 + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.title);
        List<FlutterGroceryDeliveryFeeTier> list = this.tiers;
        parcel.writeInt(list.size());
        for (FlutterGroceryDeliveryFeeTier writeToParcel : list) {
            writeToParcel.writeToParcel(parcel, i11);
        }
        parcel.writeString(this.info);
        parcel.writeString(this.ctaTag);
    }
}
