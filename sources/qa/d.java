package qa;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.internal.ConfigCacheClient;
import com.google.firebase.remoteconfig.internal.ConfigContainer;

public final /* synthetic */ class d implements SuccessContinuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConfigCacheClient f50723a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f50724b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ConfigContainer f50725c;

    public /* synthetic */ d(ConfigCacheClient configCacheClient, boolean z11, ConfigContainer configContainer) {
        this.f50723a = configCacheClient;
        this.f50724b = z11;
        this.f50725c = configContainer;
    }

    public final Task then(Object obj) {
        return this.f50723a.lambda$put$1(this.f50724b, this.f50725c, (Void) obj);
    }
}
