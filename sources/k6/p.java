package k6;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;

public final /* synthetic */ class p implements GraphRequest.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GraphRequest.GraphJSONObjectCallback f34516a;

    public /* synthetic */ p(GraphRequest.GraphJSONObjectCallback graphJSONObjectCallback) {
        this.f34516a = graphJSONObjectCallback;
    }

    public final void onCompleted(GraphResponse graphResponse) {
        GraphRequest.Companion.m8871newMeRequest$lambda0(this.f34516a, graphResponse);
    }
}
