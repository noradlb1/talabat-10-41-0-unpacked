package o4;

import android.view.View;
import com.deliveryhero.chatui.domain.imageselection.UploadImageConfirmationDialog;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UploadImageConfirmationDialog.SendListener f34600b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f34601c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ UploadImageConfirmationDialog f34602d;

    public /* synthetic */ b(UploadImageConfirmationDialog.SendListener sendListener, int i11, UploadImageConfirmationDialog uploadImageConfirmationDialog) {
        this.f34600b = sendListener;
        this.f34601c = i11;
        this.f34602d = uploadImageConfirmationDialog;
    }

    public final void onClick(View view) {
        UploadImageConfirmationDialog.m8147bind$lambda1(this.f34600b, this.f34601c, this.f34602d, view);
    }
}
