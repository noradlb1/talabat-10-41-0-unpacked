package androidx.compose.ui.text;

import androidx.compose.ui.text.AnnotatedString;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a4\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¨\u0006\u0007"}, d2 = {"getLocalPlaceholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "start", "", "end", "ui-text_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class MultiParagraphIntrinsicsKt {
    /* access modifiers changed from: private */
    public static final List<AnnotatedString.Range<Placeholder>> getLocalPlaceholders(List<AnnotatedString.Range<Placeholder>> list, int i11, int i12) {
        boolean z11;
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i13 = 0; i13 < size; i13++) {
            AnnotatedString.Range<Placeholder> range = list.get(i13);
            AnnotatedString.Range range2 = range;
            if (AnnotatedStringKt.intersect(i11, i12, range2.getStart(), range2.getEnd())) {
                arrayList.add(range);
            }
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size2 = arrayList.size();
        int i14 = 0;
        while (i14 < size2) {
            AnnotatedString.Range range3 = (AnnotatedString.Range) arrayList.get(i14);
            if (i11 > range3.getStart() || range3.getEnd() > i12) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                arrayList2.add(new AnnotatedString.Range(range3.getItem(), range3.getStart() - i11, range3.getEnd() - i11));
                i14++;
            } else {
                throw new IllegalArgumentException("placeholder can not overlap with paragraph.".toString());
            }
        }
        return arrayList2;
    }
}
