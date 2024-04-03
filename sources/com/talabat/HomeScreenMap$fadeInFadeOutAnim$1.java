package com.talabat;

import android.view.animation.Animation;
import android.widget.ImageView;
import com.huawei.hms.flutter.map.constants.Param;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/talabat/HomeScreenMap$fadeInFadeOutAnim$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HomeScreenMap$fadeInFadeOutAnim$1 implements Animation.AnimationListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int[] f54201b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f54202c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ HomeScreenMap f54203d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ImageView f54204e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ boolean f54205f;

    public HomeScreenMap$fadeInFadeOutAnim$1(int[] iArr, int i11, HomeScreenMap homeScreenMap, ImageView imageView, boolean z11) {
        this.f54201b = iArr;
        this.f54202c = i11;
        this.f54203d = homeScreenMap;
        this.f54204e = imageView;
        this.f54205f = z11;
    }

    public void onAnimationEnd(@NotNull Animation animation) {
        Intrinsics.checkNotNullParameter(animation, Param.ANIMATION);
        int[] iArr = this.f54201b;
        int length = iArr.length - 1;
        int i11 = this.f54202c;
        if (length > i11) {
            this.f54203d.fadeInFadeOutAnim(this.f54204e, iArr, i11 + 1, this.f54205f);
            return;
        }
        boolean z11 = this.f54205f;
        if (z11) {
            this.f54203d.fadeInFadeOutAnim(this.f54204e, iArr, 0, z11);
        }
    }

    public void onAnimationRepeat(@NotNull Animation animation) {
        Intrinsics.checkNotNullParameter(animation, Param.ANIMATION);
    }

    public void onAnimationStart(@NotNull Animation animation) {
        Intrinsics.checkNotNullParameter(animation, Param.ANIMATION);
    }
}
