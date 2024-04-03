package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.NotNull;

public final class AbstractTypeAliasDescriptor$typeConstructor$1 implements TypeConstructor {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AbstractTypeAliasDescriptor f24504a;

    public AbstractTypeAliasDescriptor$typeConstructor$1(AbstractTypeAliasDescriptor abstractTypeAliasDescriptor) {
        this.f24504a = abstractTypeAliasDescriptor;
    }

    @NotNull
    public KotlinBuiltIns getBuiltIns() {
        return DescriptorUtilsKt.getBuiltIns(getDeclarationDescriptor());
    }

    @NotNull
    public List<TypeParameterDescriptor> getParameters() {
        return this.f24504a.b();
    }

    @NotNull
    public Collection<KotlinType> getSupertypes() {
        Collection<KotlinType> supertypes = getDeclarationDescriptor().getUnderlyingType().getConstructor().getSupertypes();
        Intrinsics.checkNotNullExpressionValue(supertypes, "declarationDescriptor.un…pe.constructor.supertypes");
        return supertypes;
    }

    public boolean isDenotable() {
        return true;
    }

    @NotNull
    public TypeConstructor refine(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    @NotNull
    public String toString() {
        return "[typealias " + getDeclarationDescriptor().getName().asString() + AbstractJsonLexerKt.END_LIST;
    }

    @NotNull
    public TypeAliasDescriptor getDeclarationDescriptor() {
        return this.f24504a;
    }
}
