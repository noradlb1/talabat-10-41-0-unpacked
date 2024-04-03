package oq;

import JsonModels.GemRejectResponse;
import com.talabat.gem.adapters.data.GemAcceptanceDataSources;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class a implements Consumer {
    public final void accept(Object obj) {
        GemAcceptanceDataSources.m10502requestGemOfferRejection$lambda1((GemRejectResponse) obj);
    }
}
