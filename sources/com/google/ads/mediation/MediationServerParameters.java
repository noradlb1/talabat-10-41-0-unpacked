package com.google.ads.mediation;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.internal.ads.zzciz;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@Deprecated
public abstract class MediationServerParameters {

    public static final class MappingException extends Exception {
        public MappingException(@RecentlyNonNull String str) {
            super(str);
        }
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Parameter {
        @RecentlyNonNull
        String name();

        boolean required() default true;
    }

    public void load(@RecentlyNonNull Map<String, String> map) throws MappingException {
        Class cls;
        String str;
        String str2;
        HashMap hashMap = new HashMap();
        Field[] fields = getClass().getFields();
        int length = fields.length;
        int i11 = 0;
        while (true) {
            cls = Parameter.class;
            if (i11 >= length) {
                break;
            }
            Field field = fields[i11];
            Parameter parameter = (Parameter) field.getAnnotation(cls);
            if (parameter != null) {
                hashMap.put(parameter.name(), field);
            }
            i11++;
        }
        if (hashMap.isEmpty()) {
            zzciz.zzj("No server options fields detected. To suppress this message either add a field with the @Parameter annotation, or override the load() method.");
        }
        for (Map.Entry next : map.entrySet()) {
            Field field2 = (Field) hashMap.remove(next.getKey());
            if (field2 != null) {
                try {
                    field2.set(this, next.getValue());
                } catch (IllegalAccessException unused) {
                    String str3 = (String) next.getKey();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(str3).length() + 49);
                    sb2.append("Server option \"");
                    sb2.append(str3);
                    sb2.append("\" could not be set: Illegal Access");
                    zzciz.zzj(sb2.toString());
                } catch (IllegalArgumentException unused2) {
                    String str4 = (String) next.getKey();
                    StringBuilder sb3 = new StringBuilder(String.valueOf(str4).length() + 43);
                    sb3.append("Server option \"");
                    sb3.append(str4);
                    sb3.append("\" could not be set: Bad Type");
                    zzciz.zzj(sb3.toString());
                }
            } else {
                String str5 = (String) next.getKey();
                String str6 = (String) next.getValue();
                StringBuilder sb4 = new StringBuilder(String.valueOf(str5).length() + 31 + String.valueOf(str6).length());
                sb4.append("Unexpected server option: ");
                sb4.append(str5);
                sb4.append(" = \"");
                sb4.append(str6);
                sb4.append("\"");
                zzciz.zze(sb4.toString());
            }
        }
        StringBuilder sb5 = new StringBuilder();
        for (Field field3 : hashMap.values()) {
            if (((Parameter) field3.getAnnotation(cls)).required()) {
                String valueOf = String.valueOf(((Parameter) field3.getAnnotation(cls)).name());
                if (valueOf.length() != 0) {
                    str2 = "Required server option missing: ".concat(valueOf);
                } else {
                    str2 = new String("Required server option missing: ");
                }
                zzciz.zzj(str2);
                if (sb5.length() > 0) {
                    sb5.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                }
                sb5.append(((Parameter) field3.getAnnotation(cls)).name());
            }
        }
        if (sb5.length() > 0) {
            String sb6 = sb5.toString();
            if (sb6.length() != 0) {
                str = "Required server option(s) missing: ".concat(sb6);
            } else {
                str = new String("Required server option(s) missing: ");
            }
            throw new MappingException(str);
        }
    }
}
