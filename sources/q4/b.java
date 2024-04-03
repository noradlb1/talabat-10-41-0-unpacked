package q4;

import android.view.View;
import com.deliveryhero.chatui.view.chatroom.customview.AttachmentView;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f34636b;

    public /* synthetic */ b(Function1 function1) {
        this.f34636b = function1;
    }

    public final void onClick(View view) {
        AttachmentView.m8160onActionsClick$lambda1(this.f34636b, view);
    }
}
