package com.talabat.feature.rating.data;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/talabat/feature/rating/data/RatingShown;", "", "()V", "isRatingShown", "", "()Z", "setRatingShown", "(Z)V", "com_talabat_feature_rating_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RatingShown {
    @NotNull
    public static final RatingShown INSTANCE = new RatingShown();
    private static boolean isRatingShown;

    private RatingShown() {
    }

    public final boolean isRatingShown() {
        return isRatingShown;
    }

    public final void setRatingShown(boolean z11) {
        isRatingShown = z11;
    }
}
