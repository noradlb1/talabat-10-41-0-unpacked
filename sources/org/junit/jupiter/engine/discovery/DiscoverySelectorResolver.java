package org.junit.jupiter.engine.discovery;

import e30.j;
import e30.k;
import e30.l;
import e30.m;
import e30.n;
import e30.o;
import org.apiguardian.api.API;
import org.junit.jupiter.engine.descriptor.JupiterEngineDescriptor;
import org.junit.jupiter.engine.discovery.predicates.IsTestClassWithTests;
import org.junit.platform.engine.EngineDiscoveryRequest;
import org.junit.platform.engine.TestDescriptor;
import org.junit.platform.engine.support.discovery.EngineDiscoveryRequestResolver;
import org.junit.platform.engine.support.discovery.SelectorResolver;

@API(since = "5.0", status = API.Status.INTERNAL)
public class DiscoverySelectorResolver {
    private static final EngineDiscoveryRequestResolver<JupiterEngineDescriptor> resolver = EngineDiscoveryRequestResolver.builder().addClassContainerSelectorResolver(new IsTestClassWithTests()).addSelectorResolver(new k()).addSelectorResolver(new l()).addTestDescriptorVisitor(new m()).addTestDescriptorVisitor(new n()).addTestDescriptorVisitor(new o()).build();

    /* access modifiers changed from: private */
    public static /* synthetic */ SelectorResolver lambda$static$0(EngineDiscoveryRequestResolver.InitializationContext initializationContext) {
        return new ClassSelectorResolver(initializationContext.getClassNameFilter(), ((JupiterEngineDescriptor) initializationContext.getEngineDescriptor()).getConfiguration());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ SelectorResolver lambda$static$1(EngineDiscoveryRequestResolver.InitializationContext initializationContext) {
        return new MethodSelectorResolver(((JupiterEngineDescriptor) initializationContext.getEngineDescriptor()).getConfiguration());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ TestDescriptor.Visitor lambda$static$2(EngineDiscoveryRequestResolver.InitializationContext initializationContext) {
        return new ClassOrderingVisitor(((JupiterEngineDescriptor) initializationContext.getEngineDescriptor()).getConfiguration());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ TestDescriptor.Visitor lambda$static$3(EngineDiscoveryRequestResolver.InitializationContext initializationContext) {
        return new MethodOrderingVisitor(((JupiterEngineDescriptor) initializationContext.getEngineDescriptor()).getConfiguration());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ TestDescriptor.Visitor lambda$static$4(EngineDiscoveryRequestResolver.InitializationContext initializationContext) {
        return new j();
    }

    public void resolveSelectors(EngineDiscoveryRequest engineDiscoveryRequest, JupiterEngineDescriptor jupiterEngineDescriptor) {
        resolver.resolve(engineDiscoveryRequest, jupiterEngineDescriptor);
    }
}
