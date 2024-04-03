package com.jakewharton.rxbinding3.widget;

import android.view.MenuItem;
import android.widget.PopupMenu;
import com.jakewharton.rxbinding3.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\tH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/jakewharton/rxbinding3/widget/PopupMenuItemClickObservable;", "Lio/reactivex/Observable;", "Landroid/view/MenuItem;", "view", "Landroid/widget/PopupMenu;", "(Landroid/widget/PopupMenu;)V", "subscribeActual", "", "observer", "Lio/reactivex/Observer;", "Listener", "rxbinding_release"}, k = 1, mv = {1, 1, 15})
final class PopupMenuItemClickObservable extends Observable<MenuItem> {
    private final PopupMenu view;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u000e\u0010\r\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00030\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0014R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00030\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/jakewharton/rxbinding3/widget/PopupMenuItemClickObservable$Listener;", "Lio/reactivex/android/MainThreadDisposable;", "Landroid/widget/PopupMenu$OnMenuItemClickListener;", "Landroid/view/MenuItem;", "menuItem", "", "onMenuItemClick", "", "a", "Landroid/widget/PopupMenu;", "view", "Landroid/widget/PopupMenu;", "Lio/reactivex/Observer;", "observer", "Lio/reactivex/Observer;", "<init>", "(Landroid/widget/PopupMenu;Lio/reactivex/Observer;)V", "rxbinding_release"}, k = 1, mv = {1, 4, 0})
    public static final class Listener extends MainThreadDisposable implements PopupMenu.OnMenuItemClickListener {
        private final Observer<? super MenuItem> observer;
        private final PopupMenu view;

        public Listener(@NotNull PopupMenu popupMenu, @NotNull Observer<? super MenuItem> observer2) {
            Intrinsics.checkParameterIsNotNull(popupMenu, "view");
            Intrinsics.checkParameterIsNotNull(observer2, "observer");
            this.view = popupMenu;
            this.observer = observer2;
        }

        public void a() {
            this.view.setOnMenuItemClickListener((PopupMenu.OnMenuItemClickListener) null);
        }

        public boolean onMenuItemClick(@NotNull MenuItem menuItem) {
            Intrinsics.checkParameterIsNotNull(menuItem, "menuItem");
            if (isDisposed()) {
                return false;
            }
            this.observer.onNext(menuItem);
            return true;
        }
    }

    public PopupMenuItemClickObservable(@NotNull PopupMenu popupMenu) {
        Intrinsics.checkParameterIsNotNull(popupMenu, "view");
        this.view = popupMenu;
    }

    public void subscribeActual(@NotNull Observer<? super MenuItem> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            Listener listener = new Listener(this.view, observer);
            this.view.setOnMenuItemClickListener(listener);
            observer.onSubscribe(listener);
        }
    }
}
