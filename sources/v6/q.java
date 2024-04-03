package v6;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.internal.Utility;

public final /* synthetic */ class q implements GraphRequest.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Utility.GraphMeRequestWithCacheCallback f34763a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f34764b;

    public /* synthetic */ q(Utility.GraphMeRequestWithCacheCallback graphMeRequestWithCacheCallback, String str) {
        this.f34763a = graphMeRequestWithCacheCallback;
        this.f34764b = str;
    }

    public final void onCompleted(GraphResponse graphResponse) {
        Utility.m8962getGraphMeRequestWithCacheAsync$lambda3(this.f34763a, this.f34764b, graphResponse);
    }
}
