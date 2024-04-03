package com.designsystem.ds_navigation_bar;

import android.content.Context;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSNavigationBar$createTrailingContainerComposable$1$1$1 extends Lambda implements Function1<Context, View> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ View f32384g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSNavigationBar$createTrailingContainerComposable$1$1$1(View view) {
        super(1);
        this.f32384g = view;
    }

    @NotNull
    public final View invoke(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "it");
        return this.f32384g;
    }
}
