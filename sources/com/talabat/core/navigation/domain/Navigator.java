package com.talabat.core.navigation.domain;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.talabat.core.navigation.domain.screen.Screen;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011J?\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t2\u0019\b\u0002\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\u0002\b\rH&J7\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t2\u0019\b\u0002\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\u0002\b\rH&¨\u0006\u0012"}, d2 = {"Lcom/talabat/core/navigation/domain/Navigator;", "", "navigateForResultTo", "", "activity", "Landroid/app/Activity;", "requestCode", "", "screen", "Lcom/talabat/core/navigation/domain/screen/Screen;", "extraOptions", "Lkotlin/Function1;", "Landroid/content/Intent;", "Lkotlin/ExtensionFunctionType;", "navigateTo", "context", "Landroid/content/Context;", "Companion", "com_talabat_core_navigation_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface Navigator {
    @NotNull
    public static final Companion Companion = Companion.f55949a;
    @NotNull
    public static final String EXTRA_DATA = "navigatorData";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/core/navigation/domain/Navigator$Companion;", "", "()V", "EXTRA_DATA", "", "com_talabat_core_navigation_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        @NotNull
        public static final String EXTRA_DATA = "navigatorData";

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f55949a = new Companion();

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void navigateForResultTo$default(Navigator navigator, Activity activity, int i11, Screen screen, Function1 function1, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 8) != 0) {
                    function1 = Navigator$navigateForResultTo$1.INSTANCE;
                }
                navigator.navigateForResultTo(activity, i11, screen, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: navigateForResultTo");
        }

        public static /* synthetic */ void navigateTo$default(Navigator navigator, Context context, Screen screen, Function1 function1, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 4) != 0) {
                    function1 = Navigator$navigateTo$1.INSTANCE;
                }
                navigator.navigateTo(context, screen, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: navigateTo");
        }
    }

    void navigateForResultTo(@NotNull Activity activity, int i11, @NotNull Screen<?> screen, @NotNull Function1<? super Intent, Unit> function1);

    void navigateTo(@NotNull Context context, @NotNull Screen<?> screen, @NotNull Function1<? super Intent, Unit> function1);
}
