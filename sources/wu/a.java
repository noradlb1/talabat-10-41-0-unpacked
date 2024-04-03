package wu;

import android.content.DialogInterface;
import com.talabat.splash.presentation.infrastructure.device.PresentationUtils;

public final /* synthetic */ class a implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PresentationUtils f63012b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PresentationUtils.OnAlertListener f63013c;

    public /* synthetic */ a(PresentationUtils presentationUtils, PresentationUtils.OnAlertListener onAlertListener) {
        this.f63012b = presentationUtils;
        this.f63013c = onAlertListener;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        PresentationUtils.m10910onForceUpdatePopup$lambda0(this.f63012b, this.f63013c, dialogInterface, i11);
    }
}
