package dev.groupone.services;

import java.io.File;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;

/*
 * The following class uploads images to an AWS S3
 */
@Service
public class ImageUploadService {
	private static AmazonS3 s3client = null;
	public static String bucketName = "proj2buck"; //Establishes name of our bucket
	
	

	public boolean uploadFile(MultipartFile mpf, int imageId) {
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
				//PutObjectRequest por = new PutObjectRequest(bucketName, f.getName(), f);

				// File Upload
//				s3client.putObject(por);

			} 
			//If s3client already exists, it will execute the file upload here without having to establish credentials again
			else {
				if (!s3client.doesBucketExistV2(bucketName)) {
					s3client.createBucket(bucketName);
				}

				//PutObjectRequest por = new PutObjectRequest(bucketName, f.getName(), f);

				// File Upload

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			//PutObjectRequest por = new PutObjectRequest()
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		return false;
	}
	
}
