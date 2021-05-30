package MongoDBProject;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.*;

import java.util.Arrays;

import com.mongodb.client.model.CreateCollectionOptions;
import com.mongodb.client.model.ValidationOptions;
import org.bson.Document; //for MongoCollection<Document>


import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;

import com.mongodb.Block;

import com.mongodb.client.MongoCursor;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;


import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Projections.*;
import com.mongodb.client.model.Sorts;
import java.util.function.Consumer;


import org.bson.types.ObjectId;
//
public class MongoDB {
	//connect string�ھڦۤv���a�ݪ����ק�
	String url="mongodb+srv://user:user@cluster0.72dhy.mongodb.net/test?authSource=admin&replicaSet=atlas-g2rfcy-shard-0&readPreference=primary&appname=MongoDB%20Compass&ssl=true";
	MongoClient mongoClient;
	MongoDatabase database;
	MongoCollection<Document> coll;
	
	public MongoDB() {
		connect();
	}
	
	//�s�����Ʈw
	public void connect() {
		
		ConnectionString connString = new ConnectionString(url);
		MongoClientSettings settings = MongoClientSettings.builder()
			    .applyConnectionString(connString)
			    .retryWrites(true)
			    .build();
		mongoClient = MongoClients.create(settings);
		//�ھڭn�Ϊ���Ʈw���W�ٰ��ק�
		database = mongoClient.getDatabase("test");
		//�ھڭn�Ϊ�collection���ק�
		coll = database.getCollection("account");
		
	}
	
	//�s�W
	public void insert(String pas,int amount,String name,String birth,String gender,String address,String telephone,String mobile,String email) {
		
		Document doc = new Document("password", pas)
				.append("amount", amount)
				.append("name",name)
				.append("birth", birth)
				.append("gender", gender)
				.append("address", address)
				.append("contact", new Document("telephone", telephone).append("mobile", mobile).append("e-mail", email));		
		coll.insertOne(doc);
		
	}	
	
	//�R��
	public void deleteOne(String id) {
		
		coll.deleteOne(eq("_id",id));
		//ObjectId objId = new ObjectId(id);
		coll.deleteOne(eq("_id",new ObjectId(id)));
		
	}		
	
	//�ק�
	public void updateOne(String id) {
		//set("�n��諸����",��諸�ƭ�)
		coll.updateOne(eq("_id", id), set("amount", 81000));
		coll.updateOne(eq("_id", new ObjectId(id)), set("amount", 81000));
	}
	/*
	public void updateMany(int amount) {
		
		UpdateResult updateResult = coll.updateMany(lt("amount", amount), set("amount", 100));
		System.out.println(updateResult.getModifiedCount());
		
	}			
	*/
	public void findOne(String id) {
		
		//�̾�_id�OObjectId���A��String���A��@�ӥ�
		try {
		Document myDoc = coll.find(eq("_id", id)).first();
		System.out.println(myDoc.toJson());}catch(Exception e){
			//do nothing
		}
		try {
		Document myDoc2 = coll.find(eq("_id", new ObjectId(id))).first();
		System.out.println(myDoc2.toJson());}catch(Exception e){
			//do nothing
		}
		
	}

	//for findMany
	Consumer<Document> printConsumer = new Consumer<Document>() {
	       @Override
	       public void accept(final Document document) {
	           System.out.println(document.toJson());
	       }
	};
	public void findMany(int amount) {
		//gt >  lt <  lte <=
		coll.find(gt("amount", amount))
        	.forEach(printConsumer);
	}
	
	public static void main(String args[]) {
		MongoDB mongoDB=new MongoDB();
		//test 
		//mongoDB.insert("sufhas4wf8",100000,"�����","20001231","male","�򶩥������ϥ_���2��","02-1234-5678","0985458215","af5484@gmail.com");
		//mongoDB.deleteOne("60b3680bf8daa25f426a557e");
		//mongoDB.updateOne("60b368bb897cc84702c22eb6");
		//mongoDB.findOne("60b368bb897cc84702c22eb6");
		mongoDB.findMany(10);
	}

}