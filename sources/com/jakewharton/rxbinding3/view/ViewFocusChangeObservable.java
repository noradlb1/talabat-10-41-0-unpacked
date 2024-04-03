package com.jakewharton.rxbinding3.view;

import android.view.View;
import com.jakewharton.rxbinding3.InitialValueObservable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u0003H\u0014R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u00028TX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/jakewharton/rxbinding3/view/ViewFocusChangeObservable;", "Lcom/jakewharton/rxbinding3/InitialValueObservable;", "", "Lio/reactivex/Observer;", "observer", "", "a", "Landroid/view/View;", "view", "Landroid/view/View;", "b", "()Ljava/lang/Boolean;", "initialValue", "<init>", "(Landroid/view/View;)V", "Listener", "rxbinding_release"}, k = 1, mv = {1, 4, 0})
final class ViewFocusChangeObservable extends InitialValueObservable<Boolean> {
    private final View view;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u000e\u0010\r\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00050\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0014R\u0014\u0010\n\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00050\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/jakewharton/rxbinding3/view/ViewFocusChangeObservable$Listener;", "Lio/reactivex/android/MainThreadDisposable;", "Landroid/view/View$OnFocusChangeListener;", "Landroid/view/View;", "v", "", "hasFocus", "", "onFocusChange", "a", "view", "Landroid/view/View;", "Lio/reactivex/Observer;", "observer", "Lio/reactivex/Observer;", "<init>", "(Landroid/view/View;Lio/reactivex/Observer;)V", "rxbinding_release"}, k = 1, mv = {1, 4, 0})
    public static final class Listener extends MainThreadDisposable implements View.OnFocusChangeListener {
        private final Observer<? super Boolean> observer;
        private final View view;

        public Listener(@NotNull View view2, @NotNull Observer<? super Boolean> observer2) {
            Intrinsics.checkParameterIsNotNull(view2, "view");
            Intrinsics.checkParameterIsNotNull(observer2, "observer");
            this.view = view2;
            this.observer = observer2;
        }

        public void a() {
            this.view.setOnFocusChangeListener((View.OnFocusChangeListener) null);
        }

        public void onFocusChange(@NotNull View view2, boolean z11) {
            Intrinsics.checkParameterIsNotNull(view2, "v");
            if (!isDisposed()) {
                this.observer.onNext(Boolean.valueOf(z11));
            }
        }
    }

    public ViewFocusChangeObservable(@NotNull View view2) {
        Intrinsics.checkParameterIsNotNull(view2, "view");
        this.view = view2;
    }

    public void a(@NotNull Observer<? super Boolean> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        Listener listener = new Listener(this.view, observer);
        observer.onSubscribe(listener);
        this.view.setOnFocusChangeListener(listener);
    }

    @NotNull
    /* renamed from: b */
    public Boolean getInitialValue() {
        return Boolean.valueOf(this.view.hasFocus());
    }
}
