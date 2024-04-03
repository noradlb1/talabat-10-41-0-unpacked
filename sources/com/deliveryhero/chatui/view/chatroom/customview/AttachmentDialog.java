package com.deliveryhero.chatui.view.chatroom.customview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.deliveryhero.chatui.view.chatroom.adapter.AttachmentDialogAdapter;
import com.deliveryhero.customerchat.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/deliveryhero/chatui/view/chatroom/customview/AttachmentDialog;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "convertView", "Landroid/view/View;", "dialog", "Landroidx/appcompat/app/AlertDialog;", "bind", "", "attachmentItemDialogAdapter", "Lcom/deliveryhero/chatui/view/chatroom/adapter/AttachmentDialogAdapter;", "dismissDialog", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AttachmentDialog {
    @NotNull
    private final Context context;
    @NotNull
    private View convertView;
    @NotNull
    private final AlertDialog dialog;

    public AttachmentDialog(@NotNull Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
        View inflate = View.inflate(context2, R.layout.customer_chat_include_layout_attachment_list, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou…ut_attachment_list, null)");
        this.convertView = inflate;
        AlertDialog create = new AlertDialog.Builder(context2).create();
        Intrinsics.checkNotNullExpressionValue(create, "Builder(context).create()");
        this.dialog = create;
    }

    public final void bind(@NotNull AttachmentDialogAdapter attachmentDialogAdapter) {
        Intrinsics.checkNotNullParameter(attachmentDialogAdapter, "attachmentItemDialogAdapter");
        RecyclerView recyclerView = (RecyclerView) this.convertView.findViewById(R.id.rv_attachment_selection_list);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this.context));
        }
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
        }
        if (recyclerView != null) {
            recyclerView.setAdapter(attachmentDialogAdapter);
        }
        this.dialog.setView(this.convertView);
        Window window = this.dialog.getWindow();
        Intrinsics.checkNotNull(window);
        window.setLayout(600, 400);
        this.dialog.show();
    }

    public final void dismissDialog() {
        this.dialog.dismiss();
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }
}
