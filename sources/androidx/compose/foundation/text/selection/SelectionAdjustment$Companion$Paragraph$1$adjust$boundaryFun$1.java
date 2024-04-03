package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.StringHelpersKt;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public /* synthetic */ class SelectionAdjustment$Companion$Paragraph$1$adjust$boundaryFun$1 extends FunctionReferenceImpl implements Function1<Integer, TextRange> {
    public SelectionAdjustment$Companion$Paragraph$1$adjust$boundaryFun$1(Object obj) {
        super(1, obj, StringHelpersKt.class, "getParagraphBoundary", "getParagraphBoundary(Ljava/lang/CharSequence;I)J", 1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return TextRange.m5026boximpl(m972invokejx7JFs(((Number) obj).intValue()));
    }

    /* renamed from: invoke--jx7JFs  reason: not valid java name */
    public final long m972invokejx7JFs(int i11) {
        return StringHelpersKt.getParagraphBoundary((CharSequence) this.receiver, i11);
    }
}
