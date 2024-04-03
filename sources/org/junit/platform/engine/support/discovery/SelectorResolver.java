package org.junit.platform.engine.support.discovery;

import j$.util.Optional;
import j$.util.function.Function;
import j$.util.function.Supplier;
import java.util.Collections;
import java.util.Set;
import org.apiguardian.api.API;
import org.junit.platform.commons.util.Preconditions;
import org.junit.platform.engine.DiscoverySelector;
import org.junit.platform.engine.TestDescriptor;
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
import q30.k;

@API(since = "1.5", status = API.Status.EXPERIMENTAL)
public interface SelectorResolver {

    @API(since = "1.5", status = API.Status.EXPERIMENTAL)
    public interface Context {
        <T extends TestDescriptor> Optional<T> addToParent(Function<TestDescriptor, Optional<T>> function);

        <T extends TestDescriptor> Optional<T> addToParent(Supplier<DiscoverySelector> supplier, Function<TestDescriptor, Optional<T>> function);

        Optional<TestDescriptor> resolve(DiscoverySelector discoverySelector);
    }

    @API(since = "1.5", status = API.Status.EXPERIMENTAL)
    public static class Match {
        private final Supplier<Set<? extends DiscoverySelector>> childSelectorsSupplier;
        private final TestDescriptor testDescriptor;
        private final Type type;

        public enum Type {
            EXACT,
            PARTIAL
        }

        /* JADX WARNING: type inference failed for: r3v0, types: [java.lang.Object, j$.util.function.Supplier<java.util.Set<? extends org.junit.platform.engine.DiscoverySelector>>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private Match(org.junit.platform.engine.TestDescriptor r2, j$.util.function.Supplier<java.util.Set<? extends org.junit.platform.engine.DiscoverySelector>> r3, org.junit.platform.engine.support.discovery.SelectorResolver.Match.Type r4) {
            /*
                r1 = this;
                r1.<init>()
                java.lang.String r0 = "testDescriptor must not be null"
                java.lang.Object r2 = org.junit.platform.commons.util.Preconditions.notNull(r2, (java.lang.String) r0)
                org.junit.platform.engine.TestDescriptor r2 = (org.junit.platform.engine.TestDescriptor) r2
                r1.testDescriptor = r2
                java.lang.String r2 = "childSelectorsSupplier must not be null"
                java.lang.Object r2 = org.junit.platform.commons.util.Preconditions.notNull(r3, (java.lang.String) r2)
                j$.util.function.Supplier r2 = (j$.util.function.Supplier) r2
                r1.childSelectorsSupplier = r2
                r1.type = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.junit.platform.engine.support.discovery.SelectorResolver.Match.<init>(org.junit.platform.engine.TestDescriptor, j$.util.function.Supplier, org.junit.platform.engine.support.discovery.SelectorResolver$Match$Type):void");
        }

        public static Match exact(TestDescriptor testDescriptor2) {
            return exact(testDescriptor2, new k());
        }

        public static Match partial(TestDescriptor testDescriptor2) {
            return partial(testDescriptor2, new k());
        }

        public Set<? extends DiscoverySelector> expand() {
            return this.childSelectorsSupplier.get();
        }

        public TestDescriptor getTestDescriptor() {
            return this.testDescriptor;
        }

        public boolean isExact() {
            return this.type == Type.EXACT;
        }

        public static Match exact(TestDescriptor testDescriptor2, Supplier<Set<? extends DiscoverySelector>> supplier) {
            return new Match(testDescriptor2, supplier, Type.EXACT);
        }

        public static Match partial(TestDescriptor testDescriptor2, Supplier<Set<? extends DiscoverySelector>> supplier) {
            return new Match(testDescriptor2, supplier, Type.PARTIAL);
        }
    }

    @API(since = "1.5", status = API.Status.EXPERIMENTAL)
    public static class Resolution {
        private static final Resolution UNRESOLVED = new Resolution(Collections.emptySet(), Collections.emptySet());
        private final Set<Match> matches;
        private final Set<? extends DiscoverySelector> selectors;

        private Resolution(Set<Match> set, Set<? extends DiscoverySelector> set2) {
            this.matches = set;
            this.selectors = set2;
        }

        public static Resolution match(Match match) {
            return new Resolution(Collections.singleton(match), Collections.emptySet());
        }

        public static Resolution matches(Set<Match> set) {
            Preconditions.containsNoNullElements(set, "matches must not contain null elements");
            Preconditions.notEmpty(set, "matches must not be empty");
            return new Resolution(set, Collections.emptySet());
        }

        public static Resolution selectors(Set<? extends DiscoverySelector> set) {
            Preconditions.containsNoNullElements(set, "selectors must not contain null elements");
            Preconditions.notEmpty(set, "selectors must not be empty");
            return new Resolution(Collections.emptySet(), set);
        }

        public static Resolution unresolved() {
            return UNRESOLVED;
        }

        public Set<Match> getMatches() {
            return this.matches;
        }

        public Set<? extends DiscoverySelector> getSelectors() {
            return this.selectors;
        }

        public boolean isResolved() {
            return this != UNRESOLVED;
        }
    }

    Resolution resolve(DiscoverySelector discoverySelector, Context context);

    Resolution resolve(ClassSelector classSelector, Context context);

    Resolution resolve(ClasspathResourceSelector classpathResourceSelector, Context context);

    Resolution resolve(ClasspathRootSelector classpathRootSelector, Context context);

    Resolution resolve(DirectorySelector directorySelector, Context context);

    Resolution resolve(FileSelector fileSelector, Context context);

    @API(since = "1.9", status = API.Status.EXPERIMENTAL)
    Resolution resolve(IterationSelector iterationSelector, Context context);

    Resolution resolve(MethodSelector methodSelector, Context context);

    Resolution resolve(ModuleSelector moduleSelector, Context context);

    Resolution resolve(NestedClassSelector nestedClassSelector, Context context);

    Resolution resolve(NestedMethodSelector nestedMethodSelector, Context context);

    Resolution resolve(PackageSelector packageSelector, Context context);

    Resolution resolve(UniqueIdSelector uniqueIdSelector, Context context);

    Resolution resolve(UriSelector uriSelector, Context context);
}
