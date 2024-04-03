package ch;

import com.huawei.hmf.tasks.OnFailureListener;
import com.talabat.core.hms.location.data.LocationResponseTaskWrapper;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class c implements OnFailureListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f50928a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocationResponseTaskWrapper f50929b;

    public /* synthetic */ c(Function1 function1, LocationResponseTaskWrapper locationResponseTaskWrapper) {
        this.f50928a = function1;
        this.f50929b = locationResponseTaskWrapper;
    }

    public final void onFailure(Exception exc) {
        LocationResponseTaskWrapper.m9609addOnFailureListener$lambda1(this.f50928a, this.f50929b, exc);
    }
}
