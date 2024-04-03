package com.instabug.bug.view.reporting;

import com.instabug.bug.R;

class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ x f45895b;

    public h(x xVar) {
        this.f45895b = xVar;
    }

    public void run() {
        x xVar = this.f45895b;
        int i11 = R.id.instabug_add_attachment;
        if (xVar.i(i11) != null) {
            this.f45895b.i(i11).setVisibility(8);
        }
        if (this.f45895b.f45932p != null) {
            this.f45895b.f45932p.setState(3);
        }
    }
}
