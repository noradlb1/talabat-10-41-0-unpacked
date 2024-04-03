package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0001H\u0000\u001a\r\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u000b\u001a%\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\f\u0010\u0012\u001a\u00020\u0001*\u00020\u0001H\u0002\u001a\f\u0010\u0013\u001a\u00020\u0001*\u00020\u0003H\u0002\u001a\u0019\u0010\u0014\u001a\u00020\u0003*\u00020\u0015H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\f\u0010\u0018\u001a\u00020\u0001*\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u001b\u0010\u0002\u001a\u00020\u0003*\u00020\u00048BX\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0019"}, d2 = {"ScrollingAxesThreshold", "", "scrollAxes", "", "Landroidx/compose/ui/geometry/Offset;", "getScrollAxes-k-4lQ0M", "(J)I", "composeToViewOffset", "offset", "rememberNestedScrollInteropConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "toOffset", "consumed", "", "available", "toOffset-Uv8p0NA", "([IJ)J", "ceilAwayFromZero", "reverseAxis", "toViewType", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "toViewType-GyEprt8", "(I)I", "toViewVelocity", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class NestedScrollInteropConnectionKt {
    private static final float ScrollingAxesThreshold = 0.5f;

    private static final float ceilAwayFromZero(float f11) {
        return (float) (f11 >= 0.0f ? Math.ceil((double) f11) : Math.floor((double) f11));
    }

    public static final int composeToViewOffset(float f11) {
        return ((int) ceilAwayFromZero(f11)) * -1;
    }

    /* access modifiers changed from: private */
    /* renamed from: getScrollAxes-k-4lQ0M  reason: not valid java name */
    public static final int m4866getScrollAxesk4lQ0M(long j11) {
        int i11;
        if (Math.abs(Offset.m2676getXimpl(j11)) >= 0.5f) {
            i11 = 1;
        } else {
            i11 = 0;
        }
        if (Math.abs(Offset.m2677getYimpl(j11)) >= 0.5f) {
            return i11 | 2;
        }
        return i11;
    }

    @ExperimentalComposeUiApi
    @NotNull
    @Composable
    public static final NestedScrollConnection rememberNestedScrollInteropConnection(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(1471602047);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1471602047, i11, -1, "androidx.compose.ui.platform.rememberNestedScrollInteropConnection (NestedScrollInteropConnection.kt:231)");
        }
        View view = (View) composer.consume(AndroidCompositionLocals_androidKt.getLocalView());
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed((Object) view);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new NestedScrollInteropConnection(view);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        NestedScrollInteropConnection nestedScrollInteropConnection = (NestedScrollInteropConnection) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return nestedScrollInteropConnection;
    }

    private static final float reverseAxis(int i11) {
        return ((float) i11) * -1.0f;
    }

    /* access modifiers changed from: private */
    /* renamed from: toOffset-Uv8p0NA  reason: not valid java name */
    public static final long m4867toOffsetUv8p0NA(int[] iArr, long j11) {
        float f11;
        float f12;
        if (Offset.m2676getXimpl(j11) >= 0.0f) {
            f11 = RangesKt___RangesKt.coerceAtMost(reverseAxis(iArr[0]), Offset.m2676getXimpl(j11));
        } else {
            f11 = RangesKt___RangesKt.coerceAtLeast(reverseAxis(iArr[0]), Offset.m2676getXimpl(j11));
        }
        if (Offset.m2677getYimpl(j11) >= 0.0f) {
            f12 = RangesKt___RangesKt.coerceAtMost(reverseAxis(iArr[1]), Offset.m2677getYimpl(j11));
        } else {
            f12 = RangesKt___RangesKt.coerceAtLeast(reverseAxis(iArr[1]), Offset.m2677getYimpl(j11));
        }
        return OffsetKt.Offset(f11, f12);
    }

    /* access modifiers changed from: private */
    /* renamed from: toViewType-GyEprt8  reason: not valid java name */
    public static final int m4868toViewTypeGyEprt8(int i11) {
        return NestedScrollSource.m4213equalsimpl0(i11, NestedScrollSource.Companion.m4218getDragWNlRxjI()) ^ true ? 1 : 0;
    }

    /* access modifiers changed from: private */
    public static final float toViewVelocity(float f11) {
        return f11 * -1.0f;
    }
}
