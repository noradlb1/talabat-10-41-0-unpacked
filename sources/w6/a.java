package w6;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.internal.instrument.ExceptionAnalyzer;
import com.facebook.internal.instrument.InstrumentData;

public final /* synthetic */ class a implements GraphRequest.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InstrumentData f34774a;

    public /* synthetic */ a(InstrumentData instrumentData) {
        this.f34774a = instrumentData;
    }

    public final void onCompleted(GraphResponse graphResponse) {
        ExceptionAnalyzer.m8970sendExceptionAnalysisReports$lambda1(this.f34774a, graphResponse);
    }
}
