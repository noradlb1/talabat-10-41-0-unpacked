package com.talabat.feature.tpro.presentation.benefits.viewmodel;

import com.talabat.core.navigation.domain.screen.restaurant.FoodListFlutterScreen;
import com.talabat.core.navigation.domain.screen.tpro.SubscriptionDetailsScreen;
import com.talabat.feature.subscriptions.domain.model.CountryParams;
import com.talabat.feature.subscriptions.domain.model.ProCentralization;
import com.talabat.feature.subscriptions.domain.wrapper.ProCentralizationStatusWrapper;
import com.talabat.helpers.GlobalDataModel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.feature.tpro.presentation.benefits.viewmodel.TproBenefitsViewModel$updateUserStatus$1", f = "TproBenefitsViewModel.kt", i = {}, l = {348}, m = "invokeSuspend", n = {}, s = {})
public final class TproBenefitsViewModel$updateUserStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f59280h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TproBenefitsViewModel f59281i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f59282j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TproBenefitsViewModel$updateUserStatus$1(TproBenefitsViewModel tproBenefitsViewModel, String str, Continuation<? super TproBenefitsViewModel$updateUserStatus$1> continuation) {
        super(2, continuation);
        this.f59281i = tproBenefitsViewModel;
        this.f59282j = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TproBenefitsViewModel$updateUserStatus$1 tproBenefitsViewModel$updateUserStatus$1 = new TproBenefitsViewModel$updateUserStatus$1(this.f59281i, this.f59282j, continuation);
        tproBenefitsViewModel$updateUserStatus$1.L$0 = obj;
        return tproBenefitsViewModel$updateUserStatus$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TproBenefitsViewModel$updateUserStatus$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        Object obj3;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59280h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            TproBenefitsViewModel tproBenefitsViewModel = this.f59281i;
            Result.Companion companion = Result.Companion;
            ProCentralizationStatusWrapper access$getGetProCentralizationStatusWrapper$p = tproBenefitsViewModel.getProCentralizationStatusWrapper;
            CountryParams countryParams = new CountryParams(tproBenefitsViewModel.configurationLocalRepository.selectedCountry());
            this.f59280h = 1;
            obj = access$getGetProCentralizationStatusWrapper$p.single(countryParams, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        obj2 = Result.m6329constructorimpl((ProCentralization) obj);
        String str = this.f59282j;
        TproBenefitsViewModel tproBenefitsViewModel2 = this.f59281i;
        if (Result.m6336isSuccessimpl(obj2)) {
            ProCentralization proCentralization = (ProCentralization) obj2;
            if (Intrinsics.areEqual((Object) str, (Object) "success_dismissed")) {
                obj3 = new SubscriptionDetailsScreen((Void) null, 1, (DefaultConstructorMarker) null);
            } else if (Intrinsics.areEqual((Object) str, (Object) "success_navigate")) {
                Double latitudeDouble = GlobalDataModel.LATLONGFORAPI.getLatitudeDouble();
                Intrinsics.checkNotNullExpressionValue(latitudeDouble, "getLatitudeDouble()");
                double doubleValue = latitudeDouble.doubleValue();
                Double longitudeDouble = GlobalDataModel.LATLONGFORAPI.getLongitudeDouble();
                Intrinsics.checkNotNullExpressionValue(longitudeDouble, "getLongitudeDouble()");
                double doubleValue2 = longitudeDouble.doubleValue();
                String valueOf = String.valueOf(GlobalDataModel.SelectedAreaId);
                String valueOf2 = String.valueOf(GlobalDataModel.SelectedCityId);
                int countryId = tproBenefitsViewModel2.configurationLocalRepository.selectedCountry().getCountryId();
                String str2 = GlobalDataModel.SelectedAreaName;
                Intrinsics.checkNotNullExpressionValue(str2, "SelectedAreaName");
                obj3 = new FoodListFlutterScreen(new FoodListFlutterScreen.FoodListFlutterData(doubleValue, doubleValue2, valueOf, valueOf2, countryId, str2));
            } else {
                obj3 = null;
            }
            tproBenefitsViewModel2.getPostUpdatingStatus().postValue(obj3);
        }
        TproBenefitsViewModel tproBenefitsViewModel3 = this.f59281i;
        if (Result.m6332exceptionOrNullimpl(obj2) != null) {
            tproBenefitsViewModel3.getPostUpdatingStatus().postValue(null);
        }
        return Unit.INSTANCE;
    }
}
