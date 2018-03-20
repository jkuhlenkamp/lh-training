package de.lh.wiki;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

/**
 * @author Joern Kuhlenkamp (j.kuhlenkamp@gmail.com)
 *         Created by on 20.03.18.
 */
public class DummyTest {

    private static final String TESTRECORD = "field1 field2 field3 field4";

    @Test
    public void mapperTestDummy() throws IOException {
        /**
        new MapDriver<...>()
            .withMapper(...)
            .withInput(...)
            .withOutput(...)
            .runTest();
         */
    }

    @Test
    public void reducerTestDummy() throws IOException {
        /**
         new ReduceDriver<...>()
            .withReducer(...)
            .withInput(...)
            .withOutput(...)
            .runTest();
         */
    }

}
