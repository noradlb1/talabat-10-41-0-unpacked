package com.jakewharton.rxbinding3.widget;

import android.widget.TextView;
import androidx.annotation.CheckResult;
import com.jakewharton.rxbinding3.InitialValueObservable;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"com/jakewharton/rxbinding3/widget/RxTextView__TextViewAfterTextChangeEventObservableKt", "com/jakewharton/rxbinding3/widget/RxTextView__TextViewBeforeTextChangeEventObservableKt", "com/jakewharton/rxbinding3/widget/RxTextView__TextViewEditorActionEventObservableKt", "com/jakewharton/rxbinding3/widget/RxTextView__TextViewEditorActionObservableKt", "com/jakewharton/rxbinding3/widget/RxTextView__TextViewTextChangeEventObservableKt", "com/jakewharton/rxbinding3/widget/RxTextView__TextViewTextChangesObservableKt"}, k = 4, mv = {1, 1, 15})
public final class RxTextView {
    @CheckResult
    @NotNull
    public static final InitialValueObservable<TextViewAfterTextChangeEvent> afterTextChangeEvents(@NotNull TextView textView) {
        return RxTextView__TextViewAfterTextChangeEventObservableKt.afterTextChangeEvents(textView);
    }

    @CheckResult
    @NotNull
    public static final InitialValueObservable<TextViewBeforeTextChangeEvent> beforeTextChangeEvents(@NotNull TextView textView) {
        return RxTextView__TextViewBeforeTextChangeEventObservableKt.beforeTextChangeEvents(textView);
    }

    @CheckResult
    @NotNull
    @JvmOverloads
    public static final Observable<TextViewEditorActionEvent> editorActionEvents(@NotNull TextView textView) {
        return RxTextView__TextViewEditorActionEventObservableKt.editorActionEvents$default(textView, (Function1) null, 1, (Object) null);
    }

    @CheckResult
    @NotNull
    @JvmOverloads
    public static final Observable<TextViewEditorActionEvent> editorActionEvents(@NotNull TextView textView, @NotNull Function1<? super TextViewEditorActionEvent, Boolean> function1) {
        return RxTextView__TextViewEditorActionEventObservableKt.editorActionEvents(textView, function1);
    }

    @CheckResult
    @NotNull
    @JvmOverloads
    public static final Observable<Integer> editorActions(@NotNull TextView textView) {
        return RxTextView__TextViewEditorActionObservableKt.editorActions$default(textView, (Function1) null, 1, (Object) null);
    }

    @CheckResult
    @NotNull
    @JvmOverloads
    public static final Observable<Integer> editorActions(@NotNull TextView textView, @NotNull Function1<? super Integer, Boolean> function1) {
        return RxTextView__TextViewEditorActionObservableKt.editorActions(textView, function1);
    }

    @CheckResult
    @NotNull
    public static final InitialValueObservable<TextViewTextChangeEvent> textChangeEvents(@NotNull TextView textView) {
        return RxTextView__TextViewTextChangeEventObservableKt.textChangeEvents(textView);
    }

    @CheckResult
    @NotNull
    public static final InitialValueObservable<CharSequence> textChanges(@NotNull TextView textView) {
        return RxTextView__TextViewTextChangesObservableKt.textChanges(textView);
    }
}
