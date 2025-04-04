import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class javaMongo {

	public static void main(String[] args) {
		String uri = "mongodb+srv://nhathuynguyen:1608@cluster0.tec28ns.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
		
		try (MongoClient mongoClient = MongoClients.create(uri)) {
			
			// choose database
			MongoDatabase database = mongoClient.getDatabase("exampleDatabase");
			System.out.println("Connect susccessful");
			
			// choose collection
			MongoCollection<Document> collection = database.getCollection("users");
			
			// insert data
			Document user = new Document("maNV", "nv001")
					.append("hoTen", "Tran Thi Dieu")
					.append("ngaySinh", "2002-02-19")
					.append("queQuan", "Hue")
					.append("heSoLuong", 2.5)
					.append("luong", 25000000)
					.append("khoa", "K04");
			
			collection.insertOne(user);
			System.out.println("Insert successful");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
