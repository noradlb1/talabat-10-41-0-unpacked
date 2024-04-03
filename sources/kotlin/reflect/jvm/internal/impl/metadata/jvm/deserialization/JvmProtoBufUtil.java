package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JvmProtoBufUtil {
    @NotNull
    private static final ExtensionRegistryLite EXTENSION_REGISTRY;
    @NotNull
    public static final JvmProtoBufUtil INSTANCE = new JvmProtoBufUtil();

    static {
        ExtensionRegistryLite newInstance = ExtensionRegistryLite.newInstance();
        JvmProtoBuf.registerAllExtensions(newInstance);
        Intrinsics.checkNotNullExpressionValue(newInstance, "newInstance().apply(JvmP…f::registerAllExtensions)");
        EXTENSION_REGISTRY = newInstance;
    }

    private JvmProtoBufUtil() {
    }

    public static /* synthetic */ JvmMemberSignature.Field getJvmFieldSignature$default(JvmProtoBufUtil jvmProtoBufUtil, ProtoBuf.Property property, NameResolver nameResolver, TypeTable typeTable, boolean z11, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            z11 = true;
        }
        return jvmProtoBufUtil.getJvmFieldSignature(property, nameResolver, typeTable, z11);
    }

    @JvmStatic
    public static final boolean isMovedFromInterfaceCompanion(@NotNull ProtoBuf.Property property) {
        Intrinsics.checkNotNullParameter(property, "proto");
        Flags.BooleanFlagField is_moved_from_interface_companion = JvmFlags.INSTANCE.getIS_MOVED_FROM_INTERFACE_COMPANION();
        Object extension = property.getExtension(JvmProtoBuf.flags);
        Intrinsics.checkNotNullExpressionValue(extension, "proto.getExtension(JvmProtoBuf.flags)");
        Boolean bool = is_moved_from_interface_companion.get(((Number) extension).intValue());
        Intrinsics.checkNotNullExpressionValue(bool, "JvmFlags.IS_MOVED_FROM_I…nsion(JvmProtoBuf.flags))");
        return bool.booleanValue();
    }

    private final String mapTypeDefault(ProtoBuf.Type type, NameResolver nameResolver) {
        if (type.hasClassName()) {
            return ClassMapperLite.mapClass(nameResolver.getQualifiedClassName(type.getClassName()));
        }
        return null;
    }

    @JvmStatic
    @NotNull
    public static final Pair<JvmNameResolver, ProtoBuf.Class> readClassDataFrom(@NotNull String[] strArr, @NotNull String[] strArr2) {
        Intrinsics.checkNotNullParameter(strArr, "data");
        Intrinsics.checkNotNullParameter(strArr2, "strings");
        byte[] decodeBytes = BitEncoding.decodeBytes(strArr);
        Intrinsics.checkNotNullExpressionValue(decodeBytes, "decodeBytes(data)");
        return readClassDataFrom(decodeBytes, strArr2);
    }

    @JvmStatic
    @NotNull
    public static final Pair<JvmNameResolver, ProtoBuf.Function> readFunctionDataFrom(@NotNull String[] strArr, @NotNull String[] strArr2) {
        Intrinsics.checkNotNullParameter(strArr, "data");
        Intrinsics.checkNotNullParameter(strArr2, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(BitEncoding.decodeBytes(strArr));
        return new Pair<>(INSTANCE.readNameResolver(byteArrayInputStream, strArr2), ProtoBuf.Function.parseFrom(byteArrayInputStream, EXTENSION_REGISTRY));
    }

    private final JvmNameResolver readNameResolver(InputStream inputStream, String[] strArr) {
        JvmProtoBuf.StringTableTypes parseDelimitedFrom = JvmProtoBuf.StringTableTypes.parseDelimitedFrom(inputStream, EXTENSION_REGISTRY);
        Intrinsics.checkNotNullExpressionValue(parseDelimitedFrom, "parseDelimitedFrom(this, EXTENSION_REGISTRY)");
        return new JvmNameResolver(parseDelimitedFrom, strArr);
    }

    @JvmStatic
    @NotNull
    public static final Pair<JvmNameResolver, ProtoBuf.Package> readPackageDataFrom(@NotNull String[] strArr, @NotNull String[] strArr2) {
        Intrinsics.checkNotNullParameter(strArr, "data");
        Intrinsics.checkNotNullParameter(strArr2, "strings");
        byte[] decodeBytes = BitEncoding.decodeBytes(strArr);
        Intrinsics.checkNotNullExpressionValue(decodeBytes, "decodeBytes(data)");
        return readPackageDataFrom(decodeBytes, strArr2);
    }

    @NotNull
    public final ExtensionRegistryLite getEXTENSION_REGISTRY() {
        return EXTENSION_REGISTRY;
    }

    @Nullable
    public final JvmMemberSignature.Method getJvmConstructorSignature(@NotNull ProtoBuf.Constructor constructor, @NotNull NameResolver nameResolver, @NotNull TypeTable typeTable) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(constructor, "proto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Constructor, JvmProtoBuf.JvmMethodSignature> generatedExtension = JvmProtoBuf.constructorSignature;
        Intrinsics.checkNotNullExpressionValue(generatedExtension, "constructorSignature");
        JvmProtoBuf.JvmMethodSignature jvmMethodSignature = (JvmProtoBuf.JvmMethodSignature) ProtoBufUtilKt.getExtensionOrNull(constructor, generatedExtension);
        if (jvmMethodSignature == null || !jvmMethodSignature.hasName()) {
            str = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
        } else {
            str = nameResolver.getString(jvmMethodSignature.getName());
        }
        if (jvmMethodSignature == null || !jvmMethodSignature.hasDesc()) {
            List<ProtoBuf.ValueParameter> valueParameterList = constructor.getValueParameterList();
            Intrinsics.checkNotNullExpressionValue(valueParameterList, "proto.valueParameterList");
            Iterable<ProtoBuf.ValueParameter> iterable = valueParameterList;
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
            for (ProtoBuf.ValueParameter valueParameter : iterable) {
                JvmProtoBufUtil jvmProtoBufUtil = INSTANCE;
                Intrinsics.checkNotNullExpressionValue(valueParameter, "it");
                String mapTypeDefault = jvmProtoBufUtil.mapTypeDefault(ProtoTypeTableUtilKt.type(valueParameter, typeTable), nameResolver);
                if (mapTypeDefault == null) {
                    return null;
                }
                arrayList.add(mapTypeDefault);
            }
            str2 = CollectionsKt___CollectionsKt.joinToString$default(arrayList, "", "(", ")V", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
        } else {
            str2 = nameResolver.getString(jvmMethodSignature.getDesc());
        }
        return new JvmMemberSignature.Method(str, str2);
    }

    @Nullable
    public final JvmMemberSignature.Field getJvmFieldSignature(@NotNull ProtoBuf.Property property, @NotNull NameResolver nameResolver, @NotNull TypeTable typeTable, boolean z11) {
        JvmProtoBuf.JvmFieldSignature jvmFieldSignature;
        int i11;
        String str;
        Intrinsics.checkNotNullParameter(property, "proto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, JvmProtoBuf.JvmPropertySignature> generatedExtension = JvmProtoBuf.propertySignature;
        Intrinsics.checkNotNullExpressionValue(generatedExtension, "propertySignature");
        JvmProtoBuf.JvmPropertySignature jvmPropertySignature = (JvmProtoBuf.JvmPropertySignature) ProtoBufUtilKt.getExtensionOrNull(property, generatedExtension);
        if (jvmPropertySignature == null) {
            return null;
        }
        if (jvmPropertySignature.hasField()) {
            jvmFieldSignature = jvmPropertySignature.getField();
        } else {
            jvmFieldSignature = null;
        }
        if (jvmFieldSignature == null && z11) {
            return null;
        }
        if (jvmFieldSignature == null || !jvmFieldSignature.hasName()) {
            i11 = property.getName();
        } else {
            i11 = jvmFieldSignature.getName();
        }
        if (jvmFieldSignature == null || !jvmFieldSignature.hasDesc()) {
            str = mapTypeDefault(ProtoTypeTableUtilKt.returnType(property, typeTable), nameResolver);
            if (str == null) {
                return null;
            }
        } else {
            str = nameResolver.getString(jvmFieldSignature.getDesc());
        }
        return new JvmMemberSignature.Field(nameResolver.getString(i11), str);
    }

    @Nullable
    public final JvmMemberSignature.Method getJvmMethodSignature(@NotNull ProtoBuf.Function function, @NotNull NameResolver nameResolver, @NotNull TypeTable typeTable) {
        int i11;
        String str;
        ProtoBuf.Function function2 = function;
        NameResolver nameResolver2 = nameResolver;
        TypeTable typeTable2 = typeTable;
        Intrinsics.checkNotNullParameter(function2, "proto");
        Intrinsics.checkNotNullParameter(nameResolver2, "nameResolver");
        Intrinsics.checkNotNullParameter(typeTable2, "typeTable");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Function, JvmProtoBuf.JvmMethodSignature> generatedExtension = JvmProtoBuf.methodSignature;
        Intrinsics.checkNotNullExpressionValue(generatedExtension, "methodSignature");
        JvmProtoBuf.JvmMethodSignature jvmMethodSignature = (JvmProtoBuf.JvmMethodSignature) ProtoBufUtilKt.getExtensionOrNull(function2, generatedExtension);
        if (jvmMethodSignature == null || !jvmMethodSignature.hasName()) {
            i11 = function.getName();
        } else {
            i11 = jvmMethodSignature.getName();
        }
        if (jvmMethodSignature == null || !jvmMethodSignature.hasDesc()) {
            Collection listOfNotNull = CollectionsKt__CollectionsKt.listOfNotNull(ProtoTypeTableUtilKt.receiverType(function2, typeTable2));
            List<ProtoBuf.ValueParameter> valueParameterList = function.getValueParameterList();
            Intrinsics.checkNotNullExpressionValue(valueParameterList, "proto.valueParameterList");
            Iterable<ProtoBuf.ValueParameter> iterable = valueParameterList;
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
            for (ProtoBuf.ValueParameter valueParameter : iterable) {
                Intrinsics.checkNotNullExpressionValue(valueParameter, "it");
                arrayList.add(ProtoTypeTableUtilKt.type(valueParameter, typeTable2));
            }
            Iterable<ProtoBuf.Type> plus = CollectionsKt___CollectionsKt.plus(listOfNotNull, arrayList);
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(plus, 10));
            for (ProtoBuf.Type mapTypeDefault : plus) {
                String mapTypeDefault2 = INSTANCE.mapTypeDefault(mapTypeDefault, nameResolver2);
                if (mapTypeDefault2 == null) {
                    return null;
                }
                arrayList2.add(mapTypeDefault2);
            }
            String mapTypeDefault3 = mapTypeDefault(ProtoTypeTableUtilKt.returnType(function2, typeTable2), nameResolver2);
            if (mapTypeDefault3 == null) {
                return null;
            }
            str = CollectionsKt___CollectionsKt.joinToString$default(arrayList2, "", "(", ")", 0, (CharSequence) null, (Function1) null, 56, (Object) null) + mapTypeDefault3;
        } else {
            str = nameResolver2.getString(jvmMethodSignature.getDesc());
        }
        return new JvmMemberSignature.Method(nameResolver2.getString(i11), str);
    }

    @JvmStatic
    @NotNull
    public static final Pair<JvmNameResolver, ProtoBuf.Class> readClassDataFrom(@NotNull byte[] bArr, @NotNull String[] strArr) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        Intrinsics.checkNotNullParameter(strArr, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        return new Pair<>(INSTANCE.readNameResolver(byteArrayInputStream, strArr), ProtoBuf.Class.parseFrom(byteArrayInputStream, EXTENSION_REGISTRY));
    }

    @JvmStatic
    @NotNull
    public static final Pair<JvmNameResolver, ProtoBuf.Package> readPackageDataFrom(@NotNull byte[] bArr, @NotNull String[] strArr) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        Intrinsics.checkNotNullParameter(strArr, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        return new Pair<>(INSTANCE.readNameResolver(byteArrayInputStream, strArr), ProtoBuf.Package.parseFrom(byteArrayInputStream, EXTENSION_REGISTRY));
    }
}
