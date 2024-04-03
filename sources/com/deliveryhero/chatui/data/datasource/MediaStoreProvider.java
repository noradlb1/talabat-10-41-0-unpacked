package com.deliveryhero.chatui.data.datasource;

import android.content.ContentResolver;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.net.Uri;
import com.deliveryhero.customerchat.R;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Instrumented
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/deliveryhero/chatui/data/datasource/MediaStoreProvider;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "saveTempImage", "", "imageUri", "Landroid/net/Uri;", "saveToGallery", "", "file", "Ljava/io/File;", "Companion", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MediaStoreProvider {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String EMPTY_STRING = "";
    private static final int IMAGE_QUALITY = 100;
    @NotNull
    private static final String MIME_TYPE = "image/jpeg";
    @NotNull
    private static final String PICTURE_LOCATION = "Pictures";
    @NotNull
    private final Context context;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/deliveryhero/chatui/data/datasource/MediaStoreProvider$Companion;", "", "()V", "EMPTY_STRING", "", "IMAGE_QUALITY", "", "MIME_TYPE", "PICTURE_LOCATION", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public MediaStoreProvider(@NotNull Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    @NotNull
    public final String saveTempImage(@NotNull Uri uri) {
        InputStream openInputStream;
        Bitmap decodeStream;
        Intrinsics.checkNotNullParameter(uri, "imageUri");
        ContentResolver contentResolver = this.context.getContentResolver();
        if (contentResolver == null || (openInputStream = contentResolver.openInputStream(uri)) == null || (decodeStream = BitmapFactoryInstrumentation.decodeStream(openInputStream)) == null) {
            return "";
        }
        File dir = new ContextWrapper(this.context.getApplicationContext()).getDir(PICTURE_LOCATION, 0);
        if (!dir.exists()) {
            dir.mkdir();
        }
        File file = new File(dir, this.context.getString(R.string.customer_chat_image_title));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            decodeStream.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.close();
        } catch (FileNotFoundException unused) {
        } catch (Throwable th2) {
            openInputStream.close();
            throw th2;
        }
        openInputStream.close();
        String path = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "imagePath.path");
        return path;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0075, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0076, code lost:
        kotlin.io.CloseableKt.closeFinally(r5, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0079, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void saveToGallery(@org.jetbrains.annotations.NotNull java.io.File r5) {
        /*
            r4 = this;
            java.lang.String r0 = "file"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = r5.getAbsolutePath()
            android.graphics.Bitmap r0 = com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation.decodeFile(r0)
            java.lang.String r1 = "decodeFile(file.absolutePath)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 29
            r3 = 0
            if (r1 < r2) goto L_0x0050
            android.content.ContentValues r1 = new android.content.ContentValues
            r1.<init>()
            java.lang.String r2 = "_display_name"
            java.lang.String r5 = r5.getName()
            r1.put(r2, r5)
            java.lang.String r5 = "mime_type"
            java.lang.String r2 = "image/jpeg"
            r1.put(r5, r2)
            java.lang.String r5 = "relative_path"
            java.lang.String r2 = android.os.Environment.DIRECTORY_PICTURES
            r1.put(r5, r2)
            android.content.Context r5 = r4.context
            android.content.ContentResolver r5 = r5.getContentResolver()
            android.net.Uri r2 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            android.net.Uri r5 = r5.insert(r2, r1)
            if (r5 == 0) goto L_0x004e
            android.content.Context r1 = r4.context
            android.content.ContentResolver r1 = r1.getContentResolver()
            java.io.OutputStream r5 = r1.openOutputStream(r5)
            goto L_0x0066
        L_0x004e:
            r5 = r3
            goto L_0x0066
        L_0x0050:
            android.content.Context r1 = r4.context
            java.lang.String r2 = android.os.Environment.DIRECTORY_PICTURES
            java.io.File r1 = r1.getExternalFilesDir(r2)
            java.io.File r2 = new java.io.File
            java.lang.String r5 = r5.getName()
            r2.<init>(r1, r5)
            java.io.FileOutputStream r5 = new java.io.FileOutputStream
            r5.<init>(r2)
        L_0x0066:
            if (r5 == 0) goto L_0x007a
            android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ all -> 0x0073 }
            r2 = 100
            r0.compress(r1, r2, r5)     // Catch:{ all -> 0x0073 }
            kotlin.io.CloseableKt.closeFinally(r5, r3)
            goto L_0x007a
        L_0x0073:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0075 }
        L_0x0075:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r5, r0)
            throw r1
        L_0x007a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.chatui.data.datasource.MediaStoreProvider.saveToGallery(java.io.File):void");
    }
}
