package org.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import org.apache.commons.lang3.CharUtils;

public class JSONTokener {
    private long character;
    private long characterPreviousLine;
    private boolean eof;
    private long index;
    private long line;
    private char previous;
    private final Reader reader;
    private boolean usePrevious;

    public JSONTokener(Reader reader2) {
        this.reader = !reader2.markSupported() ? new BufferedReader(reader2) : reader2;
        this.eof = false;
        this.usePrevious = false;
        this.previous = 0;
        this.index = 0;
        this.character = 1;
        this.characterPreviousLine = 0;
        this.line = 1;
    }

    private void decrementIndexes() {
        this.index--;
        char c11 = this.previous;
        if (c11 == 13 || c11 == 10) {
            this.line--;
            this.character = this.characterPreviousLine;
            return;
        }
        long j11 = this.character;
        if (j11 > 0) {
            this.character = j11 - 1;
        }
    }

    public static int dehexchar(char c11) {
        if (c11 >= '0' && c11 <= '9') {
            return c11 - '0';
        }
        if (c11 >= 'A' && c11 <= 'F') {
            return c11 - '7';
        }
        if (c11 < 'a' || c11 > 'f') {
            return -1;
        }
        return c11 - 'W';
    }

    private void incrementIndexes(int i11) {
        if (i11 > 0) {
            this.index++;
            if (i11 == 13) {
                this.line++;
                this.characterPreviousLine = this.character;
                this.character = 0;
            } else if (i11 == 10) {
                if (this.previous != 13) {
                    this.line++;
                    this.characterPreviousLine = this.character;
                }
                this.character = 0;
            } else {
                this.character++;
            }
        }
    }

    public void back() throws JSONException {
        if (this.usePrevious || this.index <= 0) {
            throw new JSONException("Stepping back two steps is not supported");
        }
        decrementIndexes();
        this.usePrevious = true;
        this.eof = false;
    }

    public boolean end() {
        return this.eof && !this.usePrevious;
    }

    public boolean more() throws JSONException {
        if (this.usePrevious) {
            return true;
        }
        try {
            this.reader.mark(1);
            try {
                if (this.reader.read() <= 0) {
                    this.eof = true;
                    return false;
                }
                this.reader.reset();
                return true;
            } catch (IOException e11) {
                throw new JSONException("Unable to read the next character from the stream", e11);
            }
        } catch (IOException e12) {
            throw new JSONException("Unable to preserve stream position", e12);
        }
    }

