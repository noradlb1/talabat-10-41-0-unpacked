package com.talabat.splash.data.local;

import android.content.Context;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/talabat/splash/data/local/LocalCache;", "", "context", "Landroid/content/Context;", "fileFactory", "Lkotlin/Function1;", "", "Ljava/io/File;", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "downloadFolder", "getDownloadFolder", "()Ljava/io/File;", "fileExists", "", "path", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LocalCache {
    @NotNull
    private final Context context;
    @NotNull
    private final Function1<String, File> fileFactory;

    public LocalCache(@NotNull Context context2, @NotNull Function1<? super String, ? extends File> function1) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(function1, "fileFactory");
        this.context = context2;
        this.fileFactory = function1;
    }

    public final boolean fileExists(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "path");
        return this.fileFactory.invoke(str).exists();
    }

    @NotNull
    public final File getDownloadFolder() {
        Function1<String, File> function1 = this.fileFactory;
        String path = this.context.getCacheDir().getPath();
        return function1.invoke(path + "/downloads/");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LocalCache(Context context2, Function1 function1, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context2, (i11 & 2) != 0 ? AnonymousClass1.INSTANCE : function1);
    }
}
