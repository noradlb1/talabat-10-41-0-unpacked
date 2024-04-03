package sl;

import android.view.View;
import com.talabat.feature.customervouchersswimlane.presentation.adapter.SingleVouchersSwimLaneViewHolder;
import com.talabat.features.swimlanevoucherslist.domain.model.CustomerVoucher;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SingleVouchersSwimLaneViewHolder f62885b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CustomerVoucher f62886c;

    public /* synthetic */ a(SingleVouchersSwimLaneViewHolder singleVouchersSwimLaneViewHolder, CustomerVoucher customerVoucher) {
        this.f62885b = singleVouchersSwimLaneViewHolder;
        this.f62886c = customerVoucher;
    }

    public final void onClick(View view) {
        SingleVouchersSwimLaneViewHolder.m10146bind$lambda1$lambda0(this.f62885b, this.f62886c, view);
    }
}
