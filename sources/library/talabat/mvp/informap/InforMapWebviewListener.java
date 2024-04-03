package library.talabat.mvp.informap;

import JsonModels.Response.InforMapAddressResponse;
import library.talabat.mvp.IGlobalListener;

public interface InforMapWebviewListener extends IGlobalListener {
    void convertAddressFailed();

    void convertAddressReceived(InforMapAddressResponse inforMapAddressResponse);
}
