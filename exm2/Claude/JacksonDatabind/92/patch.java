public void testJDKTypes1737() throws Exception
    {
        _testTypes1737(java.util.logging.FileHandler.class);
        _testTypes1737(java.rmi.server.UnicastRemoteObject.class);
    }