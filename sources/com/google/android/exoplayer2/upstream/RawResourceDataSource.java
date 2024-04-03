package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;

public final class RawResourceDataSource extends BaseDataSource {
    public static final String RAW_RESOURCE_SCHEME = "rawresource";
    @Nullable
    private AssetFileDescriptor assetFileDescriptor;
    private long bytesRemaining;
    @Nullable
    private InputStream inputStream;
    private boolean opened;
    private final String packageName;
    private final Resources resources;
    @Nullable
    private Uri uri;

    public static class RawResourceDataSourceException extends DataSourceException {
        @Deprecated
        public RawResourceDataSourceException(String str) {
            super(str, (Throwable) null, 2000);
        }

        @Deprecated
        public RawResourceDataSourceException(Throwable th2) {
            super(th2, 2000);
        }

        public RawResourceDataSourceException(@Nullable String str, @Nullable Throwable th2, int i11) {
            super(str, th2, i11);
        }
    }

    public RawResourceDataSource(Context context) {
        super(false);
        this.resources = context.getResources();
        this.packageName = context.getPackageName();
    }

    public static Uri buildRawResourceUri(int i11) {
        return Uri.parse("rawresource:///" + i11);
    }

    public void close() throws RawResourceDataSourceException {
        this.uri = null;
        try {
            InputStream inputStream2 = this.inputStream;
            if (inputStream2 != null) {
                inputStream2.close();
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
                throw new RawResourceDataSourceException((String) null, e11, 2000);
            } catch (Throwable th2) {
                this.assetFileDescriptor = null;
                if (this.opened) {
                    this.opened = false;
                    transferEnded();
                }
                throw th2;
            }
        } catch (IOException e12) {
            throw new RawResourceDataSourceException((String) null, e12, 2000);
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
                throw new RawResourceDataSourceException((String) null, e13, 2000);
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

    public long open(DataSpec dataSpec) throws RawResourceDataSourceException {
        int i11;
        String str;
        DataSpec dataSpec2 = dataSpec;
        Uri uri2 = dataSpec2.uri;
        this.uri = uri2;
        if (TextUtils.equals(RAW_RESOURCE_SCHEME, uri2.getScheme()) || (TextUtils.equals("android.resource", uri2.getScheme()) && uri2.getPathSegments().size() == 1 && ((String) Assertions.checkNotNull(uri2.getLastPathSegment())).matches("\\d+"))) {
            try {
                i11 = Integer.parseInt((String) Assertions.checkNotNull(uri2.getLastPathSegment()));
            } catch (NumberFormatException unused) {
                throw new RawResourceDataSourceException("Resource identifier must be an integer.", (Throwable) null, 1004);
            }
        } else if (TextUtils.equals("android.resource", uri2.getScheme())) {
            String str2 = (String) Assertions.checkNotNull(uri2.getPath());
            if (str2.startsWith("/")) {
                str2 = str2.substring(1);
            }
            String host = uri2.getHost();
            StringBuilder sb2 = new StringBuilder();
            if (TextUtils.isEmpty(host)) {
                str = "";
            } else {
                str = host + CertificateUtil.DELIMITER;
            }
            sb2.append(str);
            sb2.append(str2);
            i11 = this.resources.getIdentifier(sb2.toString(), "raw", this.packageName);
            if (i11 == 0) {
                throw new RawResourceDataSourceException("Resource not found.", (Throwable) null, PlaybackException.ERROR_CODE_IO_FILE_NOT_FOUND);
            }
        } else {
            throw new RawResourceDataSourceException("URI must either use scheme rawresource or android.resource", (Throwable) null, 1004);
        }
        transferInitializing(dataSpec);
        try {
            AssetFileDescriptor openRawResourceFd = this.resources.openRawResourceFd(i11);
            this.assetFileDescriptor = openRawResourceFd;
            if (openRawResourceFd != null) {
                long length = openRawResourceFd.getLength();
                FileInputStream fileInputStream = new FileInputStream(openRawResourceFd.getFileDescriptor());
                this.inputStream = fileInputStream;
                int i12 = (length > -1 ? 1 : (length == -1 ? 0 : -1));
                if (i12 != 0) {
                    try {
                        if (dataSpec2.position > length) {
                            throw new RawResourceDataSourceException((String) null, (Throwable) null, 2008);
                        }
                    } catch (RawResourceDataSourceException e11) {
                        throw e11;
                    } catch (IOException e12) {
                        throw new RawResourceDataSourceException((String) null, e12, 2000);
                    }
                }
                long startOffset = openRawResourceFd.getStartOffset();
                long skip = fileInputStream.skip(dataSpec2.position + startOffset) - startOffset;
                if (skip == dataSpec2.position) {
                    if (i12 == 0) {
                        FileChannel channel = fileInputStream.getChannel();
                        if (channel.size() == 0) {
                            this.bytesRemaining = -1;
                        } else {
                            long size = channel.size() - channel.position();
                            this.bytesRemaining = size;
                            if (size < 0) {
                                throw new RawResourceDataSourceException((String) null, (Throwable) null, 2008);
                            }
                        }
                    } else {
                        long j11 = length - skip;
                        this.bytesRemaining = j11;
                        if (j11 < 0) {
                            throw new DataSourceException(2008);
                        }
                    }
                    long j12 = dataSpec2.length;
                    if (j12 != -1) {
                        long j13 = this.bytesRemaining;
                        if (j13 != -1) {
                            j12 = Math.min(j13, j12);
                        }
                        this.bytesRemaining = j12;
                    }
                    this.opened = true;
                    transferStarted(dataSpec);
                    long j14 = dataSpec2.length;
                    if (j14 != -1) {
                        return j14;
                    }
                    return this.bytesRemaining;
                }
                throw new RawResourceDataSourceException((String) null, (Throwable) null, 2008);
            }
            throw new RawResourceDataSourceException("Resource is compressed: " + uri2, (Throwable) null, 2000);
        } catch (Resources.NotFoundException e13) {
            throw new RawResourceDataSourceException((String) null, e13, PlaybackException.ERROR_CODE_IO_FILE_NOT_FOUND);
        }
    }

    public int read(byte[] bArr, int i11, int i12) throws RawResourceDataSourceException {
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
                throw new RawResourceDataSourceException((String) null, e11, 2000);
            }
        }
        int read = ((InputStream) Util.castNonNull(this.inputStream)).read(bArr, i11, i12);
        if (read != -1) {
            long j12 = this.bytesRemaining;
            if (j12 != -1) {
                this.bytesRemaining = j12 - ((long) read);
            }
            bytesTransferred(read);
            return read;
        } else if (this.bytesRemaining == -1) {
            return -1;
        } else {
            throw new RawResourceDataSourceException("End of stream reached having not read sufficient data.", new EOFException(), 2000);
        }
    }
}
