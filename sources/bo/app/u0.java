package bo.app;

import com.braze.support.BrazeLogger;
import com.visa.checkout.Profile;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ7\u0010\b\u001a\u00028\u0000\"\u0010\b\u0000\u0010\u0003*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0007¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\nH\u0007J:\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\u000e\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\fH\u0007¨\u0006\u0010"}, d2 = {"Lbo/app/u0;", "", "", "TargetEnum", "", "enumValue", "Ljava/lang/Class;", "targetEnumClass", "a", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Enum;", "Ljava/util/EnumSet;", "sourceEnumSet", "", "sourceStringSet", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class u0 {

    /* renamed from: a  reason: collision with root package name */
    public static final u0 f39450a = new u0();

    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "TargetEnum", "", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class a extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f39451b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(String str) {
            super(0);
            this.f39451b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Failed to create valid enum from string: ", this.f39451b);
        }
    }

    private u0() {
    }

    @JvmStatic
    public static final <TargetEnum extends Enum<TargetEnum>> TargetEnum a(String str, Class<TargetEnum> cls) {
        Intrinsics.checkNotNullParameter(str, "enumValue");
        Intrinsics.checkNotNullParameter(cls, "targetEnumClass");
        return Enum.valueOf(cls, str);
    }

    @JvmStatic
    public static final <TargetEnum extends Enum<TargetEnum>> EnumSet<TargetEnum> a(Class<TargetEnum> cls, Set<String> set) {
        Intrinsics.checkNotNullParameter(cls, "targetEnumClass");
        Intrinsics.checkNotNullParameter(set, "sourceStringSet");
        EnumSet<TargetEnum> noneOf = EnumSet.noneOf(cls);
        for (String str : set) {
            try {
                Locale locale = Locale.US;
                Intrinsics.checkNotNullExpressionValue(locale, Profile.Country.US);
                String upperCase = str.toUpperCase(locale);
                Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
                noneOf.add(a(upperCase, cls));
            } catch (Exception e11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) f39450a, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) new a(str), 4, (Object) null);
            }
        }
        Intrinsics.checkNotNullExpressionValue(noneOf, "result");
        return noneOf;
    }

    @JvmStatic
    public static final Set<String> a(EnumSet<?> enumSet) {
        Intrinsics.checkNotNullParameter(enumSet, "sourceEnumSet");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(enumSet, 10));
        Iterator<T> it = enumSet.iterator();
        while (it.hasNext()) {
            arrayList.add(((Enum) it.next()).name());
        }
        return CollectionsKt___CollectionsKt.toSet(arrayList);
    }
}
