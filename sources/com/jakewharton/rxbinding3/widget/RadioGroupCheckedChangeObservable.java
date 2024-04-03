package com.jakewharton.rxbinding3.widget;

import android.widget.RadioGroup;
import com.jakewharton.rxbinding3.InitialValueObservable;
import com.jakewharton.rxbinding3.internal.Preconditions;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u0003H\u0014R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u00028TX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/jakewharton/rxbinding3/widget/RadioGroupCheckedChangeObservable;", "Lcom/jakewharton/rxbinding3/InitialValueObservable;", "", "Lio/reactivex/Observer;", "observer", "", "a", "Landroid/widget/RadioGroup;", "view", "Landroid/widget/RadioGroup;", "b", "()Ljava/lang/Integer;", "initialValue", "<init>", "(Landroid/widget/RadioGroup;)V", "Listener", "rxbinding_release"}, k = 1, mv = {1, 4, 0})
final class RadioGroupCheckedChangeObservable extends InitialValueObservable<Integer> {
    private final RadioGroup view;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00050\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0014R\u0016\u0010\n\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00050\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/jakewharton/rxbinding3/widget/RadioGroupCheckedChangeObservable$Listener;", "Lio/reactivex/android/MainThreadDisposable;", "Landroid/widget/RadioGroup$OnCheckedChangeListener;", "Landroid/widget/RadioGroup;", "radioGroup", "", "checkedId", "", "onCheckedChanged", "a", "lastChecked", "I", "view", "Landroid/widget/RadioGroup;", "Lio/reactivex/Observer;", "observer", "Lio/reactivex/Observer;", "<init>", "(Landroid/widget/RadioGroup;Lio/reactivex/Observer;)V", "rxbinding_release"}, k = 1, mv = {1, 4, 0})
    public static final class Listener extends MainThreadDisposable implements RadioGroup.OnCheckedChangeListener {
        private int lastChecked = -1;
        private final Observer<? super Integer> observer;
        private final RadioGroup view;

        public Listener(@NotNull RadioGroup radioGroup, @NotNull Observer<? super Integer> observer2) {
            Intrinsics.checkParameterIsNotNull(radioGroup, "view");
            Intrinsics.checkParameterIsNotNull(observer2, "observer");
            this.view = radioGroup;
            this.observer = observer2;
        }

        public void a() {
            this.view.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) null);
        }

        public void onCheckedChanged(@NotNull RadioGroup radioGroup, int i11) {
            Intrinsics.checkParameterIsNotNull(radioGroup, "radioGroup");
            if (!isDisposed() && i11 != this.lastChecked) {
                this.lastChecked = i11;
                this.observer.onNext(Integer.valueOf(i11));
            }
        }
    }

    public RadioGroupCheckedChangeObservable(@NotNull RadioGroup radioGroup) {
        Intrinsics.checkParameterIsNotNull(radioGroup, "view");
        this.view = radioGroup;
    }

    public void a(@NotNull Observer<? super Integer> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            Listener listener = new Listener(this.view, observer);
            this.view.setOnCheckedChangeListener(listener);
            observer.onSubscribe(listener);
        }
    }

    @NotNull
    /* renamed from: b */
    public Integer getInitialValue() {
        return Integer.valueOf(this.view.getCheckedRadioButtonId());
    }
}
