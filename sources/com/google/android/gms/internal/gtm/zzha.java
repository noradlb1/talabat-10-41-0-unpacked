package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.common.internal.Preconditions;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import com.talabat.configuration.location.LocationExtensionsKt;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import java.util.ArrayList;
import java.util.List;

public final class zzha {
    public static boolean zza(zzoa<?> zzoa) {
        Preconditions.checkArgument(zzoa != null);
        if (zzoa == zzog.zzaum || zzoa == zzog.zzaul) {
            return false;
        }
        if (zzoa instanceof zzod) {
            return ((Boolean) ((zzod) zzoa).value()).booleanValue();
        }
        if (zzoa instanceof zzoe) {
            zzoe zzoe = (zzoe) zzoa;
            if (((Double) zzoe.value()).doubleValue() == 0.0d || ((Double) zzoe.value()).doubleValue() == -0.0d || Double.isNaN(((Double) zzoe.value()).doubleValue())) {
                return false;
            }
        } else if (zzoa instanceof zzom) {
            if (((String) ((zzom) zzoa).value()).isEmpty()) {
                return false;
            }
        } else if (zzf(zzoa)) {
            String zzoa2 = zzoa.toString();
            StringBuilder sb2 = new StringBuilder(String.valueOf(zzoa2).length() + 33);
            sb2.append("Illegal type given to isTruthy: ");
            sb2.append(zzoa2);
            sb2.append(RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
            throw new IllegalArgumentException(sb2.toString());
        }
        return true;
    }

    public static double zzb(zzoa<?> zzoa) {
        while (true) {
            Preconditions.checkArgument(zzoa != null);
            if (zzoa == zzog.zzaum) {
                return Double.NaN;
            }
            if (zzoa == zzog.zzaul) {
                return 0.0d;
            }
            if (zzoa instanceof zzod) {
                if (((Boolean) ((zzod) zzoa).value()).booleanValue()) {
                    return 1.0d;
                }
                return 0.0d;
            } else if (zzoa instanceof zzoe) {
                return ((Double) ((zzoe) zzoa).value()).doubleValue();
            } else {
                if (zzoa instanceof zzoh) {
                    zzoh zzoh = (zzoh) zzoa;
                    if (!((List) zzoh.value()).isEmpty()) {
                        if (((List) zzoh.value()).size() != 1) {
                            break;
                        }
                        zzoa = new zzom(zzd(zzoh.zzac(0)));
                    } else {
                        return 0.0d;
                    }
                } else if (zzoa instanceof zzom) {
                    zzom zzom = (zzom) zzoa;
                    if (((String) zzom.value()).isEmpty()) {
                        return 0.0d;
                    }
                    try {
                        return Double.parseDouble((String) zzom.value());
                    } catch (NumberFormatException unused) {
                        return Double.NaN;
                    }
                }
            }
        }
        if (!zzf(zzoa)) {
            return Double.NaN;
        }
        String zzoa2 = zzoa.toString();
        StringBuilder sb2 = new StringBuilder(String.valueOf(zzoa2).length() + 41);
        sb2.append("Illegal type given to numberEquivalent: ");
        sb2.append(zzoa2);
        sb2.append(RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
        throw new IllegalArgumentException(sb2.toString());
    }

    public static double zzc(zzoa<?> zzoa) {
        double zzb = zzb(zzoa);
        if (Double.isNaN(zzb)) {
            return 0.0d;
        }
        return (zzb == 0.0d || zzb == -0.0d || Double.isInfinite(zzb)) ? zzb : Math.signum(zzb) * Math.floor(Math.abs(zzb));
    }

    public static String zzd(zzoa<?> zzoa) {
        String str;
        Preconditions.checkArgument(zzoa != null);
        if (zzoa == zzog.zzaum) {
            return AdError.UNDEFINED_DOMAIN;
        }
        if (zzoa == zzog.zzaul) {
            return "null";
        }
        if (zzoa instanceof zzod) {
            return ((Boolean) ((zzod) zzoa).value()).booleanValue() ? "true" : "false";
        }
        if (zzoa instanceof zzoe) {
            String d11 = Double.toString(((Double) ((zzoe) zzoa).value()).doubleValue());
            int indexOf = d11.indexOf(ExifInterface.LONGITUDE_EAST);
            if (indexOf > 0) {
                int parseInt = Integer.parseInt(d11.substring(indexOf + 1, d11.length()));
                if (parseInt < 0) {
                    if (parseInt <= -7) {
                        return d11.replace(ExifInterface.LONGITUDE_EAST, "e");
                    }
                    String replace = d11.substring(0, indexOf).replace(RealDiscoveryConfigurationRepository.VERSION_DELIMETER, "");
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(LocationExtensionsKt.DECIMAL_PATTERN_DEFAULT);
                    while (true) {
                        parseInt++;
                        if (parseInt < 0) {
                            sb2.append("0");
                        } else {
                            sb2.append(replace);
                            return sb2.toString();
                        }
                    }
                } else if (parseInt >= 21) {
                    return d11.replace(ExifInterface.LONGITUDE_EAST, "e+");
                } else {
                    String replace2 = d11.substring(0, indexOf).replace(RealDiscoveryConfigurationRepository.VERSION_DELIMETER, "");
                    int length = (parseInt + 1) - (replace2.length() - (replace2.startsWith(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE) ? 1 : 0));
                    StringBuilder sb3 = new StringBuilder();
                    if (length < 0) {
                        int length2 = replace2.length() + length;
                        sb3.append(replace2.substring(0, length2));
                        sb3.append(RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
                        sb3.append(replace2.substring(length2, replace2.length()));
                    } else {
                        sb3.append(replace2);
                        while (length > 0) {
                            sb3.append("0");
                            length--;
                        }
                    }
                    return sb3.toString();
                }
            } else if (!d11.endsWith(".0")) {
                return d11;
            } else {
                String substring = d11.substring(0, d11.length() - 2);
                if (substring.equals("-0")) {
                    return "0";
                }
                return substring;
            }
        } else {
            if (zzoa instanceof zzof) {
                zzgz zzgz = (zzgz) ((zzof) zzoa).value();
                if (zzgz instanceof zzgy) {
                    return ((zzgy) zzgz).getName();
                }
            } else if (zzoa instanceof zzoh) {
                ArrayList arrayList = new ArrayList();
                for (zzoa zzoa2 : (List) ((zzoh) zzoa).value()) {
                    if (zzoa2 == zzog.zzaul || zzoa2 == zzog.zzaum) {
                        arrayList.add("");
                    } else {
                        arrayList.add(zzd(zzoa2));
                    }
                }
                return TextUtils.join(",", arrayList);
            } else if (zzoa instanceof zzok) {
                return "[object Object]";
            } else {
                if (zzoa instanceof zzom) {
                    return (String) ((zzom) zzoa).value();
                }
            }
            if (zzf(zzoa)) {
                String zzoa3 = zzoa.toString();
                StringBuilder sb4 = new StringBuilder(String.valueOf(zzoa3).length() + 41);
                sb4.append("Illegal type given to stringEquivalent: ");
                sb4.append(zzoa3);
                sb4.append(RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
                str = sb4.toString();
            } else {
                str = "Unknown type in stringEquivalent.";
            }
            throw new IllegalArgumentException(str);
        }
    }

    private static String zze(zzoa<?> zzoa) {
        if (zzoa == zzog.zzaum) {
            return "Undefined";
        }
        if (zzoa == zzog.zzaul) {
            return "Null";
        }
        if (zzoa instanceof zzod) {
            return "Boolean";
        }
        if (zzoa instanceof zzoe) {
            return "Number";
        }
        if (zzoa instanceof zzom) {
            return "String";
        }
        return "Object";
    }

    private static boolean zzf(zzoa<?> zzoa) {
        if (!(zzoa instanceof zzol)) {
            return (!(zzoa instanceof zzog) || zzoa == zzog.zzaum || zzoa == zzog.zzaul) ? false : true;
        }
        return true;
    }

    public static boolean zzc(zzoa<?> zzoa, zzoa<?> zzoa2) {
        zzoa<?> zzoa3;
        zzoa<?> zzom;
        while (true) {
            Preconditions.checkArgument(zzoa != null);
            Preconditions.checkArgument(zzoa2 != null);
            if (zzf(zzoa)) {
                String zzoa4 = zzoa.toString();
                StringBuilder sb2 = new StringBuilder(String.valueOf(zzoa4).length() + 48);
                sb2.append("Illegal type given to abstractEqualityCompare: ");
                sb2.append(zzoa4);
                sb2.append(RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
                throw new IllegalArgumentException(sb2.toString());
            } else if (!zzf(zzoa2)) {
                String zze = zze(zzoa);
                String zze2 = zze(zzoa2);
                if (zze.equals(zze2)) {
                    char c11 = 65535;
                    switch (zze.hashCode()) {
                        case -1950496919:
                            if (zze.equals("Number")) {
                                c11 = 0;
                                break;
                            }
                            break;
                        case -1939501217:
                            if (zze.equals("Object")) {
                                c11 = 1;
                                break;
                            }
                            break;
                        case -1808118735:
                            if (zze.equals("String")) {
                                c11 = 2;
                                break;
                            }
                            break;
                        case 2439591:
                            if (zze.equals("Null")) {
                                c11 = 3;
                                break;
                            }
                            break;
                        case 965837104:
                            if (zze.equals("Undefined")) {
                                c11 = 4;
                                break;
                            }
                            break;
                        case 1729365000:
                            if (zze.equals("Boolean")) {
                                c11 = 5;
                                break;
                            }
                            break;
                    }
                    switch (c11) {
                        case 0:
                            double doubleValue = ((Double) ((zzoe) zzoa).value()).doubleValue();
                            double doubleValue2 = ((Double) ((zzoe) zzoa2).value()).doubleValue();
                            return !Double.isNaN(doubleValue) && !Double.isNaN(doubleValue2) && doubleValue == doubleValue2;
                        case 1:
                            return zzoa == zzoa2;
                        case 2:
                            return ((String) ((zzom) zzoa).value()).equals((String) ((zzom) zzoa2).value());
                        case 3:
                        case 4:
                            return true;
                        case 5:
                            return ((Boolean) ((zzod) zzoa).value()) == ((Boolean) ((zzod) zzoa2).value());
                        default:
                            return false;
                    }
                } else {
                    zzog zzog = zzog.zzaum;
                    if ((zzoa == zzog || zzoa == zzog.zzaul) && (zzoa2 == zzog || zzoa2 == zzog.zzaul)) {
                        return true;
                    }
                    if (!zze.equals("Number") || !zze2.equals("String")) {
                        if (zze.equals("String") && zze2.equals("Number")) {
                            zzoa3 = new zzoe(Double.valueOf(zzb(zzoa)));
                        } else if (zze.equals("Boolean")) {
                            zzoa3 = new zzoe(Double.valueOf(zzb(zzoa)));
                        } else if (zze2.equals("Boolean")) {
                            zzom = new zzoe(Double.valueOf(zzb(zzoa2)));
                        } else if ((zze.equals("String") || zze.equals("Number")) && zze2.equals("Object")) {
                            zzom = new zzom(zzd(zzoa2));
                        } else if (!zze.equals("Object") || (!zze2.equals("String") && !zze2.equals("Number"))) {
                            return false;
                        } else {
                            zzoa3 = new zzom(zzd(zzoa));
                        }
                        zzoa = zzoa3;
                    } else {
                        zzom = new zzoe(Double.valueOf(zzb(zzoa2)));
                    }
                    zzoa2 = zzom;
                }
            } else {
                String zzoa5 = zzoa2.toString();
                StringBuilder sb3 = new StringBuilder(String.valueOf(zzoa5).length() + 48);
                sb3.append("Illegal type given to abstractEqualityCompare: ");
                sb3.append(zzoa5);
                sb3.append(RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
                throw new IllegalArgumentException(sb3.toString());
            }
        }
        return false;
    }

    public static double zza(zzoa<?> zzoa, zzoa<?> zzoa2) {
        boolean z11 = true;
        Preconditions.checkArgument(zzoa != null);
        if (zzoa2 == null) {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        double zzb = zzb(zzoa);
        double zzb2 = zzb(zzoa2);
        if (Double.isNaN(zzb) || Double.isNaN(zzb2)) {
            return Double.NaN;
        }
        if ((zzb == Double.POSITIVE_INFINITY && zzb2 == Double.NEGATIVE_INFINITY) || (zzb == Double.NEGATIVE_INFINITY && zzb2 == Double.POSITIVE_INFINITY)) {
            return Double.NaN;
        }
        if (!Double.isInfinite(zzb) || Double.isInfinite(zzb2)) {
            return (Double.isInfinite(zzb) || !Double.isInfinite(zzb2)) ? zzb + zzb2 : zzb2;
        }
        return zzb;
    }

    public static boolean zzb(zzoa<?> zzoa, zzoa<?> zzoa2) {
        Preconditions.checkArgument(zzoa != null);
        Preconditions.checkArgument(zzoa2 != null);
        if (zzf(zzoa)) {
            String zzoa3 = zzoa.toString();
            StringBuilder sb2 = new StringBuilder(String.valueOf(zzoa3).length() + 50);
            sb2.append("Illegal type given to abstractRelationalCompare: ");
            sb2.append(zzoa3);
            sb2.append(RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
            throw new IllegalArgumentException(sb2.toString());
        } else if (!zzf(zzoa2)) {
            if ((zzoa instanceof zzok) || (zzoa instanceof zzoh) || (zzoa instanceof zzof)) {
                zzoa = new zzom(zzd(zzoa));
            }
            if ((zzoa2 instanceof zzok) || (zzoa2 instanceof zzoh) || (zzoa2 instanceof zzof)) {
                zzoa2 = new zzom(zzd(zzoa2));
            }
            if ((zzoa instanceof zzom) && (zzoa2 instanceof zzom)) {
                return ((String) ((zzom) zzoa).value()).compareTo((String) ((zzom) zzoa2).value()) < 0;
            }
            double zzb = zzb(zzoa);
            double zzb2 = zzb(zzoa2);
            if (Double.isNaN(zzb) || Double.isNaN(zzb2) || ((zzb == 0.0d && zzb2 == -0.0d) || ((zzb == -0.0d && zzb2 == 0.0d) || zzb == Double.POSITIVE_INFINITY))) {
                return false;
            }
            if (zzb2 == Double.POSITIVE_INFINITY) {
                return true;
            }
            if (zzb2 == Double.NEGATIVE_INFINITY) {
                return false;
            }
            return zzb == Double.NEGATIVE_INFINITY || Double.compare(zzb, zzb2) < 0;
        } else {
            String zzoa4 = zzoa2.toString();
            StringBuilder sb3 = new StringBuilder(String.valueOf(zzoa4).length() + 50);
            sb3.append("Illegal type given to abstractRelationalCompare: ");
            sb3.append(zzoa4);
            sb3.append(RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
            throw new IllegalArgumentException(sb3.toString());
        }
    }

    public static boolean zzd(zzoa<?> zzoa, zzoa<?> zzoa2) {
        Preconditions.checkArgument(zzoa != null);
        Preconditions.checkArgument(zzoa2 != null);
        if (zzf(zzoa)) {
            String zzoa3 = zzoa.toString();
            StringBuilder sb2 = new StringBuilder(String.valueOf(zzoa3).length() + 46);
            sb2.append("Illegal type given to strictEqualityCompare: ");
            sb2.append(zzoa3);
            sb2.append(RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
            throw new IllegalArgumentException(sb2.toString());
        } else if (!zzf(zzoa2)) {
            String zze = zze(zzoa);
            if (!zze.equals(zze(zzoa2))) {
                return false;
            }
            char c11 = 65535;
            switch (zze.hashCode()) {
                case -1950496919:
                    if (zze.equals("Number")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -1808118735:
                    if (zze.equals("String")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 2439591:
                    if (zze.equals("Null")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 965837104:
                    if (zze.equals("Undefined")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case 1729365000:
                    if (zze.equals("Boolean")) {
                        c11 = 4;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    double doubleValue = ((Double) ((zzoe) zzoa).value()).doubleValue();
                    double doubleValue2 = ((Double) ((zzoe) zzoa2).value()).doubleValue();
                    return !Double.isNaN(doubleValue) && !Double.isNaN(doubleValue2) && doubleValue == doubleValue2;
                case 1:
                    return ((String) ((zzom) zzoa).value()).equals((String) ((zzom) zzoa2).value());
                case 2:
                case 3:
                    return true;
                case 4:
                    return ((Boolean) ((zzod) zzoa).value()) == ((Boolean) ((zzod) zzoa2).value());
                default:
                    return zzoa == zzoa2;
            }
        } else {
            String zzoa4 = zzoa2.toString();
            StringBuilder sb3 = new StringBuilder(String.valueOf(zzoa4).length() + 46);
            sb3.append("Illegal type given to strictEqualityCompare: ");
            sb3.append(zzoa4);
            sb3.append(RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
            throw new IllegalArgumentException(sb3.toString());
        }
    }
}
