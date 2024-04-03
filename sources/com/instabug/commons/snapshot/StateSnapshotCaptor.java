package com.instabug.commons.snapshot;

import android.content.Context;
import com.instabug.commons.caching.SessionCacheDirectory;
import com.instabug.commons.di.CommonsLocator;
import com.instabug.commons.lifecycle.b;
import com.instabug.commons.lifecycle.c;
import com.instabug.commons.logging.a;
import com.instabug.library.model.State;
import java.io.File;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class StateSnapshotCaptor extends d implements b {
    @NotNull
    private static final String CAPTOR_NAME = "CrashesStateSnapshot";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int ID = 1;
    @NotNull
    public static final String OLD_STATE_SNAPSHOT_FILE_SUFFIX = "-old";
    @NotNull
    public static final String STATE_SNAPSHOT_FILE_NAME = "snapshot";
    @NotNull
    private final e configurations;
    @NotNull
    private final c lifecycleOwner;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final File getOldSnapshotFile(@NotNull File file) {
            Intrinsics.checkNotNullParameter(file, "sessionDirectory");
            return new File(Intrinsics.stringPlus(getSnapshotFile(file).getAbsolutePath(), StateSnapshotCaptor.OLD_STATE_SNAPSHOT_FILE_SUFFIX));
        }

        @NotNull
        public final File getSnapshotFile(@NotNull File file) {
            Intrinsics.checkNotNullParameter(file, "sessionDirectory");
            return new File(file.getAbsolutePath() + File.separator + StateSnapshotCaptor.STATE_SNAPSHOT_FILE_NAME);
        }
    }

    public static final class Factory {
        @NotNull
        public static final Factory INSTANCE = new Factory();

        public /* synthetic */ class a extends PropertyReference0Impl {
            public a(Object obj) {
                super(obj, CommonsLocator.class, "appCtx", "getAppCtx()Landroid/content/Context;", 0);
            }

            @Nullable
            public Object get() {
                return ((CommonsLocator) this.receiver).getAppCtx();
            }
        }

        public /* synthetic */ class b extends PropertyReference0Impl {
            public b(Object obj) {
                super(obj, SessionCacheDirectory.class, "currentSessionDirectory", "getCurrentSessionDirectory()Ljava/io/File;", 0);
            }

            @Nullable
            public Object get() {
                return ((SessionCacheDirectory) this.receiver).getCurrentSessionDirectory();
            }
        }

        public /* synthetic */ class c extends FunctionReferenceImpl implements Function1 {
            public c(Object obj) {
                super(1, obj, CommonsLocator.class, "getScheduledExecutor", "getScheduledExecutor(Ljava/lang/String;)Ljava/util/concurrent/ScheduledExecutorService;", 0);
            }

            @NotNull
            /* renamed from: a */
            public final ScheduledExecutorService invoke(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "p0");
                return ((CommonsLocator) this.receiver).getScheduledExecutor(str);
            }
        }

        private Factory() {
        }

        @JvmStatic
        @NotNull
        @JvmOverloads
        public static final StateSnapshotCaptor invoke() {
            return invoke$default((Function0) null, (Function0) null, (Function1) null, (com.instabug.commons.lifecycle.c) null, 15, (Object) null);
        }

        @JvmStatic
        @NotNull
        @JvmOverloads
        public static final StateSnapshotCaptor invoke(@NotNull Function0<? extends Context> function0) {
            Intrinsics.checkNotNullParameter(function0, "ctxGetter");
            return invoke$default(function0, (Function0) null, (Function1) null, (com.instabug.commons.lifecycle.c) null, 14, (Object) null);
        }

        @JvmStatic
        @NotNull
        @JvmOverloads
        public static final StateSnapshotCaptor invoke(@NotNull Function0<? extends Context> function0, @NotNull Function0<? extends File> function02) {
            Intrinsics.checkNotNullParameter(function0, "ctxGetter");
            Intrinsics.checkNotNullParameter(function02, "savingDirectoryGetter");
            return invoke$default(function0, function02, (Function1) null, (com.instabug.commons.lifecycle.c) null, 12, (Object) null);
        }

        @JvmStatic
        @NotNull
        @JvmOverloads
        public static final StateSnapshotCaptor invoke(@NotNull Function0<? extends Context> function0, @NotNull Function0<? extends File> function02, @NotNull Function1<? super String, ? extends ScheduledExecutorService> function1) {
            Intrinsics.checkNotNullParameter(function0, "ctxGetter");
            Intrinsics.checkNotNullParameter(function02, "savingDirectoryGetter");
            Intrinsics.checkNotNullParameter(function1, "executorFactory");
            return invoke$default(function0, function02, function1, (com.instabug.commons.lifecycle.c) null, 8, (Object) null);
        }

        @JvmStatic
        @NotNull
        @JvmOverloads
        public static final StateSnapshotCaptor invoke(@NotNull Function0<? extends Context> function0, @NotNull Function0<? extends File> function02, @NotNull Function1<? super String, ? extends ScheduledExecutorService> function1, @NotNull com.instabug.commons.lifecycle.c cVar) {
            Intrinsics.checkNotNullParameter(function0, "ctxGetter");
            Intrinsics.checkNotNullParameter(function02, "savingDirectoryGetter");
            Intrinsics.checkNotNullParameter(function1, "executorFactory");
            Intrinsics.checkNotNullParameter(cVar, "lifecycleOwner");
            return new StateSnapshotCaptor(new e(function0, function02, function1), cVar);
        }

        public static /* synthetic */ StateSnapshotCaptor invoke$default(Function0 function0, Function0 function02, Function1 function1, com.instabug.commons.lifecycle.c cVar, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                function0 = new a(CommonsLocator.INSTANCE);
            }
            if ((i11 & 2) != 0) {
                function02 = new b(CommonsLocator.getCrashesCacheDir());
            }
            if ((i11 & 4) != 0) {
                function1 = new c(CommonsLocator.INSTANCE);
            }
            if ((i11 & 8) != 0) {
                cVar = CommonsLocator.INSTANCE.getCompositeLifecycleOwner();
            }
            return invoke(function0, function02, function1, cVar);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StateSnapshotCaptor(@NotNull e eVar, @NotNull c cVar) {
        super(eVar.b());
        Intrinsics.checkNotNullParameter(eVar, "configurations");
        Intrinsics.checkNotNullParameter(cVar, "lifecycleOwner");
        this.configurations = eVar;
        this.lifecycleOwner = cVar;
    }

    private final File getOldSnapshotFile(File file) {
        return new File(Intrinsics.stringPlus(file.getAbsolutePath(), OLD_STATE_SNAPSHOT_FILE_SUFFIX));
    }

    private final File getSnapshotFile(File file) {
        return new File(file.getAbsolutePath() + File.separator + STATE_SNAPSHOT_FILE_NAME);
    }

    public void c() {
        File c11;
        File file;
        if (!Thread.currentThread().isInterrupted() && (c11 = this.configurations.c()) != null) {
            File snapshotFile = getSnapshotFile(c11);
            File file2 = null;
            if (!snapshotFile.exists()) {
                snapshotFile = null;
            }
            if (snapshotFile == null) {
                file = null;
            } else {
                file = getOldSnapshotFile(snapshotFile);
                snapshotFile.renameTo(file);
            }
            File parentFile = getSnapshotFile(c11).getParentFile();
            if (parentFile != null) {
                if (parentFile.exists()) {
                    file2 = parentFile;
                }
                if (file2 == null) {
                    parentFile.mkdirs();
                    Unit unit = Unit.INSTANCE;
                }
            }
            Context a11 = this.configurations.a();
            if (a11 != null) {
                State build = new State.Builder(a11).withCurrentActivity(true).build(true, true, 1.0f);
                build.updateVisualUserSteps();
                File snapshotFile2 = getSnapshotFile(c11);
                Intrinsics.checkNotNullExpressionValue(build, "savable");
                FileKtxKt.writeSerializable(snapshotFile2, build);
            }
            if (file != null) {
                file.delete();
            }
            a.b("State snapshot captured");
        }
    }

    @NotNull
    public String d() {
        return CAPTOR_NAME;
    }

    public long e() {
        return 5;
    }

    public int getId() {
        return 1;
    }

    public void i() {
        this.lifecycleOwner.b(this);
    }

    public void j() {
        this.lifecycleOwner.a(this);
    }

    public void onActivityStarted() {
        a.b("StateSnapshotCaptor: Activity started");
        force();
    }

    public void onBackgrounded() {
        a.b("StateSnapshotCaptor: Backgrounded");
    }

    public void onFragmentStarted() {
        a.b("StateSnapshotCaptor: Fragment started");
        force();
    }
}
