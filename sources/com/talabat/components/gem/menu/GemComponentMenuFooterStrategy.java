package com.talabat.components.gem.menu;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.talabat.R;
import com.talabat.components.gem.menu.GemMenuFooterStrategy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/talabat/components/gem/menu/GemComponentMenuFooterStrategy;", "Lcom/talabat/components/gem/menu/GemMenuFooterStrategy;", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "bundle", "Landroid/os/Bundle;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemComponentMenuFooterStrategy implements GemMenuFooterStrategy {
    public void initialiseTimer() {
        GemMenuFooterStrategy.DefaultImpls.initialiseTimer(this);
    }

    public void onAttach(@NotNull Activity activity) {
        GemMenuFooterStrategy.DefaultImpls.onAttach((GemMenuFooterStrategy) this, activity);
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.v2_gem_checkout_footer, (ViewGroup) null);
        inflate.setVisibility(8);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…  visibility = GONE\n    }");
        return inflate;
    }

    public void onDestroy() {
        GemMenuFooterStrategy.DefaultImpls.onDestroy(this);
    }

    public void onDetach() {
        GemMenuFooterStrategy.DefaultImpls.onDetach(this);
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        GemMenuFooterStrategy.DefaultImpls.onViewCreated(this, view, bundle);
    }

    public void refreshTimer(@Nullable String str) {
        GemMenuFooterStrategy.DefaultImpls.refreshTimer(this, str);
    }

    public void startTimer() {
        GemMenuFooterStrategy.DefaultImpls.startTimer(this);
    }

    public void stopTimer() {
        GemMenuFooterStrategy.DefaultImpls.stopTimer(this);
    }

    public void onAttach(@NotNull Context context) {
        GemMenuFooterStrategy.DefaultImpls.onAttach((GemMenuFooterStrategy) this, context);
    }
}
