package org.tukaani.xz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class SeekableFileInputStream extends SeekableInputStream {

    /* renamed from: b  reason: collision with root package name */
    public RandomAccessFile f63414b;

    public SeekableFileInputStream(File file) throws FileNotFoundException {
        this.f63414b = new RandomAccessFile(file, "r");
    }

    public SeekableFileInputStream(RandomAccessFile randomAccessFile) {
        this.f63414b = randomAccessFile;
    }

    public SeekableFileInputStream(String str) throws FileNotFoundException {
        this.f63414b = new RandomAccessFile(str, "r");
    }

    public void close() throws IOException {
        this.f63414b.close();
    }

    public long length() throws IOException {
        return this.f63414b.length();
    }

    public long position() throws IOException {
        return this.f63414b.getFilePointer();
    }

    public int read() throws IOException {
        return this.f63414b.read();
    }

    public int read(byte[] bArr) throws IOException {
        return this.f63414b.read(bArr);
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        return this.f63414b.read(bArr, i11, i12);
    }

    public void seek(long j11) throws IOException {
        this.f63414b.seek(j11);
    }
}
