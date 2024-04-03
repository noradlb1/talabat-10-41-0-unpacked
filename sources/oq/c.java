package oq;

import JsonModels.GemAcceptResponse;
import com.talabat.gem.adapters.data.GemAcceptanceDataSources;
import io.reactivex.functions.Function;

public final /* synthetic */ class c implements Function {
    public final Object apply(Object obj) {
        return GemAcceptanceDataSources.m10501requestGemOfferAcceptance$lambda0((GemAcceptResponse) obj);
    }
}
