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

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u0003H\u0014R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u00028TX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/jakewharton/rxbinding3/widget/TextViewBeforeTextChangeEventObservable;", "Lcom/jakewharton/rxbinding3/InitialValueObservable;", "Lcom/jakewharton/rxbinding3/widget/TextViewBeforeTextChangeEvent;", "Lio/reactivex/Observer;", "observer", "", "a", "Landroid/widget/TextView;", "view", "Landroid/widget/TextView;", "b", "()Lcom/jakewharton/rxbinding3/widget/TextViewBeforeTextChangeEvent;", "initialValue", "<init>", "(Landroid/widget/TextView;)V", "Listener", "rxbinding_release"}, k = 1, mv = {1, 4, 0})
final class TextViewBeforeTextChangeEventObservable extends InitialValueObservable<TextViewBeforeTextChangeEvent> {
    private final TextView view;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u000e\u0010\u0016\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00150\u0014¢\u0006\u0004\b\u0018\u0010\u0019J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0016J(\u0010\r\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\tH\u0014R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0016\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00150\u00148\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/jakewharton/rxbinding3/widget/TextViewBeforeTextChangeEventObservable$Listener;", "Lio/reactivex/android/MainThreadDisposable;", "Landroid/text/TextWatcher;", "", "s", "", "start", "count", "after", "", "beforeTextChanged", "charSequence", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "a", "Landroid/widget/TextView;", "view", "Landroid/widget/TextView;", "Lio/reactivex/Observer;", "Lcom/jakewharton/rxbinding3/widget/TextViewBeforeTextChangeEvent;", "observer", "Lio/reactivex/Observer;", "<init>", "(Landroid/widget/TextView;Lio/reactivex/Observer;)V", "rxbinding_release"}, k = 1, mv = {1, 4, 0})
    public static final class Listener extends MainThreadDisposable implements TextWatcher {
        private final Observer<? super TextViewBeforeTextChangeEvent> observer;
        private final TextView view;

        public Listener(@NotNull TextView textView, @NotNull Observer<? super TextViewBeforeTextChangeEvent> observer2) {
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
            if (!isDisposed()) {
                this.observer.onNext(new TextViewBeforeTextChangeEvent(this.view, charSequence, i11, i12, i13));
            }
        }

        public void onTextChanged(@NotNull CharSequence charSequence, int i11, int i12, int i13) {
            Intrinsics.checkParameterIsNotNull(charSequence, "charSequence");
        }
    }

    public TextViewBeforeTextChangeEventObservable(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "view");
        this.view = textView;
    }

    public void a(@NotNull Observer<? super TextViewBeforeTextChangeEvent> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        Listener listener = new Listener(this.view, observer);
        observer.onSubscribe(listener);
        this.view.addTextChangedListener(listener);
    }

    @NotNull
    /* renamed from: b */
    public TextViewBeforeTextChangeEvent getInitialValue() {
        TextView textView = this.view;
        CharSequence text = textView.getText();
        Intrinsics.checkExpressionValueIsNotNull(text, "view.text");
        return new TextViewBeforeTextChangeEvent(textView, text, 0, 0, 0);
    }
}
