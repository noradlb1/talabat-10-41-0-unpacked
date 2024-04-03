package com.talabat.feature.subscriptions.domain.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/model/UpgradePlanBenefit;", "Landroid/os/Parcelable;", "name", "", "description", "icon", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "getIcon", "getName", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Parcelize
public final class UpgradePlanBenefit implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<UpgradePlanBenefit> CREATOR = new Creator();
    @NotNull
    private final String description;
    @NotNull
    private final String icon;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f58983name;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<UpgradePlanBenefit> {
        @NotNull
        public final UpgradePlanBenefit createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new UpgradePlanBenefit(parcel.readString(), parcel.readString(), parcel.readString());
        }

        @NotNull
        public final UpgradePlanBenefit[] newArray(int i11) {
            return new UpgradePlanBenefit[i11];
        }
    }

    public UpgradePlanBenefit() {
        this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public UpgradePlanBenefit(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "description");
        Intrinsics.checkNotNullParameter(str3, "icon");
        this.f58983name = str;
        this.description = str2;
        this.icon = str3;
    }

    public static /* synthetic */ UpgradePlanBenefit copy$default(UpgradePlanBenefit upgradePlanBenefit, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = upgradePlanBenefit.f58983name;
        }
        if ((i11 & 2) != 0) {
            str2 = upgradePlanBenefit.description;
        }
        if ((i11 & 4) != 0) {
            str3 = upgradePlanBenefit.icon;
        }
        return upgradePlanBenefit.copy(str, str2, str3);
    }

    @NotNull
    public final String component1() {
        return this.f58983name;
    }

    @NotNull
    public final String component2() {
        return this.description;
    }

    @NotNull
    public final String component3() {
        return this.icon;
    }

    @NotNull
    public final UpgradePlanBenefit copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "description");
        Intrinsics.checkNotNullParameter(str3, "icon");
        return new UpgradePlanBenefit(str, str2, str3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UpgradePlanBenefit)) {
            return false;
        }
        UpgradePlanBenefit upgradePlanBenefit = (UpgradePlanBenefit) obj;
        return Intrinsics.areEqual((Object) this.f58983name, (Object) upgradePlanBenefit.f58983name) && Intrinsics.areEqual((Object) this.description, (Object) upgradePlanBenefit.description) && Intrinsics.areEqual((Object) this.icon, (Object) upgradePlanBenefit.icon);
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
    public final String getName() {
        return this.f58983name;
    }

    public int hashCode() {
        return (((this.f58983name.hashCode() * 31) + this.description.hashCode()) * 31) + this.icon.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.f58983name;
        String str2 = this.description;
        String str3 = this.icon;
        return "UpgradePlanBenefit(name=" + str + ", description=" + str2 + ", icon=" + str3 + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.f58983name);
        parcel.writeString(this.description);
        parcel.writeString(this.icon);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UpgradePlanBenefit(String str, String str2, String str3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? "" : str2, (i11 & 4) != 0 ? "" : str3);
    }
}
