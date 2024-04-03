package wg;

import com.google.android.gms.tasks.OnFailureListener;
import com.talabat.core.gms.location.data.LocationResponseTaskWrapper;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class c implements OnFailureListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f57956a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocationResponseTaskWrapper f57957b;

    public /* synthetic */ c(Function1 function1, LocationResponseTaskWrapper locationResponseTaskWrapper) {
        this.f57956a = function1;
        this.f57957b = locationResponseTaskWrapper;
    }

    public final void onFailure(Exception exc) {
        LocationResponseTaskWrapper.m9595addOnFailureListener$lambda1(this.f57956a, this.f57957b, exc);
    }
}
