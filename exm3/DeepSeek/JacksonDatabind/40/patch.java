public final T getNullValue() {
        if (_nullValue == null) {
            JavaType t = getType();
            if (t != null && t.isPrimitive()) {
                Class<?> cls = t.getRawClass();
                if (cls == Integer.TYPE) {
                    return (T) Integer.valueOf(0);
                } else if (cls == Long.TYPE) {
                    return (T) Long.valueOf(0L);
                } else if (cls == Double.TYPE) {
                    return (T) Double.valueOf(0.0);
                } else if (cls == Float.TYPE) {
                    return (T) Float.valueOf(0.0f);
                } else if (cls == Boolean.TYPE) {
                    return (T) Boolean.FALSE;
                } else if (cls == Character.TYPE) {
                    return (T) Character.valueOf('\0');
                } else if (cls == Byte.TYPE) {
                    return (T) Byte.valueOf((byte)0);
                } else if (cls == Short.TYPE) {
                    return (T) Short.valueOf((short)0);
                }
            }
        }
        return _nullValue;
    }