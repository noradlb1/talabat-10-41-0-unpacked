package fa;

import android.content.Intent;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.EnhancedIntentService;

public final /* synthetic */ class b implements OnCompleteListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EnhancedIntentService f50618b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Intent f50619c;

    public /* synthetic */ b(EnhancedIntentService enhancedIntentService, Intent intent) {
        this.f50618b = enhancedIntentService;
        this.f50619c = intent;
    }

    public final void onComplete(Task task) {
        this.f50618b.lambda$onStartCommand$1(this.f50619c, task);
    }
}
