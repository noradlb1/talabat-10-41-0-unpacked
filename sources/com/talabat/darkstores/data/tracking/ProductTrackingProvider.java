package com.talabat.darkstores.data.tracking;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import com.talabat.darkstores.data.ConfigurationParameters;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/talabat/darkstores/data/tracking/ProductTrackingProvider;", "", "configurationParameters", "Lcom/talabat/darkstores/data/ConfigurationParameters;", "(Lcom/talabat/darkstores/data/ConfigurationParameters;)V", "prepareProductParams", "Landroid/os/Bundle;", "productTrackingData", "Lcom/talabat/darkstores/data/tracking/ProductTrackingData;", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProductTrackingProvider {
    @NotNull
    @Deprecated
    public static final String AGE_LIMIT = "ageVerificationRequired";
    @NotNull
    @Deprecated
    public static final String CURRENCY = "currencyCode";
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    public static final String DESCRIPTION = "productDetails";
    @NotNull
    @Deprecated
    public static final String FAVOURITE = "isFavorite";
    @NotNull
    @Deprecated
    public static final String NAME = "productName";
    @NotNull
    @Deprecated
    public static final String NMR_AD_ID = "nmrAdId";
    @NotNull
    @Deprecated
    public static final String PRICE = "productUnitPrice";
    @NotNull
    @Deprecated
    public static final String QUANTITY = "productQuantity";
    @NotNull
    @Deprecated
    public static final String SALE_PRICE = "productUnitSalePrice";
    @NotNull
    @Deprecated
    public static final String SHOP_SPONSORING = "shopSponsoring";
    @NotNull
    @Deprecated
    public static final String SKU = "productSku";
    @NotNull
    private final ConfigurationParameters configurationParameters;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/talabat/darkstores/data/tracking/ProductTrackingProvider$Companion;", "", "()V", "AGE_LIMIT", "", "CURRENCY", "DESCRIPTION", "FAVOURITE", "NAME", "NMR_AD_ID", "PRICE", "QUANTITY", "SALE_PRICE", "SHOP_SPONSORING", "SKU", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public ProductTrackingProvider(@NotNull ConfigurationParameters configurationParameters2) {
        Intrinsics.checkNotNullParameter(configurationParameters2, "configurationParameters");
        this.configurationParameters = configurationParameters2;
    }

    @NotNull
    public final Bundle prepareProductParams(@NotNull ProductTrackingData productTrackingData) {
        boolean z11;
        Intrinsics.checkNotNullParameter(productTrackingData, "productTrackingData");
        Pair[] pairArr = new Pair[11];
        Integer valueOf = Integer.valueOf(productTrackingData.getAgeLimit());
        if (valueOf.intValue() != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            valueOf = null;
        }
        pairArr[0] = TuplesKt.to(AGE_LIMIT, BaseTrackerKt.orDefault$default(valueOf, (String) null, 1, (Object) null));
        pairArr[1] = TuplesKt.to("currencyCode", this.configurationParameters.getCurrencyCode());
        pairArr[2] = TuplesKt.to(DESCRIPTION, productTrackingData.getDescription());
        pairArr[3] = TuplesKt.to(FAVOURITE, Boolean.valueOf(productTrackingData.isFavorite()));
        pairArr[4] = TuplesKt.to(NAME, productTrackingData.getName());
        pairArr[5] = TuplesKt.to(PRICE, Float.valueOf(productTrackingData.getPrice()));
        pairArr[6] = TuplesKt.to(QUANTITY, Integer.valueOf(productTrackingData.getQuantity()));
        pairArr[7] = TuplesKt.to(SALE_PRICE, Float.valueOf(productTrackingData.getPrice()));
        pairArr[8] = TuplesKt.to("productSku", productTrackingData.getSku());
        pairArr[9] = TuplesKt.to(NMR_AD_ID, productTrackingData.getNmrAdId());
        pairArr[10] = TuplesKt.to("shopSponsoring", productTrackingData.getShopSponsoring());
        return BundleKt.bundleOf(pairArr);
    }
}
