package o3;

import android.location.Location;
import com.baseflow.geolocator.location.PositionChangedCallback;
import com.google.android.gms.tasks.OnSuccessListener;

public final /* synthetic */ class b implements OnSuccessListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PositionChangedCallback f44381a;

    public /* synthetic */ b(PositionChangedCallback positionChangedCallback) {
        this.f44381a = positionChangedCallback;
    }

    public final void onSuccess(Object obj) {
        this.f44381a.onPositionChanged((Location) obj);
    }
}
