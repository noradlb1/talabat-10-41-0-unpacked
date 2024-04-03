package g30;

import e30.c;
import j$.util.stream.Collectors;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.engine.extension.ExtensionRegistry;

public final /* synthetic */ class a {
    public static List a(ExtensionRegistry extensionRegistry, Class cls) {
        return (List) extensionRegistry.stream(cls).collect(Collectors.toCollection(new c()));
    }

    public static List b(ExtensionRegistry extensionRegistry, Class cls) {
        List extensions = extensionRegistry.getExtensions(cls);
        Collections.reverse(extensions);
        return extensions;
    }
}
