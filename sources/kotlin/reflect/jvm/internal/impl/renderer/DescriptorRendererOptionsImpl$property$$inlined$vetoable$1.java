package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

public final class DescriptorRendererOptionsImpl$property$$inlined$vetoable$1 extends ObservableProperty<T> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DescriptorRendererOptionsImpl f24787a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DescriptorRendererOptionsImpl$property$$inlined$vetoable$1(Object obj, DescriptorRendererOptionsImpl descriptorRendererOptionsImpl) {
        super(obj);
        this.f24787a = descriptorRendererOptionsImpl;
    }

    public boolean b(@NotNull KProperty<?> kProperty, T t11, T t12) {
        Intrinsics.checkNotNullParameter(kProperty, "property");
        if (!this.f24787a.isLocked()) {
            return true;
        }
        throw new IllegalStateException("Cannot modify readonly DescriptorRendererOptions");
    }
}
