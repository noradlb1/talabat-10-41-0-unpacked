package org.apache.commons.compress.archivers.dump;

import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;

public class InvalidFormatException extends DumpArchiveException {
    private static final long serialVersionUID = 1;
    protected long offset;

    public InvalidFormatException() {
        super("there was an error decoding a tape segment");
    }

    public long getOffset() {
        return this.offset;
    }

    public InvalidFormatException(long j11) {
        super("there was an error decoding a tape segment header at offset " + j11 + RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
        this.offset = j11;
    }
}
