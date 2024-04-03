package com.jakewharton.rxbinding3.widget;

import android.view.MenuItem;
import android.widget.Toolbar;
import androidx.annotation.RequiresApi;
import com.jakewharton.rxbinding3.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@RequiresApi(21)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\tH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/jakewharton/rxbinding3/widget/ToolbarItemClickObservable;", "Lio/reactivex/Observable;", "Landroid/view/MenuItem;", "view", "Landroid/widget/Toolbar;", "(Landroid/widget/Toolbar;)V", "subscribeActual", "", "observer", "Lio/reactivex/Observer;", "Listener", "rxbinding_release"}, k = 1, mv = {1, 1, 15})
final class ToolbarItemClickObservable extends Observable<MenuItem> {
    private final Toolbar view;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u000e\u0010\r\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00030\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0014R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00030\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/jakewharton/rxbinding3/widget/ToolbarItemClickObservable$Listener;", "Lio/reactivex/android/MainThreadDisposable;", "Landroid/widget/Toolbar$OnMenuItemClickListener;", "Landroid/view/MenuItem;", "item", "", "onMenuItemClick", "", "a", "Landroid/widget/Toolbar;", "view", "Landroid/widget/Toolbar;", "Lio/reactivex/Observer;", "observer", "Lio/reactivex/Observer;", "<init>", "(Landroid/widget/Toolbar;Lio/reactivex/Observer;)V", "rxbinding_release"}, k = 1, mv = {1, 4, 0})
    public static final class Listener extends MainThreadDisposable implements Toolbar.OnMenuItemClickListener {
        private final Observer<? super MenuItem> observer;
        private final Toolbar view;

        public Listener(@NotNull Toolbar toolbar, @NotNull Observer<? super MenuItem> observer2) {
            Intrinsics.checkParameterIsNotNull(toolbar, "view");
            Intrinsics.checkParameterIsNotNull(observer2, "observer");
            this.view = toolbar;
            this.observer = observer2;
        }

        public void a() {
            this.view.setOnMenuItemClickListener((Toolbar.OnMenuItemClickListener) null);
        }

        public boolean onMenuItemClick(@NotNull MenuItem menuItem) {
            Intrinsics.checkParameterIsNotNull(menuItem, "item");
            if (isDisposed()) {
                return false;
            }
            this.observer.onNext(menuItem);
            return true;
        }
    }

    public ToolbarItemClickObservable(@NotNull Toolbar toolbar) {
        Intrinsics.checkParameterIsNotNull(toolbar, "view");
        this.view = toolbar;
    }

    public void subscribeActual(@NotNull Observer<? super MenuItem> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            Listener listener = new Listener(this.view, observer);
            observer.onSubscribe(listener);
            this.view.setOnMenuItemClickListener(listener);
        }
    }
}
