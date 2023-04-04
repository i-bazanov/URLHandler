import java.io.IOException;
import java.net.MalformedURLException;

import java.net.URL;
import java.net.HttpURLConnection;

public class URLHandler {
    public static int check(String strUrl) {
        try {
            URL url = new URL(strUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            return connection.getResponseCode();
        }
        catch (MalformedURLException ex) {
            return -1;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void checkWheel(long delayInSec, String url) throws Exception {
        long delayInMSec = delayInSec * 1000;

        while(true) {

            int code = check(url);

            if(code == 200) {
                System.out.println("Checking '" + url + "'. Result: OK(" + code + ")");
            }
            else if(code != -1) {
                System.out.println("Checking '" + url + "'. Result: ERR(" + code + ")");
            }
            else { //code == -1
                System.out.println("URL parsing error");
                break;
            }

            Thread.sleep(delayInMSec); //delay
        }
    }
}
