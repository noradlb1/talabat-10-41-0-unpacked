package n6;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.appevents.cloudbridge.AppEventsCAPIManager;

public final /* synthetic */ class a implements GraphRequest.Callback {
    public final void onCompleted(GraphResponse graphResponse) {
        AppEventsCAPIManager.m8901enable$lambda0(graphResponse);
    }
}
