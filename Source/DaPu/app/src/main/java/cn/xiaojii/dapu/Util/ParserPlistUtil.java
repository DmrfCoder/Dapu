package cn.xiaojii.dapu.Util;

import android.content.Context;

public class ParserPlistUtil {

    private Context context;

    public ParserPlistUtil(Context context) {
        this.context=context;
    }

    public void ReadPlist(String filename) {
        PListXMLParser parser = new PListXMLParser();
        PListXMLHandler handler = new PListXMLHandler();
        parser.setHandler(handler);
        try {
            parser.parse(context.getAssets().open("city.plist"));        // city.plist是你要解析的文件，放在assets文件夹中
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        PList actualPList = ((PListXMLHandler) parser.getHandler()).getPlist();
        Array root = (Array) actualPList.getRootElement();
        for (int l = 0; l < root.size(); l++) {
            Dict dict = (Dict) root.get(l);
            Map<String, PListObject> provinceCities = dict.getConfigMap();
            Iterator iter = provinceCities.entrySet().iterator();
            List<List<String>> cityAreaNames = new ArrayList<>();
            List<String> cityNames = new ArrayList<>();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                Dict provinceRoot = (Dict) provinceCities.get(entry.getKey());
                Map<String, PListObject> province = provinceRoot.getConfigMap();
                provinces.add(entry.getKey().toString());    //添加省份到列表
                for (int i = 0; i < province.size(); i++) {
                    Dict cityRoot = (Dict) province.get(String.valueOf(i));
                    Map<String, PListObject> cities = cityRoot.getConfigMap();
                    Iterator iterCity = cities.entrySet().iterator();
                    while (iterCity.hasNext()) {
                        Map.Entry entryCity = (Map.Entry) iterCity.next();
                        Array districts = (Array) cities.get(entryCity.getKey());
                        String cityName = entryCity.getKey().toString();
                        cityNames.add(cityName);    //添加城市到列表
                        List<String> areaNames = new ArrayList<>();
                        for (int k = 0; k < districts.size(); k++) {
                            MyString district = (MyString) districts.get(k);
                            areaNames.add(district.getValue());    //添加区域到列表
                        }
                        cityAreaNames.add(areaNames);
                    }
                }
                citys.add(cityNames);
            }
            areas.add(cityAreaNames);
        }
    }
}
