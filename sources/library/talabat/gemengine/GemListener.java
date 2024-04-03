package library.talabat.gemengine;

import JsonModels.GemAcceptResponse;
import JsonModels.GemRejectResponse;
import JsonModels.Response.GEMResponse.GemOfferResponse;
import library.talabat.mvp.IGlobalListener;

public interface GemListener extends IGlobalListener {
    void onAcceptGemReceived(GemAcceptResponse gemAcceptResponse);

    void onCancelGemResult(GemRejectResponse gemRejectResponse);

    void onGemOfferReceived(GemOfferResponse gemOfferResponse, String str);

    void onRejectGemResult(GemRejectResponse gemRejectResponse);
}
