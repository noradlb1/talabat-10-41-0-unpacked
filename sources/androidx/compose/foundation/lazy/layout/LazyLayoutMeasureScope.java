package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001J+\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u00020\f*\u00020\rH\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001c\u0010\u000b\u001a\u00020\f*\u00020\u0010H\u0017ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001c\u0010\u000b\u001a\u00020\f*\u00020\u0006H\u0017ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0013J\u0019\u0010\u0014\u001a\u00020\u0015*\u00020\u0016H\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0019\u001a\u00020\u0016*\u00020\u0015H\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u0018J\u0019\u0010\u001b\u001a\u00020\r*\u00020\fH\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001c\u0010\u001b\u001a\u00020\r*\u00020\u0010H\u0017ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001dJ\u001c\u0010\u001b\u001a\u00020\r*\u00020\u0006H\u0017ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001f\u0001\u0001 ø\u0001\u0003\u0002\u0015\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0002\b!\n\u0004\b!0\u0001¨\u0006!À\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/layout/MeasureScope;", "measure", "", "Landroidx/compose/ui/layout/Placeable;", "index", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-0kLqBqw", "(IJ)Ljava/util/List;", "toDp", "Landroidx/compose/ui/unit/Dp;", "Landroidx/compose/ui/unit/TextUnit;", "toDp-GaN1DYA", "(J)F", "", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScopeImpl;", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ExperimentalFoundationApi
@Stable
public interface LazyLayoutMeasureScope extends MeasureScope {
    @NotNull
    /* renamed from: measure-0kLqBqw  reason: not valid java name */
    List<Placeable> m738measure0kLqBqw(int i11, long j11);

    @Stable
    /* renamed from: toDp-GaN1DYA  reason: not valid java name */
    float m739toDpGaN1DYA(long j11);

    @Stable
    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    float m740toDpu2uoSUM(float f11);

    @Stable
    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    float m741toDpu2uoSUM(int i11);

    @Stable
    /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
    long m742toDpSizekrfVVM(long j11);

    @Stable
    /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
    long m743toSizeXkaWNTQ(long j11);

    @Stable
    /* renamed from: toSp-0xMU5do  reason: not valid java name */
    long m744toSp0xMU5do(float f11);

    @Stable
    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    long m745toSpkPz2Gy4(float f11);

    @Stable
    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    long m746toSpkPz2Gy4(int i11);
}
