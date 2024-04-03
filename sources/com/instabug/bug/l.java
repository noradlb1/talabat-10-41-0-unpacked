package com.instabug.bug;

import com.instabug.bug.model.d;
import com.instabug.library.internal.storage.ProcessedUri;
import com.instabug.library.model.Attachment;
import io.reactivex.functions.Consumer;

class l implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d f45648b;

    public l(n nVar, d dVar) {
        this.f45648b = dVar;
    }

    /* renamed from: a */
    public void accept(ProcessedUri processedUri) {
        d dVar = this.f45648b;
        if (dVar != null) {
            dVar.a(processedUri.getUri(), Attachment.Type.VISUAL_USER_STEPS, processedUri.isUriEncrypted());
        }
    }
}
