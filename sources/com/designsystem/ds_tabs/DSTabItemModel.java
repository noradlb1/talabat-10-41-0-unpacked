package com.designsystem.ds_tabs;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/designsystem/ds_tabs/DSTabItemModel;", "Landroid/os/Parcelable;", "id", "", "title", "", "menuDescription", "(ILjava/lang/String;Ljava/lang/String;)V", "getId", "()I", "getMenuDescription", "()Ljava/lang/String;", "getTitle", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Parcelize
public final class DSTabItemModel implements Parcelable {
    public static final int $stable = 8;
    @NotNull
    public static final Parcelable.Creator<DSTabItemModel> CREATOR = new Creator();

    /* renamed from: id  reason: collision with root package name */
    private final int f33048id;
    @Nullable
    private final String menuDescription;
    @NotNull
    private final String title;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DSTabItemModel> {
        @NotNull
        public final DSTabItemModel createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DSTabItemModel(parcel.readInt(), parcel.readString(), parcel.readString());
        }

        @NotNull
        public final DSTabItemModel[] newArray(int i11) {
            return new DSTabItemModel[i11];
        }
    }

    public DSTabItemModel(int i11, @NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.f33048id = i11;
        this.title = str;
        this.menuDescription = str2;
    }

    public static /* synthetic */ DSTabItemModel copy$default(DSTabItemModel dSTabItemModel, int i11, String str, String str2, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = dSTabItemModel.f33048id;
        }
        if ((i12 & 2) != 0) {
            str = dSTabItemModel.title;
        }
        if ((i12 & 4) != 0) {
            str2 = dSTabItemModel.menuDescription;
        }
        return dSTabItemModel.copy(i11, str, str2);
    }

    public final int component1() {
        return this.f33048id;
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    @Nullable
    public final String component3() {
        return this.menuDescription;
    }

    @NotNull
    public final DSTabItemModel copy(int i11, @NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "title");
        return new DSTabItemModel(i11, str, str2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DSTabItemModel)) {
            return false;
        }
        DSTabItemModel dSTabItemModel = (DSTabItemModel) obj;
        return this.f33048id == dSTabItemModel.f33048id && Intrinsics.areEqual((Object) this.title, (Object) dSTabItemModel.title) && Intrinsics.areEqual((Object) this.menuDescription, (Object) dSTabItemModel.menuDescription);
    }

    public final int getId() {
        return this.f33048id;
    }

    @Nullable
    public final String getMenuDescription() {
        return this.menuDescription;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int hashCode = ((this.f33048id * 31) + this.title.hashCode()) * 31;
        String str = this.menuDescription;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    @NotNull
    public String toString() {
        return "DSTabItemModel(id=" + this.f33048id + ", title=" + this.title + ", menuDescription=" + this.menuDescription + ')';
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.f33048id);
        parcel.writeString(this.title);
        parcel.writeString(this.menuDescription);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSTabItemModel(int i11, String str, String str2, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, str, (i12 & 4) != 0 ? null : str2);
    }
}
