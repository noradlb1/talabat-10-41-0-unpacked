package datamodels;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J2\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0012J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u001f"}, d2 = {"Ldatamodels/SubscriptionCollectionCallToAction;", "Landroid/os/Parcelable;", "type", "", "buttonText", "", "message", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getButtonText", "()Ljava/lang/String;", "getMessage", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Ldatamodels/SubscriptionCollectionCallToAction;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Parcelize
public final class SubscriptionCollectionCallToAction implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<SubscriptionCollectionCallToAction> CREATOR = new Creator();
    @Nullable
    private final String buttonText;
    @Nullable
    private final String message;
    @Nullable
    private final Integer type;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SubscriptionCollectionCallToAction> {
        @NotNull
        public final SubscriptionCollectionCallToAction createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SubscriptionCollectionCallToAction(parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString());
        }

        @NotNull
        public final SubscriptionCollectionCallToAction[] newArray(int i11) {
            return new SubscriptionCollectionCallToAction[i11];
        }
    }

    public SubscriptionCollectionCallToAction(@Nullable Integer num, @Nullable String str, @Nullable String str2) {
        this.type = num;
        this.buttonText = str;
        this.message = str2;
    }

    public static /* synthetic */ SubscriptionCollectionCallToAction copy$default(SubscriptionCollectionCallToAction subscriptionCollectionCallToAction, Integer num, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = subscriptionCollectionCallToAction.type;
        }
        if ((i11 & 2) != 0) {
            str = subscriptionCollectionCallToAction.buttonText;
        }
        if ((i11 & 4) != 0) {
            str2 = subscriptionCollectionCallToAction.message;
        }
        return subscriptionCollectionCallToAction.copy(num, str, str2);
    }

    @Nullable
    public final Integer component1() {
        return this.type;
    }

    @Nullable
    public final String component2() {
        return this.buttonText;
    }

    @Nullable
    public final String component3() {
        return this.message;
    }

    @NotNull
    public final SubscriptionCollectionCallToAction copy(@Nullable Integer num, @Nullable String str, @Nullable String str2) {
        return new SubscriptionCollectionCallToAction(num, str, str2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionCollectionCallToAction)) {
            return false;
        }
        SubscriptionCollectionCallToAction subscriptionCollectionCallToAction = (SubscriptionCollectionCallToAction) obj;
        return Intrinsics.areEqual((Object) this.type, (Object) subscriptionCollectionCallToAction.type) && Intrinsics.areEqual((Object) this.buttonText, (Object) subscriptionCollectionCallToAction.buttonText) && Intrinsics.areEqual((Object) this.message, (Object) subscriptionCollectionCallToAction.message);
    }

    @Nullable
    public final String getButtonText() {
        return this.buttonText;
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    public final Integer getType() {
        return this.type;
    }

    public int hashCode() {
        Integer num = this.type;
        int i11 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.buttonText;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.message;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        Integer num = this.type;
        String str = this.buttonText;
        String str2 = this.message;
        return "SubscriptionCollectionCallToAction(type=" + num + ", buttonText=" + str + ", message=" + str2 + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        int i12;
        Intrinsics.checkNotNullParameter(parcel, "out");
        Integer num = this.type;
        if (num == null) {
            i12 = 0;
        } else {
            parcel.writeInt(1);
            i12 = num.intValue();
        }
        parcel.writeInt(i12);
        parcel.writeString(this.buttonText);
        parcel.writeString(this.message);
    }
}
