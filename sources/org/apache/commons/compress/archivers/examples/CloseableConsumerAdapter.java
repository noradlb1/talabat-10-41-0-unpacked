package org.apache.commons.compress.archivers.examples;

import java.io.Closeable;
import java.io.IOException;
import java.util.Objects;

final class CloseableConsumerAdapter implements Closeable {
    private Closeable closeable;
    private final CloseableConsumer consumer;

    public CloseableConsumerAdapter(CloseableConsumer closeableConsumer) {
        Objects.requireNonNull(closeableConsumer, "consumer");
        this.consumer = closeableConsumer;
    }

    public <C extends Closeable> C a(C c11) {
        this.closeable = c11;
        return c11;
    }

    public void close() throws IOException {
        Closeable closeable2 = this.closeable;
        if (closeable2 != null) {
            this.consumer.accept(closeable2);
        }
    }
}
