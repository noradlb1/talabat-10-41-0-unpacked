package com.jakewharton.rxbinding3.widget;

import android.widget.RatingBar;
import androidx.annotation.CheckResult;
import com.jakewharton.rxbinding3.InitialValueObservable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0007¨\u0006\u0004"}, d2 = {"ratingChanges", "Lcom/jakewharton/rxbinding3/InitialValueObservable;", "", "Landroid/widget/RatingBar;", "rxbinding_release"}, k = 5, mv = {1, 1, 15}, xs = "com/jakewharton/rxbinding3/widget/RxRatingBar")
final /* synthetic */ class RxRatingBar__RatingBarRatingChangeObservableKt {
    @CheckResult
    @NotNull
    public static final InitialValueObservable<Float> ratingChanges(@NotNull RatingBar ratingBar) {
        Intrinsics.checkParameterIsNotNull(ratingBar, "$this$ratingChanges");
        return new RatingBarRatingChangeObservable(ratingBar);
    }
}
