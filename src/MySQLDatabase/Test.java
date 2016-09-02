package MySQLDatabase;

import java.io.File;
import java.io.IOException;
import java.security.Permission;

import org.apache.commons.io.FileUtils;

import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;







public class Test {

	public static void main(String[] args) {

		DBConnection con = new DBConnection();
	}
	

	public static void fromByteArrayToFIle(byte[] byteArray, String fileName){
		System.out.println("Körs detta i Test "+ "/DressLibrary/war/images/" +fileName);
		
		BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
		
		
		
		/*try {
			Files.write(byteArray, new File("/DressLibrary/war/images/" +fileName));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		
		System.out.println("Körs detta i Test "+ "/DressLibrary/war/images/" +fileName);
		Permission p = new java.io.FilePermission ("/DressLibrary/war/images/", "write");
		try {
			FileUtils.writeByteArrayToFile(new File("/DressLibrary/war/images/" +fileName), byteArray);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
