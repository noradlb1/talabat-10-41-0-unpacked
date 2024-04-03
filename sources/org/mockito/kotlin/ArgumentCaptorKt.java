package org.mockito.kotlin;

import androidx.exifinterface.media.ExifInterface;
import com.apptimize.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.mockito.ArgumentCaptor;
import org.mockito.kotlin.internal.CreateInstanceKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001b\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00010\f\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\rH\b\u001aY\u0010\u000b\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\f0\u000e\"\n\b\u0000\u0010\u000f\u0018\u0001*\u00020\r\"\n\b\u0001\u0010\u0010\u0018\u0001*\u00020\r2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00122\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0012H\b\u001a\u0001\u0010\u000b\u001a&\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00150\f0\u0014\"\n\b\u0000\u0010\u000f\u0018\u0001*\u00020\r\"\n\b\u0001\u0010\u0010\u0018\u0001*\u00020\r\"\n\b\u0002\u0010\u0015\u0018\u0001*\u00020\r2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00122\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00100\u00122\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0012H\b\u001a©\u0001\u0010\u000b\u001a2\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00150\f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180\f0\u0017\"\n\b\u0000\u0010\u000f\u0018\u0001*\u00020\r\"\n\b\u0001\u0010\u0010\u0018\u0001*\u00020\r\"\n\b\u0002\u0010\u0015\u0018\u0001*\u00020\r\"\n\b\u0003\u0010\u0018\u0018\u0001*\u00020\r2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00122\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00100\u00122\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u00122\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u0012H\b\u001aÑ\u0001\u0010\u000b\u001a>\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00150\f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180\f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001b0\f0\u001a\"\n\b\u0000\u0010\u000f\u0018\u0001*\u00020\r\"\n\b\u0001\u0010\u0010\u0018\u0001*\u00020\r\"\n\b\u0002\u0010\u0015\u0018\u0001*\u00020\r\"\n\b\u0003\u0010\u0018\u0018\u0001*\u00020\r\"\n\b\u0004\u0010\u001b\u0018\u0001*\u00020\r2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00122\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00100\u00122\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u00122\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u00122\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u0012H\b\u001a:\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00010\f\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\r2\u001d\u0010\u001d\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\f\u0012\u0004\u0012\u00020\u001f0\u001e¢\u0006\u0002\b H\b\u001a(\u0010!\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\r2\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0002H\b¢\u0006\u0002\u0010\u0004\u001a\u001d\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\f\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\rH\b\u001a>\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\f\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\r2\u001f\u0010\u001d\u001a\u001b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\f\u0012\u0004\u0012\u00020\u001f0\u001e¢\u0006\u0002\b H\b\"!\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"!\u0010\u0005\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00028F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004\"!\u0010\u0007\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00028F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004\"!\u0010\t\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00028F¢\u0006\u0006\u001a\u0004\b\n\u0010\u0004¨\u0006$"}, d2 = {"firstValue", "T", "Lorg/mockito/ArgumentCaptor;", "getFirstValue", "(Lorg/mockito/ArgumentCaptor;)Ljava/lang/Object;", "lastValue", "getLastValue", "secondValue", "getSecondValue", "thirdValue", "getThirdValue", "argumentCaptor", "Lorg/mockito/kotlin/KArgumentCaptor;", "", "Lkotlin/Pair;", "A", "B", "a", "Lkotlin/reflect/KClass;", "b", "Lkotlin/Triple;", "C", "c", "Lorg/mockito/kotlin/ArgumentCaptorHolder4;", "D", "d", "Lorg/mockito/kotlin/ArgumentCaptorHolder5;", "E", "e", "f", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "capture", "captor", "nullableArgumentCaptor", "mockito-kotlin"}, k = 2, mv = {1, 1, 15})
public final class ArgumentCaptorKt {
    @NotNull
    public static final /* synthetic */ <T> KArgumentCaptor<T> argumentCaptor() {
        Intrinsics.reifiedOperationMarker(4, "T");
        Class<Object> cls = Object.class;
        ArgumentCaptor<U> forClass = ArgumentCaptor.forClass(cls);
        Intrinsics.checkExpressionValueIsNotNull(forClass, "ArgumentCaptor.forClass(T::class.java)");
        Intrinsics.reifiedOperationMarker(4, "T");
        return new KArgumentCaptor<>(forClass, Reflection.getOrCreateKotlinClass(cls));
    }

