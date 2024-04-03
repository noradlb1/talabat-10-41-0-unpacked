package ue;

import android.view.View;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class qa implements Function0 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View.OnClickListener f57709b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f57710c;

    public /* synthetic */ qa(View.OnClickListener onClickListener, View view) {
        this.f57709b = onClickListener;
        this.f57710c = view;
    }

    public final Object invoke() {
        return this.f57709b.onClick(this.f57710c);
    }
}
