import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.Base64;

public class EncryptDecryptCsv {
    private static final String KEY = "MySecretKey12345"; 
    private static final String ALGO = "AES";

    public static String encrypt(String data) {
        try {
            Cipher cipher = Cipher.getInstance(ALGO);
            cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(KEY.getBytes(), ALGO));
            return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes()));
        } catch (Exception e) {
            return data;
        }
    }

    public static String decrypt(String data) {
        try {
            Cipher cipher = Cipher.getInstance(ALGO);
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(KEY.getBytes(), ALGO));
            return new String(cipher.doFinal(Base64.getDecoder().decode(data)));
        } catch (Exception e) {
            return data;
        }
    }

    public static void encryptCSV(String inputFile, String outputFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            String header = br.readLine();
            bw.write(header + "\n"); 

            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", -1);
                parts[3] = encrypt(parts[3]); 
                bw.write(String.join(",", parts) + "\n");
            }
            System.out.println("Encrypted CSV written to: " + outputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void decryptCSV(String inputFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            System.out.println("Id | Name | Department | Salary");

            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", -1);
                parts[3] = decrypt(parts[3]);
                System.out.println(String.join(" | ", parts));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String inputFile = "employee.csv";   
        String encryptedFile = "encrypted_employees.csv";

        encryptCSV(inputFile, encryptedFile);
        System.out.println("\nDecrypted Output:");
        decryptCSV(encryptedFile);
    }
}
