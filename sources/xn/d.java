package xn;

import androidx.lifecycle.Observer;
import com.talabat.feature.rating.presentation.ui.RatingCommentFragment;

public final /* synthetic */ class d implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RatingCommentFragment f63023a;

    public /* synthetic */ d(RatingCommentFragment ratingCommentFragment) {
        this.f63023a = ratingCommentFragment;
    }

    public final void onChanged(Object obj) {
        RatingCommentFragment.m10262onViewCreated$lambda3(this.f63023a, (Boolean) obj);
    }
}
