package library.talabat.mvp.welcomevideo;

import com.talabat.helpers.TalabatUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Llibrary/talabat/mvp/welcomevideo/WelcomeVideoPresenter;", "Llibrary/talabat/mvp/welcomevideo/IWelcomVideoPresenter;", "mView", "Llibrary/talabat/mvp/welcomevideo/IWelcomVideoView;", "(Llibrary/talabat/mvp/welcomevideo/IWelcomVideoView;)V", "loadVideoView", "", "videoPath", "", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WelcomeVideoPresenter implements IWelcomVideoPresenter {
    @NotNull
    private final IWelcomVideoView mView;

    public WelcomeVideoPresenter(@NotNull IWelcomVideoView iWelcomVideoView) {
        Intrinsics.checkNotNullParameter(iWelcomVideoView, "mView");
        this.mView = iWelcomVideoView;
    }

    public void loadVideoView(@Nullable String str) {
        if (TalabatUtils.isNullOrEmpty(str)) {
            this.mView.playWelcomeVideo(str);
        } else {
            this.mView.loadWelocomeImageView();
        }
    }
}
