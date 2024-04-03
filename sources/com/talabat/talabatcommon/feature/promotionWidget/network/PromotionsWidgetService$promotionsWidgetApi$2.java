package com.talabat.talabatcommon.feature.promotionWidget.network;

import com.talabat.core.network.network.TalabatAPIBuilder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/talabatcommon/feature/promotionWidget/network/PromotionsWidgetApi;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class PromotionsWidgetService$promotionsWidgetApi$2 extends Lambda implements Function0<PromotionsWidgetApi> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TalabatAPIBuilder f61559g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ PromotionsWidgetService f61560h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PromotionsWidgetService$promotionsWidgetApi$2(TalabatAPIBuilder talabatAPIBuilder, PromotionsWidgetService promotionsWidgetService) {
        super(0);
        this.f61559g = talabatAPIBuilder;
        this.f61560h = promotionsWidgetService;
    }

    @NotNull
    public final PromotionsWidgetApi invoke() {
        return (PromotionsWidgetApi) this.f61559g.createApi(this.f61560h.baseUrl, PromotionsWidgetApi.class);
    }
}
