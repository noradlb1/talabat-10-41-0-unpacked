package com.huawei.wearengine;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.wearengine.device.Device;
import com.huawei.wearengine.sensor.AsyncReadCallback;
import com.huawei.wearengine.sensor.AsyncStopCallback;
import com.huawei.wearengine.sensor.Sensor;
import java.util.List;

public interface SensorManager extends IInterface {

    public static class Default implements SensorManager {
        public IBinder asBinder() {
            return null;
        }

        public int asyncRead(Device device, Sensor sensor, AsyncReadCallback asyncReadCallback) {
            return 0;
        }

        public int asyncReadSensors(Device device, List<Sensor> list, AsyncReadCallback asyncReadCallback) {
            return 0;
        }

        public List<Sensor> getSensorList(Device device) {
            return null;
        }

        public int stopAsyncRead(Device device, Sensor sensor, AsyncStopCallback asyncStopCallback) {
            return 0;
        }

        public int stopAsyncReadSensors(Device device, List<Sensor> list, AsyncStopCallback asyncStopCallback) {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements SensorManager {
        private static final String DESCRIPTOR = "com.huawei.wearengine.SensorManager";

        public static class Proxy implements SensorManager {
            public static SensorManager sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public int asyncRead(Device device, Sensor sensor, AsyncReadCallback asyncReadCallback) {
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
                    if (sensor != null) {
                        obtain.writeInt(1);
                        sensor.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(asyncReadCallback != null ? asyncReadCallback.asBinder() : null);
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        readInt = obtain2.readInt();
                    } else {
                        readInt = Stub.getDefaultImpl().asyncRead(device, sensor, asyncReadCallback);
                    }
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int asyncReadSensors(Device device, List<Sensor> list, AsyncReadCallback asyncReadCallback) {
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
                    obtain.writeTypedList(list);
                    obtain.writeStrongBinder(asyncReadCallback != null ? asyncReadCallback.asBinder() : null);
                    if (this.mRemote.transact(3, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        readInt = obtain2.readInt();
                    } else {
                        readInt = Stub.getDefaultImpl().asyncReadSensors(device, list, asyncReadCallback);
                    }
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public List<Sensor> getSensorList(Device device) {
                List<Sensor> createTypedArrayList;
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
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        createTypedArrayList = obtain2.createTypedArrayList(Sensor.CREATOR);
                    } else {
                        createTypedArrayList = Stub.getDefaultImpl().getSensorList(device);
                    }
                    return createTypedArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int stopAsyncRead(Device device, Sensor sensor, AsyncStopCallback asyncStopCallback) {
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
                    if (sensor != null) {
                        obtain.writeInt(1);
                        sensor.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(asyncStopCallback != null ? asyncStopCallback.asBinder() : null);
                    if (this.mRemote.transact(4, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        readInt = obtain2.readInt();
                    } else {
                        readInt = Stub.getDefaultImpl().stopAsyncRead(device, sensor, asyncStopCallback);
                    }
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int stopAsyncReadSensors(Device device, List<Sensor> list, AsyncStopCallback asyncStopCallback) {
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
                    obtain.writeTypedList(list);
                    obtain.writeStrongBinder(asyncStopCallback != null ? asyncStopCallback.asBinder() : null);
                    if (this.mRemote.transact(5, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        readInt = obtain2.readInt();
                    } else {
                        readInt = Stub.getDefaultImpl().stopAsyncReadSensors(device, list, asyncStopCallback);
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

        public static SensorManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof SensorManager)) ? new Proxy(iBinder) : (SensorManager) queryLocalInterface;
        }

        public static SensorManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(SensorManager sensorManager) {
            if (Proxy.sDefaultImpl != null || sensorManager == null) {
                return false;
            }
            Proxy.sDefaultImpl = sensorManager;
            return true;
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: com.huawei.wearengine.device.Device} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: com.huawei.wearengine.sensor.Sensor} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: com.huawei.wearengine.device.Device} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: com.huawei.wearengine.sensor.Sensor} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: com.huawei.wearengine.device.Device} */
        /* JADX WARNING: type inference failed for: r0v1 */
        /* JADX WARNING: type inference failed for: r0v17 */
        /* JADX WARNING: type inference failed for: r0v18 */
        /* JADX WARNING: type inference failed for: r0v19 */
        /* JADX WARNING: type inference failed for: r0v20 */
        /* JADX WARNING: type inference failed for: r0v21 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r5, android.os.Parcel r6, android.os.Parcel r7, int r8) {
            /*
                r4 = this;
                r0 = 1598968902(0x5f4e5446, float:1.4867585E19)
                r1 = 1
                java.lang.String r2 = "com.huawei.wearengine.SensorManager"
                if (r5 == r0) goto L_0x00f9
                r0 = 0
                if (r5 == r1) goto L_0x00dc
                r3 = 2
                if (r5 == r3) goto L_0x00a7
                r3 = 3
                if (r5 == r3) goto L_0x007c
                r3 = 4
                if (r5 == r3) goto L_0x0047
                r3 = 5
                if (r5 == r3) goto L_0x001c
                boolean r5 = super.onTransact(r5, r6, r7, r8)
                return r5
            L_0x001c:
                r6.enforceInterface(r2)
                int r5 = r6.readInt()
                if (r5 == 0) goto L_0x002e
                android.os.Parcelable$Creator<com.huawei.wearengine.device.Device> r5 = com.huawei.wearengine.device.Device.CREATOR
                java.lang.Object r5 = r5.createFromParcel(r6)
                r0 = r5
                com.huawei.wearengine.device.Device r0 = (com.huawei.wearengine.device.Device) r0
            L_0x002e:
                android.os.Parcelable$Creator<com.huawei.wearengine.sensor.Sensor> r5 = com.huawei.wearengine.sensor.Sensor.CREATOR
                java.util.ArrayList r5 = r6.createTypedArrayList(r5)
                android.os.IBinder r6 = r6.readStrongBinder()
                com.huawei.wearengine.sensor.AsyncStopCallback r6 = com.huawei.wearengine.sensor.AsyncStopCallback.Stub.asInterface(r6)
                int r5 = r4.stopAsyncReadSensors(r0, r5, r6)
                r7.writeNoException()
                r7.writeInt(r5)
                return r1
            L_0x0047:
                r6.enforceInterface(r2)
                int r5 = r6.readInt()
                if (r5 == 0) goto L_0x0059
                android.os.Parcelable$Creator<com.huawei.wearengine.device.Device> r5 = com.huawei.wearengine.device.Device.CREATOR
                java.lang.Object r5 = r5.createFromParcel(r6)
                com.huawei.wearengine.device.Device r5 = (com.huawei.wearengine.device.Device) r5
                goto L_0x005a
            L_0x0059:
                r5 = r0
            L_0x005a:
                int r8 = r6.readInt()
                if (r8 == 0) goto L_0x0069
                android.os.Parcelable$Creator<com.huawei.wearengine.sensor.Sensor> r8 = com.huawei.wearengine.sensor.Sensor.CREATOR
                java.lang.Object r8 = r8.createFromParcel(r6)
                r0 = r8
                com.huawei.wearengine.sensor.Sensor r0 = (com.huawei.wearengine.sensor.Sensor) r0
            L_0x0069:
                android.os.IBinder r6 = r6.readStrongBinder()
                com.huawei.wearengine.sensor.AsyncStopCallback r6 = com.huawei.wearengine.sensor.AsyncStopCallback.Stub.asInterface(r6)
                int r5 = r4.stopAsyncRead(r5, r0, r6)
                r7.writeNoException()
                r7.writeInt(r5)
                return r1
            L_0x007c:
                r6.enforceInterface(r2)
                int r5 = r6.readInt()
                if (r5 == 0) goto L_0x008e
                android.os.Parcelable$Creator<com.huawei.wearengine.device.Device> r5 = com.huawei.wearengine.device.Device.CREATOR
                java.lang.Object r5 = r5.createFromParcel(r6)
                r0 = r5
                com.huawei.wearengine.device.Device r0 = (com.huawei.wearengine.device.Device) r0
            L_0x008e:
                android.os.Parcelable$Creator<com.huawei.wearengine.sensor.Sensor> r5 = com.huawei.wearengine.sensor.Sensor.CREATOR
                java.util.ArrayList r5 = r6.createTypedArrayList(r5)
                android.os.IBinder r6 = r6.readStrongBinder()
                com.huawei.wearengine.sensor.AsyncReadCallback r6 = com.huawei.wearengine.sensor.AsyncReadCallback.Stub.asInterface(r6)
                int r5 = r4.asyncReadSensors(r0, r5, r6)
                r7.writeNoException()
                r7.writeInt(r5)
                return r1
            L_0x00a7:
                r6.enforceInterface(r2)
                int r5 = r6.readInt()
                if (r5 == 0) goto L_0x00b9
                android.os.Parcelable$Creator<com.huawei.wearengine.device.Device> r5 = com.huawei.wearengine.device.Device.CREATOR
                java.lang.Object r5 = r5.createFromParcel(r6)
                com.huawei.wearengine.device.Device r5 = (com.huawei.wearengine.device.Device) r5
                goto L_0x00ba
            L_0x00b9:
                r5 = r0
            L_0x00ba:
                int r8 = r6.readInt()
                if (r8 == 0) goto L_0x00c9
                android.os.Parcelable$Creator<com.huawei.wearengine.sensor.Sensor> r8 = com.huawei.wearengine.sensor.Sensor.CREATOR
                java.lang.Object r8 = r8.createFromParcel(r6)
                r0 = r8
                com.huawei.wearengine.sensor.Sensor r0 = (com.huawei.wearengine.sensor.Sensor) r0
            L_0x00c9:
                android.os.IBinder r6 = r6.readStrongBinder()
                com.huawei.wearengine.sensor.AsyncReadCallback r6 = com.huawei.wearengine.sensor.AsyncReadCallback.Stub.asInterface(r6)
                int r5 = r4.asyncRead(r5, r0, r6)
                r7.writeNoException()
                r7.writeInt(r5)
                return r1
            L_0x00dc:
                r6.enforceInterface(r2)
                int r5 = r6.readInt()
                if (r5 == 0) goto L_0x00ee
                android.os.Parcelable$Creator<com.huawei.wearengine.device.Device> r5 = com.huawei.wearengine.device.Device.CREATOR
                java.lang.Object r5 = r5.createFromParcel(r6)
                r0 = r5
                com.huawei.wearengine.device.Device r0 = (com.huawei.wearengine.device.Device) r0
            L_0x00ee:
                java.util.List r5 = r4.getSensorList(r0)
                r7.writeNoException()
                r7.writeTypedList(r5)
                return r1
            L_0x00f9:
                r7.writeString(r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.wearengine.SensorManager.Stub.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    int asyncRead(Device device, Sensor sensor, AsyncReadCallback asyncReadCallback);

    int asyncReadSensors(Device device, List<Sensor> list, AsyncReadCallback asyncReadCallback);

    List<Sensor> getSensorList(Device device);

    int stopAsyncRead(Device device, Sensor sensor, AsyncStopCallback asyncStopCallback);

    int stopAsyncReadSensors(Device device, List<Sensor> list, AsyncStopCallback asyncStopCallback);
}
