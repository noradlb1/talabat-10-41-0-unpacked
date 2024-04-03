package com.talabat.darkstores.domain.naivgator;

import android.os.Bundle;
import com.talabat.darkstores.R;
import com.talabat.darkstores.feature.home.swimlane.ProductClickTrackingAttribute;
import com.talabat.darkstores.feature.product.ProductFragmentArgs;
import com.talabat.darkstores.feature.searchResults.SearchResultsFragmentArgs;
import com.talabat.darkstores.feature.searchResults.SearchResultsType;
import com.talabat.feature.darkstores.domain.navigator.DarkstoresInternalNavigationTarget;
import com.talabat.feature.darkstorescart.data.model.CampaignTrigger;
import com.talabat.feature.darkstorescart.data.model.Product;
import com.talabat.feature.darkstorescart.data.model.ProductExtendedInfo;
import com.talabat.feature.darkstorescart.data.model.Tracking;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0006*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"arguments", "Landroid/os/Bundle;", "Lcom/talabat/feature/darkstores/domain/navigator/DarkstoresInternalNavigationTarget;", "getArguments", "(Lcom/talabat/feature/darkstores/domain/navigator/DarkstoresInternalNavigationTarget;)Landroid/os/Bundle;", "destinationId", "", "getDestinationId", "(Lcom/talabat/feature/darkstores/domain/navigator/DarkstoresInternalNavigationTarget;)I", "com_talabat_NewArchi_darkstores_darkstores"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class DarkstoresInternalNavigationTargetExtKt {
    @NotNull
    public static final Bundle getArguments(@NotNull DarkstoresInternalNavigationTarget darkstoresInternalNavigationTarget) {
        DarkstoresInternalNavigationTarget darkstoresInternalNavigationTarget2 = darkstoresInternalNavigationTarget;
        Intrinsics.checkNotNullParameter(darkstoresInternalNavigationTarget2, "<this>");
        if (darkstoresInternalNavigationTarget2 instanceof DarkstoresInternalNavigationTarget.ProductDetails) {
            Product product = new Product((String) null, (String) null, (String) null, 0.0f, (Float) null, 0, 0, (Integer) null, (Float) null, (Tracking) null, (String) null, 0, false, (List) null, (List) null, (String) null, (List) null, (String) null, false, (String) null, false, (CampaignTrigger) null, 0, (ProductExtendedInfo) null, (List) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (String) null, (String) null, Integer.MAX_VALUE, (DefaultConstructorMarker) null);
            DarkstoresInternalNavigationTarget.ProductDetails productDetails = (DarkstoresInternalNavigationTarget.ProductDetails) darkstoresInternalNavigationTarget2;
            product.setId(productDetails.getProductId());
            return new ProductFragmentArgs(product, productDetails.getShouldTrackProductOpenedEvent(), (String) null, productDetails.getEventOrigin(), (ProductClickTrackingAttribute) null, productDetails.getSwimlaneRequestId(), productDetails.getSearchRequestId(), (String) null, 148, (DefaultConstructorMarker) null).toBundle();
        } else if (darkstoresInternalNavigationTarget2 instanceof DarkstoresInternalNavigationTarget.Cart) {
            return new Bundle();
        } else {
            if (darkstoresInternalNavigationTarget2 instanceof DarkstoresInternalNavigationTarget.VendorLanding) {
                return new Bundle();
            }
            if (darkstoresInternalNavigationTarget2 instanceof DarkstoresInternalNavigationTarget.BannerCampaignSearchResult) {
                DarkstoresInternalNavigationTarget.BannerCampaignSearchResult bannerCampaignSearchResult = (DarkstoresInternalNavigationTarget.BannerCampaignSearchResult) darkstoresInternalNavigationTarget2;
                return new SearchResultsFragmentArgs(new SearchResultsType.Banner(bannerCampaignSearchResult.getTag()), bannerCampaignSearchResult.getEventOrigin().getTrackingName()).toBundle();
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final int getDestinationId(@NotNull DarkstoresInternalNavigationTarget darkstoresInternalNavigationTarget) {
        Intrinsics.checkNotNullParameter(darkstoresInternalNavigationTarget, "<this>");
        if (darkstoresInternalNavigationTarget instanceof DarkstoresInternalNavigationTarget.ProductDetails) {
            return R.id.productFragment;
        }
        if (darkstoresInternalNavigationTarget instanceof DarkstoresInternalNavigationTarget.Cart) {
            return R.id.cartFragment;
        }
        if (darkstoresInternalNavigationTarget instanceof DarkstoresInternalNavigationTarget.VendorLanding) {
            return R.id.homeFragment;
        }
        if (darkstoresInternalNavigationTarget instanceof DarkstoresInternalNavigationTarget.BannerCampaignSearchResult) {
            return R.id.searchResultsFragment;
        }
        throw new NoWhenBranchMatchedException();
    }
}
