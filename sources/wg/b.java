package wg;

import com.google.android.gms.tasks.OnFailureListener;
import com.talabat.core.gms.location.data.GmsTaskWrapper;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class b implements OnFailureListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f57955a;

    public /* synthetic */ b(Function1 function1) {
        this.f57955a = function1;
    }

    public final void onFailure(Exception exc) {
        GmsTaskWrapper.m9593addOnFailureListener$lambda1(this.f57955a, exc);
    }
}
