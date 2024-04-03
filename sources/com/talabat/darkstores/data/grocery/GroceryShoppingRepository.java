package com.talabat.darkstores.data.grocery;

import com.talabat.darkstores.data.ConfigurationParameters;
import com.talabat.darkstores.data.grocery.model.CampaignProgressResponse;
import com.talabat.darkstores.di.LibScope;
import com.talabat.observabilityNew.squads.nfv.ObservableAttributesNames;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0001\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006JM\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b¢\u0006\u0002\u0010\u0013J]\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\r¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/talabat/darkstores/data/grocery/GroceryShoppingRepository;", "", "groceryShoppingApi", "Lcom/talabat/darkstores/data/grocery/GroceryShoppingApi;", "configurationParameters", "Lcom/talabat/darkstores/data/ConfigurationParameters;", "(Lcom/talabat/darkstores/data/grocery/GroceryShoppingApi;Lcom/talabat/darkstores/data/ConfigurationParameters;)V", "getCampaignProgress", "Lio/reactivex/Single;", "Lcom/talabat/darkstores/data/grocery/model/CampaignProgressResponse;", "total", "", "vendorId", "", "minOrderValue", "deliveryFee", "cartDiscount", "deliveryDiscount", "subTotal", "(FLjava/lang/String;Ljava/lang/Float;Ljava/lang/Float;FFF)Lio/reactivex/Single;", "getCampaignProgressV3", "subtotalAfterDiscount", "vendorCode", "(FLjava/lang/String;Ljava/lang/Float;Ljava/lang/Float;FFFFLjava/lang/String;)Lio/reactivex/Single;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
@LibScope
public final class GroceryShoppingRepository {
    @NotNull
    private final ConfigurationParameters configurationParameters;
    @NotNull
    private final GroceryShoppingApi groceryShoppingApi;

    @Inject
    public GroceryShoppingRepository(@NotNull GroceryShoppingApi groceryShoppingApi2, @NotNull ConfigurationParameters configurationParameters2) {
        Intrinsics.checkNotNullParameter(groceryShoppingApi2, "groceryShoppingApi");
        Intrinsics.checkNotNullParameter(configurationParameters2, "configurationParameters");
        this.groceryShoppingApi = groceryShoppingApi2;
        this.configurationParameters = configurationParameters2;
    }

    @NotNull
    public final Single<CampaignProgressResponse> getCampaignProgress(float f11, @NotNull String str, @Nullable Float f12, @Nullable Float f13, float f14, float f15, float f16) {
        Intrinsics.checkNotNullParameter(str, "vendorId");
        return this.groceryShoppingApi.campaignProgress(this.configurationParameters.getCountryCode(), f11, str, f12, f13, this.configurationParameters.getCurrencyCode(), this.configurationParameters.getSessionId(), f14, f15, f16);
    }

    @NotNull
    public final Single<CampaignProgressResponse> getCampaignProgressV3(float f11, @NotNull String str, @Nullable Float f12, @Nullable Float f13, float f14, float f15, float f16, float f17, @NotNull String str2) {
        String str3 = str;
        Intrinsics.checkNotNullParameter(str3, "vendorId");
        String str4 = str2;
        Intrinsics.checkNotNullParameter(str4, ObservableAttributesNames.VENDOR_CODE);
        return this.groceryShoppingApi.campaignProgressV3(this.configurationParameters.getCountryCode(), f11, str3, f12, f13, this.configurationParameters.getCurrencyCode(), this.configurationParameters.getSessionId(), f14, f15, f16, f17, str4);
    }
}
