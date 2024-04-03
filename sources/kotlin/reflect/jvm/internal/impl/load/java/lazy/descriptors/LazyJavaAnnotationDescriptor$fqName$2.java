package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.Nullable;

public final class LazyJavaAnnotationDescriptor$fqName$2 extends Lambda implements Function0<FqName> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazyJavaAnnotationDescriptor f24601g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyJavaAnnotationDescriptor$fqName$2(LazyJavaAnnotationDescriptor lazyJavaAnnotationDescriptor) {
        super(0);
        this.f24601g = lazyJavaAnnotationDescriptor;
    }

    @Nullable
    public final FqName invoke() {
        ClassId classId = this.f24601g.javaAnnotation.getClassId();
        if (classId != null) {
            return classId.asSingleFqName();
        }
        return null;
    }
}
