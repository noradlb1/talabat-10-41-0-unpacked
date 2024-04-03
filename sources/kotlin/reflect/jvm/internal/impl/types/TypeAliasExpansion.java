package kotlin.reflect.jvm.internal.impl.types;

import com.tekartik.sqflite.Constant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TypeAliasExpansion {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final List<TypeProjection> arguments;
    @NotNull
    private final TypeAliasDescriptor descriptor;
    @NotNull
    private final Map<TypeParameterDescriptor, TypeProjection> mapping;
    @Nullable
    private final TypeAliasExpansion parent;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final TypeAliasExpansion create(@Nullable TypeAliasExpansion typeAliasExpansion, @NotNull TypeAliasDescriptor typeAliasDescriptor, @NotNull List<? extends TypeProjection> list) {
            Intrinsics.checkNotNullParameter(typeAliasDescriptor, "typeAliasDescriptor");
            Intrinsics.checkNotNullParameter(list, Constant.PARAM_SQL_ARGUMENTS);
            List<TypeParameterDescriptor> parameters = typeAliasDescriptor.getTypeConstructor().getParameters();
            Intrinsics.checkNotNullExpressionValue(parameters, "typeAliasDescriptor.typeConstructor.parameters");
            Iterable<TypeParameterDescriptor> iterable = parameters;
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
            for (TypeParameterDescriptor original : iterable) {
                arrayList.add(original.getOriginal());
            }
            return new TypeAliasExpansion(typeAliasExpansion, typeAliasDescriptor, list, MapsKt__MapsKt.toMap(CollectionsKt___CollectionsKt.zip(arrayList, list)), (DefaultConstructorMarker) null);
        }
    }

    private TypeAliasExpansion(TypeAliasExpansion typeAliasExpansion, TypeAliasDescriptor typeAliasDescriptor, List<? extends TypeProjection> list, Map<TypeParameterDescriptor, ? extends TypeProjection> map) {
        this.parent = typeAliasExpansion;
        this.descriptor = typeAliasDescriptor;
        this.arguments = list;
        this.mapping = map;
    }

    public /* synthetic */ TypeAliasExpansion(TypeAliasExpansion typeAliasExpansion, TypeAliasDescriptor typeAliasDescriptor, List list, Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(typeAliasExpansion, typeAliasDescriptor, list, map);
    }

    @NotNull
    public final List<TypeProjection> getArguments() {
        return this.arguments;
    }

    @NotNull
    public final TypeAliasDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Nullable
    public final TypeProjection getReplacement(@NotNull TypeConstructor typeConstructor) {
        Intrinsics.checkNotNullParameter(typeConstructor, "constructor");
        ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor();
        if (declarationDescriptor instanceof TypeParameterDescriptor) {
            return this.mapping.get(declarationDescriptor);
        }
        return null;
    }

    public final boolean isRecursion(@NotNull TypeAliasDescriptor typeAliasDescriptor) {
        boolean z11;
        Intrinsics.checkNotNullParameter(typeAliasDescriptor, "descriptor");
        if (!Intrinsics.areEqual((Object) this.descriptor, (Object) typeAliasDescriptor)) {
            TypeAliasExpansion typeAliasExpansion = this.parent;
            if (typeAliasExpansion != null) {
                z11 = typeAliasExpansion.isRecursion(typeAliasDescriptor);
            } else {
                z11 = false;
            }
            if (z11) {
                return true;
            }
            return false;
        }
        return true;
    }
}
