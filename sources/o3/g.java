package o3;

import android.location.OnNmeaMessageListener;
import com.baseflow.geolocator.location.NmeaClient;

public final /* synthetic */ class g implements OnNmeaMessageListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NmeaClient f44382a;

    public /* synthetic */ g(NmeaClient nmeaClient) {
        this.f44382a = nmeaClient;
    }

    public final void onNmeaMessage(String str, long j11) {
        this.f44382a.lambda$new$0(str, j11);
    }
}
