package com.talabat.feature.rating.presentation.ui;

import android.view.ViewGroup;
import androidx.recyclerview.widget.ListAdapter;
import com.talabat.feature.rating.domain.model.RatingReasonsData;
import com.talabat.feature.rating.presentation.RatingViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\rH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/talabat/feature/rating/presentation/ui/RatingReasonsAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/talabat/feature/rating/domain/model/RatingReasonsData;", "Lcom/talabat/feature/rating/presentation/RatingViewHolder;", "ratingReasonClickListener", "Lcom/talabat/feature/rating/presentation/ui/RatingReasonClickListener;", "(Lcom/talabat/feature/rating/presentation/ui/RatingReasonClickListener;)V", "getRatingReasonClickListener", "()Lcom/talabat/feature/rating/presentation/ui/RatingReasonClickListener;", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "com_talabat_feature_rating_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RatingReasonsAdapter extends ListAdapter<RatingReasonsData, RatingViewHolder> {
    @NotNull
    private final RatingReasonClickListener ratingReasonClickListener;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RatingReasonsAdapter(@NotNull RatingReasonClickListener ratingReasonClickListener2) {
        super(DiffCallback.INSTANCE);
        Intrinsics.checkNotNullParameter(ratingReasonClickListener2, "ratingReasonClickListener");
        this.ratingReasonClickListener = ratingReasonClickListener2;
    }

    @NotNull
    public final RatingReasonClickListener getRatingReasonClickListener() {
        return this.ratingReasonClickListener;
    }

    public void onBindViewHolder(@NotNull RatingViewHolder ratingViewHolder, int i11) {
        Intrinsics.checkNotNullParameter(ratingViewHolder, "holder");
        RatingReasonsData ratingReasonsData = (RatingReasonsData) getItem(ratingViewHolder.getAdapterPosition());
        Intrinsics.checkNotNullExpressionValue(ratingReasonsData, "ratingReasonItem");
        ratingViewHolder.populate(ratingReasonsData);
        ratingViewHolder.setOnClickListener(new RatingReasonsAdapter$onBindViewHolder$1$1(this, ratingViewHolder, ratingReasonsData));
    }

    @NotNull
    public RatingViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        return new RatingViewHolder(viewGroup);
    }
}
