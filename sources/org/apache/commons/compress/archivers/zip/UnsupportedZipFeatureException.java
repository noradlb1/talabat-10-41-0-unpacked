package org.apache.commons.compress.archivers.zip;

import java.io.Serializable;
import java.util.zip.ZipException;

public class UnsupportedZipFeatureException extends ZipException {
    private static final long serialVersionUID = 20161219;
    private final transient ZipArchiveEntry entry;
    private final Feature reason;

    public static class Feature implements Serializable {
        public static final Feature DATA_DESCRIPTOR = new Feature("data descriptor");
        public static final Feature ENCRYPTION = new Feature("encryption");
        public static final Feature METHOD = new Feature("compression method");
        public static final Feature SPLITTING = new Feature("splitting");
        public static final Feature UNKNOWN_COMPRESSED_SIZE = new Feature("unknown compressed size");
        private static final long serialVersionUID = 4112582948775420359L;

        /* renamed from: name  reason: collision with root package name */
        private final String f27655name;

        private Feature(String str) {
            this.f27655name = str;
        }

        public String toString() {
            return this.f27655name;
        }
    }

    public UnsupportedZipFeatureException(Feature feature, ZipArchiveEntry zipArchiveEntry) {
        super("Unsupported feature " + feature + " used in entry " + zipArchiveEntry.getName());
        this.reason = feature;
        this.entry = zipArchiveEntry;
    }

    public ZipArchiveEntry getEntry() {
        return this.entry;
    }

    public Feature getFeature() {
        return this.reason;
    }

    public UnsupportedZipFeatureException(ZipMethod zipMethod, ZipArchiveEntry zipArchiveEntry) {
        super("Unsupported compression method " + zipArchiveEntry.getMethod() + " (" + zipMethod.name() + ") used in entry " + zipArchiveEntry.getName());
        this.reason = Feature.METHOD;
        this.entry = zipArchiveEntry;
    }

    public UnsupportedZipFeatureException(Feature feature) {
        super("Unsupported feature " + feature + " used in archive.");
        this.reason = feature;
        this.entry = null;
    }
}
