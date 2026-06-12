

// trigger testcase
@Test
    public void testCodec200() {
        final Base32 codec = new Base32(true, (byte)'W'); // should be allowed
        assertNotNull(codec);
    }
