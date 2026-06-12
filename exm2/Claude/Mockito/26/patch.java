public Object returnValueFor(Class<?> type) {
    if (type == boolean.class) {
        return false;
    } else if (type == char.class) {
        return '\u0000';
    } else if (type == byte.class) {
        return (byte) 0;
    } else if (type == short.class) {
        return (short) 0;
    } else if (type == int.class) {
        return 0;
    } else if (type == long.class) {
        return 0L;
    } else if (type == float.class) {
        return 0.0F;
    } else if (type == double.class) {
        return 0.0D;
    }

    // else return the mock
    return returnValueFor(type);
}