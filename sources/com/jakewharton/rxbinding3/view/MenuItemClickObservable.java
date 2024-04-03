package com.jakewharton.rxbinding3.view;

import android.view.MenuItem;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.jakewharton.rxbinding3.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\u00022\u000e\u0010\n\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u000bH\u0014R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/jakewharton/rxbinding3/view/MenuItemClickObservable;", "Lio/reactivex/Observable;", "", "menuItem", "Landroid/view/MenuItem;", "handled", "Lkotlin/Function1;", "", "(Landroid/view/MenuItem;Lkotlin/jvm/functions/Function1;)V", "subscribeActual", "observer", "Lio/reactivex/Observer;", "Listener", "rxbinding_release"}, k = 1, mv = {1, 1, 15})
final class MenuItemClickObservable extends Observable<Unit> {
    private final Function1<MenuItem, Boolean> handled;
    private final MenuItem menuItem;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u000b\u0012\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00070\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0014R\u0014\u0010\t\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00070\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/jakewharton/rxbinding3/view/MenuItemClickObservable$Listener;", "Lio/reactivex/android/MainThreadDisposable;", "Landroid/view/MenuItem$OnMenuItemClickListener;", "Landroid/view/MenuItem;", "item", "", "onMenuItemClick", "", "a", "menuItem", "Landroid/view/MenuItem;", "Lkotlin/Function1;", "handled", "Lkotlin/jvm/functions/Function1;", "Lio/reactivex/Observer;", "observer", "Lio/reactivex/Observer;", "<init>", "(Landroid/view/MenuItem;Lkotlin/jvm/functions/Function1;Lio/reactivex/Observer;)V", "rxbinding_release"}, k = 1, mv = {1, 4, 0})
    public static final class Listener extends MainThreadDisposable implements MenuItem.OnMenuItemClickListener {
        private final Function1<MenuItem, Boolean> handled;
        private final MenuItem menuItem;
        private final Observer<? super Unit> observer;

        public Listener(@NotNull MenuItem menuItem2, @NotNull Function1<? super MenuItem, Boolean> function1, @NotNull Observer<? super Unit> observer2) {
            Intrinsics.checkParameterIsNotNull(menuItem2, "menuItem");
            Intrinsics.checkParameterIsNotNull(function1, InstabugDbContract.CrashEntry.COLUMN_HANDLED);
            Intrinsics.checkParameterIsNotNull(observer2, "observer");
            this.menuItem = menuItem2;
            this.handled = function1;
            this.observer = observer2;
        }

        public void a() {
            this.menuItem.setOnMenuItemClickListener((MenuItem.OnMenuItemClickListener) null);
        }

        public boolean onMenuItemClick(@NotNull MenuItem menuItem2) {
            Intrinsics.checkParameterIsNotNull(menuItem2, "item");
            if (isDisposed()) {
                return false;
            }
            try {
                if (!this.handled.invoke(this.menuItem).booleanValue()) {
                    return false;
                }
                this.observer.onNext(Unit.INSTANCE);
                return true;
            } catch (Exception e11) {
                this.observer.onError(e11);
                dispose();
                return false;
            }
        }
    }

    public MenuItemClickObservable(@NotNull MenuItem menuItem2, @NotNull Function1<? super MenuItem, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(menuItem2, "menuItem");
        Intrinsics.checkParameterIsNotNull(function1, InstabugDbContract.CrashEntry.COLUMN_HANDLED);
        this.menuItem = menuItem2;
        this.handled = function1;
    }

    public void subscribeActual(@NotNull Observer<? super Unit> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            Listener listener = new Listener(this.menuItem, this.handled, observer);
            observer.onSubscribe(listener);
            this.menuItem.setOnMenuItemClickListener(listener);
        }
    }
}
