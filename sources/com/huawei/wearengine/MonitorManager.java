package com.huawei.wearengine;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.wearengine.device.Device;
import com.huawei.wearengine.monitor.MonitorData;
import com.huawei.wearengine.monitor.MonitorDataCallback;
import com.huawei.wearengine.monitor.MonitorItem;
import java.util.List;

public interface MonitorManager extends IInterface {

    public static class Default implements MonitorManager {
        public IBinder asBinder() {
            return null;
        }

        public MonitorData query(Device device, MonitorItem monitorItem) {
            return null;
        }

        public int registerListListener(Device device, String str, List<MonitorItem> list, MonitorDataCallback monitorDataCallback, int i11) {
            return 0;
        }

        public int registerListener(Device device, String str, MonitorItem monitorItem, MonitorDataCallback monitorDataCallback, int i11) {
            return 0;
        }

        public int unregisterListener(MonitorDataCallback monitorDataCallback, int i11) {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements MonitorManager {
        private static final String DESCRIPTOR = "com.huawei.wearengine.MonitorManager";

        public static class Proxy implements MonitorManager {
            public static MonitorManager sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public MonitorData query(Device device, MonitorItem monitorItem) {
                MonitorData createFromParcel;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (device != null) {
                        obtain.writeInt(1);
                        device.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (monitorItem != null) {
                        obtain.writeInt(1);
                        monitorItem.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(4, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        createFromParcel = obtain2.readInt() != 0 ? MonitorData.CREATOR.createFromParcel(obtain2) : null;
                    } else {
                        createFromParcel = Stub.getDefaultImpl().query(device, monitorItem);
                    }
                    return createFromParcel;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int registerListListener(Device device, String str, List<MonitorItem> list, MonitorDataCallback monitorDataCallback, int i11) {
                int readInt;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (device != null) {
                        obtain.writeInt(1);
                        device.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeTypedList(list);
                    obtain.writeStrongBinder(monitorDataCallback != null ? monitorDataCallback.asBinder() : null);
                    obtain.writeInt(i11);
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        readInt = obtain2.readInt();
                    } else {
                        readInt = Stub.getDefaultImpl().registerListListener(device, str, list, monitorDataCallback, i11);
                    }
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int registerListener(Device device, String str, MonitorItem monitorItem, MonitorDataCallback monitorDataCallback, int i11) {
                int readInt;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (device != null) {
                        obtain.writeInt(1);
                        device.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (monitorItem != null) {
                        obtain.writeInt(1);
                        monitorItem.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(monitorDataCallback != null ? monitorDataCallback.asBinder() : null);
                    obtain.writeInt(i11);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        readInt = obtain2.readInt();
                    } else {
                        readInt = Stub.getDefaultImpl().registerListener(device, str, monitorItem, monitorDataCallback, i11);
                    }
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int unregisterListener(MonitorDataCallback monitorDataCallback, int i11) {
                int readInt;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(monitorDataCallback != null ? monitorDataCallback.asBinder() : null);
                    obtain.writeInt(i11);
                    if (this.mRemote.transact(3, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        readInt = obtain2.readInt();
                    } else {
                        readInt = Stub.getDefaultImpl().unregisterListener(monitorDataCallback, i11);
                    }
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static MonitorManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof MonitorManager)) ? new Proxy(iBinder) : (MonitorManager) queryLocalInterface;
        }

        public static MonitorManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(MonitorManager monitorManager) {
            if (Proxy.sDefaultImpl != null || monitorManager == null) {
                return false;
            }
            Proxy.sDefaultImpl = monitorManager;
            return true;
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.huawei.wearengine.monitor.MonitorItem} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: com.huawei.wearengine.monitor.MonitorItem} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: com.huawei.wearengine.monitor.MonitorItem} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.huawei.wearengine.device.Device} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: com.huawei.wearengine.monitor.MonitorItem} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: com.huawei.wearengine.monitor.MonitorItem} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: com.huawei.wearengine.monitor.MonitorItem} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: com.huawei.wearengine.monitor.MonitorItem} */
        /* JADX WARNING: type inference failed for: r0v7, types: [com.huawei.wearengine.device.Device] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r9, android.os.Parcel r10, android.os.Parcel r11, int r12) {
            /*
                r8 = this;
                r0 = 1598968902(0x5f4e5446, float:1.4867585E19)
                r1 = 1
                java.lang.String r2 = "com.huawei.wearengine.MonitorManager"
                if (r9 == r0) goto L_0x00d3
                r0 = 0
                if (r9 == r1) goto L_0x0099
                r3 = 2
                if (r9 == r3) goto L_0x006a
                r3 = 3
                if (r9 == r3) goto L_0x0050
                r3 = 4
                if (r9 == r3) goto L_0x0019
                boolean r9 = super.onTransact(r9, r10, r11, r12)
                return r9
            L_0x0019:
                r10.enforceInterface(r2)
                int r9 = r10.readInt()
                if (r9 == 0) goto L_0x002b
                android.os.Parcelable$Creator<com.huawei.wearengine.device.Device> r9 = com.huawei.wearengine.device.Device.CREATOR
                java.lang.Object r9 = r9.createFromParcel(r10)
                com.huawei.wearengine.device.Device r9 = (com.huawei.wearengine.device.Device) r9
                goto L_0x002c
            L_0x002b:
                r9 = r0
            L_0x002c:
                int r12 = r10.readInt()
                if (r12 == 0) goto L_0x003b
                android.os.Parcelable$Creator<com.huawei.wearengine.monitor.MonitorItem> r12 = com.huawei.wearengine.monitor.MonitorItem.CREATOR
                java.lang.Object r10 = r12.createFromParcel(r10)
                r0 = r10
                com.huawei.wearengine.monitor.MonitorItem r0 = (com.huawei.wearengine.monitor.MonitorItem) r0
            L_0x003b:
                com.huawei.wearengine.monitor.MonitorData r9 = r8.query(r9, r0)
                r11.writeNoException()
                if (r9 == 0) goto L_0x004b
                r11.writeInt(r1)
                r9.writeToParcel(r11, r1)
                goto L_0x004f
            L_0x004b:
                r9 = 0
                r11.writeInt(r9)
            L_0x004f:
                return r1
            L_0x0050:
                r10.enforceInterface(r2)
                android.os.IBinder r9 = r10.readStrongBinder()
                com.huawei.wearengine.monitor.MonitorDataCallback r9 = com.huawei.wearengine.monitor.MonitorDataCallback.Stub.asInterface(r9)
                int r10 = r10.readInt()
                int r9 = r8.unregisterListener(r9, r10)
            L_0x0063:
                r11.writeNoException()
                r11.writeInt(r9)
                return r1
            L_0x006a:
                r10.enforceInterface(r2)
                int r9 = r10.readInt()
                if (r9 == 0) goto L_0x007c
                android.os.Parcelable$Creator<com.huawei.wearengine.device.Device> r9 = com.huawei.wearengine.device.Device.CREATOR
                java.lang.Object r9 = r9.createFromParcel(r10)
                r0 = r9
                com.huawei.wearengine.device.Device r0 = (com.huawei.wearengine.device.Device) r0
            L_0x007c:
                r3 = r0
                java.lang.String r4 = r10.readString()
                android.os.Parcelable$Creator<com.huawei.wearengine.monitor.MonitorItem> r9 = com.huawei.wearengine.monitor.MonitorItem.CREATOR
                java.util.ArrayList r5 = r10.createTypedArrayList(r9)
                android.os.IBinder r9 = r10.readStrongBinder()
                com.huawei.wearengine.monitor.MonitorDataCallback r6 = com.huawei.wearengine.monitor.MonitorDataCallback.Stub.asInterface(r9)
                int r7 = r10.readInt()
                r2 = r8
                int r9 = r2.registerListListener(r3, r4, r5, r6, r7)
                goto L_0x0063
            L_0x0099:
                r10.enforceInterface(r2)
                int r9 = r10.readInt()
                if (r9 == 0) goto L_0x00ac
                android.os.Parcelable$Creator<com.huawei.wearengine.device.Device> r9 = com.huawei.wearengine.device.Device.CREATOR
                java.lang.Object r9 = r9.createFromParcel(r10)
                com.huawei.wearengine.device.Device r9 = (com.huawei.wearengine.device.Device) r9
                r3 = r9
                goto L_0x00ad
            L_0x00ac:
                r3 = r0
            L_0x00ad:
                java.lang.String r4 = r10.readString()
                int r9 = r10.readInt()
                if (r9 == 0) goto L_0x00c0
                android.os.Parcelable$Creator<com.huawei.wearengine.monitor.MonitorItem> r9 = com.huawei.wearengine.monitor.MonitorItem.CREATOR
                java.lang.Object r9 = r9.createFromParcel(r10)
                r0 = r9
                com.huawei.wearengine.monitor.MonitorItem r0 = (com.huawei.wearengine.monitor.MonitorItem) r0
            L_0x00c0:
                r5 = r0
                android.os.IBinder r9 = r10.readStrongBinder()
                com.huawei.wearengine.monitor.MonitorDataCallback r6 = com.huawei.wearengine.monitor.MonitorDataCallback.Stub.asInterface(r9)
                int r7 = r10.readInt()
                r2 = r8
                int r9 = r2.registerListener(r3, r4, r5, r6, r7)
                goto L_0x0063
            L_0x00d3:
                r11.writeString(r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.wearengine.MonitorManager.Stub.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    MonitorData query(Device device, MonitorItem monitorItem);

    int registerListListener(Device device, String str, List<MonitorItem> list, MonitorDataCallback monitorDataCallback, int i11);

    int registerListener(Device device, String str, MonitorItem monitorItem, MonitorDataCallback monitorDataCallback, int i11);

    int unregisterListener(MonitorDataCallback monitorDataCallback, int i11);
}
