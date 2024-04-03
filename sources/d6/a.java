package d6;

import com.designsystem.ds_input_field.DateFieldComposablesKt;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class a implements MaterialPickerOnPositiveButtonClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f34413a;

    public /* synthetic */ a(Function1 function1) {
        this.f34413a = function1;
    }

    public final void onPositiveButtonClick(Object obj) {
        DateFieldComposablesKt.m8405showMaterialDatePicker$lambda20$lambda18(this.f34413a, (Long) obj);
    }
}
