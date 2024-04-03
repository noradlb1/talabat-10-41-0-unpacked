package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "e", "invoke", "kotlinx/coroutines/internal/ExceptionsConstructorKt$safeCtor$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ExceptionsConstructorKt$createSafeConstructor$$inlined$safeCtor$4 extends Lambda implements Function1<Throwable, Throwable> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Constructor f26192g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExceptionsConstructorKt$createSafeConstructor$$inlined$safeCtor$4(Constructor constructor) {
        super(1);
        this.f26192g = constructor;
    }

    @Nullable
    public final Throwable invoke(@NotNull Throwable th2) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            Object newInstance = this.f26192g.newInstance(new Object[0]);
            if (newInstance != null) {
                Throwable th3 = (Throwable) newInstance;
                th3.initCause(th2);
                obj = Result.m6329constructorimpl(th3);
                if (Result.m6335isFailureimpl(obj)) {
                    obj = null;
                }
                return (Throwable) obj;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
        } catch (Throwable th4) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th4));
        }
    }
}
