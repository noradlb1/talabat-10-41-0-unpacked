package com.talabat.feature.tpro.presentation.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.talabat.talabatcommon.extentions.StringUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001f"}, d2 = {"Lcom/talabat/feature/tpro/presentation/model/TProProductDisplayModel;", "Landroid/os/Parcelable;", "title", "", "id", "description", "iconUri", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "getIconUri", "getId", "getTitle", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Parcelize
public final class TProProductDisplayModel implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<TProProductDisplayModel> CREATOR = new Creator();
    @NotNull
    private final String description;
    @NotNull
    private final String iconUri;
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f59352id;
    @NotNull
    private final String title;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<TProProductDisplayModel> {
        @NotNull
        public final TProProductDisplayModel createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new TProProductDisplayModel(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @NotNull
        public final TProProductDisplayModel[] newArray(int i11) {
            return new TProProductDisplayModel[i11];
        }
    }

    public TProProductDisplayModel() {
        this((String) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public TProProductDisplayModel(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "id");
        Intrinsics.checkNotNullParameter(str3, "description");
        Intrinsics.checkNotNullParameter(str4, "iconUri");
        this.title = str;
        this.f59352id = str2;
        this.description = str3;
        this.iconUri = str4;
    }

    public static /* synthetic */ TProProductDisplayModel copy$default(TProProductDisplayModel tProProductDisplayModel, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = tProProductDisplayModel.title;
        }
        if ((i11 & 2) != 0) {
            str2 = tProProductDisplayModel.f59352id;
        }
        if ((i11 & 4) != 0) {
            str3 = tProProductDisplayModel.description;
        }
        if ((i11 & 8) != 0) {
            str4 = tProProductDisplayModel.iconUri;
        }
        return tProProductDisplayModel.copy(str, str2, str3, str4);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final String component2() {
        return this.f59352id;
    }

    @NotNull
    public final String component3() {
        return this.description;
    }

    @NotNull
    public final String component4() {
        return this.iconUri;
    }

    @NotNull
    public final TProProductDisplayModel copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "id");
        Intrinsics.checkNotNullParameter(str3, "description");
        Intrinsics.checkNotNullParameter(str4, "iconUri");
        return new TProProductDisplayModel(str, str2, str3, str4);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TProProductDisplayModel)) {
            return false;
        }
        TProProductDisplayModel tProProductDisplayModel = (TProProductDisplayModel) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) tProProductDisplayModel.title) && Intrinsics.areEqual((Object) this.f59352id, (Object) tProProductDisplayModel.f59352id) && Intrinsics.areEqual((Object) this.description, (Object) tProProductDisplayModel.description) && Intrinsics.areEqual((Object) this.iconUri, (Object) tProProductDisplayModel.iconUri);
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getIconUri() {
        return this.iconUri;
    }

    @NotNull
    public final String getId() {
        return this.f59352id;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((((this.title.hashCode() * 31) + this.f59352id.hashCode()) * 31) + this.description.hashCode()) * 31) + this.iconUri.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.title;
        String str2 = this.f59352id;
        String str3 = this.description;
        String str4 = this.iconUri;
        return "TProProductDisplayModel(title=" + str + ", id=" + str2 + ", description=" + str3 + ", iconUri=" + str4 + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.title);
        parcel.writeString(this.f59352id);
        parcel.writeString(this.description);
        parcel.writeString(this.iconUri);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TProProductDisplayModel(String str, String str2, String str3, String str4, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? StringUtils.empty(StringCompanionObject.INSTANCE) : str, (i11 & 2) != 0 ? StringUtils.empty(StringCompanionObject.INSTANCE) : str2, (i11 & 4) != 0 ? StringUtils.empty(StringCompanionObject.INSTANCE) : str3, (i11 & 8) != 0 ? StringUtils.empty(StringCompanionObject.INSTANCE) : str4);
    }
}
