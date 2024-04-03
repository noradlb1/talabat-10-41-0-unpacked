package mp;

import android.view.View;
import androidx.constraintlayout.widget.Group;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingCardModel;
import com.talabat.feature.tpro.presentation.benefits.view.learnmore.OnBoardingCardLearnMoreView;
import com.talabat.feature.tpro.presentation.databinding.ProOnboardingButtonBinding;
import com.talabat.feature.tpro.presentation.util.LearnMoreUtil;
import kotlin.jvm.functions.Function2;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OnBoardingCardLearnMoreView f62311b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TProOnBoardingCardModel f62312c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Function2 f62313d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Group f62314e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ ProOnboardingButtonBinding f62315f;

    public /* synthetic */ a(OnBoardingCardLearnMoreView onBoardingCardLearnMoreView, TProOnBoardingCardModel tProOnBoardingCardModel, Function2 function2, Group group, ProOnboardingButtonBinding proOnboardingButtonBinding) {
        this.f62311b = onBoardingCardLearnMoreView;
        this.f62312c = tProOnBoardingCardModel;
        this.f62313d = function2;
        this.f62314e = group;
        this.f62315f = proOnboardingButtonBinding;
    }

    public final void onClick(View view) {
        LearnMoreUtil.m10428applyClickListener$lambda0(this.f62311b, this.f62312c, this.f62313d, this.f62314e, this.f62315f, view);
    }
}
