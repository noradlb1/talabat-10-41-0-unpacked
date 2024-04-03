package org.junit.jupiter.engine.extension;

import j$.util.stream.Stream;
import java.util.List;
import org.apiguardian.api.API;
import org.junit.jupiter.api.extension.Extension;

@API(since = "5.0", status = API.Status.INTERNAL)
public interface ExtensionRegistry {
    <E extends Extension> List<E> getExtensions(Class<E> cls);

    <E extends Extension> List<E> getReversedExtensions(Class<E> cls);

    <E extends Extension> Stream<E> stream(Class<E> cls);
}
