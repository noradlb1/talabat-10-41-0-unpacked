package com.google.android.exoplayer2.upstream;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.util.Util;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

public final class ContentDataSource extends BaseDataSource {
    @Nullable
    private AssetFileDescriptor assetFileDescriptor;
    private long bytesRemaining;
    @Nullable
    private FileInputStream inputStream;
    private boolean opened;
    private final ContentResolver resolver;
    @Nullable
    private Uri uri;

    public static class ContentDataSourceException extends DataSourceException {
        @Deprecated
        public ContentDataSourceException(IOException iOException) {
            this(iOException, 2000);
        }

        public ContentDataSourceException(@Nullable IOException iOException, int i11) {
            super((Throwable) iOException, i11);
        }
    }

    public ContentDataSource(Context context) {
        super(false);
        this.resolver = context.getContentResolver();
    }

    public void close() throws ContentDataSourceException {
        this.uri = null;
        try {
            FileInputStream fileInputStream = this.inputStream;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            this.inputStream = null;
            try {
                AssetFileDescriptor assetFileDescriptor2 = this.assetFileDescriptor;
                if (assetFileDescriptor2 != null) {
                    assetFileDescriptor2.close();
                }
                this.assetFileDescriptor = null;
                if (this.opened) {
                    this.opened = false;
                    transferEnded();
                }
            } catch (IOException e11) {
                throw new ContentDataSourceException(e11, 2000);
            } catch (Throwable th2) {
                this.assetFileDescriptor = null;
                if (this.opened) {
                    this.opened = false;
                    transferEnded();
                }
                throw th2;
            }
        } catch (IOException e12) {
            throw new ContentDataSourceException(e12, 2000);
        } catch (Throwable th3) {
            this.inputStream = null;
            try {
                AssetFileDescriptor assetFileDescriptor3 = this.assetFileDescriptor;
                if (assetFileDescriptor3 != null) {
                    assetFileDescriptor3.close();
                }
                this.assetFileDescriptor = null;
                if (this.opened) {
                    this.opened = false;
                    transferEnded();
                }
                throw th3;
            } catch (IOException e13) {
                throw new ContentDataSourceException(e13, 2000);
            } catch (Throwable th4) {
                this.assetFileDescriptor = null;
                if (this.opened) {
                    this.opened = false;
                    transferEnded();
                }
                throw th4;
            }
        }
    }

    @Nullable
    public Uri getUri() {
        return this.uri;
    }

    public long open(DataSpec dataSpec) throws ContentDataSourceException {
        AssetFileDescriptor assetFileDescriptor2;
        DataSpec dataSpec2 = dataSpec;
        int i11 = 2000;
        try {
            Uri uri2 = dataSpec2.uri;
            this.uri = uri2;
            transferInitializing(dataSpec);
            if ("content".equals(dataSpec2.uri.getScheme())) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("android.provider.extra.ACCEPT_ORIGINAL_MEDIA_FORMAT", true);
                assetFileDescriptor2 = this.resolver.openTypedAssetFileDescriptor(uri2, "*/*", bundle);
            } else {
                assetFileDescriptor2 = this.resolver.openAssetFileDescriptor(uri2, "r");
            }
            this.assetFileDescriptor = assetFileDescriptor2;
            if (assetFileDescriptor2 != null) {
                long length = assetFileDescriptor2.getLength();
                FileInputStream fileInputStream = new FileInputStream(assetFileDescriptor2.getFileDescriptor());
                this.inputStream = fileInputStream;
                int i12 = (length > -1 ? 1 : (length == -1 ? 0 : -1));
                if (i12 != 0) {
                    if (dataSpec2.position > length) {
                        throw new ContentDataSourceException((IOException) null, 2008);
                    }
                }
                long startOffset = assetFileDescriptor2.getStartOffset();
                long j11 = length;
                long skip = fileInputStream.skip(dataSpec2.position + startOffset) - startOffset;
                if (skip == dataSpec2.position) {
                    if (i12 == 0) {
                        FileChannel channel = fileInputStream.getChannel();
                        long size = channel.size();
                        if (size == 0) {
                            this.bytesRemaining = -1;
                        } else {
                            long position = size - channel.position();
                            this.bytesRemaining = position;
                            if (position < 0) {
                                throw new ContentDataSourceException((IOException) null, 2008);
                            }
                        }
                    } else {
                        long j12 = j11 - skip;
                        this.bytesRemaining = j12;
                        if (j12 < 0) {
                            throw new ContentDataSourceException((IOException) null, 2008);
                        }
                    }
                    long j13 = dataSpec2.length;
                    if (j13 != -1) {
                        long j14 = this.bytesRemaining;
                        if (j14 != -1) {
                            j13 = Math.min(j14, j13);
                        }
                        this.bytesRemaining = j13;
                    }
                    this.opened = true;
                    transferStarted(dataSpec);
                    long j15 = dataSpec2.length;
                    if (j15 != -1) {
                        return j15;
                    }
                    return this.bytesRemaining;
                }
                throw new ContentDataSourceException((IOException) null, 2008);
            }
            throw new ContentDataSourceException(new IOException("Could not open file descriptor for: " + uri2), 2000);
        } catch (ContentDataSourceException e11) {
            throw e11;
        } catch (IOException e12) {
            if (e12 instanceof FileNotFoundException) {
                i11 = PlaybackException.ERROR_CODE_IO_FILE_NOT_FOUND;
            }
            throw new ContentDataSourceException(e12, i11);
        }
    }

    public int read(byte[] bArr, int i11, int i12) throws ContentDataSourceException {
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
                throw new ContentDataSourceException(e11, 2000);
            }
        }
        int read = ((FileInputStream) Util.castNonNull(this.inputStream)).read(bArr, i11, i12);
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
