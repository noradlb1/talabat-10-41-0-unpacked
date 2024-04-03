package com.designsystem.ds_input_field.country;

import android.content.Context;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/designsystem/ds_input_field/country/CountryUtils;", "", "()V", "Companion", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class CountryUtils {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String DOMINICAN_REPUBLIC_ALTERNATIVE_CODE = "dominican_republic";
    @NotNull
    private static final String DOMINICAN_REPUBLIC_CODE = "do";

    @Instrumented
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\fJ\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e2\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/designsystem/ds_input_field/country/CountryUtils$Companion;", "", "()V", "DOMINICAN_REPUBLIC_ALTERNATIVE_CODE", "", "DOMINICAN_REPUBLIC_CODE", "getFlagImageIdForCountry", "", "context", "Landroid/content/Context;", "country", "Lcom/designsystem/ds_input_field/country/DSCountryModel;", "(Landroid/content/Context;Lcom/designsystem/ds_input_field/country/DSCountryModel;)Ljava/lang/Integer;", "readCountryList", "", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Integer getFlagImageIdForCountry(Context context, DSCountryModel dSCountryModel) {
            String code = dSCountryModel.getCode();
            if (code != null) {
                String lowerCase = code.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                if (Intrinsics.areEqual((Object) lowerCase, (Object) CountryUtils.DOMINICAN_REPUBLIC_CODE)) {
                    lowerCase = CountryUtils.DOMINICAN_REPUBLIC_ALTERNATIVE_CODE;
                }
                int identifier = context.getResources().getIdentifier(lowerCase, "drawable", context.getPackageName());
                if (identifier == 0) {
                    return null;
                }
                return Integer.valueOf(identifier);
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x007d, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x007e, code lost:
            kotlin.io.CloseableKt.closeFinally(r3, r12);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0081, code lost:
            throw r0;
         */
        @org.jetbrains.annotations.NotNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.util.List<com.designsystem.ds_input_field.country.DSCountryModel> readCountryList(@org.jetbrains.annotations.NotNull android.content.Context r12) {
            /*
                r11 = this;
                java.lang.String r0 = "context"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
                android.content.res.Resources r0 = r12.getResources()
                int r1 = com.designsystem.marshmallow.R.raw.country_data
                java.io.InputStream r0 = r0.openRawResource(r1)
                java.lang.String r1 = "context.resources.openRa…ource(R.raw.country_data)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                com.designsystem.ds_input_field.country.CountryUtils$Companion$readCountryList$countryListType$1 r1 = new com.designsystem.ds_input_field.country.CountryUtils$Companion$readCountryList$countryListType$1
                r1.<init>()
                java.lang.reflect.Type r1 = r1.getType()
                java.nio.charset.Charset r2 = kotlin.text.Charsets.UTF_8
                java.io.InputStreamReader r3 = new java.io.InputStreamReader
                r3.<init>(r0, r2)
                boolean r0 = r3 instanceof java.io.BufferedReader
                if (r0 == 0) goto L_0x002b
                java.io.BufferedReader r3 = (java.io.BufferedReader) r3
                goto L_0x0033
            L_0x002b:
                java.io.BufferedReader r0 = new java.io.BufferedReader
                r2 = 8192(0x2000, float:1.14794E-41)
                r0.<init>(r3, r2)
                r3 = r0
            L_0x0033:
                com.google.gson.Gson r0 = new com.google.gson.Gson     // Catch:{ all -> 0x007b }
                r0.<init>()     // Catch:{ all -> 0x007b }
                java.lang.Object r0 = com.newrelic.agent.android.instrumentation.GsonInstrumentation.fromJson((com.google.gson.Gson) r0, (java.io.Reader) r3, (java.lang.reflect.Type) r1)     // Catch:{ all -> 0x007b }
                java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x007b }
                r1 = 0
                kotlin.io.CloseableKt.closeFinally(r3, r1)
                java.lang.String r1 = "resourceStream.bufferedR…ryListType)\n            }"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                java.lang.Iterable r0 = (java.lang.Iterable) r0
                java.util.ArrayList r1 = new java.util.ArrayList
                r2 = 10
                int r2 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r0, r2)
                r1.<init>(r2)
                java.util.Iterator r0 = r0.iterator()
            L_0x0058:
                boolean r2 = r0.hasNext()
                if (r2 == 0) goto L_0x007a
                java.lang.Object r2 = r0.next()
                r3 = r2
                com.designsystem.ds_input_field.country.DSCountryModel r3 = (com.designsystem.ds_input_field.country.DSCountryModel) r3
                com.designsystem.ds_input_field.country.CountryUtils$Companion r2 = com.designsystem.ds_input_field.country.CountryUtils.Companion
                java.lang.Integer r5 = r2.getFlagImageIdForCountry(r12, r3)
                r4 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 29
                r10 = 0
                com.designsystem.ds_input_field.country.DSCountryModel r2 = com.designsystem.ds_input_field.country.DSCountryModel.copy$default(r3, r4, r5, r6, r7, r8, r9, r10)
                r1.add(r2)
                goto L_0x0058
            L_0x007a:
                return r1
            L_0x007b:
                r12 = move-exception
                throw r12     // Catch:{ all -> 0x007d }
            L_0x007d:
                r0 = move-exception
                kotlin.io.CloseableKt.closeFinally(r3, r12)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_input_field.country.CountryUtils.Companion.readCountryList(android.content.Context):java.util.List");
        }
    }
}
