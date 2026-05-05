public int getPropertyIndex() {
    if (_delegate == null) {
        return -1;
    }
    return _delegate.getPropertyIndex();
}