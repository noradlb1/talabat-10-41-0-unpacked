package com.deliveryhero.fluid.widgets.text;

import androidx.annotation.StyleRes;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/deliveryhero/fluid/widgets/text/ResourceTextStyle;", "Lcom/deliveryhero/fluid/widgets/text/TextStyle;", "id", "", "(I)V", "getId", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ResourceTextStyle implements TextStyle {

    /* renamed from: id  reason: collision with root package name */
    private final int f30282id;

    public ResourceTextStyle(@StyleRes int i11) {
        this.f30282id = i11;
    }

    public static /* synthetic */ ResourceTextStyle copy$default(ResourceTextStyle resourceTextStyle, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = resourceTextStyle.f30282id;
        }
        return resourceTextStyle.copy(i11);
    }

    public final int component1() {
        return this.f30282id;
    }

    @NotNull
    public final ResourceTextStyle copy(@StyleRes int i11) {
        return new ResourceTextStyle(i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ResourceTextStyle) && this.f30282id == ((ResourceTextStyle) obj).f30282id;
    }

    public final int getId() {
        return this.f30282id;
    }

    public int hashCode() {
        return this.f30282id;
    }

    @NotNull
    public String toString() {
        return "ResourceTextStyle(id=" + this.f30282id + ')';
    }
}
