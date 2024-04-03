package com.jakewharton.rxbinding3.widget;

import android.view.View;
import android.widget.AdapterView;
import com.jakewharton.rxbinding3.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0011\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\tH\u0014R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/jakewharton/rxbinding3/widget/AdapterViewItemClickObservable;", "Lio/reactivex/Observable;", "", "view", "Landroid/widget/AdapterView;", "(Landroid/widget/AdapterView;)V", "subscribeActual", "", "observer", "Lio/reactivex/Observer;", "Listener", "rxbinding_release"}, k = 1, mv = {1, 1, 15})
final class AdapterViewItemClickObservable extends Observable<Integer> {
    private final AdapterView<?> view;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00070\u000f¢\u0006\u0004\b\u0012\u0010\u0013J.\u0010\f\u001a\u00020\u000b2\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0014R\u0018\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000eR\u001c\u0010\u0010\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00070\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/jakewharton/rxbinding3/widget/AdapterViewItemClickObservable$Listener;", "Lio/reactivex/android/MainThreadDisposable;", "Landroid/widget/AdapterView$OnItemClickListener;", "Landroid/widget/AdapterView;", "adapterView", "Landroid/view/View;", "view", "", "position", "", "id", "", "onItemClick", "a", "Landroid/widget/AdapterView;", "Lio/reactivex/Observer;", "observer", "Lio/reactivex/Observer;", "<init>", "(Landroid/widget/AdapterView;Lio/reactivex/Observer;)V", "rxbinding_release"}, k = 1, mv = {1, 4, 0})
    public static final class Listener extends MainThreadDisposable implements AdapterView.OnItemClickListener {
        private final Observer<? super Integer> observer;
        private final AdapterView<?> view;

        public Listener(@NotNull AdapterView<?> adapterView, @NotNull Observer<? super Integer> observer2) {
            Intrinsics.checkParameterIsNotNull(adapterView, "view");
            Intrinsics.checkParameterIsNotNull(observer2, "observer");
            this.view = adapterView;
            this.observer = observer2;
        }

        public void a() {
            this.view.setOnItemClickListener((AdapterView.OnItemClickListener) null);
        }

        public void onItemClick(@NotNull AdapterView<?> adapterView, @Nullable View view2, int i11, long j11) {
            Intrinsics.checkParameterIsNotNull(adapterView, "adapterView");
            if (!isDisposed()) {
                this.observer.onNext(Integer.valueOf(i11));
            }
        }
    }

    public AdapterViewItemClickObservable(@NotNull AdapterView<?> adapterView) {
        Intrinsics.checkParameterIsNotNull(adapterView, "view");
        this.view = adapterView;
    }

    public void subscribeActual(@NotNull Observer<? super Integer> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            Listener listener = new Listener(this.view, observer);
            observer.onSubscribe(listener);
            this.view.setOnItemClickListener(listener);
        }
    }
}
