package androidx.compose.ui.tooling.data;

import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.CompositionGroup;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.layout.ModifierInfo;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000x\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a\u0010\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020#H\u0002\u001a(\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\u000e\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010(0%2\b\u0010)\u001a\u0004\u0018\u00010*H\u0003\u001a\u0014\u0010+\u001a\u0004\u0018\u00010\u00062\b\u0010,\u001a\u0004\u0018\u00010(H\u0003\u001a\u0016\u0010-\u001a\b\u0012\u0004\u0012\u00020.0%2\u0006\u0010/\u001a\u00020\u0006H\u0002\u001a\u001a\u00100\u001a\u00020*2\u0006\u00101\u001a\u00020\u00062\b\u00102\u001a\u0004\u0018\u00010*H\u0003\u001a\u001a\u00103\u001a\u0004\u0018\u000104*\u0006\u0012\u0002\b\u0003052\u0006\u00106\u001a\u00020\u0006H\u0002\u001a\f\u00107\u001a\u00020\u0019*\u000208H\u0007\u001a\f\u00109\u001a\u00020\u0006*\u00020\u0015H\u0002\u001a\u0016\u0010:\u001a\u00020\u0019*\u00020;2\b\u0010<\u001a\u0004\u0018\u00010*H\u0003\u001a\f\u0010=\u001a\u00020\u0014*\u00020\u0015H\u0002\u001a\u0014\u0010>\u001a\u00020\u0014*\u00020\u00152\u0006\u0010?\u001a\u00020\u0006H\u0002\u001a\f\u0010@\u001a\u00020\u0014*\u00020\u0015H\u0002\u001a\f\u0010A\u001a\u00020\u0014*\u00020\u0015H\u0002\u001a\f\u0010B\u001a\u00020\u0014*\u00020\u0015H\u0002\u001a\f\u0010C\u001a\u00020\u0001*\u00020\u0015H\u0002\u001a\u001c\u0010D\u001a\u00020\u0006*\u00020\u00062\u0006\u0010E\u001a\u00020\u00062\u0006\u0010F\u001a\u00020\u0006H\u0002\u001a\u0014\u0010G\u001a\u00020\t*\u00020\t2\u0006\u0010H\u001a\u00020\tH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000\"\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000\"\u0018\u0010\u0013\u001a\u00020\u0014*\u00020\u00158BX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0016\"\u0018\u0010\u0017\u001a\u00020\u0014*\u00020\u00158BX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0016\" \u0010\u0018\u001a\u0004\u0018\u00010\u0006*\u00020\u00198GX\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0018\u0010\u001e\u001a\u00020\u0006*\u00020\u00158BX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006I"}, d2 = {"BITS_PER_SLOT", "", "SLOT_MASK", "STABLE_BITS", "STATIC_BITS", "changedFieldName", "", "defaultFieldName", "emptyBox", "Landroidx/compose/ui/unit/IntRect;", "getEmptyBox", "()Landroidx/compose/ui/unit/IntRect;", "internalFieldPrefix", "jacocoDataField", "parameterPrefix", "parametersInformationTokenizer", "Lkotlin/text/Regex;", "recomposeScopeNameSuffix", "tokenizer", "isANumber", "", "Lkotlin/text/MatchResult;", "(Lkotlin/text/MatchResult;)Z", "isClassName", "position", "Landroidx/compose/ui/tooling/data/Group;", "getPosition$annotations", "(Landroidx/compose/ui/tooling/data/Group;)V", "getPosition", "(Landroidx/compose/ui/tooling/data/Group;)Ljava/lang/String;", "text", "getText", "(Lkotlin/text/MatchResult;)Ljava/lang/String;", "boundsOfLayoutNode", "node", "Landroidx/compose/ui/layout/LayoutInfo;", "extractParameterInfo", "", "Landroidx/compose/ui/tooling/data/ParameterInformation;", "data", "", "context", "Landroidx/compose/ui/tooling/data/SourceInformationContext;", "keyPosition", "key", "parseParameters", "Landroidx/compose/ui/tooling/data/Parameter;", "parameters", "sourceInformationContextOf", "information", "parent", "accessibleField", "Ljava/lang/reflect/Field;", "Ljava/lang/Class;", "name", "asTree", "Landroidx/compose/runtime/tooling/CompositionData;", "callName", "getGroup", "Landroidx/compose/runtime/tooling/CompositionGroup;", "parentContext", "isCallWithName", "isChar", "c", "isFileName", "isNumber", "isParameterInformation", "number", "replacePrefix", "prefix", "replacement", "union", "other", "ui-tooling-data_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class SlotTreeKt {
    private static final int BITS_PER_SLOT = 3;
    private static final int SLOT_MASK = 7;
    private static final int STABLE_BITS = 4;
    private static final int STATIC_BITS = 3;
    @NotNull
    private static final String changedFieldName = "$$changed";
    @NotNull
    private static final String defaultFieldName = "$$default";
    @NotNull
    private static final IntRect emptyBox = new IntRect(0, 0, 0, 0);
    @NotNull
    private static final String internalFieldPrefix = "$$";
    @NotNull
    private static final String jacocoDataField = "$jacoco";
    @NotNull
    private static final String parameterPrefix = "$";
    @NotNull
    private static final Regex parametersInformationTokenizer = new Regex("(\\d+)|,|[!P()]|:([^,!)]+)");
    @NotNull
    private static final String recomposeScopeNameSuffix = ".RecomposeScopeImpl";
    @NotNull
    private static final Regex tokenizer = new Regex("(\\d+)|([,])|([*])|([:])|L|(P\\([^)]*\\))|(C(\\(([^)]*)\\))?)|@");

    private static final Field accessibleField(Class<?> cls, String str) {
        Field field;
        Field[] declaredFields = cls.getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(declaredFields, "declaredFields");
        int length = declaredFields.length;
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                field = null;
                break;
            }
            field = declaredFields[i11];
            if (Intrinsics.areEqual((Object) field.getName(), (Object) str)) {
                break;
            }
            i11++;
        }
        if (field == null) {
            return null;
        }
        field.setAccessible(true);
        return field;
    }

    @NotNull
    @UiToolingDataApi
    public static final Group asTree(@NotNull CompositionData compositionData) {
        Intrinsics.checkNotNullParameter(compositionData, "<this>");
        CompositionGroup compositionGroup = (CompositionGroup) CollectionsKt___CollectionsKt.firstOrNull(compositionData.getCompositionGroups());
        if (compositionGroup == null) {
            return EmptyGroup.INSTANCE;
        }
        return getGroup(compositionGroup, (SourceInformationContext) null);
    }

    private static final IntRect boundsOfLayoutNode(LayoutInfo layoutInfo) {
        if (!layoutInfo.isAttached()) {
            return new IntRect(0, 0, layoutInfo.getWidth(), layoutInfo.getHeight());
        }
        long positionInWindow = LayoutCoordinatesKt.positionInWindow(layoutInfo.getCoordinates());
        long r22 = layoutInfo.getCoordinates().m4473getSizeYbymL2g();
        int roundToInt = MathKt__MathJVMKt.roundToInt(Offset.m2676getXimpl(positionInWindow));
        int roundToInt2 = MathKt__MathJVMKt.roundToInt(Offset.m2677getYimpl(positionInWindow));
        return new IntRect(roundToInt, roundToInt2, IntSize.m5638getWidthimpl(r22) + roundToInt, IntSize.m5637getHeightimpl(r22) + roundToInt2);
    }

    private static final String callName(MatchResult matchResult) {
        return matchResult.getGroupValues().get(8);
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00d9 A[Catch:{ all -> 0x018b }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0041 A[EDGE_INSN: B:90:0x0041->B:13:0x0041 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x00dc A[SYNTHETIC] */
    @androidx.compose.ui.tooling.data.UiToolingDataApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final java.util.List<androidx.compose.ui.tooling.data.ParameterInformation> extractParameterInfo(java.util.List<? extends java.lang.Object> r22, androidx.compose.ui.tooling.data.SourceInformationContext r23) {
        /*
            java.lang.String r0 = "it.name"
            r1 = r22
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            r2 = 1
            r1 = r1 ^ r2
            if (r1 == 0) goto L_0x018b
            r1 = r22
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x0016:
            boolean r3 = r1.hasNext()
            r4 = 2
            r5 = 0
            r6 = 0
            if (r3 == 0) goto L_0x0040
            java.lang.Object r3 = r1.next()
            if (r3 == 0) goto L_0x003c
            java.lang.Class r7 = r3.getClass()
            java.lang.String r7 = r7.getName()
            java.lang.String r8 = "it.javaClass.name"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            java.lang.String r8 = ".RecomposeScopeImpl"
            boolean r7 = kotlin.text.StringsKt__StringsJVMKt.endsWith$default(r7, r8, r6, r4, r5)
            if (r7 == 0) goto L_0x003c
            r7 = r2
            goto L_0x003d
        L_0x003c:
            r7 = r6
        L_0x003d:
            if (r7 == 0) goto L_0x0016
            goto L_0x0041
        L_0x0040:
            r3 = r5
        L_0x0041:
            if (r3 == 0) goto L_0x018b
            java.lang.Class r1 = r3.getClass()     // Catch:{ all -> 0x018b }
            java.lang.String r7 = "block"
            java.lang.reflect.Field r1 = accessibleField(r1, r7)     // Catch:{ all -> 0x018b }
            if (r1 == 0) goto L_0x018b
            java.lang.Object r1 = r1.get(r3)     // Catch:{ all -> 0x018b }
            if (r1 == 0) goto L_0x018b
            java.lang.Class r3 = r1.getClass()     // Catch:{ all -> 0x018b }
            java.lang.String r7 = "$$default"
            java.lang.reflect.Field r7 = accessibleField(r3, r7)     // Catch:{ all -> 0x018b }
            java.lang.String r8 = "$$changed"
            java.lang.reflect.Field r8 = accessibleField(r3, r8)     // Catch:{ all -> 0x018b }
            java.lang.String r9 = "null cannot be cast to non-null type kotlin.Int"
            if (r7 == 0) goto L_0x007c
            java.lang.Object r7 = r7.get(r1)     // Catch:{ all -> 0x018b }
            if (r7 == 0) goto L_0x0076
            java.lang.Integer r7 = (java.lang.Integer) r7     // Catch:{ all -> 0x018b }
            int r7 = r7.intValue()     // Catch:{ all -> 0x018b }
            goto L_0x007d
        L_0x0076:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch:{ all -> 0x018b }
            r0.<init>(r9)     // Catch:{ all -> 0x018b }
            throw r0     // Catch:{ all -> 0x018b }
        L_0x007c:
            r7 = r6
        L_0x007d:
            if (r8 == 0) goto L_0x0092
            java.lang.Object r8 = r8.get(r1)     // Catch:{ all -> 0x018b }
            if (r8 == 0) goto L_0x008c
            java.lang.Integer r8 = (java.lang.Integer) r8     // Catch:{ all -> 0x018b }
            int r8 = r8.intValue()     // Catch:{ all -> 0x018b }
            goto L_0x0093
        L_0x008c:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch:{ all -> 0x018b }
            r0.<init>(r9)     // Catch:{ all -> 0x018b }
            throw r0     // Catch:{ all -> 0x018b }
        L_0x0092:
            r8 = r6
        L_0x0093:
            java.lang.reflect.Field[] r3 = r3.getDeclaredFields()     // Catch:{ all -> 0x018b }
            java.lang.String r9 = "blockClass.declaredFields"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r9)     // Catch:{ all -> 0x018b }
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ all -> 0x018b }
            r9.<init>()     // Catch:{ all -> 0x018b }
            int r10 = r3.length     // Catch:{ all -> 0x018b }
            r11 = r6
        L_0x00a3:
            if (r11 >= r10) goto L_0x00df
            r12 = r3[r11]     // Catch:{ all -> 0x018b }
            java.lang.String r13 = r12.getName()     // Catch:{ all -> 0x018b }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r0)     // Catch:{ all -> 0x018b }
            java.lang.String r14 = "$"
            boolean r13 = kotlin.text.StringsKt__StringsJVMKt.startsWith$default(r13, r14, r6, r4, r5)     // Catch:{ all -> 0x018b }
            if (r13 == 0) goto L_0x00d6
            java.lang.String r13 = r12.getName()     // Catch:{ all -> 0x018b }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r0)     // Catch:{ all -> 0x018b }
            java.lang.String r14 = "$$"
            boolean r13 = kotlin.text.StringsKt__StringsJVMKt.startsWith$default(r13, r14, r6, r4, r5)     // Catch:{ all -> 0x018b }
            if (r13 != 0) goto L_0x00d6
            java.lang.String r13 = r12.getName()     // Catch:{ all -> 0x018b }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r0)     // Catch:{ all -> 0x018b }
            java.lang.String r14 = "$jacoco"
            boolean r13 = kotlin.text.StringsKt__StringsJVMKt.startsWith$default(r13, r14, r6, r4, r5)     // Catch:{ all -> 0x018b }
            if (r13 != 0) goto L_0x00d6
            r13 = r2
            goto L_0x00d7
        L_0x00d6:
            r13 = r6
        L_0x00d7:
            if (r13 == 0) goto L_0x00dc
            r9.add(r12)     // Catch:{ all -> 0x018b }
        L_0x00dc:
            int r11 = r11 + 1
            goto L_0x00a3
        L_0x00df:
            androidx.compose.ui.tooling.data.SlotTreeKt$extractParameterInfo$$inlined$sortedBy$1 r0 = new androidx.compose.ui.tooling.data.SlotTreeKt$extractParameterInfo$$inlined$sortedBy$1     // Catch:{ all -> 0x018b }
            r0.<init>()     // Catch:{ all -> 0x018b }
            java.util.List r0 = kotlin.collections.CollectionsKt___CollectionsKt.sortedWith(r9, r0)     // Catch:{ all -> 0x018b }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x018b }
            r3.<init>()     // Catch:{ all -> 0x018b }
            if (r23 != 0) goto L_0x00f1
            r9 = r5
            goto L_0x00f5
        L_0x00f1:
            java.util.List r9 = r23.getParameters()     // Catch:{ all -> 0x018b }
        L_0x00f5:
            if (r9 != 0) goto L_0x00fb
            java.util.List r9 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()     // Catch:{ all -> 0x018b }
        L_0x00fb:
            int r10 = r0.size()     // Catch:{ all -> 0x018b }
            r11 = r6
        L_0x0100:
            if (r11 >= r10) goto L_0x018a
            int r12 = r9.size()     // Catch:{ all -> 0x018b }
            if (r11 >= r12) goto L_0x010f
            java.lang.Object r12 = r9.get(r11)     // Catch:{ all -> 0x018b }
            androidx.compose.ui.tooling.data.Parameter r12 = (androidx.compose.ui.tooling.data.Parameter) r12     // Catch:{ all -> 0x018b }
            goto L_0x0114
        L_0x010f:
            androidx.compose.ui.tooling.data.Parameter r12 = new androidx.compose.ui.tooling.data.Parameter     // Catch:{ all -> 0x018b }
            r12.<init>(r11, r5, r4, r5)     // Catch:{ all -> 0x018b }
        L_0x0114:
            int r13 = r12.getSortedIndex()     // Catch:{ all -> 0x018b }
            int r14 = r0.size()     // Catch:{ all -> 0x018b }
            if (r13 < r14) goto L_0x0120
            goto L_0x0185
        L_0x0120:
            int r13 = r12.getSortedIndex()     // Catch:{ all -> 0x018b }
            java.lang.Object r13 = r0.get(r13)     // Catch:{ all -> 0x018b }
            java.lang.reflect.Field r13 = (java.lang.reflect.Field) r13     // Catch:{ all -> 0x018b }
            r13.setAccessible(r2)     // Catch:{ all -> 0x018b }
            java.lang.Object r16 = r13.get(r1)     // Catch:{ all -> 0x018b }
            int r14 = r2 << r11
            r14 = r14 & r7
            if (r14 == 0) goto L_0x0139
            r17 = r2
            goto L_0x013b
        L_0x0139:
            r17 = r6
        L_0x013b:
            int r14 = r11 * 3
            int r14 = r14 + r2
            r15 = 7
            int r15 = r15 << r14
            r15 = r15 & r8
            int r14 = r15 >> r14
            r15 = r14 & 3
            r4 = 3
            if (r15 != r4) goto L_0x014b
            r18 = r2
            goto L_0x014d
        L_0x014b:
            r18 = r6
        L_0x014d:
            if (r15 != 0) goto L_0x0151
            r4 = r2
            goto L_0x0152
        L_0x0151:
            r4 = r6
        L_0x0152:
            r14 = r14 & 4
            if (r14 != 0) goto L_0x0159
            r21 = r2
            goto L_0x015b
        L_0x0159:
            r21 = r6
        L_0x015b:
            androidx.compose.ui.tooling.data.ParameterInformation r15 = new androidx.compose.ui.tooling.data.ParameterInformation     // Catch:{ all -> 0x018b }
            java.lang.String r13 = r13.getName()     // Catch:{ all -> 0x018b }
            java.lang.String r14 = "field.name"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r14)     // Catch:{ all -> 0x018b }
            java.lang.String r13 = r13.substring(r2)     // Catch:{ all -> 0x018b }
            java.lang.String r14 = "(this as java.lang.String).substring(startIndex)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r14)     // Catch:{ all -> 0x018b }
            if (r4 == 0) goto L_0x0176
            if (r17 != 0) goto L_0x0176
            r19 = r2
            goto L_0x0178
        L_0x0176:
            r19 = r6
        L_0x0178:
            java.lang.String r20 = r12.getInlineClass()     // Catch:{ all -> 0x018b }
            r14 = r15
            r4 = r15
            r15 = r13
            r14.<init>(r15, r16, r17, r18, r19, r20, r21)     // Catch:{ all -> 0x018b }
            r3.add(r4)     // Catch:{ all -> 0x018b }
        L_0x0185:
            int r11 = r11 + 1
            r4 = 2
            goto L_0x0100
        L_0x018a:
            return r3
        L_0x018b:
            java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.data.SlotTreeKt.extractParameterInfo(java.util.List, androidx.compose.ui.tooling.data.SourceInformationContext):java.util.List");
    }

    @NotNull
    public static final IntRect getEmptyBox() {
        return emptyBox;
    }

    @UiToolingDataApi
    private static final Group getGroup(CompositionGroup compositionGroup, SourceInformationContext sourceInformationContext) {
        SourceInformationContext sourceInformationContext2;
        List<ModifierInfo> list;
        IntRect intRect;
        String str;
        SourceLocation sourceLocation;
        Object key = compositionGroup.getKey();
        String sourceInfo = compositionGroup.getSourceInfo();
        if (sourceInfo == null) {
            sourceInformationContext2 = null;
        } else {
            sourceInformationContext2 = sourceInformationContextOf(sourceInfo, sourceInformationContext);
        }
        Object node = compositionGroup.getNode();
        ArrayList arrayList = new ArrayList();
        ArrayList<Group> arrayList2 = new ArrayList<>();
        boolean unused = CollectionsKt__MutableCollectionsKt.addAll(arrayList, compositionGroup.getData());
        for (CompositionGroup group : compositionGroup.getCompositionGroups()) {
            arrayList2.add(getGroup(group, sourceInformationContext2));
        }
        boolean z11 = node instanceof LayoutInfo;
        if (z11) {
            list = ((LayoutInfo) node).getModifierInfo();
        } else {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        List<ModifierInfo> list2 = list;
        if (z11) {
            intRect = boundsOfLayoutNode((LayoutInfo) node);
        } else if (arrayList2.isEmpty()) {
            intRect = emptyBox;
        } else {
            ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10));
            for (Group box : arrayList2) {
                arrayList3.add(box.getBox());
            }
            Iterator it = arrayList3.iterator();
            if (it.hasNext()) {
                Object next = it.next();
                while (it.hasNext()) {
                    next = union((IntRect) it.next(), (IntRect) next);
                }
                intRect = (IntRect) next;
            } else {
                throw new UnsupportedOperationException("Empty collection can't be reduced.");
            }
        }
        if (node != null) {
            return new NodeGroup(key, node, intRect, arrayList, list2, arrayList2);
        }
        if (sourceInformationContext2 == null) {
            str = null;
        } else {
            str = sourceInformationContext2.getName();
        }
        if (sourceInformationContext2 == null || !sourceInformationContext2.isCall() || sourceInformationContext == null) {
            sourceLocation = null;
        } else {
            sourceLocation = sourceInformationContext.nextSourceLocation();
        }
        return new CallGroup(key, str, intRect, sourceLocation, extractParameterInfo(arrayList, sourceInformationContext2), arrayList, arrayList2);
    }

    @Nullable
    @UiToolingDataApi
    public static final String getPosition(@NotNull Group group) {
        Intrinsics.checkNotNullParameter(group, "<this>");
        return keyPosition(group.getKey());
    }

    @UiToolingDataApi
    public static /* synthetic */ void getPosition$annotations(Group group) {
    }

    private static final String getText(MatchResult matchResult) {
        return matchResult.getGroupValues().get(0);
    }

    private static final boolean isANumber(MatchResult matchResult) {
        return matchResult.getGroups().get(1) != null;
    }

    private static final boolean isCallWithName(MatchResult matchResult) {
        return matchResult.getGroups().get(6) != null;
    }

    private static final boolean isChar(MatchResult matchResult, String str) {
        return Intrinsics.areEqual((Object) getText(matchResult), (Object) str);
    }

    private static final boolean isClassName(MatchResult matchResult) {
        return matchResult.getGroups().get(2) != null;
    }

    private static final boolean isFileName(MatchResult matchResult) {
        return matchResult.getGroups().get(4) != null;
    }

    private static final boolean isNumber(MatchResult matchResult) {
        return matchResult.getGroups().get(1) != null;
    }

    private static final boolean isParameterInformation(MatchResult matchResult) {
        return matchResult.getGroups().get(5) != null;
    }

    @UiToolingDataApi
    private static final String keyPosition(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (!(obj instanceof JoinedKey)) {
            return null;
        }
        JoinedKey joinedKey = (JoinedKey) obj;
        String keyPosition = keyPosition(joinedKey.getLeft());
        if (keyPosition == null) {
            return keyPosition(joinedKey.getRight());
        }
        return keyPosition;
    }

    private static final int number(MatchResult matchResult) {
        return Integer.parseInt(matchResult.getGroupValues().get(1));
    }

    private static final List<Parameter> parseParameters(String str) {
        String str2;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = Regex.find$default(parametersInformationTokenizer, str, 0, 2, (Object) null);
        List mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(0, 1, 2, 3);
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = mutableListOf.size() - 1;
        ArrayList arrayList = new ArrayList();
        try {
            parseParameters$expect(objectRef, "P");
            parseParameters$expect(objectRef, "(");
            while (!parseParameters$isChar(objectRef, ")")) {
                if (parseParameters$isChar(objectRef, "!")) {
                    parseParameters$next(objectRef);
                    int parseParameters$expectNumber = parseParameters$expectNumber(objectRef);
                    parseParameters$ensureIndexes(intRef, mutableListOf, arrayList.size() + parseParameters$expectNumber);
                    for (int i11 = 0; i11 < parseParameters$expectNumber; i11++) {
                        arrayList.add(new Parameter(((Number) CollectionsKt___CollectionsKt.first(mutableListOf)).intValue(), (String) null, 2, (DefaultConstructorMarker) null));
                        mutableListOf.remove(0);
                    }
                } else if (parseParameters$isChar(objectRef, ",")) {
                    parseParameters$next(objectRef);
                } else {
                    int parseParameters$expectNumber2 = parseParameters$expectNumber(objectRef);
                    if (parseParameters$isClassName(objectRef)) {
                        str2 = parseParameters$expectClassName(objectRef);
                    } else {
                        str2 = null;
                    }
                    arrayList.add(new Parameter(parseParameters$expectNumber2, str2));
                    parseParameters$ensureIndexes(intRef, mutableListOf, parseParameters$expectNumber2);
                    mutableListOf.remove(Integer.valueOf(parseParameters$expectNumber2));
                }
            }
            parseParameters$expect(objectRef, ")");
            while (mutableListOf.size() > 0) {
                arrayList.add(new Parameter(((Number) CollectionsKt___CollectionsKt.first(mutableListOf)).intValue(), (String) null, 2, (DefaultConstructorMarker) null));
                mutableListOf.remove(0);
            }
            return arrayList;
        } catch (ParseError unused) {
            return CollectionsKt__CollectionsKt.emptyList();
        } catch (NumberFormatException unused2) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
    }

    private static final void parseParameters$ensureIndexes(Ref.IntRef intRef, List<Integer> list, int i11) {
        int i12 = i11 - intRef.element;
        if (i12 > 0) {
            if (i12 < 4) {
                i12 = 4;
            }
            for (int i13 = 0; i13 < i12; i13++) {
                list.add(Integer.valueOf(intRef.element + i13 + 1));
            }
            intRef.element += i12;
        }
    }

    private static final void parseParameters$expect(Ref.ObjectRef<MatchResult> objectRef, String str) {
        MatchResult matchResult = (MatchResult) objectRef.element;
        if (matchResult == null || !Intrinsics.areEqual((Object) getText(matchResult), (Object) str)) {
            throw new ParseError();
        }
        parseParameters$next(objectRef);
    }

    private static final String parseParameters$expectClassName(Ref.ObjectRef<MatchResult> objectRef) {
        MatchResult matchResult = (MatchResult) objectRef.element;
        if (matchResult == null || !isClassName(matchResult)) {
            throw new ParseError();
        }
        parseParameters$next(objectRef);
        String text = getText(matchResult);
        if (text != null) {
            String substring = text.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
            return replacePrefix(substring, "c#", "androidx.compose.");
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    private static final int parseParameters$expectNumber(Ref.ObjectRef<MatchResult> objectRef) {
        MatchResult matchResult = (MatchResult) objectRef.element;
        if (matchResult == null || !isANumber(matchResult)) {
            throw new ParseError();
        }
        parseParameters$next(objectRef);
        return Integer.parseInt(getText(matchResult));
    }

    private static final boolean parseParameters$isChar(Ref.ObjectRef<MatchResult> objectRef, String str) {
        MatchResult matchResult = (MatchResult) objectRef.element;
        if (matchResult == null || Intrinsics.areEqual((Object) getText(matchResult), (Object) str)) {
            return true;
        }
        return false;
    }

    private static final boolean parseParameters$isClassName(Ref.ObjectRef<MatchResult> objectRef) {
        MatchResult matchResult = (MatchResult) objectRef.element;
        if (matchResult == null || !isClassName(matchResult)) {
            return false;
        }
        return true;
    }

    private static final MatchResult parseParameters$next(Ref.ObjectRef<MatchResult> objectRef) {
        MatchResult matchResult = (MatchResult) objectRef.element;
        if (matchResult != null) {
            objectRef.element = matchResult.next();
        }
        return (MatchResult) objectRef.element;
    }

    private static final String replacePrefix(String str, String str2, String str3) {
        if (!StringsKt__StringsJVMKt.startsWith$default(str, str2, false, 2, (Object) null)) {
            return str;
        }
        int length = str2.length();
        if (str != null) {
            String substring = str.substring(length);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
            return Intrinsics.stringPlus(str3, substring);
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0100  */
    @androidx.compose.ui.tooling.data.UiToolingDataApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final androidx.compose.ui.tooling.data.SourceInformationContext sourceInformationContextOf(java.lang.String r13, androidx.compose.ui.tooling.data.SourceInformationContext r14) {
        /*
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef
            r0.<init>()
            kotlin.text.Regex r1 = tokenizer
            r2 = 0
            r3 = 2
            r4 = 0
            kotlin.text.MatchResult r1 = kotlin.text.Regex.find$default(r1, r13, r2, r3, r4)
            r0.element = r1
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            r1 = -1
            r10 = r1
            r12 = r2
            r6 = r4
            r11 = r6
        L_0x001a:
            T r3 = r0.element
            if (r3 == 0) goto L_0x00f2
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            kotlin.text.MatchResult r3 = (kotlin.text.MatchResult) r3
            boolean r5 = isNumber(r3)
            r7 = 1
            if (r5 != 0) goto L_0x00d1
            java.lang.String r5 = "@"
            boolean r5 = isChar(r3, r5)
            if (r5 == 0) goto L_0x0034
            goto L_0x00d1
        L_0x0034:
            java.lang.String r5 = "C"
            boolean r5 = isChar(r3, r5)
            if (r5 == 0) goto L_0x0042
            m5409sourceInformationContextOf$next4(r0)
        L_0x003f:
            r12 = r7
            goto L_0x00db
        L_0x0042:
            boolean r5 = isCallWithName(r3)
            if (r5 == 0) goto L_0x0050
            java.lang.String r6 = callName(r3)
            m5409sourceInformationContextOf$next4(r0)
            goto L_0x003f
        L_0x0050:
            boolean r5 = isParameterInformation(r3)
            if (r5 == 0) goto L_0x0063
            java.lang.String r5 = getText(r3)
            java.util.List r11 = parseParameters(r5)
            m5409sourceInformationContextOf$next4(r0)
            goto L_0x00db
        L_0x0063:
            java.lang.String r5 = "*"
            boolean r5 = isChar(r3, r5)
            if (r5 == 0) goto L_0x0073
            int r10 = r9.size()
            m5409sourceInformationContextOf$next4(r0)
            goto L_0x00db
        L_0x0073:
            java.lang.String r5 = ","
            boolean r5 = isChar(r3, r5)
            if (r5 == 0) goto L_0x007f
            m5409sourceInformationContextOf$next4(r0)
            goto L_0x00db
        L_0x007f:
            boolean r0 = isFileName(r3)
            if (r0 == 0) goto L_0x00f2
            kotlin.ranges.IntRange r0 = r3.getRange()
            int r0 = r0.getLast()
            int r0 = r0 + r7
            if (r13 == 0) goto L_0x00c9
            java.lang.String r13 = r13.substring(r0)
            java.lang.String r0 = "(this as java.lang.String).substring(startIndex)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r0)
            java.lang.String r0 = "#"
            java.lang.String r3 = ""
            java.lang.String r0 = kotlin.text.StringsKt__StringsKt.substringAfterLast((java.lang.String) r13, (java.lang.String) r0, (java.lang.String) r3)
            int r3 = r0.length()
            if (r3 <= 0) goto L_0x00a9
            r3 = r7
            goto L_0x00aa
        L_0x00a9:
            r3 = r2
        L_0x00aa:
            if (r3 == 0) goto L_0x00f3
            int r3 = r13.length()
            int r5 = r0.length()
            int r3 = r3 - r5
            int r3 = r3 - r7
            kotlin.ranges.IntRange r2 = kotlin.ranges.RangesKt___RangesKt.until((int) r2, (int) r3)
            java.lang.String r13 = kotlin.text.StringsKt__StringsKt.substring((java.lang.String) r13, (kotlin.ranges.IntRange) r2)
            r2 = 36
            int r2 = kotlin.text.CharsKt__CharJVMKt.checkRadix(r2)     // Catch:{ NumberFormatException -> 0x00f3 }
            int r1 = java.lang.Integer.parseInt(r0, r2)     // Catch:{ NumberFormatException -> 0x00f3 }
            goto L_0x00f3
        L_0x00c9:
            java.lang.NullPointerException r13 = new java.lang.NullPointerException
            java.lang.String r14 = "null cannot be cast to non-null type java.lang.String"
            r13.<init>(r14)
            throw r13
        L_0x00d1:
            androidx.compose.ui.tooling.data.SourceLocationInfo r5 = sourceInformationContextOf$parseLocation(r0)
            if (r5 != 0) goto L_0x00d8
            goto L_0x00db
        L_0x00d8:
            r9.add(r5)
        L_0x00db:
            T r5 = r0.element
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            r3 = r3 ^ r7
            if (r3 == 0) goto L_0x00e6
            goto L_0x001a
        L_0x00e6:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.String r14 = "regex didn't advance"
            java.lang.String r14 = r14.toString()
            r13.<init>(r14)
            throw r13
        L_0x00f2:
            r13 = r4
        L_0x00f3:
            androidx.compose.ui.tooling.data.SourceInformationContext r0 = new androidx.compose.ui.tooling.data.SourceInformationContext
            if (r13 != 0) goto L_0x0100
            if (r14 != 0) goto L_0x00fa
            goto L_0x00fe
        L_0x00fa:
            java.lang.String r4 = r14.getSourceFile()
        L_0x00fe:
            r7 = r4
            goto L_0x0101
        L_0x0100:
            r7 = r13
        L_0x0101:
            if (r13 == 0) goto L_0x0104
            goto L_0x0106
        L_0x0104:
            if (r14 != 0) goto L_0x0108
        L_0x0106:
            r8 = r1
            goto L_0x010d
        L_0x0108:
            int r13 = r14.getPackageHash()
            r8 = r13
        L_0x010d:
            r5 = r0
            r5.<init>(r6, r7, r8, r9, r10, r11, r12)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.data.SlotTreeKt.sourceInformationContextOf(java.lang.String, androidx.compose.ui.tooling.data.SourceInformationContext):androidx.compose.ui.tooling.data.SourceInformationContext");
    }

    /* renamed from: sourceInformationContextOf$next-4  reason: not valid java name */
    private static final MatchResult m5409sourceInformationContextOf$next4(Ref.ObjectRef<MatchResult> objectRef) {
        MatchResult matchResult = (MatchResult) objectRef.element;
        if (matchResult != null) {
            objectRef.element = matchResult.next();
        }
        return (MatchResult) objectRef.element;
    }

    private static final SourceLocationInfo sourceInformationContextOf$parseLocation(Ref.ObjectRef<MatchResult> objectRef) {
        Integer num;
        Integer num2;
        Integer num3;
        MatchResult matchResult = (MatchResult) objectRef.element;
        if (matchResult == null || !isNumber(matchResult)) {
            num = null;
        } else {
            num = Integer.valueOf(number(matchResult) + 1);
            matchResult = m5409sourceInformationContextOf$next4(objectRef);
        }
        if (matchResult == null || !isChar(matchResult, "@")) {
            num2 = null;
            num3 = null;
        } else {
            MatchResult r02 = m5409sourceInformationContextOf$next4(objectRef);
            if (r02 == null || !isNumber(r02)) {
                return null;
            }
            num3 = Integer.valueOf(number(r02));
            MatchResult r32 = m5409sourceInformationContextOf$next4(objectRef);
            if (r32 == null || !isChar(r32, "L")) {
                num2 = null;
            } else {
                MatchResult r62 = m5409sourceInformationContextOf$next4(objectRef);
                if (r62 == null || !isNumber(r62)) {
                    return null;
                }
                num2 = Integer.valueOf(number(r62));
            }
        }
        if (num == null || num3 == null || num2 == null) {
            return null;
        }
        return new SourceLocationInfo(num, num3, num2);
    }

    @NotNull
    public static final IntRect union(@NotNull IntRect intRect, @NotNull IntRect intRect2) {
        Intrinsics.checkNotNullParameter(intRect, "<this>");
        Intrinsics.checkNotNullParameter(intRect2, "other");
        IntRect intRect3 = emptyBox;
        if (Intrinsics.areEqual((Object) intRect, (Object) intRect3)) {
            return intRect2;
        }
        if (Intrinsics.areEqual((Object) intRect2, (Object) intRect3)) {
            return intRect;
        }
        return new IntRect(Math.min(intRect.getLeft(), intRect2.getLeft()), Math.min(intRect.getTop(), intRect2.getTop()), Math.max(intRect.getRight(), intRect2.getRight()), Math.max(intRect.getBottom(), intRect2.getBottom()));
    }
}
