package q30;

import org.apiguardian.api.API;
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

public final /* synthetic */ class j {
    public static SelectorResolver.Resolution a(SelectorResolver selectorResolver, DiscoverySelector discoverySelector, SelectorResolver.Context context) {
        return SelectorResolver.Resolution.unresolved();
    }

    public static SelectorResolver.Resolution b(SelectorResolver selectorResolver, ClassSelector classSelector, SelectorResolver.Context context) {
        return selectorResolver.resolve((DiscoverySelector) classSelector, context);
    }

    public static SelectorResolver.Resolution c(SelectorResolver selectorResolver, ClasspathResourceSelector classpathResourceSelector, SelectorResolver.Context context) {
        return selectorResolver.resolve((DiscoverySelector) classpathResourceSelector, context);
    }

    public static SelectorResolver.Resolution d(SelectorResolver selectorResolver, ClasspathRootSelector classpathRootSelector, SelectorResolver.Context context) {
        return selectorResolver.resolve((DiscoverySelector) classpathRootSelector, context);
    }

    public static SelectorResolver.Resolution e(SelectorResolver selectorResolver, DirectorySelector directorySelector, SelectorResolver.Context context) {
        return selectorResolver.resolve((DiscoverySelector) directorySelector, context);
    }

    public static SelectorResolver.Resolution f(SelectorResolver selectorResolver, FileSelector fileSelector, SelectorResolver.Context context) {
        return selectorResolver.resolve((DiscoverySelector) fileSelector, context);
    }

    @API(since = "1.9", status = API.Status.EXPERIMENTAL)
    public static SelectorResolver.Resolution g(SelectorResolver selectorResolver, IterationSelector iterationSelector, SelectorResolver.Context context) {
        return selectorResolver.resolve((DiscoverySelector) iterationSelector, context);
    }

    public static SelectorResolver.Resolution h(SelectorResolver selectorResolver, MethodSelector methodSelector, SelectorResolver.Context context) {
        return selectorResolver.resolve((DiscoverySelector) methodSelector, context);
    }

    public static SelectorResolver.Resolution i(SelectorResolver selectorResolver, ModuleSelector moduleSelector, SelectorResolver.Context context) {
        return selectorResolver.resolve((DiscoverySelector) moduleSelector, context);
    }

    public static SelectorResolver.Resolution j(SelectorResolver selectorResolver, NestedClassSelector nestedClassSelector, SelectorResolver.Context context) {
        return selectorResolver.resolve((DiscoverySelector) nestedClassSelector, context);
    }

    public static SelectorResolver.Resolution k(SelectorResolver selectorResolver, NestedMethodSelector nestedMethodSelector, SelectorResolver.Context context) {
        return selectorResolver.resolve((DiscoverySelector) nestedMethodSelector, context);
    }

    public static SelectorResolver.Resolution l(SelectorResolver selectorResolver, PackageSelector packageSelector, SelectorResolver.Context context) {
        return selectorResolver.resolve((DiscoverySelector) packageSelector, context);
    }

    public static SelectorResolver.Resolution m(SelectorResolver selectorResolver, UniqueIdSelector uniqueIdSelector, SelectorResolver.Context context) {
        return selectorResolver.resolve((DiscoverySelector) uniqueIdSelector, context);
    }

    public static SelectorResolver.Resolution n(SelectorResolver selectorResolver, UriSelector uriSelector, SelectorResolver.Context context) {
        return selectorResolver.resolve((DiscoverySelector) uriSelector, context);
    }
}
