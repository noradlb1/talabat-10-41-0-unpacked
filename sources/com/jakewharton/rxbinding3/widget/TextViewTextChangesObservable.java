package com.jakewharton.rxbinding3.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.jakewharton.rxbinding3.InitialValueObservable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u0003H\u0014R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001c\u0010\r\u001a\n \n*\u0004\u0018\u00010\u00020\u00028TX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/jakewharton/rxbinding3/widget/TextViewTextChangesObservable;", "Lcom/jakewharton/rxbinding3/InitialValueObservable;", "", "Lio/reactivex/Observer;", "observer", "", "a", "Landroid/widget/TextView;", "view", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "b", "()Ljava/lang/CharSequence;", "initialValue", "<init>", "(Landroid/widget/TextView;)V", "Listener", "rxbinding_release"}, k = 1, mv = {1, 4, 0})
final class TextViewTextChangesObservable extends InitialValueObservable<CharSequence> {
    private final TextView view;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u000e\u0010\u0014\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00030\u0013¢\u0006\u0004\b\u0016\u0010\u0017J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0016J(\u0010\f\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0014R\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00030\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/jakewharton/rxbinding3/widget/TextViewTextChangesObservable$Listener;", "Lio/reactivex/android/MainThreadDisposable;", "Landroid/text/TextWatcher;", "", "s", "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "a", "Landroid/widget/TextView;", "view", "Landroid/widget/TextView;", "Lio/reactivex/Observer;", "observer", "Lio/reactivex/Observer;", "<init>", "(Landroid/widget/TextView;Lio/reactivex/Observer;)V", "rxbinding_release"}, k = 1, mv = {1, 4, 0})
    public static final class Listener extends MainThreadDisposable implements TextWatcher {
        private final Observer<? super CharSequence> observer;
        private final TextView view;

        public Listener(@NotNull TextView textView, @NotNull Observer<? super CharSequence> observer2) {
            Intrinsics.checkParameterIsNotNull(textView, "view");
            Intrinsics.checkParameterIsNotNull(observer2, "observer");
            this.view = textView;
            this.observer = observer2;
        }

        public void a() {
            this.view.removeTextChangedListener(this);
        }

        public void afterTextChanged(@NotNull Editable editable) {
            Intrinsics.checkParameterIsNotNull(editable, "s");
        }

        public void beforeTextChanged(@NotNull CharSequence charSequence, int i11, int i12, int i13) {
            Intrinsics.checkParameterIsNotNull(charSequence, "s");
        }

        public void onTextChanged(@NotNull CharSequence charSequence, int i11, int i12, int i13) {
            Intrinsics.checkParameterIsNotNull(charSequence, "s");
            if (!isDisposed()) {
                this.observer.onNext(charSequence);
            }
        }
    }

    public TextViewTextChangesObservable(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "view");
        this.view = textView;
    }

    public void a(@NotNull Observer<? super CharSequence> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        Listener listener = new Listener(this.view, observer);
        observer.onSubscribe(listener);
        this.view.addTextChangedListener(listener);
    }

    /* renamed from: b */
    public CharSequence getInitialValue() {
        return this.view.getText();
    }
}
