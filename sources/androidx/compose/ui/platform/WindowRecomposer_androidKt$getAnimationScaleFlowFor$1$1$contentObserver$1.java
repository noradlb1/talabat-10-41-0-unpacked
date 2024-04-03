package androidx.compose.ui.platform;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.channels.Channel;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"androidx/compose/ui/platform/WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1", "Landroid/database/ContentObserver;", "onChange", "", "selfChange", "", "uri", "Landroid/net/Uri;", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1 extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Channel<Unit> f10100a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1(Channel<Unit> channel, Handler handler) {
        super(handler);
        this.f10100a = channel;
    }

    public void onChange(boolean z11, @Nullable Uri uri) {
        this.f10100a.m7820trySendJP2dKIU(Unit.INSTANCE);
    }
}
