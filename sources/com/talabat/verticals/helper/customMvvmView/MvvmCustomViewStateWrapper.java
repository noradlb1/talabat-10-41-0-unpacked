package com.talabat.verticals.helper.customMvvmView;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\u000e\u001a\u00020\u0001HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0012HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/talabat/verticals/helper/customMvvmView/MvvmCustomViewStateWrapper;", "Landroid/os/Parcelable;", "def", "state", "Lcom/talabat/verticals/helper/customMvvmView/MvvmCustomViewState;", "(Landroid/os/Parcelable;Lcom/talabat/verticals/helper/customMvvmView/MvvmCustomViewState;)V", "getDef", "()Landroid/os/Parcelable;", "setDef", "(Landroid/os/Parcelable;)V", "getState", "()Lcom/talabat/verticals/helper/customMvvmView/MvvmCustomViewState;", "setState", "(Lcom/talabat/verticals/helper/customMvvmView/MvvmCustomViewState;)V", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_NewArchi_VerticalsSquad_VerticalsSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Parcelize
public final class MvvmCustomViewStateWrapper implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<MvvmCustomViewStateWrapper> CREATOR = new Creator();
    @NotNull
    private Parcelable def;
    @NotNull
    private MvvmCustomViewState state;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<MvvmCustomViewStateWrapper> {
        @NotNull
        public final MvvmCustomViewStateWrapper createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            Class<MvvmCustomViewStateWrapper> cls = MvvmCustomViewStateWrapper.class;
            return new MvvmCustomViewStateWrapper(parcel.readParcelable(cls.getClassLoader()), (MvvmCustomViewState) parcel.readParcelable(cls.getClassLoader()));
        }

        @NotNull
        public final MvvmCustomViewStateWrapper[] newArray(int i11) {
            return new MvvmCustomViewStateWrapper[i11];
        }
    }

    public MvvmCustomViewStateWrapper(@NotNull Parcelable parcelable, @NotNull MvvmCustomViewState mvvmCustomViewState) {
        Intrinsics.checkNotNullParameter(parcelable, "def");
        Intrinsics.checkNotNullParameter(mvvmCustomViewState, "state");
        this.def = parcelable;
        this.state = mvvmCustomViewState;
    }

    public static /* synthetic */ MvvmCustomViewStateWrapper copy$default(MvvmCustomViewStateWrapper mvvmCustomViewStateWrapper, Parcelable parcelable, MvvmCustomViewState mvvmCustomViewState, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            parcelable = mvvmCustomViewStateWrapper.def;
        }
        if ((i11 & 2) != 0) {
            mvvmCustomViewState = mvvmCustomViewStateWrapper.state;
        }
        return mvvmCustomViewStateWrapper.copy(parcelable, mvvmCustomViewState);
    }

    @NotNull
    public final Parcelable component1() {
        return this.def;
    }

    @NotNull
    public final MvvmCustomViewState component2() {
        return this.state;
    }

    @NotNull
    public final MvvmCustomViewStateWrapper copy(@NotNull Parcelable parcelable, @NotNull MvvmCustomViewState mvvmCustomViewState) {
        Intrinsics.checkNotNullParameter(parcelable, "def");
        Intrinsics.checkNotNullParameter(mvvmCustomViewState, "state");
        return new MvvmCustomViewStateWrapper(parcelable, mvvmCustomViewState);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MvvmCustomViewStateWrapper)) {
            return false;
        }
        MvvmCustomViewStateWrapper mvvmCustomViewStateWrapper = (MvvmCustomViewStateWrapper) obj;
        return Intrinsics.areEqual((Object) this.def, (Object) mvvmCustomViewStateWrapper.def) && Intrinsics.areEqual((Object) this.state, (Object) mvvmCustomViewStateWrapper.state);
    }

    @NotNull
    public final Parcelable getDef() {
        return this.def;
    }

    @NotNull
    public final MvvmCustomViewState getState() {
        return this.state;
    }

    public int hashCode() {
        return (this.def.hashCode() * 31) + this.state.hashCode();
    }

    public final void setDef(@NotNull Parcelable parcelable) {
        Intrinsics.checkNotNullParameter(parcelable, "<set-?>");
        this.def = parcelable;
    }

    public final void setState(@NotNull MvvmCustomViewState mvvmCustomViewState) {
        Intrinsics.checkNotNullParameter(mvvmCustomViewState, "<set-?>");
        this.state = mvvmCustomViewState;
    }

    @NotNull
    public String toString() {
        Parcelable parcelable = this.def;
        MvvmCustomViewState mvvmCustomViewState = this.state;
        return "MvvmCustomViewStateWrapper(def=" + parcelable + ", state=" + mvvmCustomViewState + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeParcelable(this.def, i11);
        parcel.writeParcelable(this.state, i11);
    }
}
