package ue;

import android.app.DatePickerDialog;
import android.widget.DatePicker;
import com.talabat.RegistrationScreen;
import java.text.SimpleDateFormat;

public final /* synthetic */ class tc implements DatePickerDialog.OnDateSetListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RegistrationScreen f57759b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SimpleDateFormat f57760c;

    public /* synthetic */ tc(RegistrationScreen registrationScreen, SimpleDateFormat simpleDateFormat) {
        this.f57759b = registrationScreen;
        this.f57760c = simpleDateFormat;
    }

    public final void onDateSet(DatePicker datePicker, int i11, int i12, int i13) {
        this.f57759b.lambda$onCreate$2(this.f57760c, datePicker, i11, i12, i13);
    }
}
