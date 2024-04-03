package com.squareup.picasso;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import com.facebook.share.internal.ShareConstants;
import com.google.android.exoplayer2.RendererCapabilities;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestHandler;
import java.io.IOException;
import okio.Okio;
import okio.Source;

class MediaStoreRequestHandler extends ContentStreamRequestHandler {
    private static final String[] CONTENT_ORIENTATION = {"orientation"};

    public enum PicassoKind {
        MICRO(3, 96, 96),
        MINI(1, 512, RendererCapabilities.MODE_SUPPORT_MASK),
        FULL(2, -1, -1);
        

        /* renamed from: b  reason: collision with root package name */
        public final int f53423b;

        /* renamed from: c  reason: collision with root package name */
        public final int f53424c;

        /* renamed from: d  reason: collision with root package name */
        public final int f53425d;

        private PicassoKind(int i11, int i12, int i13) {
            this.f53423b = i11;
            this.f53424c = i12;
            this.f53425d = i13;
        }
    }

    public MediaStoreRequestHandler(Context context) {
        super(context);
    }

    public static int h(ContentResolver contentResolver, Uri uri) {
        Cursor cursor = null;
        try {
            Cursor query = contentResolver.query(uri, CONTENT_ORIENTATION, (String) null, (String[]) null, (String) null);
            if (query != null) {
                if (query.moveToFirst()) {
                    int i11 = query.getInt(0);
                    query.close();
                    return i11;
                }
            }
            if (query != null) {
                query.close();
            }
            return 0;
        } catch (RuntimeException unused) {
            if (cursor != null) {
                cursor.close();
            }
            return 0;
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    public static PicassoKind i(int i11, int i12) {
        PicassoKind picassoKind = PicassoKind.MICRO;
        if (i11 <= picassoKind.f53424c && i12 <= picassoKind.f53425d) {
            return picassoKind;
        }
        PicassoKind picassoKind2 = PicassoKind.MINI;
        if (i11 > picassoKind2.f53424c || i12 > picassoKind2.f53425d) {
            return PicassoKind.FULL;
        }
        return picassoKind2;
    }

    public boolean canHandleRequest(Request request) {
        Uri uri = request.uri;
        if (!"content".equals(uri.getScheme()) || !ShareConstants.WEB_DIALOG_PARAM_MEDIA.equals(uri.getAuthority())) {
            return false;
        }
        return true;
    }

    public RequestHandler.Result load(Request request, int i11) throws IOException {
        boolean z11;
        Bitmap bitmap;
        int i12;
        Request request2 = request;
        ContentResolver contentResolver = this.f53395a.getContentResolver();
        int h11 = h(contentResolver, request2.uri);
        String type = contentResolver.getType(request2.uri);
        if (type == null || !type.startsWith("video/")) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (request.hasSize()) {
            PicassoKind i13 = i(request2.targetWidth, request2.targetHeight);
            if (!z11 && i13 == PicassoKind.FULL) {
                return new RequestHandler.Result((Bitmap) null, Okio.source(getInputStream(request)), Picasso.LoadedFrom.DISK, h11);
            }
            long parseId = ContentUris.parseId(request2.uri);
            BitmapFactory.Options c11 = RequestHandler.c(request);
            c11.inJustDecodeBounds = true;
            BitmapFactory.Options options = c11;
            RequestHandler.a(request2.targetWidth, request2.targetHeight, i13.f53424c, i13.f53425d, c11, request);
            if (z11) {
                if (i13 == PicassoKind.FULL) {
                    i12 = 1;
                } else {
                    i12 = i13.f53423b;
                }
                bitmap = MediaStore.Video.Thumbnails.getThumbnail(contentResolver, parseId, i12, options);
            } else {
                bitmap = MediaStore.Images.Thumbnails.getThumbnail(contentResolver, parseId, i13.f53423b, options);
            }
            if (bitmap != null) {
                return new RequestHandler.Result(bitmap, (Source) null, Picasso.LoadedFrom.DISK, h11);
            }
        }
        return new RequestHandler.Result((Bitmap) null, Okio.source(getInputStream(request)), Picasso.LoadedFrom.DISK, h11);
    }
}
