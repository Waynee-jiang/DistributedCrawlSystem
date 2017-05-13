package badcode;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.ezmorph.bean.MorphDynaBean;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JParser {
    private Map<String, HashMap<String, Integer>> entity = new HashMap<String,HashMap<String,Integer>>();
    private Map<String, HashMap<String, Integer>> oword = new HashMap<String,HashMap<String,Integer>>();
    private ArrayList<String> nugget = new ArrayList<String>();
    public JParser(String JsonContext){
        JSONObject objs = JSONObject.fromObject(JsonContext);//将json对象的字符串转成对象
        JSONArray Entity = JSONArray.fromObject(objs.getString("Entity"));
        JSONArray Nugget = JSONArray.fromObject(objs.getString("Nugget"));
        JSONArray OWord = JSONArray.fromObject(objs.getString("OWord"));
        for(int i=0; i<Nugget.size(); i++){
            nugget.add(Nugget.getString(i));
        }
        JSONObject tmp;
        String key;
        JSONArray value;
        String key1;
        int value1 = 0;
        for (int i=0; i < Entity.size(); i++){
            tmp = Entity.getJSONObject(i);
            key = tmp.getString("Key");//第一层Key对应的字符串
            value = JSONArray.fromObject(tmp.getString("Value"));
            HashMap<String,Integer> tmp1 = new HashMap<String,Integer>();
            for(int j=0; j < value.size(); j++){
                key1 = value.getJSONObject(j).getString("Key");
                value1 = value.getJSONObject(j).getInt("Value");
                //System.out.println(key1+" "+value1);
                tmp1.put(key1, value1);
            }
            entity.put(key, tmp1);
        }
        for (int i=0; i < OWord.size(); i++){
            tmp = OWord.getJSONObject(i);
            key = tmp.getString("Key");//第一层Key对应的字符串
            value = JSONArray.fromObject(tmp.getString("Value"));
            HashMap<String,Integer> tmp1 = new HashMap<String,Integer>();
            for(int j=0; j < value.size(); j++){
                key1 = value.getJSONObject(j).getString("Key");
                value1 = value.getJSONObject(j).getInt("Value");
                //System.out.println(key1+" "+value1);
                tmp1.put(key1, value1);
            }
            oword.put(key, tmp1);
        }
        //test
        /*for(HashMap.Entry<String,HashMap<String,Integer>> i : entity.entrySet()){
        	System.out.println("key:"+i.getKey()+" value:"+i.getValue());
        }*/
        /*for(String s: nugget){
        	System.out.println(s);
        }*/
    }
    //以下函数为测试时使用
    public static String ReadFile(String Path){
        BufferedReader reader = null;
        String laststr = "";
        try{
            FileInputStream fileInputStream = new FileInputStream(Path);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            reader = new BufferedReader(inputStreamReader);
            String tempString = null;
            while((tempString = reader.readLine()) != null){
                laststr += tempString;
            }
            reader.close();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return laststr;
    }
    public static void main(String[] args) throws UnsupportedEncodingException{
        String JSONContext = ReadFile("F:\\本科\\大二\\JAVA\\大作业\\response-export.json");//test
        new JParser(JSONContext);
    }
}
