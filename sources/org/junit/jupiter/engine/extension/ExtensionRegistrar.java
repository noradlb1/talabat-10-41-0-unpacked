package org.junit.jupiter.engine.extension;

import org.apiguardian.api.API;
import org.junit.jupiter.api.extension.Extension;

@API(since = "5.5", status = API.Status.INTERNAL)
public interface ExtensionRegistrar {
    void registerExtension(Class<? extends Extension> cls);

    void registerExtension(Extension extension, Object obj);

    void registerSyntheticExtension(Extension extension, Object obj);
}
