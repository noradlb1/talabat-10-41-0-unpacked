package zz;

import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.util.concurrent.Callable;

public final /* synthetic */ class b implements Callable {
    public final Object call() {
        return FirebaseCrashlytics.getInstance().sendUnsentReports();
    }
}
