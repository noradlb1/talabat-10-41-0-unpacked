package com.talabat.feature.tmart.growth.presentation.widget;

import com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimDisplayModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H@"}, d2 = {"Lcom/talabat/feature/tmart/growth/domain/claim/TMartGrowthClaimDisplayModel;", "previous", "new", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.feature.tmart.growth.presentation.widget.TMartGrowthWidgetViewModel$trackEvents$1", f = "TMartGrowthWidgetViewModel.kt", i = {}, l = {78}, m = "invokeSuspend", n = {}, s = {})
public final class TMartGrowthWidgetViewModel$trackEvents$1 extends SuspendLambda implements Function3<TMartGrowthClaimDisplayModel, TMartGrowthClaimDisplayModel, Continuation<? super TMartGrowthClaimDisplayModel>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f59222h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f59223i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f59224j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ TMartGrowthWidgetViewModel f59225k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TMartGrowthWidgetViewModel$trackEvents$1(TMartGrowthWidgetViewModel tMartGrowthWidgetViewModel, Continuation<? super TMartGrowthWidgetViewModel$trackEvents$1> continuation) {
        super(3, continuation);
        this.f59225k = tMartGrowthWidgetViewModel;
    }

    @Nullable
    public final Object invoke(@NotNull TMartGrowthClaimDisplayModel tMartGrowthClaimDisplayModel, @NotNull TMartGrowthClaimDisplayModel tMartGrowthClaimDisplayModel2, @Nullable Continuation<? super TMartGrowthClaimDisplayModel> continuation) {
        TMartGrowthWidgetViewModel$trackEvents$1 tMartGrowthWidgetViewModel$trackEvents$1 = new TMartGrowthWidgetViewModel$trackEvents$1(this.f59225k, continuation);
        tMartGrowthWidgetViewModel$trackEvents$1.f59223i = tMartGrowthClaimDisplayModel;
        tMartGrowthWidgetViewModel$trackEvents$1.f59224j = tMartGrowthClaimDisplayModel2;
        return tMartGrowthWidgetViewModel$trackEvents$1.invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        TMartGrowthClaimDisplayModel tMartGrowthClaimDisplayModel;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59222h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            TMartGrowthClaimDisplayModel tMartGrowthClaimDisplayModel2 = (TMartGrowthClaimDisplayModel) this.f59224j;
            TMartGrowthWidgetViewModel tMartGrowthWidgetViewModel = this.f59225k;
            if (!tMartGrowthWidgetViewModel.shouldTrackEvent((TMartGrowthClaimDisplayModel) this.f59223i, tMartGrowthClaimDisplayModel2)) {
                return tMartGrowthClaimDisplayModel2;
            }
            this.f59223i = tMartGrowthClaimDisplayModel2;
            this.f59222h = 1;
            if (tMartGrowthWidgetViewModel.trackWidgetLoaded(tMartGrowthClaimDisplayModel2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            tMartGrowthClaimDisplayModel = tMartGrowthClaimDisplayModel2;
        } else if (i11 == 1) {
            tMartGrowthClaimDisplayModel = (TMartGrowthClaimDisplayModel) this.f59223i;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return tMartGrowthClaimDisplayModel;
    }
}
