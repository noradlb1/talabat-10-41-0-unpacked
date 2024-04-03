package gj;

import android.view.View;
import com.talabat.darkstores.feature.home.viewholder.SwimlanesProductViewHolder;
import com.talabat.darkstores.model.Swimlane;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f56859b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Swimlane f56860c;

    public /* synthetic */ b(Function1 function1, Swimlane swimlane) {
        this.f56859b = function1;
        this.f56860c = swimlane;
    }

    public final void onClick(View view) {
        SwimlanesProductViewHolder.m9978bind$lambda3$lambda1(this.f56859b, this.f56860c, view);
    }
}
