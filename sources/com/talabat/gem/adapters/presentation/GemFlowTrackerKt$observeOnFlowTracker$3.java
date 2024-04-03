package com.talabat.gem.adapters.presentation;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\"\u0010\u0002\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004 \u0005*\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "", "Lkotlin/reflect/KClass;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemFlowTrackerKt$observeOnFlowTracker$3 extends Lambda implements Function1<List<KClass<?>>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f59889g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemFlowTrackerKt$observeOnFlowTracker$3(Function0<Unit> function0) {
        super(1);
        this.f59889g = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<KClass<?>>) (List) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(List<KClass<?>> list) {
        Intrinsics.checkNotNullExpressionValue(list, "it");
        GemFlowTrackerKt.handleResetFlow(CollectionsKt___CollectionsKt.takeLast(list, 2), this.f59889g);
    }
}
