package com.jakewharton.rxbinding3.widget;

import android.widget.SeekBar;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/jakewharton/rxbinding3/widget/SeekBarProgressChangeEvent;", "Lcom/jakewharton/rxbinding3/widget/SeekBarChangeEvent;", "view", "Landroid/widget/SeekBar;", "progress", "", "fromUser", "", "(Landroid/widget/SeekBar;IZ)V", "getFromUser", "()Z", "getProgress", "()I", "getView", "()Landroid/widget/SeekBar;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "toString", "", "rxbinding_release"}, k = 1, mv = {1, 1, 15})
public final class SeekBarProgressChangeEvent extends SeekBarChangeEvent {
    private final boolean fromUser;
    private final int progress;
    @NotNull
    private final SeekBar view;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SeekBarProgressChangeEvent(@NotNull SeekBar seekBar, int i11, boolean z11) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkParameterIsNotNull(seekBar, "view");
        this.view = seekBar;
        this.progress = i11;
        this.fromUser = z11;
    }

    public static /* synthetic */ SeekBarProgressChangeEvent copy$default(SeekBarProgressChangeEvent seekBarProgressChangeEvent, SeekBar seekBar, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            seekBar = seekBarProgressChangeEvent.getView();
        }
        if ((i12 & 2) != 0) {
            i11 = seekBarProgressChangeEvent.progress;
        }
        if ((i12 & 4) != 0) {
            z11 = seekBarProgressChangeEvent.fromUser;
        }
        return seekBarProgressChangeEvent.copy(seekBar, i11, z11);
    }

    @NotNull
    public final SeekBar component1() {
        return getView();
    }

    public final int component2() {
        return this.progress;
    }

    public final boolean component3() {
        return this.fromUser;
    }

    @NotNull
    public final SeekBarProgressChangeEvent copy(@NotNull SeekBar seekBar, int i11, boolean z11) {
        Intrinsics.checkParameterIsNotNull(seekBar, "view");
        return new SeekBarProgressChangeEvent(seekBar, i11, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof SeekBarProgressChangeEvent) {
                SeekBarProgressChangeEvent seekBarProgressChangeEvent = (SeekBarProgressChangeEvent) obj;
                if (Intrinsics.areEqual((Object) getView(), (Object) seekBarProgressChangeEvent.getView())) {
                    if (this.progress == seekBarProgressChangeEvent.progress) {
                        if (this.fromUser == seekBarProgressChangeEvent.fromUser) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final boolean getFromUser() {
        return this.fromUser;
    }

    public final int getProgress() {
        return this.progress;
    }

    @NotNull
    public SeekBar getView() {
        return this.view;
    }

    public int hashCode() {
        SeekBar view2 = getView();
        int hashCode = (((view2 != null ? view2.hashCode() : 0) * 31) + this.progress) * 31;
        boolean z11 = this.fromUser;
        if (z11) {
            z11 = true;
        }
        return hashCode + (z11 ? 1 : 0);
    }

    @NotNull
    public String toString() {
        return "SeekBarProgressChangeEvent(view=" + getView() + ", progress=" + this.progress + ", fromUser=" + this.fromUser + ")";
    }
}
