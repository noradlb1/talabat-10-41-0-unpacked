package lj;

import android.animation.ValueAnimator;
import com.talabat.darkstores.feature.product.views.CampaignProgressView;

public final /* synthetic */ class f implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CampaignProgressView f57013a;

    public /* synthetic */ f(CampaignProgressView campaignProgressView) {
        this.f57013a = campaignProgressView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        CampaignProgressView.m10052animateProgress$lambda4$lambda3(this.f57013a, valueAnimator);
    }
}
