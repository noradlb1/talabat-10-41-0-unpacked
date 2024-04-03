package oq;

import JsonModels.GemRejectResponse;
import com.talabat.gem.adapters.data.GemAcceptanceDataSources;
import io.reactivex.functions.Function;

public final /* synthetic */ class b implements Function {
    public final Object apply(Object obj) {
        return GemAcceptanceDataSources.m10503requestGemOfferRejection$lambda2((GemRejectResponse) obj);
    }
}
