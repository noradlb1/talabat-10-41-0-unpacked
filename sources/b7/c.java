package b7;

import android.content.DialogInterface;
import com.facebook.login.DeviceAuthDialog;

public final /* synthetic */ class c implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DeviceAuthDialog f29328b;

    public /* synthetic */ c(DeviceAuthDialog deviceAuthDialog) {
        this.f29328b = deviceAuthDialog;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        DeviceAuthDialog.m8991presentConfirmation$lambda8(this.f29328b, dialogInterface, i11);
    }
}
