package l20;

import java.io.Closeable;
import org.apache.commons.compress.archivers.examples.CloseableConsumer;

public final /* synthetic */ class i implements CloseableConsumer {
    public final void accept(Closeable closeable) {
        closeable.close();
    }
}
