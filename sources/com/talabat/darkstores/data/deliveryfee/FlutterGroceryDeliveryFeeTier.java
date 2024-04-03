package com.talabat.darkstores.data.deliveryfee;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/talabat/darkstores/data/deliveryfee/FlutterGroceryDeliveryFeeTier;", "Landroid/os/Parcelable;", "deliveryFee", "", "description", "highlightColor", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDeliveryFee", "()Ljava/lang/String;", "getDescription", "getHighlightColor", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Parcelize
public final class FlutterGroceryDeliveryFeeTier implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<FlutterGroceryDeliveryFeeTier> CREATOR = new Creator();
    @NotNull
    private final String deliveryFee;
    @NotNull
    private final String description;
    @Nullable
    private final String highlightColor;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<FlutterGroceryDeliveryFeeTier> {
        @NotNull
        public final FlutterGroceryDeliveryFeeTier createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new FlutterGroceryDeliveryFeeTier(parcel.readString(), parcel.readString(), parcel.readString());
        }

        @NotNull
        public final FlutterGroceryDeliveryFeeTier[] newArray(int i11) {
            return new FlutterGroceryDeliveryFeeTier[i11];
        }
    }

    public FlutterGroceryDeliveryFeeTier(@NotNull String str, @NotNull String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "deliveryFee");
        Intrinsics.checkNotNullParameter(str2, "description");
        this.deliveryFee = str;
        this.description = str2;
        this.highlightColor = str3;
    }

    public static /* synthetic */ FlutterGroceryDeliveryFeeTier copy$default(FlutterGroceryDeliveryFeeTier flutterGroceryDeliveryFeeTier, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = flutterGroceryDeliveryFeeTier.deliveryFee;
        }
        if ((i11 & 2) != 0) {
            str2 = flutterGroceryDeliveryFeeTier.description;
        }
        if ((i11 & 4) != 0) {
            str3 = flutterGroceryDeliveryFeeTier.highlightColor;
        }
        return flutterGroceryDeliveryFeeTier.copy(str, str2, str3);
    }

    @NotNull
    public final String component1() {
        return this.deliveryFee;
    }

    @NotNull
    public final String component2() {
        return this.description;
    }

    @Nullable
    public final String component3() {
        return this.highlightColor;
    }

    @NotNull
    public final FlutterGroceryDeliveryFeeTier copy(@NotNull String str, @NotNull String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "deliveryFee");
        Intrinsics.checkNotNullParameter(str2, "description");
        return new FlutterGroceryDeliveryFeeTier(str, str2, str3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FlutterGroceryDeliveryFeeTier)) {
            return false;
        }
        FlutterGroceryDeliveryFeeTier flutterGroceryDeliveryFeeTier = (FlutterGroceryDeliveryFeeTier) obj;
        return Intrinsics.areEqual((Object) this.deliveryFee, (Object) flutterGroceryDeliveryFeeTier.deliveryFee) && Intrinsics.areEqual((Object) this.description, (Object) flutterGroceryDeliveryFeeTier.description) && Intrinsics.areEqual((Object) this.highlightColor, (Object) flutterGroceryDeliveryFeeTier.highlightColor);
    }

    @NotNull
    public final String getDeliveryFee() {
        return this.deliveryFee;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final String getHighlightColor() {
        return this.highlightColor;
    }

    public int hashCode() {
        int hashCode = ((this.deliveryFee.hashCode() * 31) + this.description.hashCode()) * 31;
        String str = this.highlightColor;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    @NotNull
    public String toString() {
        String str = this.deliveryFee;
        String str2 = this.description;
        String str3 = this.highlightColor;
        return "FlutterGroceryDeliveryFeeTier(deliveryFee=" + str + ", description=" + str2 + ", highlightColor=" + str3 + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.deliveryFee);
        parcel.writeString(this.description);
        parcel.writeString(this.highlightColor);
    }
}
