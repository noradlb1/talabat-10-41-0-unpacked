package kotlin.reflect.jvm.internal.impl.load.java.components;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;

public final class JavaAnnotationDescriptor$type$2 extends Lambda implements Function0<SimpleType> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazyJavaResolverContext f24575g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ JavaAnnotationDescriptor f24576h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JavaAnnotationDescriptor$type$2(LazyJavaResolverContext lazyJavaResolverContext, JavaAnnotationDescriptor javaAnnotationDescriptor) {
        super(0);
        this.f24575g = lazyJavaResolverContext;
        this.f24576h = javaAnnotationDescriptor;
    }

    @NotNull
    public final SimpleType invoke() {
        SimpleType defaultType = this.f24575g.getModule().getBuiltIns().getBuiltInClassByFqName(this.f24576h.getFqName()).getDefaultType();
        Intrinsics.checkNotNullExpressionValue(defaultType, "c.module.builtIns.getBui…qName(fqName).defaultType");
        return defaultType;
    }
}
