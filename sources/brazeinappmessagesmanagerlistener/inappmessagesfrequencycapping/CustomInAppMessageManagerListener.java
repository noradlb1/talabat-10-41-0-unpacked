package brazeinappmessagesmanagerlistener.inappmessagesfrequencycapping;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import brazeinappmessagesmanagerlistener.inappmessagesfrequencycapping.repo.InAppMessagesCappingRepoImpl;
import brazeinappmessagesmanagerlistener.inappmessagesfrequencycapping.usecase.ShouldDisplayInAppMessage;
import c4.b;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.inappmessage.MessageButton;
import com.braze.ui.inappmessage.InAppMessageCloser;
import com.braze.ui.inappmessage.InAppMessageOperation;
import com.braze.ui.inappmessage.listeners.IInAppMessageManagerListener;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.projects.ecosystems.EcosystemsFeatureFlagsKeys;
import com.talabat.helpers.DateUtils;
import com.talabat.helpers.GlobalConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lbrazeinappmessagesmanagerlistener/inappmessagesfrequencycapping/CustomInAppMessageManagerListener;", "Lcom/braze/ui/inappmessage/listeners/IInAppMessageManagerListener;", "shouldDisplayInAppMessage", "Lbrazeinappmessagesmanagerlistener/inappmessagesfrequencycapping/usecase/ShouldDisplayInAppMessage;", "dateUtils", "Lcom/talabat/helpers/DateUtils;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "(Lbrazeinappmessagesmanagerlistener/inappmessagesfrequencycapping/usecase/ShouldDisplayInAppMessage;Lcom/talabat/helpers/DateUtils;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "beforeInAppMessageDisplayed", "Lcom/braze/ui/inappmessage/InAppMessageOperation;", "inAppMessage", "Lcom/braze/models/inappmessage/IInAppMessage;", "handleInAppMessageDisplayStatus", "currentTimeStamp", "", "Companion", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CustomInAppMessageManagerListener implements IInAppMessageManagerListener {
    @NotNull
    public static final String CATEGORY_KEY = "priority_category";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final DateUtils dateUtils;
    @NotNull
    private final ShouldDisplayInAppMessage shouldDisplayInAppMessage;
    @NotNull
    private final ITalabatFeatureFlag talabatFeatureFlag;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lbrazeinappmessagesmanagerlistener/inappmessagesfrequencycapping/CustomInAppMessageManagerListener$Companion;", "", "()V", "CATEGORY_KEY", "", "initCustomIAMListener", "Lbrazeinappmessagesmanagerlistener/inappmessagesfrequencycapping/CustomInAppMessageManagerListener;", "context", "Landroid/content/Context;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final CustomInAppMessageManagerListener initCustomIAMListener(@Nullable Context context, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
            SharedPreferences sharedPreferences;
            Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
            if (context != null) {
                sharedPreferences = context.getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0);
            } else {
                sharedPreferences = null;
            }
            if (sharedPreferences != null) {
                return new CustomInAppMessageManagerListener(new ShouldDisplayInAppMessage(new InAppMessagesCappingRepoImpl(sharedPreferences)), new DateUtils(), iTalabatFeatureFlag);
            }
            throw new IllegalStateException("context is required for CustomInAppMessageManagerListener creation".toString());
        }
    }

    public CustomInAppMessageManagerListener(@NotNull ShouldDisplayInAppMessage shouldDisplayInAppMessage2, @NotNull DateUtils dateUtils2, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(shouldDisplayInAppMessage2, "shouldDisplayInAppMessage");
        Intrinsics.checkNotNullParameter(dateUtils2, "dateUtils");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        this.shouldDisplayInAppMessage = shouldDisplayInAppMessage2;
        this.dateUtils = dateUtils2;
        this.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    private final InAppMessageOperation handleInAppMessageDisplayStatus(IInAppMessage iInAppMessage, long j11) {
        if (this.shouldDisplayInAppMessage.invoke(j11, iInAppMessage.getExtras().get(CATEGORY_KEY))) {
            return InAppMessageOperation.DISPLAY_NOW;
        }
        return InAppMessageOperation.DISPLAY_LATER;
    }

    public /* synthetic */ void afterInAppMessageViewClosed(IInAppMessage iInAppMessage) {
        b.a(this, iInAppMessage);
    }

    public /* synthetic */ void afterInAppMessageViewOpened(View view, IInAppMessage iInAppMessage) {
        b.b(this, view, iInAppMessage);
    }

    @NotNull
    public InAppMessageOperation beforeInAppMessageDisplayed(@NotNull IInAppMessage iInAppMessage) {
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        if (this.talabatFeatureFlag.getFeatureFlag(EcosystemsFeatureFlagsKeys.IS_IN_APP_MESSAGES_FREQUENCY_CAPPING_ENABLED, false)) {
            return handleInAppMessageDisplayStatus(iInAppMessage, this.dateUtils.currentTimeInMillis());
        }
        return b.c(this, iInAppMessage);
    }

    public /* synthetic */ void beforeInAppMessageViewClosed(View view, IInAppMessage iInAppMessage) {
        b.d(this, view, iInAppMessage);
    }

    public /* synthetic */ void beforeInAppMessageViewOpened(View view, IInAppMessage iInAppMessage) {
        b.e(this, view, iInAppMessage);
    }

    public /* synthetic */ boolean onInAppMessageButtonClicked(IInAppMessage iInAppMessage, MessageButton messageButton) {
        return b.f(this, iInAppMessage, messageButton);
    }

    public /* synthetic */ boolean onInAppMessageButtonClicked(IInAppMessage iInAppMessage, MessageButton messageButton, InAppMessageCloser inAppMessageCloser) {
        return b.g(this, iInAppMessage, messageButton, inAppMessageCloser);
    }

    public /* synthetic */ boolean onInAppMessageClicked(IInAppMessage iInAppMessage) {
        return b.h(this, iInAppMessage);
    }

    public /* synthetic */ boolean onInAppMessageClicked(IInAppMessage iInAppMessage, InAppMessageCloser inAppMessageCloser) {
        return b.i(this, iInAppMessage, inAppMessageCloser);
    }

    public /* synthetic */ void onInAppMessageDismissed(IInAppMessage iInAppMessage) {
        b.j(this, iInAppMessage);
    }
}
