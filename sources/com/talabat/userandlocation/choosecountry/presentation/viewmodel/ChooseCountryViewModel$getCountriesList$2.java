package com.talabat.userandlocation.choosecountry.presentation.viewmodel;

import com.talabat.userandlocation.choosecountry.domain.UseCases;
import com.talabat.userandlocation.choosecountry.presentation.displaymodel.CountryDisplayModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "Lcom/talabat/userandlocation/choosecountry/presentation/displaymodel/CountryDisplayModel;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.userandlocation.choosecountry.presentation.viewmodel.ChooseCountryViewModel$getCountriesList$2", f = "ChooseCountryViewModel.kt", i = {}, l = {50}, m = "invokeSuspend", n = {}, s = {})
public final class ChooseCountryViewModel$getCountriesList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends CountryDisplayModel>>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f12245h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ChooseCountryViewModel f12246i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChooseCountryViewModel$getCountriesList$2(ChooseCountryViewModel chooseCountryViewModel, Continuation<? super ChooseCountryViewModel$getCountriesList$2> continuation) {
        super(2, continuation);
        this.f12246i = chooseCountryViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ChooseCountryViewModel$getCountriesList$2(this.f12246i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super List<CountryDisplayModel>> continuation) {
        return ((ChooseCountryViewModel$getCountriesList$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f12245h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            UseCases access$getUseCases$p = this.f12246i.useCases;
            this.f12245h = 1;
            obj = access$getUseCases$p.getSupportedCountriesForUserToChoose(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Iterable<Object> iterable = (Iterable) obj;
        Function1 access$getDisplayModelMapper$p = this.f12246i.displayModelMapper;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (Object invoke : iterable) {
            arrayList.add(access$getDisplayModelMapper$p.invoke(invoke));
        }
        return arrayList;
    }
}
