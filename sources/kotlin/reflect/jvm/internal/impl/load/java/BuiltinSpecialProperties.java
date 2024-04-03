package kotlin.reflect.jvm.internal.impl.load.java;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.talabat.darkstores.common.bindingAdapters.BindingAdaptersKt;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

public final class BuiltinSpecialProperties {
    @NotNull
    private static final Map<Name, List<Name>> GETTER_JVM_NAME_TO_PROPERTIES_SHORT_NAME_MAP;
    @NotNull
    public static final BuiltinSpecialProperties INSTANCE = new BuiltinSpecialProperties();
    @NotNull
    private static final Map<FqName, Name> PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP;
    @NotNull
    private static final Set<FqName> SPECIAL_FQ_NAMES;
    @NotNull
    private static final Set<Name> SPECIAL_SHORT_NAMES;

    static {
        FqNameUnsafe fqNameUnsafe = StandardNames.FqNames._enum;
        FqName fqName = StandardNames.FqNames.map;
        Map<FqName, Name> mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(BuiltinSpecialPropertiesKt.childSafe(fqNameUnsafe, "name"), Name.identifier("name")), TuplesKt.to(BuiltinSpecialPropertiesKt.childSafe(fqNameUnsafe, "ordinal"), Name.identifier("ordinal")), TuplesKt.to(BuiltinSpecialPropertiesKt.child(StandardNames.FqNames.collection, BindingAdaptersKt.QUERY_SIZE), Name.identifier(BindingAdaptersKt.QUERY_SIZE)), TuplesKt.to(BuiltinSpecialPropertiesKt.child(fqName, BindingAdaptersKt.QUERY_SIZE), Name.identifier(BindingAdaptersKt.QUERY_SIZE)), TuplesKt.to(BuiltinSpecialPropertiesKt.childSafe(StandardNames.FqNames.charSequence, "length"), Name.identifier("length")), TuplesKt.to(BuiltinSpecialPropertiesKt.child(fqName, UserMetadata.KEYDATA_FILENAME), Name.identifier("keySet")), TuplesKt.to(BuiltinSpecialPropertiesKt.child(fqName, "values"), Name.identifier("values")), TuplesKt.to(BuiltinSpecialPropertiesKt.child(fqName, RemoteConfigConstants.ResponseFieldKey.ENTRIES), Name.identifier("entrySet")));
        PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP = mapOf;
        Set<Map.Entry<FqName, Name>> entrySet = mapOf.entrySet();
        ArrayList<Pair> arrayList = new ArrayList<>(CollectionsKt__IterablesKt.collectionSizeOrDefault(entrySet, 10));
        for (Map.Entry entry : entrySet) {
            arrayList.add(new Pair(((FqName) entry.getKey()).shortName(), entry.getValue()));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Pair pair : arrayList) {
            Name name2 = (Name) pair.getSecond();
            Object obj = linkedHashMap.get(name2);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(name2, obj);
            }
            ((List) obj).add((Name) pair.getFirst());
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            linkedHashMap2.put(entry2.getKey(), CollectionsKt___CollectionsKt.distinct((Iterable) entry2.getValue()));
        }
        GETTER_JVM_NAME_TO_PROPERTIES_SHORT_NAME_MAP = linkedHashMap2;
        Set<FqName> keySet = PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP.keySet();
        SPECIAL_FQ_NAMES = keySet;
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(keySet, 10));
        for (FqName shortName : keySet) {
            arrayList2.add(shortName.shortName());
        }
        SPECIAL_SHORT_NAMES = CollectionsKt___CollectionsKt.toSet(arrayList2);
    }

    private BuiltinSpecialProperties() {
    }

    @NotNull
    public final Map<FqName, Name> getPROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP() {
        return PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP;
    }

    @NotNull
    public final List<Name> getPropertyNameCandidatesBySpecialGetterName(@NotNull Name name2) {
        Intrinsics.checkNotNullParameter(name2, "name1");
        List<Name> list = GETTER_JVM_NAME_TO_PROPERTIES_SHORT_NAME_MAP.get(name2);
        if (list == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return list;
    }

    @NotNull
    public final Set<FqName> getSPECIAL_FQ_NAMES() {
        return SPECIAL_FQ_NAMES;
    }

    @NotNull
    public final Set<Name> getSPECIAL_SHORT_NAMES() {
        return SPECIAL_SHORT_NAMES;
    }
}
