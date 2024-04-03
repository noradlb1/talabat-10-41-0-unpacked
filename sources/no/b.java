package no;

import android.view.View;
import com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimDisplayModel;
import com.talabat.feature.tmart.growth.presentation.widget.views.TMartGrowthReminderView;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f62351b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TMartGrowthClaimDisplayModel.Reminder f62352c;

    public /* synthetic */ b(Function1 function1, TMartGrowthClaimDisplayModel.Reminder reminder) {
        this.f62351b = function1;
        this.f62352c = reminder;
    }

    public final void onClick(View view) {
        TMartGrowthReminderView.m10349setup$lambda2$lambda1(this.f62351b, this.f62352c, view);
    }
}
