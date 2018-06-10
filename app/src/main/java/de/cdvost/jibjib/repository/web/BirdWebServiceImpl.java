package de.cdvost.jibjib.repository.web;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class BirdWebServiceImpl implements IBirdWebService {
    @Override
    public String match(Object audio) {
        String response = requestMatch(audio);
        return response;
    }

    @Override
    public String getMatchBird(int id) {
        String response = requestBirdDetails(id);
        return response;

    }

    private String requestBirdDetails(int id) {

        try {
            String uriString = "http://jibjib.api.f0rkd.net:8080/birds/"+id;

            URL url = new URL(uriString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                builder.append(line);
            }
            conn.disconnect();
            return builder.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String requestMatch(Object audio) {

        try {
            String uriString = "http://jibjib.api.f0rkd.net:8080/birds/dummy";

            URL url = new URL(uriString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            //conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                builder.append(line);
            }
            conn.disconnect();
            return builder.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

//    public String requestMatch(Object audio) {
//
//        try {
//            String uriString = "http://jibjib.api.f0rkd.net:8080/detect/binary";
//
//            URL url = new URL(uriString);
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("POST");
//            //conn.setRequestProperty("Accept", "application/octet-stream");
//
//            conn.setDoOutput(true);
//            DataOutputStream out = new DataOutputStream(conn.getOutputStream());
//
//            File audioFile = new File(audio.toString());
//            byte[] fileData = new byte[(int) audioFile.length()];
//            DataInputStream dis = new DataInputStream(new FileInputStream(audioFile));
//            dis.readFully(fileData);
//            dis.close();
//
//            out.write(fileData);
//            out.flush();
//            out.close();
//
//            if (conn.getResponseCode() != 200 && conn.getResponseCode()!= 202) {
//                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
//            }
//            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
//
//            StringBuilder builder = new StringBuilder();
//            String line;
//            while ((line = br.readLine()) != null) {
//                builder.append(line);
//            }
//            conn.disconnect();
//            return builder.toString();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
}
