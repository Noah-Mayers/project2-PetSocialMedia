package dev.mayers.util;

import java.io.File;

import org.junit.jupiter.api.Test;


import dev.mayers.utils.S3Util;


class S3Tests {
	
	public static S3Util s3;
	@Test
	void uploadTest() {
	File f = new File("C:\\Users\\Ric\\Pictures\\1.jpg");
	S3Util.uploadFile(f);
	}
}
