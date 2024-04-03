package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Size;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a%\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\u0006\u001a%\u0010\t\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u0006\u001a%\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\u0006\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\r"}, d2 = {"computeFillHeight", "", "srcSize", "Landroidx/compose/ui/geometry/Size;", "dstSize", "computeFillHeight-iLBOSCw", "(JJ)F", "computeFillMaxDimension", "computeFillMaxDimension-iLBOSCw", "computeFillMinDimension", "computeFillMinDimension-iLBOSCw", "computeFillWidth", "computeFillWidth-iLBOSCw", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ContentScaleKt {
    /* access modifiers changed from: private */
    /* renamed from: computeFillHeight-iLBOSCw  reason: not valid java name */
    public static final float m4453computeFillHeightiLBOSCw(long j11, long j12) {
        return Size.m2742getHeightimpl(j12) / Size.m2742getHeightimpl(j11);
    }

    /* access modifiers changed from: private */
    /* renamed from: computeFillMaxDimension-iLBOSCw  reason: not valid java name */
    public static final float m4454computeFillMaxDimensioniLBOSCw(long j11, long j12) {
        return Math.max(m4456computeFillWidthiLBOSCw(j11, j12), m4453computeFillHeightiLBOSCw(j11, j12));
    }

    /* access modifiers changed from: private */
    /* renamed from: computeFillMinDimension-iLBOSCw  reason: not valid java name */
    public static final float m4455computeFillMinDimensioniLBOSCw(long j11, long j12) {
        return Math.min(m4456computeFillWidthiLBOSCw(j11, j12), m4453computeFillHeightiLBOSCw(j11, j12));
    }

    /* access modifiers changed from: private */
    /* renamed from: computeFillWidth-iLBOSCw  reason: not valid java name */
    public static final float m4456computeFillWidthiLBOSCw(long j11, long j12) {
        return Size.m2745getWidthimpl(j12) / Size.m2745getWidthimpl(j11);
    }
}
