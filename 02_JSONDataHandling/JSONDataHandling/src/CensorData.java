import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

class IplData{
	int matchid;
	String team1,team2;
	int score1,score2;
	String winner;
	String pom;
	public IplData(int matchid,String team1,String team2,int s1,int s2,String winner,String pom) {
		this.matchid = matchid;this.team1 = team1;this.team2 = team2;this.score1 = s1;
		this.score2 = s2;this.winner = winner;this.pom=pom;
	}
}
public class CensorData {
	public static List<IplData> readJsonData(String path){
		List<IplData> jsonToList = new ArrayList<>();
		try {
			String content = new String(Files.readAllBytes(Paths.get(path)));
			JSONArray arr = new JSONArray(content);
			for(int i =0;i<arr.length();i++) {
				JSONObject obj = arr.getJSONObject(i);
				int id = obj.getInt("match_id");
				String t1 = obj.getString("team1");
				String t2 = obj.getString("team2");
				JSONObject score = obj.getJSONObject("score");
				int s1 = score.getInt(t1);
				int s2 = score.getInt(t2);
				String winner = obj.getString("winner");
				String pom = obj.getString("player_of_match");
				jsonToList.add(new IplData(id,t1,t2,s1,s2,winner,pom));
				
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return jsonToList;
	}
	public static  List<IplData> readCsvData(String path){
		List<IplData> csvtolist = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			br.readLine();
			while((line = br.readLine())!=null) {
				String[] objAslist = line.split(",");
				csvtolist.add( new IplData(Integer.valueOf(objAslist[0]),objAslist[1],objAslist[2],Integer.valueOf(objAslist[3]),Integer.valueOf(objAslist[4]),objAslist[5],objAslist[6]));
			}
			br.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return csvtolist;
	}
	public static  void writeToJson(List<IplData> list,String path) {
		try {
			JSONArray arr = new JSONArray();
			for(IplData i : list) {
				JSONObject obj = new JSONObject();
				obj.put("match_id", i.matchid);
				obj.put("team1", i.team1);
				obj.put("team2", i.team2);
				JSONObject sc = new JSONObject();
				sc.put(i.team1, i.score1);
				sc.put(i.team2, i.score2);
				obj.put("score", sc);
				obj.put("winner", i.winner);
				obj.put("player_of_match", i.pom);
				arr.put(obj);
			}
			 Files.write(Paths.get(path), arr.toString(2).getBytes());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	public static void writeToCsv(List<IplData> list,String path) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(path));
			bw.write("match_id,team1,team2,score_team1,score_team2,winner,player_of_match\n");
			for(IplData obj : list) {
				bw.write(obj.matchid+","+obj.team1+","+obj.team2+","+obj.score1+","+obj.score2+","+obj.winner+","+obj.pom+"\n");	
			}
			bw.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	public static void censorData(List<IplData> matches) {
	        for (IplData m : matches) {
	            m.team1 = maskTeamName(m.team1);
	            m.team2 = maskTeamName(m.team2);
	            m.winner = maskTeamName(m.winner);
	            m.pom = "REDACTED";
	        }
	    }

	  public static String maskTeamName(String name) {
	        String[] parts = name.split(" ");
	        parts[parts.length-1] = "*".repeat(parts[parts.length-1].length()) ;
	        return String.join(" ", parts);
	    }

	public static void main(String[] args) {
		try {
			List<IplData> jsonToObj = readJsonData("ipl.json");
			List<IplData> csvToObj = readCsvData("ipl.csv");
			censorData(jsonToObj);
			censorData(csvToObj);
			writeToJson(jsonToObj,"censored_ipl.json");
			writeToCsv(csvToObj,"censored_ipl.csv");
			System.out.println("Successfully censored data and converted back ! ");
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
