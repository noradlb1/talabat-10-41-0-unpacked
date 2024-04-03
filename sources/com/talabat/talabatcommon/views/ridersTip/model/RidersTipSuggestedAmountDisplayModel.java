package com.talabat.talabatcommon.views.ridersTip.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\tHÖ\u0001J\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u000f"}, d2 = {"Lcom/talabat/talabatcommon/views/ridersTip/model/RidersTipSuggestedAmountDisplayModel;", "Landroid/os/Parcelable;", "amount", "", "(F)V", "getAmount", "()F", "setAmount", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Parcelize
public final class RidersTipSuggestedAmountDisplayModel implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<RidersTipSuggestedAmountDisplayModel> CREATOR = new Creator();
    private float amount;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<RidersTipSuggestedAmountDisplayModel> {
        @NotNull
        public final RidersTipSuggestedAmountDisplayModel createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new RidersTipSuggestedAmountDisplayModel(parcel.readFloat());
        }

        @NotNull
        public final RidersTipSuggestedAmountDisplayModel[] newArray(int i11) {
            return new RidersTipSuggestedAmountDisplayModel[i11];
        }
    }

    public RidersTipSuggestedAmountDisplayModel() {
        this(0.0f, 1, (DefaultConstructorMarker) null);
    }

    public RidersTipSuggestedAmountDisplayModel(float f11) {
        this.amount = f11;
    }

    public int describeContents() {
        return 0;
    }

    public final float getAmount() {
        return this.amount;
    }

    public final void setAmount(float f11) {
        this.amount = f11;
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeFloat(this.amount);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RidersTipSuggestedAmountDisplayModel(float f11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? 0.0f : f11);
    }
}
