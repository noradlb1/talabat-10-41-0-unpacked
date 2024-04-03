package r9;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.crashlytics.internal.common.SessionReportingCoordinator;

public final /* synthetic */ class k implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SessionReportingCoordinator f50765a;

    public /* synthetic */ k(SessionReportingCoordinator sessionReportingCoordinator) {
        this.f50765a = sessionReportingCoordinator;
    }

    public final Object then(Task task) {
        return Boolean.valueOf(this.f50765a.onReportSendComplete(task));
    }
}
