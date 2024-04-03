package com.instabug.library.internal.video;

import android.content.Context;
import android.widget.MediaController;
import androidx.annotation.NonNull;

public class a extends MediaController {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final C0095a f51147a;

    /* renamed from: com.instabug.library.internal.video.a$a  reason: collision with other inner class name */
    public interface C0095a {
        void isVisible(boolean z11);
    }

    public a(Context context, @NonNull C0095a aVar) {
        super(context);
        this.f51147a = aVar;
    }

    public void hide() {
        super.hide();
        C0095a aVar = this.f51147a;
        if (aVar != null) {
            aVar.isVisible(false);
        }
    }

    public void show() {
        super.show();
        C0095a aVar = this.f51147a;
        if (aVar != null) {
            aVar.isVisible(true);
        }
    }
}
