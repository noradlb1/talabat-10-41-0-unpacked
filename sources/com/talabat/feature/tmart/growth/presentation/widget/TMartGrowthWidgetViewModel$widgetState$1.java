package com.talabat.feature.tmart.growth.presentation.widget;

import com.talabat.feature.tmart.growth.domain.ITMartGrowthReminderRepository;
import com.talabat.feature.tmart.growth.domain.dto.TMartGrowthReminderData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthReminderData;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.feature.tmart.growth.presentation.widget.TMartGrowthWidgetViewModel$widgetState$1", f = "TMartGrowthWidgetViewModel.kt", i = {}, l = {57, 57}, m = "invokeSuspend", n = {}, s = {})
public final class TMartGrowthWidgetViewModel$widgetState$1 extends SuspendLambda implements Function2<FlowCollector<? super TMartGrowthReminderData>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f59226h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ITMartGrowthReminderRepository f59227i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ TMartGrowthWidgetViewModel f59228j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TMartGrowthWidgetViewModel$widgetState$1(ITMartGrowthReminderRepository iTMartGrowthReminderRepository, TMartGrowthWidgetViewModel tMartGrowthWidgetViewModel, Continuation<? super TMartGrowthWidgetViewModel$widgetState$1> continuation) {
        super(2, continuation);
        this.f59227i = iTMartGrowthReminderRepository;
        this.f59228j = tMartGrowthWidgetViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TMartGrowthWidgetViewModel$widgetState$1 tMartGrowthWidgetViewModel$widgetState$1 = new TMartGrowthWidgetViewModel$widgetState$1(this.f59227i, this.f59228j, continuation);
        tMartGrowthWidgetViewModel$widgetState$1.L$0 = obj;
        return tMartGrowthWidgetViewModel$widgetState$1;
    }

    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super TMartGrowthReminderData> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        return ((TMartGrowthWidgetViewModel$widgetState$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: kotlinx.coroutines.flow.FlowCollector} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.f59226h
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0022
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0049
        L_0x0012:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x001a:
            java.lang.Object r1 = r5.L$0
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x003d
        L_0x0022:
            kotlin.ResultKt.throwOnFailure(r6)
            java.lang.Object r6 = r5.L$0
            r1 = r6
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            com.talabat.feature.tmart.growth.domain.ITMartGrowthReminderRepository r6 = r5.f59227i
            com.talabat.feature.tmart.growth.presentation.widget.TMartGrowthWidgetViewModel r4 = r5.f59228j
            com.talabat.feature.tmart.growth.domain.TMartGrowthScreenType r4 = r4.screenType
            r5.L$0 = r1
            r5.f59226h = r3
            java.lang.Object r6 = r6.getVoucherReminder(r4, r5)
            if (r6 != r0) goto L_0x003d
            return r0
        L_0x003d:
            r3 = 0
            r5.L$0 = r3
            r5.f59226h = r2
            java.lang.Object r6 = r1.emit(r6, r5)
            if (r6 != r0) goto L_0x0049
            return r0
        L_0x0049:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tmart.growth.presentation.widget.TMartGrowthWidgetViewModel$widgetState$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
