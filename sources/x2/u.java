package x2;

import bo.app.r1;
import bo.app.z1;
import com.google.android.gms.tasks.OnFailureListener;

public final /* synthetic */ class u implements OnFailureListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ z1 f44441a;

    public /* synthetic */ u(z1 z1Var) {
        this.f44441a = z1Var;
    }

    public final void onFailure(Exception exc) {
        r1.a(this.f44441a, exc);
    }
}
