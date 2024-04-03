package com.deliveryhero.chatui.view.chatroom.adapter;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class AttachmentDialogAdapter$onBindViewHolder$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AttachmentDialogAdapter f29628g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f29629h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AttachmentDialogAdapter$onBindViewHolder$1(AttachmentDialogAdapter attachmentDialogAdapter, int i11) {
        super(0);
        this.f29628g = attachmentDialogAdapter;
        this.f29629h = i11;
    }

    public final void invoke() {
        this.f29628g.onItemClickListener.onItemClick(this.f29629h, this.f29628g.attachmentOptionList.get(this.f29629h));
    }
}
