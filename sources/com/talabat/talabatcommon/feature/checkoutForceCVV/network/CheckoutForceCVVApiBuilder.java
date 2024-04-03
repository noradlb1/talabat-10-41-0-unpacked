package com.talabat.talabatcommon.feature.checkoutForceCVV.network;

import com.talabat.core.network.endpoint.MonolithEndPointProvider;
import com.talabat.core.network.network.TalabatAPIBuilder;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/talabatcommon/feature/checkoutForceCVV/network/CheckoutForceCVVApiBuilder;", "", "()V", "getCheckoutCVVPopUpApi", "Lcom/talabat/talabatcommon/feature/checkoutForceCVV/network/CheckoutForceCVVApi;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CheckoutForceCVVApiBuilder {
    @NotNull
    public static final CheckoutForceCVVApiBuilder INSTANCE = new CheckoutForceCVVApiBuilder();

    private CheckoutForceCVVApiBuilder() {
    }

    @NotNull
    public final CheckoutForceCVVApi getCheckoutCVVPopUpApi() {
        return (CheckoutForceCVVApi) new TalabatAPIBuilder().createApi(MonolithEndPointProvider.INSTANCE.getBaseUrl(), CheckoutForceCVVApi.class);
    }
}
