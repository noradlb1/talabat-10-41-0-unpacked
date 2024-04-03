package com.braze.ui.inappmessage;

import androidx.annotation.Keep;
import com.visa.checkout.Profile;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0007"}, d2 = {"Lcom/braze/ui/inappmessage/InAppMessageOperation;", "", "(Ljava/lang/String;I)V", "DISPLAY_NOW", "DISPLAY_LATER", "DISCARD", "Companion", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum InAppMessageOperation {
    DISPLAY_NOW,
    DISPLAY_LATER,
    DISCARD;
    
    @NotNull
    public static final Companion Companion = null;

    @Keep
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/braze/ui/inappmessage/InAppMessageOperation$Companion;", "", "()V", "fromValue", "Lcom/braze/ui/inappmessage/InAppMessageOperation;", "value", "", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @Nullable
        public final InAppMessageOperation fromValue(@Nullable String str) {
            String str2;
            InAppMessageOperation inAppMessageOperation;
            String name2;
            InAppMessageOperation[] values = InAppMessageOperation.values();
            int length = values.length;
            int i11 = 0;
            do {
                str2 = null;
                if (i11 >= length) {
                    return null;
                }
                inAppMessageOperation = values[i11];
                i11++;
                name2 = inAppMessageOperation.name();
                if (str != null) {
                    Locale locale = Locale.US;
                    Intrinsics.checkNotNullExpressionValue(locale, Profile.Country.US);
                    str2 = str.toUpperCase(locale);
                    Intrinsics.checkNotNullExpressionValue(str2, "this as java.lang.String).toUpperCase(locale)");
                }
            } while (!Intrinsics.areEqual((Object) name2, (Object) str2));
            return inAppMessageOperation;
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    @JvmStatic
    @Nullable
    public static final InAppMessageOperation fromValue(@Nullable String str) {
        return Companion.fromValue(str);
    }
}
