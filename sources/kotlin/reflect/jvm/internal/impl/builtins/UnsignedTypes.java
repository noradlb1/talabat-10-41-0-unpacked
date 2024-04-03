package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class UnsignedTypes {
    @NotNull
    public static final UnsignedTypes INSTANCE = new UnsignedTypes();
    @NotNull
    private static final HashMap<ClassId, ClassId> arrayClassIdToUnsignedClassId = new HashMap<>();
    @NotNull
    private static final Set<Name> arrayClassesShortNames;
    @NotNull
    private static final Set<Name> unsignedArrayTypeNames;
    @NotNull
    private static final HashMap<UnsignedArrayType, Name> unsignedArrayTypeToArrayCall = MapsKt__MapsKt.hashMapOf(TuplesKt.to(UnsignedArrayType.UBYTEARRAY, Name.identifier("ubyteArrayOf")), TuplesKt.to(UnsignedArrayType.USHORTARRAY, Name.identifier("ushortArrayOf")), TuplesKt.to(UnsignedArrayType.UINTARRAY, Name.identifier("uintArrayOf")), TuplesKt.to(UnsignedArrayType.ULONGARRAY, Name.identifier("ulongArrayOf")));
    @NotNull
    private static final HashMap<ClassId, ClassId> unsignedClassIdToArrayClassId = new HashMap<>();
    @NotNull
    private static final Set<Name> unsignedTypeNames;

    static {
        UnsignedType[] values = UnsignedType.values();
        ArrayList arrayList = new ArrayList(values.length);
        for (UnsignedType typeName : values) {
            arrayList.add(typeName.getTypeName());
        }
        unsignedTypeNames = CollectionsKt___CollectionsKt.toSet(arrayList);
        UnsignedArrayType[] values2 = UnsignedArrayType.values();
        ArrayList arrayList2 = new ArrayList(values2.length);
        for (UnsignedArrayType typeName2 : values2) {
            arrayList2.add(typeName2.getTypeName());
        }
        unsignedArrayTypeNames = CollectionsKt___CollectionsKt.toSet(arrayList2);
        UnsignedType[] values3 = UnsignedType.values();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (UnsignedType arrayClassId : values3) {
            linkedHashSet.add(arrayClassId.getArrayClassId().getShortClassName());
        }
        arrayClassesShortNames = linkedHashSet;
        for (UnsignedType unsignedType : UnsignedType.values()) {
            arrayClassIdToUnsignedClassId.put(unsignedType.getArrayClassId(), unsignedType.getClassId());
            unsignedClassIdToArrayClassId.put(unsignedType.getClassId(), unsignedType.getArrayClassId());
        }
    }

    private UnsignedTypes() {
    }

    @JvmStatic
    public static final boolean isUnsignedType(@NotNull KotlinType kotlinType) {
        ClassifierDescriptor declarationDescriptor;
        Intrinsics.checkNotNullParameter(kotlinType, "type");
        if (!TypeUtils.noExpectedType(kotlinType) && (declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor()) != null) {
            return INSTANCE.isUnsignedClass(declarationDescriptor);
        }
        return false;
    }

    @Nullable
    public final ClassId getUnsignedClassIdByArrayClassId(@NotNull ClassId classId) {
        Intrinsics.checkNotNullParameter(classId, "arrayClassId");
        return arrayClassIdToUnsignedClassId.get(classId);
    }

    public final boolean isShortNameOfUnsignedArray(@NotNull Name name2) {
        Intrinsics.checkNotNullParameter(name2, "name");
        return arrayClassesShortNames.contains(name2);
    }

    public final boolean isUnsignedClass(@NotNull DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "descriptor");
        DeclarationDescriptor containingDeclaration = declarationDescriptor.getContainingDeclaration();
        if (!(containingDeclaration instanceof PackageFragmentDescriptor) || !Intrinsics.areEqual((Object) ((PackageFragmentDescriptor) containingDeclaration).getFqName(), (Object) StandardNames.BUILT_INS_PACKAGE_FQ_NAME) || !unsignedTypeNames.contains(declarationDescriptor.getName())) {
            return false;
        }
        return true;
    }
}
