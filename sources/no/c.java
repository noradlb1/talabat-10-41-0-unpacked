package no;

import android.view.View;
import com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimDisplayModel;
import com.talabat.feature.tmart.growth.presentation.widget.views.TmartGrowthClaimedView;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f62353b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TMartGrowthClaimDisplayModel.Claimed f62354c;

    public /* synthetic */ c(Function1 function1, TMartGrowthClaimDisplayModel.Claimed claimed) {
        this.f62353b = function1;
        this.f62354c = claimed;
    }

    public final void onClick(View view) {
        TmartGrowthClaimedView.m10350setup$lambda1$lambda0(this.f62353b, this.f62354c, view);
    }
}
