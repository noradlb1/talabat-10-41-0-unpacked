package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a~\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u0017\u001a~\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u001a\u001a&\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001dH\u0002\u001aE\u0010!\u001a\u001f\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\"¢\u0006\u0002\b\u00162\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0003ø\u0001\u0000¢\u0006\u0002\u0010%\u001aE\u0010&\u001a\u001f\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\"¢\u0006\u0002\b\u00162\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0003ø\u0001\u0000¢\u0006\u0002\u0010'\u001aá\u0001\u0010(\u001a\u00020\u0001\"\u0004\b\u0000\u0010)*\u00020\u00152\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H)0*2%\b\n\u0010+\u001a\u001f\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020/\u0018\u00010\u001420\b\n\u00100\u001a*\u0012\u0004\u0012\u000201\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u000202\u0018\u00010\"¢\u0006\u0002\b\u00162%\b\n\u00103\u001a\u001f\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0006\u0012\u0004\u0018\u00010/0\u001423\b\u0004\u00104\u001a-\u0012\u0004\u0012\u000205\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00010\"¢\u0006\u0002\b6¢\u0006\u0002\b\u0016H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\u00107\u001aá\u0001\u0010(\u001a\u00020\u0001\"\u0004\b\u0000\u0010)*\u00020\u00152\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H)0\u001c2%\b\n\u0010+\u001a\u001f\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020/\u0018\u00010\u001420\b\n\u00100\u001a*\u0012\u0004\u0012\u000201\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u000202\u0018\u00010\"¢\u0006\u0002\b\u00162%\b\n\u00103\u001a\u001f\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0006\u0012\u0004\u0018\u00010/0\u001423\b\u0004\u00104\u001a-\u0012\u0004\u0012\u000205\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00010\"¢\u0006\u0002\b6¢\u0006\u0002\b\u0016H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\u00108\u001aµ\u0002\u00109\u001a\u00020\u0001\"\u0004\b\u0000\u0010)*\u00020\u00152\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H)0*2:\b\n\u0010+\u001a4\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(:\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020/\u0018\u00010\"2E\b\n\u00100\u001a?\u0012\u0004\u0012\u000201\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(:\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u000202\u0018\u00010;¢\u0006\u0002\b\u00162:\b\u0006\u00103\u001a4\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(:\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0006\u0012\u0004\u0018\u00010/0\"2H\b\u0004\u00104\u001aB\u0012\u0004\u0012\u000205\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(:\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00010;¢\u0006\u0002\b6¢\u0006\u0002\b\u0016H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\u0010<\u001aµ\u0002\u00109\u001a\u00020\u0001\"\u0004\b\u0000\u0010)*\u00020\u00152\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H)0\u001c2:\b\n\u0010+\u001a4\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(:\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020/\u0018\u00010\"2E\b\n\u00100\u001a?\u0012\u0004\u0012\u000201\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(:\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u000202\u0018\u00010;¢\u0006\u0002\b\u00162:\b\u0006\u00103\u001a4\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(:\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0006\u0012\u0004\u0018\u00010/0\"2H\b\u0004\u00104\u001aB\u0012\u0004\u0012\u000205\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(:\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00010;¢\u0006\u0002\b6¢\u0006\u0002\b\u0016H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\u0010=\u0002\u000b\n\u0002\b\u0019\n\u0005\b20\u0001¨\u0006>"}, d2 = {"LazyHorizontalGrid", "", "rows", "Landroidx/compose/foundation/lazy/grid/GridCells;", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/grid/LazyGridScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LazyVerticalGrid", "columns", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "calculateCellsCrossAxisSizeImpl", "", "", "gridSize", "slotCount", "spacing", "rememberColumnWidthSums", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/Constraints;", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "rememberRowHeightSums", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "items", "T", "", "key", "Lkotlin/ParameterName;", "name", "item", "", "span", "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "contentType", "itemContent", "Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "itemsIndexed", "index", "Lkotlin/Function3;", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class LazyGridDslKt {
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x0285  */
    /* JADX WARNING: Removed duplicated region for block: B:168:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0125  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void LazyHorizontalGrid(@org.jetbrains.annotations.NotNull androidx.compose.foundation.lazy.grid.GridCells r27, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r28, @org.jetbrains.annotations.Nullable androidx.compose.foundation.lazy.grid.LazyGridState r29, @org.jetbrains.annotations.Nullable androidx.compose.foundation.layout.PaddingValues r30, boolean r31, @org.jetbrains.annotations.Nullable androidx.compose.foundation.layout.Arrangement.Horizontal r32, @org.jetbrains.annotations.Nullable androidx.compose.foundation.layout.Arrangement.Vertical r33, @org.jetbrains.annotations.Nullable androidx.compose.foundation.gestures.FlingBehavior r34, boolean r35, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.grid.LazyGridScope, kotlin.Unit> r36, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r37, int r38, int r39) {
        /*
            r1 = r27
            r0 = r36
            r15 = r38
            r14 = r39
            java.lang.String r2 = "rows"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            java.lang.String r2 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            r2 = 2123608858(0x7e93b31a, float:9.816323E37)
            r3 = r37
            androidx.compose.runtime.Composer r13 = r3.startRestartGroup(r2)
            r3 = r14 & 1
            if (r3 == 0) goto L_0x0022
            r3 = r15 | 6
            goto L_0x0032
        L_0x0022:
            r3 = r15 & 14
            if (r3 != 0) goto L_0x0031
            boolean r3 = r13.changed((java.lang.Object) r1)
            if (r3 == 0) goto L_0x002e
            r3 = 4
            goto L_0x002f
        L_0x002e:
            r3 = 2
        L_0x002f:
            r3 = r3 | r15
            goto L_0x0032
        L_0x0031:
            r3 = r15
        L_0x0032:
            r4 = r14 & 2
            if (r4 == 0) goto L_0x0039
            r3 = r3 | 48
            goto L_0x004c
        L_0x0039:
            r5 = r15 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x004c
            r5 = r28
            boolean r6 = r13.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0048
            r6 = 32
            goto L_0x004a
        L_0x0048:
            r6 = 16
        L_0x004a:
            r3 = r3 | r6
            goto L_0x004e
        L_0x004c:
            r5 = r28
        L_0x004e:
            r6 = r15 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x0067
            r6 = r14 & 4
            if (r6 != 0) goto L_0x0061
            r6 = r29
            boolean r7 = r13.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0063
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0065
        L_0x0061:
            r6 = r29
        L_0x0063:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0065:
            r3 = r3 | r7
            goto L_0x0069
        L_0x0067:
            r6 = r29
        L_0x0069:
            r7 = r14 & 8
            if (r7 == 0) goto L_0x0070
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0083
        L_0x0070:
            r8 = r15 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x0083
            r8 = r30
            boolean r9 = r13.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x007f
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x0081
        L_0x007f:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x0081:
            r3 = r3 | r9
            goto L_0x0085
        L_0x0083:
            r8 = r30
        L_0x0085:
            r9 = r14 & 16
            r10 = 57344(0xe000, float:8.0356E-41)
            if (r9 == 0) goto L_0x008f
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a2
        L_0x008f:
            r11 = r15 & r10
            if (r11 != 0) goto L_0x00a2
            r11 = r31
            boolean r12 = r13.changed((boolean) r11)
            if (r12 == 0) goto L_0x009e
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a0
        L_0x009e:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x00a0:
            r3 = r3 | r12
            goto L_0x00a4
        L_0x00a2:
            r11 = r31
        L_0x00a4:
            r12 = 458752(0x70000, float:6.42848E-40)
            r12 = r12 & r15
            if (r12 != 0) goto L_0x00bf
            r12 = r14 & 32
            if (r12 != 0) goto L_0x00b8
            r12 = r32
            boolean r16 = r13.changed((java.lang.Object) r12)
            if (r16 == 0) goto L_0x00ba
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bc
        L_0x00b8:
            r12 = r32
        L_0x00ba:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00bc:
            r3 = r3 | r16
            goto L_0x00c1
        L_0x00bf:
            r12 = r32
        L_0x00c1:
            r16 = r14 & 64
            r17 = 3670016(0x380000, float:5.142788E-39)
            if (r16 == 0) goto L_0x00ce
            r18 = 1572864(0x180000, float:2.204052E-39)
            r3 = r3 | r18
            r10 = r33
            goto L_0x00e1
        L_0x00ce:
            r18 = r15 & r17
            r10 = r33
            if (r18 != 0) goto L_0x00e1
            boolean r18 = r13.changed((java.lang.Object) r10)
            if (r18 == 0) goto L_0x00dd
            r18 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00df
        L_0x00dd:
            r18 = 524288(0x80000, float:7.34684E-40)
        L_0x00df:
            r3 = r3 | r18
        L_0x00e1:
            r18 = 29360128(0x1c00000, float:7.052966E-38)
            r19 = r15 & r18
            if (r19 != 0) goto L_0x00fd
            r2 = r14 & 128(0x80, float:1.794E-43)
            if (r2 != 0) goto L_0x00f6
            r2 = r34
            boolean r20 = r13.changed((java.lang.Object) r2)
            if (r20 == 0) goto L_0x00f8
            r20 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00fa
        L_0x00f6:
            r2 = r34
        L_0x00f8:
            r20 = 4194304(0x400000, float:5.877472E-39)
        L_0x00fa:
            r3 = r3 | r20
            goto L_0x00ff
        L_0x00fd:
            r2 = r34
        L_0x00ff:
            r2 = r14 & 256(0x100, float:3.59E-43)
            r20 = 234881024(0xe000000, float:1.5777218E-30)
            if (r2 == 0) goto L_0x010c
            r21 = 100663296(0x6000000, float:2.4074124E-35)
            r3 = r3 | r21
            r5 = r35
            goto L_0x011f
        L_0x010c:
            r21 = r15 & r20
            r5 = r35
            if (r21 != 0) goto L_0x011f
            boolean r21 = r13.changed((boolean) r5)
            if (r21 == 0) goto L_0x011b
            r21 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x011d
        L_0x011b:
            r21 = 33554432(0x2000000, float:9.403955E-38)
        L_0x011d:
            r3 = r3 | r21
        L_0x011f:
            r5 = r14 & 512(0x200, float:7.175E-43)
            r21 = 1879048192(0x70000000, float:1.58456325E29)
            if (r5 == 0) goto L_0x0129
            r5 = 805306368(0x30000000, float:4.656613E-10)
        L_0x0127:
            r3 = r3 | r5
            goto L_0x0139
        L_0x0129:
            r5 = r15 & r21
            if (r5 != 0) goto L_0x0139
            boolean r5 = r13.changed((java.lang.Object) r0)
            if (r5 == 0) goto L_0x0136
            r5 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0127
        L_0x0136:
            r5 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x0127
        L_0x0139:
            r5 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r5 = r5 & r3
            r0 = 306783378(0x12492492, float:6.3469493E-28)
            if (r5 != r0) goto L_0x015b
            boolean r0 = r13.getSkipping()
            if (r0 != 0) goto L_0x0149
            goto L_0x015b
        L_0x0149:
            r13.skipToGroupEnd()
            r2 = r28
            r9 = r35
            r3 = r6
            r4 = r8
            r7 = r10
            r5 = r11
            r6 = r12
            r21 = r13
            r8 = r34
            goto L_0x027e
        L_0x015b:
            r13.startDefaults()
            r0 = r15 & 1
            r5 = -458753(0xfffffffffff8ffff, float:NaN)
            if (r0 == 0) goto L_0x0192
            boolean r0 = r13.getDefaultsInvalid()
            if (r0 == 0) goto L_0x016c
            goto L_0x0192
        L_0x016c:
            r13.skipToGroupEnd()
            r0 = r14 & 4
            if (r0 == 0) goto L_0x0175
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0175:
            r0 = r14 & 32
            if (r0 == 0) goto L_0x017a
            r3 = r3 & r5
        L_0x017a:
            r0 = r14 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0182
            r0 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r3 = r3 & r0
        L_0x0182:
            r0 = r28
            r25 = r34
            r26 = r35
            r22 = r6
            r23 = r11
            r24 = r12
            r12 = r8
            r11 = r10
            goto L_0x01fd
        L_0x0192:
            if (r4 == 0) goto L_0x0197
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            goto L_0x0199
        L_0x0197:
            r0 = r28
        L_0x0199:
            r4 = r14 & 4
            r5 = 0
            if (r4 == 0) goto L_0x01a6
            r4 = 3
            androidx.compose.foundation.lazy.grid.LazyGridState r4 = androidx.compose.foundation.lazy.grid.LazyGridStateKt.rememberLazyGridState(r5, r5, r13, r5, r4)
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x01a7
        L_0x01a6:
            r4 = r6
        L_0x01a7:
            if (r7 == 0) goto L_0x01b3
            float r6 = (float) r5
            float r6 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r6)
            androidx.compose.foundation.layout.PaddingValues r6 = androidx.compose.foundation.layout.PaddingKt.m479PaddingValues0680j_4(r6)
            goto L_0x01b4
        L_0x01b3:
            r6 = r8
        L_0x01b4:
            if (r9 == 0) goto L_0x01b7
            goto L_0x01b8
        L_0x01b7:
            r5 = r11
        L_0x01b8:
            r7 = r14 & 32
            if (r7 == 0) goto L_0x01ce
            androidx.compose.foundation.layout.Arrangement r7 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            if (r5 != 0) goto L_0x01c5
            androidx.compose.foundation.layout.Arrangement$Horizontal r7 = r7.getStart()
            goto L_0x01c9
        L_0x01c5:
            androidx.compose.foundation.layout.Arrangement$Horizontal r7 = r7.getEnd()
        L_0x01c9:
            r8 = -458753(0xfffffffffff8ffff, float:NaN)
            r3 = r3 & r8
            goto L_0x01cf
        L_0x01ce:
            r7 = r12
        L_0x01cf:
            if (r16 == 0) goto L_0x01d8
            androidx.compose.foundation.layout.Arrangement r8 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r8 = r8.getTop()
            goto L_0x01d9
        L_0x01d8:
            r8 = r10
        L_0x01d9:
            r9 = r14 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x01e9
            androidx.compose.foundation.gestures.ScrollableDefaults r9 = androidx.compose.foundation.gestures.ScrollableDefaults.INSTANCE
            r10 = 6
            androidx.compose.foundation.gestures.FlingBehavior r9 = r9.flingBehavior(r13, r10)
            r10 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r3 = r3 & r10
            goto L_0x01eb
        L_0x01e9:
            r9 = r34
        L_0x01eb:
            if (r2 == 0) goto L_0x01f1
            r2 = 1
            r26 = r2
            goto L_0x01f3
        L_0x01f1:
            r26 = r35
        L_0x01f3:
            r22 = r4
            r23 = r5
            r12 = r6
            r24 = r7
            r11 = r8
            r25 = r9
        L_0x01fd:
            r13.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x020f
            r2 = -1
            java.lang.String r4 = "androidx.compose.foundation.lazy.grid.LazyHorizontalGrid (LazyGridDsl.kt:116)"
            r5 = 2123608858(0x7e93b31a, float:9.816323E37)
            androidx.compose.runtime.ComposerKt.traceEventStart(r5, r3, r2, r4)
        L_0x020f:
            r2 = r3 & 14
            int r4 = r3 >> 15
            r4 = r4 & 112(0x70, float:1.57E-43)
            r2 = r2 | r4
            int r4 = r3 >> 3
            r5 = r4 & 896(0x380, float:1.256E-42)
            r2 = r2 | r5
            kotlin.jvm.functions.Function2 r5 = rememberRowHeightSums(r1, r11, r12, r13, r2)
            r7 = 0
            r2 = r4 & 14
            r6 = 196608(0x30000, float:2.75506E-40)
            r2 = r2 | r6
            r6 = r4 & 112(0x70, float:1.57E-43)
            r2 = r2 | r6
            r6 = r3 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r6
            r6 = 57344(0xe000, float:8.0356E-41)
            r6 = r6 & r3
            r2 = r2 | r6
            r6 = r4 & r17
            r2 = r2 | r6
            r4 = r4 & r18
            r2 = r2 | r4
            int r4 = r3 << 6
            r4 = r4 & r20
            r2 = r2 | r4
            int r4 = r3 << 12
            r4 = r4 & r21
            r16 = r2 | r4
            int r2 = r3 >> 27
            r17 = r2 & 14
            r18 = 0
            r2 = r0
            r3 = r22
            r4 = r5
            r5 = r12
            r6 = r23
            r8 = r25
            r9 = r26
            r10 = r11
            r19 = r11
            r11 = r24
            r20 = r12
            r12 = r36
            r21 = r13
            r14 = r16
            r15 = r17
            r16 = r18
            androidx.compose.foundation.lazy.grid.LazyGridKt.LazyGrid(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x026f
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x026f:
            r2 = r0
            r7 = r19
            r4 = r20
            r3 = r22
            r5 = r23
            r6 = r24
            r8 = r25
            r9 = r26
        L_0x027e:
            androidx.compose.runtime.ScopeUpdateScope r13 = r21.endRestartGroup()
            if (r13 != 0) goto L_0x0285
            goto L_0x0296
        L_0x0285:
            androidx.compose.foundation.lazy.grid.LazyGridDslKt$LazyHorizontalGrid$1 r14 = new androidx.compose.foundation.lazy.grid.LazyGridDslKt$LazyHorizontalGrid$1
            r0 = r14
            r1 = r27
            r10 = r36
            r11 = r38
            r12 = r39
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r13.updateScope(r14)
        L_0x0296:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyHorizontalGrid(androidx.compose.foundation.lazy.grid.GridCells, androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.grid.LazyGridState, androidx.compose.foundation.layout.PaddingValues, boolean, androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.gestures.FlingBehavior, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x0282  */
    /* JADX WARNING: Removed duplicated region for block: B:168:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0125  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void LazyVerticalGrid(@org.jetbrains.annotations.NotNull androidx.compose.foundation.lazy.grid.GridCells r27, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r28, @org.jetbrains.annotations.Nullable androidx.compose.foundation.lazy.grid.LazyGridState r29, @org.jetbrains.annotations.Nullable androidx.compose.foundation.layout.PaddingValues r30, boolean r31, @org.jetbrains.annotations.Nullable androidx.compose.foundation.layout.Arrangement.Vertical r32, @org.jetbrains.annotations.Nullable androidx.compose.foundation.layout.Arrangement.Horizontal r33, @org.jetbrains.annotations.Nullable androidx.compose.foundation.gestures.FlingBehavior r34, boolean r35, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.grid.LazyGridScope, kotlin.Unit> r36, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r37, int r38, int r39) {
        /*
            r1 = r27
            r0 = r36
            r15 = r38
            r14 = r39
            java.lang.String r2 = "columns"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            java.lang.String r2 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            r2 = 1485410512(0x588990d0, float:1.21004046E15)
            r3 = r37
            androidx.compose.runtime.Composer r13 = r3.startRestartGroup(r2)
            r3 = r14 & 1
            if (r3 == 0) goto L_0x0022
            r3 = r15 | 6
            goto L_0x0032
        L_0x0022:
            r3 = r15 & 14
            if (r3 != 0) goto L_0x0031
            boolean r3 = r13.changed((java.lang.Object) r1)
            if (r3 == 0) goto L_0x002e
            r3 = 4
            goto L_0x002f
        L_0x002e:
            r3 = 2
        L_0x002f:
            r3 = r3 | r15
            goto L_0x0032
        L_0x0031:
            r3 = r15
        L_0x0032:
            r4 = r14 & 2
            if (r4 == 0) goto L_0x0039
            r3 = r3 | 48
            goto L_0x004c
        L_0x0039:
            r5 = r15 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x004c
            r5 = r28
            boolean r6 = r13.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0048
            r6 = 32
            goto L_0x004a
        L_0x0048:
            r6 = 16
        L_0x004a:
            r3 = r3 | r6
            goto L_0x004e
        L_0x004c:
            r5 = r28
        L_0x004e:
            r6 = r15 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x0067
            r6 = r14 & 4
            if (r6 != 0) goto L_0x0061
            r6 = r29
            boolean r7 = r13.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0063
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0065
        L_0x0061:
            r6 = r29
        L_0x0063:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0065:
            r3 = r3 | r7
            goto L_0x0069
        L_0x0067:
            r6 = r29
        L_0x0069:
            r7 = r14 & 8
            if (r7 == 0) goto L_0x0070
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0083
        L_0x0070:
            r8 = r15 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x0083
            r8 = r30
            boolean r9 = r13.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x007f
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x0081
        L_0x007f:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x0081:
            r3 = r3 | r9
            goto L_0x0085
        L_0x0083:
            r8 = r30
        L_0x0085:
            r9 = r14 & 16
            r10 = 57344(0xe000, float:8.0356E-41)
            if (r9 == 0) goto L_0x008f
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a2
        L_0x008f:
            r11 = r15 & r10
            if (r11 != 0) goto L_0x00a2
            r11 = r31
            boolean r12 = r13.changed((boolean) r11)
            if (r12 == 0) goto L_0x009e
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a0
        L_0x009e:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x00a0:
            r3 = r3 | r12
            goto L_0x00a4
        L_0x00a2:
            r11 = r31
        L_0x00a4:
            r12 = 458752(0x70000, float:6.42848E-40)
            r12 = r12 & r15
            if (r12 != 0) goto L_0x00bf
            r12 = r14 & 32
            if (r12 != 0) goto L_0x00b8
            r12 = r32
            boolean r16 = r13.changed((java.lang.Object) r12)
            if (r16 == 0) goto L_0x00ba
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bc
        L_0x00b8:
            r12 = r32
        L_0x00ba:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00bc:
            r3 = r3 | r16
            goto L_0x00c1
        L_0x00bf:
            r12 = r32
        L_0x00c1:
            r16 = r14 & 64
            r17 = 3670016(0x380000, float:5.142788E-39)
            if (r16 == 0) goto L_0x00ce
            r18 = 1572864(0x180000, float:2.204052E-39)
            r3 = r3 | r18
            r10 = r33
            goto L_0x00e1
        L_0x00ce:
            r18 = r15 & r17
            r10 = r33
            if (r18 != 0) goto L_0x00e1
            boolean r18 = r13.changed((java.lang.Object) r10)
            if (r18 == 0) goto L_0x00dd
            r18 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00df
        L_0x00dd:
            r18 = 524288(0x80000, float:7.34684E-40)
        L_0x00df:
            r3 = r3 | r18
        L_0x00e1:
            r18 = 29360128(0x1c00000, float:7.052966E-38)
            r19 = r15 & r18
            if (r19 != 0) goto L_0x00fd
            r2 = r14 & 128(0x80, float:1.794E-43)
            if (r2 != 0) goto L_0x00f6
            r2 = r34
            boolean r20 = r13.changed((java.lang.Object) r2)
            if (r20 == 0) goto L_0x00f8
            r20 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00fa
        L_0x00f6:
            r2 = r34
        L_0x00f8:
            r20 = 4194304(0x400000, float:5.877472E-39)
        L_0x00fa:
            r3 = r3 | r20
            goto L_0x00ff
        L_0x00fd:
            r2 = r34
        L_0x00ff:
            r2 = r14 & 256(0x100, float:3.59E-43)
            r20 = 234881024(0xe000000, float:1.5777218E-30)
            if (r2 == 0) goto L_0x010c
            r21 = 100663296(0x6000000, float:2.4074124E-35)
            r3 = r3 | r21
            r5 = r35
            goto L_0x011f
        L_0x010c:
            r21 = r15 & r20
            r5 = r35
            if (r21 != 0) goto L_0x011f
            boolean r21 = r13.changed((boolean) r5)
            if (r21 == 0) goto L_0x011b
            r21 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x011d
        L_0x011b:
            r21 = 33554432(0x2000000, float:9.403955E-38)
        L_0x011d:
            r3 = r3 | r21
        L_0x011f:
            r5 = r14 & 512(0x200, float:7.175E-43)
            r21 = 1879048192(0x70000000, float:1.58456325E29)
            if (r5 == 0) goto L_0x0129
            r5 = 805306368(0x30000000, float:4.656613E-10)
        L_0x0127:
            r3 = r3 | r5
            goto L_0x0139
        L_0x0129:
            r5 = r15 & r21
            if (r5 != 0) goto L_0x0139
            boolean r5 = r13.changed((java.lang.Object) r0)
            if (r5 == 0) goto L_0x0136
            r5 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0127
        L_0x0136:
            r5 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x0127
        L_0x0139:
            r5 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r5 = r5 & r3
            r0 = 306783378(0x12492492, float:6.3469493E-28)
            if (r5 != r0) goto L_0x015b
            boolean r0 = r13.getSkipping()
            if (r0 != 0) goto L_0x0149
            goto L_0x015b
        L_0x0149:
            r13.skipToGroupEnd()
            r2 = r28
            r9 = r35
            r3 = r6
            r4 = r8
            r7 = r10
            r5 = r11
            r6 = r12
            r21 = r13
            r8 = r34
            goto L_0x027b
        L_0x015b:
            r13.startDefaults()
            r0 = r15 & 1
            r5 = -458753(0xfffffffffff8ffff, float:NaN)
            if (r0 == 0) goto L_0x0192
            boolean r0 = r13.getDefaultsInvalid()
            if (r0 == 0) goto L_0x016c
            goto L_0x0192
        L_0x016c:
            r13.skipToGroupEnd()
            r0 = r14 & 4
            if (r0 == 0) goto L_0x0175
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0175:
            r0 = r14 & 32
            if (r0 == 0) goto L_0x017a
            r3 = r3 & r5
        L_0x017a:
            r0 = r14 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0182
            r0 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r3 = r3 & r0
        L_0x0182:
            r0 = r28
            r25 = r34
            r26 = r35
            r22 = r6
            r23 = r11
            r24 = r12
            r12 = r8
            r11 = r10
            goto L_0x01fd
        L_0x0192:
            if (r4 == 0) goto L_0x0197
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            goto L_0x0199
        L_0x0197:
            r0 = r28
        L_0x0199:
            r4 = r14 & 4
            r5 = 0
            if (r4 == 0) goto L_0x01a6
            r4 = 3
            androidx.compose.foundation.lazy.grid.LazyGridState r4 = androidx.compose.foundation.lazy.grid.LazyGridStateKt.rememberLazyGridState(r5, r5, r13, r5, r4)
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x01a7
        L_0x01a6:
            r4 = r6
        L_0x01a7:
            if (r7 == 0) goto L_0x01b3
            float r6 = (float) r5
            float r6 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r6)
            androidx.compose.foundation.layout.PaddingValues r6 = androidx.compose.foundation.layout.PaddingKt.m479PaddingValues0680j_4(r6)
            goto L_0x01b4
        L_0x01b3:
            r6 = r8
        L_0x01b4:
            if (r9 == 0) goto L_0x01b7
            goto L_0x01b8
        L_0x01b7:
            r5 = r11
        L_0x01b8:
            r7 = r14 & 32
            if (r7 == 0) goto L_0x01ce
            androidx.compose.foundation.layout.Arrangement r7 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            if (r5 != 0) goto L_0x01c5
            androidx.compose.foundation.layout.Arrangement$Vertical r7 = r7.getTop()
            goto L_0x01c9
        L_0x01c5:
            androidx.compose.foundation.layout.Arrangement$Vertical r7 = r7.getBottom()
        L_0x01c9:
            r8 = -458753(0xfffffffffff8ffff, float:NaN)
            r3 = r3 & r8
            goto L_0x01cf
        L_0x01ce:
            r7 = r12
        L_0x01cf:
            if (r16 == 0) goto L_0x01d8
            androidx.compose.foundation.layout.Arrangement r8 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r8 = r8.getStart()
            goto L_0x01d9
        L_0x01d8:
            r8 = r10
        L_0x01d9:
            r9 = r14 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x01e9
            androidx.compose.foundation.gestures.ScrollableDefaults r9 = androidx.compose.foundation.gestures.ScrollableDefaults.INSTANCE
            r10 = 6
            androidx.compose.foundation.gestures.FlingBehavior r9 = r9.flingBehavior(r13, r10)
            r10 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r3 = r3 & r10
            goto L_0x01eb
        L_0x01e9:
            r9 = r34
        L_0x01eb:
            if (r2 == 0) goto L_0x01f1
            r2 = 1
            r26 = r2
            goto L_0x01f3
        L_0x01f1:
            r26 = r35
        L_0x01f3:
            r22 = r4
            r23 = r5
            r12 = r6
            r24 = r7
            r11 = r8
            r25 = r9
        L_0x01fd:
            r13.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x020f
            r2 = -1
            java.lang.String r4 = "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:62)"
            r5 = 1485410512(0x588990d0, float:1.21004046E15)
            androidx.compose.runtime.ComposerKt.traceEventStart(r5, r3, r2, r4)
        L_0x020f:
            r2 = r3 & 14
            int r4 = r3 >> 15
            r4 = r4 & 112(0x70, float:1.57E-43)
            r2 = r2 | r4
            int r4 = r3 >> 3
            r5 = r4 & 896(0x380, float:1.256E-42)
            r2 = r2 | r5
            kotlin.jvm.functions.Function2 r5 = rememberColumnWidthSums(r1, r11, r12, r13, r2)
            r7 = 1
            r2 = r4 & 14
            r6 = 196608(0x30000, float:2.75506E-40)
            r2 = r2 | r6
            r6 = r4 & 112(0x70, float:1.57E-43)
            r2 = r2 | r6
            r6 = r3 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r6
            r6 = 57344(0xe000, float:8.0356E-41)
            r6 = r6 & r3
            r2 = r2 | r6
            r6 = r4 & r17
            r2 = r2 | r6
            r4 = r4 & r18
            r2 = r2 | r4
            int r4 = r3 << 9
            r6 = r4 & r20
            r2 = r2 | r6
            r4 = r4 & r21
            r16 = r2 | r4
            int r2 = r3 >> 27
            r17 = r2 & 14
            r18 = 0
            r2 = r0
            r3 = r22
            r4 = r5
            r5 = r12
            r6 = r23
            r8 = r25
            r9 = r26
            r10 = r24
            r19 = r11
            r20 = r12
            r12 = r36
            r21 = r13
            r14 = r16
            r15 = r17
            r16 = r18
            androidx.compose.foundation.lazy.grid.LazyGridKt.LazyGrid(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x026c
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x026c:
            r2 = r0
            r7 = r19
            r4 = r20
            r3 = r22
            r5 = r23
            r6 = r24
            r8 = r25
            r9 = r26
        L_0x027b:
            androidx.compose.runtime.ScopeUpdateScope r13 = r21.endRestartGroup()
            if (r13 != 0) goto L_0x0282
            goto L_0x0293
        L_0x0282:
            androidx.compose.foundation.lazy.grid.LazyGridDslKt$LazyVerticalGrid$1 r14 = new androidx.compose.foundation.lazy.grid.LazyGridDslKt$LazyVerticalGrid$1
            r0 = r14
            r1 = r27
            r10 = r36
            r11 = r38
            r12 = r39
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r13.updateScope(r14)
        L_0x0293:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid(androidx.compose.foundation.lazy.grid.GridCells, androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.grid.LazyGridState, androidx.compose.foundation.layout.PaddingValues, boolean, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.foundation.gestures.FlingBehavior, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final List<Integer> calculateCellsCrossAxisSizeImpl(int i11, int i12, int i13) {
        int i14;
        int i15 = i11 - (i13 * (i12 - 1));
        int i16 = i15 / i12;
        int i17 = i15 % i12;
        ArrayList arrayList = new ArrayList(i12);
        for (int i18 = 0; i18 < i12; i18++) {
            if (i18 < i17) {
                i14 = 1;
            } else {
                i14 = 0;
            }
            arrayList.add(Integer.valueOf(i14 + i16));
        }
        return arrayList;
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final <T> void items(@NotNull LazyGridScope lazyGridScope, @NotNull List<? extends T> list, @Nullable Function1<? super T, ? extends Object> function1, @Nullable Function2<? super LazyGridItemSpanScope, ? super T, GridItemSpan> function2, @NotNull Function1<? super T, ? extends Object> function12, @NotNull Function4<? super LazyGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4) {
        Intrinsics.checkNotNullParameter(lazyGridScope, "<this>");
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullParameter(function12, AnalyticsAttribute.CONTENT_TYPE_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(function4, "itemContent");
        int size = list.size();
        LazyGridDslKt$items$3 lazyGridDslKt$items$3 = null;
        LazyGridDslKt$items$2 lazyGridDslKt$items$2 = function1 != null ? new LazyGridDslKt$items$2(function1, list) : null;
        if (function2 != null) {
            lazyGridDslKt$items$3 = new LazyGridDslKt$items$3(function2, list);
        }
        lazyGridScope.items(size, lazyGridDslKt$items$2, lazyGridDslKt$items$3, new LazyGridDslKt$items$4(function12, list), ComposableLambdaKt.composableLambdaInstance(699646206, true, new LazyGridDslKt$items$5(function4, list)));
    }

    public static /* synthetic */ void items$default(LazyGridScope lazyGridScope, List list, Function1 function1, Function2 function2, Function1 function12, Function4 function4, int i11, Object obj) {
        LazyGridDslKt$items$3 lazyGridDslKt$items$3 = null;
        if ((i11 & 2) != 0) {
            function1 = null;
        }
        if ((i11 & 4) != 0) {
            function2 = null;
        }
        if ((i11 & 8) != 0) {
            function12 = LazyGridDslKt$items$1.INSTANCE;
        }
        Intrinsics.checkNotNullParameter(lazyGridScope, "<this>");
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullParameter(function12, AnalyticsAttribute.CONTENT_TYPE_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(function4, "itemContent");
        int size = list.size();
        LazyGridDslKt$items$2 lazyGridDslKt$items$2 = function1 != null ? new LazyGridDslKt$items$2(function1, list) : null;
        if (function2 != null) {
            lazyGridDslKt$items$3 = new LazyGridDslKt$items$3(function2, list);
        }
        lazyGridScope.items(size, lazyGridDslKt$items$2, lazyGridDslKt$items$3, new LazyGridDslKt$items$4(function12, list), ComposableLambdaKt.composableLambdaInstance(699646206, true, new LazyGridDslKt$items$5(function4, list)));
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final <T> void itemsIndexed(@NotNull LazyGridScope lazyGridScope, @NotNull List<? extends T> list, @Nullable Function2<? super Integer, ? super T, ? extends Object> function2, @Nullable Function3<? super LazyGridItemSpanScope, ? super Integer, ? super T, GridItemSpan> function3, @NotNull Function2<? super Integer, ? super T, ? extends Object> function22, @NotNull Function5<? super LazyGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5) {
        Intrinsics.checkNotNullParameter(lazyGridScope, "<this>");
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullParameter(function22, AnalyticsAttribute.CONTENT_TYPE_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(function5, "itemContent");
        int size = list.size();
        LazyGridDslKt$itemsIndexed$3 lazyGridDslKt$itemsIndexed$3 = null;
        LazyGridDslKt$itemsIndexed$2 lazyGridDslKt$itemsIndexed$2 = function2 != null ? new LazyGridDslKt$itemsIndexed$2(function2, list) : null;
        if (function3 != null) {
            lazyGridDslKt$itemsIndexed$3 = new LazyGridDslKt$itemsIndexed$3(function3, list);
        }
        lazyGridScope.items(size, lazyGridDslKt$itemsIndexed$2, lazyGridDslKt$itemsIndexed$3, new LazyGridDslKt$itemsIndexed$4(function22, list), ComposableLambdaKt.composableLambdaInstance(1229287273, true, new LazyGridDslKt$itemsIndexed$5(function5, list)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyGridScope lazyGridScope, List list, Function2 function2, Function3 function3, Function2 function22, Function5 function5, int i11, Object obj) {
        LazyGridDslKt$itemsIndexed$3 lazyGridDslKt$itemsIndexed$3 = null;
        if ((i11 & 2) != 0) {
            function2 = null;
        }
        if ((i11 & 4) != 0) {
            function3 = null;
        }
        if ((i11 & 8) != 0) {
            function22 = LazyGridDslKt$itemsIndexed$1.INSTANCE;
        }
        Intrinsics.checkNotNullParameter(lazyGridScope, "<this>");
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullParameter(function22, AnalyticsAttribute.CONTENT_TYPE_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(function5, "itemContent");
        int size = list.size();
        LazyGridDslKt$itemsIndexed$2 lazyGridDslKt$itemsIndexed$2 = function2 != null ? new LazyGridDslKt$itemsIndexed$2(function2, list) : null;
        if (function3 != null) {
            lazyGridDslKt$itemsIndexed$3 = new LazyGridDslKt$itemsIndexed$3(function3, list);
        }
        lazyGridScope.items(size, lazyGridDslKt$itemsIndexed$2, lazyGridDslKt$itemsIndexed$3, new LazyGridDslKt$itemsIndexed$4(function22, list), ComposableLambdaKt.composableLambdaInstance(1229287273, true, new LazyGridDslKt$itemsIndexed$5(function5, list)));
    }

    @Composable
    private static final Function2<Density, Constraints, List<Integer>> rememberColumnWidthSums(GridCells gridCells, Arrangement.Horizontal horizontal, PaddingValues paddingValues, Composer composer, int i11) {
        composer.startReplaceableGroup(-1355301804);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1355301804, i11, -1, "androidx.compose.foundation.lazy.grid.rememberColumnWidthSums (LazyGridDsl.kt:148)");
        }
        composer.startReplaceableGroup(1618982084);
        boolean changed = composer.changed((Object) gridCells) | composer.changed((Object) horizontal) | composer.changed((Object) paddingValues);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new LazyGridDslKt$rememberColumnWidthSums$1$1(paddingValues, gridCells, horizontal);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Function2<Density, Constraints, List<Integer>> function2 = (Function2) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return function2;
    }

    @Composable
    private static final Function2<Density, Constraints, List<Integer>> rememberRowHeightSums(GridCells gridCells, Arrangement.Vertical vertical, PaddingValues paddingValues, Composer composer, int i11) {
        composer.startReplaceableGroup(239683573);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(239683573, i11, -1, "androidx.compose.foundation.lazy.grid.rememberRowHeightSums (LazyGridDsl.kt:180)");
        }
        composer.startReplaceableGroup(1618982084);
        boolean changed = composer.changed((Object) gridCells) | composer.changed((Object) vertical) | composer.changed((Object) paddingValues);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new LazyGridDslKt$rememberRowHeightSums$1$1(paddingValues, gridCells, vertical);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Function2<Density, Constraints, List<Integer>> function2 = (Function2) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return function2;
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final <T> void items(@NotNull LazyGridScope lazyGridScope, @NotNull T[] tArr, @Nullable Function1<? super T, ? extends Object> function1, @Nullable Function2<? super LazyGridItemSpanScope, ? super T, GridItemSpan> function2, @NotNull Function1<? super T, ? extends Object> function12, @NotNull Function4<? super LazyGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4) {
        Intrinsics.checkNotNullParameter(lazyGridScope, "<this>");
        Intrinsics.checkNotNullParameter(tArr, FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullParameter(function12, AnalyticsAttribute.CONTENT_TYPE_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(function4, "itemContent");
        int length = tArr.length;
        LazyGridDslKt$items$8 lazyGridDslKt$items$8 = null;
        LazyGridDslKt$items$7 lazyGridDslKt$items$7 = function1 != null ? new LazyGridDslKt$items$7(function1, tArr) : null;
        if (function2 != null) {
            lazyGridDslKt$items$8 = new LazyGridDslKt$items$8(function2, tArr);
        }
        lazyGridScope.items(length, lazyGridDslKt$items$7, lazyGridDslKt$items$8, new LazyGridDslKt$items$9(function12, tArr), ComposableLambdaKt.composableLambdaInstance(407562193, true, new LazyGridDslKt$items$10(function4, tArr)));
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final <T> void itemsIndexed(@NotNull LazyGridScope lazyGridScope, @NotNull T[] tArr, @Nullable Function2<? super Integer, ? super T, ? extends Object> function2, @Nullable Function3<? super LazyGridItemSpanScope, ? super Integer, ? super T, GridItemSpan> function3, @NotNull Function2<? super Integer, ? super T, ? extends Object> function22, @NotNull Function5<? super LazyGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5) {
        Intrinsics.checkNotNullParameter(lazyGridScope, "<this>");
        Intrinsics.checkNotNullParameter(tArr, FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullParameter(function22, AnalyticsAttribute.CONTENT_TYPE_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(function5, "itemContent");
        int length = tArr.length;
        LazyGridDslKt$itemsIndexed$8 lazyGridDslKt$itemsIndexed$8 = null;
        LazyGridDslKt$itemsIndexed$7 lazyGridDslKt$itemsIndexed$7 = function2 != null ? new LazyGridDslKt$itemsIndexed$7(function2, tArr) : null;
        if (function3 != null) {
            lazyGridDslKt$itemsIndexed$8 = new LazyGridDslKt$itemsIndexed$8(function3, tArr);
        }
        lazyGridScope.items(length, lazyGridDslKt$itemsIndexed$7, lazyGridDslKt$itemsIndexed$8, new LazyGridDslKt$itemsIndexed$9(function22, tArr), ComposableLambdaKt.composableLambdaInstance(-911455938, true, new LazyGridDslKt$itemsIndexed$10(function5, tArr)));
    }

    public static /* synthetic */ void items$default(LazyGridScope lazyGridScope, Object[] objArr, Function1 function1, Function2 function2, Function1 function12, Function4 function4, int i11, Object obj) {
        LazyGridDslKt$items$8 lazyGridDslKt$items$8 = null;
        if ((i11 & 2) != 0) {
            function1 = null;
        }
        if ((i11 & 4) != 0) {
            function2 = null;
        }
        if ((i11 & 8) != 0) {
            function12 = LazyGridDslKt$items$6.INSTANCE;
        }
        Intrinsics.checkNotNullParameter(lazyGridScope, "<this>");
        Intrinsics.checkNotNullParameter(objArr, FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullParameter(function12, AnalyticsAttribute.CONTENT_TYPE_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(function4, "itemContent");
        int length = objArr.length;
        LazyGridDslKt$items$7 lazyGridDslKt$items$7 = function1 != null ? new LazyGridDslKt$items$7(function1, objArr) : null;
        if (function2 != null) {
            lazyGridDslKt$items$8 = new LazyGridDslKt$items$8(function2, objArr);
        }
        lazyGridScope.items(length, lazyGridDslKt$items$7, lazyGridDslKt$items$8, new LazyGridDslKt$items$9(function12, objArr), ComposableLambdaKt.composableLambdaInstance(407562193, true, new LazyGridDslKt$items$10(function4, objArr)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyGridScope lazyGridScope, Object[] objArr, Function2 function2, Function3 function3, Function2 function22, Function5 function5, int i11, Object obj) {
        LazyGridDslKt$itemsIndexed$8 lazyGridDslKt$itemsIndexed$8 = null;
        if ((i11 & 2) != 0) {
            function2 = null;
        }
        if ((i11 & 4) != 0) {
            function3 = null;
        }
        if ((i11 & 8) != 0) {
            function22 = LazyGridDslKt$itemsIndexed$6.INSTANCE;
        }
        Intrinsics.checkNotNullParameter(lazyGridScope, "<this>");
        Intrinsics.checkNotNullParameter(objArr, FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullParameter(function22, AnalyticsAttribute.CONTENT_TYPE_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(function5, "itemContent");
        int length = objArr.length;
        LazyGridDslKt$itemsIndexed$7 lazyGridDslKt$itemsIndexed$7 = function2 != null ? new LazyGridDslKt$itemsIndexed$7(function2, objArr) : null;
        if (function3 != null) {
            lazyGridDslKt$itemsIndexed$8 = new LazyGridDslKt$itemsIndexed$8(function3, objArr);
        }
        lazyGridScope.items(length, lazyGridDslKt$itemsIndexed$7, lazyGridDslKt$itemsIndexed$8, new LazyGridDslKt$itemsIndexed$9(function22, objArr), ComposableLambdaKt.composableLambdaInstance(-911455938, true, new LazyGridDslKt$itemsIndexed$10(function5, objArr)));
    }
}
