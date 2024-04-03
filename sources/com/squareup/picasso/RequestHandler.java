package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.NetworkInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.squareup.picasso.Picasso;
import java.io.IOException;
import okio.Source;

public abstract class RequestHandler {

    public static final class Result {
        private final Bitmap bitmap;
        private final int exifOrientation;
        private final Picasso.LoadedFrom loadedFrom;
        private final Source source;

        public Result(@NonNull Bitmap bitmap2, @NonNull Picasso.LoadedFrom loadedFrom2) {
            this((Bitmap) Utils.e(bitmap2, "bitmap == null"), (Source) null, loadedFrom2, 0);
        }

        public int a() {
            return this.exifOrientation;
        }

        @Nullable
        public Bitmap getBitmap() {
            return this.bitmap;
        }

        @NonNull
        public Picasso.LoadedFrom getLoadedFrom() {
            return this.loadedFrom;
        }

        @Nullable
        public Source getSource() {
            return this.source;
        }

        public Result(@NonNull Source source2, @NonNull Picasso.LoadedFrom loadedFrom2) {
            this((Bitmap) null, (Source) Utils.e(source2, "source == null"), loadedFrom2, 0);
        }

        public Result(@Nullable Bitmap bitmap2, @Nullable Source source2, @NonNull Picasso.LoadedFrom loadedFrom2, int i11) {
            if ((bitmap2 != null) != (source2 == null ? false : true)) {
                this.bitmap = bitmap2;
                this.source = source2;
                this.loadedFrom = (Picasso.LoadedFrom) Utils.e(loadedFrom2, "loadedFrom == null");
                this.exifOrientation = i11;
                return;
            }
            throw new AssertionError();
        }
    }

    public static void a(int i11, int i12, int i13, int i14, BitmapFactory.Options options, Request request) {
        int i15;
        double floor;
        if (i14 > i12 || i13 > i11) {
            if (i12 == 0) {
                floor = Math.floor((double) (((float) i13) / ((float) i11)));
            } else if (i11 == 0) {
                floor = Math.floor((double) (((float) i14) / ((float) i12)));
            } else {
                int floor2 = (int) Math.floor((double) (((float) i14) / ((float) i12)));
                int floor3 = (int) Math.floor((double) (((float) i13) / ((float) i11)));
                if (request.centerInside) {
                    i15 = Math.max(floor2, floor3);
                } else {
                    i15 = Math.min(floor2, floor3);
                }
            }
            i15 = (int) floor;
        } else {
            i15 = 1;
        }
        options.inSampleSize = i15;
        options.inJustDecodeBounds = false;
    }

    public static void b(int i11, int i12, BitmapFactory.Options options, Request request) {
        a(i11, i12, options.outWidth, options.outHeight, options, request);
    }

    public static BitmapFactory.Options c(Request request) {
        boolean z11;
        boolean hasSize = request.hasSize();
        if (request.config != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!hasSize && !z11 && !request.purgeable) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = hasSize;
        boolean z12 = request.purgeable;
        options.inInputShareable = z12;
        options.inPurgeable = z12;
        if (z11) {
            options.inPreferredConfig = request.config;
        }
        return options;
    }

    public static boolean e(BitmapFactory.Options options) {
        return options != null && options.inJustDecodeBounds;
    }

    public abstract boolean canHandleRequest(Request request);

    public int d() {
        return 0;
    }

    public boolean f(boolean z11, NetworkInfo networkInfo) {
        return false;
    }

    public boolean g() {
        return false;
    }

    @Nullable
    public abstract Result load(Request request, int i11) throws IOException;
}
