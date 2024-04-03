package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.Nullable;

public final class LazyJavaScope$resolveProperty$1 extends Lambda implements Function0<NullableLazyValue<? extends ConstantValue<?>>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazyJavaScope f24641g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ JavaField f24642h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ PropertyDescriptorImpl f24643i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyJavaScope$resolveProperty$1(LazyJavaScope lazyJavaScope, JavaField javaField, PropertyDescriptorImpl propertyDescriptorImpl) {
        super(0);
        this.f24641g = lazyJavaScope;
        this.f24642h = javaField;
        this.f24643i = propertyDescriptorImpl;
    }

    public final NullableLazyValue<ConstantValue<?>> invoke() {
        StorageManager storageManager = this.f24641g.i().getStorageManager();
        final LazyJavaScope lazyJavaScope = this.f24641g;
        final JavaField javaField = this.f24642h;
        final PropertyDescriptorImpl propertyDescriptorImpl = this.f24643i;
        return storageManager.createNullableLazyValue(new Function0<ConstantValue<?>>() {
            @Nullable
            public final ConstantValue<?> invoke() {
                return lazyJavaScope.i().getComponents().getJavaPropertyInitializerEvaluator().getInitializerConstant(javaField, propertyDescriptorImpl);
            }
        });
    }
}
