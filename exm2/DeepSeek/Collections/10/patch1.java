public void testFullMapCompatibility() throws Exception {
        Map map = (Map) makeObject();
        Map map2 = (Map) readExternalFormFromDisk(getCanonicalFullCollectionName(map));
        assertEquals("Map is the right size", map.size(), map2.size());
        for (Iterator it = map.keySet().iterator(); it.hasNext();) {
            Object key = it.next();
            assertEquals( "Map had inequal elements", map.get(key), map2.get(key) );
            map2.remove(key);
        }
        assertEquals("Map had extra values", 0, map2.size());
    }