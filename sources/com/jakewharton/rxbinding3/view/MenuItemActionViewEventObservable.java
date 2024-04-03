package com.jakewharton.rxbinding3.view;

import android.view.MenuItem;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.jakewharton.rxbinding3.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\fH\u0014R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/jakewharton/rxbinding3/view/MenuItemActionViewEventObservable;", "Lio/reactivex/Observable;", "Lcom/jakewharton/rxbinding3/view/MenuItemActionViewEvent;", "menuItem", "Landroid/view/MenuItem;", "handled", "Lkotlin/Function1;", "", "(Landroid/view/MenuItem;Lkotlin/jvm/functions/Function1;)V", "subscribeActual", "", "observer", "Lio/reactivex/Observer;", "Listener", "rxbinding_release"}, k = 1, mv = {1, 1, 15})
final class MenuItemActionViewEventObservable extends Observable<MenuItemActionViewEvent> {
    private final Function1<MenuItemActionViewEvent, Boolean> handled;
    private final MenuItem menuItem;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u000f\u0012\u000e\u0010\u0013\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00030\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0014R\u0014\u0010\r\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00030\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/jakewharton/rxbinding3/view/MenuItemActionViewEventObservable$Listener;", "Lio/reactivex/android/MainThreadDisposable;", "Landroid/view/MenuItem$OnActionExpandListener;", "Lcom/jakewharton/rxbinding3/view/MenuItemActionViewEvent;", "event", "", "onEvent", "Landroid/view/MenuItem;", "item", "onMenuItemActionExpand", "onMenuItemActionCollapse", "", "a", "menuItem", "Landroid/view/MenuItem;", "Lkotlin/Function1;", "handled", "Lkotlin/jvm/functions/Function1;", "Lio/reactivex/Observer;", "observer", "Lio/reactivex/Observer;", "<init>", "(Landroid/view/MenuItem;Lkotlin/jvm/functions/Function1;Lio/reactivex/Observer;)V", "rxbinding_release"}, k = 1, mv = {1, 4, 0})
    public static final class Listener extends MainThreadDisposable implements MenuItem.OnActionExpandListener {
        private final Function1<MenuItemActionViewEvent, Boolean> handled;
        private final MenuItem menuItem;
        private final Observer<? super MenuItemActionViewEvent> observer;

        public Listener(@NotNull MenuItem menuItem2, @NotNull Function1<? super MenuItemActionViewEvent, Boolean> function1, @NotNull Observer<? super MenuItemActionViewEvent> observer2) {
            Intrinsics.checkParameterIsNotNull(menuItem2, "menuItem");
            Intrinsics.checkParameterIsNotNull(function1, InstabugDbContract.CrashEntry.COLUMN_HANDLED);
            Intrinsics.checkParameterIsNotNull(observer2, "observer");
            this.menuItem = menuItem2;
            this.handled = function1;
            this.observer = observer2;
        }

        private final boolean onEvent(MenuItemActionViewEvent menuItemActionViewEvent) {
            if (isDisposed()) {
                return false;
            }
            try {
                if (!this.handled.invoke(menuItemActionViewEvent).booleanValue()) {
                    return false;
                }
                this.observer.onNext(menuItemActionViewEvent);
                return true;
            } catch (Exception e11) {
                this.observer.onError(e11);
                dispose();
                return false;
            }
        }

        public void a() {
            this.menuItem.setOnActionExpandListener((MenuItem.OnActionExpandListener) null);
        }

        public boolean onMenuItemActionCollapse(@NotNull MenuItem menuItem2) {
            Intrinsics.checkParameterIsNotNull(menuItem2, "item");
            return onEvent(new MenuItemActionViewCollapseEvent(menuItem2));
        }

        public boolean onMenuItemActionExpand(@NotNull MenuItem menuItem2) {
            Intrinsics.checkParameterIsNotNull(menuItem2, "item");
            return onEvent(new MenuItemActionViewExpandEvent(menuItem2));
        }
    }

    public MenuItemActionViewEventObservable(@NotNull MenuItem menuItem2, @NotNull Function1<? super MenuItemActionViewEvent, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(menuItem2, "menuItem");
        Intrinsics.checkParameterIsNotNull(function1, InstabugDbContract.CrashEntry.COLUMN_HANDLED);
        this.menuItem = menuItem2;
        this.handled = function1;
    }

    public void subscribeActual(@NotNull Observer<? super MenuItemActionViewEvent> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            Listener listener = new Listener(this.menuItem, this.handled, observer);
            observer.onSubscribe(listener);
            this.menuItem.setOnActionExpandListener(listener);
        }
    }
}
