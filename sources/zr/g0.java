package zr;

import android.content.DialogInterface;
import com.talabat.helpers.UnableToValidateDetailsDialogFactory;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class g0 implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f63108b;

    public /* synthetic */ g0(Function1 function1) {
        this.f63108b = function1;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        UnableToValidateDetailsDialogFactory.m10629createDialog$lambda0(this.f63108b, dialogInterface, i11);
    }
}
