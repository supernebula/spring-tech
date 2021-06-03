package com.evol.protobuftest.util;

import com.evol.protobuftest.domain.SearchRequest;
import com.evol.protobuftest.domain.SearchResponse;
import com.googlecode.protobuf.format.JsonFormat;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.HttpClients;

import java.net.URI;

public class ProtoSearchTest {

    public static void main(String[] args){
        try {
            URI uri = new URI("http", null, "127.0.0.1", 8080, "/test/getUser", "", null);
            HttpClient httpclient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(uri);
            String requestUrl = httpPost.getURI().toString();
            System.out.println(requestUrl);

            SearchRequest.MessageSearchRequest.Builder builder = SearchRequest.MessageSearchRequest.newBuilder();
            builder.setUsername("zhangsan001");
            builder.setPageNumber(2);
            builder.setResultPerPage(4);
            SearchRequest.MessageSearchRequest request = builder.build();
            httpPost.setEntity(new ByteArrayEntity(request.toByteArray()));
            httpPost.setHeader("Content-Type", "application/x-protobuf;charset=UTF-8");
            //HttpResponse response = HttpUtils.doPost(httpPost, builder.build());


            //region

            for (Header header : httpPost.getAllHeaders()) {
                System.out.println(header.getName() + ":" + header.getValue());
            }

            StringBuilder sb = new StringBuilder();
            sb.append("curl -XPOST ");
            for (Header header : httpPost.getAllHeaders()) {
                sb.append(" -H \"").append(header.getName()).append(":").append(header.getValue()).append("\"");
            }


            String jsonBody = (new JsonFormat()).printToString(request);
            jsonBody = jsonBody.replace("\"", "\\\"");
            sb.append(" -d \"").append(jsonBody).append("\"");
            sb.append(" ").append(requestUrl);

            System.out.println(sb.toString());

            //endregion

            HttpResponse response = httpclient.execute(httpPost);
            System.out.println(response.getStatusLine());



            SearchResponse.MessageSearchResponse userResponse = SearchResponse.MessageSearchResponse.parseFrom(response.getEntity().getContent());
            System.out.println(userResponse.getSubMsg());
            System.out.println(userResponse.getNick());
            System.out.println(userResponse.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