    public static /* synthetic */ Pair argumentCaptor$default(KClass kClass, KClass kClass2, int i11, Object obj) {
        Class<Object> cls = Object.class;
        if ((i11 & 1) != 0) {
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS);
            kClass = Reflection.getOrCreateKotlinClass(cls);
        }
        if ((i11 & 2) != 0) {
            Intrinsics.reifiedOperationMarker(4, "B");
            kClass2 = Reflection.getOrCreateKotlinClass(cls);
        }
        Intrinsics.checkParameterIsNotNull(kClass, "a");
        Intrinsics.checkParameterIsNotNull(kClass2, "b");
        ArgumentCaptor forClass = ArgumentCaptor.forClass(JvmClassMappingKt.getJavaClass(kClass));
        Intrinsics.checkExpressionValueIsNotNull(forClass, "ArgumentCaptor.forClass(a.java)");
        KArgumentCaptor kArgumentCaptor = new KArgumentCaptor(forClass, kClass);
        ArgumentCaptor forClass2 = ArgumentCaptor.forClass(JvmClassMappingKt.getJavaClass(kClass2));
        Intrinsics.checkExpressionValueIsNotNull(forClass2, "ArgumentCaptor.forClass(b.java)");
        return new Pair(kArgumentCaptor, new KArgumentCaptor(forClass2, kClass2));
    }

    @NotNull
    public static final /* synthetic */ <T> T capture(@NotNull ArgumentCaptor<T> argumentCaptor) {
        Intrinsics.checkParameterIsNotNull(argumentCaptor, "captor");
        T capture = argumentCaptor.capture();
        if (capture != null) {
            return capture;
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

    public static final <T> T getFirstValue(@NotNull ArgumentCaptor<T> argumentCaptor) {
        Intrinsics.checkParameterIsNotNull(argumentCaptor, "$this$firstValue");
        return argumentCaptor.getAllValues().get(0);
    }

    public static final <T> T getLastValue(@NotNull ArgumentCaptor<T> argumentCaptor) {
        Intrinsics.checkParameterIsNotNull(argumentCaptor, "$this$lastValue");
        List<T> allValues = argumentCaptor.getAllValues();
        Intrinsics.checkExpressionValueIsNotNull(allValues, "allValues");
        return CollectionsKt___CollectionsKt.last(allValues);
    }

    public static final <T> T getSecondValue(@NotNull ArgumentCaptor<T> argumentCaptor) {
        Intrinsics.checkParameterIsNotNull(argumentCaptor, "$this$secondValue");
        return argumentCaptor.getAllValues().get(1);
    }

    public static final <T> T getThirdValue(@NotNull ArgumentCaptor<T> argumentCaptor) {
        Intrinsics.checkParameterIsNotNull(argumentCaptor, "$this$thirdValue");
        return argumentCaptor.getAllValues().get(2);
    }

    @NotNull
    public static final /* synthetic */ <T> KArgumentCaptor<T> nullableArgumentCaptor() {
        Intrinsics.reifiedOperationMarker(4, "T");
        Class<Object> cls = Object.class;
        ArgumentCaptor<U> forClass = ArgumentCaptor.forClass(cls);
        Intrinsics.checkExpressionValueIsNotNull(forClass, "ArgumentCaptor.forClass(T::class.java)");
        Intrinsics.reifiedOperationMarker(4, "T");
        return new KArgumentCaptor<>(forClass, Reflection.getOrCreateKotlinClass(cls));
    }

    @NotNull
    public static final /* synthetic */ <A, B> Pair<KArgumentCaptor<A>, KArgumentCaptor<B>> argumentCaptor(@NotNull KClass<A> kClass, @NotNull KClass<B> kClass2) {
        Intrinsics.checkParameterIsNotNull(kClass, "a");
        Intrinsics.checkParameterIsNotNull(kClass2, "b");
        ArgumentCaptor<U> forClass = ArgumentCaptor.forClass(JvmClassMappingKt.getJavaClass(kClass));
        Intrinsics.checkExpressionValueIsNotNull(forClass, "ArgumentCaptor.forClass(a.java)");
        KArgumentCaptor kArgumentCaptor = new KArgumentCaptor(forClass, kClass);
        ArgumentCaptor<U> forClass2 = ArgumentCaptor.forClass(JvmClassMappingKt.getJavaClass(kClass2));
        Intrinsics.checkExpressionValueIsNotNull(forClass2, "ArgumentCaptor.forClass(b.java)");
        return new Pair<>(kArgumentCaptor, new KArgumentCaptor(forClass2, kClass2));
    }

    @NotNull
    public static final /* synthetic */ <T> KArgumentCaptor<T> nullableArgumentCaptor(@NotNull Function1<? super KArgumentCaptor<? extends T>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "f");
        Intrinsics.reifiedOperationMarker(4, "T");
        Class<Object> cls = Object.class;
        ArgumentCaptor<U> forClass = ArgumentCaptor.forClass(cls);
        Intrinsics.checkExpressionValueIsNotNull(forClass, "ArgumentCaptor.forClass(T::class.java)");
        Intrinsics.reifiedOperationMarker(4, "T");
        KArgumentCaptor<T> kArgumentCaptor = new KArgumentCaptor<>(forClass, Reflection.getOrCreateKotlinClass(cls));
        function1.invoke(kArgumentCaptor);
        return kArgumentCaptor;
    }

    @NotNull
    public static final /* synthetic */ <A, B, C> Triple<KArgumentCaptor<A>, KArgumentCaptor<B>, KArgumentCaptor<C>> argumentCaptor(@NotNull KClass<A> kClass, @NotNull KClass<B> kClass2, @NotNull KClass<C> kClass3) {
        Intrinsics.checkParameterIsNotNull(kClass, "a");
        Intrinsics.checkParameterIsNotNull(kClass2, "b");
        Intrinsics.checkParameterIsNotNull(kClass3, c.f41585a);
        ArgumentCaptor<U> forClass = ArgumentCaptor.forClass(JvmClassMappingKt.getJavaClass(kClass));
        Intrinsics.checkExpressionValueIsNotNull(forClass, "ArgumentCaptor.forClass(a.java)");
        KArgumentCaptor kArgumentCaptor = new KArgumentCaptor(forClass, kClass);
        ArgumentCaptor<U> forClass2 = ArgumentCaptor.forClass(JvmClassMappingKt.getJavaClass(kClass2));
        Intrinsics.checkExpressionValueIsNotNull(forClass2, "ArgumentCaptor.forClass(b.java)");
        KArgumentCaptor kArgumentCaptor2 = new KArgumentCaptor(forClass2, kClass2);
        ArgumentCaptor<U> forClass3 = ArgumentCaptor.forClass(JvmClassMappingKt.getJavaClass(kClass3));
        Intrinsics.checkExpressionValueIsNotNull(forClass3, "ArgumentCaptor.forClass(c.java)");
        return new Triple<>(kArgumentCaptor, kArgumentCaptor2, new KArgumentCaptor(forClass3, kClass3));
    }

    public static /* synthetic */ Triple argumentCaptor$default(KClass kClass, KClass kClass2, KClass kClass3, int i11, Object obj) {
        Class<Object> cls = Object.class;
        if ((i11 & 1) != 0) {
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS);
            kClass = Reflection.getOrCreateKotlinClass(cls);
        }
        if ((i11 & 2) != 0) {
            Intrinsics.reifiedOperationMarker(4, "B");
            kClass2 = Reflection.getOrCreateKotlinClass(cls);
        }
        if ((i11 & 4) != 0) {
            Intrinsics.reifiedOperationMarker(4, "C");
            kClass3 = Reflection.getOrCreateKotlinClass(cls);
        }
        Intrinsics.checkParameterIsNotNull(kClass, "a");
        Intrinsics.checkParameterIsNotNull(kClass2, "b");
        Intrinsics.checkParameterIsNotNull(kClass3, c.f41585a);
        ArgumentCaptor forClass = ArgumentCaptor.forClass(JvmClassMappingKt.getJavaClass(kClass));
        Intrinsics.checkExpressionValueIsNotNull(forClass, "ArgumentCaptor.forClass(a.java)");
        KArgumentCaptor kArgumentCaptor = new KArgumentCaptor(forClass, kClass);
        ArgumentCaptor forClass2 = ArgumentCaptor.forClass(JvmClassMappingKt.getJavaClass(kClass2));
        Intrinsics.checkExpressionValueIsNotNull(forClass2, "ArgumentCaptor.forClass(b.java)");
        KArgumentCaptor kArgumentCaptor2 = new KArgumentCaptor(forClass2, kClass2);
        ArgumentCaptor forClass3 = ArgumentCaptor.forClass(JvmClassMappingKt.getJavaClass(kClass3));
        Intrinsics.checkExpressionValueIsNotNull(forClass3, "ArgumentCaptor.forClass(c.java)");
        return new Triple(kArgumentCaptor, kArgumentCaptor2, new KArgumentCaptor(forClass3, kClass3));
    }

    @NotNull
    public static final /* synthetic */ <A, B, C, D> ArgumentCaptorHolder4<KArgumentCaptor<A>, KArgumentCaptor<B>, KArgumentCaptor<C>, KArgumentCaptor<D>> argumentCaptor(@NotNull KClass<A> kClass, @NotNull KClass<B> kClass2, @NotNull KClass<C> kClass3, @NotNull KClass<D> kClass4) {
        Intrinsics.checkParameterIsNotNull(kClass, "a");
        Intrinsics.checkParameterIsNotNull(kClass2, "b");
        Intrinsics.checkParameterIsNotNull(kClass3, c.f41585a);
        Intrinsics.checkParameterIsNotNull(kClass4, "d");
        ArgumentCaptor<U> forClass = ArgumentCaptor.forClass(JvmClassMappingKt.getJavaClass(kClass));
        Intrinsics.checkExpressionValueIsNotNull(forClass, "ArgumentCaptor.forClass(a.java)");
        KArgumentCaptor kArgumentCaptor = new KArgumentCaptor(forClass, kClass);
        ArgumentCaptor<U> forClass2 = ArgumentCaptor.forClass(JvmClassMappingKt.getJavaClass(kClass2));
        Intrinsics.checkExpressionValueIsNotNull(forClass2, "ArgumentCaptor.forClass(b.java)");
        KArgumentCaptor kArgumentCaptor2 = new KArgumentCaptor(forClass2, kClass2);
        ArgumentCaptor<U> forClass3 = ArgumentCaptor.forClass(JvmClassMappingKt.getJavaClass(kClass3));
        Intrinsics.checkExpressionValueIsNotNull(forClass3, "ArgumentCaptor.forClass(c.java)");
        KArgumentCaptor kArgumentCaptor3 = new KArgumentCaptor(forClass3, kClass3);
        ArgumentCaptor<U> forClass4 = ArgumentCaptor.forClass(JvmClassMappingKt.getJavaClass(kClass4));
        Intrinsics.checkExpressionValueIsNotNull(forClass4, "ArgumentCaptor.forClass(d.java)");
        return new ArgumentCaptorHolder4<>(kArgumentCaptor, kArgumentCaptor2, kArgumentCaptor3, new KArgumentCaptor(forClass4, kClass4));
    }

    public static /* synthetic */ ArgumentCaptorHolder4 argumentCaptor$default(KClass kClass, KClass kClass2, KClass kClass3, KClass kClass4, int i11, Object obj) {
        Class<Object> cls = Object.class;
        if ((i11 & 1) != 0) {
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS);
            kClass = Reflection.getOrCreateKotlinClass(cls);
        }
        if ((i11 & 2) != 0) {
            Intrinsics.reifiedOperationMarker(4, "B");
            kClass2 = Reflection.getOrCreateKotlinClass(cls);
        }
        if ((i11 & 4) != 0) {
            Intrinsics.reifiedOperationMarker(4, "C");
            kClass3 = Reflection.getOrCreateKotlinClass(cls);
        }
        if ((i11 & 8) != 0) {
            Intrinsics.reifiedOperationMarker(4, "D");
            kClass4 = Reflection.getOrCreateKotlinClass(cls);
        }
        Intrinsics.checkParameterIsNotNull(kClass, "a");
        Intrinsics.checkParameterIsNotNull(kClass2, "b");
        Intrinsics.checkParameterIsNotNull(kClass3, c.f41585a);
        Intrinsics.checkParameterIsNotNull(kClass4, "d");
        ArgumentCaptor forClass = ArgumentCaptor.forClass(JvmClassMappingKt.getJavaClass(kClass));
        Intrinsics.checkExpressionValueIsNotNull(forClass, "ArgumentCaptor.forClass(a.java)");
        KArgumentCaptor kArgumentCaptor = new KArgumentCaptor(forClass, kClass);
        ArgumentCaptor forClass2 = ArgumentCaptor.forClass(JvmClassMappingKt.getJavaClass(kClass2));
        Intrinsics.checkExpressionValueIsNotNull(forClass2, "ArgumentCaptor.forClass(b.java)");
        KArgumentCaptor kArgumentCaptor2 = new KArgumentCaptor(forClass2, kClass2);
        ArgumentCaptor forClass3 = ArgumentCaptor.forClass(JvmClassMappingKt.getJavaClass(kClass3));
        Intrinsics.checkExpressionValueIsNotNull(forClass3, "ArgumentCaptor.forClass(c.java)");
        KArgumentCaptor kArgumentCaptor3 = new KArgumentCaptor(forClass3, kClass3);
        ArgumentCaptor forClass4 = ArgumentCaptor.forClass(JvmClassMappingKt.getJavaClass(kClass4));
        Intrinsics.checkExpressionValueIsNotNull(forClass4, "ArgumentCaptor.forClass(d.java)");
        return new ArgumentCaptorHolder4(kArgumentCaptor, kArgumentCaptor2, kArgumentCaptor3, new KArgumentCaptor(forClass4, kClass4));
    }

    @NotNull
    public static final /* synthetic */ <A, B, C, D, E> ArgumentCaptorHolder5<KArgumentCaptor<A>, KArgumentCaptor<B>, KArgumentCaptor<C>, KArgumentCaptor<D>, KArgumentCaptor<E>> argumentCaptor(@NotNull KClass<A> kClass, @NotNull KClass<B> kClass2, @NotNull KClass<C> kClass3, @NotNull KClass<D> kClass4, @NotNull KClass<E> kClass5) {
        Intrinsics.checkParameterIsNotNull(kClass, "a");
        Intrinsics.checkParameterIsNotNull(kClass2, "b");
        Intrinsics.checkParameterIsNotNull(kClass3, c.f41585a);
        Intrinsics.checkParameterIsNotNull(kClass4, "d");
        Intrinsics.checkParameterIsNotNull(kClass5, "e");
        ArgumentCaptor<U> forClass = ArgumentCaptor.forClass(JvmClassMappingKt.getJavaClass(kClass));
        Intrinsics.checkExpressionValueIsNotNull(forClass, "ArgumentCaptor.forClass(a.java)");
        KArgumentCaptor kArgumentCaptor = new KArgumentCaptor(forClass, kClass);
        ArgumentCaptor<U> forClass2 = ArgumentCaptor.forClass(JvmClassMappingKt.getJavaClass(kClass2));
        Intrinsics.checkExpressionValueIsNotNull(forClass2, "ArgumentCaptor.forClass(b.java)");
        KArgumentCaptor kArgumentCaptor2 = new KArgumentCaptor(forClass2, kClass2);
        ArgumentCaptor<U> forClass3 = ArgumentCaptor.forClass(JvmClassMappingKt.getJavaClass(kClass3));
        Intrinsics.checkExpressionValueIsNotNull(forClass3, "ArgumentCaptor.forClass(c.java)");
        KArgumentCaptor kArgumentCaptor3 = new KArgumentCaptor(forClass3, kClass3);
        ArgumentCaptor<U> forClass4 = ArgumentCaptor.forClass(JvmClassMappingKt.getJavaClass(kClass4));
        Intrinsics.checkExpressionValueIsNotNull(forClass4, "ArgumentCaptor.forClass(d.java)");
        KArgumentCaptor kArgumentCaptor4 = new KArgumentCaptor(forClass4, kClass4);
        ArgumentCaptor<U> forClass5 = ArgumentCaptor.forClass(JvmClassMappingKt.getJavaClass(kClass5));
        Intrinsics.checkExpressionValueIsNotNull(forClass5, "ArgumentCaptor.forClass(e.java)");
        return new ArgumentCaptorHolder5(kArgumentCaptor, kArgumentCaptor2, kArgumentCaptor3, kArgumentCaptor4, new KArgumentCaptor(forClass5, kClass5));
    }

    @NotNull
    public static final /* synthetic */ <T> KArgumentCaptor<T> argumentCaptor(@NotNull Function1<? super KArgumentCaptor<? extends T>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "f");
        Intrinsics.reifiedOperationMarker(4, "T");
        Class<Object> cls = Object.class;
        ArgumentCaptor<U> forClass = ArgumentCaptor.forClass(cls);
        Intrinsics.checkExpressionValueIsNotNull(forClass, "ArgumentCaptor.forClass(T::class.java)");
        Intrinsics.reifiedOperationMarker(4, "T");
        KArgumentCaptor<T> kArgumentCaptor = new KArgumentCaptor<>(forClass, Reflection.getOrCreateKotlinClass(cls));
        function1.invoke(kArgumentCaptor);
        return kArgumentCaptor;
    }

    public static /* synthetic */ ArgumentCaptorHolder5 argumentCaptor$default(KClass kClass, KClass kClass2, KClass kClass3, KClass kClass4, KClass kClass5, int i11, Object obj) {
        Class<Object> cls = Object.class;
        if ((i11 & 1) != 0) {
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS);
            kClass = Reflection.getOrCreateKotlinClass(cls);
        }
        if ((i11 & 2) != 0) {
            Intrinsics.reifiedOperationMarker(4, "B");
            kClass2 = Reflection.getOrCreateKotlinClass(cls);
        }
        if ((i11 & 4) != 0) {
            Intrinsics.reifiedOperationMarker(4, "C");
            kClass3 = Reflection.getOrCreateKotlinClass(cls);
        }
        if ((i11 & 8) != 0) {
            Intrinsics.reifiedOperationMarker(4, "D");
            kClass4 = Reflection.getOrCreateKotlinClass(cls);
        }
        if ((i11 & 16) != 0) {
            Intrinsics.reifiedOperationMarker(4, ExifInterface.LONGITUDE_EAST);
            kClass5 = Reflection.getOrCreateKotlinClass(cls);
        }
        Intrinsics.checkParameterIsNotNull(kClass, "a");
        Intrinsics.checkParameterIsNotNull(kClass2, "b");
        Intrinsics.checkParameterIsNotNull(kClass3, c.f41585a);
        Intrinsics.checkParameterIsNotNull(kClass4, "d");
        Intrinsics.checkParameterIsNotNull(kClass5, "e");
        ArgumentCaptor forClass = ArgumentCaptor.forClass(JvmClassMappingKt.getJavaClass(kClass));
        Intrinsics.checkExpressionValueIsNotNull(forClass, "ArgumentCaptor.forClass(a.java)");
        KArgumentCaptor kArgumentCaptor = new KArgumentCaptor(forClass, kClass);
        ArgumentCaptor forClass2 = ArgumentCaptor.forClass(JvmClassMappingKt.getJavaClass(kClass2));
        Intrinsics.checkExpressionValueIsNotNull(forClass2, "ArgumentCaptor.forClass(b.java)");
        KArgumentCaptor kArgumentCaptor2 = new KArgumentCaptor(forClass2, kClass2);
        ArgumentCaptor forClass3 = ArgumentCaptor.forClass(JvmClassMappingKt.getJavaClass(kClass3));
        Intrinsics.checkExpressionValueIsNotNull(forClass3, "ArgumentCaptor.forClass(c.java)");
        KArgumentCaptor kArgumentCaptor3 = new KArgumentCaptor(forClass3, kClass3);
        ArgumentCaptor forClass4 = ArgumentCaptor.forClass(JvmClassMappingKt.getJavaClass(kClass4));
        Intrinsics.checkExpressionValueIsNotNull(forClass4, "ArgumentCaptor.forClass(d.java)");
        KArgumentCaptor kArgumentCaptor4 = new KArgumentCaptor(forClass4, kClass4);
        ArgumentCaptor forClass5 = ArgumentCaptor.forClass(JvmClassMappingKt.getJavaClass(kClass5));
        Intrinsics.checkExpressionValueIsNotNull(forClass5, "ArgumentCaptor.forClass(e.java)");
        return new ArgumentCaptorHolder5(kArgumentCaptor, kArgumentCaptor2, kArgumentCaptor3, kArgumentCaptor4, new KArgumentCaptor(forClass5, kClass5));
    }
}
