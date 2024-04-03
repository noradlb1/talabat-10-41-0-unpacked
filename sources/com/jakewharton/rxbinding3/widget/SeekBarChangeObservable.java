package com.jakewharton.rxbinding3.widget;

import android.widget.SeekBar;
import com.jakewharton.rxbinding3.InitialValueObservable;
import com.jakewharton.rxbinding3.internal.Preconditions;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u0003H\u0014R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00028TX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/jakewharton/rxbinding3/widget/SeekBarChangeObservable;", "Lcom/jakewharton/rxbinding3/InitialValueObservable;", "", "Lio/reactivex/Observer;", "observer", "", "a", "Landroid/widget/SeekBar;", "view", "Landroid/widget/SeekBar;", "", "shouldBeFromUser", "Ljava/lang/Boolean;", "b", "()Ljava/lang/Integer;", "initialValue", "<init>", "(Landroid/widget/SeekBar;Ljava/lang/Boolean;)V", "Listener", "rxbinding_release"}, k = 1, mv = {1, 4, 0})
final class SeekBarChangeObservable extends InitialValueObservable<Integer> {
    private final Boolean shouldBeFromUser;
    private final SeekBar view;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\u0013\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00050\u0012¢\u0006\u0004\b\u0015\u0010\u0016J \u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\tH\u0014R\u0014\u0010\u000e\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00050\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/jakewharton/rxbinding3/widget/SeekBarChangeObservable$Listener;", "Lio/reactivex/android/MainThreadDisposable;", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "Landroid/widget/SeekBar;", "seekBar", "", "progress", "", "fromUser", "", "onProgressChanged", "onStartTrackingTouch", "onStopTrackingTouch", "a", "view", "Landroid/widget/SeekBar;", "shouldBeFromUser", "Ljava/lang/Boolean;", "Lio/reactivex/Observer;", "observer", "Lio/reactivex/Observer;", "<init>", "(Landroid/widget/SeekBar;Ljava/lang/Boolean;Lio/reactivex/Observer;)V", "rxbinding_release"}, k = 1, mv = {1, 4, 0})
    public static final class Listener extends MainThreadDisposable implements SeekBar.OnSeekBarChangeListener {
        private final Observer<? super Integer> observer;
        private final Boolean shouldBeFromUser;
        private final SeekBar view;

        public Listener(@NotNull SeekBar seekBar, @Nullable Boolean bool, @NotNull Observer<? super Integer> observer2) {
            Intrinsics.checkParameterIsNotNull(seekBar, "view");
            Intrinsics.checkParameterIsNotNull(observer2, "observer");
            this.view = seekBar;
            this.shouldBeFromUser = bool;
            this.observer = observer2;
        }

        public void a() {
            this.view.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener) null);
        }

        public void onProgressChanged(@NotNull SeekBar seekBar, int i11, boolean z11) {
            Intrinsics.checkParameterIsNotNull(seekBar, "seekBar");
            if (!isDisposed()) {
                Boolean bool = this.shouldBeFromUser;
                if (bool == null || Intrinsics.areEqual((Object) bool, (Object) Boolean.valueOf(z11))) {
                    this.observer.onNext(Integer.valueOf(i11));
                }
            }
        }

        public void onStartTrackingTouch(@NotNull SeekBar seekBar) {
            Intrinsics.checkParameterIsNotNull(seekBar, "seekBar");
        }

        public void onStopTrackingTouch(@NotNull SeekBar seekBar) {
            Intrinsics.checkParameterIsNotNull(seekBar, "seekBar");
        }
    }

    public SeekBarChangeObservable(@NotNull SeekBar seekBar, @Nullable Boolean bool) {
        Intrinsics.checkParameterIsNotNull(seekBar, "view");
        this.view = seekBar;
        this.shouldBeFromUser = bool;
    }

    public void a(@NotNull Observer<? super Integer> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            Listener listener = new Listener(this.view, this.shouldBeFromUser, observer);
            this.view.setOnSeekBarChangeListener(listener);
            observer.onSubscribe(listener);
        }
    }

    @NotNull
    /* renamed from: b */
    public Integer getInitialValue() {
        return Integer.valueOf(this.view.getProgress());
    }
}
