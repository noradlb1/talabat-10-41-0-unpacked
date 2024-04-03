package org.junit.jupiter.engine.descriptor;

import j$.util.function.Supplier;
import java.net.URI;
import org.junit.platform.commons.util.Preconditions;
import org.junit.platform.commons.util.ReflectionUtils;
import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.engine.support.descriptor.MethodSource;

class MethodSourceSupport {
    public static MethodSource d(URI uri) {
        Preconditions.notNull(uri, "URI must not be null");
        Preconditions.condition("method".equals(uri.getScheme()), (Supplier<String>) new a0(uri));
        String[] parseFullyQualifiedMethodName = ReflectionUtils.parseFullyQualifiedMethodName(((String) Preconditions.notNull(uri.getSchemeSpecificPart(), (Supplier<String>) new b0())) + "#" + ((String) Preconditions.notNull(uri.getFragment(), (Supplier<String>) new c0())));
        return MethodSource.from(parseFullyQualifiedMethodName[0], parseFullyQualifiedMethodName[1], parseFullyQualifiedMethodName[2]);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String lambda$from$0(URI uri) {
        return "URI [" + uri + "] must have [" + "method" + "] scheme";
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String lambda$from$1() {
        return "Invalid method URI (scheme-specific part must not be null). Please consult the Javadoc of " + DiscoverySelectors.class.getName() + "#selectMethod(String) for details on the supported formats.";
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String lambda$from$2() {
        return "Invalid method URI (fragment must not be null). Please consult the Javadoc of " + DiscoverySelectors.class.getName() + "#selectMethod(String) for details on the supported formats.";
    }
}
