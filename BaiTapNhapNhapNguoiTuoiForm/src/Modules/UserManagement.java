package Modules;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class UserManagement {
	public ArrayList<User> getUsers() throws Exception {
		ArrayList<User> rs = new ArrayList<User>();
		FileReader f = new FileReader("src/Data/users.txt");
		BufferedReader bf = new BufferedReader(f);
		
		while(true) {
			String line = bf.readLine();
			if (line == "" || line == null) break;
			String[] lineSplit = line.strip().split("[;]");
			User newUser = new User(lineSplit[0], lineSplit[1], lineSplit[2], Integer.parseInt(lineSplit[3]));
			rs.add(newUser);
		}
		bf.close();
		return rs;
	}
}
