@Test
    public void testExcelHeaderCountLessThanData() throws Exception {
        final String code = "A,B,C,,\r\na,b,c,d,e\r\n";
        final CSVParser parser = CSVParser.parse(code, CSVFormat.EXCEL.withHeader());
        try {
            for (CSVRecord record : parser.getRecords()) {
                Assert.assertEquals("a", record.get("A"));
                Assert.assertEquals("b", record.get("B"));
                Assert.assertEquals("c", record.get("C"));
            }
        } finally {
            parser.close();
        }
    }