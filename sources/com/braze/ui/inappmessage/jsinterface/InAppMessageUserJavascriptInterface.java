package com.braze.ui.inappmessage.jsinterface;

import android.content.Context;
import android.webkit.JavascriptInterface;
import androidx.annotation.VisibleForTesting;
import b4.a;
import com.appboy.enums.Gender;
import com.appboy.enums.Month;
import com.appboy.enums.NotificationSubscriptionType;
import com.braze.Braze;
import com.braze.BrazeUser;
import com.braze.support.BrazeLogger;
import com.visa.checkout.Profile;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 ?2\u00020\u0001:\u0001?B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0007J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\bH\u0007J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\bH\u0007J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\bH\u0007J!\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0002\u0010\u001bJ\u0018\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0007J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\bH\u0007J\u0012\u0010\u001e\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\bH\u0007J \u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010#\u001a\u00020\bH\u0007J \u0010$\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&H\u0007J\u001a\u0010(\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\bH\u0007J\u0018\u0010)\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010#\u001a\u00020\bH\u0007J \u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010,\u001a\u00020\u0014H\u0007J\u0012\u0010-\u001a\u00020\u00062\b\u0010.\u001a\u0004\u0018\u00010\bH\u0007J\u0010\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020\bH\u0007J\u0012\u00101\u001a\u00020\u00062\b\u00102\u001a\u0004\u0018\u00010\bH\u0007J\u0010\u00103\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\bH\u0007J\u0012\u00104\u001a\u00020\u00062\b\u00105\u001a\u0004\u0018\u00010\bH\u0007J\u0012\u00106\u001a\u00020\u00062\b\u00107\u001a\u0004\u0018\u00010\bH\u0007J\u0012\u00108\u001a\u00020\u00062\b\u00109\u001a\u0004\u0018\u00010\bH\u0007J\u0012\u0010:\u001a\u00020\u00062\b\u0010;\u001a\u0004\u0018\u00010\bH\u0007J\u0010\u0010<\u001a\u00020\u00062\u0006\u00100\u001a\u00020\bH\u0007J\u0014\u0010=\u001a\u0004\u0018\u00010>2\b\u00100\u001a\u0004\u0018\u00010\bH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/braze/ui/inappmessage/jsinterface/InAppMessageUserJavascriptInterface;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "addAlias", "", "alias", "", "label", "addToCustomAttributeArray", "key", "value", "addToSubscriptionGroup", "subscriptionGroupId", "incrementCustomUserAttribute", "attribute", "monthFromInt", "Lcom/appboy/enums/Month;", "monthInt", "", "parseGender", "Lcom/appboy/enums/Gender;", "genderString", "parseStringArrayFromJsonString", "", "jsonArrayString", "(Ljava/lang/String;)[Ljava/lang/String;", "removeFromCustomAttributeArray", "removeFromSubscriptionGroup", "setCountry", "country", "setCustomAttribute", "user", "Lcom/braze/BrazeUser;", "jsonStringValue", "setCustomLocationAttribute", "latitude", "", "longitude", "setCustomUserAttributeArray", "setCustomUserAttributeJSON", "setDateOfBirth", "year", "day", "setEmail", "email", "setEmailNotificationSubscriptionType", "subscriptionType", "setFirstName", "firstName", "setGender", "setHomeCity", "homeCity", "setLanguage", "language", "setLastName", "lastName", "setPhoneNumber", "phoneNumber", "setPushNotificationSubscriptionType", "subscriptionTypeFromJavascriptString", "Lcom/appboy/enums/NotificationSubscriptionType;", "Companion", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class InAppMessageUserJavascriptInterface {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String JS_BRIDGE_ATTRIBUTE_VALUE = "value";
    @NotNull
    private final Context context;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J/\u0010\u0005\u001a\u00020\u0006*\u00020\u00072!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00060\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/braze/ui/inappmessage/jsinterface/InAppMessageUserJavascriptInterface$Companion;", "", "()V", "JS_BRIDGE_ATTRIBUTE_VALUE", "", "runOnUser", "", "Lcom/braze/Braze;", "block", "Lkotlin/Function1;", "Lcom/braze/BrazeUser;", "Lkotlin/ParameterName;", "name", "user", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final void runOnUser(Braze braze, Function1<? super BrazeUser, Unit> function1) {
            braze.getCurrentUser(new a(function1));
        }

        /* access modifiers changed from: private */
        /* renamed from: runOnUser$lambda-0  reason: not valid java name */
        public static final void m9217runOnUser$lambda0(Function1 function1, BrazeUser brazeUser) {
            Intrinsics.checkNotNullParameter(function1, "$block");
            Intrinsics.checkNotNullParameter(brazeUser, "it");
            function1.invoke(brazeUser);
        }
    }

    public InAppMessageUserJavascriptInterface(@NotNull Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    @JavascriptInterface
    public final void addAlias(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "alias");
        Intrinsics.checkNotNullParameter(str2, "label");
        Companion.runOnUser(Braze.Companion.getInstance(this.context), new InAppMessageUserJavascriptInterface$addAlias$1(str, str2));
    }

    @JavascriptInterface
    public final void addToCustomAttributeArray(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "value");
        Companion.runOnUser(Braze.Companion.getInstance(this.context), new InAppMessageUserJavascriptInterface$addToCustomAttributeArray$1(str, str2));
    }

    @JavascriptInterface
    public final void addToSubscriptionGroup(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "subscriptionGroupId");
        Companion.runOnUser(Braze.Companion.getInstance(this.context), new InAppMessageUserJavascriptInterface$addToSubscriptionGroup$1(str));
    }

    @JavascriptInterface
    public final void incrementCustomUserAttribute(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "attribute");
        Companion.runOnUser(Braze.Companion.getInstance(this.context), new InAppMessageUserJavascriptInterface$incrementCustomUserAttribute$1(str));
    }

    @VisibleForTesting
    @Nullable
    public final Month monthFromInt(int i11) {
        if (i11 < 1 || i11 > 12) {
            return null;
        }
        return Month.Companion.getMonth(i11 - 1);
    }

    @VisibleForTesting
    @Nullable
    public final Gender parseGender(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "genderString");
        Locale locale = Locale.US;
        Intrinsics.checkNotNullExpressionValue(locale, Profile.Country.US);
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        Gender gender = Gender.MALE;
        if (Intrinsics.areEqual((Object) lowerCase, (Object) gender.forJsonPut())) {
            return gender;
        }
        Gender gender2 = Gender.FEMALE;
        if (Intrinsics.areEqual((Object) lowerCase, (Object) gender2.forJsonPut())) {
            return gender2;
        }
        Gender gender3 = Gender.OTHER;
        if (Intrinsics.areEqual((Object) lowerCase, (Object) gender3.forJsonPut())) {
            return gender3;
        }
        Gender gender4 = Gender.UNKNOWN;
        if (Intrinsics.areEqual((Object) lowerCase, (Object) gender4.forJsonPut())) {
            return gender4;
        }
        Gender gender5 = Gender.NOT_APPLICABLE;
        if (Intrinsics.areEqual((Object) lowerCase, (Object) gender5.forJsonPut())) {
            return gender5;
        }
        Gender gender6 = Gender.PREFER_NOT_TO_SAY;
        if (Intrinsics.areEqual((Object) lowerCase, (Object) gender6.forJsonPut())) {
            return gender6;
        }
        return null;
    }

    @VisibleForTesting
    @Nullable
    public final String[] parseStringArrayFromJsonString(@Nullable String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            ArrayList arrayList = new ArrayList(length);
            for (int i11 = 0; i11 < length; i11++) {
                arrayList.add(jSONArray.getString(i11));
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array != null) {
                return (String[]) array;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) InAppMessageUserJavascriptInterface$parseStringArrayFromJsonString$2.INSTANCE, 4, (Object) null);
            return null;
        }
    }

    @JavascriptInterface
    public final void removeFromCustomAttributeArray(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "value");
        Companion.runOnUser(Braze.Companion.getInstance(this.context), new InAppMessageUserJavascriptInterface$removeFromCustomAttributeArray$1(str, str2));
    }

    @JavascriptInterface
    public final void removeFromSubscriptionGroup(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "subscriptionGroupId");
        Companion.runOnUser(Braze.Companion.getInstance(this.context), new InAppMessageUserJavascriptInterface$removeFromSubscriptionGroup$1(str));
    }

    @JavascriptInterface
    public final void setCountry(@Nullable String str) {
        Companion.runOnUser(Braze.Companion.getInstance(this.context), new InAppMessageUserJavascriptInterface$setCountry$1(str));
    }

    @VisibleForTesting
    public final void setCustomAttribute(@NotNull BrazeUser brazeUser, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(brazeUser, "user");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "jsonStringValue");
        try {
            Object obj = new JSONObject(str2).get("value");
            if (obj instanceof String) {
                brazeUser.setCustomUserAttribute(str, (String) obj);
            } else if (obj instanceof Boolean) {
                brazeUser.setCustomUserAttribute(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Integer) {
                brazeUser.setCustomUserAttribute(str, ((Number) obj).intValue());
            } else if (obj instanceof Double) {
                brazeUser.setCustomUserAttribute(str, ((Number) obj).doubleValue());
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new InAppMessageUserJavascriptInterface$setCustomAttribute$1(str, str2), 6, (Object) null);
            }
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) new InAppMessageUserJavascriptInterface$setCustomAttribute$2(str, str2), 4, (Object) null);
        }
    }

    @JavascriptInterface
    public final void setCustomLocationAttribute(@NotNull String str, double d11, double d12) {
        Intrinsics.checkNotNullParameter(str, "attribute");
        Companion.runOnUser(Braze.Companion.getInstance(this.context), new InAppMessageUserJavascriptInterface$setCustomLocationAttribute$1(str, d11, d12));
    }

    @JavascriptInterface
    public final void setCustomUserAttributeArray(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        String[] parseStringArrayFromJsonString = parseStringArrayFromJsonString(str2);
        if (parseStringArrayFromJsonString == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new InAppMessageUserJavascriptInterface$setCustomUserAttributeArray$1(str), 6, (Object) null);
            return;
        }
        Companion.runOnUser(Braze.Companion.getInstance(this.context), new InAppMessageUserJavascriptInterface$setCustomUserAttributeArray$2(str, parseStringArrayFromJsonString));
    }

    @JavascriptInterface
    public final void setCustomUserAttributeJSON(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "jsonStringValue");
        Companion.runOnUser(Braze.Companion.getInstance(this.context), new InAppMessageUserJavascriptInterface$setCustomUserAttributeJSON$1(this, str, str2));
    }

    @JavascriptInterface
    public final void setDateOfBirth(int i11, int i12, int i13) {
        Month monthFromInt = monthFromInt(i12);
        if (monthFromInt == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new InAppMessageUserJavascriptInterface$setDateOfBirth$1(i12), 6, (Object) null);
            return;
        }
        Companion.runOnUser(Braze.Companion.getInstance(this.context), new InAppMessageUserJavascriptInterface$setDateOfBirth$2(i11, monthFromInt, i13));
    }

    @JavascriptInterface
    public final void setEmail(@Nullable String str) {
        Companion.runOnUser(Braze.Companion.getInstance(this.context), new InAppMessageUserJavascriptInterface$setEmail$1(str));
    }

    @JavascriptInterface
    public final void setEmailNotificationSubscriptionType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "subscriptionType");
        NotificationSubscriptionType subscriptionTypeFromJavascriptString = subscriptionTypeFromJavascriptString(str);
        if (subscriptionTypeFromJavascriptString == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new InAppMessageUserJavascriptInterface$setEmailNotificationSubscriptionType$1(str), 6, (Object) null);
            return;
        }
        Companion.runOnUser(Braze.Companion.getInstance(this.context), new InAppMessageUserJavascriptInterface$setEmailNotificationSubscriptionType$2(subscriptionTypeFromJavascriptString));
    }

    @JavascriptInterface
    public final void setFirstName(@Nullable String str) {
        Companion.runOnUser(Braze.Companion.getInstance(this.context), new InAppMessageUserJavascriptInterface$setFirstName$1(str));
    }

    @JavascriptInterface
    public final void setGender(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "genderString");
        Gender parseGender = parseGender(str);
        if (parseGender == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new InAppMessageUserJavascriptInterface$setGender$1(str), 6, (Object) null);
            return;
        }
        Companion.runOnUser(Braze.Companion.getInstance(this.context), new InAppMessageUserJavascriptInterface$setGender$2(parseGender));
    }

    @JavascriptInterface
    public final void setHomeCity(@Nullable String str) {
        Companion.runOnUser(Braze.Companion.getInstance(this.context), new InAppMessageUserJavascriptInterface$setHomeCity$1(str));
    }

    @JavascriptInterface
    public final void setLanguage(@Nullable String str) {
        Companion.runOnUser(Braze.Companion.getInstance(this.context), new InAppMessageUserJavascriptInterface$setLanguage$1(str));
    }

    @JavascriptInterface
    public final void setLastName(@Nullable String str) {
        Companion.runOnUser(Braze.Companion.getInstance(this.context), new InAppMessageUserJavascriptInterface$setLastName$1(str));
    }

    @JavascriptInterface
    public final void setPhoneNumber(@Nullable String str) {
        Companion.runOnUser(Braze.Companion.getInstance(this.context), new InAppMessageUserJavascriptInterface$setPhoneNumber$1(str));
    }

    @JavascriptInterface
    public final void setPushNotificationSubscriptionType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "subscriptionType");
        NotificationSubscriptionType subscriptionTypeFromJavascriptString = subscriptionTypeFromJavascriptString(str);
        if (subscriptionTypeFromJavascriptString == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new InAppMessageUserJavascriptInterface$setPushNotificationSubscriptionType$1(str), 6, (Object) null);
            return;
        }
        Companion.runOnUser(Braze.Companion.getInstance(this.context), new InAppMessageUserJavascriptInterface$setPushNotificationSubscriptionType$2(subscriptionTypeFromJavascriptString));
    }

    @VisibleForTesting
    @Nullable
    public final NotificationSubscriptionType subscriptionTypeFromJavascriptString(@Nullable String str) {
        return NotificationSubscriptionType.Companion.fromValue(str);
    }
}
