public void testRequiredOptions(){
		PatternBuilder builder = new PatternBuilder();
		builder.withPattern("hc!<");
		Option option = builder.create();
		assertTrue(option instanceof GroupImpl);
		
		GroupImpl group = (GroupImpl)option;
		Iterator i = group.getOptions().iterator();
		assertEquals("[-h]",i.next().toString());
		assertEquals("-c <arg>",i.next().toString());
		assertFalse(i.hasNext());
	}