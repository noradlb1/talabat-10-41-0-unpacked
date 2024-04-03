package zu;

import android.view.View;
import com.talabat.talabatcommon.extension.ViewKt;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f47295b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f47296c;

    public /* synthetic */ a(Function1 function1, View view) {
        this.f47295b = function1;
        this.f47296c = view;
    }

    public final void onClick(View view) {
        ViewKt.m9349invoke$lambda2(this.f47295b, this.f47296c, view);
    }
}
