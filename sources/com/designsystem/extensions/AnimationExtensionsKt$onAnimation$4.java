package com.designsystem.extensions;

import android.view.animation.Animation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, d2 = {"com/designsystem/extensions/AnimationExtensionsKt$onAnimation$4", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "p0", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AnimationExtensionsKt$onAnimation$4 implements Animation.AnimationListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f33287b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f33288c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f33289d;

    public AnimationExtensionsKt$onAnimation$4(Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03) {
        this.f33287b = function0;
        this.f33288c = function02;
        this.f33289d = function03;
    }

    public void onAnimationEnd(@Nullable Animation animation) {
        this.f33288c.invoke();
    }

    public void onAnimationRepeat(@Nullable Animation animation) {
        this.f33289d.invoke();
    }

    public void onAnimationStart(@Nullable Animation animation) {
        this.f33287b.invoke();
    }
}
