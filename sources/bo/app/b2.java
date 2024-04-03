package bo.app;

import android.app.Activity;
import bo.app.a4;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\u0002H&J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH&J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH&J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H&J\b\u0010\u000f\u001a\u00020\u0002H&J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H&J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H&J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\tH&J\b\u0010\u0017\u001a\u00020\u0002H&J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH&J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aH&J\u001e\u0010\f\u001a\u00020\u00022\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010 \u001a\u00020\u001fH&J\"\u0010\f\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001f2\b\b\u0002\u0010$\u001a\u00020#H&R\u001c\u0010%\u001a\u00020\u000b8&@&X¦\u000e¢\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b\u000f\u0010'R\u001c\u0010)\u001a\u00020\u000b8&@&X¦\u000e¢\u0006\f\u001a\u0004\b(\u0010&\"\u0004\b\f\u0010'R\u0016\u0010+\u001a\u0004\u0018\u00010\u001d8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010*ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006,À\u0006\u0001"}, d2 = {"Lbo/app/b2;", "", "", "d", "Landroid/app/Activity;", "activity", "openSession", "closeSession", "e", "Lbo/app/x1;", "event", "", "a", "", "throwable", "b", "Lbo/app/a4$a;", "respondWithBuilder", "Lbo/app/c2;", "request", "Lbo/app/a2;", "location", "geofenceEvent", "refreshFeatureFlags", "Lbo/app/x5;", "templatedTriggeredAction", "Lbo/app/w2;", "triggerEvent", "", "", "deviceLogs", "", "creationTime", "lastCardUpdatedAt", "lastFullSyncAt", "", "retryCount", "isOutboundNetworkRequestsOffline", "()Z", "(Z)V", "c", "shouldRequestTriggersInNextRequest", "()Ljava/lang/String;", "userId", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public interface b2 {
    String a();

    void a(long j11, long j12, int i11);

    void a(a2 a2Var);

    void a(a4.a aVar);

    void a(c2 c2Var);

    void a(w2 w2Var);

    void a(x5 x5Var, w2 w2Var);

    void a(Throwable th2);

    void a(List<String> list, long j11);

    void a(boolean z11);

    boolean a(x1 x1Var);

    void b();

    void b(x1 x1Var);

    void b(Throwable th2);

    void b(boolean z11);

    boolean c();

    void closeSession(Activity activity);

    void d();

    void e();

    void openSession(Activity activity);

    void refreshFeatureFlags();
}
