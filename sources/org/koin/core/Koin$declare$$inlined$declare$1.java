package org.koin.core;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.BeanDefinitionKt;
import org.koin.core.definition.Kind;
import org.koin.core.instance.ScopedInstanceFactory;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.registry.InstanceRegistry;
import org.koin.core.scope.Scope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0000\u0018\u0001H\n¨\u0006\u0002"}, d2 = {"T", "", "org/koin/core/scope/Scope$declare$1", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class Koin$declare$$inlined$declare$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Scope f62696g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Object f62697h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Qualifier f62698i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ List f62699j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f62700k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Koin$declare$$inlined$declare$1(Scope scope, Object obj, Qualifier qualifier, List list, boolean z11) {
        super(0);
        this.f62696g = scope;
        this.f62697h = obj;
        this.f62698i = qualifier;
        this.f62699j = list;
        this.f62700k = z11;
    }

    public final void invoke() {
        InstanceRegistry instanceRegistry = this.f62696g.get_koin().getInstanceRegistry();
        final Object obj = this.f62697h;
        Qualifier qualifier = this.f62698i;
        List list = this.f62699j;
        boolean z11 = this.f62700k;
        Qualifier scopeQualifier = this.f62696g.getScopeQualifier();
        Kind kind = Kind.Scoped;
        Intrinsics.needClassReification();
        AnonymousClass1 r62 = new Function2<Scope, ParametersHolder, T>() {
            public final T invoke(@NotNull Scope scope, @NotNull ParametersHolder parametersHolder) {
                Intrinsics.checkNotNullParameter(scope, "$this$createDefinition");
                Intrinsics.checkNotNullParameter(parametersHolder, "it");
                return obj;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "T");
        BeanDefinition beanDefinition = new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, r62, kind, list);
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(beanDefinition);
        InstanceRegistry.saveMapping$default(instanceRegistry, z11, BeanDefinitionKt.indexKey(beanDefinition.getPrimaryType(), beanDefinition.getQualifier(), beanDefinition.getScopeQualifier()), scopedInstanceFactory, false, 8, (Object) null);
        for (KClass indexKey : beanDefinition.getSecondaryTypes()) {
            InstanceRegistry.saveMapping$default(instanceRegistry, z11, BeanDefinitionKt.indexKey(indexKey, beanDefinition.getQualifier(), beanDefinition.getScopeQualifier()), scopedInstanceFactory, false, 8, (Object) null);
        }
    }
}
