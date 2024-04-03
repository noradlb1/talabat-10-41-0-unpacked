package ce;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.instabug.survey.a;
import com.instabug.survey.utils.e;

public final /* synthetic */ class c implements OnCompleteListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f50922b;

    public /* synthetic */ c(a aVar) {
        this.f50922b = aVar;
    }

    public final void onComplete(Task task) {
        e.a(this.f50922b, task);
    }
}
