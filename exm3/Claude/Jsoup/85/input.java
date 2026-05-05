// buggy function
    public Attribute(String key, String val, Attributes parent) {
        Validate.notNull(key);
        this.key = key.trim();
        Validate.notEmpty(key); // trimming could potentially make empty, so validate here
        this.val = val;
        this.parent = parent;
    }

// trigger testcase
    @Test(expected = IllegalArgumentException.class) public void validatesKeysNotEmpty() {
        Attribute attr = new Attribute(" ", "Check");
    }
