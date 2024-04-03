package com.deliveryhero.fluid;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.deliveryhero.fluid.utils.ResourcesUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/graphics/drawable/Drawable;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class UiConfig$Companion$getDefaultClickDrawable$1 extends Lambda implements Function0<Drawable> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Context f30190g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f30191h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UiConfig$Companion$getDefaultClickDrawable$1(Context context, int i11) {
        super(0);
        this.f30190g = context;
        this.f30191h = i11;
    }

    @NotNull
    public final Drawable invoke() {
        return ResourcesUtilsKt.getDrawableCompat(this.f30190g, this.f30191h, "selectableItemBackground");
    }
}
