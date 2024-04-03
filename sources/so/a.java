package so;

import android.view.View;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingInfoWidgetModel;
import com.talabat.feature.tpro.presentation.benefits.view.AverageInfoOnboardingCard;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AverageInfoOnboardingCard f62891b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TProOnBoardingInfoWidgetModel f62892c;

    public /* synthetic */ a(AverageInfoOnboardingCard averageInfoOnboardingCard, TProOnBoardingInfoWidgetModel tProOnBoardingInfoWidgetModel) {
        this.f62891b = averageInfoOnboardingCard;
        this.f62892c = tProOnBoardingInfoWidgetModel;
    }

    public final void onClick(View view) {
        AverageInfoOnboardingCard.m10365buildContent$lambda1(this.f62891b, this.f62892c, view);
    }
}
