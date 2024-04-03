package v6;

import android.content.DialogInterface;
import com.facebook.internal.WebDialog;

public final /* synthetic */ class s implements DialogInterface.OnCancelListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WebDialog f34765b;

    public /* synthetic */ s(WebDialog webDialog) {
        this.f34765b = webDialog;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        WebDialog.m8965onCreate$lambda4(this.f34765b, dialogInterface);
    }
}
