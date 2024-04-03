package com.talabat.feature.nfvinvendorsearch.presentation.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/talabat/feature/nfvinvendorsearch/presentation/model/VoucherDetails;", "Landroid/os/Parcelable;", "id", "", "name", "eventOrigin", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEventOrigin", "()Ljava/lang/String;", "getId", "getName", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_feature_qcommerce-flutter_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Parcelize
public final class VoucherDetails implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<VoucherDetails> CREATOR = new Creator();
    @NotNull
    private final String eventOrigin;
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f58627id;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f58628name;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<VoucherDetails> {
        @NotNull
        public final VoucherDetails createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new VoucherDetails(parcel.readString(), parcel.readString(), parcel.readString());
        }

        @NotNull
        public final VoucherDetails[] newArray(int i11) {
            return new VoucherDetails[i11];
        }
    }

    public VoucherDetails(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, "eventOrigin");
        this.f58627id = str;
        this.f58628name = str2;
        this.eventOrigin = str3;
    }

    public static /* synthetic */ VoucherDetails copy$default(VoucherDetails voucherDetails, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = voucherDetails.f58627id;
        }
        if ((i11 & 2) != 0) {
            str2 = voucherDetails.f58628name;
        }
        if ((i11 & 4) != 0) {
            str3 = voucherDetails.eventOrigin;
        }
        return voucherDetails.copy(str, str2, str3);
    }

    @NotNull
    public final String component1() {
        return this.f58627id;
    }

    @NotNull
    public final String component2() {
        return this.f58628name;
    }

    @NotNull
    public final String component3() {
        return this.eventOrigin;
    }

    @NotNull
    public final VoucherDetails copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, "eventOrigin");
        return new VoucherDetails(str, str2, str3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VoucherDetails)) {
            return false;
        }
        VoucherDetails voucherDetails = (VoucherDetails) obj;
        return Intrinsics.areEqual((Object) this.f58627id, (Object) voucherDetails.f58627id) && Intrinsics.areEqual((Object) this.f58628name, (Object) voucherDetails.f58628name) && Intrinsics.areEqual((Object) this.eventOrigin, (Object) voucherDetails.eventOrigin);
    }

    @NotNull
    public final String getEventOrigin() {
        return this.eventOrigin;
    }

    @NotNull
    public final String getId() {
        return this.f58627id;
    }

    @NotNull
    public final String getName() {
        return this.f58628name;
    }

    public int hashCode() {
        return (((this.f58627id.hashCode() * 31) + this.f58628name.hashCode()) * 31) + this.eventOrigin.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.f58627id;
        String str2 = this.f58628name;
        String str3 = this.eventOrigin;
        return "VoucherDetails(id=" + str + ", name=" + str2 + ", eventOrigin=" + str3 + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.f58627id);
        parcel.writeString(this.f58628name);
        parcel.writeString(this.eventOrigin);
    }
}
