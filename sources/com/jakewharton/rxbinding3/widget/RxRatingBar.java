package com.jakewharton.rxbinding3.widget;

import android.widget.RatingBar;
import androidx.annotation.CheckResult;
import com.jakewharton.rxbinding3.InitialValueObservable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"com/jakewharton/rxbinding3/widget/RxRatingBar__RatingBarRatingChangeEventObservableKt", "com/jakewharton/rxbinding3/widget/RxRatingBar__RatingBarRatingChangeObservableKt"}, k = 4, mv = {1, 1, 15})
public final class RxRatingBar {
    @CheckResult
    @NotNull
    public static final InitialValueObservable<RatingBarChangeEvent> ratingChangeEvents(@NotNull RatingBar ratingBar) {
        return RxRatingBar__RatingBarRatingChangeEventObservableKt.ratingChangeEvents(ratingBar);
    }

    @CheckResult
    @NotNull
    public static final InitialValueObservable<Float> ratingChanges(@NotNull RatingBar ratingBar) {
        return RxRatingBar__RatingBarRatingChangeObservableKt.ratingChanges(ratingBar);
    }
}
