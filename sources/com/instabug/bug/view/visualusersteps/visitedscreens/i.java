package com.instabug.bug.view.visualusersteps.visitedscreens;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.instabug.bug.model.f;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.ui.BasePresenter;
import com.instabug.library.internal.storage.ProcessedBytes;
import com.instabug.library.internal.storage.operation.DeleteUriDiskOperation;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;
import com.instabug.library.util.DiskUtils;
import com.instabug.library.util.FileUtils;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.visualusersteps.VisualUserStep;
import com.instabug.library.visualusersteps.VisualUserStepsHelper;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

@Instrumented
public class i extends BasePresenter {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public ArrayList f45982a = new ArrayList();
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private Disposable f45983b;

    public i(d dVar) {
        super(dVar);
    }

    @Nullable
    private String a(ArrayList arrayList, String str) {
        String substring = str.substring(0, FileUtils.getIndexOfExtension(str));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            if (file.getPath().contains(substring)) {
                return file.getPath();
            }
        }
        return null;
    }

    private Observable c(Context context) {
        return Observable.fromCallable(new g(this, context));
    }

    public ArrayList a(Context context) {
        String a11;
        ArrayList arrayList = new ArrayList();
        ArrayList<VisualUserStep> fetchSteps = VisualUserStepsHelper.fetchSteps();
        ArrayList<File> listFilesInDirectory = DiskUtils.listFilesInDirectory(VisualUserStepsHelper.getVisualUserStepsDirectory(InstabugInternalTrackingDelegate.getInstance().getTargetActivity()));
        Iterator<VisualUserStep> it = fetchSteps.iterator();
        int i11 = 1;
        while (it.hasNext()) {
            VisualUserStep next = it.next();
            if (!(next.getScreenshotId() == null || (a11 = a(listFilesInDirectory, next.getScreenshotId())) == null)) {
                boolean exists = new File(a11).exists();
                if (!exists && next.getScreenshotId() != null) {
                    i11++;
                }
                int i12 = i11;
                if (!(next.getScreenId() == null || next.getScreenshotId() == null || !exists)) {
                    ProcessedBytes decryptOnTheFly = InstabugCore.decryptOnTheFly(a11);
                    if (decryptOnTheFly.isProcessSuccessful()) {
                        byte[] fileBytes = decryptOnTheFly.getFileBytes();
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inSampleSize = 2;
                        arrayList.add(new f(i12, next.getScreenName(), next.getScreenshotId(), a11, BitmapFactoryInstrumentation.decodeByteArray(fileBytes, 0, fileBytes.length, options)));
                        i11 = i12 + 1;
                    }
                }
                i11 = i12;
            }
        }
        return arrayList;
    }

    public void a(Context context, int i11, f fVar) {
        d dVar;
        InstabugSDKLogger.v("IBG-BR", "Deleting visual user step, Screen name: " + fVar);
        if (i11 >= 0 && this.f45982a.size() > i11) {
            VisualUserStepsHelper.removeScreenshotId(fVar.d());
            this.f45982a.remove(i11);
            com.instabug.library.internal.storage.DiskUtils.with(context).deleteOperation(new DeleteUriDiskOperation(Uri.parse(fVar.e()))).executeAsync(new h(this));
            WeakReference<V> weakReference = this.f34200f;
            if (weakReference != null && (dVar = (d) weakReference.get()) != null) {
                dVar.a(this.f45982a);
            }
        }
    }

    public void b(Context context) {
        WeakReference<V> weakReference = this.f34200f;
        if (weakReference != null) {
            d dVar = (d) weakReference.get();
            if (dVar != null && !this.f45982a.isEmpty()) {
                dVar.a(this.f45982a);
            } else if (dVar != null) {
                dVar.b();
                this.f45983b = c(context).subscribeOn(Schedulers.io()).delay(1, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(this, dVar));
            }
        }
    }

    public void l() {
        Disposable disposable = this.f45983b;
        if (disposable != null && disposable.isDisposed()) {
            this.f45983b.dispose();
        }
        VisualUserStepsHelper.encryptExistingSteps();
    }
}
