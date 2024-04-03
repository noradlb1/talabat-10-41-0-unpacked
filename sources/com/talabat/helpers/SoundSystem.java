package com.talabat.helpers;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/helpers/SoundSystem;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "playNotificationSound", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SoundSystem {
    @NotNull
    private final Context context;

    public SoundSystem() {
        this((Context) null, 1, (DefaultConstructorMarker) null);
    }

    public SoundSystem(@NotNull Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public final void playNotificationSound() {
        MediaPlayer create = MediaPlayer.create(this.context, RingtoneManager.getDefaultUri(2));
        if (create != null) {
            create.start();
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SoundSystem(android.content.Context r1, int r2, kotlin.jvm.internal.DefaultConstructorMarker r3) {
        /*
            r0 = this;
            r2 = r2 & 1
            if (r2 == 0) goto L_0x0013
            com.talabat.talabatcore.application.BaseApplication$Companion r1 = com.talabat.talabatcore.application.BaseApplication.Companion
            com.talabat.talabatcore.application.BaseApplication r1 = r1.getInstance()
            android.content.Context r1 = r1.getApplicationContext()
            java.lang.String r2 = "BaseApplication.instance.applicationContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
        L_0x0013:
            r0.<init>(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.helpers.SoundSystem.<init>(android.content.Context, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
