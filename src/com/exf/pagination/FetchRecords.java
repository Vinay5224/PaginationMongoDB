package com.exf.pagination;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class FetchRecords {

	static MongoClientURI uri;
	static MongoClient mongoClient;
	static MongoDatabase dbProvider;
	static MongoCollection<Document> cmsColl;
	
	
	
	public static void dbInitialization() {
		uri = new MongoClientURI(
				"mongodb://admin:test123@exfprovidermdm-shard-00-00-2ms1l.gcp.mongodb.net:27017,exfprovidermdm-shard-00-01-2ms1l.gcp.mongodb.net:27017,exfprovidermdm-shard-00-02-2ms1l.gcp.mongodb.net:27017/test?ssl=true&replicaSet=ExfProviderMDM-shard-0&authSource=admin&retryWrites=true");
		mongoClient = new MongoClient(uri);
		dbProvider = mongoClient.getDatabase("Provider");
		cmsColl = dbProvider.getCollection("Cmsdata");
	}

	public static ArrayList<Document> getRecords(int start, int total) {
		
		dbInitialization(); 
		FindIterable<Document> findIter = cmsColl.find().skip(0).limit(10);
		Iterator<Document> iter = findIter.iterator();
		ArrayList<Document> doc = new ArrayList<Document>();
		while (iter.hasNext()) {
			Document innerDoc = iter.next();
			doc.add(innerDoc);
		}

		return doc;
	}

	public static long recordCounts() {
		dbInitialization();
		long dbCount = cmsColl.count();
		return 0;
	}

}
