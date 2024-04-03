package androidx.compose.ui.text.platform.extensions;

import android.text.Spannable;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.PlaceholderVerticalAlign;
import androidx.compose.ui.text.android.style.PlaceholderSpan;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import com.instabug.library.model.State;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a,\u0010\r\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0015H\u0002\u001a(\u0010\u0016\u001a\u00020\u000e*\u00020\u000f2\u0012\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00190\u00182\u0006\u0010\u0014\u001a\u00020\u0015H\u0000\"!\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"!\u0010\u0007\u001a\u00020\u0001*\u00020\b8BX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"spanUnit", "", "Landroidx/compose/ui/unit/TextUnit;", "getSpanUnit--R2X_6o$annotations", "(J)V", "getSpanUnit--R2X_6o", "(J)I", "spanVerticalAlign", "Landroidx/compose/ui/text/PlaceholderVerticalAlign;", "getSpanVerticalAlign-do9X-Gg$annotations", "(I)V", "getSpanVerticalAlign-do9X-Gg", "(I)I", "setPlaceholder", "", "Landroid/text/Spannable;", "placeholder", "Landroidx/compose/ui/text/Placeholder;", "start", "end", "density", "Landroidx/compose/ui/unit/Density;", "setPlaceholders", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "ui-text_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class PlaceholderExtensions_androidKt {
    /* renamed from: getSpanUnit--R2X_6o  reason: not valid java name */
    private static final int m5260getSpanUnitR2X_6o(long j11) {
        long r32 = TextUnit.m5658getTypeUIouoOA(j11);
        TextUnitType.Companion companion = TextUnitType.Companion;
        if (TextUnitType.m5687equalsimpl0(r32, companion.m5692getSpUIouoOA())) {
            return 0;
        }
        if (TextUnitType.m5687equalsimpl0(r32, companion.m5691getEmUIouoOA())) {
            return 1;
        }
        return 2;
    }

    /* renamed from: getSpanUnit--R2X_6o$annotations  reason: not valid java name */
    private static /* synthetic */ void m5261getSpanUnitR2X_6o$annotations(long j11) {
    }

    /* renamed from: getSpanVerticalAlign-do9X-Gg  reason: not valid java name */
    private static final int m5262getSpanVerticalAligndo9XGg(int i11) {
        PlaceholderVerticalAlign.Companion companion = PlaceholderVerticalAlign.Companion;
        if (PlaceholderVerticalAlign.m4972equalsimpl0(i11, companion.m4976getAboveBaselineJ6kI3mc())) {
            return 0;
        }
        if (PlaceholderVerticalAlign.m4972equalsimpl0(i11, companion.m4982getTopJ6kI3mc())) {
            return 1;
        }
        if (PlaceholderVerticalAlign.m4972equalsimpl0(i11, companion.m4977getBottomJ6kI3mc())) {
            return 2;
        }
        if (PlaceholderVerticalAlign.m4972equalsimpl0(i11, companion.m4978getCenterJ6kI3mc())) {
            return 3;
        }
        if (PlaceholderVerticalAlign.m4972equalsimpl0(i11, companion.m4981getTextTopJ6kI3mc())) {
            return 4;
        }
        if (PlaceholderVerticalAlign.m4972equalsimpl0(i11, companion.m4979getTextBottomJ6kI3mc())) {
            return 5;
        }
        if (PlaceholderVerticalAlign.m4972equalsimpl0(i11, companion.m4980getTextCenterJ6kI3mc())) {
            return 6;
        }
        throw new IllegalStateException("Invalid PlaceholderVerticalAlign".toString());
    }

    /* renamed from: getSpanVerticalAlign-do9X-Gg$annotations  reason: not valid java name */
    private static /* synthetic */ void m5263getSpanVerticalAligndo9XGg$annotations(int i11) {
    }

    private static final void setPlaceholder(Spannable spannable, Placeholder placeholder, int i11, int i12, Density density) {
        SpannableExtensions_androidKt.setSpan(spannable, new PlaceholderSpan(TextUnit.m5659getValueimpl(placeholder.m4968getWidthXSAIIZE()), m5260getSpanUnitR2X_6o(placeholder.m4968getWidthXSAIIZE()), TextUnit.m5659getValueimpl(placeholder.m4966getHeightXSAIIZE()), m5260getSpanUnitR2X_6o(placeholder.m4966getHeightXSAIIZE()), density.getFontScale() * density.getDensity(), m5262getSpanVerticalAligndo9XGg(placeholder.m4967getPlaceholderVerticalAlignJ6kI3mc())), i11, i12);
    }

    public static final void setPlaceholders(@NotNull Spannable spannable, @NotNull List<AnnotatedString.Range<Placeholder>> list, @NotNull Density density) {
        Intrinsics.checkNotNullParameter(spannable, "<this>");
        Intrinsics.checkNotNullParameter(list, "placeholders");
        Intrinsics.checkNotNullParameter(density, State.KEY_DENSITY);
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            AnnotatedString.Range range = list.get(i11);
            setPlaceholder(spannable, (Placeholder) range.component1(), range.component2(), range.component3(), density);
        }
    }
}
