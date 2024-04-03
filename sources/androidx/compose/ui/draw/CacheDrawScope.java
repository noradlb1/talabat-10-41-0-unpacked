package androidx.compose.ui.draw;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u0.a;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\u001f\u0010\u001d\u001a\u00020\u000e2\u0017\u0010\u001e\u001a\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001f¢\u0006\u0002\b\"J\u001f\u0010#\u001a\u00020\u000e2\u0017\u0010\u001e\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020!0\u001f¢\u0006\u0002\b\"R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\fR\u0011\u0010\u0015\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001a8Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006%"}, d2 = {"Landroidx/compose/ui/draw/CacheDrawScope;", "Landroidx/compose/ui/unit/Density;", "()V", "cacheParams", "Landroidx/compose/ui/draw/BuildDrawCacheParams;", "getCacheParams$ui_release", "()Landroidx/compose/ui/draw/BuildDrawCacheParams;", "setCacheParams$ui_release", "(Landroidx/compose/ui/draw/BuildDrawCacheParams;)V", "density", "", "getDensity", "()F", "drawResult", "Landroidx/compose/ui/draw/DrawResult;", "getDrawResult$ui_release", "()Landroidx/compose/ui/draw/DrawResult;", "setDrawResult$ui_release", "(Landroidx/compose/ui/draw/DrawResult;)V", "fontScale", "getFontScale", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "()J", "onDrawBehind", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "onDrawWithContent", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CacheDrawScope implements Density {
    public static final int $stable = 0;
    @NotNull
    private BuildDrawCacheParams cacheParams = EmptyBuildDrawCacheParams.INSTANCE;
    @Nullable
    private DrawResult drawResult;

    @NotNull
    public final BuildDrawCacheParams getCacheParams$ui_release() {
        return this.cacheParams;
    }

    public float getDensity() {
        return this.cacheParams.getDensity().getDensity();
    }

    @Nullable
    public final DrawResult getDrawResult$ui_release() {
        return this.drawResult;
    }

    public float getFontScale() {
        return this.cacheParams.getDensity().getFontScale();
    }

    @NotNull
    public final LayoutDirection getLayoutDirection() {
        return this.cacheParams.getLayoutDirection();
    }

    /* renamed from: getSize-NH-jbRc  reason: not valid java name */
    public final long m2573getSizeNHjbRc() {
        return this.cacheParams.m2572getSizeNHjbRc();
    }

    @NotNull
    public final DrawResult onDrawBehind(@NotNull Function1<? super DrawScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        return onDrawWithContent(new CacheDrawScope$onDrawBehind$1(function1));
    }

    @NotNull
    public final DrawResult onDrawWithContent(@NotNull Function1<? super ContentDrawScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        DrawResult drawResult2 = new DrawResult(function1);
        this.drawResult = drawResult2;
        return drawResult2;
    }

    /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
    public /* synthetic */ int m2574roundToPxR2X_6o(long j11) {
        return a.a(this, j11);
    }

    /* renamed from: roundToPx-0680j_4  reason: not valid java name */
    public /* synthetic */ int m2575roundToPx0680j_4(float f11) {
        return a.b(this, f11);
    }

    public final void setCacheParams$ui_release(@NotNull BuildDrawCacheParams buildDrawCacheParams) {
        Intrinsics.checkNotNullParameter(buildDrawCacheParams, "<set-?>");
        this.cacheParams = buildDrawCacheParams;
    }

    public final void setDrawResult$ui_release(@Nullable DrawResult drawResult2) {
        this.drawResult = drawResult2;
    }

    /* renamed from: toDp-GaN1DYA  reason: not valid java name */
    public /* synthetic */ float m2576toDpGaN1DYA(long j11) {
        return a.c(this, j11);
    }

    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    public /* synthetic */ float m2577toDpu2uoSUM(float f11) {
        return a.d(this, f11);
    }

    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    public /* synthetic */ float m2578toDpu2uoSUM(int i11) {
        return a.e(this, i11);
    }

    /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
    public /* synthetic */ long m2579toDpSizekrfVVM(long j11) {
        return a.f(this, j11);
    }

    /* renamed from: toPx--R2X_6o  reason: not valid java name */
    public /* synthetic */ float m2580toPxR2X_6o(long j11) {
        return a.g(this, j11);
    }

    /* renamed from: toPx-0680j_4  reason: not valid java name */
    public /* synthetic */ float m2581toPx0680j_4(float f11) {
        return a.h(this, f11);
    }

    public /* synthetic */ Rect toRect(DpRect dpRect) {
        return a.i(this, dpRect);
    }

    /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
    public /* synthetic */ long m2582toSizeXkaWNTQ(long j11) {
        return a.j(this, j11);
    }

    /* renamed from: toSp-0xMU5do  reason: not valid java name */
    public /* synthetic */ long m2583toSp0xMU5do(float f11) {
        return a.k(this, f11);
    }

    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    public /* synthetic */ long m2584toSpkPz2Gy4(float f11) {
        return a.l(this, f11);
    }

    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    public /* synthetic */ long m2585toSpkPz2Gy4(int i11) {
        return a.m(this, i11);
    }
}
