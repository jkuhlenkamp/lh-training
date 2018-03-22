package de.lh.wiki;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.junit.Test;

import java.io.IOException;

/**
 * @author Joern Kuhlenkamp (j.kuhlenkamp@gmail.com)
 *         Created by on 18.03.18.
 */
public class MaxViewsPerCountryMapperTest {

    private static final String RECORD = "de Nyan_cat_mag_jeder 100000 600";

    @Test
    public void selectCountryAndViews() throws IOException {

        new MapDriver<LongWritable, Text, Text, IntWritable>()
            .withMapper(new MaxViewsPerCountryDriver.MaxViewsPerCountryMapper())
            .withInput(new LongWritable(0), new Text(RECORD))
            .withOutput(new Text("de"), new IntWritable(100000))
            .runTest();

    }
}
