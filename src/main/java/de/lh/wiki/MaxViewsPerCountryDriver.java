package de.lh.wiki;

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

/**
 * @author Joern Kuhlenkamp (j.kuhlenkamp@gmail.com)
 *         Created by on 18.03.18.
 */
public class MaxViewsPerCountryDriver extends Configured implements Tool {

    static class MaxViewsPerCountryMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            String line = value.toString();
            String[] columns = line.split(" ");
            context.write(new Text(columns[0]), new IntWritable(Integer.parseInt(columns[2])));
        }

    }

    static class MaxViewsPerCountryReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
        @Override
        protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
            int maxValue = Integer.MIN_VALUE;
            for(IntWritable value : values) {
                maxValue = Math.max(maxValue, value.get());
            }
            context.write(key, new IntWritable(maxValue));
        }
    }


    public int run(String[] arg0) throws Exception {
        if(arg0.length != 2) {
            System.err.printf("Usage: %s [generic options] <input> <output> \n", getClass().getSimpleName());
            ToolRunner.printGenericCommandUsage(System.err);
            return -1;
        }

        // Create job
        Job job = Job.getInstance(getConf(), "Max views per country.");
        job.setJarByClass(getClass());

        // Set input path and output path
        FileInputFormat.addInputPath(job, new Path(arg0[0]));
        FileOutputFormat.setOutputPath(job, new Path(arg0[1]));

        // Set code
        job.setMapperClass(MaxViewsPerCountryMapper.class);
        job.setReducerClass(MaxViewsPerCountryReducer.class);

        // Set output formats
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        return job.waitForCompletion(true) ? 0 : 1;
    }

    public static void main(String[] args) throws Exception {
        int exitCode = ToolRunner.run(new MaxViewsPerCountryDriver(), args);
        System.exit(exitCode);

    }

}
