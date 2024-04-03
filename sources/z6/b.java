package z6;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.internal.instrument.errorreport.ErrorReportHandler;
import java.util.ArrayList;

public final /* synthetic */ class b implements GraphRequest.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArrayList f34854a;

    public /* synthetic */ b(ArrayList arrayList) {
        this.f34854a = arrayList;
    }

    public final void onCompleted(GraphResponse graphResponse) {
        ErrorReportHandler.m8984sendErrorReports$lambda2(this.f34854a, graphResponse);
    }
}
