package com.talabat.feature.helpcenter.presentation;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/talabat/feature/helpcenter/presentation/CancellationPolicyItemDisplayModel;", "Landroid/os/Parcelable;", "icon", "", "title", "description", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "getIcon", "getTitle", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_feature_helpcenter_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Parcelize
public final class CancellationPolicyItemDisplayModel implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<CancellationPolicyItemDisplayModel> CREATOR = new Creator();
    @NotNull
    private final String description;
    @NotNull
    private final String icon;
    @NotNull
    private final String title;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CancellationPolicyItemDisplayModel> {
        @NotNull
        public final CancellationPolicyItemDisplayModel createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CancellationPolicyItemDisplayModel(parcel.readString(), parcel.readString(), parcel.readString());
        }

        @NotNull
        public final CancellationPolicyItemDisplayModel[] newArray(int i11) {
            return new CancellationPolicyItemDisplayModel[i11];
        }
    }

    public CancellationPolicyItemDisplayModel(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "icon");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "description");
        this.icon = str;
        this.title = str2;
        this.description = str3;
    }

    public static /* synthetic */ CancellationPolicyItemDisplayModel copy$default(CancellationPolicyItemDisplayModel cancellationPolicyItemDisplayModel, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = cancellationPolicyItemDisplayModel.icon;
        }
        if ((i11 & 2) != 0) {
            str2 = cancellationPolicyItemDisplayModel.title;
        }
        if ((i11 & 4) != 0) {
            str3 = cancellationPolicyItemDisplayModel.description;
        }
        return cancellationPolicyItemDisplayModel.copy(str, str2, str3);
    }

    @NotNull
    public final String component1() {
        return this.icon;
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    @NotNull
    public final String component3() {
        return this.description;
    }

    @NotNull
    public final CancellationPolicyItemDisplayModel copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "icon");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "description");
        return new CancellationPolicyItemDisplayModel(str, str2, str3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CancellationPolicyItemDisplayModel)) {
            return false;
        }
        CancellationPolicyItemDisplayModel cancellationPolicyItemDisplayModel = (CancellationPolicyItemDisplayModel) obj;
        return Intrinsics.areEqual((Object) this.icon, (Object) cancellationPolicyItemDisplayModel.icon) && Intrinsics.areEqual((Object) this.title, (Object) cancellationPolicyItemDisplayModel.title) && Intrinsics.areEqual((Object) this.description, (Object) cancellationPolicyItemDisplayModel.description);
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getIcon() {
        return this.icon;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((this.icon.hashCode() * 31) + this.title.hashCode()) * 31) + this.description.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.icon;
        String str2 = this.title;
        String str3 = this.description;
        return "CancellationPolicyItemDisplayModel(icon=" + str + ", title=" + str2 + ", description=" + str3 + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.icon);
        parcel.writeString(this.title);
        parcel.writeString(this.description);
    }
}
