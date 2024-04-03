package androidx.compose.foundation.text.selection;

import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public /* synthetic */ class SelectionAdjustment$Companion$Word$1$adjust$1 extends FunctionReferenceImpl implements Function1<Integer, TextRange> {
    public SelectionAdjustment$Companion$Word$1$adjust$1(Object obj) {
        super(1, obj, TextLayoutResult.class, "getWordBoundary", "getWordBoundary--jx7JFs(I)J", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return TextRange.m5026boximpl(m974invokejx7JFs(((Number) obj).intValue()));
    }

    /* renamed from: invoke--jx7JFs  reason: not valid java name */
    public final long m974invokejx7JFs(int i11) {
        return ((TextLayoutResult) this.receiver).m5015getWordBoundaryjx7JFs(i11);
    }
}
