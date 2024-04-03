package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType;
import org.jetbrains.annotations.Nullable;

public final class ContextKt$copyWithNewDefaultTypeQualifiers$1 extends Lambda implements Function0<JavaTypeQualifiersByElementType> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazyJavaResolverContext f24584g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Annotations f24585h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContextKt$copyWithNewDefaultTypeQualifiers$1(LazyJavaResolverContext lazyJavaResolverContext, Annotations annotations) {
        super(0);
        this.f24584g = lazyJavaResolverContext;
        this.f24585h = annotations;
    }

    @Nullable
    public final JavaTypeQualifiersByElementType invoke() {
        return ContextKt.computeNewDefaultTypeQualifiers(this.f24584g, this.f24585h);
    }
}
