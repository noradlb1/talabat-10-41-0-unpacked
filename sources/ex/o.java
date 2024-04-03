package ex;

import android.content.DialogInterface;
import com.talabat.userandlocation.compliance.verification.ui.fragment.UserVerificationFragment;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class o implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f14023b;

    public /* synthetic */ o(Function1 function1) {
        this.f14023b = function1;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        UserVerificationFragment.m5898createDialog$lambda3(this.f14023b, dialogInterface, i11);
    }
}
