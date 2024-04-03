package com.talabat.feature.darkstorescart.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/talabat/feature/darkstorescart/data/model/Tracking;", "Landroid/os/Parcelable;", "nmrAdId", "", "(Ljava/lang/String;)V", "getNmrAdId", "()Ljava/lang/String;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_feature_darkstores-cart_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Parcelize
public final class Tracking implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<Tracking> CREATOR = new Creator();
    @Nullable
    private final String nmrAdId;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<Tracking> {
        @NotNull
        public final Tracking createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new Tracking(parcel.readString());
        }

        @NotNull
        public final Tracking[] newArray(int i11) {
            return new Tracking[i11];
        }
    }

    public Tracking() {
        this((String) null, 1, (DefaultConstructorMarker) null);
    }

    public Tracking(@Nullable @Json(name = "nmr_ad_id") String str) {
        this.nmrAdId = str;
    }

    public static /* synthetic */ Tracking copy$default(Tracking tracking2, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = tracking2.nmrAdId;
        }
        return tracking2.copy(str);
    }

    @Nullable
    public final String component1() {
        return this.nmrAdId;
    }

    @NotNull
    public final Tracking copy(@Nullable @Json(name = "nmr_ad_id") String str) {
        return new Tracking(str);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Tracking) && Intrinsics.areEqual((Object) this.nmrAdId, (Object) ((Tracking) obj).nmrAdId);
    }

    @Nullable
    public final String getNmrAdId() {
        return this.nmrAdId;
    }

    public int hashCode() {
        String str = this.nmrAdId;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.nmrAdId;
        return "Tracking(nmrAdId=" + str + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.nmrAdId);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Tracking(String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str);
    }
}
