package com.talabat.components;

import android.content.Context;
import android.widget.Toast;
import com.talabat.talabatcommon.extentions.CoroutinesKt;
import com.talabat.talabatcore.logger.LogManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CuisinesLogger$displayErrorMessage$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Throwable f55682g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ CuisinesLogger f55683h;

    @Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.talabat.components.CuisinesLogger$displayErrorMessage$1$1", f = "Cuisines.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.talabat.components.CuisinesLogger$displayErrorMessage$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f55684h;

        @NotNull
        public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
            return new AnonymousClass1(cuisinesLogger, th2, continuation);
        }

        @Nullable
        public final Object invoke(@Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f55684h == 0) {
                ResultKt.throwOnFailure(obj);
                Context context = cuisinesLogger.getContext();
                String message = th2.getMessage();
                if (message == null) {
                    message = th2.toString();
                }
                Toast.makeText(context, message, 0).show();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CuisinesLogger$displayErrorMessage$1(Throwable th2, CuisinesLogger cuisinesLogger) {
        super(0);
        this.f55682g = th2;
        this.f55683h = cuisinesLogger;
    }

    public final void invoke() {
        LogManager.logException(this.f55682g);
        GlobalScope globalScope = GlobalScope.INSTANCE;
        MainCoroutineDispatcher main = Dispatchers.getMain();
        final CuisinesLogger cuisinesLogger = this.f55683h;
        final Throwable th2 = this.f55682g;
        CoroutinesKt.launchCatching$default(globalScope, (Function1) null, main, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 1, (Object) null);
    }
}
