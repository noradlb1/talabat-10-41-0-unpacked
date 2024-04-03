package o4;

import android.view.View;
import com.deliveryhero.chatui.domain.imageselection.UploadImageConfirmationDialog;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UploadImageConfirmationDialog.SendListener f34598b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ UploadImageConfirmationDialog f34599c;

    public /* synthetic */ a(UploadImageConfirmationDialog.SendListener sendListener, UploadImageConfirmationDialog uploadImageConfirmationDialog) {
        this.f34598b = sendListener;
        this.f34599c = uploadImageConfirmationDialog;
    }

    public final void onClick(View view) {
        UploadImageConfirmationDialog.m8146bind$lambda0(this.f34598b, this.f34599c, view);
    }
}
