package wg;

import com.google.android.gms.tasks.OnSuccessListener;
import com.talabat.core.gms.location.data.GmsTaskWrapper;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class a implements OnSuccessListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f57954a;

    public /* synthetic */ a(Function1 function1) {
        this.f57954a = function1;
    }

    public final void onSuccess(Object obj) {
        GmsTaskWrapper.m9594addOnSuccessListener$lambda0(this.f57954a, obj);
    }
}
