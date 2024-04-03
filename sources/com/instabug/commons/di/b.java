package com.instabug.commons.di;

import android.content.Context;
import com.instabug.library.internal.storage.AttachmentManager;
import java.io.File;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

final class b extends Lambda implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public static final b f46306a = new b();

    public b() {
        super(1);
    }

    @Nullable
    /* renamed from: a */
    public final File invoke(@Nullable Context context) {
        return AttachmentManager.getAttachmentDirectory(context);
    }
}
