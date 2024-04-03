package com.checkout.frames.style.theme.colors;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001a\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/checkout/frames/style/theme/colors/ImageColors;", "", "tinColor", "", "(Ljava/lang/Long;)V", "getTinColor", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "copy", "(Ljava/lang/Long;)Lcom/checkout/frames/style/theme/colors/ImageColors;", "equals", "", "other", "hashCode", "", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ImageColors {
    public static final int $stable = 0;
    @Nullable
    private final Long tinColor;

    public ImageColors() {
        this((Long) null, 1, (DefaultConstructorMarker) null);
    }

    public ImageColors(@Nullable Long l11) {
        this.tinColor = l11;
    }

    public static /* synthetic */ ImageColors copy$default(ImageColors imageColors, Long l11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            l11 = imageColors.tinColor;
        }
        return imageColors.copy(l11);
    }

    @Nullable
    public final Long component1() {
        return this.tinColor;
    }

    @NotNull
    public final ImageColors copy(@Nullable Long l11) {
        return new ImageColors(l11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ImageColors) && Intrinsics.areEqual((Object) this.tinColor, (Object) ((ImageColors) obj).tinColor);
    }

    @Nullable
    public final Long getTinColor() {
        return this.tinColor;
    }

    public int hashCode() {
        Long l11 = this.tinColor;
        if (l11 == null) {
            return 0;
        }
        return l11.hashCode();
    }

    @NotNull
    public String toString() {
        Long l11 = this.tinColor;
        return "ImageColors(tinColor=" + l11 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ImageColors(Long l11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : l11);
    }
}
