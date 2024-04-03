package com.talabat.restaurants.v2.data.swimlane;

import com.talabat.core.network.network.TalabatAPIBuilder;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001¨\u0006\u0002"}, d2 = {"SwimlaneApiImpl", "Lcom/talabat/restaurants/v2/data/swimlane/SwimlaneApi;", "com_talabat_talabat_talabat"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class SwimlaneApiImplKt {
    @NotNull
    public static final SwimlaneApi SwimlaneApiImpl() {
        return (SwimlaneApi) new TalabatAPIBuilder().createApi(SwimlaneUrlConstants.INSTANCE.getBaseUrl(), SwimlaneApi.class);
    }
}
