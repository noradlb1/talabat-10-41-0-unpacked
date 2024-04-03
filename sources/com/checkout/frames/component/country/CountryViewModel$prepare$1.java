package com.checkout.frames.component.country;

import androidx.compose.runtime.MutableState;
import com.checkout.base.model.Country;
import com.checkout.frames.screen.billingaddress.billingaddressdetails.models.BillingAddress;
import com.checkout.frames.utils.extensions.CountryExtensionsKt;
import com.checkout.tokenization.model.Address;
import java.util.Locale;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.checkout.frames.component.country.CountryViewModel$prepare$1", f = "CountryViewModel.kt", i = {}, l = {35}, m = "invokeSuspend", n = {}, s = {})
public final class CountryViewModel$prepare$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Country, Unit> $onCountryUpdated;
    int label;
    final /* synthetic */ CountryViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CountryViewModel$prepare$1(CountryViewModel countryViewModel, Function1<? super Country, Unit> function1, Continuation<? super CountryViewModel$prepare$1> continuation) {
        super(2, continuation);
        this.this$0 = countryViewModel;
        this.$onCountryUpdated = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CountryViewModel$prepare$1(this.this$0, this.$onCountryUpdated, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((CountryViewModel$prepare$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            MutableStateFlow<BillingAddress> billingAddress = this.this$0.paymentStateManager.getBillingAddress();
            final CountryViewModel countryViewModel = this.this$0;
            final Function1<Country, Unit> function1 = this.$onCountryUpdated;
            AnonymousClass1 r12 = new FlowCollector<BillingAddress>() {
                @Nullable
                public final Object emit(@NotNull BillingAddress billingAddress, @NotNull Continuation<? super Unit> continuation) {
                    String iso3166Alpha2;
                    Address address = billingAddress.getAddress();
                    String str = null;
                    Country country = address != null ? address.getCountry() : null;
                    String displayCountry = (country == null || (iso3166Alpha2 = country.getIso3166Alpha2()) == null) ? null : new Locale(Locale.getDefault().getLanguage(), iso3166Alpha2).getDisplayCountry();
                    if (country != null) {
                        str = CountryExtensionsKt.emojiFlag(country);
                    }
                    MutableState<String> text = countryViewModel.getComponentState().getInputFieldState().getText();
                    text.setValue(str + "    " + displayCountry);
                    function1.invoke(country == null ? Country.INVALID_COUNTRY : country);
                    countryViewModel.maybeShowErrorMessage(country);
                    return Unit.INSTANCE;
                }
            };
            this.label = 1;
            if (billingAddress.collect(r12, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }
}
