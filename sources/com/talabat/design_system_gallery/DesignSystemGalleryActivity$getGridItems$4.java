package com.talabat.design_system_gallery;

import android.content.Intent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DesignSystemGalleryActivity$getGridItems$4 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DesignSystemGalleryActivity f58224g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DesignSystemGalleryActivity$getGridItems$4(DesignSystemGalleryActivity designSystemGalleryActivity) {
        super(0);
        this.f58224g = designSystemGalleryActivity;
    }

    public final void invoke() {
        this.f58224g.startActivity(new Intent(this.f58224g, DividersActivity.class));
    }
}
