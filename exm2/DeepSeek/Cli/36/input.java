

// trigger testcase
@Test
    public void testOptionComparatorInsertedOrder() throws ParseException {
        Collection<Option> options = getOptions().getOptions();
        int i = 0;
        for(Option o: options) {
            Assert.assertEquals(o.getOpt(), insertedOrder.get(i));
            i++;
        }
    }
