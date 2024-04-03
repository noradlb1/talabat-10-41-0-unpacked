package com.jakewharton.rxbinding3.widget;

import android.widget.SeekBar;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/jakewharton/rxbinding3/widget/SeekBarStartChangeEvent;", "Lcom/jakewharton/rxbinding3/widget/SeekBarChangeEvent;", "view", "Landroid/widget/SeekBar;", "(Landroid/widget/SeekBar;)V", "getView", "()Landroid/widget/SeekBar;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "rxbinding_release"}, k = 1, mv = {1, 1, 15})
public final class SeekBarStartChangeEvent extends SeekBarChangeEvent {
    @NotNull
    private final SeekBar view;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SeekBarStartChangeEvent(@NotNull SeekBar seekBar) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkParameterIsNotNull(seekBar, "view");
        this.view = seekBar;
    }

    public static /* synthetic */ SeekBarStartChangeEvent copy$default(SeekBarStartChangeEvent seekBarStartChangeEvent, SeekBar seekBar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            seekBar = seekBarStartChangeEvent.getView();
        }
        return seekBarStartChangeEvent.copy(seekBar);
    }

    @NotNull
    public final SeekBar component1() {
        return getView();
    }

    @NotNull
    public final SeekBarStartChangeEvent copy(@NotNull SeekBar seekBar) {
        Intrinsics.checkParameterIsNotNull(seekBar, "view");
        return new SeekBarStartChangeEvent(seekBar);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof SeekBarStartChangeEvent) && Intrinsics.areEqual((Object) getView(), (Object) ((SeekBarStartChangeEvent) obj).getView());
        }
        return true;
    }

    @NotNull
    public SeekBar getView() {
        return this.view;
    }

    public int hashCode() {
        SeekBar view2 = getView();
        if (view2 != null) {
            return view2.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return "SeekBarStartChangeEvent(view=" + getView() + ")";
    }
}
