package x6;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.internal.instrument.anrreport.ANRHandler;
import java.util.List;

public final /* synthetic */ class c implements GraphRequest.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f34827a;

    public /* synthetic */ c(List list) {
        this.f34827a = list;
    }

    public final void onCompleted(GraphResponse graphResponse) {
        ANRHandler.m8979sendANRReports$lambda5(this.f34827a, graphResponse);
    }
}
