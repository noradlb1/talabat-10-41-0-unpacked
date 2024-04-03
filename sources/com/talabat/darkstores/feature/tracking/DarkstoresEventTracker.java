package com.talabat.darkstores.feature.tracking;

import com.models.ProductTrackingModel;
import com.talabat.darkstores.feature.tracking.data.CategoryLoadedEvent;
import com.talabat.darkstores.feature.tracking.data.DarkstoreDetails;
import com.talabat.darkstores.feature.tracking.data.ProductDetails;
import com.talabat.darkstores.feature.tracking.data.ShopDetails;
import com.talabat.darkstores.feature.tracking.data.VendorVisitDetails;
import com.talabat.darkstores.model.Banner;
import com.talabat.talabatcommon.extentions.StringUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J:\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH&J \u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u000bH&J \u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u000bH&J0\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00032\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00192\u0006\u0010\u0013\u001a\u00020\u000bH&J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001cH&J0\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u00032\u0006\u0010 \u001a\u00020\u00032\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u0019H&J0\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0003H&J\u001a\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0003H&J\b\u0010-\u001a\u00020\u0005H&J(\u0010.\u001a\u00020\u00052\b\b\u0002\u0010/\u001a\u00020\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u00100\u001a\u00020\u0003H&J\"\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u00032\b\u00103\u001a\u0004\u0018\u00010\u00032\u0006\u00104\u001a\u000205H&J\b\u00106\u001a\u00020\u0005H&J\u001a\u00107\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u00032\b\u00103\u001a\u0004\u0018\u00010\u0003H&J0\u00108\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u00032\u0006\u00104\u001a\u0002052\b\u00103\u001a\u0004\u0018\u00010\u00032\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00030\u0019H&J<\u0010:\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00032\b\u0010;\u001a\u0004\u0018\u00010\u00032\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003H&J\u001a\u0010?\u001a\u00020\u00052\b\u0010@\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u000eH&J\"\u0010A\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u00032\b\u00103\u001a\u0004\u0018\u00010\u00032\u0006\u0010B\u001a\u00020\u000bH&J(\u0010C\u001a\u00020\u00052\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\t2\u0006\u0010G\u001a\u00020\u00032\u0006\u0010H\u001a\u00020\tH&J\u0010\u0010I\u001a\u00020\u00052\u0006\u0010J\u001a\u00020KH&J\u0018\u0010L\u001a\u00020\u00052\u0006\u0010@\u001a\u00020\u00032\u0006\u0010M\u001a\u00020\u0003H&J\u001e\u0010N\u001a\u00020\u00052\u0006\u0010@\u001a\u00020\u00032\f\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00030\u0019H&J \u0010P\u001a\u00020\u00052\u0006\u0010@\u001a\u00020\u00032\u0006\u0010Q\u001a\u00020\u000b2\u0006\u0010R\u001a\u00020\u0003H&J\u0018\u0010S\u001a\u00020\u00052\u0006\u0010@\u001a\u00020\u00032\u0006\u0010M\u001a\u00020\u0003H&¨\u0006T"}, d2 = {"Lcom/talabat/darkstores/feature/tracking/DarkstoresEventTracker;", "", "getScreenName", "", "onAddCartClicked", "", "productDetails", "Lcom/talabat/darkstores/feature/tracking/data/ProductDetails;", "isAdd", "", "ageVerification", "", "searchRequestId", "eventOriginType", "Lcom/talabat/darkstores/feature/tracking/EventOriginType;", "onBannerClicked", "banner", "Lcom/talabat/darkstores/model/Banner;", "type", "position", "onBannerShown", "onCategoryClicked", "name", "id", "subcategories", "", "onCategoryLoaded", "event", "Lcom/talabat/darkstores/feature/tracking/data/CategoryLoadedEvent;", "onCategoryUpdated", "categoryName", "categoryId", "selectedItem", "products", "Lcom/models/ProductTrackingModel;", "onCollectionClicked", "chainId", "branchId", "isDarkstore", "collectionId", "collectionName", "onDarkstoreLoaded", "darkstoreDetails", "Lcom/talabat/darkstores/feature/tracking/data/DarkstoreDetails;", "restaurantBackup", "onDarkstoresAgeVerificationShown", "onDarkstoresAllButtonClicked", "shopCategory", "originType", "onDarkstoresEmptySearchResult", "query", "requestId", "screenType", "Lcom/talabat/darkstores/feature/tracking/SearchResultScreenType;", "onDarkstoresSearchBarClicked", "onDarkstoresSearchResultClicked", "onDarkstoresSearchResultsLoaded", "productSkus", "onProductOpened", "description", "price", "", "b", "onScreenOpened", "screenName", "onSearchClosed", "itemCount", "onShopDetailsLoaded", "shopDetails", "Lcom/talabat/darkstores/feature/tracking/data/ShopDetails;", "emptyCart", "searchTerm", "isNewTrackerEnabled", "onVendorVisit", "vendorVisitDetails", "Lcom/talabat/darkstores/feature/tracking/data/VendorVisitDetails;", "sendNavigateToVoucherProductDetails", "eventOrigin", "sendSwimLaneLoadedEvent", "voucherTitles", "sendSwimLaneVoucherClickedEvent", "voucherPosition", "voucherName", "trackPreCheckoutAlertVisibility", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface DarkstoresEventTracker {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void onAddCartClicked$default(DarkstoresEventTracker darkstoresEventTracker, ProductDetails productDetails, boolean z11, int i11, String str, EventOriginType eventOriginType, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 4) != 0) {
                    i11 = 0;
                }
                darkstoresEventTracker.onAddCartClicked(productDetails, z11, i11, (i12 & 8) != 0 ? null : str, (i12 & 16) != 0 ? null : eventOriginType);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onAddCartClicked");
        }

        public static /* synthetic */ void onDarkstoresAllButtonClicked$default(DarkstoresEventTracker darkstoresEventTracker, String str, String str2, String str3, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 1) != 0) {
                    str = StringUtils.empty(StringCompanionObject.INSTANCE);
                }
                if ((i11 & 2) != 0) {
                    str2 = "";
                }
                if ((i11 & 4) != 0) {
                    str3 = "";
                }
                darkstoresEventTracker.onDarkstoresAllButtonClicked(str, str2, str3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onDarkstoresAllButtonClicked");
        }
    }

    @Nullable
    String getScreenName();

    void onAddCartClicked(@NotNull ProductDetails productDetails, boolean z11, int i11, @Nullable String str, @Nullable EventOriginType eventOriginType);

    void onBannerClicked(@NotNull Banner banner, @NotNull String str, int i11);

    void onBannerShown(@NotNull Banner banner, @NotNull String str, int i11);

    void onCategoryClicked(@NotNull String str, @Nullable String str2, @NotNull List<String> list, int i11);

    void onCategoryLoaded(@NotNull CategoryLoadedEvent categoryLoadedEvent);

    void onCategoryUpdated(@NotNull String str, @Nullable String str2, @NotNull String str3, @NotNull List<ProductTrackingModel> list);

    void onCollectionClicked(int i11, int i12, boolean z11, @NotNull String str, @NotNull String str2);

    void onDarkstoreLoaded(@NotNull DarkstoreDetails darkstoreDetails, @Nullable String str);

    void onDarkstoresAgeVerificationShown();

    void onDarkstoresAllButtonClicked(@NotNull String str, @Nullable String str2, @NotNull String str3);

    void onDarkstoresEmptySearchResult(@NotNull String str, @Nullable String str2, @NotNull SearchResultScreenType searchResultScreenType);

    void onDarkstoresSearchBarClicked();

    void onDarkstoresSearchResultClicked(@NotNull String str, @Nullable String str2);

    void onDarkstoresSearchResultsLoaded(@NotNull String str, @NotNull SearchResultScreenType searchResultScreenType, @Nullable String str2, @NotNull List<String> list);

    void onProductOpened(@NotNull String str, @NotNull String str2, @Nullable String str3, float f11, boolean z11, @Nullable String str4);

    void onScreenOpened(@Nullable String str, @NotNull EventOriginType eventOriginType);

    void onSearchClosed(@NotNull String str, @Nullable String str2, int i11);

    void onShopDetailsLoaded(@NotNull ShopDetails shopDetails, boolean z11, @NotNull String str, boolean z12);

    void onVendorVisit(@NotNull VendorVisitDetails vendorVisitDetails);

    void sendNavigateToVoucherProductDetails(@NotNull String str, @NotNull String str2);

    void sendSwimLaneLoadedEvent(@NotNull String str, @NotNull List<String> list);

    void sendSwimLaneVoucherClickedEvent(@NotNull String str, int i11, @NotNull String str2);

    void trackPreCheckoutAlertVisibility(@NotNull String str, @NotNull String str2);
}
