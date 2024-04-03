package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import org.jetbrains.annotations.NotNull;

public final class StaticScopeForKotlinEnum$functions$2 extends Lambda implements Function0<List<? extends SimpleFunctionDescriptor>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ StaticScopeForKotlinEnum f24820g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StaticScopeForKotlinEnum$functions$2(StaticScopeForKotlinEnum staticScopeForKotlinEnum) {
        super(0);
        this.f24820g = staticScopeForKotlinEnum;
    }

    @NotNull
    public final List<SimpleFunctionDescriptor> invoke() {
        return CollectionsKt__CollectionsKt.listOf(DescriptorFactory.createEnumValueOfMethod(this.f24820g.containingClass), DescriptorFactory.createEnumValuesMethod(this.f24820g.containingClass));
    }
}
