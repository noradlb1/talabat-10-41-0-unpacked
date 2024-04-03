package ue;

import android.view.View;
import com.talabat.GemFooterMenuLevelView;

public final /* synthetic */ class f6 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GemFooterMenuLevelView f57524b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f57525c;

    public /* synthetic */ f6(GemFooterMenuLevelView gemFooterMenuLevelView, View view) {
        this.f57524b = gemFooterMenuLevelView;
        this.f57525c = view;
    }

    public final void run() {
        this.f57524b.lambda$onViewCreated$0(this.f57525c);
    }
}
