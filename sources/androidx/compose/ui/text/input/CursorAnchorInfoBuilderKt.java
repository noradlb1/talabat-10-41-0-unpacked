package androidx.compose.ui.text.input;

import android.graphics.Matrix;
import android.view.inputmethod.CursorAnchorInfo;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000\u001a\u001c\u0010\t\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\f"}, d2 = {"build", "Landroid/view/inputmethod/CursorAnchorInfo;", "Landroid/view/inputmethod/CursorAnchorInfo$Builder;", "textFieldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "matrix", "Landroid/graphics/Matrix;", "setInsertionMarker", "selectionStart", "", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class CursorAnchorInfoBuilderKt {
    @NotNull
    public static final CursorAnchorInfo build(@NotNull CursorAnchorInfo.Builder builder, @NotNull TextFieldValue textFieldValue, @NotNull TextLayoutResult textLayoutResult, @NotNull Matrix matrix) {
        int i11;
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(textFieldValue, "textFieldValue");
        Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        builder.reset();
        builder.setMatrix(matrix);
        int r52 = TextRange.m5036getMinimpl(textFieldValue.m5234getSelectiond9O1mEE());
        builder.setSelectionRange(r52, TextRange.m5035getMaximpl(textFieldValue.m5234getSelectiond9O1mEE()));
        setInsertionMarker(builder, r52, textLayoutResult);
        TextRange r42 = textFieldValue.m5233getCompositionMzsxiRA();
        int i12 = -1;
        if (r42 != null) {
            i11 = TextRange.m5036getMinimpl(r42.m5042unboximpl());
        } else {
            i11 = -1;
        }
        TextRange r02 = textFieldValue.m5233getCompositionMzsxiRA();
        if (r02 != null) {
            i12 = TextRange.m5035getMaximpl(r02.m5042unboximpl());
        }
        boolean z11 = false;
        if (i11 >= 0 && i11 < i12) {
            z11 = true;
        }
        if (z11) {
            builder.setComposingText(i11, textFieldValue.getText().subSequence(i11, i12));
        }
        CursorAnchorInfo build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "build()");
        return build;
    }

    private static final CursorAnchorInfo.Builder setInsertionMarker(CursorAnchorInfo.Builder builder, int i11, TextLayoutResult textLayoutResult) {
        boolean z11;
        if (i11 < 0) {
            return builder;
        }
        Rect cursorRect = textLayoutResult.getCursorRect(i11);
        int i12 = 0;
        if (textLayoutResult.getBidiRunDirection(i11) == ResolvedTextDirection.Rtl) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            i12 = 4;
        }
        builder.setInsertionMarkerLocation(cursorRect.getLeft(), cursorRect.getTop(), cursorRect.getBottom(), cursorRect.getBottom(), i12);
        return builder;
    }
}
