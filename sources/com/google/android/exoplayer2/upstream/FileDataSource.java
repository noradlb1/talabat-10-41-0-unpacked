package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.text.TextUtils;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class FileDataSource extends BaseDataSource {
    private long bytesRemaining;
    @Nullable
    private RandomAccessFile file;
    private boolean opened;
    @Nullable
    private Uri uri;

    @RequiresApi(21)
    public static final class Api21 {
        private Api21() {
        }

        /* access modifiers changed from: private */
        @DoNotInline
        public static boolean isPermissionError(@Nullable Throwable th2) {
            return (th2 instanceof ErrnoException) && ((ErrnoException) th2).errno == OsConstants.EACCES;
        }
    }

    public static final class Factory implements DataSource.Factory {
        @Nullable
        private TransferListener listener;

        @CanIgnoreReturnValue
        public Factory setListener(@Nullable TransferListener transferListener) {
            this.listener = transferListener;
            return this;
        }

        public FileDataSource createDataSource() {
            FileDataSource fileDataSource = new FileDataSource();
            TransferListener transferListener = this.listener;
            if (transferListener != null) {
                fileDataSource.addTransferListener(transferListener);
            }
            return fileDataSource;
        }
    }

    public static class FileDataSourceException extends DataSourceException {
        @Deprecated
        public FileDataSourceException(Exception exc) {
            super((Throwable) exc, 2000);
        }

        @Deprecated
        public FileDataSourceException(String str, IOException iOException) {
            super(str, iOException, 2000);
        }

        public FileDataSourceException(Throwable th2, int i11) {
            super(th2, i11);
        }

        public FileDataSourceException(@Nullable String str, @Nullable Throwable th2, int i11) {
            super(str, th2, i11);
        }
    }

    public FileDataSource() {
        super(false);
    }

    private static RandomAccessFile openLocalFile(Uri uri2) throws FileDataSourceException {
        int i11 = PlaybackException.ERROR_CODE_IO_NO_PERMISSION;
        try {
            return new RandomAccessFile((String) Assertions.checkNotNull(uri2.getPath()), "r");
        } catch (FileNotFoundException e11) {
            if (!TextUtils.isEmpty(uri2.getQuery()) || !TextUtils.isEmpty(uri2.getFragment())) {
                throw new FileDataSourceException(String.format("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=%s,query=%s,fragment=%s", new Object[]{uri2.getPath(), uri2.getQuery(), uri2.getFragment()}), e11, 1004);
            }
            if (Util.SDK_INT < 21 || !Api21.isPermissionError(e11.getCause())) {
                i11 = PlaybackException.ERROR_CODE_IO_FILE_NOT_FOUND;
            }
            throw new FileDataSourceException((Throwable) e11, i11);
        } catch (SecurityException e12) {
            throw new FileDataSourceException((Throwable) e12, (int) PlaybackException.ERROR_CODE_IO_NO_PERMISSION);
        } catch (RuntimeException e13) {
            throw new FileDataSourceException((Throwable) e13, 2000);
        }
    }

    public void close() throws FileDataSourceException {
        this.uri = null;
        try {
            RandomAccessFile randomAccessFile = this.file;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            this.file = null;
            if (this.opened) {
                this.opened = false;
                transferEnded();
            }
        } catch (IOException e11) {
            throw new FileDataSourceException((Throwable) e11, 2000);
        } catch (Throwable th2) {
            this.file = null;
            if (this.opened) {
                this.opened = false;
                transferEnded();
            }
            throw th2;
        }
    }

    @Nullable
    public Uri getUri() {
        return this.uri;
    }

    public long open(DataSpec dataSpec) throws FileDataSourceException {
        Uri uri2 = dataSpec.uri;
        this.uri = uri2;
        transferInitializing(dataSpec);
        RandomAccessFile openLocalFile = openLocalFile(uri2);
        this.file = openLocalFile;
        try {
            openLocalFile.seek(dataSpec.position);
            long j11 = dataSpec.length;
            if (j11 == -1) {
                j11 = this.file.length() - dataSpec.position;
            }
            this.bytesRemaining = j11;
            if (j11 >= 0) {
                this.opened = true;
                transferStarted(dataSpec);
                return this.bytesRemaining;
            }
            throw new FileDataSourceException((String) null, (Throwable) null, 2008);
        } catch (IOException e11) {
            throw new FileDataSourceException((Throwable) e11, 2000);
        }
    }

    public int read(byte[] bArr, int i11, int i12) throws FileDataSourceException {
        if (i12 == 0) {
            return 0;
        }
        if (this.bytesRemaining == 0) {
            return -1;
        }
        try {
            int read = ((RandomAccessFile) Util.castNonNull(this.file)).read(bArr, i11, (int) Math.min(this.bytesRemaining, (long) i12));
            if (read > 0) {
                this.bytesRemaining -= (long) read;
                bytesTransferred(read);
            }
            return read;
        } catch (IOException e11) {
            throw new FileDataSourceException((Throwable) e11, 2000);
        }
    }
}
