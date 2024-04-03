package org.koin.mp;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.koin.core.context.GlobalContext;
import org.koin.core.context.KoinContext;
import org.koin.core.instance.InstanceFactory;
import org.koin.core.logger.Level;
import org.koin.core.logger.Logger;
import org.koin.core.logger.PrintLogger;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\fJ\u0012\u0010\r\u001a\u00020\f2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000fJ\u0012\u0010\u0010\u001a\u00020\f2\n\u0010\u0011\u001a\u00060\u0012j\u0002`\u0013J\u001e\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u00170\u0015\"\u0004\b\u0000\u0010\u0016\"\u0004\b\u0001\u0010\u0017J'\u0010\u0018\u001a\u0002H\u0019\"\u0004\b\u0000\u0010\u00192\u0006\u0010\u001a\u001a\u00020\u00012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00190\u001c¢\u0006\u0002\u0010\u001d¨\u0006\u001e"}, d2 = {"Lorg/koin/mp/KoinPlatformTools;", "", "()V", "defaultContext", "Lorg/koin/core/context/KoinContext;", "defaultLazyMode", "Lkotlin/LazyThreadSafetyMode;", "defaultLogger", "Lorg/koin/core/logger/Logger;", "level", "Lorg/koin/core/logger/Level;", "generateId", "", "getClassName", "kClass", "Lkotlin/reflect/KClass;", "getStackTrace", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "safeHashMap", "", "K", "V", "synchronized", "R", "lock", "block", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "koin-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class KoinPlatformTools {
    @NotNull
    public static final KoinPlatformTools INSTANCE = new KoinPlatformTools();

    private KoinPlatformTools() {
    }

    public static /* synthetic */ Logger defaultLogger$default(KoinPlatformTools koinPlatformTools, Level level, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            level = Level.INFO;
        }
        return koinPlatformTools.defaultLogger(level);
    }

    @NotNull
    public final KoinContext defaultContext() {
        return GlobalContext.INSTANCE;
    }

    @NotNull
    public final LazyThreadSafetyMode defaultLazyMode() {
        return LazyThreadSafetyMode.SYNCHRONIZED;
    }

    @NotNull
    public final Logger defaultLogger(@NotNull Level level) {
        Intrinsics.checkNotNullParameter(level, "level");
        return new PrintLogger(level);
    }

    @NotNull
    public final String generateId() {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        return uuid;
    }

    @NotNull
    public final String getClassName(@NotNull KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        String name2 = JvmClassMappingKt.getJavaClass(kClass).getName();
        Intrinsics.checkNotNullExpressionValue(name2, "kClass.java.name");
        return name2;
    }

    @NotNull
    public final String getStackTrace(@NotNull Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "e");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(exc);
        sb2.append(InstanceFactory.ERROR_SEPARATOR);
        StackTraceElement[] stackTrace = exc.getStackTrace();
        Intrinsics.checkNotNullExpressionValue(stackTrace, "e.stackTrace");
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            Intrinsics.checkNotNullExpressionValue(className, "it.className");
            if (!(!StringsKt__StringsKt.contains$default((CharSequence) className, (CharSequence) "sun.reflect", false, 2, (Object) null))) {
                break;
            }
            arrayList.add(stackTraceElement);
        }
        sb2.append(CollectionsKt___CollectionsKt.joinToString$default(arrayList, InstanceFactory.ERROR_SEPARATOR, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        return sb2.toString();
    }

    @NotNull
    public final <K, V> Map<K, V> safeHashMap() {
        return new ConcurrentHashMap();
    }

    /* renamed from: synchronized  reason: not valid java name */
    public final <R> R m10944synchronized(@NotNull Object obj, @NotNull Function0<? extends R> function0) {
        R invoke;
        Intrinsics.checkNotNullParameter(obj, "lock");
        Intrinsics.checkNotNullParameter(function0, "block");
        synchronized (obj) {
            invoke = function0.invoke();
        }
        return invoke;
    }
}
