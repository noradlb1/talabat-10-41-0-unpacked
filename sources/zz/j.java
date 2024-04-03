package zz;

import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.util.concurrent.Callable;

public final /* synthetic */ class j implements Callable {
    public final Object call() {
        return FirebaseCrashlytics.getInstance().deleteUnsentReports();
    }
}
