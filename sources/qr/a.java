package qr;

import android.view.View;
import com.talabat.growth.ui.vouchers.details.VoucherDetailsFragment;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VoucherDetailsFragment f62832b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f62833c;

    public /* synthetic */ a(VoucherDetailsFragment voucherDetailsFragment, String str) {
        this.f62832b = voucherDetailsFragment;
        this.f62833c = str;
    }

    public final void onClick(View view) {
        VoucherDetailsFragment.m10611handleRedirectionToPartnerButton$lambda13(this.f62832b, this.f62833c, view);
    }
}
