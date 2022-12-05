package controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Id;
import models.Message;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ServerController {
    private String rootURL = "http://zipcode.rocks:8085";

    private static ServerController svr = new ServerController();

    private static HttpURLConnection connection;

    private List<Id> ids;

    private List<Message> messages;

    ServerController() {}

    public static ServerController shared() {
        return svr;
    }

    public String idGet() throws IOException {
        // url -> /ids/
        // send the server a get with url
        // return json from server

        BufferedReader reader;
        String line;
        StringBuilder idResponse = new StringBuilder();
        try{
            URL url = new URL(rootURL + "/ids");
            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int status = connection.getResponseCode();

            if (status > 299){
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while((line = reader.readLine()) != null){
                    idResponse.append(line);
                }
                reader.close();
            }
            else{
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while((line = reader.readLine()) != null){
                    idResponse.append(line);
                }
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            connection.disconnect();
        }
        return idResponse.toString();

    }

    public String messageGet() throws IOException{

        BufferedReader reader;
        String line;
        StringBuilder messageResponse = new StringBuilder();
        try{
            URL url = new URL(rootURL + "/messages");
            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int status = connection.getResponseCode();

            if (status > 299){
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while((line = reader.readLine()) != null){
                    messageResponse.append(line);
                }
                reader.close();
            }
            else{
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while((line = reader.readLine()) != null){
                    messageResponse.append(line);
                }
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            connection.disconnect();
        }
        return messageResponse.toString();
    }

    public String idPost(Id id) throws IOException {
        // url -> /ids/
        // create json from Id
        // request
        // reply
        // return json

        String line;
        StringBuilder response = new StringBuilder();

        URL url = new URL(rootURL + "/ids");
        connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        connection.setDoOutput(true);

        OutputStream os = connection.getOutputStream();
        System.out.println(id);
        byte[] input = id.toString().getBytes(StandardCharsets.UTF_8);
        os.write(input, 0, input.length);
        os.flush();
        os.close();

        int status = connection.getResponseCode();

        if(status > 299){
            System.out.println("POST request has failed");

        }
        else{
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while((line = reader.readLine()) != null){
                response.append(line);
            }
            reader.close();
            System.out.println(response);
        }
        connection.disconnect();

        return response.toString();
    }

    public String idPut(Id id) {
        // url -> /ids/
        return null;
    }


}

// ServerController.shared.doGet()