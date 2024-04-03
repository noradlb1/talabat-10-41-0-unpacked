package com.talabat.feature.rating.presentation.ui;

import androidx.recyclerview.widget.DiffUtil;
import com.talabat.feature.rating.domain.model.RatingReasonsData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/talabat/feature/rating/presentation/ui/DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/talabat/feature/rating/domain/model/RatingReasonsData;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "com_talabat_feature_rating_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DiffCallback extends DiffUtil.ItemCallback<RatingReasonsData> {
    @NotNull
    public static final DiffCallback INSTANCE = new DiffCallback();

    private DiffCallback() {
    }

    public boolean areContentsTheSame(@NotNull RatingReasonsData ratingReasonsData, @NotNull RatingReasonsData ratingReasonsData2) {
        Intrinsics.checkNotNullParameter(ratingReasonsData, "oldItem");
        Intrinsics.checkNotNullParameter(ratingReasonsData2, "newItem");
        return Intrinsics.areEqual((Object) ratingReasonsData, (Object) ratingReasonsData2);
    }

    public boolean areItemsTheSame(@NotNull RatingReasonsData ratingReasonsData, @NotNull RatingReasonsData ratingReasonsData2) {
        Intrinsics.checkNotNullParameter(ratingReasonsData, "oldItem");
        Intrinsics.checkNotNullParameter(ratingReasonsData2, "newItem");
        return ratingReasonsData.getId() == ratingReasonsData2.getId();
    }
}
