package o6;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.appevents.codeless.ViewIndexer;

public final /* synthetic */ class g implements GraphRequest.Callback {
    public final void onCompleted(GraphResponse graphResponse) {
        ViewIndexer.Companion.m8910buildAppIndexingRequest$lambda0(graphResponse);
    }
}
