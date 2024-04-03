package sv;

import android.content.DialogInterface;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.DialogUtilKt;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class c implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function0 f24108b;

    public /* synthetic */ c(Function0 function0) {
        this.f24108b = function0;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        DialogUtilKt.m5779showAlertDialog$lambda0(this.f24108b, dialogInterface, i11);
    }
}
