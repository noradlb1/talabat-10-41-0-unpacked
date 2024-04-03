package org.apache.commons.compress.compressors.pack200;

import java.io.IOException;

public enum Pack200Strategy {
    IN_MEMORY {
        public StreamBridge newStreamBridge() {
            return new InMemoryCachingStreamBridge();
        }
    },
    TEMP_FILE {
        public StreamBridge newStreamBridge() throws IOException {
            return new TempFileCachingStreamBridge();
        }
    };

    public abstract StreamBridge newStreamBridge() throws IOException;
}
