// Jsoup/85/input.java
@Test(expected = IllegalArgumentException.class) public void validatesKeysNotEmptyTab() {
        Attribute attr = new Attribute("\\t", "Check");
    }
