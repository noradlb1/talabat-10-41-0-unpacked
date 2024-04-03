package com.jakewharton.rxbinding3.view;

import android.view.KeyEvent;
import android.view.View;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.jakewharton.rxbinding3.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\fH\u0014R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/jakewharton/rxbinding3/view/ViewKeyObservable;", "Lio/reactivex/Observable;", "Landroid/view/KeyEvent;", "view", "Landroid/view/View;", "handled", "Lkotlin/Function1;", "", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "subscribeActual", "", "observer", "Lio/reactivex/Observer;", "Listener", "rxbinding_release"}, k = 1, mv = {1, 1, 15})
final class ViewKeyObservable extends Observable<KeyEvent> {
    private final Function1<KeyEvent, Boolean> handled;
    private final View view;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\u000f\u0012\u000e\u0010\u0013\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00070\u0012¢\u0006\u0004\b\u0015\u0010\u0016J \u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0014R\u0014\u0010\r\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00070\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/jakewharton/rxbinding3/view/ViewKeyObservable$Listener;", "Lio/reactivex/android/MainThreadDisposable;", "Landroid/view/View$OnKeyListener;", "Landroid/view/View;", "v", "", "keyCode", "Landroid/view/KeyEvent;", "event", "", "onKey", "", "a", "view", "Landroid/view/View;", "Lkotlin/Function1;", "handled", "Lkotlin/jvm/functions/Function1;", "Lio/reactivex/Observer;", "observer", "Lio/reactivex/Observer;", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;Lio/reactivex/Observer;)V", "rxbinding_release"}, k = 1, mv = {1, 4, 0})
    public static final class Listener extends MainThreadDisposable implements View.OnKeyListener {
        private final Function1<KeyEvent, Boolean> handled;
        private final Observer<? super KeyEvent> observer;
        private final View view;

        public Listener(@NotNull View view2, @NotNull Function1<? super KeyEvent, Boolean> function1, @NotNull Observer<? super KeyEvent> observer2) {
            Intrinsics.checkParameterIsNotNull(view2, "view");
            Intrinsics.checkParameterIsNotNull(function1, InstabugDbContract.CrashEntry.COLUMN_HANDLED);
            Intrinsics.checkParameterIsNotNull(observer2, "observer");
            this.view = view2;
            this.handled = function1;
            this.observer = observer2;
        }

        public void a() {
            this.view.setOnKeyListener((View.OnKeyListener) null);
        }

        public boolean onKey(@NotNull View view2, int i11, @NotNull KeyEvent keyEvent) {
            Intrinsics.checkParameterIsNotNull(view2, "v");
            Intrinsics.checkParameterIsNotNull(keyEvent, "event");
            if (isDisposed()) {
                return false;
            }
            try {
                if (!this.handled.invoke(keyEvent).booleanValue()) {
                    return false;
                }
                this.observer.onNext(keyEvent);
                return true;
            } catch (Exception e11) {
                this.observer.onError(e11);
                dispose();
                return false;
            }
        }
    }

    public ViewKeyObservable(@NotNull View view2, @NotNull Function1<? super KeyEvent, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(view2, "view");
        Intrinsics.checkParameterIsNotNull(function1, InstabugDbContract.CrashEntry.COLUMN_HANDLED);
        this.view = view2;
        this.handled = function1;
    }

    public void subscribeActual(@NotNull Observer<? super KeyEvent> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            Listener listener = new Listener(this.view, this.handled, observer);
            observer.onSubscribe(listener);
            this.view.setOnKeyListener(listener);
        }
    }
}
