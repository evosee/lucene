package com.example.demo.search.lucene;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexableField;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.*;
import org.apache.lucene.store.FSDirectory;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author chensai
 * @version 1.0
 * @date 2019/7/2 10:28
 */
public class Searcher {
    public static void main(String[] args) throws IOException {
        new Searcher().search("华为2");
    }
    public String search(String param) throws IOException {
        try (IndexReader reader = DirectoryReader.open(FSDirectory.open(Paths.get("E:\\lucene")))) {
            IndexSearcher searcher = new IndexSearcher(reader);
            Query query = new TermQuery(new Term(param,"为"));

            TopDocs topDocs =  searcher.search(query,10);

            ScoreDoc[] docs =  topDocs.scoreDocs;
            for(ScoreDoc scoreDoc:docs ){
              Document document =  searcher.doc(scoreDoc.doc);
                System.out.println(document.toString());
                List<IndexableField>  fields = document.getFields();
                fields.forEach(e->{
                    System.out.println(e.name());
                    System.out.println(e.stringValue());
                });

            }

        }
        return "";

    }
}
