package fa;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FcmBroadcastProcessor;

public final /* synthetic */ class d implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f50622a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Intent f50623b;

    public /* synthetic */ d(Context context, Intent intent) {
        this.f50622a = context;
        this.f50623b = intent;
    }

    public final Object then(Task task) {
        return FcmBroadcastProcessor.lambda$startMessagingService$2(this.f50622a, this.f50623b, task);
    }
}
