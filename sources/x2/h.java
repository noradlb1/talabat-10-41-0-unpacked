package x2;

import bo.app.k1;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class h implements OnCompleteListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ k1 f44423b;

    public /* synthetic */ h(k1 k1Var) {
        this.f44423b = k1Var;
    }

    public final void onComplete(Task task) {
        k1.a(this.f44423b, task);
    }
}
