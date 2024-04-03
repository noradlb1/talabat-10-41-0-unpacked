package com.jakewharton.rxbinding3.widget;

import android.widget.SeekBar;
import com.jakewharton.rxbinding3.InitialValueObservable;
import com.jakewharton.rxbinding3.internal.Preconditions;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u0003H\u0014R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\n8TX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/jakewharton/rxbinding3/widget/SeekBarChangeEventObservable;", "Lcom/jakewharton/rxbinding3/InitialValueObservable;", "Lcom/jakewharton/rxbinding3/widget/SeekBarChangeEvent;", "Lio/reactivex/Observer;", "observer", "", "a", "Landroid/widget/SeekBar;", "view", "Landroid/widget/SeekBar;", "Lcom/jakewharton/rxbinding3/widget/SeekBarProgressChangeEvent;", "b", "()Lcom/jakewharton/rxbinding3/widget/SeekBarProgressChangeEvent;", "initialValue", "<init>", "(Landroid/widget/SeekBar;)V", "Listener", "rxbinding_release"}, k = 1, mv = {1, 4, 0})
final class SeekBarChangeEventObservable extends InitialValueObservable<SeekBarChangeEvent> {
    private final SeekBar view;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u000e\u0010\u0012\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0014\u0010\u0015J \u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\tH\u0014R\u0014\u0010\u000e\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0012\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00110\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/jakewharton/rxbinding3/widget/SeekBarChangeEventObservable$Listener;", "Lio/reactivex/android/MainThreadDisposable;", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "Landroid/widget/SeekBar;", "seekBar", "", "progress", "", "fromUser", "", "onProgressChanged", "onStartTrackingTouch", "onStopTrackingTouch", "a", "view", "Landroid/widget/SeekBar;", "Lio/reactivex/Observer;", "Lcom/jakewharton/rxbinding3/widget/SeekBarChangeEvent;", "observer", "Lio/reactivex/Observer;", "<init>", "(Landroid/widget/SeekBar;Lio/reactivex/Observer;)V", "rxbinding_release"}, k = 1, mv = {1, 4, 0})
    public static final class Listener extends MainThreadDisposable implements SeekBar.OnSeekBarChangeListener {
        private final Observer<? super SeekBarChangeEvent> observer;
        private final SeekBar view;

        public Listener(@NotNull SeekBar seekBar, @NotNull Observer<? super SeekBarChangeEvent> observer2) {
            Intrinsics.checkParameterIsNotNull(seekBar, "view");
            Intrinsics.checkParameterIsNotNull(observer2, "observer");
            this.view = seekBar;
            this.observer = observer2;
        }

        public void a() {
            this.view.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener) null);
        }

        public void onProgressChanged(@NotNull SeekBar seekBar, int i11, boolean z11) {
            Intrinsics.checkParameterIsNotNull(seekBar, "seekBar");
            if (!isDisposed()) {
                this.observer.onNext(new SeekBarProgressChangeEvent(seekBar, i11, z11));
            }
        }

        public void onStartTrackingTouch(@NotNull SeekBar seekBar) {
            Intrinsics.checkParameterIsNotNull(seekBar, "seekBar");
            if (!isDisposed()) {
                this.observer.onNext(new SeekBarStartChangeEvent(seekBar));
            }
        }

        public void onStopTrackingTouch(@NotNull SeekBar seekBar) {
            Intrinsics.checkParameterIsNotNull(seekBar, "seekBar");
            if (!isDisposed()) {
                this.observer.onNext(new SeekBarStopChangeEvent(seekBar));
            }
        }
    }

    public SeekBarChangeEventObservable(@NotNull SeekBar seekBar) {
        Intrinsics.checkParameterIsNotNull(seekBar, "view");
        this.view = seekBar;
    }

    public void a(@NotNull Observer<? super SeekBarChangeEvent> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            Listener listener = new Listener(this.view, observer);
            this.view.setOnSeekBarChangeListener(listener);
            observer.onSubscribe(listener);
        }
    }

    @NotNull
    /* renamed from: b */
    public SeekBarProgressChangeEvent getInitialValue() {
        SeekBar seekBar = this.view;
        return new SeekBarProgressChangeEvent(seekBar, seekBar.getProgress(), false);
    }
}
