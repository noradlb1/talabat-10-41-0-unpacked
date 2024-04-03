package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
@J2ktIncompatible
class MultiReader extends Reader {
    @CheckForNull
    private Reader current;
    private final Iterator<? extends CharSource> it;

    public MultiReader(Iterator<? extends CharSource> it2) throws IOException {
        this.it = it2;
        advance();
    }

    private void advance() throws IOException {
        close();
        if (this.it.hasNext()) {
            this.current = ((CharSource) this.it.next()).openStream();
        }
    }

    public void close() throws IOException {
        Reader reader = this.current;
        if (reader != null) {
            try {
                reader.close();
            } finally {
                this.current = null;
            }
        }
    }

    public int read(char[] cArr, int i11, int i12) throws IOException {
        Preconditions.checkNotNull(cArr);
        Reader reader = this.current;
        if (reader == null) {
            return -1;
        }
        int read = reader.read(cArr, i11, i12);
        if (read != -1) {
            return read;
        }
        advance();
        return read(cArr, i11, i12);
    }

    public boolean ready() throws IOException {
        Reader reader = this.current;
        return reader != null && reader.ready();
    }

    public long skip(long j11) throws IOException {
        boolean z11;
        int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
        if (i11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "n is negative");
        if (i11 > 0) {
            while (true) {
                Reader reader = this.current;
                if (reader == null) {
                    break;
                }
                long skip = reader.skip(j11);
                if (skip > 0) {
                    return skip;
                }
                advance();
            }
        }
        return 0;
    }
}
