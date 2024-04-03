package xn;

import android.view.View;
import com.talabat.feature.rating.presentation.ui.RatingCommentFragment;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f63020b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RatingCommentFragment f63021c;

    public /* synthetic */ b(String str, RatingCommentFragment ratingCommentFragment) {
        this.f63020b = str;
        this.f63021c = ratingCommentFragment;
    }

    public final void onClick(View view) {
        RatingCommentFragment.m10260onViewCreated$lambda1(this.f63020b, this.f63021c, view);
    }
}
