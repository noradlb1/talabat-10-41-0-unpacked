package com.deliveryhero.chatui.view.chatroom;

import com.deliveryhero.chatui.view.chatroom.customview.AttachmentView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/deliveryhero/chatui/view/chatroom/customview/AttachmentView$AttachmentTypes;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ChatFragment$configureViews$1 extends Lambda implements Function1<AttachmentView.AttachmentTypes, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ChatFragment f29460g;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AttachmentView.AttachmentTypes.values().length];
            iArr[AttachmentView.AttachmentTypes.ADD.ordinal()] = 1;
            iArr[AttachmentView.AttachmentTypes.CAMERA.ordinal()] = 2;
            iArr[AttachmentView.AttachmentTypes.GALLERY.ordinal()] = 3;
            iArr[AttachmentView.AttachmentTypes.LOCATION.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatFragment$configureViews$1(ChatFragment chatFragment) {
        super(1);
        this.f29460g = chatFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AttachmentView.AttachmentTypes) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull AttachmentView.AttachmentTypes attachmentTypes) {
        Intrinsics.checkNotNullParameter(attachmentTypes, "it");
        int i11 = WhenMappings.$EnumSwitchMapping$0[attachmentTypes.ordinal()];
        if (i11 == 1) {
            this.f29460g.showAddAttachmentDialog();
        } else if (i11 == 2) {
            this.f29460g.getViewModel().openCamera();
        } else if (i11 == 3) {
            this.f29460g.getViewModel().openGallery();
        } else if (i11 == 4) {
            this.f29460g.fetchLocation();
        }
    }
}
