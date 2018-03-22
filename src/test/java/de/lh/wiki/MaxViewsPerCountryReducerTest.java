package de.lh.wiki;

import de.lh.wiki.deprecated.MaxViewsPerCountryReducer;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

/**
 * @author Joern Kuhlenkamp (j.kuhlenkamp@gmail.com)
 *         Created by on 18.03.18.
 */
public class MaxViewsPerCountryReducerTest {

    @Test
    public void aggregateViewsByMax() throws IOException {
        new ReduceDriver<Text, IntWritable, Text, IntWritable>()
            .withReducer( new MaxViewsPerCountryReducer())
            .withInput(new Text("de"), Arrays.asList(
                    new IntWritable(1),
                    new IntWritable(20),
                    new IntWritable(300),
                    new IntWritable(8000)
            ))
            .withOutput(new Text("de"), new IntWritable(8000))
            .runTest();
    }
}
