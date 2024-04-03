package s9;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.concurrent.Callable;

public final /* synthetic */ class a implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserMetadata f50774b;

    public /* synthetic */ a(UserMetadata userMetadata) {
        this.f50774b = userMetadata;
    }

    public final Object call() {
        return this.f50774b.lambda$setUserId$0();
    }
}
