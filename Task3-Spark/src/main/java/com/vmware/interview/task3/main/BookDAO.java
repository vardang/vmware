package com.vmware.interview.task3.main;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import static com.mongodb.client.model.Projections.excludeId;

/**
 * Created by vardang on 2/28/17.
 */
public class BookDAO {

    MongoCollection<Document> booksCollection;

    public BookDAO(final MongoDatabase blogDatabase) {
        booksCollection = blogDatabase.getCollection("books");
        getBooks();
    }

    public String getBooks() {
        String json = "{\n" +
                "    \"text\": \"Root\",\n" +
                "    \"Children\": [";
        FindIterable<Document> books = booksCollection.find().projection(excludeId());
        MongoCursor cursor = books.iterator();
        for (Document book : books) {
            cursor.next();
            json += book.toJson();
            if (cursor.hasNext()){
                json += ",";
            }
        }
        json += "]}";
        return "{\n" +
                "    \"success\": true,\n" +
                "    \"children\": [\n" +
                "        { \"id\": 1, \"name\": \"Phil\", \"leaf\": true },\n" +
                "        { \"id\": 2, \"name\": \"Nico\", \"expanded\": true, \"children\": [\n" +
                "            { \"id\": 3, \"name\": \"Mitchell\", \"leaf\": true }\n" +
                "        ]},\n" +
                "        { \"id\": 4, \"name\": \"Sue\", \"loaded\": true }\n" +
                "    ]\n" +
                "}";
    }
}
