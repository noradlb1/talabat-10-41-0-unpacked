package com.designsystem.ds_input_field;

import android.content.Context;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.text.input.VisualTransformation;
import com.designsystem.ds_input_field.country.CountryUtils;
import com.designsystem.ds_input_field.country.DSCountryModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.designsystem.ds_input_field.PhoneFieldComposablesKt$PhoneNumberInputField$1", f = "PhoneFieldComposables.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class PhoneFieldComposablesKt$PhoneNumberInputField$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f31785h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Context f31786i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f31787j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ MutableState<List<DSCountryModel>> f31788k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ MutableState<VisualTransformation> f31789l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ MutableState<DSCountryModel> f31790m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhoneFieldComposablesKt$PhoneNumberInputField$1(Context context, String str, MutableState<List<DSCountryModel>> mutableState, MutableState<VisualTransformation> mutableState2, MutableState<DSCountryModel> mutableState3, Continuation<? super PhoneFieldComposablesKt$PhoneNumberInputField$1> continuation) {
        super(2, continuation);
        this.f31786i = context;
        this.f31787j = str;
        this.f31788k = mutableState;
        this.f31789l = mutableState2;
        this.f31790m = mutableState3;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PhoneFieldComposablesKt$PhoneNumberInputField$1(this.f31786i, this.f31787j, this.f31788k, this.f31789l, this.f31790m, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((PhoneFieldComposablesKt$PhoneNumberInputField$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f31785h == 0) {
            ResultKt.throwOnFailure(obj);
            PhoneFieldComposablesKt.m8452PhoneNumberInputField_4_mkn5s$lambda2(this.f31788k, CountryUtils.Companion.readCountryList(this.f31786i));
            MutableState<DSCountryModel> mutableState = this.f31790m;
            DSCountryModel access$getDefaultCountry = PhoneFieldComposablesKt.getDefaultCountry(PhoneFieldComposablesKt.m8449PhoneNumberInputField_4_mkn5s$lambda1(this.f31788k), this.f31787j);
            if (access$getDefaultCountry == null) {
                access$getDefaultCountry = null;
            } else {
                PhoneFieldComposablesKt.m8451PhoneNumberInputField_4_mkn5s$lambda11(this.f31789l, new PhoneNumberFormatter(access$getDefaultCountry.getCode(), access$getDefaultCountry.getPrefix()));
                Unit unit = Unit.INSTANCE;
            }
            PhoneFieldComposablesKt.m8456PhoneNumberInputField_4_mkn5s$lambda8(mutableState, access$getDefaultCountry);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
