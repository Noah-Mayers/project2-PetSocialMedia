package dev.mayers.utils;

import java.io.File;

public class S3TestClass {

	public static void main(String[] args) {
		
		File a = new File("C:\\Users\\Ric\\Pictures\\1.jpg");
		S3Util.uploadFile(a);
}
}
