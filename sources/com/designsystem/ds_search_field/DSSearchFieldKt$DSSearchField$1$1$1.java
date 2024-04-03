package com.designsystem.ds_search_field;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.designsystem.ds_search_field.DSSearchFieldKt$DSSearchField$1$1$1", f = "DSSearchField.kt", i = {0}, l = {90}, m = "invokeSuspend", n = {"it"}, s = {"L$2"})
public final class DSSearchFieldKt$DSSearchField$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f32573h;

    /* renamed from: i  reason: collision with root package name */
    public Object f32574i;

    /* renamed from: j  reason: collision with root package name */
    public Object f32575j;

    /* renamed from: k  reason: collision with root package name */
    public int f32576k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ MutableState<String> f32577l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f32578m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ long f32579n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f32580o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ MutableState<Long> f32581p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSSearchFieldKt$DSSearchField$1$1$1(MutableState<String> mutableState, int i11, long j11, Function1<? super String, Unit> function1, MutableState<Long> mutableState2, Continuation<? super DSSearchFieldKt$DSSearchField$1$1$1> continuation) {
        super(2, continuation);
        this.f32577l = mutableState;
        this.f32578m = i11;
        this.f32579n = j11;
        this.f32580o = function1;
        this.f32581p = mutableState2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DSSearchFieldKt$DSSearchField$1$1$1(this.f32577l, this.f32578m, this.f32579n, this.f32580o, this.f32581p, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DSSearchFieldKt$DSSearchField$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String str;
        MutableState<Long> mutableState;
        Function1<String, Unit> function1;
        Function1<String, Unit> function12;
        MutableState<Long> mutableState2;
        String str2;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f32576k;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            str = DSSearchFieldKt.m8555DSSearchField$lambda4(this.f32577l);
            if (str != null) {
                int i12 = this.f32578m;
                long j11 = this.f32579n;
                function1 = this.f32580o;
                mutableState = this.f32581p;
                if (str.length() >= i12) {
                    long currentTimeMillis = j11 - (System.currentTimeMillis() - DSSearchFieldKt.m8557DSSearchField$lambda7(mutableState));
                    if (currentTimeMillis > 0) {
                        this.f32573h = function1;
                        this.f32574i = mutableState;
                        this.f32575j = str;
                        this.f32576k = 1;
                        if (DelayKt.delay(currentTimeMillis, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        str2 = str;
                        function12 = function1;
                        mutableState2 = mutableState;
                    }
                    function1.invoke(str);
                    DSSearchFieldKt.m8558DSSearchField$lambda8(mutableState, System.currentTimeMillis());
                }
            }
            return Unit.INSTANCE;
        } else if (i11 == 1) {
            str2 = (String) this.f32575j;
            mutableState2 = (MutableState) this.f32574i;
            function12 = (Function1) this.f32573h;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        str = str2;
        mutableState = mutableState2;
        function1 = function12;
        function1.invoke(str);
        DSSearchFieldKt.m8558DSSearchField$lambda8(mutableState, System.currentTimeMillis());
        return Unit.INSTANCE;
    }
}
