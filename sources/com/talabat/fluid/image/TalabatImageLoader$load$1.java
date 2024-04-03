package com.talabat.fluid.image;

import android.widget.ImageView;
import com.deliveryhero.fluid.widgets.image.ImageLocator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TalabatImageLoader$load$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TalabatImageLoader f59755g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ImageLocator.Remote f59756h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ImageLocator.Local f59757i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ImageLocator.Local f59758j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ImageView f59759k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TalabatImageLoader$load$1(TalabatImageLoader talabatImageLoader, ImageLocator.Remote remote, ImageLocator.Local local, ImageLocator.Local local2, ImageView imageView) {
        super(0);
        this.f59755g = talabatImageLoader;
        this.f59756h = remote;
        this.f59757i = local;
        this.f59758j = local2;
        this.f59759k = imageView;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0015, code lost:
        r1 = r1.getAsset();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke() {
        /*
            r3 = this;
            com.talabat.fluid.image.TalabatImageLoader r0 = r3.f59755g
            com.bumptech.glide.RequestManager r0 = r0.requestManager
            com.deliveryhero.fluid.widgets.image.ImageLocator$Remote r1 = r3.f59756h
            java.lang.String r1 = r1.getUrl()
            com.bumptech.glide.RequestBuilder r0 = r0.load((java.lang.String) r1)
            com.deliveryhero.fluid.widgets.image.ImageLocator$Local r1 = r3.f59757i
            r2 = 0
            if (r1 == 0) goto L_0x0020
            com.deliveryhero.fluid.widgets.image.ImageAsset r1 = r1.getAsset()
            if (r1 == 0) goto L_0x0020
            android.graphics.drawable.Drawable r1 = r1.getDrawable()
            goto L_0x0021
        L_0x0020:
            r1 = r2
        L_0x0021:
            com.bumptech.glide.request.BaseRequestOptions r0 = r0.error((android.graphics.drawable.Drawable) r1)
            com.bumptech.glide.RequestBuilder r0 = (com.bumptech.glide.RequestBuilder) r0
            com.deliveryhero.fluid.widgets.image.ImageLocator$Local r1 = r3.f59758j
            if (r1 == 0) goto L_0x0035
            com.deliveryhero.fluid.widgets.image.ImageAsset r1 = r1.getAsset()
            if (r1 == 0) goto L_0x0035
            android.graphics.drawable.Drawable r2 = r1.getDrawable()
        L_0x0035:
            com.bumptech.glide.request.BaseRequestOptions r0 = r0.placeholder((android.graphics.drawable.Drawable) r2)
            com.bumptech.glide.RequestBuilder r0 = (com.bumptech.glide.RequestBuilder) r0
            android.widget.ImageView r1 = r3.f59759k
            r0.into((android.widget.ImageView) r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.fluid.image.TalabatImageLoader$load$1.invoke():void");
    }
}
