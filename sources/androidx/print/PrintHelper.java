package androidx.print;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import android.print.PrintManager;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.FileNotFoundException;

public final class PrintHelper {
    @SuppressLint({"InlinedApi"})
    public static final int COLOR_MODE_COLOR = 2;
    @SuppressLint({"InlinedApi"})
    public static final int COLOR_MODE_MONOCHROME = 1;
    private static final String LOG_TAG = "PrintHelper";
    private static final int MAX_PRINT_SIZE = 3500;
    public static final int ORIENTATION_LANDSCAPE = 1;
    public static final int ORIENTATION_PORTRAIT = 2;
    public static final int SCALE_MODE_FILL = 2;
    public static final int SCALE_MODE_FIT = 1;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f37351g;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f37352h;

    /* renamed from: a  reason: collision with root package name */
    public final Context f37353a;

    /* renamed from: b  reason: collision with root package name */
    public BitmapFactory.Options f37354b = null;

    /* renamed from: c  reason: collision with root package name */
    public final Object f37355c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public int f37356d = 2;

    /* renamed from: e  reason: collision with root package name */
    public int f37357e = 2;

    /* renamed from: f  reason: collision with root package name */
    public int f37358f = 1;

    public interface OnPrintFinishCallback {
        void onFinish();
    }

    @RequiresApi(19)
    public class PrintBitmapAdapter extends PrintDocumentAdapter {
        private PrintAttributes mAttributes;
        private final Bitmap mBitmap;
        private final OnPrintFinishCallback mCallback;
        private final int mFittingMode;
        private final String mJobName;

        public PrintBitmapAdapter(String str, int i11, Bitmap bitmap, OnPrintFinishCallback onPrintFinishCallback) {
            this.mJobName = str;
            this.mFittingMode = i11;
            this.mBitmap = bitmap;
            this.mCallback = onPrintFinishCallback;
        }

        public void onFinish() {
            OnPrintFinishCallback onPrintFinishCallback = this.mCallback;
            if (onPrintFinishCallback != null) {
                onPrintFinishCallback.onFinish();
            }
        }

