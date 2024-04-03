package x00;

import JsonModels.AreaPreoloadResponse;
import com.android.volley.Response;
import com.talabat.helpers.GlobalDataModel;

public final /* synthetic */ class l implements Response.Listener {
    public final void onResponse(Object obj) {
        GlobalDataModel.areas = ((AreaPreoloadResponse) obj).result;
    }
}
