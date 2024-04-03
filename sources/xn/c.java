package xn;

import androidx.lifecycle.Observer;
import com.talabat.feature.rating.presentation.ui.RatingCommentFragment;

public final /* synthetic */ class c implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RatingCommentFragment f63022a;

    public /* synthetic */ c(RatingCommentFragment ratingCommentFragment) {
        this.f63022a = ratingCommentFragment;
    }

    public final void onChanged(Object obj) {
        RatingCommentFragment.m10261onViewCreated$lambda2(this.f63022a, (Boolean) obj);
    }
}
