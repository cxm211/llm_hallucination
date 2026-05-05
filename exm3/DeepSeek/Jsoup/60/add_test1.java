// Jsoup/60/QueryParserTest.java
@Test
    public void parsesAttributeWithEscapedQuote() {
        Evaluator eval = QueryParser.parse("a[href=\"foo\\\"bar\"]");
    }
