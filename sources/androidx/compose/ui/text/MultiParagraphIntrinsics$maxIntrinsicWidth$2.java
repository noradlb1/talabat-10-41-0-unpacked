package androidx.compose.ui.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Float;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class MultiParagraphIntrinsics$maxIntrinsicWidth$2 extends Lambda implements Function0<Float> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MultiParagraphIntrinsics f10134g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MultiParagraphIntrinsics$maxIntrinsicWidth$2(MultiParagraphIntrinsics multiParagraphIntrinsics) {
        super(0);
        this.f10134g = multiParagraphIntrinsics;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0046, code lost:
        r0 = r0.getIntrinsics();
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Float invoke() {
        /*
            r8 = this;
            androidx.compose.ui.text.MultiParagraphIntrinsics r0 = r8.f10134g
            java.util.List r0 = r0.getInfoList$ui_text_release()
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x000e
            r0 = 0
            goto L_0x0042
        L_0x000e:
            r1 = 0
            java.lang.Object r1 = r0.get(r1)
            r2 = r1
            androidx.compose.ui.text.ParagraphIntrinsicInfo r2 = (androidx.compose.ui.text.ParagraphIntrinsicInfo) r2
            androidx.compose.ui.text.ParagraphIntrinsics r2 = r2.getIntrinsics()
            float r2 = r2.getMaxIntrinsicWidth()
            int r3 = kotlin.collections.CollectionsKt__CollectionsKt.getLastIndex(r0)
            r4 = 1
            if (r4 > r3) goto L_0x0041
        L_0x0025:
            java.lang.Object r5 = r0.get(r4)
            r6 = r5
            androidx.compose.ui.text.ParagraphIntrinsicInfo r6 = (androidx.compose.ui.text.ParagraphIntrinsicInfo) r6
            androidx.compose.ui.text.ParagraphIntrinsics r6 = r6.getIntrinsics()
            float r6 = r6.getMaxIntrinsicWidth()
            int r7 = java.lang.Float.compare(r2, r6)
            if (r7 >= 0) goto L_0x003c
            r1 = r5
            r2 = r6
        L_0x003c:
            if (r4 == r3) goto L_0x0041
            int r4 = r4 + 1
            goto L_0x0025
        L_0x0041:
            r0 = r1
        L_0x0042:
            androidx.compose.ui.text.ParagraphIntrinsicInfo r0 = (androidx.compose.ui.text.ParagraphIntrinsicInfo) r0
            if (r0 == 0) goto L_0x0051
            androidx.compose.ui.text.ParagraphIntrinsics r0 = r0.getIntrinsics()
            if (r0 == 0) goto L_0x0051
            float r0 = r0.getMaxIntrinsicWidth()
            goto L_0x0052
        L_0x0051:
            r0 = 0
        L_0x0052:
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.MultiParagraphIntrinsics$maxIntrinsicWidth$2.invoke():java.lang.Float");
    }
}
