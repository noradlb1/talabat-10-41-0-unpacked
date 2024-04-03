package org.koin.java;

import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.koin.core.Koin;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JC\u0010\u0003\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\u0004\u0018\u0001`\fH\u0007¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0007JE\u0010\u0010\u001a\u0004\u0018\u0001H\u0004\"\u0004\b\u0000\u0010\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\u0004\u0018\u0001`\fH\u0007¢\u0006\u0002\u0010\rJD\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0012\"\u0004\b\u0000\u0010\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\u0004\u0018\u0001`\fH\u0007JF\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00040\u0012\"\u0004\b\u0000\u0010\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\u0004\u0018\u0001`\fH\u0007¨\u0006\u0014"}, d2 = {"Lorg/koin/java/KoinJavaComponent;", "", "()V", "get", "T", "clazz", "Ljava/lang/Class;", "qualifier", "Lorg/koin/core/qualifier/Qualifier;", "parameters", "Lkotlin/Function0;", "Lorg/koin/core/parameter/ParametersHolder;", "Lorg/koin/core/parameter/ParametersDefinition;", "(Ljava/lang/Class;Lorg/koin/core/qualifier/Qualifier;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getKoin", "Lorg/koin/core/Koin;", "getOrNull", "inject", "Lkotlin/Lazy;", "injectOrNull", "koin-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class KoinJavaComponent {
    @NotNull
    public static final KoinJavaComponent INSTANCE = new KoinJavaComponent();

    private KoinJavaComponent() {
    }

    @JvmStatic
    @JvmOverloads
    public static final <T> T get(@NotNull Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        return get$default(cls, (Qualifier) null, (Function0) null, 6, (Object) null);
    }

    @JvmStatic
    @JvmOverloads
    public static final <T> T get(@NotNull Class<?> cls, @Nullable Qualifier qualifier) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        return get$default(cls, qualifier, (Function0) null, 4, (Object) null);
    }

    @JvmStatic
    @JvmOverloads
    public static final <T> T get(@NotNull Class<?> cls, @Nullable Qualifier qualifier, @Nullable Function0<? extends ParametersHolder> function0) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        return getKoin().get(JvmClassMappingKt.getKotlinClass(cls), qualifier, function0);
    }

    public static /* synthetic */ Object get$default(Class cls, Qualifier qualifier, Function0 function0, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            qualifier = null;
        }
        if ((i11 & 4) != 0) {
            function0 = null;
        }
        return get(cls, qualifier, function0);
    }

    @JvmStatic
    @NotNull
    public static final Koin getKoin() {
        return KoinPlatformTools.INSTANCE.defaultContext().get();
    }

    @Nullable
    @JvmStatic
    @JvmOverloads
    public static final <T> T getOrNull(@NotNull Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        return getOrNull$default(cls, (Qualifier) null, (Function0) null, 6, (Object) null);
    }

    @Nullable
    @JvmStatic
    @JvmOverloads
    public static final <T> T getOrNull(@NotNull Class<?> cls, @Nullable Qualifier qualifier) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        return getOrNull$default(cls, qualifier, (Function0) null, 4, (Object) null);
    }

    @Nullable
    @JvmStatic
    @JvmOverloads
    public static final <T> T getOrNull(@NotNull Class<?> cls, @Nullable Qualifier qualifier, @Nullable Function0<? extends ParametersHolder> function0) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        return getKoin().getOrNull(JvmClassMappingKt.getKotlinClass(cls), qualifier, function0);
    }

    public static /* synthetic */ Object getOrNull$default(Class cls, Qualifier qualifier, Function0 function0, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            qualifier = null;
        }
        if ((i11 & 4) != 0) {
            function0 = null;
        }
        return getOrNull(cls, qualifier, function0);
    }

    @JvmStatic
    @NotNull
    @JvmOverloads
    public static final <T> Lazy<T> inject(@NotNull Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        return inject$default(cls, (Qualifier) null, (Function0) null, 6, (Object) null);
    }

    @JvmStatic
    @NotNull
    @JvmOverloads
    public static final <T> Lazy<T> inject(@NotNull Class<?> cls, @Nullable Qualifier qualifier) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        return inject$default(cls, qualifier, (Function0) null, 4, (Object) null);
    }

    @JvmStatic
    @NotNull
    @JvmOverloads
    public static final <T> Lazy<T> inject(@NotNull Class<?> cls, @Nullable Qualifier qualifier, @Nullable Function0<? extends ParametersHolder> function0) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        return LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new KoinJavaComponent$inject$1(cls, qualifier, function0));
    }

    public static /* synthetic */ Lazy inject$default(Class cls, Qualifier qualifier, Function0 function0, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            qualifier = null;
        }
        if ((i11 & 4) != 0) {
            function0 = null;
        }
        return inject(cls, qualifier, function0);
    }

    @JvmStatic
    @NotNull
    @JvmOverloads
    public static final <T> Lazy<T> injectOrNull(@NotNull Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        return injectOrNull$default(cls, (Qualifier) null, (Function0) null, 6, (Object) null);
    }

    @JvmStatic
    @NotNull
    @JvmOverloads
    public static final <T> Lazy<T> injectOrNull(@NotNull Class<?> cls, @Nullable Qualifier qualifier) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        return injectOrNull$default(cls, qualifier, (Function0) null, 4, (Object) null);
    }

    @JvmStatic
    @NotNull
    @JvmOverloads
    public static final <T> Lazy<T> injectOrNull(@NotNull Class<?> cls, @Nullable Qualifier qualifier, @Nullable Function0<? extends ParametersHolder> function0) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        return LazyKt__LazyJVMKt.lazy(new KoinJavaComponent$injectOrNull$1(cls, qualifier, function0));
    }

    public static /* synthetic */ Lazy injectOrNull$default(Class cls, Qualifier qualifier, Function0 function0, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            qualifier = null;
        }
        if ((i11 & 4) != 0) {
            function0 = null;
        }
        return injectOrNull(cls, qualifier, function0);
    }
}
