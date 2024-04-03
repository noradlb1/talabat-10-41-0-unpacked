package com.designsystem.ds_tag_v2;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0018\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0005J\u0019\u0010\u0007\u001a\u00020\u0003HÂ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\n\u001a\u00020\u0003HÂ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\tJ*\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u001e\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0019\u0010\u0004\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0006R\u0019\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001b"}, d2 = {"Lcom/designsystem/ds_tag_v2/TagColor;", "", "normalPriorityColor", "Landroidx/compose/ui/graphics/Color;", "highPriorityColor", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "component1", "component1-0d7_KjU", "()J", "component2", "component2-0d7_KjU", "copy", "copy--OWjLjI", "(JJ)Lcom/designsystem/ds_tag_v2/TagColor;", "equals", "", "other", "getColor", "priority", "Lcom/designsystem/ds_tag_v2/DSTagPriority;", "getColor-vNxB06k", "(Lcom/designsystem/ds_tag_v2/DSTagPriority;)J", "hashCode", "", "toString", "", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class TagColor {
    private final long highPriorityColor;
    private final long normalPriorityColor;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DSTagPriority.values().length];
            iArr[DSTagPriority.Normal.ordinal()] = 1;
            iArr[DSTagPriority.High.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private TagColor(long j11, long j12) {
        this.normalPriorityColor = j11;
        this.highPriorityColor = j12;
    }

    public /* synthetic */ TagColor(long j11, long j12, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12);
    }

    /* renamed from: component1-0d7_KjU  reason: not valid java name */
    private final long m8630component10d7_KjU() {
        return this.normalPriorityColor;
    }

    /* renamed from: component2-0d7_KjU  reason: not valid java name */
    private final long m8631component20d7_KjU() {
        return this.highPriorityColor;
    }

    /* renamed from: copy--OWjLjI$default  reason: not valid java name */
    public static /* synthetic */ TagColor m8632copyOWjLjI$default(TagColor tagColor, long j11, long j12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            j11 = tagColor.normalPriorityColor;
        }
        if ((i11 & 2) != 0) {
            j12 = tagColor.highPriorityColor;
        }
        return tagColor.m8633copyOWjLjI(j11, j12);
    }

    @NotNull
    /* renamed from: copy--OWjLjI  reason: not valid java name */
    public final TagColor m8633copyOWjLjI(long j11, long j12) {
        return new TagColor(j11, j12, (DefaultConstructorMarker) null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TagColor)) {
            return false;
        }
        TagColor tagColor = (TagColor) obj;
        return Color.m2920equalsimpl0(this.normalPriorityColor, tagColor.normalPriorityColor) && Color.m2920equalsimpl0(this.highPriorityColor, tagColor.highPriorityColor);
    }

    /* renamed from: getColor-vNxB06k  reason: not valid java name */
    public final long m8634getColorvNxB06k(@NotNull DSTagPriority dSTagPriority) {
        Intrinsics.checkNotNullParameter(dSTagPriority, "priority");
        int i11 = WhenMappings.$EnumSwitchMapping$0[dSTagPriority.ordinal()];
        if (i11 == 1) {
            return this.normalPriorityColor;
        }
        if (i11 == 2) {
            return this.highPriorityColor;
        }
        throw new NoWhenBranchMatchedException();
    }

    public int hashCode() {
        return (Color.m2926hashCodeimpl(this.normalPriorityColor) * 31) + Color.m2926hashCodeimpl(this.highPriorityColor);
    }

    @NotNull
    public String toString() {
        return "TagColor(normalPriorityColor=" + Color.m2927toStringimpl(this.normalPriorityColor) + ", highPriorityColor=" + Color.m2927toStringimpl(this.highPriorityColor) + ')';
    }
}
