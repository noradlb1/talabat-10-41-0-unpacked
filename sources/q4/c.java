package q4;

import android.view.View;
import com.deliveryhero.chatui.view.chatroom.customview.AttachmentView;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f34637b;

    public /* synthetic */ c(Function1 function1) {
        this.f34637b = function1;
    }

    public final void onClick(View view) {
        AttachmentView.m8161onActionsClick$lambda2(this.f34637b, view);
    }
}
