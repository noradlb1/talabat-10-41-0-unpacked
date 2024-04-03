package gateways;

import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import service.ApiHandler;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00028\u00000\u0001J$\u0010\b\u001a\u00028\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u00022\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0002¢\u0006\u0002\u0010\fR\u001b\u0010\u0003\u001a\n \u0004*\u0004\u0018\u00018\u00018\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"gateways/DataSourcesDelegateKt$server$1", "Lkotlin/properties/ReadOnlyProperty;", "", "service", "kotlin.jvm.PlatformType", "getService", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 176)
public final class DataSourcesDelegateKt$server$1 implements ReadOnlyProperty<Object, T> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1<S, T> f14080a;

    /* renamed from: service  reason: collision with root package name */
    private final S f14081service;

    public DataSourcesDelegateKt$server$1(KClass<S> kClass, Function1<? super S, ? extends T> function1) {
        this.f14080a = function1;
        this.f14081service = ApiHandler.getInstance().getRetrofit().create(JvmClassMappingKt.getJavaClass(kClass));
    }

    public final S getService() {
        return this.f14081service;
    }

    public T getValue(@Nullable Object obj, @NotNull KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(kProperty, "property");
        Function1<S, T> function1 = this.f14080a;
        S s11 = this.f14081service;
        Intrinsics.checkNotNullExpressionValue(s11, "service");
        return function1.invoke(s11);
    }
}
