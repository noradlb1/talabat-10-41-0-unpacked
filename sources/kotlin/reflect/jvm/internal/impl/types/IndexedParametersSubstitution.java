package kotlin.reflect.jvm.internal.impl.types;

import com.tekartik.sqflite.Constant;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class IndexedParametersSubstitution extends TypeSubstitution {
    private final boolean approximateContravariantCapturedTypes;
    @NotNull
    private final TypeProjection[] arguments;
    @NotNull
    private final TypeParameterDescriptor[] parameters;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ IndexedParametersSubstitution(TypeParameterDescriptor[] typeParameterDescriptorArr, TypeProjection[] typeProjectionArr, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(typeParameterDescriptorArr, typeProjectionArr, (i11 & 4) != 0 ? false : z11);
    }

    public boolean approximateContravariantCapturedTypes() {
        return this.approximateContravariantCapturedTypes;
    }

    @Nullable
    public TypeProjection get(@NotNull KotlinType kotlinType) {
        TypeParameterDescriptor typeParameterDescriptor;
        Intrinsics.checkNotNullParameter(kotlinType, "key");
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor instanceof TypeParameterDescriptor) {
            typeParameterDescriptor = (TypeParameterDescriptor) declarationDescriptor;
        } else {
            typeParameterDescriptor = null;
        }
        if (typeParameterDescriptor == null) {
            return null;
        }
        int index = typeParameterDescriptor.getIndex();
        TypeParameterDescriptor[] typeParameterDescriptorArr = this.parameters;
        if (index >= typeParameterDescriptorArr.length || !Intrinsics.areEqual((Object) typeParameterDescriptorArr[index].getTypeConstructor(), (Object) typeParameterDescriptor.getTypeConstructor())) {
            return null;
        }
        return this.arguments[index];
    }

    @NotNull
    public final TypeProjection[] getArguments() {
        return this.arguments;
    }

    @NotNull
    public final TypeParameterDescriptor[] getParameters() {
        return this.parameters;
    }

    public boolean isEmpty() {
        return this.arguments.length == 0;
    }

    public IndexedParametersSubstitution(@NotNull TypeParameterDescriptor[] typeParameterDescriptorArr, @NotNull TypeProjection[] typeProjectionArr, boolean z11) {
        Intrinsics.checkNotNullParameter(typeParameterDescriptorArr, "parameters");
        Intrinsics.checkNotNullParameter(typeProjectionArr, Constant.PARAM_SQL_ARGUMENTS);
        this.parameters = typeParameterDescriptorArr;
        this.arguments = typeProjectionArr;
        this.approximateContravariantCapturedTypes = z11;
        int length = typeParameterDescriptorArr.length;
        int length2 = typeProjectionArr.length;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public IndexedParametersSubstitution(@org.jetbrains.annotations.NotNull java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> r9, @org.jetbrains.annotations.NotNull java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeProjection> r10) {
        /*
            r8 = this;
            java.lang.String r0 = "parameters"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "argumentsList"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.util.Collection r9 = (java.util.Collection) r9
            r0 = 0
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor[] r1 = new kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor[r0]
            java.lang.Object[] r9 = r9.toArray(r1)
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9, r1)
            r3 = r9
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor[] r3 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor[]) r3
            java.util.Collection r10 = (java.util.Collection) r10
            kotlin.reflect.jvm.internal.impl.types.TypeProjection[] r9 = new kotlin.reflect.jvm.internal.impl.types.TypeProjection[r0]
            java.lang.Object[] r9 = r10.toArray(r9)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9, r1)
            r4 = r9
            kotlin.reflect.jvm.internal.impl.types.TypeProjection[] r4 = (kotlin.reflect.jvm.internal.impl.types.TypeProjection[]) r4
            r5 = 0
            r6 = 4
            r7 = 0
            r2 = r8
            r2.<init>(r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.IndexedParametersSubstitution.<init>(java.util.List, java.util.List):void");
    }
}
