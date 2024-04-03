package com.deliveryhero.chatui.data.datasource;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import androidx.core.content.FileProvider;
import androidx.exifinterface.media.ExifInterface;
import com.deliveryhero.customerchat.BuildConfig;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Instrumented
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\"\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\bH\u0016J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\bH\u0002J \u0010\u0015\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0016H\u0002J\u0018\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0016H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/deliveryhero/chatui/data/datasource/ImageFileProviderImpl;", "Lcom/deliveryhero/chatui/data/datasource/ImageFileProvider;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "createImageFile", "Ljava/io/File;", "imageFileName", "", "getEditedImageFile", "cameraFilePath", "quality", "", "isAutoRotated", "", "getImageFileUri", "Landroid/net/Uri;", "imageFile", "isFileExisted", "path", "readImageRotatedDegree", "rotateImage", "Landroid/graphics/Bitmap;", "originPath", "bitmap", "rotatingImageView", "angle", "Companion", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ImageFileProviderImpl implements ImageFileProvider {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String IMAGE_SUFFIX = ".jpg";
    private static final int ROTATE_180 = 180;
    private static final int ROTATE_270 = 270;
    private static final int ROTATE_90 = 90;
    @NotNull
    private static final String TAG = "ImageFileProvider";
    @NotNull
    private final Context context;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/deliveryhero/chatui/data/datasource/ImageFileProviderImpl$Companion;", "", "()V", "IMAGE_SUFFIX", "", "ROTATE_180", "", "ROTATE_270", "ROTATE_90", "TAG", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ImageFileProviderImpl(@NotNull Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    private final int readImageRotatedDegree(String str) {
        int i11;
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
            if (attributeInt == 3) {
                i11 = 180;
            } else if (attributeInt == 6) {
                i11 = 90;
            } else if (attributeInt != 8) {
                return 0;
            } else {
                i11 = ROTATE_270;
            }
            return i11;
        } catch (IOException e11) {
            Log.e(TAG, "Exception rotating image: " + e11.getLocalizedMessage());
            return 0;
        }
    }

    private final Bitmap rotateImage(boolean z11, String str, Bitmap bitmap) {
        int readImageRotatedDegree = readImageRotatedDegree(str);
        if (!z11 || readImageRotatedDegree == 0) {
            return bitmap;
        }
        return rotatingImageView(readImageRotatedDegree, bitmap);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0019, code lost:
        if (r8 == null) goto L_0x0033;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final android.graphics.Bitmap rotatingImageView(int r8, android.graphics.Bitmap r9) {
        /*
            r7 = this;
            android.graphics.Matrix r5 = new android.graphics.Matrix
            r5.<init>()
            float r8 = (float) r8
            r5.postRotate(r8)
            r1 = 0
            r2 = 0
            int r3 = r9.getWidth()     // Catch:{ OutOfMemoryError -> 0x001c }
            int r4 = r9.getHeight()     // Catch:{ OutOfMemoryError -> 0x001c }
            r6 = 1
            r0 = r9
            android.graphics.Bitmap r8 = android.graphics.Bitmap.createBitmap(r0, r1, r2, r3, r4, r5, r6)     // Catch:{ OutOfMemoryError -> 0x001c }
            if (r8 != 0) goto L_0x0034
            goto L_0x0033
        L_0x001c:
            r8 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "rotatingImageView Out of memory: "
            r0.append(r1)
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            java.lang.String r0 = "ImageFileProvider"
            android.util.Log.e(r0, r8)
        L_0x0033:
            r8 = r9
        L_0x0034:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r8)
            if (r0 != 0) goto L_0x003d
            r9.recycle()
        L_0x003d:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.chatui.data.datasource.ImageFileProviderImpl.rotatingImageView(int, android.graphics.Bitmap):android.graphics.Bitmap");
    }

    @NotNull
    public File createImageFile(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "imageFileName");
        File createTempFile = File.createTempFile(str, IMAGE_SUFFIX, this.context.getExternalFilesDir(Environment.DIRECTORY_PICTURES));
        Intrinsics.checkNotNullExpressionValue(createTempFile, "createTempFile(\n        …     storageDir\n        )");
        return createTempFile;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004a, code lost:
        if (r7 == null) goto L_0x0058;
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0054  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.io.File getEditedImageFile(@org.jetbrains.annotations.NotNull java.lang.String r5, int r6, boolean r7) {
        /*
            r4 = this;
            java.lang.String r0 = "cameraFilePath"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            r1 = 0
            if (r0 == 0) goto L_0x000d
            return r1
        L_0x000d:
            android.graphics.Bitmap r0 = com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation.decodeFile(r5)
            if (r0 == 0) goto L_0x0058
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream
            r2.<init>()
            android.graphics.Bitmap r7 = r4.rotateImage(r7, r5, r0)
            android.graphics.Bitmap$CompressFormat r3 = android.graphics.Bitmap.CompressFormat.JPEG
            r7.compress(r3, r6, r2)
            byte[] r6 = r2.toByteArray()
            r0.recycle()
            java.io.BufferedOutputStream r7 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x003f, all -> 0x003d }
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x003f, all -> 0x003d }
            r0.<init>(r5)     // Catch:{ IOException -> 0x003f, all -> 0x003d }
            r7.<init>(r0)     // Catch:{ IOException -> 0x003f, all -> 0x003d }
            r7.write(r6)     // Catch:{ IOException -> 0x003b }
            r7.flush()     // Catch:{ IOException -> 0x003b }
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ IOException -> 0x003b }
            goto L_0x004c
        L_0x003b:
            r6 = move-exception
            goto L_0x0041
        L_0x003d:
            r5 = move-exception
            goto L_0x0052
        L_0x003f:
            r6 = move-exception
            r7 = r1
        L_0x0041:
            java.lang.String r0 = "Compress Image File"
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0050 }
            android.util.Log.e(r0, r6)     // Catch:{ all -> 0x0050 }
            if (r7 == 0) goto L_0x0058
        L_0x004c:
            r7.close()
            goto L_0x0058
        L_0x0050:
            r5 = move-exception
            r1 = r7
        L_0x0052:
            if (r1 == 0) goto L_0x0057
            r1.close()
        L_0x0057:
            throw r5
        L_0x0058:
            java.io.File r6 = new java.io.File     // Catch:{ FileNotFoundException -> 0x005e }
            r6.<init>(r5)     // Catch:{ FileNotFoundException -> 0x005e }
            r1 = r6
        L_0x005e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.chatui.data.datasource.ImageFileProviderImpl.getEditedImageFile(java.lang.String, int, boolean):java.io.File");
    }

    @NotNull
    public Uri getImageFileUri(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "imageFile");
        try {
            Context context2 = this.context;
            Uri uriForFile = FileProvider.getUriForFile(context2, this.context.getPackageName() + BuildConfig.IMAGE_FILE_PROVIDER_AUTHORITY, file);
            Intrinsics.checkNotNullExpressionValue(uriForFile, "{\n            FileProvid…e\n            )\n        }");
            return uriForFile;
        } catch (IllegalArgumentException unused) {
            Uri fromFile = Uri.fromFile(file);
            Intrinsics.checkNotNullExpressionValue(fromFile, "{\n            Uri.fromFile(imageFile)\n        }");
            return fromFile;
        }
    }

    public boolean isFileExisted(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "path");
        return new File(str).exists();
    }
}
