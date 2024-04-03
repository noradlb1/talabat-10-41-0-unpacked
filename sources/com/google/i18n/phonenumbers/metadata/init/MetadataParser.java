package com.google.i18n.phonenumbers.metadata.init;

import com.google.i18n.phonenumbers.Phonemetadata;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class MetadataParser {
    private static final Logger logger = Logger.getLogger(MetadataParser.class.getName());
    private final boolean strictMode;

    private MetadataParser(boolean z11) {
        this.strictMode = z11;
    }

    private void close(InputStream inputStream) {
        try {
            inputStream.close();
        } catch (IOException e11) {
            logger.log(Level.WARNING, "Error closing input stream (ignored)", e11);
        }
    }

    private List<Phonemetadata.PhoneMetadata> handleNullSource() {
        if (!this.strictMode) {
            return Collections.emptyList();
        }
        throw new IllegalArgumentException("Source cannot be null");
    }

    public static MetadataParser newLenientParser() {
        return new MetadataParser(false);
    }

    public static MetadataParser newStrictParser() {
        return new MetadataParser(true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0049  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Collection<com.google.i18n.phonenumbers.Phonemetadata.PhoneMetadata> parse(java.io.InputStream r6) {
        /*
            r5 = this;
            if (r6 != 0) goto L_0x0007
            java.util.List r6 = r5.handleNullSource()
            return r6
        L_0x0007:
            r0 = 0
            java.io.ObjectInputStream r1 = new java.io.ObjectInputStream     // Catch:{ IOException -> 0x0036, all -> 0x0031 }
            r1.<init>(r6)     // Catch:{ IOException -> 0x0036, all -> 0x0031 }
            com.google.i18n.phonenumbers.Phonemetadata$PhoneMetadataCollection r0 = new com.google.i18n.phonenumbers.Phonemetadata$PhoneMetadataCollection     // Catch:{ IOException -> 0x002f }
            r0.<init>()     // Catch:{ IOException -> 0x002f }
            r0.readExternal(r1)     // Catch:{ IOException -> 0x002f }
            java.util.List r2 = r0.getMetadataList()     // Catch:{ IOException -> 0x002f }
            boolean r2 = r2.isEmpty()     // Catch:{ IOException -> 0x002f }
            if (r2 != 0) goto L_0x0027
            java.util.List r6 = r0.getMetadataList()     // Catch:{ IOException -> 0x002f }
            r5.close(r1)
            return r6
        L_0x0027:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ IOException -> 0x002f }
            java.lang.String r2 = "Empty metadata"
            r0.<init>(r2)     // Catch:{ IOException -> 0x002f }
            throw r0     // Catch:{ IOException -> 0x002f }
        L_0x002f:
            r0 = move-exception
            goto L_0x003a
        L_0x0031:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L_0x0043
        L_0x0036:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x003a:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0042 }
            java.lang.String r3 = "Unable to parse metadata file"
            r2.<init>(r3, r0)     // Catch:{ all -> 0x0042 }
            throw r2     // Catch:{ all -> 0x0042 }
        L_0x0042:
            r0 = move-exception
        L_0x0043:
            if (r1 == 0) goto L_0x0049
            r5.close(r1)
            goto L_0x004c
        L_0x0049:
            r5.close(r6)
        L_0x004c:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.i18n.phonenumbers.metadata.init.MetadataParser.parse(java.io.InputStream):java.util.Collection");
    }
}
