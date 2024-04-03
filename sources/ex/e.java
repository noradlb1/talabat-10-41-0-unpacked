package ex;

import android.app.DatePickerDialog;
import android.widget.DatePicker;
import com.talabat.userandlocation.compliance.verification.ui.fragment.UserVerificationFragment;
import java.text.SimpleDateFormat;

public final /* synthetic */ class e implements DatePickerDialog.OnDateSetListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserVerificationFragment f14013b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SimpleDateFormat f14014c;

    public /* synthetic */ e(UserVerificationFragment userVerificationFragment, SimpleDateFormat simpleDateFormat) {
        this.f14013b = userVerificationFragment;
        this.f14014c = simpleDateFormat;
    }

    public final void onDateSet(DatePicker datePicker, int i11, int i12, int i13) {
        UserVerificationFragment.m5899initDatePicker$lambda27(this.f14013b, this.f14014c, datePicker, i11, i12, i13);
    }
}
