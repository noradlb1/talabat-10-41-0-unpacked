package mn;

import android.view.View;
import com.talabat.feature.pharmacy.model.BannerData;
import com.talabat.feature.pharmacy.presentation.ui.fragment.PrescriptionFragment;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PrescriptionFragment f62306b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ BannerData f62307c;

    public /* synthetic */ c(PrescriptionFragment prescriptionFragment, BannerData bannerData) {
        this.f62306b = prescriptionFragment;
        this.f62307c = bannerData;
    }

    public final void onClick(View view) {
        PrescriptionFragment.m10238setOnTrackOrderDetailsClicked$lambda4(this.f62306b, this.f62307c, view);
    }
}
