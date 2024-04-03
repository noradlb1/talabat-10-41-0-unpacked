package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007JH\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00142\u0014\b\u0002\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00140\u001d2\u0017\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0 ¢\u0006\u0002\b#H\u0001J+\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020'H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010)J\u001a\u0010*\u001a\u00020\u0014*\u00020+H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010-J\u001a\u0010*\u001a\u00020\u0014*\u00020.H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u00100J\u0019\u00101\u001a\u00020+*\u00020.H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u00103J\u001c\u00101\u001a\u00020+*\u00020\tH\u0016ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b4\u00105J\u001c\u00101\u001a\u00020+*\u00020\u0014H\u0016ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b4\u00106J\u0019\u00107\u001a\u000208*\u000209H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b:\u0010;J\u001a\u0010<\u001a\u00020\t*\u00020+H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b=\u00105J\u001a\u0010<\u001a\u00020\t*\u00020.H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b>\u00103J\r\u0010?\u001a\u00020@*\u00020AH\u0001J\u0019\u0010B\u001a\u000209*\u000208H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bC\u0010;J\u0019\u0010D\u001a\u00020.*\u00020+H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bE\u0010FJ\u001c\u0010D\u001a\u00020.*\u00020\tH\u0016ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bG\u0010FJ\u001c\u0010D\u001a\u00020.*\u00020\u0014H\u0016ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bG\u0010HR\u0014\u0010\b\u001a\u00020\t8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u000fX\u0005¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R6\u0010\u0012\u001a*\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0013j\u0014\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015`\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0002\b!¨\u0006I"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScopeImpl;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/layout/MeasureScope;", "itemContentFactory", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;", "subcomposeMeasureScope", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;Landroidx/compose/ui/layout/SubcomposeMeasureScope;)V", "density", "", "getDensity", "()F", "fontScale", "getFontScale", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "placeablesCache", "Ljava/util/HashMap;", "", "", "Landroidx/compose/ui/layout/Placeable;", "Lkotlin/collections/HashMap;", "layout", "Landroidx/compose/ui/layout/MeasureResult;", "width", "height", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "placementBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "measure", "index", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-0kLqBqw", "(IJ)Ljava/util/List;", "roundToPx", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ExperimentalFoundationApi
public final class LazyLayoutMeasureScopeImpl implements LazyLayoutMeasureScope, MeasureScope {
    @NotNull
    private final LazyLayoutItemContentFactory itemContentFactory;
    @NotNull
    private final HashMap<Integer, List<Placeable>> placeablesCache = new HashMap<>();
    @NotNull
    private final SubcomposeMeasureScope subcomposeMeasureScope;

    public LazyLayoutMeasureScopeImpl(@NotNull LazyLayoutItemContentFactory lazyLayoutItemContentFactory, @NotNull SubcomposeMeasureScope subcomposeMeasureScope2) {
        Intrinsics.checkNotNullParameter(lazyLayoutItemContentFactory, "itemContentFactory");
        Intrinsics.checkNotNullParameter(subcomposeMeasureScope2, "subcomposeMeasureScope");
        this.itemContentFactory = lazyLayoutItemContentFactory;
        this.subcomposeMeasureScope = subcomposeMeasureScope2;
    }

    public float getDensity() {
        return this.subcomposeMeasureScope.getDensity();
    }

    public float getFontScale() {
        return this.subcomposeMeasureScope.getFontScale();
    }

    @NotNull
    public LayoutDirection getLayoutDirection() {
        return this.subcomposeMeasureScope.getLayoutDirection();
    }

    @NotNull
    public MeasureResult layout(int i11, int i12, @NotNull Map<AlignmentLine, Integer> map, @NotNull Function1<? super Placeable.PlacementScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(map, "alignmentLines");
        Intrinsics.checkNotNullParameter(function1, "placementBlock");
        return this.subcomposeMeasureScope.layout(i11, i12, map, function1);
    }

    @NotNull
    /* renamed from: measure-0kLqBqw  reason: not valid java name */
    public List<Placeable> m747measure0kLqBqw(int i11, long j11) {
        List<Placeable> list = this.placeablesCache.get(Integer.valueOf(i11));
        if (list != null) {
            return list;
        }
        Object key = this.itemContentFactory.getItemProvider().invoke().getKey(i11);
        List<Measurable> subcompose = this.subcomposeMeasureScope.subcompose(key, this.itemContentFactory.getContent(i11, key));
        int size = subcompose.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i12 = 0; i12 < size; i12++) {
            arrayList.add(subcompose.get(i12).m4508measureBRTryo0(j11));
        }
        this.placeablesCache.put(Integer.valueOf(i11), arrayList);
        return arrayList;
    }

    @Stable
    /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
    public int m748roundToPxR2X_6o(long j11) {
        return this.subcomposeMeasureScope.m5440roundToPxR2X_6o(j11);
    }

    @Stable
    /* renamed from: roundToPx-0680j_4  reason: not valid java name */
    public int m749roundToPx0680j_4(float f11) {
        return this.subcomposeMeasureScope.m5441roundToPx0680j_4(f11);
    }

    /* renamed from: toDp-GaN1DYA  reason: not valid java name */
    public float m750toDpGaN1DYA(long j11) {
        return this.subcomposeMeasureScope.m5442toDpGaN1DYA(j11);
    }

    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    public float m752toDpu2uoSUM(int i11) {
        return this.subcomposeMeasureScope.m5444toDpu2uoSUM(i11);
    }

    /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
    public long m753toDpSizekrfVVM(long j11) {
        return this.subcomposeMeasureScope.m5445toDpSizekrfVVM(j11);
    }

    @Stable
    /* renamed from: toPx--R2X_6o  reason: not valid java name */
    public float m754toPxR2X_6o(long j11) {
        return this.subcomposeMeasureScope.m5446toPxR2X_6o(j11);
    }

    @Stable
    /* renamed from: toPx-0680j_4  reason: not valid java name */
    public float m755toPx0680j_4(float f11) {
        return this.subcomposeMeasureScope.m5447toPx0680j_4(f11);
    }

    @NotNull
    @Stable
    public Rect toRect(@NotNull DpRect dpRect) {
        Intrinsics.checkNotNullParameter(dpRect, "<this>");
        return this.subcomposeMeasureScope.toRect(dpRect);
    }

    /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
    public long m756toSizeXkaWNTQ(long j11) {
        return this.subcomposeMeasureScope.m5448toSizeXkaWNTQ(j11);
    }

    /* renamed from: toSp-0xMU5do  reason: not valid java name */
    public long m757toSp0xMU5do(float f11) {
        return this.subcomposeMeasureScope.m5449toSp0xMU5do(f11);
    }

    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    public long m758toSpkPz2Gy4(float f11) {
        return this.subcomposeMeasureScope.m5450toSpkPz2Gy4(f11);
    }

    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    public float m751toDpu2uoSUM(float f11) {
        return this.subcomposeMeasureScope.m5443toDpu2uoSUM(f11);
    }

    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    public long m759toSpkPz2Gy4(int i11) {
        return this.subcomposeMeasureScope.m5451toSpkPz2Gy4(i11);
    }
}
