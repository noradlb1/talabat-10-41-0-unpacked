package com.deliveryhero.chatui.view.chatroom.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.deliveryhero.chatui.view.chatroom.dataholder.AttachmentDataModel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import s4.a;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u0018R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0004¨\u0006\u0019"}, d2 = {"Lcom/deliveryhero/chatui/view/chatroom/viewholder/AttachmentViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "attachmentIcon", "Landroid/widget/ImageView;", "getAttachmentIcon", "()Landroid/widget/ImageView;", "attachmentIcon$delegate", "Lkotlin/Lazy;", "attachmentTitle", "Landroid/widget/TextView;", "getAttachmentTitle", "()Landroid/widget/TextView;", "attachmentTitle$delegate", "getView", "()Landroid/view/View;", "setView", "bind", "", "attachmentItem", "Lcom/deliveryhero/chatui/view/chatroom/dataholder/AttachmentDataModel;", "onItemClickListener", "Lkotlin/Function0;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AttachmentViewHolder extends RecyclerView.ViewHolder {
    @NotNull
    private final Lazy attachmentIcon$delegate = LazyKt__LazyJVMKt.lazy(new AttachmentViewHolder$attachmentIcon$2(this));
    @NotNull
    private final Lazy attachmentTitle$delegate = LazyKt__LazyJVMKt.lazy(new AttachmentViewHolder$attachmentTitle$2(this));
    @NotNull
    private View view;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AttachmentViewHolder(@NotNull View view2) {
        super(view2);
        Intrinsics.checkNotNullParameter(view2, "view");
        this.view = view2;
    }

    /* access modifiers changed from: private */
    /* renamed from: bind$lambda-0  reason: not valid java name */
    public static final void m8165bind$lambda0(Function0 function0, View view2) {
        Intrinsics.checkNotNullParameter(function0, "$onItemClickListener");
        function0.invoke();
    }

    private final ImageView getAttachmentIcon() {
        return (ImageView) this.attachmentIcon$delegate.getValue();
    }

    private final TextView getAttachmentTitle() {
        return (TextView) this.attachmentTitle$delegate.getValue();
    }

    public final void bind(@NotNull AttachmentDataModel attachmentDataModel, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(attachmentDataModel, "attachmentItem");
        Intrinsics.checkNotNullParameter(function0, "onItemClickListener");
        getAttachmentTitle().setText(attachmentDataModel.getAttachmentType());
        getAttachmentIcon().setImageDrawable(attachmentDataModel.getAttachmentIcon());
        this.view.setOnClickListener(new a(function0));
    }

    @NotNull
    public final View getView() {
        return this.view;
    }

    public final void setView(@NotNull View view2) {
        Intrinsics.checkNotNullParameter(view2, "<set-?>");
        this.view = view2;
    }
}
