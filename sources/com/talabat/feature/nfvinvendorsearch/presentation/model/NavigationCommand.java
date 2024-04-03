package com.talabat.feature.nfvinvendorsearch.presentation.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0003\u0004\u0005\u0006\u0007\bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0006\t\n\u000b\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/talabat/feature/nfvinvendorsearch/presentation/model/NavigationCommand;", "Landroid/os/Parcelable;", "()V", "BannerCampaignProductListing", "Cart", "Checkout", "ProductDetails", "VendorLanding", "VoucherProductListing", "Lcom/talabat/feature/nfvinvendorsearch/presentation/model/NavigationCommand$ProductDetails;", "Lcom/talabat/feature/nfvinvendorsearch/presentation/model/NavigationCommand$Cart;", "Lcom/talabat/feature/nfvinvendorsearch/presentation/model/NavigationCommand$VendorLanding;", "Lcom/talabat/feature/nfvinvendorsearch/presentation/model/NavigationCommand$BannerCampaignProductListing;", "Lcom/talabat/feature/nfvinvendorsearch/presentation/model/NavigationCommand$Checkout;", "Lcom/talabat/feature/nfvinvendorsearch/presentation/model/NavigationCommand$VoucherProductListing;", "com_talabat_feature_qcommerce-flutter_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class NavigationCommand implements Parcelable {

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/talabat/feature/nfvinvendorsearch/presentation/model/NavigationCommand$BannerCampaignProductListing;", "Lcom/talabat/feature/nfvinvendorsearch/presentation/model/NavigationCommand;", "tag", "", "(Ljava/lang/String;)V", "getTag", "()Ljava/lang/String;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_feature_qcommerce-flutter_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Parcelize
    public static final class BannerCampaignProductListing extends NavigationCommand {
        @NotNull
        public static final Parcelable.Creator<BannerCampaignProductListing> CREATOR = new Creator();
        @NotNull
        private final String tag;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<BannerCampaignProductListing> {
            @NotNull
            public final BannerCampaignProductListing createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new BannerCampaignProductListing(parcel.readString());
            }

            @NotNull
            public final BannerCampaignProductListing[] newArray(int i11) {
                return new BannerCampaignProductListing[i11];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BannerCampaignProductListing(@NotNull String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "tag");
            this.tag = str;
        }

        public static /* synthetic */ BannerCampaignProductListing copy$default(BannerCampaignProductListing bannerCampaignProductListing, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = bannerCampaignProductListing.tag;
            }
            return bannerCampaignProductListing.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.tag;
        }

        @NotNull
        public final BannerCampaignProductListing copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "tag");
            return new BannerCampaignProductListing(str);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof BannerCampaignProductListing) && Intrinsics.areEqual((Object) this.tag, (Object) ((BannerCampaignProductListing) obj).tag);
        }

        @NotNull
        public final String getTag() {
            return this.tag;
        }

        public int hashCode() {
            return this.tag.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.tag;
            return "BannerCampaignProductListing(tag=" + str + ")";
        }

        public void writeToParcel(@NotNull Parcel parcel, int i11) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.tag);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lcom/talabat/feature/nfvinvendorsearch/presentation/model/NavigationCommand$Cart;", "Lcom/talabat/feature/nfvinvendorsearch/presentation/model/NavigationCommand;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_feature_qcommerce-flutter_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Parcelize
    public static final class Cart extends NavigationCommand {
        @NotNull
        public static final Parcelable.Creator<Cart> CREATOR = new Creator();
        @NotNull
        public static final Cart INSTANCE = new Cart();

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<Cart> {
            @NotNull
            public final Cart createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return Cart.INSTANCE;
            }

            @NotNull
            public final Cart[] newArray(int i11) {
                return new Cart[i11];
            }
        }

        private Cart() {
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

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/talabat/feature/nfvinvendorsearch/presentation/model/NavigationCommand$Checkout;", "Lcom/talabat/feature/nfvinvendorsearch/presentation/model/NavigationCommand;", "specialRequest", "", "(Ljava/lang/String;)V", "getSpecialRequest", "()Ljava/lang/String;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_feature_qcommerce-flutter_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Parcelize
    public static final class Checkout extends NavigationCommand {
        @NotNull
        public static final Parcelable.Creator<Checkout> CREATOR = new Creator();
        @NotNull
        private final String specialRequest;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<Checkout> {
            @NotNull
            public final Checkout createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Checkout(parcel.readString());
            }

            @NotNull
            public final Checkout[] newArray(int i11) {
                return new Checkout[i11];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Checkout(@NotNull String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "specialRequest");
            this.specialRequest = str;
        }

        public static /* synthetic */ Checkout copy$default(Checkout checkout, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = checkout.specialRequest;
            }
            return checkout.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.specialRequest;
        }

        @NotNull
        public final Checkout copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "specialRequest");
            return new Checkout(str);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Checkout) && Intrinsics.areEqual((Object) this.specialRequest, (Object) ((Checkout) obj).specialRequest);
        }

        @NotNull
        public final String getSpecialRequest() {
            return this.specialRequest;
        }

        public int hashCode() {
            return this.specialRequest.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.specialRequest;
            return "Checkout(specialRequest=" + str + ")";
        }

        public void writeToParcel(@NotNull Parcel parcel, int i11) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.specialRequest);
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/talabat/feature/nfvinvendorsearch/presentation/model/NavigationCommand$ProductDetails;", "Lcom/talabat/feature/nfvinvendorsearch/presentation/model/NavigationCommand;", "productInfo", "Lcom/talabat/feature/nfvinvendorsearch/presentation/model/ProductInfo;", "(Lcom/talabat/feature/nfvinvendorsearch/presentation/model/ProductInfo;)V", "getProductInfo", "()Lcom/talabat/feature/nfvinvendorsearch/presentation/model/ProductInfo;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_feature_qcommerce-flutter_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Parcelize
    public static final class ProductDetails extends NavigationCommand {
        @NotNull
        public static final Parcelable.Creator<ProductDetails> CREATOR = new Creator();
        @NotNull
        private final ProductInfo productInfo;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<ProductDetails> {
            @NotNull
            public final ProductDetails createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new ProductDetails(ProductInfo.CREATOR.createFromParcel(parcel));
            }

            @NotNull
            public final ProductDetails[] newArray(int i11) {
                return new ProductDetails[i11];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ProductDetails(@NotNull ProductInfo productInfo2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(productInfo2, "productInfo");
            this.productInfo = productInfo2;
        }

        public static /* synthetic */ ProductDetails copy$default(ProductDetails productDetails, ProductInfo productInfo2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                productInfo2 = productDetails.productInfo;
            }
            return productDetails.copy(productInfo2);
        }

        @NotNull
        public final ProductInfo component1() {
            return this.productInfo;
        }

        @NotNull
        public final ProductDetails copy(@NotNull ProductInfo productInfo2) {
            Intrinsics.checkNotNullParameter(productInfo2, "productInfo");
            return new ProductDetails(productInfo2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ProductDetails) && Intrinsics.areEqual((Object) this.productInfo, (Object) ((ProductDetails) obj).productInfo);
        }

        @NotNull
        public final ProductInfo getProductInfo() {
            return this.productInfo;
        }

        public int hashCode() {
            return this.productInfo.hashCode();
        }

        @NotNull
        public String toString() {
            ProductInfo productInfo2 = this.productInfo;
            return "ProductDetails(productInfo=" + productInfo2 + ")";
        }

        public void writeToParcel(@NotNull Parcel parcel, int i11) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            this.productInfo.writeToParcel(parcel, i11);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lcom/talabat/feature/nfvinvendorsearch/presentation/model/NavigationCommand$VendorLanding;", "Lcom/talabat/feature/nfvinvendorsearch/presentation/model/NavigationCommand;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_feature_qcommerce-flutter_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Parcelize
    public static final class VendorLanding extends NavigationCommand {
        @NotNull
        public static final Parcelable.Creator<VendorLanding> CREATOR = new Creator();
        @NotNull
        public static final VendorLanding INSTANCE = new VendorLanding();

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<VendorLanding> {
            @NotNull
            public final VendorLanding createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return VendorLanding.INSTANCE;
            }

            @NotNull
            public final VendorLanding[] newArray(int i11) {
                return new VendorLanding[i11];
            }
        }

        private VendorLanding() {
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

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/talabat/feature/nfvinvendorsearch/presentation/model/NavigationCommand$VoucherProductListing;", "Lcom/talabat/feature/nfvinvendorsearch/presentation/model/NavigationCommand;", "voucherDetails", "Lcom/talabat/feature/nfvinvendorsearch/presentation/model/VoucherDetails;", "(Lcom/talabat/feature/nfvinvendorsearch/presentation/model/VoucherDetails;)V", "getVoucherDetails", "()Lcom/talabat/feature/nfvinvendorsearch/presentation/model/VoucherDetails;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_feature_qcommerce-flutter_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Parcelize
    public static final class VoucherProductListing extends NavigationCommand {
        @NotNull
        public static final Parcelable.Creator<VoucherProductListing> CREATOR = new Creator();
        @NotNull
        private final VoucherDetails voucherDetails;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<VoucherProductListing> {
            @NotNull
            public final VoucherProductListing createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new VoucherProductListing(VoucherDetails.CREATOR.createFromParcel(parcel));
            }

            @NotNull
            public final VoucherProductListing[] newArray(int i11) {
                return new VoucherProductListing[i11];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public VoucherProductListing(@NotNull VoucherDetails voucherDetails2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(voucherDetails2, "voucherDetails");
            this.voucherDetails = voucherDetails2;
        }

        public static /* synthetic */ VoucherProductListing copy$default(VoucherProductListing voucherProductListing, VoucherDetails voucherDetails2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                voucherDetails2 = voucherProductListing.voucherDetails;
            }
            return voucherProductListing.copy(voucherDetails2);
        }

        @NotNull
        public final VoucherDetails component1() {
            return this.voucherDetails;
        }

        @NotNull
        public final VoucherProductListing copy(@NotNull VoucherDetails voucherDetails2) {
            Intrinsics.checkNotNullParameter(voucherDetails2, "voucherDetails");
            return new VoucherProductListing(voucherDetails2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof VoucherProductListing) && Intrinsics.areEqual((Object) this.voucherDetails, (Object) ((VoucherProductListing) obj).voucherDetails);
        }

        @NotNull
        public final VoucherDetails getVoucherDetails() {
            return this.voucherDetails;
        }

        public int hashCode() {
            return this.voucherDetails.hashCode();
        }

        @NotNull
        public String toString() {
            VoucherDetails voucherDetails2 = this.voucherDetails;
            return "VoucherProductListing(voucherDetails=" + voucherDetails2 + ")";
        }

        public void writeToParcel(@NotNull Parcel parcel, int i11) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            this.voucherDetails.writeToParcel(parcel, i11);
        }
    }

    private NavigationCommand() {
    }

    public /* synthetic */ NavigationCommand(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
