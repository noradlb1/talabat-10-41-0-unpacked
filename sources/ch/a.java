package ch;

import com.huawei.hmf.tasks.OnFailureListener;
import com.talabat.core.hms.location.data.HmsTaskWrapper;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class a implements OnFailureListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f50926a;

    public /* synthetic */ a(Function1 function1) {
        this.f50926a = function1;
    }

    public final void onFailure(Exception exc) {
        HmsTaskWrapper.m9607addOnFailureListener$lambda1(this.f50926a, exc);
    }
}
