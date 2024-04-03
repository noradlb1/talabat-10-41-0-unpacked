package io.flutter.plugins.imagepicker;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import com.deliveryhero.chatui.data.datasource.ImageFileProviderImpl;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

public class ImagePickerDelegate implements PluginRegistry.ActivityResultListener, PluginRegistry.RequestPermissionsResultListener {
    private final Activity activity;
    @VisibleForTesting

    /* renamed from: b  reason: collision with root package name */
    public final String f14365b;
    @VisibleForTesting

    /* renamed from: c  reason: collision with root package name */
    public final File f14366c;
    private final ImagePickerCache cache;
    private CameraDevice cameraDevice;
    private final FileUriResolver fileUriResolver;
    private final FileUtils fileUtils;
    private final ImageResizer imageResizer;
    private final IntentResolver intentResolver;
    private MethodCall methodCall;
    private Uri pendingCameraMediaUri;
    private MethodChannel.Result pendingResult;
    private final PermissionManager permissionManager;

    public interface FileUriResolver {
        void getFullImagePath(Uri uri, OnPathReadyListener onPathReadyListener);

        Uri resolveFileProviderUriForFile(String str, File file);
    }

    public interface IntentResolver {
        boolean resolveActivity(Intent intent);
    }

    public interface OnPathReadyListener {
        void onPathReady(String str);
    }

    public interface PermissionManager {
        void askForPermission(String str, int i11);

        boolean isPermissionGranted(String str);

        boolean needRequestCameraPermission();
    }

    public ImagePickerDelegate(final Activity activity2, File file, ImageResizer imageResizer2, ImagePickerCache imagePickerCache) {
        this(activity2, file, imageResizer2, (MethodChannel.Result) null, (MethodCall) null, imagePickerCache, new PermissionManager() {
            public void askForPermission(String str, int i11) {
                ActivityCompat.requestPermissions(activity2, new String[]{str}, i11);
            }

            public boolean isPermissionGranted(String str) {
                return ContextCompat.checkSelfPermission(activity2, str) == 0;
            }

            public boolean needRequestCameraPermission() {
                return ImagePickerUtils.a(activity2);
            }
        }, new IntentResolver() {
            public boolean resolveActivity(Intent intent) {
                return intent.resolveActivity(activity2.getPackageManager()) != null;
            }
        }, new FileUriResolver() {
            public void getFullImagePath(Uri uri, final OnPathReadyListener onPathReadyListener) {
                String str;
                Activity activity = activity2;
                String[] strArr = new String[1];
                if (uri != null) {
                    str = uri.getPath();
                } else {
                    str = "";
                }
                strArr[0] = str;
                MediaScannerConnection.scanFile(activity, strArr, (String[]) null, new MediaScannerConnection.OnScanCompletedListener() {
                    public void onScanCompleted(String str, Uri uri) {
                        onPathReadyListener.onPathReady(str);
                    }
                });
            }

            public Uri resolveFileProviderUriForFile(String str, File file) {
                return FileProvider.getUriForFile(activity2, str, file);
            }
        }, new FileUtils());
    }

    private void clearMethodCallAndResult() {
        this.methodCall = null;
        this.pendingResult = null;
    }

    private File createTemporaryWritableFile(String str) {
        try {
            return File.createTempFile(UUID.randomUUID().toString(), str, this.f14366c);
        } catch (IOException e11) {
            throw new RuntimeException(e11);
        }
    }

    private File createTemporaryWritableImageFile() {
        return createTemporaryWritableFile(ImageFileProviderImpl.IMAGE_SUFFIX);
    }

    private File createTemporaryWritableVideoFile() {
        return createTemporaryWritableFile(".mp4");
    }

    private void finishWithAlreadyActiveError(MethodChannel.Result result) {
        result.error("already_active", "Image picker is already active", (Object) null);
    }

    private void finishWithError(String str, String str2) {
        MethodChannel.Result result = this.pendingResult;
        if (result == null) {
            this.cache.f((String) null, str, str2);
            return;
        }
        result.error(str, str2, (Object) null);
        clearMethodCallAndResult();
    }

