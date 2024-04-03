package com.talabat.device_info_plugin;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class DeviceInfoPlugin$getGoogleAdvertisingId$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DeviceInfoPlugin f58295g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f58296h;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.talabat.device_info_plugin.DeviceInfoPlugin$getGoogleAdvertisingId$1$1", f = "DeviceInfoPlugin.kt", i = {}, l = {117}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.talabat.device_info_plugin.DeviceInfoPlugin$getGoogleAdvertisingId$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;

        /* renamed from: h  reason: collision with root package name */
        public int f58297h;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 r02 = new AnonymousClass1(deviceInfoPlugin, result, continuation);
            r02.L$0 = obj;
            return r02;
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            final Object obj2;
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f58297h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                DeviceInfoPlugin deviceInfoPlugin = deviceInfoPlugin;
                try {
                    Result.Companion companion = Result.Companion;
                    Context access$getApplicationContext$p = deviceInfoPlugin.applicationContext;
                    Intrinsics.checkNotNull(access$getApplicationContext$p);
                    obj2 = Result.m6329constructorimpl(AdvertisingIdClient.getAdvertisingIdInfo(access$getApplicationContext$p));
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.Companion;
                    obj2 = Result.m6329constructorimpl(ResultKt.createFailure(th2));
                }
                MainCoroutineDispatcher main = Dispatchers.getMain();
                final MethodChannel.Result result = result;
                AnonymousClass1 r32 = new Function2<CoroutineScope, Continuation<? super Unit>, Object>((Continuation<? super AnonymousClass1>) null) {

                    /* renamed from: h  reason: collision with root package name */
                    public int f58300h;

                    @NotNull
                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                        return 

                        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                        public DeviceInfoPlugin$getGoogleAdvertisingId$1(DeviceInfoPlugin deviceInfoPlugin, MethodChannel.Result result) {
                            super(0);
                            this.f58295g = deviceInfoPlugin;
                            this.f58296h = result;
                        }

                        public final void invoke() {
                            GlobalScope globalScope = GlobalScope.INSTANCE;
                            CoroutineDispatcher io2 = Dispatchers.getIO();
                            final DeviceInfoPlugin deviceInfoPlugin = this.f58295g;
                            final MethodChannel.Result result = this.f58296h;
                            Job unused = BuildersKt__Builders_commonKt.launch$default(globalScope, io2, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 2, (Object) null);
                        }
                    }
