package com.example.demo.search.lucene;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexableField;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.SimpleFSDirectory;

import java.nio.file.Paths;

/**
 * @author chensai
 * @version 1.0
 * @date 2019/7/1 16:20
 */
public class IndexWriter {
    public static void main(String[] args) throws Exception {
        new IndexWriter().writer();
    }
    public void writer() throws Exception {
        try (Directory directory = new SimpleFSDirectory(Paths.get("E:\\lucene"))) {
            IndexWriterConfig indexWriterConfig = new IndexWriterConfig();
            org.apache.lucene.index.IndexWriter writer = new org.apache.lucene.index.IndexWriter(directory,indexWriterConfig);
            Document document = new Document();
            IndexableField field = new TextField("苹果2","苹果牛", Field.Store.YES);
            IndexableField field2 = new TextField("苹2","苹果牛", Field.Store.YES);
            IndexableField field3 = new TextField("果2","苹果牛", Field.Store.YES);
            IndexableField field4 = new TextField("华为2","华为牛", Field.Store.YES);
            IndexableField field5 = new TextField("三星2","三星牛", Field.Store.YES);
            document.add(field);
            document.add(field2);
            document.add(field3);
            document.add(field4);
            document.add(field5);
            writer.addDocument(document);
            writer.close();
        }

    }
}
