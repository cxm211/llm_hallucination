

// trigger testcase
@Test public void unescape() {
        String text = "Hello &amp;&LT&gt; &angst &#960; &#960 &#x65B0; there &! &frac34;";
        assertEquals("Hello &<> Å π π 新 there &! ¾", Entities.unescape(text));

        assertEquals("&0987654321; &unknown", Entities.unescape("&0987654321; &unknown"));
    }