    private void finishWithListSuccess(ArrayList<String> arrayList) {
        MethodChannel.Result result = this.pendingResult;
        if (result == null) {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                this.cache.f(it.next(), (String) null, (String) null);
            }
            return;
        }
        result.success(arrayList);
        clearMethodCallAndResult();
    }

    private void finishWithSuccess(String str) {
        MethodChannel.Result result = this.pendingResult;
        if (result == null) {
            this.cache.f(str, (String) null, (String) null);
            return;
        }
        result.success(str);
        clearMethodCallAndResult();
    }

    private String getResizedImagePath(String str) {
        return this.imageResizer.a(str, (Double) this.methodCall.argument("maxWidth"), (Double) this.methodCall.argument("maxHeight"), (Integer) this.methodCall.argument("imageQuality"));
    }

    private void grantUriPermissions(Intent intent, Uri uri) {
        for (ResolveInfo resolveInfo : this.activity.getPackageManager().queryIntentActivities(intent, 65536)) {
            this.activity.grantUriPermission(resolveInfo.activityInfo.packageName, uri, 3);
        }
    }

    private void handleCaptureImageResult(int i11) {
        if (i11 == -1) {
            FileUriResolver fileUriResolver2 = this.fileUriResolver;
            Uri uri = this.pendingCameraMediaUri;
            if (uri == null) {
                uri = Uri.parse(this.cache.c());
            }
            fileUriResolver2.getFullImagePath(uri, new OnPathReadyListener() {
                public void onPathReady(String str) {
                    ImagePickerDelegate.this.handleImageResult(str, true);
                }
            });
            return;
        }
        finishWithSuccess((String) null);
    }

    private void handleCaptureVideoResult(int i11) {
        if (i11 == -1) {
            FileUriResolver fileUriResolver2 = this.fileUriResolver;
            Uri uri = this.pendingCameraMediaUri;
            if (uri == null) {
                uri = Uri.parse(this.cache.c());
            }
            fileUriResolver2.getFullImagePath(uri, new OnPathReadyListener() {
                public void onPathReady(String str) {
                    ImagePickerDelegate.this.handleVideoResult(str);
                }
            });
            return;
        }
        finishWithSuccess((String) null);
    }

    private void handleChooseImageResult(int i11, Intent intent) {
        if (i11 != -1 || intent == null) {
            finishWithSuccess((String) null);
        } else {
            handleImageResult(this.fileUtils.a(this.activity, intent.getData()), false);
        }
    }

    private void handleChooseMultiImageResult(int i11, Intent intent) {
        if (i11 != -1 || intent == null) {
            finishWithSuccess((String) null);
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (intent.getClipData() != null) {
            for (int i12 = 0; i12 < intent.getClipData().getItemCount(); i12++) {
                arrayList.add(this.fileUtils.a(this.activity, intent.getClipData().getItemAt(i12).getUri()));
            }
        } else {
            arrayList.add(this.fileUtils.a(this.activity, intent.getData()));
        }
        handleMultiImageResult(arrayList, false);
    }

    private void handleChooseVideoResult(int i11, Intent intent) {
        if (i11 != -1 || intent == null) {
            finishWithSuccess((String) null);
        } else {
            handleVideoResult(this.fileUtils.a(this.activity, intent.getData()));
        }
    }

    /* access modifiers changed from: private */
    public void handleImageResult(String str, boolean z11) {
        if (this.methodCall != null) {
            String resizedImagePath = getResizedImagePath(str);
            if (resizedImagePath != null && !resizedImagePath.equals(str) && z11) {
                new File(str).delete();
            }
            finishWithSuccess(resizedImagePath);
            return;
        }
        finishWithSuccess(str);
    }

    private void handleMultiImageResult(ArrayList<String> arrayList, boolean z11) {
        if (this.methodCall != null) {
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                String resizedImagePath = getResizedImagePath(arrayList.get(i11));
                if (resizedImagePath != null && !resizedImagePath.equals(arrayList.get(i11)) && z11) {
                    new File(arrayList.get(i11)).delete();
                }
                arrayList.set(i11, resizedImagePath);
            }
            finishWithListSuccess(arrayList);
        }
    }

    /* access modifiers changed from: private */
    public void handleVideoResult(String str) {
        finishWithSuccess(str);
    }

    private void launchMultiPickImageFromGalleryIntent() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        intent.setType("image/*");
        this.activity.startActivityForResult(intent, 2346);
    }

    private void launchPickImageFromGalleryIntent() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        this.activity.startActivityForResult(intent, 2342);
    }

    private void launchPickVideoFromGalleryIntent() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("video/*");
        this.activity.startActivityForResult(intent, 2352);
    }

    private void launchTakeImageWithCameraIntent() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (this.cameraDevice == CameraDevice.FRONT) {
            useFrontCamera(intent);
        }
        if (!this.intentResolver.resolveActivity(intent)) {
            finishWithError("no_available_camera", "No cameras available for taking pictures.");
            return;
        }
        File createTemporaryWritableImageFile = createTemporaryWritableImageFile();
        this.pendingCameraMediaUri = Uri.parse("file:" + createTemporaryWritableImageFile.getAbsolutePath());
        Uri resolveFileProviderUriForFile = this.fileUriResolver.resolveFileProviderUriForFile(this.f14365b, createTemporaryWritableImageFile);
        intent.putExtra("output", resolveFileProviderUriForFile);
        grantUriPermissions(intent, resolveFileProviderUriForFile);
        this.activity.startActivityForResult(intent, 2343);
    }

    private void launchTakeVideoWithCameraIntent() {
        Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        MethodCall methodCall2 = this.methodCall;
        if (!(methodCall2 == null || methodCall2.argument("maxDuration") == null)) {
            intent.putExtra("android.intent.extra.durationLimit", ((Integer) this.methodCall.argument("maxDuration")).intValue());
        }
        if (this.cameraDevice == CameraDevice.FRONT) {
            useFrontCamera(intent);
        }
        if (!this.intentResolver.resolveActivity(intent)) {
            finishWithError("no_available_camera", "No cameras available for taking pictures.");
            return;
        }
        File createTemporaryWritableVideoFile = createTemporaryWritableVideoFile();
        this.pendingCameraMediaUri = Uri.parse("file:" + createTemporaryWritableVideoFile.getAbsolutePath());
        Uri resolveFileProviderUriForFile = this.fileUriResolver.resolveFileProviderUriForFile(this.f14365b, createTemporaryWritableVideoFile);
        intent.putExtra("output", resolveFileProviderUriForFile);
        grantUriPermissions(intent, resolveFileProviderUriForFile);
        this.activity.startActivityForResult(intent, 2353);
    }

    private boolean needRequestCameraPermission() {
        PermissionManager permissionManager2 = this.permissionManager;
        if (permissionManager2 == null) {
            return false;
        }
        return permissionManager2.needRequestCameraPermission();
    }

    private boolean setPendingMethodCallAndResult(MethodCall methodCall2, MethodChannel.Result result) {
        if (this.pendingResult != null) {
            return false;
        }
        this.methodCall = methodCall2;
        this.pendingResult = result;
        this.cache.a();
        return true;
    }

    private void useFrontCamera(Intent intent) {
        int i11 = Build.VERSION.SDK_INT;
        intent.putExtra("android.intent.extras.CAMERA_FACING", 0);
        if (i11 >= 26) {
            intent.putExtra("android.intent.extra.USE_FRONT_CAMERA", true);
        }
    }

    public void c(MethodChannel.Result result) {
        int i11;
        Map<String, Object> b11 = this.cache.b();
        String str = (String) b11.get("path");
        if (str != null) {
            Double d11 = (Double) b11.get("maxWidth");
            Double d12 = (Double) b11.get("maxHeight");
            if (b11.get("imageQuality") == null) {
                i11 = 100;
            } else {
                i11 = ((Integer) b11.get("imageQuality")).intValue();
            }
            b11.put("path", this.imageResizer.a(str, d11, d12, Integer.valueOf(i11)));
        }
        if (b11.isEmpty()) {
            result.success((Object) null);
        } else {
            result.success(b11);
        }
        this.cache.a();
    }

    public void chooseImageFromGallery(MethodCall methodCall2, MethodChannel.Result result) {
        if (!setPendingMethodCallAndResult(methodCall2, result)) {
            finishWithAlreadyActiveError(result);
        } else {
            launchPickImageFromGalleryIntent();
        }
    }

    public void chooseMultiImageFromGallery(MethodCall methodCall2, MethodChannel.Result result) {
        if (!setPendingMethodCallAndResult(methodCall2, result)) {
            finishWithAlreadyActiveError(result);
        } else {
            launchMultiPickImageFromGalleryIntent();
        }
    }

    public void chooseVideoFromGallery(MethodCall methodCall2, MethodChannel.Result result) {
        if (!setPendingMethodCallAndResult(methodCall2, result)) {
            finishWithAlreadyActiveError(result);
        } else {
            launchPickVideoFromGalleryIntent();
        }
    }

    public void d() {
        MethodCall methodCall2 = this.methodCall;
        if (methodCall2 != null) {
            this.cache.g(methodCall2.method);
            this.cache.d(this.methodCall);
            Uri uri = this.pendingCameraMediaUri;
            if (uri != null) {
                this.cache.e(uri);
            }
        }
    }

    public void e(CameraDevice cameraDevice2) {
        this.cameraDevice = cameraDevice2;
    }

    public boolean onActivityResult(int i11, int i12, Intent intent) {
        if (i11 == 2342) {
            handleChooseImageResult(i12, intent);
            return true;
        } else if (i11 == 2343) {
            handleCaptureImageResult(i12);
            return true;
        } else if (i11 == 2346) {
            handleChooseMultiImageResult(i12, intent);
            return true;
        } else if (i11 == 2352) {
            handleChooseVideoResult(i12, intent);
            return true;
        } else if (i11 != 2353) {
            return false;
        } else {
            handleCaptureVideoResult(i12);
            return true;
        }
    }

    public boolean onRequestPermissionsResult(int i11, String[] strArr, int[] iArr) {
        boolean z11;
        if (iArr.length <= 0 || iArr[0] != 0) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (i11 != 2345) {
            if (i11 != 2355) {
                return false;
            }
            if (z11) {
                launchTakeVideoWithCameraIntent();
            }
        } else if (z11) {
            launchTakeImageWithCameraIntent();
        }
        if (!z11 && (i11 == 2345 || i11 == 2355)) {
            finishWithError("camera_access_denied", "The user did not allow camera access.");
        }
        return true;
    }

    public void takeImageWithCamera(MethodCall methodCall2, MethodChannel.Result result) {
        if (!setPendingMethodCallAndResult(methodCall2, result)) {
            finishWithAlreadyActiveError(result);
        } else if (!needRequestCameraPermission() || this.permissionManager.isPermissionGranted("android.permission.CAMERA")) {
            launchTakeImageWithCameraIntent();
        } else {
            this.permissionManager.askForPermission("android.permission.CAMERA", 2345);
        }
    }

    public void takeVideoWithCamera(MethodCall methodCall2, MethodChannel.Result result) {
        if (!setPendingMethodCallAndResult(methodCall2, result)) {
            finishWithAlreadyActiveError(result);
        } else if (!needRequestCameraPermission() || this.permissionManager.isPermissionGranted("android.permission.CAMERA")) {
            launchTakeVideoWithCameraIntent();
        } else {
            this.permissionManager.askForPermission("android.permission.CAMERA", 2355);
        }
    }

    @VisibleForTesting
    public ImagePickerDelegate(Activity activity2, File file, ImageResizer imageResizer2, MethodChannel.Result result, MethodCall methodCall2, ImagePickerCache imagePickerCache, PermissionManager permissionManager2, IntentResolver intentResolver2, FileUriResolver fileUriResolver2, FileUtils fileUtils2) {
        this.activity = activity2;
        this.f14366c = file;
        this.imageResizer = imageResizer2;
        this.f14365b = activity2.getPackageName() + ".flutter.image_provider";
        this.pendingResult = result;
        this.methodCall = methodCall2;
        this.permissionManager = permissionManager2;
        this.intentResolver = intentResolver2;
        this.fileUriResolver = fileUriResolver2;
        this.fileUtils = fileUtils2;
        this.cache = imagePickerCache;
    }
}
