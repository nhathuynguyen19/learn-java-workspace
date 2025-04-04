package Buoi7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class QuanLyUsers {
	public ArrayList<Users> getUsers() throws Exception {
		ArrayList<Users> ds = new ArrayList<Users>();
		
		FileReader f = new FileReader("users.txt");
		BufferedReader bf = new BufferedReader(f);
		
		while(true) {
			String line = bf.readLine();
			if (line == "" || line == null) break;
			String[] che = line.split("[;]");
			
			String username = che[0];
			String password = che[1];
			
			Users user1 = new Users();
			user1.setUsername(username);
			user1.setPassword(password);
			ds.add(user1);
		}
		bf.close();
		return ds;
	}
}
