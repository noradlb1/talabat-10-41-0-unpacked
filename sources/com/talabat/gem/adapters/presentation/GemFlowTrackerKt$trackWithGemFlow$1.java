package com.talabat.gem.adapters.presentation;

import com.talabat.talabatcommon.extentions.RxKt;
import com.talabat.talabatcommon.lifecycle.ContextLifecycleEvents;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/talabat/talabatcommon/lifecycle/ContextLifecycleEvents;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemFlowTrackerKt$trackWithGemFlow$1 extends Lambda implements Function1<ContextLifecycleEvents, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Object f59890g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemFlowTrackerKt$trackWithGemFlow$1(Object obj) {
        super(1);
        this.f59890g = obj;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ContextLifecycleEvents) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ContextLifecycleEvents contextLifecycleEvents) {
        Intrinsics.checkNotNullParameter(contextLifecycleEvents, "$this$null");
        ContextLifecycleEvents on2 = contextLifecycleEvents.getOn();
        final Object obj = this.f59890g;
        on2.resume(new Function0<Unit>() {
            public final void invoke() {
                BehaviorSubject access$getGemFlowTracker = GemFlowTrackerKt.getGemFlowTracker();
                Intrinsics.checkNotNullExpressionValue(access$getGemFlowTracker, "gemFlowTracker");
                BehaviorSubject access$getGemFlowTracker2 = GemFlowTrackerKt.getGemFlowTracker();
                Intrinsics.checkNotNullExpressionValue(access$getGemFlowTracker2, "gemFlowTracker");
                Object obj = RxKt.get(access$getGemFlowTracker2, new ArrayList());
                List list = (List) obj;
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(obj.getClass());
                Intrinsics.checkNotNullExpressionValue(list, "it");
                if (!GemFlowTrackerKt.isDuplicateViewHolderEntry$default(list, orCreateKotlinClass, (List) null, 2, (Object) null)) {
                    list.add(orCreateKotlinClass);
                }
                RxKt.plusAssign(access$getGemFlowTracker, obj);
            }
        });
    }
}
