package com.google.android.gms.internal.vision;

import org.apache.commons.compress.archivers.tar.TarConstants;

final class zzjf {
    public static String zzd(zzfh zzfh) {
        zzji zzji = new zzji(zzfh);
        StringBuilder sb2 = new StringBuilder(zzji.size());
        for (int i11 = 0; i11 < zzji.size(); i11++) {
            byte zzan = zzji.zzan(i11);
            if (zzan == 34) {
                sb2.append("\\\"");
            } else if (zzan == 39) {
                sb2.append("\\'");
            } else if (zzan != 92) {
                switch (zzan) {
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
                        if (zzan >= 32 && zzan <= 126) {
                            sb2.append((char) zzan);
                            break;
                        } else {
                            sb2.append('\\');
                            sb2.append((char) (((zzan >>> 6) & 3) + 48));
                            sb2.append((char) (((zzan >>> 3) & 7) + 48));
                            sb2.append((char) ((zzan & 7) + TarConstants.LF_NORMAL));
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
