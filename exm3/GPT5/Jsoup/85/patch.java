public Attribute(String key, String val, Attributes parent) {
        Validate.notNull(key);
        this.key = key.trim();
        Validate.notEmpty(this.key); // validate the trimmed key, which may be empty after trimming
        this.val = val;
        this.parent = parent;
    }