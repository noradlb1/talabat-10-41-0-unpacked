package library.talabat.mvp.informap;

import JsonModels.Response.InforMapAddressResponse;
import android.content.Context;
import com.talabat.helpers.Talabat;

public interface InforMapWebView extends Talabat {
    void dismissProgressBarOnView();

    Context getContext();

    void infoMapConvertedAddressFailed();

    void infoMapConvertedAddressReceived(InforMapAddressResponse inforMapAddressResponse);

    void onAreaMismatched(String str, String str2);

    void setInformMapUrl(String str);

    void showLoadingPopup();
}
