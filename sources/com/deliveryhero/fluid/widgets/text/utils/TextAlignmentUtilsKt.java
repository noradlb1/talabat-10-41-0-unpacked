package com.deliveryhero.fluid.widgets.text.utils;

import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.deliveryhero.fluid.utils.AndroidVersion;
import com.deliveryhero.fluid.widgets.text.TextAlignment;
import com.google.android.material.badge.BadgeDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0006H\u0000¨\u0006\u0007"}, d2 = {"updateJustifyText", "", "Landroid/widget/TextView;", "value", "", "updateTextAlignment", "Lcom/deliveryhero/fluid/widgets/text/TextAlignment;", "core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class TextAlignmentUtilsKt {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TextAlignment.values().length];
            iArr[TextAlignment.TOP_LEADING.ordinal()] = 1;
            iArr[TextAlignment.TOP_CENTER.ordinal()] = 2;
            iArr[TextAlignment.TOP_TRAILING.ordinal()] = 3;
            iArr[TextAlignment.LEADING_CENTER.ordinal()] = 4;
            iArr[TextAlignment.CENTER.ordinal()] = 5;
            iArr[TextAlignment.TRAILING_CENTER.ordinal()] = 6;
            iArr[TextAlignment.BOTTOM_LEADING.ordinal()] = 7;
            iArr[TextAlignment.BOTTOM_CENTER.ordinal()] = 8;
            iArr[TextAlignment.BOTTOM_TRAILING.ordinal()] = 9;
            iArr[TextAlignment.JUSTIFIED.ordinal()] = 10;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final void updateJustifyText(TextView textView, boolean z11) {
        if (AndroidVersion.INSTANCE.isAtLeastOreo() && textView.getJustificationMode() != z11) {
            textView.setJustificationMode(z11 ? 1 : 0);
        }
    }

    public static final void updateTextAlignment(@NotNull TextView textView, @NotNull TextAlignment textAlignment) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(textAlignment, "value");
        switch (WhenMappings.$EnumSwitchMapping$0[textAlignment.ordinal()]) {
            case 1:
                textView.setGravity(BadgeDrawable.TOP_START);
                updateJustifyText(textView, false);
                return;
            case 2:
                textView.setGravity(49);
                updateJustifyText(textView, false);
                return;
            case 3:
                textView.setGravity(BadgeDrawable.TOP_END);
                updateJustifyText(textView, false);
                return;
            case 4:
                textView.setGravity(8388627);
                updateJustifyText(textView, false);
                return;
            case 5:
                textView.setGravity(17);
                updateJustifyText(textView, false);
                return;
            case 6:
                textView.setGravity(8388629);
                updateJustifyText(textView, false);
                return;
            case 7:
                textView.setGravity(BadgeDrawable.BOTTOM_START);
                updateJustifyText(textView, false);
                return;
            case 8:
                textView.setGravity(81);
                updateJustifyText(textView, false);
                return;
            case 9:
                textView.setGravity(BadgeDrawable.BOTTOM_END);
                updateJustifyText(textView, false);
                return;
            case 10:
                textView.setGravity(GravityCompat.START);
                updateJustifyText(textView, true);
                return;
            default:
                return;
        }
    }
}
