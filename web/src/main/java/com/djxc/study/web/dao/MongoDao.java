package com.djxc.study.web.dao;

//import com.mongodb.MongoClient;
//import com.mongodb.client.FindIterable;
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.MongoCursor;
//import com.mongodb.client.MongoDatabase;
//import org.bson.Document;


public class MongoDao {
//    public void testMongo() {
//        try{
//            // 连接到 mongodb 服务
//            MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
//
//            // 连接到数据库
//            MongoDatabase mongoDatabase = mongoClient.getDatabase("testdj");
//            System.out.println("Connect to database successfully");
//
//            MongoCollection<Document> collection = mongoDatabase.getCollection("user");
//            findCol(collection);
//        }catch(Exception e){
//            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
//        }
//    }

//    //创建集合
//    private void createCollection(MongoDatabase mongoDatabase)
//    {
//        mongoDatabase.createCollection("test");
//        System.out.println("集合创建成功");
//    }
//
//    //插入文档
//    /**
//     * 1. 创建文档 org.bson.Document 参数为key-value的格式
//     * 2. 创建文档集合List<Document>
//     * 3. 将文档集合插入数据库集合中 mongoCollection.insertMany(List<Document>) 插入单个文档可以用 mongoCollection.insertOne(Document)
//     * */
//    private void insertCol(MongoCollection<Document> collection)
//    {
//        Document document = new Document("title", "MongoDB").
//                append("description", "database").
//                append("likes", 100).
//                append("by", "Fly");
//        List<Document> documents = new ArrayList<Document>();
//        documents.add(document);
//        collection.insertMany(documents);
//        System.out.println("文档插入成功");
//    }
//
//    //检索所有文档
//    /**
//     * 1. 获取迭代器FindIterable<Document>
//     * 2. 获取游标MongoCursor<Document>
//     * 3. 通过游标遍历检索出的文档集合
//     * */
//    private static void findCol(MongoCollection<Document> collection)
//    {
//        FindIterable<Document> findIterable = collection.find();
//        MongoCursor<Document> mongoCursor = findIterable.iterator();
//        while(mongoCursor.hasNext()){
//            System.out.println(mongoCursor.next().get("name"));
//        }
//    }
//
//    public static void addNum(int num)
//    {
//        num = num + 10;
//    }
//
//    public static void changeName(UserEntity xc)
//    {
//        xc.setName("xcdj");
//    }
}
