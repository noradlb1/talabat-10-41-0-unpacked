package tracking.perseus;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.di.ApiContainer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tracking.perseus.TalabatPerseus;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Ltracking/perseus/SendWorker;", "Landroidx/work/Worker;", "appContext", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "doWork", "Landroidx/work/ListenableWorker$Result;", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SendWorker extends Worker {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SendWorker(@NotNull Context context, @NotNull WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics.checkNotNullParameter(context, "appContext");
        Intrinsics.checkNotNullParameter(workerParameters, "workerParams");
    }

    @NotNull
    public ListenableWorker.Result doWork() {
        ApiContainer apiContainer;
        ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        AppVersionProvider appVersionProvider;
        Context applicationContext = getApplicationContext();
        String str = null;
        if (applicationContext instanceof ApiContainer) {
            apiContainer = (ApiContainer) applicationContext;
        } else {
            apiContainer = null;
        }
        if (!(apiContainer == null || (configurationRemoteCoreLibApi = (ConfigurationRemoteCoreLibApi) apiContainer.getFeature(ConfigurationRemoteCoreLibApi.class)) == null || (appVersionProvider = configurationRemoteCoreLibApi.getAppVersionProvider()) == null)) {
            str = appVersionProvider.appVersion();
        }
        if (str == null) {
            str = "";
        }
        TalabatPerseus.Companion companion = TalabatPerseus.Companion;
        Context applicationContext2 = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext2, "this.applicationContext");
        companion.dispatchPerseusEvent(applicationContext2, str, getInputData().getKeyValueMap());
        ListenableWorker.Result success = ListenableWorker.Result.success();
        Intrinsics.checkNotNullExpressionValue(success, "success()");
        return success;
    }
}
