package com.talabat.card_tokenization;

import com.talabat.card_tokenization.datasource.CheckoutTokenizationDataSource;
import com.talabat.card_tokenization.request.RemoteTokenizationRequest;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.HashMap;
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
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.talabat.card_tokenization.CardTokenizationPlugin$onMethodCall$1", f = "CardTokenizationPlugin.kt", i = {}, l = {105}, m = "invokeSuspend", n = {}, s = {})
public final class CardTokenizationPlugin$onMethodCall$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f55529h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ MethodCall f55530i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f55531j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ CardTokenizationPlugin f55532k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CardTokenizationPlugin$onMethodCall$1(MethodCall methodCall, MethodChannel.Result result, CardTokenizationPlugin cardTokenizationPlugin, Continuation<? super CardTokenizationPlugin$onMethodCall$1> continuation) {
        super(2, continuation);
        this.f55530i = methodCall;
        this.f55531j = result;
        this.f55532k = cardTokenizationPlugin;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CardTokenizationPlugin$onMethodCall$1(this.f55530i, this.f55531j, this.f55532k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((CardTokenizationPlugin$onMethodCall$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String str;
        HashMap hashMap;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f55529h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Object obj2 = this.f55530i.arguments;
            if (obj2 instanceof HashMap) {
                hashMap = (HashMap) obj2;
            } else {
                hashMap = null;
            }
            if (hashMap == null) {
                this.f55531j.error(CardTokenizationPlugin.ERROR_CODE_INVALID_ARGUMENT, "Expected a HashMap", (Object) null);
                return Unit.INSTANCE;
            }
            ArrayList arrayList = new ArrayList();
            Object obj3 = hashMap.get(CardTokenizationPlugin.ARG_NUMBER_KEY);
            if (obj3 instanceof String) {
                str2 = (String) obj3;
            } else {
                str2 = null;
            }
            if (str2 == null) {
                arrayList.add(CardTokenizationPlugin.ARG_NUMBER_KEY);
            }
            Object obj4 = hashMap.get(CardTokenizationPlugin.ARG_CVV_KEY);
            if (obj4 instanceof String) {
                str3 = (String) obj4;
            } else {
                str3 = null;
            }
            if (str3 == null) {
                arrayList.add(CardTokenizationPlugin.ARG_CVV_KEY);
            }
            Object obj5 = hashMap.get(CardTokenizationPlugin.ARG_EXPIRY_MONTH_KEY);
            if (obj5 instanceof String) {
                str4 = (String) obj5;
            } else {
                str4 = null;
            }
            if (str4 == null) {
                arrayList.add(CardTokenizationPlugin.ARG_EXPIRY_MONTH_KEY);
            }
            Object obj6 = hashMap.get(CardTokenizationPlugin.ARG_EXPIRY_YEAR_KEY);
            if (obj6 instanceof String) {
                str5 = (String) obj6;
            } else {
                str5 = null;
            }
            if (str5 == null) {
                arrayList.add(CardTokenizationPlugin.ARG_EXPIRY_YEAR_KEY);
            }
            Object obj7 = hashMap.get("holderName");
            if (obj7 instanceof String) {
                str6 = (String) obj7;
            } else {
                str6 = null;
            }
            if (str6 == null) {
                arrayList.add("holderName");
            }
            Object obj8 = hashMap.get("publicKey");
            if (obj8 instanceof String) {
                str7 = (String) obj8;
            } else {
                str7 = null;
            }
            if (str7 == null) {
                arrayList.add("publicKey");
            }
            Object obj9 = hashMap.get(CardTokenizationPlugin.ARG_ENV_KEY);
            if (obj9 instanceof String) {
                str8 = (String) obj9;
            } else {
                str8 = null;
            }
            if (str8 == null) {
                arrayList.add(CardTokenizationPlugin.ARG_ENV_KEY);
            }
            if (!arrayList.isEmpty()) {
                this.f55531j.error(CardTokenizationPlugin.ERROR_CODE_INVALID_ARGUMENT, "Issues found: " + CollectionsKt___CollectionsKt.joinToString$default(arrayList, IndicativeSentencesGeneration.DEFAULT_SEPARATOR, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) + " are missing", (Object) null);
                return Unit.INSTANCE;
            }
            if (str2 == null) {
                str9 = "";
            } else {
                str9 = str2;
            }
            if (str6 == null) {
                str10 = "";
            } else {
                str10 = str6;
            }
            if (str4 == null) {
                str4 = "";
            }
            if (str5 == null) {
                str5 = "";
            }
            if (str3 == null) {
                str11 = "";
            } else {
                str11 = str3;
            }
            if (str7 == null) {
                str7 = "";
            }
            if (str8 == null) {
                str8 = "";
            }
            RemoteTokenizationRequest remoteTokenizationRequest = new RemoteTokenizationRequest(str9, str10, str4, str5, str11, str7, str8);
            CheckoutTokenizationDataSource checkoutTokenizationDataSource = this.f55532k.getCheckoutTokenizationDataSource();
            if (checkoutTokenizationDataSource != null) {
                this.f55529h = 1;
                obj = checkoutTokenizationDataSource.generateToken(remoteTokenizationRequest, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                str = null;
                this.f55531j.success(str);
                return Unit.INSTANCE;
            }
        } else if (i11 == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception e11) {
                this.f55531j.error(CardTokenizationPlugin.ERROR_CODE_TOKENIZATION_FAILED, e11.getMessage(), (Object) null);
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        str = (String) obj;
        this.f55531j.success(str);
        return Unit.INSTANCE;
    }
}
