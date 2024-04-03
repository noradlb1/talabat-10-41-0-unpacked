package com.instabug.library.visualusersteps;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.apichecker.ReturnableRunnable;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.internal.storage.AttachmentManager;
import com.instabug.library.internal.storage.ProcessedUri;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;
import com.instabug.library.util.DiskUtils;
import com.instabug.library.util.FileUtils;
import com.instabug.library.util.threading.PoolProvider;
import io.reactivex.Observable;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Callable;

public class VisualUserStepsHelper {

    public class a implements ReturnableRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ File f52133a;

        public a(File file) {
            this.f52133a = file;
        }

        @Nullable
        /* renamed from: a */
        public ArrayList run() {
            return DiskUtils.listFilesInDirectory(this.f52133a);
        }
    }

    public class b implements ReturnableRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ File f52134a;

        public b(File file) {
            this.f52134a = file;
        }

        @Nullable
        /* renamed from: a */
        public ArrayList run() {
            return DiskUtils.listFilesInDirectory(this.f52134a);
        }
    }

    public class c implements Callable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f52135b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f52136c;

        public c(Context context, String str) {
            this.f52135b = context;
            this.f52136c = str;
        }

        /* renamed from: a */
        public ProcessedUri call() {
            return VisualUserStepsHelper.getVisualUserStepsFile(this.f52135b, this.f52136c);
        }
    }

    public class d implements Runnable {
        public void run() {
            Iterator<File> it = DiskUtils.listFilesInDirectory(VisualUserStepsHelper.getVisualUserStepsDirectory(InstabugInternalTrackingDelegate.getInstance().getTargetActivity())).iterator();
            while (it.hasNext()) {
                File next = it.next();
                if (!FileUtils.isEncryptedFile(next.getPath())) {
                    InstabugCore.encrypt(next.getPath());
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0012  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(android.view.View r3) {
        /*
            com.instabug.library.settings.SettingsManager r0 = com.instabug.library.settings.SettingsManager.getInstance()
            java.util.Collection r0 = r0.getPrivateViews()
            java.util.Iterator r0 = r0.iterator()
        L_0x000c:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0028
            java.lang.Object r1 = r0.next()
            android.view.View r1 = (android.view.View) r1
            if (r1 == 0) goto L_0x0020
            boolean r2 = r1.equals(r3)
            if (r2 != 0) goto L_0x0026
        L_0x0020:
            boolean r1 = isInPrivateScope(r3, r1)
            if (r1 == 0) goto L_0x000c
        L_0x0026:
            r3 = 1
            return r3
        L_0x0028:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.visualusersteps.VisualUserStepsHelper.a(android.view.View):boolean");
    }

    public static Bitmap decryptBitmap(String str) {
        return y.d().l(str.replace(FileUtils.FLAG_ENCRYPTED, ""));
    }

    public static void encryptExistingSteps() {
        PoolProvider.postIOTask(new d());
    }

    public static ArrayList<VisualUserStep> fetchSteps() {
        return y.d().b();
    }

    public static File getVisualUserStepsDirectory(@Nullable Context context) {
        return AttachmentManager.getNewDirectory(context, "vusf");
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public static ProcessedUri getVisualUserStepsFile(Context context, String str) {
        Uri uri;
        File visualUserStepsDirectory = getVisualUserStepsDirectory(InstabugInternalTrackingDelegate.getInstance().getTargetActivity());
        Iterator<File> it = DiskUtils.listFilesInDirectory(visualUserStepsDirectory).iterator();
        while (it.hasNext()) {
            File next = it.next();
            if (FileUtils.isEncryptedFile(next.getPath())) {
                InstabugCore.decrypt(next.getPath());
            }
        }
        ArrayList arrayList = (ArrayList) PoolProvider.getFilesEncryptionExecutor().executeAndGet(new a(visualUserStepsDirectory));
        boolean z11 = false;
        if (arrayList != null) {
            uri = DiskUtils.zipFiles(context, "usersteps_" + str, arrayList);
            if (!(uri == null || uri.getPath() == null)) {
                z11 = InstabugCore.encrypt(uri.getPath());
            }
        } else {
            uri = null;
        }
        ArrayList arrayList2 = (ArrayList) PoolProvider.getFilesEncryptionExecutor().executeAndGet(new b(visualUserStepsDirectory));
        if (arrayList2 != null) {
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                File file = (File) it2.next();
                if (!FileUtils.isEncryptedFile(file.getPath())) {
                    InstabugCore.encrypt(file.getPath());
                }
            }
        }
        return new ProcessedUri(uri, z11);
    }

    @NonNull
    public static Observable<ProcessedUri> getVisualUserStepsFileObservable(Context context, String str) {
        return Observable.fromCallable(new c(context, str));
    }

    private static boolean isInPrivateScope(View view, View view2) {
        if (view == null) {
            return false;
        }
        ViewParent parent = view.getParent();
        if (!(parent instanceof View)) {
            return false;
        }
        if (parent == view2) {
            return true;
        }
        return isInPrivateScope((View) parent, view2);
    }

    public static void removeScreenshotId(String str) {
        y.d().c(str);
    }
}
