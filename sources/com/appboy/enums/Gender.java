package com.appboy.enums;

import com.braze.models.IPutIntoJson;
import com.braze.support.BrazeLogger;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0001\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u000fB\u000f\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\u0003H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/appboy/enums/Gender;", "", "Lcom/braze/models/IPutIntoJson;", "", "value", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "forJsonPut", "MALE", "FEMALE", "OTHER", "UNKNOWN", "NOT_APPLICABLE", "PREFER_NOT_TO_SAY", "Companion", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum Gender implements IPutIntoJson<String> {
    MALE("m"),
    FEMALE("f"),
    OTHER("o"),
    UNKNOWN("u"),
    NOT_APPLICABLE("n"),
    PREFER_NOT_TO_SAY("p");
    
    public static final Companion Companion = null;
    private final String value;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/appboy/enums/Gender$Companion;", "", "()V", "getGender", "Lcom/appboy/enums/Gender;", "value", "", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class a extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f40730b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(0);
                this.f40730b = str;
            }

            /* renamed from: a */
            public final String invoke() {
                return "No gender with value " + this.f40730b + '.';
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final Gender getGender(String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            Gender[] values = Gender.values();
            int length = values.length;
            Gender gender = null;
            int i11 = 0;
            Gender gender2 = null;
            boolean z11 = false;
            while (true) {
                if (i11 < length) {
                    Gender gender3 = values[i11];
                    i11++;
                    if (Intrinsics.areEqual((Object) gender3.getValue(), (Object) str)) {
                        if (z11) {
                            break;
                        }
                        z11 = true;
                        gender2 = gender3;
                    }
                } else if (z11) {
                    gender = gender2;
                }
            }
            if (gender == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new a(str), 6, (Object) null);
            }
            return gender;
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    private Gender(String str) {
        this.value = str;
    }

    @JvmStatic
    public static final Gender getGender(String str) {
        return Companion.getGender(str);
    }

    public final String getValue() {
        return this.value;
    }

    public String forJsonPut() {
        return this.value;
    }
}
