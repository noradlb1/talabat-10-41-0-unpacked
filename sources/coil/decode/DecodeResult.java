package coil.decode;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\t¨\u0006\u0013"}, d2 = {"Lcoil/decode/DecodeResult;", "", "drawable", "Landroid/graphics/drawable/Drawable;", "isSampled", "", "(Landroid/graphics/drawable/Drawable;Z)V", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DecodeResult {
    @NotNull
    private final Drawable drawable;
    private final boolean isSampled;

    public DecodeResult(@NotNull Drawable drawable2, boolean z11) {
        Intrinsics.checkNotNullParameter(drawable2, "drawable");
        this.drawable = drawable2;
        this.isSampled = z11;
    }

    public static /* synthetic */ DecodeResult copy$default(DecodeResult decodeResult, Drawable drawable2, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            drawable2 = decodeResult.drawable;
        }
        if ((i11 & 2) != 0) {
            z11 = decodeResult.isSampled;
        }
        return decodeResult.copy(drawable2, z11);
    }

    @NotNull
    public final Drawable component1() {
        return this.drawable;
    }

    public final boolean component2() {
        return this.isSampled;
    }

    @NotNull
    public final DecodeResult copy(@NotNull Drawable drawable2, boolean z11) {
        Intrinsics.checkNotNullParameter(drawable2, "drawable");
        return new DecodeResult(drawable2, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DecodeResult)) {
            return false;
        }
        DecodeResult decodeResult = (DecodeResult) obj;
        return Intrinsics.areEqual((Object) this.drawable, (Object) decodeResult.drawable) && this.isSampled == decodeResult.isSampled;
    }

    @NotNull
    public final Drawable getDrawable() {
        return this.drawable;
    }

    public int hashCode() {
        int hashCode = this.drawable.hashCode() * 31;
        boolean z11 = this.isSampled;
        if (z11) {
            z11 = true;
        }
        return hashCode + (z11 ? 1 : 0);
    }

    public final boolean isSampled() {
        return this.isSampled;
    }

    @NotNull
    public String toString() {
        return "DecodeResult(drawable=" + this.drawable + ", isSampled=" + this.isSampled + ')';
    }
}
