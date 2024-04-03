package com.deliveryhero.chatui.view.chatroom;

import android.view.View;
import android.widget.EditText;
import com.deliveryhero.customerchat.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/widget/EditText;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ChatFragment$composeEditText$2 extends Lambda implements Function0<EditText> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ChatFragment f29453g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatFragment$composeEditText$2(ChatFragment chatFragment) {
        super(0);
        this.f29453g = chatFragment;
    }

    @NotNull
    public final EditText invoke() {
        View view = this.f29453g.getView();
        EditText editText = view != null ? (EditText) view.findViewById(R.id.edit_text_compose_message) : null;
        if (editText != null) {
            return editText;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.EditText");
    }
}
