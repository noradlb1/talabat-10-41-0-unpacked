package kotlin.reflect.jvm.internal.impl.load.java;

import com.google.android.gms.analytics.ecommerce.ProductAction;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import net.bytebuddy.implementation.auxiliary.TypeProxy;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SpecialGenericSignatures {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final List<String> ERASED_COLLECTION_PARAMETER_NAMES;
    @NotNull
    private static final List<Companion.NameAndSignature> ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES;
    /* access modifiers changed from: private */
    @NotNull
    public static final List<String> ERASED_COLLECTION_PARAMETER_SIGNATURES;
    /* access modifiers changed from: private */
    @NotNull
    public static final Set<Name> ERASED_VALUE_PARAMETERS_SHORT_NAMES;
    /* access modifiers changed from: private */
    @NotNull
    public static final Set<String> ERASED_VALUE_PARAMETERS_SIGNATURES;
    @NotNull
    private static final Map<Companion.NameAndSignature, TypeSafeBarrierDescription> GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP;
    /* access modifiers changed from: private */
    @NotNull
    public static final Map<Name, Name> JVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP;
    @NotNull
    private static final Map<Companion.NameAndSignature, Name> NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP;
    /* access modifiers changed from: private */
    @NotNull
    public static final List<Name> ORIGINAL_SHORT_NAMES;
    /* access modifiers changed from: private */
    @NotNull
    public static final Companion.NameAndSignature REMOVE_AT_NAME_AND_SIGNATURE;
    /* access modifiers changed from: private */
    @NotNull
    public static final Map<String, TypeSafeBarrierDescription> SIGNATURE_TO_DEFAULT_VALUES_MAP;
    /* access modifiers changed from: private */
    @NotNull
    public static final Map<String, Name> SIGNATURE_TO_JVM_REPRESENTATION_NAME;

    public static final class Companion {

        public static final class NameAndSignature {
            @NotNull

            /* renamed from: name  reason: collision with root package name */
            private final Name f24569name;
            @NotNull
            private final String signature;

            public NameAndSignature(@NotNull Name name2, @NotNull String str) {
                Intrinsics.checkNotNullParameter(name2, "name");
                Intrinsics.checkNotNullParameter(str, "signature");
                this.f24569name = name2;
                this.signature = str;
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof NameAndSignature)) {
                    return false;
                }
                NameAndSignature nameAndSignature = (NameAndSignature) obj;
                return Intrinsics.areEqual((Object) this.f24569name, (Object) nameAndSignature.f24569name) && Intrinsics.areEqual((Object) this.signature, (Object) nameAndSignature.signature);
            }

            @NotNull
            public final Name getName() {
                return this.f24569name;
            }

            @NotNull
            public final String getSignature() {
                return this.signature;
            }

            public int hashCode() {
                return (this.f24569name.hashCode() * 31) + this.signature.hashCode();
            }

            @NotNull
            public String toString() {
                return "NameAndSignature(name=" + this.f24569name + ", signature=" + this.signature + ')';
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final NameAndSignature method(String str, String str2, String str3, String str4) {
            Name identifier = Name.identifier(str2);
            Intrinsics.checkNotNullExpressionValue(identifier, "identifier(name)");
            SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
            return new NameAndSignature(identifier, signatureBuildingComponents.signature(str, str2 + '(' + str3 + ')' + str4));
        }

        @Nullable
        public final Name getBuiltinFunctionNamesByJvmName(@NotNull Name name2) {
            Intrinsics.checkNotNullParameter(name2, "name");
            return getJVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP().get(name2);
        }

        @NotNull
        public final List<String> getERASED_COLLECTION_PARAMETER_SIGNATURES() {
            return SpecialGenericSignatures.ERASED_COLLECTION_PARAMETER_SIGNATURES;
        }

        @NotNull
        public final Set<Name> getERASED_VALUE_PARAMETERS_SHORT_NAMES() {
            return SpecialGenericSignatures.ERASED_VALUE_PARAMETERS_SHORT_NAMES;
        }

        @NotNull
        public final Set<String> getERASED_VALUE_PARAMETERS_SIGNATURES() {
            return SpecialGenericSignatures.ERASED_VALUE_PARAMETERS_SIGNATURES;
        }

        @NotNull
        public final Map<Name, Name> getJVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP() {
            return SpecialGenericSignatures.JVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP;
        }

        @NotNull
        public final List<Name> getORIGINAL_SHORT_NAMES() {
            return SpecialGenericSignatures.ORIGINAL_SHORT_NAMES;
        }

        @NotNull
        public final NameAndSignature getREMOVE_AT_NAME_AND_SIGNATURE() {
            return SpecialGenericSignatures.REMOVE_AT_NAME_AND_SIGNATURE;
        }

        @NotNull
        public final Map<String, TypeSafeBarrierDescription> getSIGNATURE_TO_DEFAULT_VALUES_MAP() {
            return SpecialGenericSignatures.SIGNATURE_TO_DEFAULT_VALUES_MAP;
        }

        @NotNull
        public final Map<String, Name> getSIGNATURE_TO_JVM_REPRESENTATION_NAME() {
            return SpecialGenericSignatures.SIGNATURE_TO_JVM_REPRESENTATION_NAME;
        }

        public final boolean getSameAsRenamedInJvmBuiltin(@NotNull Name name2) {
            Intrinsics.checkNotNullParameter(name2, "<this>");
            return getORIGINAL_SHORT_NAMES().contains(name2);
        }

        @NotNull
        public final SpecialSignatureInfo getSpecialSignatureInfo(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "builtinSignature");
            if (getERASED_COLLECTION_PARAMETER_SIGNATURES().contains(str)) {
                return SpecialSignatureInfo.ONE_COLLECTION_PARAMETER;
            }
            if (((TypeSafeBarrierDescription) MapsKt__MapsKt.getValue(getSIGNATURE_TO_DEFAULT_VALUES_MAP(), str)) == TypeSafeBarrierDescription.NULL) {
                return SpecialSignatureInfo.OBJECT_PARAMETER_GENERIC;
            }
            return SpecialSignatureInfo.OBJECT_PARAMETER_NON_GENERIC;
        }
    }

    public enum SpecialSignatureInfo {
        ONE_COLLECTION_PARAMETER("Ljava/util/Collection<+Ljava/lang/Object;>;", false),
        OBJECT_PARAMETER_NON_GENERIC((String) null, true),
        OBJECT_PARAMETER_GENERIC(TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_DESCRIPTOR, true);
        
        private final boolean isObjectReplacedWithTypeParameter;
        @Nullable
        private final String valueParametersSignature;

        private SpecialSignatureInfo(String str, boolean z11) {
            this.valueParametersSignature = str;
            this.isObjectReplacedWithTypeParameter = z11;
        }
    }

    public enum TypeSafeBarrierDescription {
        NULL((String) null),
        INDEX(-1),
        FALSE(Boolean.FALSE);
        
        @Nullable
        private final Object defaultValue;

        public static final class MAP_GET_OR_DEFAULT extends TypeSafeBarrierDescription {
            public MAP_GET_OR_DEFAULT(String str, int i11) {
                super(str, i11, (Object) null, (DefaultConstructorMarker) null);
            }
        }

        private TypeSafeBarrierDescription(Object obj) {
            this.defaultValue = obj;
        }
    }

    static {
        Set<String> of2 = SetsKt__SetsKt.setOf("containsAll", "removeAll", "retainAll");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(of2, 10));
        for (String access$method : of2) {
            Companion companion = Companion;
            String desc = JvmPrimitiveType.BOOLEAN.getDesc();
            Intrinsics.checkNotNullExpressionValue(desc, "BOOLEAN.desc");
            arrayList.add(companion.method("java/util/Collection", access$method, "Ljava/util/Collection;", desc));
        }
        ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES = arrayList;
        Iterable<Companion.NameAndSignature> iterable = arrayList;
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (Companion.NameAndSignature signature : iterable) {
            arrayList2.add(signature.getSignature());
        }
        ERASED_COLLECTION_PARAMETER_SIGNATURES = arrayList2;
        Iterable<Companion.NameAndSignature> iterable2 = ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES;
        ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable2, 10));
        for (Companion.NameAndSignature name2 : iterable2) {
            arrayList3.add(name2.getName().asString());
        }
        ERASED_COLLECTION_PARAMETER_NAMES = arrayList3;
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
        Companion companion2 = Companion;
        String javaUtil = signatureBuildingComponents.javaUtil("Collection");
        JvmPrimitiveType jvmPrimitiveType = JvmPrimitiveType.BOOLEAN;
        String desc2 = jvmPrimitiveType.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc2, "BOOLEAN.desc");
        Companion.NameAndSignature access$method2 = companion2.method(javaUtil, "contains", TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_DESCRIPTOR, desc2);
        TypeSafeBarrierDescription typeSafeBarrierDescription = TypeSafeBarrierDescription.FALSE;
        String javaUtil2 = signatureBuildingComponents.javaUtil("Collection");
        String desc3 = jvmPrimitiveType.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc3, "BOOLEAN.desc");
        String javaUtil3 = signatureBuildingComponents.javaUtil("Map");
        String desc4 = jvmPrimitiveType.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc4, "BOOLEAN.desc");
        String javaUtil4 = signatureBuildingComponents.javaUtil("Map");
        String desc5 = jvmPrimitiveType.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc5, "BOOLEAN.desc");
        String javaUtil5 = signatureBuildingComponents.javaUtil("Map");
        String desc6 = jvmPrimitiveType.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc6, "BOOLEAN.desc");
        Companion.NameAndSignature access$method3 = companion2.method(signatureBuildingComponents.javaUtil("Map"), "get", TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_DESCRIPTOR, TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_DESCRIPTOR);
        TypeSafeBarrierDescription typeSafeBarrierDescription2 = TypeSafeBarrierDescription.NULL;
        String javaUtil6 = signatureBuildingComponents.javaUtil("List");
        JvmPrimitiveType jvmPrimitiveType2 = JvmPrimitiveType.INT;
        String desc7 = jvmPrimitiveType2.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc7, "INT.desc");
        Companion.NameAndSignature access$method4 = companion2.method(javaUtil6, "indexOf", TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_DESCRIPTOR, desc7);
        TypeSafeBarrierDescription typeSafeBarrierDescription3 = TypeSafeBarrierDescription.INDEX;
        String javaUtil7 = signatureBuildingComponents.javaUtil("List");
        String desc8 = jvmPrimitiveType2.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc8, "INT.desc");
        Map<Companion.NameAndSignature, TypeSafeBarrierDescription> mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(access$method2, typeSafeBarrierDescription), TuplesKt.to(companion2.method(javaUtil2, ProductAction.ACTION_REMOVE, TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_DESCRIPTOR, desc3), typeSafeBarrierDescription), TuplesKt.to(companion2.method(javaUtil3, "containsKey", TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_DESCRIPTOR, desc4), typeSafeBarrierDescription), TuplesKt.to(companion2.method(javaUtil4, "containsValue", TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_DESCRIPTOR, desc5), typeSafeBarrierDescription), TuplesKt.to(companion2.method(javaUtil5, ProductAction.ACTION_REMOVE, "Ljava/lang/Object;Ljava/lang/Object;", desc6), typeSafeBarrierDescription), TuplesKt.to(companion2.method(signatureBuildingComponents.javaUtil("Map"), "getOrDefault", "Ljava/lang/Object;Ljava/lang/Object;", TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_DESCRIPTOR), TypeSafeBarrierDescription.MAP_GET_OR_DEFAULT), TuplesKt.to(access$method3, typeSafeBarrierDescription2), TuplesKt.to(companion2.method(signatureBuildingComponents.javaUtil("Map"), ProductAction.ACTION_REMOVE, TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_DESCRIPTOR, TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_DESCRIPTOR), typeSafeBarrierDescription2), TuplesKt.to(access$method4, typeSafeBarrierDescription3), TuplesKt.to(companion2.method(javaUtil7, "lastIndexOf", TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_DESCRIPTOR, desc8), typeSafeBarrierDescription3));
        GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP = mapOf;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(mapOf.size()));
        for (Map.Entry entry : mapOf.entrySet()) {
            linkedHashMap.put(((Companion.NameAndSignature) entry.getKey()).getSignature(), entry.getValue());
        }
        SIGNATURE_TO_DEFAULT_VALUES_MAP = linkedHashMap;
        Set<Companion.NameAndSignature> plus = SetsKt___SetsKt.plus(GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP.keySet(), ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES);
        ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(plus, 10));
        for (Companion.NameAndSignature name3 : plus) {
            arrayList4.add(name3.getName());
        }
        ERASED_VALUE_PARAMETERS_SHORT_NAMES = CollectionsKt___CollectionsKt.toSet(arrayList4);
        ArrayList arrayList5 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(plus, 10));
        for (Companion.NameAndSignature signature2 : plus) {
            arrayList5.add(signature2.getSignature());
        }
        ERASED_VALUE_PARAMETERS_SIGNATURES = CollectionsKt___CollectionsKt.toSet(arrayList5);
        Companion companion3 = Companion;
        JvmPrimitiveType jvmPrimitiveType3 = JvmPrimitiveType.INT;
        String desc9 = jvmPrimitiveType3.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc9, "INT.desc");
        Companion.NameAndSignature access$method5 = companion3.method("java/util/List", "removeAt", desc9, TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_DESCRIPTOR);
        REMOVE_AT_NAME_AND_SIGNATURE = access$method5;
        SignatureBuildingComponents signatureBuildingComponents2 = SignatureBuildingComponents.INSTANCE;
        String javaLang = signatureBuildingComponents2.javaLang("Number");
        String desc10 = JvmPrimitiveType.BYTE.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc10, "BYTE.desc");
        String javaLang2 = signatureBuildingComponents2.javaLang("Number");
        String desc11 = JvmPrimitiveType.SHORT.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc11, "SHORT.desc");
        String javaLang3 = signatureBuildingComponents2.javaLang("Number");
        String desc12 = jvmPrimitiveType3.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc12, "INT.desc");
        String javaLang4 = signatureBuildingComponents2.javaLang("Number");
        String desc13 = JvmPrimitiveType.LONG.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc13, "LONG.desc");
        String javaLang5 = signatureBuildingComponents2.javaLang("Number");
        String desc14 = JvmPrimitiveType.FLOAT.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc14, "FLOAT.desc");
        String javaLang6 = signatureBuildingComponents2.javaLang("Number");
        String desc15 = JvmPrimitiveType.DOUBLE.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc15, "DOUBLE.desc");
        String javaLang7 = signatureBuildingComponents2.javaLang("CharSequence");
        String desc16 = jvmPrimitiveType3.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc16, "INT.desc");
        String desc17 = JvmPrimitiveType.CHAR.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc17, "CHAR.desc");
        Map<Companion.NameAndSignature, Name> mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to(companion3.method(javaLang, "toByte", "", desc10), Name.identifier("byteValue")), TuplesKt.to(companion3.method(javaLang2, "toShort", "", desc11), Name.identifier("shortValue")), TuplesKt.to(companion3.method(javaLang3, "toInt", "", desc12), Name.identifier("intValue")), TuplesKt.to(companion3.method(javaLang4, "toLong", "", desc13), Name.identifier("longValue")), TuplesKt.to(companion3.method(javaLang5, "toFloat", "", desc14), Name.identifier("floatValue")), TuplesKt.to(companion3.method(javaLang6, "toDouble", "", desc15), Name.identifier("doubleValue")), TuplesKt.to(access$method5, Name.identifier(ProductAction.ACTION_REMOVE)), TuplesKt.to(companion3.method(javaLang7, "get", desc16, desc17), Name.identifier("charAt")));
        NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP = mapOf2;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(mapOf2.size()));
        for (Map.Entry entry2 : mapOf2.entrySet()) {
            linkedHashMap2.put(((Companion.NameAndSignature) entry2.getKey()).getSignature(), entry2.getValue());
        }
        SIGNATURE_TO_JVM_REPRESENTATION_NAME = linkedHashMap2;
        Set<Companion.NameAndSignature> keySet = NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP.keySet();
        ArrayList arrayList6 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(keySet, 10));
        for (Companion.NameAndSignature name4 : keySet) {
            arrayList6.add(name4.getName());
        }
        ORIGINAL_SHORT_NAMES = arrayList6;
        Set<Map.Entry<Companion.NameAndSignature, Name>> entrySet = NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP.entrySet();
        ArrayList<Pair> arrayList7 = new ArrayList<>(CollectionsKt__IterablesKt.collectionSizeOrDefault(entrySet, 10));
        for (Map.Entry entry3 : entrySet) {
            arrayList7.add(new Pair(((Companion.NameAndSignature) entry3.getKey()).getName(), entry3.getValue()));
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList7, 10)), 16));
        for (Pair pair : arrayList7) {
            linkedHashMap3.put((Name) pair.getSecond(), (Name) pair.getFirst());
        }
        JVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP = linkedHashMap3;
    }
}
