package dev.fluttercommunity.plus.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import com.pichillilorenzo.flutter_inappwebview.chrome_custom_tabs.ActionBroadcastReceiver;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Share {
    private Activity activity;
    private Context context;
    private String providerAuthority = (getContext().getPackageName() + ".flutter.share_provider");

    public Share(Context context2, Activity activity2) {
        this.context = context2;
        this.activity = activity2;
    }

    private void clearShareCacheFolder() {
        File shareCacheFolder = getShareCacheFolder();
        if (shareCacheFolder.exists()) {
            for (File delete : shareCacheFolder.listFiles()) {
                delete.delete();
            }
            shareCacheFolder.delete();
        }
    }

    private static void copy(File file, File file2) throws IOException {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            fileOutputStream = new FileOutputStream(file2);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.close();
                    fileInputStream.close();
                    return;
                }
            }
        } catch (Throwable th2) {
            fileInputStream.close();
            throw th2;
        }
    }

    private File copyToShareCacheFolder(File file) throws IOException {
        File shareCacheFolder = getShareCacheFolder();
        if (!shareCacheFolder.exists()) {
            shareCacheFolder.mkdirs();
        }
        File file2 = new File(shareCacheFolder, file.getName());
        copy(file, file2);
        return file2;
    }

    private boolean fileIsInShareCache(File file) {
        try {
            return file.getCanonicalPath().startsWith(getShareCacheFolder().getCanonicalPath());
        } catch (IOException unused) {
            return false;
        }
    }

    private Context getContext() {
        Activity activity2 = this.activity;
        if (activity2 != null) {
            return activity2;
        }
        Context context2 = this.context;
        if (context2 != null) {
            return context2;
        }
        throw new IllegalStateException("Both context and activity are null");
    }

    @NonNull
    private String getMimeTypeBase(String str) {
        if (str == null || !str.contains("/")) {
            return "*";
        }
        return str.substring(0, str.indexOf("/"));
    }

    @NonNull
    private File getShareCacheFolder() {
        return new File(getContext().getCacheDir(), "share_plus");
    }

    private ArrayList<Uri> getUrisForPaths(List<String> list) throws IOException {
        ArrayList<Uri> arrayList = new ArrayList<>(list.size());
        for (String file : list) {
            File file2 = new File(file);
            if (!fileIsInShareCache(file2)) {
                arrayList.add(FileProvider.getUriForFile(getContext(), this.providerAuthority, copyToShareCacheFolder(file2)));
            } else {
                throw new IOException("File to share not allowed to be located in '" + getShareCacheFolder().getCanonicalPath() + "'");
            }
        }
        return arrayList;
    }

    private String reduceMimeTypes(List<String> list) {
        if (list.size() > 1) {
            String str = list.get(0);
            for (int i11 = 1; i11 < list.size(); i11++) {
                String str2 = list.get(i11);
                if (!str.equals(str2)) {
                    if (!getMimeTypeBase(str2).equals(getMimeTypeBase(str))) {
                        return "*/*";
                    }
                    str = getMimeTypeBase(str2) + "/*";
                }
            }
            return str;
        } else if (list.size() == 1) {
            return list.get(0);
        } else {
            return "*/*";
        }
    }

    private void startActivity(Intent intent) {
        Activity activity2 = this.activity;
        if (activity2 != null) {
            activity2.startActivity(intent);
        } else if (this.context != null) {
            intent.addFlags(268435456);
            this.context.startActivity(intent);
        } else {
            throw new IllegalStateException("Both context and activity are null");
        }
    }

    public void a(Activity activity2) {
        this.activity = activity2;
    }

    public void b(String str, String str2) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Non-empty text expected");
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", str);
        intent.putExtra(ActionBroadcastReceiver.KEY_URL_TITLE, str2);
        intent.setType("text/plain");
        startActivity(Intent.createChooser(intent, (CharSequence) null));
    }

    public void c(List<String> list, List<String> list2, String str, String str2) throws IOException {
        String str3;
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("Non-empty path expected");
        }
        clearShareCacheFolder();
        ArrayList<Uri> urisForPaths = getUrisForPaths(list);
        Intent intent = new Intent();
        if (urisForPaths.isEmpty()) {
            b(str, str2);
            return;
        }
        if (urisForPaths.size() == 1) {
            intent.setAction("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.STREAM", urisForPaths.get(0));
            if (list2.isEmpty() || list2.get(0) == null) {
                str3 = "*/*";
            } else {
                str3 = list2.get(0);
            }
            intent.setType(str3);
        } else {
            intent.setAction("android.intent.action.SEND_MULTIPLE");
            intent.putParcelableArrayListExtra("android.intent.extra.STREAM", urisForPaths);
            intent.setType(reduceMimeTypes(list2));
        }
        if (str != null) {
            intent.putExtra("android.intent.extra.TEXT", str);
        }
        if (str2 != null) {
            intent.putExtra(ActionBroadcastReceiver.KEY_URL_TITLE, str2);
        }
        intent.addFlags(1);
        Intent createChooser = Intent.createChooser(intent, (CharSequence) null);
        for (ResolveInfo resolveInfo : getContext().getPackageManager().queryIntentActivities(createChooser, 65536)) {
            String str4 = resolveInfo.activityInfo.packageName;
            Iterator<Uri> it = urisForPaths.iterator();
            while (it.hasNext()) {
                getContext().grantUriPermission(str4, it.next(), 3);
            }
        }
        startActivity(createChooser);
    }
}
