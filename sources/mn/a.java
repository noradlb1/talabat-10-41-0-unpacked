package mn;

import android.view.View;
import com.talabat.feature.pharmacy.model.BannerData;
import com.talabat.feature.pharmacy.presentation.ui.fragment.PrescriptionFragment;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PrescriptionFragment f62302b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ BannerData f62303c;

    public /* synthetic */ a(PrescriptionFragment prescriptionFragment, BannerData bannerData) {
        this.f62302b = prescriptionFragment;
        this.f62303c = bannerData;
    }

    public final void onClick(View view) {
        PrescriptionFragment.m10236setOnHavePrescriptionClicked$lambda1(this.f62302b, this.f62303c, view);
    }
}
