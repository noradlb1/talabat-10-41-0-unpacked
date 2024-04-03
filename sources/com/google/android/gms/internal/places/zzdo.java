package com.google.android.gms.internal.places;

import org.apache.commons.compress.archivers.tar.TarConstants;

final class zzdo {
    public static String zzd(zzw zzw) {
        zzdn zzdn = new zzdn(zzw);
        StringBuilder sb2 = new StringBuilder(zzdn.size());
        for (int i11 = 0; i11 < zzdn.size(); i11++) {
            byte zzi = zzdn.zzi(i11);
            if (zzi == 34) {
                sb2.append("\\\"");
            } else if (zzi == 39) {
                sb2.append("\\'");
            } else if (zzi != 92) {
                switch (zzi) {
                    case 7:
                        sb2.append("\\a");
                        break;
                    case 8:
                        sb2.append("\\b");
                        break;
                    case 9:
                        sb2.append("\\t");
                        break;
                    case 10:
                        sb2.append("\\n");
                        break;
                    case 11:
                        sb2.append("\\v");
                        break;
                    case 12:
                        sb2.append("\\f");
                        break;
                    case 13:
                        sb2.append("\\r");
                        break;
                    default:
                        if (zzi >= 32 && zzi <= 126) {
                            sb2.append((char) zzi);
                            break;
                        } else {
                            sb2.append('\\');
                            sb2.append((char) (((zzi >>> 6) & 3) + 48));
                            sb2.append((char) (((zzi >>> 3) & 7) + 48));
                            sb2.append((char) ((zzi & 7) + TarConstants.LF_NORMAL));
                            break;
                        }
                }
            } else {
                sb2.append("\\\\");
            }
        }
        return sb2.toString();
    }
}
