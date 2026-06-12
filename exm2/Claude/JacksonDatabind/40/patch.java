public final T getNullValue() {
    if (_nullValue == null && _valueClass != null && _valueClass.isPrimitive()) {
        if (_valueClass == int.class) return (T) Integer.valueOf(0);
        if (_valueClass == long.class) return (T) Long.valueOf(0L);
        if (_valueClass == double.class) return (T) Double.valueOf(0.0);
        if (_valueClass == float.class) return (T) Float.valueOf(0.0f);
        if (_valueClass == boolean.class) return (T) Boolean.FALSE;
        if (_valueClass == byte.class) return (T) Byte.valueOf((byte) 0);
        if (_valueClass == short.class) return (T) Short.valueOf((short) 0);
        if (_valueClass == char.class) return (T) Character.valueOf('\u0000');
    }
    return _nullValue;
}