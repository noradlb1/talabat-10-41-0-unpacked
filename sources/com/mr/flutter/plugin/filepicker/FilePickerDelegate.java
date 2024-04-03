package com.mr.flutter.plugin.filepicker;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.huawei.location.lite.common.util.PermissionUtil;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class FilePickerDelegate implements PluginRegistry.ActivityResultListener, PluginRegistry.RequestPermissionsResultListener {
    private static final int REQUEST_CODE = ((FilePickerPlugin.class.hashCode() + 43) & 65535);
    private static final String TAG = "FilePickerDelegate";
    /* access modifiers changed from: private */
    public final Activity activity;
    private String[] allowedExtensions;
    /* access modifiers changed from: private */
    public EventChannel.EventSink eventSink;
    private boolean isMultipleSelection;
    /* access modifiers changed from: private */
    public boolean loadDataToMemory;
    private MethodChannel.Result pendingResult;
    private final PermissionManager permissionManager;
    /* access modifiers changed from: private */
    public String type;

    public interface PermissionManager {
        void askForPermission(String str, int i11);

        boolean isPermissionGranted(String str);
    }

    public FilePickerDelegate(final Activity activity2) {
        this(activity2, (MethodChannel.Result) null, new PermissionManager() {
            public void askForPermission(String str, int i11) {
                ActivityCompat.requestPermissions(activity2, new String[]{str}, i11);
            }

            public boolean isPermissionGranted(String str) {
                return ContextCompat.checkSelfPermission(activity2, str) == 0;
            }
        });
    }

    private void clearPendingResult() {
        this.pendingResult = null;
    }

    private void dispatchEventStatus(final boolean z11) {
        if (this.eventSink != null && !this.type.equals("dir")) {
            new Handler(Looper.getMainLooper()) {
                public void handleMessage(Message message) {
                    FilePickerDelegate.this.eventSink.success(Boolean.valueOf(z11));
                }
            }.obtainMessage().sendToTarget();
        }
    }

    private static void finishWithAlreadyActiveError(MethodChannel.Result result) {
        result.error("already_active", "File picker is already active", (Object) null);
    }

    /* access modifiers changed from: private */
    public void finishWithError(String str, String str2) {
        if (this.pendingResult != null) {
            dispatchEventStatus(false);
            this.pendingResult.error(str, str2, (Object) null);
            clearPendingResult();
        }
    }

    /* access modifiers changed from: private */
    public void finishWithSuccess(Object obj) {
        dispatchEventStatus(false);
        if (this.pendingResult != null) {
            if (obj != null && !(obj instanceof String)) {
                ArrayList arrayList = new ArrayList();
                Iterator it = ((ArrayList) obj).iterator();
                while (it.hasNext()) {
                    arrayList.add(((FileInfo) it.next()).toMap());
                }
                obj = arrayList;
            }
            this.pendingResult.success(obj);
            clearPendingResult();
        }
    }

    /* access modifiers changed from: private */
    public ArrayList<Parcelable> getSelectedItems(Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 33) {
            return bundle.getParcelableArrayList("selectedItems", Parcelable.class);
        }
        return bundle.getParcelableArrayList("selectedItems");
    }

    private boolean setPendingMethodCallAndResult(MethodChannel.Result result) {
        if (this.pendingResult != null) {
            return false;
        }
        this.pendingResult = result;
        return true;
    }

    private void startFileExplorer() {
        Intent intent;
        String str = this.type;
        if (str != null) {
            if (str.equals("dir")) {
                intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
            } else {
                if (this.type.equals("image/*")) {
                    intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                } else {
                    intent = new Intent("android.intent.action.GET_CONTENT");
                    intent.addCategory("android.intent.category.OPENABLE");
                }
                Uri parse = Uri.parse(Environment.getExternalStorageDirectory().getPath() + File.separator);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Selected type ");
                sb2.append(this.type);
                intent.setDataAndType(parse, this.type);
                intent.setType(this.type);
                intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", this.isMultipleSelection);
                intent.putExtra("multi-pick", this.isMultipleSelection);
                if (this.type.contains(",")) {
                    this.allowedExtensions = this.type.split(",");
                }
                String[] strArr = this.allowedExtensions;
                if (strArr != null) {
                    intent.putExtra("android.intent.extra.MIME_TYPES", strArr);
                }
            }
            if (intent.resolveActivity(this.activity.getPackageManager()) != null) {
                this.activity.startActivityForResult(intent, REQUEST_CODE);
                return;
            }
            Log.e(TAG, "Can't find a valid activity to handle the request. Make sure you've a file explorer installed.");
            finishWithError("invalid_format_type", "Can't handle the provided file type.");
        }
    }

    public boolean onActivityResult(int i11, int i12, final Intent intent) {
        if (this.type == null) {
            return false;
        }
        int i13 = REQUEST_CODE;
        if (i11 == i13 && i12 == -1) {
            dispatchEventStatus(true);
            new Thread(new Runnable() {
                /* JADX WARNING: Code restructure failed: missing block: B:37:0x012d, code lost:
                    r2 = (android.net.Uri) r2;
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r8 = this;
                        android.content.Intent r0 = r7
                        java.lang.String r1 = "Unknown activity error, please fill an issue."
                        java.lang.String r2 = "unknown_activity"
                        if (r0 == 0) goto L_0x0170
                        java.util.ArrayList r0 = new java.util.ArrayList
                        r0.<init>()
                        android.content.Intent r3 = r7
                        android.content.ClipData r3 = r3.getClipData()
                        java.lang.String r4 = " - URI: "
                        java.lang.String r5 = "[MultiFilePick] File #"
                        r6 = 0
                        if (r3 == 0) goto L_0x0069
                        android.content.Intent r1 = r7
                        android.content.ClipData r1 = r1.getClipData()
                        int r1 = r1.getItemCount()
                    L_0x0025:
                        if (r6 >= r1) goto L_0x0062
                        android.content.Intent r2 = r7
                        android.content.ClipData r2 = r2.getClipData()
                        android.content.ClipData$Item r2 = r2.getItemAt(r6)
                        android.net.Uri r2 = r2.getUri()
                        com.mr.flutter.plugin.filepicker.FilePickerDelegate r3 = com.mr.flutter.plugin.filepicker.FilePickerDelegate.this
                        android.app.Activity r3 = r3.activity
                        com.mr.flutter.plugin.filepicker.FilePickerDelegate r7 = com.mr.flutter.plugin.filepicker.FilePickerDelegate.this
                        boolean r7 = r7.loadDataToMemory
                        com.mr.flutter.plugin.filepicker.FileInfo r3 = com.mr.flutter.plugin.filepicker.FileUtils.openFileStream(r3, r2, r7)
                        if (r3 == 0) goto L_0x005f
                        r0.add(r3)
                        java.lang.StringBuilder r3 = new java.lang.StringBuilder
                        r3.<init>()
                        r3.append(r5)
                        r3.append(r6)
                        r3.append(r4)
                        java.lang.String r2 = r2.getPath()
                        r3.append(r2)
                    L_0x005f:
                        int r6 = r6 + 1
                        goto L_0x0025
                    L_0x0062:
                        com.mr.flutter.plugin.filepicker.FilePickerDelegate r1 = com.mr.flutter.plugin.filepicker.FilePickerDelegate.this
                        r1.finishWithSuccess(r0)
                        goto L_0x0175
                    L_0x0069:
                        android.content.Intent r3 = r7
                        android.net.Uri r3 = r3.getData()
                        java.lang.String r7 = "unknown_path"
                        if (r3 == 0) goto L_0x00f7
                        android.content.Intent r1 = r7
                        android.net.Uri r1 = r1.getData()
                        com.mr.flutter.plugin.filepicker.FilePickerDelegate r2 = com.mr.flutter.plugin.filepicker.FilePickerDelegate.this
                        java.lang.String r2 = r2.type
                        java.lang.String r3 = "dir"
                        boolean r2 = r2.equals(r3)
                        if (r2 == 0) goto L_0x00bb
                        java.lang.String r0 = android.provider.DocumentsContract.getTreeDocumentId(r1)
                        android.net.Uri r0 = android.provider.DocumentsContract.buildDocumentUriUsingTree(r1, r0)
                        java.lang.StringBuilder r1 = new java.lang.StringBuilder
                        r1.<init>()
                        java.lang.String r2 = "[SingleFilePick] File URI:"
                        r1.append(r2)
                        java.lang.String r2 = r0.toString()
                        r1.append(r2)
                        com.mr.flutter.plugin.filepicker.FilePickerDelegate r1 = com.mr.flutter.plugin.filepicker.FilePickerDelegate.this
                        android.app.Activity r1 = r1.activity
                        java.lang.String r0 = com.mr.flutter.plugin.filepicker.FileUtils.getFullPathFromTreeUri(r0, r1)
                        if (r0 == 0) goto L_0x00b3
                        com.mr.flutter.plugin.filepicker.FilePickerDelegate r1 = com.mr.flutter.plugin.filepicker.FilePickerDelegate.this
                        r1.finishWithSuccess(r0)
                        goto L_0x00ba
                    L_0x00b3:
                        com.mr.flutter.plugin.filepicker.FilePickerDelegate r0 = com.mr.flutter.plugin.filepicker.FilePickerDelegate.this
                        java.lang.String r1 = "Failed to retrieve directory path."
                        r0.finishWithError(r7, r1)
                    L_0x00ba:
                        return
                    L_0x00bb:
                        com.mr.flutter.plugin.filepicker.FilePickerDelegate r2 = com.mr.flutter.plugin.filepicker.FilePickerDelegate.this
                        android.app.Activity r2 = r2.activity
                        com.mr.flutter.plugin.filepicker.FilePickerDelegate r3 = com.mr.flutter.plugin.filepicker.FilePickerDelegate.this
                        boolean r3 = r3.loadDataToMemory
                        com.mr.flutter.plugin.filepicker.FileInfo r1 = com.mr.flutter.plugin.filepicker.FileUtils.openFileStream(r2, r1, r3)
                        if (r1 == 0) goto L_0x00d0
                        r0.add(r1)
                    L_0x00d0:
                        boolean r1 = r0.isEmpty()
                        if (r1 != 0) goto L_0x00ee
                        java.lang.StringBuilder r1 = new java.lang.StringBuilder
                        r1.<init>()
                        java.lang.String r2 = "File path:"
                        r1.append(r2)
                        java.lang.String r2 = r0.toString()
                        r1.append(r2)
                        com.mr.flutter.plugin.filepicker.FilePickerDelegate r1 = com.mr.flutter.plugin.filepicker.FilePickerDelegate.this
                        r1.finishWithSuccess(r0)
                        goto L_0x0175
                    L_0x00ee:
                        com.mr.flutter.plugin.filepicker.FilePickerDelegate r0 = com.mr.flutter.plugin.filepicker.FilePickerDelegate.this
                        java.lang.String r1 = "Failed to retrieve path."
                        r0.finishWithError(r7, r1)
                        goto L_0x0175
                    L_0x00f7:
                        android.content.Intent r3 = r7
                        android.os.Bundle r3 = r3.getExtras()
                        if (r3 == 0) goto L_0x016a
                        android.content.Intent r1 = r7
                        android.os.Bundle r1 = r1.getExtras()
                        java.util.Set r2 = r1.keySet()
                        java.lang.String r3 = "selectedItems"
                        boolean r2 = r2.contains(r3)
                        if (r2 == 0) goto L_0x0162
                        com.mr.flutter.plugin.filepicker.FilePickerDelegate r2 = com.mr.flutter.plugin.filepicker.FilePickerDelegate.this
                        java.util.ArrayList r1 = r2.getSelectedItems(r1)
                        if (r1 == 0) goto L_0x015c
                        java.util.Iterator r1 = r1.iterator()
                    L_0x011d:
                        boolean r2 = r1.hasNext()
                        if (r2 == 0) goto L_0x015c
                        java.lang.Object r2 = r1.next()
                        android.os.Parcelable r2 = (android.os.Parcelable) r2
                        boolean r3 = r2 instanceof android.net.Uri
                        if (r3 == 0) goto L_0x0159
                        android.net.Uri r2 = (android.net.Uri) r2
                        com.mr.flutter.plugin.filepicker.FilePickerDelegate r3 = com.mr.flutter.plugin.filepicker.FilePickerDelegate.this
                        android.app.Activity r3 = r3.activity
                        com.mr.flutter.plugin.filepicker.FilePickerDelegate r7 = com.mr.flutter.plugin.filepicker.FilePickerDelegate.this
                        boolean r7 = r7.loadDataToMemory
                        com.mr.flutter.plugin.filepicker.FileInfo r3 = com.mr.flutter.plugin.filepicker.FileUtils.openFileStream(r3, r2, r7)
                        if (r3 == 0) goto L_0x0159
                        r0.add(r3)
                        java.lang.StringBuilder r3 = new java.lang.StringBuilder
                        r3.<init>()
                        r3.append(r5)
                        r3.append(r6)
                        r3.append(r4)
                        java.lang.String r2 = r2.getPath()
                        r3.append(r2)
                    L_0x0159:
                        int r6 = r6 + 1
                        goto L_0x011d
                    L_0x015c:
                        com.mr.flutter.plugin.filepicker.FilePickerDelegate r1 = com.mr.flutter.plugin.filepicker.FilePickerDelegate.this
                        r1.finishWithSuccess(r0)
                        goto L_0x0175
                    L_0x0162:
                        com.mr.flutter.plugin.filepicker.FilePickerDelegate r0 = com.mr.flutter.plugin.filepicker.FilePickerDelegate.this
                        java.lang.String r1 = "Failed to retrieve path from bundle."
                        r0.finishWithError(r7, r1)
                        goto L_0x0175
                    L_0x016a:
                        com.mr.flutter.plugin.filepicker.FilePickerDelegate r0 = com.mr.flutter.plugin.filepicker.FilePickerDelegate.this
                        r0.finishWithError(r2, r1)
                        goto L_0x0175
                    L_0x0170:
                        com.mr.flutter.plugin.filepicker.FilePickerDelegate r0 = com.mr.flutter.plugin.filepicker.FilePickerDelegate.this
                        r0.finishWithError(r2, r1)
                    L_0x0175:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.mr.flutter.plugin.filepicker.FilePickerDelegate.AnonymousClass2.run():void");
                }
            }).start();
            return true;
        } else if (i11 == i13 && i12 == 0) {
            Log.i(TAG, "User cancelled the picker request");
            finishWithSuccess((Object) null);
            return true;
        } else {
            if (i11 == i13) {
                finishWithError("unknown_activity", "Unknown activity error, please fill an issue.");
            }
            return false;
        }
    }

    public boolean onRequestPermissionsResult(int i11, String[] strArr, int[] iArr) {
        boolean z11 = false;
        if (REQUEST_CODE != i11) {
            return false;
        }
        if (iArr.length > 0 && iArr[0] == 0) {
            z11 = true;
        }
        if (z11) {
            startFileExplorer();
        } else {
            finishWithError("read_external_storage_denied", "User did not allow reading external storage");
        }
        return true;
    }

    public void setEventHandler(EventChannel.EventSink eventSink2) {
        this.eventSink = eventSink2;
    }

    @VisibleForTesting
    public FilePickerDelegate(Activity activity2, MethodChannel.Result result, PermissionManager permissionManager2) {
        this.isMultipleSelection = false;
        this.loadDataToMemory = false;
        this.activity = activity2;
        this.pendingResult = result;
        this.permissionManager = permissionManager2;
    }

    public void startFileExplorer(String str, boolean z11, boolean z12, String[] strArr, MethodChannel.Result result) {
        if (!setPendingMethodCallAndResult(result)) {
            finishWithAlreadyActiveError(result);
            return;
        }
        this.type = str;
        this.isMultipleSelection = z11;
        this.loadDataToMemory = z12;
        this.allowedExtensions = strArr;
        if (Build.VERSION.SDK_INT >= 33 || this.permissionManager.isPermissionGranted(PermissionUtil.READ_EXTERNAL_PERMISSION)) {
            startFileExplorer();
        } else {
            this.permissionManager.askForPermission(PermissionUtil.READ_EXTERNAL_PERMISSION, REQUEST_CODE);
        }
    }
}
