package wu;

import android.content.DialogInterface;
import com.talabat.splash.presentation.infrastructure.device.PresentationUtils;

public final /* synthetic */ class b implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PresentationUtils f63014b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PresentationUtils.OnAlertListener f63015c;

    public /* synthetic */ b(PresentationUtils presentationUtils, PresentationUtils.OnAlertListener onAlertListener) {
        this.f63014b = presentationUtils;
        this.f63015c = onAlertListener;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        PresentationUtils.m10911onForceUpdatePopup$lambda1(this.f63014b, this.f63015c, dialogInterface, i11);
    }
}
