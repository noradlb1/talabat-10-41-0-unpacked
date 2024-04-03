package com.designsystem.ds_empty_state_v2;

import androidx.annotation.DrawableRes;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B6\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\tø\u0001\u0000¢\u0006\u0002\u0010\nJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0016\u001a\u00020\u0005HÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\fJ\u0019\u0010\u0018\u001a\u00020\u0005HÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\fJ\u0019\u0010\u001a\u001a\u00020\u0005HÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\fJ\u0019\u0010\u001c\u001a\u00020\tHÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u000fJH\u0010\u001e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u001c\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\b\u001a\u00020\tø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0006\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0007\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0014\u0010\f\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006'"}, d2 = {"Lcom/designsystem/ds_empty_state_v2/EmptyStateIcon;", "", "icon", "", "bottomMargin", "Landroidx/compose/ui/unit/Dp;", "height", "width", "color", "Landroidx/compose/ui/graphics/Color;", "(IFFFJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBottomMargin-D9Ej5fM", "()F", "F", "getColor-0d7_KjU", "()J", "J", "getHeight-D9Ej5fM", "getIcon", "()I", "getWidth-D9Ej5fM", "component1", "component2", "component2-D9Ej5fM", "component3", "component3-D9Ej5fM", "component4", "component4-D9Ej5fM", "component5", "component5-0d7_KjU", "copy", "copy-Krg-7T4", "(IFFFJ)Lcom/designsystem/ds_empty_state_v2/EmptyStateIcon;", "equals", "", "other", "hashCode", "toString", "", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class EmptyStateIcon {
    private final float bottomMargin;
    private final long color;
    private final float height;
    private final int icon;
    private final float width;

    private EmptyStateIcon(int i11, float f11, float f12, float f13, long j11) {
        this.icon = i11;
        this.bottomMargin = f11;
        this.height = f12;
        this.width = f13;
        this.color = j11;
    }

    public /* synthetic */ EmptyStateIcon(@DrawableRes int i11, float f11, float f12, float f13, long j11, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, f11, f12, f13, j11);
    }

    /* renamed from: copy-Krg-7T4$default  reason: not valid java name */
    public static /* synthetic */ EmptyStateIcon m8335copyKrg7T4$default(EmptyStateIcon emptyStateIcon, int i11, float f11, float f12, float f13, long j11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = emptyStateIcon.icon;
        }
        if ((i12 & 2) != 0) {
            f11 = emptyStateIcon.bottomMargin;
        }
        float f14 = f11;
        if ((i12 & 4) != 0) {
            f12 = emptyStateIcon.height;
        }
        float f15 = f12;
        if ((i12 & 8) != 0) {
            f13 = emptyStateIcon.width;
        }
        float f16 = f13;
        if ((i12 & 16) != 0) {
            j11 = emptyStateIcon.color;
        }
        return emptyStateIcon.m8340copyKrg7T4(i11, f14, f15, f16, j11);
    }

    public final int component1() {
        return this.icon;
    }

    /* renamed from: component2-D9Ej5fM  reason: not valid java name */
    public final float m8336component2D9Ej5fM() {
        return this.bottomMargin;
    }

    /* renamed from: component3-D9Ej5fM  reason: not valid java name */
    public final float m8337component3D9Ej5fM() {
        return this.height;
    }

    /* renamed from: component4-D9Ej5fM  reason: not valid java name */
    public final float m8338component4D9Ej5fM() {
        return this.width;
    }

    /* renamed from: component5-0d7_KjU  reason: not valid java name */
    public final long m8339component50d7_KjU() {
        return this.color;
    }

    @NotNull
    /* renamed from: copy-Krg-7T4  reason: not valid java name */
    public final EmptyStateIcon m8340copyKrg7T4(@DrawableRes int i11, float f11, float f12, float f13, long j11) {
        return new EmptyStateIcon(i11, f11, f12, f13, j11, (DefaultConstructorMarker) null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EmptyStateIcon)) {
            return false;
        }
        EmptyStateIcon emptyStateIcon = (EmptyStateIcon) obj;
        return this.icon == emptyStateIcon.icon && Dp.m5483equalsimpl0(this.bottomMargin, emptyStateIcon.bottomMargin) && Dp.m5483equalsimpl0(this.height, emptyStateIcon.height) && Dp.m5483equalsimpl0(this.width, emptyStateIcon.width) && Color.m2920equalsimpl0(this.color, emptyStateIcon.color);
    }

    /* renamed from: getBottomMargin-D9Ej5fM  reason: not valid java name */
    public final float m8341getBottomMarginD9Ej5fM() {
        return this.bottomMargin;
    }

    /* renamed from: getColor-0d7_KjU  reason: not valid java name */
    public final long m8342getColor0d7_KjU() {
        return this.color;
    }

    /* renamed from: getHeight-D9Ej5fM  reason: not valid java name */
    public final float m8343getHeightD9Ej5fM() {
        return this.height;
    }

    public final int getIcon() {
        return this.icon;
    }

    /* renamed from: getWidth-D9Ej5fM  reason: not valid java name */
    public final float m8344getWidthD9Ej5fM() {
        return this.width;
    }

    public int hashCode() {
        return (((((((this.icon * 31) + Dp.m5484hashCodeimpl(this.bottomMargin)) * 31) + Dp.m5484hashCodeimpl(this.height)) * 31) + Dp.m5484hashCodeimpl(this.width)) * 31) + Color.m2926hashCodeimpl(this.color);
    }

    @NotNull
    public String toString() {
        return "EmptyStateIcon(icon=" + this.icon + ", bottomMargin=" + Dp.m5489toStringimpl(this.bottomMargin) + ", height=" + Dp.m5489toStringimpl(this.height) + ", width=" + Dp.m5489toStringimpl(this.width) + ", color=" + Color.m2927toStringimpl(this.color) + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EmptyStateIcon(int i11, float f11, float f12, float f13, long j11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, f11, f12, (i12 & 8) != 0 ? Dp.Companion.m5498getUnspecifiedD9Ej5fM() : f13, (i12 & 16) != 0 ? Color.Companion.m2955getUnspecified0d7_KjU() : j11, (DefaultConstructorMarker) null);
    }
}
