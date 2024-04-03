package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;

public final class BuiltInAnnotationDescriptor$type$2 extends Lambda implements Function0<SimpleType> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ BuiltInAnnotationDescriptor f24494g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BuiltInAnnotationDescriptor$type$2(BuiltInAnnotationDescriptor builtInAnnotationDescriptor) {
        super(0);
        this.f24494g = builtInAnnotationDescriptor;
    }

    @NotNull
    public final SimpleType invoke() {
        return this.f24494g.builtIns.getBuiltInClassByFqName(this.f24494g.getFqName()).getDefaultType();
    }
}
