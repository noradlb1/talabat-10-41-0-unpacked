package com.jakewharton.rxbinding3.widget;

import android.widget.RatingBar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/jakewharton/rxbinding3/widget/RatingBarChangeEvent;", "", "view", "Landroid/widget/RatingBar;", "rating", "", "fromUser", "", "(Landroid/widget/RatingBar;FZ)V", "getFromUser", "()Z", "getRating", "()F", "getView", "()Landroid/widget/RatingBar;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "rxbinding_release"}, k = 1, mv = {1, 1, 15})
public final class RatingBarChangeEvent {
    private final boolean fromUser;
    private final float rating;
    @NotNull
    private final RatingBar view;

    public RatingBarChangeEvent(@NotNull RatingBar ratingBar, float f11, boolean z11) {
        Intrinsics.checkParameterIsNotNull(ratingBar, "view");
        this.view = ratingBar;
        this.rating = f11;
        this.fromUser = z11;
    }

    public static /* synthetic */ RatingBarChangeEvent copy$default(RatingBarChangeEvent ratingBarChangeEvent, RatingBar ratingBar, float f11, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            ratingBar = ratingBarChangeEvent.view;
        }
        if ((i11 & 2) != 0) {
            f11 = ratingBarChangeEvent.rating;
        }
        if ((i11 & 4) != 0) {
            z11 = ratingBarChangeEvent.fromUser;
        }
        return ratingBarChangeEvent.copy(ratingBar, f11, z11);
    }

    @NotNull
    public final RatingBar component1() {
        return this.view;
    }

    public final float component2() {
        return this.rating;
    }

    public final boolean component3() {
        return this.fromUser;
    }

    @NotNull
    public final RatingBarChangeEvent copy(@NotNull RatingBar ratingBar, float f11, boolean z11) {
        Intrinsics.checkParameterIsNotNull(ratingBar, "view");
        return new RatingBarChangeEvent(ratingBar, f11, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof RatingBarChangeEvent) {
                RatingBarChangeEvent ratingBarChangeEvent = (RatingBarChangeEvent) obj;
                if (Intrinsics.areEqual((Object) this.view, (Object) ratingBarChangeEvent.view) && Float.compare(this.rating, ratingBarChangeEvent.rating) == 0) {
                    if (this.fromUser == ratingBarChangeEvent.fromUser) {
                        return true;
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

    public final float getRating() {
        return this.rating;
    }

    @NotNull
    public final RatingBar getView() {
        return this.view;
    }

    public int hashCode() {
        RatingBar ratingBar = this.view;
        int hashCode = (((ratingBar != null ? ratingBar.hashCode() : 0) * 31) + Float.floatToIntBits(this.rating)) * 31;
        boolean z11 = this.fromUser;
        if (z11) {
            z11 = true;
        }
        return hashCode + (z11 ? 1 : 0);
    }

    @NotNull
    public String toString() {
        return "RatingBarChangeEvent(view=" + this.view + ", rating=" + this.rating + ", fromUser=" + this.fromUser + ")";
    }
}
