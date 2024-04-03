package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class RawSubstitution$eraseInflexibleBasedOnClassDescriptor$2 extends Lambda implements Function1<KotlinTypeRefiner, SimpleType> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ClassDescriptor f24658g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ RawSubstitution f24659h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SimpleType f24660i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ JavaTypeAttributes f24661j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RawSubstitution$eraseInflexibleBasedOnClassDescriptor$2(ClassDescriptor classDescriptor, RawSubstitution rawSubstitution, SimpleType simpleType, JavaTypeAttributes javaTypeAttributes) {
        super(1);
        this.f24658g = classDescriptor;
        this.f24659h = rawSubstitution;
        this.f24660i = simpleType;
        this.f24661j = javaTypeAttributes;
    }

    @Nullable
    public final SimpleType invoke(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        ClassId classId;
        ClassDescriptor findClassAcrossModuleDependencies;
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        ClassDescriptor classDescriptor = this.f24658g;
        if (!(classDescriptor instanceof ClassDescriptor)) {
            classDescriptor = null;
        }
        if (classDescriptor == null || (classId = DescriptorUtilsKt.getClassId(classDescriptor)) == null || (findClassAcrossModuleDependencies = kotlinTypeRefiner.findClassAcrossModuleDependencies(classId)) == null || Intrinsics.areEqual((Object) findClassAcrossModuleDependencies, (Object) this.f24658g)) {
            return null;
        }
        return (SimpleType) this.f24659h.eraseInflexibleBasedOnClassDescriptor(this.f24660i, findClassAcrossModuleDependencies, this.f24661j).getFirst();
    }
}
