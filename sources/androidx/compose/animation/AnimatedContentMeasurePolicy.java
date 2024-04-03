package androidx.compose.animation;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.MeasurePolicy;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0007\u001a\u00020\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\bH\u0016J\"\u0010\u000e\u001a\u00020\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\bH\u0016J/\u0010\u0010\u001a\u00020\u0011*\u00020\u00122\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\"\u0010\u0018\u001a\u00020\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\bH\u0016J\"\u0010\u0019\u001a\u00020\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\bH\u0016R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001a"}, d2 = {"Landroidx/compose/animation/AnimatedContentMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "rootScope", "Landroidx/compose/animation/AnimatedContentScope;", "(Landroidx/compose/animation/AnimatedContentScope;)V", "getRootScope", "()Landroidx/compose/animation/AnimatedContentScope;", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "animation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class AnimatedContentMeasurePolicy implements MeasurePolicy {
    @NotNull
    private final AnimatedContentScope<?> rootScope;

    public AnimatedContentMeasurePolicy(@NotNull AnimatedContentScope<?> animatedContentScope) {
        Intrinsics.checkNotNullParameter(animatedContentScope, "rootScope");
        this.rootScope = animatedContentScope;
    }

    @NotNull
    public final AnimatedContentScope<?> getRootScope() {
        return this.rootScope;
    }

    public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        Integer num = (Integer) SequencesKt___SequencesKt.maxOrNull(SequencesKt___SequencesKt.map(CollectionsKt___CollectionsKt.asSequence(list), new AnimatedContentMeasurePolicy$maxIntrinsicHeight$1(i11)));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        Integer num = (Integer) SequencesKt___SequencesKt.maxOrNull(SequencesKt___SequencesKt.map(CollectionsKt___CollectionsKt.asSequence(list), new AnimatedContentMeasurePolicy$maxIntrinsicWidth$1(i11)));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: androidx.compose.ui.layout.Placeable[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v0, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v7, resolved type: androidx.compose.animation.AnimatedContentScope$ChildData} */
    /* JADX WARNING: type inference failed for: r10v0 */
    /* JADX WARNING: type inference failed for: r1v2, types: [androidx.compose.ui.layout.Placeable] */
    /* JADX WARNING: type inference failed for: r10v1, types: [androidx.compose.ui.layout.Placeable] */
    /* JADX WARNING: type inference failed for: r10v3, types: [androidx.compose.ui.layout.Placeable] */
    /* JADX WARNING: type inference failed for: r10v4 */
    /* JADX WARNING: type inference failed for: r4v3, types: [androidx.compose.ui.layout.Placeable] */
    /* JADX WARNING: type inference failed for: r10v5 */
    /* JADX WARNING: type inference failed for: r10v6 */
    /* JADX WARNING: type inference failed for: r1v7, types: [androidx.compose.ui.layout.Placeable] */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: type inference failed for: r9v5, types: [androidx.compose.ui.layout.Placeable] */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: type inference failed for: r10v12 */
    /* JADX WARNING: type inference failed for: r10v13 */
    /* JADX WARNING: type inference failed for: r10v14 */
    /* JADX WARNING: type inference failed for: r1v14 */
    /* JADX WARNING: type inference failed for: r1v15 */
    /* JADX WARNING: type inference failed for: r1v16 */
    /* JADX WARNING: type inference failed for: r10v15 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    @org.jetbrains.annotations.NotNull
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.compose.ui.layout.MeasureResult m10measure3p2s80s(@org.jetbrains.annotations.NotNull androidx.compose.ui.layout.MeasureScope r16, @org.jetbrains.annotations.NotNull java.util.List<? extends androidx.compose.ui.layout.Measurable> r17, long r18) {
        /*
            r15 = this;
            r0 = r15
            r1 = r17
            r2 = r18
            java.lang.String r4 = "$this$measure"
            r5 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r4)
            java.lang.String r4 = "measurables"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r4)
            int r4 = r17.size()
            androidx.compose.ui.layout.Placeable[] r6 = new androidx.compose.ui.layout.Placeable[r4]
            int r7 = r17.size()
            r8 = 0
            r9 = r8
        L_0x001d:
            r10 = 0
            r11 = 1
            if (r9 >= r7) goto L_0x0047
            java.lang.Object r12 = r1.get(r9)
            androidx.compose.ui.layout.Measurable r12 = (androidx.compose.ui.layout.Measurable) r12
            java.lang.Object r13 = r12.getParentData()
            boolean r14 = r13 instanceof androidx.compose.animation.AnimatedContentScope.ChildData
            if (r14 == 0) goto L_0x0032
            r10 = r13
            androidx.compose.animation.AnimatedContentScope$ChildData r10 = (androidx.compose.animation.AnimatedContentScope.ChildData) r10
        L_0x0032:
            if (r10 == 0) goto L_0x003b
            boolean r10 = r10.isTarget()
            if (r10 != r11) goto L_0x003b
            goto L_0x003c
        L_0x003b:
            r11 = r8
        L_0x003c:
            if (r11 == 0) goto L_0x0044
            androidx.compose.ui.layout.Placeable r10 = r12.m4508measureBRTryo0(r2)
            r6[r9] = r10
        L_0x0044:
            int r9 = r9 + 1
            goto L_0x001d
        L_0x0047:
            int r7 = r17.size()
            r9 = r8
        L_0x004c:
            if (r9 >= r7) goto L_0x0061
            java.lang.Object r12 = r1.get(r9)
            androidx.compose.ui.layout.Measurable r12 = (androidx.compose.ui.layout.Measurable) r12
            r13 = r6[r9]
            if (r13 != 0) goto L_0x005e
            androidx.compose.ui.layout.Placeable r12 = r12.m4508measureBRTryo0(r2)
            r6[r9] = r12
        L_0x005e:
            int r9 = r9 + 1
            goto L_0x004c
        L_0x0061:
            if (r4 != 0) goto L_0x0065
            r1 = r11
            goto L_0x0066
        L_0x0065:
            r1 = r8
        L_0x0066:
            if (r1 == 0) goto L_0x006a
            r1 = r10
            goto L_0x0091
        L_0x006a:
            r1 = r6[r8]
            int r2 = kotlin.collections.ArraysKt___ArraysKt.getLastIndex((T[]) r6)
            if (r2 != 0) goto L_0x0073
            goto L_0x0091
        L_0x0073:
            if (r1 == 0) goto L_0x007a
            int r3 = r1.getWidth()
            goto L_0x007b
        L_0x007a:
            r3 = r8
        L_0x007b:
            if (r11 > r2) goto L_0x0091
            r7 = r11
        L_0x007e:
            r9 = r6[r7]
            if (r9 == 0) goto L_0x0087
            int r12 = r9.getWidth()
            goto L_0x0088
        L_0x0087:
            r12 = r8
        L_0x0088:
            if (r3 >= r12) goto L_0x008c
            r1 = r9
            r3 = r12
        L_0x008c:
            if (r7 == r2) goto L_0x0091
            int r7 = r7 + 1
            goto L_0x007e
        L_0x0091:
            if (r1 == 0) goto L_0x0098
            int r1 = r1.getWidth()
            goto L_0x0099
        L_0x0098:
            r1 = r8
        L_0x0099:
            if (r4 != 0) goto L_0x009d
            r2 = r11
            goto L_0x009e
        L_0x009d:
            r2 = r8
        L_0x009e:
            if (r2 == 0) goto L_0x00a1
            goto L_0x00c7
        L_0x00a1:
            r10 = r6[r8]
            int r2 = kotlin.collections.ArraysKt___ArraysKt.getLastIndex((T[]) r6)
            if (r2 != 0) goto L_0x00aa
            goto L_0x00c7
        L_0x00aa:
            if (r10 == 0) goto L_0x00b1
            int r3 = r10.getHeight()
            goto L_0x00b2
        L_0x00b1:
            r3 = r8
        L_0x00b2:
            if (r11 > r2) goto L_0x00c7
        L_0x00b4:
            r4 = r6[r11]
            if (r4 == 0) goto L_0x00bd
            int r7 = r4.getHeight()
            goto L_0x00be
        L_0x00bd:
            r7 = r8
        L_0x00be:
            if (r3 >= r7) goto L_0x00c2
            r10 = r4
            r3 = r7
        L_0x00c2:
            if (r11 == r2) goto L_0x00c7
            int r11 = r11 + 1
            goto L_0x00b4
        L_0x00c7:
            if (r10 == 0) goto L_0x00cf
            int r2 = r10.getHeight()
            r7 = r2
            goto L_0x00d0
        L_0x00cf:
            r7 = r8
        L_0x00d0:
            androidx.compose.animation.AnimatedContentScope<?> r2 = r0.rootScope
            long r3 = androidx.compose.ui.unit.IntSizeKt.IntSize(r1, r7)
            r2.m22setMeasuredSizeozmzZPI$animation_release(r3)
            r8 = 0
            androidx.compose.animation.AnimatedContentMeasurePolicy$measure$3 r9 = new androidx.compose.animation.AnimatedContentMeasurePolicy$measure$3
            r9.<init>(r6, r15, r1, r7)
            r10 = 4
            r11 = 0
            r5 = r16
            r6 = r1
            androidx.compose.ui.layout.MeasureResult r1 = androidx.compose.ui.layout.MeasureScope.CC.p(r5, r6, r7, r8, r9, r10, r11)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedContentMeasurePolicy.m10measure3p2s80s(androidx.compose.ui.layout.MeasureScope, java.util.List, long):androidx.compose.ui.layout.MeasureResult");
    }

    public int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        Integer num = (Integer) SequencesKt___SequencesKt.maxOrNull(SequencesKt___SequencesKt.map(CollectionsKt___CollectionsKt.asSequence(list), new AnimatedContentMeasurePolicy$minIntrinsicHeight$1(i11)));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        Integer num = (Integer) SequencesKt___SequencesKt.maxOrNull(SequencesKt___SequencesKt.map(CollectionsKt___CollectionsKt.asSequence(list), new AnimatedContentMeasurePolicy$minIntrinsicWidth$1(i11)));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }
}
