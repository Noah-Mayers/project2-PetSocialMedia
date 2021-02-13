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
	public static String bucketName = "proj2buck"; //Establishes name of our bucket
	
	
	public static void main(String[] args) {
		//Test for AWS
		File a = new File("");
		uploadFile(a);
	}

	public static boolean uploadFile(File f) {
		
		try {
			if (s3client == null) { //Verifies that s3client is null
				//Credential check
				AWSCredentials credentials = new BasicAWSCredentials("", "");
				
				//Our actual client is established here, checks for credentials
				AmazonS3 s3client = AmazonS3ClientBuilder.standard()
						.withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.US_EAST_1)
						.build();

				if (!s3client.doesBucketExistV2(bucketName)) {
					s3client.createBucket(bucketName);
				}
				
				//This places our object in a state where it can be uploaded with ease
				PutObjectRequest por = new PutObjectRequest(bucketName, f.getName(), f);

				// File Upload
				s3client.putObject(por);

				return true;
			} 
			//If s3client already exists, it will execute the file upload here without having to establish credentials again
			else {
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
