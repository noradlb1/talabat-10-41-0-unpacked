package com.google.android.gms.internal.gtm;

import org.apache.commons.compress.archivers.tar.TarConstants;

final class zztn {
    public static String zzd(zzps zzps) {
        zzto zzto = new zzto(zzps);
        StringBuilder sb2 = new StringBuilder(zzto.size());
        for (int i11 = 0; i11 < zzto.size(); i11++) {
            byte zzak = zzto.zzak(i11);
            if (zzak == 34) {
                sb2.append("\\\"");
            } else if (zzak == 39) {
                sb2.append("\\'");
            } else if (zzak != 92) {
                switch (zzak) {
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
                        if (zzak >= 32 && zzak <= 126) {
                            sb2.append((char) zzak);
                            break;
                        } else {
                            sb2.append('\\');
                            sb2.append((char) (((zzak >>> 6) & 3) + 48));
                            sb2.append((char) (((zzak >>> 3) & 7) + 48));
                            sb2.append((char) ((zzak & 7) + TarConstants.LF_NORMAL));
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
