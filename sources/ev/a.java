package ev;

import android.content.DialogInterface;
import com.talabat.talabatcommon.helpers.LocationHelper;

public final /* synthetic */ class a implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocationHelper f62033b;

    public /* synthetic */ a(LocationHelper locationHelper) {
        this.f62033b = locationHelper;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        LocationHelper.m10934showLocationNeededReasonDialog$lambda2(this.f62033b, dialogInterface, i11);
    }
}
