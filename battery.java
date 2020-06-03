import java.io.*;
import java.util.*;
import org.json.simple.*;

class Battery {
	public static void main(String args[]) {
		try {
			FileReader fr = new FileReader("C:\\Users\\harsh\\Desktop\\Battery.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			JSONObject ob = new JSONObject();
			String activities = null;
			String drain = null;
			while ((line = br.readLine()) != null) {
				if (line.contains("Foreground activities:")) {
					activities = line.replaceAll("    Foreground activities: ", "");
				}

				if (line.contains("Uid u0a202:")) {
					String splitvalues[] = line.split("\\s+");
					drain = splitvalues[3];
				}
			}

			ob.put("Foreground_time", activities);
			ob.put("Battery_percentage", (Float.parseFloat(drain) / 1000));
			ob.put("Battery_drain", drain);
			System.out.println(ob);
			FileWriter file1 = new FileWriter("output1.json");
			file1.write(ob.toJSONString());
			file1.close();
			fr.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
