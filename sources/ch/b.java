package ch;

import com.huawei.hmf.tasks.OnSuccessListener;
import com.talabat.core.hms.location.data.HmsTaskWrapper;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class b implements OnSuccessListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f50927a;

    public /* synthetic */ b(Function1 function1) {
        this.f50927a = function1;
    }

    public final void onSuccess(Object obj) {
        HmsTaskWrapper.m9608addOnSuccessListener$lambda0(this.f50927a, obj);
    }
}
