package com.instabug.bug.view.reporting;

import android.view.View;
import com.instabug.bug.R;
import com.instabug.library.model.Attachment;

class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f45896b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f45897c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Attachment f45898d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ x f45899e;

    public i(x xVar, int i11, View view, Attachment attachment) {
        this.f45899e = xVar;
        this.f45896b = i11;
        this.f45897c = view;
        this.f45898d = attachment;
    }

    public void run() {
        int i11 = this.f45896b;
        if (i11 == R.id.instabug_attachment_img_item || i11 == R.id.instabug_btn_image_edit_attachment) {
            if (this.f45899e.C != null) {
                this.f45899e.b(this.f45897c, this.f45898d);
            }
        } else if (i11 == R.id.instabug_btn_remove_attachment) {
            if (this.f45899e.C != null) {
                ((h0) this.f45899e.C).a(this.f45898d);
            }
        } else if (i11 == R.id.instabug_attachment_video_item && this.f45898d.getLocalPath() != null) {
            boolean unused = this.f45899e.f45926j = true;
            this.f45899e.g(this.f45898d.getLocalPath());
        }
        if (!(this.f45899e.f45939w == null || this.f45899e.f45938v == null)) {
            this.f45899e.f45939w.removeCallbacks(this.f45899e.f45938v);
        }
        Runnable unused2 = this.f45899e.f45938v = null;
    }
}
