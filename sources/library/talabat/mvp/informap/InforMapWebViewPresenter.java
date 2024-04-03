package library.talabat.mvp.informap;

import JsonModels.Request.InforMapRequest;
import JsonModels.Response.InforMapAddressResponse;
import JsonModels.Response.InforMapResult;
import android.util.Log;
import com.android.volley.VolleyError;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.helpers.GlobalDataModel;
import tracking.AppTracker;

public class InforMapWebViewPresenter implements IInforMapPresenter, InforMapWebviewListener {
    private InforMapInetractor inforMapInetractor;
    private InforMapWebView inforMapWebView;

    public InforMapWebViewPresenter(AppVersionProvider appVersionProvider, InforMapWebView inforMapWebView2) {
        this.inforMapWebView = inforMapWebView2;
        this.inforMapInetractor = new InforMapInetractor(appVersionProvider, this);
    }

    public void convertAddressFailed() {
        this.inforMapWebView.infoMapConvertedAddressFailed();
    }

    public void convertAddressReceived(InforMapAddressResponse inforMapAddressResponse) {
        if (inforMapAddressResponse.result.statusCode == 0) {
            AppTracker.onMcdMapResultReturned(this.inforMapWebView.getContext(), false);
            this.inforMapWebView.infoMapConvertedAddressReceived(inforMapAddressResponse);
            return;
        }
        AppTracker.onMcdMapResultReturned(this.inforMapWebView.getContext(), true);
        InforMapWebView inforMapWebView2 = this.inforMapWebView;
        InforMapResult inforMapResult = inforMapAddressResponse.result;
        inforMapWebView2.onAreaMismatched(inforMapResult.message, inforMapResult.msgTitle);
    }

    public void informapAddressReceived(String str, boolean z11, int i11, int i12) {
        InforMapRequest inforMapRequest = new InforMapRequest(str, GlobalDataModel.SelectedAreaId, false);
        if (i11 > 0) {
            inforMapRequest.setRestaurantId(i11);
        }
        this.inforMapWebView.showLoadingPopup();
        Log.e("REstaunrant id", "" + i11);
        this.inforMapInetractor.mapInforMapAddressObjectConvertor(z11, i11, inforMapRequest);
    }

    public void onDataError() {
    }

    public void onDestroy() {
        this.inforMapWebView = null;
    }

    public void onNetworkError() {
    }

    public void onServerError(VolleyError volleyError) {
    }

    public void onUrlChanged(String str) {
        Log.e("url changed", str);
    }

    public void setUpViews(String str) {
        this.inforMapWebView.setInformMapUrl(str);
    }
}
