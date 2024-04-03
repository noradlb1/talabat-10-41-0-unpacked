package k6;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;

public final /* synthetic */ class q implements GraphRequest.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GraphRequest.GraphJSONArrayCallback f34517a;

    public /* synthetic */ q(GraphRequest.GraphJSONArrayCallback graphJSONArrayCallback) {
        this.f34517a = graphJSONArrayCallback;
    }

    public final void onCompleted(GraphResponse graphResponse) {
        GraphRequest.Companion.m8872newPlacesSearchRequest$lambda1(this.f34517a, graphResponse);
    }
}
