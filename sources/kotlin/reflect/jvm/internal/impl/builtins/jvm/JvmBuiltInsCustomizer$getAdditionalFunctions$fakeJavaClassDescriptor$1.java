package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor;
import org.jetbrains.annotations.NotNull;

public final class JvmBuiltInsCustomizer$getAdditionalFunctions$fakeJavaClassDescriptor$1 extends Lambda implements Function0<ClassDescriptor> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazyJavaClassDescriptor f24475g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ClassDescriptor f24476h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JvmBuiltInsCustomizer$getAdditionalFunctions$fakeJavaClassDescriptor$1(LazyJavaClassDescriptor lazyJavaClassDescriptor, ClassDescriptor classDescriptor) {
        super(0);
        this.f24475g = lazyJavaClassDescriptor;
        this.f24476h = classDescriptor;
    }

    @NotNull
    public final ClassDescriptor invoke() {
        LazyJavaClassDescriptor lazyJavaClassDescriptor = this.f24475g;
        JavaResolverCache javaResolverCache = JavaResolverCache.EMPTY;
        Intrinsics.checkNotNullExpressionValue(javaResolverCache, "EMPTY");
        return lazyJavaClassDescriptor.copy$descriptors_jvm(javaResolverCache, this.f24476h);
    }
}
