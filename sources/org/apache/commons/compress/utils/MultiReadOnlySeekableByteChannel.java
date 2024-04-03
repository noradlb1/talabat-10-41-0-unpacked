package org.apache.commons.compress.utils;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NonWritableChannelException;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class MultiReadOnlySeekableByteChannel implements SeekableByteChannel {
    private final List<SeekableByteChannel> channels;
    private int currentChannelIdx;
    private long globalPosition;

    public MultiReadOnlySeekableByteChannel(List<SeekableByteChannel> list) {
        Objects.requireNonNull(list, "channels must not be null");
        this.channels = Collections.unmodifiableList(new ArrayList(list));
    }

    public static SeekableByteChannel forFiles(File... fileArr) throws IOException {
        ArrayList arrayList = new ArrayList();
        Objects.requireNonNull(fileArr, "files must not be null");
        for (File a11 : fileArr) {
            arrayList.add(Files.newByteChannel(a11.toPath(), new OpenOption[]{StandardOpenOption.READ}));
        }
        if (arrayList.size() == 1) {
            return (SeekableByteChannel) arrayList.get(0);
        }
        return new MultiReadOnlySeekableByteChannel(arrayList);
    }

    public static SeekableByteChannel forSeekableByteChannels(SeekableByteChannel... seekableByteChannelArr) {
        Objects.requireNonNull(seekableByteChannelArr, "channels must not be null");
        if (seekableByteChannelArr.length == 1) {
            return seekableByteChannelArr[0];
        }
        return new MultiReadOnlySeekableByteChannel(Arrays.asList(seekableByteChannelArr));
    }

    public void close() throws IOException {
        IOException iOException = null;
        for (SeekableByteChannel a11 : this.channels) {
            try {
                a11.close();
            } catch (IOException e11) {
                if (iOException == null) {
                    iOException = e11;
                }
            }
        }
        if (iOException != null) {
            throw new IOException("failed to close wrapped channel", iOException);
        }
    }

    public boolean isOpen() {
        for (SeekableByteChannel a11 : this.channels) {
            if (!a11.isOpen()) {
                return false;
            }
        }
        return true;
    }

    public long position() {
        return this.globalPosition;
    }

    public synchronized int read(ByteBuffer byteBuffer) throws IOException {
        if (isOpen()) {
            int i11 = 0;
            if (!byteBuffer.hasRemaining()) {
                return 0;
            }
            while (byteBuffer.hasRemaining() && this.currentChannelIdx < this.channels.size()) {
                SeekableByteChannel seekableByteChannel = this.channels.get(this.currentChannelIdx);
                int a11 = seekableByteChannel.read(byteBuffer);
                if (a11 == -1) {
                    this.currentChannelIdx++;
                } else {
                    if (seekableByteChannel.position() >= seekableByteChannel.size()) {
                        this.currentChannelIdx++;
                    }
                    i11 += a11;
                }
            }
            if (i11 <= 0) {
                return -1;
            }
            this.globalPosition += (long) i11;
            return i11;
        }
        throw new ClosedChannelException();
    }

    public long size() throws IOException {
        if (isOpen()) {
            long j11 = 0;
            for (SeekableByteChannel a11 : this.channels) {
                j11 += a11.size();
            }
            return j11;
        }
        throw new ClosedChannelException();
    }

    public SeekableByteChannel truncate(long j11) {
        throw new NonWritableChannelException();
    }

    public int write(ByteBuffer byteBuffer) {
        throw new NonWritableChannelException();
    }

    public synchronized SeekableByteChannel position(long j11, long j12) throws IOException {
        if (isOpen()) {
            for (int i11 = 0; ((long) i11) < j11; i11++) {
                j12 += this.channels.get(i11).size();
            }
        } else {
            throw new ClosedChannelException();
        }
        return position(j12);
    }

    public synchronized SeekableByteChannel position(long j11) throws IOException {
        if (j11 >= 0) {
            try {
                if (isOpen()) {
                    this.globalPosition = j11;
                    int i11 = 0;
                    while (i11 < this.channels.size()) {
                        SeekableByteChannel seekableByteChannel = this.channels.get(i11);
                        long a11 = seekableByteChannel.size();
                        long j12 = -1;
                        if (j11 == -1) {
                            j12 = j11;
                            j11 = 0;
                        } else if (j11 <= a11) {
                            this.currentChannelIdx = i11;
                        } else {
                            j12 = j11 - a11;
                            j11 = a11;
                        }
                        SeekableByteChannel unused = seekableByteChannel.position(j11);
                        i11++;
                        j11 = j12;
                    }
                } else {
                    throw new ClosedChannelException();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        } else {
            throw new IOException("Negative position: " + j11);
        }
        return this;
    }
}
