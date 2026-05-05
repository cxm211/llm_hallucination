// Jsoup/60/QueryParserTest.java
@Test
    public void parsesEscapedBackslashInContains() {
        Evaluator eval = QueryParser.parse("p:contains(\"foo\\\\bar\")");
    }
