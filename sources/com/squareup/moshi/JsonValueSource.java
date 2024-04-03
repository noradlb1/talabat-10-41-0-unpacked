package com.squareup.moshi;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;
import org.json.HTTP;

final class JsonValueSource implements Source {

    /* renamed from: b  reason: collision with root package name */
    public static final ByteString f53268b = ByteString.encodeUtf8("[]{}\"'/#");

    /* renamed from: c  reason: collision with root package name */
    public static final ByteString f53269c = ByteString.encodeUtf8("'\\");

    /* renamed from: d  reason: collision with root package name */
    public static final ByteString f53270d = ByteString.encodeUtf8("\"\\");

    /* renamed from: e  reason: collision with root package name */
    public static final ByteString f53271e = ByteString.encodeUtf8(HTTP.CRLF);

    /* renamed from: f  reason: collision with root package name */
    public static final ByteString f53272f = ByteString.encodeUtf8("*");

    /* renamed from: g  reason: collision with root package name */
    public static final ByteString f53273g = ByteString.EMPTY;
    private final Buffer buffer;
    private boolean closed = false;
    private long limit = 0;
    private final Buffer prefix;
    private final BufferedSource source;
    private int stackSize;
    private ByteString state;

    public JsonValueSource(BufferedSource bufferedSource, Buffer buffer2, ByteString byteString, int i11) {
        this.source = bufferedSource;
        this.buffer = bufferedSource.getBuffer();
        this.prefix = buffer2;
        this.state = byteString;
        this.stackSize = i11;
    }

    private void advanceLimit(long j11) throws IOException {
        ByteString byteString;
        while (true) {
            long j12 = this.limit;
            if (j12 < j11 && this.state != (byteString = f53273g)) {
                if (j12 == this.buffer.size()) {
                    if (this.limit <= 0) {
                        this.source.require(1);
                    } else {
                        return;
                    }
                }
                long indexOfElement = this.buffer.indexOfElement(this.state, this.limit);
                if (indexOfElement == -1) {
                    this.limit = this.buffer.size();
                } else {
                    byte b11 = this.buffer.getByte(indexOfElement);
                    ByteString byteString2 = this.state;
                    ByteString byteString3 = f53268b;
                    if (byteString2 == byteString3) {
                        if (b11 == 34) {
                            this.state = f53270d;
                            this.limit = indexOfElement + 1;
                        } else if (b11 == 35) {
                            this.state = f53271e;
                            this.limit = indexOfElement + 1;
                        } else if (b11 == 39) {
                            this.state = f53269c;
                            this.limit = indexOfElement + 1;
                        } else if (b11 != 47) {
                            if (b11 != 91) {
                                if (b11 != 93) {
                                    if (b11 != 123) {
                                        if (b11 != 125) {
                                        }
                                    }
                                }
                                int i11 = this.stackSize - 1;
                                this.stackSize = i11;
                                if (i11 == 0) {
                                    this.state = byteString;
                                }
                                this.limit = indexOfElement + 1;
                            }
                            this.stackSize++;
                            this.limit = indexOfElement + 1;
                        } else {
                            long j13 = 2 + indexOfElement;
                            this.source.require(j13);
                            long j14 = indexOfElement + 1;
                            byte b12 = this.buffer.getByte(j14);
                            if (b12 == 47) {
                                this.state = f53271e;
                                this.limit = j13;
                            } else if (b12 == 42) {
                                this.state = f53272f;
                                this.limit = j13;
                            } else {
                                this.limit = j14;
                            }
                        }
                    } else if (byteString2 == f53269c || byteString2 == f53270d) {
                        if (b11 == 92) {
                            long j15 = indexOfElement + 2;
                            this.source.require(j15);
                            this.limit = j15;
                        } else {
                            if (this.stackSize > 0) {
                                byteString = byteString3;
                            }
                            this.state = byteString;
                            this.limit = indexOfElement + 1;
                        }
                    } else if (byteString2 == f53272f) {
                        long j16 = 2 + indexOfElement;
                        this.source.require(j16);
                        long j17 = indexOfElement + 1;
                        if (this.buffer.getByte(j17) == 47) {
                            this.limit = j16;
                            this.state = byteString3;
                        } else {
                            this.limit = j17;
                        }
                    } else if (byteString2 == f53271e) {
                        this.limit = indexOfElement + 1;
                        this.state = byteString3;
                    } else {
                        throw new AssertionError();
                    }
                }
            } else {
                return;
            }
        }
    }

    public void close() throws IOException {
        this.closed = true;
    }

    public void discard() throws IOException {
        this.closed = true;
        while (this.state != f53273g) {
            advanceLimit(PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            this.source.skip(this.limit);
        }
    }

    public long read(Buffer buffer2, long j11) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        } else if (j11 == 0) {
            return 0;
        } else {
            if (!this.prefix.exhausted()) {
                long read = this.prefix.read(buffer2, j11);
                long j12 = j11 - read;
                if (this.buffer.exhausted()) {
                    return read;
                }
                long read2 = read(buffer2, j12);
                if (read2 != -1) {
                    return read + read2;
                }
                return read;
            }
            advanceLimit(j11);
            long j13 = this.limit;
            if (j13 != 0) {
                long min = Math.min(j11, j13);
                buffer2.write(this.buffer, min);
                this.limit -= min;
                return min;
            } else if (this.state == f53273g) {
                return -1;
            } else {
                throw new AssertionError();
            }
        }
    }

    public Timeout timeout() {
        return this.source.timeout();
    }
}
