package com.talabat.feature.rating.presentation.ui;

import android.widget.TextView;
import com.talabat.feature.rating.presentation.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class RatingDeliveryReasonFragment$onViewCreated$2 extends Lambda implements Function1<Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ RatingDeliveryReasonFragment f58708g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RatingDeliveryReasonFragment$onViewCreated$2(RatingDeliveryReasonFragment ratingDeliveryReasonFragment) {
        super(1);
        this.f58708g = ratingDeliveryReasonFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i11) {
        this.f58708g.getRatingReasonAdapter().submitList(this.f58708g.getRatingFeedBackViewModel().getDeliveryReasonList(i11));
        this.f58708g.getRatingFeedBackViewModel().setSelectedDeliveryRating(i11);
        ((TextView) this.f58708g._$_findCachedViewById(R.id.tvReasonRatingTitle)).setText(this.f58708g.getRatingFeedBackViewModel().getRatingReasonTitle(i11));
        ((TextView) this.f58708g._$_findCachedViewById(R.id.tvReasonRatingMessage)).setText(this.f58708g.getRatingFeedBackViewModel().getRatingReasonMessage(i11));
    }
}
