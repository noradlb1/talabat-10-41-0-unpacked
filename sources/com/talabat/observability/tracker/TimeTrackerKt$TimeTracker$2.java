package com.talabat.observability.tracker;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/observability/tracker/TimeTrackerImplementation;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TimeTrackerKt$TimeTracker$2 extends Lambda implements Function0<TimeTrackerImplementation> {
    public static final TimeTrackerKt$TimeTracker$2 INSTANCE = new TimeTrackerKt$TimeTracker$2();

    public TimeTrackerKt$TimeTracker$2() {
        super(0);
    }

    @NotNull
    public final TimeTrackerImplementation invoke() {
        return new TimeTrackerImplementation((HashMap) null, (Function2) null, 3, (DefaultConstructorMarker) null);
    }
}
