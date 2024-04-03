package n6;

import com.facebook.GraphRequest;
import com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformerWebRequests;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GraphRequest f34597b;

    public /* synthetic */ b(GraphRequest graphRequest) {
        this.f34597b = graphRequest;
    }

    public final void run() {
        AppEventsConversionsAPITransformerWebRequests.m8902transformGraphRequestAndSendToCAPIGEndPoint$lambda0(this.f34597b);
    }
}
