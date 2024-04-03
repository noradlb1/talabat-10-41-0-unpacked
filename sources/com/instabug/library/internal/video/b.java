package com.instabug.library.internal.video;

import com.instabug.library.internal.video.InternalAutoScreenRecorderHelper;

class b implements Runnable {
    public b(InternalAutoScreenRecorderHelper.b bVar) {
    }

    public void run() {
        InternalAutoScreenRecorderHelper.getInstance().start();
    }
}