    public char next() throws JSONException {
        int i11;
        if (this.usePrevious) {
            this.usePrevious = false;
            i11 = this.previous;
        } else {
            try {
                i11 = this.reader.read();
            } catch (IOException e11) {
                throw new JSONException((Throwable) e11);
            }
        }
        if (i11 <= 0) {
            this.eof = true;
            return 0;
        }
        incrementIndexes(i11);
        char c11 = (char) i11;
        this.previous = c11;
        return c11;
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public char nextClean() throws org.json.JSONException {
        /*
            r2 = this;
        L_0x0000:
            char r0 = r2.next()
            if (r0 == 0) goto L_0x000a
            r1 = 32
            if (r0 <= r1) goto L_0x0000
        L_0x000a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.json.JSONTokener.nextClean():char");
    }

    public String nextString(char c11) throws JSONException {
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            char next = next();
            if (next != 0 && next != 10 && next != 13) {
                if (next == '\\') {
                    char next2 = next();
                    if (next2 == '\"' || next2 == '\'' || next2 == '/' || next2 == '\\') {
                        sb2.append(next2);
                    } else if (next2 == 'b') {
                        sb2.append(8);
                    } else if (next2 == 'f') {
                        sb2.append(12);
                    } else if (next2 == 'n') {
                        sb2.append(10);
                    } else if (next2 == 'r') {
                        sb2.append(CharUtils.CR);
                    } else if (next2 == 't') {
                        sb2.append(9);
                    } else if (next2 == 'u') {
                        try {
                            sb2.append((char) Integer.parseInt(next(4), 16));
                        } catch (NumberFormatException e11) {
                            throw syntaxError("Illegal escape.", e11);
                        }
                    } else {
                        throw syntaxError("Illegal escape.");
                    }
                } else if (next == c11) {
                    return sb2.toString();
                } else {
                    sb2.append(next);
                }
            }
        }
        throw syntaxError("Unterminated string");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String nextTo(char r4) throws org.json.JSONException {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
        L_0x0005:
            char r1 = r3.next()
            if (r1 == r4) goto L_0x001a
            if (r1 == 0) goto L_0x001a
            r2 = 10
            if (r1 == r2) goto L_0x001a
            r2 = 13
            if (r1 != r2) goto L_0x0016
            goto L_0x001a
        L_0x0016:
            r0.append(r1)
            goto L_0x0005
        L_0x001a:
            if (r1 == 0) goto L_0x001f
            r3.back()
        L_0x001f:
            java.lang.String r4 = r0.toString()
            java.lang.String r4 = r4.trim()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.json.JSONTokener.nextTo(char):java.lang.String");
    }

    public Object nextValue() throws JSONException {
        char nextClean = nextClean();
        if (nextClean == '\"' || nextClean == '\'') {
            return nextString(nextClean);
        }
        if (nextClean == '[') {
            back();
            return new JSONArray(this);
        } else if (nextClean != '{') {
            StringBuilder sb2 = new StringBuilder();
            while (nextClean >= ' ' && ",:]}/\\\"[{;=#".indexOf(nextClean) < 0) {
                sb2.append(nextClean);
                nextClean = next();
            }
            back();
            String trim = sb2.toString().trim();
            if (!"".equals(trim)) {
                return JSONObject.stringToValue(trim);
            }
            throw syntaxError("Missing value");
        } else {
            back();
            return new JSONObject(this);
        }
    }

    public char skipTo(char c11) throws JSONException {
        char next;
        try {
            long j11 = this.index;
            long j12 = this.character;
            long j13 = this.line;
            this.reader.mark(1000000);
            do {
                next = next();
                if (next == 0) {
                    this.reader.reset();
                    this.index = j11;
                    this.character = j12;
                    this.line = j13;
                    return 0;
                }
            } while (next != c11);
            this.reader.mark(1);
            back();
            return next;
        } catch (IOException e11) {
            throw new JSONException((Throwable) e11);
        }
    }

    public JSONException syntaxError(String str) {
        return new JSONException(str + toString());
    }

    public String toString() {
        return " at " + this.index + " [character " + this.character + " line " + this.line + "]";
    }

    public JSONException syntaxError(String str, Throwable th2) {
        return new JSONException(str + toString(), th2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0020  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String nextTo(java.lang.String r4) throws org.json.JSONException {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
        L_0x0005:
            char r1 = r3.next()
            int r2 = r4.indexOf(r1)
            if (r2 >= 0) goto L_0x001e
            if (r1 == 0) goto L_0x001e
            r2 = 10
            if (r1 == r2) goto L_0x001e
            r2 = 13
            if (r1 != r2) goto L_0x001a
            goto L_0x001e
        L_0x001a:
            r0.append(r1)
            goto L_0x0005
        L_0x001e:
            if (r1 == 0) goto L_0x0023
            r3.back()
        L_0x0023:
            java.lang.String r4 = r0.toString()
            java.lang.String r4 = r4.trim()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.json.JSONTokener.nextTo(java.lang.String):java.lang.String");
    }

    public char next(char c11) throws JSONException {
        char next = next();
        if (next == c11) {
            return next;
        }
        if (next > 0) {
            throw syntaxError("Expected '" + c11 + "' and instead saw '" + next + "'");
        }
        throw syntaxError("Expected '" + c11 + "' and instead saw ''");
    }

    public JSONTokener(InputStream inputStream) {
        this((Reader) new InputStreamReader(inputStream));
    }

    public JSONTokener(String str) {
        this((Reader) new StringReader(str));
    }

    public String next(int i11) throws JSONException {
        if (i11 == 0) {
            return "";
        }
        char[] cArr = new char[i11];
        int i12 = 0;
        while (i12 < i11) {
            cArr[i12] = next();
            if (!end()) {
                i12++;
            } else {
                throw syntaxError("Substring bounds error");
            }
        }
        return new String(cArr);
    }
}
