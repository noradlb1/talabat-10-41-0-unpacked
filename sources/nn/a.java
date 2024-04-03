package nn;

import com.talabat.feature.pharmacy.model.BannerData;
import com.talabat.feature.pharmacy.presentation.ui.viewmodel.PrescriptionViewModel;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PrescriptionViewModel f62348b;

    public /* synthetic */ a(PrescriptionViewModel prescriptionViewModel) {
        this.f62348b = prescriptionViewModel;
    }

    public final void accept(Object obj) {
        PrescriptionViewModel.m10239loadPrescriptionInfo$lambda1(this.f62348b, (BannerData) obj);
    }
}
