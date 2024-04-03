package j10;

import JsonModels.Response.AddAddressRM;
import com.android.volley.Response;
import library.talabat.mvp.homemap.HomeMapInteractor;

public final /* synthetic */ class j implements Response.Listener {
    public final void onResponse(Object obj) {
        HomeMapInteractor.m7891onUpdateResponse$lambda9((AddAddressRM) obj);
    }
}
