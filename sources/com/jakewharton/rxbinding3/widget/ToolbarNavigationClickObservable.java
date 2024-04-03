package com.jakewharton.rxbinding3.widget;

import android.view.View;
import android.widget.Toolbar;
import androidx.annotation.RequiresApi;
import com.jakewharton.rxbinding3.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@RequiresApi(21)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00022\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\bH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/jakewharton/rxbinding3/widget/ToolbarNavigationClickObservable;", "Lio/reactivex/Observable;", "", "view", "Landroid/widget/Toolbar;", "(Landroid/widget/Toolbar;)V", "subscribeActual", "observer", "Lio/reactivex/Observer;", "Listener", "rxbinding_release"}, k = 1, mv = {1, 1, 15})
public final class ToolbarNavigationClickObservable extends Observable<Unit> {
    private final Toolbar view;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u000e\u0010\f\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00050\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0014R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00050\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/jakewharton/rxbinding3/widget/ToolbarNavigationClickObservable$Listener;", "Lio/reactivex/android/MainThreadDisposable;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "v", "", "onClick", "a", "Landroid/widget/Toolbar;", "view", "Landroid/widget/Toolbar;", "Lio/reactivex/Observer;", "observer", "Lio/reactivex/Observer;", "<init>", "(Landroid/widget/Toolbar;Lio/reactivex/Observer;)V", "rxbinding_release"}, k = 1, mv = {1, 4, 0})
    public static final class Listener extends MainThreadDisposable implements View.OnClickListener {
        private final Observer<? super Unit> observer;
        private final Toolbar view;

        public Listener(@NotNull Toolbar toolbar, @NotNull Observer<? super Unit> observer2) {
            Intrinsics.checkParameterIsNotNull(toolbar, "view");
            Intrinsics.checkParameterIsNotNull(observer2, "observer");
            this.view = toolbar;
            this.observer = observer2;
        }

        public void a() {
            this.view.setNavigationOnClickListener((View.OnClickListener) null);
        }

        public void onClick(@NotNull View view2) {
            Intrinsics.checkParameterIsNotNull(view2, "v");
            if (!isDisposed()) {
                this.observer.onNext(Unit.INSTANCE);
            }
        }
    }

    public ToolbarNavigationClickObservable(@NotNull Toolbar toolbar) {
        Intrinsics.checkParameterIsNotNull(toolbar, "view");
        this.view = toolbar;
    }

    public void subscribeActual(@NotNull Observer<? super Unit> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            Listener listener = new Listener(this.view, observer);
            observer.onSubscribe(listener);
            this.view.setNavigationOnClickListener(listener);
        }
    }
}
