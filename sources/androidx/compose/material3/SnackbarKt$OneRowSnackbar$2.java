package androidx.compose.material3;

import androidx.compose.material3.tokens.SnackbarTokens;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import j0.d;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SnackbarKt$OneRowSnackbar$2 implements MeasurePolicy {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f8264a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f8265b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f8266c;

    public SnackbarKt$OneRowSnackbar$2(String str, String str2, String str3) {
        this.f8264a = str;
        this.f8265b = str2;
        this.f8266c = str3;
    }

    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.a(this, intrinsicMeasureScope, list, i11);
    }

    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.b(this, intrinsicMeasureScope, list, i11);
    }

    @NotNull
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m1831measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j11) {
        Placeable placeable;
        Object obj;
        Placeable placeable2;
        Object obj2;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        boolean z11;
        boolean z12;
        int i16;
        int i17;
        int i18;
        int i19;
        int i21;
        int i22;
        int i23;
        MeasureScope measureScope2 = measureScope;
        List<? extends Measurable> list2 = list;
        long j12 = j11;
        Intrinsics.checkNotNullParameter(measureScope2, "$this$Layout");
        Intrinsics.checkNotNullParameter(list2, "measurables");
        int min = Math.min(Constraints.m5422getMaxWidthimpl(j11), measureScope2.m5441roundToPx0680j_4(SnackbarKt.ContainerMaxWidth));
        Iterable<Measurable> iterable = list2;
        String str = this.f8264a;
        Iterator it = iterable.iterator();
        while (true) {
            placeable = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj), (Object) str)) {
                break;
            }
        }
        Measurable measurable = (Measurable) obj;
        if (measurable != null) {
            placeable2 = measurable.m4508measureBRTryo0(j12);
        } else {
            placeable2 = null;
        }
        String str2 = this.f8265b;
        Iterator it2 = iterable.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it2.next();
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj2), (Object) str2)) {
                break;
            }
        }
        Measurable measurable2 = (Measurable) obj2;
        if (measurable2 != null) {
            placeable = measurable2.m4508measureBRTryo0(j12);
        }
        Placeable placeable3 = placeable;
        if (placeable2 != null) {
            i11 = placeable2.getWidth();
        } else {
            i11 = 0;
        }
        if (placeable2 != null) {
            i12 = placeable2.getHeight();
        } else {
            i12 = 0;
        }
        if (placeable3 != null) {
            i13 = placeable3.getWidth();
        } else {
            i13 = 0;
        }
        if (placeable3 != null) {
            i14 = placeable3.getHeight();
        } else {
            i14 = 0;
        }
        if (i13 == 0) {
            i15 = measureScope2.m5441roundToPx0680j_4(SnackbarKt.TextEndExtraSpacing);
        } else {
            i15 = 0;
        }
        int coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(((min - i11) - i13) - i15, Constraints.m5424getMinWidthimpl(j11));
        String str3 = this.f8266c;
        for (Measurable measurable3 : iterable) {
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable3), (Object) str3)) {
                int i24 = i14;
                Placeable r22 = measurable3.m4508measureBRTryo0(Constraints.m5413copyZbe2FdA$default(j11, 0, coerceAtLeast, 0, 0, 9, (Object) null));
                int i25 = r22.get(AlignmentLineKt.getFirstBaseline());
                boolean z13 = true;
                if (i25 != Integer.MIN_VALUE) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    int i26 = r22.get(AlignmentLineKt.getLastBaseline());
                    if (i26 != Integer.MIN_VALUE) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (z12) {
                        if (i25 != i26) {
                            z13 = false;
                        }
                        int i27 = min - i13;
                        int i28 = i27 - i11;
                        if (z13) {
                            int max = Math.max(measureScope2.m5441roundToPx0680j_4(SnackbarTokens.INSTANCE.m2429getSingleLineContainerHeightD9Ej5fM()), Math.max(i12, i24));
                            int height = (max - r22.getHeight()) / 2;
                            if (placeable2 == null || (i23 = placeable2.get(AlignmentLineKt.getFirstBaseline())) == Integer.MIN_VALUE) {
                                i22 = 0;
                            } else {
                                i22 = (i25 + height) - i23;
                            }
                            i16 = i22;
                            i17 = height;
                            i18 = max;
                        } else {
                            int r02 = measureScope2.m5441roundToPx0680j_4(SnackbarKt.HeightToFirstLine) - i25;
                            i18 = Math.max(measureScope2.m5441roundToPx0680j_4(SnackbarTokens.INSTANCE.m2430getTwoLinesContainerHeightD9Ej5fM()), r22.getHeight() + r02);
                            if (placeable2 != null) {
                                i21 = (i18 - placeable2.getHeight()) / 2;
                            } else {
                                i21 = 0;
                            }
                            i17 = r02;
                            i16 = i21;
                        }
                        if (placeable3 != null) {
                            i19 = (i18 - placeable3.getHeight()) / 2;
                        } else {
                            i19 = 0;
                        }
                        return MeasureScope.CC.p(measureScope, min, i18, (Map) null, new SnackbarKt$OneRowSnackbar$2$measure$4(r22, i17, placeable3, i27, i19, placeable2, i28, i16), 4, (Object) null);
                    }
                    throw new IllegalArgumentException("No baselines for text".toString());
                }
                throw new IllegalArgumentException("No baselines for text".toString());
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.c(this, intrinsicMeasureScope, list, i11);
    }

    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.d(this, intrinsicMeasureScope, list, i11);
    }
}
