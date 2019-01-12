package com.safu.safecoin.service.external;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.safu.safecoin.service.external.entity.EtherQueryResponse;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class EtherscamdbService {
    private class ResponseExceptin extends Exception{}
    private final String PREFIX = "https://etherscamdb.info/api/check/";
    private final Logger logger = Logger.getLogger(getClass().getName());

    /**
     * send a http request to etherscamdb and parse the results into json
     * @param addr the suspicious address
     * @return
     */
    public EtherQueryResponse queryAddr(String addr){
        try{
            URL url = new URL(PREFIX.concat(addr).concat("/"));
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("X-requested-with", "XMLHttpRequest");
            con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");

            con.setConnectTimeout(5000);

            con.setReadTimeout(5000);
//            con.setRequestProperty("Cookie", cookie)
            con.connect();

            int status = con.getResponseCode();
            if (status / 100 != 2){
                throw new ResponseExceptin();
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(con
                    .getInputStream()));
            StringBuilder builder = new StringBuilder();
            String line;
            while((line = in.readLine()) != null){
                builder.append(line);
            }

            Gson gson = new Gson();
            EtherQueryResponse response = gson.fromJson(builder.toString(),
                    EtherQueryResponse.class);
            return response;
        }catch(IOException e){
            logger.log(Level.SEVERE,"IOException in query from etherscamdb");
        }catch(ResponseExceptin e){
            logger.log(Level.SEVERE, "Bad request to etherscamdb");
        }finally {
            return new EtherQueryResponse();
        }
    }
}
