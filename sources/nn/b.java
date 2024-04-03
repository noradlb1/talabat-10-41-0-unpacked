package nn;

import com.talabat.feature.pharmacy.presentation.ui.viewmodel.PrescriptionViewModel;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class b implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PrescriptionViewModel f62349b;

    public /* synthetic */ b(PrescriptionViewModel prescriptionViewModel) {
        this.f62349b = prescriptionViewModel;
    }

    public final void accept(Object obj) {
        PrescriptionViewModel.m10240loadPrescriptionInfo$lambda2(this.f62349b, (Throwable) obj);
    }
}
