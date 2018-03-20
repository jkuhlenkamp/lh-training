package de.lh.wiki;

import de.lh.wiki.model.ShowDB;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import java.io.IOException;
import java.net.URI;

/**
 * @author Joern Kuhlenkamp (j.kuhlenkamp@gmail.com)
 *         Created by on 18.03.18.
 */
public class DummyMapReduce extends Configured implements Tool {

    /**
    static class FilterArticelAndViewsMapper extends Mapper<...> {
        @Override
        protected void map(...) throws ... {
            ...
        }
    }
    */

    /**
    static class FilterShowsReducer extends Reducer<...> {
        @Override
        protected void reduce(...) throws ... {
            ...
        }
     }
    */

    public int run(String[] arg0) throws Exception {
        if(arg0.length != 2) {
            System.err.printf("Usage: %s [generic options] <input> <output> \n", getClass().getSimpleName());
            ToolRunner.printGenericCommandUsage(System.err);
            return -1;
        }

        Job job = Job.getInstance(getConf(), "My name.");
        // Add configuration for job here.

        return job.waitForCompletion(true) ? 0 : 1;
    }

    public static void main(String[] args) throws Exception {
        int exitCode = ToolRunner.run(new DummyMapReduce(), args);
        System.exit(exitCode);
    }
}