package com.talabat.talabatcore.application;

import android.content.Context;
import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\b\u0010\u0007\u001a\u00020\u0004H\u0016¨\u0006\t"}, d2 = {"Lcom/talabat/talabatcore/application/BaseApplication;", "Landroidx/multidex/MultiDexApplication;", "()V", "attachBaseContext", "", "base", "Landroid/content/Context;", "onCreate", "Companion", "com_talabat_NewArchi_TalabatCore_TalabatCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class BaseApplication extends MultiDexApplication {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static BaseApplication instance;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/talabat/talabatcore/application/BaseApplication$Companion;", "", "()V", "instance", "Lcom/talabat/talabatcore/application/BaseApplication;", "getInstance", "()Lcom/talabat/talabatcore/application/BaseApplication;", "setInstance", "(Lcom/talabat/talabatcore/application/BaseApplication;)V", "com_talabat_NewArchi_TalabatCore_TalabatCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final BaseApplication getInstance() {
            BaseApplication baseApplication = BaseApplication.instance;
            if (baseApplication != null) {
                return baseApplication;
            }
            Intrinsics.throwUninitializedPropertyAccessException("instance");
            return null;
        }

        public final void setInstance(@NotNull BaseApplication baseApplication) {
            Intrinsics.checkNotNullParameter(baseApplication, "<set-?>");
            BaseApplication.instance = baseApplication;
        }
    }

    public void attachBaseContext(@Nullable Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }

    public void onCreate() {
        super.onCreate();
        Companion.setInstance(this);
    }
}
