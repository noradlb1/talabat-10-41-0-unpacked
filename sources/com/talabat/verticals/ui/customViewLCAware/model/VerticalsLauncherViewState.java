package com.talabat.verticals.ui.customViewLCAware.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.talabat.verticals.helper.customMvvmView.MvvmCustomViewState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/talabat/verticals/ui/customViewLCAware/model/VerticalsLauncherViewState;", "Lcom/talabat/verticals/helper/customMvvmView/MvvmCustomViewState;", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "setValue", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_NewArchi_VerticalsSquad_VerticalsSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Parcelize
public final class VerticalsLauncherViewState implements MvvmCustomViewState {
    @NotNull
    public static final Parcelable.Creator<VerticalsLauncherViewState> CREATOR = new Creator();
    @NotNull
    private String value;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<VerticalsLauncherViewState> {
        @NotNull
        public final VerticalsLauncherViewState createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new VerticalsLauncherViewState(parcel.readString());
        }

        @NotNull
        public final VerticalsLauncherViewState[] newArray(int i11) {
            return new VerticalsLauncherViewState[i11];
        }
    }

    public VerticalsLauncherViewState() {
        this((String) null, 1, (DefaultConstructorMarker) null);
    }

    public VerticalsLauncherViewState(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.value = str;
    }

    public static /* synthetic */ VerticalsLauncherViewState copy$default(VerticalsLauncherViewState verticalsLauncherViewState, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = verticalsLauncherViewState.value;
        }
        return verticalsLauncherViewState.copy(str);
    }

    @NotNull
    public final String component1() {
        return this.value;
    }

    @NotNull
    public final VerticalsLauncherViewState copy(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        return new VerticalsLauncherViewState(str);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof VerticalsLauncherViewState) && Intrinsics.areEqual((Object) this.value, (Object) ((VerticalsLauncherViewState) obj).value);
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public final void setValue(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.value = str;
    }

    @NotNull
    public String toString() {
        String str = this.value;
        return "VerticalsLauncherViewState(value=" + str + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.value);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VerticalsLauncherViewState(String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? "" : str);
    }
}
