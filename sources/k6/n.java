package k6;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;

public final /* synthetic */ class n implements GraphRequest.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GraphRequest.Callback f34513a;

    public /* synthetic */ n(GraphRequest.Callback callback) {
        this.f34513a = callback;
    }

    public final void onCompleted(GraphResponse graphResponse) {
        GraphRequest.m8870_set_callback_$lambda0(this.f34513a, graphResponse);
    }
}
