package com.example.projetcomics.Classes;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

public class ComicsList implements Serializable {
    private ArrayList<Comics> comicsArrayList;

    public ArrayList<Comics> getComicsArrayList() {
        return comicsArrayList;
    }

    public void setComicsArrayList(ArrayList<Comics> comicsArrayList) {
        this.comicsArrayList = comicsArrayList;
    }

    public ComicsList() {
    }

    public void parsage(String text) throws JSONException {
        comicsArrayList = new ArrayList<>();
        if (!text.equals("Aucun comics trouvé")) {
            JSONObject obj = new JSONObject(text);
            JSONObject data = obj.getJSONObject("data");
            JSONArray results = data.getJSONArray("results");
            for (int i = 0; i < results.length(); i++) {
                String title = results.getJSONObject(i).getString("title");
                String description = results.getJSONObject(i).getString("description");
                String diamondCode = results.getJSONObject(i).getString("diamondCode");
                JSONArray urls = results.getJSONObject(i).getJSONArray("urls");
                String url = urls.getJSONObject(0).getString("url");
                JSONArray dates = results.getJSONObject(i).getJSONArray("dates");
                String date = dates.getJSONObject(0).getString("date");
                JSONArray prices = results.getJSONObject(i).getJSONArray("prices");
                String price = prices.getJSONObject(0).getString("price");
                JSONArray images = results.getJSONObject(i).getJSONArray("images");
                String path = images.getJSONObject(0).getString("path");
                String extension = images.getJSONObject(0).getString("extension");
                String image = path +"."+ extension;
                JSONObject creators = results.getJSONObject(i).getJSONObject("creators");
                JSONArray items = creators.getJSONArray("items");
                ArrayList<Creator> creatorsList = new ArrayList<>();
                for (int j = 0; j < items.length(); j++) {
                    String name = items.getJSONObject(j).getString("name");
                    String role = items.getJSONObject(j).getString("role");
                    Creator cre = new Creator(name, role);
                    creatorsList.add(cre);
                }
                if (diamondCode.equals("")){
                    diamondCode = "No Diamond Code";
                }
                Comics com = new Comics(title, description, diamondCode, url, date, price, image, creatorsList);
                comicsArrayList.add(com);
            }
        }

    }
}
