package kotlin.reflect.jvm.internal.impl.types.error;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;

public final class ErrorClassDescriptor extends ClassDescriptorImpl {
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ErrorClassDescriptor(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.name.Name r21) {
        /*
            r20 = this;
            r9 = r20
            java.lang.String r0 = "name"
            r2 = r21
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils r10 = kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.INSTANCE
            kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor r1 = r10.getErrorModule()
            kotlin.reflect.jvm.internal.impl.descriptors.Modality r3 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.OPEN
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r4 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.CLASS
            java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            r5 = r0
            java.util.Collection r5 = (java.util.Collection) r5
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r11 = kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE
            r7 = 0
            kotlin.reflect.jvm.internal.impl.storage.StorageManager r8 = kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.NO_LOCKS
            r0 = r20
            r6 = r11
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations$Companion r0 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r0 = r0.getEMPTY()
            r1 = 1
            kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl r0 = kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl.create(r9, r0, r1, r11)
            java.util.List r2 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r3 = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.INTERNAL
            r0.initialize(r2, r3)
            java.lang.String r2 = "create(this, Annotations…          )\n            }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind r2 = kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind.SCOPE_FOR_ERROR_CLASS
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]
            kotlin.reflect.jvm.internal.impl.name.Name r4 = r0.getName()
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "errorConstructor.name.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            r5 = 0
            r3[r5] = r4
            java.lang.String r4 = ""
            r3[r1] = r4
            kotlin.reflect.jvm.internal.impl.types.error.ErrorScope r1 = kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.createErrorScope(r2, r3)
            kotlin.reflect.jvm.internal.impl.types.error.ErrorType r2 = new kotlin.reflect.jvm.internal.impl.types.error.ErrorType
            kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind r14 = kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind.ERROR_CLASS
            java.lang.String[] r3 = new java.lang.String[r5]
            kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeConstructor r12 = r10.createErrorTypeConstructor(r14, r3)
            r15 = 0
            r16 = 0
            java.lang.String[] r3 = new java.lang.String[r5]
            r18 = 24
            r19 = 0
            r11 = r2
            r13 = r1
            r17 = r3
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19)
            r0.setReturnType(r2)
            java.util.Set r2 = kotlin.collections.SetsKt__SetsJVMKt.setOf(r0)
            r9.initialize(r1, r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.error.ErrorClassDescriptor.<init>(kotlin.reflect.jvm.internal.impl.name.Name):void");
    }

    @NotNull
    public MemberScope getMemberScope(@NotNull TypeSubstitution typeSubstitution, @NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(typeSubstitution, "typeSubstitution");
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        ErrorScopeKind errorScopeKind = ErrorScopeKind.SCOPE_FOR_ERROR_CLASS;
        String name2 = getName().toString();
        Intrinsics.checkNotNullExpressionValue(name2, "name.toString()");
        return ErrorUtils.createErrorScope(errorScopeKind, name2, typeSubstitution.toString());
    }

    @NotNull
    public ClassDescriptor substitute(@NotNull TypeSubstitutor typeSubstitutor) {
        Intrinsics.checkNotNullParameter(typeSubstitutor, "substitutor");
        return this;
    }

    @NotNull
    public String toString() {
        String asString = getName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "name.asString()");
        return asString;
    }
}
