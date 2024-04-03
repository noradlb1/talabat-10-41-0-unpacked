package zq;

import com.google.android.gms.maps.GoogleMap;
import com.talabat.gms.maps.data.GoogleFrameworkMap;
import com.talabat.maps.domain.FrameworkMap;

public final /* synthetic */ class d implements GoogleMap.OnCameraMoveCanceledListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FrameworkMap.OnCameraMoveCanceledListener f63095a;

    public /* synthetic */ d(FrameworkMap.OnCameraMoveCanceledListener onCameraMoveCanceledListener) {
        this.f63095a = onCameraMoveCanceledListener;
    }

    public final void onCameraMoveCanceled() {
        GoogleFrameworkMap.m10591setOnCameraMoveCanceledListener$lambda2(this.f63095a);
    }
}
