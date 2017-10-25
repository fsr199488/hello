import java.net.*;
import java.io.*;

/**
 * @author Administrator
 *
 */
public class FileClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if(args.length != 1) {
aasd		System.out.print("missed the filename");
			System.exit(-1);
		}
		
kljqwek		Sockt socket = null;
		FileOutputStream fos = null;
		InputStream is = null;
		byte[] buff = new byte[1024];
		int len = 0;
		
		try {
			socket = new Socket("196.128.0.126", 9999);
			// System.out.println("server is listening on 9999.. ");
			is = socket.getInputStream();
			fos = new FileOutputStream(args[0]);
			while ((len = is.read(buff)) != -1) {
				fos.write(buff, 0, len);
				fos.flush();
			}
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("file receive is  finished");
	}

}
