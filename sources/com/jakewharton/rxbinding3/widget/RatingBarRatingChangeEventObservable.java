package com.jakewharton.rxbinding3.widget;

import android.widget.RatingBar;
import com.jakewharton.rxbinding3.InitialValueObservable;
import com.jakewharton.rxbinding3.internal.Preconditions;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u0003H\u0014R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u00028TX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/jakewharton/rxbinding3/widget/RatingBarRatingChangeEventObservable;", "Lcom/jakewharton/rxbinding3/InitialValueObservable;", "Lcom/jakewharton/rxbinding3/widget/RatingBarChangeEvent;", "Lio/reactivex/Observer;", "observer", "", "a", "Landroid/widget/RatingBar;", "view", "Landroid/widget/RatingBar;", "b", "()Lcom/jakewharton/rxbinding3/widget/RatingBarChangeEvent;", "initialValue", "<init>", "(Landroid/widget/RatingBar;)V", "Listener", "rxbinding_release"}, k = 1, mv = {1, 4, 0})
final class RatingBarRatingChangeEventObservable extends InitialValueObservable<RatingBarChangeEvent> {
    private final RatingBar view;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u000f0\u000e¢\u0006\u0004\b\u0012\u0010\u0013J \u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\tH\u0014R\u0014\u0010\f\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001c\u0010\u0010\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u000f0\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/jakewharton/rxbinding3/widget/RatingBarRatingChangeEventObservable$Listener;", "Lio/reactivex/android/MainThreadDisposable;", "Landroid/widget/RatingBar$OnRatingBarChangeListener;", "Landroid/widget/RatingBar;", "ratingBar", "", "rating", "", "fromUser", "", "onRatingChanged", "a", "view", "Landroid/widget/RatingBar;", "Lio/reactivex/Observer;", "Lcom/jakewharton/rxbinding3/widget/RatingBarChangeEvent;", "observer", "Lio/reactivex/Observer;", "<init>", "(Landroid/widget/RatingBar;Lio/reactivex/Observer;)V", "rxbinding_release"}, k = 1, mv = {1, 4, 0})
    public static final class Listener extends MainThreadDisposable implements RatingBar.OnRatingBarChangeListener {
        private final Observer<? super RatingBarChangeEvent> observer;
        private final RatingBar view;

        public Listener(@NotNull RatingBar ratingBar, @NotNull Observer<? super RatingBarChangeEvent> observer2) {
            Intrinsics.checkParameterIsNotNull(ratingBar, "view");
            Intrinsics.checkParameterIsNotNull(observer2, "observer");
            this.view = ratingBar;
            this.observer = observer2;
        }

        public void a() {
            this.view.setOnRatingBarChangeListener((RatingBar.OnRatingBarChangeListener) null);
        }

        public void onRatingChanged(@NotNull RatingBar ratingBar, float f11, boolean z11) {
            Intrinsics.checkParameterIsNotNull(ratingBar, "ratingBar");
            if (!isDisposed()) {
                this.observer.onNext(new RatingBarChangeEvent(ratingBar, f11, z11));
            }
        }
    }

    public RatingBarRatingChangeEventObservable(@NotNull RatingBar ratingBar) {
        Intrinsics.checkParameterIsNotNull(ratingBar, "view");
        this.view = ratingBar;
    }

    public void a(@NotNull Observer<? super RatingBarChangeEvent> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            Listener listener = new Listener(this.view, observer);
            this.view.setOnRatingBarChangeListener(listener);
            observer.onSubscribe(listener);
        }
    }

    @NotNull
    /* renamed from: b */
    public RatingBarChangeEvent getInitialValue() {
        RatingBar ratingBar = this.view;
        return new RatingBarChangeEvent(ratingBar, ratingBar.getRating(), false);
    }
}
