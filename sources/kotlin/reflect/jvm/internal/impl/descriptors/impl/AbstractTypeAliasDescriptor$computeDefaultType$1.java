package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

public final class AbstractTypeAliasDescriptor$computeDefaultType$1 extends Lambda implements Function1<KotlinTypeRefiner, SimpleType> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AbstractTypeAliasDescriptor f24502g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AbstractTypeAliasDescriptor$computeDefaultType$1(AbstractTypeAliasDescriptor abstractTypeAliasDescriptor) {
        super(1);
        this.f24502g = abstractTypeAliasDescriptor;
    }

    public final SimpleType invoke(KotlinTypeRefiner kotlinTypeRefiner) {
        ClassifierDescriptor refineDescriptor = kotlinTypeRefiner.refineDescriptor(this.f24502g);
        if (refineDescriptor != null) {
            return refineDescriptor.getDefaultType();
        }
        return null;
    }
}
