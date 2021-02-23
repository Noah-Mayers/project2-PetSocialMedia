package dev.groupone.services;

import java.io.File;
import java.io.InputStream;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;

import dev.groupone.beans.Image;

/*
 * The following class uploads images to an AWS S3
 */
@Service
public class ImageUploadService {
	private  AmazonS3 s3client = null;
	private  String bucketName = "proj2buck"; //Establishes name of our bucket
	private AWSCredentials credentials;
	private String accessKey = "";
	private String secretAccesskey = "";
	
	
	public String uploadFileToBucket(MultipartFile mpf, int imageId) {
		initBucket();
		ObjectMetadata metadata=new ObjectMetadata();
		try {
			InputStream input = mpf.getInputStream();
			metadata.setContentLength(input.available());
			metadata.setContentType(mpf.getContentType());
			PutObjectRequest putRequest = new PutObjectRequest(bucketName, Integer.toString(imageId), input, metadata);
			PutObjectResult por = s3client.putObject(putRequest);
			//System.out.println(por);
			//System.out.println(por.getMetadata().
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return "https://proj2buck.s3.amazonaws.com/" + imageId;
		
	}
	
	private void initBucket(){
			if(this.s3client == null) {
				this.credentials = new BasicAWSCredentials(this.accessKey, this.secretAccesskey);
				this.s3client = AmazonS3ClientBuilder.standard()
						.withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.US_EAST_1)
						.build();
			} 
			if (!s3client.doesBucketExistV2(bucketName)) {
					s3client.createBucket(bucketName);
			}
	}
	
	
	

	
}
