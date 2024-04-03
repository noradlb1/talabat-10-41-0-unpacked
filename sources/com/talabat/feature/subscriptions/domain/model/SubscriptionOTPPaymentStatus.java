package com.talabat.feature.subscriptions.domain.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.talabat.observability.squads.nfv.ObservableAttributesNames;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0017HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\""}, d2 = {"Lcom/talabat/feature/subscriptions/domain/model/SubscriptionOTPPaymentStatus;", "Landroid/os/Parcelable;", "isSuccessful", "", "imageUrl", "", "title", "description", "buttonTitle", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getButtonTitle", "()Ljava/lang/String;", "getDescription", "getImageUrl", "()Z", "getTitle", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Parcelize
public final class SubscriptionOTPPaymentStatus implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<SubscriptionOTPPaymentStatus> CREATOR = new Creator();
    @NotNull
    private final String buttonTitle;
    @NotNull
    private final String description;
    @NotNull
    private final String imageUrl;
    private final boolean isSuccessful;
    @NotNull
    private final String title;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SubscriptionOTPPaymentStatus> {
        @NotNull
        public final SubscriptionOTPPaymentStatus createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SubscriptionOTPPaymentStatus(parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @NotNull
        public final SubscriptionOTPPaymentStatus[] newArray(int i11) {
            return new SubscriptionOTPPaymentStatus[i11];
        }
    }

    public SubscriptionOTPPaymentStatus(boolean z11, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, ObservableAttributesNames.IMAGE_URL_V2);
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "description");
        Intrinsics.checkNotNullParameter(str4, "buttonTitle");
        this.isSuccessful = z11;
        this.imageUrl = str;
        this.title = str2;
        this.description = str3;
        this.buttonTitle = str4;
    }

    public static /* synthetic */ SubscriptionOTPPaymentStatus copy$default(SubscriptionOTPPaymentStatus subscriptionOTPPaymentStatus, boolean z11, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = subscriptionOTPPaymentStatus.isSuccessful;
        }
        if ((i11 & 2) != 0) {
            str = subscriptionOTPPaymentStatus.imageUrl;
        }
        String str5 = str;
        if ((i11 & 4) != 0) {
            str2 = subscriptionOTPPaymentStatus.title;
        }
        String str6 = str2;
        if ((i11 & 8) != 0) {
            str3 = subscriptionOTPPaymentStatus.description;
        }
        String str7 = str3;
        if ((i11 & 16) != 0) {
            str4 = subscriptionOTPPaymentStatus.buttonTitle;
        }
        return subscriptionOTPPaymentStatus.copy(z11, str5, str6, str7, str4);
    }

    public final boolean component1() {
        return this.isSuccessful;
    }

    @NotNull
    public final String component2() {
        return this.imageUrl;
    }

    @NotNull
    public final String component3() {
        return this.title;
    }

    @NotNull
    public final String component4() {
        return this.description;
    }

    @NotNull
    public final String component5() {
        return this.buttonTitle;
    }

    @NotNull
    public final SubscriptionOTPPaymentStatus copy(boolean z11, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, ObservableAttributesNames.IMAGE_URL_V2);
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "description");
        Intrinsics.checkNotNullParameter(str4, "buttonTitle");
        return new SubscriptionOTPPaymentStatus(z11, str, str2, str3, str4);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionOTPPaymentStatus)) {
            return false;
        }
        SubscriptionOTPPaymentStatus subscriptionOTPPaymentStatus = (SubscriptionOTPPaymentStatus) obj;
        return this.isSuccessful == subscriptionOTPPaymentStatus.isSuccessful && Intrinsics.areEqual((Object) this.imageUrl, (Object) subscriptionOTPPaymentStatus.imageUrl) && Intrinsics.areEqual((Object) this.title, (Object) subscriptionOTPPaymentStatus.title) && Intrinsics.areEqual((Object) this.description, (Object) subscriptionOTPPaymentStatus.description) && Intrinsics.areEqual((Object) this.buttonTitle, (Object) subscriptionOTPPaymentStatus.buttonTitle);
    }

    @NotNull
    public final String getButtonTitle() {
        return this.buttonTitle;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        boolean z11 = this.isSuccessful;
        if (z11) {
            z11 = true;
        }
        return ((((((((z11 ? 1 : 0) * true) + this.imageUrl.hashCode()) * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31) + this.buttonTitle.hashCode();
    }

    public final boolean isSuccessful() {
        return this.isSuccessful;
    }

    @NotNull
    public String toString() {
        boolean z11 = this.isSuccessful;
        String str = this.imageUrl;
        String str2 = this.title;
        String str3 = this.description;
        String str4 = this.buttonTitle;
        return "SubscriptionOTPPaymentStatus(isSuccessful=" + z11 + ", imageUrl=" + str + ", title=" + str2 + ", description=" + str3 + ", buttonTitle=" + str4 + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.isSuccessful ? 1 : 0);
        parcel.writeString(this.imageUrl);
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeString(this.buttonTitle);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SubscriptionOTPPaymentStatus(boolean z11, String str, String str2, String str3, String str4, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(z11, (i11 & 2) != 0 ? "" : str, str2, str3, str4);
    }
}
