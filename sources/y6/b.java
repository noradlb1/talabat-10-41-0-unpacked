package y6;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.internal.instrument.crashreport.CrashHandler;
import java.util.List;

public final /* synthetic */ class b implements GraphRequest.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f34839a;

    public /* synthetic */ b(List list) {
        this.f34839a = list;
    }

    public final void onCompleted(GraphResponse graphResponse) {
        CrashHandler.Companion.m8981sendExceptionReports$lambda5(this.f34839a, graphResponse);
    }
}
