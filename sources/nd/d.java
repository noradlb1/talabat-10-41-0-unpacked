package nd;

import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import com.instabug.library.ui.custom.InstabugAlertDialog;

public final /* synthetic */ class d implements DialogInterface.OnShowListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InstabugAlertDialog.Builder f57056a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AlertDialog f57057b;

    public /* synthetic */ d(InstabugAlertDialog.Builder builder, AlertDialog alertDialog) {
        this.f57056a = builder;
        this.f57057b = alertDialog;
    }

    public final void onShow(DialogInterface dialogInterface) {
        this.f57056a.lambda$show$2(this.f57057b, dialogInterface);
    }
}
