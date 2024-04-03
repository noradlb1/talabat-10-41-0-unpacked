package gateways;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.Delegates;
import kotlin.properties.ReadOnlyProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\\\u0010\u0000\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\u0001\"\u0004\b\u0000\u0010\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u0001H\u00032!\b\u0002\u0010\u0007\u001a\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0002\b\u000b¢\u0006\u0002\u0010\f\u001aY\u0010\r\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u0002H\u00030\u000e\"\n\b\u0000\u0010\u000f\u0018\u0001*\u00020\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00112\u0019\b\b\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u00030\b¢\u0006\u0002\b\u000bH\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0013"}, d2 = {"preferences", "Lkotlin/properties/ReadWriteProperty;", "", "T", "Lkotlin/properties/Delegates;", "key", "defaultValue", "intercept", "Lkotlin/Function1;", "Lgateways/PreferencesInterceptors;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/properties/Delegates;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlin/properties/ReadWriteProperty;", "server", "Lkotlin/properties/ReadOnlyProperty;", "S", "retrofitApis", "Lkotlin/reflect/KClass;", "apiSelector", "com_talabat_talabatlib_talabatlib"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class DataSourcesDelegateKt {
    @NotNull
    public static final <T> ReadWriteProperty<Object, T> preferences(@NotNull Delegates delegates, @NotNull Object obj, @Nullable T t11, @Nullable Function1<? super PreferencesInterceptors<T>, Unit> function1) {
        Intrinsics.checkNotNullParameter(delegates, "<this>");
        Intrinsics.checkNotNullParameter(obj, "key");
        return new DataSourcesDelegateKt$preferences$1(obj, t11, function1);
    }

    public static /* synthetic */ ReadWriteProperty preferences$default(Delegates delegates, Object obj, Object obj2, Function1 function1, int i11, Object obj3) {
        if ((i11 & 2) != 0) {
            obj2 = null;
        }
        if ((i11 & 4) != 0) {
            function1 = null;
        }
        return preferences(delegates, obj, obj2, function1);
    }

    public static final /* synthetic */ <S, T> ReadOnlyProperty<Object, T> server(Delegates delegates, KClass<S> kClass, Function1<? super S, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(delegates, "<this>");
        Intrinsics.checkNotNullParameter(kClass, "retrofitApis");
        Intrinsics.checkNotNullParameter(function1, "apiSelector");
        return new DataSourcesDelegateKt$server$1(kClass, function1);
    }
}
