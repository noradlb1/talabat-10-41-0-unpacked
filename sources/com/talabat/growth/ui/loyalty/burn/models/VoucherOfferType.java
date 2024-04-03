package com.talabat.growth.ui.loyalty.burn.models;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.talabat.growth.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\f\r\u000e\u000f\u0010\u0011B\u0013\b\u0004\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH&R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0001\u0006\u0012\u0013\u0014\u0015\u0016\u0017¨\u0006\u0018"}, d2 = {"Lcom/talabat/growth/ui/loyalty/burn/models/VoucherOfferType;", "Landroid/os/Parcelable;", "icon", "", "(Ljava/lang/Integer;)V", "getIcon", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLabel", "", "context", "Landroid/content/Context;", "Charity", "Discount", "FreeDelivery", "Lifestyle", "PercentageDiscount", "Unknown", "Lcom/talabat/growth/ui/loyalty/burn/models/VoucherOfferType$Unknown;", "Lcom/talabat/growth/ui/loyalty/burn/models/VoucherOfferType$FreeDelivery;", "Lcom/talabat/growth/ui/loyalty/burn/models/VoucherOfferType$Discount;", "Lcom/talabat/growth/ui/loyalty/burn/models/VoucherOfferType$PercentageDiscount;", "Lcom/talabat/growth/ui/loyalty/burn/models/VoucherOfferType$Lifestyle;", "Lcom/talabat/growth/ui/loyalty/burn/models/VoucherOfferType$Charity;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class VoucherOfferType implements Parcelable {
    @Nullable
    private final Integer icon;

    @Parcelize
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004HÖ\u0001¨\u0006\u000e"}, d2 = {"Lcom/talabat/growth/ui/loyalty/burn/models/VoucherOfferType$Charity;", "Lcom/talabat/growth/ui/loyalty/burn/models/VoucherOfferType;", "()V", "describeContents", "", "getLabel", "", "context", "Landroid/content/Context;", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Charity extends VoucherOfferType {
        @NotNull
        public static final Parcelable.Creator<Charity> CREATOR = new Creator();

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<Charity> {
            @NotNull
            public final Charity createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return new Charity();
            }

            @NotNull
            public final Charity[] newArray(int i11) {
                return new Charity[i11];
            }
        }

        public Charity() {
            super(Integer.valueOf(R.drawable.ic_charity), (DefaultConstructorMarker) null);
        }

        public int describeContents() {
            return 0;
        }

        @NotNull
        public String getLabel(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            String string = context.getString(com.talabat.localization.R.string.offer_type_charity);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.ta…tring.offer_type_charity)");
            return string;
        }

        public void writeToParcel(@NotNull Parcel parcel, int i11) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(1);
        }
    }

    @Parcelize
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0019\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/talabat/growth/ui/loyalty/burn/models/VoucherOfferType$Discount;", "Lcom/talabat/growth/ui/loyalty/burn/models/VoucherOfferType;", "discount", "", "(Ljava/lang/String;)V", "getDiscount", "()Ljava/lang/String;", "describeContents", "", "getLabel", "context", "Landroid/content/Context;", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Discount extends VoucherOfferType {
        @NotNull
        public static final Parcelable.Creator<Discount> CREATOR = new Creator();
        @NotNull
        private final String discount;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<Discount> {
            @NotNull
            public final Discount createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Discount(parcel.readString());
            }

            @NotNull
            public final Discount[] newArray(int i11) {
                return new Discount[i11];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Discount(@NotNull String str) {
            super(Integer.valueOf(R.drawable.ic_discount), (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "discount");
            this.discount = str;
        }

        public int describeContents() {
            return 0;
        }

        @NotNull
        public final String getDiscount() {
            return this.discount;
        }

        @NotNull
        public String getLabel(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            String string = context.getString(com.talabat.localization.R.string.offer_type_discount, new Object[]{this.discount});
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.ta…_type_discount, discount)");
            return string;
        }

        public void writeToParcel(@NotNull Parcel parcel, int i11) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.discount);
        }
    }

    @Parcelize
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004HÖ\u0001¨\u0006\u000e"}, d2 = {"Lcom/talabat/growth/ui/loyalty/burn/models/VoucherOfferType$FreeDelivery;", "Lcom/talabat/growth/ui/loyalty/burn/models/VoucherOfferType;", "()V", "describeContents", "", "getLabel", "", "context", "Landroid/content/Context;", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class FreeDelivery extends VoucherOfferType {
        @NotNull
        public static final Parcelable.Creator<FreeDelivery> CREATOR = new Creator();

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<FreeDelivery> {
            @NotNull
            public final FreeDelivery createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return new FreeDelivery();
            }

            @NotNull
            public final FreeDelivery[] newArray(int i11) {
                return new FreeDelivery[i11];
            }
        }

        public FreeDelivery() {
            super(Integer.valueOf(R.drawable.ic_free_delivery), (DefaultConstructorMarker) null);
        }

        public int describeContents() {
            return 0;
        }

        @NotNull
        public String getLabel(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            String string = context.getString(com.talabat.localization.R.string.offer_type_free_delivery);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.ta…offer_type_free_delivery)");
            return string;
        }

        public void writeToParcel(@NotNull Parcel parcel, int i11) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(1);
        }
    }

    @Parcelize
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004HÖ\u0001¨\u0006\u000e"}, d2 = {"Lcom/talabat/growth/ui/loyalty/burn/models/VoucherOfferType$Lifestyle;", "Lcom/talabat/growth/ui/loyalty/burn/models/VoucherOfferType;", "()V", "describeContents", "", "getLabel", "", "context", "Landroid/content/Context;", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Lifestyle extends VoucherOfferType {
        @NotNull
        public static final Parcelable.Creator<Lifestyle> CREATOR = new Creator();

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<Lifestyle> {
            @NotNull
            public final Lifestyle createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return new Lifestyle();
            }

            @NotNull
            public final Lifestyle[] newArray(int i11) {
                return new Lifestyle[i11];
            }
        }

        public Lifestyle() {
            super(Integer.valueOf(R.drawable.ic_lifestyle), (DefaultConstructorMarker) null);
        }

        public int describeContents() {
            return 0;
        }

        @NotNull
        public String getLabel(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            String string = context.getString(com.talabat.localization.R.string.offer_type_lifestyle);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.ta…ing.offer_type_lifestyle)");
            return string;
        }

        public void writeToParcel(@NotNull Parcel parcel, int i11) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(1);
        }
    }

    @Parcelize
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0019\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/talabat/growth/ui/loyalty/burn/models/VoucherOfferType$PercentageDiscount;", "Lcom/talabat/growth/ui/loyalty/burn/models/VoucherOfferType;", "discount", "", "(Ljava/lang/String;)V", "getDiscount", "()Ljava/lang/String;", "describeContents", "", "getLabel", "context", "Landroid/content/Context;", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class PercentageDiscount extends VoucherOfferType {
        @NotNull
        public static final Parcelable.Creator<PercentageDiscount> CREATOR = new Creator();
        @NotNull
        private final String discount;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<PercentageDiscount> {
            @NotNull
            public final PercentageDiscount createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new PercentageDiscount(parcel.readString());
            }

            @NotNull
            public final PercentageDiscount[] newArray(int i11) {
                return new PercentageDiscount[i11];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PercentageDiscount(@NotNull String str) {
            super(Integer.valueOf(R.drawable.ic_discount), (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "discount");
            this.discount = str;
        }

        public int describeContents() {
            return 0;
        }

        @NotNull
        public final String getDiscount() {
            return this.discount;
        }

        @NotNull
        public String getLabel(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            String string = context.getString(com.talabat.localization.R.string.offer_type_percentage_discount, new Object[]{this.discount});
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(\n     …       discount\n        )");
            return string;
        }

        public void writeToParcel(@NotNull Parcel parcel, int i11) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.discount);
        }
    }

    @Parcelize
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004HÖ\u0001¨\u0006\u000e"}, d2 = {"Lcom/talabat/growth/ui/loyalty/burn/models/VoucherOfferType$Unknown;", "Lcom/talabat/growth/ui/loyalty/burn/models/VoucherOfferType;", "()V", "describeContents", "", "getLabel", "", "context", "Landroid/content/Context;", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Unknown extends VoucherOfferType {
        @NotNull
        public static final Parcelable.Creator<Unknown> CREATOR = new Creator();

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<Unknown> {
            @NotNull
            public final Unknown createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return new Unknown();
            }

            @NotNull
            public final Unknown[] newArray(int i11) {
                return new Unknown[i11];
            }
        }

        public Unknown() {
            super(0, (DefaultConstructorMarker) null);
        }

        public int describeContents() {
            return 0;
        }

        @Nullable
        public String getLabel(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return null;
        }

        public void writeToParcel(@NotNull Parcel parcel, int i11) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(1);
        }
    }

    private VoucherOfferType(Integer num) {
        this.icon = num;
    }

    public /* synthetic */ VoucherOfferType(Integer num, DefaultConstructorMarker defaultConstructorMarker) {
        this(num);
    }

    @Nullable
    public final Integer getIcon() {
        return this.icon;
    }

    @Nullable
    public abstract String getLabel(@NotNull Context context);

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VoucherOfferType(Integer num, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : num, (DefaultConstructorMarker) null);
    }
}
