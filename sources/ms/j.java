package ms;

import com.apptimize.Apptimize;
import com.talabat.integration.IntegrationsKt;
import io.reactivex.subjects.SingleSubject;

public final /* synthetic */ class j implements Apptimize.OnApptimizeInitializedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SingleSubject f62342a;

    public /* synthetic */ j(SingleSubject singleSubject) {
        this.f62342a = singleSubject;
    }

    public final void onApptimizeInitialized() {
        IntegrationsKt.m10672initializeApptimize$lambda6$lambda5(this.f62342a);
    }
}