        public void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, Bundle bundle) {
            this.mAttributes = printAttributes2;
            layoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(this.mJobName).setContentType(1).setPageCount(1).build(), !printAttributes2.equals(printAttributes));
        }

        public void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
            PrintHelper.this.e(this.mAttributes, this.mFittingMode, this.mBitmap, parcelFileDescriptor, cancellationSignal, writeResultCallback);
        }
    }

    @RequiresApi(19)
    public class PrintUriAdapter extends PrintDocumentAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final String f37368a;

        /* renamed from: b  reason: collision with root package name */
        public final Uri f37369b;

        /* renamed from: c  reason: collision with root package name */
        public final OnPrintFinishCallback f37370c;

        /* renamed from: d  reason: collision with root package name */
        public final int f37371d;

        /* renamed from: e  reason: collision with root package name */
        public PrintAttributes f37372e;

        /* renamed from: f  reason: collision with root package name */
        public AsyncTask<Uri, Boolean, Bitmap> f37373f;

        /* renamed from: g  reason: collision with root package name */
        public Bitmap f37374g = null;

        public PrintUriAdapter(String str, Uri uri, OnPrintFinishCallback onPrintFinishCallback, int i11) {
            this.f37368a = str;
            this.f37369b = uri;
            this.f37370c = onPrintFinishCallback;
            this.f37371d = i11;
        }

        public void a() {
            synchronized (PrintHelper.this.f37355c) {
                BitmapFactory.Options options = PrintHelper.this.f37354b;
                if (options != null) {
                    if (Build.VERSION.SDK_INT < 24) {
                        options.requestCancelDecode();
                    }
                    PrintHelper.this.f37354b = null;
                }
            }
        }

        public void onFinish() {
            super.onFinish();
            a();
            AsyncTask<Uri, Boolean, Bitmap> asyncTask = this.f37373f;
            if (asyncTask != null) {
                asyncTask.cancel(true);
            }
            OnPrintFinishCallback onPrintFinishCallback = this.f37370c;
            if (onPrintFinishCallback != null) {
                onPrintFinishCallback.onFinish();
            }
            Bitmap bitmap = this.f37374g;
            if (bitmap != null) {
                bitmap.recycle();
                this.f37374g = null;
            }
        }

        public void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, Bundle bundle) {
            synchronized (this) {
                this.f37372e = printAttributes2;
            }
            if (cancellationSignal.isCanceled()) {
                layoutResultCallback.onLayoutCancelled();
            } else if (this.f37374g != null) {
                layoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(this.f37368a).setContentType(1).setPageCount(1).build(), !printAttributes2.equals(printAttributes));
            } else {
                final CancellationSignal cancellationSignal2 = cancellationSignal;
                final PrintAttributes printAttributes3 = printAttributes2;
                final PrintAttributes printAttributes4 = printAttributes;
                final PrintDocumentAdapter.LayoutResultCallback layoutResultCallback2 = layoutResultCallback;
                this.f37373f = new AsyncTask<Uri, Boolean, Bitmap>() {
                    /* renamed from: a */
                    public Bitmap doInBackground(Uri... uriArr) {
                        try {
                            PrintUriAdapter printUriAdapter = PrintUriAdapter.this;
                            return PrintHelper.this.d(printUriAdapter.f37369b);
                        } catch (FileNotFoundException unused) {
                            return null;
                        }
                    }

                    /* renamed from: b */
                    public void onCancelled(Bitmap bitmap) {
                        layoutResultCallback2.onLayoutCancelled();
                        PrintUriAdapter.this.f37373f = null;
                    }

                    /* renamed from: c */
                    public void onPostExecute(Bitmap bitmap) {
                        PrintAttributes.MediaSize mediaSize;
                        super.onPostExecute(bitmap);
                        if (bitmap != null && (!PrintHelper.f37351g || PrintHelper.this.f37358f == 0)) {
                            synchronized (this) {
                                mediaSize = PrintUriAdapter.this.f37372e.getMediaSize();
                            }
                            if (!(mediaSize == null || mediaSize.isPortrait() == PrintHelper.c(bitmap))) {
                                Matrix matrix = new Matrix();
                                matrix.postRotate(90.0f);
                                bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                            }
                        }
                        PrintUriAdapter.this.f37374g = bitmap;
                        if (bitmap != null) {
                            layoutResultCallback2.onLayoutFinished(new PrintDocumentInfo.Builder(PrintUriAdapter.this.f37368a).setContentType(1).setPageCount(1).build(), true ^ printAttributes3.equals(printAttributes4));
                        } else {
                            layoutResultCallback2.onLayoutFailed((CharSequence) null);
                        }
                        PrintUriAdapter.this.f37373f = null;
                    }

                    public void onPreExecute() {
                        cancellationSignal2.setOnCancelListener(new CancellationSignal.OnCancelListener() {
                            public void onCancel() {
                                PrintUriAdapter.this.a();
                                AnonymousClass1.this.cancel(false);
                            }
                        });
                    }
                }.execute(new Uri[0]);
            }
        }

        public void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
            PrintHelper.this.e(this.f37372e, this.f37371d, this.f37374g, parcelFileDescriptor, cancellationSignal, writeResultCallback);
        }
    }

    static {
        boolean z11;
        int i11 = Build.VERSION.SDK_INT;
        boolean z12 = false;
        if (i11 > 23) {
            z11 = true;
        } else {
            z11 = false;
        }
        f37351g = z11;
        if (i11 != 23) {
            z12 = true;
        }
        f37352h = z12;
    }

    public PrintHelper(@NonNull Context context) {
        this.f37353a = context;
    }

    public static Bitmap a(Bitmap bitmap, int i11) {
        if (i11 != 1) {
            return bitmap;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        canvas.setBitmap((Bitmap) null);
        return createBitmap;
    }

    public static Matrix b(int i11, int i12, RectF rectF, int i13) {
        float f11;
        Matrix matrix = new Matrix();
        float f12 = (float) i11;
        float width = rectF.width() / f12;
        if (i13 == 2) {
            f11 = Math.max(width, rectF.height() / ((float) i12));
        } else {
            f11 = Math.min(width, rectF.height() / ((float) i12));
        }
        matrix.postScale(f11, f11);
        matrix.postTranslate((rectF.width() - (f12 * f11)) / 2.0f, (rectF.height() - (((float) i12) * f11)) / 2.0f);
        return matrix;
    }

    public static boolean c(Bitmap bitmap) {
        return bitmap.getWidth() <= bitmap.getHeight();
    }

    @RequiresApi(19)
    private static PrintAttributes.Builder copyAttributes(PrintAttributes printAttributes) {
        PrintAttributes.Builder minMargins = new PrintAttributes.Builder().setMediaSize(printAttributes.getMediaSize()).setResolution(printAttributes.getResolution()).setMinMargins(printAttributes.getMinMargins());
        if (printAttributes.getColorMode() != 0) {
            minMargins.setColorMode(printAttributes.getColorMode());
        }
        if (printAttributes.getDuplexMode() != 0) {
            minMargins.setDuplexMode(printAttributes.getDuplexMode());
        }
        return minMargins;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0028 A[SYNTHETIC, Splitter:B:19:0x0028] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Bitmap loadBitmap(android.net.Uri r5, android.graphics.BitmapFactory.Options r6) throws java.io.FileNotFoundException {
        /*
            r4 = this;
            java.lang.String r0 = "close fail "
            java.lang.String r1 = "PrintHelper"
            if (r5 == 0) goto L_0x0031
            android.content.Context r2 = r4.f37353a
            if (r2 == 0) goto L_0x0031
            r3 = 0
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch:{ all -> 0x0025 }
            java.io.InputStream r5 = r2.openInputStream(r5)     // Catch:{ all -> 0x0025 }
            android.graphics.Bitmap r6 = android.graphics.BitmapFactory.decodeStream(r5, r3, r6)     // Catch:{ all -> 0x0022 }
            if (r5 == 0) goto L_0x0021
            r5.close()     // Catch:{ IOException -> 0x001d }
            goto L_0x0021
        L_0x001d:
            r5 = move-exception
            android.util.Log.w(r1, r0, r5)
        L_0x0021:
            return r6
        L_0x0022:
            r6 = move-exception
            r3 = r5
            goto L_0x0026
        L_0x0025:
            r6 = move-exception
        L_0x0026:
            if (r3 == 0) goto L_0x0030
            r3.close()     // Catch:{ IOException -> 0x002c }
            goto L_0x0030
        L_0x002c:
            r5 = move-exception
            android.util.Log.w(r1, r0, r5)
        L_0x0030:
            throw r6
        L_0x0031:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "bad argument to loadBitmap"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.print.PrintHelper.loadBitmap(android.net.Uri, android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
    }

    public static boolean systemSupportsPrint() {
        return true;
    }

    public Bitmap d(Uri uri) throws FileNotFoundException {
        BitmapFactory.Options options;
        if (uri == null || this.f37353a == null) {
            throw new IllegalArgumentException("bad argument to getScaledBitmap");
        }
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inJustDecodeBounds = true;
        loadBitmap(uri, options2);
        int i11 = options2.outWidth;
        int i12 = options2.outHeight;
        if (i11 > 0 && i12 > 0) {
            int max = Math.max(i11, i12);
            int i13 = 1;
            while (max > MAX_PRINT_SIZE) {
                max >>>= 1;
                i13 <<= 1;
            }
            if (i13 > 0 && Math.min(i11, i12) / i13 > 0) {
                synchronized (this.f37355c) {
                    options = new BitmapFactory.Options();
                    this.f37354b = options;
                    options.inMutable = true;
                    options.inSampleSize = i13;
                }
                try {
                    Bitmap loadBitmap = loadBitmap(uri, options);
                    synchronized (this.f37355c) {
                        this.f37354b = null;
                    }
                    return loadBitmap;
                } catch (Throwable th2) {
                    synchronized (this.f37355c) {
                        this.f37354b = null;
                        throw th2;
                    }
                }
            }
        }
        return null;
    }

    @RequiresApi(19)
    public void e(PrintAttributes printAttributes, int i11, Bitmap bitmap, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
        final PrintAttributes printAttributes2;
        if (f37352h) {
            printAttributes2 = printAttributes;
        } else {
            printAttributes2 = copyAttributes(printAttributes).setMinMargins(new PrintAttributes.Margins(0, 0, 0, 0)).build();
        }
        final CancellationSignal cancellationSignal2 = cancellationSignal;
        final Bitmap bitmap2 = bitmap;
        final PrintAttributes printAttributes3 = printAttributes;
        final int i12 = i11;
        final ParcelFileDescriptor parcelFileDescriptor2 = parcelFileDescriptor;
        final PrintDocumentAdapter.WriteResultCallback writeResultCallback2 = writeResultCallback;
        new AsyncTask<Void, Void, Throwable>() {
            /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
            /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x009f */
            /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x00bf */
            /* JADX WARNING: Missing exception handler attribute for start block: B:46:0x00d2 */
            /* JADX WARNING: Removed duplicated region for block: B:27:0x00a3 A[Catch:{ all -> 0x00c7, all -> 0x00da }] */
            /* JADX WARNING: Removed duplicated region for block: B:39:0x00c3 A[Catch:{ all -> 0x00c7, all -> 0x00da }] */
            /* JADX WARNING: Removed duplicated region for block: B:49:0x00d6 A[Catch:{ all -> 0x00c7, all -> 0x00da }] */
            /* renamed from: a */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Throwable doInBackground(java.lang.Void... r9) {
                /*
                    r8 = this;
                    android.os.CancellationSignal r9 = r4     // Catch:{ all -> 0x00da }
                    boolean r9 = r9.isCanceled()     // Catch:{ all -> 0x00da }
                    r0 = 0
                    if (r9 == 0) goto L_0x000a
                    return r0
                L_0x000a:
                    android.print.pdf.PrintedPdfDocument r9 = new android.print.pdf.PrintedPdfDocument     // Catch:{ all -> 0x00da }
                    androidx.print.PrintHelper r1 = androidx.print.PrintHelper.this     // Catch:{ all -> 0x00da }
                    android.content.Context r1 = r1.f37353a     // Catch:{ all -> 0x00da }
                    android.print.PrintAttributes r2 = r5     // Catch:{ all -> 0x00da }
                    r9.<init>(r1, r2)     // Catch:{ all -> 0x00da }
                    android.graphics.Bitmap r1 = r6     // Catch:{ all -> 0x00da }
                    android.print.PrintAttributes r2 = r5     // Catch:{ all -> 0x00da }
                    int r2 = r2.getColorMode()     // Catch:{ all -> 0x00da }
                    android.graphics.Bitmap r1 = androidx.print.PrintHelper.a(r1, r2)     // Catch:{ all -> 0x00da }
                    android.os.CancellationSignal r2 = r4     // Catch:{ all -> 0x00da }
                    boolean r2 = r2.isCanceled()     // Catch:{ all -> 0x00da }
                    if (r2 == 0) goto L_0x002a
                    return r0
                L_0x002a:
                    r2 = 1
                    android.graphics.pdf.PdfDocument$Page r3 = r9.startPage(r2)     // Catch:{ all -> 0x00c7 }
                    boolean r4 = androidx.print.PrintHelper.f37352h     // Catch:{ all -> 0x00c7 }
                    if (r4 == 0) goto L_0x0041
                    android.graphics.RectF r2 = new android.graphics.RectF     // Catch:{ all -> 0x00c7 }
                    android.graphics.pdf.PdfDocument$PageInfo r5 = r3.getInfo()     // Catch:{ all -> 0x00c7 }
                    android.graphics.Rect r5 = r5.getContentRect()     // Catch:{ all -> 0x00c7 }
                    r2.<init>(r5)     // Catch:{ all -> 0x00c7 }
                    goto L_0x0064
                L_0x0041:
                    android.print.pdf.PrintedPdfDocument r5 = new android.print.pdf.PrintedPdfDocument     // Catch:{ all -> 0x00c7 }
                    androidx.print.PrintHelper r6 = androidx.print.PrintHelper.this     // Catch:{ all -> 0x00c7 }
                    android.content.Context r6 = r6.f37353a     // Catch:{ all -> 0x00c7 }
                    android.print.PrintAttributes r7 = r7     // Catch:{ all -> 0x00c7 }
                    r5.<init>(r6, r7)     // Catch:{ all -> 0x00c7 }
                    android.graphics.pdf.PdfDocument$Page r2 = r5.startPage(r2)     // Catch:{ all -> 0x00c7 }
                    android.graphics.RectF r6 = new android.graphics.RectF     // Catch:{ all -> 0x00c7 }
                    android.graphics.pdf.PdfDocument$PageInfo r7 = r2.getInfo()     // Catch:{ all -> 0x00c7 }
                    android.graphics.Rect r7 = r7.getContentRect()     // Catch:{ all -> 0x00c7 }
                    r6.<init>(r7)     // Catch:{ all -> 0x00c7 }
                    r5.finishPage(r2)     // Catch:{ all -> 0x00c7 }
                    r5.close()     // Catch:{ all -> 0x00c7 }
                    r2 = r6
                L_0x0064:
                    int r5 = r1.getWidth()     // Catch:{ all -> 0x00c7 }
                    int r6 = r1.getHeight()     // Catch:{ all -> 0x00c7 }
                    int r7 = r8     // Catch:{ all -> 0x00c7 }
                    android.graphics.Matrix r5 = androidx.print.PrintHelper.b(r5, r6, r2, r7)     // Catch:{ all -> 0x00c7 }
                    if (r4 == 0) goto L_0x0075
                    goto L_0x0083
                L_0x0075:
                    float r4 = r2.left     // Catch:{ all -> 0x00c7 }
                    float r6 = r2.top     // Catch:{ all -> 0x00c7 }
                    r5.postTranslate(r4, r6)     // Catch:{ all -> 0x00c7 }
                    android.graphics.Canvas r4 = r3.getCanvas()     // Catch:{ all -> 0x00c7 }
                    r4.clipRect(r2)     // Catch:{ all -> 0x00c7 }
                L_0x0083:
                    android.graphics.Canvas r2 = r3.getCanvas()     // Catch:{ all -> 0x00c7 }
                    r2.drawBitmap(r1, r5, r0)     // Catch:{ all -> 0x00c7 }
                    r9.finishPage(r3)     // Catch:{ all -> 0x00c7 }
                    android.os.CancellationSignal r2 = r4     // Catch:{ all -> 0x00c7 }
                    boolean r2 = r2.isCanceled()     // Catch:{ all -> 0x00c7 }
                    if (r2 == 0) goto L_0x00a7
                    r9.close()     // Catch:{ all -> 0x00da }
                    android.os.ParcelFileDescriptor r9 = r9     // Catch:{ all -> 0x00da }
                    if (r9 == 0) goto L_0x009f
                    r9.close()     // Catch:{ IOException -> 0x009f }
                L_0x009f:
                    android.graphics.Bitmap r9 = r6     // Catch:{ all -> 0x00da }
                    if (r1 == r9) goto L_0x00a6
                    r1.recycle()     // Catch:{ all -> 0x00da }
                L_0x00a6:
                    return r0
                L_0x00a7:
                    java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x00c7 }
                    android.os.ParcelFileDescriptor r3 = r9     // Catch:{ all -> 0x00c7 }
                    java.io.FileDescriptor r3 = r3.getFileDescriptor()     // Catch:{ all -> 0x00c7 }
                    r2.<init>(r3)     // Catch:{ all -> 0x00c7 }
                    r9.writeTo(r2)     // Catch:{ all -> 0x00c7 }
                    r9.close()     // Catch:{ all -> 0x00da }
                    android.os.ParcelFileDescriptor r9 = r9     // Catch:{ all -> 0x00da }
                    if (r9 == 0) goto L_0x00bf
                    r9.close()     // Catch:{ IOException -> 0x00bf }
                L_0x00bf:
                    android.graphics.Bitmap r9 = r6     // Catch:{ all -> 0x00da }
                    if (r1 == r9) goto L_0x00c6
                    r1.recycle()     // Catch:{ all -> 0x00da }
                L_0x00c6:
                    return r0
                L_0x00c7:
                    r0 = move-exception
                    r9.close()     // Catch:{ all -> 0x00da }
                    android.os.ParcelFileDescriptor r9 = r9     // Catch:{ all -> 0x00da }
                    if (r9 == 0) goto L_0x00d2
                    r9.close()     // Catch:{ IOException -> 0x00d2 }
                L_0x00d2:
                    android.graphics.Bitmap r9 = r6     // Catch:{ all -> 0x00da }
                    if (r1 == r9) goto L_0x00d9
                    r1.recycle()     // Catch:{ all -> 0x00da }
                L_0x00d9:
                    throw r0     // Catch:{ all -> 0x00da }
                L_0x00da:
                    r9 = move-exception
                    return r9
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.print.PrintHelper.AnonymousClass1.doInBackground(java.lang.Void[]):java.lang.Throwable");
            }

            /* renamed from: b */
            public void onPostExecute(Throwable th2) {
                if (cancellationSignal2.isCanceled()) {
                    writeResultCallback2.onWriteCancelled();
                } else if (th2 == null) {
                    writeResultCallback2.onWriteFinished(new PageRange[]{PageRange.ALL_PAGES});
                } else {
                    Log.e(PrintHelper.LOG_TAG, "Error writing printed content", th2);
                    writeResultCallback2.onWriteFailed((CharSequence) null);
                }
            }
        }.execute(new Void[0]);
    }

    public int getColorMode() {
        return this.f37357e;
    }

    public int getOrientation() {
        int i11 = this.f37358f;
        if (i11 == 0) {
            return 1;
        }
        return i11;
    }

    public int getScaleMode() {
        return this.f37356d;
    }

    public void printBitmap(@NonNull String str, @NonNull Bitmap bitmap) {
        printBitmap(str, bitmap, (OnPrintFinishCallback) null);
    }

    public void setColorMode(int i11) {
        this.f37357e = i11;
    }

    public void setOrientation(int i11) {
        this.f37358f = i11;
    }

    public void setScaleMode(int i11) {
        this.f37356d = i11;
    }

    public void printBitmap(@NonNull String str, @NonNull Bitmap bitmap, @Nullable OnPrintFinishCallback onPrintFinishCallback) {
        PrintAttributes.MediaSize mediaSize;
        if (bitmap != null) {
            PrintManager printManager = (PrintManager) this.f37353a.getSystemService("print");
            if (c(bitmap)) {
                mediaSize = PrintAttributes.MediaSize.UNKNOWN_PORTRAIT;
            } else {
                mediaSize = PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE;
            }
            printManager.print(str, new PrintBitmapAdapter(str, this.f37356d, bitmap, onPrintFinishCallback), new PrintAttributes.Builder().setMediaSize(mediaSize).setColorMode(this.f37357e).build());
        }
    }

    public void printBitmap(@NonNull String str, @NonNull Uri uri) throws FileNotFoundException {
        printBitmap(str, uri, (OnPrintFinishCallback) null);
    }

    public void printBitmap(@NonNull String str, @NonNull Uri uri, @Nullable OnPrintFinishCallback onPrintFinishCallback) throws FileNotFoundException {
        PrintUriAdapter printUriAdapter = new PrintUriAdapter(str, uri, onPrintFinishCallback, this.f37356d);
        PrintManager printManager = (PrintManager) this.f37353a.getSystemService("print");
        PrintAttributes.Builder builder = new PrintAttributes.Builder();
        builder.setColorMode(this.f37357e);
        int i11 = this.f37358f;
        if (i11 == 1 || i11 == 0) {
            builder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE);
        } else if (i11 == 2) {
            builder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_PORTRAIT);
        }
        printManager.print(str, printUriAdapter, builder.build());
    }
}
