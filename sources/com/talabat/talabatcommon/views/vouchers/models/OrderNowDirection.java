package com.talabat.talabatcommon.views.vouchers.models;

import android.os.Parcel;
import android.os.Parcelable;
import datamodels.Restaurant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/models/OrderNowDirection;", "Landroid/os/Parcelable;", "()V", "MultipleRestaurants", "OneRestaurant", "Undefined", "Lcom/talabat/talabatcommon/views/vouchers/models/OrderNowDirection$OneRestaurant;", "Lcom/talabat/talabatcommon/views/vouchers/models/OrderNowDirection$MultipleRestaurants;", "Lcom/talabat/talabatcommon/views/vouchers/models/OrderNowDirection$Undefined;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class OrderNowDirection implements Parcelable {

    @Parcelize
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/models/OrderNowDirection$MultipleRestaurants;", "Lcom/talabat/talabatcommon/views/vouchers/models/OrderNowDirection;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class MultipleRestaurants extends OrderNowDirection {
        @NotNull
        public static final Parcelable.Creator<MultipleRestaurants> CREATOR = new Creator();
        @NotNull
        public static final MultipleRestaurants INSTANCE = new MultipleRestaurants();

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<MultipleRestaurants> {
            @NotNull
            public final MultipleRestaurants createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return MultipleRestaurants.INSTANCE;
            }

            @NotNull
            public final MultipleRestaurants[] newArray(int i11) {
                return new MultipleRestaurants[i11];
            }
        }

        private MultipleRestaurants() {
            super((DefaultConstructorMarker) null);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(@NotNull Parcel parcel, int i11) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(1);
        }
    }

    @Parcelize
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/models/OrderNowDirection$OneRestaurant;", "Lcom/talabat/talabatcommon/views/vouchers/models/OrderNowDirection;", "restaurant", "Ldatamodels/Restaurant;", "(Ldatamodels/Restaurant;)V", "getRestaurant", "()Ldatamodels/Restaurant;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class OneRestaurant extends OrderNowDirection {
        @NotNull
        public static final Parcelable.Creator<OneRestaurant> CREATOR = new Creator();
        @NotNull
        private final Restaurant restaurant;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<OneRestaurant> {
            @NotNull
            public final OneRestaurant createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new OneRestaurant((Restaurant) parcel.readParcelable(OneRestaurant.class.getClassLoader()));
            }

            @NotNull
            public final OneRestaurant[] newArray(int i11) {
                return new OneRestaurant[i11];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OneRestaurant(@NotNull Restaurant restaurant2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(restaurant2, "restaurant");
            this.restaurant = restaurant2;
        }

        public int describeContents() {
            return 0;
        }

        @NotNull
        public final Restaurant getRestaurant() {
            return this.restaurant;
        }

        public void writeToParcel(@NotNull Parcel parcel, int i11) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeParcelable(this.restaurant, i11);
        }
    }

    @Parcelize
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/models/OrderNowDirection$Undefined;", "Lcom/talabat/talabatcommon/views/vouchers/models/OrderNowDirection;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Undefined extends OrderNowDirection {
        @NotNull
        public static final Parcelable.Creator<Undefined> CREATOR = new Creator();
        @NotNull
        public static final Undefined INSTANCE = new Undefined();

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<Undefined> {
            @NotNull
            public final Undefined createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return Undefined.INSTANCE;
            }

            @NotNull
            public final Undefined[] newArray(int i11) {
                return new Undefined[i11];
            }
        }

        private Undefined() {
            super((DefaultConstructorMarker) null);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(@NotNull Parcel parcel, int i11) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(1);
        }
    }

    private OrderNowDirection() {
    }

    public /* synthetic */ OrderNowDirection(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
