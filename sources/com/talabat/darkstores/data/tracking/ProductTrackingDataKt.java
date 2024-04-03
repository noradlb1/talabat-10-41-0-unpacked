package com.talabat.darkstores.data.tracking;

import com.talabat.feature.darkstorescart.data.model.Product;
import com.talabat.feature.darkstorescart.data.model.Tracking;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"toTrackingData", "Lcom/talabat/darkstores/data/tracking/ProductTrackingData;", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "quantity", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ProductTrackingDataKt {
    @NotNull
    public static final ProductTrackingData toTrackingData(@NotNull Product product, int i11) {
        String str;
        Intrinsics.checkNotNullParameter(product, "<this>");
        int ageLimit = product.getAgeLimit();
        String description = product.getDescription();
        boolean isFavorite = product.isFavorite();
        String name2 = product.getName();
        float price = product.getPrice();
        String sku = product.getSku();
        Tracking tracking2 = product.getTracking();
        if (tracking2 == null || (str = tracking2.getNmrAdId()) == null) {
            str = "NA";
        }
        return new ProductTrackingData(ageLimit, description, isFavorite, name2, price, i11, sku, str, product.isSponsored() ? "True:nmr_NA__NA" : "False:nmr_NA__NA");
    }

    @NotNull
    public static final ProductTrackingData toTrackingData(@NotNull Product product) {
        Intrinsics.checkNotNullParameter(product, "<this>");
        return toTrackingData(product, 0);
    }
}
