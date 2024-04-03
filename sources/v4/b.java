package v4;

import android.content.DialogInterface;
import com.deliveryhero.chatui.view.util.DialogUtils;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class b implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function0 f34737b;

    public /* synthetic */ b(Function0 function0) {
        this.f34737b = function0;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        DialogUtils.m8173showDialog$lambda1(this.f34737b, dialogInterface, i11);
    }
}
