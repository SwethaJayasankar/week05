
public class LegacyApi {
  @Deprecated 
  void oldFeature() {
	  System.out.println("This is old feature");
  }
  void newFeature() {
	  System.out.println("This is new feature");
  }
  public static void main(String[] args) {
	  LegacyApi la = new LegacyApi();
	  la.oldFeature();
	  la.newFeature();
	  
  }
}
