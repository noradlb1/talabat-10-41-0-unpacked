package com.talabat.gem.adapters.presentation;

import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a$\u0012 \u0012\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003 \u0004*\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lio/reactivex/subjects/BehaviorSubject;", "", "Lkotlin/reflect/KClass;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemFlowTrackerKt$gemFlowTracker$2 extends Lambda implements Function0<BehaviorSubject<List<KClass<?>>>> {
    public static final GemFlowTrackerKt$gemFlowTracker$2 INSTANCE = new GemFlowTrackerKt$gemFlowTracker$2();

    public GemFlowTrackerKt$gemFlowTracker$2() {
        super(0);
    }

    @NotNull
    public final BehaviorSubject<List<KClass<?>>> invoke() {
        return BehaviorSubject.createDefault(new ArrayList());
    }
}
