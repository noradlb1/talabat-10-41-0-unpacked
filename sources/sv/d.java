package sv;

import android.content.DialogInterface;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.DialogUtilKt;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class d implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function0 f24109b;

    public /* synthetic */ d(Function0 function0) {
        this.f24109b = function0;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        DialogUtilKt.m5780showAlertDialog$lambda1(this.f24109b, dialogInterface, i11);
    }
}
