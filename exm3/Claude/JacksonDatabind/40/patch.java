public final T getNullValue() {
    if (_valueClass.isPrimitive()) {
        return _emptyValue;
    }
    return _nullValue;
}