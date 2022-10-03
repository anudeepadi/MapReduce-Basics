package org.mapreduce;
import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class WordCountDriver {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		Configuration conf = new Configuration();
	    Job job = new Job(conf, "WordCOuntDriver");
	    job.setJarByClass(WordCountDriver.class);
	    job.setJobName("Stub Driver");
	    job.setMapperClass(WordCountMapper.class);
	    job.setReducerClass(WordCountReducer.class);
	    job.setOutputKeyClass(Text.class);
	    job.setOutputValueClass(IntWritable.class);
//	    job.setNumReduceTasks(5);
//	    job.setCombinerClass(WordCountReducer.class);
	    
	    FileInputFormat.addInputPath(job, new Path(args[0]));
	    FileOutputFormat.setOutputPath(job, new Path(args[1]));
	    
	    job.setJobName("My Job 1");
	    job.waitForCompletion(true);
	    
	}

}
