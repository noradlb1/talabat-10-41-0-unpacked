package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.vector.PathNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aB\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\b2!\u0010%\u001a\u001d\u0012\u0013\u0012\u00110#¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0004\u0012\u00020!0&H\b\u001a\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020!0 *\u00020\u00012\u0006\u0010\"\u001a\u00020#H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"ArcToKey", "", "CloseKey", "CurveToKey", "HorizontalToKey", "LineToKey", "MoveToKey", "NUM_ARC_TO_ARGS", "", "NUM_CURVE_TO_ARGS", "NUM_HORIZONTAL_TO_ARGS", "NUM_LINE_TO_ARGS", "NUM_MOVE_TO_ARGS", "NUM_QUAD_TO_ARGS", "NUM_REFLECTIVE_CURVE_TO_ARGS", "NUM_REFLECTIVE_QUAD_TO_ARGS", "NUM_VERTICAL_TO_ARGS", "QuadToKey", "ReflectiveCurveToKey", "ReflectiveQuadToKey", "RelativeArcToKey", "RelativeCloseKey", "RelativeCurveToKey", "RelativeHorizontalToKey", "RelativeLineToKey", "RelativeMoveToKey", "RelativeQuadToKey", "RelativeReflectiveCurveToKey", "RelativeReflectiveQuadToKey", "RelativeVerticalToKey", "VerticalToKey", "pathNodesFromArgs", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "args", "", "numArgs", "nodeFor", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "subArray", "toPathNodes", "ui-graphics_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class PathNodeKt {
    private static final char ArcToKey = 'A';
    private static final char CloseKey = 'Z';
    private static final char CurveToKey = 'C';
    private static final char HorizontalToKey = 'H';
    private static final char LineToKey = 'L';
    private static final char MoveToKey = 'M';
    private static final int NUM_ARC_TO_ARGS = 7;
    private static final int NUM_CURVE_TO_ARGS = 6;
    private static final int NUM_HORIZONTAL_TO_ARGS = 1;
    private static final int NUM_LINE_TO_ARGS = 2;
    private static final int NUM_MOVE_TO_ARGS = 2;
    private static final int NUM_QUAD_TO_ARGS = 4;
    private static final int NUM_REFLECTIVE_CURVE_TO_ARGS = 4;
    private static final int NUM_REFLECTIVE_QUAD_TO_ARGS = 2;
    private static final int NUM_VERTICAL_TO_ARGS = 1;
    private static final char QuadToKey = 'Q';
    private static final char ReflectiveCurveToKey = 'S';
    private static final char ReflectiveQuadToKey = 'T';
    private static final char RelativeArcToKey = 'a';
    private static final char RelativeCloseKey = 'z';
    private static final char RelativeCurveToKey = 'c';
    private static final char RelativeHorizontalToKey = 'h';
    private static final char RelativeLineToKey = 'l';
    private static final char RelativeMoveToKey = 'm';
    private static final char RelativeQuadToKey = 'q';
    private static final char RelativeReflectiveCurveToKey = 's';
    private static final char RelativeReflectiveQuadToKey = 't';
    private static final char RelativeVerticalToKey = 'v';
    private static final char VerticalToKey = 'V';

    private static final List<PathNode> pathNodesFromArgs(float[] fArr, int i11, Function1<? super float[], ? extends PathNode> function1) {
        IntProgression step = RangesKt___RangesKt.step((IntProgression) new IntRange(0, fArr.length - i11), i11);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(step, 10));
        Iterator it = step.iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            float[] copyOfRange = ArraysKt___ArraysJvmKt.copyOfRange(fArr, nextInt, nextInt + i11);
            Object obj = (PathNode) function1.invoke(copyOfRange);
            if ((obj instanceof PathNode.MoveTo) && nextInt > 0) {
                obj = new PathNode.LineTo(copyOfRange[0], copyOfRange[1]);
            } else if ((obj instanceof PathNode.RelativeMoveTo) && nextInt > 0) {
                obj = new PathNode.RelativeLineTo(copyOfRange[0], copyOfRange[1]);
            }
            arrayList.add(obj);
        }
        return arrayList;
    }

    /* JADX WARNING: type inference failed for: r12v2, types: [androidx.compose.ui.graphics.vector.PathNode$RelativeLineTo] */
    /* JADX WARNING: type inference failed for: r12v3, types: [androidx.compose.ui.graphics.vector.PathNode$LineTo] */
    /* JADX WARNING: type inference failed for: r12v6, types: [androidx.compose.ui.graphics.vector.PathNode$RelativeLineTo] */
    /* JADX WARNING: type inference failed for: r12v7, types: [androidx.compose.ui.graphics.vector.PathNode$LineTo] */
    /* JADX WARNING: type inference failed for: r8v25, types: [androidx.compose.ui.graphics.vector.PathNode$RelativeLineTo] */
    /* JADX WARNING: type inference failed for: r8v26, types: [androidx.compose.ui.graphics.vector.PathNode$LineTo] */
    /* JADX WARNING: Code restructure failed: missing block: B:324:0x03c2, code lost:
        r11 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:359:0x0674, code lost:
        r19 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:364:0x06f2, code lost:
        r19 = r19;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.List<androidx.compose.ui.graphics.vector.PathNode> toPathNodes(char r27, @org.jetbrains.annotations.NotNull float[] r28) {
        /*
            r0 = r27
            r1 = r28
            java.lang.String r2 = "args"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r2 = 122(0x7a, float:1.71E-43)
            r3 = 1
            r4 = 0
            if (r0 != r2) goto L_0x0011
        L_0x000f:
            r2 = r3
            goto L_0x0017
        L_0x0011:
            r2 = 90
            if (r0 != r2) goto L_0x0016
            goto L_0x000f
        L_0x0016:
            r2 = r4
        L_0x0017:
            if (r2 == 0) goto L_0x0021
            androidx.compose.ui.graphics.vector.PathNode$Close r0 = androidx.compose.ui.graphics.vector.PathNode.Close.INSTANCE
            java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsJVMKt.listOf(r0)
            goto L_0x06f6
        L_0x0021:
            r2 = 109(0x6d, float:1.53E-43)
            r5 = 2
            r6 = 10
            if (r0 != r2) goto L_0x007e
            kotlin.ranges.IntRange r0 = new kotlin.ranges.IntRange
            int r2 = r1.length
            int r2 = r2 - r5
            r0.<init>(r4, r2)
            kotlin.ranges.IntProgression r0 = kotlin.ranges.RangesKt___RangesKt.step((kotlin.ranges.IntProgression) r0, (int) r5)
            java.util.ArrayList r2 = new java.util.ArrayList
            int r5 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r0, r6)
            r2.<init>(r5)
            java.util.Iterator r0 = r0.iterator()
        L_0x0040:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x007b
            r5 = r0
            kotlin.collections.IntIterator r5 = (kotlin.collections.IntIterator) r5
            int r5 = r5.nextInt()
            int r6 = r5 + 2
            float[] r6 = kotlin.collections.ArraysKt___ArraysJvmKt.copyOfRange((float[]) r1, (int) r5, (int) r6)
            androidx.compose.ui.graphics.vector.PathNode$RelativeMoveTo r7 = new androidx.compose.ui.graphics.vector.PathNode$RelativeMoveTo
            r8 = r6[r4]
            r9 = r6[r3]
            r7.<init>(r8, r9)
            boolean r8 = r7 instanceof androidx.compose.ui.graphics.vector.PathNode.MoveTo
            if (r8 == 0) goto L_0x006c
            if (r5 <= 0) goto L_0x006c
            androidx.compose.ui.graphics.vector.PathNode$LineTo r7 = new androidx.compose.ui.graphics.vector.PathNode$LineTo
            r5 = r6[r4]
            r6 = r6[r3]
            r7.<init>(r5, r6)
            goto L_0x0077
        L_0x006c:
            if (r5 <= 0) goto L_0x0077
            androidx.compose.ui.graphics.vector.PathNode$RelativeLineTo r7 = new androidx.compose.ui.graphics.vector.PathNode$RelativeLineTo
            r5 = r6[r4]
            r6 = r6[r3]
            r7.<init>(r5, r6)
        L_0x0077:
            r2.add(r7)
            goto L_0x0040
        L_0x007b:
            r0 = r2
            goto L_0x06f6
        L_0x007e:
            r2 = 77
            if (r0 != r2) goto L_0x00d5
            kotlin.ranges.IntRange r0 = new kotlin.ranges.IntRange
            int r2 = r1.length
            int r2 = r2 - r5
            r0.<init>(r4, r2)
            kotlin.ranges.IntProgression r0 = kotlin.ranges.RangesKt___RangesKt.step((kotlin.ranges.IntProgression) r0, (int) r5)
            java.util.ArrayList r2 = new java.util.ArrayList
            int r5 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r0, r6)
            r2.<init>(r5)
            java.util.Iterator r0 = r0.iterator()
        L_0x009a:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x007b
            r5 = r0
            kotlin.collections.IntIterator r5 = (kotlin.collections.IntIterator) r5
            int r5 = r5.nextInt()
            int r6 = r5 + 2
            float[] r6 = kotlin.collections.ArraysKt___ArraysJvmKt.copyOfRange((float[]) r1, (int) r5, (int) r6)
            androidx.compose.ui.graphics.vector.PathNode$MoveTo r7 = new androidx.compose.ui.graphics.vector.PathNode$MoveTo
            r8 = r6[r4]
            r9 = r6[r3]
            r7.<init>(r8, r9)
            if (r5 <= 0) goto L_0x00c2
            androidx.compose.ui.graphics.vector.PathNode$LineTo r7 = new androidx.compose.ui.graphics.vector.PathNode$LineTo
            r5 = r6[r4]
            r6 = r6[r3]
            r7.<init>(r5, r6)
            goto L_0x00d1
        L_0x00c2:
            boolean r8 = r7 instanceof androidx.compose.ui.graphics.vector.PathNode.RelativeMoveTo
            if (r8 == 0) goto L_0x00d1
            if (r5 <= 0) goto L_0x00d1
            androidx.compose.ui.graphics.vector.PathNode$RelativeLineTo r7 = new androidx.compose.ui.graphics.vector.PathNode$RelativeLineTo
            r5 = r6[r4]
            r6 = r6[r3]
            r7.<init>(r5, r6)
        L_0x00d1:
            r2.add(r7)
            goto L_0x009a
        L_0x00d5:
            r2 = 108(0x6c, float:1.51E-43)
            if (r0 != r2) goto L_0x0130
            kotlin.ranges.IntRange r0 = new kotlin.ranges.IntRange
            int r2 = r1.length
            int r2 = r2 - r5
            r0.<init>(r4, r2)
            kotlin.ranges.IntProgression r0 = kotlin.ranges.RangesKt___RangesKt.step((kotlin.ranges.IntProgression) r0, (int) r5)
            java.util.ArrayList r2 = new java.util.ArrayList
            int r5 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r0, r6)
            r2.<init>(r5)
            java.util.Iterator r0 = r0.iterator()
        L_0x00f1:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x007b
            r5 = r0
            kotlin.collections.IntIterator r5 = (kotlin.collections.IntIterator) r5
            int r5 = r5.nextInt()
            int r6 = r5 + 2
            float[] r6 = kotlin.collections.ArraysKt___ArraysJvmKt.copyOfRange((float[]) r1, (int) r5, (int) r6)
            androidx.compose.ui.graphics.vector.PathNode$RelativeLineTo r7 = new androidx.compose.ui.graphics.vector.PathNode$RelativeLineTo
            r8 = r6[r4]
            r9 = r6[r3]
            r7.<init>(r8, r9)
            boolean r8 = r7 instanceof androidx.compose.ui.graphics.vector.PathNode.MoveTo
            if (r8 == 0) goto L_0x011d
            if (r5 <= 0) goto L_0x011d
            androidx.compose.ui.graphics.vector.PathNode$LineTo r7 = new androidx.compose.ui.graphics.vector.PathNode$LineTo
            r5 = r6[r4]
            r6 = r6[r3]
            r7.<init>(r5, r6)
            goto L_0x012c
        L_0x011d:
            boolean r8 = r7 instanceof androidx.compose.ui.graphics.vector.PathNode.RelativeMoveTo
            if (r8 == 0) goto L_0x012c
            if (r5 <= 0) goto L_0x012c
            androidx.compose.ui.graphics.vector.PathNode$RelativeLineTo r7 = new androidx.compose.ui.graphics.vector.PathNode$RelativeLineTo
            r5 = r6[r4]
            r6 = r6[r3]
            r7.<init>(r5, r6)
        L_0x012c:
            r2.add(r7)
            goto L_0x00f1
        L_0x0130:
            r2 = 76
            if (r0 != r2) goto L_0x018b
            kotlin.ranges.IntRange r0 = new kotlin.ranges.IntRange
            int r2 = r1.length
            int r2 = r2 - r5
            r0.<init>(r4, r2)
            kotlin.ranges.IntProgression r0 = kotlin.ranges.RangesKt___RangesKt.step((kotlin.ranges.IntProgression) r0, (int) r5)
            java.util.ArrayList r2 = new java.util.ArrayList
            int r5 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r0, r6)
            r2.<init>(r5)
            java.util.Iterator r0 = r0.iterator()
        L_0x014c:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x007b
            r5 = r0
            kotlin.collections.IntIterator r5 = (kotlin.collections.IntIterator) r5
            int r5 = r5.nextInt()
            int r6 = r5 + 2
            float[] r6 = kotlin.collections.ArraysKt___ArraysJvmKt.copyOfRange((float[]) r1, (int) r5, (int) r6)
            androidx.compose.ui.graphics.vector.PathNode$LineTo r7 = new androidx.compose.ui.graphics.vector.PathNode$LineTo
            r8 = r6[r4]
            r9 = r6[r3]
            r7.<init>(r8, r9)
            boolean r8 = r7 instanceof androidx.compose.ui.graphics.vector.PathNode.MoveTo
            if (r8 == 0) goto L_0x0178
            if (r5 <= 0) goto L_0x0178
            androidx.compose.ui.graphics.vector.PathNode$LineTo r7 = new androidx.compose.ui.graphics.vector.PathNode$LineTo
            r5 = r6[r4]
            r6 = r6[r3]
            r7.<init>(r5, r6)
            goto L_0x0187
        L_0x0178:
            boolean r8 = r7 instanceof androidx.compose.ui.graphics.vector.PathNode.RelativeMoveTo
            if (r8 == 0) goto L_0x0187
            if (r5 <= 0) goto L_0x0187
            androidx.compose.ui.graphics.vector.PathNode$RelativeLineTo r7 = new androidx.compose.ui.graphics.vector.PathNode$RelativeLineTo
            r5 = r6[r4]
            r6 = r6[r3]
            r7.<init>(r5, r6)
        L_0x0187:
            r2.add(r7)
            goto L_0x014c
        L_0x018b:
            r2 = 104(0x68, float:1.46E-43)
            if (r0 != r2) goto L_0x01e4
            kotlin.ranges.IntRange r0 = new kotlin.ranges.IntRange
            int r2 = r1.length
            int r2 = r2 - r3
            r0.<init>(r4, r2)
            kotlin.ranges.IntProgression r0 = kotlin.ranges.RangesKt___RangesKt.step((kotlin.ranges.IntProgression) r0, (int) r3)
            java.util.ArrayList r2 = new java.util.ArrayList
            int r5 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r0, r6)
            r2.<init>(r5)
            java.util.Iterator r0 = r0.iterator()
        L_0x01a7:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x007b
            r5 = r0
            kotlin.collections.IntIterator r5 = (kotlin.collections.IntIterator) r5
            int r5 = r5.nextInt()
            int r6 = r5 + 1
            float[] r6 = kotlin.collections.ArraysKt___ArraysJvmKt.copyOfRange((float[]) r1, (int) r5, (int) r6)
            androidx.compose.ui.graphics.vector.PathNode$RelativeHorizontalTo r7 = new androidx.compose.ui.graphics.vector.PathNode$RelativeHorizontalTo
            r8 = r6[r4]
            r7.<init>(r8)
            boolean r8 = r7 instanceof androidx.compose.ui.graphics.vector.PathNode.MoveTo
            if (r8 == 0) goto L_0x01d1
            if (r5 <= 0) goto L_0x01d1
            androidx.compose.ui.graphics.vector.PathNode$LineTo r7 = new androidx.compose.ui.graphics.vector.PathNode$LineTo
            r5 = r6[r4]
            r6 = r6[r3]
            r7.<init>(r5, r6)
            goto L_0x01e0
        L_0x01d1:
            boolean r8 = r7 instanceof androidx.compose.ui.graphics.vector.PathNode.RelativeMoveTo
            if (r8 == 0) goto L_0x01e0
            if (r5 <= 0) goto L_0x01e0
            androidx.compose.ui.graphics.vector.PathNode$RelativeLineTo r7 = new androidx.compose.ui.graphics.vector.PathNode$RelativeLineTo
            r5 = r6[r4]
            r6 = r6[r3]
            r7.<init>(r5, r6)
        L_0x01e0:
            r2.add(r7)
            goto L_0x01a7
        L_0x01e4:
            r2 = 72
            if (r0 != r2) goto L_0x023d
            kotlin.ranges.IntRange r0 = new kotlin.ranges.IntRange
            int r2 = r1.length
            int r2 = r2 - r3
            r0.<init>(r4, r2)
            kotlin.ranges.IntProgression r0 = kotlin.ranges.RangesKt___RangesKt.step((kotlin.ranges.IntProgression) r0, (int) r3)
            java.util.ArrayList r2 = new java.util.ArrayList
            int r5 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r0, r6)
            r2.<init>(r5)
            java.util.Iterator r0 = r0.iterator()
        L_0x0200:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x007b
            r5 = r0
            kotlin.collections.IntIterator r5 = (kotlin.collections.IntIterator) r5
            int r5 = r5.nextInt()
            int r6 = r5 + 1
            float[] r6 = kotlin.collections.ArraysKt___ArraysJvmKt.copyOfRange((float[]) r1, (int) r5, (int) r6)
            androidx.compose.ui.graphics.vector.PathNode$HorizontalTo r7 = new androidx.compose.ui.graphics.vector.PathNode$HorizontalTo
            r8 = r6[r4]
            r7.<init>(r8)
            boolean r8 = r7 instanceof androidx.compose.ui.graphics.vector.PathNode.MoveTo
            if (r8 == 0) goto L_0x022a
            if (r5 <= 0) goto L_0x022a
            androidx.compose.ui.graphics.vector.PathNode$LineTo r7 = new androidx.compose.ui.graphics.vector.PathNode$LineTo
            r5 = r6[r4]
            r6 = r6[r3]
            r7.<init>(r5, r6)
            goto L_0x0239
        L_0x022a:
            boolean r8 = r7 instanceof androidx.compose.ui.graphics.vector.PathNode.RelativeMoveTo
            if (r8 == 0) goto L_0x0239
            if (r5 <= 0) goto L_0x0239
            androidx.compose.ui.graphics.vector.PathNode$RelativeLineTo r7 = new androidx.compose.ui.graphics.vector.PathNode$RelativeLineTo
            r5 = r6[r4]
            r6 = r6[r3]
            r7.<init>(r5, r6)
        L_0x0239:
            r2.add(r7)
            goto L_0x0200
        L_0x023d:
            r2 = 118(0x76, float:1.65E-43)
            if (r0 != r2) goto L_0x0296
            kotlin.ranges.IntRange r0 = new kotlin.ranges.IntRange
            int r2 = r1.length
            int r2 = r2 - r3
            r0.<init>(r4, r2)
            kotlin.ranges.IntProgression r0 = kotlin.ranges.RangesKt___RangesKt.step((kotlin.ranges.IntProgression) r0, (int) r3)
            java.util.ArrayList r2 = new java.util.ArrayList
            int r5 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r0, r6)
            r2.<init>(r5)
            java.util.Iterator r0 = r0.iterator()
        L_0x0259:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x007b
            r5 = r0
            kotlin.collections.IntIterator r5 = (kotlin.collections.IntIterator) r5
            int r5 = r5.nextInt()
            int r6 = r5 + 1
            float[] r6 = kotlin.collections.ArraysKt___ArraysJvmKt.copyOfRange((float[]) r1, (int) r5, (int) r6)
            androidx.compose.ui.graphics.vector.PathNode$RelativeVerticalTo r7 = new androidx.compose.ui.graphics.vector.PathNode$RelativeVerticalTo
            r8 = r6[r4]
            r7.<init>(r8)
            boolean r8 = r7 instanceof androidx.compose.ui.graphics.vector.PathNode.MoveTo
            if (r8 == 0) goto L_0x0283
            if (r5 <= 0) goto L_0x0283
            androidx.compose.ui.graphics.vector.PathNode$LineTo r7 = new androidx.compose.ui.graphics.vector.PathNode$LineTo
            r5 = r6[r4]
            r6 = r6[r3]
            r7.<init>(r5, r6)
            goto L_0x0292
        L_0x0283:
            boolean r8 = r7 instanceof androidx.compose.ui.graphics.vector.PathNode.RelativeMoveTo
            if (r8 == 0) goto L_0x0292
            if (r5 <= 0) goto L_0x0292
            androidx.compose.ui.graphics.vector.PathNode$RelativeLineTo r7 = new androidx.compose.ui.graphics.vector.PathNode$RelativeLineTo
            r5 = r6[r4]
            r6 = r6[r3]
            r7.<init>(r5, r6)
        L_0x0292:
            r2.add(r7)
            goto L_0x0259
        L_0x0296:
            r2 = 86
            if (r0 != r2) goto L_0x02ef
            kotlin.ranges.IntRange r0 = new kotlin.ranges.IntRange
            int r2 = r1.length
            int r2 = r2 - r3
            r0.<init>(r4, r2)
            kotlin.ranges.IntProgression r0 = kotlin.ranges.RangesKt___RangesKt.step((kotlin.ranges.IntProgression) r0, (int) r3)
            java.util.ArrayList r2 = new java.util.ArrayList
            int r5 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r0, r6)
            r2.<init>(r5)
            java.util.Iterator r0 = r0.iterator()
        L_0x02b2:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x007b
            r5 = r0
            kotlin.collections.IntIterator r5 = (kotlin.collections.IntIterator) r5
            int r5 = r5.nextInt()
            int r6 = r5 + 1
            float[] r6 = kotlin.collections.ArraysKt___ArraysJvmKt.copyOfRange((float[]) r1, (int) r5, (int) r6)
            androidx.compose.ui.graphics.vector.PathNode$VerticalTo r7 = new androidx.compose.ui.graphics.vector.PathNode$VerticalTo
            r8 = r6[r4]
            r7.<init>(r8)
            boolean r8 = r7 instanceof androidx.compose.ui.graphics.vector.PathNode.MoveTo
            if (r8 == 0) goto L_0x02dc
            if (r5 <= 0) goto L_0x02dc
            androidx.compose.ui.graphics.vector.PathNode$LineTo r7 = new androidx.compose.ui.graphics.vector.PathNode$LineTo
            r5 = r6[r4]
            r6 = r6[r3]
            r7.<init>(r5, r6)
            goto L_0x02eb
        L_0x02dc:
            boolean r8 = r7 instanceof androidx.compose.ui.graphics.vector.PathNode.RelativeMoveTo
            if (r8 == 0) goto L_0x02eb
            if (r5 <= 0) goto L_0x02eb
            androidx.compose.ui.graphics.vector.PathNode$RelativeLineTo r7 = new androidx.compose.ui.graphics.vector.PathNode$RelativeLineTo
            r5 = r6[r4]
            r6 = r6[r3]
            r7.<init>(r5, r6)
        L_0x02eb:
            r2.add(r7)
            goto L_0x02b2
        L_0x02ef:
            r2 = 99
            r7 = 5
            r8 = 6
            r9 = 3
            r10 = 4
            if (r0 != r2) goto L_0x0361
            kotlin.ranges.IntRange r0 = new kotlin.ranges.IntRange
            int r2 = r1.length
            int r2 = r2 - r8
            r0.<init>(r4, r2)
            kotlin.ranges.IntProgression r0 = kotlin.ranges.RangesKt___RangesKt.step((kotlin.ranges.IntProgression) r0, (int) r8)
            java.util.ArrayList r2 = new java.util.ArrayList
            int r6 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r0, r6)
            r2.<init>(r6)
            java.util.Iterator r0 = r0.iterator()
        L_0x030f:
            boolean r6 = r0.hasNext()
            if (r6 == 0) goto L_0x007b
            r6 = r0
            kotlin.collections.IntIterator r6 = (kotlin.collections.IntIterator) r6
            int r6 = r6.nextInt()
            int r8 = r6 + 6
            float[] r8 = kotlin.collections.ArraysKt___ArraysJvmKt.copyOfRange((float[]) r1, (int) r6, (int) r8)
            androidx.compose.ui.graphics.vector.PathNode$RelativeCurveTo r15 = new androidx.compose.ui.graphics.vector.PathNode$RelativeCurveTo
            r12 = r8[r4]
            r13 = r8[r3]
            r14 = r8[r5]
            r16 = r8[r9]
            r17 = r8[r10]
            r18 = r8[r7]
            r11 = r15
            r7 = r15
            r15 = r16
            r16 = r17
            r17 = r18
            r11.<init>(r12, r13, r14, r15, r16, r17)
            boolean r11 = r7 instanceof androidx.compose.ui.graphics.vector.PathNode.MoveTo
            if (r11 == 0) goto L_0x034b
            if (r6 <= 0) goto L_0x034b
            androidx.compose.ui.graphics.vector.PathNode$LineTo r15 = new androidx.compose.ui.graphics.vector.PathNode$LineTo
            r6 = r8[r4]
            r7 = r8[r3]
            r15.<init>(r6, r7)
            goto L_0x035c
        L_0x034b:
            boolean r11 = r7 instanceof androidx.compose.ui.graphics.vector.PathNode.RelativeMoveTo
            if (r11 == 0) goto L_0x035b
            if (r6 <= 0) goto L_0x035b
            androidx.compose.ui.graphics.vector.PathNode$RelativeLineTo r15 = new androidx.compose.ui.graphics.vector.PathNode$RelativeLineTo
            r6 = r8[r4]
            r7 = r8[r3]
            r15.<init>(r6, r7)
            goto L_0x035c
        L_0x035b:
            r15 = r7
        L_0x035c:
            r2.add(r15)
            r7 = 5
            goto L_0x030f
        L_0x0361:
            r2 = 67
            if (r0 != r2) goto L_0x03c6
            kotlin.ranges.IntRange r0 = new kotlin.ranges.IntRange
            int r2 = r1.length
            int r2 = r2 - r8
            r0.<init>(r4, r2)
            kotlin.ranges.IntProgression r0 = kotlin.ranges.RangesKt___RangesKt.step((kotlin.ranges.IntProgression) r0, (int) r8)
            java.util.ArrayList r2 = new java.util.ArrayList
            int r6 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r0, r6)
            r2.<init>(r6)
            java.util.Iterator r0 = r0.iterator()
        L_0x037d:
            boolean r6 = r0.hasNext()
            if (r6 == 0) goto L_0x007b
            r6 = r0
            kotlin.collections.IntIterator r6 = (kotlin.collections.IntIterator) r6
            int r6 = r6.nextInt()
            int r7 = r6 + 6
            float[] r7 = kotlin.collections.ArraysKt___ArraysJvmKt.copyOfRange((float[]) r1, (int) r6, (int) r7)
            androidx.compose.ui.graphics.vector.PathNode$CurveTo r8 = new androidx.compose.ui.graphics.vector.PathNode$CurveTo
            r12 = r7[r4]
            r13 = r7[r3]
            r14 = r7[r5]
            r15 = r7[r9]
            r16 = r7[r10]
            r11 = 5
            r17 = r7[r11]
            r11 = r8
            r11.<init>(r12, r13, r14, r15, r16, r17)
            boolean r11 = r8 instanceof androidx.compose.ui.graphics.vector.PathNode.MoveTo
            if (r11 == 0) goto L_0x03b3
            if (r6 <= 0) goto L_0x03b3
            androidx.compose.ui.graphics.vector.PathNode$LineTo r8 = new androidx.compose.ui.graphics.vector.PathNode$LineTo
            r6 = r7[r4]
            r7 = r7[r3]
            r8.<init>(r6, r7)
            goto L_0x03c2
        L_0x03b3:
            boolean r11 = r8 instanceof androidx.compose.ui.graphics.vector.PathNode.RelativeMoveTo
            if (r11 == 0) goto L_0x03c2
            if (r6 <= 0) goto L_0x03c2
            androidx.compose.ui.graphics.vector.PathNode$RelativeLineTo r8 = new androidx.compose.ui.graphics.vector.PathNode$RelativeLineTo
            r6 = r7[r4]
            r7 = r7[r3]
            r8.<init>(r6, r7)
        L_0x03c2:
            r2.add(r8)
            goto L_0x037d
        L_0x03c6:
            r2 = 115(0x73, float:1.61E-43)
            if (r0 != r2) goto L_0x0425
            kotlin.ranges.IntRange r0 = new kotlin.ranges.IntRange
            int r2 = r1.length
            int r2 = r2 - r10
            r0.<init>(r4, r2)
            kotlin.ranges.IntProgression r0 = kotlin.ranges.RangesKt___RangesKt.step((kotlin.ranges.IntProgression) r0, (int) r10)
            java.util.ArrayList r2 = new java.util.ArrayList
            int r6 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r0, r6)
            r2.<init>(r6)
            java.util.Iterator r0 = r0.iterator()
        L_0x03e2:
            boolean r6 = r0.hasNext()
            if (r6 == 0) goto L_0x007b
            r6 = r0
            kotlin.collections.IntIterator r6 = (kotlin.collections.IntIterator) r6
            int r6 = r6.nextInt()
            int r7 = r6 + 4
            float[] r7 = kotlin.collections.ArraysKt___ArraysJvmKt.copyOfRange((float[]) r1, (int) r6, (int) r7)
            androidx.compose.ui.graphics.vector.PathNode$RelativeReflectiveCurveTo r8 = new androidx.compose.ui.graphics.vector.PathNode$RelativeReflectiveCurveTo
            r10 = r7[r4]
            r11 = r7[r3]
            r12 = r7[r5]
            r13 = r7[r9]
            r8.<init>(r10, r11, r12, r13)
            boolean r10 = r8 instanceof androidx.compose.ui.graphics.vector.PathNode.MoveTo
            if (r10 == 0) goto L_0x0412
            if (r6 <= 0) goto L_0x0412
            androidx.compose.ui.graphics.vector.PathNode$LineTo r8 = new androidx.compose.ui.graphics.vector.PathNode$LineTo
            r6 = r7[r4]
            r7 = r7[r3]
            r8.<init>(r6, r7)
            goto L_0x0421
        L_0x0412:
            boolean r10 = r8 instanceof androidx.compose.ui.graphics.vector.PathNode.RelativeMoveTo
            if (r10 == 0) goto L_0x0421
            if (r6 <= 0) goto L_0x0421
            androidx.compose.ui.graphics.vector.PathNode$RelativeLineTo r8 = new androidx.compose.ui.graphics.vector.PathNode$RelativeLineTo
            r6 = r7[r4]
            r7 = r7[r3]
            r8.<init>(r6, r7)
        L_0x0421:
            r2.add(r8)
            goto L_0x03e2
        L_0x0425:
            r2 = 83
            if (r0 != r2) goto L_0x0484
            kotlin.ranges.IntRange r0 = new kotlin.ranges.IntRange
            int r2 = r1.length
            int r2 = r2 - r10
            r0.<init>(r4, r2)
            kotlin.ranges.IntProgression r0 = kotlin.ranges.RangesKt___RangesKt.step((kotlin.ranges.IntProgression) r0, (int) r10)
            java.util.ArrayList r2 = new java.util.ArrayList
            int r6 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r0, r6)
            r2.<init>(r6)
            java.util.Iterator r0 = r0.iterator()
        L_0x0441:
            boolean r6 = r0.hasNext()
            if (r6 == 0) goto L_0x007b
            r6 = r0
            kotlin.collections.IntIterator r6 = (kotlin.collections.IntIterator) r6
            int r6 = r6.nextInt()
            int r7 = r6 + 4
            float[] r7 = kotlin.collections.ArraysKt___ArraysJvmKt.copyOfRange((float[]) r1, (int) r6, (int) r7)
            androidx.compose.ui.graphics.vector.PathNode$ReflectiveCurveTo r8 = new androidx.compose.ui.graphics.vector.PathNode$ReflectiveCurveTo
            r10 = r7[r4]
            r11 = r7[r3]
            r12 = r7[r5]
            r13 = r7[r9]
            r8.<init>(r10, r11, r12, r13)
            boolean r10 = r8 instanceof androidx.compose.ui.graphics.vector.PathNode.MoveTo
            if (r10 == 0) goto L_0x0471
            if (r6 <= 0) goto L_0x0471
            androidx.compose.ui.graphics.vector.PathNode$LineTo r8 = new androidx.compose.ui.graphics.vector.PathNode$LineTo
            r6 = r7[r4]
            r7 = r7[r3]
            r8.<init>(r6, r7)
            goto L_0x0480
        L_0x0471:
            boolean r10 = r8 instanceof androidx.compose.ui.graphics.vector.PathNode.RelativeMoveTo
            if (r10 == 0) goto L_0x0480
            if (r6 <= 0) goto L_0x0480
            androidx.compose.ui.graphics.vector.PathNode$RelativeLineTo r8 = new androidx.compose.ui.graphics.vector.PathNode$RelativeLineTo
            r6 = r7[r4]
            r7 = r7[r3]
            r8.<init>(r6, r7)
        L_0x0480:
            r2.add(r8)
            goto L_0x0441
        L_0x0484:
            r2 = 113(0x71, float:1.58E-43)
            if (r0 != r2) goto L_0x04e3
            kotlin.ranges.IntRange r0 = new kotlin.ranges.IntRange
            int r2 = r1.length
            int r2 = r2 - r10
            r0.<init>(r4, r2)
            kotlin.ranges.IntProgression r0 = kotlin.ranges.RangesKt___RangesKt.step((kotlin.ranges.IntProgression) r0, (int) r10)
            java.util.ArrayList r2 = new java.util.ArrayList
            int r6 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r0, r6)
            r2.<init>(r6)
            java.util.Iterator r0 = r0.iterator()
        L_0x04a0:
            boolean r6 = r0.hasNext()
            if (r6 == 0) goto L_0x007b
            r6 = r0
            kotlin.collections.IntIterator r6 = (kotlin.collections.IntIterator) r6
            int r6 = r6.nextInt()
            int r7 = r6 + 4
            float[] r7 = kotlin.collections.ArraysKt___ArraysJvmKt.copyOfRange((float[]) r1, (int) r6, (int) r7)
            androidx.compose.ui.graphics.vector.PathNode$RelativeQuadTo r8 = new androidx.compose.ui.graphics.vector.PathNode$RelativeQuadTo
            r10 = r7[r4]
            r11 = r7[r3]
            r12 = r7[r5]
            r13 = r7[r9]
            r8.<init>(r10, r11, r12, r13)
            boolean r10 = r8 instanceof androidx.compose.ui.graphics.vector.PathNode.MoveTo
            if (r10 == 0) goto L_0x04d0
            if (r6 <= 0) goto L_0x04d0
            androidx.compose.ui.graphics.vector.PathNode$LineTo r8 = new androidx.compose.ui.graphics.vector.PathNode$LineTo
            r6 = r7[r4]
            r7 = r7[r3]
            r8.<init>(r6, r7)
            goto L_0x04df
        L_0x04d0:
            boolean r10 = r8 instanceof androidx.compose.ui.graphics.vector.PathNode.RelativeMoveTo
            if (r10 == 0) goto L_0x04df
            if (r6 <= 0) goto L_0x04df
            androidx.compose.ui.graphics.vector.PathNode$RelativeLineTo r8 = new androidx.compose.ui.graphics.vector.PathNode$RelativeLineTo
            r6 = r7[r4]
            r7 = r7[r3]
            r8.<init>(r6, r7)
        L_0x04df:
            r2.add(r8)
            goto L_0x04a0
        L_0x04e3:
            r2 = 81
            if (r0 != r2) goto L_0x0542
            kotlin.ranges.IntRange r0 = new kotlin.ranges.IntRange
            int r2 = r1.length
            int r2 = r2 - r10
            r0.<init>(r4, r2)
            kotlin.ranges.IntProgression r0 = kotlin.ranges.RangesKt___RangesKt.step((kotlin.ranges.IntProgression) r0, (int) r10)
            java.util.ArrayList r2 = new java.util.ArrayList
            int r6 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r0, r6)
            r2.<init>(r6)
            java.util.Iterator r0 = r0.iterator()
        L_0x04ff:
            boolean r6 = r0.hasNext()
            if (r6 == 0) goto L_0x007b
            r6 = r0
            kotlin.collections.IntIterator r6 = (kotlin.collections.IntIterator) r6
            int r6 = r6.nextInt()
            int r7 = r6 + 4
            float[] r7 = kotlin.collections.ArraysKt___ArraysJvmKt.copyOfRange((float[]) r1, (int) r6, (int) r7)
            androidx.compose.ui.graphics.vector.PathNode$QuadTo r8 = new androidx.compose.ui.graphics.vector.PathNode$QuadTo
            r10 = r7[r4]
            r11 = r7[r3]
            r12 = r7[r5]
            r13 = r7[r9]
            r8.<init>(r10, r11, r12, r13)
            boolean r10 = r8 instanceof androidx.compose.ui.graphics.vector.PathNode.MoveTo
            if (r10 == 0) goto L_0x052f
            if (r6 <= 0) goto L_0x052f
            androidx.compose.ui.graphics.vector.PathNode$LineTo r8 = new androidx.compose.ui.graphics.vector.PathNode$LineTo
            r6 = r7[r4]
            r7 = r7[r3]
            r8.<init>(r6, r7)
            goto L_0x053e
        L_0x052f:
            boolean r10 = r8 instanceof androidx.compose.ui.graphics.vector.PathNode.RelativeMoveTo
            if (r10 == 0) goto L_0x053e
            if (r6 <= 0) goto L_0x053e
            androidx.compose.ui.graphics.vector.PathNode$RelativeLineTo r8 = new androidx.compose.ui.graphics.vector.PathNode$RelativeLineTo
            r6 = r7[r4]
            r7 = r7[r3]
            r8.<init>(r6, r7)
        L_0x053e:
            r2.add(r8)
            goto L_0x04ff
        L_0x0542:
            r2 = 116(0x74, float:1.63E-43)
            if (r0 != r2) goto L_0x059d
            kotlin.ranges.IntRange r0 = new kotlin.ranges.IntRange
            int r2 = r1.length
            int r2 = r2 - r5
            r0.<init>(r4, r2)
            kotlin.ranges.IntProgression r0 = kotlin.ranges.RangesKt___RangesKt.step((kotlin.ranges.IntProgression) r0, (int) r5)
            java.util.ArrayList r2 = new java.util.ArrayList
            int r5 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r0, r6)
            r2.<init>(r5)
            java.util.Iterator r0 = r0.iterator()
        L_0x055e:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x007b
            r5 = r0
            kotlin.collections.IntIterator r5 = (kotlin.collections.IntIterator) r5
            int r5 = r5.nextInt()
            int r6 = r5 + 2
            float[] r6 = kotlin.collections.ArraysKt___ArraysJvmKt.copyOfRange((float[]) r1, (int) r5, (int) r6)
            androidx.compose.ui.graphics.vector.PathNode$RelativeReflectiveQuadTo r7 = new androidx.compose.ui.graphics.vector.PathNode$RelativeReflectiveQuadTo
            r8 = r6[r4]
            r9 = r6[r3]
            r7.<init>(r8, r9)
            boolean r8 = r7 instanceof androidx.compose.ui.graphics.vector.PathNode.MoveTo
            if (r8 == 0) goto L_0x058a
            if (r5 <= 0) goto L_0x058a
            androidx.compose.ui.graphics.vector.PathNode$LineTo r7 = new androidx.compose.ui.graphics.vector.PathNode$LineTo
            r5 = r6[r4]
            r6 = r6[r3]
            r7.<init>(r5, r6)
            goto L_0x0599
        L_0x058a:
            boolean r8 = r7 instanceof androidx.compose.ui.graphics.vector.PathNode.RelativeMoveTo
            if (r8 == 0) goto L_0x0599
            if (r5 <= 0) goto L_0x0599
            androidx.compose.ui.graphics.vector.PathNode$RelativeLineTo r7 = new androidx.compose.ui.graphics.vector.PathNode$RelativeLineTo
            r5 = r6[r4]
            r6 = r6[r3]
            r7.<init>(r5, r6)
        L_0x0599:
            r2.add(r7)
            goto L_0x055e
        L_0x059d:
            r2 = 84
            if (r0 != r2) goto L_0x05f8
            kotlin.ranges.IntRange r0 = new kotlin.ranges.IntRange
            int r2 = r1.length
            int r2 = r2 - r5
            r0.<init>(r4, r2)
            kotlin.ranges.IntProgression r0 = kotlin.ranges.RangesKt___RangesKt.step((kotlin.ranges.IntProgression) r0, (int) r5)
            java.util.ArrayList r2 = new java.util.ArrayList
            int r5 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r0, r6)
            r2.<init>(r5)
            java.util.Iterator r0 = r0.iterator()
        L_0x05b9:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x007b
            r5 = r0
            kotlin.collections.IntIterator r5 = (kotlin.collections.IntIterator) r5
            int r5 = r5.nextInt()
            int r6 = r5 + 2
            float[] r6 = kotlin.collections.ArraysKt___ArraysJvmKt.copyOfRange((float[]) r1, (int) r5, (int) r6)
            androidx.compose.ui.graphics.vector.PathNode$ReflectiveQuadTo r7 = new androidx.compose.ui.graphics.vector.PathNode$ReflectiveQuadTo
            r8 = r6[r4]
            r9 = r6[r3]
            r7.<init>(r8, r9)
            boolean r8 = r7 instanceof androidx.compose.ui.graphics.vector.PathNode.MoveTo
            if (r8 == 0) goto L_0x05e5
            if (r5 <= 0) goto L_0x05e5
            androidx.compose.ui.graphics.vector.PathNode$LineTo r7 = new androidx.compose.ui.graphics.vector.PathNode$LineTo
            r5 = r6[r4]
            r6 = r6[r3]
            r7.<init>(r5, r6)
            goto L_0x05f4
        L_0x05e5:
            boolean r8 = r7 instanceof androidx.compose.ui.graphics.vector.PathNode.RelativeMoveTo
            if (r8 == 0) goto L_0x05f4
            if (r5 <= 0) goto L_0x05f4
            androidx.compose.ui.graphics.vector.PathNode$RelativeLineTo r7 = new androidx.compose.ui.graphics.vector.PathNode$RelativeLineTo
            r5 = r6[r4]
            r6 = r6[r3]
            r7.<init>(r5, r6)
        L_0x05f4:
            r2.add(r7)
            goto L_0x05b9
        L_0x05f8:
            r2 = 97
            r7 = 7
            r11 = 0
            if (r0 != r2) goto L_0x0678
            kotlin.ranges.IntRange r0 = new kotlin.ranges.IntRange
            int r2 = r1.length
            int r2 = r2 - r7
            r0.<init>(r4, r2)
            kotlin.ranges.IntProgression r0 = kotlin.ranges.RangesKt___RangesKt.step((kotlin.ranges.IntProgression) r0, (int) r7)
            java.util.ArrayList r2 = new java.util.ArrayList
            int r6 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r0, r6)
            r2.<init>(r6)
            java.util.Iterator r0 = r0.iterator()
        L_0x0616:
            boolean r6 = r0.hasNext()
            if (r6 == 0) goto L_0x007b
            r6 = r0
            kotlin.collections.IntIterator r6 = (kotlin.collections.IntIterator) r6
            int r6 = r6.nextInt()
            int r7 = r6 + 7
            float[] r7 = kotlin.collections.ArraysKt___ArraysJvmKt.copyOfRange((float[]) r1, (int) r6, (int) r7)
            androidx.compose.ui.graphics.vector.PathNode$RelativeArcTo r12 = new androidx.compose.ui.graphics.vector.PathNode$RelativeArcTo
            r20 = r7[r4]
            r21 = r7[r3]
            r22 = r7[r5]
            r13 = r7[r9]
            int r13 = java.lang.Float.compare(r13, r11)
            if (r13 == 0) goto L_0x063c
            r23 = r3
            goto L_0x063e
        L_0x063c:
            r23 = r4
        L_0x063e:
            r13 = r7[r10]
            int r13 = java.lang.Float.compare(r13, r11)
            if (r13 == 0) goto L_0x0649
            r24 = r3
            goto L_0x064b
        L_0x0649:
            r24 = r4
        L_0x064b:
            r13 = 5
            r25 = r7[r13]
            r26 = r7[r8]
            r19 = r12
            r19.<init>(r20, r21, r22, r23, r24, r25, r26)
            boolean r13 = r12 instanceof androidx.compose.ui.graphics.vector.PathNode.MoveTo
            if (r13 == 0) goto L_0x0665
            if (r6 <= 0) goto L_0x0665
            androidx.compose.ui.graphics.vector.PathNode$LineTo r12 = new androidx.compose.ui.graphics.vector.PathNode$LineTo
            r6 = r7[r4]
            r7 = r7[r3]
            r12.<init>(r6, r7)
            goto L_0x0674
        L_0x0665:
            boolean r13 = r12 instanceof androidx.compose.ui.graphics.vector.PathNode.RelativeMoveTo
            if (r13 == 0) goto L_0x0674
            if (r6 <= 0) goto L_0x0674
            androidx.compose.ui.graphics.vector.PathNode$RelativeLineTo r12 = new androidx.compose.ui.graphics.vector.PathNode$RelativeLineTo
            r6 = r7[r4]
            r7 = r7[r3]
            r12.<init>(r6, r7)
        L_0x0674:
            r2.add(r12)
            goto L_0x0616
        L_0x0678:
            r2 = 65
            if (r0 != r2) goto L_0x06f7
            kotlin.ranges.IntRange r0 = new kotlin.ranges.IntRange
            int r2 = r1.length
            int r2 = r2 - r7
            r0.<init>(r4, r2)
            kotlin.ranges.IntProgression r0 = kotlin.ranges.RangesKt___RangesKt.step((kotlin.ranges.IntProgression) r0, (int) r7)
            java.util.ArrayList r2 = new java.util.ArrayList
            int r6 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r0, r6)
            r2.<init>(r6)
            java.util.Iterator r0 = r0.iterator()
        L_0x0694:
            boolean r6 = r0.hasNext()
            if (r6 == 0) goto L_0x007b
            r6 = r0
            kotlin.collections.IntIterator r6 = (kotlin.collections.IntIterator) r6
            int r6 = r6.nextInt()
            int r7 = r6 + 7
            float[] r7 = kotlin.collections.ArraysKt___ArraysJvmKt.copyOfRange((float[]) r1, (int) r6, (int) r7)
            androidx.compose.ui.graphics.vector.PathNode$ArcTo r12 = new androidx.compose.ui.graphics.vector.PathNode$ArcTo
            r20 = r7[r4]
            r21 = r7[r3]
            r22 = r7[r5]
            r13 = r7[r9]
            int r13 = java.lang.Float.compare(r13, r11)
            if (r13 == 0) goto L_0x06ba
            r23 = r3
            goto L_0x06bc
        L_0x06ba:
            r23 = r4
        L_0x06bc:
            r13 = r7[r10]
            int r13 = java.lang.Float.compare(r13, r11)
            if (r13 == 0) goto L_0x06c7
            r24 = r3
            goto L_0x06c9
        L_0x06c7:
            r24 = r4
        L_0x06c9:
            r13 = 5
            r25 = r7[r13]
            r26 = r7[r8]
            r19 = r12
            r19.<init>(r20, r21, r22, r23, r24, r25, r26)
            boolean r14 = r12 instanceof androidx.compose.ui.graphics.vector.PathNode.MoveTo
            if (r14 == 0) goto L_0x06e3
            if (r6 <= 0) goto L_0x06e3
            androidx.compose.ui.graphics.vector.PathNode$LineTo r12 = new androidx.compose.ui.graphics.vector.PathNode$LineTo
            r6 = r7[r4]
            r7 = r7[r3]
            r12.<init>(r6, r7)
            goto L_0x06f2
        L_0x06e3:
            boolean r14 = r12 instanceof androidx.compose.ui.graphics.vector.PathNode.RelativeMoveTo
            if (r14 == 0) goto L_0x06f2
            if (r6 <= 0) goto L_0x06f2
            androidx.compose.ui.graphics.vector.PathNode$RelativeLineTo r12 = new androidx.compose.ui.graphics.vector.PathNode$RelativeLineTo
            r6 = r7[r4]
            r7 = r7[r3]
            r12.<init>(r6, r7)
        L_0x06f2:
            r2.add(r12)
            goto L_0x0694
        L_0x06f6:
            return r0
        L_0x06f7:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Unknown command for: "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.PathNodeKt.toPathNodes(char, float[]):java.util.List");
    }
}
