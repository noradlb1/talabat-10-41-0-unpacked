package ch;

import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hms.location.LocationSettingsResponse;
import com.talabat.core.hms.location.data.LocationResponseTaskWrapper;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class d implements OnSuccessListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f50930a;

    public /* synthetic */ d(Function1 function1) {
        this.f50930a = function1;
    }

    public final void onSuccess(Object obj) {
        LocationResponseTaskWrapper.m9610addOnSuccessListener$lambda0(this.f50930a, (LocationSettingsResponse) obj);
    }
}
