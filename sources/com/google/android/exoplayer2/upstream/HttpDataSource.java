package com.google.android.exoplayer2.upstream;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Ascii;
import com.google.common.base.Predicate;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.net.SocketTimeoutException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import l8.d;

public interface HttpDataSource extends DataSource {
    public static final Predicate<String> REJECT_PAYWALL_TYPES = new d();

    public static abstract class BaseFactory implements Factory {
        private final RequestProperties defaultRequestProperties = new RequestProperties();

        public abstract HttpDataSource createDataSourceInternal(RequestProperties requestProperties);

        @CanIgnoreReturnValue
        public final Factory setDefaultRequestProperties(Map<String, String> map) {
            this.defaultRequestProperties.clearAndSet(map);
            return this;
        }

        public final HttpDataSource createDataSource() {
            return createDataSourceInternal(this.defaultRequestProperties);
        }
    }

    public static final class CleartextNotPermittedException extends HttpDataSourceException {
        public CleartextNotPermittedException(IOException iOException, DataSpec dataSpec) {
            super("Cleartext HTTP traffic not permitted. See https://developer.android.com/guide/topics/media/issues/cleartext-not-permitted", iOException, dataSpec, PlaybackException.ERROR_CODE_IO_CLEARTEXT_NOT_PERMITTED, 1);
        }
    }

    public interface Factory extends DataSource.Factory {
        /* bridge */ /* synthetic */ DataSource createDataSource();

        HttpDataSource createDataSource();

        Factory setDefaultRequestProperties(Map<String, String> map);
    }

    public static class HttpDataSourceException extends DataSourceException {
        public static final int TYPE_CLOSE = 3;
        public static final int TYPE_OPEN = 1;
        public static final int TYPE_READ = 2;
        public final DataSpec dataSpec;
        public final int type;

        @Documented
        @Target({ElementType.TYPE_USE})
        @Retention(RetentionPolicy.SOURCE)
        public @interface Type {
        }

        @Deprecated
        public HttpDataSourceException(DataSpec dataSpec2, int i11) {
            this(dataSpec2, 2000, i11);
        }

        private static int assignErrorCode(int i11, int i12) {
            if (i11 == 2000 && i12 == 1) {
                return 2001;
            }
            return i11;
        }

        public static HttpDataSourceException createForIOException(IOException iOException, DataSpec dataSpec2, int i11) {
            int i12;
            String message = iOException.getMessage();
            if (iOException instanceof SocketTimeoutException) {
                i12 = PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_TIMEOUT;
            } else if (iOException instanceof InterruptedIOException) {
                i12 = 1004;
            } else if (message == null || !Ascii.toLowerCase(message).matches("cleartext.*not permitted.*")) {
                i12 = 2001;
            } else {
                i12 = 2007;
            }
            if (i12 == 2007) {
                return new CleartextNotPermittedException(iOException, dataSpec2);
            }
            return new HttpDataSourceException(iOException, dataSpec2, i12, i11);
        }

        public HttpDataSourceException(DataSpec dataSpec2, int i11, int i12) {
            super(assignErrorCode(i11, i12));
            this.dataSpec = dataSpec2;
            this.type = i12;
        }

        @Deprecated
        public HttpDataSourceException(String str, DataSpec dataSpec2, int i11) {
            this(str, dataSpec2, 2000, i11);
        }

        public HttpDataSourceException(String str, DataSpec dataSpec2, int i11, int i12) {
            super(str, assignErrorCode(i11, i12));
            this.dataSpec = dataSpec2;
            this.type = i12;
        }

        @Deprecated
        public HttpDataSourceException(IOException iOException, DataSpec dataSpec2, int i11) {
            this(iOException, dataSpec2, 2000, i11);
        }

        public HttpDataSourceException(IOException iOException, DataSpec dataSpec2, int i11, int i12) {
            super((Throwable) iOException, assignErrorCode(i11, i12));
            this.dataSpec = dataSpec2;
            this.type = i12;
        }

        @Deprecated
        public HttpDataSourceException(String str, IOException iOException, DataSpec dataSpec2, int i11) {
            this(str, iOException, dataSpec2, 2000, i11);
        }

        public HttpDataSourceException(String str, @Nullable IOException iOException, DataSpec dataSpec2, int i11, int i12) {
            super(str, iOException, assignErrorCode(i11, i12));
            this.dataSpec = dataSpec2;
            this.type = i12;
        }
    }

    public static final class InvalidContentTypeException extends HttpDataSourceException {
        public final String contentType;

        public InvalidContentTypeException(String str, DataSpec dataSpec) {
            super("Invalid content type: " + str, dataSpec, 2003, 1);
            this.contentType = str;
        }
    }

    public static final class InvalidResponseCodeException extends HttpDataSourceException {
        public final Map<String, List<String>> headerFields;
        public final byte[] responseBody;
        public final int responseCode;
        @Nullable
        public final String responseMessage;

        @Deprecated
        public InvalidResponseCodeException(int i11, Map<String, List<String>> map, DataSpec dataSpec) {
            this(i11, (String) null, (IOException) null, map, dataSpec, Util.EMPTY_BYTE_ARRAY);
        }

        @Deprecated
        public InvalidResponseCodeException(int i11, @Nullable String str, Map<String, List<String>> map, DataSpec dataSpec) {
            this(i11, str, (IOException) null, map, dataSpec, Util.EMPTY_BYTE_ARRAY);
        }

        public InvalidResponseCodeException(int i11, @Nullable String str, @Nullable IOException iOException, Map<String, List<String>> map, DataSpec dataSpec, byte[] bArr) {
            super("Response code: " + i11, iOException, dataSpec, PlaybackException.ERROR_CODE_IO_BAD_HTTP_STATUS, 1);
            this.responseCode = i11;
            this.responseMessage = str;
            this.headerFields = map;
            this.responseBody = bArr;
        }
    }

    void clearAllRequestProperties();

    void clearRequestProperty(String str);

    void close() throws HttpDataSourceException;

    int getResponseCode();

    Map<String, List<String>> getResponseHeaders();

    long open(DataSpec dataSpec) throws HttpDataSourceException;

    int read(byte[] bArr, int i11, int i12) throws HttpDataSourceException;

    void setRequestProperty(String str, String str2);

    public static final class RequestProperties {
        private final Map<String, String> requestProperties = new HashMap();
        @Nullable
        private Map<String, String> requestPropertiesSnapshot;

        public synchronized void clear() {
            this.requestPropertiesSnapshot = null;
            this.requestProperties.clear();
        }

        public synchronized void clearAndSet(Map<String, String> map) {
            this.requestPropertiesSnapshot = null;
            this.requestProperties.clear();
            this.requestProperties.putAll(map);
        }

        public synchronized Map<String, String> getSnapshot() {
            if (this.requestPropertiesSnapshot == null) {
                this.requestPropertiesSnapshot = Collections.unmodifiableMap(new HashMap(this.requestProperties));
            }
            return this.requestPropertiesSnapshot;
        }

        public synchronized void remove(String str) {
            this.requestPropertiesSnapshot = null;
            this.requestProperties.remove(str);
        }

        public synchronized void set(String str, String str2) {
            this.requestPropertiesSnapshot = null;
            this.requestProperties.put(str, str2);
        }

        public synchronized void set(Map<String, String> map) {
            this.requestPropertiesSnapshot = null;
            this.requestProperties.putAll(map);
        }
    }
}
