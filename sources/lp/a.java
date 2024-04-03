package lp;

import android.view.View;
import com.talabat.feature.tpro.presentation.databinding.SidemenuTProSavingsBinding;
import com.talabat.feature.tpro.presentation.savings.account.SideMenuTProSavingsViewHolder;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SidemenuTProSavingsBinding f62253b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SideMenuTProSavingsViewHolder f62254c;

    public /* synthetic */ a(SidemenuTProSavingsBinding sidemenuTProSavingsBinding, SideMenuTProSavingsViewHolder sideMenuTProSavingsViewHolder) {
        this.f62253b = sidemenuTProSavingsBinding;
        this.f62254c = sideMenuTProSavingsViewHolder;
    }

    public final void onClick(View view) {
        SideMenuTProSavingsViewHolder.m10424cancellationPeriodMode$lambda7$lambda5(this.f62253b, this.f62254c, view);
    }
}
