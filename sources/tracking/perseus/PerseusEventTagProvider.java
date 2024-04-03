package tracking.perseus;

import androidx.annotation.Keep;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import com.google.android.gms.tagmanager.CustomTagProvider;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006H\u0016¨\u0006\t"}, d2 = {"Ltracking/perseus/PerseusEventTagProvider;", "Lcom/google/android/gms/tagmanager/CustomTagProvider;", "()V", "execute", "", "eventVariablesMap", "", "", "", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Keep
public final class PerseusEventTagProvider implements CustomTagProvider {
    public void execute(@Nullable Map<String, Object> map) {
        synchronized (this) {
            Data.Builder builder = new Data.Builder();
            Intrinsics.checkNotNull(map);
            Data build = builder.putAll(map).build();
            Intrinsics.checkNotNullExpressionValue(build, "Builder().putAll(eventVariablesMap!!).build()");
            WorkRequest build2 = ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(SendWorker.class).setInputData(build)).setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build())).build();
            Intrinsics.checkNotNullExpressionValue(build2, "Builder(SendWorker::clas…                ).build()");
            WorkManager.getInstance().enqueue((WorkRequest) (OneTimeWorkRequest) build2);
        }
    }
}
