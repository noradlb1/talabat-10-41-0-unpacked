package library.talabat.gemengine;

import JsonModels.GemAcceptResponse;
import JsonModels.GemRejectResponse;
import JsonModels.Response.GEMResponse.GemOfferResponse;
import JsonModels.Response.GEMResponse.GemRestaurant;
import android.net.Uri;
import buisnessmodels.GEMEngine;
import com.android.volley.VolleyError;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;
import datamodels.Gem;
import datamodels.GemOfferItemsModel;
import java.util.ArrayList;

public class GemPresenter implements IGemPresenter, GemListener {
    private IGemInteractor iGemInteractor;

    public GemPresenter(AppVersionProvider appVersionProvider) {
        this.iGemInteractor = new GemInteractor(appVersionProvider, this);
    }

    public void acceptGemOffer(String str, long j11) {
        this.iGemInteractor.acceptGem(str, j11);
    }

    public void getGemOffers(int i11, String str, String str2) {
        this.iGemInteractor.getGemOffers(i11, str, str2);
    }

    public String getGemRestaurantCoverUrl(String str, String str2) {
        if (TalabatUtils.isNullOrEmpty(str)) {
            str = GlobalDataModel.imageBaseUrl;
        }
        if (TalabatUtils.isNullOrEmpty(str2)) {
            return "";
        }
        String encode = Uri.encode(str2);
        return (str + "restaurants/" + encode).replace(" ", "%20");
    }

    public void onAcceptGemReceived(GemAcceptResponse gemAcceptResponse) {
    }

    public void onCancelGemResult(GemRejectResponse gemRejectResponse) {
    }

    public void onDataError() {
    }

    public void onDestroy() {
        IGemInteractor iGemInteractor2 = this.iGemInteractor;
        if (iGemInteractor2 != null) {
            iGemInteractor2.unregister();
        }
        this.iGemInteractor = null;
    }

    public void onGemOfferReceived(GemOfferResponse gemOfferResponse, String str) {
        int i11 = (int) ((gemOfferResponse.remDuration / 1000.0f) / 60.0f);
        GlobalDataModel.GEMCONSTANTS.gemTimer = (double) i11;
        ArrayList arrayList = new ArrayList();
        int i12 = 0;
        Gem[] gemArr = new Gem[0];
        if (GEMEngine.getInstance() != null) {
            GEMEngine.getInstance().setMaxTime((double) (i11 * 60));
            GemOfferItemsModel[] gemOfferItemsModelArr = gemOfferResponse.gemOfferItems;
            if (gemOfferItemsModelArr != null && gemOfferItemsModelArr.length > 0) {
                for (GemOfferItemsModel gemOfferItemsModel : gemOfferItemsModelArr) {
                    arrayList.add(new GemRestaurant(gemOfferItemsModel.status, gemOfferItemsModel.getBranchId(), getGemRestaurantCoverUrl(str, gemOfferItemsModel.imagePath)));
                }
            }
            Gem[] gemArr2 = gemOfferResponse.gemTiers;
            if (gemArr2 != null && gemArr2.length > 0) {
                gemArr = new Gem[gemArr2.length];
                while (true) {
                    Gem[] gemArr3 = gemOfferResponse.gemTiers;
                    if (i12 >= gemArr3.length) {
                        break;
                    }
                    gemArr[i12] = gemArr3[i12];
                    i12++;
                }
            }
            GEMEngine.getInstance().setGemOffer(gemOfferResponse);
            GEMEngine.getInstance().setGems(gemArr);
            GEMEngine.getInstance().setRestaurants(arrayList);
        }
    }

    public void onNetworkError() {
    }

    public void onRejectGemResult(GemRejectResponse gemRejectResponse) {
    }

    public void onServerError(VolleyError volleyError) {
    }

    public void rejectGemOffer(String str) {
        this.iGemInteractor.rejectGem(str);
    }
}
