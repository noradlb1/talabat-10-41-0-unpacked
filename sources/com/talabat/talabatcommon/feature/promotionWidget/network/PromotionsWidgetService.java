package com.talabat.talabatcommon.feature.promotionWidget.network;

import com.talabat.core.network.domain.endpoint.EndpointEnvironment;
import com.talabat.core.network.endpoint.VerticalsEndPointProvider;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.talabatcommon.feature.promotionWidget.model.response.PromotionsWidgetResponse;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J>\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\u00018BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/talabat/talabatcommon/feature/promotionWidget/network/PromotionsWidgetService;", "Lcom/talabat/talabatcommon/feature/promotionWidget/network/PromotionsWidgetApi;", "talabatAPIBuilder", "Lcom/talabat/core/network/network/TalabatAPIBuilder;", "(Lcom/talabat/core/network/network/TalabatAPIBuilder;)V", "baseUrl", "", "promotionsWidgetApi", "getPromotionsWidgetApi", "()Lcom/talabat/talabatcommon/feature/promotionWidget/network/PromotionsWidgetApi;", "promotionsWidgetApi$delegate", "Lkotlin/Lazy;", "getPromotionData", "Lretrofit2/Call;", "Lcom/talabat/talabatcommon/feature/promotionWidget/model/response/PromotionsWidgetResponse;", "countryId", "", "areaId", "promotionTag", "module", "lat", "lng", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PromotionsWidgetService implements PromotionsWidgetApi {
    /* access modifiers changed from: private */
    @NotNull
    public final String baseUrl;
    @NotNull
    private final Lazy promotionsWidgetApi$delegate;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EndpointEnvironment.values().length];
            iArr[EndpointEnvironment.PRODUCTION.ordinal()] = 1;
            iArr[EndpointEnvironment.QA.ordinal()] = 2;
            iArr[EndpointEnvironment.MOCK.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public PromotionsWidgetService(@NotNull TalabatAPIBuilder talabatAPIBuilder) {
        String str;
        Intrinsics.checkNotNullParameter(talabatAPIBuilder, "talabatAPIBuilder");
        this.promotionsWidgetApi$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new PromotionsWidgetService$promotionsWidgetApi$2(talabatAPIBuilder, this));
        int i11 = WhenMappings.$EnumSwitchMapping$0[VerticalsEndPointProvider.INSTANCE.getEndpointEnvironment().ordinal()];
        if (i11 == 1) {
            str = "https://verticals-api.talabat.com/api/";
        } else if (i11 == 2) {
            str = "https://verticals-api-qa.dhhmena.com/api/";
        } else if (i11 == 3) {
            str = "http://localhost:8000/";
        } else {
            throw new NoWhenBranchMatchedException();
        }
        this.baseUrl = str;
    }

    private final PromotionsWidgetApi getPromotionsWidgetApi() {
        return (PromotionsWidgetApi) this.promotionsWidgetApi$delegate.getValue();
    }

    @NotNull
    public Call<PromotionsWidgetResponse> getPromotionData(int i11, int i12, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "promotionTag");
        Intrinsics.checkNotNullParameter(str2, "module");
        Intrinsics.checkNotNullParameter(str3, "lat");
        Intrinsics.checkNotNullParameter(str4, "lng");
        return getPromotionsWidgetApi().getPromotionData(i11, i12, str, str2, str3, str4);
    }
}
