package r6;

import com.facebook.appevents.internal.FileDownloadTask;
import com.facebook.appevents.ml.ModelManager;
import java.io.File;
import java.util.List;

public final /* synthetic */ class d implements FileDownloadTask.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f34650a;

    public /* synthetic */ d(List list) {
        this.f34650a = list;
    }

    public final void onComplete(File file) {
        ModelManager.TaskHandler.Companion.m8924execute$lambda1(this.f34650a, file);
    }
}
