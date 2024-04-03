package u00;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.tasks.TasksKt;

public final /* synthetic */ class a implements OnCompleteListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CompletableDeferred f28208b;

    public /* synthetic */ a(CompletableDeferred completableDeferred) {
        this.f28208b = completableDeferred;
    }

    public final void onComplete(Task task) {
        TasksKt.m7865asDeferredImpl$lambda0(this.f28208b, task);
    }
}
