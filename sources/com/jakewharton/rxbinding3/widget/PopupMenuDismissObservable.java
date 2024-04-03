package com.jakewharton.rxbinding3.widget;

import android.widget.PopupMenu;
import com.jakewharton.rxbinding3.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00022\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\bH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/jakewharton/rxbinding3/widget/PopupMenuDismissObservable;", "Lio/reactivex/Observable;", "", "view", "Landroid/widget/PopupMenu;", "(Landroid/widget/PopupMenu;)V", "subscribeActual", "observer", "Lio/reactivex/Observer;", "Listener", "rxbinding_release"}, k = 1, mv = {1, 1, 15})
final class PopupMenuDismissObservable extends Observable<Unit> {
    private final PopupMenu view;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00050\n¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0014R\u0014\u0010\b\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00050\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/jakewharton/rxbinding3/widget/PopupMenuDismissObservable$Listener;", "Lio/reactivex/android/MainThreadDisposable;", "Landroid/widget/PopupMenu$OnDismissListener;", "Landroid/widget/PopupMenu;", "popupMenu", "", "onDismiss", "a", "view", "Landroid/widget/PopupMenu;", "Lio/reactivex/Observer;", "observer", "Lio/reactivex/Observer;", "<init>", "(Landroid/widget/PopupMenu;Lio/reactivex/Observer;)V", "rxbinding_release"}, k = 1, mv = {1, 4, 0})
    public static final class Listener extends MainThreadDisposable implements PopupMenu.OnDismissListener {
        private final Observer<? super Unit> observer;
        private final PopupMenu view;

        public Listener(@NotNull PopupMenu popupMenu, @NotNull Observer<? super Unit> observer2) {
            Intrinsics.checkParameterIsNotNull(popupMenu, "view");
            Intrinsics.checkParameterIsNotNull(observer2, "observer");
            this.view = popupMenu;
            this.observer = observer2;
        }

        public void a() {
            this.view.setOnDismissListener((PopupMenu.OnDismissListener) null);
        }

        public void onDismiss(@NotNull PopupMenu popupMenu) {
            Intrinsics.checkParameterIsNotNull(popupMenu, "popupMenu");
            if (!isDisposed()) {
                this.observer.onNext(Unit.INSTANCE);
            }
        }
    }

    public PopupMenuDismissObservable(@NotNull PopupMenu popupMenu) {
        Intrinsics.checkParameterIsNotNull(popupMenu, "view");
        this.view = popupMenu;
    }

    public void subscribeActual(@NotNull Observer<? super Unit> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            Listener listener = new Listener(this.view, observer);
            this.view.setOnDismissListener(listener);
            observer.onSubscribe(listener);
        }
    }
}
