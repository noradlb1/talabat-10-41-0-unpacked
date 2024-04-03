package d6;

import android.content.DialogInterface;
import com.designsystem.ds_input_field.DateFieldComposablesKt;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class b implements DialogInterface.OnDismissListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function0 f34414b;

    public /* synthetic */ b(Function0 function0) {
        this.f34414b = function0;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        DateFieldComposablesKt.m8406showMaterialDatePicker$lambda20$lambda19(this.f34414b, dialogInterface);
    }
}
