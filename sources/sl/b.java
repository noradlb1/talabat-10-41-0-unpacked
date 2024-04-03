package sl;

import android.view.View;
import com.talabat.feature.customervouchersswimlane.presentation.adapter.VouchersListSwimLaneViewHolder;
import com.talabat.features.swimlanevoucherslist.domain.model.CustomerVoucher;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VouchersListSwimLaneViewHolder f62887b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CustomerVoucher f62888c;

    public /* synthetic */ b(VouchersListSwimLaneViewHolder vouchersListSwimLaneViewHolder, CustomerVoucher customerVoucher) {
        this.f62887b = vouchersListSwimLaneViewHolder;
        this.f62888c = customerVoucher;
    }

    public final void onClick(View view) {
        VouchersListSwimLaneViewHolder.m10147bind$lambda1$lambda0(this.f62887b, this.f62888c, view);
    }
}
