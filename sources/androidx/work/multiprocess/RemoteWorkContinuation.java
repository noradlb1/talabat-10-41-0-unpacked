package androidx.work.multiprocess;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.OneTimeWorkRequest;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;

public abstract class RemoteWorkContinuation {
    @NonNull
    public static RemoteWorkContinuation combine(@NonNull List<RemoteWorkContinuation> list) {
        return list.get(0).a(list);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public abstract RemoteWorkContinuation a(@NonNull List<RemoteWorkContinuation> list);

    @NonNull
    public abstract ListenableFuture<Void> enqueue();

    @NonNull
    public final RemoteWorkContinuation then(@NonNull OneTimeWorkRequest oneTimeWorkRequest) {
        return then((List<OneTimeWorkRequest>) Collections.singletonList(oneTimeWorkRequest));
    }

    @NonNull
    public abstract RemoteWorkContinuation then(@NonNull List<OneTimeWorkRequest> list);
}
