package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

class ThumbnailStreamOpener {
    private static final FileService DEFAULT_SERVICE = new FileService();
    private static final String TAG = "ThumbStreamOpener";
    private final ArrayPool byteArrayPool;
    private final ContentResolver contentResolver;
    private final List<ImageHeaderParser> parsers;
    private final ThumbnailQuery query;

    /* renamed from: service  reason: collision with root package name */
    private final FileService f44185service;

    public ThumbnailStreamOpener(List<ImageHeaderParser> list, ThumbnailQuery thumbnailQuery, ArrayPool arrayPool, ContentResolver contentResolver2) {
        this(list, DEFAULT_SERVICE, thumbnailQuery, arrayPool, contentResolver2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x002a A[Catch:{ all -> 0x003d }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0041  */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String getPath(@androidx.annotation.NonNull android.net.Uri r5) {
        /*
            r4 = this;
            r0 = 0
            com.bumptech.glide.load.data.mediastore.ThumbnailQuery r1 = r4.query     // Catch:{ SecurityException -> 0x0020, all -> 0x001e }
            android.database.Cursor r1 = r1.query(r5)     // Catch:{ SecurityException -> 0x0020, all -> 0x001e }
            if (r1 == 0) goto L_0x0018
            boolean r2 = r1.moveToFirst()     // Catch:{ SecurityException -> 0x0021 }
            if (r2 == 0) goto L_0x0018
            r2 = 0
            java.lang.String r5 = r1.getString(r2)     // Catch:{ SecurityException -> 0x0021 }
            r1.close()
            return r5
        L_0x0018:
            if (r1 == 0) goto L_0x001d
            r1.close()
        L_0x001d:
            return r0
        L_0x001e:
            r5 = move-exception
            goto L_0x003f
        L_0x0020:
            r1 = r0
        L_0x0021:
            java.lang.String r2 = "ThumbStreamOpener"
            r3 = 3
            boolean r2 = android.util.Log.isLoggable(r2, r3)     // Catch:{ all -> 0x003d }
            if (r2 == 0) goto L_0x0037
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x003d }
            r2.<init>()     // Catch:{ all -> 0x003d }
            java.lang.String r3 = "Failed to query for thumbnail for Uri: "
            r2.append(r3)     // Catch:{ all -> 0x003d }
            r2.append(r5)     // Catch:{ all -> 0x003d }
        L_0x0037:
            if (r1 == 0) goto L_0x003c
            r1.close()
        L_0x003c:
            return r0
        L_0x003d:
            r5 = move-exception
            r0 = r1
        L_0x003f:
            if (r0 == 0) goto L_0x0044
            r0.close()
        L_0x0044:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.data.mediastore.ThumbnailStreamOpener.getPath(android.net.Uri):java.lang.String");
    }

    private boolean isValid(File file) {
        return this.f44185service.exists(file) && 0 < this.f44185service.length(file);
    }

    public int getOrientation(Uri uri) {
        InputStream inputStream = null;
        try {
            InputStream openInputStream = this.contentResolver.openInputStream(uri);
            int orientation = ImageHeaderParserUtils.getOrientation(this.parsers, openInputStream, this.byteArrayPool);
            if (openInputStream != null) {
                try {
                    openInputStream.close();
                } catch (IOException unused) {
                }
            }
            return orientation;
        } catch (IOException | NullPointerException unused2) {
            if (Log.isLoggable(TAG, 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Failed to open uri: ");
                sb2.append(uri);
            }
            if (inputStream == null) {
                return -1;
            }
            try {
                inputStream.close();
                return -1;
            } catch (IOException unused3) {
                return -1;
            }
        } catch (Throwable th2) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused4) {
                }
            }
            throw th2;
        }
    }

    public InputStream open(Uri uri) throws FileNotFoundException {
        String path = getPath(uri);
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        File file = this.f44185service.get(path);
        if (!isValid(file)) {
            return null;
        }
        Uri fromFile = Uri.fromFile(file);
        try {
            return this.contentResolver.openInputStream(fromFile);
        } catch (NullPointerException e11) {
            throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + " -> " + fromFile).initCause(e11));
        }
    }

    public ThumbnailStreamOpener(List<ImageHeaderParser> list, FileService fileService, ThumbnailQuery thumbnailQuery, ArrayPool arrayPool, ContentResolver contentResolver2) {
        this.f44185service = fileService;
        this.query = thumbnailQuery;
        this.byteArrayPool = arrayPool;
        this.contentResolver = contentResolver2;
        this.parsers = list;
    }
}
