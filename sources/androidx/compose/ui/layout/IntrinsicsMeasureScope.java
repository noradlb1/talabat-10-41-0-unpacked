package androidx.compose.ui.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.LayoutDirection;
import com.instabug.library.model.State;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u000e\u001a\u00020\u000f*\u00020\u0010H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u000e\u001a\u00020\u000f*\u00020\u0013H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0016\u001a\u00020\u0010*\u00020\u0013H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u0016\u001a\u00020\u0010*\u00020\u0007H\u0001ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u0016\u001a\u00020\u0010*\u00020\u000fH\u0001ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001bJ\u001a\u0010\u001c\u001a\u00020\u001d*\u00020\u001eH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010!\u001a\u00020\u0007*\u00020\u0010H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010\u001aJ\u001a\u0010!\u001a\u00020\u0007*\u00020\u0013H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010\u0018J\r\u0010$\u001a\u00020%*\u00020&H\u0001J\u001a\u0010'\u001a\u00020\u001e*\u00020\u001dH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010 J\u001a\u0010)\u001a\u00020\u0013*\u00020\u0010H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010+J\u001d\u0010)\u001a\u00020\u0013*\u00020\u0007H\u0001ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010+J\u001d\u0010)\u001a\u00020\u0013*\u00020\u000fH\u0001ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010-R\u0014\u0010\u0003\u001a\u00020\u00078\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u0002\u000f\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0002\b!¨\u0006."}, d2 = {"Landroidx/compose/ui/layout/IntrinsicsMeasureScope;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/unit/Density;", "density", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;)V", "", "getDensity", "()F", "fontScale", "getFontScale", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class IntrinsicsMeasureScope implements MeasureScope, Density {
    private final /* synthetic */ Density $$delegate_0;
    @NotNull
    private final LayoutDirection layoutDirection;

    public IntrinsicsMeasureScope(@NotNull Density density, @NotNull LayoutDirection layoutDirection2) {
        Intrinsics.checkNotNullParameter(density, State.KEY_DENSITY);
        Intrinsics.checkNotNullParameter(layoutDirection2, "layoutDirection");
        this.layoutDirection = layoutDirection2;
        this.$$delegate_0 = density;
    }

    public float getDensity() {
        return this.$$delegate_0.getDensity();
    }

    public float getFontScale() {
        return this.$$delegate_0.getFontScale();
    }

    @NotNull
    public LayoutDirection getLayoutDirection() {
        return this.layoutDirection;
    }

    public /* synthetic */ MeasureResult layout(int i11, int i12, Map map, Function1 function1) {
        return MeasureScope.CC.a(this, i11, i12, map, function1);
    }

    @Stable
    /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
    public int m4461roundToPxR2X_6o(long j11) {
        return this.$$delegate_0.m5440roundToPxR2X_6o(j11);
    }

    @Stable
    /* renamed from: roundToPx-0680j_4  reason: not valid java name */
    public int m4462roundToPx0680j_4(float f11) {
        return this.$$delegate_0.m5441roundToPx0680j_4(f11);
    }

    @Stable
    /* renamed from: toDp-GaN1DYA  reason: not valid java name */
    public float m4463toDpGaN1DYA(long j11) {
        return this.$$delegate_0.m5442toDpGaN1DYA(j11);
    }

    @Stable
    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    public float m4464toDpu2uoSUM(float f11) {
        return this.$$delegate_0.m5443toDpu2uoSUM(f11);
    }

    @Stable
    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    public float m4465toDpu2uoSUM(int i11) {
        return this.$$delegate_0.m5444toDpu2uoSUM(i11);
    }

    @Stable
    /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
    public long m4466toDpSizekrfVVM(long j11) {
        return this.$$delegate_0.m5445toDpSizekrfVVM(j11);
    }

    @Stable
    /* renamed from: toPx--R2X_6o  reason: not valid java name */
    public float m4467toPxR2X_6o(long j11) {
        return this.$$delegate_0.m5446toPxR2X_6o(j11);
    }

    @Stable
    /* renamed from: toPx-0680j_4  reason: not valid java name */
    public float m4468toPx0680j_4(float f11) {
        return this.$$delegate_0.m5447toPx0680j_4(f11);
    }

    @NotNull
    @Stable
    public Rect toRect(@NotNull DpRect dpRect) {
        Intrinsics.checkNotNullParameter(dpRect, "<this>");
        return this.$$delegate_0.toRect(dpRect);
    }

    @Stable
    /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
    public long m4469toSizeXkaWNTQ(long j11) {
        return this.$$delegate_0.m5448toSizeXkaWNTQ(j11);
    }

    @Stable
    /* renamed from: toSp-0xMU5do  reason: not valid java name */
    public long m4470toSp0xMU5do(float f11) {
        return this.$$delegate_0.m5449toSp0xMU5do(f11);
    }

    @Stable
    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    public long m4471toSpkPz2Gy4(float f11) {
        return this.$$delegate_0.m5450toSpkPz2Gy4(f11);
    }

    @Stable
    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    public long m4472toSpkPz2Gy4(int i11) {
        return this.$$delegate_0.m5451toSpkPz2Gy4(i11);
    }
}
