package org.koin.core.scope;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.BeanDefinitionKt;
import org.koin.core.definition.Kind;
import org.koin.core.instance.ScopedInstanceFactory;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.registry.InstanceRegistry;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0000\u0018\u0001H\n"}, d2 = {"T", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class Scope$declare$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Scope f62742g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ T f62743h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Qualifier f62744i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ List<KClass<?>> f62745j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f62746k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Scope$declare$1(Scope scope, T t11, Qualifier qualifier, List<? extends KClass<?>> list, boolean z11) {
        super(0);
        this.f62742g = scope;
        this.f62743h = t11;
        this.f62744i = qualifier;
        this.f62745j = list;
        this.f62746k = z11;
    }

    public final void invoke() {
        InstanceRegistry instanceRegistry = this.f62742g.get_koin().getInstanceRegistry();
        T t11 = this.f62743h;
        Qualifier qualifier = this.f62744i;
        List<KClass<?>> list = this.f62745j;
        boolean z11 = this.f62746k;
        Qualifier scopeQualifier = this.f62742g.getScopeQualifier();
        Kind kind = Kind.Scoped;
        Intrinsics.needClassReification();
        Scope$declare$1$invoke$$inlined$declareInstance$1 scope$declare$1$invoke$$inlined$declareInstance$1 = new Scope$declare$1$invoke$$inlined$declareInstance$1(t11);
        Intrinsics.reifiedOperationMarker(4, "T");
        BeanDefinition beanDefinition = new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, scope$declare$1$invoke$$inlined$declareInstance$1, kind, list);
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(beanDefinition);
        InstanceRegistry.saveMapping$default(instanceRegistry, z11, BeanDefinitionKt.indexKey(beanDefinition.getPrimaryType(), beanDefinition.getQualifier(), beanDefinition.getScopeQualifier()), scopedInstanceFactory, false, 8, (Object) null);
        for (KClass indexKey : beanDefinition.getSecondaryTypes()) {
            InstanceRegistry.saveMapping$default(instanceRegistry, z11, BeanDefinitionKt.indexKey(indexKey, beanDefinition.getQualifier(), beanDefinition.getScopeQualifier()), scopedInstanceFactory, false, 8, (Object) null);
        }
    }
}
