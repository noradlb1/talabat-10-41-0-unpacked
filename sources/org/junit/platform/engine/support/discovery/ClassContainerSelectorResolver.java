package org.junit.platform.engine.support.discovery;

import j$.util.Collection;
import j$.util.function.Predicate;
import j$.util.stream.Collectors;
import java.util.List;
import java.util.Set;
import org.junit.platform.commons.support.ReflectionSupport;
import org.junit.platform.engine.DiscoverySelector;
import org.junit.platform.engine.discovery.ClassSelector;
import org.junit.platform.engine.discovery.ClasspathResourceSelector;
import org.junit.platform.engine.discovery.ClasspathRootSelector;
import org.junit.platform.engine.discovery.DirectorySelector;
import org.junit.platform.engine.discovery.FileSelector;
import org.junit.platform.engine.discovery.IterationSelector;
import org.junit.platform.engine.discovery.MethodSelector;
import org.junit.platform.engine.discovery.ModuleSelector;
import org.junit.platform.engine.discovery.NestedClassSelector;
import org.junit.platform.engine.discovery.NestedMethodSelector;
import org.junit.platform.engine.discovery.PackageSelector;
import org.junit.platform.engine.discovery.UniqueIdSelector;
import org.junit.platform.engine.discovery.UriSelector;
import org.junit.platform.engine.support.discovery.SelectorResolver;
import q30.a;
import q30.j;

class ClassContainerSelectorResolver implements SelectorResolver {
    private final Predicate<Class<?>> classFilter;
    private final Predicate<String> classNameFilter;

    public ClassContainerSelectorResolver(Predicate<Class<?>> predicate, Predicate<String> predicate2) {
        this.classFilter = predicate;
        this.classNameFilter = predicate2;
    }

    private SelectorResolver.Resolution classSelectors(List<Class<?>> list) {
        if (list.isEmpty()) {
            return SelectorResolver.Resolution.unresolved();
        }
        return SelectorResolver.Resolution.selectors((Set) Collection.EL.stream(list).map(new a()).collect(Collectors.toSet()));
    }

    public /* synthetic */ SelectorResolver.Resolution resolve(DiscoverySelector discoverySelector, SelectorResolver.Context context) {
        return j.a(this, discoverySelector, context);
    }

    public /* synthetic */ SelectorResolver.Resolution resolve(ClassSelector classSelector, SelectorResolver.Context context) {
        return j.b(this, classSelector, context);
    }

    public /* synthetic */ SelectorResolver.Resolution resolve(ClasspathResourceSelector classpathResourceSelector, SelectorResolver.Context context) {
        return j.c(this, classpathResourceSelector, context);
    }

    public SelectorResolver.Resolution resolve(ClasspathRootSelector classpathRootSelector, SelectorResolver.Context context) {
        return classSelectors(ReflectionSupport.findAllClassesInClasspathRoot(classpathRootSelector.getClasspathRoot(), this.classFilter, this.classNameFilter));
    }

    public /* synthetic */ SelectorResolver.Resolution resolve(DirectorySelector directorySelector, SelectorResolver.Context context) {
        return j.e(this, directorySelector, context);
    }

    public /* synthetic */ SelectorResolver.Resolution resolve(FileSelector fileSelector, SelectorResolver.Context context) {
        return j.f(this, fileSelector, context);
    }

    public /* synthetic */ SelectorResolver.Resolution resolve(IterationSelector iterationSelector, SelectorResolver.Context context) {
        return j.g(this, iterationSelector, context);
    }

    public /* synthetic */ SelectorResolver.Resolution resolve(MethodSelector methodSelector, SelectorResolver.Context context) {
        return j.h(this, methodSelector, context);
    }

    public /* synthetic */ SelectorResolver.Resolution resolve(NestedClassSelector nestedClassSelector, SelectorResolver.Context context) {
        return j.j(this, nestedClassSelector, context);
    }

    public /* synthetic */ SelectorResolver.Resolution resolve(NestedMethodSelector nestedMethodSelector, SelectorResolver.Context context) {
        return j.k(this, nestedMethodSelector, context);
    }

    public /* synthetic */ SelectorResolver.Resolution resolve(UniqueIdSelector uniqueIdSelector, SelectorResolver.Context context) {
        return j.m(this, uniqueIdSelector, context);
    }

    public /* synthetic */ SelectorResolver.Resolution resolve(UriSelector uriSelector, SelectorResolver.Context context) {
        return j.n(this, uriSelector, context);
    }

    public SelectorResolver.Resolution resolve(ModuleSelector moduleSelector, SelectorResolver.Context context) {
        return classSelectors(ReflectionSupport.findAllClassesInModule(moduleSelector.getModuleName(), this.classFilter, this.classNameFilter));
    }

    public SelectorResolver.Resolution resolve(PackageSelector packageSelector, SelectorResolver.Context context) {
        return classSelectors(ReflectionSupport.findAllClassesInPackage(packageSelector.getPackageName(), this.classFilter, this.classNameFilter));
    }
}
