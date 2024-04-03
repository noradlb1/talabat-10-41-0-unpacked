package com.integration;

import android.content.Context;
import buisnessmodels.Customer;
import com.huawei.hms.flutter.map.constants.Param;
import com.models.ProductTrackingModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.AppTracker;
import tracking.IAppTracker;
import tracking.gtm.TalabatGTM;
import tracking.models.ProductTracking;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/integration/IntegrationAppTracker;", "", "()V", "Companion", "com_talabat_NewArchi_TalabatIntegration_TalabatIntegration"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IntegrationAppTracker {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static IAppTracker appTracker = new AppTracker(new TalabatGTM());

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b%\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jº\u0001\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000eJº\u0001\u0010\u001f\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000eJ`\u0010 \u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010!\u001a\u0004\u0018\u00010\u000e2\b\u0010\"\u001a\u0004\u0018\u00010\u000e2\b\u0010#\u001a\u0004\u0018\u00010\u000e2\b\u0010$\u001a\u0004\u0018\u00010\u000e2\b\u0010%\u001a\u0004\u0018\u00010\u000e2\b\u0010&\u001a\u0004\u0018\u00010\u000eJ,\u0010'\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010(\u001a\u0004\u0018\u00010\u000eJ,\u0010)\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010(\u001a\u0004\u0018\u00010\u000eJ,\u0010*\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010(\u001a\u0004\u0018\u00010\u000eJ8\u0010+\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u000eJ§\u0001\u0010-\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010.\u001a\u0004\u0018\u00010\u000e2\b\u0010/\u001a\u0004\u0018\u00010\u000e2\b\u00100\u001a\u0004\u0018\u00010\u000e2\u0006\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\u000e2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u0002082\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010,\u001a\u00020\u000e2\b\u0010:\u001a\u0004\u0018\u00010\u000e2\b\u0010;\u001a\u0004\u0018\u0001062\u0006\u0010<\u001a\u0002062\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010>\u001a\u0004\u0018\u000106¢\u0006\u0002\u0010?J\"\u0010@\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010.\u001a\u0004\u0018\u00010\u000e2\b\u0010A\u001a\u0004\u0018\u00010\u000eJ@\u0010B\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010.\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010C\u001a\u0004\u0018\u00010\u000e2\b\u0010/\u001a\u0004\u0018\u00010\u000e2\b\u0010D\u001a\u0004\u0018\u00010\u000eJF\u0010E\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010.\u001a\u0004\u0018\u00010\u000e2\b\u0010F\u001a\u0004\u0018\u00010\u000e2\b\u00102\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010G\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u000206JN\u0010H\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u00102\u001a\u0004\u0018\u00010\u000e2\b\u0010/\u001a\u0004\u0018\u00010\u000e2\u000e\u0010I\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010J2\u0006\u0010\u0013\u001a\u0002062\b\u0010.\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJf\u0010K\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u00102\u001a\u0004\u0018\u00010\u000e2\b\u0010/\u001a\u0004\u0018\u00010\u000e2\u000e\u0010I\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010J2\b\u0010.\u001a\u0004\u0018\u00010\u000e2\f\u0010L\u001a\b\u0012\u0004\u0012\u00020M0J2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010N\u001a\u0002082\b\u0010,\u001a\u0004\u0018\u00010\u000eJ@\u0010O\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010.\u001a\u0004\u0018\u00010\u000e2\u0006\u0010P\u001a\u00020\u000e2\b\u0010/\u001a\u0004\u0018\u00010\u000e2\u0006\u0010Q\u001a\u00020\u000e2\f\u0010L\u001a\b\u0012\u0004\u0012\u00020M0JJ4\u0010R\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010S\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010T\u001a\u0004\u0018\u00010\u000eJ\"\u0010U\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010.\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJV\u0010V\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010W\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\u000e2\b\u00100\u001a\u0004\u0018\u00010\u000e2\u0006\u00103\u001a\u0002042\u0006\u00107\u001a\u0002082\b\u0010/\u001a\u0004\u0018\u00010\u000e2\b\u0010.\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\"\u0010X\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010.\u001a\u0004\u0018\u00010\u000e2\b\u0010A\u001a\u0004\u0018\u00010\u000eJ*\u0010Y\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010S\u001a\u00020\u000e2\b\u0010T\u001a\u0004\u0018\u00010\u000eJ@\u0010Z\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010.\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010S\u001a\u00020\u000e2\b\u0010T\u001a\u0004\u0018\u00010\u000e2\f\u0010[\u001a\b\u0012\u0004\u0012\u00020\u000e0JJ2\u0010\\\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010.\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010]\u001a\u0002082\u0006\u0010^\u001a\u00020\u000eJ\u0018\u0010_\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010.\u001a\u0004\u0018\u00010\u000eJ\u0018\u0010`\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010.\u001a\u0004\u0018\u00010\u000eJ\u001a\u0010a\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010b\u001a\u0004\u0018\u00010\u000eJ\u001e\u0010c\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010d\u001a\u00020\u000eJ,\u0010e\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010f\u001a\u0002062\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ2\u0010g\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010h\u001a\u0004\u0018\u00010\u000e2\u0006\u0010S\u001a\u00020\u000e2\b\u0010T\u001a\u0004\u0018\u00010\u000e2\u0006\u0010i\u001a\u000206R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006j"}, d2 = {"Lcom/integration/IntegrationAppTracker$Companion;", "", "()V", "appTracker", "Ltracking/IAppTracker;", "getAppTracker", "()Ltracking/IAppTracker;", "setAppTracker", "(Ltracking/IAppTracker;)V", "homePagerBannerClicked", "", "context", "Landroid/content/Context;", "screenName", "", "screenType", "zoneNumber", "bannerId", "bannerName", "position", "chainId", "chainName", "shopId", "shopName", "shopStatus", "shopType", "shopArea", "shopMainCuisine", "shopDeliveryTime", "deliveryProvider", "vendorSponsoringPlacement", "homePagerBannerImpression", "homeScreenLoaded", "shopListType", "swimlanesTotal", "swimlanesTitleList", "swimlaneRequestId", "swimlaneStrategyList", "swimlaneVariation", "onAlertCloseClicked", "alertType", "onAlertReadMoreClicked", "onAlertShown", "onBannerStoreShown", "eventOrigin", "onDarkstoresAddToCartClicked", "restaurant", "categoryId", "description", "sku", "name", "price", "", "quantity", "", "isFavorite", "", "isAdd", "swimlaneTitle", "swimlaneLength", "ageVerificationRequired", "searchRequestId", "listPosition", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FIZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ILjava/lang/String;Ljava/lang/Integer;)V", "onDarkstoresAgeVerificationShown", "lastOpenedScreen", "onDarkstoresAllButtonClicked", "shopCategory", "originType", "onDarkstoresBannerShown", "globalId", "type", "onDarkstoresCategoryClicked", "subcategories", "", "onDarkstoresCategoryLoaded", "products", "Lcom/models/ProductTrackingModel;", "expanded", "onDarkstoresCategoryUpdated", "categoryName", "selectedItem", "onDarkstoresEmptySearchResults", "query", "requestId", "onDarkstoresLoaded", "onDarkstoresProductOpened", "id", "onDarkstoresSearchBarClicked", "onDarkstoresSearchResultsClicked", "onDarkstoresSearchResultsLoaded", "productsSkus", "onDarkstoresShopDetailsLoaded", "emptyCart", "searchTerm", "onLookingGlassClicked", "onLookingGlassShown", "onOrderRatingClicked", "orderId", "onRedeemPageOpen", "points", "onReorderClicked", "branchId", "onSearchClosed", "extraRestaurant", "itemCount", "com_talabat_NewArchi_TalabatIntegration_TalabatIntegration"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void onDarkstoresAddToCartClicked$default(Companion companion, Context context, String str, String str2, String str3, String str4, String str5, float f11, int i11, boolean z11, boolean z12, String str6, String str7, String str8, Integer num, int i12, String str9, Integer num2, int i13, Object obj) {
            companion.onDarkstoresAddToCartClicked(context, str, str2, str3, str4, str5, f11, i11, z11, z12, str6, str7, str8, num, i12, (i13 & 32768) != 0 ? null : str9, (i13 & 65536) != 0 ? null : num2);
        }

        @NotNull
        public final IAppTracker getAppTracker() {
            return IntegrationAppTracker.appTracker;
        }

        public final void homePagerBannerClicked(@Nullable Context context, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11, @Nullable String str12, @Nullable String str13, @Nullable String str14, @Nullable String str15, @Nullable String str16, @Nullable String str17) {
            AppTracker.homePagerBannerClicked(context, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17);
        }

        public final void homePagerBannerImpression(@Nullable Context context, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11, @Nullable String str12, @Nullable String str13, @Nullable String str14, @Nullable String str15, @Nullable String str16, @Nullable String str17) {
            AppTracker.homePagerBannerImpression(context, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17);
        }

        public final void homeScreenLoaded(@Nullable Context context, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8) {
            AppTracker.homeScreenLoaded(context, str, str2, str3, str4, str5, str6, str7, str8);
        }

        public final void onAlertCloseClicked(@NotNull Context context, @Nullable String str, @Nullable String str2, @Nullable String str3) {
            Intrinsics.checkNotNullParameter(context, "context");
            AppTracker.onAlertCloseClicked(context, str, str2, str3);
        }

        public final void onAlertReadMoreClicked(@NotNull Context context, @Nullable String str, @Nullable String str2, @Nullable String str3) {
            Intrinsics.checkNotNullParameter(context, "context");
            AppTracker.onAlertReadMoreClicked(context, str, str2, str3);
        }

        public final void onAlertShown(@NotNull Context context, @Nullable String str, @Nullable String str2, @Nullable String str3) {
            Intrinsics.checkNotNullParameter(context, "context");
            AppTracker.onAlertShown(context, str, str2, str3);
        }

        public final void onBannerStoreShown(@Nullable Context context, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
            Intrinsics.checkNotNullParameter(str, "bannerName");
            Intrinsics.checkNotNullParameter(str2, "bannerId");
            Intrinsics.checkNotNullParameter(str3, "chainName");
            Intrinsics.checkNotNullParameter(str4, "chainId");
            Intrinsics.checkNotNullParameter(str5, "eventOrigin");
            AppTracker.onBannerStoreShown(context, str, str2, str3, str4, str5);
        }

        public final void onDarkstoresAddToCartClicked(@NotNull Context context, @Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull String str4, @NotNull String str5, float f11, int i11, boolean z11, boolean z12, @Nullable String str6, @NotNull String str7, @Nullable String str8, @Nullable Integer num, int i12, @Nullable String str9, @Nullable Integer num2) {
            Context context2 = context;
            Intrinsics.checkNotNullParameter(context2, "context");
            Intrinsics.checkNotNullParameter(str4, "sku");
            Intrinsics.checkNotNullParameter(str5, "name");
            Intrinsics.checkNotNullParameter(str7, "eventOrigin");
            getAppTracker().onDarkstoresAddToCartClicked(context2, str, str2, str3, str4, str5, f11, i11, z11, z12, str6, str7, str8, num, i12, str9, num2);
        }

        public final void onDarkstoresAgeVerificationShown(@NotNull Context context, @Nullable String str, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(context, "context");
            AppTracker.onDarkstoresAgeVerificationShown(context, str, str2);
        }

        public final void onDarkstoresAllButtonClicked(@NotNull Context context, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
            Intrinsics.checkNotNullParameter(context, "context");
            AppTracker.onDarkstoresAllButtonClicked(context, str, str2, str3, str4, str5);
        }

        public final void onDarkstoresBannerShown(@NotNull Context context, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @NotNull String str5, int i11) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str5, "type");
            AppTracker.onDarkstoresBannerShown(context, str, str2, str3, str4, str5, i11);
        }

        public final void onDarkstoresCategoryClicked(@NotNull Context context, @Nullable String str, @Nullable String str2, @Nullable List<String> list, int i11, @Nullable String str3, @Nullable String str4) {
            Intrinsics.checkNotNullParameter(context, "context");
            AppTracker.onDarkstoresCategoryClicked(context, str, str2, list, i11, str3, str4);
        }

        public final void onDarkstoresCategoryLoaded(@NotNull Context context, @Nullable String str, @Nullable String str2, @Nullable List<String> list, @Nullable String str3, @NotNull List<ProductTrackingModel> list2, @Nullable String str4, boolean z11, @Nullable String str5) {
            List<ProductTrackingModel> list3 = list2;
            Context context2 = context;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(list3, "products");
            Iterable<ProductTrackingModel> iterable = list3;
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
            for (ProductTrackingModel productTrackingModel : iterable) {
                arrayList.add(new ProductTracking(productTrackingModel.getSku(), productTrackingModel.getName(), productTrackingModel.getPrice(), productTrackingModel.getCurrency(), productTrackingModel.getIndex()));
            }
            AppTracker.onDarkstoresCategoryLoaded(context, str3, str, str2, list, arrayList, str4, Boolean.valueOf(z11), str5);
        }

        public final void onDarkstoresCategoryUpdated(@NotNull Context context, @Nullable String str, @NotNull String str2, @Nullable String str3, @NotNull String str4, @NotNull List<ProductTrackingModel> list) {
            List<ProductTrackingModel> list2 = list;
            Context context2 = context;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str2, "categoryName");
            Intrinsics.checkNotNullParameter(str4, "selectedItem");
            Intrinsics.checkNotNullParameter(list2, "products");
            Iterable<ProductTrackingModel> iterable = list2;
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
            for (ProductTrackingModel productTrackingModel : iterable) {
                arrayList.add(new ProductTracking(productTrackingModel.getSku(), productTrackingModel.getName(), productTrackingModel.getPrice(), productTrackingModel.getCurrency(), productTrackingModel.getIndex()));
            }
            AppTracker.onDarkstoresCategoryUpdated(context, str, str2, str3, str4, arrayList);
        }

        public final void onDarkstoresEmptySearchResults(@NotNull Context context, @NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "query");
            getAppTracker().onSearchErrorShown(context, str3, str2, str, str4);
        }

        public final void onDarkstoresLoaded(@NotNull Context context, @Nullable String str, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(context, "context");
            AppTracker.onDarkstoresLoaded(context, str, str2);
        }

        public final void onDarkstoresProductOpened(@NotNull Context context, @NotNull String str, @NotNull String str2, @Nullable String str3, float f11, boolean z11, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "name");
            AppTracker.onDarkstoresProductOpened(context, str, str2, str3, f11, z11, str4, str5, str6);
        }

        public final void onDarkstoresSearchBarClicked(@NotNull Context context, @Nullable String str, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(context, "context");
            AppTracker.onDarkstoresSearchBarClicked(context, str, str2);
        }

        public final void onDarkstoresSearchResultsClicked(@NotNull Context context, @Nullable String str, @NotNull String str2, @Nullable String str3) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str2, "query");
            getAppTracker().onDarkstoresSearchResultsClicked(context, str, str2, str3);
        }

        public final void onDarkstoresSearchResultsLoaded(@NotNull Context context, @Nullable String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @NotNull List<String> list) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str2, "screenType");
            Intrinsics.checkNotNullParameter(str3, "query");
            Intrinsics.checkNotNullParameter(list, "productsSkus");
            getAppTracker().onDarkstoresSearchResultsLoaded(context, str, str2, str3, str4, list);
        }

        public final void onDarkstoresShopDetailsLoaded(@NotNull Context context, @Nullable String str, @Nullable String str2, boolean z11, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str3, "searchTerm");
            getAppTracker().onDarkstoresShopDetailsLoaded(context, str, str2, z11, str3);
        }

        public final void onLookingGlassClicked(@NotNull Context context, @Nullable String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            AppTracker.onDarkstoresLookingGlassClicked(context, str);
        }

        public final void onLookingGlassShown(@NotNull Context context, @Nullable String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            AppTracker.onDarkstoresLookingGlassShown(context, str);
        }

        public final void onOrderRatingClicked(@Nullable Context context, @Nullable String str) {
            AppTracker.onOrderRatingClicked(context, str);
        }

        public final void onRedeemPageOpen(@NotNull Context context, @NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "screenName");
            Intrinsics.checkNotNullParameter(str2, Param.POINTS);
            AppTracker.onRedeemPageOpen(context, str, Customer.getInstance().getCustomerInfo(), str2);
        }

        public final void onReorderClicked(@Nullable Context context, int i11, @Nullable String str, @Nullable String str2) {
            AppTracker.onReorderClicked(context, i11, str, str2);
        }

        public final void onSearchClosed(@NotNull Context context, @Nullable String str, @NotNull String str2, @Nullable String str3, int i11) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str2, "query");
            getAppTracker().onSearchClosed(context, str, str2, str3, i11);
        }

        public final void setAppTracker(@NotNull IAppTracker iAppTracker) {
            Intrinsics.checkNotNullParameter(iAppTracker, "<set-?>");
            IntegrationAppTracker.appTracker = iAppTracker;
        }
    }
}
