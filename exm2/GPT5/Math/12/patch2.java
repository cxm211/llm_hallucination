@Test
    public void testDistributionClone3()
        throws IOException,
               ClassNotFoundException {
        // Construct a distribution and initialize its internal random
        // generator, using a fixed seed for deterministic results.
        distribution.reseedRandomGenerator(123);
        distribution.sample();

        // Clone the distribution.
        final RealDistribution cloned = deepClone();

        // Make sure they still produce the same samples.
        final double s1 = distribution.sample();
        final double s2 = cloned.sample();
        Assert.assertEquals(s1, s2, 0d);
    }