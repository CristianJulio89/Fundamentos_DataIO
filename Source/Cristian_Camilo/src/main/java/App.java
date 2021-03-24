import com.google.gson.Gson;

import java.io.BufferedInputStream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class App {

    static Gson gson = new Gson();
    private File file;
    private static final String jsonFilepath= "src/main/resources/user.json";
    public static void main(String[] args) {

        user userTransformer = new App().JsonTouserT();
        System.out.println(String.format("objeto user\n%s\n", userTransformer));

        String newJsonT = gson.toJson(userTransformer);
        System.out.println(String.format("Tran hacia Json \n%s\n", newJsonT));

    }

    public user JsonTouserT(){
        try {
            file = new File(jsonFilepath);
            BufferedReader buffer = new BufferedReader(new FileReader(file));
            String json ="";
            String line="";

            while ((line= buffer.readLine())!=null){
                json=json + line;
            }
            buffer.close();
            user user = gson.fromJson (json, user.class);

            return  null;

        }catch (Exception e){
            e.printStackTrace();

            return null;
        }
    }
}
