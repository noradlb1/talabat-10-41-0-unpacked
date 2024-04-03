package v4;

import android.app.AlertDialog;
import android.content.DialogInterface;
import com.deliveryhero.chatui.view.util.DialogUtils;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class a implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function0 f34734b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f34735c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AlertDialog f34736d;

    public /* synthetic */ a(Function0 function0, boolean z11, AlertDialog alertDialog) {
        this.f34734b = function0;
        this.f34735c = z11;
        this.f34736d = alertDialog;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        DialogUtils.m8172showDialog$lambda0(this.f34734b, this.f34735c, this.f34736d, dialogInterface, i11);
    }
}
