package ha;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.perf.config.RemoteConfigManager;

public final /* synthetic */ class c implements OnFailureListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RemoteConfigManager f50640a;

    public /* synthetic */ c(RemoteConfigManager remoteConfigManager) {
        this.f50640a = remoteConfigManager;
    }

    public final void onFailure(Exception exc) {
        this.f50640a.lambda$triggerFirebaseRemoteConfigFetchAndActivateOnSuccessfulFetch$1(exc);
    }
}
