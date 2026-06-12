public void testEmptyMapCompatibility() throws Exception {
        Map map = makeEmptyMap();
        Map map2 = (Map) readExternalFormFromDisk(getCanonicalEmptyCollectionName(map));
        assertEquals("Map is empty", 0, map2.size());
    }