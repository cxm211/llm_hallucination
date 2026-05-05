// Jsoup/85/input.java
@Test(expected = IllegalArgumentException.class) public void validatesKeysNotEmptyWithParent() {
        Attributes parent = new Attributes();
        Attribute attr = new Attribute("  ", "Check", parent);
    }
