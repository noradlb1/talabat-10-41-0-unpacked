package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public final class AssetDataSource extends BaseDataSource {
    private final AssetManager assetManager;
    private long bytesRemaining;
    @Nullable
    private InputStream inputStream;
    private boolean opened;
    @Nullable
    private Uri uri;

    public static final class AssetDataSourceException extends DataSourceException {
        @Deprecated
        public AssetDataSourceException(IOException iOException) {
            super((Throwable) iOException, 2000);
        }

        public AssetDataSourceException(@Nullable Throwable th2, int i11) {
            super(th2, i11);
        }
    }

    public AssetDataSource(Context context) {
        super(false);
        this.assetManager = context.getAssets();
    }

    public void close() throws AssetDataSourceException {
        this.uri = null;
        try {
            InputStream inputStream2 = this.inputStream;
            if (inputStream2 != null) {
                inputStream2.close();
            }
            this.inputStream = null;
            if (this.opened) {
                this.opened = false;
                transferEnded();
            }
        } catch (IOException e11) {
            throw new AssetDataSourceException(e11, 2000);
        } catch (Throwable th2) {
            this.inputStream = null;
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

    public long open(DataSpec dataSpec) throws AssetDataSourceException {
        int i11;
        try {
            Uri uri2 = dataSpec.uri;
            this.uri = uri2;
            String str = (String) Assertions.checkNotNull(uri2.getPath());
            if (str.startsWith("/android_asset/")) {
                str = str.substring(15);
            } else if (str.startsWith("/")) {
                str = str.substring(1);
            }
            transferInitializing(dataSpec);
            InputStream open = this.assetManager.open(str, 1);
            this.inputStream = open;
            if (open.skip(dataSpec.position) >= dataSpec.position) {
                long j11 = dataSpec.length;
                if (j11 != -1) {
                    this.bytesRemaining = j11;
                } else {
                    long available = (long) this.inputStream.available();
                    this.bytesRemaining = available;
                    if (available == 2147483647L) {
                        this.bytesRemaining = -1;
                    }
                }
                this.opened = true;
                transferStarted(dataSpec);
                return this.bytesRemaining;
            }
            throw new AssetDataSourceException((Throwable) null, 2008);
        } catch (AssetDataSourceException e11) {
            throw e11;
        } catch (IOException e12) {
            if (e12 instanceof FileNotFoundException) {
                i11 = PlaybackException.ERROR_CODE_IO_FILE_NOT_FOUND;
            } else {
                i11 = 2000;
            }
            throw new AssetDataSourceException(e12, i11);
        }
    }

    public int read(byte[] bArr, int i11, int i12) throws AssetDataSourceException {
        if (i12 == 0) {
            return 0;
        }
        long j11 = this.bytesRemaining;
        if (j11 == 0) {
            return -1;
        }
        if (j11 != -1) {
            try {
                i12 = (int) Math.min(j11, (long) i12);
            } catch (IOException e11) {
                throw new AssetDataSourceException(e11, 2000);
            }
        }
        int read = ((InputStream) Util.castNonNull(this.inputStream)).read(bArr, i11, i12);
        if (read == -1) {
            return -1;
        }
        long j12 = this.bytesRemaining;
        if (j12 != -1) {
            this.bytesRemaining = j12 - ((long) read);
        }
        bytesTransferred(read);
        return read;
    }
}
