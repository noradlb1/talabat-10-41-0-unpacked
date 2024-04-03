package kotlin.reflect.jvm.internal;

import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0003 \u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "kotlin.jvm.PlatformType", "R", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class KCallableImpl$_returnType$1 extends Lambda implements Function0<KTypeImpl> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ KCallableImpl<R> f24362g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KCallableImpl$_returnType$1(KCallableImpl<? extends R> kCallableImpl) {
        super(0);
        this.f24362g = kCallableImpl;
    }

    public final KTypeImpl invoke() {
        KotlinType returnType = this.f24362g.getDescriptor().getReturnType();
        Intrinsics.checkNotNull(returnType);
        final KCallableImpl<R> kCallableImpl = this.f24362g;
        return new KTypeImpl(returnType, new Function0<Type>() {
            @NotNull
            public final Type invoke() {
                Type access$extractContinuationArgument = kCallableImpl.extractContinuationArgument();
                return access$extractContinuationArgument == null ? kCallableImpl.getCaller().getReturnType() : access$extractContinuationArgument;
            }
        });
    }
}
