public final T getNullValue() {
            if (_nullValue != null) {
                return _nullValue;
            }
            Class<?> cls = _valueClass;
            if (cls == null) {
                return null;
            }
            Object v = null;
            if (cls == Integer.TYPE) {
                v = Integer.valueOf(0);
            } else if (cls == Long.TYPE) {
                v = Long.valueOf(0L);
            } else if (cls == Double.TYPE) {
                v = Double.valueOf(0.0);
            } else if (cls == Float.TYPE) {
                v = Float.valueOf(0.0f);
            } else if (cls == Short.TYPE) {
                v = Short.valueOf((short) 0);
            } else if (cls == Byte.TYPE) {
                v = Byte.valueOf((byte) 0);
            } else if (cls == Boolean.TYPE) {
                v = Boolean.FALSE;
            } else if (cls == Character.TYPE) {
                v = Character.valueOf('\0');
            }
            return (T) v;
        }