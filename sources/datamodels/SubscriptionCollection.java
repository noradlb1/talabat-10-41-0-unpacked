package datamodels;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\nHÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u001cHÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001cHÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006("}, d2 = {"Ldatamodels/SubscriptionCollection;", "Landroid/os/Parcelable;", "productId", "", "foregroundImg", "text", "Ldatamodels/SubscriptionCollectionText;", "background", "Ldatamodels/SubscriptionCollectionBackground;", "callToAction", "Ldatamodels/SubscriptionCollectionCallToAction;", "(Ljava/lang/String;Ljava/lang/String;Ldatamodels/SubscriptionCollectionText;Ldatamodels/SubscriptionCollectionBackground;Ldatamodels/SubscriptionCollectionCallToAction;)V", "getBackground", "()Ldatamodels/SubscriptionCollectionBackground;", "getCallToAction", "()Ldatamodels/SubscriptionCollectionCallToAction;", "getForegroundImg", "()Ljava/lang/String;", "getProductId", "getText", "()Ldatamodels/SubscriptionCollectionText;", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Parcelize
public final class SubscriptionCollection implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<SubscriptionCollection> CREATOR = new Creator();
    @Nullable
    private final SubscriptionCollectionBackground background;
    @Nullable
    private final SubscriptionCollectionCallToAction callToAction;
    @Nullable
    private final String foregroundImg;
    @Nullable
    private final String productId;
    @Nullable
    private final SubscriptionCollectionText text;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SubscriptionCollection> {
        @NotNull
        public final SubscriptionCollection createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            SubscriptionCollectionCallToAction subscriptionCollectionCallToAction = null;
            SubscriptionCollectionText createFromParcel = parcel.readInt() == 0 ? null : SubscriptionCollectionText.CREATOR.createFromParcel(parcel);
            SubscriptionCollectionBackground createFromParcel2 = parcel.readInt() == 0 ? null : SubscriptionCollectionBackground.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                subscriptionCollectionCallToAction = SubscriptionCollectionCallToAction.CREATOR.createFromParcel(parcel);
            }
            return new SubscriptionCollection(readString, readString2, createFromParcel, createFromParcel2, subscriptionCollectionCallToAction);
        }

        @NotNull
        public final SubscriptionCollection[] newArray(int i11) {
            return new SubscriptionCollection[i11];
        }
    }

    public SubscriptionCollection(@Nullable String str, @Nullable String str2, @Nullable SubscriptionCollectionText subscriptionCollectionText, @Nullable SubscriptionCollectionBackground subscriptionCollectionBackground, @Nullable SubscriptionCollectionCallToAction subscriptionCollectionCallToAction) {
        this.productId = str;
        this.foregroundImg = str2;
        this.text = subscriptionCollectionText;
        this.background = subscriptionCollectionBackground;
        this.callToAction = subscriptionCollectionCallToAction;
    }

    public static /* synthetic */ SubscriptionCollection copy$default(SubscriptionCollection subscriptionCollection, String str, String str2, SubscriptionCollectionText subscriptionCollectionText, SubscriptionCollectionBackground subscriptionCollectionBackground, SubscriptionCollectionCallToAction subscriptionCollectionCallToAction, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = subscriptionCollection.productId;
        }
        if ((i11 & 2) != 0) {
            str2 = subscriptionCollection.foregroundImg;
        }
        String str3 = str2;
        if ((i11 & 4) != 0) {
            subscriptionCollectionText = subscriptionCollection.text;
        }
        SubscriptionCollectionText subscriptionCollectionText2 = subscriptionCollectionText;
        if ((i11 & 8) != 0) {
            subscriptionCollectionBackground = subscriptionCollection.background;
        }
        SubscriptionCollectionBackground subscriptionCollectionBackground2 = subscriptionCollectionBackground;
        if ((i11 & 16) != 0) {
            subscriptionCollectionCallToAction = subscriptionCollection.callToAction;
        }
        return subscriptionCollection.copy(str, str3, subscriptionCollectionText2, subscriptionCollectionBackground2, subscriptionCollectionCallToAction);
    }

    @Nullable
    public final String component1() {
        return this.productId;
    }

    @Nullable
    public final String component2() {
        return this.foregroundImg;
    }

    @Nullable
    public final SubscriptionCollectionText component3() {
        return this.text;
    }

    @Nullable
    public final SubscriptionCollectionBackground component4() {
        return this.background;
    }

    @Nullable
    public final SubscriptionCollectionCallToAction component5() {
        return this.callToAction;
    }

    @NotNull
    public final SubscriptionCollection copy(@Nullable String str, @Nullable String str2, @Nullable SubscriptionCollectionText subscriptionCollectionText, @Nullable SubscriptionCollectionBackground subscriptionCollectionBackground, @Nullable SubscriptionCollectionCallToAction subscriptionCollectionCallToAction) {
        return new SubscriptionCollection(str, str2, subscriptionCollectionText, subscriptionCollectionBackground, subscriptionCollectionCallToAction);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionCollection)) {
            return false;
        }
        SubscriptionCollection subscriptionCollection = (SubscriptionCollection) obj;
        return Intrinsics.areEqual((Object) this.productId, (Object) subscriptionCollection.productId) && Intrinsics.areEqual((Object) this.foregroundImg, (Object) subscriptionCollection.foregroundImg) && Intrinsics.areEqual((Object) this.text, (Object) subscriptionCollection.text) && Intrinsics.areEqual((Object) this.background, (Object) subscriptionCollection.background) && Intrinsics.areEqual((Object) this.callToAction, (Object) subscriptionCollection.callToAction);
    }

    @Nullable
    public final SubscriptionCollectionBackground getBackground() {
        return this.background;
    }

    @Nullable
    public final SubscriptionCollectionCallToAction getCallToAction() {
        return this.callToAction;
    }

    @Nullable
    public final String getForegroundImg() {
        return this.foregroundImg;
    }

    @Nullable
    public final String getProductId() {
        return this.productId;
    }

    @Nullable
    public final SubscriptionCollectionText getText() {
        return this.text;
    }

    public int hashCode() {
        String str = this.productId;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.foregroundImg;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        SubscriptionCollectionText subscriptionCollectionText = this.text;
        int hashCode3 = (hashCode2 + (subscriptionCollectionText == null ? 0 : subscriptionCollectionText.hashCode())) * 31;
        SubscriptionCollectionBackground subscriptionCollectionBackground = this.background;
        int hashCode4 = (hashCode3 + (subscriptionCollectionBackground == null ? 0 : subscriptionCollectionBackground.hashCode())) * 31;
        SubscriptionCollectionCallToAction subscriptionCollectionCallToAction = this.callToAction;
        if (subscriptionCollectionCallToAction != null) {
            i11 = subscriptionCollectionCallToAction.hashCode();
        }
        return hashCode4 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.productId;
        String str2 = this.foregroundImg;
        SubscriptionCollectionText subscriptionCollectionText = this.text;
        SubscriptionCollectionBackground subscriptionCollectionBackground = this.background;
        SubscriptionCollectionCallToAction subscriptionCollectionCallToAction = this.callToAction;
        return "SubscriptionCollection(productId=" + str + ", foregroundImg=" + str2 + ", text=" + subscriptionCollectionText + ", background=" + subscriptionCollectionBackground + ", callToAction=" + subscriptionCollectionCallToAction + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.productId);
        parcel.writeString(this.foregroundImg);
        SubscriptionCollectionText subscriptionCollectionText = this.text;
        if (subscriptionCollectionText == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            subscriptionCollectionText.writeToParcel(parcel, i11);
        }
        SubscriptionCollectionBackground subscriptionCollectionBackground = this.background;
        if (subscriptionCollectionBackground == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            subscriptionCollectionBackground.writeToParcel(parcel, i11);
        }
        SubscriptionCollectionCallToAction subscriptionCollectionCallToAction = this.callToAction;
        if (subscriptionCollectionCallToAction == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        subscriptionCollectionCallToAction.writeToParcel(parcel, i11);
    }
}
