package org.apache.commons.compress.archivers.examples;

import java.io.Closeable;
import java.io.IOException;
import l20.i;
import l20.j;

public interface CloseableConsumer {
    public static final CloseableConsumer CLOSING_CONSUMER = new i();
    public static final CloseableConsumer NULL_CONSUMER = new j();

    void accept(Closeable closeable) throws IOException;
}
