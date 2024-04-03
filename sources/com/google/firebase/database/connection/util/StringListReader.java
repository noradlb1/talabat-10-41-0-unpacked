package com.google.firebase.database.connection.util;

import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;

public class StringListReader extends Reader {
    private int charPos;
    private boolean closed;
    private boolean frozen;
    private int markedCharPos;
    private int markedStringListPos;
    private int stringListPos;
    private List<String> strings;

    public StringListReader() {
        this.strings = null;
        this.closed = false;
        this.markedCharPos = this.charPos;
        this.markedStringListPos = this.stringListPos;
        this.frozen = false;
        this.strings = new ArrayList();
    }

    private long advance(long j11) {
        long j12 = 0;
        while (this.stringListPos < this.strings.size() && j12 < j11) {
            long j13 = j11 - j12;
            long currentStringRemainingChars = (long) currentStringRemainingChars();
            if (j13 < currentStringRemainingChars) {
                this.charPos = (int) (((long) this.charPos) + j13);
                j12 += j13;
            } else {
                j12 += currentStringRemainingChars;
                this.charPos = 0;
                this.stringListPos++;
            }
        }
        return j12;
    }

    private void checkState() throws IOException {
        if (this.closed) {
            throw new IOException("Stream already closed");
        } else if (!this.frozen) {
            throw new IOException("Reader needs to be frozen before read operations can be called");
        }
    }

    private String currentString() {
        if (this.stringListPos < this.strings.size()) {
            return this.strings.get(this.stringListPos);
        }
        return null;
    }

    private int currentStringRemainingChars() {
        String currentString = currentString();
        if (currentString == null) {
            return 0;
        }
        return currentString.length() - this.charPos;
    }

    public void addString(String str) {
        if (this.frozen) {
            throw new IllegalStateException("Trying to add string after reading");
        } else if (str.length() > 0) {
            this.strings.add(str);
        }
    }

    public void close() throws IOException {
        checkState();
        this.closed = true;
    }

    public void freeze() {
        if (!this.frozen) {
            this.frozen = true;
            return;
        }
        throw new IllegalStateException("Trying to freeze frozen StringListReader");
    }

    public void mark(int i11) throws IOException {
        checkState();
        this.markedCharPos = this.charPos;
        this.markedStringListPos = this.stringListPos;
    }

    public boolean markSupported() {
        return true;
    }

    public int read(CharBuffer charBuffer) throws IOException {
        checkState();
        int remaining = charBuffer.remaining();
        String currentString = currentString();
        int i11 = 0;
        while (remaining > 0 && currentString != null) {
            int min = Math.min(currentString.length() - this.charPos, remaining);
            int i12 = this.charPos;
            charBuffer.put(this.strings.get(this.stringListPos), i12, i12 + min);
            remaining -= min;
            i11 += min;
            advance((long) min);
            currentString = currentString();
        }
        if (i11 > 0 || currentString != null) {
            return i11;
        }
        return -1;
    }

    public boolean ready() throws IOException {
        checkState();
        return true;
    }

    public void reset() throws IOException {
        this.charPos = this.markedCharPos;
        this.stringListPos = this.markedStringListPos;
    }

    public long skip(long j11) throws IOException {
        checkState();
        return advance(j11);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        for (String append : this.strings) {
            sb2.append(append);
        }
        return sb2.toString();
    }

    public int read() throws IOException {
        checkState();
        String currentString = currentString();
        if (currentString == null) {
            return -1;
        }
        char charAt = currentString.charAt(this.charPos);
        advance(1);
        return charAt;
    }

    public int read(char[] cArr, int i11, int i12) throws IOException {
        checkState();
        String currentString = currentString();
        int i13 = 0;
        while (currentString != null && i13 < i12) {
            int min = Math.min(currentStringRemainingChars(), i12 - i13);
            int i14 = this.charPos;
            currentString.getChars(i14, i14 + min, cArr, i11 + i13);
            i13 += min;
            advance((long) min);
            currentString = currentString();
        }
        if (i13 > 0 || currentString != null) {
            return i13;
        }
        return -1;
    }
}
