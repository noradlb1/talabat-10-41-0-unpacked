package com.designsystem.ds_alert;

import androidx.annotation.DrawableRes;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\"\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u000f\u001a\u00020\u0005HÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\tJ\u0019\u0010\u0011\u001a\u00020\u0005HÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\tJ4\u0010\u0013\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u001c\u0010\u0006\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\r\u0010\t\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, d2 = {"Lcom/designsystem/ds_alert/AlertTypeModel;", "", "icon", "", "iconColor", "Landroidx/compose/ui/graphics/Color;", "backgroundColor", "(IJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBackgroundColor-0d7_KjU", "()J", "J", "getIcon", "()I", "getIconColor-0d7_KjU", "component1", "component2", "component2-0d7_KjU", "component3", "component3-0d7_KjU", "copy", "copy-WkMS-hQ", "(IJJ)Lcom/designsystem/ds_alert/AlertTypeModel;", "equals", "", "other", "hashCode", "toString", "", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class AlertTypeModel {
    private final long backgroundColor;
    private final int icon;
    private final long iconColor;

    private AlertTypeModel(int i11, long j11, long j12) {
        this.icon = i11;
        this.iconColor = j11;
        this.backgroundColor = j12;
    }

    public /* synthetic */ AlertTypeModel(@DrawableRes int i11, long j11, long j12, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, j11, j12);
    }

    /* renamed from: copy-WkMS-hQ$default  reason: not valid java name */
    public static /* synthetic */ AlertTypeModel m8242copyWkMShQ$default(AlertTypeModel alertTypeModel, int i11, long j11, long j12, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = alertTypeModel.icon;
        }
        if ((i12 & 2) != 0) {
            j11 = alertTypeModel.iconColor;
        }
        long j13 = j11;
        if ((i12 & 4) != 0) {
            j12 = alertTypeModel.backgroundColor;
        }
        return alertTypeModel.m8245copyWkMShQ(i11, j13, j12);
    }

    public final int component1() {
        return this.icon;
    }

    /* renamed from: component2-0d7_KjU  reason: not valid java name */
    public final long m8243component20d7_KjU() {
        return this.iconColor;
    }

    /* renamed from: component3-0d7_KjU  reason: not valid java name */
    public final long m8244component30d7_KjU() {
        return this.backgroundColor;
    }

    @NotNull
    /* renamed from: copy-WkMS-hQ  reason: not valid java name */
    public final AlertTypeModel m8245copyWkMShQ(@DrawableRes int i11, long j11, long j12) {
        return new AlertTypeModel(i11, j11, j12, (DefaultConstructorMarker) null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AlertTypeModel)) {
            return false;
        }
        AlertTypeModel alertTypeModel = (AlertTypeModel) obj;
        return this.icon == alertTypeModel.icon && Color.m2920equalsimpl0(this.iconColor, alertTypeModel.iconColor) && Color.m2920equalsimpl0(this.backgroundColor, alertTypeModel.backgroundColor);
    }

    /* renamed from: getBackgroundColor-0d7_KjU  reason: not valid java name */
    public final long m8246getBackgroundColor0d7_KjU() {
        return this.backgroundColor;
    }

    public final int getIcon() {
        return this.icon;
    }

    /* renamed from: getIconColor-0d7_KjU  reason: not valid java name */
    public final long m8247getIconColor0d7_KjU() {
        return this.iconColor;
    }

    public int hashCode() {
        return (((this.icon * 31) + Color.m2926hashCodeimpl(this.iconColor)) * 31) + Color.m2926hashCodeimpl(this.backgroundColor);
    }

    @NotNull
    public String toString() {
        return "AlertTypeModel(icon=" + this.icon + ", iconColor=" + Color.m2927toStringimpl(this.iconColor) + ", backgroundColor=" + Color.m2927toStringimpl(this.backgroundColor) + ')';
    }
}
