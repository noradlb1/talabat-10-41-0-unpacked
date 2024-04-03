package com.deliveryhero.chatui.view.chatroom.viewholder;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import s4.d;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0012R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/deliveryhero/chatui/view/chatroom/viewholder/QuickReplyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "quickReplyTextView", "Landroid/widget/TextView;", "getQuickReplyTextView", "()Landroid/widget/TextView;", "quickReplyTextView$delegate", "Lkotlin/Lazy;", "getView", "()Landroid/view/View;", "bind", "", "reply", "", "quickReplyClickListener", "Lkotlin/Function0;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class QuickReplyViewHolder extends RecyclerView.ViewHolder {
    @NotNull
    private final Lazy quickReplyTextView$delegate = LazyKt__LazyJVMKt.lazy(new QuickReplyViewHolder$quickReplyTextView$2(this));
    @NotNull
    private final View view;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public QuickReplyViewHolder(@NotNull View view2) {
        super(view2);
        Intrinsics.checkNotNullParameter(view2, "view");
        this.view = view2;
    }

    /* access modifiers changed from: private */
    /* renamed from: bind$lambda-0  reason: not valid java name */
    public static final void m8168bind$lambda0(Function0 function0, View view2) {
        Intrinsics.checkNotNullParameter(function0, "$quickReplyClickListener");
        function0.invoke();
    }

    private final TextView getQuickReplyTextView() {
        return (TextView) this.quickReplyTextView$delegate.getValue();
    }

    public final void bind(@NotNull String str, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "reply");
        Intrinsics.checkNotNullParameter(function0, "quickReplyClickListener");
        getQuickReplyTextView().setText(str);
        getQuickReplyTextView().setOnClickListener(new d(function0));
    }

    @NotNull
    public final View getView() {
        return this.view;
    }
}
