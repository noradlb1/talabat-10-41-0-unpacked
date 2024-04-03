package com.apptimize;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApptimizeVar<T> {

    /* renamed from: a  reason: collision with root package name */
    final String f40998a;

    /* renamed from: b  reason: collision with root package name */
    final String f40999b;

    /* renamed from: c  reason: collision with root package name */
    final String f41000c;

    /* renamed from: d  reason: collision with root package name */
    final T f41001d;

    public ApptimizeVar(String str, String str2, String str3, T t11) {
        this.f40998a = str;
        this.f40999b = str2;
        this.f41000c = str3;
        this.f41001d = t11;
    }

    public static ApptimizeVar<Boolean> createBoolean(String str, Boolean bool) {
        if (str != null) {
            return Apptimize.a(str, TypedValues.Custom.S_BOOLEAN, (String) null, bool);
        }
        throw new NullPointerException("Cannot create an ApptimizeVar with a null name");
    }

    public static ApptimizeVar<Double> createDouble(String str, Double d11) {
        if (str != null) {
            return Apptimize.a(str, "double", (String) null, d11);
        }
        throw new NullPointerException("Cannot create an ApptimizeVar with a null name");
    }

    public static ApptimizeVar<Integer> createInteger(String str, Integer num) {
        if (str != null) {
            return Apptimize.a(str, "int", (String) null, num);
        }
        throw new NullPointerException("Cannot create an ApptimizeVar with a null name");
    }

    public static ApptimizeVar<List<Boolean>> createListOfBooleans(String str, List<Boolean> list) {
        if (str == null) {
            throw new NullPointerException("Cannot create an ApptimizeVar with a null name");
        } else if (list == null) {
            return Apptimize.a(str, DefaultCardView.CARD_LIST, TypedValues.Custom.S_BOOLEAN, null);
        } else {
            return Apptimize.a(str, DefaultCardView.CARD_LIST, TypedValues.Custom.S_BOOLEAN, Collections.unmodifiableList(new ArrayList(list)));
        }
    }

    public static ApptimizeVar<List<Double>> createListOfDoubles(String str, List<Double> list) {
        if (str == null) {
            throw new NullPointerException("Cannot create an ApptimizeVar with a null name");
        } else if (list == null) {
            return Apptimize.a(str, DefaultCardView.CARD_LIST, "double", null);
        } else {
            return Apptimize.a(str, DefaultCardView.CARD_LIST, "double", Collections.unmodifiableList(new ArrayList(list)));
        }
    }

    public static ApptimizeVar<List<Integer>> createListOfIntegers(String str, List<Integer> list) {
        if (str == null) {
            throw new NullPointerException("Cannot create an ApptimizeVar with a null name");
        } else if (list == null) {
            return Apptimize.a(str, DefaultCardView.CARD_LIST, "int", null);
        } else {
            return Apptimize.a(str, DefaultCardView.CARD_LIST, "int", Collections.unmodifiableList(new ArrayList(list)));
        }
    }

    public static ApptimizeVar<List<String>> createListOfStrings(String str, List<String> list) {
        if (str == null) {
            throw new NullPointerException("Cannot create an ApptimizeVar with a null name");
        } else if (list == null) {
            return Apptimize.a(str, DefaultCardView.CARD_LIST, TypedValues.Custom.S_STRING, null);
        } else {
            return Apptimize.a(str, DefaultCardView.CARD_LIST, TypedValues.Custom.S_STRING, Collections.unmodifiableList(new ArrayList(list)));
        }
    }

    public static ApptimizeVar<Map<String, Boolean>> createMapOfBooleans(String str, Map<String, Boolean> map) {
        if (str == null) {
            throw new NullPointerException("Cannot create an ApptimizeVar with a null name");
        } else if (map == null) {
            return Apptimize.a(str, "dictionary", TypedValues.Custom.S_BOOLEAN, null);
        } else {
            return Apptimize.a(str, "dictionary", TypedValues.Custom.S_BOOLEAN, Collections.unmodifiableMap(new HashMap(map)));
        }
    }

    public static ApptimizeVar<Map<String, Double>> createMapOfDoubles(String str, Map<String, Double> map) {
        if (str == null) {
            throw new NullPointerException("Cannot create an ApptimizeVar with a null name");
        } else if (map == null) {
            return Apptimize.a(str, "dictionary", "double", null);
        } else {
            return Apptimize.a(str, "dictionary", "double", Collections.unmodifiableMap(new HashMap(map)));
        }
    }

    public static ApptimizeVar<Map<String, Integer>> createMapOfIntegers(String str, Map<String, Integer> map) {
        if (str == null) {
            throw new NullPointerException("Cannot create an ApptimizeVar with a null name");
        } else if (map == null) {
            return Apptimize.a(str, "dictionary", "int", null);
        } else {
            return Apptimize.a(str, "dictionary", "int", Collections.unmodifiableMap(new HashMap(map)));
        }
    }

    public static ApptimizeVar<Map<String, String>> createMapOfStrings(String str, Map<String, String> map) {
        if (str == null) {
            throw new NullPointerException("Cannot create an ApptimizeVar with a null name");
        } else if (map == null) {
            return Apptimize.a(str, "dictionary", TypedValues.Custom.S_STRING, null);
        } else {
            return Apptimize.a(str, "dictionary", TypedValues.Custom.S_STRING, Collections.unmodifiableMap(new HashMap(map)));
        }
    }

    public static ApptimizeVar<String> createString(String str, String str2) {
        if (str != null) {
            return Apptimize.a(str, TypedValues.Custom.S_STRING, (String) null, str2);
        }
        throw new NullPointerException("Cannot create an ApptimizeVar with a null name");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ApptimizeVar)) {
            return false;
        }
        ApptimizeVar apptimizeVar = (ApptimizeVar) obj;
        if (!this.f40998a.equals(apptimizeVar.f40998a) || !this.f40999b.equals(apptimizeVar.f40999b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.f40998a + this.f40999b).hashCode();
    }

    public T value(ApptimizeOptions apptimizeOptions) {
        T a11 = Apptimize.a(this, apptimizeOptions);
        if (a11 == null) {
            return null;
        }
        if (a11 instanceof List) {
            return new ArrayList((List) a11);
        }
        return a11 instanceof Map ? new HashMap((Map) a11) : a11;
    }

    public T value() {
        return value(new ApptimizeOptions());
    }
}
