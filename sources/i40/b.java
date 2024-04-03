package i40;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import tracking.gtm.TalabatFirebase;

public final /* synthetic */ class b implements OnCompleteListener {
    public final void onComplete(Task task) {
        TalabatFirebase.Companion.m10951sendToFirebase$lambda2(task);
    }
}
