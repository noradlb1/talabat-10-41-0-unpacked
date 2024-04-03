package org.mockito.kotlin.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0013\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001H\u0002¢\u0006\u0002\u0010\u0002\u001a\u001a\u0010\u0003\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0004H\b¢\u0006\u0002\u0010\u0002\u001a#\u0010\u0003\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"castNull", "T", "()Ljava/lang/Object;", "createInstance", "", "kClass", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "mockito-kotlin"}, k = 2, mv = {1, 1, 15})
public final class CreateInstanceKt {
    private static final <T> T castNull() {
        return null;
    }

    @NotNull
    public static final /* synthetic */ <T> T createInstance() {
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
            return createInstance(Reflection.getOrCreateKotlinClass(cls));
        }
    }

    @NotNull
    public static final <T> T createInstance(@NotNull KClass<T> kClass) {
        Intrinsics.checkParameterIsNotNull(kClass, "kClass");
        return castNull();
    }
}
