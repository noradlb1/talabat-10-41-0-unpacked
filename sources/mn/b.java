package mn;

import android.view.View;
import com.talabat.feature.pharmacy.model.BannerData;
import com.talabat.feature.pharmacy.presentation.ui.fragment.PrescriptionFragment;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PrescriptionFragment f62304b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ BannerData f62305c;

    public /* synthetic */ b(PrescriptionFragment prescriptionFragment, BannerData bannerData) {
        this.f62304b = prescriptionFragment;
        this.f62305c = bannerData;
    }

    public final void onClick(View view) {
        PrescriptionFragment.m10237setOnHavePrescriptionClicked$lambda2(this.f62304b, this.f62305c, view);
    }
}
