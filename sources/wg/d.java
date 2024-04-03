package wg;

import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.tasks.OnSuccessListener;
import com.talabat.core.gms.location.data.LocationResponseTaskWrapper;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class d implements OnSuccessListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f57958a;

    public /* synthetic */ d(Function1 function1) {
        this.f57958a = function1;
    }

    public final void onSuccess(Object obj) {
        LocationResponseTaskWrapper.m9596addOnSuccessListener$lambda0(this.f57958a, (LocationSettingsResponse) obj);
    }
}
