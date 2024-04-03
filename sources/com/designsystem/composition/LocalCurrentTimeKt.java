package com.designsystem.composition;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.SnapshotMutationPolicy;
import java.util.Calendar;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u001f\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"LocalCalendar", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", "getLocalCalendar", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class LocalCurrentTimeKt {
    @NotNull
    private static final ProvidableCompositionLocal<Calendar> LocalCalendar = CompositionLocalKt.compositionLocalOf$default((SnapshotMutationPolicy) null, LocalCurrentTimeKt$LocalCalendar$1.INSTANCE, 1, (Object) null);

    @NotNull
    public static final ProvidableCompositionLocal<Calendar> getLocalCalendar() {
        return LocalCalendar;
    }
}
