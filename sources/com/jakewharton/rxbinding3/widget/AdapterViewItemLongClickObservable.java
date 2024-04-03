package com.jakewharton.rxbinding3.widget;

import android.view.View;
import android.widget.AdapterView;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.jakewharton.rxbinding3.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u001f\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\fH\u0014R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/jakewharton/rxbinding3/widget/AdapterViewItemLongClickObservable;", "Lio/reactivex/Observable;", "", "view", "Landroid/widget/AdapterView;", "handled", "Lkotlin/Function0;", "", "(Landroid/widget/AdapterView;Lkotlin/jvm/functions/Function0;)V", "subscribeActual", "", "observer", "Lio/reactivex/Observer;", "Listener", "rxbinding_release"}, k = 1, mv = {1, 1, 15})
final class AdapterViewItemLongClickObservable extends Observable<Integer> {
    private final Function0<Boolean> handled;
    private final AdapterView<?> view;

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u000e\u0010\u0011\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00070\u0010\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013¢\u0006\u0004\b\u0016\u0010\u0017J.\u0010\f\u001a\u00020\u000b2\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0014R\u0018\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000fR\u001c\u0010\u0011\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00070\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/jakewharton/rxbinding3/widget/AdapterViewItemLongClickObservable$Listener;", "Lio/reactivex/android/MainThreadDisposable;", "Landroid/widget/AdapterView$OnItemLongClickListener;", "Landroid/widget/AdapterView;", "parent", "Landroid/view/View;", "view", "", "position", "", "id", "", "onItemLongClick", "", "a", "Landroid/widget/AdapterView;", "Lio/reactivex/Observer;", "observer", "Lio/reactivex/Observer;", "Lkotlin/Function0;", "handled", "Lkotlin/jvm/functions/Function0;", "<init>", "(Landroid/widget/AdapterView;Lio/reactivex/Observer;Lkotlin/jvm/functions/Function0;)V", "rxbinding_release"}, k = 1, mv = {1, 4, 0})
    public static final class Listener extends MainThreadDisposable implements AdapterView.OnItemLongClickListener {
        private final Function0<Boolean> handled;
        private final Observer<? super Integer> observer;
        private final AdapterView<?> view;

        public Listener(@NotNull AdapterView<?> adapterView, @NotNull Observer<? super Integer> observer2, @NotNull Function0<Boolean> function0) {
            Intrinsics.checkParameterIsNotNull(adapterView, "view");
            Intrinsics.checkParameterIsNotNull(observer2, "observer");
            Intrinsics.checkParameterIsNotNull(function0, InstabugDbContract.CrashEntry.COLUMN_HANDLED);
            this.view = adapterView;
            this.observer = observer2;
            this.handled = function0;
        }

        public void a() {
            this.view.setOnItemLongClickListener((AdapterView.OnItemLongClickListener) null);
        }

        public boolean onItemLongClick(@NotNull AdapterView<?> adapterView, @Nullable View view2, int i11, long j11) {
            Intrinsics.checkParameterIsNotNull(adapterView, "parent");
            if (isDisposed()) {
                return false;
            }
            try {
                if (!this.handled.invoke().booleanValue()) {
                    return false;
                }
                this.observer.onNext(Integer.valueOf(i11));
                return true;
            } catch (Exception e11) {
                this.observer.onError(e11);
                dispose();
                return false;
            }
        }
    }

    public AdapterViewItemLongClickObservable(@NotNull AdapterView<?> adapterView, @NotNull Function0<Boolean> function0) {
        Intrinsics.checkParameterIsNotNull(adapterView, "view");
        Intrinsics.checkParameterIsNotNull(function0, InstabugDbContract.CrashEntry.COLUMN_HANDLED);
        this.view = adapterView;
        this.handled = function0;
    }

    public void subscribeActual(@NotNull Observer<? super Integer> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            Listener listener = new Listener(this.view, observer, this.handled);
            observer.onSubscribe(listener);
            this.view.setOnItemLongClickListener(listener);
        }
    }
}
