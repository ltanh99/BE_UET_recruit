package com.example.finalproject.service.studentService;

import com.example.finalproject.dao.studentDao.StudentDao;
import com.example.finalproject.model.studentDTO.DAONews;
import com.example.finalproject.model.studentDTO.DAOStudent;
import com.example.finalproject.model.studentDTO.SearchRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import static com.example.finalproject.FinalprojectApplication.main;
import static com.example.finalproject.FinalprojectApplication.main_token;

@Service
public class StudentService {
    @Autowired
    private StudentDao studentDao;

    public Iterable<DAOStudent> GetAllStudent() {

        return studentDao.findAll();
    }

    public Iterable<DAOStudent> SearchStudent(SearchRequest param) {
        return studentDao.FindByCategory(param);
    }

    public String  getNews(DAONews[] listNews, String token) {
        URL url = null;
        try {
            StringBuilder sb = new StringBuilder();
            List<JSONObject> jsonObjects = new ArrayList<>();
            int index = 0;
            for (DAONews item: listNews) {
                url = new URL("http://localhost:8082/news");
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestProperty("Authorization", token);
                con.setRequestProperty("Content-Type", "application/json; utf-8");
                con.setRequestProperty("Accept", "application/json");
                con.setDoOutput(true);
                con.setRequestMethod("POST");
                ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
                String json = ow.writeValueAsString(item);
                String jsonInputString = json;
                try(OutputStream os = con.getOutputStream()) {
                    byte[] input = jsonInputString.getBytes("utf-8");
                    os.write(input, 0, input.length);
                }


                BufferedReader br = null;
                if (100 <= con.getResponseCode() && con.getResponseCode() <= 399) {
                    br = new BufferedReader(new InputStreamReader(con.getInputStream()));

                    String line;
                    while ((line = br.readLine()) != null) {

//                        sb.append(line+"\n");
//                        JSONObject jsonObject = new JSONObject(line.substring(1,line.length()-1));
                        String tmp = line.substring(1,line.length()-1);
                        String[] listTmp = tmp.split("},");
                        for (int i =0 ; i < listTmp.length; i++) {
                            listTmp[i]+="}";
                            JSONObject jsonObjectItem = new JSONObject(listTmp[i]);
                            jsonObjects.add(jsonObjectItem);
                        }
                    }
                } else {
                    br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
                }
            }


            return jsonObjects.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
