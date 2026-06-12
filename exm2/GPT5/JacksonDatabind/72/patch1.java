public void testIssue1501() throws Exception
    {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        String ser = mapper.writeValueAsString(new Something());
        mapper.readValue(ser, Something.class);
    }