public Attribute(String key, String val, Attributes parent) {
    Validate.notNull(key);
    String trimmedKey = key.trim();
    Validate.notEmpty(trimmedKey); // trimming could potentially make empty, so validate here
    this.key = trimmedKey;
    this.val = val;
    this.parent = parent;
}