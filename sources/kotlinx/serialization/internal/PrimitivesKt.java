package kotlinx.serialization.internal;

import fwfd.com.fwfsdk.constant.FWFConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.BooleanCompanionObject;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.CharCompanionObject;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.ShortCompanionObject;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0002\u001a$\u0010\u000f\u001a\n\u0012\u0004\u0012\u0002H\u0010\u0018\u00010\u0004\"\b\b\u0000\u0010\u0010*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00100\u0002H\u0000\u001a\f\u0010\u0011\u001a\u00020\n*\u00020\nH\u0002\"2\u0010\u0000\u001a\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00040\u00018\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"BUILTIN_SERIALIZERS", "", "Lkotlin/reflect/KClass;", "", "Lkotlinx/serialization/KSerializer;", "getBUILTIN_SERIALIZERS$annotations", "()V", "PrimitiveDescriptorSafe", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialName", "", "kind", "Lkotlinx/serialization/descriptors/PrimitiveKind;", "checkName", "", "builtinSerializerOrNull", "T", "capitalize", "kotlinx-serialization-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class PrimitivesKt {
    @NotNull
    private static final Map<KClass<? extends Object>, KSerializer<? extends Object>> BUILTIN_SERIALIZERS = MapsKt__MapsKt.mapOf(TuplesKt.to(Reflection.getOrCreateKotlinClass(String.class), BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE)), TuplesKt.to(Reflection.getOrCreateKotlinClass(Character.TYPE), BuiltinSerializersKt.serializer(CharCompanionObject.INSTANCE)), TuplesKt.to(Reflection.getOrCreateKotlinClass(char[].class), BuiltinSerializersKt.CharArraySerializer()), TuplesKt.to(Reflection.getOrCreateKotlinClass(Double.TYPE), BuiltinSerializersKt.serializer(DoubleCompanionObject.INSTANCE)), TuplesKt.to(Reflection.getOrCreateKotlinClass(double[].class), BuiltinSerializersKt.DoubleArraySerializer()), TuplesKt.to(Reflection.getOrCreateKotlinClass(Float.TYPE), BuiltinSerializersKt.serializer(FloatCompanionObject.INSTANCE)), TuplesKt.to(Reflection.getOrCreateKotlinClass(float[].class), BuiltinSerializersKt.FloatArraySerializer()), TuplesKt.to(Reflection.getOrCreateKotlinClass(Long.TYPE), BuiltinSerializersKt.serializer(LongCompanionObject.INSTANCE)), TuplesKt.to(Reflection.getOrCreateKotlinClass(long[].class), BuiltinSerializersKt.LongArraySerializer()), TuplesKt.to(Reflection.getOrCreateKotlinClass(Integer.TYPE), BuiltinSerializersKt.serializer(IntCompanionObject.INSTANCE)), TuplesKt.to(Reflection.getOrCreateKotlinClass(int[].class), BuiltinSerializersKt.IntArraySerializer()), TuplesKt.to(Reflection.getOrCreateKotlinClass(Short.TYPE), BuiltinSerializersKt.serializer(ShortCompanionObject.INSTANCE)), TuplesKt.to(Reflection.getOrCreateKotlinClass(short[].class), BuiltinSerializersKt.ShortArraySerializer()), TuplesKt.to(Reflection.getOrCreateKotlinClass(Byte.TYPE), BuiltinSerializersKt.serializer(ByteCompanionObject.INSTANCE)), TuplesKt.to(Reflection.getOrCreateKotlinClass(byte[].class), BuiltinSerializersKt.ByteArraySerializer()), TuplesKt.to(Reflection.getOrCreateKotlinClass(Boolean.TYPE), BuiltinSerializersKt.serializer(BooleanCompanionObject.INSTANCE)), TuplesKt.to(Reflection.getOrCreateKotlinClass(boolean[].class), BuiltinSerializersKt.BooleanArraySerializer()), TuplesKt.to(Reflection.getOrCreateKotlinClass(Unit.class), BuiltinSerializersKt.serializer(Unit.INSTANCE)));

    @NotNull
    public static final SerialDescriptor PrimitiveDescriptorSafe(@NotNull String str, @NotNull PrimitiveKind primitiveKind) {
        Intrinsics.checkNotNullParameter(str, "serialName");
        Intrinsics.checkNotNullParameter(primitiveKind, FWFConstants.EXPLANATION_TYPE_KIND);
        checkName(str);
        return new PrimitiveSerialDescriptor(str, primitiveKind);
    }

    @Nullable
    public static final <T> KSerializer<T> builtinSerializerOrNull(@NotNull KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        return BUILTIN_SERIALIZERS.get(kClass);
    }

    private static final String capitalize(String str) {
        if (!(str.length() > 0)) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        char charAt = str.charAt(0);
        sb2.append(Character.isLowerCase(charAt) ? CharsKt__CharKt.titlecase(charAt) : String.valueOf(charAt));
        String substring = str.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        sb2.append(substring);
        return sb2.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0010  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final void checkName(java.lang.String r4) {
        /*
            java.util.Map<kotlin.reflect.KClass<? extends java.lang.Object>, kotlinx.serialization.KSerializer<? extends java.lang.Object>> r0 = BUILTIN_SERIALIZERS
            java.util.Set r0 = r0.keySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x000a:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x006c
            java.lang.Object r1 = r0.next()
            kotlin.reflect.KClass r1 = (kotlin.reflect.KClass) r1
            java.lang.String r1 = r1.getSimpleName()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            java.lang.String r1 = capitalize(r1)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "kotlin."
            r2.append(r3)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            r3 = 1
            boolean r2 = kotlin.text.StringsKt__StringsJVMKt.equals(r4, r2, r3)
            if (r2 != 0) goto L_0x0040
            boolean r2 = kotlin.text.StringsKt__StringsJVMKt.equals(r4, r1, r3)
            if (r2 != 0) goto L_0x0040
            goto L_0x000a
        L_0x0040:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "\n                The name of serial descriptor should uniquely identify associated serializer.\n                For serial name "
            r2.append(r3)
            r2.append(r4)
            java.lang.String r4 = " there already exist "
            r2.append(r4)
            java.lang.String r4 = capitalize(r1)
            r2.append(r4)
            java.lang.String r4 = "Serializer.\n                Please refer to SerialDescriptor documentation for additional information.\n            "
            r2.append(r4)
            java.lang.String r4 = r2.toString()
            java.lang.String r4 = kotlin.text.StringsKt__IndentKt.trimIndent(r4)
            r0.<init>(r4)
            throw r0
        L_0x006c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.internal.PrimitivesKt.checkName(java.lang.String):void");
    }

    private static /* synthetic */ void getBUILTIN_SERIALIZERS$annotations() {
    }
}
