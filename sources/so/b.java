package so;

import android.view.View;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingExpandableWidgetModel;
import com.talabat.feature.tpro.presentation.benefits.view.ExpandableOnboardingCard;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExpandableOnboardingCard f62893b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TProOnBoardingExpandableWidgetModel f62894c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Function2 f62895d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Function0 f62896e;

    public /* synthetic */ b(ExpandableOnboardingCard expandableOnboardingCard, TProOnBoardingExpandableWidgetModel tProOnBoardingExpandableWidgetModel, Function2 function2, Function0 function0) {
        this.f62893b = expandableOnboardingCard;
        this.f62894c = tProOnBoardingExpandableWidgetModel;
        this.f62895d = function2;
        this.f62896e = function0;
    }

    public final void onClick(View view) {
        ExpandableOnboardingCard.m10366handleExpandableList$lambda1(this.f62893b, this.f62894c, this.f62895d, this.f62896e, view);
    }
}
