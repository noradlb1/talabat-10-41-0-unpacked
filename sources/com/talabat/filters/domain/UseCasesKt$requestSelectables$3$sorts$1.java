package com.talabat.filters.domain;

import com.talabat.talabatcommon.extentions.CoroutinesKt;
import datamodels.filters.SelectableSortType;
import datamodels.filters.SortType;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H@"}, d2 = {"", "Ldatamodels/filters/SelectableSortType;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.filters.domain.UseCasesKt$requestSelectables$3$sorts$1", f = "UseCases.kt", i = {}, l = {90, 90}, m = "invokeSuspend", n = {}, s = {})
public final class UseCasesKt$requestSelectables$3$sorts$1 extends SuspendLambda implements Function1<Continuation<? super List<? extends SelectableSortType>>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f59533h;

    /* renamed from: i  reason: collision with root package name */
    public int f59534i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function1<Continuation<? super List<SelectableSortType>>, Object> f59535j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Deferred<Integer> f59536k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UseCasesKt$requestSelectables$3$sorts$1(Function1<? super Continuation<? super List<SelectableSortType>>, ? extends Object> function1, Deferred<Integer> deferred, Continuation<? super UseCasesKt$requestSelectables$3$sorts$1> continuation) {
        super(1, continuation);
        this.f59535j = function1;
        this.f59536k = deferred;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new UseCasesKt$requestSelectables$3$sorts$1(this.f59535j, this.f59536k, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super List<SelectableSortType>> continuation) {
        return ((UseCasesKt$requestSelectables$3$sorts$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        List list;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59534i;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Function1<Continuation<? super List<SelectableSortType>>, Object> function1 = this.f59535j;
            this.f59534i = 1;
            obj = function1.invoke(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i11 == 2) {
            list = (List) this.f59533h;
            ResultKt.throwOnFailure(obj);
            return UseCasesKt.toSelectedSortTypes(list, ((Number) obj).intValue());
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        List list2 = (List) obj;
        Deferred<Integer> deferred = this.f59536k;
        Integer boxInt = Boxing.boxInt(SortType.RECOMMENDATION.getValue());
        this.f59533h = list2;
        this.f59534i = 2;
        Object await = CoroutinesKt.await(deferred, boxInt, this);
        if (await == coroutine_suspended) {
            return coroutine_suspended;
        }
        list = list2;
        obj = await;
        return UseCasesKt.toSelectedSortTypes(list, ((Number) obj).intValue());
    }
}
