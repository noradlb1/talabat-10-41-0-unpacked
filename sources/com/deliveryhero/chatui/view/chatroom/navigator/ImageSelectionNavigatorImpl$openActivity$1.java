package com.deliveryhero.chatui.view.chatroom.navigator;

import androidx.activity.result.PickVisualMediaRequestKt;
import androidx.activity.result.contract.ActivityResultContracts;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ImageSelectionNavigatorImpl$openActivity$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ImageSelectionNavigatorImpl f29656g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageSelectionNavigatorImpl$openActivity$1(ImageSelectionNavigatorImpl imageSelectionNavigatorImpl) {
        super(0);
        this.f29656g = imageSelectionNavigatorImpl;
    }

    public final void invoke() {
        this.f29656g.galleryResultLauncher.launch(PickVisualMediaRequestKt.PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly.INSTANCE));
    }
}
