package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.ExperimentalFoundationApi;
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
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001at\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0015H\u0007¢\u0006\u0002\u0010\u0016\u001at\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0015H\u0007¢\u0006\u0002\u0010\u0016\u001a?\u0010\u0019\u001a\u0019\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001a¢\u0006\u0002\b\u00152\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u001e\u001a?\u0010\u001f\u001a\u0019\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001a¢\u0006\u0002\b\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0003ø\u0001\u0000¢\u0006\u0002\u0010 \u001a¦\u0001\u0010!\u001a\u00020\u0001\"\u0004\b\u0000\u0010\"*\u00020\u00142\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H\"0#2%\b\u0002\u0010$\u001a\u001f\u0012\u0013\u0012\u0011H\"¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020(\u0018\u00010\u00132%\b\u0002\u0010)\u001a\u001f\u0012\u0013\u0012\u0011H\"¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0006\u0012\u0004\u0018\u00010(0\u001321\u0010*\u001a-\u0012\u0004\u0012\u00020+\u0012\u0013\u0012\u0011H\"¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u00010\u001a¢\u0006\u0002\b,¢\u0006\u0002\b\u0015H\u0007¢\u0006\u0002\u0010-\u001a¦\u0001\u0010!\u001a\u00020\u0001\"\u0004\b\u0000\u0010\"*\u00020\u00142\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H\"0.2%\b\u0002\u0010$\u001a\u001f\u0012\u0013\u0012\u0011H\"¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020(\u0018\u00010\u00132%\b\u0002\u0010)\u001a\u001f\u0012\u0013\u0012\u0011H\"¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0006\u0012\u0004\u0018\u00010(0\u001321\u0010*\u001a-\u0012\u0004\u0012\u00020+\u0012\u0013\u0012\u0011H\"¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u00010\u001a¢\u0006\u0002\b,¢\u0006\u0002\b\u0015H\u0007¢\u0006\u0002\u0010/\u001aå\u0001\u00100\u001a\u00020\u0001\"\u0004\b\u0000\u0010\"*\u00020\u00142\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H\"0#2:\b\u0002\u0010$\u001a4\u0012\u0013\u0012\u001101¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\"¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020(\u0018\u00010\u001a2:\b\u0002\u0010)\u001a4\u0012\u0013\u0012\u001101¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\"¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0006\u0012\u0004\u0018\u00010(0\u001a2F\u0010*\u001aB\u0012\u0004\u0012\u00020+\u0012\u0013\u0012\u001101¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\"¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u000103¢\u0006\u0002\b,¢\u0006\u0002\b\u0015H\u0007¢\u0006\u0002\u00104\u001aå\u0001\u00100\u001a\u00020\u0001\"\u0004\b\u0000\u0010\"*\u00020\u00142\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H\"0.2:\b\u0002\u0010$\u001a4\u0012\u0013\u0012\u001101¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\"¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020(\u0018\u00010\u001a2:\b\u0002\u0010)\u001a4\u0012\u0013\u0012\u001101¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\"¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0006\u0012\u0004\u0018\u00010(0\u001a2F\u0010*\u001aB\u0012\u0004\u0012\u00020+\u0012\u0013\u0012\u001101¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\"¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u000103¢\u0006\u0002\b,¢\u0006\u0002\b\u0015H\u0007¢\u0006\u0002\u00105\u0002\u0004\n\u0002\b\u0019¨\u00066"}, d2 = {"LazyHorizontalStaggeredGrid", "", "rows", "Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LazyVerticalStaggeredGrid", "columns", "rememberColumnWidthSums", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/Constraints;", "", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "rememberRowHeightSums", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "items", "T", "", "key", "Lkotlin/ParameterName;", "name", "item", "", "contentType", "itemContent", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemScope;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "itemsIndexed", "", "index", "Lkotlin/Function3;", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class LazyStaggeredGridDslKt {
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0236  */
    /* JADX WARNING: Removed duplicated region for block: B:138:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x012a  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.foundation.ExperimentalFoundationApi
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void LazyHorizontalStaggeredGrid(@org.jetbrains.annotations.NotNull androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells r26, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r27, @org.jetbrains.annotations.Nullable androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState r28, @org.jetbrains.annotations.Nullable androidx.compose.foundation.layout.PaddingValues r29, @org.jetbrains.annotations.Nullable androidx.compose.foundation.layout.Arrangement.Vertical r30, @org.jetbrains.annotations.Nullable androidx.compose.foundation.layout.Arrangement.Horizontal r31, @org.jetbrains.annotations.Nullable androidx.compose.foundation.gestures.FlingBehavior r32, boolean r33, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope, kotlin.Unit> r34, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r35, int r36, int r37) {
        /*
            r1 = r26
            r0 = r34
            r15 = r36
            r14 = r37
            java.lang.String r2 = "rows"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            java.lang.String r2 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            r2 = -1591874454(0xffffffffa11dec6a, float:-5.350656E-19)
            r3 = r35
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
            r5 = r14 & 2
            if (r5 == 0) goto L_0x0039
            r3 = r3 | 48
            goto L_0x004c
        L_0x0039:
            r6 = r15 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L_0x004c
            r6 = r27
            boolean r7 = r13.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0048
            r7 = 32
            goto L_0x004a
        L_0x0048:
            r7 = 16
        L_0x004a:
            r3 = r3 | r7
            goto L_0x004e
        L_0x004c:
            r6 = r27
        L_0x004e:
            r7 = r14 & 4
            if (r7 == 0) goto L_0x0054
            r3 = r3 | 128(0x80, float:1.794E-43)
        L_0x0054:
            r8 = r14 & 8
            if (r8 == 0) goto L_0x005b
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x006e
        L_0x005b:
            r9 = r15 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x006e
            r9 = r29
            boolean r10 = r13.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x006a
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x006c
        L_0x006a:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x006c:
            r3 = r3 | r10
            goto L_0x0070
        L_0x006e:
            r9 = r29
        L_0x0070:
            r10 = r14 & 16
            r11 = 57344(0xe000, float:8.0356E-41)
            if (r10 == 0) goto L_0x007a
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x008e
        L_0x007a:
            r12 = r15 & r11
            if (r12 != 0) goto L_0x008e
            r12 = r30
            boolean r16 = r13.changed((java.lang.Object) r12)
            if (r16 == 0) goto L_0x0089
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x008b
        L_0x0089:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x008b:
            r3 = r3 | r16
            goto L_0x0090
        L_0x008e:
            r12 = r30
        L_0x0090:
            r16 = r14 & 32
            if (r16 == 0) goto L_0x009b
            r17 = 196608(0x30000, float:2.75506E-40)
            r3 = r3 | r17
            r11 = r31
            goto L_0x00b0
        L_0x009b:
            r17 = 458752(0x70000, float:6.42848E-40)
            r17 = r15 & r17
            r11 = r31
            if (r17 != 0) goto L_0x00b0
            boolean r17 = r13.changed((java.lang.Object) r11)
            if (r17 == 0) goto L_0x00ac
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ae
        L_0x00ac:
            r17 = 65536(0x10000, float:9.18355E-41)
        L_0x00ae:
            r3 = r3 | r17
        L_0x00b0:
            r17 = 3670016(0x380000, float:5.142788E-39)
            r18 = r15 & r17
            if (r18 != 0) goto L_0x00ca
            r18 = r14 & 64
            r2 = r32
            if (r18 != 0) goto L_0x00c5
            boolean r19 = r13.changed((java.lang.Object) r2)
            if (r19 == 0) goto L_0x00c5
            r19 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00c7
        L_0x00c5:
            r19 = 524288(0x80000, float:7.34684E-40)
        L_0x00c7:
            r3 = r3 | r19
            goto L_0x00cc
        L_0x00ca:
            r2 = r32
        L_0x00cc:
            r4 = r14 & 128(0x80, float:1.794E-43)
            r20 = 29360128(0x1c00000, float:7.052966E-38)
            if (r4 == 0) goto L_0x00d9
            r21 = 12582912(0xc00000, float:1.7632415E-38)
            r3 = r3 | r21
            r2 = r33
            goto L_0x00ec
        L_0x00d9:
            r21 = r15 & r20
            r2 = r33
            if (r21 != 0) goto L_0x00ec
            boolean r21 = r13.changed((boolean) r2)
            if (r21 == 0) goto L_0x00e8
            r21 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ea
        L_0x00e8:
            r21 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ea:
            r3 = r3 | r21
        L_0x00ec:
            r2 = r14 & 256(0x100, float:3.59E-43)
            r21 = 234881024(0xe000000, float:1.5777218E-30)
            if (r2 == 0) goto L_0x00f6
            r2 = 100663296(0x6000000, float:2.4074124E-35)
        L_0x00f4:
            r3 = r3 | r2
            goto L_0x0106
        L_0x00f6:
            r2 = r15 & r21
            if (r2 != 0) goto L_0x0106
            boolean r2 = r13.changed((java.lang.Object) r0)
            if (r2 == 0) goto L_0x0103
            r2 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x00f4
        L_0x0103:
            r2 = 33554432(0x2000000, float:9.403955E-38)
            goto L_0x00f4
        L_0x0106:
            r2 = 4
            if (r7 != r2) goto L_0x012a
            r2 = 191739611(0xb6db6db, float:4.5782105E-32)
            r2 = r2 & r3
            r0 = 38347922(0x2492492, float:1.4777643E-37)
            if (r2 != r0) goto L_0x012a
            boolean r0 = r13.getSkipping()
            if (r0 != 0) goto L_0x0119
            goto L_0x012a
        L_0x0119:
            r13.skipToGroupEnd()
            r3 = r28
            r7 = r32
            r8 = r33
            r2 = r6
            r4 = r9
            r6 = r11
            r5 = r12
            r25 = r13
            goto L_0x022f
        L_0x012a:
            r13.startDefaults()
            r0 = r15 & 1
            r2 = -3670017(0xffffffffffc7ffff, float:NaN)
            if (r0 == 0) goto L_0x0154
            boolean r0 = r13.getDefaultsInvalid()
            if (r0 == 0) goto L_0x013b
            goto L_0x0154
        L_0x013b:
            r13.skipToGroupEnd()
            if (r7 == 0) goto L_0x0142
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0142:
            r0 = r14 & 64
            if (r0 == 0) goto L_0x0147
            r3 = r3 & r2
        L_0x0147:
            r19 = r28
            r23 = r32
            r24 = r33
            r0 = r6
            r22 = r11
            r11 = r12
            r12 = r9
            goto L_0x01b3
        L_0x0154:
            if (r5 == 0) goto L_0x0159
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            r6 = r0
        L_0x0159:
            r0 = 0
            if (r7 == 0) goto L_0x0164
            r5 = 3
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState r5 = androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(r0, r0, r13, r0, r5)
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x0166
        L_0x0164:
            r5 = r28
        L_0x0166:
            if (r8 == 0) goto L_0x0172
            float r7 = (float) r0
            float r7 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r7)
            androidx.compose.foundation.layout.PaddingValues r7 = androidx.compose.foundation.layout.PaddingKt.m479PaddingValues0680j_4(r7)
            goto L_0x0173
        L_0x0172:
            r7 = r9
        L_0x0173:
            if (r10 == 0) goto L_0x0181
            androidx.compose.foundation.layout.Arrangement r8 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            float r9 = (float) r0
            float r9 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r9)
            androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical r8 = r8.m394spacedBy0680j_4(r9)
            goto L_0x0182
        L_0x0181:
            r8 = r12
        L_0x0182:
            if (r16 == 0) goto L_0x0190
            androidx.compose.foundation.layout.Arrangement r9 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            float r0 = (float) r0
            float r0 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r0)
            androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical r0 = r9.m394spacedBy0680j_4(r0)
            r11 = r0
        L_0x0190:
            r0 = r14 & 64
            if (r0 == 0) goto L_0x019e
            androidx.compose.foundation.gestures.ScrollableDefaults r0 = androidx.compose.foundation.gestures.ScrollableDefaults.INSTANCE
            r9 = 6
            androidx.compose.foundation.gestures.FlingBehavior r0 = r0.flingBehavior(r13, r9)
            r2 = r2 & r3
            r3 = r2
            goto L_0x01a0
        L_0x019e:
            r0 = r32
        L_0x01a0:
            if (r4 == 0) goto L_0x01a8
            r2 = 1
            r23 = r0
            r24 = r2
            goto L_0x01ac
        L_0x01a8:
            r24 = r33
            r23 = r0
        L_0x01ac:
            r19 = r5
            r0 = r6
            r12 = r7
            r22 = r11
            r11 = r8
        L_0x01b3:
            r13.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x01c5
            r2 = -1
            java.lang.String r4 = "androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid (LazyStaggeredGridDsl.kt:137)"
            r5 = -1591874454(0xffffffffa11dec6a, float:-5.350656E-19)
            androidx.compose.runtime.ComposerKt.traceEventStart(r5, r3, r2, r4)
        L_0x01c5:
            androidx.compose.foundation.gestures.Orientation r4 = androidx.compose.foundation.gestures.Orientation.Horizontal
            r2 = r3 & 14
            int r5 = r3 >> 9
            r5 = r5 & 112(0x70, float:1.57E-43)
            r2 = r2 | r5
            int r5 = r3 >> 3
            r5 = r5 & 896(0x380, float:1.256E-42)
            r2 = r2 | r5
            kotlin.jvm.functions.Function2 r5 = rememberRowHeightSums(r1, r11, r12, r13, r2)
            r7 = 0
            int r2 = r3 << 6
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | 56
            int r6 = r3 << 3
            r8 = 57344(0xe000, float:8.0356E-41)
            r6 = r6 & r8
            r2 = r2 | r6
            r6 = r3 & r17
            r2 = r2 | r6
            r6 = r3 & r20
            r2 = r2 | r6
            int r6 = r3 << 12
            r8 = r6 & r21
            r2 = r2 | r8
            r8 = 1879048192(0x70000000, float:1.58456325E29)
            r6 = r6 & r8
            r16 = r2 | r6
            int r2 = r3 >> 24
            r17 = r2 & 14
            r18 = 32
            r2 = r19
            r3 = r4
            r4 = r5
            r5 = r0
            r6 = r12
            r8 = r23
            r9 = r24
            r10 = r11
            r20 = r11
            r11 = r22
            r21 = r12
            r12 = r34
            r25 = r13
            r14 = r16
            r15 = r17
            r16 = r18
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridKt.LazyStaggeredGrid(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0222
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0222:
            r2 = r0
            r3 = r19
            r5 = r20
            r4 = r21
            r6 = r22
            r7 = r23
            r8 = r24
        L_0x022f:
            androidx.compose.runtime.ScopeUpdateScope r12 = r25.endRestartGroup()
            if (r12 != 0) goto L_0x0236
            goto L_0x0247
        L_0x0236:
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$LazyHorizontalStaggeredGrid$1 r13 = new androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$LazyHorizontalStaggeredGrid$1
            r0 = r13
            r1 = r26
            r9 = r34
            r10 = r36
            r11 = r37
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r12.updateScope(r13)
        L_0x0247:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt.LazyHorizontalStaggeredGrid(androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells, androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.foundation.gestures.FlingBehavior, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:136:0x0233  */
    /* JADX WARNING: Removed duplicated region for block: B:138:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x012a  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.foundation.ExperimentalFoundationApi
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void LazyVerticalStaggeredGrid(@org.jetbrains.annotations.NotNull androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells r26, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r27, @org.jetbrains.annotations.Nullable androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState r28, @org.jetbrains.annotations.Nullable androidx.compose.foundation.layout.PaddingValues r29, @org.jetbrains.annotations.Nullable androidx.compose.foundation.layout.Arrangement.Vertical r30, @org.jetbrains.annotations.Nullable androidx.compose.foundation.layout.Arrangement.Horizontal r31, @org.jetbrains.annotations.Nullable androidx.compose.foundation.gestures.FlingBehavior r32, boolean r33, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope, kotlin.Unit> r34, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r35, int r36, int r37) {
        /*
            r1 = r26
            r0 = r34
            r15 = r36
            r14 = r37
            java.lang.String r2 = "columns"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            java.lang.String r2 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            r2 = -228373416(0xfffffffff2634c58, float:-4.502105E30)
            r3 = r35
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
            r5 = r14 & 2
            if (r5 == 0) goto L_0x0039
            r3 = r3 | 48
            goto L_0x004c
        L_0x0039:
            r6 = r15 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L_0x004c
            r6 = r27
            boolean r7 = r13.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0048
            r7 = 32
            goto L_0x004a
        L_0x0048:
            r7 = 16
        L_0x004a:
            r3 = r3 | r7
            goto L_0x004e
        L_0x004c:
            r6 = r27
        L_0x004e:
            r7 = r14 & 4
            if (r7 == 0) goto L_0x0054
            r3 = r3 | 128(0x80, float:1.794E-43)
        L_0x0054:
            r8 = r14 & 8
            if (r8 == 0) goto L_0x005b
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x006e
        L_0x005b:
            r9 = r15 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x006e
            r9 = r29
            boolean r10 = r13.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x006a
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x006c
        L_0x006a:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x006c:
            r3 = r3 | r10
            goto L_0x0070
        L_0x006e:
            r9 = r29
        L_0x0070:
            r10 = r14 & 16
            r11 = 57344(0xe000, float:8.0356E-41)
            if (r10 == 0) goto L_0x007a
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x008e
        L_0x007a:
            r12 = r15 & r11
            if (r12 != 0) goto L_0x008e
            r12 = r30
            boolean r16 = r13.changed((java.lang.Object) r12)
            if (r16 == 0) goto L_0x0089
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x008b
        L_0x0089:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x008b:
            r3 = r3 | r16
            goto L_0x0090
        L_0x008e:
            r12 = r30
        L_0x0090:
            r16 = r14 & 32
            if (r16 == 0) goto L_0x009b
            r17 = 196608(0x30000, float:2.75506E-40)
            r3 = r3 | r17
            r11 = r31
            goto L_0x00b0
        L_0x009b:
            r17 = 458752(0x70000, float:6.42848E-40)
            r17 = r15 & r17
            r11 = r31
            if (r17 != 0) goto L_0x00b0
            boolean r17 = r13.changed((java.lang.Object) r11)
            if (r17 == 0) goto L_0x00ac
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ae
        L_0x00ac:
            r17 = 65536(0x10000, float:9.18355E-41)
        L_0x00ae:
            r3 = r3 | r17
        L_0x00b0:
            r17 = 3670016(0x380000, float:5.142788E-39)
            r18 = r15 & r17
            if (r18 != 0) goto L_0x00ca
            r18 = r14 & 64
            r2 = r32
            if (r18 != 0) goto L_0x00c5
            boolean r19 = r13.changed((java.lang.Object) r2)
            if (r19 == 0) goto L_0x00c5
            r19 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00c7
        L_0x00c5:
            r19 = 524288(0x80000, float:7.34684E-40)
        L_0x00c7:
            r3 = r3 | r19
            goto L_0x00cc
        L_0x00ca:
            r2 = r32
        L_0x00cc:
            r4 = r14 & 128(0x80, float:1.794E-43)
            r20 = 29360128(0x1c00000, float:7.052966E-38)
            if (r4 == 0) goto L_0x00d9
            r21 = 12582912(0xc00000, float:1.7632415E-38)
            r3 = r3 | r21
            r2 = r33
            goto L_0x00ec
        L_0x00d9:
            r21 = r15 & r20
            r2 = r33
            if (r21 != 0) goto L_0x00ec
            boolean r21 = r13.changed((boolean) r2)
            if (r21 == 0) goto L_0x00e8
            r21 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ea
        L_0x00e8:
            r21 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ea:
            r3 = r3 | r21
        L_0x00ec:
            r2 = r14 & 256(0x100, float:3.59E-43)
            r21 = 234881024(0xe000000, float:1.5777218E-30)
            if (r2 == 0) goto L_0x00f6
            r2 = 100663296(0x6000000, float:2.4074124E-35)
        L_0x00f4:
            r3 = r3 | r2
            goto L_0x0106
        L_0x00f6:
            r2 = r15 & r21
            if (r2 != 0) goto L_0x0106
            boolean r2 = r13.changed((java.lang.Object) r0)
            if (r2 == 0) goto L_0x0103
            r2 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x00f4
        L_0x0103:
            r2 = 33554432(0x2000000, float:9.403955E-38)
            goto L_0x00f4
        L_0x0106:
            r2 = 4
            if (r7 != r2) goto L_0x012a
            r2 = 191739611(0xb6db6db, float:4.5782105E-32)
            r2 = r2 & r3
            r0 = 38347922(0x2492492, float:1.4777643E-37)
            if (r2 != r0) goto L_0x012a
            boolean r0 = r13.getSkipping()
            if (r0 != 0) goto L_0x0119
            goto L_0x012a
        L_0x0119:
            r13.skipToGroupEnd()
            r3 = r28
            r7 = r32
            r8 = r33
            r2 = r6
            r4 = r9
            r6 = r11
            r5 = r12
            r25 = r13
            goto L_0x022c
        L_0x012a:
            r13.startDefaults()
            r0 = r15 & 1
            r2 = -3670017(0xffffffffffc7ffff, float:NaN)
            if (r0 == 0) goto L_0x0153
            boolean r0 = r13.getDefaultsInvalid()
            if (r0 == 0) goto L_0x013b
            goto L_0x0153
        L_0x013b:
            r13.skipToGroupEnd()
            if (r7 == 0) goto L_0x0142
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0142:
            r0 = r14 & 64
            if (r0 == 0) goto L_0x0147
            r3 = r3 & r2
        L_0x0147:
            r19 = r28
            r23 = r32
            r24 = r33
            r0 = r6
            r22 = r12
            r12 = r9
            goto L_0x01b1
        L_0x0153:
            if (r5 == 0) goto L_0x0158
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            r6 = r0
        L_0x0158:
            r0 = 0
            if (r7 == 0) goto L_0x0163
            r5 = 3
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState r5 = androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(r0, r0, r13, r0, r5)
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x0165
        L_0x0163:
            r5 = r28
        L_0x0165:
            if (r8 == 0) goto L_0x0171
            float r7 = (float) r0
            float r7 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r7)
            androidx.compose.foundation.layout.PaddingValues r7 = androidx.compose.foundation.layout.PaddingKt.m479PaddingValues0680j_4(r7)
            goto L_0x0172
        L_0x0171:
            r7 = r9
        L_0x0172:
            if (r10 == 0) goto L_0x0180
            androidx.compose.foundation.layout.Arrangement r8 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            float r9 = (float) r0
            float r9 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r9)
            androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical r8 = r8.m394spacedBy0680j_4(r9)
            goto L_0x0181
        L_0x0180:
            r8 = r12
        L_0x0181:
            if (r16 == 0) goto L_0x018f
            androidx.compose.foundation.layout.Arrangement r9 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            float r0 = (float) r0
            float r0 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r0)
            androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical r0 = r9.m394spacedBy0680j_4(r0)
            r11 = r0
        L_0x018f:
            r0 = r14 & 64
            if (r0 == 0) goto L_0x019d
            androidx.compose.foundation.gestures.ScrollableDefaults r0 = androidx.compose.foundation.gestures.ScrollableDefaults.INSTANCE
            r9 = 6
            androidx.compose.foundation.gestures.FlingBehavior r0 = r0.flingBehavior(r13, r9)
            r2 = r2 & r3
            r3 = r2
            goto L_0x019f
        L_0x019d:
            r0 = r32
        L_0x019f:
            if (r4 == 0) goto L_0x01a7
            r2 = 1
            r23 = r0
            r24 = r2
            goto L_0x01ab
        L_0x01a7:
            r24 = r33
            r23 = r0
        L_0x01ab:
            r19 = r5
            r0 = r6
            r12 = r7
            r22 = r8
        L_0x01b1:
            r13.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x01c3
            r2 = -1
            java.lang.String r4 = "androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid (LazyStaggeredGridDsl.kt:55)"
            r5 = -228373416(0xfffffffff2634c58, float:-4.502105E30)
            androidx.compose.runtime.ComposerKt.traceEventStart(r5, r3, r2, r4)
        L_0x01c3:
            androidx.compose.foundation.gestures.Orientation r4 = androidx.compose.foundation.gestures.Orientation.Vertical
            r2 = r3 & 14
            int r5 = r3 >> 12
            r5 = r5 & 112(0x70, float:1.57E-43)
            r2 = r2 | r5
            int r5 = r3 >> 3
            r5 = r5 & 896(0x380, float:1.256E-42)
            r2 = r2 | r5
            kotlin.jvm.functions.Function2 r5 = rememberColumnWidthSums(r1, r11, r12, r13, r2)
            r7 = 0
            int r2 = r3 << 6
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | 56
            int r6 = r3 << 3
            r8 = 57344(0xe000, float:8.0356E-41)
            r6 = r6 & r8
            r2 = r2 | r6
            r6 = r3 & r17
            r2 = r2 | r6
            r6 = r3 & r20
            r2 = r2 | r6
            int r6 = r3 << 12
            r8 = r6 & r21
            r2 = r2 | r8
            r8 = 1879048192(0x70000000, float:1.58456325E29)
            r6 = r6 & r8
            r16 = r2 | r6
            int r2 = r3 >> 24
            r17 = r2 & 14
            r18 = 32
            r2 = r19
            r3 = r4
            r4 = r5
            r5 = r0
            r6 = r12
            r8 = r23
            r9 = r24
            r10 = r22
            r20 = r11
            r21 = r12
            r12 = r34
            r25 = r13
            r14 = r16
            r15 = r17
            r16 = r18
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridKt.LazyStaggeredGrid(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x021f
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x021f:
            r2 = r0
            r3 = r19
            r6 = r20
            r4 = r21
            r5 = r22
            r7 = r23
            r8 = r24
        L_0x022c:
            androidx.compose.runtime.ScopeUpdateScope r12 = r25.endRestartGroup()
            if (r12 != 0) goto L_0x0233
            goto L_0x0244
        L_0x0233:
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$LazyVerticalStaggeredGrid$1 r13 = new androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$LazyVerticalStaggeredGrid$1
            r0 = r13
            r1 = r26
            r9 = r34
            r10 = r36
            r11 = r37
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r12.updateScope(r13)
        L_0x0244:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt.LazyVerticalStaggeredGrid(androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells, androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.foundation.gestures.FlingBehavior, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    @ExperimentalFoundationApi
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final <T> void items(@NotNull LazyStaggeredGridScope lazyStaggeredGridScope, @NotNull List<? extends T> list, @Nullable Function1<? super T, ? extends Object> function1, @NotNull Function1<? super T, ? extends Object> function12, @NotNull Function4<? super LazyStaggeredGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4) {
        Intrinsics.checkNotNullParameter(lazyStaggeredGridScope, "<this>");
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullParameter(function12, AnalyticsAttribute.CONTENT_TYPE_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(function4, "itemContent");
        lazyStaggeredGridScope.items(list.size(), function1 != null ? new LazyStaggeredGridDslKt$items$2$1(function1, list) : null, new LazyStaggeredGridDslKt$items$3(function12, list), ComposableLambdaKt.composableLambdaInstance(-666084403, true, new LazyStaggeredGridDslKt$items$4(function4, list)));
    }

    public static /* synthetic */ void items$default(LazyStaggeredGridScope lazyStaggeredGridScope, List list, Function1 function1, Function1 function12, Function4 function4, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            function1 = null;
        }
        if ((i11 & 4) != 0) {
            function12 = LazyStaggeredGridDslKt$items$1.INSTANCE;
        }
        items(lazyStaggeredGridScope, list, function1, function12, function4);
    }

    @ExperimentalFoundationApi
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final <T> void itemsIndexed(@NotNull LazyStaggeredGridScope lazyStaggeredGridScope, @NotNull List<? extends T> list, @Nullable Function2<? super Integer, ? super T, ? extends Object> function2, @NotNull Function2<? super Integer, ? super T, ? extends Object> function22, @NotNull Function5<? super LazyStaggeredGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5) {
        Intrinsics.checkNotNullParameter(lazyStaggeredGridScope, "<this>");
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullParameter(function22, AnalyticsAttribute.CONTENT_TYPE_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(function5, "itemContent");
        lazyStaggeredGridScope.items(list.size(), function2 != null ? new LazyStaggeredGridDslKt$itemsIndexed$2$1(function2, list) : null, new LazyStaggeredGridDslKt$itemsIndexed$3(function22, list), ComposableLambdaKt.composableLambdaInstance(330414727, true, new LazyStaggeredGridDslKt$itemsIndexed$4(function5, list)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyStaggeredGridScope lazyStaggeredGridScope, List list, Function2 function2, Function2 function22, Function5 function5, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            function2 = null;
        }
        if ((i11 & 4) != 0) {
            function22 = LazyStaggeredGridDslKt$itemsIndexed$1.INSTANCE;
        }
        itemsIndexed(lazyStaggeredGridScope, list, function2, function22, function5);
    }

    @Composable
    private static final Function2<Density, Constraints, int[]> rememberColumnWidthSums(StaggeredGridCells staggeredGridCells, Arrangement.Horizontal horizontal, PaddingValues paddingValues, Composer composer, int i11) {
        composer.startReplaceableGroup(1426908594);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1426908594, i11, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberColumnWidthSums (LazyStaggeredGridDsl.kt:83)");
        }
        composer.startReplaceableGroup(1618982084);
        boolean changed = composer.changed((Object) staggeredGridCells) | composer.changed((Object) horizontal) | composer.changed((Object) paddingValues);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new LazyStaggeredGridDslKt$rememberColumnWidthSums$1$1(paddingValues, staggeredGridCells, horizontal);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Function2<Density, Constraints, int[]> function2 = (Function2) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return function2;
    }

    @Composable
    private static final Function2<Density, Constraints, int[]> rememberRowHeightSums(StaggeredGridCells staggeredGridCells, Arrangement.Vertical vertical, PaddingValues paddingValues, Composer composer, int i11) {
        composer.startReplaceableGroup(-1665208491);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1665208491, i11, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberRowHeightSums (LazyStaggeredGridDsl.kt:165)");
        }
        composer.startReplaceableGroup(1618982084);
        boolean changed = composer.changed((Object) staggeredGridCells) | composer.changed((Object) vertical) | composer.changed((Object) paddingValues);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new LazyStaggeredGridDslKt$rememberRowHeightSums$1$1(paddingValues, staggeredGridCells, vertical);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Function2<Density, Constraints, int[]> function2 = (Function2) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return function2;
    }

    public static /* synthetic */ void items$default(LazyStaggeredGridScope lazyStaggeredGridScope, Object[] objArr, Function1 function1, Function1 function12, Function4 function4, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            function1 = null;
        }
        if ((i11 & 4) != 0) {
            function12 = LazyStaggeredGridDslKt$items$5.INSTANCE;
        }
        items(lazyStaggeredGridScope, (T[]) objArr, function1, function12, function4);
    }

    public static /* synthetic */ void itemsIndexed$default(LazyStaggeredGridScope lazyStaggeredGridScope, Object[] objArr, Function2 function2, Function2 function22, Function5 function5, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            function2 = null;
        }
        if ((i11 & 4) != 0) {
            function22 = LazyStaggeredGridDslKt$itemsIndexed$5.INSTANCE;
        }
        itemsIndexed(lazyStaggeredGridScope, (T[]) objArr, function2, function22, function5);
    }

    @ExperimentalFoundationApi
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final <T> void items(@NotNull LazyStaggeredGridScope lazyStaggeredGridScope, @NotNull T[] tArr, @Nullable Function1<? super T, ? extends Object> function1, @NotNull Function1<? super T, ? extends Object> function12, @NotNull Function4<? super LazyStaggeredGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4) {
        Intrinsics.checkNotNullParameter(lazyStaggeredGridScope, "<this>");
        Intrinsics.checkNotNullParameter(tArr, FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullParameter(function12, AnalyticsAttribute.CONTENT_TYPE_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(function4, "itemContent");
        lazyStaggeredGridScope.items(tArr.length, function1 != null ? new LazyStaggeredGridDslKt$items$6$1(function1, tArr) : null, new LazyStaggeredGridDslKt$items$7(function12, tArr), ComposableLambdaKt.composableLambdaInstance(-301024882, true, new LazyStaggeredGridDslKt$items$8(function4, tArr)));
    }

    @ExperimentalFoundationApi
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final <T> void itemsIndexed(@NotNull LazyStaggeredGridScope lazyStaggeredGridScope, @NotNull T[] tArr, @Nullable Function2<? super Integer, ? super T, ? extends Object> function2, @NotNull Function2<? super Integer, ? super T, ? extends Object> function22, @NotNull Function5<? super LazyStaggeredGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5) {
        Intrinsics.checkNotNullParameter(lazyStaggeredGridScope, "<this>");
        Intrinsics.checkNotNullParameter(tArr, FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullParameter(function22, AnalyticsAttribute.CONTENT_TYPE_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(function5, "itemContent");
        lazyStaggeredGridScope.items(tArr.length, function2 != null ? new LazyStaggeredGridDslKt$itemsIndexed$6$1(function2, tArr) : null, new LazyStaggeredGridDslKt$itemsIndexed$7(function22, tArr), ComposableLambdaKt.composableLambdaInstance(-730083922, true, new LazyStaggeredGridDslKt$itemsIndexed$8(function5, tArr)));
    }
}
