package com.deliveryhero.fluid.widgets.text;

import android.content.res.ColorStateList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0016\u0010\u000e\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006HÆ\u0003¢\u0006\u0002\u0010\u000bJ,\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001b\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/deliveryhero/fluid/widgets/text/TextAppearance;", "", "colors", "Landroid/content/res/ColorStateList;", "size", "", "Lcom/deliveryhero/fluid/values/Pixel;", "(Landroid/content/res/ColorStateList;Ljava/lang/Float;)V", "getColors", "()Landroid/content/res/ColorStateList;", "getSize", "()Ljava/lang/Float;", "Ljava/lang/Float;", "component1", "component2", "copy", "(Landroid/content/res/ColorStateList;Ljava/lang/Float;)Lcom/deliveryhero/fluid/widgets/text/TextAppearance;", "equals", "", "other", "hashCode", "", "toString", "", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TextAppearance {
    @Nullable
    private final ColorStateList colors;
    @Nullable
    private final Float size;

    public TextAppearance(@Nullable ColorStateList colorStateList, @Nullable Float f11) {
        this.colors = colorStateList;
        this.size = f11;
    }

    public static /* synthetic */ TextAppearance copy$default(TextAppearance textAppearance, ColorStateList colorStateList, Float f11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            colorStateList = textAppearance.colors;
        }
        if ((i11 & 2) != 0) {
            f11 = textAppearance.size;
        }
        return textAppearance.copy(colorStateList, f11);
    }

    @Nullable
    public final ColorStateList component1() {
        return this.colors;
    }

    @Nullable
    public final Float component2() {
        return this.size;
    }

    @NotNull
    public final TextAppearance copy(@Nullable ColorStateList colorStateList, @Nullable Float f11) {
        return new TextAppearance(colorStateList, f11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextAppearance)) {
            return false;
        }
        TextAppearance textAppearance = (TextAppearance) obj;
        return Intrinsics.areEqual((Object) this.colors, (Object) textAppearance.colors) && Intrinsics.areEqual((Object) this.size, (Object) textAppearance.size);
    }

    @Nullable
    public final ColorStateList getColors() {
        return this.colors;
    }

    @Nullable
    public final Float getSize() {
        return this.size;
    }

    public int hashCode() {
        ColorStateList colorStateList = this.colors;
        int i11 = 0;
        int hashCode = (colorStateList == null ? 0 : colorStateList.hashCode()) * 31;
        Float f11 = this.size;
        if (f11 != null) {
            i11 = f11.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        return "TextAppearance(colors=" + this.colors + ", size=" + this.size + ')';
    }
}
