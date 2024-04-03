package r6;

import com.facebook.appevents.internal.FileDownloadTask;
import com.facebook.appevents.ml.Model;
import com.facebook.appevents.ml.ModelManager;
import java.io.File;

public final /* synthetic */ class e implements FileDownloadTask.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ModelManager.TaskHandler f34651a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Model f34652b;

    public /* synthetic */ e(ModelManager.TaskHandler taskHandler, Model model) {
        this.f34651a = taskHandler;
        this.f34652b = model;
    }

    public final void onComplete(File file) {
        ModelManager.TaskHandler.Companion.m8925execute$lambda1$lambda0(this.f34651a, this.f34652b, file);
    }
}
