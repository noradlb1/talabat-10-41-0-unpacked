package com.talabat.components.gem.menu;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\u001a\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016J\b\u0010\u001a\u001a\u00020\u0003H\u0016¨\u0006\u001b"}, d2 = {"Lcom/talabat/components/gem/menu/GemMenuFooterStrategy;", "", "initialiseTimer", "", "onAttach", "activity", "Landroid/app/Activity;", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "bundle", "Landroid/os/Bundle;", "onDestroy", "onDetach", "onViewCreated", "v", "savedInstanceState", "refreshTimer", "timerText", "", "startTimer", "stopTimer", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GemMenuFooterStrategy {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void initialiseTimer(@NotNull GemMenuFooterStrategy gemMenuFooterStrategy) {
        }

        public static void onAttach(@NotNull GemMenuFooterStrategy gemMenuFooterStrategy, @NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        public static void onAttach(@NotNull GemMenuFooterStrategy gemMenuFooterStrategy, @NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
        }

        public static void onDestroy(@NotNull GemMenuFooterStrategy gemMenuFooterStrategy) {
        }

        public static void onDetach(@NotNull GemMenuFooterStrategy gemMenuFooterStrategy) {
        }

        public static void onViewCreated(@NotNull GemMenuFooterStrategy gemMenuFooterStrategy, @NotNull View view, @Nullable Bundle bundle) {
            Intrinsics.checkNotNullParameter(view, "v");
        }

        public static void refreshTimer(@NotNull GemMenuFooterStrategy gemMenuFooterStrategy, @Nullable String str) {
        }

        public static void startTimer(@NotNull GemMenuFooterStrategy gemMenuFooterStrategy) {
        }

        public static void stopTimer(@NotNull GemMenuFooterStrategy gemMenuFooterStrategy) {
        }
    }

    void initialiseTimer();

    void onAttach(@NotNull Activity activity);

    void onAttach(@NotNull Context context);

    @NotNull
    View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle);

    void onDestroy();

    void onDetach();

    void onViewCreated(@NotNull View view, @Nullable Bundle bundle);

    void refreshTimer(@Nullable String str);

    void startTimer();

    void stopTimer();
}
