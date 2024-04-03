package gateways;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0001J&\u0010\u0007\u001a\u0004\u0018\u00018\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u00022\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0002¢\u0006\u0002\u0010\u000bJ.\u0010\f\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\u00022\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\b\u0010\u000e\u001a\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0002\u0010\u000fR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"gateways/DataSourcesDelegateKt$preferences$1", "Lkotlin/properties/ReadWriteProperty;", "", "interceptors", "Lgateways/PreferencesInterceptors;", "getInterceptors", "()Lgateways/PreferencesInterceptors;", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "value", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DataSourcesDelegateKt$preferences$1 implements ReadWriteProperty<Object, T> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Object f14078a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ T f14079b;
    @NotNull
    private final PreferencesInterceptors<T> interceptors;

    public DataSourcesDelegateKt$preferences$1(Object obj, T t11, Function1<? super PreferencesInterceptors<T>, Unit> function1) {
        this.f14078a = obj;
        this.f14079b = t11;
        PreferencesInterceptors<T> preferencesInterceptors = new PreferencesInterceptors<>();
        if (function1 != null) {
            function1.invoke(preferencesInterceptors);
        }
        this.interceptors = preferencesInterceptors;
        preferencesInterceptors.getOnInitialized$com_talabat_talabatlib_talabatlib().invoke(Preferences.INSTANCE.load(obj.toString(), t11));
    }

    @NotNull
    public final PreferencesInterceptors<T> getInterceptors() {
        return this.interceptors;
    }

    @Nullable
    public T getValue(@Nullable Object obj, @NotNull KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(kProperty, "property");
        return this.interceptors.getOnLoaded$com_talabat_talabatlib_talabatlib().invoke(Preferences.INSTANCE.load(this.f14078a.toString(), this.f14079b));
    }

    public void setValue(@Nullable Object obj, @NotNull KProperty<?> kProperty, @Nullable T t11) {
        Intrinsics.checkNotNullParameter(kProperty, "property");
        Preferences.INSTANCE.save(this.f14078a.toString(), t11);
        this.interceptors.getOnSaved$com_talabat_talabatlib_talabatlib().invoke(t11);
    }
}
