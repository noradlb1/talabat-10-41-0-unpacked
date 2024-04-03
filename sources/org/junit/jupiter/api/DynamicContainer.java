package org.junit.jupiter.api;

import j$.lang.Iterable;
import j$.util.stream.Stream;
import j$.util.stream.StreamSupport;
import java.net.URI;
import org.apiguardian.api.API;
import org.junit.platform.commons.util.Preconditions;

@API(since = "5.3", status = API.Status.MAINTAINED)
public class DynamicContainer extends DynamicNode {
    private final Stream<? extends DynamicNode> children;

    private DynamicContainer(String str, URI uri, Stream<? extends DynamicNode> stream) {
        super(str, uri);
        Preconditions.notNull(stream, "children must not be null");
        this.children = stream;
    }

    public static DynamicContainer dynamicContainer(String str, Iterable<? extends DynamicNode> iterable) {
        return dynamicContainer(str, (URI) null, StreamSupport.stream(Iterable.EL.spliterator(iterable), false));
    }

    public Stream<? extends DynamicNode> getChildren() {
        return this.children;
    }

    public static DynamicContainer dynamicContainer(String str, Stream<? extends DynamicNode> stream) {
        return dynamicContainer(str, (URI) null, stream);
    }

    public static DynamicContainer dynamicContainer(String str, URI uri, Stream<? extends DynamicNode> stream) {
        return new DynamicContainer(str, uri, stream);
    }
}
