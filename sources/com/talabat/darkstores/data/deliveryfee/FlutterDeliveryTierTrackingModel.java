package com.talabat.darkstores.data.deliveryfee;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.talabat.darkstores.feature.tracking.EventOriginType;
import com.talabat.feature.darkstores.domain.tracking.ScreenTrackingProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\u0019\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006&"}, d2 = {"Lcom/talabat/darkstores/data/deliveryfee/FlutterDeliveryTierTrackingModel;", "Landroid/os/Parcelable;", "eventOrigin", "Lcom/talabat/darkstores/feature/tracking/EventOriginType;", "screenType", "Lcom/talabat/feature/darkstores/domain/tracking/ScreenTrackingProvider$ScreenType;", "screenName", "Lcom/talabat/feature/darkstores/domain/tracking/ScreenTrackingProvider$ScreenName;", "storeTrackingInfo", "Landroid/os/Bundle;", "(Lcom/talabat/darkstores/feature/tracking/EventOriginType;Lcom/talabat/feature/darkstores/domain/tracking/ScreenTrackingProvider$ScreenType;Lcom/talabat/feature/darkstores/domain/tracking/ScreenTrackingProvider$ScreenName;Landroid/os/Bundle;)V", "getEventOrigin", "()Lcom/talabat/darkstores/feature/tracking/EventOriginType;", "getScreenName", "()Lcom/talabat/feature/darkstores/domain/tracking/ScreenTrackingProvider$ScreenName;", "getScreenType", "()Lcom/talabat/feature/darkstores/domain/tracking/ScreenTrackingProvider$ScreenType;", "getStoreTrackingInfo", "()Landroid/os/Bundle;", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Parcelize
public final class FlutterDeliveryTierTrackingModel implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<FlutterDeliveryTierTrackingModel> CREATOR = new Creator();
    @NotNull
    private final EventOriginType eventOrigin;
    @NotNull
    private final ScreenTrackingProvider.ScreenName screenName;
    @NotNull
    private final ScreenTrackingProvider.ScreenType screenType;
    @NotNull
    private final Bundle storeTrackingInfo;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<FlutterDeliveryTierTrackingModel> {
        @NotNull
        public final FlutterDeliveryTierTrackingModel createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new FlutterDeliveryTierTrackingModel(EventOriginType.valueOf(parcel.readString()), ScreenTrackingProvider.ScreenType.valueOf(parcel.readString()), ScreenTrackingProvider.ScreenName.valueOf(parcel.readString()), parcel.readBundle());
        }

        @NotNull
        public final FlutterDeliveryTierTrackingModel[] newArray(int i11) {
            return new FlutterDeliveryTierTrackingModel[i11];
        }
    }

    public FlutterDeliveryTierTrackingModel(@NotNull EventOriginType eventOriginType, @NotNull ScreenTrackingProvider.ScreenType screenType2, @NotNull ScreenTrackingProvider.ScreenName screenName2, @NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(eventOriginType, "eventOrigin");
        Intrinsics.checkNotNullParameter(screenType2, "screenType");
        Intrinsics.checkNotNullParameter(screenName2, "screenName");
        Intrinsics.checkNotNullParameter(bundle, "storeTrackingInfo");
        this.eventOrigin = eventOriginType;
        this.screenType = screenType2;
        this.screenName = screenName2;
        this.storeTrackingInfo = bundle;
    }

    public static /* synthetic */ FlutterDeliveryTierTrackingModel copy$default(FlutterDeliveryTierTrackingModel flutterDeliveryTierTrackingModel, EventOriginType eventOriginType, ScreenTrackingProvider.ScreenType screenType2, ScreenTrackingProvider.ScreenName screenName2, Bundle bundle, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            eventOriginType = flutterDeliveryTierTrackingModel.eventOrigin;
        }
        if ((i11 & 2) != 0) {
            screenType2 = flutterDeliveryTierTrackingModel.screenType;
        }
        if ((i11 & 4) != 0) {
            screenName2 = flutterDeliveryTierTrackingModel.screenName;
        }
        if ((i11 & 8) != 0) {
            bundle = flutterDeliveryTierTrackingModel.storeTrackingInfo;
        }
        return flutterDeliveryTierTrackingModel.copy(eventOriginType, screenType2, screenName2, bundle);
    }

    @NotNull
    public final EventOriginType component1() {
        return this.eventOrigin;
    }

    @NotNull
    public final ScreenTrackingProvider.ScreenType component2() {
        return this.screenType;
    }

    @NotNull
    public final ScreenTrackingProvider.ScreenName component3() {
        return this.screenName;
    }

    @NotNull
    public final Bundle component4() {
        return this.storeTrackingInfo;
    }

    @NotNull
    public final FlutterDeliveryTierTrackingModel copy(@NotNull EventOriginType eventOriginType, @NotNull ScreenTrackingProvider.ScreenType screenType2, @NotNull ScreenTrackingProvider.ScreenName screenName2, @NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(eventOriginType, "eventOrigin");
        Intrinsics.checkNotNullParameter(screenType2, "screenType");
        Intrinsics.checkNotNullParameter(screenName2, "screenName");
        Intrinsics.checkNotNullParameter(bundle, "storeTrackingInfo");
        return new FlutterDeliveryTierTrackingModel(eventOriginType, screenType2, screenName2, bundle);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FlutterDeliveryTierTrackingModel)) {
            return false;
        }
        FlutterDeliveryTierTrackingModel flutterDeliveryTierTrackingModel = (FlutterDeliveryTierTrackingModel) obj;
        return this.eventOrigin == flutterDeliveryTierTrackingModel.eventOrigin && this.screenType == flutterDeliveryTierTrackingModel.screenType && this.screenName == flutterDeliveryTierTrackingModel.screenName && Intrinsics.areEqual((Object) this.storeTrackingInfo, (Object) flutterDeliveryTierTrackingModel.storeTrackingInfo);
    }

    @NotNull
    public final EventOriginType getEventOrigin() {
        return this.eventOrigin;
    }

    @NotNull
    public final ScreenTrackingProvider.ScreenName getScreenName() {
        return this.screenName;
    }

    @NotNull
    public final ScreenTrackingProvider.ScreenType getScreenType() {
        return this.screenType;
    }

    @NotNull
    public final Bundle getStoreTrackingInfo() {
        return this.storeTrackingInfo;
    }

    public int hashCode() {
        return (((((this.eventOrigin.hashCode() * 31) + this.screenType.hashCode()) * 31) + this.screenName.hashCode()) * 31) + this.storeTrackingInfo.hashCode();
    }

    @NotNull
    public String toString() {
        EventOriginType eventOriginType = this.eventOrigin;
        ScreenTrackingProvider.ScreenType screenType2 = this.screenType;
        ScreenTrackingProvider.ScreenName screenName2 = this.screenName;
        Bundle bundle = this.storeTrackingInfo;
        return "FlutterDeliveryTierTrackingModel(eventOrigin=" + eventOriginType + ", screenType=" + screenType2 + ", screenName=" + screenName2 + ", storeTrackingInfo=" + bundle + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.eventOrigin.name());
        parcel.writeString(this.screenType.name());
        parcel.writeString(this.screenName.name());
        parcel.writeBundle(this.storeTrackingInfo);
    }
}
