package hd;

import android.app.Activity;
import android.view.View;
import com.instabug.library.screenshot.ExtraScreenshotHelper;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExtraScreenshotHelper f56865b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Activity f56866c;

    public /* synthetic */ b(ExtraScreenshotHelper extraScreenshotHelper, Activity activity) {
        this.f56865b = extraScreenshotHelper;
        this.f56866c = activity;
    }

    public final void onClick(View view) {
        this.f56865b.lambda$show$0(this.f56866c, view);
    }
}
