package com.talabat.feature.darkstores.domain.navigator;

import com.talabat.feature.darkstores.domain.tracking.ScreenTrackingProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/feature/darkstores/domain/navigator/DarkstoresInternalNavigationTarget;", "", "()V", "BannerCampaignSearchResult", "Cart", "ProductDetails", "VendorLanding", "Lcom/talabat/feature/darkstores/domain/navigator/DarkstoresInternalNavigationTarget$ProductDetails;", "Lcom/talabat/feature/darkstores/domain/navigator/DarkstoresInternalNavigationTarget$Cart;", "Lcom/talabat/feature/darkstores/domain/navigator/DarkstoresInternalNavigationTarget$VendorLanding;", "Lcom/talabat/feature/darkstores/domain/navigator/DarkstoresInternalNavigationTarget$BannerCampaignSearchResult;", "com_talabat_feature_darkstores_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class DarkstoresInternalNavigationTarget {

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/talabat/feature/darkstores/domain/navigator/DarkstoresInternalNavigationTarget$BannerCampaignSearchResult;", "Lcom/talabat/feature/darkstores/domain/navigator/DarkstoresInternalNavigationTarget;", "tag", "", "eventOrigin", "Lcom/talabat/feature/darkstores/domain/tracking/ScreenTrackingProvider$EventOrigin;", "(Ljava/lang/String;Lcom/talabat/feature/darkstores/domain/tracking/ScreenTrackingProvider$EventOrigin;)V", "getEventOrigin", "()Lcom/talabat/feature/darkstores/domain/tracking/ScreenTrackingProvider$EventOrigin;", "getTag", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_feature_darkstores_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class BannerCampaignSearchResult extends DarkstoresInternalNavigationTarget {
        @NotNull
        private final ScreenTrackingProvider.EventOrigin eventOrigin;
        @NotNull
        private final String tag;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BannerCampaignSearchResult(@NotNull String str, @NotNull ScreenTrackingProvider.EventOrigin eventOrigin2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "tag");
            Intrinsics.checkNotNullParameter(eventOrigin2, "eventOrigin");
            this.tag = str;
            this.eventOrigin = eventOrigin2;
        }

        public static /* synthetic */ BannerCampaignSearchResult copy$default(BannerCampaignSearchResult bannerCampaignSearchResult, String str, ScreenTrackingProvider.EventOrigin eventOrigin2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = bannerCampaignSearchResult.tag;
            }
            if ((i11 & 2) != 0) {
                eventOrigin2 = bannerCampaignSearchResult.eventOrigin;
            }
            return bannerCampaignSearchResult.copy(str, eventOrigin2);
        }

        @NotNull
        public final String component1() {
            return this.tag;
        }

        @NotNull
        public final ScreenTrackingProvider.EventOrigin component2() {
            return this.eventOrigin;
        }

        @NotNull
        public final BannerCampaignSearchResult copy(@NotNull String str, @NotNull ScreenTrackingProvider.EventOrigin eventOrigin2) {
            Intrinsics.checkNotNullParameter(str, "tag");
            Intrinsics.checkNotNullParameter(eventOrigin2, "eventOrigin");
            return new BannerCampaignSearchResult(str, eventOrigin2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BannerCampaignSearchResult)) {
                return false;
            }
            BannerCampaignSearchResult bannerCampaignSearchResult = (BannerCampaignSearchResult) obj;
            return Intrinsics.areEqual((Object) this.tag, (Object) bannerCampaignSearchResult.tag) && this.eventOrigin == bannerCampaignSearchResult.eventOrigin;
        }

        @NotNull
        public final ScreenTrackingProvider.EventOrigin getEventOrigin() {
            return this.eventOrigin;
        }

        @NotNull
        public final String getTag() {
            return this.tag;
        }

        public int hashCode() {
            return (this.tag.hashCode() * 31) + this.eventOrigin.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.tag;
            ScreenTrackingProvider.EventOrigin eventOrigin2 = this.eventOrigin;
            return "BannerCampaignSearchResult(tag=" + str + ", eventOrigin=" + eventOrigin2 + ")";
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/feature/darkstores/domain/navigator/DarkstoresInternalNavigationTarget$Cart;", "Lcom/talabat/feature/darkstores/domain/navigator/DarkstoresInternalNavigationTarget;", "()V", "com_talabat_feature_darkstores_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Cart extends DarkstoresInternalNavigationTarget {
        @NotNull
        public static final Cart INSTANCE = new Cart();

        private Cart() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/talabat/feature/darkstores/domain/navigator/DarkstoresInternalNavigationTarget$ProductDetails;", "Lcom/talabat/feature/darkstores/domain/navigator/DarkstoresInternalNavigationTarget;", "productId", "", "shouldTrackProductOpenedEvent", "", "eventOrigin", "swimlaneRequestId", "searchRequestId", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEventOrigin", "()Ljava/lang/String;", "getProductId", "getSearchRequestId", "getShouldTrackProductOpenedEvent", "()Z", "getSwimlaneRequestId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "com_talabat_feature_darkstores_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ProductDetails extends DarkstoresInternalNavigationTarget {
        @NotNull
        private final String eventOrigin;
        @NotNull
        private final String productId;
        @NotNull
        private final String searchRequestId;
        private final boolean shouldTrackProductOpenedEvent;
        @NotNull
        private final String swimlaneRequestId;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ProductDetails(@NotNull String str, boolean z11, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "productId");
            Intrinsics.checkNotNullParameter(str2, "eventOrigin");
            Intrinsics.checkNotNullParameter(str3, "swimlaneRequestId");
            Intrinsics.checkNotNullParameter(str4, "searchRequestId");
            this.productId = str;
            this.shouldTrackProductOpenedEvent = z11;
            this.eventOrigin = str2;
            this.swimlaneRequestId = str3;
            this.searchRequestId = str4;
        }

        public static /* synthetic */ ProductDetails copy$default(ProductDetails productDetails, String str, boolean z11, String str2, String str3, String str4, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = productDetails.productId;
            }
            if ((i11 & 2) != 0) {
                z11 = productDetails.shouldTrackProductOpenedEvent;
            }
            boolean z12 = z11;
            if ((i11 & 4) != 0) {
                str2 = productDetails.eventOrigin;
            }
            String str5 = str2;
            if ((i11 & 8) != 0) {
                str3 = productDetails.swimlaneRequestId;
            }
            String str6 = str3;
            if ((i11 & 16) != 0) {
                str4 = productDetails.searchRequestId;
            }
            return productDetails.copy(str, z12, str5, str6, str4);
        }

        @NotNull
        public final String component1() {
            return this.productId;
        }

        public final boolean component2() {
            return this.shouldTrackProductOpenedEvent;
        }

        @NotNull
        public final String component3() {
            return this.eventOrigin;
        }

        @NotNull
        public final String component4() {
            return this.swimlaneRequestId;
        }

        @NotNull
        public final String component5() {
            return this.searchRequestId;
        }

        @NotNull
        public final ProductDetails copy(@NotNull String str, boolean z11, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
            Intrinsics.checkNotNullParameter(str, "productId");
            Intrinsics.checkNotNullParameter(str2, "eventOrigin");
            Intrinsics.checkNotNullParameter(str3, "swimlaneRequestId");
            Intrinsics.checkNotNullParameter(str4, "searchRequestId");
            return new ProductDetails(str, z11, str2, str3, str4);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ProductDetails)) {
                return false;
            }
            ProductDetails productDetails = (ProductDetails) obj;
            return Intrinsics.areEqual((Object) this.productId, (Object) productDetails.productId) && this.shouldTrackProductOpenedEvent == productDetails.shouldTrackProductOpenedEvent && Intrinsics.areEqual((Object) this.eventOrigin, (Object) productDetails.eventOrigin) && Intrinsics.areEqual((Object) this.swimlaneRequestId, (Object) productDetails.swimlaneRequestId) && Intrinsics.areEqual((Object) this.searchRequestId, (Object) productDetails.searchRequestId);
        }

        @NotNull
        public final String getEventOrigin() {
            return this.eventOrigin;
        }

        @NotNull
        public final String getProductId() {
            return this.productId;
        }

        @NotNull
        public final String getSearchRequestId() {
            return this.searchRequestId;
        }

        public final boolean getShouldTrackProductOpenedEvent() {
            return this.shouldTrackProductOpenedEvent;
        }

        @NotNull
        public final String getSwimlaneRequestId() {
            return this.swimlaneRequestId;
        }

        public int hashCode() {
            int hashCode = this.productId.hashCode() * 31;
            boolean z11 = this.shouldTrackProductOpenedEvent;
            if (z11) {
                z11 = true;
            }
            return ((((((hashCode + (z11 ? 1 : 0)) * 31) + this.eventOrigin.hashCode()) * 31) + this.swimlaneRequestId.hashCode()) * 31) + this.searchRequestId.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.productId;
            boolean z11 = this.shouldTrackProductOpenedEvent;
            String str2 = this.eventOrigin;
            String str3 = this.swimlaneRequestId;
            String str4 = this.searchRequestId;
            return "ProductDetails(productId=" + str + ", shouldTrackProductOpenedEvent=" + z11 + ", eventOrigin=" + str2 + ", swimlaneRequestId=" + str3 + ", searchRequestId=" + str4 + ")";
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/feature/darkstores/domain/navigator/DarkstoresInternalNavigationTarget$VendorLanding;", "Lcom/talabat/feature/darkstores/domain/navigator/DarkstoresInternalNavigationTarget;", "()V", "com_talabat_feature_darkstores_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class VendorLanding extends DarkstoresInternalNavigationTarget {
        @NotNull
        public static final VendorLanding INSTANCE = new VendorLanding();

        private VendorLanding() {
            super((DefaultConstructorMarker) null);
        }
    }

    private DarkstoresInternalNavigationTarget() {
    }

    public /* synthetic */ DarkstoresInternalNavigationTarget(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
