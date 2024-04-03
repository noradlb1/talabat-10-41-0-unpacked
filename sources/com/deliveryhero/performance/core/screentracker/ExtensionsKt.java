package com.deliveryhero.performance.core.screentracker;

import java.lang.annotation.Annotation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"getTrackScreenPerformanceAnnotation", "Lcom/deliveryhero/performance/core/screentracker/TrackScreenPerformance;", "", "toTraceName", "", "core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ExtensionsKt {
    @Nullable
    public static final TrackScreenPerformance getTrackScreenPerformanceAnnotation(@NotNull Object obj) {
        TrackScreenPerformance trackScreenPerformance;
        Intrinsics.checkNotNullParameter(obj, "<this>");
        Annotation[] annotations = obj.getClass().getAnnotations();
        Intrinsics.checkNotNullExpressionValue(annotations, "this.javaClass.annotations");
        int length = annotations.length;
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                trackScreenPerformance = null;
                break;
            }
            trackScreenPerformance = annotations[i11];
            i11++;
            if (trackScreenPerformance instanceof TrackScreenPerformance) {
                break;
            }
        }
        return trackScreenPerformance;
    }

    @NotNull
    public static final String toTraceName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Intrinsics.stringPlus(str, "StartToInteractive");
    }
}
