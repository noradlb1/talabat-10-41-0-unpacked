package com.talabat.darkstores.domain.naivgator;

import android.app.Activity;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.darkstores.domain.naivgator.DarkstoresNavigatorImpl$tryNavigateUsingDeeplink$1", f = "DarkstoresNavigatorImpl.kt", i = {0}, l = {114}, m = "invokeSuspend", n = {"deeplink"}, s = {"L$0"})
public final class DarkstoresNavigatorImpl$tryNavigateUsingDeeplink$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f56234h;

    /* renamed from: i  reason: collision with root package name */
    public int f56235i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ DarkstoresNavigatorImpl f56236j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f56237k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Integer f56238l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ String f56239m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ String f56240n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ String f56241o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ String f56242p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ Activity f56243q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f56244r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DarkstoresNavigatorImpl$tryNavigateUsingDeeplink$1(DarkstoresNavigatorImpl darkstoresNavigatorImpl, int i11, Integer num, String str, String str2, String str3, String str4, Activity activity, Function1<? super Boolean, Unit> function1, Continuation<? super DarkstoresNavigatorImpl$tryNavigateUsingDeeplink$1> continuation) {
        super(2, continuation);
        this.f56236j = darkstoresNavigatorImpl;
        this.f56237k = i11;
        this.f56238l = num;
        this.f56239m = str;
        this.f56240n = str2;
        this.f56241o = str3;
        this.f56242p = str4;
        this.f56243q = activity;
        this.f56244r = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DarkstoresNavigatorImpl$tryNavigateUsingDeeplink$1(this.f56236j, this.f56237k, this.f56238l, this.f56239m, this.f56240n, this.f56241o, this.f56242p, this.f56243q, this.f56244r, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DarkstoresNavigatorImpl$tryNavigateUsingDeeplink$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String str;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f56235i;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            String access$buildDeeplink = this.f56236j.buildDeeplink(this.f56237k, this.f56238l, this.f56239m, this.f56240n, this.f56241o, this.f56242p);
            DeepLinkNavigator access$getDeeplinkNavigator$p = this.f56236j.deeplinkNavigator;
            this.f56234h = access$buildDeeplink;
            this.f56235i = 1;
            Object canHandleDeepLink = access$getDeeplinkNavigator$p.canHandleDeepLink(access$buildDeeplink, this);
            if (canHandleDeepLink == coroutine_suspended) {
                return coroutine_suspended;
            }
            str = access$buildDeeplink;
            obj = canHandleDeepLink;
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
            str = (String) this.f56234h;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (((Boolean) obj).booleanValue()) {
            DeepLinkNavigator.DefaultImpls.navigateTo$default(this.f56236j.deeplinkNavigator, this.f56243q, str, (Function0) null, 4, (Object) null);
            this.f56244r.invoke(Boxing.boxBoolean(true));
        } else {
            this.f56244r.invoke(Boxing.boxBoolean(false));
        }
        return Unit.INSTANCE;
    }
}
