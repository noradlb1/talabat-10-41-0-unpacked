package com.talabat.feature.rating.presentation.ui;

import com.talabat.feature.rating.domain.model.RatingReasonsData;
import com.talabat.feature.rating.presentation.RatingViewHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class RatingReasonsAdapter$onBindViewHolder$1$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ RatingReasonsAdapter f58723g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ RatingViewHolder f58724h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ RatingReasonsData f58725i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RatingReasonsAdapter$onBindViewHolder$1$1(RatingReasonsAdapter ratingReasonsAdapter, RatingViewHolder ratingViewHolder, RatingReasonsData ratingReasonsData) {
        super(0);
        this.f58723g = ratingReasonsAdapter;
        this.f58724h = ratingViewHolder;
        this.f58725i = ratingReasonsData;
    }

    public final void invoke() {
        RatingReasonClickListener ratingReasonClickListener = this.f58723g.getRatingReasonClickListener();
        int adapterPosition = this.f58724h.getAdapterPosition();
        RatingReasonsData ratingReasonsData = this.f58725i;
        Intrinsics.checkNotNullExpressionValue(ratingReasonsData, "ratingReasonItem");
        ratingReasonClickListener.onRatingReasonClick(adapterPosition, ratingReasonsData);
        ((RatingReasonsData) this.f58723g.getCurrentList().get(this.f58724h.getAdapterPosition())).setSelected(!this.f58725i.isSelected());
        this.f58723g.notifyItemChanged(this.f58724h.getAdapterPosition(), this.f58725i);
    }
}
