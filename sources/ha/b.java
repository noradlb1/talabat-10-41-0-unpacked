package ha;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.perf.config.RemoteConfigManager;

public final /* synthetic */ class b implements OnSuccessListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RemoteConfigManager f50639a;

    public /* synthetic */ b(RemoteConfigManager remoteConfigManager) {
        this.f50639a = remoteConfigManager;
    }

    public final void onSuccess(Object obj) {
        this.f50639a.lambda$triggerFirebaseRemoteConfigFetchAndActivateOnSuccessfulFetch$0((Boolean) obj);
    }
}
