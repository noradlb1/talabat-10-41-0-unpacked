package org.mockito.kotlin;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.kotlin.internal.CreateInstanceKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u001a\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\b¢\u0006\u0002\u0010\u0003\u001a\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0005\"\u0006\b\u0000\u0010\u0001\u0018\u0001H\b¢\u0006\u0002\u0010\u0006\u001a\u001a\u0010\u0007\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\b¢\u0006\u0002\u0010\u0003\u001a\u001a\u0010\b\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\b¢\u0006\u0002\u0010\u0003\u001a5\u0010\t\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\u0019\b\b\u0010\n\u001a\u0013\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\b\rH\b¢\u0006\u0002\u0010\u000e\u001a5\u0010\u000f\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\u0019\b\b\u0010\n\u001a\u0013\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\b\rH\b¢\u0006\u0002\u0010\u000e\u001a(\u0010\u000f\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0011H\b¢\u0006\u0002\u0010\u0012\u001a0\u0010\u0013\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\u0014\b\b\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\f0\u000bH\b¢\u0006\u0002\u0010\u000e\u001a\u0019\u0010\u0014\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0015\u001a\u0002H\u0001¢\u0006\u0002\u0010\u0016\u001a\u001a\u0010\u0017\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\b¢\u0006\u0002\u0010\u0003\u001a\u0017\u0010\u0018\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002¢\u0006\u0002\u0010\u0003\u001a\u0017\u0010\u0019\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002¢\u0006\u0002\u0010\u0003\u001a\u0017\u0010\u001a\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002¢\u0006\u0002\u0010\u0003\u001a6\u0010\u001b\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\u0006\u0010\u0015\u001a\u0002H\u00012\u0012\u0010\u001c\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001d0\u0005\"\u00020\u001dH\b¢\u0006\u0002\u0010\u001e\u001a\u0019\u0010\u001f\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0015\u001a\u0002H\u0001¢\u0006\u0002\u0010\u0016¨\u0006 "}, d2 = {"any", "T", "", "()Ljava/lang/Object;", "anyArray", "", "()[Ljava/lang/Object;", "anyOrNull", "anyVararg", "argForWhich", "predicate", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "argThat", "matcher", "Lorg/mockito/ArgumentMatcher;", "(Lorg/mockito/ArgumentMatcher;)Ljava/lang/Object;", "argWhere", "eq", "value", "(Ljava/lang/Object;)Ljava/lang/Object;", "isA", "isNotNull", "isNull", "notNull", "refEq", "excludeFields", "", "(Ljava/lang/Object;[Ljava/lang/String;)Ljava/lang/Object;", "same", "mockito-kotlin"}, k = 2, mv = {1, 1, 15})
public final class MatchersKt {
    @NotNull
    public static final /* synthetic */ <T> T any() {
        Intrinsics.reifiedOperationMarker(4, "T");
        Class<Object> cls = Object.class;
        T any = ArgumentMatchers.any(cls);
        if (any != null) {
            return any;
        }
        Intrinsics.reifiedOperationMarker(4, "T");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(cls);
        if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            T t11 = Boolean.FALSE;
            Intrinsics.reifiedOperationMarker(1, "T");
            return t11;
        } else if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Byte.TYPE))) {
            T valueOf = Byte.valueOf((byte) 0);
            Intrinsics.reifiedOperationMarker(1, "T");
            return valueOf;
        } else if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Character.TYPE))) {
            T valueOf2 = Character.valueOf((char) 0);
            Intrinsics.reifiedOperationMarker(1, "T");
            return valueOf2;
        } else if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Short.TYPE))) {
            T valueOf3 = Short.valueOf((short) 0);
            Intrinsics.reifiedOperationMarker(1, "T");
            return valueOf3;
        } else if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
            Intrinsics.reifiedOperationMarker(1, "T");
            return 0;
        } else if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            Intrinsics.reifiedOperationMarker(1, "T");
            return 0L;
        } else if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Float.TYPE))) {
            T valueOf4 = Float.valueOf(0.0f);
            Intrinsics.reifiedOperationMarker(1, "T");
            return valueOf4;
        } else if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            T valueOf5 = Double.valueOf(0.0d);
            Intrinsics.reifiedOperationMarker(1, "T");
            return valueOf5;
        } else {
            Intrinsics.reifiedOperationMarker(4, "T");
            return CreateInstanceKt.createInstance(Reflection.getOrCreateKotlinClass(cls));
        }
    }

    @NotNull
    public static final /* synthetic */ <T> T[] anyArray() {
        T[] tArr = (Object[]) ArgumentMatchers.any(Object[].class);
        if (tArr != null) {
            return tArr;
        }
        Intrinsics.reifiedOperationMarker(0, "T");
        return new Object[0];
    }

    @NotNull
    public static final /* synthetic */ <T> T anyOrNull() {
        T any = ArgumentMatchers.any();
        if (any != null) {
            return any;
        }
        Intrinsics.reifiedOperationMarker(4, "T");
        Class<Object> cls = Object.class;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(cls);
        if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            T t11 = Boolean.FALSE;
            Intrinsics.reifiedOperationMarker(1, "T");
            return t11;
        } else if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Byte.TYPE))) {
            T valueOf = Byte.valueOf((byte) 0);
            Intrinsics.reifiedOperationMarker(1, "T");
            return valueOf;
        } else if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Character.TYPE))) {
            T valueOf2 = Character.valueOf((char) 0);
            Intrinsics.reifiedOperationMarker(1, "T");
            return valueOf2;
        } else if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Short.TYPE))) {
            T valueOf3 = Short.valueOf((short) 0);
            Intrinsics.reifiedOperationMarker(1, "T");
            return valueOf3;
        } else if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
            Intrinsics.reifiedOperationMarker(1, "T");
            return 0;
        } else if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            Intrinsics.reifiedOperationMarker(1, "T");
            return 0L;
        } else if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Float.TYPE))) {
            T valueOf4 = Float.valueOf(0.0f);
            Intrinsics.reifiedOperationMarker(1, "T");
            return valueOf4;
        } else if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            T valueOf5 = Double.valueOf(0.0d);
            Intrinsics.reifiedOperationMarker(1, "T");
            return valueOf5;
        } else {
            Intrinsics.reifiedOperationMarker(4, "T");
            return CreateInstanceKt.createInstance(Reflection.getOrCreateKotlinClass(cls));
        }
    }

    @NotNull
    public static final /* synthetic */ <T> T anyVararg() {
        T any = ArgumentMatchers.any();
        if (any != null) {
            return any;
        }
        Intrinsics.reifiedOperationMarker(4, "T");
        Class<Object> cls = Object.class;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(cls);
        if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            T t11 = Boolean.FALSE;
            Intrinsics.reifiedOperationMarker(1, "T");
            return t11;
        } else if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Byte.TYPE))) {
            T valueOf = Byte.valueOf((byte) 0);
            Intrinsics.reifiedOperationMarker(1, "T");
            return valueOf;
        } else if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Character.TYPE))) {
            T valueOf2 = Character.valueOf((char) 0);
            Intrinsics.reifiedOperationMarker(1, "T");
            return valueOf2;
        } else if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Short.TYPE))) {
            T valueOf3 = Short.valueOf((short) 0);
            Intrinsics.reifiedOperationMarker(1, "T");
            return valueOf3;
        } else if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
            Intrinsics.reifiedOperationMarker(1, "T");
            return 0;
        } else if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            Intrinsics.reifiedOperationMarker(1, "T");
            return 0L;
        } else if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Float.TYPE))) {
            T valueOf4 = Float.valueOf(0.0f);
            Intrinsics.reifiedOperationMarker(1, "T");
            return valueOf4;
        } else if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            T valueOf5 = Double.valueOf(0.0d);
            Intrinsics.reifiedOperationMarker(1, "T");
            return valueOf5;
        } else {
            Intrinsics.reifiedOperationMarker(4, "T");
            return CreateInstanceKt.createInstance(Reflection.getOrCreateKotlinClass(cls));
        }
    }

    @NotNull
    public static final /* synthetic */ <T> T argForWhich(@NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        T argThat = ArgumentMatchers.argThat(new MatchersKt$argThat$1(function1));
        if (argThat != null) {
            return argThat;
        }
        Intrinsics.reifiedOperationMarker(4, "T");
        return CreateInstanceKt.createInstance(Reflection.getOrCreateKotlinClass(Object.class));
    }

    @NotNull
    public static final /* synthetic */ <T> T argThat(@NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        T argThat = ArgumentMatchers.argThat(new MatchersKt$argThat$1(function1));
        if (argThat != null) {
            return argThat;
        }
        Intrinsics.reifiedOperationMarker(4, "T");
        return CreateInstanceKt.createInstance(Reflection.getOrCreateKotlinClass(Object.class));
    }

    @NotNull
    public static final /* synthetic */ <T> T argWhere(@NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        T argThat = ArgumentMatchers.argThat(new MatchersKt$argThat$1(function1));
        if (argThat != null) {
            return argThat;
        }
        Intrinsics.reifiedOperationMarker(4, "T");
        return CreateInstanceKt.createInstance(Reflection.getOrCreateKotlinClass(Object.class));
    }

    public static final <T> T eq(T t11) {
        T eq2 = ArgumentMatchers.eq(t11);
        return eq2 != null ? eq2 : t11;
    }

    @NotNull
    public static final /* synthetic */ <T> T isA() {
        Intrinsics.reifiedOperationMarker(4, "T");
        Class<Object> cls = Object.class;
        T isA = ArgumentMatchers.isA(cls);
        if (isA != null) {
            return isA;
        }
        Intrinsics.reifiedOperationMarker(4, "T");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(cls);
        if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            T t11 = Boolean.FALSE;
            Intrinsics.reifiedOperationMarker(1, "T");
            return t11;
        } else if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Byte.TYPE))) {
            T valueOf = Byte.valueOf((byte) 0);
            Intrinsics.reifiedOperationMarker(1, "T");
            return valueOf;
        } else if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Character.TYPE))) {
            T valueOf2 = Character.valueOf((char) 0);
            Intrinsics.reifiedOperationMarker(1, "T");
            return valueOf2;
        } else if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Short.TYPE))) {
            T valueOf3 = Short.valueOf((short) 0);
            Intrinsics.reifiedOperationMarker(1, "T");
            return valueOf3;
        } else if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
            Intrinsics.reifiedOperationMarker(1, "T");
            return 0;
        } else if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            Intrinsics.reifiedOperationMarker(1, "T");
            return 0L;
        } else if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Float.TYPE))) {
            T valueOf4 = Float.valueOf(0.0f);
            Intrinsics.reifiedOperationMarker(1, "T");
            return valueOf4;
        } else if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            T valueOf5 = Double.valueOf(0.0d);
            Intrinsics.reifiedOperationMarker(1, "T");
            return valueOf5;
        } else {
            Intrinsics.reifiedOperationMarker(4, "T");
            return CreateInstanceKt.createInstance(Reflection.getOrCreateKotlinClass(cls));
        }
    }

    @Nullable
    public static final <T> T isNotNull() {
        return ArgumentMatchers.isNotNull();
    }

    @Nullable
    public static final <T> T isNull() {
        return ArgumentMatchers.isNull();
    }

    @Nullable
    public static final <T> T notNull() {
        return ArgumentMatchers.notNull();
    }

    @NotNull
    public static final /* synthetic */ <T> T refEq(@NotNull T t11, @NotNull String... strArr) {
        Intrinsics.checkParameterIsNotNull(t11, "value");
        Intrinsics.checkParameterIsNotNull(strArr, "excludeFields");
        T refEq = ArgumentMatchers.refEq(t11, (String[]) Arrays.copyOf(strArr, strArr.length));
        if (refEq != null) {
            return refEq;
        }
        Intrinsics.reifiedOperationMarker(4, "T");
        Class<Object> cls = Object.class;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(cls);
        if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            T t12 = Boolean.FALSE;
            Intrinsics.reifiedOperationMarker(1, "T");
            return t12;
        } else if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Byte.TYPE))) {
            T valueOf = Byte.valueOf((byte) 0);
            Intrinsics.reifiedOperationMarker(1, "T");
            return valueOf;
        } else if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Character.TYPE))) {
            T valueOf2 = Character.valueOf((char) 0);
            Intrinsics.reifiedOperationMarker(1, "T");
            return valueOf2;
        } else if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Short.TYPE))) {
            T valueOf3 = Short.valueOf((short) 0);
            Intrinsics.reifiedOperationMarker(1, "T");
            return valueOf3;
        } else if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
            Intrinsics.reifiedOperationMarker(1, "T");
            return 0;
        } else if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            Intrinsics.reifiedOperationMarker(1, "T");
            return 0L;
        } else if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Float.TYPE))) {
            T valueOf4 = Float.valueOf(0.0f);
            Intrinsics.reifiedOperationMarker(1, "T");
            return valueOf4;
        } else if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            T valueOf5 = Double.valueOf(0.0d);
            Intrinsics.reifiedOperationMarker(1, "T");
            return valueOf5;
        } else {
            Intrinsics.reifiedOperationMarker(4, "T");
            return CreateInstanceKt.createInstance(Reflection.getOrCreateKotlinClass(cls));
        }
    }

    public static final <T> T same(T t11) {
        T same = ArgumentMatchers.same(t11);
        return same != null ? same : t11;
    }

    @NotNull
    public static final /* synthetic */ <T> T argThat(@NotNull ArgumentMatcher<T> argumentMatcher) {
        Intrinsics.checkParameterIsNotNull(argumentMatcher, "matcher");
        T argThat = ArgumentMatchers.argThat(argumentMatcher);
        if (argThat != null) {
            return argThat;
        }
        Intrinsics.reifiedOperationMarker(4, "T");
        Class<Object> cls = Object.class;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(cls);
        if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            T t11 = Boolean.FALSE;
            Intrinsics.reifiedOperationMarker(1, "T");
            return t11;
        } else if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Byte.TYPE))) {
            T valueOf = Byte.valueOf((byte) 0);
            Intrinsics.reifiedOperationMarker(1, "T");
            return valueOf;
        } else if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Character.TYPE))) {
            T valueOf2 = Character.valueOf((char) 0);
            Intrinsics.reifiedOperationMarker(1, "T");
            return valueOf2;
        } else if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Short.TYPE))) {
            T valueOf3 = Short.valueOf((short) 0);
            Intrinsics.reifiedOperationMarker(1, "T");
            return valueOf3;
        } else if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
            Intrinsics.reifiedOperationMarker(1, "T");
            return 0;
        } else if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            Intrinsics.reifiedOperationMarker(1, "T");
            return 0L;
        } else if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Float.TYPE))) {
            T valueOf4 = Float.valueOf(0.0f);
            Intrinsics.reifiedOperationMarker(1, "T");
            return valueOf4;
        } else if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            T valueOf5 = Double.valueOf(0.0d);
            Intrinsics.reifiedOperationMarker(1, "T");
            return valueOf5;
        } else {
            Intrinsics.reifiedOperationMarker(4, "T");
            return CreateInstanceKt.createInstance(Reflection.getOrCreateKotlinClass(cls));
        }
    }
}
