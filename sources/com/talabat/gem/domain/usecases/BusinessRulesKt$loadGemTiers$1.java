package com.talabat.gem.domain.usecases;

import com.talabat.gem.domain.entities.GemOffer;
import com.talabat.gem.domain.entities.GemTier;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0004\u0018\u0001`\u00042\u0006\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"Lcom/talabat/gem/domain/entities/GemOffer;", "it", "", "Lcom/talabat/gem/domain/entities/GemTier;", "Lcom/talabat/gem/domain/entities/GemTiers;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.gem.domain.usecases.BusinessRulesKt$loadGemTiers$1", f = "BusinessRules.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class BusinessRulesKt$loadGemTiers$1 extends SuspendLambda implements Function2<GemOffer, Continuation<? super List<? extends GemTier>>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f60342h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f60343i;

    public BusinessRulesKt$loadGemTiers$1(Continuation<? super BusinessRulesKt$loadGemTiers$1> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        BusinessRulesKt$loadGemTiers$1 businessRulesKt$loadGemTiers$1 = new BusinessRulesKt$loadGemTiers$1(continuation);
        businessRulesKt$loadGemTiers$1.f60343i = obj;
        return businessRulesKt$loadGemTiers$1;
    }

    @Nullable
    public final Object invoke(@NotNull GemOffer gemOffer, @Nullable Continuation<? super List<GemTier>> continuation) {
        return ((BusinessRulesKt$loadGemTiers$1) create(gemOffer, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f60342h == 0) {
            ResultKt.throwOnFailure(obj);
            return ((GemOffer) this.f60343i).getTiers();
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
