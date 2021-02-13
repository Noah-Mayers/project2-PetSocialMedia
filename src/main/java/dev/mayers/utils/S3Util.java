package dev.mayers.utils;

import java.io.File;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;

public class S3Util {
	private static AmazonS3 s3client = null;
	public static String bucketName = "proj2buck";

	public static boolean uploadFile(File f) {

		try {
			if (s3client == null) {
				AWSCredentials credentials = new BasicAWSCredentials("", "");

				AmazonS3 s3client = AmazonS3ClientBuilder.standard()
						.withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.US_EAST_1)
						.build();

				if (!s3client.doesBucketExistV2(bucketName)) {
					s3client.createBucket(bucketName);
				}
				PutObjectRequest por = new PutObjectRequest(bucketName, f.getName(), f);

				// File Upload
				s3client.putObject(por);

				return true;
			} else {
				if (!s3client.doesBucketExistV2(bucketName)) {
					s3client.createBucket(bucketName);
				}

				PutObjectRequest por = new PutObjectRequest(bucketName, f.getName(), f);

				// File Upload
				s3client.putObject(por);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
