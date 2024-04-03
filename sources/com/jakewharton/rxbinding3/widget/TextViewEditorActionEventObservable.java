package com.jakewharton.rxbinding3.widget;

import android.view.KeyEvent;
import android.widget.TextView;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.jakewharton.rxbinding3.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\fH\u0014R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/jakewharton/rxbinding3/widget/TextViewEditorActionEventObservable;", "Lio/reactivex/Observable;", "Lcom/jakewharton/rxbinding3/widget/TextViewEditorActionEvent;", "view", "Landroid/widget/TextView;", "handled", "Lkotlin/Function1;", "", "(Landroid/widget/TextView;Lkotlin/jvm/functions/Function1;)V", "subscribeActual", "", "observer", "Lio/reactivex/Observer;", "Listener", "rxbinding_release"}, k = 1, mv = {1, 1, 15})
final class TextViewEditorActionEventObservable extends Observable<TextViewEditorActionEvent> {
    private final Function1<TextViewEditorActionEvent, Boolean> handled;
    private final TextView view;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u000e\u0010\u0011\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00100\u000f\u0012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\t0\u0013¢\u0006\u0004\b\u0016\u0010\u0017J\"\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0014R\u0014\u0010\r\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001c\u0010\u0011\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00100\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R \u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\t0\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/jakewharton/rxbinding3/widget/TextViewEditorActionEventObservable$Listener;", "Lio/reactivex/android/MainThreadDisposable;", "Landroid/widget/TextView$OnEditorActionListener;", "Landroid/widget/TextView;", "textView", "", "actionId", "Landroid/view/KeyEvent;", "keyEvent", "", "onEditorAction", "", "a", "view", "Landroid/widget/TextView;", "Lio/reactivex/Observer;", "Lcom/jakewharton/rxbinding3/widget/TextViewEditorActionEvent;", "observer", "Lio/reactivex/Observer;", "Lkotlin/Function1;", "handled", "Lkotlin/jvm/functions/Function1;", "<init>", "(Landroid/widget/TextView;Lio/reactivex/Observer;Lkotlin/jvm/functions/Function1;)V", "rxbinding_release"}, k = 1, mv = {1, 4, 0})
    public static final class Listener extends MainThreadDisposable implements TextView.OnEditorActionListener {
        private final Function1<TextViewEditorActionEvent, Boolean> handled;
        private final Observer<? super TextViewEditorActionEvent> observer;
        private final TextView view;

        public Listener(@NotNull TextView textView, @NotNull Observer<? super TextViewEditorActionEvent> observer2, @NotNull Function1<? super TextViewEditorActionEvent, Boolean> function1) {
            Intrinsics.checkParameterIsNotNull(textView, "view");
            Intrinsics.checkParameterIsNotNull(observer2, "observer");
            Intrinsics.checkParameterIsNotNull(function1, InstabugDbContract.CrashEntry.COLUMN_HANDLED);
            this.view = textView;
            this.observer = observer2;
            this.handled = function1;
        }

        public void a() {
            this.view.setOnEditorActionListener((TextView.OnEditorActionListener) null);
        }

        public boolean onEditorAction(@NotNull TextView textView, int i11, @Nullable KeyEvent keyEvent) {
            Intrinsics.checkParameterIsNotNull(textView, "textView");
            TextViewEditorActionEvent textViewEditorActionEvent = new TextViewEditorActionEvent(this.view, i11, keyEvent);
            try {
                if (isDisposed() || !this.handled.invoke(textViewEditorActionEvent).booleanValue()) {
                    return false;
                }
                this.observer.onNext(textViewEditorActionEvent);
                return true;
            } catch (Exception e11) {
                this.observer.onError(e11);
                dispose();
                return false;
            }
        }
    }

    public TextViewEditorActionEventObservable(@NotNull TextView textView, @NotNull Function1<? super TextViewEditorActionEvent, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(textView, "view");
        Intrinsics.checkParameterIsNotNull(function1, InstabugDbContract.CrashEntry.COLUMN_HANDLED);
        this.view = textView;
        this.handled = function1;
    }

    public void subscribeActual(@NotNull Observer<? super TextViewEditorActionEvent> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            Listener listener = new Listener(this.view, observer, this.handled);
            observer.onSubscribe(listener);
            this.view.setOnEditorActionListener(listener);
        }
    }
}
