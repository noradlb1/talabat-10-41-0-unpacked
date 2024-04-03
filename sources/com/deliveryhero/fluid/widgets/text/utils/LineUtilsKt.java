package com.deliveryhero.fluid.widgets.text.utils;

import android.text.TextUtils;
import android.widget.TextView;
import com.deliveryhero.fluid.widgets.text.LineBreakMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0006H\u0000\u001a\u0014\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0006H\u0000¨\u0006\b"}, d2 = {"updateLineBreakMode", "", "Landroid/widget/TextView;", "value", "Lcom/deliveryhero/fluid/widgets/text/LineBreakMode;", "updateMaxLines", "", "updateMinLines", "core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class LineUtilsKt {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LineBreakMode.values().length];
            iArr[LineBreakMode.TRUNCATE_LEADING.ordinal()] = 1;
            iArr[LineBreakMode.TRUNCATE_MIDDLE.ordinal()] = 2;
            iArr[LineBreakMode.TRUNCATE_TRAILING.ordinal()] = 3;
            iArr[LineBreakMode.CLIP.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void updateLineBreakMode(@NotNull TextView textView, @NotNull LineBreakMode lineBreakMode) {
        TextUtils.TruncateAt truncateAt;
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(lineBreakMode, "value");
        int i11 = WhenMappings.$EnumSwitchMapping$0[lineBreakMode.ordinal()];
        if (i11 == 1) {
            truncateAt = TextUtils.TruncateAt.START;
        } else if (i11 == 2) {
            truncateAt = TextUtils.TruncateAt.MIDDLE;
        } else if (i11 == 3) {
            truncateAt = TextUtils.TruncateAt.END;
        } else if (i11 == 4) {
            truncateAt = null;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        textView.setEllipsize(truncateAt);
    }

    public static final void updateMaxLines(@NotNull TextView textView, int i11) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        if (i11 == 0) {
            i11 = Integer.MAX_VALUE;
        }
        if (textView.getMaxLines() != i11) {
            textView.setMaxLines(i11);
        }
    }

    public static final void updateMinLines(@NotNull TextView textView, int i11) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        if (textView.getMinLines() != i11) {
            textView.setMinLines(i11);
        }
    }
}
