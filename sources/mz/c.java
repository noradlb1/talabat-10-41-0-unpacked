package mz;

import android.graphics.Bitmap;
import com.google.android.gms.maps.GoogleMap;
import com.uxcam.internals.Cdo;

public final /* synthetic */ class c implements GoogleMap.SnapshotReadyCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Cdo.aa f23945a;

    public /* synthetic */ c(Cdo.aa aaVar) {
        this.f23945a = aaVar;
    }

    public final void onSnapshotReady(Bitmap bitmap) {
        this.f23945a.a(bitmap);
    }
}
